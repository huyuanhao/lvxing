package com.jiayouya.travel.module.explore.p263a;

import com.jiayouya.travel.module.explore.data.DynamicContent;
import com.jiayouya.travel.module.explore.data.ExploreDoor;
import com.jiayouya.travel.module.explore.data.ExploreIndex;
import ezy.app.data.DataPage;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'¨\u0006\u0011"}, mo39189d2 = {"Lcom/jiayouya/travel/module/explore/api/ExploreService;", "", "claimReward", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "type", "", "value", "door", "Lcom/jiayouya/travel/module/explore/data/ExploreDoor;", "dynamic", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/explore/data/DynamicContent;", "next", "index", "Lcom/jiayouya/travel/module/explore/data/ExploreIndex;", "recall", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.explore.a.a */
public interface ExploreService {
    @GET("explore")
    /* renamed from: a */
    Observable<ExploreIndex> mo20816a();

    @GET("explore/dynamic")
    /* renamed from: a */
    Observable<DataPage<DynamicContent>> mo20817a(@Query("next") String str);

    @FormUrlEncoded
    @POST("explore/reward")
    /* renamed from: a */
    Observable<C8364ac> mo20818a(@Field("type") String str, @Field("value") String str2);

    @POST("explore/recall")
    /* renamed from: b */
    Observable<C8364ac> mo20819b();

    @GET("explore/door")
    /* renamed from: c */
    Observable<ExploreDoor> mo20820c();
}
