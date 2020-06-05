package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6074b;

/* renamed from: com.qiyukf.unicorn.ui.b.a.d */
public class C6255d extends C6257e {
    /* renamed from: a */
    private ImageView f19490a;
    /* renamed from: b */
    private TextView f19491b;
    /* renamed from: c */
    private TextView f19492c;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        final C6074b bVar = (C6074b) this.message.getAttachment();
        if (!TextUtils.isEmpty(bVar.mo28929c())) {
            this.f19490a.setVisibility(0);
            C5426a.m22179a(bVar.mo28929c(), this.f19490a, (int) this.context.getResources().getDimension(C5961R.dimen.ysf_bubble_max_width), C5412d.m22146a(92.0f));
        } else {
            this.f19490a.setVisibility(8);
        }
        this.f19491b.setText(bVar.mo28930d());
        this.f19492c.setText(bVar.mo28931e().mo28932a());
        this.f19492c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                C6255d.this.mo29448a(bVar.mo28931e().mo28933b());
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_activity;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19490a = (ImageView) findViewById(C5961R.C5963id.ysf_iv_activity_img);
        this.f19491b = (TextView) findViewById(C5961R.C5963id.ysf_tv_activity_label);
        this.f19492c = (TextView) findViewById(C5961R.C5963id.ysf_btn_activity_action);
    }
}
