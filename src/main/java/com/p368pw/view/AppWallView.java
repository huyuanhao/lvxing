package com.p368pw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.p368pw.inner.appwall.C5015j;
import com.p368pw.inner.appwall.C5015j.C5024e;
import com.p368pw.inner.appwall.C5015j.C5025f;
import com.p368pw.inner.appwall.C5015j.C5026g;
import com.p368pw.inner.appwall.C5040o;
import com.p368pw.inner.appwall.C5043q;
import com.p368pw.inner.appwall.C5047t;
import com.p368pw.inner.appwall.C5054w;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5208r;
import java.util.List;

/* renamed from: com.pw.view.AppWallView */
public class AppWallView extends FrameLayout {
    /* access modifiers changed from: private */
    public C5015j appWallAdapter;
    private C5040o appWallDecoration;
    private C5043q appWallEmptyView;
    private RecyclerView appWallList;
    private C5054w appWallRefreshView;
    private int mAppWallCoinResId;
    private int mAppWallColor;
    private double mAppWallInstallCoin;
    private double mAppWallOpenCoin;

    public AppWallView(Context context) {
        this(context, null);
    }

    public AppWallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        initAppList(context);
        initEmptyView(context);
        initRefreshView(context);
        showAppList(true);
        showEmptyView(false);
        showRefresh(false);
    }

    private void initAppList(Context context) {
        this.appWallList = new RecyclerView(context);
        this.appWallDecoration = new C5040o(-C5191i.m21391b(context, 49));
        this.appWallList.addItemDecoration(this.appWallDecoration);
        this.appWallList.setLayoutManager(new LinearLayoutManager(context));
        this.appWallAdapter = new C5015j(context);
        this.appWallList.setAdapter(this.appWallAdapter);
        addView(this.appWallList, new LayoutParams(-1, -1));
    }

    private void initEmptyView(Context context) {
        this.appWallEmptyView = new C5043q(context);
        addView(this.appWallEmptyView, new LayoutParams(-1, -1));
    }

    private void initRefreshView(Context context) {
        this.appWallRefreshView = new C5054w(context);
        addView(this.appWallRefreshView, new LayoutParams(-1, -1));
    }

    public void notifyItemChanged(final int i, final Integer num) {
        C5208r.m21479a(new Runnable() {
            public void run() {
                AppWallView.this.appWallAdapter.notifyItemChanged(i, num);
            }
        });
    }

    public void onPause() {
        this.appWallAdapter.mo26421b();
    }

    public void onResume() {
        this.appWallAdapter.mo26416a();
    }

    public void setAppWallInfo(double d, double d2, int i, int i2) {
        this.mAppWallOpenCoin = d;
        this.mAppWallInstallCoin = d2;
        this.mAppWallColor = i;
        this.mAppWallCoinResId = i2;
    }

    public void setData(List<C5047t> list, List<C5138c> list2) {
        boolean z;
        C5040o oVar;
        this.appWallAdapter.mo26417a(this.mAppWallOpenCoin, this.mAppWallInstallCoin, this.mAppWallColor, this.mAppWallCoinResId);
        this.appWallAdapter.mo26420a(list, list2);
        if (C5188f.m21379b(list2)) {
            oVar = this.appWallDecoration;
            z = true;
        } else {
            oVar = this.appWallDecoration;
            z = false;
        }
        oVar.mo26477a(z);
    }

    public void setOnBannerItemClickListener(C5024e eVar) {
        this.appWallAdapter.mo26415a(eVar);
    }

    public void setOnItemClickListener(C5025f fVar) {
        this.appWallAdapter.mo26418a(fVar);
    }

    public void setOnMoreClickListener(C5026g gVar) {
        this.appWallAdapter.mo26419a(gVar);
    }

    public void setOnRefreshClickListener(OnClickListener onClickListener) {
        this.appWallRefreshView.setOnRefreshOnClickListener(onClickListener);
    }

    public void showAppList(boolean z) {
        this.appWallList.setVisibility(z ? 0 : 8);
    }

    public void showEmptyView(boolean z) {
        this.appWallEmptyView.setVisibility(z ? 0 : 8);
    }

    public void showRefresh(boolean z) {
        this.appWallRefreshView.setVisibility(z ? 0 : 8);
    }
}
