package com.yanzhenjie.album.app.gallery;

import android.content.Context;
import android.widget.ImageView;
import com.yanzhenjie.album.Album;
import java.util.List;

public class PreviewPathAdapter extends PreviewAdapter<String> {
    public PreviewPathAdapter(Context context, List<String> list) {
        super(context, list);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37665a(ImageView imageView, String str, int i) {
        Album.m33246a().mo37673a().mo19817a(imageView, str);
    }
}
