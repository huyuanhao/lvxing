package com.tencent.dynamicbundle;

import android.content.Context;
import com.tencent.dynamicbundle.model.BundleInfo;
import java.util.HashMap;

/* compiled from: ProGuard */
public class DynamicBundleStatus {
    /* renamed from: a */
    private static DynamicBundleStatus f24677a;
    public Context AppContext;
    public HashMap<String, BundleInfo> loadedBundles = new HashMap<>();

    public static synchronized DynamicBundleStatus getInstance() {
        DynamicBundleStatus dynamicBundleStatus;
        synchronized (DynamicBundleStatus.class) {
            if (f24677a == null) {
                f24677a = new DynamicBundleStatus();
            }
            dynamicBundleStatus = f24677a;
        }
        return dynamicBundleStatus;
    }
}
