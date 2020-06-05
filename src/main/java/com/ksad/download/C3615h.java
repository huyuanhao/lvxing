package com.ksad.download;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.ksad.download.p296b.C3604a;
import com.ksad.download.p297c.C3606a;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p358f.C4654c.C4656b;
import com.kwai.filedownloader.p358f.C4664f;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C8362ab;
import okhttp3.C8488j;
import okhttp3.C8508u;
import okhttp3.C8513x;
import okhttp3.C8513x.C8515a;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.Protocol;
import okhttp3.internal.C8417c;

/* renamed from: com.ksad.download.h */
public class C3615h implements C4589b {
    /* renamed from: a */
    private final C8513x f12376a;
    /* renamed from: b */
    private final C8519a f12377b;
    /* renamed from: c */
    private C8518z f12378c;
    /* renamed from: d */
    private C8362ab f12379d;

    /* renamed from: com.ksad.download.h$a */
    public static class C3617a implements C4656b {
        /* renamed from: a */
        private C8513x f12380a;
        /* renamed from: b */
        private C8515a f12381b;

        public C3617a() {
        }

        public C3617a(boolean z) {
            this.f12381b = z ? C3615h.m15083j() : C3615h.m15082i();
        }

        /* renamed from: a */
        public C4589b mo22748a(String str) {
            if (this.f12380a == null) {
                synchronized (C3617a.class) {
                    if (this.f12380a == null) {
                        this.f12380a = this.f12381b != null ? this.f12381b.mo40632a() : new C8513x();
                        this.f12381b = null;
                    }
                }
            }
            return new C3615h(str, this.f12380a);
        }
    }

    private C3615h(String str, C8513x xVar) {
        this(new C8519a().mo40655a(str), xVar);
    }

    private C3615h(C8519a aVar, C8513x xVar) {
        this.f12377b = aVar;
        this.f12376a = xVar;
    }

    /* renamed from: b */
    private String m15079b(String str) {
        String a = mo22740a("Content-Type");
        String b = C3606a.m15044b(str);
        String str2 = ".apk";
        if (TextUtils.isEmpty(a) || !TextUtils.isEmpty(b)) {
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                sb.append(str2);
                str = sb.toString();
            }
            return str;
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        if (!TextUtils.isEmpty(extensionFromMimeType)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(".");
            sb3.append(extensionFromMimeType);
            str2 = sb3.toString();
        }
        sb2.append(str2);
        return sb2.toString();
    }

    /* access modifiers changed from: private|static */
    /* renamed from: i */
    public static C8515a m15082i() {
        return new C8515a().mo40622a(10000, TimeUnit.MILLISECONDS).mo40630a((C8508u) new C3604a()).mo40633b(0, TimeUnit.MILLISECONDS).mo40628a(new C8488j(6, 60000, TimeUnit.MILLISECONDS)).mo40635b(true);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: j */
    public static C8515a m15083j() {
        return new C8515a().mo40622a(10000, TimeUnit.MILLISECONDS).mo40630a((C8508u) new C3604a()).mo40623a(C8417c.m36035a((T[]) new Protocol[]{Protocol.HTTP_1_1})).mo40633b(0, TimeUnit.MILLISECONDS).mo40628a(new C8488j(6, 60000, TimeUnit.MILLISECONDS)).mo40635b(true);
    }

    /* renamed from: a */
    public InputStream mo22739a() {
        C8362ab abVar = this.f12379d;
        if (abVar != null) {
            return abVar.mo40097h().mo40124d();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    /* renamed from: a */
    public String mo22740a(String str) {
        String str2;
        if ("Content-Disposition".equals(str)) {
            try {
                if (!TextUtils.isEmpty(C4664f.m19158g(this.f12379d.mo40089b(str)))) {
                    return this.f12379d.mo40089b(str);
                }
                List k = this.f12379d.mo40088a().mo40645a().mo40562k();
                str2 = (String) k.get(k.size() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append("attachment; filename=\"");
                sb.append(m15079b(str2));
                sb.append("\"");
                return sb.toString();
            } catch (Exception unused) {
                str2 = "";
            }
        } else {
            C8362ab abVar = this.f12379d;
            return abVar == null ? null : abVar.mo40089b(str);
        }
    }

    /* renamed from: a */
    public void mo22741a(String str, String str2) {
        this.f12377b.mo40662b(str, str2);
    }

    /* renamed from: a */
    public boolean mo22742a(String str, long j) {
        return false;
    }

    /* renamed from: b */
    public Map<String, List<String>> mo22743b() {
        if (this.f12378c == null) {
            this.f12378c = this.f12377b.mo40663b();
        }
        return this.f12378c.mo40648c().mo40537c();
    }

    /* renamed from: c */
    public Map<String, List<String>> mo22744c() {
        C8362ab abVar = this.f12379d;
        if (abVar == null) {
            return null;
        }
        return abVar.mo40096g().mo40537c();
    }

    /* renamed from: d */
    public void mo22745d() {
        if (this.f12378c == null) {
            this.f12378c = this.f12377b.mo40663b();
        }
        this.f12379d = this.f12376a.mo40177a(this.f12378c).mo40173a();
    }

    /* renamed from: e */
    public int mo22746e() {
        C8362ab abVar = this.f12379d;
        if (abVar != null) {
            return abVar.mo40091c();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    /* renamed from: f */
    public void mo22747f() {
        this.f12378c = null;
        C8362ab abVar = this.f12379d;
        if (!(abVar == null || abVar.mo40097h() == null)) {
            this.f12379d.mo40097h().close();
        }
        this.f12379d = null;
    }
}
