package com.kp.kpcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.kp.kpcontroller.network.KPSocket;
import com.kp.kpcontroller.player.KPPlayerActivity;

public class MainActivity extends Activity {

    private KPSocket socket;
    private boolean autoConnect;
    private static MainActivity act;


    public static MainActivity getInstance() {
        return act;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoConnect = false;
        act = this;
        socket = new KPSocket();
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
        if (autoConnect && !socket.getConnected()) {
            socket.Connect();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (socket.getConnected()) {
            socket.Disconnect();
        }
    }

    public void connect() {
        this.autoConnect = true;
        socket.Connect();
    }

    public void startPlayer() {
        Intent intent = new Intent(this, KPPlayerActivity.class);
        startActivity(intent);
    }

}
