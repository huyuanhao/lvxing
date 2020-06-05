package com.tencent.mta.track;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Base64OutputStream;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.as */
class C7359as {
    /* renamed from: a */
    private Bitmap f24919a = null;
    /* renamed from: b */
    private final Paint f24920b = new Paint(2);
    /* renamed from: c */
    private String f24921c = "";

    /* renamed from: a */
    public synchronized void mo35889a(int i, int i2, int i3, Bitmap bitmap) {
        if (!(this.f24919a != null && this.f24919a.getWidth() == i && this.f24919a.getHeight() == i2)) {
            try {
                this.f24919a = Bitmap.createBitmap(i, i2, Config.RGB_565);
            } catch (OutOfMemoryError unused) {
                this.f24919a = null;
            }
            if (this.f24919a != null) {
                this.f24919a.setDensity(i3);
            }
        }
        if (this.f24919a != null) {
            new Canvas(this.f24919a).drawBitmap(bitmap, 0.0f, 0.0f, this.f24920b);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                this.f24919a.compress(CompressFormat.PNG, 10, byteArrayOutputStream);
                this.f24921c = m31764a(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
            } catch (Throwable th) {
                String str = "Snapshot";
                StringBuilder sb = new StringBuilder();
                sb.append("CachedBitmap.recreate;Create image_hash error=");
                sb.append(th);
                Log.e(str, sb.toString());
            }
        }
        return;
    }

    /* renamed from: a */
    public synchronized void mo35890a(CompressFormat compressFormat, int i, OutputStream outputStream) {
        try {
            if (!(this.f24919a == null || this.f24919a.getWidth() == 0)) {
                if (this.f24919a.getHeight() != 0) {
                    outputStream.write(34);
                    Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 2);
                    this.f24919a.compress(CompressFormat.PNG, 10, base64OutputStream);
                    base64OutputStream.flush();
                    outputStream.write(34);
                }
            }
            outputStream.write("null".getBytes());
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public String mo35888a() {
        return this.f24921c;
    }

    /* renamed from: a */
    private String m31764a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = "0123456789ABCDEF";
            sb.append(str2.charAt((bArr[i] >> 4) & 15));
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(str2.charAt(bArr[i] & 15));
            str = sb3.toString();
        }
        return str;
    }
}
