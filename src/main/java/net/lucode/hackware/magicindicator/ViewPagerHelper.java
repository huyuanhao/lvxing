package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

/* renamed from: net.lucode.hackware.magicindicator.c */
public class ViewPagerHelper {
    /* renamed from: a */
    public static void m35751a(final MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int i, float f, int i2) {
                magicIndicator.mo39887a(i, f, i2);
            }

            public void onPageSelected(int i) {
                magicIndicator.mo39886a(i);
            }

            public void onPageScrollStateChanged(int i) {
                magicIndicator.mo39888b(i);
            }
        });
    }
}
