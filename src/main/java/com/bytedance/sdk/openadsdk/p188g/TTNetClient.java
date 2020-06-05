package com.bytedance.sdk.openadsdk.p188g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.core.C1982p;
import com.bytedance.sdk.adnet.core.DefaultRetryPolicy;
import com.bytedance.sdk.adnet.core.OkStack;
import com.bytedance.sdk.adnet.core.RequestQueue;
import com.bytedance.sdk.adnet.core.TTDnsProxy;
import com.bytedance.sdk.adnet.p159b.C1948b;
import com.bytedance.sdk.adnet.p159b.C1948b.C1950a;
import com.bytedance.sdk.adnet.p159b.ImageLoader;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1963c;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1964d;
import com.bytedance.sdk.adnet.p161d.TLSSocketFactory;
import com.bytedance.sdk.adnet.p162e.IHttpStack;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader;

/* renamed from: com.bytedance.sdk.openadsdk.g.e */
public class TTNetClient {
    /* renamed from: a */
    private static volatile TTNetClient f8721a;
    /* renamed from: c */
    private static IHttpStack f8722c;
    /* renamed from: b */
    private Context f8723b;
    /* renamed from: d */
    private RequestQueue f8724d;
    /* renamed from: e */
    private C1948b f8725e;
    /* renamed from: f */
    private RequestQueue f8726f;
    /* renamed from: g */
    private RequestQueue f8727g;
    /* renamed from: h */
    private ImageLoader f8728h;
    /* renamed from: i */
    private GifLoader f8729i;

    /* compiled from: TTNetClient */
    /* renamed from: com.bytedance.sdk.openadsdk.g.e$a */
    static class C2438a implements C1964d {
        /* renamed from: a */
        private ImageView f8730a;
        /* renamed from: b */
        private final String f8731b;
        /* renamed from: c */
        private final int f8732c;
        /* renamed from: d */
        private final int f8733d;

        /* renamed from: a */
        public void mo14171a(C1982p<Bitmap> pVar) {
        }

        C2438a(ImageView imageView, String str, int i, int i2) {
            this.f8730a = imageView;
            this.f8731b = str;
            this.f8732c = i;
            this.f8733d = i2;
            ImageView imageView2 = this.f8730a;
            if (imageView2 != null) {
                imageView2.setTag(1094453505, str);
            }
        }

        /* renamed from: a */
        public void mo14215a() {
            ImageView imageView = this.f8730a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.f8730a.getContext()).isFinishing()) && this.f8730a != null && m11445c()) {
                int i = this.f8732c;
                if (i != 0) {
                    this.f8730a.setImageResource(i);
                }
            }
        }

        /* renamed from: a */
        public void mo14216a(C1963c cVar, boolean z) {
            ImageView imageView = this.f8730a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.f8730a.getContext()).isFinishing()) && this.f8730a != null && m11445c() && cVar.mo14214a() != null) {
                this.f8730a.setImageBitmap(cVar.mo14214a());
            }
        }

        /* renamed from: b */
        public void mo14217b() {
            this.f8730a = null;
        }

        /* renamed from: b */
        public void mo14172b(C1982p<Bitmap> pVar) {
            ImageView imageView = this.f8730a;
            if ((imageView == null || !(imageView.getContext() instanceof Activity) || !((Activity) this.f8730a.getContext()).isFinishing()) && this.f8730a != null && this.f8733d != 0 && m11445c()) {
                this.f8730a.setImageResource(this.f8733d);
            }
        }

        /* renamed from: c */
        private boolean m11445c() {
            ImageView imageView = this.f8730a;
            if (imageView == null) {
                return false;
            }
            Object tag = imageView.getTag(1094453505);
            if (tag == null || !tag.equals(this.f8731b)) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: a */
    public static IHttpStack m11426a() {
        return f8722c;
    }

    /* renamed from: a */
    public static void m11429a(IHttpStack aVar) {
        f8722c = aVar;
    }

    /* renamed from: b */
    public static DefaultRetryPolicy m11430b() {
        return new DefaultRetryPolicy();
    }

    /* renamed from: a */
    public static TTNetClient m11428a(Context context) {
        if (f8721a == null) {
            synchronized (TTNetClient.class) {
                if (f8721a == null) {
                    f8721a = new TTNetClient(context);
                }
            }
        }
        return f8721a;
    }

    private TTNetClient(Context context) {
        this.f8723b = context == null ? InternalContainer.m10059a() : context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo16655a(String str, C1950a aVar) {
        m11433j();
        if (this.f8725e == null) {
            this.f8725e = new C1948b(this.f8723b, this.f8724d);
        }
        this.f8725e.mo14178a(str, aVar);
    }

    /* renamed from: c */
    public RequestQueue mo16656c() {
        m11433j();
        return this.f8724d;
    }

    /* renamed from: d */
    public RequestQueue mo16657d() {
        m11434k();
        return this.f8727g;
    }

    /* renamed from: e */
    public RequestQueue mo16658e() {
        if (this.f8726f == null) {
            this.f8726f = AdNetSdk.m7642a(this.f8723b, m11435l());
        }
        return this.f8726f;
    }

    /* renamed from: f */
    public GifLoader mo16659f() {
        m11431h();
        return this.f8729i;
    }

    /* renamed from: g */
    public ImageLoader mo16660g() {
        m11432i();
        return this.f8728h;
    }

    /* renamed from: a */
    public void mo16653a(String str, ImageView imageView) {
        mo16654a(str, imageView, m11427a(str, imageView, 0, 0));
    }

    /* renamed from: a */
    public void mo16654a(String str, ImageView imageView, C1964d dVar) {
        m11432i();
        this.f8728h.mo14198a(str, dVar);
    }

    /* renamed from: a */
    public static C2438a m11427a(String str, ImageView imageView, int i, int i2) {
        return new C2438a(imageView, str, i, i2);
    }

    /* renamed from: h */
    private void m11431h() {
        if (this.f8729i == null) {
            m11434k();
            this.f8729i = new GifLoader(this.f8727g);
        }
    }

    /* renamed from: i */
    private void m11432i() {
        if (this.f8728h == null) {
            m11434k();
            this.f8728h = new ImageLoader(this.f8727g, DiskImageCache.m11364a());
        }
    }

    /* renamed from: j */
    private void m11433j() {
        if (this.f8724d == null) {
            this.f8724d = AdNetSdk.m7642a(this.f8723b, m11435l());
        }
    }

    /* renamed from: k */
    private void m11434k() {
        if (this.f8727g == null) {
            this.f8727g = AdNetSdk.m7642a(this.f8723b, m11435l());
        }
    }

    /* renamed from: l */
    private IHttpStack m11435l() {
        if (m11426a() != null) {
            return m11426a();
        }
        return new OkStack(new TLSSocketFactory(), TLSSocketFactory.f6318a, TTHostNameVerifier.f8720a);
    }

    /* renamed from: a */
    public void mo16652a(TTDnsProxy qVar) {
        AdNetSdk.m7647a(qVar);
    }
}
