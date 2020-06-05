package com.bytedance.sdk.adnet.p159b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.RequestQueue;
import com.bytedance.sdk.adnet.err.VAdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.bytedance.sdk.adnet.b.d */
public class ImageLoader {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final ExecutorService f6095a = Executors.newCachedThreadPool();
    /* renamed from: b */
    private final RequestQueue f6096b;
    /* renamed from: c */
    private int f6097c = 50;
    /* renamed from: d */
    private final C1962b f6098d;
    /* renamed from: e */
    private final Map<String, C1961a> f6099e = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private|final */
    /* renamed from: f */
    public final Map<String, C1961a> f6100f = Collections.synchronizedMap(new HashMap());
    /* renamed from: g */
    private final Handler f6101g = new Handler(Looper.getMainLooper());

    /* compiled from: ImageLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.d$a */
    private static class C1961a {
        /* renamed from: a */
        private final Request<?> f6121a;
        /* renamed from: b */
        private C1982p<Bitmap> f6122b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public Bitmap f6123c;
        /* renamed from: d */
        private VAdError f6124d;
        /* access modifiers changed from: private|final */
        /* renamed from: e */
        public final List<C1963c> f6125e = Collections.synchronizedList(new ArrayList());

        public C1961a(Request<?> request, C1963c cVar) {
            this.f6121a = request;
            this.f6125e.add(cVar);
        }

        /* renamed from: a */
        public void mo14212a(VAdError vAdError) {
            this.f6124d = vAdError;
        }

        /* renamed from: a */
        public VAdError mo14209a() {
            return this.f6124d;
        }

        /* renamed from: b */
        public C1982p<Bitmap> mo14213b() {
            return this.f6122b;
        }

        /* renamed from: a */
        public void mo14211a(C1982p<Bitmap> pVar) {
            this.f6122b = pVar;
        }

        /* renamed from: a */
        public void mo14210a(C1963c cVar) {
            this.f6125e.add(cVar);
        }
    }

    /* compiled from: ImageLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.d$b */
    public interface C1962b {
        /* renamed from: a */
        Bitmap mo14173a(String str);

        /* renamed from: a */
        String mo14174a(String str, int i, int i2, ScaleType scaleType);

        /* renamed from: a */
        void mo14175a(String str, Bitmap bitmap);
    }

    /* compiled from: ImageLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.d$c */
    public class C1963c {
        /* access modifiers changed from: private */
        /* renamed from: b */
        public Bitmap f6127b;
        /* access modifiers changed from: private|final */
        /* renamed from: c */
        public final C1964d f6128c;
        /* renamed from: d */
        private final String f6129d;
        /* renamed from: e */
        private final String f6130e;

        public C1963c(Bitmap bitmap, String str, String str2, C1964d dVar) {
            this.f6127b = bitmap;
            this.f6130e = str;
            this.f6129d = str2;
            this.f6128c = dVar;
        }

        /* renamed from: a */
        public Bitmap mo14214a() {
            return this.f6127b;
        }
    }

    /* compiled from: ImageLoader */
    /* renamed from: com.bytedance.sdk.adnet.b.d$d */
    public interface C1964d extends C1983a<Bitmap> {
        /* renamed from: a */
        void mo14215a();

        /* renamed from: a */
        void mo14216a(C1963c cVar, boolean z);

        /* renamed from: b */
        void mo14217b();
    }

    public ImageLoader(RequestQueue oVar, C1962b bVar) {
        this.f6096b = oVar;
        if (bVar == null) {
            bVar = new DefaultImageCache();
        }
        this.f6098d = bVar;
    }

    /* renamed from: a */
    public void mo14198a(String str, C1964d dVar) {
        mo14199a(str, dVar, 0, 0);
    }

    /* renamed from: a */
    public void mo14199a(String str, C1964d dVar, int i, int i2) {
        mo14200a(str, dVar, i, i2, ScaleType.CENTER_INSIDE);
    }

