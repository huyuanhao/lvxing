package com.scwang.smartrefresh.layout.p529c;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener;
import com.scwang.smartrefresh.layout.p527a.RefreshKernel;
import com.scwang.smartrefresh.layout.p528b.CoordinatorLayoutListener;

/* renamed from: com.scwang.smartrefresh.layout.c.c */
public class DesignUtil {
    /* renamed from: a */
    public static void m25574a(View view, RefreshKernel iVar, CoordinatorLayoutListener aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.mo30931a().mo30886e(false);
                m25575a((ViewGroup) view, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m25575a(ViewGroup viewGroup, final CoordinatorLayoutListener aVar) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof AppBarLayout) {
                ((AppBarLayout) childAt).addOnOffsetChangedListener((OnOffsetChangedListener) new OnOffsetChangedListener() {
                    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                        CoordinatorLayoutListener aVar = aVar;
                        boolean z = true;
                        boolean z2 = i >= 0;
                        if (appBarLayout.getTotalScrollRange() + i > 0) {
                            z = false;
                        }
                        aVar.mo30957a(z2, z);
                    }
                });
            }
        }
    }
}
