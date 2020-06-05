package com.jiayouya.travel.module.common.p257a;

import com.jiayouya.travel.module.common.data.CertifiedStatusRsp;
import com.jiayouya.travel.module.common.data.CheckPhoneRsp;
import com.jiayouya.travel.module.common.data.ContactRsp;
import com.jiayouya.travel.module.common.data.InviteConfirm;
import com.jiayouya.travel.module.common.data.InviteDataRsp;
import com.jiayouya.travel.module.common.data.ParentRsp;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.common.data.UserPrivacyRsp;
import kotlin.Metadata;
import okhttp3.C8358aa;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u0005H'J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\t\u001a\u00020\bH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'J\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\bH'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\bH'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0017\u001a\u00020\bH'J\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\t\u001a\u00020\bH'J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H'J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u001c\u001a\u00020\bH'J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0003H'J\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020!2\b\b\u0001\u0010\"\u001a\u00020!H'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0017\u001a\u00020\bH'J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H'¨\u0006%"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/api/UserService;", "", "avatar", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "bindPhone", "phone", "", "code", "certified", "Lcom/jiayouya/travel/module/common/data/CertifiedStatusRsp;", "checkPhone", "Lcom/jiayouya/travel/module/common/data/CheckPhoneRsp;", "contact", "Lcom/jiayouya/travel/module/common/data/ContactRsp;", "wx", "qq", "editPhone", "credential", "info", "Lcom/jiayouya/travel/module/common/data/User;", "infoByCode", "inviteCode", "inviteConfirm", "Lcom/jiayouya/travel/module/common/data/InviteConfirm;", "inviteData", "Lcom/jiayouya/travel/module/common/data/InviteDataRsp;", "nickname", "parent", "Lcom/jiayouya/travel/module/common/data/ParentRsp;", "privacy", "Lcom/jiayouya/travel/module/common/data/UserPrivacyRsp;", "", "children", "saveParent", "starParent", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.a.i */
public interface UserService {
    @GET("auth/me")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: a */
    Observable<User> mo20417a();

    @FormUrlEncoded
    @POST("user/privacy")
    /* renamed from: a */
    Observable<C8364ac> mo20418a(@Field("parent") int i, @Field("children") int i2);

    @FormUrlEncoded
    @POST("users/checkPhone")
    /* renamed from: a */
    Observable<CheckPhoneRsp> mo20419a(@Field("code") String str);

    @FormUrlEncoded
    @POST("users/bindPhone")
    /* renamed from: a */
    Observable<C8364ac> mo20420a(@Field("phone") String str, @Field("code") String str2);

    @FormUrlEncoded
    @POST("users/editPhone")
    /* renamed from: a */
    Observable<C8364ac> mo20421a(@Field("phone") String str, @Field("code") String str2, @Field("credential") String str3);

    @POST("users/avatar")
    @Multipart
    /* renamed from: a */
    Observable<C8364ac> mo20422a(@Part("avatar\";filename=\"avatar.jpeg") C8358aa aaVar);

    @GET("invite/data")
    /* renamed from: b */
    Observable<InviteDataRsp> mo20423b();

    @FormUrlEncoded
    @POST("users/nickname")
    /* renamed from: b */
    Observable<C8364ac> mo20424b(@Field("nickname") String str);

    @FormUrlEncoded
    @POST("user/contact")
    /* renamed from: b */
    Observable<C8364ac> mo20425b(@Field("wx") String str, @Field("qq") String str2);

    @GET("my/parent")
    /* renamed from: c */
    Observable<ParentRsp> mo20426c();

    @GET("info/code")
    /* renamed from: c */
    Observable<User> mo20427c(@Query("inviteCode") String str);

    @GET("my/starParent")
    /* renamed from: d */
    Observable<ParentRsp> mo20428d();

    @FormUrlEncoded
    @POST("save/parent")
    /* renamed from: d */
    Observable<ParentRsp> mo20429d(@Field("inviteCode") String str);

    @GET("user/contact")
    /* renamed from: e */
    Observable<ContactRsp> mo20430e();

    @FormUrlEncoded
    @POST("invite/confirm")
    /* renamed from: e */
    Observable<InviteConfirm> mo20431e(@Field("code") String str);

    @GET("user/privacy")
    /* renamed from: f */
    Observable<UserPrivacyRsp> mo20432f();

    @GET("user/certified")
    /* renamed from: g */
    Observable<CertifiedStatusRsp> mo20433g();
}
