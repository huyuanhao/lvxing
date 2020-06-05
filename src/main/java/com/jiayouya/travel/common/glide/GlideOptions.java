package com.jiayouya.travel.common.glide;

import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.RequestOptions;

/* renamed from: com.jiayouya.travel.common.glide.a */
public final class GlideOptions extends RequestOptions implements Cloneable {
    /* renamed from: b */
    public GlideOptions mo12420a(float f) {
        return (GlideOptions) super.mo12420a(f);
    }

    /* renamed from: c */
    public GlideOptions mo12432a(boolean z) {
        return (GlideOptions) super.mo12432a(z);
    }

    /* renamed from: c */
    public GlideOptions mo12425a(DiskCacheStrategy jVar) {
        return (GlideOptions) super.mo12425a(jVar);
    }

    /* renamed from: b */
    public GlideOptions mo12422a(Priority priority) {
        return (GlideOptions) super.mo12422a(priority);
    }

    /* renamed from: d */
    public GlideOptions mo12437b(boolean z) {
        return (GlideOptions) super.mo12437b(z);
    }

    /* renamed from: b */
    public GlideOptions mo12421a(int i, int i2) {
        return (GlideOptions) super.mo12421a(i, i2);
    }

    /* renamed from: c */
    public GlideOptions mo12423a(Key cVar) {
        return (GlideOptions) super.mo12423a(cVar);
    }

    /* renamed from: a */
    public GlideOptions clone() {
        return (GlideOptions) super.clone();
    }

    /* renamed from: b */
    public <Y> GlideOptions mo12424a(Option<Y> eVar, Y y) {
        return (GlideOptions) super.mo12424a(eVar, y);
    }

    /* renamed from: c */
    public GlideOptions mo12430a(Class<?> cls) {
        return (GlideOptions) super.mo12430a(cls);
    }

    /* renamed from: b */
    public GlideOptions mo12428a(DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.mo12428a(downsampleStrategy);
    }

    /* renamed from: I */
    public GlideOptions mo12441e() {
        return (GlideOptions) super.mo12441e();
    }

    /* renamed from: J */
    public GlideOptions mo12443f() {
        return (GlideOptions) super.mo12443f();
    }

    /* renamed from: K */
    public GlideOptions mo12444g() {
        return (GlideOptions) super.mo12444g();
    }

    /* renamed from: b */
    public GlideOptions mo12426a(Transformation<Bitmap> iVar) {
        return (GlideOptions) super.mo12426a(iVar);
    }

    @Deprecated
    @SafeVarargs
    /* renamed from: b */
    public final GlideOptions mo12433a(Transformation<Bitmap>... iVarArr) {
        return (GlideOptions) super.mo12433a(iVarArr);
    }

    /* renamed from: L */
    public GlideOptions mo12445h() {
        return (GlideOptions) super.mo12445h();
    }

    /* renamed from: a */
    public GlideOptions mo12435b(BaseRequestOptions<?> aVar) {
        return (GlideOptions) super.mo12435b(aVar);
    }

    /* renamed from: M */
    public GlideOptions mo12447i() {
        return (GlideOptions) super.mo12447i();
    }

    /* renamed from: N */
    public GlideOptions mo12448j() {
        return (GlideOptions) super.mo12448j();
    }
}
