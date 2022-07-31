package com.manuni.broadcastrecimplicitconverttoexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view) {
        Intent intent = new Intent("com.manuni.broadcastreceiver.ACTION_SEND");
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryBroadcastReceivers(intent,0);
        for (ResolveInfo info: resolveInfos){

            ComponentName componentName = new ComponentName(info.activityInfo.packageName,info.activityInfo.name);
            intent.setComponent(componentName);

            sendBroadcast(intent);
        }
    }
}