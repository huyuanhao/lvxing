package com.p522qq.p523e.ads.cfg;

import android.content.Context;
import com.p522qq.p523e.comm.managers.GDTADManager;
import com.p522qq.p523e.comm.managers.plugin.C6413PM.C6416a.C6417a;
import com.p522qq.p523e.comm.util.GDTLogger;
import com.p522qq.p523e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.cfg.GDTAD */
public class GDTAD {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static boolean f19964a = false;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static InitListener f19965b;
    /* renamed from: c */
    private static C6417a f19966c = new C6417a() {
        public final void onLoadFail() {
            GDTLogger.m25264w("Init fail", null);
        }

        public final void onLoadSuccess() {
            GDTAD.f19964a = true;
            if (GDTAD.f19965b != null) {
                GDTAD.f19965b.onSuccess();
            }
        }
    };

    /* renamed from: com.qq.e.ads.cfg.GDTAD$InitListener */
    public interface InitListener {
        void onSuccess();
    }

    public static void initSDK(Context context, String str, InitListener initListener) {
        if (f19964a) {
            GDTLogger.m25264w("SDK已经被初始化过", null);
        } else if (context == null) {
            GDTLogger.m25260e("Context参数不能为null");
        } else if (StringUtil.isEmpty(str)) {
            GDTLogger.m25260e("AppId参数不能为空");
        } else {
            f19965b = initListener;
            GDTADManager instance = GDTADManager.getInstance();
            instance.setPluginLoadListener(f19966c);
            instance.initWith(context.getApplicationContext(), str);
        }
    }
}
