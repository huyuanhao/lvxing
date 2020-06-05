package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.bugly.proguard.C7226an;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.c */
public class C7129c implements OnTouchListener {
    /* renamed from: a */
    final int f23694a;
    /* renamed from: b */
    final Object[] f23695b;

    public C7129c(int i, Object... objArr) {
        this.f23694a = i;
        this.f23695b = objArr;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (this.f23694a != 1) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0 || action == 2) {
                view.setBackgroundDrawable((Drawable) this.f23695b[0]);
            } else {
                view.setBackgroundDrawable((Drawable) this.f23695b[1]);
            }
            return false;
        } catch (Exception e) {
            if (!C7226an.m31145b(e)) {
                e.printStackTrace();
            }
        }
    }
}
