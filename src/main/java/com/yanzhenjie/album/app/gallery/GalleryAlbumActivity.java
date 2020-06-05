package com.yanzhenjie.album.app.gallery;

import android.os.Bundle;
import android.view.View;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.ItemAction;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.C7732b;
import com.yanzhenjie.album.app.Contract.GalleryPresenter;
import com.yanzhenjie.album.mvp.BaseActivity;
import com.yanzhenjie.album.p628a.C7726c;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class GalleryAlbumActivity extends BaseActivity implements GalleryPresenter {
    /* renamed from: a */
    public static Action<ArrayList<AlbumFile>> f26299a;
    /* renamed from: b */
    public static Action<String> f26300b;
    /* renamed from: c */
    public static ItemAction<AlbumFile> f26301c;
    /* renamed from: d */
    public static ItemAction<AlbumFile> f26302d;
    /* renamed from: e */
    static final /* synthetic */ boolean f26303e = (!GalleryAlbumActivity.class.desiredAssertionStatus());
    /* renamed from: f */
    private Widget f26304f;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public ArrayList<AlbumFile> f26305j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f26306k;
    /* renamed from: l */
    private boolean f26307l;
    /* renamed from: m */
    private C7732b<AlbumFile> f26308m;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_activity_gallery);
        this.f26308m = new GalleryView(this, this);
        Bundle extras = getIntent().getExtras();
        if (f26303e || extras != null) {
            this.f26304f = (Widget) extras.getParcelable("KEY_INPUT_WIDGET");
            this.f26305j = extras.getParcelableArrayList("KEY_INPUT_CHECKED_LIST");
            this.f26306k = extras.getInt("KEY_INPUT_CURRENT_POSITION");
            this.f26307l = extras.getBoolean("KEY_INPUT_GALLERY_CHECKABLE");
            this.f26308m.mo37698c(this.f26304f.mo37550e());
            this.f26308m.mo37598a(this.f26304f, this.f26307l);
            PreviewAlbumAdapter previewAlbumAdapter = new PreviewAlbumAdapter(this, this.f26305j);
            if (f26301c != null) {
                previewAlbumAdapter.mo37666a(new C7726c() {
                    /* renamed from: a */
                    public void mo37526a(View view, int i) {
                        ItemAction<AlbumFile> eVar = GalleryAlbumActivity.f26301c;
                        GalleryAlbumActivity galleryAlbumActivity = GalleryAlbumActivity.this;
                        eVar.mo37678a(galleryAlbumActivity, galleryAlbumActivity.f26305j.get(GalleryAlbumActivity.this.f26306k));
                    }
                });
            }
            if (f26302d != null) {
                previewAlbumAdapter.mo37667b(new C7726c() {
                    /* renamed from: a */
                    public void mo37526a(View view, int i) {
                        ItemAction<AlbumFile> eVar = GalleryAlbumActivity.f26302d;
                        GalleryAlbumActivity galleryAlbumActivity = GalleryAlbumActivity.this;
                        eVar.mo37678a(galleryAlbumActivity, galleryAlbumActivity.f26305j.get(GalleryAlbumActivity.this.f26306k));
                    }
                });
            }
            this.f26308m.mo37599a((PreviewAdapter<Data>) previewAlbumAdapter);
            int i = this.f26306k;
            if (i == 0) {
                mo37585a(i);
            } else {
                this.f26308m.mo37597a(i);
            }
            m33504c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private void m33504c() {
        Iterator it = this.f26305j.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((AlbumFile) it.next()).mo37503e()) {
                i++;
            }
        }
        String string = getString(R.string.album_menu_finish);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        sb.append(i);
        sb.append(" / ");
        sb.append(this.f26305j.size());
        sb.append(")");
        this.f26308m.mo37602b(sb.toString());
    }

    /* renamed from: a */
    public void mo37585a(int i) {
        this.f26306k = i;
        C7732b<AlbumFile> bVar = this.f26308m;
        StringBuilder sb = new StringBuilder();
        sb.append(i + 1);
        sb.append(" / ");
        sb.append(this.f26305j.size());
        bVar.mo37701d(sb.toString());
        AlbumFile albumFile = (AlbumFile) this.f26305j.get(i);
        if (this.f26307l) {
            this.f26308m.mo37603b(albumFile.mo37503e());
        }
        this.f26308m.mo37605d(albumFile.mo37505f());
        if (albumFile.mo37500d() == 2) {
            if (!this.f26307l) {
                this.f26308m.mo37604c(true);
            }
            this.f26308m.mo37600a(AlbumUtils.m33539a(albumFile.mo37496c()));
            this.f26308m.mo37601a(true);
            return;
        }
        if (!this.f26307l) {
            this.f26308m.mo37604c(false);
        }
        this.f26308m.mo37601a(false);
    }

    /* renamed from: a */
    public void mo37584a() {
        AlbumFile albumFile = (AlbumFile) this.f26305j.get(this.f26306k);
        albumFile.mo37490a(!albumFile.mo37503e());
        m33504c();
    }

    /* renamed from: b */
    public void mo37586b() {
        if (f26299a != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f26305j.iterator();
            while (it.hasNext()) {
                AlbumFile albumFile = (AlbumFile) it.next();
                if (albumFile.mo37503e()) {
                    arrayList.add(albumFile);
                }
            }
            f26299a.mo21403a(arrayList);
        }
        finish();
    }

    public void onBackPressed() {
        Action<String> aVar = f26300b;
        if (aVar != null) {
            aVar.mo21403a("User canceled.");
        }
        finish();
    }

    public void finish() {
        f26299a = null;
        f26300b = null;
        f26301c = null;
        f26302d = null;
        super.finish();
    }
}
