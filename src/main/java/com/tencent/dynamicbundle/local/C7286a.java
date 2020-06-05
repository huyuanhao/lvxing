package com.tencent.dynamicbundle.local;

import android.content.Context;
import com.tencent.dynamicbundle.DynamicBundleConfig;
import com.tencent.dynamicbundle.DynamicBundleStatus;
import com.tencent.dynamicbundle.model.BundleInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: ProGuard */
/* renamed from: com.tencent.dynamicbundle.local.a */
public class C7286a {
    /* renamed from: a */
    private static C7286a f24684a;
    /* renamed from: b */
    private Boolean f24685b = Boolean.valueOf(false);

    /* renamed from: a */
    public static synchronized C7286a m31453a() {
        C7286a aVar;
        synchronized (C7286a.class) {
            if (f24684a == null) {
                f24684a = new C7286a();
            }
            aVar = f24684a;
        }
        return aVar;
    }

    /* renamed from: b */
    public void mo34998b() {
        if (!this.f24685b.booleanValue()) {
            File file = new File(DynamicBundleConfig.appDexPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            mo34997a(BundleFileManager.getInstance().getPathFiles(BundleFileManager.getInstance().getFilePath(DynamicBundleStatus.getInstance().AppContext, DynamicBundleConfig.appDexPath), DynamicBundleConfig.endFileName));
            this.f24685b = Boolean.valueOf(true);
        }
    }

    /* renamed from: a */
    public void mo34997a(Vector<String> vector) {
        HashMap<String, BundleInfo> hashMap = DynamicBundleStatus.getInstance().loadedBundles;
        for (int i = 0; i < vector.size(); i++) {
            BundleInfo bundleInfo = new BundleInfo();
            String str = (String) vector.elementAt(i);
            Context context = DynamicBundleStatus.getInstance().AppContext;
            File file = new File(str);
            String a = C7287b.m31456a().mo34999a(file);
            bundleInfo.bundleFullName = file.getName();
            String[] split = bundleInfo.bundleFullName.split("\\.");
            if (split.length >= 3) {
                bundleInfo.bundleName = split[0];
                if (C7288c.m31459a().mo35001a(bundleInfo.bundleName)) {
                    bundleInfo.bundleVersion = split[1];
                    ClassLoader loadDexByPath = BundleFileManager.getInstance().loadDexByPath(context, str, bundleInfo.bundleName);
                    if (loadDexByPath != null) {
                        bundleInfo.dexLoader = loadDexByPath;
                        bundleInfo.bundleMD5 = a;
                        bundleInfo.bundlePath = str;
                        hashMap.put(bundleInfo.bundleName, bundleInfo);
                    } else if (C7288c.m31459a().mo35002b(bundleInfo.bundleFullName)) {
                        C7288c.m31459a().mo35003c(bundleInfo.bundleFullName);
                    }
                }
            }
        }
    }
}
