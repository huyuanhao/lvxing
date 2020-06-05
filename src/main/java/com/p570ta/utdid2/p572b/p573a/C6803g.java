package com.p570ta.utdid2.p572b.p573a;

import java.util.Random;

/* compiled from: PhoneInfoUtils */
/* renamed from: com.ta.utdid2.b.a.g */
public class C6803g {
    /* renamed from: c */
    public static final String m29031c() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = C6801e.getBytes(currentTimeMillis);
        byte[] bytes2 = C6801e.getBytes(nanoTime);
        byte[] bytes3 = C6801e.getBytes(nextInt);
        byte[] bytes4 = C6801e.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return C6797b.encodeToString(bArr, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    public static java.lang.String m29029a(android.content.Context r1) {
        /*
        if (r1 == 0) goto L_0x0011
        java.lang.String r0 = "phone"
        java.lang.Object r1 = r1.getSystemService(r0)     // Catch:{ Exception -> 0x0011 }
        android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x0011 }
        if (r1 == 0) goto L_0x0011
        java.lang.String r1 = r1.getDeviceId()     // Catch:{ Exception -> 0x0011 }
        goto L_0x0012
    L_0x0011:
        r1 = 0
    L_0x0012:
        boolean r0 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r1)
        if (r0 == 0) goto L_0x001c
        java.lang.String r1 = m29031c()
    L_0x001c:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p572b.p573a.C6803g.m29029a(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    public static java.lang.String m29030b(android.content.Context r1) {
        /*
        if (r1 == 0) goto L_0x0011
        java.lang.String r0 = "phone"
        java.lang.Object r1 = r1.getSystemService(r0)     // Catch:{ Exception -> 0x0011 }
        android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ Exception -> 0x0011 }
        if (r1 == 0) goto L_0x0011
        java.lang.String r1 = r1.getSubscriberId()     // Catch:{ Exception -> 0x0011 }
        goto L_0x0012
    L_0x0011:
        r1 = 0
    L_0x0012:
        boolean r0 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r1)
        if (r0 == 0) goto L_0x001c
        java.lang.String r1 = m29031c()
    L_0x001c:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p572b.p573a.C6803g.m29030b(android.content.Context):java.lang.String");
    }
}
