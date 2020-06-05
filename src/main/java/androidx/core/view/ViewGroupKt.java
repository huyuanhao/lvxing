package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;
import kotlin.jvm.p679a.C8258m;
import kotlin.sequences.Sequence;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\n\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\n\u001a\u0017\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\b\u001a5\u0010\u001f\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010 \u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010\"\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\b\u001a5\u0010$\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010%\u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, mo39189d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: ViewGroup.kt */
public final class ViewGroupKt {
    public static final View get(ViewGroup viewGroup, int i) {
        C8271i.m35386b(viewGroup, "$this$get");
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index: ");
        sb.append(i);
        sb.append(", Size: ");
        sb.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        C8271i.m35386b(viewGroup, "$this$contains");
        C8271i.m35386b(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        C8271i.m35386b(viewGroup, "$this$plusAssign");
        C8271i.m35386b(view, "view");
        viewGroup.addView(view);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        C8271i.m35386b(viewGroup, "$this$minusAssign");
        C8271i.m35386b(view, "view");
        viewGroup.removeView(view);
    }

    public static final int getSize(ViewGroup viewGroup) {
        C8271i.m35386b(viewGroup, "$this$size");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        C8271i.m35386b(viewGroup, "$this$isEmpty");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        C8271i.m35386b(viewGroup, "$this$isNotEmpty");
        return viewGroup.getChildCount() != 0;
    }

    public static final void forEach(ViewGroup viewGroup, C8247b<? super View, Unit> bVar) {
        C8271i.m35386b(viewGroup, "$this$forEach");
        C8271i.m35386b(bVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            C8271i.m35382a((Object) childAt, "getChildAt(index)");
            bVar.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, C8258m<? super Integer, ? super View, Unit> mVar) {
        C8271i.m35386b(viewGroup, "$this$forEachIndexed");
        C8271i.m35386b(mVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Integer valueOf = Integer.valueOf(i);
            View childAt = viewGroup.getChildAt(i);
            C8271i.m35382a((Object) childAt, "getChildAt(index)");
            mVar.invoke(valueOf, childAt);
        }
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        C8271i.m35386b(viewGroup, "$this$iterator");
        return new ViewGroupKt$iterator$1<>(viewGroup);
    }

    public static final Sequence<View> getChildren(ViewGroup viewGroup) {
        C8271i.m35386b(viewGroup, "$this$children");
        return new ViewGroupKt$children$1<>(viewGroup);
    }

    public static final void setMargins(MarginLayoutParams marginLayoutParams, int i) {
        C8271i.m35386b(marginLayoutParams, "$this$setMargins");
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static /* synthetic */ void updateMargins$default(MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.rightMargin;
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C8271i.m35386b(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static final void updateMargins(MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        C8271i.m35386b(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i, i2, i3, i4);
    }

    public static /* synthetic */ void updateMarginsRelative$default(MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i5 & 2) != 0) {
            i2 = marginLayoutParams.topMargin;
        }
        if ((i5 & 4) != 0) {
            i3 = marginLayoutParams.getMarginEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = marginLayoutParams.bottomMargin;
        }
        C8271i.m35386b(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }

    public static final void updateMarginsRelative(MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        C8271i.m35386b(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.setMarginEnd(i3);
        marginLayoutParams.bottomMargin = i4;
    }
}
