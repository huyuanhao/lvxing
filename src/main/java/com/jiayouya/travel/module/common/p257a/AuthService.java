package com.jiayouya.travel.module.common.p257a;

import ezy.app.data.Token;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.C8623b;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'¨\u0006\u0012"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/api/AuthService;", "", "login3rd", "Lio/reactivex/Observable;", "Lezy/app/data/Token;", "platform", "", "credential", "loginByPhone", "phone", "code", "logout", "Lokhttp3/ResponseBody;", "refresh", "Lretrofit2/Call;", "refreshToken", "refreshAsync", "smsCode", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.a.e */
public interface AuthService {
    @FormUrlEncoded
    @POST("auth/login3rd")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: a */
    Observable<Token> mo20409a(@Field("platform") String str, @Field("credential") String str2);

    @FormUrlEncoded
    @POST("auth/refresh")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: a */
    C8623b<Token> mo20410a(@Field("refreshToken") String str);

    @FormUrlEncoded
    @POST("auth/refresh")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: b */
    Observable<Token> mo20411b(@Field("refreshToken") String str);

    @FormUrlEncoded
    @POST("auth/phone")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: b */
    Observable<Token> mo20412b(@Field("phone") String str, @Field("code") String str2);

    @FormUrlEncoded
    @POST("login/smsCode")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: c */
    Observable<C8364ac> mo20413c(@Field("phone") String str);
}
