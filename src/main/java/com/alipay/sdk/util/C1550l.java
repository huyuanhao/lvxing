package com.alipay.sdk.util;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.p122c.C1513a;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import java.io.ByteArrayInputStream;
import java.io.Closeable;

/* renamed from: com.alipay.sdk.util.l */
public class C1550l {
    /* renamed from: a */
    public static Drawable m4657a(String str, Context context) {
        return m4658a(str, context, 480);
    }

    /* renamed from: a */
    public static Drawable m4658a(String str, Context context, int i) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C1513a.m4508a(str));
            try {
                Options options = new Options();
                if (i <= 0) {
                    i = ScreenUtil.G8_WIDTH;
                }
                options.inDensity = i;
                options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
                m4659a(byteArrayInputStream);
                return bitmapDrawable;
            } catch (Throwable unused) {
                m4659a(byteArrayInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
            m4659a(byteArrayInputStream);
            return null;
        }
    }

    /* renamed from: a */
    private static void m4659a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
