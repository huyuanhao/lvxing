package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.NavigatorHelper;
import net.lucode.hackware.magicindicator.NavigatorHelper.C8351a;
import net.lucode.hackware.magicindicator.R;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IMeasurablePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p696b.PositionData;
import net.lucode.hackware.magicindicator.p694a.IPagerNavigator;

public class CommonNavigator extends FrameLayout implements IPagerNavigator, C8351a {
    /* renamed from: a */
    private HorizontalScrollView f28096a;
    /* renamed from: b */
    private LinearLayout f28097b;
    /* renamed from: c */
    private LinearLayout f28098c;
    /* renamed from: d */
    private IPagerIndicator f28099d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public CommonNavigatorAdapter f28100e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public NavigatorHelper f28101f = new NavigatorHelper();
    /* renamed from: g */
    private boolean f28102g;
    /* renamed from: h */
    private boolean f28103h;
    /* renamed from: i */
    private float f28104i = 0.5f;
    /* renamed from: j */
    private boolean f28105j = true;
    /* renamed from: k */
    private boolean f28106k = true;
    /* renamed from: l */
    private int f28107l;
    /* renamed from: m */
    private int f28108m;
    /* renamed from: n */
    private boolean f28109n;
    /* renamed from: o */
    private boolean f28110o;
    /* renamed from: p */
    private boolean f28111p = true;
    /* renamed from: q */
    private List<PositionData> f28112q = new ArrayList();
    /* renamed from: r */
    private DataSetObserver f28113r = new DataSetObserver() {
        public void onInvalidated() {
        }

        public void onChanged() {
            CommonNavigator.this.f28101f.mo39904c(CommonNavigator.this.f28100e.mo21559a());
            CommonNavigator.this.m35655c();
        }
    };

    /* renamed from: b */
    public void mo39894b() {
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f28101f.mo39899a((C8351a) this);
    }

    public void setAdjustMode(boolean z) {
        this.f28102g = z;
    }

    public CommonNavigatorAdapter getAdapter() {
        return this.f28100e;
    }

    public void setAdapter(CommonNavigatorAdapter aVar) {
        CommonNavigatorAdapter aVar2 = this.f28100e;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.mo39953b(this.f28113r);
            }
            this.f28100e = aVar;
            CommonNavigatorAdapter aVar3 = this.f28100e;
            if (aVar3 != null) {
                aVar3.mo39950a(this.f28113r);
                this.f28101f.mo39904c(this.f28100e.mo21559a());
                if (this.f28097b != null) {
                    this.f28100e.mo39952b();
                }
            } else {
                this.f28101f.mo39904c(0);
                m35655c();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m35655c() {
        View view;
        removeAllViews();
        if (this.f28102g) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        }
        this.f28096a = (HorizontalScrollView) view.findViewById(R.id.scroll_view);
        this.f28097b = (LinearLayout) view.findViewById(R.id.title_container);
        this.f28097b.setPadding(this.f28108m, 0, this.f28107l, 0);
        this.f28098c = (LinearLayout) view.findViewById(R.id.indicator_container);
        if (this.f28109n) {
            this.f28098c.getParent().bringChildToFront(this.f28098c);
        }
        m35657d();
    }

