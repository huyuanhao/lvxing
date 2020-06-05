package com.jiayouya.travel.module.common.widget.indicator;

import android.content.Context;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001d"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/widget/indicator/CommonTabView;", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/titles/SimplePagerTitleView;", "context", "Landroid/content/Context;", "title", "", "(Landroid/content/Context;Ljava/lang/String;)V", "isNormalBold", "", "()Z", "setNormalBold", "(Z)V", "isSelectedBold", "setSelectedBold", "normalTextSize", "", "getNormalTextSize", "()F", "setNormalTextSize", "(F)V", "selectedTextSize", "getSelectedTextSize", "setSelectedTextSize", "onDeselected", "", "index", "", "totalCount", "onSelected", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: CommonTabView.kt */
public final class CommonTabView extends SimplePagerTitleView {
    /* renamed from: c */
    private float f11356c = 14.0f;
    /* renamed from: d */
    private float f11357d = 14.0f;
    /* renamed from: e */
    private boolean f11358e;
    /* renamed from: f */
    private boolean f11359f;

    public CommonTabView(Context context, String str) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(str, "title");
        super(context);
        setText(str);
    }

    public final float getSelectedTextSize() {
        return this.f11356c;
    }

    public final void setSelectedTextSize(float f) {
        this.f11356c = f;
    }

    public final float getNormalTextSize() {
        return this.f11357d;
    }

    public final void setNormalTextSize(float f) {
        this.f11357d = f;
    }

    public final void setSelectedBold(boolean z) {
        this.f11358e = z;
    }

    public final void setNormalBold(boolean z) {
        this.f11359f = z;
    }

    /* renamed from: a */
    public void mo20757a(int i, int i2) {
        setTextColor(this.f28186b);
        setSelected(false);
        setTextSize(this.f11357d);
        TextPaint paint = getPaint();
        C8271i.m35382a((Object) paint, "paint");
        paint.setFakeBoldText(this.f11359f);
        invalidate();
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
        setTextColor(this.f28185a);
        setSelected(true);
        setTextSize(this.f11356c);
        TextPaint paint = getPaint();
        C8271i.m35382a((Object) paint, "paint");
        paint.setFakeBoldText(this.f11358e);
        invalidate();
    }
}
