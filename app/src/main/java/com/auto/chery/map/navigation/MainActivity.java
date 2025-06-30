package com.auto.chery.map.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private boolean isFinishing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 检查是否正在销毁
        if (isFinishing || isDestroyed()) {
            return;
        }

        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.auto.chery.map",
                    "com.navigation.auto.splash.activity.NaviSplashActivity"));
            startActivity(intent);
        } finally {
            isFinishing = true;
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 异常捕获作为最后防线
        if (!isFinishing && !isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                if (e.getMessage().contains("did not call finish()")) {
                    finish();
                }
                Log.i("isa MainActivity", "onResume error!!!");
                e.printStackTrace();
            }
        }
    }
}