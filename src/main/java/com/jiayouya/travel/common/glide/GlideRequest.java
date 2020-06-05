package com.jiayouya.travel.common.glide;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.RequestListener;

/* renamed from: com.jiayouya.travel.common.glide.b */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    GlideRequest(Glide eVar, RequestManager iVar, Class<TranscodeType> cls, Context context) {
        super(eVar, iVar, cls, context);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12420a(float f) {
        return (GlideRequest) super.mo12420a(f);
    }

    /* renamed from: c */
    public GlideRequest<TranscodeType> mo12432a(boolean z) {
        return (GlideRequest) super.mo12432a(z);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12425a(DiskCacheStrategy jVar) {
        return (GlideRequest) super.mo12425a(jVar);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12422a(Priority priority) {
        return (GlideRequest) super.mo12422a(priority);
    }

    /* renamed from: d */
    public GlideRequest<TranscodeType> mo12437b(boolean z) {
        return (GlideRequest) super.mo12437b(z);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12421a(int i, int i2) {
        return (GlideRequest) super.mo12421a(i, i2);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12423a(Key cVar) {
        return (GlideRequest) super.mo12423a(cVar);
    }

    /* renamed from: b */
    public <Y> GlideRequest<TranscodeType> mo12424a(Option<Y> eVar, Y y) {
        return (GlideRequest) super.mo12424a(eVar, y);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12430a(Class<?> cls) {
        return (GlideRequest) super.mo12430a(cls);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12428a(DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.mo12428a(downsampleStrategy);
    }

    /* renamed from: I */
    public GlideRequest<TranscodeType> mo12441e() {
        return (GlideRequest) super.mo12441e();
    }

    /* renamed from: J */
    public GlideRequest<TranscodeType> mo12443f() {
        return (GlideRequest) super.mo12443f();
    }

    /* renamed from: K */
    public GlideRequest<TranscodeType> mo12444g() {
        return (GlideRequest) super.mo12444g();
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12426a(Transformation<Bitmap> iVar) {
        return (GlideRequest) super.mo12426a(iVar);
    }

    @Deprecated
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12433a(Transformation<Bitmap>... iVarArr) {
        return (GlideRequest) super.mo12433a(iVarArr);
    }

    /* renamed from: L */
    public GlideRequest<TranscodeType> mo12445h() {
        return (GlideRequest) super.mo12445h();
    }

    /* renamed from: c */
    public GlideRequest<TranscodeType> mo12435b(BaseRequestOptions<?> aVar) {
        return (GlideRequest) super.mo12435b(aVar);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12585a(RequestListener<TranscodeType> eVar) {
        return (GlideRequest) super.mo12585a(eVar);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12587a(Object obj) {
        return (GlideRequest) super.mo12587a(obj);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12588a(String str) {
        return (GlideRequest) super.mo12588a(str);
    }

    /* renamed from: b */
    public GlideRequest<TranscodeType> mo12586a(Integer num) {
        return (GlideRequest) super.mo12586a(num);
    }

    /* renamed from: M */
    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest) super.clone();
    }
}
