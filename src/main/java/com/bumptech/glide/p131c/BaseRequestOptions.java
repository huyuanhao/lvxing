package com.bumptech.glide.p131c;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p134d.EmptySignature;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.a */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    /* renamed from: a */
    private int f4162a;
    /* renamed from: b */
    private float f4163b = 1.0f;
    /* renamed from: c */
    private DiskCacheStrategy f4164c = DiskCacheStrategy.f4633e;
    /* renamed from: d */
    private Priority f4165d = Priority.NORMAL;
    /* renamed from: e */
    private Drawable f4166e;
    /* renamed from: f */
    private int f4167f;
    /* renamed from: g */
    private Drawable f4168g;
    /* renamed from: h */
    private int f4169h;
    /* renamed from: i */
    private boolean f4170i = true;
    /* renamed from: j */
    private int f4171j = -1;
    /* renamed from: k */
    private int f4172k = -1;
    /* renamed from: l */
    private Key f4173l = EmptySignature.m5168a();
    /* renamed from: m */
    private boolean f4174m;
    /* renamed from: n */
    private boolean f4175n = true;
    /* renamed from: o */
    private Drawable f4176o;
    /* renamed from: p */
    private int f4177p;
    /* renamed from: q */
    private Options f4178q = new Options();
    /* renamed from: r */
    private Map<Class<?>, Transformation<?>> f4179r = new CachedHashCodeArrayMap();
    /* renamed from: s */
    private Class<?> f4180s = Object.class;
    /* renamed from: t */
    private boolean f4181t;
    /* renamed from: u */
    private Theme f4182u;
    /* renamed from: v */
    private boolean f4183v;
    /* renamed from: w */
    private boolean f4184w;
    /* renamed from: x */
    private boolean f4185x;
    /* renamed from: y */
    private boolean f4186y = true;
    /* renamed from: z */
    private boolean f4187z;

    /* renamed from: I */
    private T mo19960I() {
        return this;
    }

    /* renamed from: b */
    private static boolean mo19968b(int i, int i2) {
        return (i & i2) != 0;
    }

    /* renamed from: a */
    public T mo12420a(float f) {
        if (this.f4183v) {
            return clone().mo12420a(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f4163b = f;
        this.f4162a |= 2;
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12432a(boolean z) {
        if (this.f4183v) {
            return clone().mo12432a(z);
        }
        this.f4187z = z;
        this.f4162a |= 1048576;
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12425a(DiskCacheStrategy jVar) {
        if (this.f4183v) {
            return clone().mo12425a(jVar);
        }
        this.f4164c = (DiskCacheStrategy) Preconditions.m6138a(jVar);
        this.f4162a |= 4;
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12422a(Priority priority) {
        if (this.f4183v) {
            return clone().mo12422a(priority);
        }
        this.f4165d = (Priority) Preconditions.m6138a(priority);
        this.f4162a |= 8;
        return mo12583a();
    }

    /* renamed from: b */
    public T mo12437b(boolean z) {
        if (this.f4183v) {
            return clone().mo12437b(true);
        }
        this.f4170i = !z;
        this.f4162a |= 256;
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12421a(int i, int i2) {
        if (this.f4183v) {
            return clone().mo12421a(i, i2);
        }
        this.f4172k = i;
        this.f4171j = i2;
        this.f4162a |= 512;
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12423a(Key cVar) {
        if (this.f4183v) {
            return clone().mo12423a(cVar);
        }
        this.f4173l = (Key) Preconditions.m6138a(cVar);
        this.f4162a |= 1024;
        return mo12583a();
    }

    /* renamed from: b */
    public T clone() {
        try {
            T t = (BaseRequestOptions) super.clone();
            t.f4178q = new Options();
            t.f4178q.mo12920a(this.f4178q);
            t.f4179r = new CachedHashCodeArrayMap();
            t.f4179r.putAll(this.f4179r);
            t.f4181t = false;
            t.f4183v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public <Y> T mo12424a(Option<Y> eVar, Y y) {
        if (this.f4183v) {
            return clone().mo12424a(eVar, y);
        }
        Preconditions.m6138a(eVar);
        Preconditions.m6138a(y);
        this.f4178q.mo12918a(eVar, y);
        return mo12583a();
    }

    /* renamed from: a */
    public T mo12430a(Class<?> cls) {
        if (this.f4183v) {
            return clone().mo12430a(cls);
        }
        this.f4180s = (Class) Preconditions.m6138a(cls);
        this.f4162a |= 4096;
        return mo12583a();
    }

    /* renamed from: c */
    public final boolean mo12438c() {
        return this.f4175n;
    }

    /* renamed from: d */
    public final boolean mo12440d() {
        return m4959a(2048);
    }

    /* renamed from: a */
    public T mo12428a(DownsampleStrategy downsampleStrategy) {
        return mo12424a(DownsampleStrategy.OPTION, (Y) Preconditions.m6138a(downsampleStrategy));
    }

    /* renamed from: e */
    public T mo12441e() {
        return mo12429a(DownsampleStrategy.CENTER_OUTSIDE, (Transformation<Bitmap>) new CenterCrop<Bitmap>());
    }

    /* renamed from: f */
    public T mo12443f() {
        return m4961c(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    /* renamed from: g */
    public T mo12444g() {
        return m4961c(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final T mo12429a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> iVar) {
        if (this.f4183v) {
            return clone().mo12429a(downsampleStrategy, iVar);
        }
        mo12428a(downsampleStrategy);
        return mo12427a(iVar, false);
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final T mo12436b(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> iVar) {
        if (this.f4183v) {
            return clone().mo12436b(downsampleStrategy, iVar);
        }
        mo12428a(downsampleStrategy);
        return mo12426a(iVar);
    }

    /* renamed from: c */
    private T m4961c(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> iVar) {
        return m4958a(downsampleStrategy, iVar, false);
    }

    /* renamed from: a */
    private T m4958a(DownsampleStrategy downsampleStrategy, Transformation<Bitmap> iVar, boolean z) {
        T b = z ? mo12436b(downsampleStrategy, iVar) : mo12429a(downsampleStrategy, iVar);
        b.f4186y = true;
        return b;
    }

    /* renamed from: a */
    public T mo12426a(Transformation<Bitmap> iVar) {
        return mo12427a(iVar, true);
    }

    @Deprecated
    /* renamed from: a */
    public T mo12433a(Transformation<Bitmap>... iVarArr) {
        return mo12427a((Transformation<Bitmap>) new MultiTransformation<Bitmap>(iVarArr), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public T mo12427a(Transformation<Bitmap> iVar, boolean z) {
        if (this.f4183v) {
            return clone().mo12427a(iVar, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(iVar, z);
        mo12431a(Bitmap.class, iVar, z);
        mo12431a(Drawable.class, (Transformation<Y>) drawableTransformation, z);
        mo12431a(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        mo12431a(GifDrawable.class, (Transformation<Y>) new GifDrawableTransformation<Y>(iVar), z);
        return mo12583a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Y> T mo12431a(Class<Y> cls, Transformation<Y> iVar, boolean z) {
        if (this.f4183v) {
            return clone().mo12431a(cls, iVar, z);
        }
        Preconditions.m6138a(cls);
        Preconditions.m6138a(iVar);
        this.f4179r.put(cls, iVar);
        this.f4162a |= 2048;
        this.f4175n = true;
        this.f4162a |= 65536;
        this.f4186y = false;
        if (z) {
            this.f4162a |= 131072;
            this.f4174m = true;
        }
        return mo12583a();
    }

    /* renamed from: h */
    public T mo12445h() {
        return mo12424a(GifOptions.DISABLE_ANIMATION, (Y) Boolean.valueOf(true));
    }

    /* renamed from: b */
    public T mo12435b(BaseRequestOptions<?> aVar) {
        if (this.f4183v) {
            return clone().mo12435b(aVar);
        }
        if (mo19968b(aVar.f4162a, 2)) {
            this.f4163b = aVar.f4163b;
        }
        if (mo19968b(aVar.f4162a, 262144)) {
            this.f4184w = aVar.f4184w;
        }
        if (mo19968b(aVar.f4162a, 1048576)) {
            this.f4187z = aVar.f4187z;
        }
        if (mo19968b(aVar.f4162a, 4)) {
            this.f4164c = aVar.f4164c;
        }
        if (mo19968b(aVar.f4162a, 8)) {
            this.f4165d = aVar.f4165d;
        }
        if (mo19968b(aVar.f4162a, 16)) {
            this.f4166e = aVar.f4166e;
            this.f4167f = 0;
            this.f4162a &= -33;
        }
        if (mo19968b(aVar.f4162a, 32)) {
            this.f4167f = aVar.f4167f;
            this.f4166e = null;
            this.f4162a &= -17;
        }
        if (mo19968b(aVar.f4162a, 64)) {
            this.f4168g = aVar.f4168g;
            this.f4169h = 0;
            this.f4162a &= -129;
        }
        if (mo19968b(aVar.f4162a, 128)) {
            this.f4169h = aVar.f4169h;
            this.f4168g = null;
            this.f4162a &= -65;
        }
        if (mo19968b(aVar.f4162a, 256)) {
            this.f4170i = aVar.f4170i;
        }
        if (mo19968b(aVar.f4162a, 512)) {
            this.f4172k = aVar.f4172k;
            this.f4171j = aVar.f4171j;
        }
        if (mo19968b(aVar.f4162a, 1024)) {
            this.f4173l = aVar.f4173l;
        }
        if (mo19968b(aVar.f4162a, 4096)) {
            this.f4180s = aVar.f4180s;
        }
        if (mo19968b(aVar.f4162a, 8192)) {
            this.f4176o = aVar.f4176o;
            this.f4177p = 0;
            this.f4162a &= -16385;
        }
        if (mo19968b(aVar.f4162a, 16384)) {
            this.f4177p = aVar.f4177p;
            this.f4176o = null;
            this.f4162a &= -8193;
        }
        if (mo19968b(aVar.f4162a, 32768)) {
            this.f4182u = aVar.f4182u;
        }
        if (mo19968b(aVar.f4162a, 65536)) {
            this.f4175n = aVar.f4175n;
        }
        if (mo19968b(aVar.f4162a, 131072)) {
            this.f4174m = aVar.f4174m;
        }
        if (mo19968b(aVar.f4162a, 2048)) {
            this.f4179r.putAll(aVar.f4179r);
            this.f4186y = aVar.f4186y;
        }
        if (mo19968b(aVar.f4162a, 524288)) {
            this.f4185x = aVar.f4185x;
        }
        if (!this.f4175n) {
            this.f4179r.clear();
            this.f4162a &= -2049;
            this.f4174m = false;
            this.f4162a &= -131073;
            this.f4186y = true;
        }
        this.f4162a |= aVar.f4162a;
        this.f4178q.mo12920a(aVar.f4178q);
        return mo12583a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions aVar = (BaseRequestOptions) obj;
        if (Float.compare(aVar.f4163b, this.f4163b) == 0 && this.f4167f == aVar.f4167f && C1772j.m6156a((Object) this.f4166e, (Object) aVar.f4166e) && this.f4169h == aVar.f4169h && C1772j.m6156a((Object) this.f4168g, (Object) aVar.f4168g) && this.f4177p == aVar.f4177p && C1772j.m6156a((Object) this.f4176o, (Object) aVar.f4176o) && this.f4170i == aVar.f4170i && this.f4171j == aVar.f4171j && this.f4172k == aVar.f4172k && this.f4174m == aVar.f4174m && this.f4175n == aVar.f4175n && this.f4184w == aVar.f4184w && this.f4185x == aVar.f4185x && this.f4164c.equals(aVar.f4164c) && this.f4165d == aVar.f4165d && this.f4178q.equals(aVar.f4178q) && this.f4179r.equals(aVar.f4179r) && this.f4180s.equals(aVar.f4180s) && C1772j.m6156a((Object) this.f4173l, (Object) aVar.f4173l) && C1772j.m6156a((Object) this.f4182u, (Object) aVar.f4182u)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C1772j.m6148a((Object) this.f4182u, C1772j.m6148a((Object) this.f4173l, C1772j.m6148a((Object) this.f4180s, C1772j.m6148a((Object) this.f4179r, C1772j.m6148a((Object) this.f4178q, C1772j.m6148a((Object) this.f4165d, C1772j.m6148a((Object) this.f4164c, C1772j.m6149a(this.f4185x, C1772j.m6149a(this.f4184w, C1772j.m6149a(this.f4175n, C1772j.m6149a(this.f4174m, C1772j.m6158b(this.f4172k, C1772j.m6158b(this.f4171j, C1772j.m6149a(this.f4170i, C1772j.m6148a((Object) this.f4176o, C1772j.m6158b(this.f4177p, C1772j.m6148a((Object) this.f4168g, C1772j.m6158b(this.f4169h, C1772j.m6148a((Object) this.f4166e, C1772j.m6158b(this.f4167f, C1772j.m6143a(this.f4163b)))))))))))))))))))));
    }

    /* renamed from: i */
    public T mo12447i() {
        this.f4181t = true;
        return mo19960I();
    }

    /* renamed from: j */
    public T mo12448j() {
        if (!this.f4181t || this.f4183v) {
            this.f4183v = true;
            return mo12447i();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    /* renamed from: a */
    private T mo12583a() {
        if (!this.f4181t) {
            return mo19960I();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    /* renamed from: k */
    public final Map<Class<?>, Transformation<?>> mo12449k() {
        return this.f4179r;
    }

    /* renamed from: l */
    public final boolean mo12450l() {
        return this.f4174m;
    }

    /* renamed from: m */
    public final Options mo12451m() {
        return this.f4178q;
    }

    /* renamed from: n */
    public final Class<?> mo12452n() {
        return this.f4180s;
    }

    /* renamed from: o */
    public final DiskCacheStrategy mo12453o() {
        return this.f4164c;
    }

    /* renamed from: p */
    public final Drawable mo12454p() {
        return this.f4166e;
    }

    /* renamed from: q */
    public final int mo12455q() {
        return this.f4167f;
    }

    /* renamed from: r */
    public final int mo12456r() {
        return this.f4169h;
    }

    /* renamed from: s */
    public final Drawable mo12457s() {
        return this.f4168g;
    }

    /* renamed from: t */
    public final int mo12458t() {
        return this.f4177p;
    }

    /* renamed from: u */
    public final Drawable mo12459u() {
        return this.f4176o;
    }

    /* renamed from: v */
    public final Theme mo12460v() {
        return this.f4182u;
    }

    /* renamed from: w */
    public final boolean mo12461w() {
        return this.f4170i;
    }

    /* renamed from: x */
    public final Key mo12462x() {
        return this.f4173l;
    }

    /* renamed from: y */
    public final boolean mo12463y() {
        return m4959a(8);
    }

    /* renamed from: z */
    public final Priority mo12464z() {
        return this.f4165d;
    }

    /* renamed from: A */
    public final int mo12412A() {
        return this.f4172k;
    }

    /* renamed from: B */
    public final boolean mo12413B() {
        return C1772j.m6155a(this.f4172k, this.f4171j);
    }

    /* renamed from: C */
    public final int mo12414C() {
        return this.f4171j;
    }

    /* renamed from: D */
    public final float mo12415D() {
        return this.f4163b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public boolean mo12416E() {
        return this.f4186y;
    }

    /* renamed from: a */
    private boolean m4959a(int i) {
        return mo19968b(this.f4162a, i);
    }

    /* renamed from: F */
    public final boolean mo12417F() {
        return this.f4184w;
    }

    /* renamed from: G */
    public final boolean mo12418G() {
        return this.f4187z;
    }

    /* renamed from: H */
    public final boolean mo12419H() {
        return this.f4185x;
    }
}
