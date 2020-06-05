package p706pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;

/* renamed from: pl.droidsonroids.gif.d */
final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {

    /* compiled from: GifRenderingExecutor */
    /* renamed from: pl.droidsonroids.gif.d$a */
    private static final class C8595a {
        /* access modifiers changed from: private|static|final */
        /* renamed from: a */
        public static final GifRenderingExecutor f29282a = new GifRenderingExecutor();
    }

    /* renamed from: a */
    static GifRenderingExecutor m37433a() {
        return C8595a.f29282a;
    }

    private GifRenderingExecutor() {
        super(1, new DiscardPolicy());
    }
}
