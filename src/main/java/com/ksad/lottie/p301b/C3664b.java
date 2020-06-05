package com.ksad.lottie.p301b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.ksad.lottie.C3662b;
import com.ksad.lottie.C3731g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.ksad.lottie.b.b */
public class C3664b {
    /* renamed from: a */
    private static final Object f12564a = new Object();
    /* renamed from: b */
    private final Context f12565b;
    /* renamed from: c */
    private String f12566c;
    /* renamed from: d */
    private C3662b f12567d;
    /* renamed from: e */
    private final Map<String, C3731g> f12568e;

    public C3664b(Callback callback, String str, C3662b bVar, Map<String, C3731g> map) {
        this.f12566c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f12566c;
            if (str2.charAt(str2.length() - 1) != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f12566c);
                sb.append('/');
                this.f12566c = sb.toString();
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f12568e = new HashMap();
            this.f12565b = null;
            return;
        }
        this.f12565b = ((View) callback).getContext();
        this.f12568e = map;
        mo22861a(bVar);
    }

    /* renamed from: a */
    private Bitmap m15245a(String str, Bitmap bitmap) {
        synchronized (f12564a) {
            ((C3731g) this.f12568e.get(str)).mo23010a(bitmap);
        }
        return bitmap;
    }

    /* renamed from: a */
    public Bitmap mo22859a(String str) {
        String str2;
        Bitmap decodeStream;
        C3731g gVar = (C3731g) this.f12568e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap c = gVar.mo23012c();
        if (c != null) {
            return c;
        }
        C3662b bVar = this.f12567d;
        if (bVar != null) {
            Bitmap a = bVar.mo22856a(gVar);
            if (a != null) {
                m15245a(str, a);
            }
            return a;
        }
        String b = gVar.mo23011b();
        Options options = new Options();
        options.inScaled = true;
        options.inDensity = 160;
        String str3 = "LOTTIE";
        if (!b.startsWith("data:") || b.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f12566c)) {
                    AssetManager assets = this.f12565b.getAssets();
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f12566c);
                    sb.append(b);
                    decodeStream = BitmapFactory.decodeStream(assets.open(sb.toString()), null, options);
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e) {
                e = e;
                str2 = "Unable to open asset.";
                Log.w(str3, str2, e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                decodeStream = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            } catch (IllegalArgumentException e2) {
                e = e2;
                str2 = "data URL did not have correct base64 format.";
                Log.w(str3, str2, e);
                return null;
            }
        }
        return m15245a(str, decodeStream);
    }

    /* renamed from: a */
    public void mo22860a() {
        synchronized (f12564a) {
            for (Entry value : this.f12568e.entrySet()) {
                C3731g gVar = (C3731g) value.getValue();
                Bitmap c = gVar.mo23012c();
                if (c != null) {
                    c.recycle();
                    gVar.mo23010a(null);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo22861a(C3662b bVar) {
        this.f12567d = bVar;
    }

    /* renamed from: a */
    public boolean mo22862a(Context context) {
        return (context == null && this.f12565b == null) || this.f12565b.equals(context);
    }
}
