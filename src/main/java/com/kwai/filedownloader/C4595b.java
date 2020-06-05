package com.kwai.filedownloader;

import android.os.SystemClock;
import com.kwai.filedownloader.C4725r.C4726a;
import com.kwai.filedownloader.C4725r.C4727b;

/* renamed from: com.kwai.filedownloader.b */
public class C4595b implements C4726a, C4727b {
    /* renamed from: a */
    private long f14962a;
    /* renamed from: b */
    private long f14963b;
    /* renamed from: c */
    private long f14964c;
    /* renamed from: d */
    private long f14965d;
    /* renamed from: e */
    private int f14966e;
    /* renamed from: f */
    private int f14967f = 1000;

    /* renamed from: a */
    public void mo24955a() {
        this.f14966e = 0;
        this.f14962a = 0;
    }

    /* renamed from: a */
    public void mo24956a(long j) {
        this.f14965d = SystemClock.uptimeMillis();
        this.f14964c = j;
    }

    /* renamed from: b */
    public int mo24957b() {
        return this.f14966e;
    }

    /* renamed from: b */
    public void mo24958b(long j) {
        if (this.f14965d > 0) {
            long j2 = j - this.f14964c;
            this.f14962a = 0;
            long uptimeMillis = SystemClock.uptimeMillis() - this.f14965d;
            if (uptimeMillis > 0) {
                j2 /= uptimeMillis;
            }
            this.f14966e = (int) j2;
        }
    }

    /* renamed from: c */
    public void mo24959c(long j) {
        if (this.f14967f > 0) {
            boolean z = true;
            if (this.f14962a != 0) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f14962a;
                if (uptimeMillis >= ((long) this.f14967f) || (this.f14966e == 0 && uptimeMillis > 0)) {
                    this.f14966e = (int) ((j - this.f14963b) / uptimeMillis);
                    this.f14966e = Math.max(0, this.f14966e);
                } else {
                    z = false;
                }
            }
            if (z) {
                this.f14963b = j;
                this.f14962a = SystemClock.uptimeMillis();
            }
        }
    }
}
