package com.gyf.barlibrary;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;

public class BarParams implements Cloneable {
    float autoNavigationBarDarkModeAlpha = 0.0f;
    boolean autoNavigationBarDarkModeEnable = false;
    float autoStatusBarDarkModeAlpha = 0.0f;
    boolean autoStatusBarDarkModeEnable = false;
    BarHide barHide = BarHide.FLAG_SHOW_BAR;
    float contentAlpha = 0.0f;
    int contentColor = 0;
    int contentColorTransform = ViewCompat.MEASURED_STATE_MASK;
    int defaultNavigationBarColor = ViewCompat.MEASURED_STATE_MASK;
    public boolean fits = false;
    @Deprecated
    boolean fixMarginAtBottom = false;
    int flymeOSStatusBarFontColor;
    public boolean fullScreen = false;
    boolean hideNavigationBar = false;
    boolean isSupportActionBar = false;
    public boolean keyboardEnable = false;
    int keyboardMode = 18;
    float navigationBarAlpha = 0.0f;
    int navigationBarColor = ViewCompat.MEASURED_STATE_MASK;
    int navigationBarColorTransform = ViewCompat.MEASURED_STATE_MASK;
    boolean navigationBarDarkIcon = false;
    boolean navigationBarEnable = true;
    boolean navigationBarWithEMUI3Enable = true;
    boolean navigationBarWithKitkatEnable = true;
    OnKeyboardListener onKeyboardListener;
    float statusBarAlpha = 0.0f;
    int statusBarColor = 0;
    boolean statusBarColorEnabled = true;
    int statusBarColorTransform = ViewCompat.MEASURED_STATE_MASK;
    boolean statusBarDarkFont = false;
    View statusBarView;
    View titleBarView;
    float viewAlpha = 0.0f;
    Map<View, Map<Integer, Integer>> viewMap = new HashMap();

    /* access modifiers changed from: protected */
    public BarParams clone() {
        try {
            return (BarParams) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
