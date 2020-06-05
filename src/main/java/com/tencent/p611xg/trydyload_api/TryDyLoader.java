package com.tencent.p611xg.trydyload_api;

import android.content.Context;
import com.tencent.dynamicbundle.DynamicBundle;
import com.tencent.dynamicbundle.DynamicBundleConfig;
import com.tencent.dynamicbundle.DynamicBundleStatus;
import com.tencent.dynamicbundle.local.BundleFileManager;
import com.tencent.dynamicbundle.model.BundleInfo;
import java.util.HashMap;

/* renamed from: com.tencent.xg.trydyload_api.TryDyLoader */
public class TryDyLoader {
    private static TryDyLoader instance;
    private ClassLoader classLoader = null;
    private Context context;
    private String dexName = "trydyloaddex";

    private TryDyLoader(Context context2) {
        if (this.classLoader == null) {
            this.context = context2;
            DynamicBundle.getInstance().startLoad(context2);
            HashMap<String, BundleInfo> hashMap = DynamicBundleStatus.getInstance().loadedBundles;
            if (!hashMap.isEmpty()) {
                this.classLoader = ((BundleInfo) hashMap.get(this.dexName)).dexLoader;
                TryDyLoaderRefMapping.init(this.classLoader);
            }
        }
    }

    public static synchronized TryDyLoader getInstance(Context context2) {
        TryDyLoader tryDyLoader;
        synchronized (TryDyLoader.class) {
            if (instance == null) {
                instance = new TryDyLoader(context2);
            }
            tryDyLoader = instance;
        }
        return tryDyLoader;
    }

    public void doSomething(String str) {
        TryDyLoaderRefMapping.doSomething.call(str);
    }

    public String getTryDyLoadBundlePath() {
        return BundleFileManager.getInstance().getFilePath(DynamicBundleStatus.getInstance().AppContext, DynamicBundleConfig.appDexPath);
    }
}
