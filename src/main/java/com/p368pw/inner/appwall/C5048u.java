package com.p368pw.inner.appwall;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5191i;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.u */
public class C5048u extends Dialog {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5052b f16526a;
    /* renamed from: b */
    private View f16527b;
    /* renamed from: c */
    private View f16528c;
    /* renamed from: d */
    private OnClickListener f16529d = new OnClickListener() {
        public void onClick(View view) {
            C5048u.this.dismiss();
            if (C5048u.this.f16526a != null) {
                C5048u.this.f16526a.onClick();
            }
        }
    };

    /* renamed from: com.pw.inner.appwall.u$a */
    public static class C5051a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Context f16532a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f16533b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f16534c;
        /* renamed from: d */
        private int f16535d;

        public C5051a(Context context) {
            this.f16532a = context;
        }

        /* renamed from: a */
        public C5051a mo26549a(int i) {
            this.f16535d = i;
            return this;
        }

        /* renamed from: a */
        public C5051a mo26550a(String str) {
            this.f16533b = str;
            return this;
        }

        /* renamed from: a */
        public C5048u mo26551a() {
            return new C5048u(this);
        }

        /* renamed from: b */
        public C5051a mo26552b(String str) {
            this.f16534c = str;
            return this;
        }
    }

    /* renamed from: com.pw.inner.appwall.u$b */
    public interface C5052b {
        void onClick();

        void onDismiss();
    }

    public C5048u(C5051a aVar) {
        super(aVar.f16532a, R.style.win_sdk_no_dim_dialog);
        setContentView(LayoutInflater.from(C5233e.m21559b()).inflate(R.layout.win_sdk_next_step_dialog, null), new LayoutParams(C5191i.m21384a(C5233e.m21559b(), 1), -2));
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f16528c = findViewById(R.id.win_sdk_next_step_dialog_layout);
        TextView textView = (TextView) findViewById(R.id.win_sdk_offer_dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.win_sdk_offer_dialog_get);
        this.f16527b = findViewById(R.id.win_sdk_offer_dialog_get_container);
        textView.setText(aVar.f16533b);
        textView2.setText(aVar.f16534c);
        m21075a();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C5048u.this.f16526a != null) {
                    C5048u.this.f16526a.onDismiss();
                }
            }
        });
    }

    /* renamed from: a */
    private void m21075a() {
        this.f16527b.setOnClickListener(this.f16529d);
        this.f16528c.setOnClickListener(this.f16529d);
    }

    /* renamed from: a */
    public void mo26546a(C5052b bVar) {
        this.f16526a = bVar;
    }
}
