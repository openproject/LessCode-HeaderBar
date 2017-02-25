package com.jayfeng.lesscode.headerbar.app;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;

public class BaseActivity extends AppCompatActivity {

    protected HeaderBar mHeaderBar;

    protected void initHeaderBar(boolean showBack) {
        mHeaderBar = ViewLess.$(this, R.id.headerbar);
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
