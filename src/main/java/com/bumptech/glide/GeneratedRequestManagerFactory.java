package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever.C1758a;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.jiayouya.travel.common.glide.GlideRequests;

/* renamed from: com.bumptech.glide.c */
final class GeneratedRequestManagerFactory implements C1758a {
    GeneratedRequestManagerFactory() {
    }

    /* renamed from: a */
    public RequestManager mo12411a(Glide eVar, Lifecycle hVar, RequestManagerTreeNode mVar, Context context) {
        return new GlideRequests(eVar, hVar, mVar, context);
    }
}
