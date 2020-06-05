package com.jiayouya.travel.module.common.p257a;

import com.jiayouya.travel.module.common.data.AdRsp;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0002\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\u0006H'¨\u0006\r"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/api/AdService;", "", "event", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "isBak", "", "plat", "", "adLogId", "getId", "Lcom/jiayouya/travel/module/common/data/AdRsp;", "scene", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.a.a */
public interface AdService {
    @GET("ad/getId")
    /* renamed from: a */
    Observable<AdRsp> mo20403a(@Query("scene") int i);

    @FormUrlEncoded
    @POST("ad/event")
    /* renamed from: a */
    Observable<C8364ac> mo20404a(@Field("isBak") int i, @Field("plat") int i2, @Field("event") String str, @Field("adLogId") String str2);
}
