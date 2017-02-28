package com.jayfeng.lesscode.headerbar.app;

import android.app.Application;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.jayfeng.lesscode.core.$;
import com.jayfeng.lesscode.core.DisplayLess;
import com.jayfeng.lesscode.headerbar.HeaderBarConfig;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        $.getInstance()
                .context(getApplicationContext())
                .build();

        HeaderBarConfig.getInstance()
                // header
                .setHeaderHeight(DisplayLess.$dp2px(56))
                .setHeaderBackgroundDrawable(new ColorDrawable(Color.RED))
                .setHeaderBackIcon(R.drawable.app_back)
                .setHeaderShadowDrawable(getResources().getDrawable(R.drawable.app_shadow))
                .setHeaderShadowHeight(200)
                // title
                .setTitleTextColor(Color.BLUE)
                .setTitleTextSize(24)
                // item
                .setItemTextNormalColor(getResources().getColor(R.color.header_menu_text_normal_color))
                .setItemTextPressedColor(getResources().getColor(R.color.header_menu_text_pressed_color))
                .setItemTextSize(10)
                .setItemBackgroudResource(R.drawable.app_item_bg_transparent)
                .build();
    }
}
