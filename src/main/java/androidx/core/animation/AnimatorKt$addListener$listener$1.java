package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo39189d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Animator.kt */
public final class AnimatorKt$addListener$listener$1 implements AnimatorListener {
    final /* synthetic */ C8247b $onCancel;
    final /* synthetic */ C8247b $onEnd;
    final /* synthetic */ C8247b $onRepeat;
    final /* synthetic */ C8247b $onStart;

    public AnimatorKt$addListener$listener$1(C8247b bVar, C8247b bVar2, C8247b bVar3, C8247b bVar4) {
        this.$onRepeat = bVar;
        this.$onEnd = bVar2;
        this.$onCancel = bVar3;
        this.$onStart = bVar4;
    }

    public void onAnimationRepeat(Animator animator) {
        C8271i.m35386b(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    public void onAnimationEnd(Animator animator) {
        C8271i.m35386b(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    public void onAnimationCancel(Animator animator) {
        C8271i.m35386b(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    public void onAnimationStart(Animator animator) {
        C8271i.m35386b(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
