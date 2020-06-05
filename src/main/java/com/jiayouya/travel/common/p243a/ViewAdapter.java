package com.jiayouya.travel.common.p243a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.databinding.BindingAdapter;
import com.jiayouya.travel.C2835b;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p246d.Router;
import ezy.p642a.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u001fH\u0007J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001fH\u0007J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\rH\u0007J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\rH\u0007J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001fH\u0007J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\rH\u0007J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0015J\u001f\u0010.\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012J\u001f\u00100\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u0015¨\u00062"}, mo39189d2 = {"Lcom/jiayouya/travel/common/adapter/ViewAdapter;", "", "()V", "adaptBackground", "", "view", "Landroid/view/View;", "drawable", "Landroid/graphics/drawable/Drawable;", "adaptClick", "onClickListener", "Landroid/view/View$OnClickListener;", "throttleTime", "", "(Landroid/view/View;Landroid/view/View$OnClickListener;Ljava/lang/Integer;)V", "adaptEnable", "isEnable", "", "(Landroid/view/View;Ljava/lang/Boolean;)V", "adaptHeight", "height", "(Landroid/view/View;Ljava/lang/Integer;)V", "adaptIsGone", "isGone", "adaptIsInvisible", "isInvisible", "adaptLink", "url", "", "adaptMargin", "margin", "", "adaptMarginBottom", "bottom", "adaptMarginEnd", "end", "adaptMarginLeft", "left", "adaptMarginRight", "right", "adaptMarginStart", "start", "adaptMarginTop", "top", "adaptPaddingTop", "paddingTop", "adaptSelected", "isSelected", "adaptWidth", "width", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.a.e */
public final class ViewAdapter {
    /* renamed from: a */
    public static final ViewAdapter f9562a = new ViewAdapter();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ViewAdapter.kt */
    /* renamed from: com.jiayouya.travel.common.a.e$a */
    static final class C2854a extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ OnClickListener $onClickListener;
        final /* synthetic */ View $view;

        C2854a(OnClickListener onClickListener, View view) {
            this.$onClickListener = onClickListener;
            this.$view = view;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            OnClickListener onClickListener = this.$onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.$view);
            }
        }
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39189d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, mo39190k = 3, mo39191mv = {1, 1, 15})
    /* compiled from: ViewAdapter.kt */
    /* renamed from: com.jiayouya.travel.common.a.e$b */
    static final class C2855b extends Lambda implements C8247b<View, Unit> {
        final /* synthetic */ String $url;

        C2855b(String str) {
            this.$url = str;
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((View) obj);
            return Unit.f27778a;
        }

        public final void invoke(View view) {
            C8271i.m35386b(view, "it");
            Router.m12969a(Router.f9644a, this.$url, null, null, 6, null);
        }
    }

    private ViewAdapter() {
    }

    @JvmStatic
    @BindingAdapter({"link"})
    /* renamed from: a */
    public static final void m12794a(View view, String str) {
        C8271i.m35386b(view, "view");
        Object tag = view.getTag(R.id.tag_link);
        if (str != null && !C8271i.m35384a((Object) str, tag)) {
            view.setTag(R.id.tag_link, str);
            ezy.p642a.View.m34750a(view, 0, new C2855b(str), 1, null);
        }
    }

    @JvmStatic
    @BindingAdapter(requireAll = false, value = {"android:onClick", "throttleTime"})
    /* renamed from: a */
    public static final void m12792a(View view, OnClickListener onClickListener, Integer num) {
        C8271i.m35386b(view, "view");
        ezy.p642a.View.m34749a(view, (long) (num != null ? num.intValue() : 1000), new C2854a(onClickListener, view));
    }

    @JvmStatic
    @BindingAdapter({"isEnable"})
    /* renamed from: a */
    public static final void m12793a(View view, Boolean bool) {
        C8271i.m35386b(view, "view");
        if (bool != null) {
            view.setEnabled(bool.booleanValue());
        }
    }

    @JvmStatic
    @BindingAdapter({"isSelected"})
    /* renamed from: b */
    public static final void m12796b(View view, Boolean bool) {
        C8271i.m35386b(view, "view");
        if (bool != null) {
            view.setSelected(bool.booleanValue());
        }
    }

    @JvmStatic
    @BindingAdapter({"isGone"})
    /* renamed from: c */
    public static final void m12798c(View view, Boolean bool) {
        C8271i.m35386b(view, "view");
        int i = (bool == null || C8271i.m35384a((Object) bool, (Object) Boolean.valueOf(true))) ? 8 : 0;
        view.setVisibility(i);
    }

    @JvmStatic
    @BindingAdapter({"isInvisible"})
    /* renamed from: d */
    public static final void m12799d(View view, Boolean bool) {
        C8271i.m35386b(view, "view");
        int i = (bool == null || C8271i.m35384a((Object) bool, (Object) Boolean.valueOf(true))) ? 4 : 0;
        view.setVisibility(i);
    }

    @JvmStatic
    @BindingAdapter({"android:layout_marginTop"})
    /* renamed from: a */
    public static final void m12790a(View view, int i) {
        C8271i.m35386b(view, "view");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).topMargin = Context.m34741a(C2835b.f9544a, (float) i);
        }
    }

    @JvmStatic
    @BindingAdapter({"android:layout_marginBottom"})
    /* renamed from: a */
    public static final void m12789a(View view, float f) {
        C8271i.m35386b(view, "view");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = Context.m34741a(C2835b.f9544a, f);
        }
    }

    @JvmStatic
    @BindingAdapter({"android:layout_marginStart"})
    /* renamed from: b */
    public static final void m12795b(View view, float f) {
        C8271i.m35386b(view, "view");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMarginStart(Context.m34741a(C2835b.f9544a, f));
        }
    }

    @JvmStatic
    @BindingAdapter({"android:layout_marginEnd"})
    /* renamed from: c */
    public static final void m12797c(View view, float f) {
        C8271i.m35386b(view, "view");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMarginEnd(Context.m34741a(C2835b.f9544a, f));
        }
    }

    @JvmStatic
    @BindingAdapter({"android:background"})
    /* renamed from: a */
    public static final void m12791a(View view, Drawable drawable) {
        C8271i.m35386b(view, "view");
        if (drawable != null) {
            view.setBackground(drawable);
        }
    }
}
