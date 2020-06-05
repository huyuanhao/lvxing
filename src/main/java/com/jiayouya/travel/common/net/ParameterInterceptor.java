package com.jiayouya.travel.common.net;

import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import com.tencent.p605ep.commonbase.software.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8362ab;
import okhttp3.C8506t.C8507a;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8518z.C8519a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo39189d2 = {"Lcom/jiayouya/travel/common/net/ParameterInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.net.a */
public final class ParameterInterceptor implements C8508u {
    public C8362ab intercept(C8509a aVar) {
        C8271i.m35386b(aVar, "chain");
        C8519a e = aVar.mo40246a().mo40650e();
        User user = (User) ResidentMemoryModel.f11323a.mo20737b().getValue();
        if (user != null) {
            String uid = user.getUid();
            if (uid != null) {
                C8507a q = aVar.mo40246a().mo40645a().mo40568q();
                q.mo40573a(AppEntity.KEY_UID, uid);
                e.mo40660a(q.mo40580c());
            }
        }
        C8362ab a = aVar.mo40244a(e.mo40663b());
        C8271i.m35382a((Object) a, "chain.proceed(build.build())");
        return a;
    }
}
