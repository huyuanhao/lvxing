package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.stat.common.DeviceInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.alibaba.wireless.security.framework.utils.a */
public class C1347a {
    /* renamed from: a */
    private static Context f3519a;
    /* renamed from: b */
    private static String f3520b;
    /* renamed from: c */
    private static int f3521c;
    /* renamed from: d */
    private static int f3522d;
    /* renamed from: e */
    private static int f3523e;
    /* renamed from: f */
    private static int f3524f;
    /* renamed from: g */
    private static Class f3525g;
    /* renamed from: h */
    private static Class f3526h;
    /* renamed from: i */
    private static Class f3527i;
    /* renamed from: j */
    private static Constructor f3528j;
    /* renamed from: k */
    private static Method f3529k;
    /* renamed from: l */
    private static Method f3530l;
    /* renamed from: m */
    private static Method f3531m;
    /* renamed from: n */
    private static Method f3532n;
    /* renamed from: o */
    private static final char[] f3533o = "0123456789abcdef".toCharArray();

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    public static int m3971a() {
        /*
        int r0 = f3524f
        if (r0 != 0) goto L_0x0089
        java.lang.Class<com.alibaba.wireless.security.framework.utils.a> r0 = com.alibaba.wireless.security.framework.utils.C1347a.class
        monitor-enter(r0)
        int r1 = f3524f     // Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0084
        r1 = 1
        java.lang.String r2 = "com.ut.mini.c.a"
        java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
        f3525g = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
        java.lang.String r2 = "com.ut.mini.b"
        java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
        f3526h = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
        java.lang.String r2 = "com.ut.mini.f"
        java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0082 }
        f3527i = r2     // Catch:{ ClassNotFoundException -> 0x0082 }
        java.lang.Class r2 = f3525g     // Catch:{  }
        r3 = 6
        java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{  }
        java.lang.Class<java.lang.String> r4 = java.lang.String.class
        r5 = 0
        r3[r5] = r4     // Catch:{  }
        java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{  }
        r3[r1] = r4     // Catch:{  }
        r4 = 2
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        r3[r4] = r6     // Catch:{  }
        r4 = 3
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        r3[r4] = r6     // Catch:{  }
        r4 = 4
        java.lang.Class<java.lang.String> r6 = java.lang.String.class
        r3[r4] = r6     // Catch:{  }
        r4 = 5
        java.lang.Class<java.util.Map> r6 = java.util.Map.class
        r3[r4] = r6     // Catch:{  }
        java.lang.reflect.Constructor r2 = r2.getConstructor(r3)     // Catch:{  }
        f3528j = r2     // Catch:{  }
        java.lang.Class r2 = f3525g     // Catch:{  }
        java.lang.String r3 = "build"
        java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
        f3529k = r2     // Catch:{  }
        java.lang.Class r2 = f3526h     // Catch:{  }
        java.lang.String r3 = "getInstance"
        java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
        f3530l = r2     // Catch:{  }
        java.lang.Class r2 = f3526h     // Catch:{  }
        java.lang.String r3 = "getDefaultTracker"
        java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{  }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
        f3531m = r2     // Catch:{  }
        java.lang.Class r2 = f3527i     // Catch:{  }
        java.lang.String r3 = "send"
        java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{  }
        java.lang.Class<java.util.Map> r6 = java.util.Map.class
        r4[r5] = r6     // Catch:{  }
        java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{  }
        f3532n = r2     // Catch:{  }
        f3523e = r1     // Catch:{ all -> 0x0086 }
    L_0x0082:
        f3524f = r1     // Catch:{ all -> 0x0086 }
    L_0x0084:
        monitor-exit(r0)     // Catch:{ all -> 0x0086 }
        goto L_0x0089
    L_0x0086:
        r1 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0086 }
        throw r1
    L_0x0089:
        int r0 = f3523e
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.C1347a.m3971a():int");
    }

    /* renamed from: a */
    public static int m3972a(String str, int i, int i2, String str2, long j, String str3, String str4, String str5, String str6, String str7) {
        if (!(m3971a() == 0 || str == null || str.length() == 0)) {
            String str8 = "Page_SecurityGuardSDK";
            String str9 = str2 != null ? str2 : "";
            try {
                String valueOf = String.valueOf(i % 100);
                HashMap hashMap = new HashMap();
                hashMap.put("plugin", String.valueOf(i2));
                hashMap.put("pid", String.valueOf(Process.myPid()));
                hashMap.put("tid", String.valueOf(Thread.currentThread().getId()));
                hashMap.put("time", String.valueOf(j));
                if (f3522d == 0) {
                    f3521c = C1352f.m3994c(f3519a) ? 1 : 0;
                    f3522d = 1;
                }
                hashMap.put(DeviceInfo.TAG_IMEI, String.valueOf(f3521c));
                hashMap.put("sid", m3976b());
                hashMap.put("uuid", m3977c());
                hashMap.put(NotificationCompat.CATEGORY_MESSAGE, m3973a(str3));
                hashMap.put("rsv1", m3973a(str4));
                hashMap.put("rsv2", m3973a(str5));
                hashMap.put("rsv3", m3973a(str6));
                hashMap.put("rsv4", m3973a(str7));
                Object newInstance = f3528j.newInstance(new Object[]{str8, Integer.valueOf(19999), str, str9, valueOf, hashMap});
                if (newInstance != null) {
                    Map map = (Map) f3529k.invoke(newInstance, new Object[0]);
                    if (map != null) {
                        if (map.size() != 0) {
                            Object invoke = f3530l.invoke(f3526h, new Object[0]);
                            if (invoke != null) {
                                Object invoke2 = f3531m.invoke(invoke, new Object[0]);
                                if (invoke2 != null) {
                                    f3532n.invoke(invoke2, new Object[]{map});
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static String m3973a(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m3974a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            int i2 = i * 2;
            char[] cArr2 = f3533o;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static void m3975a(Context context) {
        if (context != null) {
            f3519a = context;
        }
    }

    /* renamed from: b */
    private static synchronized String m3976b() {
        String substring;
        synchronized (C1347a.class) {
            if (f3520b == null || f3520b.length() == 0) {
                f3520b = m3977c();
            }
            substring = f3520b.substring(0, f3520b.length() / 8);
        }
        return substring;
    }

    /* renamed from: c */
    private static String m3977c() {
        try {
            String uuid = UUID.randomUUID().toString();
            String valueOf = String.valueOf(System.nanoTime());
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            StringBuilder sb = new StringBuilder();
            sb.append(uuid);
            sb.append(valueOf);
            return m3974a(instance.digest(sb.toString().getBytes("UTF-8")));
        } catch (Exception unused) {
            return "";
        }
    }
}
