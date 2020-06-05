package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.b */
public final class C5599b extends PagerAdapter {
    /* renamed from: a */
    private final int f18023a = 8;
    /* access modifiers changed from: private|final */
    /* renamed from: b */
    public final Context f18024b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final List<BaseAction> f18025c;
    /* access modifiers changed from: private|final */
    /* renamed from: d */
    public final ViewPager f18026d;
    /* renamed from: e */
    private final int f18027e;

    public C5599b(ViewPager viewPager, List<BaseAction> list) {
        this.f18024b = viewPager.getContext();
        this.f18025c = new ArrayList(list);
        this.f18026d = viewPager;
        this.f18027e = ((list.size() + 8) - 1) / 8;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public final int getCount() {
        return this.f18027e;
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        int i2 = (i + 1) << 3;
        if (i2 > this.f18025c.size()) {
            i2 = this.f18025c.size();
        }
        List subList = this.f18025c.subList(i << 3, i2);
        GridView gridView = new GridView(this.f18024b);
        gridView.setAdapter(new C5593a(this.f18024b, subList));
        int size = this.f18025c.size();
        gridView.setNumColumns(4);
        viewGroup.post(size > 4 ? new Runnable() {
            public final void run() {
                LayoutParams layoutParams = C5599b.this.f18026d.getLayoutParams();
                layoutParams.height = C5599b.this.f18024b.getResources().getDimensionPixelOffset(C5961R.dimen.ysf_message_action_list_height_modify);
                C5599b.this.f18026d.setLayoutParams(layoutParams);
            }
        } : new Runnable() {
            public final void run() {
                LayoutParams layoutParams = C5599b.this.f18026d.getLayoutParams();
                layoutParams.height = C5599b.this.f18024b.getResources().getDimensionPixelOffset(C5961R.dimen.ysf_message_action_list_height) / 2;
                C5599b.this.f18026d.setLayoutParams(layoutParams);
            }
        });
        gridView.setSelector(17170445);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);
        gridView.setGravity(17);
        gridView.setTag(Integer.valueOf(i));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((BaseAction) C5599b.this.f18025c.get((((Integer) adapterView.getTag()).intValue() << 3) + i)).onClick();
            }
        });
        viewGroup.addView(gridView);
        return gridView;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
