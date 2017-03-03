package com.jayfeng.lesscode.headerbar.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.jayfeng.lesscode.core.ToastLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;

public class MainActivity extends BaseActivity {

    private HeaderBar mHeaderBarWidthShadowNone;
    private HeaderBar mHeaderBarWidthDivider;
    private HeaderBar mHeaderBarWithSubtitle;
    private HeaderBar mHeaderBarWithSearch;
    private HeaderBar mHeaderBarWithTab;
    private HeaderBar mHeaderBarWithDowndown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // HeaderBar
        initHeaderBar("HeaderBar(阴影)", true);
        mHeaderBar.addLeftTextItem("返回", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHeaderBar.addRightTextItem("分享", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastLess.$("share");
            }
        });
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

        // HeaderBar With Search
        mHeaderBarWithSearch = ViewLess.$(this, R.id.headerbar_search);
        mHeaderBarWithSearch.showBack();
        mHeaderBarWithSearch.showSearch();

        // HeaderBar With Divider
        mHeaderBarWithTab = ViewLess.$(this, R.id.headerbar_tab);
        mHeaderBarWithTab.showBack();

        RelativeLayout customCenterContainer = mHeaderBarWithTab.showCustomCenterContainer();
        TabLayout tabLayout = new TabLayout(this);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("列表"));
        tabLayout.addTab(tabLayout.newTab().setText("设置"));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        customCenterContainer.addView(tabLayout, params);

        // HeaderBar With Divider
        mHeaderBarWithDowndown = ViewLess.$(this, R.id.headerbar_dropdown);
        mHeaderBarWithDowndown.setTitle("HeaderBar(下拉列表)");

    }
}
