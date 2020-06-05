package com.bytedance.sdk.openadsdk.core.video.p177c;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.video.p175a.VideoAdModel;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2304a;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2305b;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2306c;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2307d;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2308e;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2309f;
import com.bytedance.sdk.openadsdk.core.video.p177c.IMediaPlayer.C2310g;
import com.bytedance.sdk.openadsdk.utils.C2538ak;
import com.bytedance.sdk.openadsdk.utils.C2538ak.C2539a;
import com.bytedance.sdk.openadsdk.utils.C2564t;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.bytedance.sdk.openadsdk.core.video.c.d */
public class SSMediaPlayerWrapper implements C2304a, C2305b, C2306c, C2307d, C2308e, C2309f, C2310g, C2539a {
    /* renamed from: m */
    private static boolean f7993m = false;
    /* renamed from: o */
    private static final SparseIntArray f7994o = new SparseIntArray();
    /* access modifiers changed from: private */
    /* renamed from: a */
    public IMediaPlayer f7995a;
    /* renamed from: b */
    private boolean f7996b;
    /* renamed from: c */
    private boolean f7997c;
    /* renamed from: d */
    private boolean f7998d;
    /* renamed from: e */
    private boolean f7999e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f8000f;
    /* renamed from: g */
    private long f8001g;
    /* access modifiers changed from: private|final */
    /* renamed from: h */
    public final Handler f8002h;
    /* renamed from: i */
    private Handler f8003i;
    /* renamed from: j */
    private ArrayList<Runnable> f8004j;
    /* renamed from: k */
    private int f8005k;
    /* renamed from: l */
    private int f8006l;
    /* renamed from: n */
    private String f8007n;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean f8008p;
    /* renamed from: q */
    private final Object f8009q;
    /* renamed from: r */
    private StringBuilder f8010r;
    /* renamed from: s */
    private boolean f8011s;
    /* renamed from: t */
    private long f8012t;
    /* renamed from: u */
    private long f8013u;
    /* renamed from: v */
    private long f8014v;
    /* renamed from: w */
    private long f8015w;
    /* renamed from: x */
    private boolean f8016x;

    public SSMediaPlayerWrapper(Handler handler) {
        this(handler, -1);
    }

