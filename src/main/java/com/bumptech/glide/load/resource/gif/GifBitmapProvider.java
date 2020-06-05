package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.gifdecoder.GifDecoder.C1617a;
import com.bumptech.glide.load.engine.p137a.ArrayPool;
import com.bumptech.glide.load.engine.p137a.BitmapPool;

public final class GifBitmapProvider implements C1617a {
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool eVar) {
        this(eVar, null);
    }

    public GifBitmapProvider(BitmapPool eVar, ArrayPool bVar) {
        this.bitmapPool = eVar;
        this.arrayPool = bVar;
    }

    public Bitmap obtain(int i, int i2, Config config) {
        return this.bitmapPool.getDirty(i, i2, config);
    }

    public void release(Bitmap bitmap) {
        this.bitmapPool.put(bitmap);
    }

    public byte[] obtainByteArray(int i) {
        ArrayPool bVar = this.arrayPool;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.mo12702a(i, byte[].class);
    }

    public void release(byte[] bArr) {
        ArrayPool bVar = this.arrayPool;
        if (bVar != null) {
            bVar.mo12705a(bArr);
        }
    }

    public int[] obtainIntArray(int i) {
        ArrayPool bVar = this.arrayPool;
        if (bVar == null) {
            return new int[i];
        }
        return (int[]) bVar.mo12702a(i, int[].class);
    }

    public void release(int[] iArr) {
        ArrayPool bVar = this.arrayPool;
        if (bVar != null) {
            bVar.mo12705a(iArr);
        }
    }
}
