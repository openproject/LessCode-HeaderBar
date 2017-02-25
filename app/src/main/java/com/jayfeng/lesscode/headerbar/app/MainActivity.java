package com.jayfeng.lesscode.headerbar.app;

import android.os.Bundle;
import android.view.View;

import com.jayfeng.lesscode.core.ToastLess;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHeaderBar(true);
        mHeaderBar.addLeftImageItem(R.drawable.app_back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastLess.$("aaaa");
            }
        });
        mHeaderBar.addRightImageItem(R.drawable.app_more, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastLess.$("more");
            }
        });

    }
}
