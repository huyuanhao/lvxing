package com.p530ss.android.downloadlib.p549e;

import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.p530ss.android.downloadlib.p541a.C6565j;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* renamed from: com.ss.android.downloadlib.e.a */
public class AntiHijackUtils {

    /* compiled from: AntiHijackUtils */
    /* renamed from: com.ss.android.downloadlib.e.a$a */
    private static class C6582a implements InvocationHandler {
        /* renamed from: a */
        private Object f21427a;

        private C6582a(Object obj) {
            this.f21427a = obj;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(2:4|(2:8|(3:12|13|(3:15|16|(1:18))(2:19|(5:21|(1:23)|24|(1:26)(1:27)|(1:29))(2:30|(3:32|(1:34)|35))))))|36|37|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e0, code lost:
            r9 = move-exception;
     */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e5, code lost:
            throw m26484a(r9);
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00d9 */
        public java.lang.Object invoke(java.lang.Object r9, java.lang.reflect.Method r10, java.lang.Object[] r11) throws java.lang.Throwable {
            /*
            r8 = this;
            java.lang.String r9 = "refererHost"
            java.lang.String r0 = "oppo_extra_pkg_name"
            java.lang.String r1 = "startActivity"
            java.lang.String r2 = r10.getName()     // Catch:{ all -> 0x00d9 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x00d9 }
            if (r1 == 0) goto L_0x00d9
            r1 = 1
            r2 = r11[r1]     // Catch:{ all -> 0x00d9 }
            boolean r2 = r2 instanceof java.lang.String     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x00d9
            r2 = 2
            r3 = r11[r2]     // Catch:{ all -> 0x00d9 }
            boolean r3 = r3 instanceof android.content.Intent     // Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x00d9
            r2 = r11[r2]     // Catch:{ all -> 0x00d9 }
            android.content.Intent r2 = (android.content.Intent) r2     // Catch:{ all -> 0x00d9 }
            java.lang.String r3 = "android.intent.action.VIEW"
            java.lang.String r4 = r2.getAction()     // Catch:{ all -> 0x00d9 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x00d9
            java.lang.String r3 = "application/vnd.android.package-archive"
            java.lang.String r4 = r2.getType()     // Catch:{ all -> 0x00d9 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x00d9
            boolean r3 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28933c()     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = "null"
            java.lang.String r5 = "com.android.settings"
            if (r3 == 0) goto L_0x0058
            org.json.JSONObject r9 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = "hook_vivo_arg"
            java.lang.String r9 = r9.optString(r0, r5)     // Catch:{ all -> 0x00d9 }
            boolean r0 = r4.equals(r9)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00d9
            r11[r1] = r9     // Catch:{ all -> 0x00d9 }
            goto L_0x00d9
        L_0x0058:
            boolean r3 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28934d()     // Catch:{ all -> 0x00d9 }
            if (r3 == 0) goto L_0x00b0
            org.json.JSONObject r3 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r6 = "hook_oppo_arg1"
            java.lang.String r3 = r3.optString(r6, r5)     // Catch:{ all -> 0x00d9 }
            boolean r4 = r4.equals(r3)     // Catch:{ all -> 0x00d9 }
            if (r4 != 0) goto L_0x0070
            r11[r1] = r3     // Catch:{ all -> 0x00d9 }
        L_0x0070:
            org.json.JSONObject r3 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = "hook_oppo_arg2"
            java.lang.String r5 = "com.android.browser"
            java.lang.String r3 = r3.optString(r4, r5)     // Catch:{ all -> 0x00d9 }
            org.json.JSONObject r4 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r5 = "hook_oppo_arg3"
            java.lang.String r6 = "m.store.oppomobile.com"
            java.lang.String r4 = r4.optString(r5, r6)     // Catch:{ all -> 0x00d9 }
            r2.putExtra(r0, r3)     // Catch:{ all -> 0x00d9 }
            r2.putExtra(r9, r4)     // Catch:{ all -> 0x00d9 }
            org.json.JSONObject r5 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r6 = "hook_oppo_arg4"
            r7 = 0
            int r5 = r5.optInt(r6, r7)     // Catch:{ all -> 0x00d9 }
            if (r5 != r1) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r1 = 0
        L_0x009d:
            if (r1 == 0) goto L_0x00d9
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x00d9 }
            r1.<init>()     // Catch:{ all -> 0x00d9 }
            r1.putExtra(r0, r3)     // Catch:{ all -> 0x00d9 }
            r1.putExtra(r9, r4)     // Catch:{ all -> 0x00d9 }
            java.lang.String r9 = "android.intent.extra.INTENT"
            r2.putExtra(r9, r1)     // Catch:{ all -> 0x00d9 }
            goto L_0x00d9
        L_0x00b0:
            boolean r9 = com.p530ss.android.socialbase.downloader.p569m.C6792i.m28929a()     // Catch:{ all -> 0x00d9 }
            if (r9 == 0) goto L_0x00d9
            org.json.JSONObject r9 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r0 = "hook_huawei_arg1"
            java.lang.String r9 = r9.optString(r0, r5)     // Catch:{ all -> 0x00d9 }
            boolean r0 = r4.equals(r9)     // Catch:{ all -> 0x00d9 }
            if (r0 != 0) goto L_0x00c8
            r11[r1] = r9     // Catch:{ all -> 0x00d9 }
        L_0x00c8:
            java.lang.String r9 = "caller_package"
            org.json.JSONObject r0 = com.p530ss.android.downloadlib.p541a.C6565j.m26375i()     // Catch:{ all -> 0x00d9 }
            java.lang.String r1 = "hook_huawei_arg2"
            java.lang.String r3 = "com.huawei.appmarket"
            java.lang.String r0 = r0.optString(r1, r3)     // Catch:{ all -> 0x00d9 }
            r2.putExtra(r9, r0)     // Catch:{ all -> 0x00d9 }
        L_0x00d9:
            java.lang.Object r9 = r8.f21427a     // Catch:{ all -> 0x00e0 }
            java.lang.Object r9 = r10.invoke(r9, r11)     // Catch:{ all -> 0x00e0 }
            return r9
        L_0x00e0:
            r9 = move-exception
            java.lang.Throwable r9 = r8.m26484a(r9)
            throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p549e.AntiHijackUtils.C6582a.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0046 A[Catch:{ all -> 0x009a }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0082 A[Catch:{ all -> 0x009a }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0083 A[Catch:{ all -> 0x009a }] */
        /* renamed from: a */
        private java.lang.Throwable m26484a(java.lang.Throwable r8) {
            /*
            r7 = this;
            java.lang.StackTraceElement[] r0 = r8.getStackTrace()     // Catch:{ all -> 0x009a }
            boolean r1 = r8 instanceof java.lang.reflect.InvocationTargetException     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x0020
            r1 = r8
            java.lang.reflect.InvocationTargetException r1 = (java.lang.reflect.InvocationTargetException) r1     // Catch:{ all -> 0x009a }
            java.lang.Throwable r2 = r1.getTargetException()     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x001a
            java.lang.Throwable r8 = r1.getTargetException()     // Catch:{ all -> 0x009a }
            java.lang.StackTraceElement[] r0 = r8.getStackTrace()     // Catch:{ all -> 0x009a }
            goto L_0x003c
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            goto L_0x003b
        L_0x0020:
            boolean r1 = r8 instanceof java.lang.reflect.UndeclaredThrowableException     // Catch:{ all -> 0x009a }
            if (r1 == 0) goto L_0x003c
            r1 = r8
            java.lang.reflect.UndeclaredThrowableException r1 = (java.lang.reflect.UndeclaredThrowableException) r1     // Catch:{ all -> 0x009a }
            java.lang.Throwable r2 = r1.getUndeclaredThrowable()     // Catch:{ all -> 0x009a }
            if (r2 == 0) goto L_0x0036
            java.lang.Throwable r8 = r1.getUndeclaredThrowable()     // Catch:{ all -> 0x009a }
            java.lang.StackTraceElement[] r0 = r8.getStackTrace()     // Catch:{ all -> 0x009a }
            goto L_0x003c
        L_0x0036:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
        L_0x003b:
            r8 = r1
        L_0x003c:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            r2 = 0
            r3 = 0
        L_0x0043:
            int r4 = r0.length     // Catch:{ all -> 0x009a }
            if (r3 >= r4) goto L_0x007c
            r4 = r0[r3]     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x004b
            goto L_0x0079
        L_0x004b:
            java.lang.String r5 = r4.getClassName()     // Catch:{ all -> 0x009a }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x0076
            java.lang.String r6 = "com.ss.android.downloadlib"
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x0079
            java.lang.Class<java.lang.reflect.Proxy> r6 = java.lang.reflect.Proxy.class
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x009a }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x009a }
            if (r6 != 0) goto L_0x0079
            java.lang.Class<java.lang.reflect.Method> r6 = java.lang.reflect.Method.class
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x009a }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x0076
            goto L_0x0079
        L_0x0076:
            r1.add(r4)     // Catch:{ all -> 0x009a }
        L_0x0079:
            int r3 = r3 + 1
            goto L_0x0043
        L_0x007c:
            boolean r0 = r1.isEmpty()     // Catch:{ all -> 0x009a }
            if (r0 == 0) goto L_0x0083
            return r8
        L_0x0083:
            int r0 = r1.size()     // Catch:{ all -> 0x009a }
            java.lang.StackTraceElement[] r0 = new java.lang.StackTraceElement[r0]     // Catch:{ all -> 0x009a }
        L_0x0089:
            int r3 = r0.length     // Catch:{ all -> 0x009a }
            if (r2 >= r3) goto L_0x0097
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x009a }
            java.lang.StackTraceElement r3 = (java.lang.StackTraceElement) r3     // Catch:{ all -> 0x009a }
            r0[r2] = r3     // Catch:{ all -> 0x009a }
            int r2 = r2 + 1
            goto L_0x0089
        L_0x0097:
            r8.setStackTrace(r0)     // Catch:{ all -> 0x009a }
        L_0x009a:
            return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p549e.AntiHijackUtils.C6582a.m26484a(java.lang.Throwable):java.lang.Throwable");
        }
    }

    /* renamed from: a */
    public static String m26480a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.length() <= 70000000) {
            return C6587g.m26512a(file);
        }
        return null;
    }

    /* renamed from: b */
    public static String m26482b(String str) {
        return m26480a(m26483c(str));
    }

    /* renamed from: c */
    public static String m26483c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = C6565j.m26357a().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: a */
    public static void m26481a() {
        Field field;
        try {
            if (VERSION.SDK_INT < 26) {
                field = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                field = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            field.setAccessible(true);
            Object obj = field.get(null);
            Field declaredField = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                Class cls = Class.forName("android.app.IActivityManager");
                if (cls != null) {
                    C6582a aVar = new C6582a(obj2);
                    declaredField.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, aVar));
                }
            }
        } catch (Throwable unused) {
        }
    }
}
