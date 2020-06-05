package com.bytedance.sdk.openadsdk.core.video.p177c;

import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2304a;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2305b;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2306c;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2307d;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2308e;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2309f;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2310g;
import com.bytedance.sdk.openadsdk.utils.C2564t;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.c.a */
public abstract class AbstractMediaPlayer implements IMediaPlayer {
    /* renamed from: a */
    private C2308e f7978a;
    /* renamed from: b */
    private C2305b f7979b;
    /* renamed from: c */
    private C2304a f7980c;
    /* renamed from: d */
    private C2309f f7981d;
    /* renamed from: e */
    private C2310g f7982e;
    /* renamed from: f */
    private C2306c f7983f;
    /* renamed from: g */
    private C2307d f7984g;

    /* renamed from: a */
    public final void mo16015a(C2308e eVar) {
        this.f7978a = eVar;
    }

    /* renamed from: a */
    public final void mo16012a(C2305b bVar) {
        this.f7979b = bVar;
    }

    /* renamed from: a */
    public final void mo16011a(C2304a aVar) {
        this.f7980c = aVar;
    }

    /* renamed from: a */
    public final void mo16016a(C2309f fVar) {
        this.f7981d = fVar;
    }

    /* renamed from: a */
    public final void mo16013a(C2306c cVar) {
        this.f7983f = cVar;
    }

    /* renamed from: a */
    public final void mo16014a(C2307d dVar) {
        this.f7984g = dVar;
    }

    /* renamed from: a */
    public final void mo16017a(C2310g gVar) {
        this.f7982e = gVar;
    }

    /* renamed from: a */
    public void mo16008a() {
        this.f7978a = null;
        this.f7980c = null;
        this.f7979b = null;
        this.f7981d = null;
        this.f7982e = null;
        this.f7983f = null;
        this.f7984g = null;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final void mo16019b() {
        try {
            if (this.f7978a != null) {
                this.f7978a.mo16052b(this);
            }
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final void mo16021c() {
        try {
            if (this.f7979b != null) {
                this.f7979b.mo16049a(this);
            }
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo16009a(int i) {
        try {
            if (this.f7980c != null) {
                this.f7980c.mo16048a(this, i);
            }
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final void mo16022d() {
        try {
            if (this.f7981d != null) {
                this.f7981d.mo16053c(this);
            }
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo16010a(int i, int i2, int i3, int i4) {
        try {
            if (this.f7982e != null) {
                this.f7982e.mo16054a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo16018a(int i, int i2) {
        boolean z = false;
        try {
            if (this.f7983f != null && this.f7983f.mo16050a(this, i, i2)) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final boolean mo16020b(int i, int i2) {
        boolean z = false;
        try {
            if (this.f7984g != null && this.f7984g.mo16051b(this, i, i2)) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            C2564t.m12223c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }
}
