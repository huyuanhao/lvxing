package com.qiyukf.nim.uikit.common.p424ui.listview;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.qiyukf.unicorn.C5961R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView */
public class AutoRefreshListView extends ListView {
    /* renamed from: a */
    float f17644a = 0.0f;
    /* renamed from: b */
    boolean f17645b = false;
    /* renamed from: c */
    private C5482b f17646c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public List<OnScrollListener> f17647d = new ArrayList();
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f17648e = C5483c.f17667b;
    /* renamed from: f */
    private int f17649f = C5481a.f17662a;
    /* renamed from: g */
    private int f17650g = C5481a.f17662a;
    /* renamed from: h */
    private boolean f17651h = true;
    /* renamed from: i */
    private boolean f17652i = true;
    /* renamed from: j */
    private ViewGroup f17653j;
    /* renamed from: k */
    private ViewGroup f17654k;
    /* renamed from: l */
    private int f17655l;
    /* renamed from: m */
    private boolean f17656m = false;
    /* renamed from: n */
    private int f17657n = 0;

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$3 */
    static /* synthetic */ class C54803 {
        /* renamed from: a */
        static final /* synthetic */ int[] f17660a = new int[C5483c.m22366a().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f17661b = new int[C5481a.m22363a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|5|6|7|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0029 */
        static {
            /*
            int[] r0 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.m22363a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f17661b = r0
            r0 = 1
            int[] r1 = f17661b     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17663b     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = r2 - r0
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = 2
            int[] r2 = f17661b     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r3 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17662a     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r3 = r3 - r0
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            int[] r2 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.m22366a()
            int r2 = r2.length
            int[] r2 = new int[r2]
            f17660a = r2
            int[] r2 = f17660a     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r3 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.f17666a     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r3 = r3 - r0
            r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            int[] r2 = f17660a     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r3 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.f17667b     // Catch:{ NoSuchFieldError -> 0x0030 }
            int r3 = r3 - r0
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0030 }
        L_0x0030:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C54803.m49641clinit():void");
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$a */
    public enum C5481a {
        ;
        
        /* renamed from: a */
        public static final int f17662a = 1;
        /* renamed from: b */
        public static final int f17663b = 2;
        /* renamed from: c */
        public static final int f17664c = 3;

        static {
            f17665d = new int[]{f17662a, f17663b, f17664c};
        }

        /* renamed from: a */
        public static int[] m22363a() {
            return (int[]) f17665d.clone();
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$b */
    public interface C5482b {
        /* renamed from: a */
        void mo27575a();

        /* renamed from: a */
        void mo27576a(int i);
    }

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$c */
    public enum C5483c {
        ;
        
        /* renamed from: a */
        public static final int f17666a = 1;
        /* renamed from: b */
        public static final int f17667b = 2;

        static {
            f17668c = new int[]{f17666a, f17667b};
        }

        /* renamed from: a */
        public static int[] m22366a() {
            return (int[]) f17668c.clone();
        }
    }

    public AutoRefreshListView(Context context) {
        super(context);
        m22352a(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22352a(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22352a(context);
    }

    public AutoRefreshListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m22352a(context);
    }

    /* renamed from: a */
    private void m22352a(Context context) {
        this.f17653j = (ViewGroup) View.inflate(context, C5961R.C5964layout.ysf_listview_refresh, null);
        addHeaderView(this.f17653j, null, false);
        this.f17654k = (ViewGroup) View.inflate(context, C5961R.C5964layout.ysf_listview_refresh, null);
        addFooterView(this.f17654k, null, false);
        super.setOnScrollListener(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                for (OnScrollListener onScroll : AutoRefreshListView.this.f17647d) {
                    onScroll.onScroll(absListView, i, i2, i3);
                }
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                for (OnScrollListener onScrollStateChanged : AutoRefreshListView.this.f17647d) {
                    onScrollStateChanged.onScrollStateChanged(absListView, i);
                }
            }
        });
        this.f17647d.add(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && AutoRefreshListView.this.f17648e == C5483c.f17667b) {
                    boolean z = true;
                    boolean z2 = AutoRefreshListView.this.getFirstVisiblePosition() < AutoRefreshListView.this.getHeaderViewsCount() && AutoRefreshListView.this.getCount() > AutoRefreshListView.this.getHeaderViewsCount();
                    if (z2) {
                        AutoRefreshListView.m22353a(AutoRefreshListView.this, true);
                        return;
                    }
                    if (AutoRefreshListView.this.getLastVisiblePosition() < AutoRefreshListView.this.getCount() - 1) {
                        z = false;
                    }
                    if (z) {
                        AutoRefreshListView.m22353a(AutoRefreshListView.this, false);
                    }
                }
            }
        });
        this.f17648e = C5483c.f17667b;
    }

    /* renamed from: a */
    static /* synthetic */ void m22353a(AutoRefreshListView autoRefreshListView, boolean z) {
        if (autoRefreshListView.f17646c != null) {
            View childAt = autoRefreshListView.getChildAt(autoRefreshListView.getHeaderViewsCount());
            if (childAt != null) {
                autoRefreshListView.f17655l = childAt.getTop();
            }
            if (!z && autoRefreshListView.f17652i && autoRefreshListView.f17649f != C5481a.f17662a) {
                autoRefreshListView.f17646c.mo27575a();
                autoRefreshListView.f17650g = C5481a.f17663b;
                autoRefreshListView.f17648e = C5483c.f17666a;
            }
            autoRefreshListView.m22356b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
            if (r0 != 3) goto L_0x0089;
     */
    /* renamed from: a */
    private boolean m22354a(android.view.MotionEvent r5) {
        /*
        r4 = this;
        int r0 = r5.getAction()
        if (r0 == 0) goto L_0x0086
        r1 = 1
        r2 = 0
        if (r0 == r1) goto L_0x002d
        r3 = 2
        if (r0 == r3) goto L_0x0012
        r3 = 3
        if (r0 == r3) goto L_0x002d
        goto L_0x0089
    L_0x0012:
        r4.m22357b(r5)
        boolean r0 = r4.f17656m
        if (r0 == 0) goto L_0x0089
        float r0 = r5.getY()
        int r1 = r4.f17657n
        float r1 = (float) r1
        float r0 = r0 - r1
        int r0 = (int) r0
        int r0 = java.lang.Math.max(r0, r2)
        int r0 = r0 / r3
        android.view.ViewGroup r1 = r4.f17653j
        r1.setPadding(r2, r0, r2, r2)
        goto L_0x0089
    L_0x002d:
        r4.f17656m = r2
        int r0 = r4.getFirstVisiblePosition()
        int r3 = r4.getHeaderViewsCount()
        if (r0 >= r3) goto L_0x0045
        int r0 = r4.getCount()
        int r3 = r4.getHeaderViewsCount()
        if (r0 <= r3) goto L_0x0045
        r0 = 1
        goto L_0x0046
    L_0x0045:
        r0 = 0
    L_0x0046:
        if (r0 == 0) goto L_0x006c
        float r0 = r4.f17644a
        float r3 = r5.getY()
        int r3 = (int) r3
        float r3 = (float) r3
        int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
        if (r0 >= 0) goto L_0x006c
        boolean r0 = r4.f17651h
        if (r0 == 0) goto L_0x006c
        int r0 = r4.f17649f
        int r3 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17663b
        if (r0 == r3) goto L_0x006c
        com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView$b r0 = r4.f17646c
        r0.mo27576a(r1)
        int r0 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17662a
        r4.f17650g = r0
        int r0 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.f17666a
        r4.f17648e = r0
        goto L_0x0078
    L_0x006c:
        android.view.ViewGroup r0 = r4.f17653j
        r0.setPadding(r2, r2, r2, r2)
        int r0 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.f17667b
        r4.f17648e = r0
        r4.m22356b()
    L_0x0078:
        boolean r0 = r4.f17656m
        if (r0 == 0) goto L_0x0081
        android.view.ViewGroup r0 = r4.f17653j
        r0.setPadding(r2, r2, r2, r2)
    L_0x0081:
        r4.f17645b = r2
        r4.f17656m = r2
        goto L_0x0089
    L_0x0086:
        r4.m22357b(r5)
    L_0x0089:
        boolean r5 = super.onTouchEvent(r5)
        return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.m22354a(android.view.MotionEvent):boolean");
    }

    /* renamed from: b */
    private void m22356b() {
        int i = C54803.f17660a[this.f17648e - 1];
        if (i != 1) {
            if (i == 2) {
                int i2 = 8;
                if (this.f17650g == C5481a.f17662a) {
                    View childAt = this.f17653j.getChildAt(0);
                    if (this.f17651h) {
                        i2 = 4;
                    }
                    childAt.setVisibility(i2);
                    return;
                }
                this.f17654k.getChildAt(0).setVisibility(8);
            }
            return;
        }
        (C54803.f17661b[this.f17650g - 1] != 1 ? this.f17653j : this.f17654k).getChildAt(0).setVisibility(0);
    }

    /* renamed from: b */
    private void m22357b(MotionEvent motionEvent) {
        boolean z = getFirstVisiblePosition() < getHeaderViewsCount() && getCount() > getHeaderViewsCount();
        if (z) {
            this.f17648e = C5483c.f17666a;
        }
        m22356b();
        int firstVisiblePosition = getFirstVisiblePosition();
        if (!this.f17651h && firstVisiblePosition <= getHeaderViewsCount() && !this.f17656m) {
            this.f17656m = true;
            this.f17657n = (int) motionEvent.getY();
        }
        if (!this.f17645b) {
            this.f17644a = (float) ((int) motionEvent.getY());
            this.f17645b = true;
        }
    }

    /* renamed from: a */
    public final C5482b mo27564a() {
        return this.f17646c;
    }

    /* renamed from: a */
    public final void mo27565a(int i) {
        this.f17649f = i;
    }

    /* renamed from: a */
    public final void mo27566a(C5482b bVar) {
        this.f17646c = bVar;
    }

    /* renamed from: b */
    public final void mo27567b(int i) {
        this.f17648e = C5483c.f17666a;
        this.f17650g = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
            if (com.qiyukf.unicorn.C6029d.m24045e().isDefaultLoadMsg == false) goto L_0x0032;
     */
    /* renamed from: c */
    public final void mo27568c(int r6) {
        /*
        r5 = this;
        int r0 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5483c.f17667b
        r5.f17648e = r0
        int r0 = r5.f17650g
        int r1 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17662a
        r2 = 1
        r3 = 0
        if (r0 != r1) goto L_0x0035
        int r0 = r5.getCount()
        int r1 = r5.getHeaderViewsCount()
        int r1 = r1 + r6
        int r4 = r5.getFooterViewsCount()
        int r1 = r1 + r4
        if (r0 != r1) goto L_0x002e
        r0 = 20
        if (r6 < r0) goto L_0x0022
        r0 = 1
        goto L_0x0023
    L_0x0022:
        r0 = 0
    L_0x0023:
        r5.f17651h = r0
        com.qiyukf.unicorn.api.YSFOptions r0 = com.qiyukf.unicorn.C6029d.m24045e()
        boolean r0 = r0.isDefaultLoadMsg
        if (r0 != 0) goto L_0x003b
        goto L_0x0032
    L_0x002e:
        if (r6 <= 0) goto L_0x0031
        goto L_0x0032
    L_0x0031:
        r2 = 0
    L_0x0032:
        r5.f17651h = r2
        goto L_0x003b
    L_0x0035:
        if (r6 <= 0) goto L_0x0038
        goto L_0x0039
    L_0x0038:
        r2 = 0
    L_0x0039:
        r5.f17652i = r2
    L_0x003b:
        r5.m22356b()
        int r0 = r5.f17650g
        int r1 = com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a.f17662a
        if (r0 != r1) goto L_0x0052
        int r0 = r5.getHeaderViewsCount()
        int r6 = r6 + r0
        boolean r0 = r5.f17651h
        if (r0 == 0) goto L_0x004f
        int r3 = r5.f17655l
    L_0x004f:
        r5.setSelectionFromTop(r6, r3)
    L_0x0052:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.mo27568c(int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT >= 11) {
            return m22354a(motionEvent);
        }
        try {
            return m22354a(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        throw new UnsupportedOperationException("Use addOnScrollListener instead!");
    }
}
