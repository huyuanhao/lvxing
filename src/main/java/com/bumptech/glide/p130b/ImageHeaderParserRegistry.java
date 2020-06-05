package com.bumptech.glide.p130b;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.b.b */
public final class ImageHeaderParserRegistry {
    /* renamed from: a */
    private final List<ImageHeaderParser> f4148a = new ArrayList();

    /* renamed from: a */
    public synchronized List<ImageHeaderParser> mo12396a() {
        return this.f4148a;
    }

    /* renamed from: a */
    public synchronized void mo12397a(ImageHeaderParser imageHeaderParser) {
        this.f4148a.add(imageHeaderParser);
    }
}
