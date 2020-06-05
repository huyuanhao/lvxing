package com.jiayouya.travel.module.group.p267a;

import com.jiayouya.travel.module.assets.data.LogsItem;
import com.jiayouya.travel.module.group.data.ClaimCityReward;
import com.jiayouya.travel.module.group.data.GroupIndexRsp;
import com.jiayouya.travel.module.group.data.InviteLogsItem;
import com.jiayouya.travel.module.group.data.TravelCity;
import ezy.app.data.DataPage;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u0007H'J\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H'J\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\n\u001a\u00020\u0007H'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H'¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/group/api/GroupService;", "", "children", "Lio/reactivex/Observable;", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/group/data/InviteLogsItem;", "next", "", "cityReward", "Lcom/jiayouya/travel/module/group/data/ClaimCityReward;", "id", "fans", "index", "Lcom/jiayouya/travel/module/group/data/GroupIndexRsp;", "invalid", "profitLogs", "Lcom/jiayouya/travel/module/assets/data/LogsItem;", "reward", "Lokhttp3/ResponseBody;", "travelCity", "Lcom/jiayouya/travel/module/group/data/TravelCity;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.group.a.a */
public interface GroupService {
    @GET("travel")
    /* renamed from: a */
    Observable<GroupIndexRsp> mo20955a();

    @GET("travel/children")
    /* renamed from: a */
    Observable<DataPage<InviteLogsItem>> mo20956a(@Query("next") String str);

    @GET("travel/city")
    /* renamed from: b */
    Observable<TravelCity> mo20957b();

    @GET("travel/fans")
    /* renamed from: b */
    Observable<DataPage<InviteLogsItem>> mo20958b(@Query("next") String str);

    @GET("travel/invalid")
    /* renamed from: c */
    Observable<DataPage<InviteLogsItem>> mo20959c(@Query("next") String str);

    @FormUrlEncoded
    @POST("travel/reward")
    /* renamed from: d */
    Observable<C8364ac> mo20960d(@Field("id") String str);

    @GET("profit/log")
    /* renamed from: e */
    Observable<DataPage<LogsItem>> mo20961e(@Query("next") String str);

    @FormUrlEncoded
    @POST("city/reward")
    /* renamed from: f */
    Observable<ClaimCityReward> mo20962f(@Field("id") String str);
}
