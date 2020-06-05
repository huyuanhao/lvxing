package com.qiyukf.unicorn.widget.p521a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.unicorn.widget.a.e */
final class C6360e extends C6353b<C6360e> {
    /* renamed from: d */
    private LinearLayout f19844d;
    /* renamed from: e */
    private View f19845e;

    public C6360e(Context context) {
        super(context);
        this.f19844d = new LinearLayout(context);
        this.f19844d.setOrientation(1);
        this.f19844d.setGravity(1);
        this.f19829b.f19831a.removeAllViews();
        this.f19829b.f19831a.addView(this.f19844d, -1, -2);
    }

    /* renamed from: b */
    private boolean m24997b() {
        return this.f19829b.f19832b.getVisibility() == 0 || this.f19829b.f19833c.getVisibility() == 0;
    }

    /* renamed from: a */
    public final C6360e mo29582a(CharSequence[] charSequenceArr) {
        this.f19844d.removeAllViews();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        LayoutParams layoutParams2 = new LayoutParams(-1, C5412d.m22146a(0.5f));
        for (final int i = 0; i < charSequenceArr.length; i++) {
            View inflate = LayoutInflater.from(this.f19828a).inflate(C5961R.C5964layout.ysf_include_divider, this.f19844d, false);
            this.f19844d.addView(inflate, layoutParams2);
            TextView textView = (TextView) LayoutInflater.from(this.f19828a).inflate(C5961R.C5964layout.ysf_dialog_content_item_list_item, this.f19844d, false);
            textView.setText(charSequenceArr[i]);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6360e.this.f19829b.cancel();
                    if (C6360e.this.f19830c != null) {
                        C6360e.this.f19830c.mo27603a(i);
                    }
                }
            });
            this.f19844d.addView(textView, layoutParams);
            if (i == 0) {
                this.f19845e = inflate;
            }
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
            if (r2 == (r4 - 1)) goto L_0x0062;
     */
    /* renamed from: a */
    public final void mo29571a() {
        /*
        r5 = this;
        android.view.View r0 = r5.f19845e
        boolean r1 = r5.m24997b()
        r2 = 0
        if (r1 == 0) goto L_0x000b
        r1 = 0
        goto L_0x000d
    L_0x000b:
        r1 = 8
    L_0x000d:
        r0.setVisibility(r1)
        java.util.ArrayList r0 = new java.util.ArrayList
        android.widget.LinearLayout r1 = r5.f19844d
        int r1 = r1.getChildCount()
        r0.<init>(r1)
        r1 = 0
    L_0x001c:
        android.widget.LinearLayout r3 = r5.f19844d
        int r3 = r3.getChildCount()
        if (r1 >= r3) goto L_0x0036
        android.widget.LinearLayout r3 = r5.f19844d
        android.view.View r3 = r3.getChildAt(r1)
        boolean r4 = r3 instanceof android.widget.TextView
        if (r4 == 0) goto L_0x0033
        android.widget.TextView r3 = (android.widget.TextView) r3
        r0.add(r3)
    L_0x0033:
        int r1 = r1 + 1
        goto L_0x001c
    L_0x0036:
        int r1 = r0.size()
        if (r2 >= r1) goto L_0x006d
        java.lang.Object r1 = r0.get(r2)
        android.widget.TextView r1 = (android.widget.TextView) r1
        r3 = 1
        int r4 = r0.size()
        if (r2 != 0) goto L_0x005f
        if (r4 != r3) goto L_0x0055
        boolean r3 = r5.m24997b()
        if (r3 == 0) goto L_0x0052
        goto L_0x0062
    L_0x0052:
        int r3 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_dialog_item_single_selector
        goto L_0x0067
    L_0x0055:
        boolean r3 = r5.m24997b()
        if (r3 == 0) goto L_0x005c
        goto L_0x0065
    L_0x005c:
        int r3 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_dialog_item_top_selector
        goto L_0x0067
    L_0x005f:
        int r4 = r4 - r3
        if (r2 != r4) goto L_0x0065
    L_0x0062:
        int r3 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_dialog_item_bottom_selector
        goto L_0x0067
    L_0x0065:
        int r3 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_dialog_item_middle_selector
    L_0x0067:
        r1.setBackgroundResource(r3)
        int r2 = r2 + 1
        goto L_0x0036
    L_0x006d:
        super.mo29571a()
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.widget.p521a.C6360e.mo29571a():void");
    }
}
