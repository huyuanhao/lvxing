package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u0000"}, mo39189d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Transition.kt */
public final class TransitionKt$doOnPause$$inlined$addListener$1 implements TransitionListener {
    final /* synthetic */ C8247b $onPause;

    public void onTransitionCancel(Transition transition) {
        C8271i.m35386b(transition, "transition");
    }

    public void onTransitionEnd(Transition transition) {
        C8271i.m35386b(transition, "transition");
    }

    public void onTransitionResume(Transition transition) {
        C8271i.m35386b(transition, "transition");
    }

    public void onTransitionStart(Transition transition) {
        C8271i.m35386b(transition, "transition");
    }

    public TransitionKt$doOnPause$$inlined$addListener$1(C8247b bVar) {
        this.$onPause = bVar;
    }

    public void onTransitionPause(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onPause.invoke(transition);
    }
}
