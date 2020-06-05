package com.yanzhenjie.album.app.album;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.Filter;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.ImageCameraWrapper;
import com.yanzhenjie.album.api.VideoCameraWrapper;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.AlbumPresenter;
import com.yanzhenjie.album.app.Contract.C7731a;
import com.yanzhenjie.album.app.album.GalleryActivity.C7743a;
import com.yanzhenjie.album.app.album.data.MediaReadTask;
import com.yanzhenjie.album.app.album.data.MediaReadTask.C7750a;
import com.yanzhenjie.album.app.album.data.MediaReader;
import com.yanzhenjie.album.app.album.data.PathConversion;
import com.yanzhenjie.album.app.album.data.PathConvertTask;
import com.yanzhenjie.album.app.album.data.PathConvertTask.C7752a;
import com.yanzhenjie.album.app.album.data.ThumbnailBuildTask;
import com.yanzhenjie.album.app.album.data.ThumbnailBuildTask.C7753a;
import com.yanzhenjie.album.mvp.BaseActivity;
import com.yanzhenjie.album.p628a.C7726c;
import com.yanzhenjie.album.p629b.AlbumUtils;
import com.yanzhenjie.album.widget.LoadingDialog;
import com.yanzhenjie.mediascanner.MediaScanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends BaseActivity implements AlbumPresenter, C7743a, C7750a, C7752a, C7753a {
    /* renamed from: a */
    public static Filter<Long> f26151a;
    /* renamed from: b */
    public static Filter<String> f26152b;
    /* renamed from: c */
    public static Filter<Long> f26153c;
    /* renamed from: d */
    public static Action<ArrayList<AlbumFile>> f26154d;
    /* renamed from: e */
    public static Action<String> f26155e;
    /* renamed from: f */
    static final /* synthetic */ boolean f26156f = (!AlbumActivity.class.desiredAssertionStatus());
    /* renamed from: A */
    private LoadingDialog f26157A;
    /* renamed from: B */
    private MediaReadTask f26158B;
    /* renamed from: C */
    private Action<String> f26159C = new Action<String>() {
        /* renamed from: a */
        public void mo21403a(String str) {
            if (AlbumActivity.this.f26173w == null) {
                AlbumActivity albumActivity = AlbumActivity.this;
                albumActivity.f26173w = new MediaScanner(albumActivity);
            }
            AlbumActivity.this.f26173w.mo37990a(str);
            new PathConvertTask(new PathConversion(AlbumActivity.f26151a, AlbumActivity.f26152b, AlbumActivity.f26153c), AlbumActivity.this).execute(new String[]{str});
        }
    };
    /* renamed from: j */
    private List<AlbumFolder> f26160j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f26161k;
    /* renamed from: l */
    private Widget f26162l;
    /* renamed from: m */
    private int f26163m;
    /* renamed from: n */
    private int f26164n;
    /* renamed from: o */
    private int f26165o;
    /* renamed from: p */
    private boolean f26166p;
    /* renamed from: q */
    private int f26167q;
    /* renamed from: r */
    private int f26168r;
    /* renamed from: s */
    private long f26169s;
    /* renamed from: t */
    private long f26170t;
    /* renamed from: u */
    private boolean f26171u;
    /* renamed from: v */
    private ArrayList<AlbumFile> f26172v;
    /* access modifiers changed from: private */
    /* renamed from: w */
    public MediaScanner f26173w;
    /* renamed from: x */
    private C7731a f26174x;
    /* renamed from: y */
    private FolderDialog f26175y;
    /* renamed from: z */
    private PopupMenu f26176z;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m33385i();
        setContentView(m33386j());
        this.f26174x = new AlbumView(this, this);
        this.f26174x.mo37592a(this.f26162l, this.f26165o, this.f26166p, this.f26164n);
        this.f26174x.mo37698c(this.f26162l.mo37550e());
        this.f26174x.mo37595b(false);
        this.f26174x.mo37593a(true);
        mo37679a(f26330i, 1);
    }

    /* renamed from: i */
    private void m33385i() {
        Bundle extras = getIntent().getExtras();
        if (f26156f || extras != null) {
            this.f26162l = (Widget) extras.getParcelable("KEY_INPUT_WIDGET");
            this.f26163m = extras.getInt("KEY_INPUT_FUNCTION");
            this.f26164n = extras.getInt("KEY_INPUT_CHOICE_MODE");
            this.f26165o = extras.getInt("KEY_INPUT_COLUMN_COUNT");
            this.f26166p = extras.getBoolean("KEY_INPUT_ALLOW_CAMERA");
            this.f26167q = extras.getInt("KEY_INPUT_LIMIT_COUNT");
            this.f26168r = extras.getInt("KEY_INPUT_CAMERA_QUALITY");
            this.f26169s = extras.getLong("KEY_INPUT_CAMERA_DURATION");
            this.f26170t = extras.getLong("KEY_INPUT_CAMERA_BYTES");
            this.f26171u = extras.getBoolean("KEY_INPUT_FILTER_VISIBILITY");
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: j */
    private int m33386j() {
        int a = this.f26162l.mo37545a();
        if (a == 1) {
            return R.layout.album_activity_album_light;
        }
        if (a == 2) {
            return R.layout.album_activity_album_dark;
        }
        throw new AssertionError("This should not be the case.");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f26174x.mo37590a(configuration);
        FolderDialog folderDialog = this.f26175y;
        if (folderDialog != null && !folderDialog.isShowing()) {
            this.f26175y = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo37613b(int i) {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("KEY_INPUT_CHECKED_LIST");
        MediaReader bVar = new MediaReader(this, f26151a, f26152b, f26153c, this.f26171u);
        this.f26158B = new MediaReadTask(this.f26163m, parcelableArrayListExtra, bVar, this);
        this.f26158B.execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo37615c(int i) {
        new Builder(this).setCancelable(false).setTitle(R.string.album_title_permission_failed).setMessage(R.string.album_permission_storage_failed_hint).setPositiveButton(R.string.album_ok, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AlbumActivity.this.m33391o();
            }
        }).show();
    }

    /* renamed from: a */
    public void mo37612a(ArrayList<AlbumFolder> arrayList, ArrayList<AlbumFile> arrayList2) {
        this.f26158B = null;
        int i = this.f26164n;
        if (i == 1) {
            this.f26174x.mo37595b(true);
        } else if (i == 2) {
            this.f26174x.mo37595b(false);
        } else {
            throw new AssertionError("This should not be the case.");
        }
        this.f26174x.mo37593a(false);
        this.f26160j = arrayList;
        this.f26172v = arrayList2;
        if (((AlbumFolder) this.f26160j.get(0)).mo37516b().isEmpty()) {
            Intent intent = new Intent(this, NullActivity.class);
            intent.putExtras(getIntent());
            startActivityForResult(intent, 1);
            return;
        }
        m33382d(0);
        int size = this.f26172v.size();
        this.f26174x.mo37596c(size);
        C7731a aVar = this.f26174x;
        StringBuilder sb = new StringBuilder();
        sb.append(size);
        sb.append("/");
        sb.append(this.f26167q);
        aVar.mo37701d(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                String a = NullActivity.m33432a(intent);
                if (!TextUtils.isEmpty(AlbumUtils.m33550b(a))) {
                    this.f26159C.mo21403a(a);
                    return;
                }
                return;
            }
            m33391o();
        }
    }

    /* renamed from: a */
    public void mo37578a() {
        if (this.f26175y == null) {
            this.f26175y = new FolderDialog(this, this.f26162l, this.f26160j, new C7726c() {
                /* renamed from: a */
                public void mo37526a(View view, int i) {
                    AlbumActivity.this.f26161k = i;
                    AlbumActivity albumActivity = AlbumActivity.this;
                    albumActivity.m33382d(albumActivity.f26161k);
                }
            });
        }
        if (!this.f26175y.isShowing()) {
            this.f26175y.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33382d(int i) {
        this.f26161k = i;
        this.f26174x.mo37591a((AlbumFolder) this.f26160j.get(i));
    }

    public void clickCamera(View view) {
        int i;
        String str = "This should not be the case.";
        if (this.f26172v.size() >= this.f26167q) {
            int i2 = this.f26163m;
            if (i2 == 0) {
                i = R.plurals.album_check_image_limit_camera;
            } else if (i2 == 1) {
                i = R.plurals.album_check_video_limit_camera;
            } else if (i2 == 2) {
                i = R.plurals.album_check_album_limit_camera;
            } else {
                throw new AssertionError(str);
            }
            C7731a aVar = this.f26174x;
            Resources resources = getResources();
            int i3 = this.f26167q;
            aVar.mo37695a((CharSequence) resources.getQuantityString(i, i3, new Object[]{Integer.valueOf(i3)}));
            return;
        }
        int i4 = this.f26163m;
        if (i4 == 0) {
            m33387k();
        } else if (i4 == 1) {
            m33388l();
        } else if (i4 == 2) {
            if (this.f26176z == null) {
                this.f26176z = new PopupMenu(this, view);
                this.f26176z.getMenuInflater().inflate(R.menu.album_menu_item_camera, this.f26176z.getMenu());
                this.f26176z.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.album_menu_camera_image) {
                            AlbumActivity.this.m33387k();
                        } else if (itemId == R.id.album_menu_camera_video) {
                            AlbumActivity.this.m33388l();
                        }
                        return true;
                    }
                });
            }
            this.f26176z.show();
        } else {
            throw new AssertionError(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m33387k() {
        String str;
        int i = this.f26161k;
        if (i == 0) {
            str = AlbumUtils.m33547b();
        } else {
            str = AlbumUtils.m33540a(new File(((AlbumFile) ((AlbumFolder) this.f26160j.get(i)).mo37516b().get(0)).mo37485a()).getParentFile());
        }
        ((ImageCameraWrapper) ((ImageCameraWrapper) ((ImageCameraWrapper) Album.m33244a((Activity) this).mo37539d()).mo37528a(str)).mo37527a(this.f26159C)).mo37529a();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m33388l() {
        String str;
        int i = this.f26161k;
        if (i == 0) {
            str = AlbumUtils.m33551c();
        } else {
            str = AlbumUtils.m33549b(new File(((AlbumFile) ((AlbumFolder) this.f26160j.get(i)).mo37516b().get(0)).mo37485a()).getParentFile());
        }
        ((VideoCameraWrapper) ((VideoCameraWrapper) ((VideoCameraWrapper) Album.m33244a((Activity) this).mo37538c()).mo37528a(str)).mo37531a(this.f26168r).mo37532a(this.f26169s).mo37534b(this.f26170t).mo37527a(this.f26159C)).mo37533a();
    }

    /* renamed from: d */
    public void mo37616d() {
        m33392p();
        this.f26157A.mo37716a(R.string.album_converting);
    }

    /* renamed from: a */
    public void mo37610a(AlbumFile albumFile) {
        albumFile.mo37490a(!albumFile.mo37505f());
        if (!albumFile.mo37505f()) {
            m33380c(albumFile);
        } else if (this.f26171u) {
            m33380c(albumFile);
        } else {
            this.f26174x.mo37695a((CharSequence) getString(R.string.album_take_file_unavailable));
        }
        mo37620g();
    }

    /* renamed from: c */
    private void m33380c(AlbumFile albumFile) {
        if (this.f26161k != 0) {
            ArrayList b = ((AlbumFolder) this.f26160j.get(0)).mo37516b();
            if (b.size() > 0) {
                b.add(0, albumFile);
            } else {
                b.add(albumFile);
            }
        }
        AlbumFolder albumFolder = (AlbumFolder) this.f26160j.get(this.f26161k);
        ArrayList b2 = albumFolder.mo37516b();
        if (b2.isEmpty()) {
            b2.add(albumFile);
            this.f26174x.mo37591a(albumFolder);
        } else {
            b2.add(0, albumFile);
            this.f26174x.mo37589a((int) this.f26166p);
        }
        this.f26172v.add(albumFile);
        int size = this.f26172v.size();
        this.f26174x.mo37596c(size);
        C7731a aVar = this.f26174x;
        StringBuilder sb = new StringBuilder();
        sb.append(size);
        sb.append("/");
        sb.append(this.f26167q);
        aVar.mo37701d(sb.toString());
        int i = this.f26164n;
        if (i == 1) {
            return;
        }
        if (i == 2) {
            m33390n();
            return;
        }
        throw new AssertionError("This should not be the case.");
    }

    /* renamed from: a */
    public void mo37580a(CompoundButton compoundButton, int i) {
        int i2;
        AlbumFile albumFile = (AlbumFile) ((AlbumFolder) this.f26160j.get(this.f26161k)).mo37516b().get(i);
        if (!compoundButton.isChecked()) {
            albumFile.mo37490a(false);
            this.f26172v.remove(albumFile);
            m33389m();
        } else if (this.f26172v.size() >= this.f26167q) {
            int i3 = this.f26163m;
            if (i3 == 0) {
                i2 = R.plurals.album_check_image_limit;
            } else if (i3 == 1) {
                i2 = R.plurals.album_check_video_limit;
            } else if (i3 == 2) {
                i2 = R.plurals.album_check_album_limit;
            } else {
                throw new AssertionError("This should not be the case.");
            }
            C7731a aVar = this.f26174x;
            Resources resources = getResources();
            int i4 = this.f26167q;
            aVar.mo37695a((CharSequence) resources.getQuantityString(i2, i4, new Object[]{Integer.valueOf(i4)}));
            compoundButton.setChecked(false);
        } else {
            albumFile.mo37490a(true);
            this.f26172v.add(albumFile);
            m33389m();
        }
    }

    /* renamed from: m */
    private void m33389m() {
        int size = this.f26172v.size();
        this.f26174x.mo37596c(size);
        C7731a aVar = this.f26174x;
        StringBuilder sb = new StringBuilder();
        sb.append(size);
        sb.append("/");
        sb.append(this.f26167q);
        aVar.mo37701d(sb.toString());
    }

    /* renamed from: a */
    public void mo37579a(int i) {
        int i2 = this.f26164n;
        if (i2 == 1) {
            GalleryActivity.f26210a = ((AlbumFolder) this.f26160j.get(this.f26161k)).mo37516b();
            GalleryActivity.f26211b = this.f26172v.size();
            GalleryActivity.f26212c = i;
            GalleryActivity.f26213d = this;
            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putExtras(getIntent());
            startActivity(intent);
        } else if (i2 == 2) {
            this.f26172v.add((AlbumFile) ((AlbumFolder) this.f26160j.get(this.f26161k)).mo37516b().get(i));
            m33389m();
            m33390n();
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }

    /* renamed from: b */
    public void mo37581b() {
        if (this.f26172v.size() > 0) {
            GalleryActivity.f26210a = new ArrayList<>(this.f26172v);
            GalleryActivity.f26211b = this.f26172v.size();
            GalleryActivity.f26212c = 0;
            GalleryActivity.f26213d = this;
            Intent intent = new Intent(this, GalleryActivity.class);
            intent.putExtras(getIntent());
            startActivity(intent);
        }
    }

    /* renamed from: e */
    public void mo37617e() {
        m33390n();
    }

    /* renamed from: b */
    public void mo37614b(AlbumFile albumFile) {
        int indexOf = ((AlbumFolder) this.f26160j.get(this.f26161k)).mo37516b().indexOf(albumFile);
        if (this.f26166p) {
            indexOf++;
        }
        this.f26174x.mo37594b(indexOf);
        if (albumFile.mo37503e()) {
            if (!this.f26172v.contains(albumFile)) {
                this.f26172v.add(albumFile);
            }
        } else if (this.f26172v.contains(albumFile)) {
            this.f26172v.remove(albumFile);
        }
        m33389m();
    }

    /* renamed from: c */
    public void mo37582c() {
        int i;
        if (this.f26172v.isEmpty()) {
            int i2 = this.f26163m;
            if (i2 == 0) {
                i = R.string.album_check_image_little;
            } else if (i2 == 1) {
                i = R.string.album_check_video_little;
            } else if (i2 == 2) {
                i = R.string.album_check_album_little;
            } else {
                throw new AssertionError("This should not be the case.");
            }
            this.f26174x.mo37707g(i);
            return;
        }
        m33390n();
    }

    public void onBackPressed() {
        MediaReadTask aVar = this.f26158B;
        if (aVar != null) {
            aVar.cancel(true);
        }
        m33391o();
    }

    /* renamed from: n */
    private void m33390n() {
        new ThumbnailBuildTask(this, this.f26172v, this).execute(new Void[0]);
    }

    /* renamed from: f */
    public void mo37618f() {
        m33392p();
        this.f26157A.mo37716a(R.string.album_thumbnail);
    }

    /* renamed from: a */
    public void mo37611a(ArrayList<AlbumFile> arrayList) {
        Action<ArrayList<AlbumFile>> aVar = f26154d;
        if (aVar != null) {
            aVar.mo21403a(arrayList);
        }
        mo37620g();
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m33391o() {
        Action<String> aVar = f26155e;
        if (aVar != null) {
            aVar.mo21403a("User canceled.");
        }
        finish();
    }

    /* renamed from: p */
    private void m33392p() {
        if (this.f26157A == null) {
            this.f26157A = new LoadingDialog(this);
            this.f26157A.mo37717a(this.f26162l);
        }
        if (!this.f26157A.isShowing()) {
            this.f26157A.show();
        }
    }

    /* renamed from: g */
    public void mo37620g() {
        LoadingDialog loadingDialog = this.f26157A;
        if (loadingDialog != null && loadingDialog.isShowing()) {
            this.f26157A.dismiss();
        }
    }

    public void finish() {
        f26151a = null;
        f26152b = null;
        f26153c = null;
        f26154d = null;
        f26155e = null;
        super.finish();
    }
}
