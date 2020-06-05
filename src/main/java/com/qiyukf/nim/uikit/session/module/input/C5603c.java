package com.qiyukf.nim.uikit.session.module.input;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.c */
public final class C5603c {
    /* renamed from: a */
    public static void m22696a(View view, List<BaseAction> list) {
        ViewPager viewPager = (ViewPager) view.findViewById(C5961R.C5963id.viewPager);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(C5961R.C5963id.actions_page_indicator);
        C5599b bVar = new C5599b(viewPager, list);
        viewPager.setAdapter(bVar);
        final int count = bVar.getCount();
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                C5603c.m22698b(viewGroup, count, i);
            }
        });
        m22698b(viewGroup, count, 0);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m22698b(ViewGroup viewGroup, int i, int i2) {
        viewGroup.removeAllViews();
        if (i > 1) {
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            int i3 = 0;
            layoutParams.setMargins(C5412d.m22146a(2.0f), 0, C5412d.m22146a(2.0f), 0);
            while (i3 < i) {
                ImageView imageView = new ImageView(viewGroup.getContext());
                imageView.setId(i3);
                imageView.setBackgroundResource(i3 == i2 ? C5961R.C5962drawable.ysf_moon_page_selected : C5961R.C5962drawable.ysf_moon_page_unselected);
                viewGroup.addView(imageView, layoutParams);
                i3++;
            }
        }
    }
}
