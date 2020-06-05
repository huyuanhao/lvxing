package com.bytedance.sdk.openadsdk.multipro.p200a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.multipro.ITTProvider;
import com.bytedance.sdk.openadsdk.utils.C2564t;

/* renamed from: com.bytedance.sdk.openadsdk.multipro.a.b */
public class DBMultiProviderImpl implements ITTProvider {
    /* renamed from: b */
    private static final Object f9001b = new Object();
    /* renamed from: a */
    private Context f9002a;

    /* renamed from: a */
    public String mo16851a() {
        return "t_db";
    }

    /* renamed from: b */
    public void mo16854b() {
    }

    /* renamed from: a */
    public void mo16853a(Context context) {
        this.f9002a = context;
    }

    /* renamed from: b */
    private boolean m11764b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            C2564t.m12220b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    /* renamed from: c */
    private Context m11765c() {
        Context context = this.f9002a;
        return context == null ? InternalContainer.m10059a() : context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
            return null;
     */
    /* renamed from: a */
    public android.database.Cursor mo16849a(android.net.Uri r14, java.lang.String[] r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18) {
        /*
        r13 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "query: "
        r0.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r14)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "DBMultiProviderImpl"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        java.lang.Object r1 = f9001b
        monitor-enter(r1)
        boolean r0 = r13.m11764b(r14)     // Catch:{ all -> 0x0064 }
        r2 = 0
        if (r0 == 0) goto L_0x0026
        monitor-exit(r1)     // Catch:{ all -> 0x0064 }
        return r2
    L_0x0026:
        java.lang.String r0 = r14.getPath()     // Catch:{ all -> 0x0064 }
        java.lang.String r3 = "/"
        java.lang.String[] r0 = r0.split(r3)     // Catch:{ all -> 0x0064 }
        if (r0 == 0) goto L_0x0062
        int r3 = r0.length     // Catch:{ all -> 0x0064 }
        r4 = 4
        if (r3 >= r4) goto L_0x0037
        goto L_0x0062
    L_0x0037:
        r3 = 2
        r3 = r0[r3]     // Catch:{ all -> 0x0064 }
        r4 = 3
        r6 = r0[r4]     // Catch:{ all -> 0x0064 }
        java.lang.String r0 = "ttopensdk.db"
        boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0064 }
        if (r0 == 0) goto L_0x0060
        android.content.Context r0 = r13.m11765c()     // Catch:{ all -> 0x0064 }
        com.bytedance.sdk.openadsdk.core.e r0 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r0)     // Catch:{ all -> 0x0064 }
        com.bytedance.sdk.openadsdk.core.f$c r5 = r0.mo15610a()     // Catch:{ all -> 0x0064 }
        r10 = 0
        r11 = 0
        r7 = r15
        r8 = r16
        r9 = r17
        r12 = r18
        android.database.Cursor r0 = r5.mo15625a(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0064 }
        monitor-exit(r1)     // Catch:{ all -> 0x0064 }
        return r0
    L_0x0060:
        monitor-exit(r1)     // Catch:{ all -> 0x0064 }
        return r2
    L_0x0062:
        monitor-exit(r1)     // Catch:{ all -> 0x0064 }
        return r2
    L_0x0064:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x0064 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl.mo16849a(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00af, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b1, code lost:
            return null;
     */
    /* renamed from: a */
    public java.lang.String mo16852a(android.net.Uri r6) {
        /*
        r5 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "getType: "
        r0.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r6)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "DBMultiProviderImpl"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        java.lang.Object r0 = f9001b
        monitor-enter(r0)
        boolean r1 = r5.m11764b(r6)     // Catch:{ all -> 0x00b2 }
        r2 = 0
        if (r1 == 0) goto L_0x0026
        monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
        return r2
    L_0x0026:
        java.lang.String r1 = r6.getPath()     // Catch:{ all -> 0x00b2 }
        java.lang.String r3 = "/"
        java.lang.String[] r1 = r1.split(r3)     // Catch:{ all -> 0x00b2 }
        if (r1 == 0) goto L_0x00b0
        int r3 = r1.length     // Catch:{ all -> 0x00b2 }
        r4 = 5
        if (r3 >= r4) goto L_0x0038
        goto L_0x00b0
    L_0x0038:
        r3 = 2
        r3 = r1[r3]     // Catch:{ all -> 0x00b2 }
        r4 = 3
        r4 = r1[r4]     // Catch:{ all -> 0x00b2 }
        r4 = 4
        r1 = r1[r4]     // Catch:{ all -> 0x00b2 }
        java.lang.String r4 = "ttopensdk.db"
        boolean r3 = r4.equals(r3)     // Catch:{ all -> 0x00b2 }
        if (r3 == 0) goto L_0x00ae
        java.lang.String r3 = "execSQL"
        boolean r3 = r3.equals(r1)     // Catch:{ all -> 0x00b2 }
        if (r3 == 0) goto L_0x0067
        java.lang.String r1 = "sql"
        java.lang.String r6 = r6.getQueryParameter(r1)     // Catch:{ all -> 0x00b2 }
        android.content.Context r1 = r5.m11765c()     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r1)     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.f$c r1 = r1.mo15610a()     // Catch:{ all -> 0x00b2 }
        r1.mo15627a(r6)     // Catch:{ all -> 0x00b2 }
        goto L_0x00ae
    L_0x0067:
        java.lang.String r6 = "transactionBegin"
        boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00b2 }
        if (r6 == 0) goto L_0x007f
        android.content.Context r6 = r5.m11765c()     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r6)     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.f$c r6 = r6.mo15610a()     // Catch:{ all -> 0x00b2 }
        r6.mo15626a()     // Catch:{ all -> 0x00b2 }
        goto L_0x00ae
    L_0x007f:
        java.lang.String r6 = "transactionSetSuccess"
        boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00b2 }
        if (r6 == 0) goto L_0x0097
        android.content.Context r6 = r5.m11765c()     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r6)     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.f$c r6 = r6.mo15610a()     // Catch:{ all -> 0x00b2 }
        r6.mo15628b()     // Catch:{ all -> 0x00b2 }
        goto L_0x00ae
    L_0x0097:
        java.lang.String r6 = "transactionEnd"
        boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x00b2 }
        if (r6 == 0) goto L_0x00ae
        android.content.Context r6 = r5.m11765c()     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.e r6 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r6)     // Catch:{ all -> 0x00b2 }
        com.bytedance.sdk.openadsdk.core.f$c r6 = r6.mo15610a()     // Catch:{ all -> 0x00b2 }
        r6.mo15629c()     // Catch:{ all -> 0x00b2 }
    L_0x00ae:
        monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
        return r2
    L_0x00b0:
        monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
        return r2
    L_0x00b2:
        r6 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x00b2 }
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl.mo16852a(android.net.Uri):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
            return null;
     */
    /* renamed from: a */
    public android.net.Uri mo16850a(android.net.Uri r5, android.content.ContentValues r6) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "insert: "
        r0.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r5)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "DBMultiProviderImpl"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        java.lang.Object r0 = f9001b
        monitor-enter(r0)
        boolean r1 = r4.m11764b(r5)     // Catch:{ all -> 0x0058 }
        r2 = 0
        if (r1 == 0) goto L_0x0026
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        return r2
    L_0x0026:
        java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x0058 }
        java.lang.String r1 = "/"
        java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x0058 }
        if (r5 == 0) goto L_0x0056
        int r1 = r5.length     // Catch:{ all -> 0x0058 }
        r3 = 4
        if (r1 >= r3) goto L_0x0037
        goto L_0x0056
    L_0x0037:
        r1 = 2
        r1 = r5[r1]     // Catch:{ all -> 0x0058 }
        r3 = 3
        r5 = r5[r3]     // Catch:{ all -> 0x0058 }
        java.lang.String r3 = "ttopensdk.db"
        boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x0054
        android.content.Context r1 = r4.m11765c()     // Catch:{ all -> 0x0058 }
        com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r1)     // Catch:{ all -> 0x0058 }
        com.bytedance.sdk.openadsdk.core.f$c r1 = r1.mo15610a()     // Catch:{ all -> 0x0058 }
        r1.mo15624a(r5, r2, r6)     // Catch:{ all -> 0x0058 }
    L_0x0054:
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        return r2
    L_0x0056:
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        return r2
    L_0x0058:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x0058 }
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl.mo16850a(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
            return 0;
     */
    /* renamed from: a */
    public int mo16848a(android.net.Uri r5, java.lang.String r6, java.lang.String[] r7) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "delete: "
        r0.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r5)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "DBMultiProviderImpl"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        java.lang.Object r0 = f9001b
        monitor-enter(r0)
        boolean r1 = r4.m11764b(r5)     // Catch:{ all -> 0x005b }
        r2 = 0
        if (r1 == 0) goto L_0x0026
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x0026:
        java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x005b }
        java.lang.String r1 = "/"
        java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x005b }
        if (r5 == 0) goto L_0x0059
        int r1 = r5.length     // Catch:{ all -> 0x005b }
        r3 = 4
        if (r1 >= r3) goto L_0x0037
        goto L_0x0059
    L_0x0037:
        r1 = 2
        r1 = r5[r1]     // Catch:{ all -> 0x005b }
        r3 = 3
        r5 = r5[r3]     // Catch:{ all -> 0x005b }
        java.lang.String r3 = "ttopensdk.db"
        boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x005b }
        if (r1 == 0) goto L_0x0057
        android.content.Context r1 = r4.m11765c()     // Catch:{ all -> 0x005b }
        com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r1)     // Catch:{ all -> 0x005b }
        com.bytedance.sdk.openadsdk.core.f$c r1 = r1.mo15610a()     // Catch:{ all -> 0x005b }
        int r5 = r1.mo15623a(r5, r6, r7)     // Catch:{ all -> 0x005b }
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r5
    L_0x0057:
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x0059:
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x005b:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl.mo16848a(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
            return 0;
     */
    /* renamed from: a */
    public int mo16847a(android.net.Uri r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8) {
        /*
        r4 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "update: "
        r0.append(r1)
        java.lang.String r1 = java.lang.String.valueOf(r5)
        r0.append(r1)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "DBMultiProviderImpl"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r1, r0)
        java.lang.Object r0 = f9001b
        monitor-enter(r0)
        boolean r1 = r4.m11764b(r5)     // Catch:{ all -> 0x005b }
        r2 = 0
        if (r1 == 0) goto L_0x0026
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x0026:
        java.lang.String r5 = r5.getPath()     // Catch:{ all -> 0x005b }
        java.lang.String r1 = "/"
        java.lang.String[] r5 = r5.split(r1)     // Catch:{ all -> 0x005b }
        if (r5 == 0) goto L_0x0059
        int r1 = r5.length     // Catch:{ all -> 0x005b }
        r3 = 4
        if (r1 >= r3) goto L_0x0037
        goto L_0x0059
    L_0x0037:
        r1 = 2
        r1 = r5[r1]     // Catch:{ all -> 0x005b }
        r3 = 3
        r5 = r5[r3]     // Catch:{ all -> 0x005b }
        java.lang.String r3 = "ttopensdk.db"
        boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x005b }
        if (r1 == 0) goto L_0x0057
        android.content.Context r1 = r4.m11765c()     // Catch:{ all -> 0x005b }
        com.bytedance.sdk.openadsdk.core.e r1 = com.bytedance.sdk.openadsdk.core.DBAdapter.m9530a(r1)     // Catch:{ all -> 0x005b }
        com.bytedance.sdk.openadsdk.core.f$c r1 = r1.mo15610a()     // Catch:{ all -> 0x005b }
        int r5 = r1.mo15622a(r5, r6, r7, r8)     // Catch:{ all -> 0x005b }
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r5
    L_0x0057:
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x0059:
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        return r2
    L_0x005b:
        r5 = move-exception
        monitor-exit(r0)     // Catch:{ all -> 0x005b }
        throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.p200a.DBMultiProviderImpl.mo16847a(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
