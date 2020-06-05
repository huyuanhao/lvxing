package p706pl.droidsonroids.gif;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: pl.droidsonroids.gif.l */
abstract class SafeRunnable implements Runnable {
    /* renamed from: c */
    final GifDrawable f29296c;

    /* renamed from: a */
    public abstract void mo41260a();

    SafeRunnable(GifDrawable cVar) {
        this.f29296c = cVar;
    }

    public final void run() {
        try {
            if (!this.f29296c.mo41224a()) {
                mo41260a();
            }
        } catch (Throwable th) {
            UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
