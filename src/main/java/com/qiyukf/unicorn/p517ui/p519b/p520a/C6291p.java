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
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6099l;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6099l.C6100a;

/* renamed from: com.qiyukf.unicorn.ui.b.a.p */
public class C6291p extends C6257e {
    /* renamed from: a */
    private TextView f19625a;
    /* renamed from: b */
    private LinearLayout f19626b;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        C6099l lVar = (C6099l) this.message.getAttachment();
        this.f19625a.setText(lVar.mo29023c());
        this.f19626b.removeAllViews();
        TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_text, this.f19626b, false);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColor(this.context, C5961R.color.ysf_grey_666666));
        textView.setText(lVar.mo29024d());
        this.f19626b.addView(textView);
        for (final C6100a aVar : lVar.mo29025e()) {
            TextView textView2 = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_bot_button, this.f19626b, false);
            textView2.setText(aVar.mo29029d());
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!"url".equals(aVar.mo29026a()) || TextUtils.isEmpty(aVar.mo29027b())) {
                        C6291p.this.mo29450a(aVar.mo29027b(), aVar.mo29028c(), aVar.mo29029d());
                        return;
                    }
                    OnMessageItemClickListener onMessageItemClickListener = C6029d.m24045e().onMessageItemClickListener;
                    if (onMessageItemClickListener != null) {
                        onMessageItemClickListener.onURLClicked(C6291p.this.context, aVar.mo29027b());
                    }
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView2.getLayoutParams();
            layoutParams.topMargin = C5412d.m22146a(10.0f);
            this.f19626b.addView(textView2, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_order_status;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19625a = (TextView) findViewById(C5961R.C5963id.ysf_tv_order_status_label);
        this.f19626b = (LinearLayout) findViewById(C5961R.C5963id.ysf_order_status_action_container);
    }
}
