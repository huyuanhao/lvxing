package com.qiyukf.unicorn.p517ui.p519b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5554a;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.p516j.C6211c;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.a */
public abstract class C6248a<T> extends C5622b {
    /* renamed from: a */
    protected LinearLayout f19473a;
    /* renamed from: b */
    private View f19474b;
    /* renamed from: c */
    private TextView f19475c;
    /* renamed from: d */
    private View f19476d;
    /* renamed from: e */
    private LinearLayout f19477e;
    /* renamed from: f */
    private View f19478f;
    /* renamed from: g */
    private TextView f19479g;
    /* renamed from: h */
    private View f19480h;

    /* renamed from: a */
    private static int m24718a(Context context) {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.textMsgColorLeft == 0) ? context.getResources().getColor(C5961R.color.ysf_black_2b2b2b) : uICustomization.textMsgColorLeft;
    }

    /* renamed from: a */
    private static void m24719a(TextView textView) {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null && uICustomization.textMsgSize > 0.0f) {
            textView.setTextSize(uICustomization.textMsgSize);
        }
    }

    /* renamed from: a */
    private void m24720a(TextView textView, String str, boolean z) {
        m24719a(textView);
        if (z) {
            C6211c.m24639a(textView, str, (int) textView.getResources().getDimension(C5961R.dimen.ysf_bubble_content_max_width), this.message.getSessionId());
            return;
        }
        Context context = this.context;
        textView.setText(C5566e.m22593a(context, (CharSequence) C5543f.m22544a(context, str, this.message.getSessionId())));
    }

    /* renamed from: b */
    private static int m24721b(Context context) {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.hyperLinkColorLeft == 0) ? context.getResources().getColor(C5961R.color.ysf_text_link_color_blue) : uICustomization.hyperLinkColorLeft;
    }

    /* renamed from: a */
    public abstract void mo29436a(TextView textView, T t);

    /* renamed from: a */
    public abstract void mo29437a(T t);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo29438a() {
        return true;
    }

    /* renamed from: b */
    public abstract String mo29439b();

    /* access modifiers changed from: protected */
    public void bindContentView() {
        int i;
        this.f19473a.setBackgroundResource(isReceivedMessage() ? C5961R.C5962drawable.ysf_message_left_bg_no_padding_selector : C5961R.C5962drawable.ysf_message_right_bg_no_padding_selector);
        String b = mo29439b();
        if (!TextUtils.isEmpty(b)) {
            this.f19474b.setVisibility(0);
            this.f19476d.setVisibility(8);
            m24720a(this.f19475c, b, mo29442e());
        } else {
            this.f19474b.setVisibility(8);
        }
        List d = mo29441d();
        this.f19477e.removeAllViews();
        if (d == null || d.isEmpty()) {
            this.f19477e.setVisibility(8);
        } else {
            this.f19477e.setVisibility(0);
            if (this.f19474b.getVisibility() == 0) {
                this.f19476d.setVisibility(0);
            }
            for (int i2 = 0; i2 < d.size(); i2++) {
                final Object obj = d.get(i2);
                View inflate = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_clickable_item, null);
                TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_clickable_item_text);
                m24719a(textView);
                mo29436a(textView, obj);
                if (mo29438a()) {
                    textView.setEnabled(true);
                    i = m24721b(textView.getContext());
                } else {
                    textView.setEnabled(false);
                    i = this.context.getResources().getColor(C5961R.color.ysf_grey_999999);
                }
                textView.setTextColor(i);
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        C6248a.this.mo29437a(obj);
                    }
                });
                this.f19477e.addView(inflate, -1, -2);
            }
        }
        String c = mo29440c();
        if (!TextUtils.isEmpty(c)) {
            this.f19478f.setVisibility(0);
            m24720a(this.f19479g, C5406d.m22123d(c), mo29443f());
            if (this.f19474b.getVisibility() == 0 || this.f19477e.getVisibility() == 0) {
                this.f19480h.setVisibility(0);
            } else {
                this.f19480h.setVisibility(8);
            }
        } else {
            this.f19478f.setVisibility(8);
        }
    }

    /* renamed from: c */
    public abstract String mo29440c();

    /* renamed from: d */
    public abstract List<T> mo29441d();

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo29442e() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo29443f() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_clickable_list;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19473a = (LinearLayout) findViewById(C5961R.C5963id.ysf_clickable_list_content);
        this.f19474b = findViewById(C5961R.C5963id.ysf_clickable_list_header);
        this.f19475c = (TextView) findViewById(C5961R.C5963id.ysf_clickable_list_header_text);
        this.f19476d = findViewById(C5961R.C5963id.ysf_clickable_list_header_divider);
        this.f19477e = (LinearLayout) findViewById(C5961R.C5963id.ysf_clickable_list_container);
        this.f19478f = findViewById(C5961R.C5963id.ysf_clickable_list_footer);
        this.f19479g = (TextView) findViewById(C5961R.C5963id.ysf_clickable_list_footer_text);
        this.f19480h = findViewById(C5961R.C5963id.ysf_clickable_list_footer_divider);
        TextView textView = this.f19475c;
        textView.setTextColor(m24718a(textView.getContext()));
        TextView textView2 = this.f19475c;
        textView2.setLinkTextColor(m24721b(textView2.getContext()));
        this.f19475c.setOnTouchListener(C5554a.m22582a());
        TextView textView3 = this.f19479g;
        textView3.setTextColor(m24718a(textView3.getContext()));
        TextView textView4 = this.f19479g;
        textView4.setLinkTextColor(m24721b(textView4.getContext()));
        this.f19479g.setOnTouchListener(C5554a.m22582a());
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
