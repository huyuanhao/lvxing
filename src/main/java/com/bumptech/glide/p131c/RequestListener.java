package com.bumptech.glide.p131c;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.p131c.p132a.Target;

/* renamed from: com.bumptech.glide.c.e */
public interface RequestListener<R> {
    /* renamed from: a */
    boolean mo12515a(GlideException glideException, Object obj, Target<R> hVar, boolean z);

    /* renamed from: a */
    boolean mo12516a(R r, Object obj, Target<R> hVar, DataSource dataSource, boolean z);
}
