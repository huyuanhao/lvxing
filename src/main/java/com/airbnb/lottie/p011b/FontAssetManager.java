package com.airbnb.lottie.p011b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.model.MutablePair;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.airbnb.lottie.b.a */
public class FontAssetManager {
    /* renamed from: a */
    private final MutablePair<String> f1426a = new MutablePair<>();
    /* renamed from: b */
    private final Map<MutablePair<String>, Typeface> f1427b = new HashMap();
    /* renamed from: c */
    private final Map<String, Typeface> f1428c = new HashMap();
    /* renamed from: d */
    private final AssetManager f1429d;
    /* renamed from: e */
    private FontAssetDelegate f1430e;
    /* renamed from: f */
    private String f1431f = ".ttf";

    public FontAssetManager(Callback callback, FontAssetDelegate aVar) {
        this.f1430e = aVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f1429d = null;
            return;
        }
        this.f1429d = ((View) callback).getContext().getAssets();
    }

    /* renamed from: a */
    public void mo9898a(FontAssetDelegate aVar) {
        this.f1430e = aVar;
    }

    /* renamed from: a */
    public Typeface mo9897a(String str, String str2) {
        this.f1426a.mo10132a(str, str2);
        Typeface typeface = (Typeface) this.f1427b.get(this.f1426a);
        if (typeface != null) {
            return typeface;
        }
        Typeface a = m1304a(m1305a(str), str2);
        this.f1427b.put(this.f1426a, a);
        return a;
    }

    /* renamed from: a */
    private Typeface m1305a(String str) {
        Typeface typeface = (Typeface) this.f1428c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        FontAssetDelegate aVar = this.f1430e;
        if (aVar != null) {
            typeface2 = aVar.mo9844a(str);
        }
        FontAssetDelegate aVar2 = this.f1430e;
        if (aVar2 != null && typeface2 == null) {
            String b = aVar2.mo9845b(str);
            if (b != null) {
                typeface2 = Typeface.createFromAsset(this.f1429d, b);
            }
        }
        if (typeface2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("fonts/");
            sb.append(str);
            sb.append(this.f1431f);
            typeface2 = Typeface.createFromAsset(this.f1429d, sb.toString());
        }
        this.f1428c.put(str, typeface2);
        return typeface2;
    }

    /* renamed from: a */
    private Typeface m1304a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
