package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.p131c.p133b.NoTransition;
import com.bumptech.glide.p131c.p133b.TransitionFactory;
import com.bumptech.glide.p131c.p133b.ViewAnimationFactory;
import com.bumptech.glide.p131c.p133b.ViewPropertyAnimationFactory;
import com.bumptech.glide.p131c.p133b.ViewPropertyTransition.C1613a;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.j */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> transitionFactory = NoTransition.m5070a();

    private CHILD self() {
        return this;
    }

    public final CHILD dontTransition() {
        return transition(NoTransition.m5070a());
    }

    public final CHILD transition(int i) {
        return transition((TransitionFactory<? super TranscodeType>) new ViewAnimationFactory<Object>(i));
    }

    public final CHILD transition(C1613a aVar) {
        return transition((TransitionFactory<? super TranscodeType>) new ViewPropertyAnimationFactory<Object>(aVar));
    }

    public final CHILD transition(TransitionFactory<? super TranscodeType> gVar) {
        this.transitionFactory = (TransitionFactory) Preconditions.m6138a(gVar);
        return self();
    }

    public final CHILD clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: final */
    public final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }
}
