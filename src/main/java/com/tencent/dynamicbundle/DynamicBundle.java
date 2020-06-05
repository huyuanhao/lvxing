package com.tencent.dynamicbundle;

import android.content.Context;
import com.tencent.dynamicbundle.local.C7286a;

/* compiled from: ProGuard */
public class DynamicBundle {
    /* renamed from: a */
    private static DynamicBundle f24675a;

    public boolean localLoad(String str) {
        return false;
    }

    public static synchronized DynamicBundle getInstance() {
        DynamicBundle dynamicBundle;
        synchronized (DynamicBundle.class) {
            if (f24675a == null) {
                f24675a = new DynamicBundle();
            }
            dynamicBundle = f24675a;
        }
        return dynamicBundle;
    }

    public boolean startLoad(Context context) {
        DynamicBundleStatus.getInstance().AppContext = context;
        C7286a.m31453a().mo34998b();
        return false;
    }
}
