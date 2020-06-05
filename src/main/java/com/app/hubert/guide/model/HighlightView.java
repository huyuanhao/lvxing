package com.app.hubert.guide.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.app.hubert.guide.model.HighLight.Shape;
import com.app.hubert.guide.p128b.LogUtil;
import com.app.hubert.guide.p128b.ViewUtils;

/* renamed from: com.app.hubert.guide.model.c */
public class HighlightView implements HighLight {
    /* renamed from: a */
    private View f4079a;
    /* renamed from: b */
    private Shape f4080b;
    /* renamed from: c */
    private int f4081c;
    /* renamed from: d */
    private int f4082d;
    /* renamed from: e */
    private HighlightOptions f4083e;
    /* renamed from: f */
    private RectF f4084f;

    public HighlightView(View view, Shape shape, int i, int i2) {
        this.f4079a = view;
        this.f4080b = shape;
        this.f4081c = i;
        this.f4082d = i2;
    }

    /* renamed from: a */
    public void mo12336a(HighlightOptions bVar) {
        this.f4083e = bVar;
    }

    /* renamed from: a */
    public Shape mo12317a() {
        return this.f4080b;
    }

    /* renamed from: c */
    public int mo12319c() {
        return this.f4081c;
    }

    /* renamed from: d */
    public HighlightOptions mo12320d() {
        return this.f4083e;
    }

    /* renamed from: b */
    public float mo12318b() {
        View view = this.f4079a;
        if (view != null) {
            return (float) (Math.max(view.getWidth() / 2, this.f4079a.getHeight() / 2) + this.f4082d);
        }
        throw new IllegalArgumentException("the highlight view is null!");
    }

    /* renamed from: a */
    public RectF mo12316a(View view) {
        if (this.f4079a != null) {
            if (this.f4084f == null) {
                this.f4084f = new RectF();
                Rect a = ViewUtils.m4781a(view, this.f4079a);
                this.f4084f.left = (float) (a.left - this.f4082d);
                this.f4084f.top = (float) (a.top - this.f4082d);
                this.f4084f.right = (float) (a.right + this.f4082d);
                this.f4084f.bottom = (float) (a.bottom + this.f4082d);
                StringBuilder sb = new StringBuilder();
                sb.append(this.f4079a.getClass().getSimpleName());
                sb.append("'s location:");
                sb.append(this.f4084f);
                LogUtil.m4779b(sb.toString());
            }
            return this.f4084f;
        }
        throw new IllegalArgumentException("the highlight view is null!");
    }
}
