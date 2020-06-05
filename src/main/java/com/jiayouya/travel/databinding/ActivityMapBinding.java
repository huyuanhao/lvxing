package com.jiayouya.travel.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.common.widget.RndCornerProgressBar;
import com.jiayouya.travel.module.group.data.TravelCity;
import com.jiayouya.travel.module.p276me.data.DogProgressRsp;
import com.jiayouya.travel.module.p276me.widget.MapView;

public abstract class ActivityMapBinding extends ViewDataBinding {
    /* renamed from: a */
    public final ImageView f10054a;
    /* renamed from: b */
    public final RecyclerView f10055b;
    /* renamed from: c */
    public final FrameLayout f10056c;
    /* renamed from: d */
    public final MapView f10057d;
    /* renamed from: e */
    public final RndCornerProgressBar f10058e;
    /* renamed from: f */
    public final FrameLayout f10059f;
    /* renamed from: g */
    public final LinearLayout f10060g;
    /* renamed from: h */
    public final TextView f10061h;
    @Bindable
    /* renamed from: i */
    protected TravelCity f10062i;
    @Bindable
    /* renamed from: j */
    protected DogProgressRsp f10063j;

    /* renamed from: a */
    public abstract void mo20090a(TravelCity travelCity);

    /* renamed from: a */
    public abstract void mo20091a(DogProgressRsp dogProgressRsp);

    protected ActivityMapBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, FrameLayout frameLayout, MapView mapView, RndCornerProgressBar rndCornerProgressBar, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.f10054a = imageView;
        this.f10055b = recyclerView;
        this.f10056c = frameLayout;
        this.f10057d = mapView;
        this.f10058e = rndCornerProgressBar;
        this.f10059f = frameLayout2;
        this.f10060g = linearLayout;
        this.f10061h = textView;
    }
}
