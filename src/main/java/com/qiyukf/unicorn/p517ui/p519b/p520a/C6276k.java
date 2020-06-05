package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6086g;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6086g.C6088b;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.a.k */
public class C6276k extends C6257e implements OnClickListener {
    /* renamed from: a */
    private TextView f19569a;
    /* renamed from: b */
    private TextView f19570b;
    /* renamed from: c */
    private LinearLayout f19571c;
    /* renamed from: d */
    private View f19572d;
    /* renamed from: e */
    private View f19573e;
    /* renamed from: f */
    private TextView f19574f;

    /* renamed from: a */
    private void m24791a(List<C6088b> list, int i) {
        this.f19571c.removeAllViews();
        int min = Math.min(list.size(), Math.max(0, i));
        int i2 = 0;
        while (i2 < min) {
            C6088b bVar = (C6088b) list.get(i2);
            View inflate = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_logistic_item, this.f19571c, false);
            View findViewById = inflate.findViewById(C5961R.C5963id.ysf_iv_logistic_icon);
            View findViewById2 = inflate.findViewById(C5961R.C5963id.ysf_logistic_line);
            TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_logistic_transport_message);
            TextView textView2 = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_logistic_transport_time);
            textView.setText(bVar.mo28979a());
            textView2.setText(bVar.mo28980b());
            boolean z = i2 == 0;
            findViewById.setSelected(z);
            findViewById2.setPadding(0, z ? C5412d.m22146a(20.0f) : 0, 0, 0);
            textView.setSelected(z);
            textView2.setSelected(z);
            this.f19571c.addView(inflate);
            i2++;
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        List list;
        final C6086g gVar = (C6086g) this.message.getAttachment();
        this.f19569a.setText(gVar.mo28971c());
        this.f19570b.setText(gVar.mo28972d().mo28981a());
        int i = 3;
        if (gVar.mo28973e().size() <= 3 || gVar.mo28975g()) {
            this.f19572d.setVisibility(8);
            list = gVar.mo28973e();
            i = gVar.mo28973e().size();
        } else {
            this.f19572d.setVisibility(0);
            list = gVar.mo28973e();
        }
        m24791a(list, i);
        if (gVar.mo28974f() != null) {
            this.f19573e.setVisibility(0);
            this.f19574f.setText(gVar.mo28974f().mo28977a());
            this.f19574f.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6276k.this.mo29448a(gVar.mo28974f().mo28978b());
                }
            });
            return;
        }
        this.f19573e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_logistic;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19569a = (TextView) findViewById(C5961R.C5963id.ysf_tv_logistic_label);
        this.f19570b = (TextView) findViewById(C5961R.C5963id.ysf_tv_logistic_title);
        this.f19571c = (LinearLayout) findViewById(C5961R.C5963id.ysf_logistic_transport_info);
        this.f19572d = findViewById(C5961R.C5963id.ysf_logistic_more_layout);
        this.f19573e = findViewById(C5961R.C5963id.ysf_bot_footer_layout);
        this.f19574f = (TextView) findViewById(C5961R.C5963id.ysf_bot_footer_text);
        this.f19572d.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == this.f19572d) {
            C6086g gVar = (C6086g) this.message.getAttachment();
            gVar.mo28976h();
            this.f19572d.setVisibility(8);
            m24791a(gVar.mo28973e(), gVar.mo28973e().size());
        }
    }
}
