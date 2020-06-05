package com.bytedance.sdk.p145a.p146a;

import android.support.p000v4.media.session.PlaybackStateCompat;

/* renamed from: com.bytedance.sdk.a.a.p */
final class SegmentPool {
    /* renamed from: a */
    static Segment f5282a;
    /* renamed from: b */
    static long f5283b;

    private SegmentPool() {
    }

    /* renamed from: a */
    static Segment m6800a() {
        synchronized (SegmentPool.class) {
            if (f5282a == null) {
                return new Segment();
            }
            Segment oVar = f5282a;
            f5282a = oVar.f5280f;
            oVar.f5280f = null;
            f5283b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return oVar;
        }
    }

    /* renamed from: a */
    static void m6801a(Segment oVar) {
        if (oVar.f5280f != null || oVar.f5281g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f5278d) {
            synchronized (SegmentPool.class) {
                if (f5283b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f5283b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    oVar.f5280f = f5282a;
                    oVar.f5277c = 0;
                    oVar.f5276b = 0;
                    f5282a = oVar;
                }
            }
        }
    }
}
