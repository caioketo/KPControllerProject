package com.kp.kpcontroller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class MainActivity extends Activity {

    private Socket sock;
    private BufferedReader r;
    private BufferedWriter out;
    private Thread thrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        try{
            InetSocketAddress address = new InetSocketAddress("qiinformatica.no-ip.info", 41979);
            sock = new Socket();
            sock.connect(address);
            r = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(sock
                    .getOutputStream()));

            thrd = new Thread(new Runnable() {
                public void run() {
                    while (!Thread.interrupted()) {
                        try {
                            final String data = r.readLine();
                            if (data != null)
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // do something in ui thread with the data var
                                    }
                                });

                        } catch (IOException e) { }
                    }
                }
            });
            thrd.start();
        }
        catch (IOException ioe) { }
    }

    private void sendText() {
        String text = "listall";
        try {
            out.write(text + "\n");
            out.flush();
        } catch (IOException e) {}
    }

    @Override
    public void onPause() {
        super.onPause();
        if (thrd != null)
            thrd.interrupt();
        try {
            if (sock != null) {
                sock.getOutputStream().close();
                sock.getInputStream().close();
                sock.close();
            }
        } catch (IOException e) {}
        thrd = null;
    }
}
