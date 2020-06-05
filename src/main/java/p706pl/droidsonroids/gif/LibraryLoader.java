package p706pl.droidsonroids.gif;

import android.content.Context;

/* renamed from: pl.droidsonroids.gif.h */
public class LibraryLoader {
    /* renamed from: a */
    private static Context f29292a;

    /* renamed from: a */
    private static Context m37444a() {
        if (f29292a == null) {
            try {
                f29292a = (Context) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
            }
        }
        return f29292a;
    }

    /* renamed from: a */
    static void m37445a(Context context) {
        try {
            System.loadLibrary("pl_droidsonroids_gif");
        } catch (UnsatisfiedLinkError unused) {
            if (context == null) {
                context = m37444a();
            }
            ReLinker.m37450a(context);
        }
    }
}
