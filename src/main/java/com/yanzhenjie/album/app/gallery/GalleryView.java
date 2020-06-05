package com.yanzhenjie.album.app.gallery;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.C7732b;
import com.yanzhenjie.album.app.Contract.GalleryPresenter;
import com.yanzhenjie.album.p629b.SystemBar;

/* renamed from: com.yanzhenjie.album.app.gallery.a */
public class GalleryView<Data> extends C7732b<Data> implements OnClickListener {
    /* renamed from: a */
    private Activity f26315a;
    /* renamed from: b */
    private MenuItem f26316b;
    /* renamed from: c */
    private ViewPager f26317c;
    /* renamed from: d */
    private RelativeLayout f26318d;
    /* renamed from: e */
    private TextView f26319e;
    /* renamed from: f */
    private AppCompatCheckBox f26320f;
    /* renamed from: g */
    private FrameLayout f26321g;

    public GalleryView(Activity activity, GalleryPresenter galleryPresenter) {
        super(activity, galleryPresenter);
        this.f26315a = activity;
        this.f26317c = (ViewPager) activity.findViewById(R.id.view_pager);
        this.f26318d = (RelativeLayout) activity.findViewById(R.id.layout_bottom);
        this.f26319e = (TextView) activity.findViewById(R.id.tv_duration);
        this.f26320f = (AppCompatCheckBox) activity.findViewById(R.id.check_box);
        this.f26321g = (FrameLayout) activity.findViewById(R.id.layout_layer);
        this.f26320f.setOnClickListener(this);
        this.f26321g.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37633a(Menu menu) {
        mo37706g().inflate(R.menu.album_menu_gallery, menu);
        this.f26316b = menu.findItem(R.id.album_menu_finish);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37634a(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.album_menu_finish) {
            ((GalleryPresenter) mo37693a()).mo37586b();
        }
    }

    /* renamed from: a */
    public void mo37598a(Widget widget, boolean z) {
        SystemBar.m33555a(this.f26315a);
        SystemBar.m33561b(this.f26315a);
        SystemBar.m33556a(this.f26315a, 0);
        SystemBar.m33562b(this.f26315a, mo37704f(R.color.albumSheetBottom));
        mo37700d(R.drawable.album_ic_back_white);
        if (!z) {
            this.f26316b.setVisible(false);
            this.f26320f.setVisibility(8);
        } else {
            ColorStateList f = widget.mo37551f();
            this.f26320f.setSupportButtonTintList(f);
            this.f26320f.setTextColor(f);
        }
        this.f26317c.addOnPageChangeListener(new SimpleOnPageChangeListener() {
            public void onPageSelected(int i) {
                ((GalleryPresenter) GalleryView.this.mo37693a()).mo37585a(i);
            }
        });
    }

    /* renamed from: a */
    public void mo37599a(PreviewAdapter<Data> previewAdapter) {
        if (previewAdapter.getCount() > 3) {
            this.f26317c.setOffscreenPageLimit(3);
        } else if (previewAdapter.getCount() > 2) {
            this.f26317c.setOffscreenPageLimit(2);
        }
        this.f26317c.setAdapter(previewAdapter);
    }

    /* renamed from: a */
    public void mo37597a(int i) {
        this.f26317c.setCurrentItem(i);
    }

    /* renamed from: a */
    public void mo37601a(boolean z) {
        this.f26319e.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    public void mo37600a(String str) {
        this.f26319e.setText(str);
    }

    /* renamed from: b */
    public void mo37603b(boolean z) {
        this.f26320f.setChecked(z);
    }

    /* renamed from: c */
    public void mo37604c(boolean z) {
        this.f26318d.setVisibility(z ? 0 : 8);
    }

    /* renamed from: d */
    public void mo37605d(boolean z) {
        this.f26321g.setVisibility(z ? 0 : 8);
    }

    /* renamed from: b */
    public void mo37602b(String str) {
        this.f26316b.setTitle(str);
    }

    public void onClick(View view) {
        if (view == this.f26320f) {
            ((GalleryPresenter) mo37693a()).mo37584a();
        } else {
            FrameLayout frameLayout = this.f26321g;
        }
    }
}
