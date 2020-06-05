package com.tencent.mta.track;

import android.content.Context;
import android.util.Log;
import java.net.URI;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.q */
public class C7386q {
    /* renamed from: e */
    private static final ByteBuffer f24975e = ByteBuffer.allocate(0);
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final C7388s f24976a;
    /* renamed from: b */
    private C7389t f24977b;
    /* renamed from: c */
    private final URI f24978c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Context f24979d;

    public C7386q(URI uri, C7388s sVar, Context context) {
        this.f24976a = sVar;
        this.f24978c = uri;
        this.f24979d = context;
        try {
            this.f24977b = new C7389t(this, uri, 1000, this.f24979d);
            this.f24977b.mo36417a();
        } catch (Throwable unused) {
            this.f24977b = null;
        }
    }

    /* renamed from: a */
    public boolean mo35930a() {
        return this.f24977b.mo36420c();
    }

    /* renamed from: a */
    public void mo35928a(String str, int i, int i2) {
        StatisticsDataAPI.f24839a.booleanValue();
        try {
            this.f24977b.mo36418a(str, i);
        } catch (Throwable th) {
            Log.e("EditorConnection", "sendMessage;error", th);
        }
    }

    /* renamed from: a */
    public void mo35929a(boolean z) {
        C7389t tVar = this.f24977b;
        if (tVar != null && z) {
            try {
                tVar.mo36421d();
            } catch (Exception e) {
                Log.e("EditorConnection", "close;error", e);
            }
        }
    }
}
