package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.p137a.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.C1772j;

public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
    private final BitmapPool bitmapPool;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool eVar) {
        super(bitmapDrawable);
        this.bitmapPool = eVar;
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return C1772j.m6147a(((BitmapDrawable) this.drawable).getBitmap());
    }

    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable) this.drawable).getBitmap());
    }

    public void initialize() {
        ((BitmapDrawable) this.drawable).getBitmap().prepareToDraw();
    }
}
