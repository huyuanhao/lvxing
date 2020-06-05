package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8247b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\b¨\u0006\u0017"}, mo39189d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Animator.kt */
public final class AnimatorKt {
    public static /* synthetic */ AnimatorListener addListener$default(Animator animator, C8247b bVar, C8247b bVar2, C8247b bVar3, C8247b bVar4, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            bVar2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            bVar3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            bVar4 = AnimatorKt$addListener$4.INSTANCE;
        }
        C8271i.m35386b(animator, "$this$addListener");
        C8271i.m35386b(bVar, "onEnd");
        C8271i.m35386b(bVar2, "onStart");
        C8271i.m35386b(bVar3, "onCancel");
        C8271i.m35386b(bVar4, "onRepeat");
        AnimatorListener animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(bVar4, bVar, bVar3, bVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static final AnimatorListener addListener(Animator animator, C8247b<? super Animator, Unit> bVar, C8247b<? super Animator, Unit> bVar2, C8247b<? super Animator, Unit> bVar3, C8247b<? super Animator, Unit> bVar4) {
        C8271i.m35386b(animator, "$this$addListener");
        C8271i.m35386b(bVar, "onEnd");
        C8271i.m35386b(bVar2, "onStart");
        C8271i.m35386b(bVar3, "onCancel");
        C8271i.m35386b(bVar4, "onRepeat");
        AnimatorListener animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(bVar4, bVar, bVar3, bVar2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ AnimatorPauseListener addPauseListener$default(Animator animator, C8247b bVar, C8247b bVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            bVar2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        C8271i.m35386b(animator, "$this$addPauseListener");
        C8271i.m35386b(bVar, "onResume");
        C8271i.m35386b(bVar2, "onPause");
        AnimatorPauseListener animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(bVar2, bVar);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final AnimatorPauseListener addPauseListener(Animator animator, C8247b<? super Animator, Unit> bVar, C8247b<? super Animator, Unit> bVar2) {
        C8271i.m35386b(animator, "$this$addPauseListener");
        C8271i.m35386b(bVar, "onResume");
        C8271i.m35386b(bVar2, "onPause");
        AnimatorPauseListener animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(bVar2, bVar);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final AnimatorListener doOnEnd(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnEnd");
        C8271i.m35386b(bVar, "action");
        AnimatorListener animatorKt$doOnEnd$$inlined$addListener$1 = new AnimatorKt$doOnEnd$$inlined$addListener$1(bVar);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$1);
        return animatorKt$doOnEnd$$inlined$addListener$1;
    }

    public static final AnimatorListener doOnStart(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnStart");
        C8271i.m35386b(bVar, "action");
        AnimatorListener animatorKt$doOnStart$$inlined$addListener$1 = new AnimatorKt$doOnStart$$inlined$addListener$1(bVar);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$1);
        return animatorKt$doOnStart$$inlined$addListener$1;
    }

    public static final AnimatorListener doOnCancel(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnCancel");
        C8271i.m35386b(bVar, "action");
        AnimatorListener animatorKt$doOnCancel$$inlined$addListener$1 = new AnimatorKt$doOnCancel$$inlined$addListener$1(bVar);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$1);
        return animatorKt$doOnCancel$$inlined$addListener$1;
    }

    public static final AnimatorListener doOnRepeat(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnRepeat");
        C8271i.m35386b(bVar, "action");
        AnimatorListener animatorKt$doOnRepeat$$inlined$addListener$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$1(bVar);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$1);
        return animatorKt$doOnRepeat$$inlined$addListener$1;
    }

    public static final AnimatorPauseListener doOnResume(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnResume");
        C8271i.m35386b(bVar, "action");
        AnimatorPauseListener animatorKt$doOnResume$$inlined$addPauseListener$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$1(bVar);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$1;
    }

    public static final AnimatorPauseListener doOnPause(Animator animator, C8247b<? super Animator, Unit> bVar) {
        C8271i.m35386b(animator, "$this$doOnPause");
        C8271i.m35386b(bVar, "action");
        AnimatorPauseListener animatorKt$doOnPause$$inlined$addPauseListener$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$1(bVar);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$1;
    }
}
