package com.jayfeng.lesscode.headerbar.app;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.jayfeng.lesscode.core.DisplayLess;
import com.jayfeng.lesscode.core.ToastLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;
import com.jayfeng.lesscode.headerbar.popup.HeaderBarPopupHelper;
import com.jayfeng.lesscode.headerbar.popup.OnPopupItemClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private HeaderBar mHeaderBarWidthShadowNone;
    private HeaderBar mHeaderBarWidthDivider;
    private HeaderBar mHeaderBarWithSubtitle;
    private HeaderBar mHeaderBarWithSearch;
    private HeaderBar mHeaderBarWithTab;
    private HeaderBar mHeaderBarWithBottomTab;
    private HeaderBar mHeaderBarWithDowndown;
    private HeaderBar mHeaderBarWithDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // popmenu
        View popupView = getLayoutInflater().inflate(R.layout.view_popup, null);
        popupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow popupWindow = new PopupWindow(popupView, popupView.getMeasuredWidth(), popupView.getMeasuredHeight(), true);

        // HeaderBar
        initHeaderBar("HeaderBar(阴影)", true);
        mHeaderBar.addLeftTextItem("返回", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHeaderBar.addRightTextPopupItem("分享", popupWindow);

        mHeaderBar.addRightImageItem(R.drawable.app_more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastLess.$("more");
            }
        });

        mHeaderBarWidthShadowNone = ViewLess.$(this, R.id.headerbar_shadow_none);
        mHeaderBarWidthShadowNone.setTitle("无阴影");
        mHeaderBarWidthShadowNone.hideShadow();

        // HeaderBar With Divider
        mHeaderBarWidthDivider = ViewLess.$(this, R.id.headerbar_divider);
        mHeaderBarWidthDivider.setTitle("HeaderBar(分割线)");

        // HeaderBar With Subtitle
        mHeaderBarWithSubtitle = ViewLess.$(this, R.id.headerbar_subtitle);
        mHeaderBarWithSubtitle.setTitle("HeaderBar(子标题)");
        mHeaderBarWithSubtitle.setSubtitle("我是副标题");

        mHeaderBarWithDrawable = ViewLess.$(this, R.id.headerbar_title_drawable);
        mHeaderBarWithDrawable.setTitle("下上箭头");
        mHeaderBarWithDrawable.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up, 0);
        mHeaderBarWithDrawable.getTitleView().setCompoundDrawablePadding(DisplayLess.$dp2px(8));
        mHeaderBarWithDrawable.getTitleView().setBackgroundResource(R.drawable.app_header_title_bg);
        mHeaderBarWithDrawable.getTitleView().setPadding(DisplayLess.$dp2px(16),
                DisplayLess.$dp2px(6), DisplayLess.$dp2px(16), DisplayLess.$dp2px(6));

        // HeaderBar With Search
        mHeaderBarWithSearch = ViewLess.$(this, R.id.headerbar_search);
        mHeaderBarWithSearch.showBack();
        mHeaderBarWithSearch.showSearch();

        // HeaderBar With Tab
        mHeaderBarWithTab = ViewLess.$(this, R.id.headerbar_tab);
        mHeaderBarWithTab.showBack();

        mHeaderBarWithTab.setCustomCenterContainerMargin(0, 0, DisplayLess.$dp2px(42), 0);
        RelativeLayout customCenterContainer = mHeaderBarWithTab.showCustomCenterContainer();
        TabLayout tabLayout = new TabLayout(this);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("列表"));
        tabLayout.addTab(tabLayout.newTab().setText("设置"));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        customCenterContainer.addView(tabLayout, params);

        // HeaderBar With Tab on bottom
        mHeaderBarWithBottomTab = ViewLess.$(this, R.id.headerbar_tab_bottom);
        mHeaderBarWithBottomTab.setTitle("底部标签页");
        mHeaderBarWithBottomTab.showBack();
        RelativeLayout customBottomContainer = mHeaderBarWithBottomTab.showCustomBottomContainer();
        TabLayout bottomTabLayout = new TabLayout(this);
        bottomTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        bottomTabLayout.addTab(bottomTabLayout.newTab().setText("标签一"));
        bottomTabLayout.addTab(bottomTabLayout.newTab().setText("标签二"));
        bottomTabLayout.addTab(bottomTabLayout.newTab().setText("标签三"));
        RelativeLayout.LayoutParams bottomTabParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        customBottomContainer.addView(bottomTabLayout, bottomTabParams);

        // HeaderBar With Divider
        mHeaderBarWithDowndown = ViewLess.$(this, R.id.headerbar_dropdown);
        // simple popup list
        List<String> listData = new ArrayList<>();
        listData.add("AAAA");
        listData.add("BBBBBBBB");
        listData.add("CCCCCCCCCCCCCCC");
        final PopupWindow newPopupWindow = HeaderBarPopupHelper.newPopupWindow(this, listData, new OnPopupItemClick<String>() {
            @Override
            public void onItemClick(int position, String s) {
                ToastLess.$("pos: " + position + ", text: " + s);
            }
        });
        mHeaderBarWithDowndown.addRightTextPopupItem("更多", newPopupWindow);
        mHeaderBarWithDowndown.setTitle("Dropdown", newPopupWindow);

    }
}
