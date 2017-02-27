package com.jayfeng.lesscode.headerbar;

import android.content.res.ColorStateList;

public class HeaderBarHelper {

    public static ColorStateList createColorStateList(int normal, int pressed) {
        int[] colors = new int[]{pressed, normal};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
}
