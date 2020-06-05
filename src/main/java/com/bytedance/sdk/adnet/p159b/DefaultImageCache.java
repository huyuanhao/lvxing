package com.bytedance.sdk.adnet.p159b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.core.VNetLog;
import com.bytedance.sdk.adnet.p159b.ImageLoader.C1962b;

/* renamed from: com.bytedance.sdk.adnet.b.a */
public class DefaultImageCache implements C1962b {
    /* renamed from: a */
    protected LruCache<String, Bitmap> f6075a = new LruCache<String, Bitmap>(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    };

    /* renamed from: a */
    public String mo14174a(String str, int i, int i2, ScaleType scaleType) {
        return null;
    }

    /* renamed from: a */
    public Bitmap mo14173a(String str) {
        try {
            return (Bitmap) this.f6075a.get(str);
        } catch (Throwable th) {
            VNetLog.m7927a(th, "DefaultImageCache get bitmap error", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public void mo14175a(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            try {
                this.f6075a.put(str, bitmap);
            } catch (Throwable th) {
                VNetLog.m7927a(th, "DefaultImageCache put bitmap error", new Object[0]);
            }
        }
    }
}
