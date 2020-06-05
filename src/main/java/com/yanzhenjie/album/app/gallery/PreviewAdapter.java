package com.yanzhenjie.album.app.gallery;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.yanzhenjie.album.p628a.C7726c;
import com.yanzhenjie.album.widget.photoview.AttacherImageView;
import com.yanzhenjie.album.widget.photoview.PhotoViewAttacher;
import java.util.List;

public abstract class PreviewAdapter<T> extends PagerAdapter implements OnClickListener, OnLongClickListener {
    /* renamed from: a */
    private Context f26311a;
    /* renamed from: b */
    private List<T> f26312b;
    /* renamed from: c */
    private C7726c f26313c;
    /* renamed from: d */
    private C7726c f26314d;

    /* renamed from: a */
    public abstract void mo37665a(ImageView imageView, T t, int i);

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public PreviewAdapter(Context context, List<T> list) {
        this.f26311a = context;
        this.f26312b = list;
    }

    /* renamed from: a */
    public void mo37666a(C7726c cVar) {
        this.f26313c = cVar;
    }

    /* renamed from: b */
    public void mo37667b(C7726c cVar) {
        this.f26314d = cVar;
    }

    public int getCount() {
        List<T> list = this.f26312b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        AttacherImageView attacherImageView = new AttacherImageView(this.f26311a);
        attacherImageView.setLayoutParams(new LayoutParams(-1, -1));
        attacherImageView.setAttacher(new PhotoViewAttacher(attacherImageView));
        mo37665a(attacherImageView, this.f26312b.get(i), i);
        attacherImageView.setId(i);
        if (this.f26313c != null) {
            attacherImageView.setOnClickListener(this);
        }
        if (this.f26314d != null) {
            attacherImageView.setOnLongClickListener(this);
        }
        viewGroup.addView(attacherImageView);
        return attacherImageView;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void onClick(View view) {
        this.f26313c.mo37526a(view, view.getId());
    }

    public boolean onLongClick(View view) {
        this.f26314d.mo37526a(view, view.getId());
        return true;
    }
}
