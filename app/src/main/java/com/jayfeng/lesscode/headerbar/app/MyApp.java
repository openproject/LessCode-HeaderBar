package com.jayfeng.lesscode.headerbar.app;

import android.app.Application;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;

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
                .titlePadding(10, 0, 10, 0)
                // item
                .itemTextNormalColor(getResources().getColor(R.color.header_menu_text_normal_color))
                .itemTextPressedColor(getResources().getColor(R.color.header_menu_text_pressed_color))
                .itemTextSize(10)
                .itemTextPadding(DisplayLess.$dp2px(8), 0, DisplayLess.$dp2px(8), 0)
                .itemImagePadding(DisplayLess.$dp2px(8), 0, DisplayLess.$dp2px(8), 0)
                .itemBackgroudResource(R.drawable.app_item_bg_transparent)
                .itemMinWidth(DisplayLess.$dp2px(48))
                // tab
                .tabBottomBackgroundDrawable(new ColorDrawable(Color.parseColor("#1abc9c")))
                // popup
                .popupBackgroundDrawable(new ColorDrawable(Color.parseColor("#1abc9c")))
                .popupItemTextColor(Color.GREEN)
                .popupItemTextGravity(Gravity.RIGHT)
                .popupItemTextPadding(DisplayLess.$dp2px(8), DisplayLess.$dp2px(8), DisplayLess.$dp2px(8), DisplayLess.$dp2px(8))
                .build();
    }
}
