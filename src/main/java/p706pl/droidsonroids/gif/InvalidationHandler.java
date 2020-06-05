package p706pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* renamed from: pl.droidsonroids.gif.g */
class InvalidationHandler extends Handler {
    /* renamed from: a */
    private final WeakReference<GifDrawable> f29291a;

    public InvalidationHandler(GifDrawable cVar) {
        super(Looper.getMainLooper());
        this.f29291a = new WeakReference<>(cVar);
    }

    public void handleMessage(Message message) {
        GifDrawable cVar = (GifDrawable) this.f29291a.get();
        if (cVar != null) {
            if (message.what == -1) {
                cVar.invalidateSelf();
            } else {
                Iterator it = cVar.f29266g.iterator();
                while (it.hasNext()) {
                    ((C8591a) it.next()).mo41216a(message.what);
                }
            }
        }
    }
}
