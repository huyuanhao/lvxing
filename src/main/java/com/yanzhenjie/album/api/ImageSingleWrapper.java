package com.yanzhenjie.album.api;

import android.content.Context;
import android.content.Intent;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.app.album.AlbumActivity;
import java.util.ArrayList;

public final class ImageSingleWrapper extends BasicChoiceWrapper<ImageSingleWrapper, ArrayList<AlbumFile>, String, AlbumFile> {
    public ImageSingleWrapper(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo37530a() {
        AlbumActivity.f26151a = this.f26124j;
        AlbumActivity.f26152b = this.f26125k;
        AlbumActivity.f26154d = this.f26109b;
        AlbumActivity.f26155e = this.f26110c;
        Intent intent = new Intent(this.f26108a, AlbumActivity.class);
        intent.putExtra("KEY_INPUT_WIDGET", this.f26111d);
        intent.putExtra("KEY_INPUT_FUNCTION", 0);
        intent.putExtra("KEY_INPUT_CHOICE_MODE", 2);
        intent.putExtra("KEY_INPUT_COLUMN_COUNT", this.f26123i);
        intent.putExtra("KEY_INPUT_ALLOW_CAMERA", this.f26122h);
        intent.putExtra("KEY_INPUT_LIMIT_COUNT", 1);
        intent.putExtra("KEY_INPUT_FILTER_VISIBILITY", this.f26126l);
        this.f26108a.startActivity(intent);
    }
}
