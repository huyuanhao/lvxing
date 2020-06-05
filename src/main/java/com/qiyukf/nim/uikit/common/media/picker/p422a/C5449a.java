package com.qiyukf.nim.uikit.common.media.picker.p422a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.common.media.picker.model.C5468a;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5462a;
import com.qiyukf.nim.uikit.common.media.picker.p423b.C5464c;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.a.a */
public final class C5449a extends BaseAdapter {
    /* renamed from: a */
    private LayoutInflater f17466a;
    /* renamed from: b */
    private List<C5468a> f17467b;
    /* renamed from: c */
    private Context f17468c;

    /* renamed from: com.qiyukf.nim.uikit.common.media.picker.a.a$a */
    private class C5451a {
        /* renamed from: a */
        public ImageView f17473a;
        /* renamed from: b */
        public TextView f17474b;
        /* renamed from: c */
        public TextView f17475c;

        private C5451a() {
        }

        /* synthetic */ C5451a(C5449a aVar, byte b) {
            this();
        }
    }

    public C5449a(Context context, List<C5468a> list) {
        this.f17468c = context;
        this.f17466a = LayoutInflater.from(context);
        this.f17467b = list;
    }

    public final int getCount() {
        return this.f17467b.size();
    }

    public final Object getItem(int i) {
        return this.f17467b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final C5451a aVar;
        View view2;
        if (view == null) {
            aVar = new C5451a(this, 0);
            view2 = this.f17466a.inflate(C5961R.C5964layout.ysf_picker_photofolder_item, null);
            aVar.f17473a = (ImageView) view2.findViewById(C5961R.C5963id.picker_photofolder_cover);
            aVar.f17474b = (TextView) view2.findViewById(C5961R.C5963id.picker_photofolder_info);
            aVar.f17475c = (TextView) view2.findViewById(C5961R.C5963id.picker_photofolder_num);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (C5451a) view.getTag();
        }
        final C5468a aVar2 = (C5468a) this.f17467b.get(i);
        final String a = C5464c.m22276a(aVar2.mo27495a(), aVar2.mo27501c());
        aVar.f17473a.setTag(a);
        aVar.f17473a.setImageResource(C5961R.C5962drawable.ysf_image_placeholder_loading);
        C5426a.m22177a(a, C5412d.m22146a(75.0f), C5412d.m22146a(75.0f), (ImageLoaderListener) new ImageLoaderListener() {
            public final void onLoadComplete(Bitmap bitmap) {
                if (a.equals(aVar.f17473a.getTag())) {
                    aVar.f17473a.setImageBitmap(C5462a.m22273a(bitmap, aVar2.mo27499b()));
                }
            }

            public final void onLoadFailed(Throwable th) {
            }
        });
        aVar.f17474b.setText(aVar2.mo27503d());
        aVar.f17475c.setText(String.format(this.f17468c.getResources().getString(C5961R.string.ysf_picker_image_folder_info), new Object[]{Integer.valueOf(((C5468a) this.f17467b.get(i)).mo27504e().size())}));
        return view2;
    }
}
