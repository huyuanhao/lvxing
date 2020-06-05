package com.p368pw.inner.base.p387d.p391d;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.p368pw.inner.base.p387d.C5205o;

/* renamed from: com.pw.inner.base.d.d.c */
public abstract class C5184c implements OnTouchListener {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final float[] f16884a = new float[2];
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final float[] f16885b = new float[2];
    /* renamed from: c */
    private final GestureDetector f16886c;

    public C5184c(Context context) {
        this.f16886c = new GestureDetector(context.getApplicationContext(), new OnGestureListener() {
            public boolean onDown(MotionEvent motionEvent) {
                C5184c.this.f16884a[0] = motionEvent.getX();
                C5184c.this.f16884a[1] = motionEvent.getY();
                C5184c.this.f16885b[0] = motionEvent.getRawX();
                C5184c.this.f16885b[1] = motionEvent.getRawY();
                return false;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onLongPress(MotionEvent motionEvent) {
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            public boolean onSingleTapUp(MotionEvent motionEvent) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                StringBuilder sb = new StringBuilder();
                sb.append("onSingleTapUp: ");
                sb.append(C5184c.this.f16884a[0]);
                String str = " ";
                sb.append(str);
                sb.append(C5184c.this.f16884a[1]);
                sb.append(str);
                sb.append(x);
                sb.append(str);
                sb.append(y);
                C5205o.m21462a(sb.toString());
                C5184c cVar = C5184c.this;
                cVar.mo26787a(C5183b.m21362a(cVar.f16884a[0], C5184c.this.f16884a[1], x, y, C5184c.this.f16885b[0], C5184c.this.f16885b[1], rawX, rawY));
                return false;
            }
        });
    }

    /* renamed from: a */
    public abstract void mo26787a(C5183b bVar);

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f16886c.onTouchEvent(motionEvent);
    }
}
