package com.qiyukf.unicorn.p499b;

import android.content.Context;
import com.qiyukf.unicorn.api.YSFOptions;
import java.io.Serializable;

/* renamed from: com.qiyukf.unicorn.b.a */
public final class C6013a implements Serializable {
    /* renamed from: a */
    private String f18818a;
    /* renamed from: b */
    private YSFOptions f18819b;

    private C6013a(String str, YSFOptions ySFOptions) {
        this.f18818a = str;
        this.f18819b = ySFOptions;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r5.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
            if (r2 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0047, code lost:
            r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r1.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004b, code lost:
            throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
            r5 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0021, B:17:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* renamed from: a */
    public static synchronized com.qiyukf.unicorn.p499b.C6013a m23916a(android.content.Context r5) {
        /*
        java.lang.Class<com.qiyukf.unicorn.b.a> r0 = com.qiyukf.unicorn.p499b.C6013a.class
        monitor-enter(r0)
        r1 = 0
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x002d }
        java.lang.String r5 = m23918b(r5)     // Catch:{ all -> 0x002d }
        r2.<init>(r5)     // Catch:{ all -> 0x002d }
        java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ all -> 0x002b }
        r5.<init>(r2)     // Catch:{ all -> 0x002b }
        java.lang.String r3 = r5.readUTF()     // Catch:{ all -> 0x002b }
        java.lang.Object r5 = r5.readObject()     // Catch:{ all -> 0x002b }
        com.qiyukf.unicorn.api.YSFOptions r5 = (com.qiyukf.unicorn.api.YSFOptions) r5     // Catch:{ all -> 0x002b }
        com.qiyukf.unicorn.b.a r4 = new com.qiyukf.unicorn.b.a     // Catch:{ all -> 0x002b }
        r4.m50307init(r3, r5)     // Catch:{ all -> 0x002b }
        r2.close()     // Catch:{ IOException -> 0x0025 }
        goto L_0x0029
    L_0x0025:
        r5 = move-exception
        r5.printStackTrace()     // Catch:{ all -> 0x0038 }
    L_0x0029:
        monitor-exit(r0)
        return r4
    L_0x002b:
        r5 = move-exception
        goto L_0x002f
    L_0x002d:
        r5 = move-exception
        r2 = r1
    L_0x002f:
        r5.printStackTrace()     // Catch:{ all -> 0x0040 }
        if (r2 == 0) goto L_0x003e
        r2.close()     // Catch:{ IOException -> 0x003a }
        goto L_0x003e
    L_0x0038:
        r5 = move-exception
        goto L_0x004c
    L_0x003a:
        r5 = move-exception
        r5.printStackTrace()     // Catch:{ all -> 0x0038 }
    L_0x003e:
        monitor-exit(r0)
        return r1
    L_0x0040:
        r5 = move-exception
        if (r2 == 0) goto L_0x004b
        r2.close()     // Catch:{ IOException -> 0x0047 }
        goto L_0x004b
    L_0x0047:
        r1 = move-exception
        r1.printStackTrace()     // Catch:{ all -> 0x0038 }
    L_0x004b:
        throw r5     // Catch:{ all -> 0x0038 }
    L_0x004c:
        monitor-exit(r0)
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p499b.C6013a.m23916a(android.content.Context):com.qiyukf.unicorn.b.a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r3.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003b, code lost:
            r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x003c, code lost:
            if (r2 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0042, code lost:
            r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0046, code lost:
            throw r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x0018, B:19:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002c A[SYNTHETIC, Splitter:B:22:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0039 A[DONT_GENERATE] */
    /* renamed from: a */
    public static synchronized void m23917a(android.content.Context r3, java.lang.String r4, com.qiyukf.unicorn.api.YSFOptions r5) {
        /*
        java.lang.Class<com.qiyukf.unicorn.b.a> r0 = com.qiyukf.unicorn.p499b.C6013a.class
        monitor-enter(r0)
        r1 = 0
        java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0025 }
        java.lang.String r3 = m23918b(r3)     // Catch:{ all -> 0x0025 }
        r2.<init>(r3)     // Catch:{ all -> 0x0025 }
        java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0023 }
        r3.<init>(r2)     // Catch:{ all -> 0x0023 }
        r3.writeUTF(r4)     // Catch:{ all -> 0x0023 }
        r3.writeObject(r5)     // Catch:{ all -> 0x0023 }
        r2.close()     // Catch:{ IOException -> 0x001d }
        monitor-exit(r0)
        return
    L_0x001d:
        r3 = move-exception
        r3.printStackTrace()     // Catch:{ all -> 0x0031 }
        monitor-exit(r0)
        return
    L_0x0023:
        r3 = move-exception
        goto L_0x0027
    L_0x0025:
        r3 = move-exception
        r2 = r1
    L_0x0027:
        r3.printStackTrace()     // Catch:{ all -> 0x003b }
        if (r2 == 0) goto L_0x0039
        r2.close()     // Catch:{ IOException -> 0x0033 }
        monitor-exit(r0)
        return
    L_0x0031:
        r3 = move-exception
        goto L_0x0047
    L_0x0033:
        r3 = move-exception
        r3.printStackTrace()     // Catch:{ all -> 0x0031 }
        monitor-exit(r0)
        return
    L_0x0039:
        monitor-exit(r0)
        return
    L_0x003b:
        r3 = move-exception
        if (r2 == 0) goto L_0x0046
        r2.close()     // Catch:{ IOException -> 0x0042 }
        goto L_0x0046
    L_0x0042:
        r4 = move-exception
        r4.printStackTrace()     // Catch:{ all -> 0x0031 }
    L_0x0046:
        throw r3     // Catch:{ all -> 0x0031 }
    L_0x0047:
        monitor-exit(r0)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p499b.C6013a.m23917a(android.content.Context, java.lang.String, com.qiyukf.unicorn.api.YSFOptions):void");
    }

    /* renamed from: b */
    private static String m23918b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().dataDir);
        sb.append("/unicorn#cheese#");
        return sb.toString();
    }

    /* renamed from: a */
    public final String mo28846a() {
        return this.f18818a;
    }

    /* renamed from: b */
    public final YSFOptions mo28847b() {
        return this.f18819b;
    }
}
