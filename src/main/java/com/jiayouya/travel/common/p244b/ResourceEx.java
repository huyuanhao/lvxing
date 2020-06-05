package com.jiayouya.travel.common.p244b;

import com.jiayouya.travel.module.common.data.Resource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¨\u0006\b"}, mo39189d2 = {"action", "", "T", "Lcom/jiayouya/travel/module/common/data/Resource;", "onSuccess", "Lkotlin/Function0;", "onFail", "onLoading", "app_grRelease"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.b.h */
public final class ResourceEx {
    /* renamed from: a */
    public static /* synthetic */ void m12833a(Resource resource, C8246a aVar, C8246a aVar2, C8246a aVar3, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar2 = null;
        }
        if ((i & 4) != 0) {
            aVar3 = null;
        }
        m12832a(resource, aVar, aVar2, aVar3);
    }

    /* renamed from: a */
    public static final <T> void m12832a(Resource<T> resource, C8246a<Unit> aVar, C8246a<Unit> aVar2, C8246a<Unit> aVar3) {
        C8271i.m35386b(resource, "$this$action");
        C8271i.m35386b(aVar, "onSuccess");
        int status = resource.getStatus();
        if (status == 0) {
            aVar.invoke();
        } else if (status != 1) {
            if (status == 2 && aVar3 != null) {
                Unit jVar = (Unit) aVar3.invoke();
            }
        } else if (aVar2 != null) {
            Unit jVar2 = (Unit) aVar2.invoke();
        }
    }
}
