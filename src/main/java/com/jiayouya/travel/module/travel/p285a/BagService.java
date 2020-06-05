package com.jiayouya.travel.module.travel.p285a;

import com.jiayouya.travel.module.travel.data.BagInfo;
import com.jiayouya.travel.module.travel.data.ExpandBag;
import com.jiayouya.travel.module.travel.data.ExpandPrice;
import com.jiayouya.travel.module.travel.data.PositionItem;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/api/BagService;", "", "dogIn", "Lio/reactivex/Observable;", "Lokhttp3/ResponseBody;", "positionId", "", "dogOut", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "dogId", "expand", "Lcom/jiayouya/travel/module/travel/data/ExpandBag;", "expandPrice", "Lcom/jiayouya/travel/module/travel/data/ExpandPrice;", "info", "Lcom/jiayouya/travel/module/travel/data/BagInfo;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.a.a */
public interface BagService {
    @GET("bag/info")
    /* renamed from: a */
    Observable<BagInfo> mo21618a();

    @FormUrlEncoded
    @POST("bag/dogIn")
    /* renamed from: a */
    Observable<C8364ac> mo21619a(@Field("positionId") int i);

    @GET("expand/price")
    /* renamed from: b */
    Observable<ExpandPrice> mo21620b();

    @FormUrlEncoded
    @POST("bag/dogOut")
    /* renamed from: b */
    Observable<PositionItem> mo21621b(@Field("dogId") int i);

    @POST("expand")
    /* renamed from: c */
    Observable<ExpandBag> mo21622c();
}
