package com.gyf.barlibrary;

import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import epco.C7990p;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ImmersionBar {
    private static final int BOUNDARY_COLOR = -4539718;
    private static final int FLAG_FITS_DEFAULT = 0;
    private static final int FLAG_FITS_STATUS = 3;
    private static final int FLAG_FITS_SYSTEM_WINDOWS = 4;
    private static final int FLAG_FITS_TITLE = 1;
    private static final int FLAG_FITS_TITLE_MARGIN_TOP = 2;
    private static final int IMMERSION_NAVIGATION_BAR_VIEW = C2819R.C2820id.immersion_navigation_bar_view;
    private static final int IMMERSION_STATUS_BAR_VIEW = C2819R.C2820id.immersion_status_bar_view;
    private static final String MIUI_NAVIGATION_BAR_DARK = "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE";
    private static final String MIUI_STATUS_BAR_DARK = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
    private static final String NAVIGATIONBAR_IS_MIN = "navigationbar_is_min";
    private static Map<String, ImmersionBar> mImmersionBarMap = new HashMap();
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public BarConfig mBarConfig;
    /* access modifiers changed from: private */
    public BarParams mBarParams;
    /* access modifiers changed from: private */
    public ViewGroup mContentView;
    /* access modifiers changed from: private */
    public ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mHasNavigationBarColor;
    private String mImmersionBarName;
    private boolean mIsFitsLayoutOverlap;
    private boolean mIsFitsNotch;
    private boolean mIsFragment;
    /* access modifiers changed from: private */
    public int mNavigationBarHeight;
    /* access modifiers changed from: private */
    public int mNavigationBarWidth;
    private ContentObserver mNavigationObserver;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;

    /* renamed from: com.gyf.barlibrary.ImmersionBar$3 */
    static /* synthetic */ class C28183 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$barlibrary$BarHide = new int[BarHide.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
            com.gyf.barlibrary.BarHide[] r0 = com.gyf.barlibrary.BarHide.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            $SwitchMap$com$gyf$barlibrary$BarHide = r0
            int[] r0 = $SwitchMap$com$gyf$barlibrary$BarHide     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_HIDE_BAR     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = $SwitchMap$com$gyf$barlibrary$BarHide     // Catch:{ NoSuchFieldError -> 0x001f }
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_HIDE_STATUS_BAR     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = $SwitchMap$com$gyf$barlibrary$BarHide     // Catch:{ NoSuchFieldError -> 0x002a }
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_HIDE_NAVIGATION_BAR     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = $SwitchMap$com$gyf$barlibrary$BarHide     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.gyf.barlibrary.BarHide r1 = com.gyf.barlibrary.BarHide.FLAG_SHOW_BAR     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.ImmersionBar.C28183.m45430clinit():void");
        }
    }

    private ImmersionBar(Activity activity) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mWindow = this.mActivity.getWindow();
        this.mImmersionBarName = this.mActivity.toString();
        this.mBarParams = new BarParams();
        this.mDecorView = (ViewGroup) this.mWindow.getDecorView();
        this.mContentView = (ViewGroup) this.mDecorView.findViewById(16908290);
    }

    private ImmersionBar(Fragment fragment) {
        this((Activity) fragment.getActivity(), fragment);
    }

    private ImmersionBar(Activity activity, Fragment fragment) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mFragment = fragment;
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            throw new IllegalArgumentException("Activity不能为空!!!");
        } else if (mImmersionBarMap.get(activity2.toString()) != null) {
            this.mIsFragment = true;
            this.mWindow = this.mActivity.getWindow();
            StringBuilder sb = new StringBuilder();
            sb.append(activity.toString());
            sb.append(fragment.toString());
            this.mImmersionBarName = sb.toString();
            this.mBarParams = new BarParams();
            this.mDecorView = (ViewGroup) this.mWindow.getDecorView();
            this.mContentView = (ViewGroup) this.mDecorView.findViewById(16908290);
        } else {
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
    }

    private ImmersionBar(DialogFragment dialogFragment) {
        this(dialogFragment, dialogFragment.getDialog());
    }

    private ImmersionBar(DialogFragment dialogFragment, Dialog dialog) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = dialogFragment.getActivity();
        this.mFragment = dialogFragment;
        this.mDialog = dialog;
        Activity activity = this.mActivity;
        if (activity == null) {
            throw new IllegalArgumentException("Activity不能为空!!!");
        } else if (this.mDialog == null) {
            throw new IllegalArgumentException("DialogFragment中的dialog不能为空");
        } else if (mImmersionBarMap.get(activity.toString()) != null) {
            this.mWindow = this.mDialog.getWindow();
            StringBuilder sb = new StringBuilder();
            sb.append(this.mActivity.toString());
            sb.append(dialogFragment.toString());
            this.mImmersionBarName = sb.toString();
            this.mBarParams = new BarParams();
            this.mDecorView = (ViewGroup) this.mWindow.getDecorView();
            this.mContentView = (ViewGroup) this.mDecorView.findViewById(16908290);
        } else {
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
    }

    private ImmersionBar(Activity activity, Dialog dialog) {
        this(activity, dialog, "");
    }

    private ImmersionBar(Activity activity, Dialog dialog, String str) {
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mIsFragment = false;
        this.mNavigationObserver = null;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mIsFitsLayoutOverlap = false;
        this.mFitsStatusBarType = 0;
        this.mHasNavigationBarColor = false;
        this.mIsFitsNotch = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mActivity = activity;
        this.mDialog = dialog;
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            throw new IllegalArgumentException("Activity不能为空!!!");
        } else if (this.mDialog == null) {
            throw new IllegalArgumentException("dialog不能为空");
        } else if (mImmersionBarMap.get(activity2.toString()) != null) {
            this.mWindow = this.mDialog.getWindow();
            StringBuilder sb = new StringBuilder();
            sb.append(activity.toString());
            sb.append(dialog.toString());
            sb.append(str);
            this.mImmersionBarName = sb.toString();
            this.mBarParams = new BarParams();
            this.mDecorView = (ViewGroup) this.mWindow.getDecorView();
            this.mContentView = (ViewGroup) this.mDecorView.findViewById(16908290);
        } else {
            throw new IllegalArgumentException("必须先在宿主Activity初始化");
        }
    }

    public static ImmersionBar with(Activity activity) {
        ImmersionBar immersionBar = (ImmersionBar) mImmersionBarMap.get(activity.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity);
        mImmersionBarMap.put(activity.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(Fragment fragment) {
        if (fragment.getActivity() != null) {
            Map<String, ImmersionBar> map = mImmersionBarMap;
            StringBuilder sb = new StringBuilder();
            sb.append(fragment.getActivity().toString());
            sb.append(fragment.toString());
            ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(fragment);
            Map<String, ImmersionBar> map2 = mImmersionBarMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fragment.getActivity().toString());
            sb2.append(fragment.toString());
            map2.put(sb2.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    public static ImmersionBar with(Activity activity, Fragment fragment) {
        Map<String, ImmersionBar> map = mImmersionBarMap;
        StringBuilder sb = new StringBuilder();
        sb.append(activity.toString());
        sb.append(fragment.toString());
        ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, fragment);
        Map<String, ImmersionBar> map2 = mImmersionBarMap;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(activity.toString());
        sb2.append(fragment.toString());
        map2.put(sb2.toString(), immersionBar2);
        return immersionBar2;
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        if (dialogFragment.getActivity() != null) {
            Map<String, ImmersionBar> map = mImmersionBarMap;
            StringBuilder sb = new StringBuilder();
            sb.append(dialogFragment.getActivity().toString());
            sb.append(dialogFragment.toString());
            ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment);
            Map<String, ImmersionBar> map2 = mImmersionBarMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dialogFragment.getActivity().toString());
            sb2.append(dialogFragment.toString());
            map2.put(sb2.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    @Deprecated
    public static ImmersionBar with(DialogFragment dialogFragment, Dialog dialog) {
        if (dialogFragment.getActivity() != null) {
            Map<String, ImmersionBar> map = mImmersionBarMap;
            StringBuilder sb = new StringBuilder();
            sb.append(dialogFragment.getActivity().toString());
            sb.append(dialogFragment.toString());
            ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
            if (immersionBar != null) {
                return immersionBar;
            }
            ImmersionBar immersionBar2 = new ImmersionBar(dialogFragment, dialog);
            Map<String, ImmersionBar> map2 = mImmersionBarMap;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dialogFragment.getActivity().toString());
            sb2.append(dialogFragment.toString());
            map2.put(sb2.toString(), immersionBar2);
            return immersionBar2;
        }
        throw new IllegalArgumentException("Activity不能为空!!!");
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        Map<String, ImmersionBar> map = mImmersionBarMap;
        StringBuilder sb = new StringBuilder();
        sb.append(activity.toString());
        sb.append(dialog.toString());
        ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog);
        Map<String, ImmersionBar> map2 = mImmersionBarMap;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(activity.toString());
        sb2.append(dialog.toString());
        map2.put(sb2.toString(), immersionBar2);
        return immersionBar2;
    }

    @Deprecated
    public static ImmersionBar with(Activity activity, Dialog dialog, String str) {
        Map<String, ImmersionBar> map = mImmersionBarMap;
        StringBuilder sb = new StringBuilder();
        sb.append(activity.toString());
        sb.append(dialog.toString());
        sb.append(str);
        ImmersionBar immersionBar = (ImmersionBar) map.get(sb.toString());
        if (immersionBar != null) {
            return immersionBar;
        }
        ImmersionBar immersionBar2 = new ImmersionBar(activity, dialog, str);
        Map<String, ImmersionBar> map2 = mImmersionBarMap;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(activity.toString());
        sb2.append(dialog.toString());
        sb2.append(str);
        map2.put(sb2.toString(), immersionBar2);
        return immersionBar2;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentBar() {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = 0;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar statusBarColor(int i) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColor(int i, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar statusBarColor(int i, int i2, float f) {
        return statusBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str, float f) {
        return statusBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar statusBarColorInt(int i) {
        this.mBarParams.statusBarColor = i;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, float f) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i;
        barParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i, int i2, float f) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i;
        barParams.statusBarColorTransform = i2;
        barParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColor(int i) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColor(int i, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), f);
    }

    public ImmersionBar navigationBarColor(int i, int i2, float f) {
        return navigationBarColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str, float f) {
        return navigationBarColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar navigationBarColorInt(int i) {
        this.mBarParams.navigationBarColor = i;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, float f) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i;
        barParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i, int i2, float f) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i;
        barParams.navigationBarColorTransform = i2;
        barParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColor(int i) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColor(int i, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), (float) i);
    }

    public ImmersionBar barColor(int i, int i2, float f) {
        return barColorInt(ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar barColor(String str, float f) {
        return barColorInt(Color.parseColor(str), f);
    }

    public ImmersionBar barColor(String str, String str2, float f) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f);
    }

    public ImmersionBar barColorInt(int i) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i;
        barParams.navigationBarColor = i;
        return this;
    }

    public ImmersionBar barColorInt(int i, float f) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i;
        barParams.navigationBarColor = i;
        barParams.statusBarAlpha = f;
        barParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barColorInt(int i, int i2, float f) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i;
        barParams.navigationBarColor = i;
        barParams.statusBarColorTransform = i2;
        barParams.navigationBarColorTransform = i2;
        barParams.statusBarAlpha = f;
        barParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i) {
        return statusBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColorTransformInt(int i) {
        this.mBarParams.statusBarColorTransform = i;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i) {
        return navigationBarColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColorTransformInt(int i) {
        this.mBarParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar barColorTransform(int i) {
        return barColorTransformInt(ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar barColorTransformInt(int i) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColorTransform = i;
        barParams.navigationBarColorTransform = i;
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i, int i2) {
        return addViewSupportTransformColorInt(view, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i, int i2) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar viewAlpha(float f) {
        this.mBarParams.viewAlpha = f;
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view != null) {
            if (((Map) this.mBarParams.viewMap.get(view)).size() != 0) {
                this.mBarParams.viewMap.remove(view);
            }
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar fullScreen(boolean z) {
        this.mBarParams.fullScreen = z;
        return this;
    }

    public ImmersionBar statusBarAlpha(float f) {
        this.mBarParams.statusBarAlpha = f;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f) {
        this.mBarParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar barAlpha(float f) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f;
        barParams.navigationBarAlpha = f;
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z) {
        return autoDarkModeEnable(z, 0.0f);
    }

    public ImmersionBar autoDarkModeEnable(boolean z, float f) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z, float f) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z;
        barParams.autoStatusBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z, float f) {
        BarParams barParams = this.mBarParams;
        barParams.autoNavigationBarDarkModeEnable = z;
        barParams.autoNavigationBarDarkModeAlpha = f;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z) {
        return statusBarDarkFont(z, 0.0f);
    }

    public ImmersionBar statusBarDarkFont(boolean z, float f) {
        this.mBarParams.statusBarDarkFont = z;
        if (!z || isSupportStatusBarDarkFont()) {
            BarParams barParams = this.mBarParams;
            barParams.flymeOSStatusBarFontColor = 0;
            barParams.statusBarAlpha = 0.0f;
        } else {
            this.mBarParams.statusBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z) {
        return navigationBarDarkIcon(z, 0.0f);
    }

    public ImmersionBar navigationBarDarkIcon(boolean z, float f) {
        this.mBarParams.navigationBarDarkIcon = z;
        if (!z || isSupportNavigationIconDark()) {
            this.mBarParams.navigationBarAlpha = 0.0f;
        } else {
            this.mBarParams.navigationBarAlpha = f;
        }
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = ContextCompat.getColor(this.mActivity, i);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i) {
        this.mBarParams.flymeOSStatusBarFontColor = i;
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (VERSION.SDK_INT == 19 || OSUtils.isEMUI3_x()) {
            if (this.mBarParams.barHide == BarHide.FLAG_HIDE_NAVIGATION_BAR || this.mBarParams.barHide == BarHide.FLAG_HIDE_BAR) {
                this.mBarParams.hideNavigationBar = true;
            } else {
                this.mBarParams.hideNavigationBar = false;
            }
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z) {
        BarParams barParams = this.mBarParams;
        barParams.fits = z;
        if (!barParams.fits) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i));
    }

    public ImmersionBar fitsSystemWindows(boolean z, int i, int i2, float f) {
        return fitsSystemWindowsInt(z, ContextCompat.getColor(this.mActivity, i), ContextCompat.getColor(this.mActivity, i2), f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i) {
        return fitsSystemWindowsInt(z, i, ViewCompat.MEASURED_STATE_MASK, 0.0f);
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z, int i, int i2, float f) {
        BarParams barParams = this.mBarParams;
        barParams.fits = z;
        barParams.contentColor = i;
        barParams.contentColorTransform = i2;
        barParams.contentAlpha = f;
        if (!barParams.fits) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        this.mContentView.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.contentColor, this.mBarParams.contentColorTransform, this.mBarParams.contentAlpha));
        return this;
    }

    public ImmersionBar statusBarView(View view) {
        if (view == null) {
            return this;
        }
        this.mBarParams.statusBarView = view;
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 3;
        }
        return this;
    }

    public ImmersionBar statusBarView(int i) {
        return statusBarView(this.mActivity.findViewById(i));
    }

    public ImmersionBar statusBarView(int i, View view) {
        return statusBarView(view.findViewById(i));
    }

    public ImmersionBar supportActionBar(boolean z) {
        this.mBarParams.isSupportActionBar = z;
        return this;
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBar(View view, boolean z) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        BarParams barParams = this.mBarParams;
        barParams.titleBarView = view;
        barParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar titleBar(int i) {
        return titleBar(i, true);
    }

    public ImmersionBar titleBar(int i, boolean z) {
        Fragment fragment = this.mFragment;
        if (fragment == null || fragment.getView() == null) {
            return titleBar(this.mActivity.findViewById(i), z);
        }
        return titleBar(this.mFragment.getView().findViewById(i), z);
    }

    public ImmersionBar titleBar(int i, View view) {
        return titleBar(view.findViewById(i), true);
    }

    public ImmersionBar titleBar(int i, View view, boolean z) {
        return titleBar(view.findViewById(i), z);
    }

    public ImmersionBar titleBarMarginTop(int i) {
        Fragment fragment = this.mFragment;
        if (fragment == null || fragment.getView() == null) {
            return titleBarMarginTop(this.mActivity.findViewById(i));
        }
        return titleBarMarginTop(this.mFragment.getView().findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(int i, View view) {
        return titleBarMarginTop(view.findViewById(i));
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z) {
        this.mBarParams.statusBarColorEnabled = z;
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    public ImmersionBar addTag(String str) {
        if (!isEmpty(str)) {
            this.mTagMap.put(str, this.mBarParams.clone());
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar getTag(String str) {
        if (!isEmpty(str)) {
            BarParams barParams = (BarParams) this.mTagMap.get(str);
            if (barParams != null) {
                this.mBarParams = barParams.clone();
            }
            return this;
        }
        throw new IllegalArgumentException("tag不能为空");
    }

    public ImmersionBar keyboardEnable(boolean z) {
        return keyboardEnable(z, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardEnable(boolean z, int i) {
        BarParams barParams = this.mBarParams;
        barParams.keyboardEnable = z;
        barParams.keyboardMode = i;
        return this;
    }

    public ImmersionBar keyboardMode(int i) {
        this.mBarParams.keyboardMode = i;
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        if (this.mBarParams.onKeyboardListener == null) {
            this.mBarParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar navigationBarEnable(boolean z) {
        this.mBarParams.navigationBarEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z) {
        this.mBarParams.navigationBarWithKitkatEnable = z;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z) {
        this.mBarParams.navigationBarWithEMUI3Enable = z;
        return this;
    }

    @Deprecated
    public ImmersionBar fixMarginAtBottom(boolean z) {
        this.mBarParams.fixMarginAtBottom = z;
        return this;
    }

    public void init() {
        updateBarParams();
        setBar();
        fitsLayoutOverlap();
        fitsKeyboard();
        transformView();
    }

    public void destroy() {
        cancelListener();
        Iterator it = mImmersionBarMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (((String) entry.getKey()).contains(this.mImmersionBarName) || ((String) entry.getKey()).equals(this.mImmersionBarName)) {
                it.remove();
            }
        }
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        if (VERSION.SDK_INT >= 19) {
            if (OSUtils.isEMUI3_x() && this.mBarParams.navigationBarWithKitkatEnable) {
                BarParams barParams = this.mBarParams;
                barParams.navigationBarWithKitkatEnable = barParams.navigationBarWithEMUI3Enable;
            }
            this.mBarConfig = new BarConfig(this.mActivity);
            if (this.mIsFragment) {
                ImmersionBar immersionBar = (ImmersionBar) mImmersionBarMap.get(this.mActivity.toString());
                if (immersionBar != null) {
                    immersionBar.mBarParams = this.mBarParams;
                }
            }
        }
    }

    private void setBar() {
        if (VERSION.SDK_INT >= 19) {
            int i = 256;
            if (VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
                initBarBelowLOLLIPOP();
            } else {
                fitsNotchScreen();
                i = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(256)));
            }
            int hideBar = hideBar(i);
            fitsWindows();
            this.mDecorView.setSystemUiVisibility(hideBar);
        }
        if (OSUtils.isMIUI6Later()) {
            setMIUIBarDark(this.mWindow, MIUI_STATUS_BAR_DARK, this.mBarParams.statusBarDarkFont);
            if (this.mBarParams.navigationBarEnable) {
                setMIUIBarDark(this.mWindow, MIUI_NAVIGATION_BAR_DARK, this.mBarParams.navigationBarDarkIcon);
            }
        }
        if (!OSUtils.isFlymeOS4Later()) {
            return;
        }
        if (this.mBarParams.flymeOSStatusBarFontColor != 0) {
            FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.flymeOSStatusBarFontColor);
        } else {
            FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(this.mActivity, this.mBarParams.statusBarDarkFont);
        }
    }

    private void fitsNotchScreen() {
        if (VERSION.SDK_INT >= 28 && !this.mIsFitsNotch) {
            LayoutParams attributes = this.mWindow.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            this.mWindow.setAttributes(attributes);
            this.mIsFitsNotch = true;
        }
    }

    private int initBarAboveLOLLIPOP(int i) {
        if (!this.mHasNavigationBarColor) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
            this.mHasNavigationBarColor = true;
        }
        int i2 = i | 1024;
        if (this.mBarParams.fullScreen && this.mBarParams.navigationBarEnable) {
            i2 |= 512;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(134217728);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        if (this.mBarParams.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            this.mWindow.setStatusBarColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
        if (this.mBarParams.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        } else {
            this.mWindow.setNavigationBarColor(this.mBarParams.defaultNavigationBarColor);
        }
        return i2;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            if (!this.mBarParams.navigationBarEnable || !this.mBarParams.navigationBarWithKitkatEnable) {
                this.mWindow.clearFlags(134217728);
            } else {
                this.mWindow.addFlags(134217728);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private void setupStatusBarView() {
        View findViewById = this.mDecorView.findViewById(IMMERSION_STATUS_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(IMMERSION_STATUS_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, this.mBarParams.statusBarColorTransform, this.mBarParams.statusBarAlpha));
        } else {
            findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.statusBarColor, 0, this.mBarParams.statusBarAlpha));
        }
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        View findViewById = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(IMMERSION_NAVIGATION_BAR_VIEW);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = GravityCompat.END;
        }
        findViewById.setLayoutParams(layoutParams);
        findViewById.setBackgroundColor(ColorUtils.blendARGB(this.mBarParams.navigationBarColor, this.mBarParams.navigationBarColorTransform, this.mBarParams.navigationBarAlpha));
        if (!this.mBarParams.navigationBarEnable || !this.mBarParams.navigationBarWithKitkatEnable || this.mBarParams.hideNavigationBar) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
    }

    private void adjustDarkModeParams() {
        boolean z = true;
        if (this.mBarParams.autoStatusBarDarkModeEnable) {
            boolean z2 = this.mBarParams.statusBarColor != 0 && this.mBarParams.statusBarColor > BOUNDARY_COLOR;
            statusBarDarkFont(z2, this.mBarParams.autoStatusBarDarkModeAlpha);
        }
        if (this.mBarParams.autoNavigationBarDarkModeEnable) {
            if (this.mBarParams.navigationBarColor == 0 || this.mBarParams.navigationBarColor <= BOUNDARY_COLOR) {
                z = false;
            }
            navigationBarDarkIcon(z, this.mBarParams.autoNavigationBarDarkModeAlpha);
        }
    }

    private int hideBar(int i) {
        if (VERSION.SDK_INT >= 16) {
            int i2 = C28183.$SwitchMap$com$gyf$barlibrary$BarHide[this.mBarParams.barHide.ordinal()];
            if (i2 == 1) {
                i |= 518;
            } else if (i2 == 2) {
                i |= 1028;
            } else if (i2 == 3) {
                i |= C7990p.f27150o;
            } else if (i2 == 4) {
                i |= 0;
            }
        }
        return i | 4096;
    }

    private void fitsWindows() {
        if (VERSION.SDK_INT < 21 || OSUtils.isEMUI3_x()) {
            fitsWindowsBelowLOLLIPOP();
            if (!this.mIsFragment && OSUtils.isEMUI3_x()) {
                fitsWindowsEMUI();
                return;
            }
            return;
        }
        fitsWindowsAboveLOLLIPOP();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        if (checkFitsSystemWindows(this.mDecorView.findViewById(16908290))) {
            if (this.mBarParams.isSupportActionBar) {
                setPadding(0, this.mBarConfig.getActionBarHeight(), 0, 0);
            }
            return;
        }
        int statusBarHeight = (!this.mBarParams.fits || this.mFitsStatusBarType != 4) ? 0 : this.mBarConfig.getStatusBarHeight();
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mBarConfig.getActionBarHeight();
        }
        setPadding(0, statusBarHeight, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    private void fitsWindowsBelowLOLLIPOP() {
        /*
        r5 = this;
        android.view.ViewGroup r0 = r5.mDecorView
        r1 = 16908290(0x1020002, float:2.3877235E-38)
        android.view.View r0 = r0.findViewById(r1)
        boolean r0 = checkFitsSystemWindows(r0)
        r1 = 0
        if (r0 == 0) goto L_0x0020
        com.gyf.barlibrary.BarParams r0 = r5.mBarParams
        boolean r0 = r0.isSupportActionBar
        if (r0 == 0) goto L_0x001f
        com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
        int r0 = r0.getActionBarHeight()
        r5.setPadding(r1, r0, r1, r1)
    L_0x001f:
        return
    L_0x0020:
        com.gyf.barlibrary.BarParams r0 = r5.mBarParams
        boolean r0 = r0.fits
        if (r0 == 0) goto L_0x0032
        int r0 = r5.mFitsStatusBarType
        r2 = 4
        if (r0 != r2) goto L_0x0032
        com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
        int r0 = r0.getStatusBarHeight()
        goto L_0x0033
    L_0x0032:
        r0 = 0
    L_0x0033:
        com.gyf.barlibrary.BarParams r2 = r5.mBarParams
        boolean r2 = r2.isSupportActionBar
        if (r2 == 0) goto L_0x0046
        com.gyf.barlibrary.BarConfig r0 = r5.mBarConfig
        int r0 = r0.getStatusBarHeight()
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        int r2 = r2.getActionBarHeight()
        int r0 = r0 + r2
    L_0x0046:
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        boolean r2 = r2.hasNavigationBar()
        if (r2 == 0) goto L_0x009a
        com.gyf.barlibrary.BarParams r2 = r5.mBarParams
        boolean r2 = r2.navigationBarEnable
        if (r2 == 0) goto L_0x009a
        com.gyf.barlibrary.BarParams r2 = r5.mBarParams
        boolean r2 = r2.navigationBarWithKitkatEnable
        if (r2 == 0) goto L_0x009a
        com.gyf.barlibrary.BarParams r2 = r5.mBarParams
        boolean r2 = r2.fullScreen
        if (r2 != 0) goto L_0x0078
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        boolean r2 = r2.isNavigationAtBottom()
        if (r2 == 0) goto L_0x0071
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        int r2 = r2.getNavigationBarHeight()
        r3 = r2
        r2 = 0
        goto L_0x007a
    L_0x0071:
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        int r2 = r2.getNavigationBarWidth()
        goto L_0x0079
    L_0x0078:
        r2 = 0
    L_0x0079:
        r3 = 0
    L_0x007a:
        com.gyf.barlibrary.BarParams r4 = r5.mBarParams
        boolean r4 = r4.hideNavigationBar
        if (r4 == 0) goto L_0x008b
        com.gyf.barlibrary.BarConfig r4 = r5.mBarConfig
        boolean r4 = r4.isNavigationAtBottom()
        if (r4 == 0) goto L_0x0089
        goto L_0x009b
    L_0x0089:
        r2 = 0
        goto L_0x009c
    L_0x008b:
        com.gyf.barlibrary.BarConfig r4 = r5.mBarConfig
        boolean r4 = r4.isNavigationAtBottom()
        if (r4 != 0) goto L_0x009c
        com.gyf.barlibrary.BarConfig r2 = r5.mBarConfig
        int r2 = r2.getNavigationBarWidth()
        goto L_0x009c
    L_0x009a:
        r2 = 0
    L_0x009b:
        r3 = 0
    L_0x009c:
        r5.setPadding(r1, r0, r2, r3)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.barlibrary.ImmersionBar.fitsWindowsBelowLOLLIPOP():void");
    }

    private void fitsWindowsEMUI() {
        final View findViewById = this.mDecorView.findViewById(IMMERSION_NAVIGATION_BAR_VIEW);
        if (!this.mBarParams.navigationBarEnable || !this.mBarParams.navigationBarWithKitkatEnable) {
            findViewById.setVisibility(8);
        } else if (findViewById != null && this.mNavigationObserver == null) {
            this.mNavigationObserver = new ContentObserver(new Handler()) {
                public void onChange(boolean z) {
                    int i;
                    int i2;
                    ImmersionBar immersionBar = ImmersionBar.this;
                    immersionBar.mBarConfig = new BarConfig(immersionBar.mActivity);
                    int paddingBottom = ImmersionBar.this.mContentView.getPaddingBottom();
                    int paddingRight = ImmersionBar.this.mContentView.getPaddingRight();
                    if (!(ImmersionBar.this.mActivity == null || ImmersionBar.this.mActivity.getContentResolver() == null)) {
                        if (System.getInt(ImmersionBar.this.mActivity.getContentResolver(), ImmersionBar.NAVIGATIONBAR_IS_MIN, 0) == 1) {
                            findViewById.setVisibility(8);
                        } else {
                            findViewById.setVisibility(0);
                            if (!ImmersionBar.checkFitsSystemWindows(ImmersionBar.this.mDecorView.findViewById(16908290))) {
                                if (ImmersionBar.this.mNavigationBarHeight == 0) {
                                    ImmersionBar immersionBar2 = ImmersionBar.this;
                                    immersionBar2.mNavigationBarHeight = immersionBar2.mBarConfig.getNavigationBarHeight();
                                }
                                if (ImmersionBar.this.mNavigationBarWidth == 0) {
                                    ImmersionBar immersionBar3 = ImmersionBar.this;
                                    immersionBar3.mNavigationBarWidth = immersionBar3.mBarConfig.getNavigationBarWidth();
                                }
                                if (!ImmersionBar.this.mBarParams.hideNavigationBar) {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                                    if (ImmersionBar.this.mBarConfig.isNavigationAtBottom()) {
                                        layoutParams.gravity = 80;
                                        layoutParams.height = ImmersionBar.this.mNavigationBarHeight;
                                        i2 = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarHeight : 0;
                                        i = 0;
                                    } else {
                                        layoutParams.gravity = GravityCompat.END;
                                        layoutParams.width = ImmersionBar.this.mNavigationBarWidth;
                                        i = !ImmersionBar.this.mBarParams.fullScreen ? ImmersionBar.this.mNavigationBarWidth : 0;
                                        i2 = 0;
                                    }
                                    findViewById.setLayoutParams(layoutParams);
                                    paddingBottom = i2;
                                    paddingRight = i;
                                }
                            }
                        }
                        paddingBottom = 0;
                        paddingRight = 0;
                    }
                    ImmersionBar immersionBar4 = ImmersionBar.this;
                    immersionBar4.setPadding(0, immersionBar4.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            };
            Activity activity = this.mActivity;
            if (activity != null && activity.getContentResolver() != null && this.mNavigationObserver != null) {
                this.mActivity.getContentResolver().registerContentObserver(System.getUriFor(NAVIGATIONBAR_IS_MIN), true, this.mNavigationObserver);
            }
        }
    }

    private int setStatusBarDarkFont(int i) {
        return (VERSION.SDK_INT < 23 || !this.mBarParams.statusBarDarkFont) ? i : i | 8192;
    }

    private int setNavigationIconDark(int i) {
        return (VERSION.SDK_INT < 26 || !this.mBarParams.navigationBarDarkIcon) ? i : i | 16;
    }

    private void setMIUIBarDark(Window window, String str, boolean z) {
        if (window != null) {
            Class cls = window.getClass();
            try {
                Class cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField(str).getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
                if (z) {
                    method.invoke(window, new Object[]{Integer.valueOf(i), Integer.valueOf(i)});
                    return;
                }
                method.invoke(window, new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
            } catch (Exception unused) {
            }
        }
    }

    private void fitsLayoutOverlap() {
        if (VERSION.SDK_INT >= 19 && !this.mIsFitsLayoutOverlap) {
            int i = this.mFitsStatusBarType;
            if (i == 1) {
                setTitleBar(this.mActivity, this.mBarParams.titleBarView);
                this.mIsFitsLayoutOverlap = true;
            } else if (i == 2) {
                setTitleBarMarginTop(this.mActivity, this.mBarParams.titleBarView);
                this.mIsFitsLayoutOverlap = true;
            } else if (i == 3) {
                setStatusBarView(this.mActivity, this.mBarParams.statusBarView);
                this.mIsFitsLayoutOverlap = true;
            }
        }
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Entry entry : this.mBarParams.viewMap.entrySet()) {
                View view = (View) entry.getKey();
                Map map = (Map) entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Entry entry2 : map.entrySet()) {
                    Integer num = (Integer) entry2.getKey();
                    valueOf2 = (Integer) entry2.getValue();
                    valueOf = num;
                }
                if (view != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.statusBarAlpha));
                    } else {
                        view.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.mBarParams.viewAlpha));
                    }
                }
            }
        }
    }

    private void cancelListener() {
        Activity activity = this.mActivity;
        if (activity != null) {
            if (this.mNavigationObserver != null) {
                activity.getContentResolver().unregisterContentObserver(this.mNavigationObserver);
                this.mNavigationObserver = null;
            }
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
        }
    }

    private void fitsKeyboard() {
        if (VERSION.SDK_INT < 19) {
            return;
        }
        if (this.mIsFragment) {
            ImmersionBar immersionBar = (ImmersionBar) mImmersionBarMap.get(this.mActivity.toString());
            if (immersionBar == null) {
                return;
            }
            if (immersionBar.mBarParams.keyboardEnable) {
                if (immersionBar.mFitsKeyboard == null) {
                    immersionBar.mFitsKeyboard = new FitsKeyboard(immersionBar, immersionBar.mActivity, immersionBar.mWindow);
                }
                immersionBar.mFitsKeyboard.enable(immersionBar.mBarParams.keyboardMode);
                return;
            }
            FitsKeyboard fitsKeyboard = immersionBar.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.disable();
            }
        } else if (this.mBarParams.keyboardEnable) {
            if (this.mFitsKeyboard == null) {
                this.mFitsKeyboard = new FitsKeyboard(this, this.mActivity, this.mWindow);
            }
            this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
        } else {
            FitsKeyboard fitsKeyboard2 = this.mFitsKeyboard;
            if (fitsKeyboard2 != null) {
                fitsKeyboard2.disable();
            }
        }
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    /* access modifiers changed from: private */
    public void setPadding(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i, i2, i3, i4);
        }
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    /* access modifiers changed from: 0000 */
    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    /* access modifiers changed from: 0000 */
    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    /* access modifiers changed from: 0000 */
    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    /* access modifiers changed from: 0000 */
    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public static boolean isSupportStatusBarDarkFont() {
        return OSUtils.isMIUI6Later() || OSUtils.isFlymeOS4Later() || VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNavigationIconDark() {
        return OSUtils.isMIUI6Later() || VERSION.SDK_INT >= 26;
    }

    public static void setTitleBar(final Activity activity, final View view) {
        if (!(activity == null || view == null || VERSION.SDK_INT < 19)) {
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams.height == -2 || layoutParams.height == -1) {
                view.post(new Runnable() {
                    public void run() {
                        layoutParams.height = view.getHeight() + ImmersionBar.getStatusBarHeight(activity);
                        View view = view;
                        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + ImmersionBar.getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
                    }
                });
            } else {
                layoutParams.height += getStatusBarHeight(activity);
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(activity), view.getPaddingRight(), view.getPaddingBottom());
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, View view) {
        if (!(activity == null || view == null || VERSION.SDK_INT < 19)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    public static void setStatusBarView(Activity activity, View view) {
        if (!(activity == null || view == null || VERSION.SDK_INT < 19)) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = getStatusBarHeight(activity);
            view.setLayoutParams(layoutParams);
        }
    }

    public static void setFitsSystemWindows(Activity activity) {
        if (activity != null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof ViewGroup) && !(childAt instanceof DrawerLayout)) {
                    childAt.setFitsSystemWindows(true);
                    ((ViewGroup) childAt).setClipToPadding(true);
                }
            }
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasNavigationBar(Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static int getNavigationBarHeight(Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    public static int getNavigationBarWidth(Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static int getStatusBarHeight(Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    public static int getActionBarHeight(Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    public static boolean hasNotchScreen(Activity activity) {
        return new BarConfig(activity).hasNotchScreen();
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
