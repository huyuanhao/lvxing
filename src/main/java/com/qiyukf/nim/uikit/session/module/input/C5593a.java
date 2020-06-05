package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.a */
public final class C5593a extends BaseAdapter {
    /* renamed from: a */
    private Context f18008a;
    /* renamed from: b */
    private List<BaseAction> f18009b;

    public C5593a(Context context, List<BaseAction> list) {
        this.f18008a = context;
        this.f18009b = list;
    }

    public final int getCount() {
        return this.f18009b.size();
    }

    public final Object getItem(int i) {
        return this.f18009b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f18008a).inflate(C5961R.C5964layout.ysf_actions_item_layout, null);
        }
        BaseAction baseAction = (BaseAction) this.f18009b.get(i);
        ((ImageView) view.findViewById(C5961R.C5963id.imageView)).setBackgroundResource(baseAction.getIconResId());
        ((TextView) view.findViewById(C5961R.C5963id.textView)).setText(this.f18008a.getString(baseAction.getTitleId()));
        ((TextView) view.findViewById(C5961R.C5963id.textView)).setTextColor(baseAction.getActionFontColor());
        return view;
    }
}
