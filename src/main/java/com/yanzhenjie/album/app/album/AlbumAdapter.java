package com.yanzhenjie.album.app.album;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.p628a.C7726c;
import com.yanzhenjie.album.p628a.OnCheckedClickListener;
import com.yanzhenjie.album.p629b.AlbumUtils;
import java.util.List;

public class AlbumAdapter extends Adapter<ViewHolder> {
    /* renamed from: a */
    private final LayoutInflater f26181a;
    /* renamed from: b */
    private final boolean f26182b;
    /* renamed from: c */
    private final int f26183c;
    /* renamed from: d */
    private final ColorStateList f26184d;
    /* renamed from: e */
    private List<AlbumFile> f26185e;
    /* renamed from: f */
    private C7726c f26186f;
    /* renamed from: g */
    private C7726c f26187g;
    /* renamed from: h */
    private OnCheckedClickListener f26188h;

    /* renamed from: com.yanzhenjie.album.app.album.AlbumAdapter$a */
    private static class C7738a extends ViewHolder implements OnClickListener {
        /* renamed from: a */
        private final C7726c f26189a;

        C7738a(View view, C7726c cVar) {
            super(view);
            this.f26189a = cVar;
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (this.f26189a != null && view == this.itemView) {
                this.f26189a.mo37526a(view, 0);
            }
        }
    }

    /* renamed from: com.yanzhenjie.album.app.album.AlbumAdapter$b */
    private static class C7739b extends C7740c implements OnClickListener {
        /* renamed from: a */
        private final boolean f26190a;
        /* renamed from: b */
        private final C7726c f26191b;
        /* renamed from: c */
        private final OnCheckedClickListener f26192c;
        /* renamed from: d */
        private ImageView f26193d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public AppCompatCheckBox f26194e;
        /* renamed from: f */
        private FrameLayout f26195f;

        C7739b(View view, boolean z, C7726c cVar, OnCheckedClickListener bVar) {
            super(view);
            this.f26190a = z;
            this.f26191b = cVar;
            this.f26192c = bVar;
            this.f26193d = (ImageView) view.findViewById(R.id.iv_album_content_image);
            this.f26194e = (AppCompatCheckBox) view.findViewById(R.id.check_box);
            this.f26195f = (FrameLayout) view.findViewById(R.id.layout_layer);
            view.setOnClickListener(this);
            this.f26194e.setOnClickListener(this);
            this.f26195f.setOnClickListener(this);
        }

        /* renamed from: a */
        public void mo37628a(AlbumFile albumFile) {
            this.f26194e.setChecked(albumFile.mo37503e());
            Album.m33246a().mo37673a().mo19816a(this.f26193d, albumFile);
            this.f26195f.setVisibility(albumFile.mo37505f() ? 0 : 8);
        }

        public void onClick(View view) {
            if (view == this.itemView) {
                this.f26191b.mo37526a(view, getAdapterPosition() - this.f26190a);
                return;
            }
            AppCompatCheckBox appCompatCheckBox = this.f26194e;
            if (view == appCompatCheckBox) {
                this.f26192c.mo37525a(appCompatCheckBox, getAdapterPosition() - this.f26190a);
            } else if (view == this.f26195f) {
                this.f26191b.mo37526a(view, getAdapterPosition() - this.f26190a);
            }
        }
    }

    /* renamed from: com.yanzhenjie.album.app.album.AlbumAdapter$c */
    private static abstract class C7740c extends ViewHolder {
        /* renamed from: a */
        public abstract void mo37628a(AlbumFile albumFile);

        public C7740c(View view) {
            super(view);
        }
    }

    /* renamed from: com.yanzhenjie.album.app.album.AlbumAdapter$d */
    private static class C7741d extends C7740c implements OnClickListener {
        /* renamed from: a */
        private final boolean f26196a;
        /* renamed from: b */
        private final C7726c f26197b;
        /* renamed from: c */
        private final OnCheckedClickListener f26198c;
        /* renamed from: d */
        private ImageView f26199d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public AppCompatCheckBox f26200e;
        /* renamed from: f */
        private TextView f26201f;
        /* renamed from: g */
        private FrameLayout f26202g;

