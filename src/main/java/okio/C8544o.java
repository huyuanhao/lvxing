package okio;

import android.support.p000v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* compiled from: SegmentPool */
/* renamed from: okio.o */
final class C8544o {
    @Nullable
    /* renamed from: a */
    static C8543n f29053a;
    /* renamed from: b */
    static long f29054b;

    private C8544o() {
    }

    /* renamed from: a */
    static C8543n m36917a() {
        synchronized (C8544o.class) {
            if (f29053a == null) {
                return new C8543n();
            }
            C8543n nVar = f29053a;
            f29053a = nVar.f29051f;
            nVar.f29051f = null;
            f29054b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return nVar;
        }
    }

    /* renamed from: a */
    static void m36918a(C8543n nVar) {
        if (nVar.f29051f != null || nVar.f29052g != null) {
            throw new IllegalArgumentException();
        } else if (!nVar.f29049d) {
            synchronized (C8544o.class) {
                if (f29054b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    f29054b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    nVar.f29051f = f29053a;
                    nVar.f29048c = 0;
                    nVar.f29047b = 0;
                    f29053a = nVar;
                }
            }
        }
    }
}
