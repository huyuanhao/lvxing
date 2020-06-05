package com.qiyukf.nim.uikit.session.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5312a;
import com.qiyukf.basesdk.p412c.p413a.C5363b;
import com.qiyukf.basesdk.p412c.p417d.C5414f;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.activity.BaseFragmentActivity;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WatchVideoActivity extends BaseFragmentActivity implements OnClickListener {
    /* renamed from: A */
    private AbortableFuture f17742A;
    /* access modifiers changed from: private */
    /* renamed from: B */
    public Runnable f17743B = new Runnable() {
        public final void run() {
            Object obj;
            if (WatchVideoActivity.this.f17755k != null && WatchVideoActivity.this.f17755k.isPlaying()) {
                WatchVideoActivity.this.f17768x = 1;
                int i = (WatchVideoActivity.this.f17754j > 0 ? 1 : (WatchVideoActivity.this.f17754j == 0 ? 0 : -1));
                WatchVideoActivity watchVideoActivity = WatchVideoActivity.this;
                if (i <= 0) {
                    watchVideoActivity.f17748d.setVisibility(4);
                    return;
                }
                int currentPosition = watchVideoActivity.f17755k.getCurrentPosition();
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                long a = C5414f.m22157a((long) currentPosition);
                TextView textView = WatchVideoActivity.this.f17748d;
                StringBuilder sb = new StringBuilder("00:");
                if (a < 10) {
                    StringBuilder sb2 = new StringBuilder("0");
                    sb2.append(a);
                    obj = sb2.toString();
                } else {
                    obj = Long.valueOf(a);
                }
                sb.append(obj);
                textView.setText(sb.toString());
                WatchVideoActivity.this.f17746b.setProgress((int) a);
                WatchVideoActivity.this.f17756l.postDelayed(this, 1000);
            }
        }
    };
    /* renamed from: C */
    private Observer<IMMessage> f17744C = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.isTheSame(WatchVideoActivity.this.f17757m) && !WatchVideoActivity.this.mo27417f()) {
                if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && WatchVideoActivity.m22438b(iMMessage)) {
                    WatchVideoActivity.this.m22441c(iMMessage);
                } else if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                    WatchVideoActivity.m22454k(WatchVideoActivity.this);
                }
            }
        }
    };
    /* renamed from: D */
    private Observer<AttachmentProgress> f17745D = new Observer<AttachmentProgress>() {
        public final /* synthetic */ void onEvent(Object obj) {
            long j;
            AttachmentProgress attachmentProgress = (AttachmentProgress) obj;
            long total = attachmentProgress.getTotal();
            long transferred = attachmentProgress.getTransferred();
            float f = ((float) transferred) / ((float) total);
            if (((double) f) > 1.0d) {
                f = 1.0f;
                j = total;
            } else {
                j = transferred;
            }
            int i = (((double) (f - WatchVideoActivity.this.f17767w)) > 0.1d ? 1 : (((double) (f - WatchVideoActivity.this.f17767w)) == 0.1d ? 0 : -1));
            WatchVideoActivity watchVideoActivity = WatchVideoActivity.this;
            if (i >= 0) {
                watchVideoActivity.f17767w = f;
                WatchVideoActivity watchVideoActivity2 = WatchVideoActivity.this;
                watchVideoActivity2.m22430a(watchVideoActivity2.getString(C5961R.string.ysf_download_video), j, total);
                return;
            }
            if (((double) watchVideoActivity.f17767w) == 0.0d) {
                WatchVideoActivity.this.f17767w = f;
                WatchVideoActivity watchVideoActivity3 = WatchVideoActivity.this;
                watchVideoActivity3.m22430a(watchVideoActivity3.getString(C5961R.string.ysf_download_video), j, total);
            }
            if (((double) f) == 1.0d && ((double) WatchVideoActivity.this.f17767w) != 1.0d) {
                WatchVideoActivity.this.f17767w = f;
                WatchVideoActivity watchVideoActivity4 = WatchVideoActivity.this;
                watchVideoActivity4.m22430a(watchVideoActivity4.getString(C5961R.string.ysf_download_video), j, total);
            }
        }
    };
    /* renamed from: b */
    ProgressBar f17746b;
    /* renamed from: c */
    ImageView f17747c;
    /* renamed from: d */
    TextView f17748d;
    /* renamed from: e */
    ImageView f17749e;
    /* renamed from: f */
    CountDownTimer f17750f;
    /* renamed from: g */
    long f17751g = 0;
    /* renamed from: h */
    protected TextView f17752h;
    /* renamed from: i */
    protected String f17753i;
    /* renamed from: j */
    protected long f17754j = 0;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public MediaPlayer f17755k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public Handler f17756l = new Handler();
    /* access modifiers changed from: private */
    /* renamed from: m */
    public IMMessage f17757m;
    /* renamed from: n */
    private SurfaceView f17758n;
    /* renamed from: o */
    private SurfaceHolder f17759o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public View f17760p;
    /* renamed from: q */
    private View f17761q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public View f17762r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public View f17763s;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public TextView f17764t;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public boolean f17765u = true;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public boolean f17766v = false;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public float f17767w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public int f17768x = 2;
    /* renamed from: y */
    private boolean f17769y;
    /* renamed from: z */
    private ImageView f17770z;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22430a(String str, long j, long j2) {
        final float f = (float) (((double) j) / ((double) j2));
        final String str2 = str;
        final long j3 = j;
        final long j4 = j2;
        C550612 r2 = new Runnable() {
            public final void run() {
                LayoutParams layoutParams = WatchVideoActivity.this.f17763s.getLayoutParams();
                layoutParams.width = (int) (((float) WatchVideoActivity.this.f17762r.getWidth()) * f);
                WatchVideoActivity.this.f17763s.setLayoutParams(layoutParams);
                WatchVideoActivity.this.f17764t.setText(String.format(WatchVideoActivity.this.getString(C5961R.string.ysf_download_progress_description), new Object[]{str2, C5363b.m22022a(j3), C5363b.m22022a(j4)}));
            }
        };
        runOnUiThread(r2);
    }

    /* renamed from: a */
    private void m22431a(boolean z) {
        int i = 8;
        this.f17760p.setVisibility(8);
        if (!z) {
            i = 0;
        }
        m22440c(i);
        this.f17747c.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_pause_btn_back);
        MediaPlayer mediaPlayer = this.f17755k;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f17755k.stop();
            } else if (this.f17766v) {
                this.f17755k.setDisplay(this.f17759o);
            } else {
                C5415g.m22165b(C5961R.string.ysf_look_video_fail_try_again);
            }
            this.f17755k.reset();
            try {
                this.f17755k.setDataSource(this.f17753i);
                this.f17755k.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        Object obj;
                        WatchVideoActivity.this.f17760p.setVisibility(0);
                        WatchVideoActivity.this.f17747c.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_start_btn_back);
                        WatchVideoActivity.this.f17768x = 2;
                        WatchVideoActivity.this.f17746b.setProgress(100);
                        int a = (int) C5414f.m22157a(((VideoAttachment) WatchVideoActivity.this.f17757m.getAttachment()).getDuration());
                        StringBuilder sb = new StringBuilder("00:");
                        if (a < 10) {
                            StringBuilder sb2 = new StringBuilder("0");
                            sb2.append(a);
                            obj = sb2.toString();
                        } else {
                            obj = Integer.valueOf(a);
                        }
                        sb.append(obj);
                        WatchVideoActivity.this.f17748d.setText(sb.toString());
                        WatchVideoActivity.this.m22440c(0);
                        WatchVideoActivity.this.f17756l.removeCallbacks(WatchVideoActivity.this.f17743B);
                    }
                });
                this.f17755k.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            StringBuilder sb = new StringBuilder("file://");
                            sb.append(WatchVideoActivity.this.f17753i);
                            intent.setDataAndType(Uri.parse(sb.toString()), "video/3gp");
                            WatchVideoActivity.this.startActivity(intent);
                            WatchVideoActivity.this.finish();
                        } catch (Exception unused) {
                            C5415g.m22165b(C5961R.string.ysf_look_video_fail);
                        }
                        return true;
                    }
                });
                this.f17755k.setOnPreparedListener(new OnPreparedListener() {
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        WatchVideoActivity.this.f17755k.start();
                        WatchVideoActivity.this.m22446g();
                        WatchVideoActivity.this.f17756l.postDelayed(WatchVideoActivity.this.f17743B, 100);
                        if (WatchVideoActivity.this.f17765u) {
                            WatchVideoActivity.this.f17755k.setVolume(0.0f, 0.0f);
                        }
                    }
                });
                this.f17755k.prepareAsync();
            } catch (Exception e) {
                C5415g.m22165b(C5961R.string.ysf_look_video_fail_try_again);
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m22437b(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.f17744C, z);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeAttachmentProgress(this.f17745D, z);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static boolean m22438b(IMMessage iMMessage) {
        return iMMessage.getAttachStatus() == AttachStatusEnum.transferred && !TextUtils.isEmpty(((VideoAttachment) iMMessage.getAttachment()).getPath());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22440c(int i) {
        this.f17749e.setVisibility(i);
        this.f17747c.setVisibility(i);
        this.f17746b.setVisibility(i);
        this.f17748d.setVisibility(i);
        if (i == 8) {
            CountDownTimer countDownTimer = this.f17750f;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                return;
            }
        }
        CountDownTimer countDownTimer2 = this.f17750f;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        initCountDownTimer(3000);
        this.f17750f.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22441c(IMMessage iMMessage) {
        this.f17742A = null;
        this.f17761q.setVisibility(8);
        this.f17753i = ((VideoAttachment) iMMessage.getAttachment()).getPath();
        this.f17747c.setOnClickListener(this);
        this.f17758n.setOnClickListener(this);
        this.f17758n.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                WatchVideoActivity.m22459p(WatchVideoActivity.this);
                return true;
            }
        });
        m22431a(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m22446g() {
        MediaPlayer mediaPlayer = this.f17755k;
        if (mediaPlayer != null) {
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = this.f17755k.getVideoHeight();
            if (videoWidth > 0 && videoHeight > 0) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int i = displayMetrics.widthPixels;
                int i2 = displayMetrics.heightPixels;
                if (i / i2 > videoWidth / videoHeight) {
                    int i3 = (videoWidth * i2) / videoHeight;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i2);
                    int i4 = (i - i3) / 2;
                    layoutParams.setMargins(i4, 0, i4, 0);
                    this.f17758n.setLayoutParams(layoutParams);
                    return;
                }
                int i5 = (videoHeight * i) / videoWidth;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i5);
                int i6 = (i2 - i5) / 2;
                layoutParams2.setMargins(0, i6, 0, i6);
                this.f17758n.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: h */
    private void m22447h() {
        this.f17760p.setVisibility(8);
        this.f17747c.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_pause_btn_back);
        MediaPlayer mediaPlayer = this.f17755k;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            this.f17755k.start();
            this.f17768x = 1;
            this.f17756l.postDelayed(this.f17743B, 100);
        }
    }

    /* renamed from: i */
    private void m22449i() {
        if (!m22438b(this.f17757m)) {
            m22430a(getString(C5961R.string.ysf_download_video), 0, ((VideoAttachment) this.f17757m.getAttachment()).getSize());
            this.f17761q.setVisibility(0);
            this.f17742A = ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(this.f17757m, false);
            this.f17769y = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m22451j() {
        if (m22438b(this.f17757m)) {
            m22441c(this.f17757m);
        }
    }

    /* renamed from: k */
    private void m22453k() {
        AbortableFuture abortableFuture = this.f17742A;
        if (abortableFuture != null) {
            abortableFuture.abort();
            this.f17742A = null;
            this.f17769y = false;
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m22454k(WatchVideoActivity watchVideoActivity) {
        watchVideoActivity.f17742A = null;
        watchVideoActivity.f17761q.setVisibility(8);
        C5415g.m22165b(C5961R.string.ysf_download_video_fail);
    }

    /* renamed from: p */
    static /* synthetic */ void m22459p(WatchVideoActivity watchVideoActivity) {
        View inflate = LayoutInflater.from(watchVideoActivity).inflate(C5961R.C5964layout.ysf_popup_save_video, null);
        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_watch_video_save);
        TextView textView2 = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tv_watch_video_save_cancel);
        textView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WatchVideoActivity.m22460q(WatchVideoActivity.this);
                popupWindow.dismiss();
            }
        });
        textView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAsDropDown(watchVideoActivity.f17758n);
    }

    /* renamed from: q */
    static /* synthetic */ void m22460q(WatchVideoActivity watchVideoActivity) {
        VideoAttachment videoAttachment = (VideoAttachment) watchVideoActivity.f17757m.getAttachment();
        if (videoAttachment.getPath() == null) {
            C5415g.m22163a("请先下载视频");
        }
        String b = C5946c.m23840b();
        if (TextUtils.isEmpty(videoAttachment.getExtension())) {
            C5415g.m22161a(C5961R.string.ysf_video_save_fail);
            return;
        }
        StringBuilder sb = new StringBuilder("video_");
        sb.append(System.currentTimeMillis());
        sb.append(".mp4");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b);
        sb3.append(sb2);
        String sb4 = sb3.toString();
        if (C5312a.m21836a(videoAttachment.getPath(), sb4) != -1) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(new File(sb4)));
                watchVideoActivity.sendBroadcast(intent);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(watchVideoActivity.getString(C5961R.string.ysf_video_save_to));
                sb5.append(b);
                sb5.append("查看");
                C5415g.m22166b(sb5.toString());
            } catch (Exception unused) {
                C5415g.m22165b(C5961R.string.ysf_picture_save_fail);
            }
        } else {
            C5415g.m22161a(C5961R.string.ysf_video_save_fail);
        }
    }

    public static void start(Context context, IMMessage iMMessage, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("EXTRA_DATA", iMMessage);
        intent.putExtra("EXTRA_MENU", z);
        intent.setClass(context, WatchVideoActivity.class);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo27411a() {
        return false;
    }

    public void initCountDownTimer(long j) {
        this.f17750f = new CountDownTimer(j) {
            public final void onFinish() {
                if (WatchVideoActivity.this.f17768x == 1) {
                    WatchVideoActivity.this.m22440c(8);
                }
            }

            public final void onTick(long j) {
            }
        };
    }

    public void onBackPressed() {
        m22453k();
        super.onBackPressed();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C5961R.C5963id.ysf_iv_watch_video_finish) {
            finish();
        } else if (id == C5961R.C5963id.control_download_btn) {
            if (this.f17769y) {
                m22453k();
            } else {
                m22449i();
            }
            this.f17770z.setImageResource(this.f17769y ? C5961R.C5962drawable.ysf_icon_download_pause : C5961R.C5962drawable.ysf_icon_download_resume);
        } else {
            if (id == C5961R.C5963id.ysf_iv_video_progress_btn) {
                int i = this.f17768x;
                if (i == 3) {
                    m22447h();
                } else if (i == 1) {
                    this.f17760p.setVisibility(0);
                    this.f17747c.setBackgroundResource(C5961R.C5962drawable.ysf_ic_video_start_btn_back);
                    MediaPlayer mediaPlayer = this.f17755k;
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        this.f17755k.pause();
                        this.f17756l.removeCallbacks(this.f17743B);
                        this.f17768x = 3;
                    }
                } else if (i == 2) {
                    m22431a(false);
                }
            } else if (id == C5961R.C5963id.videoView) {
                int i2 = this.f17768x;
                if (i2 == 3) {
                    m22447h();
                } else if (i2 == 1) {
                    if (this.f17749e.getVisibility() == 8) {
                        m22440c(0);
                    } else {
                        m22440c(8);
                    }
                } else if (i2 == 2) {
                    m22431a(true);
                }
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m22446g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5961R.C5964layout.ysf_watch_video_activity);
        getWindow().setFlags(1024, 1024);
        this.f17757m = (IMMessage) getIntent().getSerializableExtra("EXTRA_DATA");
        setTitle((CharSequence) String.format("视频发送于%s", new Object[]{new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(this.f17757m.getTime()))}));
        this.f17765u = getIntent().getBooleanExtra("EXTRA_MENU", true);
        this.f17761q = findViewById(C5961R.C5963id.layoutDownload);
        this.f17762r = findViewById(C5961R.C5963id.downloadProgressBackground);
        this.f17763s = findViewById(C5961R.C5963id.downloadProgressForeground);
        this.f17764t = (TextView) findViewById(C5961R.C5963id.downloadProgressText);
        this.f17760p = findViewById(C5961R.C5963id.videoIcon);
        this.f17749e = (ImageView) findViewById(C5961R.C5963id.ysf_iv_watch_video_finish);
        this.f17749e.setOnClickListener(this);
        this.f17758n = (SurfaceView) findViewById(C5961R.C5963id.videoView);
        this.f17759o = this.f17758n.getHolder();
        this.f17759o.setType(3);
        this.f17759o.addCallback(new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (!WatchVideoActivity.this.f17766v) {
                    WatchVideoActivity.this.f17766v = true;
                    WatchVideoActivity.this.m22451j();
                }
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                WatchVideoActivity.this.f17766v = false;
            }
        });
        this.f17752h = (TextView) findViewById(C5961R.C5963id.lblVideoFileInfo);
        this.f17770z = (ImageView) findViewById(C5961R.C5963id.control_download_btn);
        this.f17770z.setOnClickListener(this);
        this.f17746b = (ProgressBar) findViewById(C5961R.C5963id.ysf_pb_video_progress_bar);
        this.f17746b.setMax((int) C5414f.m22157a(((VideoAttachment) this.f17757m.getAttachment()).getDuration()));
        this.f17747c = (ImageView) findViewById(C5961R.C5963id.ysf_iv_video_progress_btn);
        this.f17748d = (TextView) findViewById(C5961R.C5963id.ysf_tv_video_progress_second);
        long duration = ((VideoAttachment) this.f17757m.getAttachment()).getDuration();
        long size = ((VideoAttachment) this.f17757m.getAttachment()).getSize();
        String str = "大小: ";
        if (duration <= 0) {
            TextView textView = this.f17752h;
            StringBuilder sb = new StringBuilder(str);
            sb.append(C5363b.m22022a(size));
            textView.setText(sb.toString());
        } else {
            long a = C5414f.m22157a(duration);
            TextView textView2 = this.f17752h;
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(C5363b.m22022a(size));
            sb2.append(",时长: ");
            sb2.append(String.valueOf(a));
            sb2.append(" 秒");
            textView2.setText(sb2.toString());
            this.f17754j = a;
            long j = this.f17754j;
            if (j == 0) {
                this.f17751g = 0;
            } else {
                this.f17751g = (100 / j) * 100;
            }
        }
        m22437b(true);
        m22449i();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m22437b(false);
        CountDownTimer countDownTimer = this.f17750f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f17750f = null;
        }
    }

    public void onPause() {
        super.onPause();
        MediaPlayer mediaPlayer = this.f17755k;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f17755k.stop();
            }
            this.f17755k.reset();
            this.f17755k.release();
            this.f17755k = null;
        }
    }

    public void onResume() {
        super.onResume();
        this.f17755k = new MediaPlayer();
        if (this.f17766v) {
            m22451j();
        }
    }
}
