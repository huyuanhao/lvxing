package com.airbnb.lottie.p011b;

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
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.airbnb.lottie.b.b */
public class ImageAssetManager {
    /* renamed from: a */
    private static final Object f1432a = new Object();
    /* renamed from: b */
    private final Context f1433b;
    /* renamed from: c */
    private String f1434c;
    /* renamed from: d */
    private ImageAssetDelegate f1435d;
    /* renamed from: e */
    private final Map<String, LottieImageAsset> f1436e;

    public ImageAssetManager(Callback callback, String str, ImageAssetDelegate bVar, Map<String, LottieImageAsset> map) {
        this.f1434c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f1434c;
            if (str2.charAt(str2.length() - 1) != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f1434c);
                sb.append('/');
                this.f1434c = sb.toString();
            }
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f1436e = new HashMap();
            this.f1433b = null;
            return;
        }
        this.f1433b = ((View) callback).getContext();
        this.f1436e = map;
        mo9901a(bVar);
    }

    /* renamed from: a */
    public void mo9901a(ImageAssetDelegate bVar) {
        this.f1435d = bVar;
    }

    /* renamed from: a */
    public Bitmap mo9899a(String str) {
        LottieImageAsset fVar = (LottieImageAsset) this.f1436e.get(str);
        if (fVar == null) {
            return null;
        }
        Bitmap c = fVar.mo9994c();
        if (c != null) {
            return c;
        }
        ImageAssetDelegate bVar = this.f1435d;
        if (bVar != null) {
            Bitmap a = bVar.mo9896a(fVar);
            if (a != null) {
                m1308a(str, a);
            }
            return a;
        }
        String b = fVar.mo9993b();
        Options options = new Options();
        options.inScaled = true;
        options.inDensity = 160;
        String str2 = "LOTTIE";
        if (!b.startsWith("data:") || b.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f1434c)) {
                    AssetManager assets = this.f1433b.getAssets();
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f1434c);
                    sb.append(b);
                    return m1308a(str, BitmapFactory.decodeStream(assets.open(sb.toString()), null, options));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e) {
                Log.w(str2, "Unable to open asset.", e);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                return m1308a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                Log.w(str2, "data URL did not have correct base64 format.", e2);
                return null;
            }
        }
    }

    /* renamed from: a */
    public void mo9900a() {
        synchronized (f1432a) {
            for (Entry value : this.f1436e.entrySet()) {
                LottieImageAsset fVar = (LottieImageAsset) value.getValue();
                Bitmap c = fVar.mo9994c();
                if (c != null) {
                    c.recycle();
                    fVar.mo9992a(null);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo9902a(Context context) {
        return (context == null && this.f1433b == null) || this.f1433b.equals(context);
    }

    /* renamed from: a */
    private Bitmap m1308a(String str, Bitmap bitmap) {
        synchronized (f1432a) {
            ((LottieImageAsset) this.f1436e.get(str)).mo9992a(bitmap);
        }
        return bitmap;
    }
}
