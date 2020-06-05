package com.qiyukf.nim.uikit.common.media.picker.p422a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.qiyukf.basesdk.p412c.C5361a;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.p424ui.imageview.BaseZoomableImageView;
import com.qiyukf.nim.uikit.common.p424ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nimlib.p488k.p490b.C5939a;
import com.qiyukf.nimlib.p488k.p490b.C5940b;
import com.qiyukf.unicorn.C5961R;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.a.c */
public final class C5456c extends PagerAdapter {
    /* renamed from: a */
    private List<PhotoInfo> f17497a;
    /* renamed from: b */
    private LayoutInflater f17498b;
    /* renamed from: c */
    private Handler f17499c = C5361a.m22013a().mo27317c();
    /* renamed from: d */
    private Handler f17500d = new Handler();
    /* renamed from: e */
    private int f17501e;

    public C5456c(int i, List<PhotoInfo> list, LayoutInflater layoutInflater) {
        this.f17501e = i;
        this.f17497a = list;
        this.f17498b = layoutInflater;
    }

    /* renamed from: a */
    public final void mo27464a(final MultiTouchZoomableImageView multiTouchZoomableImageView, int i, boolean z) {
        final Bitmap bitmap;
        PhotoInfo photoInfo = (PhotoInfo) this.f17497a.get(i);
        if (!(photoInfo == null || photoInfo.getAbsolutePath() == null)) {
            Bitmap b = C5939a.m23807b(photoInfo.getAbsolutePath());
            if (b == null) {
                bitmap = C5940b.m23809a();
                C5415g.m22165b(C5961R.string.ysf_picker_image_error);
            } else {
                bitmap = C5940b.m23812a(photoInfo.getAbsolutePath(), b);
            }
            if (z) {
                multiTouchZoomableImageView.mo27508a(bitmap);
                return;
            }
            this.f17500d.post(new Runnable() {
                public final void run() {
                    multiTouchZoomableImageView.mo27508a(bitmap);
                }
            });
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        ((BaseZoomableImageView) view.findViewById(C5961R.C5963id.imageView)).mo27513b();
        viewGroup.removeView(view);
    }

    public final int getCount() {
        List<PhotoInfo> list = this.f17497a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = this.f17498b.inflate(C5961R.C5964layout.ysf_preview_image_layout_multi_touch, null);
        final MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) inflate.findViewById(C5961R.C5963id.imageView);
        if (i == this.f17501e) {
            mo27464a(multiTouchZoomableImageView, i, true);
        } else {
            this.f17499c.post(new Runnable() {
                public final void run() {
                    C5456c.this.mo27464a(multiTouchZoomableImageView, i, false);
                }
            });
        }
        viewGroup.addView(inflate);
        inflate.setTag(Integer.valueOf(i));
        return inflate;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
