package com.kwad.sdk.p306a;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* renamed from: com.kwad.sdk.a.s */
public class C3816s {
    /* renamed from: a */
    public Rect f12933a = new Rect();
    /* renamed from: b */
    public Rect f12934b = new Rect();
    /* renamed from: c */
    public Point f12935c = new Point();
    /* renamed from: d */
    private View f12936d;

    public C3816s(View view) {
        this.f12936d = view;
    }

    /* renamed from: a */
    public boolean mo23212a() {
        boolean globalVisibleRect = this.f12936d.getGlobalVisibleRect(this.f12933a, this.f12935c);
        if (this.f12935c.x == 0 && this.f12935c.y == 0 && this.f12933a.height() == this.f12936d.getHeight() && this.f12934b.height() != 0 && Math.abs(this.f12933a.top - this.f12934b.top) > this.f12936d.getHeight() / 2) {
            this.f12933a.set(this.f12934b);
        }
        this.f12934b.set(this.f12933a);
        return globalVisibleRect;
    }
}
