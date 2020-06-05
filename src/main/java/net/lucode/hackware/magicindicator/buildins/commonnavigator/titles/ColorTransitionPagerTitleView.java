package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    /* renamed from: a */
    public void mo20757a(int i, int i2) {
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
    }

    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo39958a(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.m35639a(f, this.f28185a, this.f28186b));
    }

    /* renamed from: b */
    public void mo39959b(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.m35639a(f, this.f28186b, this.f28185a));
    }
}
