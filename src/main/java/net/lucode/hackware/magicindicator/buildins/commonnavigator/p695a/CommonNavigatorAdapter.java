package net.lucode.hackware.magicindicator.buildins.commonnavigator.p695a;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* renamed from: net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a */
public abstract class CommonNavigatorAdapter {
    /* renamed from: a */
    private final DataSetObservable f28115a = new DataSetObservable();

    /* renamed from: a */
    public abstract int mo21559a();

    /* renamed from: a */
    public abstract IPagerIndicator mo21560a(Context context);

    /* renamed from: a */
    public abstract IPagerTitleView mo21561a(Context context, int i);

    /* renamed from: b */
    public float mo39951b(Context context, int i) {
        return 1.0f;
    }

    /* renamed from: a */
    public final void mo39950a(DataSetObserver dataSetObserver) {
        this.f28115a.registerObserver(dataSetObserver);
    }

    /* renamed from: b */
    public final void mo39953b(DataSetObserver dataSetObserver) {
        this.f28115a.unregisterObserver(dataSetObserver);
    }

    /* renamed from: b */
    public final void mo39952b() {
        this.f28115a.notifyChanged();
    }
}
