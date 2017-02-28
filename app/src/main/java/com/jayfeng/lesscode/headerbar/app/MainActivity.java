package com.jayfeng.lesscode.headerbar.app;

import android.os.Bundle;
import android.view.View;

import com.jayfeng.lesscode.core.ToastLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;

public class MainActivity extends BaseActivity {


    private HeaderBar mSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // HeaderBar
        initHeaderBar("HeaderBar示例", true);
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

        // HeaderBar For Search
        mSearchBar = ViewLess.$(this, R.id.searchbar);
        mSearchBar.showBack();
        mSearchBar.showSearch();

    }
}
