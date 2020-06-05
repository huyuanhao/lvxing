package com.tencent.p605ep.shanhuad.adpublic.adbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.p605ep.commonbase.utils.ScreenUtil;
import com.tencent.p605ep.shanhuad.C7299R;
import com.tencent.p605ep.shanhuad.adpublic.adbuilder.RewardVideo.RVListener;
import com.tencent.p605ep.shanhuad.adpublic.view.BottomBanner;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.AdRequestData;
import com.tencent.qqpim.discovery.NativeAd;
import com.tencent.qqpim.discovery.internal.model.ClickDataModel;
import shanhuAD.C8672G.C8674b;
import shanhuAD.C8684i;
import shanhuAD.C8690o.C8691a;
import shanhuAD.C8703y;

/* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVedioPage */
public class RewardVedioPage extends Activity {
    public static final String INTENT_AD_MODEL = "INTENT_SHANHU_AD_MODEL";
    /* renamed from: pi */
    private static final int f24761pi = 1;
    /* renamed from: qi */
    private static final int f24762qi = 2;
    /* renamed from: ri */
    private static final int f24763ri = 3;
    /* renamed from: si */
    private static final int f24764si = 1;
    /* renamed from: ti */
    private static final int f24765ti = 2;
    /* renamed from: vi */
    private static final int f24766vi = 3;
    /* renamed from: Ai */
    private BottomBanner f24767Ai;
    /* renamed from: Bi */
    private ImageView f24768Bi;
    /* access modifiers changed from: private */
    /* renamed from: Ci */
    public TextView f24769Ci;
    /* access modifiers changed from: private */
    /* renamed from: Di */
    public View f24770Di;
    /* renamed from: Ei */
    private int f24771Ei = 0;
    /* renamed from: Fi */
    private AdRequestData f24772Fi = new AdRequestData();
    /* access modifiers changed from: private */
    /* renamed from: Gi */
    public NativeAd f24773Gi = new NativeAd(this.f24772Fi);
    /* access modifiers changed from: private */
    /* renamed from: Hi */
    public ClickDataModel f24774Hi = new ClickDataModel();
    /* access modifiers changed from: private */
    /* renamed from: Ii */
    public boolean f24775Ii = false;
    /* access modifiers changed from: private */
    /* renamed from: Ji */
    public boolean f24776Ji = false;
    /* renamed from: Ki */
    private int f24777Ki = 0;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                RewardVedioPage.this.m31570Bb();
            } else if (i == 2) {
                RewardVedioPage.this.m31592yb();
            } else if (i == 3) {
                RewardVedioPage.this.f24769Ci.setText("0");
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: wi */
    public AdDisplayModel f24778wi;
    /* access modifiers changed from: private */
    /* renamed from: xi */
    public boolean f24779xi = true;
    /* renamed from: yi */
    private int f24780yi = 0;
    /* access modifiers changed from: private */
    /* renamed from: zi */
    public C8703y f24781zi;

    /* renamed from: com.tencent.ep.shanhuad.adpublic.adbuilder.RewardVedioPage$ScreenOnTouch */
    private class ScreenOnTouch implements OnTouchListener {
        private ScreenOnTouch() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                RewardVedioPage.this.f24774Hi.down_x = (double) motionEvent.getX();
                RewardVedioPage.this.f24774Hi.down_y = (double) motionEvent.getY();
            } else if (action == 1) {
                RewardVedioPage.this.f24774Hi.up_x = (double) motionEvent.getX();
                RewardVedioPage.this.f24774Hi.up_y = (double) motionEvent.getY();
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Ab */
    public void m31569Ab() {
        if (this.f24779xi) {
            this.f24768Bi.setImageDrawable(getResources().getDrawable(C7299R.C7300drawable.shanhu_dis_volume_on));
        } else {
            this.f24768Bi.setImageDrawable(getResources().getDrawable(C7299R.C7300drawable.shanhu_dis_volume_off));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Bb */
    public void m31570Bb() {
        this.f24767Ai.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RewardVedioPage.this.m31591xb();
            }
        });
        this.f24767Ai.showUp();
    }

    /* renamed from: Cb */
    private void m31571Cb() {
        this.f24781zi = new C8703y(this);
        this.f24781zi.setVolume(0.5f, 0.5f);
        this.f24781zi.mo41466sb();
        this.f24781zi.mo41454a((C8691a) new C8691a() {
            public void onCompletion() {
                RewardVedioPage.this.mHandler.removeMessages(2);
                RewardVedioPage.this.mHandler.obtainMessage(3).sendToTarget();
                RewardVedioPage.this.f24770Di.setVisibility(0);
                RewardVedioPage.this.f24773Gi;
                NativeAd.reportAppPhase(RewardVedioPage.this.f24778wi, 11, 5);
                RVListener R = C8684i.getInstance().mo41446R(RewardVedioPage.this.f24778wi.uniqueKey);
                if (R != null) {
                    R.onVideoComplete();
                    RewardVedioPage.this.f24775Ii = false;
                    RewardVedioPage.this.f24776Ji = true;
                }
            }
        }, false);
        ((LinearLayout) findViewById(C7299R.C7301id.content_view)).addView(this.f24781zi);
        this.f24781zi.setSourceUrl(this.f24778wi.videoUrl);
        this.f24781zi.start();
        this.f24781zi.setVideoStartListener(new C8674b() {
            public void videoStart(int i) {
                if (RewardVedioPage.this.f24776Ji) {
                    RewardVedioPage.this.f24781zi.pause();
                    return;
                }
                if (!RewardVedioPage.this.f24775Ii) {
                    RewardVedioPage.this.f24775Ii = true;
                    RewardVedioPage.this.m31572Q(i);
                    RewardVedioPage.this.f24773Gi;
                    NativeAd.reportAppPhase(RewardVedioPage.this.f24778wi, 11, 1);
                    RVListener R = C8684i.getInstance().mo41446R(RewardVedioPage.this.f24778wi.uniqueKey);
                    if (R != null) {
                        R.onVideoPlay();
                    }
                }
            }
        });
        this.f24781zi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RewardVedioPage.this.m31591xb();
            }
        });
        this.f24773Gi.onSpecificScenesAdDisplay(this.f24778wi);
    }

    /* access modifiers changed from: private */
    /* renamed from: Q */
    public void m31572Q(int i) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000);
        this.f24780yi = i;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 500);
        findViewById(C7299R.C7301id.btn_area).setVisibility(0);
        this.f24768Bi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (RewardVedioPage.this.f24779xi) {
                    RewardVedioPage.this.f24779xi = false;
                    RewardVedioPage.this.f24781zi.setVolume(0.0f, 0.0f);
                } else {
                    RewardVedioPage.this.f24779xi = true;
                    RewardVedioPage.this.f24781zi.setVolume(0.5f, 0.5f);
                }
                RewardVedioPage.this.m31569Ab();
            }
        });
        m31569Ab();
    }

    /* access modifiers changed from: private */
    /* renamed from: xb */
    public void m31591xb() {
        this.f24774Hi.view_h = (double) ScreenUtil.getScreenHeight();
        this.f24774Hi.view_w = (double) ScreenUtil.getScreenWidth();
        AdDisplayModel adDisplayModel = this.f24778wi;
        adDisplayModel.cModel = this.f24774Hi;
        this.f24773Gi.onSpecificScenesAdClick(adDisplayModel);
        RVListener R = C8684i.getInstance().mo41446R(this.f24778wi.uniqueKey);
        if (R != null) {
            R.onClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: yb */
    public void m31592yb() {
        int currentPosition = this.f24781zi.getCurrentPosition();
        if (this.f24771Ei < currentPosition) {
            this.f24771Ei = currentPosition;
        }
        m31593zb();
        TextView textView = this.f24769Ci;
        StringBuilder sb = new StringBuilder();
        sb.append((this.f24780yi / 1000) - (currentPosition / 1000));
        sb.append("");
        textView.setText(sb.toString());
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 100);
    }

    /* renamed from: zb */
    private void m31593zb() {
        double d = ((double) this.f24771Ei) / ((double) this.f24780yi);
        String str = "RewardVedioPage";
        if (d < 0.25d || this.f24777Ki != 0) {
            String str2 = "50";
            if (d >= 0.5d && this.f24777Ki == 1) {
                this.f24777Ki = 2;
                Log.m31477d(str, str2);
            } else if (d >= 0.75d && this.f24777Ki == 2) {
                this.f24777Ki = 3;
                Log.m31477d(str, str2);
            }
        } else {
            this.f24777Ki = 1;
            Log.m31477d(str, "25");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C7299R.C7302layout.shanhu_reward_view);
        this.f24767Ai = (BottomBanner) findViewById(C7299R.C7301id.banner_bottom);
        this.f24778wi = (AdDisplayModel) getIntent().getParcelableExtra(INTENT_AD_MODEL);
        BottomBanner bottomBanner = this.f24767Ai;
        AdDisplayModel adDisplayModel = this.f24778wi;
        bottomBanner.setInfo(adDisplayModel.text1, adDisplayModel.text2, adDisplayModel.imageUrl2, "下载");
        this.f24768Bi = (ImageView) findViewById(C7299R.C7301id.iv_volume);
        this.f24770Di = findViewById(C7299R.C7301id.btn_ad_close);
        this.f24769Ci = (TextView) findViewById(C7299R.C7301id.tv_time);
        m31571Cb();
        this.f24770Di.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                RewardVedioPage.this.finish();
            }
        });
        this.f24781zi.setOnTouchListener(new ScreenOnTouch());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(null);
        int i = this.f24777Ki;
        if (i == 1) {
            NativeAd nativeAd = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 2);
        } else if (i == 2) {
            NativeAd nativeAd2 = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 2);
            NativeAd nativeAd3 = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 3);
        } else if (i == 3) {
            NativeAd nativeAd4 = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 2);
            NativeAd nativeAd5 = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 3);
            NativeAd nativeAd6 = this.f24773Gi;
            NativeAd.reportAppPhase(this.f24778wi, 11, 4);
        }
        RVListener R = C8684i.getInstance().mo41446R(this.f24778wi.uniqueKey);
        if (R != null) {
            R.onClose();
        }
        C8684i.getInstance().mo41447S(this.f24778wi.uniqueKey);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0 && this.f24781zi.isPlaying()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.f24775Ii) {
            this.f24781zi.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f24775Ii) {
            this.f24769Ci.setText("");
            this.f24781zi.resume();
        } else if (this.f24776Ji) {
            this.f24781zi.seekTo(10);
            this.f24781zi.resume();
            this.f24781zi.pause();
        }
    }
}
