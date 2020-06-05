package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.jiayouya.travel.common.glide.OkHttpGlideModule;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.bumptech.glide.b */
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    /* renamed from: a */
    private final OkHttpGlideModule f4144a = new OkHttpGlideModule();

    GeneratedAppGlideModuleImpl() {
        String str = "Glide";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Discovered AppGlideModule from annotation: com.jiayouya.travel.common.glide.OkHttpGlideModule");
        }
    }

    /* renamed from: a */
    public void mo12390a(Context context, GlideBuilder fVar) {
        this.f4144a.mo12390a(context, fVar);
    }

    /* renamed from: a */
    public void mo12389a(Context context, Glide eVar, Registry registry) {
        this.f4144a.mo12389a(context, eVar, registry);
    }

    /* renamed from: c */
    public boolean mo12391c() {
        return this.f4144a.mo12391c();
    }

    /* renamed from: a */
    public Set<Class<?>> mo12360a() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public GeneratedRequestManagerFactory mo12361b() {
        return new GeneratedRequestManagerFactory();
    }
}
