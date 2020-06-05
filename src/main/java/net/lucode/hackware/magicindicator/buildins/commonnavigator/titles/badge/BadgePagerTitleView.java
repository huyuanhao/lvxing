package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IMeasurablePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerTitleView;

public class BadgePagerTitleView extends FrameLayout implements IMeasurablePagerTitleView {
    /* renamed from: a */
    private IPagerTitleView f28187a;
    /* renamed from: b */
    private View f28188b;
    /* renamed from: c */
    private boolean f28189c = true;
    /* renamed from: d */
    private BadgeRule f28190d;
    /* renamed from: e */
    private BadgeRule f28191e;

    public BadgePagerTitleView(Context context) {
        super(context);
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
        IPagerTitleView dVar = this.f28187a;
        if (dVar != null) {
            dVar.mo20758b(i, i2);
        }
        if (this.f28189c) {
            setBadgeView(null);
        }
    }

    /* renamed from: a */
    public void mo20757a(int i, int i2) {
        IPagerTitleView dVar = this.f28187a;
        if (dVar != null) {
            dVar.mo20757a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo39958a(int i, int i2, float f, boolean z) {
        IPagerTitleView dVar = this.f28187a;
        if (dVar != null) {
            dVar.mo39958a(i, i2, f, z);
        }
    }

    /* renamed from: b */
    public void mo39959b(int i, int i2, float f, boolean z) {
        IPagerTitleView dVar = this.f28187a;
        if (dVar != null) {
            dVar.mo39959b(i, i2, f, z);
        }
    }

    public IPagerTitleView getInnerPagerTitleView() {
        return this.f28187a;
    }

    public void setInnerPagerTitleView(IPagerTitleView dVar) {
        if (this.f28187a != dVar) {
            this.f28187a = dVar;
            removeAllViews();
            if (this.f28187a instanceof View) {
                addView((View) this.f28187a, new LayoutParams(-1, -1));
            }
            if (this.f28188b != null) {
                addView(this.f28188b, new LayoutParams(-2, -2));
            }
        }
    }

    public View getBadgeView() {
        return this.f28188b;
    }

    public void setBadgeView(View view) {
        if (this.f28188b != view) {
            this.f28188b = view;
            removeAllViews();
            if (this.f28187a instanceof View) {
                addView((View) this.f28187a, new LayoutParams(-1, -1));
            }
            if (this.f28188b != null) {
                addView(this.f28188b, new LayoutParams(-2, -2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        IPagerTitleView dVar = this.f28187a;
        if ((dVar instanceof View) && this.f28188b != null) {
            int[] iArr = new int[14];
            View view = (View) dVar;
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
            iArr[2] = view.getRight();
            iArr[3] = view.getBottom();
            IPagerTitleView dVar2 = this.f28187a;
            if (dVar2 instanceof IMeasurablePagerTitleView) {
                IMeasurablePagerTitleView bVar = (IMeasurablePagerTitleView) dVar2;
                iArr[4] = bVar.getContentLeft();
                iArr[5] = bVar.getContentTop();
                iArr[6] = bVar.getContentRight();
                iArr[7] = bVar.getContentBottom();
            } else {
                for (int i5 = 4; i5 < 8; i5++) {
                    iArr[i5] = iArr[i5 - 4];
                }
            }
            iArr[8] = view.getWidth() / 2;
            iArr[9] = view.getHeight() / 2;
            iArr[10] = iArr[4] / 2;
            iArr[11] = iArr[5] / 2;
            iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
            iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
            BadgeRule aVar = this.f28190d;
            if (aVar != null) {
                int b = iArr[aVar.mo40064a().ordinal()] + this.f28190d.mo40065b();
                View view2 = this.f28188b;
                view2.offsetLeftAndRight(b - view2.getLeft());
            }
            BadgeRule aVar2 = this.f28191e;
            if (aVar2 != null) {
                int b2 = iArr[aVar2.mo40064a().ordinal()] + this.f28191e.mo40065b();
                View view3 = this.f28188b;
                view3.offsetTopAndBottom(b2 - view3.getTop());
            }
        }
    }

    public int getContentLeft() {
        if (this.f28187a instanceof IMeasurablePagerTitleView) {
            return getLeft() + ((IMeasurablePagerTitleView) this.f28187a).getContentLeft();
        }
        return getLeft();
    }

    public int getContentTop() {
        IPagerTitleView dVar = this.f28187a;
        if (dVar instanceof IMeasurablePagerTitleView) {
            return ((IMeasurablePagerTitleView) dVar).getContentTop();
        }
        return getTop();
    }

    public int getContentRight() {
        if (this.f28187a instanceof IMeasurablePagerTitleView) {
            return getLeft() + ((IMeasurablePagerTitleView) this.f28187a).getContentRight();
        }
        return getRight();
    }

    public int getContentBottom() {
        IPagerTitleView dVar = this.f28187a;
        if (dVar instanceof IMeasurablePagerTitleView) {
            return ((IMeasurablePagerTitleView) dVar).getContentBottom();
        }
        return getBottom();
    }

    public BadgeRule getXBadgeRule() {
        return this.f28190d;
    }

    public void setXBadgeRule(BadgeRule aVar) {
        if (aVar != null) {
            BadgeAnchor a = aVar.mo40064a();
            if (!(a == BadgeAnchor.LEFT || a == BadgeAnchor.RIGHT || a == BadgeAnchor.CONTENT_LEFT || a == BadgeAnchor.CONTENT_RIGHT || a == BadgeAnchor.CENTER_X || a == BadgeAnchor.LEFT_EDGE_CENTER_X || a == BadgeAnchor.RIGHT_EDGE_CENTER_X)) {
                throw new IllegalArgumentException("x badge rule is wrong.");
            }
        }
        this.f28190d = aVar;
    }

    public BadgeRule getYBadgeRule() {
        return this.f28191e;
    }

    public void setYBadgeRule(BadgeRule aVar) {
        if (aVar != null) {
            BadgeAnchor a = aVar.mo40064a();
            if (!(a == BadgeAnchor.TOP || a == BadgeAnchor.BOTTOM || a == BadgeAnchor.CONTENT_TOP || a == BadgeAnchor.CONTENT_BOTTOM || a == BadgeAnchor.CENTER_Y || a == BadgeAnchor.TOP_EDGE_CENTER_Y || a == BadgeAnchor.BOTTOM_EDGE_CENTER_Y)) {
                throw new IllegalArgumentException("y badge rule is wrong.");
            }
        }
        this.f28191e = aVar;
    }

    public void setAutoCancelBadge(boolean z) {
        this.f28189c = z;
    }
}
