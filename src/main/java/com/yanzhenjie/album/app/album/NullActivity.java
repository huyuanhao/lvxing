package com.yanzhenjie.album.app.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.C7733c;
import com.yanzhenjie.album.app.Contract.NullPresenter;
import com.yanzhenjie.album.mvp.BaseActivity;

public class NullActivity extends BaseActivity implements NullPresenter {
    /* renamed from: a */
    static final /* synthetic */ boolean f26219a = (!NullActivity.class.desiredAssertionStatus());
    /* renamed from: b */
    private Widget f26220b;
    /* renamed from: c */
    private int f26221c = 1;
    /* renamed from: d */
    private long f26222d;
    /* renamed from: e */
    private long f26223e;
    /* renamed from: f */
    private C7733c f26224f;
    /* renamed from: j */
    private Action<String> f26225j = new Action<String>() {
        /* renamed from: a */
        public void mo21403a(String str) {
            Intent intent = new Intent();
            intent.putExtra("KEY_OUTPUT_IMAGE_PATH", str);
            NullActivity.this.setResult(-1, intent);
            NullActivity.this.finish();
        }
    };

    /* renamed from: a */
    public static String m33432a(Intent intent) {
        return intent.getStringExtra("KEY_OUTPUT_IMAGE_PATH");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_activity_null);
        this.f26224f = new NullView(this, this);
        Bundle extras = getIntent().getExtras();
        if (f26219a || extras != null) {
            int i = extras.getInt("KEY_INPUT_FUNCTION");
            boolean z = extras.getBoolean("KEY_INPUT_ALLOW_CAMERA");
            this.f26221c = extras.getInt("KEY_INPUT_CAMERA_QUALITY");
            this.f26222d = extras.getLong("KEY_INPUT_CAMERA_DURATION");
            this.f26223e = extras.getLong("KEY_INPUT_CAMERA_BYTES");
            this.f26220b = (Widget) extras.getParcelable("KEY_INPUT_WIDGET");
            this.f26224f.mo37607a(this.f26220b);
            this.f26224f.mo37698c(this.f26220b.mo37550e());
            if (i == 0) {
                this.f26224f.mo37606a(R.string.album_not_found_image);
                this.f26224f.mo37609b(false);
            } else if (i == 1) {
                this.f26224f.mo37606a(R.string.album_not_found_video);
                this.f26224f.mo37608a(false);
            } else if (i == 2) {
                this.f26224f.mo37606a(R.string.album_not_found_album);
            } else {
                throw new AssertionError("This should not be the case.");
            }
            if (!z) {
                this.f26224f.mo37608a(false);
                this.f26224f.mo37609b(false);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo37587a() {
        ((ImageCameraWrapper) ((ImageCameraWrapper) Album.m33244a((Activity) this).mo37539d()).mo37527a(this.f26225j)).mo37529a();
    }

    /* renamed from: b */
    public void mo37588b() {
        ((VideoCameraWrapper) ((VideoCameraWrapper) Album.m33244a((Activity) this).mo37538c()).mo37531a(this.f26221c).mo37532a(this.f26222d).mo37534b(this.f26223e).mo37527a(this.f26225j)).mo37533a();
    }
}
