package com.p368pw.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.p391d.C5176a;
import com.p368pw.inner.base.p387d.p391d.C5186d;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4925a;
import com.p368pw.inner.p369a.p379e.p380a.p382b.C4926b;
import java.io.Serializable;

/* renamed from: com.pw.view.WebActivity */
public class WebActivity extends Activity {
    public static final String BAR_TITLE = "bar_title";
    public static final float BAR_TITLE_HEIGHT = 40.0f;
    public static final String LOAD_URL = "load_url";
    public static final String WEB_ACT_UUID = "web_act_uuid";
    private TextView barTitleView;
    private ImageView mCloseImgView;
    private Context mContext;
    private RelativeLayout mRelativeLayout;
    private RelativeLayout mTopBarLayout;
    private String mUrl;
    /* access modifiers changed from: private */
    public String mWebUuid;
    private C5176a mWebview;

    /* renamed from: com.pw.view.WebActivity$IWebActivityListener */
    public interface IWebActivityListener extends Serializable {
        void onClose(int i);
    }

    private void addTitleCloseView() {
        try {
            this.mTopBarLayout = new RelativeLayout(this.mContext, null);
            LayoutParams layoutParams = new LayoutParams(-1, C4925a.m20443a(this.mContext, 40.0f));
            layoutParams.addRule(10, -1);
            this.mTopBarLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.mRelativeLayout.addView(this.mTopBarLayout, layoutParams);
            this.mCloseImgView = new ImageView(this.mContext);
            this.mCloseImgView.setImageDrawable(C4926b.landing_page_back.mo26118a(this.mContext));
            LayoutParams layoutParams2 = new LayoutParams(C4925a.m20443a(this.mContext, 40.0f), C4925a.m20443a(this.mContext, 40.0f));
            layoutParams2.addRule(9, -1);
            layoutParams2.setMargins(0, 0, 0, 0);
            this.mTopBarLayout.addView(this.mCloseImgView, layoutParams2);
            this.mCloseImgView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    WebActivity webActivity = WebActivity.this;
                    webActivity.mWebUuid = webActivity.getIntent().getStringExtra(WebActivity.WEB_ACT_UUID);
                    if (!(WebActivity.this.mWebUuid == null || C5186d.m21366a(WebActivity.this.mWebUuid) == null)) {
                        C5186d.m21366a(WebActivity.this.mWebUuid).onClose(1);
                    }
                    WebActivity.this.finish();
                }
            });
            String stringExtra = getIntent().getStringExtra(BAR_TITLE);
            if (stringExtra != null) {
                if (stringExtra.trim().length() > 0) {
                    if (stringExtra.length() > 10) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(stringExtra.substring(0, 10));
                        sb.append("...");
                        stringExtra = sb.toString();
                    }
                    this.barTitleView = new TextView(this.mContext, null);
                    LayoutParams layoutParams3 = new LayoutParams(-1, -1);
                    this.barTitleView.setText(stringExtra);
                    this.barTitleView.setGravity(17);
                    this.barTitleView.setTextSize(20.0f);
                    this.barTitleView.setSingleLine(true);
                    this.barTitleView.setEllipsize(null);
                    this.barTitleView.setTextColor(Color.parseColor("#393939"));
                    this.mTopBarLayout.addView(this.barTitleView, layoutParams3);
                }
            }
            stringExtra = "";
            this.barTitleView = new TextView(this.mContext, null);
            LayoutParams layoutParams32 = new LayoutParams(-1, -1);
            this.barTitleView.setText(stringExtra);
            this.barTitleView.setGravity(17);
            this.barTitleView.setTextSize(20.0f);
            this.barTitleView.setSingleLine(true);
            this.barTitleView.setEllipsize(null);
            this.barTitleView.setTextColor(Color.parseColor("#393939"));
            this.mTopBarLayout.addView(this.barTitleView, layoutParams32);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    private void loadUrl() {
        try {
            this.mUrl = getIntent().getStringExtra(LOAD_URL);
            this.mWebview.loadUrl(this.mUrl);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
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
                C5205o.m21462a("wb cls");
            }
            if (this.mWebUuid != null && C5186d.m21366a(this.mWebUuid) != null) {
                C5186d.m21368b(this.mWebUuid);
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void init(Context context) {
        try {
            this.mWebview = new C5176a(context, null);
            this.mWebview.setBackgroundColor(-1);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.addRule(10, -1);
            layoutParams.setMargins(0, C4925a.m20443a(this.mContext, 40.0f), 0, 0);
            this.mRelativeLayout.addView(this.mWebview, layoutParams);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onBackPressed() {
        this.mWebUuid = getIntent().getStringExtra(WEB_ACT_UUID);
        String str = this.mWebUuid;
        if (!(str == null || C5186d.m21366a(str) == null)) {
            C5186d.m21366a(this.mWebUuid).onClose(2);
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = getApplicationContext();
        this.mRelativeLayout = new RelativeLayout(this.mContext, null);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        setContentView(this.mRelativeLayout);
        init(this.mContext);
        addTitleCloseView();
        loadUrl();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        clearWebview();
    }
}