    /* renamed from: d */
    private void m35657d() {
        LayoutParams layoutParams;
        int a = this.f28101f.mo39896a();
        for (int i = 0; i < a; i++) {
            IPagerTitleView a2 = this.f28100e.mo21561a(getContext(), i);
            if (a2 instanceof View) {
                View view = (View) a2;
                if (this.f28102g) {
                    layoutParams = new LayoutParams(0, -1);
                    layoutParams.weight = this.f28100e.mo39951b(getContext(), i);
                } else {
                    layoutParams = new LayoutParams(-2, -1);
                }
                this.f28097b.addView(view, layoutParams);
            }
        }
        CommonNavigatorAdapter aVar = this.f28100e;
        if (aVar != null) {
            this.f28099d = aVar.mo21560a(getContext());
            if (this.f28099d instanceof View) {
                this.f28098c.addView((View) this.f28099d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f28100e != null) {
            m35658e();
            IPagerIndicator cVar = this.f28099d;
            if (cVar != null) {
                cVar.mo20770a(this.f28112q);
            }
            if (this.f28111p && this.f28101f.mo39903c() == 0) {
                mo39892a(this.f28101f.mo39901b());
                mo39893a(this.f28101f.mo39901b(), 0.0f, 0);
            }
        }
    }

    /* renamed from: e */
    private void m35658e() {
        this.f28112q.clear();
        int a = this.f28101f.mo39896a();
        for (int i = 0; i < a; i++) {
            PositionData aVar = new PositionData();
            View childAt = this.f28097b.getChildAt(i);
            if (childAt != null) {
                aVar.f28116a = childAt.getLeft();
                aVar.f28117b = childAt.getTop();
                aVar.f28118c = childAt.getRight();
                aVar.f28119d = childAt.getBottom();
                if (childAt instanceof IMeasurablePagerTitleView) {
                    IMeasurablePagerTitleView bVar = (IMeasurablePagerTitleView) childAt;
                    aVar.f28120e = bVar.getContentLeft();
                    aVar.f28121f = bVar.getContentTop();
                    aVar.f28122g = bVar.getContentRight();
                    aVar.f28123h = bVar.getContentBottom();
                } else {
                    aVar.f28120e = aVar.f28116a;
                    aVar.f28121f = aVar.f28117b;
                    aVar.f28122g = aVar.f28118c;
                    aVar.f28123h = aVar.f28119d;
                }
            }
            this.f28112q.add(aVar);
        }
    }

    /* renamed from: a */
    public void mo39893a(int i, float f, int i2) {
        if (this.f28100e != null) {
            this.f28101f.mo39898a(i, f, i2);
            IPagerIndicator cVar = this.f28099d;
            if (cVar != null) {
                cVar.mo20769a(i, f, i2);
            }
            if (this.f28096a != null && this.f28112q.size() > 0 && i >= 0 && i < this.f28112q.size()) {
                if (this.f28106k) {
                    int min = Math.min(this.f28112q.size() - 1, i);
                    float b = ((float) ((PositionData) this.f28112q.get(min)).mo39961b()) - (((float) this.f28096a.getWidth()) * this.f28104i);
                    this.f28096a.scrollTo((int) (b + (((((float) ((PositionData) this.f28112q.get(Math.min(this.f28112q.size() - 1, i + 1))).mo39961b()) - (((float) this.f28096a.getWidth()) * this.f28104i)) - b) * f)), 0);
                    return;
                }
                boolean z = this.f28103h;
            }
        }
    }

    public float getScrollPivotX() {
        return this.f28104i;
    }

    public void setScrollPivotX(float f) {
        this.f28104i = f;
    }

    /* renamed from: a */
    public void mo39892a(int i) {
        if (this.f28100e != null) {
            this.f28101f.mo39897a(i);
            IPagerIndicator cVar = this.f28099d;
            if (cVar != null) {
                cVar.mo20768a(i);
            }
        }
    }

    /* renamed from: b */
    public void mo39895b(int i) {
        if (this.f28100e != null) {
            this.f28101f.mo39902b(i);
            IPagerIndicator cVar = this.f28099d;
            if (cVar != null) {
                cVar.mo20771b(i);
            }
        }
    }

    /* renamed from: a */
    public void mo39891a() {
        m35655c();
    }

    public IPagerIndicator getPagerIndicator() {
        return this.f28099d;
    }

    public void setEnablePivotScroll(boolean z) {
        this.f28103h = z;
    }

    /* renamed from: a */
    public void mo39906a(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.f28097b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).mo39959b(i, i2, f, z);
            }
        }
    }

    /* renamed from: b */
    public void mo39908b(int i, int i2, float f, boolean z) {
        LinearLayout linearLayout = this.f28097b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).mo39958a(i, i2, f, z);
            }
        }
    }

    public void setSmoothScroll(boolean z) {
        this.f28105j = z;
    }

    public void setFollowTouch(boolean z) {
        this.f28106k = z;
    }

    public void setSkimOver(boolean z) {
        this.f28110o = z;
        this.f28101f.mo39900a(z);
    }

    /* renamed from: a */
    public void mo39905a(int i, int i2) {
        LinearLayout linearLayout = this.f28097b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).mo20758b(i, i2);
            }
            if (!this.f28102g && !this.f28106k && this.f28096a != null && this.f28112q.size() > 0) {
                PositionData aVar = (PositionData) this.f28112q.get(Math.min(this.f28112q.size() - 1, i));
                if (this.f28103h) {
                    float b = ((float) aVar.mo39961b()) - (((float) this.f28096a.getWidth()) * this.f28104i);
                    if (this.f28105j) {
                        this.f28096a.smoothScrollTo((int) b, 0);
                    } else {
                        this.f28096a.scrollTo((int) b, 0);
                    }
                } else if (this.f28096a.getScrollX() > aVar.f28116a) {
                    if (this.f28105j) {
                        this.f28096a.smoothScrollTo(aVar.f28116a, 0);
                    } else {
                        this.f28096a.scrollTo(aVar.f28116a, 0);
                    }
                } else if (this.f28096a.getScrollX() + getWidth() < aVar.f28118c) {
                    if (this.f28105j) {
                        this.f28096a.smoothScrollTo(aVar.f28118c - getWidth(), 0);
                    } else {
                        this.f28096a.scrollTo(aVar.f28118c - getWidth(), 0);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo39907b(int i, int i2) {
        LinearLayout linearLayout = this.f28097b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof IPagerTitleView) {
                ((IPagerTitleView) childAt).mo20757a(i, i2);
            }
        }
    }

    public LinearLayout getTitleContainer() {
        return this.f28097b;
    }

    public int getRightPadding() {
        return this.f28107l;
    }

    public void setRightPadding(int i) {
        this.f28107l = i;
    }

    public int getLeftPadding() {
        return this.f28108m;
    }

    public void setLeftPadding(int i) {
        this.f28108m = i;
    }

    public void setIndicatorOnTop(boolean z) {
        this.f28109n = z;
    }

    public void setReselectWhenLayout(boolean z) {
        this.f28111p = z;
    }
}
