package com.qiyukf.nimlib.p488k.p491c;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.qiyukf.nimlib.k.c.a */
final class C5943a {
    /* renamed from: b */
    private static C5943a f18760b;
    /* renamed from: a */
    private String f18761a = null;

    private C5943a() {
    }

    /* renamed from: a */
    private static long m23822a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static synchronized C5943a m23823a() {
        C5943a aVar;
        synchronized (C5943a.class) {
            if (f18760b == null) {
                f18760b = new C5943a();
            }
            aVar = f18760b;
        }
        return aVar;
    }

    /* renamed from: a */
    private String m23824a(String str, C5944b bVar, boolean z) {
        StringBuilder sb = new StringBuilder(mo28375a(bVar));
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (z) {
            if (file.exists() && !file.isDirectory()) {
                return sb2;
            }
            sb2 = "";
        }
        return sb2;
    }

    /* renamed from: b */
    static boolean m23825b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final String mo28375a(C5944b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18761a);
        sb.append(bVar.mo28380a());
        return sb.toString();
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final String mo28376a(String str, C5944b bVar) {
        return m23824a(str, bVar, false);
    }

    /* renamed from: a */
    public final void mo28377a(Context context) {
        C5944b[] values;
        File externalFilesDir = context.getExternalFilesDir(null);
        String str = "/";
        if (externalFilesDir == null) {
            this.f18761a = str;
            return;
        }
        this.f18761a = externalFilesDir.getAbsolutePath().concat(str).concat("com.qiyukf.unicorn/");
        File file = new File(this.f18761a);
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        boolean z = true;
        for (C5944b bVar : C5944b.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18761a);
            sb.append(bVar.mo28380a());
            File file2 = new File(sb.toString());
            boolean exists = file2.exists();
            if (!exists) {
                exists = file2.mkdirs();
            }
            z &= exists;
        }
        if (z) {
            String str2 = this.f18761a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append("/.nomedia");
            File file3 = new File(sb2.toString());
            try {
                if (!file3.exists()) {
                    file3.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final String mo28378b(String str, C5944b bVar) {
        return TextUtils.isEmpty(str) ? "" : m23824a(str, bVar, true);
    }

    /* access modifiers changed from: final */
    /* renamed from: c */
    public final long mo28379c() {
        return m23822a(this.f18761a);
    }
}
