package com.yanzhenjie.album.api.camera;

import android.content.Context;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;

public class AlbumCamera implements Camera<ImageCameraWrapper, VideoCameraWrapper> {
    /* renamed from: a */
    private Context f26118a;

    public AlbumCamera(Context context) {
        this.f26118a = context;
    }

    /* renamed from: a */
    public ImageCameraWrapper mo37539d() {
        return new ImageCameraWrapper(this.f26118a);
    }

    /* renamed from: b */
    public VideoCameraWrapper mo37538c() {
        return new VideoCameraWrapper(this.f26118a);
    }
}
