package com.qiyukf.nim.uikit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import androidx.core.graphics.BitmapCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;

/* renamed from: com.qiyukf.nim.uikit.a */
public final class C5426a {
    /* renamed from: a */
    private static Context f17412a;
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static LruCache<String, Bitmap> f17413b = new LruCache<>(20);

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
            if ((r4 instanceof android.graphics.drawable.BitmapDrawable) != false) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
            if ((r4 instanceof android.graphics.drawable.BitmapDrawable) != false) goto L_0x0020;
     */
    /* renamed from: a */
    public static android.graphics.Bitmap m22173a(java.lang.String r4) {
        /*
        boolean r0 = android.text.TextUtils.isEmpty(r4)
        r1 = 0
        if (r0 == 0) goto L_0x0008
        return r1
    L_0x0008:
        java.lang.String r0 = "staffDefault"
        boolean r0 = r4.contains(r0)
        if (r0 == 0) goto L_0x0027
        android.content.Context r4 = f17412a
        android.content.res.Resources r4 = r4.getResources()
        int r0 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_def_avatar_staff
        android.graphics.drawable.Drawable r4 = r4.getDrawable(r0)
        boolean r0 = r4 instanceof android.graphics.drawable.BitmapDrawable
        if (r0 == 0) goto L_0x0088
    L_0x0020:
        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
        android.graphics.Bitmap r4 = r4.getBitmap()
        return r4
    L_0x0027:
        java.lang.String r0 = "selfDefault"
        boolean r0 = r4.contains(r0)
        if (r0 == 0) goto L_0x0040
        android.content.Context r4 = f17412a
        android.content.res.Resources r4 = r4.getResources()
        int r0 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_def_avatar_user
        android.graphics.drawable.Drawable r4 = r4.getDrawable(r0)
        boolean r0 = r4 instanceof android.graphics.drawable.BitmapDrawable
        if (r0 == 0) goto L_0x0088
        goto L_0x0020
    L_0x0040:
        java.lang.String r0 = "unicorn://"
        boolean r2 = r4.startsWith(r0)
        if (r2 == 0) goto L_0x0088
        r2 = 0
        java.lang.String r3 = ""
        java.lang.String r0 = r4.replace(r0, r3)     // Catch:{ NumberFormatException -> 0x0058 }
        java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0058 }
        int r2 = r0.intValue()     // Catch:{ NumberFormatException -> 0x0058 }
        goto L_0x005e
    L_0x0058:
        r0 = move-exception
        java.lang.String r3 = "本地头像 resid 获取失败 uri:"
        com.qiyukf.basesdk.p393a.C5264a.m21621b(r3, r4, r0)
    L_0x005e:
        if (r2 <= 0) goto L_0x0088
        android.content.Context r4 = f17412a     // Catch:{ NotFoundException -> 0x0075 }
        android.content.res.Resources r4 = r4.getResources()     // Catch:{ NotFoundException -> 0x0075 }
        android.graphics.drawable.Drawable r4 = r4.getDrawable(r2)     // Catch:{ NotFoundException -> 0x0075 }
        boolean r0 = r4 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ NotFoundException -> 0x0075 }
        if (r0 == 0) goto L_0x0088
        android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4     // Catch:{ NotFoundException -> 0x0075 }
        android.graphics.Bitmap r4 = r4.getBitmap()     // Catch:{ NotFoundException -> 0x0075 }
        return r4
    L_0x0075:
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        java.lang.String r0 = "id 为："
        r4.<init>(r0)
        r4.append(r2)
        java.lang.String r4 = r4.toString()
        java.lang.String r0 = "加载本地头像资源失败"
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r0, r4)
    L_0x0088:
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.C5426a.m22173a(java.lang.String):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static Bitmap m22174a(String str, int i, int i2) {
        Bitmap c = m22184c(m22182b(str, i, i2));
        if (c != null) {
            return c;
        }
        UnicornImageLoader f = C6029d.m24046f();
        if (f == null) {
            return null;
        }
        Bitmap loadImageSync = f.loadImageSync(str, i, i2);
        if (loadImageSync == null || loadImageSync.isRecycled()) {
            return null;
        }
        f17413b.put(m22182b(str, i, i2), loadImageSync);
        return loadImageSync;
    }

    /* renamed from: a */
    public static void m22175a() {
        f17413b.evictAll();
    }

    /* renamed from: a */
    public static void m22176a(Context context) {
        f17412a = context;
        C5264a.m21617a("ImageLoaderKit", "init ImageLoaderKit completed");
    }

    /* renamed from: a */
    public static void m22177a(String str, int i, int i2, ImageLoaderListener imageLoaderListener) {
        final String b = m22182b(str, i, i2);
        Bitmap c = m22184c(b);
        if (c == null) {
            final UnicornImageLoader f = C6029d.m24046f();
            if (f != null) {
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                final ImageLoaderListener imageLoaderListener2 = imageLoaderListener;
                C54282 r0 = new Runnable() {
                    public final void run() {
                        f.loadImage(str2, i3, i4, new ImageLoaderListener() {
                            public final void onLoadComplete(Bitmap bitmap) {
                                if (!bitmap.isRecycled()) {
                                    if (BitmapCompat.getAllocationByteCount(bitmap) <= 4194304) {
                                        C5426a.f17413b.put(b, bitmap);
                                    }
                                    if (imageLoaderListener2 != null) {
                                        imageLoaderListener2.onLoadComplete(bitmap);
                                    }
                                } else if (imageLoaderListener2 != null) {
                                    imageLoaderListener2.onLoadFailed(null);
                                }
                            }

                            public final void onLoadFailed(Throwable th) {
                                if (imageLoaderListener2 != null) {
                                    imageLoaderListener2.onLoadFailed(th);
                                }
                            }
                        });
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    r0.run();
                    return;
                }
                C5361a.m22014b().post(r0);
            }
        } else if (imageLoaderListener != null) {
            imageLoaderListener.onLoadComplete(c);
        }
    }

    /* renamed from: a */
    public static void m22178a(String str, ImageView imageView) {
        m22179a(str, imageView, 0, 0);
    }

    /* renamed from: a */
    public static void m22179a(final String str, final ImageView imageView, int i, int i2) {
        if (!m22183b(str)) {
            imageView.setTag(null);
            return;
        }
        imageView.setTag(str);
        m22177a(str, i, i2, (ImageLoaderListener) new ImageLoaderListener() {
            public final void onLoadComplete(Bitmap bitmap) {
                if (imageView.getTag() != null && imageView.getTag().equals(str)) {
                    imageView.setImageBitmap(bitmap);
                }
            }

            public final void onLoadFailed(Throwable th) {
            }
        });
    }

    /* renamed from: a */
    public static void m22180a(String str, ImageLoaderListener imageLoaderListener) {
        m22177a(str, 0, 0, imageLoaderListener);
    }

    /* renamed from: b */
    private static String m22182b(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("#w#");
        sb.append(i);
        sb.append("#h#");
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m22183b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* renamed from: c */
    private static Bitmap m22184c(String str) {
        Bitmap bitmap = (Bitmap) f17413b.get(str);
        if (bitmap == null || !bitmap.isRecycled()) {
            return bitmap;
        }
        f17413b.remove(str);
        return null;
    }
}
