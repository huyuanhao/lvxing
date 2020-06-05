package com.kwai.filedownloader.p358f;

import android.content.Context;
import com.kwai.filedownloader.C4746x;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.message.C4698e;
import com.kwai.filedownloader.message.C4701f;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p354b.C4596a;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p357e.C4641a;
import java.io.File;

/* renamed from: com.kwai.filedownloader.f.c */
public class C4654c {
    /* renamed from: a */
    private static Context f15178a;

    /* renamed from: com.kwai.filedownloader.f.c$a */
    public interface C4655a {
        /* renamed from: a */
        int mo24950a(int i, String str, String str2, long j);
    }

    /* renamed from: com.kwai.filedownloader.f.c$b */
    public interface C4656b {
        /* renamed from: a */
        C4589b mo22748a(String str);
    }

    /* renamed from: com.kwai.filedownloader.f.c$c */
    public interface C4657c {
        /* renamed from: a */
        C4596a mo25217a();
    }

    /* renamed from: com.kwai.filedownloader.f.c$d */
    public interface C4658d {
        /* renamed from: a */
        int mo25218a(int i, String str, String str2, boolean z);

        /* renamed from: a */
        int mo25219a(String str, String str2, boolean z);
    }

    /* renamed from: com.kwai.filedownloader.f.c$e */
    public interface C4659e {
        /* renamed from: a */
        C4641a mo25199a(File file);

        /* renamed from: a */
        boolean mo25200a();
    }

    /* renamed from: a */
    public static Context m19105a() {
        return f15178a;
    }

    /* renamed from: a */
    public static void m19106a(Context context) {
        f15178a = context;
    }

    /* renamed from: a */
    public static boolean m19107a(int i, long j, String str, String str2, C4746x xVar) {
        if (!(str2 == null || str == null)) {
            int a = xVar.mo25340a(str, i);
            if (a != 0) {
                C4698e.m19280a().mo25288a(C4701f.m19287a(i, j, (Throwable) new PathConflictException(a, str, str2)));
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m19108a(int i, C4621c cVar, C4746x xVar, boolean z) {
        if (!xVar.mo25344a(cVar)) {
            return false;
        }
        C4698e.m19280a().mo25288a(C4701f.m19286a(i, cVar.mo25089g(), cVar.mo25090h(), z));
        return true;
    }

    /* renamed from: a */
    public static boolean m19109a(int i, String str, boolean z, boolean z2) {
        if (!z && str != null) {
            File file = new File(str);
            if (file.exists()) {
                C4698e.m19280a().mo25288a(C4701f.m19288a(i, file, z2));
                return true;
            }
        }
        return false;
    }
}
