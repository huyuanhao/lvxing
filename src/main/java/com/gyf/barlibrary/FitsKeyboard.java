package com.gyf.barlibrary;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

public class FitsKeyboard implements OnGlobalLayoutListener {
    private final int mActionBarHeight;
    private Activity mActivity;
    private View mChildView;
    private View mContentView;
    private View mDecorView;
    private ImmersionBar mImmersionBar;
    private boolean mIsAddListener;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private final int mStatusBarHeight;
    private int mTempKeyboardHeight;
    private Window mWindow;

    /* JADX WARNING: type inference failed for: r3v4, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    FitsKeyboard(com.gyf.barlibrary.ImmersionBar r2, android.app.Activity r3, android.view.Window r4) {
        /*
        r1 = this;
        r1.<init>()
        r0 = 0
        r1.mPaddingLeft = r0
        r1.mPaddingTop = r0
        r1.mPaddingRight = r0
        r1.mPaddingBottom = r0
        r1.mImmersionBar = r2
        r1.mActivity = r3
        r1.mWindow = r4
        android.view.Window r2 = r1.mWindow
        android.view.View r2 = r2.getDecorView()
        r1.mDecorView = r2
        android.view.View r2 = r1.mDecorView
        r3 = 16908290(0x1020002, float:2.3877235E-38)
        android.view.View r2 = r2.findViewById(r3)
        android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
        android.view.View r3 = r2.getChildAt(r0)
        r1.mChildView = r3
        android.view.View r3 = r1.mChildView
        if (r3 == 0) goto L_0x005d
        boolean r4 = r3 instanceof androidx.drawerlayout.widget.DrawerLayout
        if (r4 == 0) goto L_0x003b
        androidx.drawerlayout.widget.DrawerLayout r3 = (androidx.drawerlayout.widget.DrawerLayout) r3
        android.view.View r3 = r3.getChildAt(r0)
        r1.mChildView = r3
    L_0x003b:
        android.view.View r3 = r1.mChildView
        if (r3 == 0) goto L_0x005d
        int r3 = r3.getPaddingLeft()
        r1.mPaddingLeft = r3
        android.view.View r3 = r1.mChildView
        int r3 = r3.getPaddingTop()
        r1.mPaddingTop = r3
        android.view.View r3 = r1.mChildView
        int r3 = r3.getPaddingRight()
        r1.mPaddingRight = r3
        android.view.View r3 = r1.mChildView
        int r3 = r3.getPaddingBottom()
        r1.mPaddingBottom = r3
    L_0x005d:
        android.view.View r3 = r1.mChildView
        if (r3 == 0) goto L_0x0062
        r2 = r3
    L_0x0062:
        r1.mContentView = r2
        com.gyf.barlibrary.BarConfig r2 = new com.gyf.barlibrary.BarConfig
        android.app.Activity r3 = r1.mActivity
        r2.m45412init(r3)
        int r3 = r2.getStatusBarHeight()
        r1.mStatusBarHeight = r3
        int r2 = r2.getActionBarHeight()
        r1.mActionBarHeight = r2
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.FitsKeyboard.m45417init(com.gyf.barlibrary.ImmersionBar, android.app.Activity, android.view.Window):void");
    }

    /* access modifiers changed from: 0000 */
    public void enable(int i) {
        if (VERSION.SDK_INT >= 19) {
            this.mWindow.setSoftInputMode(i);
            if (!this.mIsAddListener) {
                this.mDecorView.getViewTreeObserver().addOnGlobalLayoutListener(this);
                this.mIsAddListener = true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void disable() {
        if (VERSION.SDK_INT >= 19 && this.mIsAddListener) {
            if (this.mChildView != null) {
                this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
            } else {
                this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), this.mImmersionBar.getPaddingBottom());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void cancel() {
        if (VERSION.SDK_INT >= 19 && this.mIsAddListener) {
            this.mDecorView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.mIsAddListener = false;
        }
    }

    public void onGlobalLayout() {
        int i;
        ImmersionBar immersionBar = this.mImmersionBar;
        if (immersionBar != null && immersionBar.getBarParams() != null && this.mImmersionBar.getBarParams().keyboardEnable) {
            int navigationBarHeight = ImmersionBar.getNavigationBarHeight(this.mActivity);
            Rect rect = new Rect();
            this.mDecorView.getWindowVisibleDisplayFrame(rect);
            int height = this.mContentView.getHeight() - rect.bottom;
            if (height != this.mTempKeyboardHeight) {
                this.mTempKeyboardHeight = height;
                boolean z = true;
                if (ImmersionBar.checkFitsSystemWindows(this.mWindow.getDecorView().findViewById(16908290))) {
                    height -= navigationBarHeight;
                    if (height <= navigationBarHeight) {
                        z = false;
                    }
                } else if (this.mChildView != null) {
                    if (this.mImmersionBar.getBarParams().isSupportActionBar) {
                        height += this.mActionBarHeight + this.mStatusBarHeight;
                    }
                    if (this.mImmersionBar.getBarParams().fits) {
                        height += this.mStatusBarHeight;
                    }
                    if (height > navigationBarHeight) {
                        i = this.mPaddingBottom + height;
                    } else {
                        i = 0;
                        z = false;
                    }
                    this.mContentView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, i);
                } else {
                    int paddingBottom = this.mImmersionBar.getPaddingBottom();
                    height -= navigationBarHeight;
                    if (height > navigationBarHeight) {
                        paddingBottom = height + navigationBarHeight;
                    } else {
                        z = false;
                    }
                    this.mContentView.setPadding(this.mImmersionBar.getPaddingLeft(), this.mImmersionBar.getPaddingTop(), this.mImmersionBar.getPaddingRight(), paddingBottom);
                }
                if (height < 0) {
                    height = 0;
                }
                if (this.mImmersionBar.getBarParams().onKeyboardListener != null) {
                    this.mImmersionBar.getBarParams().onKeyboardListener.onKeyboardChange(z, height);
                }
            }
        }
    }
}
