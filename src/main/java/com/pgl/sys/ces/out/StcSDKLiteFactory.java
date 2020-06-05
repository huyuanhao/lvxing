package com.pgl.sys.ces.out;

import android.content.Context;
import com.pgl.sys.ces.C4804b;

public class StcSDKLiteFactory {
    /* renamed from: a */
    private static ISdkLite f15480a;

    public static ISdkLite getInstance() {
        return f15480a;
    }

    @Deprecated
    public static ISdkLite getSDK(Context context, String str) {
        if (f15480a == null) {
            synchronized (StcSDKLiteFactory.class) {
                if (f15480a == null) {
                    f15480a = C4804b.m19659a(context, str, 255);
                }
            }
        }
        return f15480a;
    }

    public static ISdkLite getSDK(Context context, String str, int i) {
        if (f15480a == null) {
            synchronized (StcSDKLiteFactory.class) {
                if (f15480a == null) {
                    f15480a = C4804b.m19659a(context, str, i);
                }
            }
        }
        return f15480a;
    }
}
