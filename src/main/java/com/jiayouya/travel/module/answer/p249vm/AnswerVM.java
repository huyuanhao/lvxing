package com.jiayouya.travel.module.answer.p249vm;

import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.jiayouya.travel.common.base.BaseViewModel;
import com.jiayouya.travel.common.p244b.ObservableEx;
import com.jiayouya.travel.module.answer.data.AnswerItem;
import com.jiayouya.travel.module.answer.data.AnswerReq;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.jiayouya.travel.module.answer.data.Questions;
import com.jiayouya.travel.module.answer.p247a.AnswerApi;
import ezy.app.p643a.API;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import p655io.reactivex.p664d.Consumer;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/vm/AnswerVM;", "Lcom/jiayouya/travel/common/base/BaseViewModel;", "()V", "answerData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "getAnswerData", "()Landroidx/lifecycle/MutableLiveData;", "gson", "Lcom/google/gson/Gson;", "questionsData", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "getQuestionsData", "answer", "", "answerAgain", "error", "getAnswer", "", "questions", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerVM.kt */
/* renamed from: com.jiayouya.travel.module.answer.vm.AnswerVM */
public final class AnswerVM extends BaseViewModel {
    /* renamed from: a */
    private final MutableLiveData<List<Questions>> f11238a = new MutableLiveData<>();
    /* renamed from: b */
    private final MutableLiveData<AnswerResult> f11239b = new MutableLiveData<>();
    /* renamed from: c */
    private final Gson f11240c = new Gson();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "kotlin.jvm.PlatformType", "accept", "com/jiayouya/travel/module/answer/vm/AnswerVM$answer$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerVM.kt */
    /* renamed from: com.jiayouya.travel.module.answer.vm.AnswerVM$a */
    static final class C2925a<T> implements Consumer<AnswerResult> {
        /* renamed from: a */
        final /* synthetic */ AnswerVM f11241a;

        C2925a(AnswerVM answerVM) {
            this.f11241a = answerVM;
        }

        /* renamed from: a */
        public final void accept(AnswerResult answerResult) {
            this.f11241a.mo20294c().postValue(answerResult);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "kotlin.jvm.PlatformType", "accept", "com/jiayouya/travel/module/answer/vm/AnswerVM$answerAgain$1$1"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerVM.kt */
    /* renamed from: com.jiayouya.travel.module.answer.vm.AnswerVM$b */
    static final class C2926b<T> implements Consumer<AnswerResult> {
        /* renamed from: a */
        final /* synthetic */ AnswerVM f11242a;

        C2926b(AnswerVM answerVM) {
            this.f11242a = answerVM;
        }

        /* renamed from: a */
        public final void accept(AnswerResult answerResult) {
            this.f11242a.mo20294c().postValue(answerResult);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerVM.kt */
    /* renamed from: com.jiayouya.travel.module.answer.vm.AnswerVM$c */
    static final class C2927c<T> implements Consumer<List<? extends Questions>> {
        /* renamed from: a */
        final /* synthetic */ AnswerVM f11243a;

        C2927c(AnswerVM answerVM) {
            this.f11243a = answerVM;
        }

        /* renamed from: a */
        public final void accept(List<Questions> list) {
            this.f11243a.mo20293b().postValue(list);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "kotlin.jvm.PlatformType", "accept"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerVM.kt */
    /* renamed from: com.jiayouya.travel.module.answer.vm.AnswerVM$d */
    static final class C2928d<T> implements Consumer<List<? extends Questions>> {
        /* renamed from: a */
        final /* synthetic */ AnswerVM f11244a;

        C2928d(AnswerVM answerVM) {
            this.f11244a = answerVM;
        }

        /* renamed from: a */
        public final void accept(List<Questions> list) {
            this.f11244a.mo20293b().postValue(list);
        }
    }

    /* renamed from: b */
    public final MutableLiveData<List<Questions>> mo20293b() {
        return this.f11238a;
    }

    /* renamed from: c */
    public final MutableLiveData<AnswerResult> mo20294c() {
        return this.f11239b;
    }

    /* renamed from: d */
    public final void mo20295d() {
        ObservableEx.m12825b(AnswerApi.m13403a(API.f27251a).mo20209a(), mo19904a()).mo38904c((Consumer<? super T>) new C2928d<Object>(this));
    }

    /* renamed from: e */
    public final void mo20296e() {
        if (((List) this.f11238a.getValue()) != null) {
            ObservableEx.m12824a(AnswerApi.m13403a(API.f27251a).mo20210a(m13435h()), mo19904a()).mo38904c((Consumer<? super T>) new C2925a<Object>(this));
        }
    }

    /* renamed from: f */
    public final void mo20297f() {
        ObservableEx.m12825b(AnswerApi.m13403a(API.f27251a).mo20211b(), mo19904a()).mo38904c((Consumer<? super T>) new C2927c<Object>(this));
    }

    /* renamed from: g */
    public final void mo20298g() {
        if (((List) this.f11238a.getValue()) != null) {
            ObservableEx.m12824a(AnswerApi.m13403a(API.f27251a).mo20212b(m13435h()), mo19904a()).mo38904c((Consumer<? super T>) new C2926b<Object>(this));
        }
    }

    /* renamed from: h */
    private final String m13435h() {
        List arrayList = new ArrayList();
        List<Questions> list = (List) this.f11238a.getValue();
        if (list != null) {
            for (Questions questions : list) {
                AnswerReq answerReq = new AnswerReq(questions.getId(), new ArrayList());
                for (AnswerItem answerItem : questions.getAnswers()) {
                    if (answerItem.isSelected()) {
                        answerReq.getA_ids().add(answerItem.getId());
                    }
                }
                arrayList.add(answerReq);
            }
        }
        String json = this.f11240c.toJson((Object) arrayList);
        C8271i.m35382a((Object) json, "gson.toJson(list)");
        return json;
    }
}