    public SSMediaPlayerWrapper(Handler handler, int i) {
        this.f7995a = null;
        boolean z = false;
        this.f7996b = false;
        this.f7997c = false;
        this.f8000f = 201;
        this.f8001g = -1;
        this.f8005k = 0;
        this.f8007n = "0";
        this.f8009q = new Object();
        this.f8010r = null;
        this.f8011s = false;
        this.f8012t = 0;
        this.f8013u = 0;
        this.f8014v = 0;
        this.f8015w = 0;
        this.f8016x = false;
        this.f8005k = 0;
        this.f8003i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f8002h = new C2538ak(handlerThread.getLooper(), this);
        if (VERSION.SDK_INT >= 17) {
            z = true;
        }
        this.f8016x = z;
        m10362q();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m10362q() {
        if (this.f7995a == null) {
            String str = "SSMediaPlayeWrapper";
            C2564t.m12220b(str, "SSMediaPlayerWrapper use System Mediaplayer");
            this.f7995a = new AndroidMediaPlayer();
            this.f8007n = "0";
            this.f7995a.mo16015a((C2308e) this);
            this.f7995a.mo16012a((C2305b) this);
            this.f7995a.mo16013a((C2306c) this);
            this.f7995a.mo16011a((C2304a) this);
            this.f7995a.mo16016a((C2309f) this);
            this.f7995a.mo16014a((C2307d) this);
            this.f7995a.mo16017a((C2310g) this);
            try {
                this.f7995a.mo16031b(this.f7996b);
            } catch (Throwable th) {
                C2564t.m12216a(str, "setLooping error: ", th);
            }
            this.f7997c = false;
        }
    }

    /* renamed from: a */
    public MediaPlayer mo16055a() throws Throwable {
        IMediaPlayer cVar = this.f7995a;
        if (cVar != null) {
            return ((AndroidMediaPlayer) cVar).mo16032e();
        }
        return null;
    }

    /* renamed from: a */
    public void mo16061a(boolean z, long j, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[video] MediaPlayerProxy#start firstSeekToPosition=");
        sb.append(j);
        sb.append(",firstPlay :");
        sb.append(z);
        sb.append(",isPauseOtherMusicVolume=");
        sb.append(z2);
        String str = "tag_video_play";
        C2564t.m12220b(str, sb.toString());
        this.f8008p = false;
        if (!z2) {
            if (this.f7995a != null) {
                mo16060a(true);
            }
        } else if (this.f7995a != null) {
            mo16060a(false);
        }
        if (z) {
            m10363r();
            this.f8001g = j;
            return;
        }
        m10347C();
        IMediaPlayer cVar = this.f7995a;
        if (cVar != null) {
            try {
                if (j <= cVar.mo16037i()) {
                    j = this.f7995a.mo16037i();
                }
                this.f8001g = j;
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[video] MediaPlayerProxy#start  error: getCurrentPosition :");
                sb2.append(th.toString());
                C2564t.m12220b(str, sb2.toString());
            }
        }
        m10359b((Runnable) new Runnable() {
            public void run() {
                SSMediaPlayerWrapper.this.f8002h.sendEmptyMessageDelayed(100, 0);
                C2564t.m12220b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
            }
        });
    }

    /* renamed from: b */
    public void mo16062b() {
        this.f8002h.removeMessages(100);
        this.f8008p = true;
        this.f8002h.sendEmptyMessage(101);
        m10348D();
    }

    /* renamed from: c */
    public void mo16063c() {
        this.f8000f = 203;
        m10348D();
        m10371z();
        if (this.f8002h != null) {
            try {
                m10360b("release");
                this.f8002h.removeCallbacksAndMessages(null);
                if (this.f7995a != null) {
                    this.f7999e = true;
                    this.f8002h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                m10365t();
                C2564t.m12216a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    /* renamed from: r */
    private void m10363r() {
        C2564t.m12220b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        m10359b((Runnable) new Runnable() {
            public void run() {
                if (SSMediaPlayerWrapper.this.f8002h != null) {
                    SSMediaPlayerWrapper.this.f8002h.sendEmptyMessage(104);
                    C2564t.m12220b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    /* renamed from: d */
    public void mo16064d() {
        m10359b((Runnable) new Runnable() {
            public void run() {
                if (SSMediaPlayerWrapper.this.f8002h != null) {
                    SSMediaPlayerWrapper.this.f8002h.sendEmptyMessage(105);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo16056a(final long j) {
        m10348D();
        int i = this.f8000f;
        if (i == 207 || i == 206 || i == 209) {
            m10359b((Runnable) new Runnable() {
                public void run() {
                    if (SSMediaPlayerWrapper.this.f8002h != null) {
                        SSMediaPlayerWrapper.this.f8002h.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo16057a(final SurfaceTexture surfaceTexture) {
        m10359b((Runnable) new Runnable() {
            public void run() {
                SSMediaPlayerWrapper.this.m10362q();
                if (SSMediaPlayerWrapper.this.f8002h != null) {
                    SSMediaPlayerWrapper.this.f8002h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    /* renamed from: a */
    public void mo16058a(final SurfaceHolder surfaceHolder) {
        m10359b((Runnable) new Runnable() {
            public void run() {
                SSMediaPlayerWrapper.this.m10362q();
                if (SSMediaPlayerWrapper.this.f8002h != null) {
                    SSMediaPlayerWrapper.this.f8002h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    /* renamed from: e */
    public void mo16065e() {
        Handler handler = this.f8002h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    /* renamed from: f */
    public void mo16066f() {
        Handler handler = this.f8002h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    /* renamed from: a */
    public void mo16059a(final VideoAdModel aVar) {
        m10359b((Runnable) new Runnable() {
            public void run() {
                SSMediaPlayerWrapper.this.m10362q();
                if (SSMediaPlayerWrapper.this.f8002h != null) {
                    SSMediaPlayerWrapper.this.f8002h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    /* renamed from: g */
    public boolean mo16067g() {
        return (this.f8000f == 206 || this.f8002h.hasMessages(100)) && !this.f8008p;
    }

    /* renamed from: h */
    public boolean mo16068h() {
        return mo16071k() || mo16067g() || mo16069i();
    }

    /* renamed from: i */
    public boolean mo16069i() {
        return (this.f8000f == 207 || this.f8008p) && !this.f8002h.hasMessages(100);
    }

    /* renamed from: j */
    public boolean mo16070j() {
        return this.f8000f == 203;
    }

    /* renamed from: k */
    public boolean mo16071k() {
        return this.f8000f == 205;
    }

    /* renamed from: l */
    public boolean mo16072l() {
        return this.f8000f == 209;
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183 A[Catch:{ all -> 0x0194 }] */
    /* renamed from: a */
    public void mo14813a(android.os.Message r17) {
        /*
        r16 = this;
        r1 = r16
        r0 = r17
        int r2 = r0.what
        java.lang.String r3 = "tag_video_play"
        java.lang.String r4 = "[video]  execute , mCurrentState = "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r4)
        com.bytedance.sdk.openadsdk.core.video.c.c r4 = r1.f7995a
        r6 = 1
        if (r4 == 0) goto L_0x02a9
        int r4 = r0.what
        r7 = 201(0xc9, float:2.82E-43)
        if (r4 == r7) goto L_0x02a9
        r8 = 203(0xcb, float:2.84E-43)
        r9 = 202(0xca, float:2.83E-43)
        java.lang.String r11 = "NativeVideoController"
        r13 = 209(0xd1, float:2.93E-43)
        r14 = 0
        r5 = 207(0xcf, float:2.9E-43)
        r12 = 206(0xce, float:2.89E-43)
        java.lang.String r10 = "SSMediaPlayeWrapper"
        switch(r4) {
            case 100: goto L_0x0265;
            case 101: goto L_0x0248;
            case 102: goto L_0x0233;
            case 103: goto L_0x0211;
            case 104: goto L_0x01de;
            case 105: goto L_0x01bb;
            case 106: goto L_0x019c;
            case 107: goto L_0x00c7;
            case 108: goto L_0x00a9;
            case 109: goto L_0x0086;
            case 110: goto L_0x005e;
            case 111: goto L_0x002d;
            default: goto L_0x002b;
        }
    L_0x002b:
        goto L_0x02a9
    L_0x002d:
        int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0056 }
        r4 = 14
        if (r3 < r4) goto L_0x0041
        java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0056 }
        android.graphics.SurfaceTexture r0 = (android.graphics.SurfaceTexture) r0     // Catch:{ all -> 0x0056 }
        com.bytedance.sdk.openadsdk.core.video.c.c r3 = r1.f7995a     // Catch:{ all -> 0x0056 }
        android.view.Surface r4 = new android.view.Surface     // Catch:{ all -> 0x0056 }
        r4.<init>(r0)     // Catch:{ all -> 0x0056 }
        r3.mo16026a(r4)     // Catch:{ all -> 0x0056 }
    L_0x0041:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0056 }
        r0.mo16030a(r6)     // Catch:{ all -> 0x0056 }
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0056 }
        android.content.Context r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x0056 }
        r4 = 10
        r0.mo16025a(r3, r4)     // Catch:{ all -> 0x0056 }
        r16.m10369x()     // Catch:{ all -> 0x0056 }
        goto L_0x02a9
    L_0x0056:
        r0 = move-exception
        java.lang.String r3 = "OP_SET_SURFACE error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x005e:
        java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x007e }
        android.view.SurfaceHolder r0 = (android.view.SurfaceHolder) r0     // Catch:{ all -> 0x007e }
        com.bytedance.sdk.openadsdk.core.video.c.c r3 = r1.f7995a     // Catch:{ all -> 0x007e }
        r3.mo16027a(r0)     // Catch:{ all -> 0x007e }
        int r0 = r1.f8005k     // Catch:{ all -> 0x007e }
        r3 = 2
        if (r0 != r3) goto L_0x0077
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x007e }
        android.content.Context r3 = com.bytedance.sdk.openadsdk.core.InternalContainer.m10059a()     // Catch:{ all -> 0x007e }
        r4 = 10
        r0.mo16025a(r3, r4)     // Catch:{ all -> 0x007e }
    L_0x0077:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x007e }
        r0.mo16030a(r6)     // Catch:{ all -> 0x007e }
        goto L_0x02a9
    L_0x007e:
        r0 = move-exception
        java.lang.String r3 = "OP_SET_DISPLAY error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x0086:
        int r0 = r1.f8000f
        if (r0 == r12) goto L_0x008c
        if (r0 != r5) goto L_0x0099
    L_0x008c:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0093 }
        long r3 = r0.mo16037i()     // Catch:{ all -> 0x0093 }
        goto L_0x009a
    L_0x0093:
        r0 = move-exception
        java.lang.String r3 = "OP_REQUEST_CUR_POSITION error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
    L_0x0099:
        r3 = r14
    L_0x009a:
        int r0 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
        if (r0 <= 0) goto L_0x02a9
        r0 = 109(0x6d, float:1.53E-43)
        java.lang.Long r3 = java.lang.Long.valueOf(r3)
        r1.m10351a(r0, r3)
        goto L_0x02a9
    L_0x00a9:
        int r0 = r1.f8000f
        if (r0 == r12) goto L_0x00af
        if (r0 != r5) goto L_0x00bc
    L_0x00af:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x00b6 }
        long r14 = r0.mo16038j()     // Catch:{ all -> 0x00b6 }
        goto L_0x00bc
    L_0x00b6:
        r0 = move-exception
        java.lang.String r3 = "OP_REQUEST_DURATION error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
    L_0x00bc:
        r0 = 108(0x6c, float:1.51E-43)
        java.lang.Long r3 = java.lang.Long.valueOf(r14)
        r1.m10351a(r0, r3)
        goto L_0x02a9
    L_0x00c7:
        int r3 = r1.f8000f
        if (r3 == r7) goto L_0x00cd
        if (r3 != r8) goto L_0x01e7
    L_0x00cd:
        java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.core.video.a.a r0 = (com.bytedance.sdk.openadsdk.core.video.p175a.VideoAdModel) r0     // Catch:{ all -> 0x0194 }
        java.lang.String r3 = r0.f7928a     // Catch:{ all -> 0x0194 }
        java.lang.String r4 = "/"
        if (r3 == 0) goto L_0x00df
        boolean r5 = r3.startsWith(r4)     // Catch:{ all -> 0x0194 }
        if (r5 == 0) goto L_0x00df
        r5 = 1
        goto L_0x00e0
    L_0x00df:
        r5 = 0
    L_0x00e0:
        if (r3 == 0) goto L_0x00e8
        boolean r7 = r3.startsWith(r4)     // Catch:{ all -> 0x0194 }
        if (r7 != 0) goto L_0x00ec
    L_0x00e8:
        int r7 = r0.f7930c     // Catch:{ all -> 0x0194 }
        if (r7 != r6) goto L_0x0106
    L_0x00ec:
        boolean r0 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()     // Catch:{ all -> 0x0194 }
        if (r0 == 0) goto L_0x00ff
        if (r3 == 0) goto L_0x00ff
        boolean r0 = r3.startsWith(r4)     // Catch:{ all -> 0x0194 }
        if (r0 == 0) goto L_0x00ff
        r1.m10354a(r3)     // Catch:{ all -> 0x0194 }
        goto L_0x017d
    L_0x00ff:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0194 }
        r0.mo16029a(r3)     // Catch:{ all -> 0x0194 }
        goto L_0x017d
    L_0x0106:
        com.bytedance.sdk.openadsdk.h.f.b r3 = new com.bytedance.sdk.openadsdk.h.f.b     // Catch:{ all -> 0x0194 }
        r3.m44098init()     // Catch:{ all -> 0x0194 }
        java.lang.String r4 = r0.f7928a     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.h.f.b r3 = r3.mo16772a(r4)     // Catch:{ all -> 0x0194 }
        java.lang.String r0 = r0.f7931d     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.h.f.b r0 = r3.mo16773b(r0)     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.h.f.a r3 = com.bytedance.sdk.openadsdk.p190h.p196f.VideoCachePreloader.m11598a()     // Catch:{ all -> 0x0194 }
        java.lang.String r0 = r3.mo16767b(r0)     // Catch:{ all -> 0x0194 }
        java.lang.String r3 = "cache009"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
        r4.<init>()     // Catch:{ all -> 0x0194 }
        java.lang.String r5 = "使用Video缓存-OP_SET_DATASOURCE-proxyurl="
        r4.append(r5)     // Catch:{ all -> 0x0194 }
        r4.append(r0)     // Catch:{ all -> 0x0194 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r3, r4)     // Catch:{ all -> 0x0194 }
        if (r0 == 0) goto L_0x0141
        java.lang.String r3 = "file"
        boolean r3 = r0.startsWith(r3)     // Catch:{ all -> 0x0194 }
        if (r3 == 0) goto L_0x0141
        r5 = 1
        goto L_0x0142
    L_0x0141:
        r5 = 0
    L_0x0142:
        if (r0 == 0) goto L_0x0178
        boolean r3 = com.bytedance.sdk.openadsdk.multipro.MultiGlobalInfo.m11808b()     // Catch:{ all -> 0x0194 }
        if (r3 == 0) goto L_0x0178
        java.lang.String r3 = "file"
        boolean r3 = r0.startsWith(r3)     // Catch:{ all -> 0x0194 }
        if (r3 == 0) goto L_0x0178
        android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0194 }
        java.lang.String r3 = "cache010"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0194 }
        r4.<init>()     // Catch:{ all -> 0x0194 }
        java.lang.String r7 = "使用uri parse ="
        r4.append(r7)     // Catch:{ all -> 0x0194 }
        java.lang.String r7 = r0.getPath()     // Catch:{ all -> 0x0194 }
        r4.append(r7)     // Catch:{ all -> 0x0194 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0194 }
        com.bytedance.sdk.openadsdk.utils.C2564t.m12226e(r3, r4)     // Catch:{ all -> 0x0194 }
        java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0194 }
        r1.m10354a(r0)     // Catch:{ all -> 0x0194 }
        goto L_0x017d
    L_0x0178:
        com.bytedance.sdk.openadsdk.core.video.c.c r3 = r1.f7995a     // Catch:{ all -> 0x0194 }
        r3.mo16029a(r0)     // Catch:{ all -> 0x0194 }
    L_0x017d:
        r1.f8000f = r9     // Catch:{ all -> 0x0194 }
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x0194 }
        if (r0 == 0) goto L_0x02a9
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x0194 }
        r3 = 314(0x13a, float:4.4E-43)
        java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0194 }
        android.os.Message r0 = r0.obtainMessage(r3, r4)     // Catch:{ all -> 0x0194 }
        r0.sendToTarget()     // Catch:{ all -> 0x0194 }
        goto L_0x02a9
    L_0x0194:
        r0 = move-exception
        java.lang.String r3 = "OP_SET_DATASOURCE error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x019c:
        int r3 = r1.f8000f
        if (r3 == r12) goto L_0x01a4
        if (r3 == r5) goto L_0x01a4
        if (r3 != r13) goto L_0x01e7
    L_0x01a4:
        com.bytedance.sdk.openadsdk.core.video.c.c r3 = r1.f7995a     // Catch:{ all -> 0x01b3 }
        java.lang.Object r0 = r0.obj     // Catch:{ all -> 0x01b3 }
        java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x01b3 }
        long r4 = r0.longValue()     // Catch:{ all -> 0x01b3 }
        r3.mo16024a(r4)     // Catch:{ all -> 0x01b3 }
        goto L_0x02a9
    L_0x01b3:
        r0 = move-exception
        java.lang.String r3 = "OP_SEEKTO error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x01bb:
        int r0 = r1.f8000f
        r3 = 205(0xcd, float:2.87E-43)
        if (r0 == r3) goto L_0x01cb
        if (r0 == r12) goto L_0x01cb
        r3 = 208(0xd0, float:2.91E-43)
        if (r0 == r3) goto L_0x01cb
        if (r0 == r5) goto L_0x01cb
        if (r0 != r13) goto L_0x01e7
    L_0x01cb:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x01d6 }
        r0.mo16035g()     // Catch:{ all -> 0x01d6 }
        r0 = 208(0xd0, float:2.91E-43)
        r1.f8000f = r0     // Catch:{ all -> 0x01d6 }
        goto L_0x02a9
    L_0x01d6:
        r0 = move-exception
        java.lang.String r3 = "OP_STOP error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x01de:
        int r0 = r1.f8000f
        if (r0 == r9) goto L_0x01ea
        r4 = 208(0xd0, float:2.91E-43)
        if (r0 != r4) goto L_0x01e7
        goto L_0x01ea
    L_0x01e7:
        r4 = 1
        goto L_0x02aa
    L_0x01ea:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0209 }
        com.bytedance.sdk.openadsdk.core.video.c.b r0 = (com.bytedance.sdk.openadsdk.core.video.p177c.AndroidMediaPlayer) r0     // Catch:{ all -> 0x0209 }
        android.media.MediaPlayer r0 = r0.mo16032e()     // Catch:{ all -> 0x0209 }
        r0.prepareAsync()     // Catch:{ all -> 0x0209 }
        java.lang.String r0 = "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)     // Catch:{ all -> 0x0209 }
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x0209 }
        if (r0 == 0) goto L_0x02a9
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x0209 }
        r3 = 312(0x138, float:4.37E-43)
        r4 = 10000(0x2710, double:4.9407E-320)
        r0.sendEmptyMessageDelayed(r3, r4)     // Catch:{ all -> 0x0209 }
        goto L_0x02a9
    L_0x0209:
        r0 = move-exception
        java.lang.String r3 = "OP_PREPARE_ASYNC error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r11, r3, r0)
        goto L_0x02a9
    L_0x0211:
        r16.m10364s()     // Catch:{ all -> 0x021a }
        java.lang.String r0 = "[video] OP_RELEASE execute , releaseMediaplayer !"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)     // Catch:{ all -> 0x021a }
        goto L_0x0220
    L_0x021a:
        r0 = move-exception
        java.lang.String r3 = "OP_RELEASE error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12223c(r11, r3, r0)
    L_0x0220:
        r3 = 0
        r1.f7999e = r3
        r0 = 309(0x135, float:4.33E-43)
        r3 = 0
        r1.m10351a(r0, r3)
        r1.f8000f = r8
        r0 = 0
        r1.f7995a = r0
        r16.m10370y()
        goto L_0x02a9
    L_0x0233:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x0241 }
        r0.mo16040l()     // Catch:{ all -> 0x0241 }
        java.lang.String r0 = "[video] OP_RELEASE execute , releaseMediaplayer !"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)     // Catch:{ all -> 0x0241 }
        r1.f8000f = r7     // Catch:{ all -> 0x0241 }
        goto L_0x02a9
    L_0x0241:
        r0 = move-exception
        java.lang.String r3 = "OP_RESET error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r10, r3, r0)
        goto L_0x02a9
    L_0x0248:
        int r0 = r1.f8000f
        if (r0 == r12) goto L_0x0250
        if (r0 == r5) goto L_0x0250
        if (r0 != r13) goto L_0x01e7
    L_0x0250:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x025d }
        r0.mo16036h()     // Catch:{ all -> 0x025d }
        r1.f8000f = r5     // Catch:{ all -> 0x025d }
        r4 = 0
        r1.f8008p = r4     // Catch:{ all -> 0x025b }
        goto L_0x02aa
    L_0x025b:
        r0 = move-exception
        goto L_0x025f
    L_0x025d:
        r0 = move-exception
        r4 = 0
    L_0x025f:
        java.lang.String r3 = "OP_PAUSE error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r11, r3, r0)
        goto L_0x02aa
    L_0x0265:
        r4 = 0
        int r0 = r1.f8000f
        r7 = 205(0xcd, float:2.87E-43)
        if (r0 == r7) goto L_0x0272
        if (r0 == r12) goto L_0x0272
        if (r0 == r5) goto L_0x0272
        if (r0 != r13) goto L_0x01e7
    L_0x0272:
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x02a2 }
        r0.mo16033f()     // Catch:{ all -> 0x02a2 }
        java.lang.String r0 = "[video] OP_START execute , mMediaPlayer real start !"
        com.bytedance.sdk.openadsdk.utils.C2564t.m12220b(r3, r0)     // Catch:{ all -> 0x02a2 }
        r1.f8000f = r12     // Catch:{ all -> 0x02a2 }
        long r7 = r1.f8001g     // Catch:{ all -> 0x02a2 }
        int r0 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
        if (r0 < 0) goto L_0x028f
        com.bytedance.sdk.openadsdk.core.video.c.c r0 = r1.f7995a     // Catch:{ all -> 0x02a2 }
        long r7 = r1.f8001g     // Catch:{ all -> 0x02a2 }
        r0.mo16024a(r7)     // Catch:{ all -> 0x02a2 }
        r7 = -1
        r1.f8001g = r7     // Catch:{ all -> 0x02a2 }
    L_0x028f:
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x02a2 }
        if (r0 == 0) goto L_0x02aa
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x02a2 }
        r5 = 312(0x138, float:4.37E-43)
        r0.removeMessages(r5)     // Catch:{ all -> 0x02a2 }
        android.os.Handler r0 = r1.f8003i     // Catch:{ all -> 0x02a2 }
        r5 = 313(0x139, float:4.39E-43)
        r0.sendEmptyMessage(r5)     // Catch:{ all -> 0x02a2 }
        goto L_0x02aa
    L_0x02a2:
        r0 = move-exception
        java.lang.String r5 = "OP_START error: "
        com.bytedance.sdk.openadsdk.utils.C2564t.m12216a(r3, r5, r0)
        goto L_0x02aa
    L_0x02a9:
        r4 = 0
    L_0x02aa:
        if (r4 == 0) goto L_0x02bf
        r0 = 200(0xc8, float:2.8E-43)
        r1.f8000f = r0
        boolean r0 = r1.f7997c
        if (r0 != 0) goto L_0x02bf
        r0 = 308(0x134, float:4.32E-43)
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        r1.m10351a(r0, r2)
        r1.f7997c = r6
    L_0x02bf:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.p177c.SSMediaPlayerWrapper.mo14813a(android.os.Message):void");
    }

    /* renamed from: a */
    private void m10354a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f7995a.mo16028a(fileInputStream.getFD());
        fileInputStream.close();
    }

    /* renamed from: s */
    private void m10364s() {
        String str = "SSMediaPlayeWrapper";
        IMediaPlayer cVar = this.f7995a;
        if (cVar != null) {
            try {
                cVar.mo16040l();
            } catch (Throwable th) {
                C2564t.m12216a(str, "releaseMediaplayer error1: ", th);
            }
            this.f7995a.mo16012a((C2305b) null);
            this.f7995a.mo16017a((C2310g) null);
            this.f7995a.mo16011a((C2304a) null);
            this.f7995a.mo16014a((C2307d) null);
            this.f7995a.mo16013a((C2306c) null);
            this.f7995a.mo16015a((C2308e) null);
            this.f7995a.mo16016a((C2309f) null);
            try {
                this.f7995a.mo16039k();
            } catch (Throwable th2) {
                C2564t.m12216a(str, "releaseMediaplayer error2: ", th2);
            }
        }
    }

    /* renamed from: t */
    private void m10365t() {
        String str = "SSMediaPlayeWrapper";
        Handler handler = this.f8002h;
        if (handler != null && handler.getLooper() != null) {
            try {
                C2564t.m12220b(str, "onDestory............");
                this.f8002h.getLooper().quit();
            } catch (Throwable th) {
                C2564t.m12216a(str, "onDestroy error: ", th);
            }
        }
    }

    /* renamed from: a */
    private void m10351a(int i, Object obj) {
        if (i == 309) {
            m10346B();
        }
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.obtainMessage(i, obj).sendToTarget();
        }
    }

    /* renamed from: a */
    public void mo16048a(IMediaPlayer cVar, int i) {
        if (this.f7995a == cVar) {
            Handler handler = this.f8003i;
            if (handler != null) {
                handler.obtainMessage(301, Integer.valueOf(i)).sendToTarget();
            }
        }
    }

    /* renamed from: u */
    private void m10366u() {
        Integer valueOf = Integer.valueOf(f7994o.get(this.f8005k));
        if (valueOf == null) {
            f7994o.put(this.f8005k, 1);
        } else {
            f7994o.put(this.f8005k, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    /* renamed from: a */
    public void mo16049a(IMediaPlayer cVar) {
        this.f8000f = !this.f7996b ? TinkerReport.KEY_APPLIED_FAIL_COST_OTHER : 206;
        f7994o.delete(this.f8005k);
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        m10360b("completion");
        m10348D();
    }

    /* renamed from: a */
    public boolean mo16050a(IMediaPlayer cVar, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("what=");
        sb.append(i);
        sb.append("extra=");
        sb.append(i2);
        C2564t.m12226e("SSMediaPlayeWrapper", sb.toString());
        m10366u();
        this.f8000f = 200;
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.obtainMessage(303, i, i2).sendToTarget();
        }
        Handler handler2 = this.f8002h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.f8002h.removeMessages(109);
        }
        if (!this.f7997c) {
            m10351a((int) TinkerReport.KEY_LOADED_MISSING_RES, (Object) Integer.valueOf(i));
            this.f7997c = true;
        }
        if (m10355a(i, i2)) {
            m10365t();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10355a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("OnError - Error code: ");
        sb.append(i);
        sb.append(" Extra code: ");
        sb.append(i2);
        C2564t.m12220b("SSMediaPlayeWrapper", sb.toString());
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo16051b(IMediaPlayer cVar, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("what,extra:");
        sb.append(i);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(i2);
        C2564t.m12226e("SSMediaPlayeWrapper", sb.toString());
        if (this.f7995a != cVar) {
            return false;
        }
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.obtainMessage(304, i, i2).sendToTarget();
            if (i2 == -1004) {
                this.f8003i.obtainMessage(303, i, i2).sendToTarget();
            }
        }
        m10357b(i, i2);
        return false;
    }

    /* renamed from: b */
    private void m10357b(int i, int i2) {
        if (i == 701) {
            m10348D();
            this.f8014v = SystemClock.elapsedRealtime();
        } else if (i == 702) {
            if (this.f8013u <= 0) {
                this.f8013u = System.currentTimeMillis();
            }
            if (this.f8014v > 0) {
                this.f8015w += SystemClock.elapsedRealtime() - this.f8014v;
                this.f8014v = 0;
            }
        } else if (this.f8016x && i == 3 && this.f8013u <= 0) {
            this.f8013u = System.currentTimeMillis();
        }
    }

    /* renamed from: b */
    public void mo16052b(IMediaPlayer cVar) {
        this.f8000f = 205;
        if (this.f8008p) {
            this.f8002h.post(new Runnable() {
                public void run() {
                    try {
                        SSMediaPlayerWrapper.this.f7995a.mo16036h();
                        SSMediaPlayerWrapper.this.f8000f = 207;
                        SSMediaPlayerWrapper.this.f8008p = false;
                    } catch (Throwable th) {
                        C2564t.m12216a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.f8002h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        f7994o.delete(this.f8005k);
        Handler handler2 = this.f8003i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        m10367v();
    }

    /* renamed from: v */
    private void m10367v() {
        if (!this.f8016x && this.f8013u <= 0) {
            this.f8013u = System.currentTimeMillis();
        }
    }

    /* renamed from: c */
    public void mo16053c(IMediaPlayer cVar) {
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.sendEmptyMessage(TinkerReport.KEY_LOADED_MISSING_PATCH_INFO);
        }
    }

    /* renamed from: a */
    private void m10353a(Runnable runnable) {
        if (this.f8004j == null) {
            this.f8004j = new ArrayList<>();
        }
        this.f8004j.add(runnable);
    }

    /* renamed from: w */
    private void m10368w() {
        if (!this.f7998d) {
            this.f7998d = true;
            Iterator it = new ArrayList(this.f8004j).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f8004j.clear();
            this.f7998d = false;
        }
    }

    /* renamed from: x */
    private void m10369x() {
        ArrayList<Runnable> arrayList = this.f8004j;
        if (arrayList != null && !arrayList.isEmpty()) {
            m10368w();
        }
    }

    /* renamed from: y */
    private void m10370y() {
        ArrayList<Runnable> arrayList = this.f8004j;
        if (arrayList == null || arrayList.isEmpty()) {
            m10365t();
        } else {
            m10368w();
        }
    }

    /* renamed from: z */
    private void m10371z() {
        ArrayList<Runnable> arrayList = this.f8004j;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f8004j.clear();
        }
    }

    /* renamed from: b */
    private void m10359b(Runnable runnable) {
        if (runnable != null) {
            if (!this.f7999e) {
                runnable.run();
            } else {
                m10353a(runnable);
            }
        }
    }

    /* renamed from: a */
    private void m10352a(int i, boolean z) {
        if (z) {
            int A = m10345A();
            if (A != i) {
                f7993m = true;
                this.f8006l = A;
            }
        }
        AudioManager audioManager = (AudioManager) InternalContainer.m10059a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    /* renamed from: A */
    private int m10345A() {
        AudioManager audioManager = (AudioManager) InternalContainer.m10059a().getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    /* renamed from: B */
    private void m10346B() {
        if (f7993m) {
            m10352a(this.f8006l, false);
            f7993m = false;
        }
    }

    /* renamed from: a */
    public void mo16060a(boolean z) {
        if (z) {
            try {
                this.f7995a.mo16023a(0.0f, 0.0f);
            } catch (Throwable th) {
                C2564t.m12216a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
            }
        } else {
            this.f7995a.mo16023a(1.0f, 1.0f);
        }
    }

    /* renamed from: b */
    private void m10360b(String str) {
        Handler handler = this.f8002h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.f8009q) {
            if (this.f8010r != null) {
                this.f8010r = null;
            }
        }
    }

    /* renamed from: C */
    private void m10347C() {
        if (this.f8013u <= 0) {
            this.f8013u = System.currentTimeMillis();
        }
    }

    /* renamed from: m */
    public void mo16073m() {
        this.f8012t = 0;
        this.f8013u = System.currentTimeMillis();
    }

    /* renamed from: D */
    private void m10348D() {
        if (this.f8013u > 0) {
            this.f8012t += System.currentTimeMillis() - this.f8013u;
            this.f8013u = 0;
        }
    }

    /* renamed from: n */
    public long mo16074n() {
        return this.f8015w;
    }

    /* renamed from: o */
    public long mo16075o() {
        m10348D();
        return this.f8012t;
    }

    /* renamed from: p */
    public long mo16076p() {
        if (this.f8013u > 0) {
            this.f8012t += System.currentTimeMillis() - this.f8013u;
            this.f8013u = System.currentTimeMillis();
        }
        return this.f8012t;
    }

    /* renamed from: a */
    public void mo16054a(IMediaPlayer cVar, int i, int i2, int i3, int i4) {
        Handler handler = this.f8003i;
        if (handler != null) {
            handler.obtainMessage(311, i, i2).sendToTarget();
        }
    }
}
