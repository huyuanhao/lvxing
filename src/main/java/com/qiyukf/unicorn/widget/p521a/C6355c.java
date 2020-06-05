package com.qiyukf.unicorn.widget.p521a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.qiyukf.unicorn.C5961R;

/* renamed from: com.qiyukf.unicorn.widget.a.c */
final class C6355c extends C6353b<C6355c> implements OnClickListener {
    /* renamed from: d */
    private Button f19834d;
    /* renamed from: e */
    private Button f19835e;

    public C6355c(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(C5961R.C5964layout.ysf_dialog_content_double_btn, null);
        this.f19834d = (Button) inflate.findViewById(C5961R.C5963id.ysf_dialog_btn_left);
        this.f19835e = (Button) inflate.findViewById(C5961R.C5963id.ysf_dialog_btn_right);
        this.f19834d.setOnClickListener(this);
        this.f19835e.setOnClickListener(this);
        this.f19829b.f19831a.removeAllViews();
        this.f19829b.f19831a.addView(inflate, -1, -2);
    }

    /* renamed from: a */
    public final C6355c mo29573a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f19834d.setText(charSequence);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f19835e.setText(charSequence2);
        }
        return this;
    }

    public final void onClick(View view) {
        this.f19829b.cancel();
        if (this.f19830c != null) {
            this.f19830c.mo27603a(view == this.f19834d ? 0 : 1);
        }
    }
}
