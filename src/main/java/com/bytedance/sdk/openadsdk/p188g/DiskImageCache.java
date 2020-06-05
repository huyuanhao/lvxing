package com.bytedance.sdk.openadsdk.p188g;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.bytedance.sdk.adnet.AdNetSdk;
import com.bytedance.sdk.adnet.p159b.DefaultImageCache;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.p164b.DiskUsage;
import com.bytedance.sdk.openadsdk.p164b.TotalSizeLruDiskUsage;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.bytedance.sdk.openadsdk.utils.DigestUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.WeakHashMap;

/* renamed from: com.bytedance.sdk.openadsdk.g.a */
class DiskImageCache extends DefaultImageCache {
    /* renamed from: b */
    private static String f8666b;
    /* renamed from: c */
    private WeakHashMap<String, String> f8667c = new WeakHashMap<>();
    /* renamed from: d */
    private final DiskUsage f8668d = new TotalSizeLruDiskUsage();

    /* renamed from: a */
    public static DiskImageCache m11364a() {
        return new DiskImageCache();
    }

    private DiskImageCache() {
    }

    /* renamed from: a */
    public Bitmap mo14173a(String str) {
        FileInputStream fileInputStream;
        Bitmap a = super.mo14173a(str);
        if (a == null) {
            File file = new File(m11365b(), str);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        a = BitmapFactory.decodeFileDescriptor(fileInputStream.getFD(), null, null);
                        if (a != null) {
                            super.mo14175a(str, a);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            C2564t.m12223c("DiskImageCache", "diskImageCache getBitmap error ", th);
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    C2564t.m12223c("DiskImageCache", "diskImageCache getBitmap error ", th);
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    public void mo14175a(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        if (bitmap != null) {
            super.mo14175a(str, bitmap);
            File file = new File(m11365b(), str);
            if (!file.exists() || !file.isFile() || file.length() <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(file);
                sb.append(".tmp");
                File file2 = new File(sb.toString());
                file2.delete();
                try {
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        if (file2.exists() && file2.length() > 0) {
                            file2.renameTo(file);
                        }
                        this.f8668d.mo14986a(file);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            C2564t.m12223c("DiskImageCache", "diskImageCache putBitmap error ", th);
                            file2.delete();
                            file.delete();
                        } finally {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    C2564t.m12223c("DiskImageCache", "diskImageCache putBitmap error ", th);
                    file2.delete();
                    file.delete();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    /* renamed from: a */
    public String mo14174a(String str, int i, int i2, ScaleType scaleType) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) this.f8667c.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String a = DigestUtils.m12169a(str);
        this.f8667c.put(str, a);
        return a;
    }

    /* renamed from: b */
    private static String m11365b() {
        if (TextUtils.isEmpty(f8666b)) {
            File file = new File(AdNetSdk.m7649b(InternalContainer.m10059a()), "diskImage");
            file.mkdirs();
            f8666b = file.getAbsolutePath();
        }
        return f8666b;
    }
}
