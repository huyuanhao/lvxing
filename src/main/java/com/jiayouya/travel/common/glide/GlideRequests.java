package com.jiayouya.travel.common.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.RequestOptions;

/* renamed from: com.jiayouya.travel.common.glide.c */
public class GlideRequests extends RequestManager {
    public GlideRequests(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, Context context) {
        super(eVar, hVar, mVar, context);
    }

    /* renamed from: c */
    public <ResourceType> GlideRequest<ResourceType> mo12589a(Class<ResourceType> cls) {
        return new GlideRequest<>(this.f4371a, this, cls, this.f4372b);
    }

    /* renamed from: g */
    public GlideRequest<Bitmap> mo12599c() {
        return (GlideRequest) super.mo12599c();
    }

    /* renamed from: h */
    public GlideRequest<Drawable> mo12600d() {
        return (GlideRequest) super.mo12600d();
    }

    /* renamed from: b */
    public GlideRequest<Drawable> mo12591a(String str) {
        return (GlideRequest) super.mo12591a(str);
    }

    /* renamed from: b */
    public GlideRequest<Drawable> mo12590a(Integer num) {
        return (GlideRequest) super.mo12590a(num);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12595a(RequestOptions fVar) {
        if (fVar instanceof GlideOptions) {
            super.mo12595a(fVar);
        } else {
            super.mo12595a((RequestOptions) new GlideOptions().mo12435b((BaseRequestOptions<?>) fVar));
        }
    }
}
