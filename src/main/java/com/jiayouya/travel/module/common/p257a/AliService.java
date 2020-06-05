package com.jiayouya.travel.module.common.p257a;

import com.jiayouya.travel.module.common.data.AliAuthRsp;
import com.jiayouya.travel.module.common.data.AliUserRsp;
import kotlin.Metadata;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\bH'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/api/AliService;", "", "auth", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/common/data/AliAuthRsp;", "bind", "Lcom/jiayouya/travel/module/common/data/AliUserRsp;", "authCode", "", "check", "Lcom/jiayouya/travel/module/common/data/AliCheckRsp;", "code", "save", "credential", "user", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.a.c */
public interface AliService {
    @GET("alipay/user")
    /* renamed from: a */
    Observable<AliUserRsp> mo20405a();

    @FormUrlEncoded
    @POST("alipay/bind")
    /* renamed from: a */
    Observable<AliUserRsp> mo20406a(@Field("authCode") String str);

    @FormUrlEncoded
    @POST("alipay/edit")
    /* renamed from: a */
    Observable<AliUserRsp> mo20407a(@Field("authCode") String str, @Field("credential") String str2);

    @GET("alipay/auth")
    /* renamed from: b */
    Observable<AliAuthRsp> mo20408b();
}
