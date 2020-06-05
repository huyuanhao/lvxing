package com.qiyukf.unicorn.widget.p521a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;

/* renamed from: com.qiyukf.unicorn.widget.a.a */
public final class C6351a extends Dialog implements OnClickListener {
    /* renamed from: a */
    private View f19820a;
    /* renamed from: b */
    private View f19821b;
    /* renamed from: c */
    private TextView f19822c;
    /* renamed from: d */
    private LinearLayout f19823d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C6365a f19824e;
    /* renamed from: f */
    private int f19825f;

    public C6351a(Context context, int i) {
        super(context, i == 17 ? C5961R.style.ysf_dialog_default_style : C5961R.style.ysf_popup_dialog_style);
        this.f19825f = i;
        View inflate = LayoutInflater.from(context).inflate(C5961R.C5964layout.ysf_dialog_category, null);
        if (i == 17) {
            inflate.setBackgroundResource(C5961R.C5962drawable.ysf_dialog_bg);
        } else {
            inflate.setBackgroundColor(ContextCompat.getColor(getContext(), C5961R.color.ysf_white));
        }
        this.f19820a = inflate.findViewById(C5961R.C5963id.ysf_dialog_category_title_layout);
        this.f19821b = inflate.findViewById(C5961R.C5963id.ysf_dialog_category_close);
        this.f19822c = (TextView) inflate.findViewById(C5961R.C5963id.ysf_dialog_category_title);
        this.f19823d = (LinearLayout) inflate.findViewById(C5961R.C5963id.ysf_dialog_category_item_container);
        this.f19821b.setOnClickListener(this);
        setContentView(inflate);
    }

    /* renamed from: a */
    public final void mo29562a(C6365a aVar) {
        this.f19824e = aVar;
    }

    /* renamed from: a */
    public final void mo29563a(String[] strArr) {
        this.f19823d.removeAllViews();
        final int i = 0;
        while (i < strArr.length) {
            View inflate = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_dialog_category_item, this.f19823d, false);
            TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_dialog_category_item_name);
            View findViewById = inflate.findViewById(C5961R.C5963id.ysf_dialog_category_item_divider);
            textView.setText(strArr[i]);
            findViewById.setVisibility(i == strArr.length + -1 ? 8 : 0);
            inflate.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6351a.this.cancel();
                    if (C6351a.this.f19824e != null) {
                        C6351a.this.f19824e.mo27603a(i);
                    }
                }
            });
            this.f19823d.addView(inflate);
            i++;
        }
    }

    public final void onClick(View view) {
        if (view == this.f19821b) {
            cancel();
        }
    }

    /* access modifiers changed from: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = this.f19825f == 17 ? getContext().getResources().getDimensionPixelSize(C5961R.dimen.ysf_dialog_width) : -1;
        attributes.height = -2;
        attributes.gravity = this.f19825f;
        getWindow().setAttributes(attributes);
    }

    public final void setTitle(CharSequence charSequence) {
        this.f19820a.setVisibility(charSequence == null ? 8 : 0);
        this.f19822c.setText(charSequence);
    }
}
