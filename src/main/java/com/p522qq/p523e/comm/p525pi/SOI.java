package com.p522qq.p523e.comm.p525pi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;

/* renamed from: com.qq.e.comm.pi.SOI */
public interface SOI {
    public static final int ONESHOT_COST_ANIMATION_CANCEL = 14049;
    public static final int ONESHOT_COST_ANIMATION_END = 14059;
    public static final int ONESHOT_COST_ANIMATION_START = 14039;

    /* renamed from: com.qq.e.comm.pi.SOI$AdProductType */
    public enum AdProductType {
        APP,
        LINK_WEB,
        MINI_PROGRAM,
        UNKNOWN
    }

    void clickJoinAd(View view);

    void exposureJoinAd(View view, long j);

    Bitmap getJoinAdImage(Options options);

    Bitmap getOneshotCoverImage(Options options);

    String getOneshotCoverImagePath();

    AdProductType getSplashProductType();

    boolean isJoinAd();

    void reportJoinAdCost(int i);
}
