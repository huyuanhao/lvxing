package com.ksad.lottie.p301b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import android.view.View;
import com.ksad.lottie.C3623a;
import com.ksad.lottie.model.C3773f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ksad.lottie.b.a */
public class C3663a {
    /* renamed from: a */
    private final C3773f<String> f12558a = new C3773f<>();
    /* renamed from: b */
    private final Map<C3773f<String>, Typeface> f12559b = new HashMap();
    /* renamed from: c */
    private final Map<String, Typeface> f12560c = new HashMap();
    /* renamed from: d */
    private final AssetManager f12561d;
    /* renamed from: e */
    private C3623a f12562e;
    /* renamed from: f */
    private String f12563f = ".ttf";

    public C3663a(Callback callback, C3623a aVar) {
        AssetManager assets;
        this.f12562e = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            assets = null;
        } else {
            assets = ((View) callback).getContext().getAssets();
        }
        this.f12561d = assets;
    }

    /* renamed from: a */
    private Typeface m15241a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    /* renamed from: a */
    private Typeface m15242a(String str) {
        Typeface typeface = (Typeface) this.f12560c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        C3623a aVar = this.f12562e;
        if (aVar != null) {
            typeface2 = aVar.mo22809a(str);
        }
        C3623a aVar2 = this.f12562e;
        if (aVar2 != null && typeface2 == null) {
            String b = aVar2.mo22810b(str);
            if (b != null) {
                typeface2 = Typeface.createFromAsset(this.f12561d, b);
            }
        }
        if (typeface2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("fonts/");
            sb.append(str);
            sb.append(this.f12563f);
            typeface2 = Typeface.createFromAsset(this.f12561d, sb.toString());
        }
        this.f12560c.put(str, typeface2);
        return typeface2;
    }

    /* renamed from: a */
    public Typeface mo22857a(String str, String str2) {
        this.f12558a.mo23141a(str, str2);
        Typeface typeface = (Typeface) this.f12559b.get(this.f12558a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = m15241a(m15242a(str), str2);
        this.f12559b.put(this.f12558a, a);
        return a;
    }

    /* renamed from: a */
    public void mo22858a(C3623a aVar) {
        this.f12562e = aVar;
    }
}
