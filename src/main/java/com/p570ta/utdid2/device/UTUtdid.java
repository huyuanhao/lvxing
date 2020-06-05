package com.p570ta.utdid2.device;

import android.content.Context;
import android.provider.Settings.System;
import com.p570ta.utdid2.p572b.p573a.C6797b;
import com.p570ta.utdid2.p572b.p573a.C6801e;
import com.p570ta.utdid2.p572b.p573a.C6803g;
import com.p570ta.utdid2.p572b.p573a.C6804i;
import com.p570ta.utdid2.p574c.p575a.PersistentConfiguration;
import com.tencent.mid.core.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.ta.utdid2.device.c */
public class UTUtdid {
    /* renamed from: a */
    private static UTUtdid f22548a = null;
    /* renamed from: f */
    private static final Object f22549f = new Object();
    /* renamed from: o */
    private static final String f22550o;
    /* renamed from: a */
    private PersistentConfiguration f22551a = null;
    /* renamed from: a */
    private UTUtdidHelper f22552a = null;
    /* renamed from: a */
    private Pattern f22553a = Pattern.compile("[^0-9a-zA-Z=/+]+");
    /* renamed from: b */
    private PersistentConfiguration f22554b = null;
    /* renamed from: l */
    private String f22555l = null;
    /* renamed from: m */
    private String f22556m = "xx_utdid_key";
    private Context mContext = null;
    /* renamed from: n */
    private String f22557n = "xx_utdid_domain";

    static {
        StringBuilder sb = new StringBuilder(".UTSystemConfig");
        sb.append(File.separator);
        sb.append("Global");
        f22550o = sb.toString();
    }

    public UTUtdid(Context context) {
        this.mContext = context;
        PersistentConfiguration cVar = new PersistentConfiguration(context, f22550o, "Alvin2", false, true);
        this.f22554b = cVar;
        PersistentConfiguration cVar2 = new PersistentConfiguration(context, ".DataStorage", "ContextData", false, true);
        this.f22551a = cVar2;
        this.f22552a = new UTUtdidHelper();
        this.f22556m = String.format("K_%d", new Object[]{Integer.valueOf(C6804i.m29033a(this.f22556m))});
        this.f22557n = String.format("D_%d", new Object[]{Integer.valueOf(C6804i.m29033a(this.f22557n))});
    }

    /* renamed from: d */
    private void m29109d() {
        PersistentConfiguration cVar = this.f22554b;
        if (cVar != null) {
            if (C6804i.m29033a(cVar.getString("UTDID2"))) {
                String string = this.f22554b.getString("UTDID");
                if (!C6804i.m29033a(string)) {
                    m29110f(string);
                }
            }
            boolean z = false;
            String str = "DID";
            if (!C6804i.m29033a(this.f22554b.getString(str))) {
                this.f22554b.remove(str);
                z = true;
            }
            String str2 = "EI";
            if (!C6804i.m29033a(this.f22554b.getString(str2))) {
                this.f22554b.remove(str2);
                z = true;
            }
            String str3 = "SI";
            if (!C6804i.m29033a(this.f22554b.getString(str3))) {
                this.f22554b.remove(str3);
                z = true;
            }
            if (z) {
                this.f22554b.commit();
            }
        }
    }

    /* renamed from: a */
    public static UTUtdid m29105a(Context context) {
        if (context != null && f22548a == null) {
            synchronized (f22549f) {
                if (f22548a == null) {
                    f22548a = new UTUtdid(context);
                    f22548a.m29109d();
                }
            }
        }
        return f22548a;
    }

