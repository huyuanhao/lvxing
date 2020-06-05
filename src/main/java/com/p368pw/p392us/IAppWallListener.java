package com.p368pw.p392us;

/* renamed from: com.pw.us.IAppWallListener */
public interface IAppWallListener {
    public static final int EVENT_TYPE_ACTIVE = 2;
    @Deprecated
    public static final int EVENT_TYPE_INSTALL = 1;
    public static final int EVENT_TYPE_SIGN_IN = 3;

    void onClicked();

    void onError(String str);

    void onLoaded(Setting setting);

    void onReward(int i, int i2, double d);

    void onShowed();
}
