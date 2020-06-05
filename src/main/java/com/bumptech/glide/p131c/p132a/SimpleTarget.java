package com.bumptech.glide.p131c.p132a;

import com.bumptech.glide.util.C1772j;

@Deprecated
/* renamed from: com.bumptech.glide.c.a.f */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public void removeCallback(SizeReadyCallback gVar) {
    }

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final void getSize(SizeReadyCallback gVar) {
        if (C1772j.m6155a(this.width, this.height)) {
            gVar.mo12482a(this.width, this.height);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        sb.append(this.width);
        sb.append(" and height: ");
        sb.append(this.height);
        sb.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(sb.toString());
    }
}
