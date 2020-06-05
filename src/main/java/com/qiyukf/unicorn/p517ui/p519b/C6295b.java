package com.qiyukf.unicorn.p517ui.p519b;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6010b;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;

/* renamed from: com.qiyukf.unicorn.ui.b.b */
public class C6295b extends C5622b {
    /* renamed from: a */
    private View f19633a;
    /* renamed from: b */
    private TextView f19634b;
    /* renamed from: c */
    private Button f19635c;
    /* renamed from: d */
    private TextView f19636d;
    /* renamed from: e */
    private TextView f19637e;

    /* access modifiers changed from: protected */
    public void bindContentView() {
        C6148d dVar = (C6148d) this.message.getAttachment();
        final C6115b e = dVar.mo29196e();
        boolean a = dVar.mo29190a();
        this.f19633a.setVisibility(a ? 8 : 0);
        this.f19636d.setVisibility(a ? 0 : 8);
        this.f19637e.setVisibility(8);
        final long l = C6014b.m23968l(String.valueOf(dVar.mo29194c()));
        if (!a) {
            this.f19634b.setText(dVar.mo29184a(this.context));
            if (dVar.mo29197f() > 0) {
                this.f19635c.setText("再次评价");
            }
            this.f19635c.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (C6010b.m23913a().mo28845b() != null) {
                        C6010b.m23913a();
                    } else if (l == 0 || System.currentTimeMillis() < l + (e.mo29064g().longValue() * 60 * 1000)) {
                        C6029d.m24047g().mo29296c().mo29265a(C6295b.this.context, C6295b.this.message);
                    } else {
                        C5415g.m22161a(C5961R.string.ysf_evaluation_time_out);
                    }
                }
            });
        } else if (e == null || !e.mo29065h() || e.mo29064g().longValue() == 0) {
            this.f19636d.setVisibility(0);
            this.f19636d.setText(dVar.mo29184a(this.context));
            this.f19636d.setMovementMethod(LinkMovementMethod.getInstance());
            this.f19637e.setVisibility(8);
        } else {
            this.f19637e.setVisibility(0);
            this.f19636d.setVisibility(8);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(dVar.mo29184a(this.context));
            spannableStringBuilder.append(this.context.getString(C5961R.string.ysf_evaluation_modify));
            spannableStringBuilder.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    if (l != 0 && System.currentTimeMillis() >= l + (e.mo29064g().longValue() * 60 * 1000)) {
                        C5415g.m22161a(C5961R.string.ysf_evaluation_time_out);
                    } else if (C6010b.m23913a().mo28845b() != null) {
                        C6010b.m23913a();
                    } else {
                        C6029d.m24047g().mo29296c().mo29265a(C6295b.this.context, C6295b.this.message);
                    }
                }
            }, dVar.mo29184a(this.context).length(), spannableStringBuilder.length(), 33);
            this.f19637e.setText(spannableStringBuilder);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#529DF9")), dVar.mo29184a(this.context).length(), spannableStringBuilder.length(), 33);
            this.f19637e.setMovementMethod(LinkMovementMethod.getInstance());
            this.f19637e.setText(spannableStringBuilder);
        }
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_evaluation;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19633a = this.view.findViewById(C5961R.C5963id.ysf_message_item_evaluation_invitation_layout);
        this.f19634b = (TextView) this.view.findViewById(C5961R.C5963id.ysf_message_item_evaluation_invitation);
        this.f19635c = (Button) this.view.findViewById(C5961R.C5963id.ysf_btn_message_item_evaluation);
        this.f19637e = (TextView) this.view.findViewById(C5961R.C5963id.ysf_message_item_multi_evaluation);
        this.f19636d = (TextView) this.view.findViewById(C5961R.C5963id.ysf_message_item_evaluation_thanks);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.tipsTextSize > 0.0f) {
                this.f19636d.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.f19636d.setTextColor(uICustomization.tipsTextColor);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean showAvatar() {
        return false;
    }
}
