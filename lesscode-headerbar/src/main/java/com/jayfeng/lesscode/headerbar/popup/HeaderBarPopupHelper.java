package com.jayfeng.lesscode.headerbar.popup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jayfeng.lesscode.core.AdapterLess;
import com.jayfeng.lesscode.core.ViewLess;
import com.jayfeng.lesscode.headerbar.HeaderBar;
import com.jayfeng.lesscode.headerbar.HeaderBarConfig;
import com.jayfeng.lesscode.headerbar.R;

import java.util.List;

public class HeaderBarPopupHelper {

    private static PopupWindow sPopupWindow;

    public static @NonNull <T> PopupWindow newPopupWindow(Context context, List<T> listData, int layout, AdapterLess.RecyclerCallBack<T> recyclerCallBack) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.headerbar_popup_recyclerview, null);
        if (HeaderBarConfig.popupBackgroundDrawable() != null) {
            rootView.setBackgroundDrawable(HeaderBarConfig.popupBackgroundDrawable());
        }
        RecyclerView recyclerView = ViewLess.$(rootView, R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter<AdapterLess.RecyclerViewHolder> adapter = AdapterLess.$recycler(context, listData, layout, recyclerCallBack);
        recyclerView.setAdapter(adapter);

        rootView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        sPopupWindow = new PopupWindow(rootView, rootView.getMeasuredWidth(), rootView.getMeasuredHeight(), true);

        return sPopupWindow;
    }

    public static @NonNull PopupWindow newPopupWindow(Context context, List<String> listData, final OnPopupItemClick<String> popupItemClick) {

        sPopupWindow = newPopupWindow(context, listData, R.layout.headerbar_popup_recyclerview_item, new AdapterLess.RecyclerCallBack<String>() {
            @Override
            public void onBindViewHolder(final int position, AdapterLess.RecyclerViewHolder recyclerViewHolder, final String text) {
                TextView textView = recyclerViewHolder.$view(R.id.text);
                textView.setText(text);
                textView.setTextSize(HeaderBarConfig.popupItemTextSize());
                textView.setTextColor(HeaderBarConfig.popupItemTextColor());
                textView.setPadding(HeaderBarConfig.popupItemTextPaddingLeft(),
                        HeaderBarConfig.popupItemTextPaddingTop(),
                        HeaderBarConfig.popupItemTextPaddingRight(),
                        HeaderBarConfig.popupItemTextPaddingBottom());
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) textView.getLayoutParams();
                params.gravity = HeaderBarConfig.popupItemTextGravity();

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupItemClick.onItemClick(position, text);
                        sPopupWindow.dismiss();
                    }
                });
            }
        });

        return sPopupWindow;
    }
}
