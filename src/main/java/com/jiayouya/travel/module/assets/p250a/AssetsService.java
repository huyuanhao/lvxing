package com.jiayouya.travel.module.assets.p250a;

import com.jiayouya.travel.module.assets.data.CashApplyRsp;
import com.jiayouya.travel.module.assets.data.CashConfig;
import com.jiayouya.travel.module.assets.data.LogsItem;
import ezy.app.data.DataPage;
import kotlin.Metadata;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u001e\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00032\b\b\u0001\u0010\b\u001a\u00020\tH'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\tH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00032\b\b\u0001\u0010\u0011\u001a\u00020\tH'J\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00032\b\b\u0001\u0010\b\u001a\u00020\tH'J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0015\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\tH'J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\u0015\u001a\u00020\tH'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H'¨\u0006\u0019"}, mo39189d2 = {"Lcom/jiayouya/travel/module/assets/api/AssetsService;", "", "balance", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/assets/data/BalanceResp;", "balanceLogs", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/assets/data/LogsItem;", "page", "", "cashApply", "Lcom/jiayouya/travel/module/assets/data/CashApplyRsp;", "channel", "amount", "cashConfig", "Lcom/jiayouya/travel/module/assets/data/CashConfig;", "cashLogs", "next", "chargeLogs", "chargePay", "Lcom/jiayouya/travel/module/common/data/PayResp;", "method", "recharge", "rechargeConfig", "Lcom/jiayouya/travel/module/assets/data/RechargeConfig;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.assets.a.a */
public interface AssetsService {
    @GET("balance/cash")
    /* renamed from: a */
    Observable<CashConfig> mo20303a();

    @GET("cash/logs")
    /* renamed from: a */
    Observable<DataPage<LogsItem>> mo20304a(@Query("next") String str);

    @FormUrlEncoded
    @POST("balance/cash")
    /* renamed from: a */
    Observable<CashApplyRsp> mo20305a(@Field("channel") String str, @Field("amount") String str2);
}
