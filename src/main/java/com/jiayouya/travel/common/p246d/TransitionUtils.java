package com.jiayouya.travel.common.p246d;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\bJ*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\b2\b\b\u0001\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0011J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¨\u0006\u0016"}, mo39189d2 = {"Lcom/jiayouya/travel/common/util/TransitionUtils;", "", "()V", "findTransition", "Landroid/transition/Transition;", "set", "Landroid/transition/TransitionSet;", "clazz", "Ljava/lang/Class;", "targetId", "", "restoreAncestralClipping", "", "view", "Landroid/view/View;", "was", "", "", "setAncestralClipping", "", "clipChildren", "TransitionListenerAdapter", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: com.jiayouya.travel.common.d.p */
public final class TransitionUtils {
    /* renamed from: a */
    public static final TransitionUtils f9646a = new TransitionUtils();

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, mo39189d2 = {"Lcom/jiayouya/travel/common/util/TransitionUtils$TransitionListenerAdapter;", "Landroid/transition/Transition$TransitionListener;", "()V", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: TransitionUtils.kt */
    /* renamed from: com.jiayouya.travel.common.d.p$a */
    public static class C2901a implements TransitionListener {
        public void onTransitionCancel(Transition transition) {
            C8271i.m35386b(transition, "transition");
        }

        public void onTransitionEnd(Transition transition) {
            C8271i.m35386b(transition, "transition");
        }

        public void onTransitionPause(Transition transition) {
            C8271i.m35386b(transition, "transition");
        }

        public void onTransitionResume(Transition transition) {
            C8271i.m35386b(transition, "transition");
        }

        public void onTransitionStart(Transition transition) {
            C8271i.m35386b(transition, "transition");
        }
    }

    private TransitionUtils() {
    }
}
