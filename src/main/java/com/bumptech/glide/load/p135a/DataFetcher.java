package com.bumptech.glide.load.p135a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.load.a.d */
public interface DataFetcher<T> {

    /* compiled from: DataFetcher */
    /* renamed from: com.bumptech.glide.load.a.d$a */
    public interface C1623a<T> {
        /* renamed from: a */
        void mo12640a(Exception exc);

        /* renamed from: a */
        void mo12641a(T t);
    }

    /* renamed from: a */
    Class<T> mo12619a();

    /* renamed from: a */
    void mo12626a(Priority priority, C1623a<? super T> aVar);

    /* renamed from: b */
    void mo12627b();

    /* renamed from: c */
    void mo12628c();

    /* renamed from: d */
    DataSource mo12629d();
}
