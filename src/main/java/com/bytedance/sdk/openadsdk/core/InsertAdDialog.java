package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.m */
public class InsertAdDialog extends Dialog {
    /* renamed from: a */
    private View f7729a;
    /* renamed from: b */
    private Context f7730b;
    /* renamed from: c */
    private ImageView f7731c;
    /* renamed from: d */
    private ImageView f7732d;
    /* renamed from: e */
    private ImageView f7733e;
    /* renamed from: f */
    private TextView f7734f;
    /* renamed from: g */
    private FrameLayout f7735g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C2262a f7736h;
    /* renamed from: i */
    private boolean f7737i;

    /* compiled from: InsertAdDialog */
    /* renamed from: com.bytedance.sdk.openadsdk.core.m$a */
    public interface C2262a {
        /* renamed from: a */
        void mo15090a(View view);

        /* renamed from: a */
        void mo15091a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);
    }

    public void onBackPressed() {
    }

    public InsertAdDialog(Context context) {
        this(context, 0);
    }

    public InsertAdDialog(Context context, int i) {
        if (i == 0) {
            i = ResourceHelp.m11937g(context, "tt_wg_insert_dialog");
        }
        super(context, i);
        this.f7737i = false;
        this.f7730b = context;
    }

    /* renamed from: a */
    public void mo15835a(boolean z, C2262a aVar) {
        this.f7737i = z;
        this.f7736h = aVar;
        m9897a();
        C2262a aVar2 = this.f7736h;
        if (aVar2 != null) {
            aVar2.mo15091a(this.f7731c, this.f7732d, this.f7735g);
        }
    }

    /* renamed from: a */
    private void m9897a() {
        int i = 0;
        setCancelable(false);
        this.f7729a = LayoutInflater.from(this.f7730b).inflate(ResourceHelp.m11936f(this.f7730b, "tt_insert_ad_layout"), null);
        setContentView(this.f7729a);
        this.f7731c = (ImageView) this.f7729a.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_insert_ad_img"));
        this.f7732d = (ImageView) this.f7729a.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_insert_dislike_icon_img"));
        this.f7733e = (ImageView) this.f7729a.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_insert_ad_logo"));
        this.f7734f = (TextView) this.f7729a.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_insert_ad_text"));
        this.f7735g = (FrameLayout) this.f7729a.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_insert_express_ad_fl"));
        int c = UIUtils.m12078c(this.f7730b);
        int i2 = c / 3;
        this.f7731c.setMaxWidth(c);
        this.f7731c.setMinimumWidth(i2);
        this.f7731c.setMinimumHeight(i2);
        this.f7735g.setMinimumWidth(i2);
        this.f7735g.setMinimumHeight(i2);
        this.f7731c.setVisibility(this.f7737i ? 8 : 0);
        this.f7732d.setVisibility(0);
        this.f7733e.setVisibility(this.f7737i ? 8 : 0);
        this.f7734f.setVisibility(this.f7737i ? 8 : 0);
        FrameLayout frameLayout = this.f7735g;
        if (!this.f7737i) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        int a = (int) UIUtils.m12048a(this.f7730b, 15.0f);
        UIUtils.m12060a((View) this.f7732d, a, a, a, a);
        this.f7732d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (InsertAdDialog.this.f7736h != null) {
                    InsertAdDialog.this.f7736h.mo15090a(view);
                }
            }
        });
    }

    public void show() {
        m9898b();
        super.show();
    }

    /* renamed from: b */
    private void m9898b() {
        try {
            if (this.f7735g != null) {
                if (this.f7735g.getChildCount() > 0) {
                    View childAt = this.f7735g.getChildAt(0);
                    if (childAt instanceof NativeExpressView) {
                        NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                        if (nativeExpressView.mo15883m()) {
                            this.f7735g.setVisibility(0);
                            this.f7731c.setVisibility(8);
                            this.f7732d.setVisibility(8);
                            this.f7733e.setVisibility(8);
                            this.f7734f.setVisibility(8);
                            View findViewById = nativeExpressView.findViewById(ResourceHelp.m11935e(this.f7730b, "tt_bu_close"));
                            if (!(findViewById == null || this.f7736h == null)) {
                                this.f7736h.mo15090a(findViewById);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
