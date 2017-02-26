package com.jayfeng.lesscode.headerbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jayfeng.lesscode.core.ViewLess;

public class HeaderBar extends LinearLayout {

    private int mTitleTextColor;
    private int mItemTextColor;
    private Drawable mHeaderBackground;
    private Drawable mHeaderItemBackground;

    private TextView mTitleView;
    private RelativeLayout mHeaderContainer;
    private LinearLayout mLeftContainer;
    private LinearLayout mRightContainer;

    public HeaderBar(Context context) {
        super(context);
        init(null, 0);
    }

    public HeaderBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater.from(getContext()).inflate(R.layout.headerbar, this, true);

        final TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.HeaderBar, defStyle, 0);

        mTitleTextColor = a.getColor(R.styleable.HeaderBar_headerbar_title_text_color, HeaderBarConfig.getTitleTextColor());
        mItemTextColor = a.getColor(R.styleable.HeaderBar_headerbar_item_text_color, HeaderBarConfig.getItemTextColor());

        if (a.hasValue(R.styleable.HeaderBar_headerbar_background)) {
            mHeaderBackground = a.getDrawable(R.styleable.HeaderBar_headerbar_background);
            mHeaderBackground.setCallback(this);
        } else {
            mHeaderBackground = HeaderBarConfig.getHeaderBackgroundDrawable();
        }
        if (a.hasValue(R.styleable.HeaderBar_headerbar_item_background)) {
            mHeaderItemBackground = a.getDrawable(R.styleable.HeaderBar_headerbar_item_background);
            mHeaderItemBackground.setCallback(this);
        } else {
            mHeaderItemBackground = HeaderBarConfig.getHeaderItemBackgroundDrawable();
        }

        a.recycle();

        mTitleView = ViewLess.$(this, R.id.title);
        mHeaderContainer = ViewLess.$(this, R.id.header_container);
        mLeftContainer = ViewLess.$(this, R.id.left_container);
        mRightContainer = ViewLess.$(this, R.id.right_container);

        mTitleView.setTextColor(mTitleTextColor);
        mHeaderContainer.setBackgroundDrawable(mHeaderBackground);
    }

    public void showBack(OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(HeaderBarConfig.getHeaderBackIcon());
        headerBarItemImage.setOnClickListener(clickListener);
        mLeftContainer.addView(headerBarItemImage);
    }

    public void addLeftTextItem(String text, OnClickListener clickListener) {
        HeaderBarItemText headerBarItemText = (HeaderBarItemText) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_text, mLeftContainer, false);
        headerBarItemText.setText(text);
        headerBarItemText.setTextColor(mItemTextColor);
        headerBarItemText.setOnClickListener(clickListener);
        mLeftContainer.addView(headerBarItemText);

    }
    public void addLeftImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(imageResource);
        headerBarItemImage.setOnClickListener(clickListener);
        mLeftContainer.addView(headerBarItemImage);
    }

    public void addRightTextItem(String text, OnClickListener clickListener) {
        HeaderBarItemText headerBarItemText = (HeaderBarItemText) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_text, mRightContainer, false);
        headerBarItemText.setText(text);
        headerBarItemText.setTextColor(mItemTextColor);
        headerBarItemText.setOnClickListener(clickListener);
        mRightContainer.addView(headerBarItemText);

    }
    public void addRightImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, mLeftContainer, false);
        headerBarItemImage.setImageResource(imageResource);
        headerBarItemImage.setOnClickListener(clickListener);
        mRightContainer.addView(headerBarItemImage);
    }
}
