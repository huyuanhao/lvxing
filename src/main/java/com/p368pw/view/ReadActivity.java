package com.p368pw.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.p368pw.inner.appwall.read.DonutProgress;
import com.p368pw.inner.appwall.read.NewsWebView;
import com.p368pw.inner.appwall.read.NewsWebView.C5045a;
import com.pw.R;

/* renamed from: com.pw.view.ReadActivity */
public class ReadActivity extends Activity {
    private static final int COMPLETE_TIME = 30;
    private static final String INTENT_DATA_COIN = "intent_data_coin";
    public static final String INTENT_DATA_FINISH_TASK = "intent_data_finish_task";
    private static final String INTENT_DATA_STAY_TIME = "intent_data_stay_time";
    private static final String INTENT_DATA_URL = "intent_data_url";
    private static final int PROGRESS_UPDATE_INTERVAL = 50;
    final int MSG_HIDE_TIPS = 4483;
    final int MSG_RESTART = 4482;
    final int MSG_START = 4481;
    /* access modifiers changed from: private */
    public boolean isInit = false;
    private double mCoin = 0.0d;
    /* access modifiers changed from: private */
    public AnimationSet mGoldAnimation;
    /* access modifiers changed from: private */
    public View mGoldIcon;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 4481) {
                float min = Math.min(ReadActivity.this.mNewsProgress.getProgress() + ((100.0f / ((float) ReadActivity.this.mStayTime)) / 20.0f), 100.0f);
                ReadActivity.this.mNewsProgress.setProgress(min);
                if (min >= 100.0f) {
                    ReadActivity.this.mReadCount = ReadActivity.this.mReadCount + 1;
                    ReadActivity.this.mGoldIcon.startAnimation(ReadActivity.this.mGoldAnimation);
                    if (!ReadActivity.this.isFinishTask()) {
                        sendEmptyMessageDelayed(4482, 1000);
                    }
                    ReadActivity.this.onFinishReadTask();
                    return;
                }
            } else if (message.what == 4482) {
                if (!ReadActivity.this.isFinishTask()) {
                    ReadActivity.this.mNewsProgress.setProgress(0.0f);
                } else {
                    return;
                }
            } else if (message.what == 4483) {
                ReadActivity.this.hideTips();
                return;
            } else {
                return;
            }
            sendEmptyMessageDelayed(4481, 50);
        }
    };
    /* access modifiers changed from: private */
    public String mLoadUrl = "https://random.yourfavorite.site/g/6917b9b6-0c5f-4a86-9172-8e08f0e8b11e";
    /* access modifiers changed from: private */
    public View mLoading;
    /* access modifiers changed from: private */
    public DonutProgress mNewsProgress;
    /* access modifiers changed from: private */
    public int mReadCount = 0;
    /* access modifiers changed from: private */
    public int mStayTime = 0;
    private int mTargetCount = 1;
    private TextView mTipsText;
    private View mTipsView;
    private NewsWebView mWebView;

    /* access modifiers changed from: private */
    public void hideTips() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(800);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new DecelerateInterpolator(3.0f));
        this.mTipsView.startAnimation(translateAnimation);
    }

    private void initGoldAnimation() {
        this.mGoldAnimation = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.25f, 1.0f, 1.25f, 1, 0.5f, 1, 0.5f);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation2.setDuration(1000);
        scaleAnimation2.setStartOffset(300);
        this.mGoldAnimation.addAnimation(scaleAnimation);
        this.mGoldAnimation.addAnimation(scaleAnimation2);
        this.mGoldAnimation.setFillAfter(true);
    }

    private void initView() {
        this.mWebView.setLayerType(1, null);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setPluginState(PluginState.ON);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setAppCacheEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (!ReadActivity.this.isInit && ReadActivity.this.mLoadUrl.equals(str)) {
                    ReadActivity.this.isInit = true;
                    ReadActivity.this.mLoading.setVisibility(8);
                    ReadActivity.this.updateReadingProgress();
                }
                if (ReadActivity.this.isInit && !ReadActivity.this.mLoadUrl.equals(str) && ReadActivity.this.mNewsProgress.getProgress() == 100.0f) {
                    ReadActivity.this.mHandler.sendEmptyMessageDelayed(4482, 0);
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return false;
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return false;
            }
        });
        this.mWebView.loadUrl(this.mLoadUrl);
        this.mWebView.setOnScrollChangeListener(new C5045a() {
            public void onMove() {
                boolean access$900 = ReadActivity.this.isInit;
            }
        });
        updateTips();
    }

    /* access modifiers changed from: private */
    public boolean isFinishTask() {
        return this.mTargetCount - this.mReadCount <= 0;
    }

    /* access modifiers changed from: private */
    public void onFinishReadTask() {
        showTips();
    }

    /* access modifiers changed from: private */
    public void onTipsShow() {
        this.mHandler.sendEmptyMessageDelayed(4483, 5000);
    }

    private void showTips() {
        updateTips();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(800);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new DecelerateInterpolator(3.0f));
        translateAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                ReadActivity.this.onTipsShow();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.mTipsView.startAnimation(translateAnimation);
    }

    public static void start(Activity activity, int i, String str, double d, int i2) {
        Intent intent = new Intent(activity, ReadActivity.class);
        intent.putExtra(INTENT_DATA_URL, str);
        intent.putExtra(INTENT_DATA_COIN, d);
        intent.putExtra(INTENT_DATA_STAY_TIME, i2);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: private */
    public void updateReadingProgress() {
        this.mHandler.sendEmptyMessageDelayed(4481, 100);
    }

    private void updateTips() {
        int max = Math.max(0, this.mTargetCount - this.mReadCount);
        String str = "奖励";
        if (max > 0) {
            TextView textView = this.mTipsText;
            StringBuilder sb = new StringBuilder();
            sb.append("阅读");
            sb.append(max);
            sb.append("篇，即可获得");
            sb.append((int) this.mCoin);
            sb.append(str);
            textView.setText(sb.toString());
            return;
        }
        TextView textView2 = this.mTipsText;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("已完成阅读任务，获得");
        sb2.append((int) this.mCoin);
        sb2.append(str);
        textView2.setText(sb2.toString());
    }

    public void onBackPressed() {
        if (this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(INTENT_DATA_FINISH_TASK, isFinishTask());
        setResult(0, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.win_sdk_activity_read);
        this.mLoadUrl = getIntent().getStringExtra(INTENT_DATA_URL);
        this.mCoin = getIntent().getDoubleExtra(INTENT_DATA_COIN, 0.0d);
        this.mStayTime = getIntent().getIntExtra(INTENT_DATA_STAY_TIME, 0);
        this.mNewsProgress = (DonutProgress) findViewById(R.id.win_sdk_read_news_progress);
        this.mWebView = (NewsWebView) findViewById(R.id.win_sdk_read_news_webview);
        this.mGoldIcon = findViewById(R.id.win_sdk_read_news_gold);
        this.mTipsView = findViewById(R.id.win_sdk_read_tip);
        this.mTipsText = (TextView) findViewById(R.id.win_sdk_read_tip_text);
        this.mLoading = findViewById(R.id.win_sdk_read_loading);
        initView();
        initGoldAnimation();
    }

    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onResume() {
        super.onResume();
        if (this.isInit && !isFinishTask()) {
            updateReadingProgress();
        }
        onTipsShow();
    }
}
