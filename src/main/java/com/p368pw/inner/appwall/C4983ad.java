package com.p368pw.inner.appwall;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.p368pw.inner.C5233e;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5196m;
import com.pw.R;

/* renamed from: com.pw.inner.appwall.ad */
public class C4983ad extends Dialog {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public TextView f16207a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public ImageView f16208b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public View f16209c;
    /* renamed from: d */
    private C4986a f16210d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C4987b f16211e;
    /* renamed from: f */
    private OnClickListener f16212f;

    /* renamed from: com.pw.inner.appwall.ad$a */
    public static class C4986a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public Activity f16215a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public double f16216b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public String f16217c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public String f16218d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f16219e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public int f16220f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public boolean f16221g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public C5034m f16222h;

        public C4986a(Activity activity) {
            this.f16215a = activity;
        }

        /* renamed from: a */
        public C4986a mo26361a(double d) {
            this.f16216b = d;
            return this;
        }

        /* renamed from: a */
        public C4986a mo26362a(int i) {
            this.f16220f = i;
            return this;
        }

        /* renamed from: a */
        public C4986a mo26363a(C5047t tVar) {
            if (tVar != null) {
                this.f16222h = tVar.mo26542d();
            }
            return this;
        }

        /* renamed from: a */
        public C4986a mo26364a(String str) {
            this.f16217c = str;
            return this;
        }

        /* renamed from: a */
        public C4986a mo26365a(boolean z) {
            this.f16221g = z;
            return this;
        }

        /* renamed from: a */
        public C4983ad mo26366a() {
            return new C4983ad(this);
        }

        /* renamed from: b */
        public C4986a mo26367b(String str) {
            this.f16218d = str;
            return this;
        }

        /* renamed from: c */
        public C4986a mo26368c(String str) {
            this.f16219e = str;
            return this;
        }
    }

    /* renamed from: com.pw.inner.appwall.ad$b */
    public interface C4987b {
        /* renamed from: a */
        void mo26338a();

        /* renamed from: a */
        void mo26339a(int i);
    }

    private C4983ad(C4986a aVar) {
        super(aVar.f16215a, R.style.win_sdk_no_dim_dialog);
        this.f16212f = new OnClickListener() {
            public void onClick(View view) {
                C4983ad.this.dismiss();
                if (C4983ad.this.f16211e != null) {
                    int i = 0;
                    if (C4983ad.this.f16208b == view) {
                        i = 1;
                    } else if (C4983ad.this.f16207a == view || C4983ad.this.f16209c == view) {
                        i = 2;
                    }
                    C4983ad.this.f16211e.mo26339a(i);
                }
            }
        };
        this.f16210d = aVar;
        setContentView(LayoutInflater.from(C5233e.m21559b()).inflate(R.layout.win_sdk_offer_dialog, null), new LayoutParams(C5191i.m21384a(C5233e.m21559b(), 1), -2));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) findViewById(R.id.win_sdk_offer_dialog_title);
        TextView textView2 = (TextView) findViewById(R.id.win_sdk_offer_dialog_desc);
        ImageView imageView = (ImageView) findViewById(R.id.win_sdk_offer_dialog_appicon);
        TextView textView3 = (TextView) findViewById(R.id.win_sdk_offer_dialog_appname);
        this.f16207a = (TextView) findViewById(R.id.win_sdk_offer_dialog_get);
        this.f16208b = (ImageView) findViewById(R.id.win_sdk_offer_dialog_close);
        this.f16209c = findViewById(R.id.win_sdk_offer_dialog_offer);
        View findViewById = findViewById(R.id.win_sdk_offer_dialog_get_container);
        textView.setText(aVar.f16217c);
        if (aVar.f16221g) {
            textView2.setVisibility(8);
            textView.setTextSize(14.0f);
            textView.setLineSpacing(textView.getLineSpacingExtra(), 1.2f);
        } else {
            textView2.setText(aVar.f16218d);
            if (aVar.f16220f > 0) {
                Drawable drawable = ContextCompat.getDrawable(C5233e.m21559b(), aVar.f16220f);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    textView2.setCompoundDrawables(drawable, null, null, null);
                    textView2.setCompoundDrawablePadding(C5191i.m21391b(C5233e.m21559b(), 6));
                }
            }
        }
        if (aVar.f16222h != null) {
            C5196m.m21445a(C5233e.m21559b(), aVar.f16222h.mo26466a().f16774c, imageView);
            textView3.setText(aVar.f16222h.mo26466a().f16772a);
            this.f16207a.setText(aVar.f16219e);
            if (aVar.f16220f > 0) {
                Drawable drawable2 = ContextCompat.getDrawable(C5233e.m21559b(), aVar.f16220f);
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    textView2.setCompoundDrawables(drawable2, null, null, null);
                    textView2.setCompoundDrawablePadding(C5191i.m21391b(C5233e.m21559b(), 4));
                }
            }
        } else {
            this.f16209c.setVisibility(8);
            findViewById.setVisibility(8);
        }
        m20842b();
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C4983ad.this.f16211e != null) {
                    C4983ad.this.f16211e.mo26338a();
                }
            }
        });
    }

    /* renamed from: b */
    private void m20842b() {
        this.f16208b.setOnClickListener(this.f16212f);
        this.f16207a.setOnClickListener(this.f16212f);
        this.f16209c.setOnClickListener(this.f16212f);
    }

    /* renamed from: a */
    public double mo26357a() {
        return this.f16210d.f16216b;
    }

    /* renamed from: a */
    public void mo26358a(C4987b bVar) {
        this.f16211e = bVar;
    }
}
