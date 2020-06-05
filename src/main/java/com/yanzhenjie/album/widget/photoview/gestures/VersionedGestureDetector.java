package com.yanzhenjie.album.widget.photoview.gestures;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: com.yanzhenjie.album.widget.photoview.gestures.c */
public final class VersionedGestureDetector {
    /* renamed from: a */
    public static GestureDetector m33726a(Context context, OnGestureListener bVar) {
        GestureDetector aVar;
        int i = VERSION.SDK_INT;
        if (i < 5) {
            aVar = new CupcakeGestureDetector(context);
        } else if (i < 8) {
            aVar = new EclairGestureDetector(context);
        } else {
            aVar = new FroyoGestureDetector(context);
        }
        aVar.mo37763a(bVar);
        return aVar;
    }
}
