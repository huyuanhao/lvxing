package com.qiyukf.nim.uikit.common.media.picker.p422a;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.common.media.picker.activity.CheckboxImageView;
import com.qiyukf.nim.uikit.common.media.picker.fragment.PickerImageFragment.C5467a;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5462a;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5464c;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.a.b */
public final class C5452b extends BaseAdapter {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Context f17477a;
    /* renamed from: b */
    private LayoutInflater f17478b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<PhotoInfo> f17479c;
    /* renamed from: d */
    private GridView f17480d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f17481e = 0;
    /* renamed from: f */
    private int f17482f = (C5412d.m22145a() / 4);
    /* renamed from: g */
    private boolean f17483g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public int f17484h;
    /* renamed from: i */
    private int f17485i = 1;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public C5467a f17486j;

    /* renamed from: com.qiyukf.nim.uikit.common.media.picker.a.b$a */
    private class C5455a {
        /* renamed from: a */
        public ImageView f17493a;
        /* renamed from: b */
        public CheckboxImageView f17494b;
        /* renamed from: c */
        public RelativeLayout f17495c;

        private C5455a() {
        }

        /* synthetic */ C5455a(C5452b bVar, byte b) {
            this();
        }
    }

    public C5452b(Context context, List<PhotoInfo> list, GridView gridView, boolean z, int i, int i2, int i3) {
        this.f17477a = context;
        this.f17478b = LayoutInflater.from(context);
        this.f17479c = list;
        this.f17480d = gridView;
        this.f17483g = z;
        this.f17481e = i;
        this.f17484h = i2;
        this.f17485i = i3;
        if (this.f17486j == null) {
            this.f17486j = (C5467a) context;
        }
        this.f17482f = i3 == 2 ? C5412d.m22145a() / 6 : C5412d.m22145a() / 4;
    }

    /* renamed from: a */
    public final void mo27457a(int i) {
        this.f17481e = i;
    }

    /* renamed from: a */
    public final void mo27458a(Configuration configuration) {
        this.f17485i = configuration.orientation;
        if (this.f17480d != null) {
            if (this.f17485i == 2) {
                this.f17482f = C5412d.m22145a() / 6;
                return;
            }
            this.f17482f = C5412d.m22145a() / 4;
        }
    }

    public final int getCount() {
        return this.f17479c.size();
    }

    public final Object getItem(int i) {
        return this.f17479c.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        final C5455a aVar;
        View view2;
        if (view == null) {
            aVar = new C5455a(this, 0);
            view2 = this.f17478b.inflate(C5961R.C5964layout.ysf_picker_photo_grid_item, null);
            aVar.f17493a = (ImageView) view2.findViewById(C5961R.C5963id.picker_photo_grid_item_img);
            aVar.f17494b = (CheckboxImageView) view2.findViewById(C5961R.C5963id.picker_photo_grid_item_select);
            aVar.f17495c = (RelativeLayout) view2.findViewById(C5961R.C5963id.picker_photo_grid_item_select_hotpot);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (C5455a) view.getTag();
        }
        if (this.f17483g) {
            aVar.f17495c.setVisibility(0);
        } else {
            aVar.f17495c.setVisibility(8);
        }
        LayoutParams layoutParams = aVar.f17495c.getLayoutParams();
        int i2 = this.f17482f;
        layoutParams.width = i2 / 2;
        layoutParams.height = i2 / 2;
        aVar.f17495c.setLayoutParams(layoutParams);
        aVar.f17495c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PhotoInfo photoInfo = (PhotoInfo) C5452b.this.f17479c.get(i);
                if (photoInfo.isChoose()) {
                    photoInfo.setChoose(false);
                    C5452b.this.f17481e = C5452b.this.f17481e - 1;
                } else if (C5452b.this.f17481e < C5452b.this.f17484h) {
                    photoInfo.setChoose(true);
                    C5452b.this.f17481e = C5452b.this.f17481e + 1;
                } else {
                    C5415g.m22166b(String.format(C5452b.this.f17477a.getResources().getString(C5961R.string.ysf_picker_image_exceed_max_image_select), new Object[]{Integer.valueOf(C5452b.this.f17484h)}));
                    return;
                }
                ((C5455a) C5452b.this.f17480d.getChildAt(i - C5452b.this.f17480d.getFirstVisiblePosition()).getTag()).f17494b.mo27467a(((PhotoInfo) C5452b.this.f17479c.get(i)).isChoose());
                C5452b.this.f17486j.onPhotoSelectClick(photoInfo);
            }
        });
        aVar.f17494b.mo27467a(((PhotoInfo) this.f17479c.get(i)).isChoose());
        LayoutParams layoutParams2 = aVar.f17493a.getLayoutParams();
        int i3 = this.f17482f;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        aVar.f17493a.setLayoutParams(layoutParams2);
        final PhotoInfo photoInfo = (PhotoInfo) this.f17479c.get(i);
        if (photoInfo != null) {
            final String a = C5464c.m22276a(photoInfo.getImageId(), photoInfo.getFilePath());
            aVar.f17493a.setTag(a);
            aVar.f17493a.setImageResource(C5961R.C5962drawable.ysf_image_placeholder_loading);
            int i4 = this.f17482f;
            C5426a.m22177a(a, i4, i4, (ImageLoaderListener) new ImageLoaderListener() {
                public final void onLoadComplete(Bitmap bitmap) {
                    if (a.equals(aVar.f17493a.getTag())) {
                        aVar.f17493a.setImageBitmap(C5462a.m22273a(bitmap, photoInfo.getAbsolutePath()));
                    }
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
        }
        return view2;
    }
}
