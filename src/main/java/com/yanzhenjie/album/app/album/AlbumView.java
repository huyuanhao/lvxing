package com.yanzhenjie.album.app.album;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.api.widget.Widget;
import com.yanzhenjie.album.app.Contract.AlbumPresenter;
import com.yanzhenjie.album.app.Contract.C7731a;
import com.yanzhenjie.album.p628a.C7726c;
import com.yanzhenjie.album.p628a.DoubleClickWrapper;
import com.yanzhenjie.album.p628a.OnCheckedClickListener;
import com.yanzhenjie.album.p629b.AlbumUtils;
import com.yanzhenjie.album.p629b.SystemBar;
import com.yanzhenjie.album.widget.ColorProgressBar;
import com.yanzhenjie.album.widget.divider.Api21ItemDivider;
import java.util.List;

/* renamed from: com.yanzhenjie.album.app.album.a */
class AlbumView extends C7731a implements OnClickListener {
    /* renamed from: a */
    private Activity f26227a;
    /* renamed from: b */
    private Toolbar f26228b;
    /* renamed from: c */
    private MenuItem f26229c;
    /* renamed from: d */
    private RecyclerView f26230d;
    /* renamed from: e */
    private GridLayoutManager f26231e;
    /* renamed from: f */
    private AlbumAdapter f26232f;
    /* renamed from: g */
    private Button f26233g;
    /* renamed from: h */
    private Button f26234h;
    /* renamed from: i */
    private LinearLayout f26235i;
    /* renamed from: j */
    private ColorProgressBar f26236j;

    public AlbumView(Activity activity, AlbumPresenter albumPresenter) {
        super(activity, albumPresenter);
        this.f26227a = activity;
        this.f26228b = (Toolbar) activity.findViewById(R.id.toolbar);
        this.f26230d = (RecyclerView) activity.findViewById(R.id.recycler_view);
        this.f26234h = (Button) activity.findViewById(R.id.btn_switch_dir);
        this.f26233g = (Button) activity.findViewById(R.id.btn_preview);
        this.f26235i = (LinearLayout) activity.findViewById(R.id.layout_loading);
        this.f26236j = (ColorProgressBar) activity.findViewById(R.id.progress_bar);
        this.f26228b.setOnClickListener(new DoubleClickWrapper(this));
        this.f26234h.setOnClickListener(this);
        this.f26233g.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37633a(Menu menu) {
        mo37706g().inflate(R.menu.album_menu_album, menu);
        this.f26229c = menu.findItem(R.id.album_menu_finish);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo37634a(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.album_menu_finish) {
            ((AlbumPresenter) mo37693a()).mo37582c();
        }
    }

    /* renamed from: a */
    public void mo37592a(Widget widget, int i, boolean z, int i2) {
        SystemBar.m33562b(this.f26227a, widget.mo37548d());
        int b = widget.mo37546b();
        if (widget.mo37545a() == 1) {
            if (SystemBar.m33559a(this.f26227a, true)) {
                SystemBar.m33556a(this.f26227a, b);
            } else {
                SystemBar.m33556a(this.f26227a, mo37704f(R.color.albumColorPrimaryBlack));
            }
            this.f26236j.setColorFilter(mo37704f(R.color.albumLoadingDark));
            Drawable e = mo37702e(R.drawable.album_ic_back_white);
            AlbumUtils.m33545a(e, mo37704f(R.color.albumIconDark));
            mo37694a(e);
            Drawable icon = this.f26229c.getIcon();
            AlbumUtils.m33545a(icon, mo37704f(R.color.albumIconDark));
            this.f26229c.setIcon(icon);
        } else {
            this.f26236j.setColorFilter(widget.mo37547c());
            SystemBar.m33556a(this.f26227a, b);
            mo37700d(R.drawable.album_ic_back_white);
        }
        this.f26228b.setBackgroundColor(widget.mo37547c());
        this.f26231e = new GridLayoutManager(mo37710j(), i, m33437b(this.f26227a.getResources().getConfiguration()), false);
        this.f26230d.setLayoutManager(this.f26231e);
        int dimensionPixelSize = mo37711k().getDimensionPixelSize(R.dimen.album_dp_4);
        this.f26230d.addItemDecoration(new Api21ItemDivider(0, dimensionPixelSize, dimensionPixelSize));
        this.f26232f = new AlbumAdapter(mo37710j(), z, i2, widget.mo37551f());
        this.f26232f.mo37624a((C7726c) new C7726c() {
            /* renamed from: a */
            public void mo37526a(View view, int i) {
                ((AlbumPresenter) AlbumView.this.mo37693a()).clickCamera(view);
            }
        });
        this.f26232f.mo37623a((OnCheckedClickListener) new OnCheckedClickListener() {
            /* renamed from: a */
            public void mo37525a(CompoundButton compoundButton, int i) {
                ((AlbumPresenter) AlbumView.this.mo37693a()).mo37580a(compoundButton, i);
            }
        });
        this.f26232f.mo37626b(new C7726c() {
            /* renamed from: a */
            public void mo37526a(View view, int i) {
                ((AlbumPresenter) AlbumView.this.mo37693a()).mo37579a(i);
            }
        });
        this.f26230d.setAdapter(this.f26232f);
    }

    /* renamed from: a */
    public void mo37593a(boolean z) {
        this.f26235i.setVisibility(z ? 0 : 8);
    }

    /* renamed from: a */
    public void mo37590a(Configuration configuration) {
        int findFirstVisibleItemPosition = this.f26231e.findFirstVisibleItemPosition();
        this.f26231e.setOrientation(m33437b(configuration));
        this.f26230d.setAdapter(this.f26232f);
        this.f26231e.scrollToPosition(findFirstVisibleItemPosition);
    }

    /* renamed from: b */
    private int m33437b(Configuration configuration) {
        int i = configuration.orientation;
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 0;
        }
        throw new AssertionError("This should not be the case.");
    }

    /* renamed from: b */
    public void mo37595b(boolean z) {
        this.f26229c.setVisible(z);
    }

    /* renamed from: a */
    public void mo37591a(AlbumFolder albumFolder) {
        this.f26234h.setText(albumFolder.mo37512a());
        this.f26232f.mo37625a((List<AlbumFile>) albumFolder.mo37516b());
        this.f26232f.notifyDataSetChanged();
        this.f26230d.scrollToPosition(0);
    }

    /* renamed from: a */
    public void mo37589a(int i) {
        this.f26232f.notifyItemInserted(i);
    }

    /* renamed from: b */
    public void mo37594b(int i) {
        this.f26232f.notifyItemChanged(i);
    }

    /* renamed from: c */
    public void mo37596c(int i) {
        Button button = this.f26233g;
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        sb.append(i);
        sb.append(")");
        button.setText(sb.toString());
    }

    public void onClick(View view) {
        if (view == this.f26228b) {
            this.f26230d.smoothScrollToPosition(0);
        } else if (view == this.f26234h) {
            ((AlbumPresenter) mo37693a()).mo37578a();
        } else if (view == this.f26233g) {
            ((AlbumPresenter) mo37693a()).mo37581b();
        }
    }
}
