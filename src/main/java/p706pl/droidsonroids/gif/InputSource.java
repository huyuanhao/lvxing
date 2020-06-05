package p706pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.IOException;

/* renamed from: pl.droidsonroids.gif.f */
public abstract class InputSource {

    /* compiled from: InputSource */
    /* renamed from: pl.droidsonroids.gif.f$a */
    public static final class C8598a extends InputSource {
        /* renamed from: a */
        private final AssetManager f29287a;
        /* renamed from: b */
        private final String f29288b;

        public C8598a(AssetManager assetManager, String str) {
            super();
            this.f29287a = assetManager;
            this.f29288b = str;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public GifInfoHandle mo41261a() throws IOException {
            return new GifInfoHandle(this.f29287a.openFd(this.f29288b));
        }
    }

    /* compiled from: InputSource */
    /* renamed from: pl.droidsonroids.gif.f$b */
    public static class C8599b extends InputSource {
        /* renamed from: a */
        private final Resources f29289a;
        /* renamed from: b */
        private final int f29290b;

        public C8599b(Resources resources, int i) {
            super();
            this.f29289a = resources;
            this.f29290b = i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public GifInfoHandle mo41261a() throws IOException {
            return new GifInfoHandle(this.f29289a.openRawResourceFd(this.f29290b));
        }
    }

    /* renamed from: a */
    public abstract GifInfoHandle mo41261a() throws IOException;

    private InputSource() {
    }
}
