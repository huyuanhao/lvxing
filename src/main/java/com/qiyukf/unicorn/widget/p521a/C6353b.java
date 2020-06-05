package com.qiyukf.unicorn.widget.p521a;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.widget.p521a.C6353b;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;

/* renamed from: com.qiyukf.unicorn.widget.a.b */
abstract class C6353b<T extends C6353b> {
    /* renamed from: a */
    protected Context f19828a;
    /* renamed from: b */
    protected C6354a f19829b;
    /* renamed from: c */
    protected C6365a f19830c;

    /* renamed from: com.qiyukf.unicorn.widget.a.b$a */
    protected static class C6354a extends Dialog {
        /* renamed from: a */
        ViewGroup f19831a;
        /* renamed from: b */
        TextView f19832b;
        /* renamed from: c */
        TextView f19833c;

        public C6354a(Context context) {
            super(context, C5961R.style.ysf_dialog_default_style);
            View inflate = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_dialog_base, null);
            this.f19831a = (ViewGroup) inflate.findViewById(C5961R.C5963id.ysf_dialog_content);
            this.f19832b = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_dialog_title);
            this.f19833c = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_dialog_message);
            setContentView(inflate);
        }
    }

    public C6353b(Context context) {
        this.f19828a = context;
        this.f19829b = new C6354a(context);
    }

    /* renamed from: a */
    public final T mo29568a(C6365a aVar) {
        this.f19830c = aVar;
        return this;
    }

    /* renamed from: a */
    public final T mo29569a(CharSequence charSequence) {
        this.f19829b.f19832b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.f19829b.f19832b.setText(charSequence);
        return this;
    }

    /* renamed from: a */
    public final T mo29570a(boolean z) {
        this.f19829b.setCancelable(z);
        return this;
    }

    /* renamed from: a */
    public void mo29571a() {
        this.f19829b.show();
    }

    /* renamed from: b */
    public final T mo29572b(CharSequence charSequence) {
        this.f19829b.f19833c.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.f19829b.f19833c.setText(charSequence);
        return this;
    }
}
