package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a.IMeasurablePagerTitleView;

public class CommonPagerTitleView extends FrameLayout implements IMeasurablePagerTitleView {
    /* renamed from: a */
    private C8355b f28183a;
    /* renamed from: b */
    private C8354a f28184b;

    /* renamed from: net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView$a */
    public interface C8354a {
        /* renamed from: a */
        int mo40042a();

        /* renamed from: b */
        int mo40043b();

        /* renamed from: c */
        int mo40044c();

        /* renamed from: d */
        int mo40045d();
    }

    /* renamed from: net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView$b */
    public interface C8355b {
        /* renamed from: a */
        void mo40046a(int i, int i2);

        /* renamed from: a */
        void mo40047a(int i, int i2, float f, boolean z);

        /* renamed from: b */
        void mo40048b(int i, int i2);

        /* renamed from: b */
        void mo40049b(int i, int i2, float f, boolean z);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    /* renamed from: b */
    public void mo20758b(int i, int i2) {
        C8355b bVar = this.f28183a;
        if (bVar != null) {
            bVar.mo40046a(i, i2);
        }
    }

    /* renamed from: a */
    public void mo20757a(int i, int i2) {
        C8355b bVar = this.f28183a;
        if (bVar != null) {
            bVar.mo40048b(i, i2);
        }
    }

    /* renamed from: a */
    public void mo39958a(int i, int i2, float f, boolean z) {
        C8355b bVar = this.f28183a;
        if (bVar != null) {
            bVar.mo40047a(i, i2, f, z);
        }
    }

    /* renamed from: b */
    public void mo39959b(int i, int i2, float f, boolean z) {
        C8355b bVar = this.f28183a;
        if (bVar != null) {
            bVar.mo40049b(i, i2, f, z);
        }
    }

    public int getContentLeft() {
        C8354a aVar = this.f28184b;
        if (aVar != null) {
            return aVar.mo40042a();
        }
        return getLeft();
    }

    public int getContentTop() {
        C8354a aVar = this.f28184b;
        if (aVar != null) {
            return aVar.mo40043b();
        }
        return getTop();
    }

    public int getContentRight() {
        C8354a aVar = this.f28184b;
        if (aVar != null) {
            return aVar.mo40044c();
        }
        return getRight();
    }

    public int getContentBottom() {
        C8354a aVar = this.f28184b;
        if (aVar != null) {
            return aVar.mo40045d();
        }
        return getBottom();
    }

    public void setContentView(View view) {
        mo40035a(view, (LayoutParams) null);
    }

    /* renamed from: a */
    public void mo40035a(View view, LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setContentView(int i) {
        mo40035a(LayoutInflater.from(getContext()).inflate(i, null), (LayoutParams) null);
    }

    public C8355b getOnPagerTitleChangeListener() {
        return this.f28183a;
    }

    public void setOnPagerTitleChangeListener(C8355b bVar) {
        this.f28183a = bVar;
    }

    public C8354a getContentPositionDataProvider() {
        return this.f28184b;
    }

    public void setContentPositionDataProvider(C8354a aVar) {
        this.f28184b = aVar;
    }
}
