package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6076c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6076c.C6077a.C6078a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6082b;
import com.qiyukf.unicorn.p516j.C6228j;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.a.g */
public class C6263g extends C6257e implements OnClickListener, OnDismissListener {
    /* renamed from: a */
    private View f19518a;
    /* renamed from: b */
    private TextView f19519b;
    /* renamed from: c */
    private C6076c f19520c;
    /* renamed from: d */
    private C6262b f19521d;
    /* renamed from: e */
    private PopupWindow f19522e;
    /* renamed from: f */
    private View f19523f;
    /* renamed from: g */
    private View f19524g;

    /* renamed from: com.qiyukf.unicorn.ui.b.a.g$a */
    public static class C6264a {
        /* renamed from: a */
        private LinearLayout f19525a;

        public C6264a(LinearLayout linearLayout) {
            this.f19525a = linearLayout;
        }

        /* renamed from: a */
        public final void mo29468a(List<List<C6078a>> list) {
            for (int i = 0; i < list.size(); i++) {
                List list2 = (List) list.get(i);
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f19525a.getContext()).inflate(C5961R.C5964layout.ysf_popup_window_card_detail_group, this.f19525a, false);
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(C5961R.C5963id.ysf_card_detail_group);
                View findViewById = linearLayout.findViewById(C5961R.C5963id.ysf_card_detail_space);
                int i2 = 0;
                while (i2 < list2.size()) {
                    C6078a aVar = (C6078a) list2.get(i2);
                    LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(linearLayout.getContext()).inflate(C5961R.C5964layout.ysf_popup_window_card_detail_item, linearLayout, false);
                    LinearLayout linearLayout4 = (LinearLayout) linearLayout3.findViewById(C5961R.C5963id.ysf_card_detail_item);
                    View findViewById2 = linearLayout3.findViewById(C5961R.C5963id.ysf_card_detail_divider);
                    C6082b[] a = aVar.mo28938a();
                    int i3 = 0;
                    while (i3 < 2) {
                        C6082b bVar = a[i3];
                        aVar.mo28938a();
                        C6251b.m24732a(bVar, linearLayout4, 2, false);
                        i3++;
                        List<List<C6078a>> list3 = list;
                    }
                    if (i2 == list2.size() - 1) {
                        findViewById2.setVisibility(8);
                    }
                    linearLayout2.addView(linearLayout3);
                    i2++;
                    List<List<C6078a>> list4 = list;
                }
                if (i == list.size() - 1) {
                    findViewById.setVisibility(8);
                }
                this.f19525a.addView(linearLayout);
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        this.f19520c = (C6076c) this.message.getAttachment();
        this.f19521d.mo29464a(this.f19520c.mo28934c());
        if (this.f19520c.mo28934c().mo28954a() != null) {
            this.f19518a.setVisibility(0);
            this.f19519b.setText(this.f19520c.mo28934c().mo28954a().mo28947d());
            this.f19519b.setOnClickListener(this);
            return;
        }
        this.f19518a.setVisibility(8);
    }

    /* renamed from: c */
    public final void mo29452c() {
        this.f19522e = new PopupWindow(this.context);
        this.f19522e.setWidth(-1);
        this.f19522e.setHeight((int) (((double) C5412d.m22148b()) * 0.8d));
        this.f19522e.setContentView(LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_popup_window_card_detail, null));
        this.f19522e.setBackgroundDrawable(new ColorDrawable(0));
        this.f19522e.setOutsideTouchable(false);
        this.f19522e.setFocusable(true);
        this.f19522e.setOnDismissListener(this);
        this.f19522e.setAnimationStyle(C5961R.style.ysf_dialog_window_animation_style);
        this.f19522e.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
        C6228j.m24667a(((Activity) this.context).getWindow(), 0.3f);
        this.f19523f = this.f19522e.getContentView().findViewById(C5961R.C5963id.ysf_card_detail_placeholder);
        TextView textView = (TextView) this.f19522e.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_title);
        this.f19524g = this.f19522e.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_close);
        LinearLayout linearLayout = (LinearLayout) this.f19522e.getContentView().findViewById(C5961R.C5963id.ysf_card_detail_container);
        textView.setText(this.f19520c.mo28935d().mo28936a());
        this.f19523f.setOnClickListener(this);
        this.f19524g.setOnClickListener(this);
        new C6264a(linearLayout).mo29468a(this.f19520c.mo28935d().mo28937b());
        getAdapter().mo27734d().mo27724b();
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_card_detail;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C5961R.C5963id.ysf_holder_card_layout);
        this.f19518a = findViewById(C5961R.C5963id.ysf_bot_footer_layout);
        this.f19519b = (TextView) findViewById(C5961R.C5963id.ysf_bot_footer_text);
        this.f19521d = new C6262b(linearLayout, true);
    }

    public void onClick(View view) {
        if (view == this.f19519b) {
            C6250a.m24730a(this.f19520c.mo28934c().mo28954a(), this);
            return;
        }
        if (view == this.f19524g || view == this.f19523f) {
            this.f19522e.dismiss();
        }
    }

    public void onDismiss() {
        C6228j.m24667a(((Activity) this.context).getWindow(), 1.0f);
    }
}
