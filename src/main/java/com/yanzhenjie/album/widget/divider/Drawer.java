package com.yanzhenjie.album.widget.divider;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.yanzhenjie.album.widget.divider.b */
class Drawer {
    /* renamed from: a */
    private final Drawable f26354a;
    /* renamed from: b */
    private final int f26355b;
    /* renamed from: c */
    private final int f26356c;

    public Drawer(Drawable drawable, int i, int i2) {
        this.f26354a = drawable;
        this.f26355b = i;
        this.f26356c = i2;
    }

    /* renamed from: a */
    public void mo37723a(View view, Canvas canvas) {
        int left = view.getLeft() - this.f26355b;
        this.f26354a.setBounds(left, view.getTop() - this.f26356c, this.f26355b + left, view.getBottom() + this.f26356c);
        this.f26354a.draw(canvas);
    }

    /* renamed from: b */
    public void mo37724b(View view, Canvas canvas) {
        int top = view.getTop() - this.f26356c;
        this.f26354a.setBounds(view.getLeft() - this.f26355b, top, view.getRight() + this.f26355b, this.f26356c + top);
        this.f26354a.draw(canvas);
    }

    /* renamed from: c */
    public void mo37725c(View view, Canvas canvas) {
        int right = view.getRight();
        this.f26354a.setBounds(right, view.getTop() - this.f26356c, this.f26355b + right, view.getBottom() + this.f26356c);
        this.f26354a.draw(canvas);
    }

    /* renamed from: d */
    public void mo37726d(View view, Canvas canvas) {
        int left = view.getLeft() - this.f26355b;
        int bottom = view.getBottom();
        this.f26354a.setBounds(left, bottom, view.getRight() + this.f26355b, this.f26356c + bottom);
        this.f26354a.draw(canvas);
    }
}
