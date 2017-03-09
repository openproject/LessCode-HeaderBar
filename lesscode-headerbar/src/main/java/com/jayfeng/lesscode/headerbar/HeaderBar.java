package com.jayfeng.lesscode.headerbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jayfeng.lesscode.core.ViewLess;

public class HeaderBar extends LinearLayout {

    // title style
    private int mTitleTextColor;
    private int mTitleTextSize;
    private int mSubtitleTextColor;
    private int mSubtitleTextSize;

    // item style
    private int mItemTextNormalColor;
    private int mItemTextPressedColor;
    private int mItemTextSize;

    // header
    private int mHeaderHeight;
    private Drawable mHeaderBackground;
    private Drawable mHeaderShadow;
    private int mHeaderShadowHeight;

    // tab
    private Drawable mTabBottomBackground;

    private TextView mTitleView;
    private TextView mSubtitleView;
    private EditText mSearchEditView;
    private RelativeLayout mHeaderContainer;
    private LinearLayout mLeftContainer;
    private LinearLayout mRightContainer;
    private RelativeLayout mCenterContainer;
    private RelativeLayout mBottomContainer;
    private ImageView mShadowView;

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

        mTitleTextColor = a.getColor(R.styleable.HeaderBar_hb_title_text_color, HeaderBarConfig.titleTextColor());
        mTitleTextSize = a.getDimensionPixelSize(R.styleable.HeaderBar_hb_title_text_size, HeaderBarConfig.titleTextSize());
        mSubtitleTextColor = a.getColor(R.styleable.HeaderBar_hb_subtitle_text_color, HeaderBarConfig.subtitleTextColor());
        mSubtitleTextSize = a.getDimensionPixelSize(R.styleable.HeaderBar_hb_subtitle_text_size, HeaderBarConfig.subtitleTextSize());

        mItemTextNormalColor = a.getColor(R.styleable.HeaderBar_hb_item_text_normal_color, HeaderBarConfig.itemTextNormalColor());
        mItemTextPressedColor = a.getColor(R.styleable.HeaderBar_hb_item_text_pressed_color, HeaderBarConfig.itemTextPressedColor());
        mItemTextSize = a.getDimensionPixelSize(R.styleable.HeaderBar_hb_item_text_size, HeaderBarConfig.itemTextSize());

        // tab
        if (a.hasValue(R.styleable.HeaderBar_hb_tab_bottom_background)) {
            mTabBottomBackground = a.getDrawable(R.styleable.HeaderBar_hb_tab_bottom_background);
            mTabBottomBackground.setCallback(this);
        } else {
            mTabBottomBackground = HeaderBarConfig.tabBottomBackgroundDrawable();
        }

        // header
        mHeaderHeight = a.getDimensionPixelSize(R.styleable.HeaderBar_hb_height, HeaderBarConfig.headerHeight());
        if (a.hasValue(R.styleable.HeaderBar_hb_background)) {
            mHeaderBackground = a.getDrawable(R.styleable.HeaderBar_hb_background);
            mHeaderBackground.setCallback(this);
        } else {
            mHeaderBackground = HeaderBarConfig.headerBackgroundDrawable();
        }

        mHeaderShadowHeight = a.getDimensionPixelSize(R.styleable.HeaderBar_hb_shadow_height, HeaderBarConfig.headerShadowHeight());
        if (a.hasValue(R.styleable.HeaderBar_hb_shadow)) {
            mHeaderShadow = a.getDrawable(R.styleable.HeaderBar_hb_shadow);
        } else {
            mHeaderShadow = HeaderBarConfig.headerShadowDrawable();
        }

        a.recycle();

        mTitleView = ViewLess.$(this, R.id.title);
        mSubtitleView = ViewLess.$(this, R.id.subtitle);
        mSearchEditView = ViewLess.$(this, R.id.search_edit);
        mHeaderContainer = ViewLess.$(this, R.id.header_container);
        mLeftContainer = ViewLess.$(this, R.id.left_container);
        mRightContainer = ViewLess.$(this, R.id.right_container);
        mCenterContainer = ViewLess.$(this, R.id.center_container);
        mBottomContainer = ViewLess.$(this, R.id.bottom_container);
        mShadowView = ViewLess.$(this, R.id.shadow);

        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        if (HeaderBarConfig.titleTypeface() != null) {
            mTitleView.setTypeface(HeaderBarConfig.titleTypeface());
        }
        mSubtitleView.setTextColor(mSubtitleTextColor);
        mSubtitleView.setTextSize(mSubtitleTextSize);
        if (HeaderBarConfig.subtitleTypeface() != null) {
            mSubtitleView.setTypeface(HeaderBarConfig.subtitleTypeface());
        }
        mShadowView.getLayoutParams().height = mHeaderShadowHeight;
        if (mHeaderShadow != null) {
            mShadowView.setImageDrawable(mHeaderShadow);
        } else {
            mShadowView.setVisibility(View.GONE);
        }
        mHeaderContainer.setBackgroundDrawable(mHeaderBackground);
        mHeaderContainer.getLayoutParams().height = mHeaderHeight;