    /* renamed from: f */
    private void m29110f(String str) {
        if (m29108b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24) {
                PersistentConfiguration cVar = this.f22554b;
                if (cVar != null) {
                    cVar.putString("UTDID2", str);
                    this.f22554b.commit();
                }
            }
        }
    }

    /* renamed from: g */
    private void m29112g(String str) {
        if (str != null) {
            PersistentConfiguration cVar = this.f22551a;
            if (cVar != null && !str.equals(cVar.getString(this.f22556m))) {
                this.f22551a.putString(this.f22556m, str);
                this.f22551a.commit();
            }
        }
    }

    /* renamed from: h */
    private void m29113h(String str) {
        String str2 = "mqBRboGZkQPcAkyk";
        if (this.mContext.checkCallingOrSelfPermission(Constants.PERMISSION_WRITE_SETTINGS) == 0 && m29108b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str3 = null;
                try {
                    str3 = System.getString(this.mContext.getContentResolver(), str2);
                } catch (Exception unused) {
                }
                if (!m29108b(str3)) {
                    try {
                        System.putString(this.mContext.getContentResolver(), str2, str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private void m29114i(String str) {
        String str2;
        String str3 = "dxCRMxhQkdGePGnp";
        try {
            str2 = System.getString(this.mContext.getContentResolver(), str3);
        } catch (Exception unused) {
            str2 = null;
        }
        if (!str.equals(str2)) {
            try {
                System.putString(this.mContext.getContentResolver(), str3, str);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: j */
    private void m29115j(String str) {
        if (this.mContext.checkCallingOrSelfPermission(Constants.PERMISSION_WRITE_SETTINGS) == 0 && str != null) {
            m29114i(str);
        }
    }

    /* renamed from: g */
    private String m29111g() {
        PersistentConfiguration cVar = this.f22554b;
        if (cVar != null) {
            String string = cVar.getString("UTDID2");
            if (!C6804i.m29033a(string) && this.f22552a.mo32716a(string) != null) {
                return string;
            }
        }
        return null;
    }

    /* renamed from: b */
    private boolean m29108b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.f22553a.matcher(str).find();
        }
    }

    public synchronized String getValue() {
        if (this.f22555l != null) {
            return this.f22555l;
        }
        return mo32715h();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072 A[Catch:{ Exception -> 0x0109 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017 A[SYNTHETIC, Splitter:B:9:0x0017] */
    /* renamed from: h */
    public synchronized java.lang.String mo32715h() {
        /*
        r6 = this;
        monitor-enter(r6)
        java.lang.String r0 = ""
        android.content.Context r1 = r6.mContext     // Catch:{ Exception -> 0x000f }
        android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x000f }
        java.lang.String r2 = "mqBRboGZkQPcAkyk"
        java.lang.String r0 = android.provider.Settings.System.getString(r1, r2)     // Catch:{ Exception -> 0x000f }
    L_0x000f:
        boolean r1 = r6.m29108b(r0)     // Catch:{ all -> 0x010f }
        if (r1 == 0) goto L_0x0017
        monitor-exit(r6)
        return r0
    L_0x0017:
        com.ta.utdid2.device.e r0 = new com.ta.utdid2.device.e     // Catch:{ all -> 0x010f }
        r0.m51755init()     // Catch:{ all -> 0x010f }
        r1 = 0
        r2 = 0
        android.content.Context r3 = r6.mContext     // Catch:{ Exception -> 0x002b }
        android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ Exception -> 0x002b }
        java.lang.String r4 = "dxCRMxhQkdGePGnp"
        java.lang.String r3 = android.provider.Settings.System.getString(r3, r4)     // Catch:{ Exception -> 0x002b }
        goto L_0x002c
    L_0x002b:
        r3 = r2
    L_0x002c:
        boolean r4 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r3)     // Catch:{ all -> 0x010f }
        if (r4 != 0) goto L_0x0083
        java.lang.String r4 = r0.mo32720c(r3)     // Catch:{ all -> 0x010f }
        boolean r5 = r6.m29108b(r4)     // Catch:{ all -> 0x010f }
        if (r5 == 0) goto L_0x0041
        r6.m29113h(r4)     // Catch:{ all -> 0x010f }
        monitor-exit(r6)
        return r4
    L_0x0041:
        java.lang.String r4 = r0.mo32719b(r3)     // Catch:{ all -> 0x010f }
        boolean r5 = r6.m29108b(r4)     // Catch:{ all -> 0x010f }
        if (r5 == 0) goto L_0x0066
        com.ta.utdid2.device.d r5 = r6.f22552a     // Catch:{ all -> 0x010f }
        java.lang.String r4 = r5.mo32716a(r4)     // Catch:{ all -> 0x010f }
        boolean r5 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r4)     // Catch:{ all -> 0x010f }
        if (r5 != 0) goto L_0x0066
        r6.m29115j(r4)     // Catch:{ all -> 0x010f }
        android.content.Context r4 = r6.mContext     // Catch:{ Exception -> 0x0066 }
        android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0066 }
        java.lang.String r5 = "dxCRMxhQkdGePGnp"
        java.lang.String r3 = android.provider.Settings.System.getString(r4, r5)     // Catch:{ Exception -> 0x0066 }
    L_0x0066:
        com.ta.utdid2.device.d r4 = r6.f22552a     // Catch:{ all -> 0x010f }
        java.lang.String r4 = r4.mo32717b(r3)     // Catch:{ all -> 0x010f }
        boolean r5 = r6.m29108b(r4)     // Catch:{ all -> 0x010f }
        if (r5 == 0) goto L_0x0084
        r6.f22555l = r4     // Catch:{ all -> 0x010f }
        r6.m29110f(r4)     // Catch:{ all -> 0x010f }
        r6.m29112g(r3)     // Catch:{ all -> 0x010f }
        java.lang.String r0 = r6.f22555l     // Catch:{ all -> 0x010f }
        r6.m29113h(r0)     // Catch:{ all -> 0x010f }
        java.lang.String r0 = r6.f22555l     // Catch:{ all -> 0x010f }
        monitor-exit(r6)
        return r0
    L_0x0083:
        r1 = 1
    L_0x0084:
        java.lang.String r3 = r6.m29111g()     // Catch:{ all -> 0x010f }
        boolean r4 = r6.m29108b(r3)     // Catch:{ all -> 0x010f }
        if (r4 == 0) goto L_0x00a3
        com.ta.utdid2.device.d r0 = r6.f22552a     // Catch:{ all -> 0x010f }
        java.lang.String r0 = r0.mo32716a(r3)     // Catch:{ all -> 0x010f }
        if (r1 == 0) goto L_0x0099
        r6.m29115j(r0)     // Catch:{ all -> 0x010f }
    L_0x0099:
        r6.m29113h(r3)     // Catch:{ all -> 0x010f }
        r6.m29112g(r0)     // Catch:{ all -> 0x010f }
        r6.f22555l = r3     // Catch:{ all -> 0x010f }
        monitor-exit(r6)
        return r3
    L_0x00a3:
        com.ta.utdid2.c.a.c r3 = r6.f22551a     // Catch:{ all -> 0x010f }
        java.lang.String r4 = r6.f22556m     // Catch:{ all -> 0x010f }
        java.lang.String r3 = r3.getString(r4)     // Catch:{ all -> 0x010f }
        boolean r4 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r3)     // Catch:{ all -> 0x010f }
        if (r4 != 0) goto L_0x00e3
        java.lang.String r0 = r0.mo32719b(r3)     // Catch:{ all -> 0x010f }
        boolean r4 = r6.m29108b(r0)     // Catch:{ all -> 0x010f }
        if (r4 != 0) goto L_0x00c1
        com.ta.utdid2.device.d r0 = r6.f22552a     // Catch:{ all -> 0x010f }
        java.lang.String r0 = r0.mo32717b(r3)     // Catch:{ all -> 0x010f }
    L_0x00c1:
        boolean r3 = r6.m29108b(r0)     // Catch:{ all -> 0x010f }
        if (r3 == 0) goto L_0x00e3
        com.ta.utdid2.device.d r3 = r6.f22552a     // Catch:{ all -> 0x010f }
        java.lang.String r3 = r3.mo32716a(r0)     // Catch:{ all -> 0x010f }
        boolean r4 = com.p570ta.utdid2.p572b.p573a.C6804i.m29033a(r0)     // Catch:{ all -> 0x010f }
        if (r4 != 0) goto L_0x00e3
        r6.f22555l = r0     // Catch:{ all -> 0x010f }
        if (r1 == 0) goto L_0x00da
        r6.m29115j(r3)     // Catch:{ all -> 0x010f }
    L_0x00da:
        java.lang.String r0 = r6.f22555l     // Catch:{ all -> 0x010f }
        r6.m29110f(r0)     // Catch:{ all -> 0x010f }
        java.lang.String r0 = r6.f22555l     // Catch:{ all -> 0x010f }
        monitor-exit(r6)
        return r0
    L_0x00e3:
        byte[] r0 = r6.m29106a()     // Catch:{ Exception -> 0x0109 }
        if (r0 == 0) goto L_0x010d
        r3 = 2
        java.lang.String r3 = com.p570ta.utdid2.p572b.p573a.C6797b.encodeToString(r0, r3)     // Catch:{ Exception -> 0x0109 }
        r6.f22555l = r3     // Catch:{ Exception -> 0x0109 }
        java.lang.String r3 = r6.f22555l     // Catch:{ Exception -> 0x0109 }
        r6.m29110f(r3)     // Catch:{ Exception -> 0x0109 }
        com.ta.utdid2.device.d r3 = r6.f22552a     // Catch:{ Exception -> 0x0109 }
        java.lang.String r0 = r3.mo32718c(r0)     // Catch:{ Exception -> 0x0109 }
        if (r0 == 0) goto L_0x0105
        if (r1 == 0) goto L_0x0102
        r6.m29115j(r0)     // Catch:{ Exception -> 0x0109 }
    L_0x0102:
        r6.m29112g(r0)     // Catch:{ Exception -> 0x0109 }
    L_0x0105:
        java.lang.String r0 = r6.f22555l     // Catch:{ Exception -> 0x0109 }
        monitor-exit(r6)
        return r0
    L_0x0109:
        r0 = move-exception
        r0.printStackTrace()     // Catch:{ all -> 0x010f }
    L_0x010d:
        monitor-exit(r6)
        return r2
    L_0x010f:
        r0 = move-exception
        monitor-exit(r6)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.device.UTUtdid.mo32715h():java.lang.String");
    }

    /* renamed from: a */
    private final byte[] m29106a() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = C6801e.getBytes(currentTimeMillis);
        byte[] bytes2 = C6801e.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = C6803g.m29029a(this.mContext);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(new Random().nextInt());
            str = sb.toString();
        }
        byteArrayOutputStream.write(C6801e.getBytes(C6804i.m29033a(str)), 0, 4);
        byteArrayOutputStream.write(C6801e.getBytes(C6804i.m29033a(m29107b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    private static String m29107b(byte[] bArr) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        return C6797b.encodeToString(instance.doFinal(bArr), 2);
    }
}
