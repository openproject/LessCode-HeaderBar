package com.jayfeng.lesscode.headerbar;

import android.content.Context;
import android.util.AttributeSet;

import com.jayfeng.lesscode.ui.LessImageView;

public class HeaderBarItemImage extends LessImageView {
    public HeaderBarItemImage(Context context) {
        super(context);
        initView();
    }

    public HeaderBarItemImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public HeaderBarItemImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setScaleType(ScaleType.CENTER_INSIDE);
    }
}
