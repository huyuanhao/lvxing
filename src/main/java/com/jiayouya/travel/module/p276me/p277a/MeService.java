package com.jiayouya.travel.module.p276me.p277a;

import com.jiayouya.travel.module.p276me.data.BonusDetailRsp;
import com.jiayouya.travel.module.p276me.data.ClaimSuperDog;
import com.jiayouya.travel.module.p276me.data.DogAnalysisRsp;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.data.MeItem;
import com.jiayouya.travel.module.p276me.data.NoticeItem;
import com.jiayouya.travel.module.p276me.data.VoiceStatus;
import com.jiayouya.travel.module.travel.data.TodayPorfitLogsItem;
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

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u001e\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00032\b\b\u0001\u0010\b\u001a\u00020\tH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H'J\u001e\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u0013H'J\u001e\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00060\u00032\b\b\u0001\u0010\b\u001a\u00020\tH'J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u001b\u001a\u00020\tH'J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0003H'¨\u0006\u001e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/api/MeService;", "", "bonusDetail", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/me/data/BonusDetailRsp;", "bonusLogs", "Lezy/app/data/DataPage;", "Lcom/jiayouya/travel/module/travel/data/TodayPorfitLogsItem;", "next", "", "claimSuperDog", "Lcom/jiayouya/travel/module/me/data/ClaimSuperDog;", "dogAnalysis", "Lcom/jiayouya/travel/module/me/data/DogAnalysisRsp;", "dogProgress", "Lcom/jiayouya/travel/module/me/data/DogProgressRsp;", "editVoice", "Lokhttp3/ResponseBody;", "status", "", "menus", "", "Lcom/jiayouya/travel/module/me/data/MeItem;", "type", "msg", "Lcom/jiayouya/travel/module/me/data/NoticeItem;", "readMsg", "id", "voice", "Lcom/jiayouya/travel/module/me/data/VoiceStatus;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.a.a */
public interface MeService {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: MeService.kt */
    /* renamed from: com.jiayouya.travel.module.me.a.a$a */
    public static final class C3108a {
        /* renamed from: a */
        public static /* synthetic */ Observable m13924a(MeService aVar, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return aVar.mo21206a(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menus");
        }
    }

    @GET("score/dog")
    /* renamed from: a */
    Observable<DogProgressRsp> mo21205a();

    @GET("app/menus")
    /* renamed from: a */
    Observable<List<MeItem>> mo21206a(@Query("type") int i);

    @GET("app/msg")
    /* renamed from: a */
    Observable<DataPage<NoticeItem>> mo21207a(@Query("next") String str);

    @GET("score/analysis")
    /* renamed from: b */
    Observable<DogAnalysisRsp> mo21208b();

    @FormUrlEncoded
    @POST("game/voice")
    /* renamed from: b */
    Observable<C8364ac> mo21209b(@Field("status") int i);

    @GET("v2/bonus/log")
    /* renamed from: b */
    Observable<DataPage<TodayPorfitLogsItem>> mo21210b(@Query("next") String str);

    @GET("v2/bonus/detail")
    /* renamed from: c */
    Observable<BonusDetailRsp> mo21211c();

    @GET("game/voice")
    /* renamed from: d */
    Observable<VoiceStatus> mo21212d();

    @POST("score/superDog")
    /* renamed from: e */
    Observable<ClaimSuperDog> mo21213e();
}
