package com.qiyukf.unicorn.widget.p521a;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;

/* renamed from: com.qiyukf.unicorn.widget.a.d */
public final class C6356d extends Dialog implements OnClickListener {
    /* renamed from: a */
    private View f19836a;
    /* renamed from: b */
    private EditText f19837b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Button f19838c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C6359a f19839d;
    /* renamed from: e */
    private String f19840e;
    /* renamed from: f */
    private TextWatcher f19841f = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            C6356d.this.f19838c.setEnabled(C6356d.this.m24989a().length() > 0);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    /* renamed from: com.qiyukf.unicorn.widget.a.d$a */
    public interface C6359a {
        /* renamed from: a */
        void mo29512a();

        /* renamed from: a */
        void mo29513a(String str);
    }

    public C6356d(Context context) {
        super(context, C5961R.style.ysf_dialog_default_style);
        View inflate = LayoutInflater.from(context).inflate(C5961R.C5964layout.ysf_dialog_input_evaluation, new LinearLayout(context), false);
        setContentView(inflate);
        setCancelable(false);
        this.f19836a = inflate.findViewById(C5961R.C5963id.ysf_dialog_input_close);
        this.f19837b = (EditText) inflate.findViewById(C5961R.C5963id.ysf_dialog_input_edit);
        this.f19838c = (Button) inflate.findViewById(C5961R.C5963id.ysf_dialog_input_submit);
        this.f19836a.setOnClickListener(this);
        this.f19838c.setOnClickListener(this);
        this.f19837b.addTextChangedListener(this.f19841f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m24989a() {
        return this.f19837b.getText().toString().trim();
    }

    /* renamed from: a */
    public final C6356d mo29575a(C6359a aVar) {
        this.f19839d = aVar;
        return this;
    }

    /* renamed from: a */
    public final C6356d mo29576a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.f19840e = str;
        this.f19837b.setText(this.f19840e);
        this.f19837b.setHint(str2);
        EditText editText = this.f19837b;
        editText.setSelection(editText.length());
        return this;
    }

    public final void cancel() {
        C5409b.m22133b(this.f19837b);
        super.cancel();
    }

    public final void onClick(View view) {
        if (view == this.f19836a) {
            cancel();
            if (!m24989a().equals(this.f19840e)) {
                C6364g.m25005a(getContext(), "确定放弃编辑吗？", false, (C6365a) new C6365a() {
                    /* renamed from: a */
                    public final void mo27603a(int i) {
                        if (i == 0 && C6356d.this.f19839d != null) {
                            C6356d.this.f19839d.mo29512a();
                        }
                        if (i == 1) {
                            C6356d.this.show();
                        }
                    }
                });
                return;
            }
            C6359a aVar = this.f19839d;
            if (aVar != null) {
                aVar.mo29512a();
            }
        } else if (view == this.f19838c) {
            C6359a aVar2 = this.f19839d;
            if (aVar2 != null) {
                aVar2.mo29513a(m24989a());
                cancel();
            }
        }
    }
}
