package com.jayfeng.lesscode.headerbar.app;

import android.app.Application;

import com.jayfeng.lesscode.core.$;
import com.jayfeng.lesscode.headerbar.HeaderBarConfig;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        $.getInstance()
                .context(getApplicationContext())
                .build();

        HeaderBarConfig.getInstance()
                .setHeaderBackIcon(R.drawable.app_back)
                .build();
    }
}
