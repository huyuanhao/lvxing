package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorPauseListener;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007¸\u0006\u0000"}, mo39189d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Animator.kt */
public final class AnimatorKt$doOnPause$$inlined$addPauseListener$1 implements AnimatorPauseListener {
    final /* synthetic */ C8247b $onPause;

    public void onAnimationResume(Animator animator) {
        C8271i.m35386b(animator, "animator");
    }

    public AnimatorKt$doOnPause$$inlined$addPauseListener$1(C8247b bVar) {
        this.$onPause = bVar;
    }

    public void onAnimationPause(Animator animator) {
        C8271i.m35386b(animator, "animator");
        this.$onPause.invoke(animator);
    }
}
