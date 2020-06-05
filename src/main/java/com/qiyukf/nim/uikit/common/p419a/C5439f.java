package com.qiyukf.nim.uikit.common.p419a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: com.qiyukf.nim.uikit.common.a.f */
public abstract class C5439f<T> implements C5434a {
    protected C5437d adapter;
    protected Context context;
    protected int position;
    protected View view;

    public void destroy() {
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.view.findViewById(i);
    }

    /* access modifiers changed from: protected */
    public C5437d getAdapter() {
        return this.adapter;
    }

    public abstract int getResId();

    public View getView(LayoutInflater layoutInflater) {
        this.view = layoutInflater.inflate(getResId(), null);
        inflate();
        return this.view;
    }

    public abstract void inflate();

    public boolean isFirstItem() {
        return this.position == 0;
    }

    public boolean isLastItem() {
        return this.position == this.adapter.getCount() - 1;
    }

    /* access modifiers changed from: protected */
    public boolean mutable() {
        return this.adapter.mo27384b();
    }

    public void onImmutable() {
    }

    public void reclaim() {
    }

    public abstract void refresh(T t);

    /* access modifiers changed from: protected */
    public void setAdapter(C5437d dVar) {
        this.adapter = dVar;
    }

    /* access modifiers changed from: protected */
    public void setContext(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void setPosition(int i) {
        this.position = i;
    }
}
