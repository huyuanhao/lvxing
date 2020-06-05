package com.yanzhenjie.album.app.album;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.AlbumFolder;
import com.yanzhenjie.album.R;
import com.yanzhenjie.album.p628a.C7726c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yanzhenjie.album.app.album.b */
class FolderAdapter extends Adapter<C7749a> {
    /* renamed from: a */
    private LayoutInflater f26240a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<AlbumFolder> f26241b;
    /* renamed from: c */
    private ColorStateList f26242c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C7726c f26243d;

    /* compiled from: FolderAdapter */
    /* renamed from: com.yanzhenjie.album.app.album.b$a */
    static class C7749a extends ViewHolder implements OnClickListener {
        /* renamed from: a */
        private C7726c f26246a;
        /* renamed from: b */
        private ImageView f26247b;
        /* renamed from: c */
        private TextView f26248c;
        /* renamed from: d */
        private AppCompatRadioButton f26249d;

        private C7749a(View view, ColorStateList colorStateList, C7726c cVar) {
            super(view);
            this.f26246a = cVar;
            this.f26247b = (ImageView) view.findViewById(R.id.iv_gallery_preview_image);
            this.f26248c = (TextView) view.findViewById(R.id.tv_gallery_preview_title);
            this.f26249d = (AppCompatRadioButton) view.findViewById(R.id.rb_gallery_preview_check);
            view.setOnClickListener(this);
            this.f26249d.setSupportButtonTintList(colorStateList);
        }

        /* renamed from: a */
        public void mo37639a(AlbumFolder albumFolder) {
            ArrayList b = albumFolder.mo37516b();
            TextView textView = this.f26248c;
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(b.size());
            sb.append(") ");
            sb.append(albumFolder.mo37512a());
            textView.setText(sb.toString());
            this.f26249d.setChecked(albumFolder.mo37517c());
            Album.m33246a().mo37673a().mo19816a(this.f26247b, (AlbumFile) b.get(0));
        }

        public void onClick(View view) {
            C7726c cVar = this.f26246a;
            if (cVar != null) {
                cVar.mo37526a(view, getAdapterPosition());
            }
        }
    }

    public FolderAdapter(Context context, List<AlbumFolder> list, ColorStateList colorStateList) {
        this.f26240a = LayoutInflater.from(context);
        this.f26242c = colorStateList;
        this.f26241b = list;
    }

    /* renamed from: a */
    public void mo37637a(C7726c cVar) {
        this.f26243d = cVar;
    }

    /* renamed from: a */
    public C7749a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C7749a(this.f26240a.inflate(R.layout.album_item_dialog_folder, viewGroup, false), this.f26242c, new C7726c() {
            /* renamed from: b */
            private int f26245b = 0;

            /* renamed from: a */
            public void mo37526a(View view, int i) {
                if (FolderAdapter.this.f26243d != null) {
                    FolderAdapter.this.f26243d.mo37526a(view, i);
                }
                AlbumFolder albumFolder = (AlbumFolder) FolderAdapter.this.f26241b.get(i);
                if (!albumFolder.mo37517c()) {
                    albumFolder.mo37515a(true);
                    ((AlbumFolder) FolderAdapter.this.f26241b.get(this.f26245b)).mo37515a(false);
                    FolderAdapter.this.notifyItemChanged(this.f26245b);
                    FolderAdapter.this.notifyItemChanged(i);
                    this.f26245b = i;
                }
            }
        });
    }

    /* renamed from: a */
    public void onBindViewHolder(C7749a aVar, int i) {
        aVar.mo37639a((AlbumFolder) this.f26241b.get(aVar.getAdapterPosition()));
    }

    public int getItemCount() {
        List<AlbumFolder> list = this.f26241b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
