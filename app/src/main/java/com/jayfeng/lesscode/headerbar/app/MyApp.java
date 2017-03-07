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
                .headerHeight(DisplayLess.$dp2px(56))
                .headerBackgroundDrawable(new ColorDrawable(Color.parseColor("#1abc9c")))
                .headerBackIcon(R.drawable.app_back)
                .headerShadowDrawable(getResources().getDrawable(R.drawable.app_shadow))
                .headerShadowHeight(DisplayLess.$dp2px(16))
                // title
                .titleTextColor(Color.BLUE)
                .titleTextSize(24)
                .subtitleTextColor(Color.RED)
                // item
                .itemTextNormalColor(getResources().getColor(R.color.header_menu_text_normal_color))
                .itemTextPressedColor(getResources().getColor(R.color.header_menu_text_pressed_color))
                .itemTextSize(10)
                .itemTextPadding(DisplayLess.$dp2px(16), 0, DisplayLess.$dp2px(16), 0)
                .itemBackgroudResource(R.drawable.app_item_bg_transparent)
                .build();
    }
}
