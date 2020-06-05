package com.qiyukf.basesdk.p412c.p414b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Html.ImageGetter;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p414b.C5376b.C5377a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.qiyukf.basesdk.c.b.a */
final class C5367a implements ImageGetter {
    /* renamed from: a */
    private static final Pattern f17313a = Pattern.compile("<(img|IMG)\\s+([^>]*)>");
    /* renamed from: b */
    private static final Pattern f17314b = Pattern.compile("(width|WIDTH)\\s*=\\s*\"?(\\w+)\"?");
    /* renamed from: c */
    private static final Pattern f17315c = Pattern.compile("(height|HEIGHT)\\s*=\\s*\"?(\\w+)\"?");
    /* access modifiers changed from: private */
    /* renamed from: d */
    public TextView f17316d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5376b f17317e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<C5372b> f17318f = new ArrayList();
    /* renamed from: g */
    private int f17319g;

    /* renamed from: com.qiyukf.basesdk.c.b.a$a */
    private class C5371a extends BitmapDrawable {
        /* renamed from: b */
        private final int f17326b;
        /* renamed from: c */
        private Drawable f17327c;

        public C5371a(int i) {
            this.f17326b = i;
        }

        /* renamed from: a */
        private int m22052a() {
            return C5367a.this.f17316d.getResources().getDisplayMetrics().heightPixels;
        }

        /* renamed from: a */
        private int m22053a(float f) {
            return (int) ((f * C5367a.this.f17316d.getResources().getDisplayMetrics().density) + 0.5f);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
        /* renamed from: a */
        public final void mo27326a(android.graphics.drawable.Drawable r4, boolean r5) {
            /*
            r3 = this;
            r3.f17327c = r4
            android.graphics.drawable.Drawable r4 = r3.f17327c
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r3.setBounds(r0, r0, r0, r0)
            return
        L_0x000b:
            com.qiyukf.basesdk.c.b.a r4 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            com.qiyukf.basesdk.c.b.b r4 = r4.f17317e
            if (r4 != 0) goto L_0x0015
            r4 = 0
            goto L_0x001f
        L_0x0015:
            com.qiyukf.basesdk.c.b.a r4 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            com.qiyukf.basesdk.c.b.b r4 = r4.f17317e
            int r4 = r4.mo27339c()
        L_0x001f:
            com.qiyukf.basesdk.c.b.a r1 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            com.qiyukf.basesdk.c.b.b r1 = r1.f17317e
            if (r1 == 0) goto L_0x002c
            com.qiyukf.basesdk.c.b.a r1 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            r1.f17317e
        L_0x002c:
            if (r5 == 0) goto L_0x006a
            com.qiyukf.basesdk.c.b.a r5 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            java.util.List r5 = r5.f17318f
            int r5 = r5.size()
            int r1 = r3.f17326b
            if (r5 <= r1) goto L_0x004b
            com.qiyukf.basesdk.c.b.a r5 = com.qiyukf.basesdk.p412c.p414b.C5367a.this
            java.util.List r5 = r5.f17318f
            int r1 = r3.f17326b
            java.lang.Object r5 = r5.get(r1)
            com.qiyukf.basesdk.c.b.a$b r5 = (com.qiyukf.basesdk.p412c.p414b.C5367a.C5372b) r5
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            if (r5 == 0) goto L_0x006a
            boolean r1 = r5.mo27328a()
            if (r1 == 0) goto L_0x006a
            int r1 = r5.f17328a
            float r1 = (float) r1
            int r1 = r3.m22053a(r1)
            int r5 = r5.f17329b
            float r5 = (float) r5
            int r5 = r3.m22053a(r5)
            r2 = r1
            r1 = r5
            r5 = r2
            goto L_0x0076
        L_0x006a:
            android.graphics.drawable.Drawable r5 = r3.f17327c
            int r5 = r5.getIntrinsicWidth()
            android.graphics.drawable.Drawable r1 = r3.f17327c
            int r1 = r1.getIntrinsicHeight()
        L_0x0076:
            if (r5 <= 0) goto L_0x0091
            if (r1 <= 0) goto L_0x0091
            if (r4 <= 0) goto L_0x0087
            if (r5 <= r4) goto L_0x0087
            float r1 = (float) r1
            float r5 = (float) r5
            float r1 = r1 / r5
            float r5 = (float) r4
            float r1 = r1 * r5
            int r5 = (int) r1
            r1 = r5
            r5 = r4
        L_0x0087:
            int r4 = r3.m22052a()
            if (r1 <= r4) goto L_0x0091
            int r1 = r3.m22052a()
        L_0x0091:
            android.graphics.drawable.Drawable r4 = r3.f17327c
            r4.setBounds(r0, r0, r5, r1)
            r3.setBounds(r0, r0, r5, r1)
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.p412c.p414b.C5367a.C5371a.mo27326a(android.graphics.drawable.Drawable, boolean):void");
        }

        public final void draw(Canvas canvas) {
            Drawable drawable = this.f17327c;
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                }
                this.f17327c.draw(canvas);
            }
        }
    }

    /* renamed from: com.qiyukf.basesdk.c.b.a$b */
    private static class C5372b {
        /* access modifiers changed from: private|final */
        /* renamed from: a */
        public final int f17328a;
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final int f17329b;

        public C5372b(int i, int i2) {
            this.f17328a = i;
            this.f17329b = i2;
        }

        /* renamed from: a */
        public final boolean mo27328a() {
            return this.f17328a >= 0 && this.f17329b >= 0;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22043a(C5367a aVar, Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            aVar.f17316d.post(runnable);
        }
    }

    /* renamed from: b */
    private static int m22044b(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public final void mo27318a(TextView textView) {
        this.f17316d = textView;
    }

    /* renamed from: a */
    public final void mo27319a(C5376b bVar) {
        this.f17317e = bVar;
    }

    /* renamed from: a */
    public final void mo27320a(String str) {
        Matcher matcher = f17313a.matcher(str);
        while (matcher.find()) {
            String trim = matcher.group(2).trim();
            Matcher matcher2 = f17314b.matcher(trim);
            int i = -1;
            int b = matcher2.find() ? m22044b(matcher2.group(2).trim()) : -1;
            Matcher matcher3 = f17315c.matcher(trim);
            if (matcher3.find()) {
                i = m22044b(matcher3.group(2).trim());
            }
            this.f17318f.add(new C5372b(b, i));
        }
    }

    public final Drawable getDrawable(String str) {
        int i = this.f17319g;
        this.f17319g = i + 1;
        final C5371a aVar = new C5371a(i);
        C5376b bVar = this.f17317e;
        if (bVar != null) {
            aVar.mo27326a(bVar.mo27336a(), false);
            this.f17317e.mo27337a(str, new C5377a() {
                /* renamed from: a */
                public final void mo27322a() {
                    C5367a.m22043a(C5367a.this, new Runnable() {
                        public final void run() {
                            aVar.mo27326a(C5367a.this.f17317e.mo27338b(), false);
                            C5367a.this.f17316d.setText(C5367a.this.f17316d.getText());
                        }
                    });
                }

                /* renamed from: a */
                public final void mo27323a(final Bitmap bitmap) {
                    C5367a.m22043a(C5367a.this, new Runnable() {
                        public final void run() {
                            aVar.mo27326a(new BitmapDrawable(C5367a.this.f17316d.getResources(), bitmap), true);
                            C5367a.this.f17316d.setText(C5367a.this.f17316d.getText());
                        }
                    });
                }
            });
        }
        return aVar;
    }
}
