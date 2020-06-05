package com.jiayouya.travel.module.common.p257a;

import com.jiayouya.travel.module.common.data.LaunchConfig;
import com.jiayouya.travel.module.common.data.SystemNotice;
import java.util.List;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0003H'¨\u0006\u0010"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/api/CommonService;", "", "appConfig", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/common/data/LaunchConfig;", "checkServer", "Lcom/jiayouya/travel/module/common/data/ServerStatus;", "sms", "Lokhttp3/ResponseBody;", "scene", "", "phone", "", "systemNotice", "", "Lcom/jiayouya/travel/module/common/data/SystemNotice;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.a.g */
public interface CommonService {

    @Metadata(mo39187bv = {1, 0, 3}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: CommonService.kt */
    /* renamed from: com.jiayouya.travel.module.common.a.g$a */
    public static final class C2960a {
        /* renamed from: a */
        public static /* synthetic */ Observable m13542a(CommonService gVar, int i, String str, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                return gVar.mo20415a(i, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sms");
        }
    }

    @GET("app/config")
    @Headers({"Domain-Name: staticUrl"})
    /* renamed from: a */
    Observable<LaunchConfig> mo20414a();

    @FormUrlEncoded
    @POST("sms/code")
    /* renamed from: a */
    Observable<C8364ac> mo20415a(@Field("scene") int i, @Field("phone") String str);

    @GET("system/dialog")
    /* renamed from: b */
    Observable<List<SystemNotice>> mo20416b();
}
