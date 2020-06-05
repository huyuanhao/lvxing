package com.bumptech.glide.p131c.p133b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.c.b.c */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    /* renamed from: a */
    private final int f4208a;
    /* renamed from: b */
    private final boolean f4209b;
    /* renamed from: c */
    private DrawableCrossFadeTransition f4210c;

    /* compiled from: DrawableCrossFadeFactory */
    /* renamed from: com.bumptech.glide.c.b.c$a */
    public static class C1609a {
        /* renamed from: a */
        private final int f4211a;
        /* renamed from: b */
        private boolean f4212b;

        public C1609a() {
            this(300);
        }

        public C1609a(int i) {
            this.f4211a = i;
        }

        /* renamed from: a */
        public DrawableCrossFadeFactory mo12510a() {
            return new DrawableCrossFadeFactory(this.f4211a, this.f4212b);
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f4208a = i;
        this.f4209b = z;
    }

    /* renamed from: a */
    public Transition<Drawable> mo12507a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.m5071b() : m5065a();
    }

    /* renamed from: a */
    private Transition<Drawable> m5065a() {
        if (this.f4210c == null) {
            this.f4210c = new DrawableCrossFadeTransition(this.f4208a, this.f4209b);
        }
        return this.f4210c;
    }
}
