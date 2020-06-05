package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.CommonPermissionListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.CommonPermissionListenerImpl;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.utils.h */
public class CommonPermissionUtils {
    /* renamed from: a */
    private static final Map<String, C2554a> f9167a = Collections.synchronizedMap(new HashMap());
    /* renamed from: b */
    private static IListenerManager f9168b;

    /* compiled from: CommonPermissionUtils */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.h$a */
    public interface C2554a {
        /* renamed from: a */
        void mo16483a();

        /* renamed from: a */
        void mo16484a(String str);
    }

    /* renamed from: a */
    public static void m12156a(String str, String[] strArr, C2554a aVar) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            m12154a(str, aVar);
            TTDelegateActivity.m8100a(str, strArr);
        }
    }

    /* renamed from: a */
    public static void m12153a(final String str) {
        if (!TextUtils.isEmpty(str)) {
            if (MultiGlobalInfo.m11808b()) {
                TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                    public void run() {
                        String str = "MultiProcess";
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("handleYes-1，key=");
                            sb.append(str);
                            C2564t.m12220b(str, sb.toString());
                            CommonPermissionUtils.m12157b().broadcastPermissionListener(str, null);
                        } catch (Throwable unused) {
                        }
                    }
                }, 5);
                return;
            }
            C2554a b = m12158b(str);
            if (b != null) {
                b.mo16483a();
            }
        }
    }

    /* renamed from: a */
    public static void m12155a(final String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (MultiGlobalInfo.m11808b()) {
                TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                    public void run() {
                        String str = "MultiProcess";
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("handleNo-1，key=");
                            sb.append(str);
                            sb.append("，permission=");
                            sb.append(str2);
                            C2564t.m12220b(str, sb.toString());
                            CommonPermissionUtils.m12157b().broadcastPermissionListener(str, str2);
                        } catch (Throwable unused) {
                        }
                    }
                }, 5);
                return;
            }
            C2554a b = m12158b(str);
            if (b != null) {
                b.mo16484a(str2);
            }
        }
    }

    /* renamed from: a */
    private static void m12154a(final String str, final C2554a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (MultiGlobalInfo.m11808b()) {
                TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                    public void run() {
                        String str = "MultiProcess";
                        try {
                            C2564t.m12226e(str, "getListenerManager().registerPermissionListener...");
                            CommonPermissionUtils.m12157b().registerPermissionListener(str, new CommonPermissionListenerImpl(aVar));
                        } catch (Throwable th) {
                            th.printStackTrace();
                            C2564t.m12226e(str, th.toString());
                        }
                    }
                }, 5);
            } else {
                f9167a.put(str, aVar);
            }
        }
    }

    /* renamed from: b */
    private static C2554a m12158b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (C2554a) f9167a.remove(str);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static IListenerManager m12157b() {
        if (f9168b == null) {
            f9168b = CommonPermissionListenerManagerImpl.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(4));
        }
        return f9168b;
    }
}
