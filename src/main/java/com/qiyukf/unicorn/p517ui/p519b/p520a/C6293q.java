package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6101m;

/* renamed from: com.qiyukf.unicorn.ui.b.a.q */
public class C6293q extends C6257e {
    /* renamed from: a */
    private TextView f19629a;
    /* renamed from: b */
    private ImageView f19630b;
    /* renamed from: c */
    private TextView f19631c;
    /* renamed from: d */
    private LinearLayout f19632d;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        C6101m mVar = (C6101m) this.message.getAttachment();
        this.f19629a.setText(mVar.mo29030c());
        this.f19631c.setText(mVar.mo29031d().mo29034b());
        this.f19630b.setSelected(TextUtils.equals(mVar.mo29031d().mo29033a(), "success"));
        this.f19632d.removeAllViews();
        for (String str : mVar.mo29032e()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_text, this.f19632d, false);
            textView.setTextSize(14.0f);
            textView.setTextColor(ContextCompat.getColor(this.context, C5961R.color.ysf_grey_666666));
            textView.setText(str);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = C5412d.m22146a(10.0f);
            this.f19632d.addView(textView, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_refund;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19629a = (TextView) findViewById(C5961R.C5963id.ysf_tv_refund_label);
        this.f19630b = (ImageView) findViewById(C5961R.C5963id.ysf_iv_refund_state_icon);
        this.f19631c = (TextView) findViewById(C5961R.C5963id.ysf_tv_refund_state);
        this.f19632d = (LinearLayout) findViewById(C5961R.C5963id.ysf_ll_refund_item_container);
    }
}
