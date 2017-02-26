package com.jayfeng.lesscode.headerbar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

import com.jayfeng.lesscode.core.$;

public class HeaderBarConfig {

    /**
     * ===================================
     * Singleton
     * ===================================
     */
    private volatile static HeaderBarConfig instance;
    public static HeaderBarConfig getInstance() {
        if (instance == null) {
            synchronized ($.class) {
                if (instance == null) {
                    instance = new HeaderBarConfig();
                }
            }
        }
        return instance;
    }

    /**
     * ===================================
     * HeaderBar Config
     * ===================================
     */
    private static Drawable mHeaderBackgroundDrawable;
    private static Drawable mHeaderItemBackgroundDrawable;
    private static Drawable mHeaderShadowDrawable;
    private static int mHeaderBackIcon = 0;

    private static int mTitleTextColor = Color.WHITE;
    private static int mTitleTextSize = 14; // sp

    private static int mItemTextColor = Color.WHITE;
    private static int mItemTextSize = 12;  // sp

    public static Drawable getHeaderBackgroundDrawable() {
        return mHeaderBackgroundDrawable;
    }

    public HeaderBarConfig setHeaderBackgroundDrawable(Drawable headerBackgroundDrawable) {
        HeaderBarConfig.mHeaderBackgroundDrawable = headerBackgroundDrawable;
        return this;
    }

    public static Drawable getHeaderItemBackgroundDrawable() {
        return mHeaderItemBackgroundDrawable;
    }

    public HeaderBarConfig setHeaderItemBackgroundDrawable(Drawable headerItemBackgroundDrawable) {
        HeaderBarConfig.mHeaderItemBackgroundDrawable = headerItemBackgroundDrawable;
        return this;
    }

    public static Drawable getHeaderShadowDrawable() {
        return mHeaderShadowDrawable;
    }

    public HeaderBarConfig setHeaderShadowDrawable(Drawable headerShadowDrawable) {
        HeaderBarConfig.mHeaderShadowDrawable = headerShadowDrawable;
        return this;
    }

    public static int getHeaderBackIcon() {
        return mHeaderBackIcon;
    }

    public HeaderBarConfig setHeaderBackIcon(int headerBackIcon) {
        HeaderBarConfig.mHeaderBackIcon = headerBackIcon;
        return this;
    }

    public static int getTitleTextColor() {
        return mTitleTextColor;
    }

    public HeaderBarConfig setTitleTextColor(int titleTextColor) {
        HeaderBarConfig.mTitleTextColor = titleTextColor;
        return this;
    }

    public static int getTitleTextSize() {
        return mTitleTextSize;
    }

    public HeaderBarConfig setTitleTextSize(int titleTextSize) {
        HeaderBarConfig.mTitleTextSize = titleTextSize;
        return this;
    }

    public static int getItemTextColor() {
        return mItemTextColor;
    }

    public HeaderBarConfig setItemTextColor(int itemTextColor) {
        HeaderBarConfig.mItemTextColor = itemTextColor;
        return this;
    }

    public static int getItemTextSize() {
        return mItemTextSize;
    }

    public HeaderBarConfig setItemTextSize(int itemTextSize) {
        HeaderBarConfig.mItemTextSize = itemTextSize;
        return this;
    }

    public void build() {
        // check config
    }
}