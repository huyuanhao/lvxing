package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, mo39189d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Transition.kt */
public final class TransitionKt$addListener$listener$1 implements TransitionListener {
    final /* synthetic */ C8247b $onCancel;
    final /* synthetic */ C8247b $onEnd;
    final /* synthetic */ C8247b $onPause;
    final /* synthetic */ C8247b $onResume;
    final /* synthetic */ C8247b $onStart;

    public TransitionKt$addListener$listener$1(C8247b bVar, C8247b bVar2, C8247b bVar3, C8247b bVar4, C8247b bVar5) {
        this.$onEnd = bVar;
        this.$onResume = bVar2;
        this.$onPause = bVar3;
        this.$onCancel = bVar4;
        this.$onStart = bVar5;
    }

    public void onTransitionEnd(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    public void onTransitionResume(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onResume.invoke(transition);
    }

    public void onTransitionPause(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onPause.invoke(transition);
    }

    public void onTransitionCancel(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    public void onTransitionStart(Transition transition) {
        C8271i.m35386b(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
