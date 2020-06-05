package com.kwad.sdk.core.p337i.p339b;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.download.p323a.C4089b;
import com.kwad.sdk.core.p337i.C4200a;
import com.kwad.sdk.core.p337i.p338a.C4201a;
import com.kwad.sdk.core.p337i.p338a.C4203c;
import com.kwad.sdk.core.response.p341a.C4321b;
import com.kwad.sdk.nativead.KsAppDownloadListener;
import com.kwad.sdk.p306a.C3800e;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.i.b.j */
public class C4229j implements C4201a {
    /* renamed from: a */
    private final C4200a f14026a;
    /* renamed from: b */
    private final C4089b f14027b;
    /* renamed from: c */
    private C4203c f14028c;
    /* renamed from: d */
    private KsAppDownloadListener f14029d;

    /* renamed from: com.kwad.sdk.core.i.b.j$a */
    public static final class C4231a implements C4321b {
        /* renamed from: a */
        public float f14031a;
        /* renamed from: b */
        public int f14032b;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C3800e.m15748a(jSONObject, NotificationCompat.CATEGORY_PROGRESS, this.f14031a);
            C3800e.m15749a(jSONObject, NotificationCompat.CATEGORY_STATUS, this.f14032b);
            return jSONObject;
        }
    }

    public C4229j(C4200a aVar, C4089b bVar) {
        this.f14026a = aVar;
        this.f14027b = bVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17473a(int i, float f) {
        if (this.f14028c != null) {
            C4231a aVar = new C4231a();
            aVar.f14031a = f;
            aVar.f14032b = i;
            this.f14028c.mo23981a(aVar);
        }
    }

    /* renamed from: c */
    private KsAppDownloadListener m17475c() {
        return new KsAppDownloadListener() {
            public void onDownloadFinished() {
                C4229j.this.m17473a(5, 1.0f);
            }

            public void onIdle() {
                C4229j.this.m17473a(1, 0.0f);
            }

            public void onInstalled() {
                C4229j.this.m17473a(6, 1.0f);
            }

            public void onProgressUpdate(int i) {
                C4229j.this.m17473a(2, (((float) i) * 1.0f) / 100.0f);
            }
        };
    }

    /* renamed from: a */
    public String mo23976a() {
        return "registerProgressListener";
    }

    /* renamed from: a */
    public void mo23977a(String str, C4203c cVar) {
        if (this.f14026a.f13972b == null) {
            cVar.mo23980a(-1, "native photo is null");
            return;
        }
        this.f14028c = cVar;
        C4089b bVar = this.f14027b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f14029d;
            if (ksAppDownloadListener == null) {
                this.f14029d = m17475c();
                this.f14027b.mo23770a(this.f14029d);
            } else {
                bVar.mo23779c(ksAppDownloadListener);
            }
        }
    }

    /* renamed from: b */
    public void mo23978b() {
        this.f14028c = null;
        C4089b bVar = this.f14027b;
        if (bVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f14029d;
            if (ksAppDownloadListener != null) {
                bVar.mo23775b(ksAppDownloadListener);
                this.f14029d = null;
            }
        }
    }
}
