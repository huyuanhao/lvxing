package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.tencent.bugly.beta.utils.C7155c;
import com.tencent.bugly.crashreport.common.info.C7174a;
import com.tencent.bugly.proguard.C7226an;
import com.tencent.bugly.proguard.C7232aq;
import com.tencent.bugly.proguard.C7270p;
import java.io.File;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.a */
public class C7127a {
    /* renamed from: a */
    public static int m30539a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getType() == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            if (!C7226an.m31142a(e)) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static int m30540a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static BitmapDrawable m30543a(Bitmap bitmap, int i, int i2, float f) {
        int i3 = (int) (((float) (C7131e.f23698E.f23701B.widthPixels * C7131e.f23698E.f23701B.heightPixels)) * 0.8f);
        if (bitmap == null || i * i2 > i3) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i, i2);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRoundRect(rectF, f, f, paint);
        canvas.drawRect(0.0f, f, (float) i, (float) i2, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(createBitmap);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d8 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dd A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e6 A[Catch:{ Exception -> 0x003a }] */
    /* renamed from: a */
    public static android.graphics.Bitmap m30541a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
        r0 = r19
        r1 = r20
        r2 = 0
        if (r1 == 0) goto L_0x00f7
        int r3 = r1.length
        if (r3 <= 0) goto L_0x00f7
        r3 = 1
        if (r0 == 0) goto L_0x0011
        if (r0 == r3) goto L_0x0011
        goto L_0x00f7
    L_0x0011:
        r4 = 0
        if (r0 != 0) goto L_0x003d
        r5 = r1[r4]     // Catch:{ Exception -> 0x003a }
        java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x003a }
        boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x003a }
        if (r5 == 0) goto L_0x001f
        return r2
    L_0x001f:
        java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x003a }
        r1 = r1[r4]     // Catch:{ Exception -> 0x003a }
        java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x003a }
        r5.<init>(r1)     // Catch:{ Exception -> 0x003a }
        boolean r1 = r5.exists()     // Catch:{ Exception -> 0x003a }
        if (r1 == 0) goto L_0x0039
        long r6 = r5.length()     // Catch:{ Exception -> 0x003a }
        r8 = 1048576(0x100000, double:5.180654E-318)
        int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r1 <= 0) goto L_0x004a
    L_0x0039:
        return r2
    L_0x003a:
        r0 = move-exception
        goto L_0x00f2
    L_0x003d:
        if (r0 != r3) goto L_0x0049
        r1 = r1[r4]     // Catch:{ Exception -> 0x003a }
        java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x003a }
        int r1 = r1.intValue()     // Catch:{ Exception -> 0x003a }
        r5 = r2
        goto L_0x004b
    L_0x0049:
        r5 = r2
    L_0x004a:
        r1 = 0
    L_0x004b:
        com.tencent.bugly.beta.global.e r6 = com.tencent.bugly.beta.global.C7131e.f23698E     // Catch:{ Exception -> 0x003a }
        android.util.DisplayMetrics r6 = r6.f23701B     // Catch:{ Exception -> 0x003a }
        int r6 = r6.widthPixels     // Catch:{ Exception -> 0x003a }
        if (r6 <= 0) goto L_0x00d8
        android.graphics.BitmapFactory$Options r7 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x003a }
        r7.<init>()     // Catch:{ Exception -> 0x003a }
        r7.inJustDecodeBounds = r3     // Catch:{ Exception -> 0x003a }
        if (r0 != 0) goto L_0x0064
        java.lang.String r8 = r5.getPath()     // Catch:{ Exception -> 0x003a }
        android.graphics.BitmapFactory.decodeFile(r8, r7)     // Catch:{ Exception -> 0x003a }
        goto L_0x006d
    L_0x0064:
        if (r0 != r3) goto L_0x006d
        android.content.res.Resources r8 = r18.getResources()     // Catch:{ Exception -> 0x003a }
        android.graphics.BitmapFactory.decodeResource(r8, r1, r7)     // Catch:{ Exception -> 0x003a }
    L_0x006d:
        int r8 = r7.outHeight     // Catch:{ Exception -> 0x003a }
        float r8 = (float) r8     // Catch:{ Exception -> 0x003a }
        int r9 = r7.outWidth     // Catch:{ Exception -> 0x003a }
        float r9 = (float) r9     // Catch:{ Exception -> 0x003a }
        float r8 = r8 / r9
        float r9 = (float) r6     // Catch:{ Exception -> 0x003a }
        float r9 = r9 * r8
        int r8 = (int) r9     // Catch:{ Exception -> 0x003a }
        int r9 = java.lang.Math.min(r6, r8)     // Catch:{ Exception -> 0x003a }
        int r10 = r7.outWidth     // Catch:{ Exception -> 0x003a }
        double r10 = (double) r10     // Catch:{ Exception -> 0x003a }
        int r12 = r7.outHeight     // Catch:{ Exception -> 0x003a }
        double r12 = (double) r12     // Catch:{ Exception -> 0x003a }
        int r14 = r6 * r8
        r15 = -1
        if (r14 != r15) goto L_0x0088
        goto L_0x0099
    L_0x0088:
        double r16 = r10 * r12
        double r2 = (double) r6     // Catch:{ Exception -> 0x003a }
        double r16 = r16 / r2
        double r2 = (double) r8     // Catch:{ Exception -> 0x003a }
        double r16 = r16 * r2
        double r2 = java.lang.Math.sqrt(r16)     // Catch:{ Exception -> 0x003a }
        double r2 = java.lang.Math.ceil(r2)     // Catch:{ Exception -> 0x003a }
        int r3 = (int) r2     // Catch:{ Exception -> 0x003a }
    L_0x0099:
        if (r9 != r15) goto L_0x00a2
        r2 = 128(0x80, float:1.794E-43)
        r20 = r5
        r4 = 128(0x80, float:1.794E-43)
        goto L_0x00b4
    L_0x00a2:
        r20 = r5
        double r4 = (double) r9     // Catch:{ Exception -> 0x003a }
        double r10 = r10 / r4
        double r10 = java.lang.Math.floor(r10)     // Catch:{ Exception -> 0x003a }
        double r12 = r12 / r4
        double r4 = java.lang.Math.floor(r12)     // Catch:{ Exception -> 0x003a }
        double r4 = java.lang.Math.min(r10, r4)     // Catch:{ Exception -> 0x003a }
        int r4 = (int) r4     // Catch:{ Exception -> 0x003a }
    L_0x00b4:
        if (r14 != r15) goto L_0x00ba
        if (r9 != r15) goto L_0x00ba
        r3 = 1
        goto L_0x00be
    L_0x00ba:
        if (r9 != r15) goto L_0x00bd
        goto L_0x00be
    L_0x00bd:
        r3 = r4
    L_0x00be:
        r4 = 8
        if (r3 > r4) goto L_0x00c8
        r4 = 1
    L_0x00c3:
        if (r4 >= r3) goto L_0x00cd
        int r4 = r4 << 1
        goto L_0x00c3
    L_0x00c8:
        int r3 = r3 + 7
        int r3 = r3 / r4
        int r4 = r3 * 8
    L_0x00cd:
        r7.inSampleSize = r4     // Catch:{ Exception -> 0x003a }
        r2 = 0
        r7.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x003a }
        r2 = 1
        r7.inInputShareable = r2     // Catch:{ Exception -> 0x003a }
        r7.inPurgeable = r2     // Catch:{ Exception -> 0x003a }
        goto L_0x00db
    L_0x00d8:
        r20 = r5
        r7 = 0
    L_0x00db:
        if (r0 != 0) goto L_0x00e6
        java.lang.String r0 = r20.getPath()     // Catch:{ Exception -> 0x003a }
        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r7)     // Catch:{ Exception -> 0x003a }
        return r0
    L_0x00e6:
        r2 = 1
        if (r0 != r2) goto L_0x00f5
        android.content.res.Resources r0 = r18.getResources()     // Catch:{ Exception -> 0x003a }
        android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r1, r7)     // Catch:{ Exception -> 0x003a }
        return r0
    L_0x00f2:
        r0.printStackTrace()
    L_0x00f5:
        r1 = 0
        return r1
    L_0x00f7:
        r1 = r2
        return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7127a.m30541a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static boolean m30549a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(".apk")) {
                    String a = C7232aq.m31182a(file, "MD5");
                    if (TextUtils.isEmpty(str) || TextUtils.equals(str.toUpperCase(), a)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("chmod 777 ");
                        sb.append(file.getAbsolutePath());
                        Runtime.getRuntime().exec(sb.toString());
                        Intent intent = new Intent("android.intent.action.VIEW");
                        String str2 = "application/vnd.android.package-archive";
                        if (VERSION.SDK_INT >= 24) {
                            String str3 = "androidx.core.content.FileProvider";
                            intent.addFlags(1);
                            if (Class.forName(str3) == null) {
                                C7226an.m31149e("can't find class android.support.v4.content.FileProvider", new Object[0]);
                                return false;
                            }
                            Class[] clsArr = {Context.class, String.class, File.class};
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(C7174a.m30753a(context).f24023d);
                            sb2.append(".fileProvider");
                            Uri uri = (Uri) C7232aq.m31176a(str3, "getUriForFile", null, clsArr, new Object[]{context, sb2.toString(), file});
                            if (uri == null) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("file location is ");
                                sb3.append(file.toString());
                                C7226an.m31149e(sb3.toString(), new Object[0]);
                                C7226an.m31149e("install failed, contentUri is null!", new Object[0]);
                                return false;
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("contentUri is ");
                            sb4.append(uri);
                            C7226an.m31147c(sb4.toString(), new Object[0]);
                            intent.setDataAndType(uri, str2);
                        } else {
                            intent.setDataAndType(Uri.fromFile(file), str2);
                        }
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        m30547a("installApkMd5", a);
                        return true;
                    }
                    C7226an.m31141a("md5 error [file md5: %s] [target md5: %s]", a, str);
                    return false;
                }
            } catch (Exception e) {
                if (!C7226an.m31145b(e)) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m30551a(File file, String str, String str2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String a = C7232aq.m31182a(file, str2);
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.equals(str.toUpperCase(), a)) {
                            return true;
                        }
                    }
                    C7226an.m31141a("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", a, str);
                    return false;
                }
            } catch (Exception unused) {
                C7226an.m31149e("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x004d A[SYNTHETIC, Splitter:B:39:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0052 A[Catch:{ IOException -> 0x0032 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0059 A[SYNTHETIC, Splitter:B:46:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0061 A[Catch:{ IOException -> 0x005d }] */
    /* renamed from: a */
    public static boolean m30550a(java.io.File r3, java.io.File r4) {
        /*
        r0 = 0
        if (r3 == 0) goto L_0x0069
        r1 = 0
        boolean r2 = r3.exists()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
        if (r2 == 0) goto L_0x0069
        boolean r2 = r3.isDirectory()     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
        if (r2 == 0) goto L_0x0012
        goto L_0x0069
    L_0x0012:
        java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
        r2.<init>(r3)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
        java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003f, all -> 0x003b }
        r3.<init>(r4, r0)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
        r4 = 1048576(0x100000, float:1.469368E-39)
        byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
    L_0x0020:
        int r1 = r2.read(r4)     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
        if (r1 <= 0) goto L_0x002a
        r3.write(r4, r0, r1)     // Catch:{ Exception -> 0x0039, all -> 0x0037 }
        goto L_0x0020
    L_0x002a:
        r0 = 1
        r2.close()     // Catch:{ IOException -> 0x0032 }
        r3.close()     // Catch:{ IOException -> 0x0032 }
        goto L_0x0055
    L_0x0032:
        r3 = move-exception
        r3.printStackTrace()
        goto L_0x0055
    L_0x0037:
        r4 = move-exception
        goto L_0x003d
    L_0x0039:
        r4 = move-exception
        goto L_0x0041
    L_0x003b:
        r4 = move-exception
        r3 = r1
    L_0x003d:
        r1 = r2
        goto L_0x0057
    L_0x003f:
        r4 = move-exception
        r3 = r1
    L_0x0041:
        r1 = r2
        goto L_0x0048
    L_0x0043:
        r4 = move-exception
        r3 = r1
        goto L_0x0057
    L_0x0046:
        r4 = move-exception
        r3 = r1
    L_0x0048:
        r4.printStackTrace()     // Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0050
        r1.close()     // Catch:{ IOException -> 0x0032 }
    L_0x0050:
        if (r3 == 0) goto L_0x0055
        r3.close()     // Catch:{ IOException -> 0x0032 }
    L_0x0055:
        return r0
    L_0x0056:
        r4 = move-exception
    L_0x0057:
        if (r1 == 0) goto L_0x005f
        r1.close()     // Catch:{ IOException -> 0x005d }
        goto L_0x005f
    L_0x005d:
        r3 = move-exception
        goto L_0x0065
    L_0x005f:
        if (r3 == 0) goto L_0x0068
        r3.close()     // Catch:{ IOException -> 0x005d }
        goto L_0x0068
    L_0x0065:
        r3.printStackTrace()
    L_0x0068:
        throw r4
    L_0x0069:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7127a.m30550a(java.io.File, java.io.File):boolean");
    }

    /* renamed from: a */
    public static Bitmap m30542a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /* renamed from: a */
    public static void m30546a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (!file2.delete()) {
                        C7226an.m31149e("cannot delete file:%s", file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
            return r1;
     */
    /* renamed from: a */
    public static synchronized <T extends android.os.Parcelable> boolean m30553a(java.lang.String r4, T r5) {
        /*
        java.lang.Class<com.tencent.bugly.beta.global.a> r0 = com.tencent.bugly.beta.global.C7127a.class
        monitor-enter(r0)
        r1 = 0
        if (r5 != 0) goto L_0x0008
        monitor-exit(r0)
        return r1
    L_0x0008:
        byte[] r5 = com.tencent.bugly.proguard.C7232aq.m31199a(r5)     // Catch:{ all -> 0x001b }
        if (r5 == 0) goto L_0x0019
        com.tencent.bugly.proguard.p r2 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ all -> 0x001b }
        r3 = 1002(0x3ea, float:1.404E-42)
        boolean r4 = r2.mo34951a(r3, r4, r5)     // Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0019
        r1 = 1
    L_0x0019:
        monitor-exit(r0)
        return r1
    L_0x001b:
        r4 = move-exception
        monitor-exit(r0)
        throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7127a.m30553a(java.lang.String, android.os.Parcelable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0023, code lost:
            return null;
     */
    /* renamed from: a */
    public static synchronized <T extends android.os.Parcelable> T m30544a(java.lang.String r3, android.os.Parcelable.Creator<T> r4) {
        /*
        java.lang.Class<com.tencent.bugly.beta.global.a> r0 = com.tencent.bugly.beta.global.C7127a.class
        monitor-enter(r0)
        com.tencent.bugly.proguard.p r1 = com.tencent.bugly.proguard.C7270p.f24600a     // Catch:{ all -> 0x0024 }
        java.util.Map r1 = r1.mo34957c()     // Catch:{ all -> 0x0024 }
        r2 = 0
        if (r1 != 0) goto L_0x000e
        monitor-exit(r0)
        return r2
    L_0x000e:
        java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0024 }
        byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x0024 }
        if (r3 == 0) goto L_0x0022
        int r1 = r3.length     // Catch:{ all -> 0x0024 }
        if (r1 > 0) goto L_0x001a
        goto L_0x0022
    L_0x001a:
        java.lang.Object r3 = com.tencent.bugly.proguard.C7232aq.m31177a(r3, r4)     // Catch:{ all -> 0x0024 }
        android.os.Parcelable r3 = (android.os.Parcelable) r3     // Catch:{ all -> 0x0024 }
        monitor-exit(r0)
        return r3
    L_0x0022:
        monitor-exit(r0)
        return r2
    L_0x0024:
        r3 = move-exception
        monitor-exit(r0)
        throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.C7127a.m30544a(java.lang.String, android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* renamed from: a */
    public static synchronized boolean m30552a(String str) {
        boolean c;
        synchronized (C7127a.class) {
            c = C7270p.f24600a.mo34958c(str);
        }
        return c;
    }

    /* renamed from: b */
    public static String m30554b(String str) {
        return new C7155c(str).mo34488a();
    }

    /* renamed from: a */
    public static void m30547a(String str, String str2) {
        if (C7131e.f23698E.f23700A != null) {
            C7131e.f23698E.f23700A.edit().putString(str, str2).apply();
        }
    }

    /* renamed from: a */
    public static void m30548a(String str, boolean z) {
        if (C7131e.f23698E.f23700A != null) {
            C7131e.f23698E.f23700A.edit().putBoolean(str, z).apply();
        }
    }

    /* renamed from: b */
    public static String m30555b(String str, String str2) {
        return C7131e.f23698E.f23700A != null ? C7131e.f23698E.f23700A.getString(str, str2) : str2;
    }

    /* renamed from: b */
    public static boolean m30556b(String str, boolean z) {
        return C7131e.f23698E.f23700A != null ? C7131e.f23698E.f23700A.getBoolean(str, z) : z;
    }

    /* renamed from: a */
    public static String m30545a(Context context, String str) {
        String str2 = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    Object obj = applicationInfo.metaData.get(str);
                    if (obj != null) {
                        str2 = String.valueOf(obj);
                    }
                }
            }
            return str2;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getManifestMetaDataValue exception:");
            sb.append(e.getMessage());
            C7226an.m31146c(C7127a.class, sb.toString(), new Object[0]);
            return null;
        }
    }
}
