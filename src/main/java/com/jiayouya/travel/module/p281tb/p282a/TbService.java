package com.jiayouya.travel.module.p281tb.p282a;

import com.jiayouya.travel.module.p281tb.data.SearchHistory;
import java.util.List;
import kotlin.Metadata;
import okhttp3.C8364ac;
import p655io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0003H'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\fH'¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/tb/api/TbService;", "", "auth", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/tb/data/TbAuth;", "searchDelete", "Lokhttp3/ResponseBody;", "searchGoods", "searchHistory", "Lcom/jiayouya/travel/module/tb/data/SearchHistory;", "searchHot", "", "", "searchKeywords", "keywords", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.tb.a.a */
public interface TbService {
    @GET("search/history")
    @Headers({"mock:http://apidoc.qianmishenghuo.com/mock/48/search/history"})
    /* renamed from: a */
    Observable<SearchHistory> mo21522a();

    @GET("search/keywords")
    @Headers({"mock:http://apidoc.qianmishenghuo.com/mock/48/search/keywords"})
    /* renamed from: a */
    Observable<List<String>> mo21523a(@Query("keywords") String str);

    @POST("search/delete")
    /* renamed from: b */
    Observable<C8364ac> mo21524b();
}
