package com.tencent.android.tpush.stat.p597b;

import android.content.Context;
import android.os.Environment;
import com.tencent.android.tpush.stat.p596a.C7067d;
import com.tencent.android.tpush.stat.p596a.C7069f;
import com.tencent.mid.core.Constants;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.stat.b.b */
public class C7073b extends C7079h {
    /* renamed from: a */
    public int mo34177a() {
        return 2;
    }

    public C7073b(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo34179b() {
        return C7069f.m30292a(this.f23535b, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE) && Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo34180c() {
        String str;
        synchronized (this) {
            this.f23534a.mo34169b((Object) "read mid from InternalStorage");
            str = null;
            try {
                Iterator it = C7072a.m30310a(new File(Environment.getExternalStorageDirectory(), mo34201e())).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String[] split = ((String) it.next()).split(StorageInterface.KEY_SPLITER);
                    if (split.length == 2 && split[0].equals(mo34202f())) {
                        C7067d dVar = this.f23534a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("read mid from InternalStorage:");
                        sb.append(split[1]);
                        dVar.mo34169b((Object) sb.toString());
                        str = split[1];
                        break;
                    }
                }
            } catch (IOException e) {
                this.f23534a.mo34172d(e.toString());
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|5|6|7|8|9|21|22) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|(2:25|26)|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0081 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077 A[SYNTHETIC, Splitter:B:19:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e A[SYNTHETIC, Splitter:B:25:0x007e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0081=Splitter:B:27:0x0081, B:21:0x007a=Splitter:B:21:0x007a} */
    /* renamed from: a */
    public void mo34178a(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3)
        com.tencent.android.tpush.stat.a.d r0 = r3.f23534a     // Catch:{ all -> 0x0082 }
        java.lang.String r1 = "write mid to InternalStorage"
        r0.mo34169b(r1)     // Catch:{ all -> 0x0082 }
        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
        r0.<init>()     // Catch:{ all -> 0x0082 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0082 }
        r0.append(r1)     // Catch:{ all -> 0x0082 }
        java.lang.String r1 = "/"
        r0.append(r1)     // Catch:{ all -> 0x0082 }
        java.lang.String r1 = r3.mo34199d()     // Catch:{ all -> 0x0082 }
        r0.append(r1)     // Catch:{ all -> 0x0082 }
        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0082 }
        com.tencent.android.tpush.stat.p597b.C7072a.m30309a(r0)     // Catch:{ all -> 0x0082 }
        java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0082 }
        java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x0082 }
        java.lang.String r2 = r3.mo34201e()     // Catch:{ all -> 0x0082 }
        r0.<init>(r1, r2)     // Catch:{ all -> 0x0082 }
        r1 = 0
        java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x006b }
        r2.<init>(r0)     // Catch:{ IOException -> 0x006b }
        java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x006b }
        r0.<init>(r2)     // Catch:{ IOException -> 0x006b }
        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.<init>()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r2 = r3.mo34202f()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.append(r2)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r2 = ","
        r1.append(r2)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r1.append(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r4 = r1.toString()     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r0.write(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        java.lang.String r4 = "\n"
        r0.write(r4)     // Catch:{ IOException -> 0x0065, all -> 0x0063 }
        r0.close()     // Catch:{ Exception -> 0x007a }
        goto L_0x007a
    L_0x0063:
        r4 = move-exception
        goto L_0x007c
    L_0x0065:
        r4 = move-exception
        r1 = r0
        goto L_0x006c
    L_0x0068:
        r4 = move-exception
        r0 = r1
        goto L_0x007c
    L_0x006b:
        r4 = move-exception
    L_0x006c:
        com.tencent.android.tpush.stat.a.d r0 = r3.f23534a     // Catch:{ all -> 0x0068 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0068 }
        r0.mo34172d(r4)     // Catch:{ all -> 0x0068 }
        if (r1 == 0) goto L_0x007a
        r1.close()     // Catch:{ Exception -> 0x007a }
    L_0x007a:
        monitor-exit(r3)     // Catch:{ all -> 0x0082 }
        return
    L_0x007c:
        if (r0 == 0) goto L_0x0081
        r0.close()     // Catch:{ Exception -> 0x0081 }
    L_0x0081:
        throw r4     // Catch:{ all -> 0x0082 }
    L_0x0082:
        r4 = move-exception
        monitor-exit(r3)     // Catch:{ all -> 0x0082 }
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.p597b.C7073b.mo34178a(java.lang.String):void");
    }
}
