package com.jiayouya.travel.module.p276me.p279ui.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p244b.GloblaEx;
import com.jiayouya.travel.databinding.PopSortBinding;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\fJ\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002RA\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/module/me/ui/dialog/SortPopWindow;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "type", "text", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "getAction", "()Lkotlin/jvm/functions/Function2;", "b", "Lcom/jiayouya/travel/databinding/PopSortBinding;", "kotlin.jvm.PlatformType", "onItemClick", "tv", "Landroid/view/View;", "setupClick", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.me.ui.dialog.h */
public final class SortPopWindow extends PopupWindow {
    /* renamed from: a */
    private final PopSortBinding f11680a;
    /* renamed from: b */
    private final C8258m<String, String, Unit> f11681b;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SortPopWindow.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.h$a */
    static final class C3223a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SortPopWindow this$0;

        C3223a(SortPopWindow hVar) {
            this.this$0 = hVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "v");
            this.this$0.m14170a("day", view);
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: SortPopWindow.kt */
    /* renamed from: com.jiayouya.travel.module.me.ui.dialog.h$b */
    static final class C3224b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ SortPopWindow this$0;

        C3224b(SortPopWindow hVar) {
            this.this$0 = hVar;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "v");
            this.this$0.m14170a("month", view);
        }
    }

    public SortPopWindow(Context context, C8258m<? super String, ? super String, Unit> mVar) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(mVar, "action");
        super(context);
        this.f11681b = mVar;
        this.f11680a = (PopSortBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.pop_sort, null, false);
        setWidth(-2);
        setHeight(-2);
        PopSortBinding popSortBinding = this.f11680a;
        C8271i.m35382a((Object) popSortBinding, "b");
        setContentView(popSortBinding.getRoot());
        setBackgroundDrawable(new ColorDrawable(GloblaEx.m12811a(17170445)));
        setOutsideTouchable(true);
        m14168a();
    }

    /* renamed from: a */
    private final void m14168a() {
        TextView textView = this.f11680a.f11208a;
        C8271i.m35382a((Object) textView, "b.tvPersons");
        ezy.p642a.View.m34750a(textView, 0, new C3223a(this), 1, null);
        TextView textView2 = this.f11680a.f11209b;
        C8271i.m35382a((Object) textView2, "b.tvTime");
        ezy.p642a.View.m34750a(textView2, 0, new C3224b(this), 1, null);
    }

    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final void m14170a(String str, View view) {
        C8258m<String, String, Unit> mVar = this.f11681b;
        if (view != null) {
            mVar.invoke(str, ezy.p642a.TextView.m34747a((TextView) view));
            dismiss();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
}
