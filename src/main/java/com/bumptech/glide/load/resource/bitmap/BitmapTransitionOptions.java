package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.p131c.p133b.BitmapTransitionFactory;
import com.bumptech.glide.p131c.p133b.DrawableCrossFadeFactory;
import com.bumptech.glide.p131c.p133b.DrawableCrossFadeFactory.C1609a;
import com.bumptech.glide.p131c.p133b.TransitionFactory;

public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withCrossFade(int i) {
        return new BitmapTransitionOptions().crossFade(i);
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory cVar) {
        return new BitmapTransitionOptions().crossFade(cVar);
    }

    public static BitmapTransitionOptions withCrossFade(C1609a aVar) {
        return new BitmapTransitionOptions().crossFade(aVar);
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory<Drawable> gVar) {
        return new BitmapTransitionOptions().transitionUsing(gVar);
    }

    public static BitmapTransitionOptions with(TransitionFactory<Bitmap> gVar) {
        return (BitmapTransitionOptions) new BitmapTransitionOptions().transition(gVar);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new C1609a());
    }

    public BitmapTransitionOptions crossFade(int i) {
        return crossFade(new C1609a(i));
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory cVar) {
        return transitionUsing(cVar);
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory<Drawable> gVar) {
        return (BitmapTransitionOptions) transition((TransitionFactory<? super TranscodeType>) new BitmapTransitionFactory<Object>(gVar));
    }

    public BitmapTransitionOptions crossFade(C1609a aVar) {
        return transitionUsing(aVar.mo12510a());
    }
}
