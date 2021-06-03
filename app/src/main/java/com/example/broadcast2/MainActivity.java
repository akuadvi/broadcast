package com.example.broadcast2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyReceiver MyReceiver2;
    private MyBroadcastReceiver MyReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("key", "");
        if(name=="") {
            final Intent i = new Intent("com.pkg.perform.Ruby");
            PackageManager pack=getPackageManager();
            List<ResolveInfo> resolveinfo=pack.queryBroadcastReceivers(i,0);
            for(ResolveInfo r:resolveinfo){
                Log.i("ak",r.activityInfo.packageName);
                ComponentName comp=new ComponentName(r.activityInfo.packageName,r.activityInfo.name);
                i.putExtra("request","akul");
                i.setComponent(comp);
                sendBroadcast(i);
            }
        }
            Toast.makeText(this, "1b", Toast.LENGTH_SHORT).show();
        }

}