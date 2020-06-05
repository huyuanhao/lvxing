package com.scwang.smartrefresh.header.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import com.scwang.smartrefresh.layout.internal.PaintDrawable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.scwang.smartrefresh.header.internal.pathview.b */
public class PathsDrawable extends PaintDrawable {
    /* renamed from: g */
    protected static final Region f20663g = new Region();
    /* renamed from: h */
    protected static final Region f20664h = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    /* renamed from: a */
    protected int f20665a = 1;
    /* renamed from: b */
    protected int f20666b = 1;
    /* renamed from: c */
    protected int f20667c = 0;
    /* renamed from: d */
    protected int f20668d = 0;
    /* renamed from: e */
    protected int f20669e;
    /* renamed from: f */
    protected int f20670f;
    /* renamed from: i */
    protected List<Path> f20671i;
    /* renamed from: j */
    protected List<Integer> f20672j;
    /* renamed from: k */
    protected List<Path> f20673k;
    /* renamed from: l */
    protected List<String> f20674l;
    /* renamed from: n */
    private Bitmap f20675n;
    /* renamed from: o */
    private boolean f20676o;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo30808a() {
        Integer num;
        Integer num2;
        Integer num3;
        int i;
        int i2;
        int i3;
        int i4;
        List<Path> list = this.f20671i;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num = null;
            for (Path path : list) {
                f20663g.setPath(path, f20664h);
                Rect bounds = f20663g.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num = Integer.valueOf(Math.max(num == null ? bounds.bottom : num.intValue(), bounds.bottom));
            }
            num3 = num4;
            num4 = num5;
        } else {
            num3 = null;
            num2 = null;
            num = null;
        }
        if (num4 == null) {
            i = 0;
        } else {
            i = num4.intValue();
        }
        this.f20667c = i;
        if (num3 == null) {
            i2 = 0;
        } else {
            i2 = num3.intValue();
        }
        this.f20668d = i2;
        if (num2 == null) {
            i3 = 0;
        } else {
            i3 = num2.intValue() - this.f20667c;
        }
        this.f20665a = i3;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.intValue() - this.f20668d;
        }
        this.f20666b = i4;
        if (this.f20669e == 0) {
            this.f20669e = this.f20665a;
        }
        if (this.f20670f == 0) {
            this.f20670f = this.f20666b;
        }
        Rect bounds2 = getBounds();
        if (this.f20665a == 0 || this.f20666b == 0) {
            if (this.f20669e == 0) {
                this.f20669e = 1;
            }
            if (this.f20670f == 0) {
                this.f20670f = 1;
            }
            this.f20666b = 1;
            this.f20665a = 1;
            return false;
        }
        super.setBounds(bounds2.left, bounds2.top, bounds2.left + this.f20665a, bounds2.top + this.f20666b);
        return true;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.f20673k;
        if (list == null || list.size() <= 0 || (i5 == this.f20665a && i6 == this.f20666b)) {
            super.setBounds(i, i2, i3, i4);
            return;
        }
        int i7 = this.f20667c;
        int i8 = this.f20668d;
        float f = (float) i5;
        float f2 = (float) i6;
        this.f20671i = C6472a.m25427a((f * 1.0f) / ((float) this.f20669e), (f2 * 1.0f) / ((float) this.f20670f), this.f20673k, this.f20674l);
        if (!mo30808a()) {
            this.f20665a = i5;
            this.f20666b = i6;
            this.f20667c = (int) (((((float) i7) * 1.0f) * f) / ((float) this.f20669e));
            this.f20668d = (int) (((((float) i8) * 1.0f) * f2) / ((float) this.f20670f));
            super.setBounds(i, i2, i3, i4);
        }
    }

    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public boolean mo30809a(String... strArr) {
        this.f20670f = 0;
        this.f20669e = 0;
        this.f20674l = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.f20673k = arrayList;
        this.f20671i = arrayList;
        for (String str : strArr) {
            this.f20674l.add(str);
            this.f20673k.add(C6472a.m25426a(str));
        }
        return mo30808a();
    }

    /* renamed from: a */
    public void mo30806a(int i, int i2, int i3, int i4) {
        this.f20667c = i;
        this.f20668d = i2;
        this.f20665a = i3;
        this.f20669e = i3;
        this.f20666b = i4;
        this.f20670f = i4;
        Rect bounds = getBounds();
        super.setBounds(bounds.left, bounds.top, bounds.left + i3, bounds.top + i4);
    }

    /* renamed from: a */
    public void mo30807a(int... iArr) {
        this.f20672j = new ArrayList();
        for (int valueOf : iArr) {
            this.f20672j.add(Integer.valueOf(valueOf));
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        int i = 0;
        if (this.f20955m.getAlpha() == 255) {
            canvas.save();
            canvas.translate((float) (bounds.left - this.f20667c), (float) (bounds.top - this.f20668d));
            if (this.f20671i != null) {
                while (i < this.f20671i.size()) {
                    List<Integer> list = this.f20672j;
                    if (list != null && i < list.size()) {
                        this.f20955m.setColor(((Integer) this.f20672j.get(i)).intValue());
                    }
                    canvas.drawPath((Path) this.f20671i.get(i), this.f20955m);
                    i++;
                }
                this.f20955m.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        m25439a(width, height);
        if (this.f20676o) {
            this.f20675n.eraseColor(0);
            m25440a(new Canvas(this.f20675n));
            this.f20676o = false;
        }
        canvas.drawBitmap(this.f20675n, (float) bounds.left, (float) bounds.top, this.f20955m);
    }

    /* renamed from: a */
    public void mo30805a(int i) {
        Rect bounds = getBounds();
        float width = (((float) i) * 1.0f) / ((float) bounds.width());
        setBounds((int) (((float) bounds.left) * width), (int) (((float) bounds.top) * width), (int) (((float) bounds.right) * width), (int) (((float) bounds.bottom) * width));
    }

    /* renamed from: b */
    public void mo30810b(int i) {
        Rect bounds = getBounds();
        float height = (((float) i) * 1.0f) / ((float) bounds.height());
        setBounds((int) (((float) bounds.left) * height), (int) (((float) bounds.top) * height), (int) (((float) bounds.right) * height), (int) (((float) bounds.bottom) * height));
    }

    /* renamed from: a */
    private void m25440a(Canvas canvas) {
        canvas.translate((float) (-this.f20667c), (float) (-this.f20668d));
        if (this.f20671i != null) {
            int i = 0;
            while (i < this.f20671i.size()) {
                List<Integer> list = this.f20672j;
                if (list != null && i < list.size()) {
                    this.f20955m.setColor(((Integer) this.f20672j.get(i)).intValue());
                }
                canvas.drawPath((Path) this.f20671i.get(i), this.f20955m);
                i++;
            }
        }
    }

    /* renamed from: a */
    private void m25439a(int i, int i2) {
        Bitmap bitmap = this.f20675n;
        if (bitmap == null || i != bitmap.getWidth() || i2 != this.f20675n.getHeight()) {
            this.f20675n = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f20676o = true;
        }
    }
}
