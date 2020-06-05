package com.jiayouya.travel.module.answer.p247a;

import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.jiayouya.travel.module.answer.data.Questions;
import java.util.List;
import kotlin.Metadata;
import p655io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003H'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003H'¨\u0006\f"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/api/AnswerService;", "", "answer", "Lio/reactivex/Observable;", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "data", "", "answerAgain", "error", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "questions", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerApi.kt */
/* renamed from: com.jiayouya.travel.module.answer.a.b */
public interface C2916b {
    @GET("questions")
    /* renamed from: a */
    Observable<List<Questions>> mo20209a();

    @FormUrlEncoded
    @POST("answer")
    /* renamed from: a */
    Observable<AnswerResult> mo20210a(@Field("data") String str);

    @GET("questions/error")
    /* renamed from: b */
    Observable<List<Questions>> mo20211b();

    @FormUrlEncoded
    @POST("answer/again")
    /* renamed from: b */
    Observable<AnswerResult> mo20212b(@Field("data") String str);
}
