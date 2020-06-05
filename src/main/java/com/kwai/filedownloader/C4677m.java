package com.kwai.filedownloader;

import android.content.Context;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4661e;
import com.kwai.filedownloader.services.C4734e.C4735a;

/* renamed from: com.kwai.filedownloader.m */
public class C4677m implements C4740t {
    /* renamed from: a */
    private final C4740t f15211a;

    /* renamed from: com.kwai.filedownloader.m$a */
    private static final class C4679a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final C4677m f15212a = new C4677m();
    }

    private C4677m() {
        this.f15211a = C4661e.m19127a().f15183d ? new C4716n() : new C4717o();
    }

    /* renamed from: a */
    public static C4677m m19228a() {
        return C4679a.f15212a;
    }

    /* renamed from: b */
    public static C4735a m19229b() {
        if (m19228a().f15211a instanceof C4716n) {
            return (C4735a) m19228a().f15211a;
        }
        return null;
    }

    /* renamed from: a */
    public void mo25261a(Context context) {
        this.f15211a.mo25261a(context);
    }

    /* renamed from: a */
    public boolean mo25262a(int i) {
        return this.f15211a.mo25262a(i);
    }

    /* renamed from: a */
    public boolean mo25263a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
        return this.f15211a.mo25263a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    /* renamed from: b */
    public byte mo25264b(int i) {
        return this.f15211a.mo25264b(i);
    }

    /* renamed from: c */
    public boolean mo25265c() {
        return this.f15211a.mo25265c();
    }

    /* renamed from: c */
    public boolean mo25266c(int i) {
        return this.f15211a.mo25266c(i);
    }
}
