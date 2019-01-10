package org.ieselcaminas.pmdm.broadcastreceiver3_custom_2018;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonReceive = (Button) findViewById(R.id.buttonEnable);
        buttonReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                broadcastReceiver = new MyReceiver();
                IntentFilter filter = new IntentFilter("net.victoralonso.CUSTOM_INTENT");
                registerReceiver(broadcastReceiver, filter);
                Toast.makeText(getApplicationContext(), "Broadcast Receiver enabled.", Toast.LENGTH_LONG).show();
            }
        });

        Button buttonDisable = (Button) findViewById(R.id.buttonDisable);
        buttonDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (broadcastReceiver != null) {
                    unregisterReceiver(broadcastReceiver);
                    broadcastReceiver = null;
                    Toast.makeText(getApplicationContext(), "Broadcast Receiver disabled.", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button buttonBroadcast = (Button) findViewById(R.id.buttonBroadcast);
        buttonBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // broadcast a custom intent.
                Intent intent = new Intent();
                intent.setAction("net.victoralonso.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
    }
}
