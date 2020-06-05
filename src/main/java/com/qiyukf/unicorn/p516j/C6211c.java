package com.qiyukf.unicorn.p516j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.basesdk.p412c.p414b.C5376b;
import com.qiyukf.basesdk.p412c.p414b.C5376b.C5377a;
import com.qiyukf.basesdk.p412c.p414b.C5395d;
import com.qiyukf.basesdk.p412c.p414b.C5395d.C5396a;
import com.qiyukf.basesdk.p412c.p414b.C5398f;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5556b;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.p517ui.activity.UrlImagePreviewActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.qiyukf.unicorn.j.c */
public final class C6211c {
    /* renamed from: a */
    private static final int f19392a = C5412d.m22146a(90.0f);
    /* renamed from: b */
    private static final String f19393b = String.format(Locale.getDefault(), "imageView&thumbnail=%dx0", new Object[]{Integer.valueOf(f19392a)});

    /* renamed from: a */
    public static String m24638a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return Html.fromHtml(str.replaceAll("<(img|IMG)\\s+([^>]*)>", C6029d.m24039c().getString(C5961R.string.ysf_msg_notify_image))).toString();
    }

    /* renamed from: a */
    public static void m24639a(final TextView textView, String str, final int i, String str2) {
        final Context context = textView.getContext();
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final C5395d a = C5395d.m22089a(str).mo27349b(str2).mo27345a((C5376b) new C5376b() {
            /* renamed from: a */
            public final Drawable mo27336a() {
                return ContextCompat.getDrawable(context, C5961R.C5962drawable.ysf_image_placeholder_loading);
            }

            /* renamed from: a */
            public final void mo27337a(String str, final C5377a aVar) {
                C5426a.m22180a(C6211c.m24641c(str), (ImageLoaderListener) new ImageLoaderListener() {
                    public final void onLoadComplete(Bitmap bitmap) {
                        aVar.mo27323a(bitmap);
                    }

                    public final void onLoadFailed(Throwable th) {
                        atomicBoolean.set(true);
                        aVar.mo27322a();
                    }
                });
            }

            /* renamed from: b */
            public final Drawable mo27338b() {
                return ContextCompat.getDrawable(context, C5961R.C5962drawable.ysf_image_placeholder_fail);
            }

            /* renamed from: c */
            public final int mo27339c() {
                return i;
            }
        }).mo27346a((C5396a) new C5396a() {
            /* renamed from: a */
            public final CharSequence mo27350a(SpannableStringBuilder spannableStringBuilder) {
                return C5566e.m22593a(context, (CharSequence) C5543f.m22542a(context, spannableStringBuilder));
            }
        });
        a.mo27347a((C5398f) new C5398f() {
            /* renamed from: a */
            public final void mo27351a(Context context, String str, String str2) {
                C5556b.m22584a(context, str, str2);
            }

            /* renamed from: a */
            public final void mo27352a(Context context, List<String> list, int i) {
                if (atomicBoolean.get()) {
                    atomicBoolean.set(false);
                    a.mo27348a(textView);
                }
                UrlImagePreviewActivity.start(context, (ArrayList) list, i);
            }
        });
        a.mo27348a(textView);
    }

    /* renamed from: b */
    public static boolean m24640b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && (host.endsWith("nosdn.127.net") || host.endsWith("nos.netease.com"))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static String m24641c(String str) {
        if (!m24640b(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = "?";
        if (str.contains(str2)) {
            str2 = "&";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(f19393b);
        return sb3.toString();
    }
}
