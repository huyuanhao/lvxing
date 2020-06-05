package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6045d.C6046a;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.a */
public final class C5530a extends BaseAdapter {
    /* renamed from: a */
    private Context f17827a;
    /* renamed from: b */
    private int f17828b;
    /* renamed from: c */
    private C5547h f17829c = null;
    /* renamed from: d */
    private boolean f17830d = false;

    public C5530a(Context context, int i) {
        this.f17827a = context;
        this.f17828b = i;
    }

    public C5530a(Context context, int i, C5547h hVar) {
        this.f17827a = context;
        this.f17828b = i;
        this.f17829c = hVar;
        this.f17830d = true;
    }

    public final int getCount() {
        return Math.min(((!this.f17830d ? C5531b.m22508a() : this.f17829c.mo27665a().size()) - this.f17828b) + 1, 28);
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) (this.f17828b + i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f17827a).inflate(C5961R.C5964layout.ysf_emoji_item, null);
        }
        ImageView imageView = (ImageView) view.findViewById(C5961R.C5963id.imgEmoji);
        if (!this.f17830d) {
            int a = C5531b.m22508a();
            int i2 = this.f17828b + i;
            if (!(i == 27 || i2 == a)) {
                if (i2 < a) {
                    imageView.setBackgroundDrawable(C5531b.m22509a(this.f17827a, i2));
                }
                return view;
            }
        } else {
            int i3 = this.f17828b + i;
            int size = this.f17829c.mo27665a().size();
            if (i3 > this.f17829c.mo27665a().size()) {
                return view;
            }
            C5547h hVar = this.f17829c;
            if (hVar == null) {
                return view;
            }
            if (!(i == 27 || i3 == size)) {
                if (i3 < size) {
                    C6046a aVar = (C6046a) hVar.mo27665a().get(i3);
                    if (aVar == null) {
                        return view;
                    }
                    C5426a.m22178a(aVar.mo28897b(), imageView);
                }
                return view;
            }
        }
        imageView.setBackgroundResource(C5961R.C5962drawable.ysf_emoji_del);
        return view;
    }
}
