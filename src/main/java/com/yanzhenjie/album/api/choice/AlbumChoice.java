package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.AlbumMultipleWrapper;
import com.yanzhenjie.album.api.AlbumSingleWrapper;

public final class AlbumChoice implements Choice<AlbumMultipleWrapper, AlbumSingleWrapper> {
    /* renamed from: a */
    private Context f26119a;

    public AlbumChoice(Context context) {
        this.f26119a = context;
    }

    /* renamed from: a */
    public AlbumSingleWrapper mo37541b() {
        return new AlbumSingleWrapper(this.f26119a);
    }
}
