package com.qiyukf.basesdk.p393a;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.Calendar;

/* renamed from: com.qiyukf.basesdk.a.c */
public final class C5268c {
    /* renamed from: a */
    private String f17060a;
    /* renamed from: b */
    private String f17061b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f17062c;
    /* renamed from: d */
    private Handler f17063d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public Calendar f17064e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public MappedByteBuffer f17065f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public long f17066g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public long f17067h;

    /* renamed from: com.qiyukf.basesdk.a.c$a */
    private static abstract class C5271a implements Runnable {
        private C5271a() {
        }

        /* synthetic */ C5271a(byte b) {
            this();
        }

        /* renamed from: a */
        public abstract void mo27112a();

        public final void run() {
            try {
                mo27112a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public C5268c(String str, String str2, final boolean z) {
        mo27109a(str);
        this.f17061b = str2;
        this.f17062c = z;
        HandlerThread handlerThread = new HandlerThread("Log-Writer");
        handlerThread.start();
        this.f17063d = new Handler(handlerThread.getLooper());
        this.f17063d.post(new C5271a() {
            /* renamed from: a */
            public final void mo27112a() {
                if (z) {
                    C5265b.m21635a(C5268c.this.m21652c());
                    C5265b.m21638b(C5268c.this.m21652c());
                }
                C5268c.this.f17064e = C5265b.m21630a();
                C5268c cVar = C5268c.this;
                File file = new File(cVar.m21645a(cVar.f17064e));
                if (!file.exists()) {
                    C5268c.m21653c(C5268c.this);
                    return;
                }
                C5268c.this.f17066g = C5265b.m21627a(file);
                C5268c.this.f17067h = (long) ((int) file.length());
                C5268c cVar2 = C5268c.this;
                cVar2.f17065f = C5265b.m21629a(file, cVar2.f17066g, C5268c.this.f17067h - C5268c.this.f17066g);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m21645a(Calendar calendar) {
        m21655d();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17060a);
        sb.append(m21646a(false));
        sb.append(C5265b.f17055a.format(calendar.getTime()));
        return sb.toString();
    }

    /* renamed from: a */
    private String m21646a(boolean z) {
        return z ? this.f17061b : this.f17062c ? "tmp_c_" : "tmp_u_";
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m21652c() {
        m21655d();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17060a);
        sb.append(m21646a(true));
        return sb.toString();
    }

    /* renamed from: c */
    static /* synthetic */ void m21653c(C5268c cVar) {
        MappedByteBuffer mappedByteBuffer = cVar.f17065f;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
            cVar.f17065f = null;
        }
        File file = new File(cVar.m21645a(cVar.f17064e));
        cVar.f17066g = 0;
        cVar.f17067h = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        cVar.f17065f = C5265b.m21629a(file, 0, cVar.f17067h);
    }

    /* renamed from: d */
    private void m21655d() {
        File file = new File(this.f17060a);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* renamed from: h */
    static /* synthetic */ boolean m21659h(C5268c cVar) {
        MappedByteBuffer mappedByteBuffer = cVar.f17065f;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
            cVar.f17065f = null;
        }
        File file = new File(cVar.m21645a(cVar.f17064e));
        cVar.f17067h += PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        long j = cVar.f17066g;
        cVar.f17065f = C5265b.m21629a(file, j, cVar.f17067h - j);
        return cVar.f17065f != null;
    }

    /* renamed from: a */
    public final String mo27108a() {
        return this.f17060a;
    }

    /* renamed from: a */
    public final void mo27109a(String str) {
        String str2 = "/";
        if (!str.endsWith(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            str = sb.toString();
        }
        this.f17060a = str;
    }

    /* renamed from: a */
    public final void mo27110a(String str, long j, String str2, Throwable th) {
        Handler handler = this.f17063d;
        final String str3 = str;
        final long j2 = j;
        final String str4 = str2;
        final Throwable th2 = th;
        C52702 r1 = new C5271a() {
            /* renamed from: a */
            public final void mo27112a() {
                if (C5268c.this.f17065f != null) {
                    String a = C5265b.m21628a(str3, j2, str4, th2);
                    if (!TextUtils.isEmpty(a)) {
                        if (System.currentTimeMillis() - C5268c.this.f17064e.getTimeInMillis() >= 86400000) {
                            if (C5268c.this.f17062c) {
                                C5265b.m21638b(C5268c.this.m21652c());
                            }
                            C5268c.this.f17064e = C5265b.m21630a();
                            C5268c.m21653c(C5268c.this);
                        }
                        C5268c cVar = C5268c.this;
                        if (!new File(cVar.m21645a(cVar.f17064e)).exists()) {
                            C5268c.m21653c(C5268c.this);
                        }
                        byte[] bytes = a.getBytes();
                        if (C5268c.this.f17066g + ((long) bytes.length) <= C5268c.this.f17067h || C5268c.m21659h(C5268c.this)) {
                            C5268c.this.f17065f.put(bytes);
                            C5268c cVar2 = C5268c.this;
                            cVar2.f17066g = cVar2.f17066g + ((long) bytes.length);
                        }
                    }
                }
            }
        };
        handler.post(r1);
    }

    /* renamed from: b */
    public final String mo27111b() {
        try {
            C5265b.m21640c(m21652c());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m21652c();
    }
}
