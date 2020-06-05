package com.yanzhenjie.album.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.widget.CompoundButton;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.gallery.PreviewAdapter;
import com.yanzhenjie.album.mvp.BasePresenter;
import com.yanzhenjie.album.mvp.BaseView;

public final class Contract {

    /* renamed from: com.yanzhenjie.album.app.Contract$AlbumPresenter */
    public interface AlbumPresenter extends BasePresenter {
        /* renamed from: a */
        void mo37578a();

        /* renamed from: a */
        void mo37579a(int i);

        /* renamed from: a */
        void mo37580a(CompoundButton compoundButton, int i);

        /* renamed from: b */
        void mo37581b();

        /* renamed from: c */
        void mo37582c();

        void clickCamera(View view);
    }

    /* renamed from: com.yanzhenjie.album.app.Contract$GalleryPresenter */
    public interface GalleryPresenter extends BasePresenter {
        /* renamed from: a */
        void mo37584a();

        /* renamed from: a */
        void mo37585a(int i);

        /* renamed from: b */
        void mo37586b();
    }

    /* renamed from: com.yanzhenjie.album.app.Contract$NullPresenter */
    public interface NullPresenter extends BasePresenter {
        /* renamed from: a */
        void mo37587a();

        /* renamed from: b */
        void mo37588b();
    }

    /* renamed from: com.yanzhenjie.album.app.Contract$a */
    public static abstract class C7731a extends BaseView<AlbumPresenter> {
        /* renamed from: a */
        public abstract void mo37589a(int i);

        /* renamed from: a */
        public abstract void mo37590a(Configuration configuration);

        /* renamed from: a */
        public abstract void mo37591a(AlbumFolder albumFolder);

        /* renamed from: a */
        public abstract void mo37592a(Widget widget, int i, boolean z, int i2);

        /* renamed from: a */
        public abstract void mo37593a(boolean z);

        /* renamed from: b */
        public abstract void mo37594b(int i);

        /* renamed from: b */
        public abstract void mo37595b(boolean z);

        /* renamed from: c */
        public abstract void mo37596c(int i);

        public C7731a(Activity activity, AlbumPresenter albumPresenter) {
            super(activity, albumPresenter);
        }
    }

    /* renamed from: com.yanzhenjie.album.app.Contract$b */
    public static abstract class C7732b<Data> extends BaseView<GalleryPresenter> {
        /* renamed from: a */
        public abstract void mo37597a(int i);

        /* renamed from: a */
        public abstract void mo37598a(Widget widget, boolean z);

        /* renamed from: a */
        public abstract void mo37599a(PreviewAdapter<Data> previewAdapter);

        /* renamed from: a */
        public abstract void mo37600a(String str);

        /* renamed from: a */
        public abstract void mo37601a(boolean z);

        /* renamed from: b */
        public abstract void mo37602b(String str);

        /* renamed from: b */
        public abstract void mo37603b(boolean z);

        /* renamed from: c */
        public abstract void mo37604c(boolean z);

        /* renamed from: d */
        public abstract void mo37605d(boolean z);

        public C7732b(Activity activity, GalleryPresenter galleryPresenter) {
            super(activity, galleryPresenter);
        }
    }

    /* renamed from: com.yanzhenjie.album.app.Contract$c */
    public static abstract class C7733c extends BaseView<NullPresenter> {
        /* renamed from: a */
        public abstract void mo37606a(int i);

        /* renamed from: a */
        public abstract void mo37607a(Widget widget);

        /* renamed from: a */
        public abstract void mo37608a(boolean z);

        /* renamed from: b */
        public abstract void mo37609b(boolean z);

        public C7733c(Activity activity, NullPresenter nullPresenter) {
            super(activity, nullPresenter);
        }
    }
}
