package com.p368pw.inner.appwall;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.p368pw.inner.C5233e;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.x */
public class C5055x extends Dialog {
    /* renamed from: a */
    ObjectAnimator f16539a;
    /* renamed from: b */
    ObjectAnimator f16540b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5059b f16541c;
    /* renamed from: d */
    private OnClickListener f16542d;

    /* renamed from: com.pw.inner.appwall.x$a */
    public static class C5058a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Context f16545a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f16546b;

        public C5058a(Context context) {
            this.f16545a = context;
        }

        /* renamed from: a */
        public C5058a mo26561a(String str) {
            this.f16546b = str;
            return this;
        }

        /* renamed from: a */
        public C5055x mo26562a() {
            return new C5055x(this);
        }
    }

    /* renamed from: com.pw.inner.appwall.x$b */
    public interface C5059b {
        void onClick();

        void onDismiss();
    }

    private C5055x(C5058a aVar) {
        super(aVar.f16545a, R.style.win_sdk_no_dim_dialog);
        this.f16542d = new OnClickListener() {
            public void onClick(View view) {
                C5055x.this.dismiss();
                if (C5055x.this.f16541c != null) {
                    C5055x.this.f16541c.onClick();
                }
            }
        };
        setContentView(LayoutInflater.from(C5233e.m21559b()).inflate(R.layout.win_sdk_surprise_dialog, null));
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        ((TextView) findViewById(R.id.win_sdk_coin_amount)).setText(aVar.f16546b);
        TextView textView = (TextView) findViewById(R.id.win_sdk_take_reward);
        textView.setOnClickListener(this.f16542d);
        this.f16539a = ObjectAnimator.ofFloat(textView, "scaleX", new float[]{0.8f, 1.0f});
        this.f16539a.setDuration(600);
        this.f16539a.setInterpolator(new LinearInterpolator());
        this.f16539a.setRepeatMode(2);
        this.f16539a.setRepeatCount(-1);
        this.f16539a.start();
        this.f16540b = ObjectAnimator.ofFloat(textView, "scaleY", new float[]{0.8f, 1.0f});
        this.f16540b.setDuration(600);
        this.f16540b.setInterpolator(new LinearInterpolator());
        this.f16540b.setRepeatMode(2);
        this.f16540b.setRepeatCount(-1);
        this.f16540b.start();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C5055x.this.f16539a != null) {
                    C5055x.this.f16539a.cancel();
                }
                if (C5055x.this.f16540b != null) {
                    C5055x.this.f16540b.cancel();
                }
                if (C5055x.this.f16541c != null) {
                    C5055x.this.f16541c.onDismiss();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo26558a(C5059b bVar) {
        this.f16541c = bVar;
    }
}
