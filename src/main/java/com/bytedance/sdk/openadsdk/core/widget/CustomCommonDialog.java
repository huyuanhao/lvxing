package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.a */
public class CustomCommonDialog extends Dialog {
    /* renamed from: a */
    public C2357a f8287a;
    /* renamed from: b */
    private ImageView f8288b;
    /* renamed from: c */
    private TextView f8289c;
    /* renamed from: d */
    private TextView f8290d;
    /* renamed from: e */
    private Button f8291e;
    /* renamed from: f */
    private Button f8292f;
    /* renamed from: g */
    private View f8293g;
    /* renamed from: h */
    private Context f8294h;
    /* renamed from: i */
    private String f8295i;
    /* renamed from: j */
    private String f8296j;
    /* renamed from: k */
    private String f8297k;
    /* renamed from: l */
    private String f8298l;
    /* renamed from: m */
    private int f8299m = -1;
    /* renamed from: n */
    private boolean f8300n = false;

    /* compiled from: CustomCommonDialog */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a */
    public interface C2357a {
        /* renamed from: a */
        void mo14966a();

        /* renamed from: b */
        void mo14967b();
    }

    public void onBackPressed() {
    }

    public CustomCommonDialog(Context context) {
        super(context, ResourceHelp.m11937g(context, "tt_custom_dialog"));
        this.f8294h = context;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResourceHelp.m11936f(this.f8294h, "tt_custom_dailog_layout"));
        setCanceledOnTouchOutside(false);
        m10773c();
        m10772b();
        m10771a();
    }

    /* renamed from: a */
    private void m10771a() {
        this.f8292f.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (CustomCommonDialog.this.f8287a != null) {
                    CustomCommonDialog.this.f8287a.mo14966a();
                }
            }
        });
        this.f8291e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (CustomCommonDialog.this.f8287a != null) {
                    CustomCommonDialog.this.f8287a.mo14967b();
                }
            }
        });
    }

    /* renamed from: b */
    private void m10772b() {
        if (!TextUtils.isEmpty(this.f8296j)) {
            this.f8289c.setText(this.f8296j);
            this.f8289c.setVisibility(0);
        } else {
            this.f8289c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f8295i)) {
            this.f8290d.setText(this.f8295i);
        }
        if (!TextUtils.isEmpty(this.f8297k)) {
            this.f8292f.setText(this.f8297k);
        } else {
            this.f8292f.setText("确定");
        }
        if (!TextUtils.isEmpty(this.f8298l)) {
            this.f8291e.setText(this.f8298l);
        } else {
            this.f8291e.setText("取消");
        }
        int i = this.f8299m;
        if (i != -1) {
            this.f8288b.setImageResource(i);
            this.f8288b.setVisibility(0);
        } else {
            this.f8288b.setVisibility(8);
        }
        if (this.f8300n) {
            this.f8293g.setVisibility(8);
            this.f8291e.setVisibility(8);
            return;
        }
        this.f8291e.setVisibility(0);
        this.f8293g.setVisibility(0);
    }

    public void show() {
        super.show();
        m10772b();
    }

    /* renamed from: c */
    private void m10773c() {
        this.f8291e = (Button) findViewById(ResourceHelp.m11935e(this.f8294h, "tt_negtive"));
        this.f8292f = (Button) findViewById(ResourceHelp.m11935e(this.f8294h, "tt_positive"));
        this.f8289c = (TextView) findViewById(ResourceHelp.m11935e(this.f8294h, "tt_title"));
        this.f8290d = (TextView) findViewById(ResourceHelp.m11935e(this.f8294h, "tt_message"));
        this.f8288b = (ImageView) findViewById(ResourceHelp.m11935e(this.f8294h, "tt_image"));
        this.f8293g = findViewById(ResourceHelp.m11935e(this.f8294h, "tt_column_line"));
    }

    /* renamed from: a */
    public CustomCommonDialog mo16285a(C2357a aVar) {
        this.f8287a = aVar;
        return this;
    }

    /* renamed from: a */
    public CustomCommonDialog mo16286a(String str) {
        this.f8295i = str;
        return this;
    }

    /* renamed from: b */
    public CustomCommonDialog mo16287b(String str) {
        this.f8297k = str;
        return this;
    }

    /* renamed from: c */
    public CustomCommonDialog mo16288c(String str) {
        this.f8298l = str;
        return this;
    }
}