    /* renamed from: a */
    public void mo14200a(String str, C1964d dVar, int i, int i2, ScaleType scaleType) {
        ExecutorService executorService = this.f6095a;
        final String str2 = str;
        final C1964d dVar2 = dVar;
        final int i3 = i;
        final int i4 = i2;
        final ScaleType scaleType2 = scaleType;
        C19541 r1 = new Runnable() {
            public void run() {
                ImageLoader.this.m7711b(str2, dVar2, i3, i4, scaleType2);
            }
        };
        executorService.execute(r1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7711b(String str, final C1964d dVar, int i, int i2, ScaleType scaleType) {
        this.f6101g.post(new Runnable() {
            public void run() {
                dVar.mo14215a();
            }
        });
        String a = m7706a(str, i, i2, scaleType);
        Bitmap a2 = this.f6098d.mo14173a(a);
        if (a2 != null) {
            final C1963c cVar = new C1963c(a2, str, null, null);
            this.f6101g.post(new Runnable() {
                public void run() {
                    dVar.mo14216a(cVar, true);
                    dVar.mo14217b();
                }
            });
            return;
        }
        C1963c cVar2 = new C1963c(null, str, a, dVar);
        C1961a aVar = (C1961a) this.f6099e.get(a);
        if (aVar == null) {
            aVar = (C1961a) this.f6100f.get(a);
        }
        if (aVar != null) {
            aVar.mo14210a(cVar2);
            return;
        }
        Request a3 = mo14197a(str, i, i2, scaleType, a);
        this.f6096b.mo14361a(a3);
        this.f6099e.put(a, new C1961a(a3, cVar2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Request<Bitmap> mo14197a(String str, int i, int i2, ScaleType scaleType, final String str2) {
        ImageRequest eVar = new ImageRequest(str, new C1983a<Bitmap>() {
            /* renamed from: a */
            public void mo14171a(final C1982p<Bitmap> pVar) {
                ImageLoader.this.f6095a.execute(new Runnable() {
                    public void run() {
                        ImageLoader.this.mo14201a(str2, pVar);
                    }
                });
            }

            /* renamed from: b */
            public void mo14172b(final C1982p<Bitmap> pVar) {
                ImageLoader.this.f6095a.execute(new Runnable() {
                    public void run() {
                        ImageLoader.this.mo14202b(str2, pVar);
                    }
                });
            }
        }, i, i2, scaleType, Config.RGB_565);
        return eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14201a(String str, C1982p<Bitmap> pVar) {
        this.f6098d.mo14175a(str, (Bitmap) pVar.f6293a);
        C1961a aVar = (C1961a) this.f6099e.remove(str);
        if (aVar != null) {
            aVar.f6123c = (Bitmap) pVar.f6293a;
            aVar.mo14211a(pVar);
            m7709a(str, aVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo14202b(String str, C1982p<Bitmap> pVar) {
        C1961a aVar = (C1961a) this.f6099e.remove(str);
        if (aVar != null) {
            aVar.mo14212a(pVar.f6295c);
            aVar.mo14211a(pVar);
            m7709a(str, aVar);
        }
    }

    /* renamed from: a */
    private void m7709a(final String str, C1961a aVar) {
        this.f6100f.put(str, aVar);
        this.f6101g.postDelayed(new Runnable() {
            public void run() {
                C1961a aVar = (C1961a) ImageLoader.this.f6100f.get(str);
                if (aVar != null) {
                    for (C1963c cVar : aVar.f6125e) {
                        if (cVar.f6128c != null) {
                            if (aVar.mo14209a() == null) {
                                cVar.f6127b = aVar.f6123c;
                                cVar.f6128c.mo14216a(cVar, false);
                            } else {
                                cVar.f6128c.mo14172b(aVar.mo14213b());
                            }
                            cVar.f6128c.mo14217b();
                        }
                    }
                }
                ImageLoader.this.f6100f.remove(str);
            }
        }, (long) this.f6097c);
    }

    /* renamed from: a */
    private String m7706a(String str, int i, int i2, ScaleType scaleType) {
        String a = this.f6098d.mo14174a(str, i, i2, scaleType);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }
}
