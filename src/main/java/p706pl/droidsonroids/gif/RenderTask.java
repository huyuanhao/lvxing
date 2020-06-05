package p706pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* renamed from: pl.droidsonroids.gif.k */
class RenderTask extends SafeRunnable {
    RenderTask(GifDrawable cVar) {
        super(cVar);
    }

    /* renamed from: a */
    public void mo41260a() {
        long a = this.f29296c.f29265f.mo41153a(this.f29296c.f29264e);
        if (a >= 0) {
            this.f29296c.f29262c = SystemClock.uptimeMillis() + a;
            if (this.f29296c.isVisible() && this.f29296c.f29261b && !this.f29296c.f29267h) {
                this.f29296c.f29260a.remove(this);
                this.f29296c.f29269j = this.f29296c.f29260a.schedule(this, a, TimeUnit.MILLISECONDS);
            }
            if (!this.f29296c.f29266g.isEmpty() && this.f29296c.mo41232e() == this.f29296c.f29265f.mo41176r() - 1) {
                this.f29296c.f29268i.sendEmptyMessageAtTime(this.f29296c.mo41233f(), this.f29296c.f29262c);
            }
        } else {
            this.f29296c.f29262c = Long.MIN_VALUE;
            this.f29296c.f29261b = false;
        }
        if (this.f29296c.isVisible() && !this.f29296c.f29268i.hasMessages(-1)) {
            this.f29296c.f29268i.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
