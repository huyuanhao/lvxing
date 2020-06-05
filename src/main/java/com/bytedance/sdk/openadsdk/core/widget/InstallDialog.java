package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.b */
public class InstallDialog extends AlertDialog {
    /* renamed from: a */
    private TextView f8303a;
    /* renamed from: b */
    private TextView f8304b;
    /* renamed from: c */
    private Button f8305c;
    /* renamed from: d */
    private Button f8306d;
    /* renamed from: e */
    private Context f8307e;
    /* renamed from: f */
    private String f8308f;
    /* renamed from: g */
    private String f8309g;
    /* renamed from: h */
    private String f8310h;
    /* renamed from: i */
    private String f8311i;
    /* renamed from: j */
    private Drawable f8312j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public C2360a f8313k;

    /* compiled from: InstallDialog */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.b$a */
    public interface C2360a {
        /* renamed from: a */
        void mo14893a(Dialog dialog);

        /* renamed from: b */
        void mo14894b(Dialog dialog);
    }

    public InstallDialog(Context context) {
        super(context, ResourceHelp.m11937g(context, "tt_custom_dialog"));
        this.f8307e = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceHelp.m11936f(this.f8307e, "tt_install_dialog_layout"));
        setCanceledOnTouchOutside(true);
        m10781a();
    }

    /* renamed from: a */
    private void m10781a() {
        this.f8303a = (TextView) findViewById(ResourceHelp.m11935e(this.f8307e, "tt_install_title"));
        this.f8304b = (TextView) findViewById(ResourceHelp.m11935e(this.f8307e, "tt_install_content"));
        this.f8305c = (Button) findViewById(ResourceHelp.m11935e(this.f8307e, "tt_install_btn_yes"));
        this.f8306d = (Button) findViewById(ResourceHelp.m11935e(this.f8307e, "tt_install_btn_no"));
        this.f8305c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                InstallDialog.this.dismiss();
                if (InstallDialog.this.f8313k != null) {
                    InstallDialog.this.f8313k.mo14893a(InstallDialog.this);
                }
            }
        });
        this.f8306d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                InstallDialog.this.dismiss();
                if (InstallDialog.this.f8313k != null) {
                    InstallDialog.this.f8313k.mo14894b(InstallDialog.this);
                }
            }
        });
    }

    public void show() {
        super.show();
        m10782b();
    }

    /* renamed from: b */
    private void m10782b() {
        TextView textView = this.f8303a;
        if (textView != null) {
            textView.setText(this.f8308f);
            Drawable drawable = this.f8312j;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.f8312j.getIntrinsicHeight();
                int c = UIUtils.m12079c(this.f8307e, 45.0f);
                if (intrinsicWidth > c || intrinsicWidth < c) {
                    intrinsicWidth = c;
                }
                if (intrinsicHeight > c || intrinsicHeight < c) {
                    intrinsicHeight = c;
                }
                this.f8312j.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f8303a.setCompoundDrawables(this.f8312j, null, null, null);
                this.f8303a.setCompoundDrawablePadding(UIUtils.m12079c(this.f8307e, 10.0f));
            }
        }
        TextView textView2 = this.f8304b;
        if (textView2 != null) {
            textView2.setText(this.f8309g);
        }
        Button button = this.f8305c;
        if (button != null) {
            button.setText(this.f8310h);
        }
        Button button2 = this.f8306d;
        if (button2 != null) {
            button2.setText(this.f8311i);
        }
    }

    /* renamed from: a */
    public InstallDialog mo16297a(String str) {
        this.f8308f = str;
        return this;
    }

    /* renamed from: b */
    public InstallDialog mo16298b(String str) {
        this.f8309g = str;
        return this;
    }

    /* renamed from: c */
    public InstallDialog mo16299c(String str) {
        this.f8310h = str;
        return this;
    }

    /* renamed from: d */
    public InstallDialog mo16300d(String str) {
        this.f8311i = str;
        return this;
    }

    /* renamed from: a */
    public InstallDialog mo16295a(Drawable drawable) {
        this.f8312j = drawable;
        return this;
    }

    /* renamed from: a */
    public InstallDialog mo16296a(C2360a aVar) {
        this.f8313k = aVar;
        return this;
    }

    /* renamed from: a */
    public InstallDialog mo16294a(OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }
}
