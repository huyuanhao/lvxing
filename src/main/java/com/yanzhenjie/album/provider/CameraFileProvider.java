package com.yanzhenjie.album.provider;

import android.content.Context;
import androidx.core.content.FileProvider;

public class CameraFileProvider extends FileProvider {
    /* renamed from: a */
    public static String m33641a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".app.file.provider");
        return sb.toString();
    }
}
