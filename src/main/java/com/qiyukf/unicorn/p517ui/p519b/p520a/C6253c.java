package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6072a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6072a.C6073a;

/* renamed from: com.qiyukf.unicorn.ui.b.a.c */
public class C6253c extends C6257e {
    /* renamed from: a */
    private TextView f19486a;
    /* renamed from: b */
    private LinearLayout f19487b;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        C6072a aVar = (C6072a) this.message.getAttachment();
        this.f19486a.setText(aVar.mo28923c());
        this.f19487b.removeAllViews();
        for (final C6073a aVar2 : aVar.mo28924d()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_button, this.f19487b, false);
            textView.setText(aVar2.mo28925a());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (TextUtils.equals("url", aVar2.mo28926b())) {
                        C6253c.this.mo29448a(aVar2.mo28927c());
                    } else {
                        C6253c.this.mo29450a(aVar2.mo28927c(), aVar2.mo28928d(), aVar2.mo28925a());
                    }
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = C5412d.m22146a(15.0f);
            this.f19487b.addView(textView, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_action_list;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19486a = (TextView) findViewById(C5961R.C5963id.ysf_tv_action_list_label);
        this.f19487b = (LinearLayout) findViewById(C5961R.C5963id.ysf_ll_action_list_action_container);
    }
}
