package com.yanzhenjie.album.p629b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.graphics.drawable.DrawableCompat;
import com.kwad.sdk.core.response.model.AdConfigData;
import com.yanzhenjie.album.provider.CameraFileProvider;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.yanzhenjie.album.b.a */
public class AlbumUtils {
    /* renamed from: a */
    public static File m33538a(Context context) {
        String str = "AlbumCache";
        if (m33546a()) {
            return new File(Environment.getExternalStorageDirectory(), str);
        }
        return new File(context.getFilesDir(), str);
    }

    /* renamed from: a */
    public static boolean m33546a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().canWrite();
        }
        return false;
    }

    /* renamed from: a */
    public static Context m33535a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale);
            return context.createConfigurationContext(configuration);
        }
        configuration.locale = locale;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    /* renamed from: a */
    public static void m33543a(Activity activity, int i, File file) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", m33537a((Context) activity, file));
        intent.addFlags(1);
        intent.addFlags(2);
        activity.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public static void m33544a(Activity activity, int i, File file, int i2, long j, long j2) {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", m33537a((Context) activity, file));
        intent.putExtra("android.intent.extra.videoQuality", i2);
        intent.putExtra("android.intent.extra.durationLimit", j);
        intent.putExtra("android.intent.extra.sizeLimit", j2);
        intent.addFlags(1);
        intent.addFlags(2);
        activity.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public static Uri m33537a(Context context, File file) {
        if (VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return CameraFileProvider.getUriForFile(context, CameraFileProvider.m33641a(context), file);
    }

    @Deprecated
    /* renamed from: b */
    public static String m33547b() {
        return m33540a(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    /* renamed from: b */
    public static String m33548b(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return m33540a(context.getCacheDir());
        }
        return m33547b();
    }

    /* renamed from: a */
    public static String m33540a(File file) {
        return m33541a(file, ".jpg");
    }

    @Deprecated
    /* renamed from: c */
    public static String m33551c() {
        return m33549b(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    /* renamed from: c */
    public static String m33552c(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return m33549b(context.getCacheDir());
        }
        return m33551c();
    }

    /* renamed from: b */
    public static String m33549b(File file) {
        return m33541a(file, ".mp4");
    }

    /* renamed from: a */
    private static String m33541a(File file, String str) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m33542a("yyyyMMdd_HHmmssSSS"));
        sb.append("_");
        sb.append(m33554d(UUID.randomUUID().toString()));
        sb.append(str);
        return new File(file, sb.toString()).getAbsolutePath();
    }

    /* renamed from: a */
    public static String m33542a(String str) {
        return new SimpleDateFormat(str, Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public static String m33550b(String str) {
        String c = m33553c(str);
        String str2 = "";
        if (!MimeTypeMap.getSingleton().hasExtension(c)) {
            return str2;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(c);
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            mimeTypeFromExtension = str2;
        }
        return mimeTypeFromExtension;
    }

    /* renamed from: c */
    public static String m33553c(String str) {
        String str2 = "";
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(TextUtils.isEmpty(str) ? str2 : str.toLowerCase());
        return TextUtils.isEmpty(fileExtensionFromUrl) ? str2 : fileExtensionFromUrl;
    }

    /* renamed from: a */
    public static void m33545a(Drawable drawable, int i) {
        DrawableCompat.setTint(DrawableCompat.wrap(drawable.mutate()), i);
    }

    /* renamed from: a */
    public static ColorStateList m33536a(int i, int i2) {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[]{16842919}, new int[]{16842913}, new int[0], new int[0], new int[0]}, new int[]{i2, i2, i2, i, i, i});
    }

    /* renamed from: a */
    public static String m33539a(long j) {
        String str;
        String str2;
        String str3;
        long j2 = j / 1000;
        int i = (int) (j2 / 3600);
        long j3 = j2 - ((long) (i * AdConfigData.DEFAULT_REQUEST_INTERVAL));
        int i2 = (int) (j3 / 60);
        int i3 = (int) (j3 - ((long) (i2 * 60)));
        String str4 = ":";
        String str5 = "0";
        if (i > 0) {
            if (i >= 10) {
                str3 = Integer.toString(i);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(i);
                str3 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str4);
            str = sb2.toString();
        } else {
            str = "";
        }
        String str6 = "00";
        if (i2 <= 0) {
            str2 = str6;
        } else if (i2 >= 10) {
            str2 = Integer.toString(i2);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str5);
            sb3.append(i2);
            str2 = sb3.toString();
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(str4);
        String sb5 = sb4.toString();
        if (i3 > 0) {
            if (i3 >= 10) {
                str6 = Integer.toString(i3);
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str5);
                sb6.append(i3);
                str6 = sb6.toString();
            }
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(str);
        sb7.append(sb5);
        sb7.append(str6);
        return sb7.toString();
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    public static java.lang.String m33554d(java.lang.String r5) {
        /*
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "MD5"
        java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x0035 }
        byte[] r2 = r5.getBytes()     // Catch:{ Exception -> 0x0035 }
        byte[] r1 = r1.digest(r2)     // Catch:{ Exception -> 0x0035 }
        r2 = 0
    L_0x0014:
        int r3 = r1.length     // Catch:{ Exception -> 0x0035 }
        if (r2 >= r3) goto L_0x0030
        byte r3 = r1[r2]     // Catch:{ Exception -> 0x0035 }
        if (r3 >= 0) goto L_0x001d
        int r3 = r3 + 256
    L_0x001d:
        r4 = 16
        if (r3 >= r4) goto L_0x0026
        java.lang.String r4 = "0"
        r0.append(r4)     // Catch:{ Exception -> 0x0035 }
    L_0x0026:
        java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x0035 }
        r0.append(r3)     // Catch:{ Exception -> 0x0035 }
        int r2 = r2 + 1
        goto L_0x0014
    L_0x0030:
        java.lang.String r5 = r0.toString()
        return r5
    L_0x0035:
        int r5 = r5.hashCode()
        java.lang.String r5 = java.lang.Integer.toString(r5)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.album.p629b.AlbumUtils.m33554d(java.lang.String):java.lang.String");
    }
}
