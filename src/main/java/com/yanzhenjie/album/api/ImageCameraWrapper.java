package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import com.yanzhenjie.album.app.camera.CameraActivity;

public class ImageCameraWrapper extends BasicCameraWrapper<ImageCameraWrapper> {
    public ImageCameraWrapper(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo37529a() {
        CameraActivity.f26277a = this.f26100b;
        CameraActivity.f26278b = this.f26101c;
        Intent intent = new Intent(this.f26099a, CameraActivity.class);
        intent.putExtra("KEY_INPUT_FUNCTION", 0);
        intent.putExtra("KEY_INPUT_FILE_PATH", this.f26102d);
        this.f26099a.startActivity(intent);
    }
}
