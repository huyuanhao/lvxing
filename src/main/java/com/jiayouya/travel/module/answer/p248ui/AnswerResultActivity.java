package com.jiayouya.travel.module.answer.p248ui;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.ClickableBindingHolder;
import com.jiayouya.travel.common.binding.OnBindListener;
import com.jiayouya.travel.common.p246d.NumPrefixUtil;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivityAnswerResultBinding;
import com.jiayouya.travel.databinding.ItemAnswerWrongBinding;
import com.jiayouya.travel.module.answer.data.AnswerError;
import com.jiayouya.travel.module.answer.data.AnswerErrorItem;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.jiayouya.travel.module.answer.p249vm.AnswerResultVM;
import com.jiayouya.travel.module.common.p260vm.ResidentMemoryModel;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/ui/AnswerResultActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityAnswerResultBinding;", "Lcom/jiayouya/travel/module/answer/vm/AnswerResultVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/answer/data/AnswerErrorItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "result", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "getLayoutId", "", "providerViewModelClass", "Ljava/lang/Class;", "setupClick", "", "setupListView", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerResultActivity.kt */
/* renamed from: com.jiayouya.travel.module.answer.ui.AnswerResultActivity */
public final class AnswerResultActivity extends BaseActivity<ActivityAnswerResultBinding, AnswerResultVM> {
    /* renamed from: c */
    public AnswerResult f11232c;
    /* renamed from: d */
    private final BindingType f11233d = BindingType.create(AnswerErrorItem.class, (int) R.layout.item_answer_wrong);
    /* renamed from: e */
    private final SingleTypeAdapter<AnswerErrorItem> f11234e = new SingleTypeAdapter<>(this.f11233d);
    /* renamed from: f */
    private HashMap f11235f;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerResultActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerResultActivity$a */
    static final class C2922a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AnswerResultActivity this$0;

        C2922a(AnswerResultActivity answerResultActivity) {
            this.this$0 = answerResultActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Bundle bundle = new Bundle();
            ezy.p642a.Bundle.m34740a(bundle, "isAnswerAgain", true);
            Router.m12969a(Router.f9644a, "/answer/index", bundle, null, 4, null);
            this.this$0.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerResultActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerResultActivity$b */
    static final class C2923b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AnswerResultActivity this$0;

        C2923b(AnswerResultActivity answerResultActivity) {
            this.this$0 = answerResultActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AnswerResult answerResult = this.this$0.f11232c;
            if (answerResult != null) {
                ResidentMemoryModel.f11323a.mo20733a(answerResult.getCoin(), 1);
            }
            this.this$0.finish();
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\b"}, mo39189d2 = {"<anonymous>", "", "holder", "Lcom/jiayouya/travel/common/binding/ClickableBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "kotlin.jvm.PlatformType", "item", "", "onBind"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerResultActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerResultActivity$c */
    static final class C2924c implements OnBindListener {
        /* renamed from: a */
        public static final C2924c f11236a = new C2924c();

        C2924c() {
        }

        /* renamed from: a */
        public final void mo19911a(ClickableBindingHolder<ViewDataBinding> clickableBindingHolder, Object obj) {
            Binding binding = clickableBindingHolder.binding;
            if (binding != null) {
                ItemAnswerWrongBinding itemAnswerWrongBinding = (ItemAnswerWrongBinding) binding;
                if (obj != null) {
                    AnswerErrorItem answerErrorItem = (AnswerErrorItem) obj;
                    SingleTypeAdapter singleTypeAdapter = new SingleTypeAdapter(BindingType.create(String.class, (int) R.layout.item_answer_wrong_sub));
                    RecyclerView recyclerView = itemAnswerWrongBinding.f10898a;
                    C8271i.m35382a((Object) recyclerView, "b.list");
                    recyclerView.setAdapter(singleTypeAdapter);
                    singleTypeAdapter.setItems(answerErrorItem.getAnswer());
                    singleTypeAdapter.notifyDataSetChanged();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.answer.data.AnswerErrorItem");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.databinding.ItemAnswerWrongBinding");
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11235f == null) {
            this.f11235f = new HashMap();
        }
        View view = (View) this.f11235f.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11235f.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_answer_result;
    }

    /* renamed from: d */
    public Class<AnswerResultVM> mo19861d() {
        return AnswerResultVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        m13428q();
        ((ActivityAnswerResultBinding) mo19857b()).mo20075a(this.f11232c);
    }

    /* renamed from: q */
    private final void m13428q() {
        List list;
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11234e);
        AnswerResult answerResult = this.f11232c;
        if (answerResult != null) {
            AnswerError error = answerResult.getError();
            if (error != null) {
                List items = error.getItems();
                if (items != null) {
                    int i = 0;
                    for (Object next : items) {
                        int i2 = i + 1;
                        if (i < 0) {
                            C8187k.m35272b();
                        }
                        AnswerErrorItem answerErrorItem = (AnswerErrorItem) next;
                        StringBuilder sb = new StringBuilder();
                        sb.append(NumPrefixUtil.m12967a(i));
                        sb.append(answerErrorItem.getQuestion());
                        answerErrorItem.setQuestion(sb.toString());
                        i = i2;
                    }
                }
            }
        }
        SingleTypeAdapter<AnswerErrorItem> singleTypeAdapter = this.f11234e;
        AnswerResult answerResult2 = this.f11232c;
        if (answerResult2 != null) {
            AnswerError error2 = answerResult2.getError();
            if (error2 != null) {
                list = error2.getItems();
                singleTypeAdapter.setItems(list);
                this.f11234e.notifyDataSetChanged();
                this.f11233d.setOnItemBind(C2924c.f11236a);
            }
        }
        list = null;
        singleTypeAdapter.setItems(list);
        this.f11234e.notifyDataSetChanged();
        this.f11233d.setOnItemBind(C2924c.f11236a);
    }

    /* renamed from: k */
    public void mo19868k() {
        RoundText roundText = (RoundText) mo19852a(R.id.btn_answer_again);
        C8271i.m35382a((Object) roundText, "btn_answer_again");
        ezy.p642a.View.m34750a(roundText, 0, new C2922a(this), 1, null);
        RoundText roundText2 = (RoundText) mo19852a(R.id.btn_receive);
        C8271i.m35382a((Object) roundText2, "btn_receive");
        ezy.p642a.View.m34750a(roundText2, 0, new C2923b(this), 1, null);
    }
}
