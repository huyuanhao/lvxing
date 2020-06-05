package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader.C2432b;
import com.bytedance.sdk.openadsdk.p188g.p189a.GifLoader.C2433c;

/* renamed from: com.bytedance.sdk.openadsdk.utils.n */
public class ImageBytesHelper {

    /* compiled from: ImageBytesHelper */
    /* renamed from: com.bytedance.sdk.openadsdk.utils.n$a */
    public interface C2558a {
        /* renamed from: a */
        void mo15239a();

        /* renamed from: a */
        void mo15240a(byte[] bArr);
    }

    /* renamed from: a */
    public static void m12184a(Context context, String str, int i, final C2558a aVar) {
        TTNetClient.m11428a(context).mo16659f().mo16632a(str, (C2432b) new C2432b() {
            /* renamed from: a */
            public void mo16638a() {
            }

            /* renamed from: a */
            public void mo16639a(C2433c cVar) {
            }

            /* renamed from: a */
            public void mo16640a(String str, byte[] bArr) {
                if (bArr == null || bArr.length <= 0 || aVar == null) {
                    C2558a aVar = aVar;
                    if (aVar != null) {
                        aVar.mo15239a();
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("图片数据返回成功");
                sb.append(bArr.length);
                C2564t.m12220b("ImageBytesHelper: ", sb.toString());
                aVar.mo15240a(bArr);
            }

            /* renamed from: b */
            public void mo16641b(C2433c cVar) {
                C2558a aVar = aVar;
                if (aVar != null) {
                    aVar.mo15239a();
                }
            }
        }, i, i);
    }

    /* renamed from: a */
    public static Drawable m12183a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