        if (mTabBottomBackground != null) {
            mBottomContainer.setBackgroundDrawable(mTabBottomBackground);
        }
    }

    public TextView getTitleView() {
        return mTitleView;
    }

    public TextView getSubtitleView() {
        return mSubtitleView;
    }

    public EditText getSearchEditView() {
        return mSearchEditView;
    }

    public void setTitle(String title) {
        mTitleView.setText(title);
    }

    public void setTitle(String title, final PopupWindow popupWindow) {
        mTitleView.setText(title);
        mTitleView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int xoff = (v.getWidth() - popupWindow.getWidth()) / 2;
                popupWindow.showAsDropDown(v, xoff, 0);
            }
        });
    }

    public void setTitle(String title, final PopupWindow popupWindow, final int xoffset, final int yoffset) {
        mTitleView.setText(title);
        mTitleView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int xoff = (v.getWidth() - popupWindow.getWidth()) / 2 + xoffset;
                popupWindow.showAsDropDown(v, xoff, yoffset);
            }
        });
    }

    public void setTitle(int titleResource) {
        mTitleView.setText(titleResource);
    }

    public void setSubtitle(String subtitle) {
        mSubtitleView.setText(subtitle);
        mSubtitleView.setVisibility(View.VISIBLE);
    }

    public void setSubtitle(int subtitleResource) {
        mSubtitleView.setText(subtitleResource);
        mSubtitleView.setVisibility(View.VISIBLE);
    }

    public void showBack() {
        showBack(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).onBackPressed();
            }
        });
    }

    public void showBack(OnClickListener clickListener) {
        if (HeaderBarConfig.headerBackIcon() != 0) {
            showBack(HeaderBarConfig.headerBackIcon(), clickListener);
        }
    }

    public HeaderBarItemImage showBack(int backResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = createHeaderBarItemImage(backResource, clickListener, mLeftContainer);
        mLeftContainer.addView(headerBarItemImage);

        return headerBarItemImage;
    }

    /**
     * ======================
     * Left
     * ======================
     */
    public @NonNull HeaderBarItemText addLeftTextItem(String text, OnClickListener clickListener) {
        HeaderBarItemText headerBarItemText = createHeaderBarItemText(text, clickListener, mLeftContainer);
        mLeftContainer.addView(headerBarItemText);

        return headerBarItemText;

    }

    public @NonNull HeaderBarItemText addLeftTextPopupItem(String text, final PopupWindow popupWindow) {
        HeaderBarItemText headerBarItemText = addLeftTextItem(text, createPopupWindowListener(popupWindow));

        return headerBarItemText;
    }

    public @NonNull HeaderBarItemText addLeftTextPopupItem(String text, final PopupWindow popupWindow, int xoffset, int yoffset) {
        HeaderBarItemText headerBarItemText = addLeftTextItem(text, createPopupWindowListener(popupWindow, xoffset, yoffset));

        return headerBarItemText;
    }

    public @NonNull HeaderBarItemImage addLeftImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = createHeaderBarItemImage(imageResource, clickListener, mLeftContainer);
        mLeftContainer.addView(headerBarItemImage);

        return headerBarItemImage;
    }

    public @NonNull HeaderBarItemImage addLeftImagePopupItem(int imageResource, final PopupWindow popupWindow) {
        HeaderBarItemImage headerBarItemImage = addLeftImageItem(imageResource, createPopupWindowListener(popupWindow));
        return headerBarItemImage;
    }

    public @NonNull HeaderBarItemImage addLeftImagePopupItem(int imageResource, final PopupWindow popupWindow, int xoffset, int yoffset) {
        HeaderBarItemImage headerBarItemImage = addLeftImageItem(imageResource, createPopupWindowListener(popupWindow, xoffset, yoffset));
        return headerBarItemImage;
    }

    /**
     * ======================
     * Right
     * ======================
     */
    public @NonNull HeaderBarItemText addRightTextItem(String text, OnClickListener clickListener) {
        HeaderBarItemText headerBarItemText = createHeaderBarItemText(text, clickListener, mRightContainer);
        mRightContainer.addView(headerBarItemText);

        return headerBarItemText;
    }

    public @NonNull HeaderBarItemText addRightTextPopupItem(String text, final PopupWindow popupWindow) {
        HeaderBarItemText headerBarItemText = addRightTextItem(text, createPopupWindowListener(popupWindow));

        return headerBarItemText;
    }

    public @NonNull HeaderBarItemText addRightTextPopupItem(String text, final PopupWindow popupWindow, int xoffset, int yoffset) {
        HeaderBarItemText headerBarItemText = addRightTextItem(text, createPopupWindowListener(popupWindow, xoffset, yoffset));

        return headerBarItemText;
    }

    public @NonNull HeaderBarItemImage addRightImageItem(int imageResource, OnClickListener clickListener) {
        HeaderBarItemImage headerBarItemImage = createHeaderBarItemImage(imageResource, clickListener, mRightContainer);
        mRightContainer.addView(headerBarItemImage);

        return headerBarItemImage;
    }

    public @NonNull HeaderBarItemImage addRightImagePopupItem(int imageResource, final PopupWindow popupWindow) {
        HeaderBarItemImage headerBarItemImage = addRightImageItem(imageResource, createPopupWindowListener(popupWindow));
        return headerBarItemImage;
    }

    public @NonNull HeaderBarItemImage addRightImagePopupItem(int imageResource, final PopupWindow popupWindow, int xoffset, int yoffset) {
        HeaderBarItemImage headerBarItemImage = addRightImageItem(imageResource, createPopupWindowListener(popupWindow, xoffset, yoffset));
        return headerBarItemImage;
    }

    public void hideShadow() {
        mShadowView.setVisibility(View.GONE);
    }

    public void showSearch() {
        mSearchEditView.setVisibility(View.VISIBLE);
    }

    public RelativeLayout getCenterContainer() {
        return mCenterContainer;
    }

    public RelativeLayout showCustomCenterContainer () {
        mCenterContainer.setVisibility(View.VISIBLE);
        return mCenterContainer;
    }

    public RelativeLayout getBottomContainer() {
        return mBottomContainer;
    }

    public RelativeLayout showCustomBottomContainer() {
        mBottomContainer.setVisibility(View.VISIBLE);
        return mBottomContainer;
    }

    // private impl
    private @NonNull HeaderBarItemImage createHeaderBarItemImage(int imageResource, OnClickListener clickListener, ViewGroup rootView) {
        HeaderBarItemImage headerBarItemImage = (HeaderBarItemImage) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_image, rootView, false);
        headerBarItemImage.setImageResource(imageResource);
        headerBarItemImage.setOnClickListener(clickListener);
        headerBarItemImage.setPadding(HeaderBarConfig.itemImagePaddingLeft(),
                HeaderBarConfig.itemImagePaddingTop(),
                HeaderBarConfig.itemImagePaddingRight(),
                HeaderBarConfig.itemImagePaddingBottom());
        headerBarItemImage.setBackgroundResource(HeaderBarConfig.itemBackgroudResource());
        return headerBarItemImage;
    }
    // private impl
    private @NonNull HeaderBarItemText createHeaderBarItemText(String text, OnClickListener clickListener, ViewGroup rootView) {
        HeaderBarItemText headerBarItemText = (HeaderBarItemText) LayoutInflater.from(getContext()).inflate(R.layout.headerbar_item_text, mRightContainer, false);
        headerBarItemText.setText(text);
        headerBarItemText.setTextColor(HeaderBarHelper.createColorStateList(mItemTextNormalColor, mItemTextPressedColor));
        headerBarItemText.setTextSize(mItemTextSize);
        headerBarItemText.setBackgroundResource(HeaderBarConfig.itemBackgroudResource());
        headerBarItemText.setOnClickListener(clickListener);
        headerBarItemText.setPadding(HeaderBarConfig.itemTextPaddingLeft(),
                HeaderBarConfig.itemTextPaddingTop(),
                HeaderBarConfig.itemTextPaddingRight(),
                HeaderBarConfig.itemTextPaddingBottom());
        return headerBarItemText;
    }

    private OnClickListener createPopupWindowListener(final PopupWindow popupWindow) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(v);
            }
        };
    }

    private OnClickListener createPopupWindowListener(final PopupWindow popupWindow, final int xoffset, final int yoffset) {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(v, xoffset, yoffset);
            }
        };
    }
}
