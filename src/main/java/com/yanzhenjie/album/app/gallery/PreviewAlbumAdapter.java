package com.yanzhenjie.album.app.gallery;

import android.content.Context;
import android.widget.ImageView;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import java.util.ArrayList;

public class PreviewAlbumAdapter extends PreviewAdapter<AlbumFile> {
    public PreviewAlbumAdapter(Context context, ArrayList<AlbumFile> arrayList) {
        super(context, arrayList);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37665a(ImageView imageView, AlbumFile albumFile, int i) {
        Album.m33246a().mo37673a().mo19816a(imageView, albumFile);
    }
}
