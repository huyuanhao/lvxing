package com.bytedance.sdk.openadsdk.core.p169c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.Mode;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* renamed from: com.bytedance.sdk.openadsdk.core.c.a */
class InteractionExpressBackupView extends BackupView {
    /* renamed from: h */
    private static Mode[] f7288h = {new Mode(1, 1.0f, 300, 300), new Mode(2, 0.6666667f, 300, TinkerReport.KEY_LOADED_INTERPRET_GET_INSTRUCTION_SET_ERROR), new Mode(3, 1.5f, 300, 200)};
    /* renamed from: i */
    private View f7289i;
    /* renamed from: j */
    private NativeExpressView f7290j;
    /* renamed from: k */
    private ITTDownloadAdapter f7291k;
    /* renamed from: l */
    private int f7292l = 1;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public Dialog f7293m;

    public InteractionExpressBackupView(Context context) {
        super(context);
        this.f7750a = context;
    }

    /* renamed from: a */
    public void mo15315a(Dialog dialog) {
        this.f7293m = dialog;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15316a(MaterialMeta kVar, NativeExpressView nativeExpressView, ITTDownloadAdapter aVar) {
        setBackgroundColor(-1);
        this.f7751b = kVar;
        this.f7290j = nativeExpressView;
        this.f7291k = aVar;
        this.f7754e = "interaction";
        this.f7290j.addView(this, new LayoutParams(-2, -2));
        m9181b();
    }

    /* renamed from: b */
    private void m9181b() {
        Mode a = m9178a(this.f7290j.getExpectExpressWidth(), this.f7290j.getExpectExpressHeight());
        if (this.f7290j.getExpectExpressWidth() <= 0 || this.f7290j.getExpectExpressHeight() <= 0) {
            this.f7755f = UIUtils.m12079c(this.f7750a, (float) a.f7848c);
            this.f7756g = UIUtils.m12079c(this.f7750a, (float) a.f7849d);
        } else if (this.f7290j.getExpectExpressWidth() > this.f7290j.getExpectExpressHeight()) {
            this.f7755f = UIUtils.m12079c(this.f7750a, ((float) this.f7290j.getExpectExpressHeight()) * a.f7847b);
            this.f7756g = UIUtils.m12079c(this.f7750a, (float) this.f7290j.getExpectExpressHeight());
        } else {
            this.f7755f = UIUtils.m12079c(this.f7750a, (float) this.f7290j.getExpectExpressWidth());
            this.f7756g = UIUtils.m12079c(this.f7750a, ((float) this.f7290j.getExpectExpressWidth()) / a.f7847b);
        }
        if (this.f7755f > 0 && this.f7755f > UIUtils.m12078c(this.f7750a)) {
            float c = ((float) UIUtils.m12078c(this.f7750a)) / ((float) this.f7755f);
            this.f7755f = UIUtils.m12078c(this.f7750a);
            this.f7756g = Float.valueOf(((float) this.f7756g) * c).intValue();
        }
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(this.f7755f, this.f7756g);
        }
        layoutParams.width = this.f7755f;
        layoutParams.height = this.f7756g;
        setLayoutParams(layoutParams);
        if (a.f7846a == 1) {
            m9182c();
        } else if (a.f7846a == 2) {
            m9183d();
        } else if (a.f7846a == 3) {
            m9184e();
        } else {
            m9182c();
        }
    }

    /* renamed from: a */
    private void m9180a(ImageView imageView) {
        TTNetClient.m11428a(this.f7750a).mo16653a(((Image) this.f7751b.mo15418F().get(0)).mo15406a(), imageView);
    }

    /* renamed from: c */
    private void m9182c() {
        this.f7289i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_insert_layout1"), this, true);
        ImageView imageView = (ImageView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        View findViewById = this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        TextView textView = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        int a = (int) UIUtils.m12048a(this.f7750a, 15.0f);
        UIUtils.m12060a(findViewById, a, a, a, a);
        m9179a(findViewById);
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        m9180a(imageView);
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: a */
    private void m9179a(View view) {
        if (view != null) {
            view.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (InteractionExpressBackupView.this.f7293m != null) {
                        InteractionExpressBackupView.this.f7293m.dismiss();
                    }
                }
            });
        }
    }

    /* renamed from: d */
    private void m9183d() {
        this.f7289i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_insert_layout2"), this, true);
        ImageView imageView = (ImageView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        View findViewById = this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        TextView textView = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        int a = (int) UIUtils.m12048a(this.f7750a, 15.0f);
        UIUtils.m12060a(findViewById, a, a, a, a);
        m9179a(findViewById);
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        m9180a(imageView);
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: e */
    private void m9184e() {
        this.f7289i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_insert_layout3"), this, true);
        ImageView imageView = (ImageView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        View findViewById = this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        TextView textView = (TextView) this.f7289i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        int a = (int) UIUtils.m12048a(this.f7750a, 15.0f);
        UIUtils.m12060a(findViewById, a, a, a, a);
        m9179a(findViewById);
        m9180a(imageView);
        textView.setText(getDescription());
        mo15844a((View) this, false);
        mo15844a(this.f7289i, true);
    }

    /* renamed from: a */
    private Mode m9178a(int i, int i2) {
        Mode[] iVarArr;
        try {
            float floatValue = Float.valueOf((float) i).floatValue() / Float.valueOf((float) i2).floatValue();
            Mode iVar = f7288h[0];
            Mode iVar2 = iVar;
            float f = Float.MAX_VALUE;
            for (Mode iVar3 : f7288h) {
                float abs = Math.abs(iVar3.f7847b - floatValue);
                if (abs <= f) {
                    iVar2 = iVar3;
                    f = abs;
                }
            }
            return iVar2;
        } catch (Throwable unused) {
            return f7288h[0];
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15294a(int i, DynamicClickInfo iVar) {
        NativeExpressView nativeExpressView = this.f7290j;
        if (nativeExpressView != null) {
            nativeExpressView.mo15184a(i, iVar);
        }
    }
}
