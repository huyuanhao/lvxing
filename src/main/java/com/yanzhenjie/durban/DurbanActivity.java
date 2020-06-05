package com.yanzhenjie.durban;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mid.core.Constants;
import com.yanzhenjie.durban.p630a.BitmapCropCallback;
import com.yanzhenjie.durban.p632c.DurbanUtils;
import com.yanzhenjie.durban.view.CropView;
import com.yanzhenjie.durban.view.GestureCropImageView;
import com.yanzhenjie.durban.view.OverlayView;
import com.yanzhenjie.durban.view.TransformImageView.C7808a;
import java.util.ArrayList;

public class DurbanActivity extends AppCompatActivity {
    /* renamed from: a */
    static final /* synthetic */ boolean f26428a = (!DurbanActivity.class.desiredAssertionStatus());
    /* renamed from: b */
    private int f26429b;
    /* renamed from: c */
    private int f26430c;
    /* renamed from: d */
    private int f26431d;
    /* renamed from: e */
    private String f26432e;
    /* renamed from: f */
    private int f26433f;
    /* renamed from: g */
    private float[] f26434g;
    /* renamed from: h */
    private int[] f26435h;
    /* renamed from: i */
    private CompressFormat f26436i;
    /* renamed from: j */
    private int f26437j;
    /* renamed from: k */
    private String f26438k;
    /* renamed from: l */
    private ArrayList<String> f26439l;
    /* renamed from: m */
    private Controller f26440m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public CropView f26441n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public GestureCropImageView f26442o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public ArrayList<String> f26443p;
    /* renamed from: q */
    private C7808a f26444q = new C7808a() {
        /* renamed from: a */
        public void mo37801a(float f) {
        }

        /* renamed from: b */
        public void mo37803b(float f) {
        }

        /* renamed from: a */
        public void mo37800a() {
            ViewCompat.animate(DurbanActivity.this.f26441n).alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
        }

        /* renamed from: b */
        public void mo37802b() {
            DurbanActivity.this.m33784d();
        }
    };
    /* renamed from: r */
    private OnClickListener f26445r = new OnClickListener() {
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.layout_controller_rotation_left) {
                DurbanActivity.this.f26442o.mo37877c(-90.0f);
                DurbanActivity.this.f26442o.mo37873b();
            } else if (id == R.id.layout_controller_rotation_right) {
                DurbanActivity.this.f26442o.mo37877c(90.0f);
                DurbanActivity.this.f26442o.mo37873b();
            } else if (id == R.id.layout_controller_scale_big) {
                DurbanActivity.this.f26442o.mo37867a(DurbanActivity.this.f26442o.getCurrentScale() + ((DurbanActivity.this.f26442o.getMaxScale() - DurbanActivity.this.f26442o.getMinScale()) / 10.0f));
                DurbanActivity.this.f26442o.mo37873b();
            } else if (id == R.id.layout_controller_scale_small) {
                DurbanActivity.this.f26442o.mo37874b(DurbanActivity.this.f26442o.getCurrentScale() - ((DurbanActivity.this.f26442o.getMaxScale() - DurbanActivity.this.f26442o.getMinScale()) / 10.0f));
                DurbanActivity.this.f26442o.mo37873b();
            }
        }
    };
    /* renamed from: s */
    private BitmapCropCallback f26446s = new BitmapCropCallback() {
        /* renamed from: a */
        public void mo37805a(String str, int i, int i2) {
            DurbanActivity.this.f26443p.add(str);
            DurbanActivity.this.m33784d();
        }

        /* renamed from: a */
        public void mo37806a(Throwable th) {
            DurbanActivity.this.m33784d();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DurbanUtils.m33821a(this, Durban.m33763a().mo37807a());
        setContentView(R.layout.durban_activity_photobox);
        m33778a(getIntent());
        m33776a();
        m33779b();
        m33782c();
        m33784d();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.f26442o;
        if (gestureCropImageView != null) {
            gestureCropImageView.mo37866a();
        }
    }

    /* renamed from: a */
    private void m33778a(Intent intent) {
        this.f26429b = ContextCompat.getColor(this, R.color.durban_ColorPrimaryDark);
        this.f26431d = ContextCompat.getColor(this, R.color.durban_ColorPrimary);
        this.f26430c = ContextCompat.getColor(this, R.color.durban_ColorPrimaryBlack);
        this.f26429b = intent.getIntExtra("AlbumCrop.KEY_INPUT_STATUS_COLOR", this.f26429b);
        this.f26431d = intent.getIntExtra("AlbumCrop.KEY_INPUT_TOOLBAR_COLOR", this.f26431d);
        this.f26430c = intent.getIntExtra("AlbumCrop.KEY_INPUT_NAVIGATION_COLOR", this.f26430c);
        this.f26432e = intent.getStringExtra("AlbumCrop.KEY_INPUT_TITLE");
        if (TextUtils.isEmpty(this.f26432e)) {
            this.f26432e = getString(R.string.durban_title_crop);
        }
        this.f26433f = intent.getIntExtra("AlbumCrop.KEY_INPUT_GESTURE", 3);
        this.f26434g = intent.getFloatArrayExtra("AlbumCrop.KEY_INPUT_ASPECT_RATIO");
        if (this.f26434g == null) {
            this.f26434g = new float[]{0.0f, 0.0f};
        }
        this.f26435h = intent.getIntArrayExtra("AlbumCrop.KEY_INPUT_MAX_WIDTH_HEIGHT");
        if (this.f26435h == null) {
            this.f26435h = new int[]{500, 500};
        }
        this.f26436i = intent.getIntExtra("AlbumCrop.KEY_INPUT_COMPRESS_FORMAT", 0) == 1 ? CompressFormat.PNG : CompressFormat.JPEG;
        this.f26437j = intent.getIntExtra("AlbumCrop.KEY_INPUT_COMPRESS_QUALITY", 90);
        this.f26438k = intent.getStringExtra("AlbumCrop.KEY_INPUT_DIRECTORY");
        if (TextUtils.isEmpty(this.f26438k)) {
            this.f26438k = getFilesDir().getAbsolutePath();
        }
        this.f26439l = intent.getStringArrayListExtra("AlbumCrop.KEY_INPUT_PATH_ARRAY");
        this.f26440m = (Controller) intent.getParcelableExtra("AlbumCrop.KEY_INPUT_CONTROLLER");
        if (this.f26440m == null) {
            this.f26440m = Controller.m33747a().mo37788a();
        }
        this.f26443p = new ArrayList<>();
    }

    /* renamed from: a */
    private void m33776a() {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(this.f26429b);
                window.setNavigationBarColor(this.f26430c);
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.f26431d);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (f26428a || supportActionBar != null) {
            supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle((CharSequence) this.f26432e);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    private void m33779b() {
        this.f26441n = (CropView) findViewById(R.id.crop_view);
        this.f26442o = this.f26441n.getCropImageView();
        this.f26442o.setOutputDirectory(this.f26438k);
        this.f26442o.setTransformImageListener(this.f26444q);
        GestureCropImageView gestureCropImageView = this.f26442o;
        int i = this.f26433f;
        boolean z = i == 3 || i == 1;
        gestureCropImageView.setScaleEnabled(z);
        GestureCropImageView gestureCropImageView2 = this.f26442o;
        int i2 = this.f26433f;
        boolean z2 = i2 == 3 || i2 == 2;
        gestureCropImageView2.setRotateEnabled(z2);
        this.f26442o.setMaxBitmapSize(0);
        this.f26442o.setMaxScaleMultiplier(10.0f);
        this.f26442o.setImageToWrapCropBoundsAnimDuration(500);
        OverlayView overlayView = this.f26441n.getOverlayView();
        overlayView.setFreestyleCropMode(0);
        overlayView.setDimmedColor(ContextCompat.getColor(this, R.color.durban_CropDimmed));
        overlayView.setCircleDimmedLayer(false);
        overlayView.setShowCropFrame(true);
        overlayView.setCropFrameColor(ContextCompat.getColor(this, R.color.durban_CropFrameLine));
        overlayView.setCropFrameStrokeWidth(getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        overlayView.setShowCropGrid(true);
        overlayView.setCropGridRowCount(2);
        overlayView.setCropGridColumnCount(2);
        overlayView.setCropGridColor(ContextCompat.getColor(this, R.color.durban_CropGridLine));
        overlayView.setCropGridStrokeWidth(getResources().getDimensionPixelSize(R.dimen.durban_dp_1));
        float[] fArr = this.f26434g;
        if (fArr[0] <= 0.0f || fArr[1] <= 0.0f) {
            this.f26442o.setTargetAspectRatio(0.0f);
        } else {
            this.f26442o.setTargetAspectRatio(fArr[0] / fArr[1]);
        }
        int[] iArr = this.f26435h;
        if (iArr[0] > 0 && iArr[1] > 0) {
            this.f26442o.setMaxResultImageSizeX(iArr[0]);
            this.f26442o.setMaxResultImageSizeY(this.f26435h[1]);
        }
    }

    /* renamed from: c */
    private void m33782c() {
        View findViewById = findViewById(R.id.iv_controller_root);
        View findViewById2 = findViewById(R.id.tv_controller_title_rotation);
        View findViewById3 = findViewById(R.id.layout_controller_rotation_left);
        View findViewById4 = findViewById(R.id.layout_controller_rotation_right);
        View findViewById5 = findViewById(R.id.tv_controller_title_scale);
        View findViewById6 = findViewById(R.id.layout_controller_scale_big);
        View findViewById7 = findViewById(R.id.layout_controller_scale_small);
        int i = 0;
        findViewById.setVisibility(this.f26440m.mo37777b() ? 0 : 8);
        int i2 = 4;
        findViewById2.setVisibility(this.f26440m.mo37779d() ? 0 : 4);
        findViewById3.setVisibility(this.f26440m.mo37778c() ? 0 : 8);
        findViewById4.setVisibility(this.f26440m.mo37778c() ? 0 : 8);
        if (this.f26440m.mo37782f()) {
            i2 = 0;
        }
        findViewById5.setVisibility(i2);
        findViewById6.setVisibility(this.f26440m.mo37781e() ? 0 : 8);
        if (!this.f26440m.mo37781e()) {
            i = 8;
        }
        findViewById7.setVisibility(i);
        if (!this.f26440m.mo37779d() && !this.f26440m.mo37782f()) {
            findViewById(R.id.layout_controller_title_root).setVisibility(8);
        }
        if (!this.f26440m.mo37778c()) {
            findViewById2.setVisibility(8);
        }
        if (!this.f26440m.mo37781e()) {
            findViewById5.setVisibility(8);
        }
        findViewById3.setOnClickListener(this.f26445r);
        findViewById4.setOnClickListener(this.f26445r);
        findViewById6.setOnClickListener(this.f26445r);
        findViewById7.setOnClickListener(this.f26445r);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33784d() {
        m33785e();
        m33777a(1);
    }

    /* renamed from: e */
    private void m33785e() {
        GestureCropImageView gestureCropImageView = this.f26442o;
        gestureCropImageView.mo37877c(-gestureCropImageView.getCurrentAngle());
        this.f26442o.mo37873b();
    }

    /* renamed from: a */
    private void m33777a(int i) {
        int i2 = VERSION.SDK_INT;
        String str = Constants.PERMISSION_WRITE_EXTERNAL_STORAGE;
        if (i2 < 23) {
            onRequestPermissionsResult(i, new String[]{str}, new int[]{0});
        } else if (ContextCompat.checkSelfPermission(this, str) == 0) {
            onRequestPermissionsResult(i, new String[]{str}, new int[]{0});
        } else {
            ActivityCompat.requestPermissions(this, new String[]{str, "android.permission.READ_EXTERNAL_STORAGE"}, i);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr[0] == 0) {
                m33786f();
                return;
            }
            Log.e("Durban", "Storage device permission is denied.");
            m33789i();
        }
    }

    /* renamed from: f */
    private void m33786f() {
        ArrayList<String> arrayList = this.f26439l;
        if (arrayList == null) {
            Log.e("Durban", "The file list is empty.");
            m33789i();
        } else if (arrayList.size() > 0) {
            try {
                this.f26442o.setImagePath((String) this.f26439l.remove(0));
            } catch (Exception unused) {
                m33784d();
            }
        } else if (this.f26443p.size() > 0) {
            m33788h();
        } else {
            m33789i();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.durban_menu_activity, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_action_ok) {
            m33787g();
        } else if (menuItem.getItemId() == 16908332) {
            m33789i();
        }
        return true;
    }

    /* renamed from: g */
    private void m33787g() {
        this.f26442o.mo37871a(this.f26436i, this.f26437j, this.f26446s);
    }

    /* renamed from: h */
    private void m33788h() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST", this.f26443p);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: i */
    private void m33789i() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("AlbumCrop.KEY_OUTPUT_IMAGE_LIST", this.f26443p);
        setResult(0, intent);
        finish();
    }
}