        C7741d(View view, boolean z, C7726c cVar, OnCheckedClickListener bVar) {
            super(view);
            this.f26196a = z;
            this.f26197b = cVar;
            this.f26198c = bVar;
            this.f26199d = (ImageView) view.findViewById(R.id.iv_album_content_image);
            this.f26200e = (AppCompatCheckBox) view.findViewById(R.id.check_box);
            this.f26201f = (TextView) view.findViewById(R.id.tv_duration);
            this.f26202g = (FrameLayout) view.findViewById(R.id.layout_layer);
            view.setOnClickListener(this);
            this.f26200e.setOnClickListener(this);
            this.f26202g.setOnClickListener(this);
        }

        /* renamed from: a */
        public void mo37628a(AlbumFile albumFile) {
            Album.m33246a().mo37673a().mo19816a(this.f26199d, albumFile);
            this.f26200e.setChecked(albumFile.mo37503e());
            this.f26201f.setText(AlbumUtils.m33539a(albumFile.mo37496c()));
            this.f26202g.setVisibility(albumFile.mo37505f() ? 0 : 8);
        }

        public void onClick(View view) {
            if (view == this.itemView) {
                this.f26197b.mo37526a(view, getAdapterPosition() - this.f26196a);
                return;
            }
            AppCompatCheckBox appCompatCheckBox = this.f26200e;
            if (view == appCompatCheckBox) {
                this.f26198c.mo37525a(appCompatCheckBox, getAdapterPosition() - this.f26196a);
            } else if (view == this.f26202g) {
                C7726c cVar = this.f26197b;
                if (cVar != null) {
                    cVar.mo37526a(view, getAdapterPosition() - this.f26196a);
                }
            }
        }
    }

    public AlbumAdapter(Context context, boolean z, int i, ColorStateList colorStateList) {
        this.f26181a = LayoutInflater.from(context);
        this.f26182b = z;
        this.f26183c = i;
        this.f26184d = colorStateList;
    }

    /* renamed from: a */
    public void mo37625a(List<AlbumFile> list) {
        this.f26185e = list;
    }

    /* renamed from: a */
    public void mo37624a(C7726c cVar) {
        this.f26186f = cVar;
    }

    /* renamed from: b */
    public void mo37626b(C7726c cVar) {
        this.f26187g = cVar;
    }

    /* renamed from: a */
    public void mo37623a(OnCheckedClickListener bVar) {
        this.f26188h = bVar;
    }

    public int getItemCount() {
        boolean z = this.f26182b;
        List<AlbumFile> list = this.f26185e;
        return list == null ? z : z + list.size();
    }

    public int getItemViewType(int i) {
        int i2 = 2;
        if (i != 0) {
            if (this.f26182b) {
                i--;
            }
            if (((AlbumFile) this.f26185e.get(i)).mo37500d() == 2) {
                i2 = 3;
            }
            return i2;
        }
        if (this.f26182b) {
            i2 = 1;
        }
        return i2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new C7738a(this.f26181a.inflate(R.layout.album_item_content_button, viewGroup, false), this.f26186f);
        }
        if (i == 2) {
            C7739b bVar = new C7739b(this.f26181a.inflate(R.layout.album_item_content_image, viewGroup, false), this.f26182b, this.f26187g, this.f26188h);
            if (this.f26183c == 1) {
                bVar.f26194e.setVisibility(0);
                bVar.f26194e.setSupportButtonTintList(this.f26184d);
                bVar.f26194e.setTextColor(this.f26184d);
            } else {
                bVar.f26194e.setVisibility(8);
            }
            return bVar;
        } else if (i == 3) {
            C7741d dVar = new C7741d(this.f26181a.inflate(R.layout.album_item_content_video, viewGroup, false), this.f26182b, this.f26187g, this.f26188h);
            if (this.f26183c == 1) {
                dVar.f26200e.setVisibility(0);
                dVar.f26200e.setSupportButtonTintList(this.f26184d);
                dVar.f26200e.setTextColor(this.f26184d);
            } else {
                dVar.f26200e.setVisibility(8);
            }
            return dVar;
        } else {
            throw new AssertionError("This should not be the case.");
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            return;
        }
        if (itemViewType == 2 || itemViewType == 3) {
            ((C7740c) viewHolder).mo37628a((AlbumFile) this.f26185e.get(viewHolder.getAdapterPosition() - this.f26182b));
            return;
        }
        throw new AssertionError("This should not be the case.");
    }
}
