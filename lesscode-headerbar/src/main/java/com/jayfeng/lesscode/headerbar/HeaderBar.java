package com.jayfeng.lesscode.headerbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.jayfeng.lesscode.core.ViewLess;

public class HeaderBar extends LinearLayout {

    private LinearLayout mLeftContainer;
    private LinearLayout mRightContainer;

    public HeaderBar(Context context) {
        super(context);
        init(context);
    }

    public HeaderBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.headerbar, this, true);
        mLeftContainer = ViewLess.$(this, R.id.left_container);
        mRightContainer = ViewLess.$(this, R.id.right_container);
    }

    public void showBack(OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(HeaderBarConfig.getHeaderBackIcon());
        headerBarItemImage.setOnClickListener(clickListener);
        mLeftContainer.addView(headerBarItemImage);
    }

    public void addLeftTextItem() {

    }
    public void addLeftImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(imageResource);
        headerBarItemImage.setOnClickListener(clickListener);
        mLeftContainer.addView(headerBarItemImage);
    }


    public void addRightImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(imageResource);
        headerBarItemImage.setOnClickListener(clickListener);
        mRightContainer.addView(headerBarItemImage);
    }
}
