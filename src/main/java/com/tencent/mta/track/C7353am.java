package com.tencent.mta.track;

import android.util.Log;

/* compiled from: ProGuard */
/* renamed from: com.tencent.mta.track.am */
class C7353am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C7350aj f24888a;
    /* renamed from: b */
    private volatile boolean f24889b = true;

    public C7353am(C7350aj ajVar) {
        this.f24888a = ajVar;
    }

    public void run() {
        if (!this.f24889b) {
            if (this.f24888a.f24884h == null) {
                this.f24888a.f24883g.postDelayed(this, 3000);
            } else {
                Log.i("Track", "mVTrackServer!=null");
                this.f24888a.f24883g.sendMessage(this.f24888a.f24883g.obtainMessage(1));
                this.f24888a.f24883g.postDelayed(this, 30000);
            }
        }
    }

    /* renamed from: a */
    public void mo35870a() {
        if (this.f24889b) {
            this.f24889b = false;
            if (this.f24888a.f24883g != null) {
                this.f24888a.f24883g.post(this);
            }
        }
    }

    /* renamed from: b */
    public void mo35871b() {
        this.f24889b = true;
        if (this.f24888a.f24883g != null) {
            this.f24888a.f24883g.removeCallbacks(this);
        }
    }
}
