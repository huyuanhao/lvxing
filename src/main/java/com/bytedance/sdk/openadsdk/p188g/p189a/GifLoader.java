package com.bytedance.sdk.openadsdk.p188g.p189a;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.RequestQueue;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifCache.C2426a;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifRequest.C2437a;
import com.bytedance.sdk.openadsdk.p198i.TTExecutor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.g.a.b */
public class GifLoader {
    /* renamed from: a */
    private final RequestQueue f8676a;
    /* renamed from: b */
    private final Handler f8677b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final Map<String, C2434d> f8678c = Collections.synchronizedMap(new HashMap());

    /* compiled from: GifLoader */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.b$a */
    static class C2431a implements C2432b {
        /* renamed from: a */
        public void mo16638a() {
        }

        /* renamed from: a */
        public void mo16639a(C2433c cVar) {
        }

        /* renamed from: a */
        public void mo16640a(String str, byte[] bArr) {
        }

        /* renamed from: b */
        public void mo16641b(C2433c cVar) {
        }

        C2431a() {
        }
    }

    /* compiled from: GifLoader */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.b$b */
    public interface C2432b {
        /* renamed from: a */
        void mo16638a();

        /* renamed from: a */
        void mo16639a(C2433c cVar);

        /* renamed from: a */
        void mo16640a(String str, byte[] bArr);

        /* renamed from: b */
        void mo16641b(C2433c cVar);
    }

    /* compiled from: GifLoader */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.b$c */
    public static class C2433c {
        /* renamed from: a */
        private final byte[] f8695a;
        /* renamed from: b */
        private final C2432b f8696b;
        /* renamed from: c */
        private final String f8697c;
        /* renamed from: d */
        private final String f8698d;
        /* renamed from: e */
        private final VAdError f8699e;

        public C2433c(byte[] bArr, C2432b bVar, String str, String str2) {
            this.f8695a = bArr;
            this.f8696b = bVar;
            this.f8697c = str;
            this.f8698d = str2;
            this.f8699e = null;
        }

        public C2433c(VAdError vAdError, C2432b bVar, String str, String str2) {
            this.f8699e = vAdError;
            this.f8696b = bVar;
            this.f8697c = str;
            this.f8698d = str2;
            this.f8695a = null;
        }
    }

    /* compiled from: GifLoader */
    /* renamed from: com.bytedance.sdk.openadsdk.g.a.b$d */
    static class C2434d {
        /* renamed from: a */
        GifRequest f8700a;
        /* renamed from: b */
        C1982p f8701b;
        /* renamed from: c */
        List<C2432b> f8702c = Collections.synchronizedList(new ArrayList());
        /* renamed from: d */
        VAdError f8703d;
        /* renamed from: e */
        byte[] f8704e;

        public C2434d(GifRequest cVar, C2432b bVar) {
            this.f8700a = cVar;
            mo16642a(bVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo16642a(C2432b bVar) {
            if (bVar != null) {
                this.f8702c.add(bVar);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo16643a() {
            return this.f8703d == null && this.f8704e != null;
        }
    }

    public GifLoader(RequestQueue oVar) {
        this.f8676a = oVar;
    }

    /* renamed from: a */
    public void mo16632a(String str, C2432b bVar, int i, int i2) {
        mo16633a(str, bVar, i, i2, ScaleType.CENTER_INSIDE);
    }

    /* renamed from: a */
    public void mo16633a(String str, final C2432b bVar, int i, int i2, ScaleType scaleType) {
        if (bVar != null) {
            this.f8677b.post(new Runnable() {
                public void run() {
                    C2432b bVar = bVar;
                    if (bVar != null) {
                        bVar.mo16638a();
                    }
                }
            });
        }
        TTExecutor a = TTExecutor.m11692a();
        final String str2 = str;
        final C2432b bVar2 = bVar;
        final int i3 = i;
        final int i4 = i2;
        final ScaleType scaleType2 = scaleType;
        C24282 r1 = new Runnable() {
            public void run() {
                GifLoader.this.m11384b(str2, bVar2, i3, i4, scaleType2);
            }
        };
        a.mo16808c(r1, 5);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11384b(String str, C2432b bVar, int i, int i2, ScaleType scaleType) {
        String a = GifCache.m11369a().mo16625a(str, i, i2, scaleType);
        final C2426a b = GifCache.m11369a().mo16627b(a);
        if (b == null || b.f8675a == null) {
            C2434d dVar = (C2434d) this.f8678c.get(a);
            if (dVar != null) {
                dVar.mo16642a(bVar);
                return;
            }
            GifRequest a2 = m11379a(str, i, i2, scaleType, a);
            C2434d dVar2 = new C2434d(a2, bVar);
            this.f8676a.mo14361a(a2);
            this.f8678c.put(a, dVar2);
            return;
        }
        final C2433c cVar = new C2433c(b.f8675a, bVar, a, str);
        Handler handler = this.f8677b;
        final C2432b bVar2 = bVar;
        final String str2 = str;
        C24293 r2 = new Runnable() {
            public void run() {
                C2432b bVar = bVar2;
                if (bVar != null) {
                    bVar.mo16640a(str2, b.f8675a);
                }
                C2432b bVar2 = bVar2;
                if (bVar2 != null) {
                    bVar2.mo16639a(cVar);
                }
            }
        };
        handler.post(r2);
    }

    /* renamed from: a */
    private GifRequest m11379a(final String str, int i, int i2, ScaleType scaleType, final String str2) {
        GifRequest cVar = new GifRequest(str, new C2437a() {
            /* renamed from: a */
            public void mo16637a(String str, byte[] bArr) {
                C2434d dVar = (C2434d) GifLoader.this.f8678c.get(str2);
                if (dVar != null) {
                    for (C2432b bVar : dVar.f8702c) {
                        if (bVar != null) {
                            bVar.mo16640a(str, bArr);
                        }
                    }
                }
            }

            /* renamed from: a */
            public void mo14171a(C1982p<byte[]> pVar) {
                C2434d dVar = (C2434d) GifLoader.this.f8678c.remove(str2);
                if (dVar != null) {
                    dVar.f8701b = pVar;
                    dVar.f8704e = (byte[]) pVar.f6293a;
                    GifLoader.this.m11383a(str2, str, dVar);
                }
            }

            /* renamed from: b */
            public void mo14172b(C1982p<byte[]> pVar) {
                C2434d dVar = (C2434d) GifLoader.this.f8678c.remove(str2);
                if (dVar != null) {
                    dVar.f8701b = pVar;
                    dVar.f8703d = pVar.f6295c;
                    GifLoader.this.m11383a(str2, str, dVar);
                }
            }
        }, i, i2, scaleType, Config.RGB_565);
        return cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11383a(String str, String str2, C2434d dVar) {
        if (dVar != null) {
            boolean a = dVar.mo16643a();
            if (dVar.f8702c != null) {
                for (C2432b bVar : dVar.f8702c) {
                    if (bVar != null) {
                        if (a) {
                            bVar.mo16639a(new C2433c(dVar.f8704e, bVar, str, str2));
                        } else {
                            bVar.mo16641b(new C2433c(dVar.f8703d, bVar, str, str2));
                        }
                    }
                }
                dVar.f8702c.clear();
            }
        }
    }

    /* renamed from: a */
    public static C2431a m11378a() {
        return new C2431a();
    }
}
