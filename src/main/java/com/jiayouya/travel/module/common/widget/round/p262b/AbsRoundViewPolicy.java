package com.jiayouya.travel.module.common.widget.round.p262b;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.jiayouya.travel.common.p244b.GloblaEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/policy/AbsRoundViewPolicy;", "Lcom/jiayouya/travel/module/common/widget/round/policy/IRoundViewPolicy;", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "attrs", "", "attrIndex", "", "(Landroid/view/View;Landroid/content/Context;Landroid/util/AttributeSet;[II)V", "mContainer", "getMContainer", "()Landroid/view/View;", "mCornerRadius", "", "getMCornerRadius", "()F", "setMCornerRadius", "(F)V", "initialize", "", "setCornerRadius", "cornerRadius", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.module.common.widget.round.b.a */
public abstract class AbsRoundViewPolicy implements IRoundViewPolicy {
    /* renamed from: a */
    public static final C2992a f11377a = new C2992a(null);
    /* renamed from: b */
    private float f11378b;
    /* renamed from: c */
    private final View f11379c;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/round/policy/AbsRoundViewPolicy$Companion;", "", "()V", "DEFAULT_CORNER_DP_SIZE", "", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: AbsRoundViewPolicy.kt */
    /* renamed from: com.jiayouya.travel.module.common.widget.round.b.a$a */
    public static final class C2992a {
        private C2992a() {
        }

        public /* synthetic */ C2992a(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public AbsRoundViewPolicy(View view, Context context, AttributeSet attributeSet, int[] iArr, int i) {
        C8271i.m35386b(view, "view");
        C8271i.m35386b(context, "context");
        C8271i.m35386b(iArr, "attrs");
        this.f11379c = view;
        m13631a(context, attributeSet, iArr, i);
    }

    /* renamed from: a */
    public final float mo20798a() {
        return this.f11378b;
    }

    /* renamed from: a */
    public final void mo20799a(float f) {
        this.f11378b = f;
    }

    /* renamed from: b */
    public final View mo20800b() {
        return this.f11379c;
    }

    /* renamed from: a */
    private final void m13631a(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        this.f11378b = obtainStyledAttributes.getDimension(i, (float) GloblaEx.m12810a(4.0f));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    public void mo20801b(float f) {
        this.f11378b = f;
    }
}
