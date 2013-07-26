package com.kp.kpcontroller.network;

import com.kp.kpcontroller.MainActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Usuario on 25/07/13.
 */
public class KPSocket {

    private String SERVER_ADDRESS = "qiinformatica.no-ip.info";
    private int SERVER_PORT = 41979;
    private Socket sock;
    private BufferedReader r;
    private BufferedWriter out;
    private Thread thrd;
    private boolean Connected = false;


    public boolean getConnected() {
        return Connected;
    }

    public KPSocket() {

    }

    public boolean Connect() {
        try{
            InetSocketAddress address = new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT);
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
                            if (data != null) {
                                Parse(data);
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
            thrd.start();
            Connected = true;
            return true;
        }
        catch (IOException ioe) {
            return false;
        }
    }

    public void Disconnect() {
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
        Connected = false;
    }

    public boolean Send(String text) {
        try {
            out.write(text + "\n");
            out.flush();
            return true;
        }
        catch (IOException e) {
            return false;
        }
    }

    private boolean Parse(String data) {


        return true;
    }
}
