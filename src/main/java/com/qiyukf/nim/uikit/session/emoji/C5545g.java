package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6045d.C6046a;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.g */
public final class C5545g extends BaseAdapter {
    /* renamed from: a */
    private Context f17863a;
    /* renamed from: b */
    private C5547h f17864b;
    /* renamed from: c */
    private int f17865c;

    /* renamed from: com.qiyukf.nim.uikit.session.emoji.g$a */
    class C5546a {
        /* renamed from: a */
        public ImageView f17866a;
        /* renamed from: b */
        public TextView f17867b;

        C5546a() {
        }
    }

    public C5545g(Context context, C5547h hVar, int i) {
        this.f17863a = context;
        this.f17864b = hVar;
        this.f17865c = i;
    }

    public final int getCount() {
        return Math.min(this.f17864b.mo27665a().size() - this.f17865c, 8);
    }

    public final Object getItem(int i) {
        return this.f17864b.mo27665a().get(this.f17865c + i);
    }

    public final long getItemId(int i) {
        return (long) (this.f17865c + i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C5546a aVar;
        if (view == null) {
            view = View.inflate(this.f17863a, C5961R.C5964layout.ysf_sticker_picker_view, null);
            aVar = new C5546a();
            aVar.f17866a = (ImageView) view.findViewById(C5961R.C5963id.sticker_thumb_image);
            aVar.f17867b = (TextView) view.findViewById(C5961R.C5963id.sticker_desc_label);
            view.setTag(aVar);
        } else {
            aVar = (C5546a) view.getTag();
        }
        int i2 = this.f17865c + i;
        if (i2 >= this.f17864b.mo27665a().size()) {
            return view;
        }
        C6046a aVar2 = (C6046a) this.f17864b.mo27665a().get(i2);
        if (aVar2 == null) {
            return view;
        }
        C5426a.m22178a(aVar2.mo28897b(), aVar.f17866a);
        aVar.f17867b.setVisibility(8);
        return view;
    }
}
