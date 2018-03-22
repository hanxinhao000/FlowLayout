package com.example.xinhao_han.xhflowlayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by XINHAO_HAN on 2018/3/22.
 */

public class UIUtils {

    private static int w = 0;

    @SuppressLint("NewApi")
    public static void init(Activity activity) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        w = displayMetrics.widthPixels;

    }


    public static int getWeiSize() {


        return w;
    }


}
