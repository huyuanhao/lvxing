package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6082b;

/* renamed from: com.qiyukf.unicorn.ui.b.a.b */
public final class C6251b {
    /* renamed from: a */
    public static void m24732a(final C6082b bVar, ViewGroup viewGroup, int i, boolean z) {
        if (TextUtils.equals("image", bVar.mo28949a())) {
            final float dimension = (((z ? viewGroup.getResources().getDimension(C5961R.dimen.ysf_bubble_content_max_width) : (float) C5412d.m22145a()) - ((float) viewGroup.getPaddingLeft())) - ((float) viewGroup.getPaddingRight())) / ((float) i);
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_message_item_card_image, viewGroup, false);
            final ImageView imageView = (ImageView) inflate.findViewById(C5961R.C5963id.ysf_card_image);
            viewGroup.addView(inflate);
            C5426a.m22180a(bVar.mo28951b(), (ImageLoaderListener) new ImageLoaderListener() {
                public final void onLoadComplete(Bitmap bitmap) {
                    int min = (int) Math.min(((float) bitmap.getWidth()) * imageView.getResources().getDisplayMetrics().density, dimension);
                    imageView.setImageBitmap(bitmap);
                    LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
                    layoutParams.width = min;
                    layoutParams.gravity = C6251b.m24734c(bVar);
                    imageView.setLayoutParams(layoutParams);
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
            return;
        }
        TextView textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_message_item_card_text, viewGroup, false);
        viewGroup.addView(textView);
        textView.setText(bVar.mo28951b());
        textView.setTextColor(m24733b(bVar));
        textView.setTextSize(z ? 14.0f : 16.0f);
        textView.setGravity(m24734c(bVar));
        textView.setMaxLines(bVar.mo28950a(8) ? 1 : 3);
        TextPaint paint = textView.getPaint();
        if (bVar.mo28950a(1)) {
            paint.setFakeBoldText(true);
        }
        if (bVar.mo28950a(2)) {
            if (!TextUtils.isEmpty(bVar.mo28951b())) {
                textView.setText(bVar.mo28951b().concat(" "));
            }
            paint.setTextSkewX(-0.2f);
        }
        if (bVar.mo28950a(4)) {
            paint.setUnderlineText(true);
        }
    }

    /* renamed from: b */
    private static int m24733b(C6082b bVar) {
        try {
            return Color.parseColor(bVar.mo28952c());
        } catch (Exception unused) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
    }

    /* access modifiers changed from: private|static */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* renamed from: c */
    public static int m24734c(com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6082b r3) {
        /*
        java.lang.String r3 = r3.mo28953d()
        int r0 = r3.hashCode()
        r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
        r2 = 1
        if (r0 == r1) goto L_0x002d
        r1 = 3317767(0x32a007, float:4.649182E-39)
        if (r0 == r1) goto L_0x0023
        r1 = 108511772(0x677c21c, float:4.6598146E-35)
        if (r0 == r1) goto L_0x0019
        goto L_0x0037
    L_0x0019:
        java.lang.String r0 = "right"
        boolean r3 = r3.equals(r0)
        if (r3 == 0) goto L_0x0037
        r3 = 0
        goto L_0x0038
    L_0x0023:
        java.lang.String r0 = "left"
        boolean r3 = r3.equals(r0)
        if (r3 == 0) goto L_0x0037
        r3 = 2
        goto L_0x0038
    L_0x002d:
        java.lang.String r0 = "center"
        boolean r3 = r3.equals(r0)
        if (r3 == 0) goto L_0x0037
        r3 = 1
        goto L_0x0038
    L_0x0037:
        r3 = -1
    L_0x0038:
        if (r3 == 0) goto L_0x0043
        if (r3 == r2) goto L_0x0040
        r3 = 8388611(0x800003, float:1.1754948E-38)
        return r3
    L_0x0040:
        r3 = 17
        return r3
    L_0x0043:
        r3 = 8388613(0x800005, float:1.175495E-38)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p517ui.p519b.p520a.C6251b.m24734c(com.qiyukf.unicorn.f.a.a.a.e$b):int");
    }
}
