package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6094j;

/* renamed from: com.qiyukf.unicorn.ui.b.a.n */
public class C6283n extends C6257e {
    /* renamed from: a */
    private TextView f19586a;
    /* renamed from: b */
    private TextView f19587b;
    /* renamed from: c */
    private TextView f19588c;
    /* renamed from: d */
    private TextView f19589d;
    /* renamed from: e */
    private View f19590e;
    /* renamed from: f */
    private TextView f19591f;
    /* renamed from: g */
    private LinearLayout f19592g;
    /* renamed from: h */
    private LinearLayout f19593h;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        final C6094j jVar = (C6094j) this.message.getAttachment();
        if (jVar != null) {
            this.f19586a.setText(jVar.mo28998d());
            this.f19587b.setText(jVar.mo28999e());
            this.f19588c.setText(jVar.mo29000f());
            this.f19589d.setText(jVar.mo29001g());
            if (!TextUtils.isEmpty(jVar.mo29002h())) {
                this.f19590e.setVisibility(0);
                this.f19591f.setText(jVar.mo29002h());
                this.f19592g.removeAllViews();
                for (String str : jVar.mo29003i()) {
                    TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_text, this.f19592g, false);
                    textView.setTextSize(14.0f);
                    textView.setTextColor(ContextCompat.getColor(this.context, C5961R.color.ysf_grey_666666));
                    textView.setText(str);
                    LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                    layoutParams.topMargin = C5412d.m22146a(2.0f);
                    this.f19592g.addView(textView, layoutParams);
                }
            } else {
                this.f19590e.setVisibility(8);
            }
            this.f19593h.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!TextUtils.isEmpty(jVar.mo28997c())) {
                        OnMessageItemClickListener onMessageItemClickListener = C6029d.m24045e().onMessageItemClickListener;
                        if (onMessageItemClickListener != null) {
                            onMessageItemClickListener.onURLClicked(C6283n.this.context, jVar.mo28997c());
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_order_detail;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19586a = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_detail_label);
        this.f19587b = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_detail_status);
        this.f19588c = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_detail_person);
        this.f19589d = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_detail_address);
        this.f19590e = findViewById(C5961R.C5963id.ysf_ll_order_detail_order_container);
        this.f19591f = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_detail_order);
        this.f19592g = (LinearLayout) findViewById(C5961R.C5963id.ysf_ll_order_detail_order_item_container);
        this.f19593h = (LinearLayout) findViewById(C5961R.C5963id.ll_message_item_detail_parent);
    }
}
