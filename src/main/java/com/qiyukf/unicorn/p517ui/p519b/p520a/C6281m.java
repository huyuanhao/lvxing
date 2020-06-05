package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6090h;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6090h.C6091a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6106b;

/* renamed from: com.qiyukf.unicorn.ui.b.a.m */
public class C6281m extends C6257e {
    /* renamed from: a */
    private TextView f19582a;
    /* renamed from: b */
    private LinearLayout f19583b;

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        C6090h hVar = (C6090h) this.message.getAttachment();
        this.f19582a.setText(hVar.mo28982c());
        this.f19583b.removeAllViews();
        for (final C6091a aVar : hVar.mo28983d()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_tv_mix_reply, this.f19583b, false);
            textView.setText(aVar.mo28984a());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6106b bVar = new C6106b();
                    bVar.mo29042a(aVar.mo28984a());
                    bVar.mo29043b(aVar.mo28985b());
                    C5969b bVar2 = new C5969b();
                    String str = "";
                    bVar2.mo28519a(aVar.mo28986c() == null ? str : aVar.mo28986c());
                    if (aVar.mo28987d() != null) {
                        str = aVar.mo28987d();
                    }
                    bVar2.mo28521b(str);
                    bVar2.mo28522c(aVar.mo28984a());
                    bVar2.mo28523d(aVar.mo28985b());
                    bVar2.mo28520a(bVar.mo29045d());
                    bVar.mo28536a(bVar2);
                    C6281m.this.getAdapter().mo27734d().mo27727c(MessageBuilder.createCustomMessage(C6281m.this.message.getSessionId(), SessionTypeEnum.Ysf, bVar));
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = C5412d.m22146a(0.0f);
            this.f19583b.addView(textView, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_mix_reply;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19582a = (TextView) findViewById(C5961R.C5963id.ysf_tv_mix_reply_label);
        this.f19583b = (LinearLayout) findViewById(C5961R.C5963id.ysf_ll_mix_reply_question_container);
    }
}
