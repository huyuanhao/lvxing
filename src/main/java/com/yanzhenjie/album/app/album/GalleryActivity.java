package com.yanzhenjie.album.app.album;

import android.content.res.Resources;
import android.os.Bundle;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.C7732b;
import com.yanzhenjie.album.app.Contract.GalleryPresenter;
import com.yanzhenjie.album.app.gallery.GalleryView;
import com.yanzhenjie.album.app.gallery.PreviewAdapter;
import com.yanzhenjie.album.app.gallery.PreviewAlbumAdapter;
import com.yanzhenjie.album.mvp.BaseActivity;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.util.ArrayList;

public class GalleryActivity extends BaseActivity implements GalleryPresenter {
    /* renamed from: a */
    public static ArrayList<AlbumFile> f26210a;
    /* renamed from: b */
    public static int f26211b;
    /* renamed from: c */
    public static int f26212c;
    /* renamed from: d */
    public static C7743a f26213d;
    /* renamed from: e */
    static final /* synthetic */ boolean f26214e = (!GalleryActivity.class.desiredAssertionStatus());
    /* renamed from: f */
    private Widget f26215f;
    /* renamed from: j */
    private int f26216j;
    /* renamed from: k */
    private int f26217k;
    /* renamed from: l */
    private C7732b<AlbumFile> f26218l;

    /* renamed from: com.yanzhenjie.album.app.album.GalleryActivity$a */
    public interface C7743a {
        /* renamed from: b */
        void mo37614b(AlbumFile albumFile);

        /* renamed from: e */
        void mo37617e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.album_activity_gallery);
        this.f26218l = new GalleryView(this, this);
        Bundle extras = getIntent().getExtras();
        if (f26214e || extras != null) {
            this.f26215f = (Widget) extras.getParcelable("KEY_INPUT_WIDGET");
            this.f26216j = extras.getInt("KEY_INPUT_FUNCTION");
            this.f26217k = extras.getInt("KEY_INPUT_LIMIT_COUNT");
            this.f26218l.mo37598a(this.f26215f, true);
            this.f26218l.mo37599a((PreviewAdapter<Data>) new PreviewAlbumAdapter<Data>(this, f26210a));
            int i = f26212c;
            if (i == 0) {
                mo37585a(i);
            } else {
                this.f26218l.mo37597a(i);
            }
            m33426c();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private void m33426c() {
        String string = getString(R.string.album_menu_finish);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        sb.append(f26211b);
        sb.append(" / ");
        sb.append(this.f26217k);
        sb.append(")");
        this.f26218l.mo37602b(sb.toString());
    }

    /* renamed from: a */
    public void mo37585a(int i) {
        f26212c = i;
        C7732b<AlbumFile> bVar = this.f26218l;
        StringBuilder sb = new StringBuilder();
        sb.append(f26212c + 1);
        sb.append(" / ");
        sb.append(f26210a.size());
        bVar.mo37698c(sb.toString());
        AlbumFile albumFile = (AlbumFile) f26210a.get(i);
        this.f26218l.mo37603b(albumFile.mo37503e());
        this.f26218l.mo37605d(albumFile.mo37505f());
        if (albumFile.mo37500d() == 2) {
            this.f26218l.mo37600a(AlbumUtils.m33539a(albumFile.mo37496c()));
            this.f26218l.mo37601a(true);
            return;
        }
        this.f26218l.mo37601a(false);
    }

    /* renamed from: a */
    public void mo37584a() {
        int i;
        AlbumFile albumFile = (AlbumFile) f26210a.get(f26212c);
        if (albumFile.mo37503e()) {
            albumFile.mo37490a(false);
            f26213d.mo37614b(albumFile);
            f26211b--;
        } else if (f26211b >= this.f26217k) {
            int i2 = this.f26216j;
            if (i2 == 0) {
                i = R.plurals.album_check_image_limit;
            } else if (i2 == 1) {
                i = R.plurals.album_check_video_limit;
            } else if (i2 == 2) {
                i = R.plurals.album_check_album_limit;
            } else {
                throw new AssertionError("This should not be the case.");
            }
            C7732b<AlbumFile> bVar = this.f26218l;
            Resources resources = getResources();
            int i3 = this.f26217k;
            bVar.mo37695a((CharSequence) resources.getQuantityString(i, i3, new Object[]{Integer.valueOf(i3)}));
            this.f26218l.mo37603b(false);
        } else {
            albumFile.mo37490a(true);
            f26213d.mo37614b(albumFile);
            f26211b++;
        }
        m33426c();
    }

    /* renamed from: b */
    public void mo37586b() {
        int i;
        if (f26211b == 0) {
            int i2 = this.f26216j;
            if (i2 == 0) {
                i = R.string.album_check_image_little;
            } else if (i2 == 1) {
                i = R.string.album_check_video_little;
            } else if (i2 == 2) {
                i = R.string.album_check_album_little;
            } else {
                throw new AssertionError("This should not be the case.");
            }
            this.f26218l.mo37707g(i);
            return;
        }
        f26213d.mo37617e();
        finish();
    }

    public void onBackPressed() {
        finish();
    }

    public void finish() {
        f26210a = null;
        f26211b = 0;
        f26212c = 0;
        f26213d = null;
        super.finish();
    }
}
