package com.example.broadcast2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String data = intent.getStringExtra("data");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String name = preferences.getString("key", "");
        if(name!="")
        {
            final Intent i = new Intent();
            i.putExtra("data", "advik");
            i.setAction("com.pkg.perform.Sapphire");
            i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            context.sendBroadcast(i);
            Toast.makeText(context, "2a", Toast.LENGTH_SHORT).show();

            Log.i("BR", "reply sent");
        }    }
}