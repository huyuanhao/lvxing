package com.p368pw.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.base.p384a.C5123d;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p391d.C5176a;
import com.p368pw.inner.base.p387d.p391d.C5176a.C5181a;
import com.p368pw.inner.base.p387d.p391d.C5183b;
import com.p368pw.inner.p369a.p376b.C4879b;
import com.p368pw.inner.p369a.p376b.C4880c;
import com.p368pw.inner.p369a.p376b.C4880c.C4885a;
import com.pw.R;

/* renamed from: com.pw.view.FullInterstitialActivity */
public class FullInterstitialActivity extends Activity implements OnClickListener {
    public static final String DATA = "ins_data";
    public static final String HTML = "ins_html";
    public static final String SOURCE = "ins_source";
    public static final String URL = "ins_url";
    /* access modifiers changed from: private */
    public int mAdSource;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public TextView mCountDownView;
    /* access modifiers changed from: private */
    public C4879b mInsBean;
    /* access modifiers changed from: private */
    public C4885a mInsMngListener = new C4885a() {
        public void onDownloadFinished() {
            FullInterstitialActivity.this.handlerPageEvent(1, "video://install");
        }

        public void onInstalled() {
            FullInterstitialActivity.this.handlerPageEvent(2, "video://open");
        }

        public void onLandPageClose() {
            if (!FullInterstitialActivity.this.isFinishing()) {
                FullInterstitialActivity.this.finish();
            }
        }
    };
    private RelativeLayout mRelativeLayout;
    private CountDownTimer mTimer;
    private C5176a mWebview;

    private void countDown() {
        long j = C5125f.m21216a().mo26727d() != null ? 8000 : 0;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (j <= 0) {
            onClose();
            return;
        }
        this.mCountDownView.setVisibility(0);
        C52563 r5 = new CountDownTimer(j, 1000) {
            public void onFinish() {
                FullInterstitialActivity.this.finish();
            }

            public void onTick(long j) {
                if (FullInterstitialActivity.this.mCountDownView != null && !FullInterstitialActivity.this.isFinishing()) {
                    FullInterstitialActivity.this.mCountDownView.setText(String.format("%sS | 跳出", new Object[]{Long.valueOf(j / 1000)}));
                }
            }
        };
        this.mTimer = r5;
        this.mTimer.start();
    }

    /* access modifiers changed from: private */
    public void handlerPageEvent(int i, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("javascript:getTmpInfo({icon:'");
            sb.append(this.mInsBean.mo25920g());
            sb.append("',title:'");
            sb.append(this.mInsBean.mo25913d());
            sb.append("',desc:'");
            sb.append(this.mInsBean.mo25916e());
            sb.append("',type:");
            sb.append(i);
            sb.append(",background:'");
            sb.append(this.mInsBean.mo25928k());
            sb.append("',link:'");
            sb.append(str);
            sb.append("'})");
            if (this.mWebview != null) {
                this.mWebview.loadUrl(sb.toString());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    private void loadHtml() {
        try {
            String stringExtra = getIntent().getStringExtra(URL);
            C5123d d = C5125f.m21216a().mo26727d();
            if (C5207q.m21478b((CharSequence) d.mo26704h())) {
                stringExtra = d.mo26704h();
            }
            this.mWebview.loadUrl(stringExtra);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: private */
    public void onClose() {
        C4880c.m20089a().mo25952b(this.mContext, this.mInsBean);
        finish();
    }

    public void clearWebview() {
        try {
            if (this.mWebview != null) {
                this.mRelativeLayout.removeView(this.mWebview);
                this.mWebview.clearHistory();
                this.mWebview.clearCache(true);
                this.mWebview.loadUrl("about:blank");
                this.mWebview.clearView();
                this.mWebview = null;
                C5205o.m21462a("fu ins cls");
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void init(Context context) {
        try {
            this.mWebview = new C5176a(context, new C5181a() {
                public void onPageFinished(WebView webView, String str) {
                    int i;
                    FullInterstitialActivity fullInterstitialActivity;
                    String str2;
                    super.onPageFinished(webView, str);
                    if (C5191i.m21390a(FullInterstitialActivity.this.mContext, FullInterstitialActivity.this.mInsBean.mo25904a())) {
                        fullInterstitialActivity = FullInterstitialActivity.this;
                        i = 2;
                        str2 = "video://open";
                    } else {
                        i = 1;
                        if (C5153c.m21275a().mo26759a(FullInterstitialActivity.this.mContext, FullInterstitialActivity.this.mInsBean.mo25904a()) == 1) {
                            fullInterstitialActivity = FullInterstitialActivity.this;
                            str2 = "video://install";
                        } else {
                            fullInterstitialActivity = FullInterstitialActivity.this;
                            i = 0;
                            str2 = "video://download";
                        }
                    }
                    fullInterstitialActivity.handlerPageEvent(i, str2);
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fu ins act url loading = ");
                    sb.append(str);
                    C5205o.m21462a(sb.toString());
                    try {
                        if (str.startsWith("video://close")) {
                            FullInterstitialActivity.this.onClose();
                            return true;
                        }
                        if (str.startsWith("video://download") || str.startsWith("video://install") || str.startsWith("video://open")) {
                            if (C5207q.m21478b((CharSequence) this.overrideDeepLink)) {
                                FullInterstitialActivity.this.mInsBean.mo25936o(this.overrideDeepLink);
                                C5205o.m21462a("webview重定向后存在deeplink，替换广告对象的deeplink");
                            }
                            C4880c.m20089a().mo25950a(FullInterstitialActivity.this.mContext, FullInterstitialActivity.this.mInsBean, FullInterstitialActivity.this.mAdSource, C5183b.m21360a(), FullInterstitialActivity.this.mInsMngListener);
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(webView, str);
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            });
            this.mRelativeLayout.addView(this.mWebview, new LayoutParams(-1, -1));
            this.mCountDownView = new TextView(this);
            this.mCountDownView.setBackgroundResource(R.drawable.win_sdk_count_down_bg);
            this.mCountDownView.setOnClickListener(this);
            this.mCountDownView.setGravity(17);
            this.mCountDownView.setTextColor(-1);
            this.mCountDownView.setTextSize(12.0f);
            this.mCountDownView.setPadding(C5191i.m21391b((Context) this, 8), C5191i.m21391b((Context) this, 4), C5191i.m21391b((Context) this, 8), C5191i.m21391b((Context) this, 4));
            this.mCountDownView.setVisibility(8);
            LayoutParams layoutParams = new LayoutParams(C5191i.m21391b((Context) this, 70), -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.topMargin = C5191i.m21391b((Context) this, 20);
            layoutParams.rightMargin = C5191i.m21391b((Context) this, 15);
            this.mRelativeLayout.addView(this.mCountDownView, layoutParams);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onClick(View view) {
        if (view == this.mCountDownView) {
            onClose();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        this.mInsBean = (C4879b) getIntent().getSerializableExtra("ins_data");
        this.mAdSource = getIntent().getIntExtra(SOURCE, 0);
        this.mContext = getApplicationContext();
        this.mRelativeLayout = new RelativeLayout(this.mContext, null);
        this.mRelativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        setContentView(this.mRelativeLayout);
        init(this.mContext);
        loadHtml();
        countDown();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        clearWebview();
        this.mTimer.cancel();
    }
}
