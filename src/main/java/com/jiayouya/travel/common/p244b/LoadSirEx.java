package com.jiayouya.travel.common.p244b;

import com.jiayouya.travel.common.callback.EmptyCallback;
import com.jiayouya.travel.common.callback.ErrorCallback;
import com.jiayouya.travel.common.callback.LoadingCallback;
import com.kingja.loadsir.core.LoadService;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002¨\u0006\u0005"}, mo39189d2 = {"showEmpty", "", "Lcom/kingja/loadsir/core/LoadService;", "showError", "showLoading", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.e */
public final class LoadSirEx {
    /* renamed from: a */
    public static final void m12821a(LoadService<?> bVar) {
        C8271i.m35386b(bVar, "$this$showError");
        bVar.mo22630a(ErrorCallback.class);
    }

    /* renamed from: b */
    public static final void m12822b(LoadService<?> bVar) {
        C8271i.m35386b(bVar, "$this$showEmpty");
        bVar.mo22630a(EmptyCallback.class);
    }

    /* renamed from: c */
    public static final void m12823c(LoadService<?> bVar) {
        C8271i.m35386b(bVar, "$this$showLoading");
        bVar.mo22630a(LoadingCallback.class);
    }
}
