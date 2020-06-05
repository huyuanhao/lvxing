package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.Mode;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p170d.DynamicClickInfo;
import com.bytedance.sdk.openadsdk.core.p170d.Image;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.p188g.TTNetClient;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import epco.C7990p;
import java.util.Locale;

public class BannerExpressBackupView extends BackupView {
    /* renamed from: h */
    private static Mode[] f7249h = {new Mode(1, 6.6666665f, OtherError.CONTAINER_INVISIBLE_ERROR, 90), new Mode(1, 6.4f, ScreenUtil.M9_WIDTH, 100), new Mode(1, 4.0f, OtherError.CONTAINER_INVISIBLE_ERROR, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE), new Mode(2, 1.2f, OtherError.CONTAINER_INVISIBLE_ERROR, 500), new Mode(3, 1.5f, OtherError.CONTAINER_INVISIBLE_ERROR, 400), new Mode(3, 2.0f, OtherError.CONTAINER_INVISIBLE_ERROR, 300), new Mode(3, 2.3076923f, OtherError.CONTAINER_INVISIBLE_ERROR, C7990p.f27145j), new Mode(3, 1.7783505f, 690, 388)};
    /* renamed from: i */
    private View f7250i;
    /* renamed from: j */
    private NativeExpressView f7251j;
    /* renamed from: k */
    private ITTDownloadAdapter f7252k;
    /* renamed from: l */
    private int f7253l = 1;

    public BannerExpressBackupView(Context context) {
        super(context);
        this.f7750a = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo15294a(int i, DynamicClickInfo iVar) {
        NativeExpressView nativeExpressView = this.f7251j;
        if (nativeExpressView != null) {
            nativeExpressView.mo15184a(i, iVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo15295a(MaterialMeta kVar, NativeExpressView nativeExpressView, ITTDownloadAdapter aVar) {
        setBackgroundColor(-1);
        this.f7751b = kVar;
        this.f7251j = nativeExpressView;
        this.f7252k = aVar;
        this.f7754e = "banner_ad";
        this.f7251j.addView(this, new LayoutParams(-2, -2));
        m9108b();
    }

    /* renamed from: b */
    private void m9108b() {
        Mode a = m9106a(this.f7251j.getExpectExpressWidth(), this.f7251j.getExpectExpressHeight());
        if (this.f7251j.getExpectExpressWidth() <= 0 || this.f7251j.getExpectExpressHeight() <= 0) {
            if (this.f7251j.getExpectExpressWidth() > 0 && this.f7251j.getExpectExpressHeight() <= 0) {
                this.f7755f = UIUtils.m12079c(this.f7750a, (float) this.f7251j.getExpectExpressWidth());
                this.f7756g = Float.valueOf(((float) this.f7755f) / a.f7847b).intValue();
            } else if (this.f7251j.getExpectExpressWidth() > 0 || this.f7251j.getExpectExpressHeight() <= 0) {
                this.f7755f = UIUtils.m12078c(this.f7750a);
                this.f7756g = Float.valueOf(((float) this.f7755f) / a.f7847b).intValue();
            } else {
                this.f7756g = UIUtils.m12079c(this.f7750a, (float) this.f7251j.getExpectExpressHeight());
                this.f7755f = Float.valueOf(((float) this.f7756g) * a.f7847b).intValue();
            }
        } else if (this.f7251j.getExpectExpressWidth() > this.f7251j.getExpectExpressHeight()) {
            this.f7755f = UIUtils.m12079c(this.f7750a, ((float) this.f7251j.getExpectExpressHeight()) * a.f7847b);
            this.f7756g = UIUtils.m12079c(this.f7750a, (float) this.f7251j.getExpectExpressHeight());
        } else {
            this.f7755f = UIUtils.m12079c(this.f7750a, (float) this.f7251j.getExpectExpressWidth());
            this.f7756g = UIUtils.m12079c(this.f7750a, ((float) this.f7251j.getExpectExpressWidth()) / a.f7847b);
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
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (a.f7846a == 1) {
            m9111e();
        } else if (a.f7846a == 2) {
            m9110d();
        } else if (a.f7846a == 3) {
            m9109c();
        } else {
            m9111e();
        }
    }

    /* renamed from: a */
    private void m9107a(ImageView imageView) {
        TTNetClient.m11428a(this.f7750a).mo16653a(((Image) this.f7751b.mo15418F().get(0)).mo15406a(), imageView);
    }

    /* renamed from: c */
    private void m9109c() {
        this.f7250i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_banner_layout3"), this, true);
        View findViewById = this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        TextView textView = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_name"));
        TextView textView4 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BannerExpressBackupView.this.mo15843a();
            }
        });
        int a = (int) UIUtils.m12048a(this.f7750a, 15.0f);
        UIUtils.m12060a(findViewById, a, a, a, a);
        m9107a(imageView);
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView2);
        textView3.setText(getNameOrSource());
        textView.setText(String.format(Locale.getDefault(), "%s提供的广告", new Object[]{getNameOrSource()}));
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView4.setText(this.f7751b.mo15424L());
        }
        mo15844a((View) this, false);
        mo15844a((View) textView4, true);
    }

    /* renamed from: d */
    private void m9110d() {
        this.f7250i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_banner_layout2"), this, true);
        View findViewById = this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        TextView textView = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BannerExpressBackupView.this.mo15843a();
            }
        });
        int a = (int) UIUtils.m12048a(this.f7750a, 15.0f);
        UIUtils.m12060a(findViewById, a, a, a, a);
        m9107a(imageView);
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: e */
    private void m9111e() {
        this.f7250i = LayoutInflater.from(this.f7750a).inflate(ResourceHelp.m11936f(this.f7750a, "tt_backup_banner_layout1"), this, true);
        ImageView imageView = (ImageView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_icon"));
        TextView textView = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_title"));
        TextView textView2 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_score_bar"));
        TextView textView3 = (TextView) this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_download"));
        this.f7250i.findViewById(ResourceHelp.m11935e(this.f7750a, "tt_bu_close")).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BannerExpressBackupView.this.mo15843a();
            }
        });
        TTNetClient.m11428a(this.f7750a).mo16653a(this.f7751b.mo15415C().mo15406a(), imageView);
        textView.setText(getTitle());
        if (!TextUtils.isEmpty(this.f7751b.mo15424L())) {
            textView3.setText(this.f7751b.mo15424L());
        }
        int e = this.f7751b.mo15426N() != null ? this.f7751b.mo15426N().mo15350e() : 4;
        textView2.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Float.valueOf((float) e)}));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth((float) UIUtils.m12079c(this.f7750a, 15.0f));
        tTRatingBar.setStarImageHeight((float) UIUtils.m12079c(this.f7750a, 14.0f));
        tTRatingBar.setStarImagePadding((float) UIUtils.m12079c(this.f7750a, 4.0f));
        tTRatingBar.mo16263a();
        mo15844a((View) this, false);
        mo15844a((View) textView3, true);
    }

    /* renamed from: a */
    private Mode m9106a(int i, int i2) {
        Mode[] iVarArr;
        try {
            float floatValue = Float.valueOf((float) i).floatValue() / Float.valueOf((float) i2).floatValue();
            Mode iVar = f7249h[0];
            Mode iVar2 = iVar;
            float f = Float.MAX_VALUE;
            for (Mode iVar3 : f7249h) {
                float abs = Math.abs(iVar3.f7847b - floatValue);
                if (abs <= f) {
                    iVar2 = iVar3;
                    f = abs;
                }
            }
            return iVar2;
        } catch (Throwable unused) {
            return f7249h[0];
        }
    }
}
