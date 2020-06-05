package com.jiayouya.travel.module.auth.p254a;

import com.jiayouya.travel.module.auth.data.AuthCode;
import kotlin.Metadata;
import p655io.reactivex.Observable;
import retrofit2.http.GET;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/auth/api/ChannelAuthService;", "", "code", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/auth/data/AuthCode;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.auth.a.a */
public interface ChannelAuthService {
    @GET("auth/code")
    /* renamed from: a */
    Observable<AuthCode> mo20388a();
}
