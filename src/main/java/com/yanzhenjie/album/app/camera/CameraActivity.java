package com.yanzhenjie.album.app.camera;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog.Builder;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.mvp.BaseActivity;
import com.yanzhenjie.album.p629b.AlbumUtils;
import com.yanzhenjie.album.p629b.SystemBar;
import java.io.File;

public class CameraActivity extends BaseActivity {
    /* renamed from: a */
    public static Action<String> f26277a;
    /* renamed from: b */
    public static Action<String> f26278b;
    /* renamed from: c */
    static final /* synthetic */ boolean f26279c = (!CameraActivity.class.desiredAssertionStatus());
    /* renamed from: d */
    private int f26280d;
    /* renamed from: e */
    private String f26281e;
    /* renamed from: f */
    private int f26282f;
    /* renamed from: j */
    private long f26283j;
    /* renamed from: k */
    private long f26284k;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SystemBar.m33556a((Activity) this, 0);
        SystemBar.m33562b((Activity) this, 0);
        SystemBar.m33561b((Activity) this);
        SystemBar.m33561b((Activity) this);
        if (bundle != null) {
            this.f26280d = bundle.getInt("INSTANCE_CAMERA_FUNCTION");
            this.f26281e = bundle.getString("INSTANCE_CAMERA_FILE_PATH");
            this.f26282f = bundle.getInt("INSTANCE_CAMERA_QUALITY");
            this.f26283j = bundle.getLong("INSTANCE_CAMERA_DURATION");
            this.f26284k = bundle.getLong("INSTANCE_CAMERA_BYTES");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (f26279c || extras != null) {
            this.f26280d = extras.getInt("KEY_INPUT_FUNCTION");
            this.f26281e = extras.getString("KEY_INPUT_FILE_PATH");
            this.f26282f = extras.getInt("KEY_INPUT_CAMERA_QUALITY");
            this.f26283j = extras.getLong("KEY_INPUT_CAMERA_DURATION");
            this.f26284k = extras.getLong("KEY_INPUT_CAMERA_BYTES");
            int i = this.f26280d;
            if (i == 0) {
                if (TextUtils.isEmpty(this.f26281e)) {
                    this.f26281e = AlbumUtils.m33548b((Context) this);
                }
                mo37679a(f26328g, 1);
            } else if (i == 1) {
                if (TextUtils.isEmpty(this.f26281e)) {
                    this.f26281e = AlbumUtils.m33552c((Context) this);
                }
                mo37679a(f26329h, 2);
            } else {
                throw new AssertionError("This should not be the case.");
            }
        } else {
            throw new AssertionError();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("INSTANCE_CAMERA_FUNCTION", this.f26280d);
        bundle.putString("INSTANCE_CAMERA_FILE_PATH", this.f26281e);
        bundle.putInt("INSTANCE_CAMERA_QUALITY", this.f26282f);
        bundle.putLong("INSTANCE_CAMERA_DURATION", this.f26283j);
        bundle.putLong("INSTANCE_CAMERA_BYTES", this.f26284k);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37613b(int i) {
        if (i == 1) {
            AlbumUtils.m33543a(this, 1, new File(this.f26281e));
        } else if (i == 2) {
            AlbumUtils.m33544a(this, 2, new File(this.f26281e), this.f26282f, this.f26283j, this.f26284k);
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37615c(int i) {
        int i2;
        int i3 = this.f26280d;
        if (i3 == 0) {
            i2 = R.string.album_permission_camera_image_failed_hint;
        } else if (i3 == 1) {
            i2 = R.string.album_permission_camera_video_failed_hint;
        } else {
            throw new AssertionError("This should not be the case.");
        }
        new Builder(this).setCancelable(false).setTitle(R.string.album_title_permission_failed).setMessage(i2).setPositiveButton(R.string.album_ok, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                CameraActivity.this.m33491b();
            }
        }).show();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1 && i != 2) {
            throw new AssertionError("This should not be the case.");
        } else if (i2 == -1) {
            m33489a();
        } else {
            m33491b();
        }
    }

    /* renamed from: a */
    private void m33489a() {
        Action<String> aVar = f26277a;
        if (aVar != null) {
            aVar.mo21403a(this.f26281e);
        }
        f26277a = null;
        f26278b = null;
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33491b() {
        Action<String> aVar = f26278b;
        if (aVar != null) {
            aVar.mo21403a("User canceled.");
        }
        f26277a = null;
        f26278b = null;
        finish();
    }
}
