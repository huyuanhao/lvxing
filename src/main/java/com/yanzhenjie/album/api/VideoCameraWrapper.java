package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import com.yanzhenjie.album.app.camera.CameraActivity;

public class VideoCameraWrapper extends BasicCameraWrapper<VideoCameraWrapper> {
    /* renamed from: e */
    private int f26104e = 1;
    /* renamed from: f */
    private long f26105f = 2147483647L;
    /* renamed from: g */
    private long f26106g = 2147483647L;

    public VideoCameraWrapper(Context context) {
        super(context);
    }

    /* renamed from: a */
    public VideoCameraWrapper mo37531a(int i) {
        this.f26104e = i;
        return this;
    }

    /* renamed from: a */
    public VideoCameraWrapper mo37532a(long j) {
        this.f26105f = j;
        return this;
    }

    /* renamed from: b */
    public VideoCameraWrapper mo37534b(long j) {
        this.f26106g = j;
        return this;
    }

    /* renamed from: a */
    public void mo37533a() {
        CameraActivity.f26277a = this.f26100b;
        CameraActivity.f26278b = this.f26101c;
        Intent intent = new Intent(this.f26099a, CameraActivity.class);
        intent.putExtra("KEY_INPUT_FUNCTION", 1);
        intent.putExtra("KEY_INPUT_FILE_PATH", this.f26102d);
        intent.putExtra("KEY_INPUT_CAMERA_QUALITY", this.f26104e);
        intent.putExtra("KEY_INPUT_CAMERA_DURATION", this.f26105f);
        intent.putExtra("KEY_INPUT_CAMERA_BYTES", this.f26106g);
        this.f26099a.startActivity(intent);
    }
}
