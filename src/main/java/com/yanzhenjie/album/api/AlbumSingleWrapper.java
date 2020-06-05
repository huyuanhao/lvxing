package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.AlbumFile;
import java.util.ArrayList;

public class AlbumSingleWrapper extends BasicChoiceAlbumWrapper<AlbumSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {
    public AlbumSingleWrapper(Context context) {
        super(context);
    }
}
