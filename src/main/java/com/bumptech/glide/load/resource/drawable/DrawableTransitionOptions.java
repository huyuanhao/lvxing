package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.p131c.p133b.DrawableCrossFadeFactory;
import com.bumptech.glide.p131c.p133b.DrawableCrossFadeFactory.C1609a;
import com.bumptech.glide.p131c.p133b.TransitionFactory;

public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public static DrawableTransitionOptions withCrossFade(int i) {
        return new DrawableTransitionOptions().crossFade(i);
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory cVar) {
        return new DrawableTransitionOptions().crossFade(cVar);
    }

    public static DrawableTransitionOptions withCrossFade(C1609a aVar) {
        return new DrawableTransitionOptions().crossFade(aVar);
    }

    public static DrawableTransitionOptions with(TransitionFactory<Drawable> gVar) {
        return (DrawableTransitionOptions) new DrawableTransitionOptions().transition(gVar);
    }

    public DrawableTransitionOptions crossFade() {
        return crossFade(new C1609a());
    }

    public DrawableTransitionOptions crossFade(int i) {
        return crossFade(new C1609a(i));
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory cVar) {
        return (DrawableTransitionOptions) transition((TransitionFactory<? super TranscodeType>) cVar);
    }

    public DrawableTransitionOptions crossFade(C1609a aVar) {
        return crossFade(aVar.mo12510a());
    }
}
