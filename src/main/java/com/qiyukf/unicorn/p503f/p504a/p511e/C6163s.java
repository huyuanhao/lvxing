package com.qiyukf.unicorn.p503f.p504a.p511e;

import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6110a;
import com.qiyukf.unicorn.p503f.p504a.p508b.C6111b;
import java.net.NetworkInterface;
import java.util.Collections;

@C6111b(mo29052a = 208)
/* renamed from: com.qiyukf.unicorn.f.a.e.s */
public final class C6163s extends C6144e {
    @C6110a(mo29051a = "appKey")
    /* renamed from: a */
    private String f19265a;
    @C6110a(mo29051a = "deviceId")
    /* renamed from: b */
    private String f19266b;
    @C6110a(mo29051a = "source")
    /* renamed from: c */
    private int f19267c;
    @C6110a(mo29051a = "imei")
    /* renamed from: d */
    private String f19268d;
    @C6110a(mo29051a = "mac")
    /* renamed from: e */
    private String f19269e;
    @C6110a(mo29051a = "androidId")
    /* renamed from: f */
    private String f19270f;
    @C6110a(mo29051a = "brand")
    /* renamed from: g */
    private String f19271g;
    @C6110a(mo29051a = "model")
    /* renamed from: h */
    private String f19272h;
    @C6110a(mo29051a = "os")
    /* renamed from: i */
    private String f19273i;
    @C6110a(mo29051a = "timestamp")
    /* renamed from: j */
    private long f19274j;

    public C6163s() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0039, code lost:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x003e;
     */
    public C6163s(android.content.Context r3) {
        /*
        r2 = this;
        r2.m50426init()
        java.lang.String r0 = com.qiyukf.unicorn.C6029d.m24043d()
        r2.f19265a = r0
        java.lang.String r0 = com.qiyukf.unicorn.p499b.C6014b.m23948d()
        r2.f19266b = r0
        r0 = 1
        r2.f19267c = r0
        java.lang.String r0 = com.qiyukf.nimlib.p453d.p459b.p460a.C5764b.m23170c(r3)
        r2.f19268d = r0
        java.lang.String r0 = com.qiyukf.nimlib.p453d.p459b.p460a.C5764b.m23169b(r3)
        boolean r1 = android.text.TextUtils.isEmpty(r0)
        if (r1 != 0) goto L_0x002b
        java.lang.String r1 = "02:00:00:00:00:00"
        boolean r1 = r0.equalsIgnoreCase(r1)
        if (r1 != 0) goto L_0x002b
        goto L_0x003e
    L_0x002b:
        int r0 = android.os.Build.VERSION.SDK_INT
        r1 = 9
        if (r0 < r1) goto L_0x003c
        java.lang.String r0 = m24456a()
        boolean r1 = android.text.TextUtils.isEmpty(r0)
        if (r1 != 0) goto L_0x003c
        goto L_0x003e
    L_0x003c:
        java.lang.String r0 = ""
    L_0x003e:
        r2.f19269e = r0
        java.lang.String r3 = com.qiyukf.nimlib.p453d.p459b.p460a.C5764b.m23175h(r3)
        r2.f19270f = r3
        java.lang.String r3 = android.os.Build.BRAND
        r2.f19271g = r3
        java.lang.String r3 = android.os.Build.MODEL
        r2.f19272h = r3
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        java.lang.String r0 = "Android "
        r3.<init>(r0)
        java.lang.String r0 = android.os.Build.VERSION.RELEASE
        r3.append(r0)
        java.lang.String r3 = r3.toString()
        r2.f19273i = r3
        long r0 = java.lang.System.currentTimeMillis()
        r2.f19274j = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p503f.p504a.p511e.C6163s.m50446init(android.content.Context):void");
    }

    /* renamed from: a */
    private static String m24456a() {
        String str = "";
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
