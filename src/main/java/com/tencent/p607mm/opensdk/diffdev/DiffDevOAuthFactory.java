package com.tencent.p607mm.opensdk.diffdev;

import com.tencent.p607mm.opensdk.diffdev.p609a.C7325a;
import com.tencent.p607mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        StringBuilder sb = new StringBuilder("getDiffDevOAuth, version = ");
        sb.append(i);
        String sb2 = sb.toString();
        String str = TAG;
        Log.m31629v(str, sb2);
        if (i > 1) {
            StringBuilder sb3 = new StringBuilder("getDiffDevOAuth fail, unsupported version = ");
            sb3.append(i);
            Log.m31627e(str, sb3.toString());
            return null;
        } else if (i != 1) {
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new C7325a();
            }
            return v1Instance;
        }
    }
}
