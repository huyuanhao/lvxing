package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.p003os.EnvironmentCompat;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.utils.o */
public class InitChecker {

    /* compiled from: InitChecker */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.o$a */
    private static class C2559a {
        /* renamed from: a */
        String f9182a;
        /* renamed from: b */
        String f9183b;
        /* renamed from: c */
        String f9184c;

        C2559a(String str, String str2, String str3) {
            this.f9182a = str;
            this.f9183b = str2;
            this.f9184c = str3;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (!(obj instanceof C2559a)) {
                return super.equals(obj);
            }
            C2559a aVar = (C2559a) obj;
            String str = this.f9182a;
            if (str != null && str.equals(aVar.f9182a)) {
                String str2 = this.f9184c;
                if (str2 != null && str2.equals(aVar.f9184c)) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        }

        public String toString() {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("<");
                sb.append(this.f9182a);
                sb.append(" name=\"");
                sb.append(this.f9183b);
                sb.append("\" path=\"");
                sb.append(this.f9184c);
                sb.append("\" />");
                return sb.toString();
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x021c A[Catch:{ all -> 0x029f }] */
    /* renamed from: a */
    public static void m12193a() {
        /*
        android.content.Context r0 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()
        if (r0 != 0) goto L_0x0007
        return
    L_0x0007:
        boolean r1 = com.bytedance.sdk.openadsdk.utils.C2564t.m12224c()
        if (r1 != 0) goto L_0x000e
        return
    L_0x000e:
        java.lang.String r1 = m12191a(r0)
        java.lang.StringBuilder r2 = new java.lang.StringBuilder
        r2.<init>()
        java.lang.String r3 = "==当前进程名："
        r2.append(r3)
        r2.append(r1)
        java.lang.String r1 = r2.toString()
        java.lang.String r2 = "TTAdSdk-InitChecker"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)
        java.lang.String r1 = "==穿山甲sdk接入，环境为debug，初始化配置检测开始=="
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)
        java.lang.String r1 = r0.getPackageName()
        android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
        int r3 = r3.targetSdkVersion
        android.content.pm.PackageManager r4 = r0.getPackageManager()
        android.content.pm.ApplicationInfo r5 = r0.getApplicationInfo()
        java.lang.String r5 = r5.processName
        android.content.pm.ApplicationInfo r6 = r0.getApplicationInfo()
        int r6 = r6.uid
        r7 = 131072(0x20000, float:1.83671E-40)
        java.util.List r5 = r4.queryContentProviders(r5, r6, r7)
        java.util.Iterator r5 = r5.iterator()
        r6 = 0
        r7 = 0
        r8 = 0
    L_0x0054:
        boolean r9 = r5.hasNext()
        java.lang.String r10 = ", require="
        java.lang.String r11 = "&phone="
        if (r9 == 0) goto L_0x01b6
        java.lang.Object r9 = r5.next()
        android.content.pm.ProviderInfo r9 = (android.content.pm.ProviderInfo) r9
        java.lang.String r12 = r9.name
        java.lang.String r13 = "com.bytedance.sdk.openadsdk.multipro.TTMultiProvider"
        boolean r12 = r13.equals(r12)
        r13 = 1
        if (r12 == 0) goto L_0x009c
        java.lang.StringBuilder r7 = new java.lang.StringBuilder
        r7.<init>()
        r7.append(r1)
        java.lang.String r10 = ".TTMultiProvider"
        r7.append(r10)
        java.lang.String r7 = r7.toString()
        boolean r10 = android.text.TextUtils.isEmpty(r7)
        if (r10 != 0) goto L_0x0095
        java.lang.String r9 = r9.authority
        boolean r7 = r7.equals(r9)
        if (r7 != 0) goto L_0x008f
        goto L_0x0095
    L_0x008f:
        java.lang.String r7 = "AndroidManifest.xml中TTMultiProvider配置正常"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r7)
        goto L_0x009a
    L_0x0095:
        java.lang.String r7 = "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r7)
    L_0x009a:
        r7 = 1
        goto L_0x0054
    L_0x009c:
        java.lang.String r12 = r9.authority
        java.lang.StringBuilder r14 = new java.lang.StringBuilder
        r14.<init>()
        r14.append(r1)
        java.lang.String r15 = ".TTFileProvider"
        r14.append(r15)
        java.lang.String r14 = r14.toString()
        boolean r12 = r12.equals(r14)
        if (r12 == 0) goto L_0x0054
        int r8 = android.os.Build.VERSION.SDK_INT
        r12 = 24
        if (r8 < r12) goto L_0x0191
        if (r3 >= r12) goto L_0x00bf
        goto L_0x0191
    L_0x00bf:
        boolean r8 = r9.exported
        if (r8 == 0) goto L_0x00c8
        java.lang.String r8 = "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r8)
    L_0x00c8:
        boolean r8 = r9.grantUriPermissions
        if (r8 != 0) goto L_0x00d1
        java.lang.String r8 = "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r8)
    L_0x00d1:
        android.content.ComponentName r8 = new android.content.ComponentName     // Catch:{ all -> 0x018a }
        java.lang.String r9 = r9.name     // Catch:{ all -> 0x018a }
        r8.<init>(r1, r9)     // Catch:{ all -> 0x018a }
        r9 = 128(0x80, float:1.794E-43)
        android.content.pm.ProviderInfo r8 = r4.getProviderInfo(r8, r9)     // Catch:{ all -> 0x018a }
        android.os.Bundle r8 = r8.metaData     // Catch:{ all -> 0x018a }
        java.lang.String r9 = "android.support.FILE_PROVIDER_PATHS"
        java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x018a }
        java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x018a }
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018a }
        int r8 = r8.intValue()     // Catch:{ all -> 0x018a }
        java.util.List r8 = m12192a(r0, r8)     // Catch:{ all -> 0x018a }
        if (r8 == 0) goto L_0x0184
        boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x018a }
        if (r9 != 0) goto L_0x0184
        java.util.List r9 = m12195c()     // Catch:{ all -> 0x018a }
        java.util.List r10 = m12196d()     // Catch:{ all -> 0x018a }
        java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x018a }
    L_0x010a:
        boolean r11 = r8.hasNext()     // Catch:{ all -> 0x018a }
        if (r11 == 0) goto L_0x011f
        java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x018a }
        com.bytedance.sdk.openadsdk.utils.o$a r11 = (com.bytedance.sdk.openadsdk.utils.InitChecker.C2559a) r11     // Catch:{ all -> 0x018a }
        if (r11 == 0) goto L_0x010a
        r9.remove(r11)     // Catch:{ all -> 0x018a }
        r10.remove(r11)     // Catch:{ all -> 0x018a }
        goto L_0x010a
    L_0x011f:
        boolean r8 = r9.isEmpty()     // Catch:{ all -> 0x018a }
        if (r8 == 0) goto L_0x0132
        boolean r8 = r10.isEmpty()     // Catch:{ all -> 0x018a }
        if (r8 == 0) goto L_0x0132
        java.lang.String r8 = "AndroidManifest.xml中TTFileProvider配置正常"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r8)     // Catch:{ all -> 0x018a }
        goto L_0x01b3
    L_0x0132:
        java.util.Iterator r8 = r9.iterator()     // Catch:{ all -> 0x018a }
    L_0x0136:
        boolean r9 = r8.hasNext()     // Catch:{ all -> 0x018a }
        if (r9 == 0) goto L_0x015b
        java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x018a }
        com.bytedance.sdk.openadsdk.utils.o$a r9 = (com.bytedance.sdk.openadsdk.utils.InitChecker.C2559a) r9     // Catch:{ all -> 0x018a }
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
        r11.<init>()     // Catch:{ all -> 0x018a }
        java.lang.String r12 = "    TTFileProvider缺少必要路径："
        r11.append(r12)     // Catch:{ all -> 0x018a }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x018a }
        r11.append(r9)     // Catch:{ all -> 0x018a }
        java.lang.String r9 = r11.toString()     // Catch:{ all -> 0x018a }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r9)     // Catch:{ all -> 0x018a }
        goto L_0x0136
    L_0x015b:
        java.util.Iterator r8 = r10.iterator()     // Catch:{ all -> 0x018a }
    L_0x015f:
        boolean r9 = r8.hasNext()     // Catch:{ all -> 0x018a }
        if (r9 == 0) goto L_0x01b3
        java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x018a }
        com.bytedance.sdk.openadsdk.utils.o$a r9 = (com.bytedance.sdk.openadsdk.utils.InitChecker.C2559a) r9     // Catch:{ all -> 0x018a }
        java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x018a }
        r10.<init>()     // Catch:{ all -> 0x018a }
        java.lang.String r11 = "    TTFileProvider缺少可选路径："
        r10.append(r11)     // Catch:{ all -> 0x018a }
        java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x018a }
        r10.append(r9)     // Catch:{ all -> 0x018a }
        java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x018a }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r9)     // Catch:{ all -> 0x018a }
        goto L_0x015f
    L_0x0184:
        java.lang.String r8 = "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r8)     // Catch:{ all -> 0x018a }
        goto L_0x01b3
    L_0x018a:
        r8 = move-exception
        java.lang.String r9 = "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r2, r9, r8)
        goto L_0x01b3
    L_0x0191:
        java.lang.StringBuilder r8 = new java.lang.StringBuilder
        r8.<init>()
        java.lang.String r9 = "TTFileProvider不需要适配：target="
        r8.append(r9)
        r8.append(r3)
        r8.append(r11)
        int r9 = android.os.Build.VERSION.SDK_INT
        r8.append(r9)
        r8.append(r10)
        r8.append(r12)
        java.lang.String r8 = r8.toString()
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r8)
    L_0x01b3:
        r8 = 1
        goto L_0x0054
    L_0x01b6:
        r5 = 4096(0x1000, float:5.74E-42)
        android.content.pm.PackageInfo r1 = r4.getPackageInfo(r1, r5)     // Catch:{ all -> 0x0210 }
        java.lang.String[] r1 = r1.requestedPermissions     // Catch:{ all -> 0x0210 }
        if (r1 == 0) goto L_0x020a
        int r4 = r1.length     // Catch:{ all -> 0x0210 }
        if (r4 <= 0) goto L_0x020a
        java.util.List r4 = m12194b()     // Catch:{ all -> 0x0210 }
        int r5 = r1.length     // Catch:{ all -> 0x0210 }
    L_0x01c8:
        if (r6 >= r5) goto L_0x01d4
        r9 = r1[r6]     // Catch:{ all -> 0x0210 }
        if (r9 == 0) goto L_0x01d1
        r4.remove(r9)     // Catch:{ all -> 0x0210 }
    L_0x01d1:
        int r6 = r6 + 1
        goto L_0x01c8
    L_0x01d4:
        boolean r1 = r4.isEmpty()     // Catch:{ all -> 0x0210 }
        if (r1 == 0) goto L_0x01e0
        java.lang.String r1 = "AndroidManifest.xml中权限配置正常"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x0210 }
        goto L_0x0216
    L_0x01e0:
        java.util.Iterator r1 = r4.iterator()     // Catch:{ all -> 0x0210 }
    L_0x01e4:
        boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0210 }
        if (r4 == 0) goto L_0x0216
        java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0210 }
        java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0210 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0210 }
        r5.<init>()     // Catch:{ all -> 0x0210 }
        java.lang.String r6 = "    可能缺少权限："
        r5.append(r6)     // Catch:{ all -> 0x0210 }
        r5.append(r4)     // Catch:{ all -> 0x0210 }
        java.lang.String r4 = "，请参考接入文档"
        r5.append(r4)     // Catch:{ all -> 0x0210 }
        java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0210 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r4)     // Catch:{ all -> 0x0210 }
        goto L_0x01e4
    L_0x020a:
        java.lang.String r1 = "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x0210 }
        goto L_0x0216
    L_0x0210:
        r1 = move-exception
        java.lang.String r4 = "AndroidManifest.xml中uses-permission配置错误，请参考接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r2, r4, r1)
    L_0x0216:
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x029f }
        r4 = 23
        if (r1 < r4) goto L_0x027c
        if (r3 >= r4) goto L_0x021f
        goto L_0x027c
    L_0x021f:
        com.bytedance.sdk.openadsdk.core.f.d r1 = com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.m9560a()     // Catch:{ all -> 0x029f }
        java.lang.String r3 = "android.permission.READ_PHONE_STATE"
        boolean r1 = r1.mo15632a(r0, r3)     // Catch:{ all -> 0x029f }
        com.bytedance.sdk.openadsdk.core.f.d r3 = com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.m9560a()     // Catch:{ all -> 0x029f }
        java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
        boolean r3 = r3.mo15632a(r0, r4)     // Catch:{ all -> 0x029f }
        com.bytedance.sdk.openadsdk.core.f.d r4 = com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.m9560a()     // Catch:{ all -> 0x029f }
        java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
        boolean r4 = r4.mo15632a(r0, r5)     // Catch:{ all -> 0x029f }
        com.bytedance.sdk.openadsdk.core.f.d r5 = com.bytedance.sdk.openadsdk.core.p172f.PermissionsManager.m9560a()     // Catch:{ all -> 0x029f }
        java.lang.String r6 = "android.permission.WRITE_EXTERNAL_STORAGE"
        boolean r0 = r5.mo15632a(r0, r6)     // Catch:{ all -> 0x029f }
        if (r1 != 0) goto L_0x024f
        java.lang.String r1 = "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
        goto L_0x0254
    L_0x024f:
        java.lang.String r1 = "动态权限正常：android.permission.READ_PHONE_STATE"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
    L_0x0254:
        if (r3 != 0) goto L_0x025c
        java.lang.String r1 = "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
        goto L_0x0261
    L_0x025c:
        java.lang.String r1 = "动态权限正常：android.permission.ACCESS_COARSE_LOCATION"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
    L_0x0261:
        if (r4 != 0) goto L_0x0269
        java.lang.String r1 = "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
        goto L_0x026e
    L_0x0269:
        java.lang.String r1 = "动态权限正常：android.permission.ACCESS_FINE_LOCATION"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r1)     // Catch:{ all -> 0x029f }
    L_0x026e:
        if (r0 != 0) goto L_0x0276
        java.lang.String r0 = "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)     // Catch:{ all -> 0x029f }
        goto L_0x02a5
    L_0x0276:
        java.lang.String r0 = "动态权限正常：android.permission.WRITE_EXTERNAL_STORAGE"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)     // Catch:{ all -> 0x029f }
        goto L_0x02a5
    L_0x027c:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x029f }
        r0.<init>()     // Catch:{ all -> 0x029f }
        java.lang.String r1 = "动态权限不需要适配：target="
        r0.append(r1)     // Catch:{ all -> 0x029f }
        r0.append(r3)     // Catch:{ all -> 0x029f }
        r0.append(r11)     // Catch:{ all -> 0x029f }
        int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x029f }
        r0.append(r1)     // Catch:{ all -> 0x029f }
        r0.append(r10)     // Catch:{ all -> 0x029f }
        r0.append(r4)     // Catch:{ all -> 0x029f }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x029f }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)     // Catch:{ all -> 0x029f }
        goto L_0x02a5
    L_0x029f:
        r0 = move-exception
        java.lang.String r1 = "动态权限获取异常，请检查并详细阅读接入文档"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r2, r1, r0)
    L_0x02a5:
        if (r7 != 0) goto L_0x02ac
        java.lang.String r0 = "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)
    L_0x02ac:
        if (r8 != 0) goto L_0x02b3
        java.lang.String r0 = "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)
    L_0x02b3:
        java.lang.String r0 = "==穿山甲sdk初始化配置检测结束=="
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r2, r0)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.InitChecker.m12193a():void");
    }

    /* renamed from: a */
    private static String m12191a(Context context) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* renamed from: b */
    private static List<String> m12194b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mid.core.Constants.PERMISSION_INTERNET);
        arrayList.add(com.tencent.mid.core.Constants.PERMISSION_ACCESS_NETWORK_STATE);
        arrayList.add(com.tencent.mid.core.Constants.PERMISSION_ACCESS_WIFI_STATE);
        arrayList.add(com.tencent.mid.core.Constants.PERMISSION_READ_PHONE_STATE);
        arrayList.add(com.tencent.mid.core.Constants.PERMISSION_WRITE_EXTERNAL_STORAGE);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add("android.permission.GET_TASKS");
        arrayList.add("android.permission.WAKE_LOCK");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        return arrayList;
    }

    /* renamed from: c */
    private static List<C2559a> m12195c() {
        ArrayList arrayList = new ArrayList();
        String str = "Download";
        arrayList.add(new C2559a("external-path", "tt_external_download", str));
        arrayList.add(new C2559a("external-files-path", "tt_external_files_download", str));
        arrayList.add(new C2559a("files-path", "tt_internal_file_download", str));
        arrayList.add(new C2559a("cache-path", "tt_internal_cache_download", str));
        return arrayList;
    }

    /* renamed from: d */
    private static List<C2559a> m12196d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C2559a("external-path", "tt_external_root", "."));
        return arrayList;
    }

    /* renamed from: a */
    private static List<C2559a> m12192a(Context context, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            XmlResourceParser xml = context.getResources().getXml(i);
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        int attributeCount = xml.getAttributeCount();
                        String str = null;
                        String str2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xml.getAttributeName(i2);
                            if (attributeName.equals(ArgKey.KEY_NAME)) {
                                str = xml.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                str2 = xml.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            arrayList.add(new C2559a(name, str, str2));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }
}
