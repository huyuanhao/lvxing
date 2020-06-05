package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.api.BasicChoiceWrapper;

/* renamed from: com.yanzhenjie.album.api.d */
public abstract class BasicChoiceWrapper<Returner extends BasicChoiceWrapper, Result, Cancel, Checked> extends BasicAlbumWrapper<Returner, Result, Cancel, Checked> {
    /* renamed from: h */
    boolean f26122h = true;
    /* renamed from: i */
    int f26123i = 2;
    /* renamed from: j */
    Filter<Long> f26124j;
    /* renamed from: k */
    Filter<String> f26125k;
    /* renamed from: l */
    boolean f26126l = true;

    BasicChoiceWrapper(Context context) {
        super(context);
    }

    /* renamed from: a */
    public Returner mo37544a(int i) {
        this.f26123i = i;
        return this;
    }
}
