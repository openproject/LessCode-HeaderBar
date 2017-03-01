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

    public static int headerHeight() {
        return mHeaderHeight;
    }

    public HeaderBarConfig headerHeight(int headerHeight) {
        HeaderBarConfig.mHeaderHeight = headerHeight;
        return this;
    }

    public static Drawable headerBackgroundDrawable() {
        return mHeaderBackgroundDrawable;
    }

    public HeaderBarConfig headerBackgroundDrawable(Drawable headerBackgroundDrawable) {
        HeaderBarConfig.mHeaderBackgroundDrawable = headerBackgroundDrawable;
        return this;
    }

    public static int headerShadowHeight() {
        return mHeaderShadowHeight;
    }

    public HeaderBarConfig headerShadowHeight(int headerShadowHeight) {
        HeaderBarConfig.mHeaderShadowHeight = headerShadowHeight;
        return this;
    }

    public static Drawable headerShadowDrawable() {
        return mHeaderShadowDrawable;
    }

    public HeaderBarConfig headerShadowDrawable(Drawable headerShadowDrawable) {
        HeaderBarConfig.mHeaderShadowDrawable = headerShadowDrawable;
        return this;
    }

    public static int headerBackIcon() {
        return mHeaderBackIcon;
    }

    public HeaderBarConfig headerBackIcon(int headerBackIcon) {
        HeaderBarConfig.mHeaderBackIcon = headerBackIcon;
        return this;
    }

    public static int titleTextColor() {
        return mTitleTextColor;
    }

    public HeaderBarConfig titleTextColor(int titleTextColor) {
        HeaderBarConfig.mTitleTextColor = titleTextColor;
        return this;
    }

    public static int titleTextSize() {
        return mTitleTextSize;
    }

    public HeaderBarConfig titleTextSize(int titleTextSize) {
        HeaderBarConfig.mTitleTextSize = titleTextSize;
        return this;
    }

    public static int subtitleTextColor() {
        return mSubtitleTextColor;
    }

    public HeaderBarConfig subtitleTextColor(int subtitleTextColor) {
        HeaderBarConfig.mSubtitleTextColor = subtitleTextColor;
        return this;
    }

    public static int subtitleTextSize() {
        return mSubtitleTextSize;
    }

    public HeaderBarConfig subtitleTextSize(int subtitleTextSize) {
        HeaderBarConfig.mSubtitleTextSize = subtitleTextSize;
        return this;
    }

    public HeaderBarConfig itemTextColor(@ColorInt int itemTextColor) {
        HeaderBarConfig.mItemTextNormalColor = itemTextColor;
        HeaderBarConfig.mItemTextPressedColor = itemTextColor;
        return this;
    }

    public static int itemTextNormalColor() {
        return mItemTextNormalColor;
    }

    public HeaderBarConfig itemTextNormalColor(@ColorInt int itemTextNormalColor) {
        HeaderBarConfig.mItemTextNormalColor = itemTextNormalColor;
        return this;
    }

    public static int itemTextPressedColor() {
        return mItemTextPressedColor;
    }

    public HeaderBarConfig itemTextPressedColor(@ColorInt int itemTextPressedColor) {
        HeaderBarConfig.mItemTextPressedColor = itemTextPressedColor;
        return this;
    }

    public static int itemBackgroudResource() {
        return mItemBackgroudResource;
    }

    public HeaderBarConfig itemBackgroudResource(int itemBackgroudResource) {
        HeaderBarConfig.mItemBackgroudResource = itemBackgroudResource;
        return this;
    }

    public static int itemTextSize() {
        return mItemTextSize;
    }

    public HeaderBarConfig itemTextSize(int itemTextSize) {
        HeaderBarConfig.mItemTextSize = itemTextSize;
        return this;
    }

    public void build() {
        // check config
    }
}