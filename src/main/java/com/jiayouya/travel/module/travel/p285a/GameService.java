package com.jiayouya.travel.module.travel.p285a;

import com.jiayouya.travel.module.travel.data.BuyDogRsp;
import com.jiayouya.travel.module.travel.data.ClaimFreeCoinRsp;
import com.jiayouya.travel.module.travel.data.CoinRankListItem;
import com.jiayouya.travel.module.travel.data.DogHomeRsp;
import com.jiayouya.travel.module.travel.data.DogInfo;
import com.jiayouya.travel.module.travel.data.DogRankListItem;
import com.jiayouya.travel.module.travel.data.DogShopItem;
import com.jiayouya.travel.module.travel.data.GameIndex;
import com.jiayouya.travel.module.travel.data.HandbookItem;
import com.jiayouya.travel.module.travel.data.IndexPop;
import com.jiayouya.travel.module.travel.data.LoversMerge;
import com.jiayouya.travel.module.travel.data.LuckDrawRsp;
import com.jiayouya.travel.module.travel.data.LuckPoolRsp;
import com.jiayouya.travel.module.travel.data.MergeDialItem;
import com.jiayouya.travel.module.travel.data.MergeDogRsp;
import com.jiayouya.travel.module.travel.data.MergeSuper;
import com.jiayouya.travel.module.travel.data.OpenHbRsp;
import com.jiayouya.travel.module.travel.data.PositionItem;
import com.jiayouya.travel.module.travel.data.ProfitRankListItem;
import com.jiayouya.travel.module.travel.data.RecycleDogRsp;
import com.jiayouya.travel.module.travel.data.ShareInfo;
import com.jiayouya.travel.module.travel.data.ShareSuccess;
import com.jiayouya.travel.module.travel.data.UpgradeHb;
import ezy.app.data.DataPage;
import java.util.List;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bH'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003H'J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0003H'J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0003H'J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u0006H'J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0003H'J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0003H'J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u0006H'J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00170\u0003H'J@\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020\u00062\b\b\u0001\u0010+\u001a\u00020\u0006H'J(\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u00170\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u0006H'J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00032\b\b\u0001\u00100\u001a\u00020\bH'J\u001e\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020\u00032\b\b\u0001\u00104\u001a\u00020\bH'J\u001e\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000206020\u00032\b\b\u0001\u00104\u001a\u00020\bH'J\u001e\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020\u00032\b\b\u0001\u00104\u001a\u00020\bH'J\u001e\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209020\u00032\b\b\u0001\u00104\u001a\u00020\bH'J\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010<\u001a\u00020\u0006H'J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u0003H'J\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00032\b\b\u0001\u0010A\u001a\u00020\bH'J\u0014\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0\u00170\u0003H'J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0003H'J\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010F\u001a\u00020\u0006H'¨\u0006G"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/api/GameService;", "", "bug", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/travel/data/BuyDogRsp;", "dogId", "", "positions", "", "claimFreeCoin", "Lcom/jiayouya/travel/module/travel/data/ClaimFreeCoinRsp;", "claimReward", "Lokhttp3/ResponseBody;", "id", "coin", "Lcom/jiayouya/travel/module/travel/data/CoinRsp;", "dogHome", "Lcom/jiayouya/travel/module/travel/data/DogHomeRsp;", "dogInfo", "Lcom/jiayouya/travel/module/travel/data/DogInfo;", "gameIndex", "Lcom/jiayouya/travel/module/travel/data/GameIndex;", "handbook", "", "Lcom/jiayouya/travel/module/travel/data/HandbookItem;", "indexPop", "Lcom/jiayouya/travel/module/travel/data/IndexPop;", "loversMerge", "Lcom/jiayouya/travel/module/travel/data/LoversMerge;", "positionId1", "positionId2", "luckDraw", "Lcom/jiayouya/travel/module/travel/data/LuckDrawRsp;", "luckPool", "Lcom/jiayouya/travel/module/travel/data/LuckPoolRsp;", "merge", "Lcom/jiayouya/travel/module/travel/data/MergeDogRsp;", "mergeDial", "Lcom/jiayouya/travel/module/travel/data/MergeDialItem;", "mergeSuper", "Lcom/jiayouya/travel/module/travel/data/MergeSuper;", "positionId3", "positionId4", "positionId5", "move", "Lcom/jiayouya/travel/module/travel/data/PositionItem;", "openHb", "Lcom/jiayouya/travel/module/travel/data/OpenHbRsp;", "hbId", "rank", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/travel/data/DogRankListItem;", "next", "rankCoin", "Lcom/jiayouya/travel/module/travel/data/CoinRankListItem;", "rankDog", "rankProfit", "Lcom/jiayouya/travel/module/travel/data/ProfitRankListItem;", "recycle", "Lcom/jiayouya/travel/module/travel/data/RecycleDogRsp;", "positionId", "shareInfo", "Lcom/jiayouya/travel/module/travel/data/ShareInfo;", "shareSuccess", "Lcom/jiayouya/travel/module/travel/data/ShareSuccess;", "shareLogId", "shop", "Lcom/jiayouya/travel/module/travel/data/DogShopItem;", "upgradeHb", "Lcom/jiayouya/travel/module/travel/data/UpgradeHb;", "walkDogId", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.travel.a.c */
public interface GameService {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: GameService.kt */
    /* renamed from: com.jiayouya.travel.module.travel.a.c$a */
    public static final class C3323a {
        /* renamed from: a */
        public static /* synthetic */ Observable m14442a(GameService cVar, int i, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                return cVar.mo21627a(i, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bug");
        }
    }

    @GET("dog/shop")
    /* renamed from: a */
    Observable<List<DogShopItem>> mo21623a();

    @FormUrlEncoded
    @POST("dog/recycle")
    /* renamed from: a */
    Observable<RecycleDogRsp> mo21624a(@Field("positionId") int i);

    @FormUrlEncoded
    @POST("dog/move")
    /* renamed from: a */
    Observable<List<PositionItem>> mo21625a(@Field("positionId1") int i, @Field("positionId2") int i2);

    @FormUrlEncoded
    @POST("merge/super")
    /* renamed from: a */
    Observable<MergeSuper> mo21626a(@Field("positionId1") int i, @Field("positionId2") int i2, @Field("positionId3") int i3, @Field("positionId4") int i4, @Field("positionId5") int i5);

    @FormUrlEncoded
    @POST("dog/bug")
    /* renamed from: a */
    Observable<BuyDogRsp> mo21627a(@Field("dogId") int i, @Field("positions") String str);

    @FormUrlEncoded
    @POST("dog/hb")
    /* renamed from: a */
    Observable<OpenHbRsp> mo21628a(@Field("hbId") String str);

    @GET("dog/home")
    /* renamed from: b */
    Observable<DogHomeRsp> mo21629b();

    @GET("dog/info")
    /* renamed from: b */
    Observable<DogInfo> mo21630b(@Query("dogId") int i);

    @FormUrlEncoded
    @POST("dog/merge")
    /* renamed from: b */
    Observable<MergeDogRsp> mo21631b(@Field("positionId1") int i, @Field("positionId2") int i2);

    @GET("rank/superDog")
    /* renamed from: b */
    Observable<DataPage<DogRankListItem>> mo21632b(@Query("next") String str);

    @GET("dog/coin")
    /* renamed from: c */
    Observable<GameIndex> mo21633c();

    @FormUrlEncoded
    @POST("dog/walk")
    /* renamed from: c */
    Observable<C8364ac> mo21634c(@Field("walkDogId") int i);

    @FormUrlEncoded
    @POST("dog/lovers")
    /* renamed from: c */
    Observable<LoversMerge> mo21635c(@Field("positionId1") int i, @Field("positionId2") int i2);

    @GET("rank/profit")
    /* renamed from: c */
    Observable<DataPage<ProfitRankListItem>> mo21636c(@Query("next") String str);

    @POST("luck/draw")
    /* renamed from: d */
    Observable<LuckDrawRsp> mo21637d();

    @FormUrlEncoded
    @POST("luck/dog")
    /* renamed from: d */
    Observable<C8364ac> mo21638d(@Field("id") int i);

    @GET("rank/coin")
    /* renamed from: d */
    Observable<DataPage<CoinRankListItem>> mo21639d(@Query("next") String str);

    @GET("luck/pool")
    /* renamed from: e */
    Observable<LuckPoolRsp> mo21640e();

    @FormUrlEncoded
    @POST("share/success")
    /* renamed from: e */
    Observable<ShareSuccess> mo21641e(@Field("shareLogId") String str);

    @POST("free/coin")
    /* renamed from: f */
    Observable<ClaimFreeCoinRsp> mo21642f();

    @GET("index/popup")
    /* renamed from: g */
    Observable<IndexPop> mo21643g();

    @GET("upgrade/hb")
    /* renamed from: h */
    Observable<UpgradeHb> mo21644h();

    @GET("dog/handbook")
    /* renamed from: i */
    Observable<List<HandbookItem>> mo21645i();

    @GET("super/dog")
    /* renamed from: j */
    Observable<List<MergeDialItem>> mo21646j();

    @GET("dog/share")
    /* renamed from: k */
    Observable<ShareInfo> mo21647k();
}
