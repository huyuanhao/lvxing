package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b¨\u0006\u0013"}, mo39189d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static /* synthetic */ TransitionListener addListener$default(Transition transition, C8247b bVar, C8247b bVar2, C8247b bVar3, C8247b bVar4, C8247b bVar5, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            bVar2 = TransitionKt$addListener$2.INSTANCE;
        }
        C8247b bVar6 = bVar2;
        if ((i & 4) != 0) {
            bVar3 = TransitionKt$addListener$3.INSTANCE;
        }
        C8247b bVar7 = bVar3;
        if ((i & 8) != 0) {
            bVar4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            bVar5 = TransitionKt$addListener$5.INSTANCE;
        }
        C8271i.m35386b(transition, "$this$addListener");
        C8271i.m35386b(bVar, "onEnd");
        C8271i.m35386b(bVar6, "onStart");
        C8271i.m35386b(bVar7, "onCancel");
        C8271i.m35386b(bVar4, "onResume");
        C8271i.m35386b(bVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(bVar, bVar4, bVar5, bVar7, bVar6);
        TransitionListener transitionListener = transitionKt$addListener$listener$1;
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final TransitionListener addListener(Transition transition, C8247b<? super Transition, Unit> bVar, C8247b<? super Transition, Unit> bVar2, C8247b<? super Transition, Unit> bVar3, C8247b<? super Transition, Unit> bVar4, C8247b<? super Transition, Unit> bVar5) {
        C8271i.m35386b(transition, "$this$addListener");
        C8271i.m35386b(bVar, "onEnd");
        C8271i.m35386b(bVar2, "onStart");
        C8271i.m35386b(bVar3, "onCancel");
        C8271i.m35386b(bVar4, "onResume");
        C8271i.m35386b(bVar5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(bVar, bVar4, bVar5, bVar3, bVar2);
        TransitionListener transitionListener = transitionKt$addListener$listener$1;
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final TransitionListener doOnEnd(Transition transition, C8247b<? super Transition, Unit> bVar) {
        C8271i.m35386b(transition, "$this$doOnEnd");
        C8271i.m35386b(bVar, "action");
        TransitionListener transitionKt$doOnEnd$$inlined$addListener$1 = new TransitionKt$doOnEnd$$inlined$addListener$1(bVar);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$1);
        return transitionKt$doOnEnd$$inlined$addListener$1;
    }

    public static final TransitionListener doOnStart(Transition transition, C8247b<? super Transition, Unit> bVar) {
        C8271i.m35386b(transition, "$this$doOnStart");
        C8271i.m35386b(bVar, "action");
        TransitionListener transitionKt$doOnStart$$inlined$addListener$1 = new TransitionKt$doOnStart$$inlined$addListener$1(bVar);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$1);
        return transitionKt$doOnStart$$inlined$addListener$1;
    }

    public static final TransitionListener doOnCancel(Transition transition, C8247b<? super Transition, Unit> bVar) {
        C8271i.m35386b(transition, "$this$doOnCancel");
        C8271i.m35386b(bVar, "action");
        TransitionListener transitionKt$doOnCancel$$inlined$addListener$1 = new TransitionKt$doOnCancel$$inlined$addListener$1(bVar);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$1);
        return transitionKt$doOnCancel$$inlined$addListener$1;
    }

    public static final TransitionListener doOnResume(Transition transition, C8247b<? super Transition, Unit> bVar) {
        C8271i.m35386b(transition, "$this$doOnResume");
        C8271i.m35386b(bVar, "action");
        TransitionListener transitionKt$doOnResume$$inlined$addListener$1 = new TransitionKt$doOnResume$$inlined$addListener$1(bVar);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$1);
        return transitionKt$doOnResume$$inlined$addListener$1;
    }

    public static final TransitionListener doOnPause(Transition transition, C8247b<? super Transition, Unit> bVar) {
        C8271i.m35386b(transition, "$this$doOnPause");
        C8271i.m35386b(bVar, "action");
        TransitionListener transitionKt$doOnPause$$inlined$addListener$1 = new TransitionKt$doOnPause$$inlined$addListener$1(bVar);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$1);
        return transitionKt$doOnPause$$inlined$addListener$1;
    }
}
