package com.kwad.sdk.core.videocache;

import com.kwad.sdk.core.videocache.p343a.C4333a;
import com.kwad.sdk.core.videocache.p343a.C4335c;
import com.kwad.sdk.core.videocache.p344b.C4345b;
import com.kwad.sdk.core.videocache.p346d.C4350b;
import java.io.File;

/* renamed from: com.kwad.sdk.core.videocache.c */
class C4346c {
    /* renamed from: a */
    public final File f14251a;
    /* renamed from: b */
    public final C4335c f14252b;
    /* renamed from: c */
    public final C4333a f14253c;
    /* renamed from: d */
    public final C4350b f14254d;
    /* renamed from: e */
    public final C4345b f14255e;

    C4346c(File file, C4335c cVar, C4333a aVar, C4350b bVar, C4345b bVar2) {
        this.f14251a = file;
        this.f14252b = cVar;
        this.f14253c = aVar;
        this.f14254d = bVar;
        this.f14255e = bVar2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public File mo24497a(String str) {
        return new File(this.f14251a, this.f14252b.mo24489a(str));
    }
}
