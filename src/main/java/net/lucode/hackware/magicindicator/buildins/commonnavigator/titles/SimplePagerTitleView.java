package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IMeasurablePagerTitleView;

public class SimplePagerTitleView extends TextView implements IMeasurablePagerTitleView {
    /* renamed from: a */
    protected int f28185a;
    /* renamed from: b */
    protected int f28186b;

    /* renamed from: a */
    public void mo39958a(int i, int i2, float f, boolean z) {
    }

    /* renamed from: b */
    public void mo39959b(int i, int i2, float f, boolean z) {
    }

    public SimplePagerTitleView(Context context) {
        super(context, null);
        m35740a(context);
    }

    /* renamed from: a */
    private void m35740a(Context context) {
        setGravity(17);
        int a = UIUtil.m35640a(context, 10.0d);
        setPadding(a, 0, a, 0);
        setSingleLine();
        setEllipsize(TruncateAt.END);
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
        setTextColor(this.f28185a);
    }

    /* renamed from: a */
    public void mo20757a(int i, int i2) {
        setTextColor(this.f28186b);
    }

    public int getContentLeft() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentTop() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentRight() {
        Rect rect = new Rect();
        getPaint().getTextBounds(getText().toString(), 0, getText().length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentBottom() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getSelectedColor() {
        return this.f28185a;
    }

    public void setSelectedColor(int i) {
        this.f28185a = i;
    }

    public int getNormalColor() {
        return this.f28186b;
    }

    public void setNormalColor(int i) {
        this.f28186b = i;
    }
}
