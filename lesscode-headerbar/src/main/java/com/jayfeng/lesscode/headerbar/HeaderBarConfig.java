package com.jayfeng.lesscode.headerbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;

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
    // header
    private static int mHeaderHeight = 56;  // dp
    private static Drawable mHeaderBackgroundDrawable;
    private static int mHeaderShadowHeight = 10;  // dp
    private static Drawable mHeaderShadowDrawable;
    private static int mHeaderBackIcon = 0;

    // title
    private static int mTitleTextColor = Color.WHITE;
    private static int mTitleTextSize = 14; // sp
    private static int mSubtitleTextColor = Color.WHITE;
    private static int mSubtitleTextSize = 12; // sp

    // item
    private static int mItemTextNormalColor = Color.WHITE;
    private static int mItemTextPressedColor = Color.parseColor("#CCCCCC");
    private static int mItemBackgroudResource = 0;
    private static int mItemTextSize = 12;  // sp

    public static int getHeaderHeight() {
        return mHeaderHeight;
    }

    public HeaderBarConfig setHeaderHeight(int headerHeight) {
        HeaderBarConfig.mHeaderHeight = headerHeight;
        return this;
    }

    public static Drawable getHeaderBackgroundDrawable() {
        return mHeaderBackgroundDrawable;
    }

    public HeaderBarConfig setHeaderBackgroundDrawable(Drawable headerBackgroundDrawable) {
        HeaderBarConfig.mHeaderBackgroundDrawable = headerBackgroundDrawable;
        return this;
    }

    public static int getHeaderShadowHeight() {
        return mHeaderShadowHeight;
    }

    public HeaderBarConfig setHeaderShadowHeight(int headerShadowHeight) {
        HeaderBarConfig.mHeaderShadowHeight = headerShadowHeight;
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

    public static int getSubtitleTextColor() {
        return mSubtitleTextColor;
    }

    public HeaderBarConfig setSubtitleTextColor(int subtitleTextColor) {
        HeaderBarConfig.mSubtitleTextColor = subtitleTextColor;
        return this;
    }

    public static int getSubtitleTextSize() {
        return mSubtitleTextSize;
    }

    public HeaderBarConfig setSubtitleTextSize(int subtitleTextSize) {
        HeaderBarConfig.mSubtitleTextSize = subtitleTextSize;
        return this;
    }

    public HeaderBarConfig setItemTextColor(@ColorInt int itemTextColor) {
        HeaderBarConfig.mItemTextNormalColor = itemTextColor;
        HeaderBarConfig.mItemTextPressedColor = itemTextColor;
        return this;
    }

    public static int getItemTextNormalColor() {
        return mItemTextNormalColor;
    }

    public HeaderBarConfig setItemTextNormalColor(@ColorInt int itemTextNormalColor) {
        HeaderBarConfig.mItemTextNormalColor = itemTextNormalColor;
        return this;
    }

    public static int getItemTextPressedColor() {
        return mItemTextPressedColor;
    }

    public HeaderBarConfig setItemTextPressedColor(@ColorInt int itemTextPressedColor) {
        HeaderBarConfig.mItemTextPressedColor = itemTextPressedColor;
        return this;
    }

    public static int getItemBackgroudResource() {
        return mItemBackgroudResource;
    }

    public HeaderBarConfig setItemBackgroudResource(int itemBackgroudResource) {
        HeaderBarConfig.mItemBackgroudResource = itemBackgroudResource;
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