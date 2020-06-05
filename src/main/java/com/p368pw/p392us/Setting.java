package com.p368pw.p392us;

import android.app.Activity;
import android.graphics.Color;
import android.view.ViewGroup;
import com.p368pw.inner.p369a.C4967g;
import com.p368pw.inner.p383b.C5073a;
import com.p368pw.inner.p383b.C5081b;
import com.p368pw.inner.p383b.C5087c;
import com.p368pw.inner.p383b.C5095d;
import com.p368pw.inner.p383b.C5104e;
import com.p368pw.view.NativeAdContainer;
import java.lang.ref.WeakReference;

/* renamed from: com.pw.us.Setting */
public class Setting {
    public static final int ORIENTATION_LANDSCAPE = 0;
    public static final int ORIENTATION_PORTRAIT = 1;
    public static final int REWARD_TYPE_DOUBLE = 2;
    public static final int REWARD_TYPE_INTEGER = 1;
    public static final int TYPE_APP_WALL = 106;
    public static final int TYPE_FULL_INTERSTITIAL = 4;
    public static final int TYPE_INTERSTITIAL = 2;
    public static final int TYPE_NATIVE = 1;
    public static final int TYPE_OPEN_SCREEN = 5;
    public static final int TYPE_REWARDED = 3;
    private Object AdObject;
    private WeakReference<Activity> mActivity;
    private IAdListener mAdListener;
    private int mAdType;
    private int mAppWallBackIconResId;
    private int mAppWallCoinResId;
    private int mAppWallColor = Color.parseColor("#F04258");
    private double mAppWallInstallCoin;
    private double mAppWallOpenCoin;
    private String mAppWallTitle;
    private IAppWallListener mAppwallListener;
    private IRewardAdListener mIRewardAdListener;
    private IInterstitialAdListener mInsListener;
    private Object mObject3;
    private int mOrientation = -1;
    private String mPlacementId;
    private int mRewardType = 1;
    private ISplashAdListener mSplashAdListener;
    private String mUuid;
    private NativeAdContainer regViewContainer;
    private ViewGroup regViewGroup;
    private C4967g thPlacementBean;
    private String userId;

    public Setting(Activity activity, int i, String str, int i2, IInterstitialAdListener iInterstitialAdListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mOrientation = i2;
        this.mInsListener = new C5087c(iInterstitialAdListener);
    }

    public Setting(Activity activity, int i, String str, IAdListener iAdListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mAdListener = new C5073a(iAdListener);
    }

    public Setting(Activity activity, int i, String str, IAppWallListener iAppWallListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mAppwallListener = new C5081b(iAppWallListener);
    }

    public Setting(Activity activity, int i, String str, IInterstitialAdListener iInterstitialAdListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mInsListener = new C5087c(iInterstitialAdListener);
    }

    public Setting(Activity activity, int i, String str, IRewardAdListener iRewardAdListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mIRewardAdListener = new C5095d(iRewardAdListener);
    }

    public Setting(Activity activity, int i, String str, ISplashAdListener iSplashAdListener) {
        this.mActivity = new WeakReference<>(activity);
        this.mAdType = i;
        this.mPlacementId = str;
        this.mSplashAdListener = new C5104e(iSplashAdListener);
    }

    public Activity getActivity() {
        return (Activity) this.mActivity.get();
    }

    public IAdListener getAdListener() {
        return this.mAdListener;
    }

    @Deprecated
    public Object getAdObject() {
        return this.AdObject;
    }

    public int getAdType() {
        return this.mAdType;
    }

    public int getAppWallBackIconResId() {
        return this.mAppWallBackIconResId;
    }

    public int getAppWallCoinResId() {
        return this.mAppWallCoinResId;
    }

    public int getAppWallColor() {
        return this.mAppWallColor;
    }

    @Deprecated
    public double getAppWallInstallCoin() {
        return this.mAppWallInstallCoin;
    }

    public double getAppWallOpenCoin() {
        return this.mAppWallOpenCoin;
    }

    public String getAppWallTitle() {
        return this.mAppWallTitle;
    }

    public IAppWallListener getAppwallListener() {
        return this.mAppwallListener;
    }

    public IRewardAdListener getIRewardAdListener() {
        return this.mIRewardAdListener;
    }

    public IInterstitialAdListener getInterstitialListener() {
        return this.mInsListener;
    }

    @Deprecated
    public Object getObject3() {
        return this.mObject3;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getPlacementId() {
        return this.mPlacementId;
    }

    public NativeAdContainer getRegViewContainer() {
        return this.regViewContainer;
    }

    public ViewGroup getRegViewGroup() {
        return this.regViewGroup;
    }

    public int getRewardType() {
        return this.mRewardType;
    }

    public ISplashAdListener getSplashAdListener() {
        return this.mSplashAdListener;
    }

    @Deprecated
    public C4967g getThPlacementBean() {
        return this.thPlacementBean;
    }

    public String getUserId() {
        return this.userId;
    }

    @Deprecated
    public String getUuid() {
        return this.mUuid;
    }

    @Deprecated
    public void setAdObject(Object obj) {
        this.AdObject = obj;
    }

    public void setAdViewContainer(NativeAdContainer nativeAdContainer) {
        this.regViewContainer = nativeAdContainer;
    }

    public void setAdViewGroup(ViewGroup viewGroup) {
        this.regViewGroup = viewGroup;
    }

    public Setting setAppWallBackIconResId(int i) {
        this.mAppWallBackIconResId = i;
        return this;
    }

    public Setting setAppWallCoinResId(int i) {
        this.mAppWallCoinResId = i;
        return this;
    }

    public Setting setAppWallColor(int i) {
        this.mAppWallColor = i;
        return this;
    }

    @Deprecated
    public Setting setAppWallInstallCoin(double d) {
        this.mAppWallInstallCoin = d;
        return this;
    }

    public Setting setAppWallOpenCoin(double d) {
        this.mAppWallOpenCoin = d;
        return this;
    }

    public Setting setAppWallTitle(String str) {
        this.mAppWallTitle = str;
        return this;
    }

    @Deprecated
    public void setObject3(Object obj) {
        this.mObject3 = obj;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public Setting setRewardType(int i) {
        this.mRewardType = i;
        return this;
    }

    @Deprecated
    public void setThPlacementBean(C4967g gVar) {
        this.thPlacementBean = gVar;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Deprecated
    public void setUuid(String str) {
        this.mUuid = str;
    }
}
