package com.jiayouya.travel.module.answer.p248ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.base.BaseActivity;
import com.jiayouya.travel.common.binding.BindingType;
import com.jiayouya.travel.common.binding.OnItemClickListener;
import com.jiayouya.travel.common.p244b.RoundTextEx;
import com.jiayouya.travel.common.p246d.Router;
import com.jiayouya.travel.databinding.ActivityAnswerBinding;
import com.jiayouya.travel.module.answer.data.AnswerItem;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.jiayouya.travel.module.answer.data.Questions;
import com.jiayouya.travel.module.answer.p249vm.AnswerVM;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import ezy.p653ui.widget.recyclerview.adapter.SingleTypeAdapter;
import ezy.p653ui.widget.round.RoundText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.C8187k;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0002J\"\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u000e2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo39189d2 = {"Lcom/jiayouya/travel/module/answer/ui/AnswerActivity;", "Lcom/jiayouya/travel/common/base/BaseActivity;", "Lcom/jiayouya/travel/databinding/ActivityAnswerBinding;", "Lcom/jiayouya/travel/module/answer/vm/AnswerVM;", "()V", "adapter", "Lezy/ui/widget/recyclerview/adapter/SingleTypeAdapter;", "Lcom/jiayouya/travel/module/answer/data/AnswerItem;", "bindType", "Lcom/jiayouya/travel/common/binding/BindingType;", "kotlin.jvm.PlatformType", "isAnswerAgain", "", "lastIndex", "", "fetchData", "", "isRefresh", "getLayoutId", "isShowErrorOnReqError", "isShowLoadingOnReqStart", "providerViewModelClass", "Ljava/lang/Class;", "restoreAnswer", "setQuestionItem", "index", "item", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "setupClick", "setupObserver", "setupView", "savedInstanceState", "Landroid/os/Bundle;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: AnswerActivity.kt */
/* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity */
public final class AnswerActivity extends BaseActivity<ActivityAnswerBinding, AnswerVM> {
    /* renamed from: c */
    public boolean f11224c;
    /* renamed from: d */
    private final BindingType f11225d = BindingType.create(AnswerItem.class, (int) R.layout.item_answer);
    /* access modifiers changed from: private|final */
    /* renamed from: e */
    public final SingleTypeAdapter<AnswerItem> f11226e = new SingleTypeAdapter<>(this.f11225d);
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f11227f = -1;
    /* renamed from: g */
    private HashMap f11228g;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, mo39189d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$a */
    static final class C2917a implements OnItemClickListener {
        /* renamed from: a */
        final /* synthetic */ AnswerActivity f11229a;

        C2917a(AnswerActivity answerActivity) {
            this.f11229a = answerActivity;
        }

        /* renamed from: a */
        public final void mo19912a(View view, int i, long j) {
            Questions a = AnswerActivity.m13408a(this.f11229a).mo20070a();
            if (a != null) {
                List items = this.f11229a.f11226e.getItems();
                C8271i.m35382a((Object) items, "adapter.items");
                int i2 = 0;
                for (Object next : items) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        C8187k.m35272b();
                    }
                    AnswerItem answerItem = (AnswerItem) next;
                    if (answerItem != null) {
                        boolean z = true;
                        if (a.isSingle()) {
                            if (i2 != i) {
                                z = false;
                            }
                            answerItem.setSelected(z);
                        } else if (i2 == i) {
                            answerItem.setSelected(!answerItem.isSelected());
                        }
                        i2 = i3;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.jiayouya.travel.module.answer.data.AnswerItem");
                    }
                }
                RoundText roundText = (RoundText) this.f11229a.mo19852a(R.id.btn);
                C8271i.m35382a((Object) roundText, "btn");
                RoundTextEx.m12837a(roundText, true, (String) null, (String) null, 6, (Object) null);
                this.f11229a.f11226e.notifyDataSetChanged();
                this.f11229a.m13415q();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$b */
    static final class C2918b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AnswerActivity this$0;

