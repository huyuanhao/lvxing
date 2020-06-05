package com.yanzhenjie.album.api.choice;

import android.content.Context;
import com.yanzhenjie.album.api.VideoMultipleWrapper;
import com.yanzhenjie.album.api.VideoSingleWrapper;

public final class VideoChoice implements Choice<VideoMultipleWrapper, VideoSingleWrapper> {
    /* renamed from: a */
    private Context f26121a;

    public VideoChoice(Context context) {
        this.f26121a = context;
    }

    /* renamed from: a */
    public VideoSingleWrapper mo37541b() {
        return new VideoSingleWrapper(this.f26121a);
    }
}
