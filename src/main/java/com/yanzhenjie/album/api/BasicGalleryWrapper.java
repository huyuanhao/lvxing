package com.yanzhenjie.album.api;

import android.content.Context;
import com.yanzhenjie.album.api.BasicGalleryWrapper;
import java.util.ArrayList;

public abstract class BasicGalleryWrapper<Returner extends BasicGalleryWrapper, Result, Cancel, Checked> extends BasicAlbumWrapper<Returner, ArrayList<Result>, Cancel, ArrayList<Checked>> {
    public BasicGalleryWrapper(Context context) {
        super(context);
    }
}