        C2918b(AnswerActivity answerActivity) {
            this.this$0 = answerActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            AnswerActivity answerActivity = this.this$0;
            AnswerActivity.m13411a(answerActivity, answerActivity.f11227f - 1, null, 2, null);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$c */
    static final class C2919c extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ AnswerActivity this$0;

        C2919c(AnswerActivity answerActivity) {
            this.this$0 = answerActivity;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            if (AnswerActivity.m13408a(this.this$0).mo20074b()) {
                AnswerActivity answerActivity = this.this$0;
                AnswerActivity.m13411a(answerActivity, answerActivity.f11227f + 1, null, 2, null);
            } else if (this.this$0.f11224c) {
                ((AnswerVM) this.this$0.mo19853a()).mo20298g();
            } else {
                ((AnswerVM) this.this$0.mo19853a()).mo20296e();
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo39189d2 = {"<anonymous>", "", "it", "", "Lcom/jiayouya/travel/module/answer/data/Questions;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$d */
    static final class C2920d<T> implements Observer<List<? extends Questions>> {
        /* renamed from: a */
        final /* synthetic */ AnswerActivity f11230a;

        C2920d(AnswerActivity answerActivity) {
            this.f11230a = answerActivity;
        }

        /* renamed from: a */
        public final void onChanged(List<Questions> list) {
            this.f11230a.m13409a(0, list);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo39189d2 = {"<anonymous>", "", "it", "Lcom/jiayouya/travel/module/answer/data/AnswerResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: AnswerActivity.kt */
    /* renamed from: com.jiayouya.travel.module.answer.ui.AnswerActivity$e */
    static final class C2921e<T> implements Observer<AnswerResult> {
        /* renamed from: a */
        final /* synthetic */ AnswerActivity f11231a;

        C2921e(AnswerActivity answerActivity) {
            this.f11231a = answerActivity;
        }

        /* renamed from: a */
        public final void onChanged(AnswerResult answerResult) {
            Bundle bundle = new Bundle();
            C8271i.m35382a((Object) answerResult, "it");
            ezy.p642a.Bundle.m34739a(bundle, ArgKey.KEY_RESULT, (Parcelable) answerResult);
            Router.m12969a(Router.f9644a, "/answer/result", bundle, null, 4, null);
            this.f11231a.finish();
        }
    }

    /* renamed from: a */
    public View mo19852a(int i) {
        if (this.f11228g == null) {
            this.f11228g = new HashMap();
        }
        View view = (View) this.f11228g.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f11228g.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* renamed from: f */
    public int mo19863f() {
        return R.layout.activity_answer;
    }

    /* renamed from: h */
    public boolean mo19865h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo19866i() {
        return true;
    }

    /* renamed from: a */
    public static final /* synthetic */ ActivityAnswerBinding m13408a(AnswerActivity answerActivity) {
        return (ActivityAnswerBinding) answerActivity.mo19857b();
    }

    /* renamed from: d */
    public Class<AnswerVM> mo19861d() {
        return AnswerVM.class;
    }

    /* renamed from: a */
    public void mo19854a(Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) mo19852a(R.id.list);
        C8271i.m35382a((Object) recyclerView, "list");
        recyclerView.setAdapter(this.f11226e);
        LinearLayout linearLayout = (LinearLayout) mo19852a(R.id.lyt_container);
        C8271i.m35382a((Object) linearLayout, "lyt_container");
        setupStatusView(linearLayout);
        BaseActivity.m12847a(this, false, 1, null);
    }

    /* renamed from: b */
    public void mo19858b(boolean z) {
        if (this.f11224c) {
            ((AnswerVM) mo19853a()).mo20297f();
        } else {
            ((AnswerVM) mo19853a()).mo20295d();
        }
    }

    /* renamed from: g */
    public void mo19864g() {
        super.mo19864g();
        LifecycleOwner lifecycleOwner = this;
        ((AnswerVM) mo19853a()).mo20293b().observe(lifecycleOwner, new C2920d(this));
        ((AnswerVM) mo19853a()).mo20294c().observe(lifecycleOwner, new C2921e(this));
    }

    /* renamed from: k */
    public void mo19868k() {
        this.f11225d.setOnItemClick(new C2917a(this));
        TextView textView = (TextView) mo19852a(R.id.btn_pre);
        C8271i.m35382a((Object) textView, "btn_pre");
        ezy.p642a.View.m34750a(textView, 0, new C2918b(this), 1, null);
        RoundText roundText = (RoundText) mo19852a(R.id.btn);
        C8271i.m35382a((Object) roundText, "btn");
        ezy.p642a.View.m34750a(roundText, 0, new C2919c(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: q */
    public final void m13415q() {
        List list = (List) ((AnswerVM) mo19853a()).mo20293b().getValue();
        if (list != null) {
            C8271i.m35382a((Object) list, "vm.questionsData.value ?: return");
            Questions questions = (Questions) list.get(this.f11227f);
            List items = this.f11226e.getItems();
            C8271i.m35382a((Object) items, "adapter.items");
            questions.setAnswers(items);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m13411a(AnswerActivity answerActivity, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        answerActivity.m13409a(i, list);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m13409a(int i, List<Questions> list) {
        if (list == null) {
            list = (List) ((AnswerVM) mo19853a()).mo20293b().getValue();
        }
        if (list != null) {
            String str = "btn";
            if (list.isEmpty()) {
                RoundText roundText = (RoundText) mo19852a(R.id.btn);
                C8271i.m35382a((Object) roundText, str);
                RoundTextEx.m12837a(roundText, false, (String) null, (String) null, 6, (Object) null);
                return;
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("每日答题");
                sb.append(i + 1);
                sb.append('/');
                sb.append(list.size());
                supportActionBar.setTitle((CharSequence) sb.toString());
            }
            this.f11227f = i;
            ((ActivityAnswerBinding) mo19857b()).mo20071a((Questions) list.get(i));
            this.f11226e.setItems(((Questions) list.get(i)).getAnswers());
            this.f11226e.notifyDataSetChanged();
            ((ActivityAnswerBinding) mo19857b()).mo20073b(i < list.size() - 1);
            ((ActivityAnswerBinding) mo19857b()).mo20072a(i > 0);
            Questions a = ((ActivityAnswerBinding) mo19857b()).mo20070a();
            if (a != null) {
                RoundText roundText2 = (RoundText) mo19852a(R.id.btn);
                C8271i.m35382a((Object) roundText2, str);
                Iterator it = a.getAnswers().iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (((AnswerItem) it.next()).isSelected()) {
                        break;
                    } else {
                        i2++;
                    }
                }
                RoundTextEx.m12837a(roundText2, i2 != -1, (String) null, (String) null, 6, (Object) null);
            }
        }
    }
}
