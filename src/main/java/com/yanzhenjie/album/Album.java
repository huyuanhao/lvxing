package com.yanzhenjie.album;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.ImageMultipleWrapper;
import com.yanzhenjie.album.api.ImageSingleWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;
import com.yanzhenjie.album.api.camera.AlbumCamera;
import com.yanzhenjie.album.api.camera.Camera;
import com.yanzhenjie.album.api.choice.Choice;
import com.yanzhenjie.album.api.choice.ImageChoice;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Album {
    /* renamed from: a */
    private static AlbumConfig f26080a;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.album.Album$CameraFunction */
    public @interface CameraFunction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.album.Album$ChoiceFunction */
    public @interface ChoiceFunction {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.yanzhenjie.album.Album$ChoiceMode */
    public @interface ChoiceMode {
    }

    /* renamed from: a */
    public static void m33247a(AlbumConfig bVar) {
        if (f26080a == null) {
            f26080a = bVar;
            return;
        }
        Log.w("Album", new IllegalStateException("Illegal operation, only allowed to configure once."));
    }

    /* renamed from: a */
    public static AlbumConfig m33246a() {
        if (f26080a == null) {
            f26080a = AlbumConfig.m33528a(null).mo37676a();
        }
        return f26080a;
    }

    /* renamed from: a */
    public static Choice<ImageMultipleWrapper, ImageSingleWrapper> m33245a(Context context) {
        return new ImageChoice(context);
    }

    /* renamed from: a */
    public static Camera<ImageCameraWrapper, VideoCameraWrapper> m33244a(Activity activity) {
        return new AlbumCamera(activity);
    }
}
