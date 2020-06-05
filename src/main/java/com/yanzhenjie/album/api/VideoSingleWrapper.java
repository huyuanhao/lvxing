package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.AlbumFile;
import java.util.ArrayList;

public final class VideoSingleWrapper extends BasicChoiceVideoWrapper<VideoSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {
    public VideoSingleWrapper(Context context) {
        super(context);
    }
}
