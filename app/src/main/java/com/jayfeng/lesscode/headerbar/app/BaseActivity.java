package com.jayfeng.lesscode.headerbar.app;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;

public class BaseActivity extends AppCompatActivity {

    protected HeaderBar mHeaderBar;

    protected void initHeaderBar(String title, boolean showBack) {
        mHeaderBar = ViewLess.$(this, R.id.headerbar);
        mHeaderBar.setTitle(title);
        if (showBack) {
            mHeaderBar.showBack(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }
}
