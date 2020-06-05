package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.p201a.CommonDialogListenerManagerImpl;
import com.bytedance.sdk.openadsdk.multipro.aidl.p202b.CommonDialogListenerImpl;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.utils.g */
public class CommonDialogHelper {
    /* renamed from: a */
    private static final Map<String, C2550a> f9161a = Collections.synchronizedMap(new HashMap());
    /* renamed from: b */
    private static IListenerManager f9162b;

    /* compiled from: CommonDialogHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.g$a */
    public interface C2550a {
        /* renamed from: a */
        void mo16493a();

        /* renamed from: b */
        void mo16494b();

        /* renamed from: c */
        void mo16495c();
    }

    /* renamed from: a */
    public static void m12143a(String str, String str2, String str3, C2550a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            m12142a(str, aVar);
            TTDelegateActivity.m8098a(str, str2, str3);
        }
    }

    /* renamed from: a */
    public static void m12144a(String str, String str2, String str3, String str4, String str5, C2550a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            m12142a(str, aVar);
            TTDelegateActivity.m8099a(str, str2, str3, str4, str5);
        }
    }

    /* renamed from: a */
    public static void m12140a(String str) {
        m12141a(str, 1);
    }

    /* renamed from: b */
    public static void m12146b(String str) {
        m12141a(str, 2);
    }

    /* renamed from: c */
    public static void m12147c(String str) {
        m12141a(str, 3);
    }

    /* renamed from: a */
    public static void m12142a(final String str, final C2550a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            if (MultiGlobalInfo.m11808b()) {
                TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            CommonDialogHelper.m12145b().registerDialogListener(str, new CommonDialogListenerImpl(aVar));
                        } catch (Throwable unused) {
                        }
                    }
                }, 5);
            } else {
                f9161a.put(str, aVar);
            }
        }
    }

    /* renamed from: d */
    public static C2550a m12148d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (C2550a) f9161a.remove(str);
    }

    /* renamed from: a */
    private static void m12141a(final String str, final int i) {
        if (!TextUtils.isEmpty(str)) {
            if (MultiGlobalInfo.m11808b()) {
                TTExecutor.m11692a().mo16804a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            CommonDialogHelper.m12145b().broadcastDialogListener(str, i);
                        } catch (Throwable unused) {
                        }
                    }
                }, 5);
                return;
            }
            C2550a d = m12148d(str);
            if (d != null) {
                if (i == 1) {
                    d.mo16493a();
                } else if (i == 2) {
                    d.mo16494b();
                } else if (i != 3) {
                    d.mo16495c();
                } else {
                    d.mo16495c();
                }
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static IListenerManager m12145b() {
        if (f9162b == null) {
            f9162b = CommonDialogListenerManagerImpl.asInterface(BinderPool.m11776a(InternalContainer.m10059a()).mo16858a(2));
        }
        return f9162b;
    }
}
