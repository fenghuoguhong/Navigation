package com.auto.chery.map.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.auto.chery.map", "com.navigation.auto.splash.activity.NaviSplashActivity"));
        startActivity(intent);
    }
}