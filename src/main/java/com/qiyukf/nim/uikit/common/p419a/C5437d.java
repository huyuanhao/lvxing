package com.qiyukf.nim.uikit.common.p419a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qiyukf.basesdk.p393a.C5264a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.qiyukf.nim.uikit.common.a.d */
public class C5437d<T> extends BaseAdapter implements C5435b {
    /* renamed from: a */
    protected final Context f17430a;
    /* renamed from: b */
    private final List<T> f17431b;
    /* renamed from: c */
    private final C5438e f17432c;
    /* renamed from: d */
    private final LayoutInflater f17433d;
    /* renamed from: e */
    private final Map<Class<?>, Integer> f17434e = new HashMap(getViewTypeCount());
    /* renamed from: f */
    private Object f17435f;
    /* renamed from: g */
    private boolean f17436g;
    /* renamed from: h */
    private Set<C5434a> f17437h = new HashSet();

    public C5437d(Context context, List<T> list, C5438e eVar) {
        this.f17430a = context;
        this.f17431b = list;
        this.f17432c = eVar;
        this.f17433d = LayoutInflater.from(context);
    }

    /* renamed from: a */
    private View m22198a(int i, View view) {
        if (view == null) {
            view = m22199b(i);
        }
        C5439f fVar = (C5439f) view.getTag();
        fVar.setPosition(i);
        try {
            fVar.refresh(getItem(i));
            mo27382a(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder("refresh viewholder error. ");
            sb.append(e);
            C5264a.m21622c("TAdapter", sb.toString());
        }
        if (fVar instanceof C5434a) {
            this.f17437h.add(fVar);
        }
        return view;
    }

    /* renamed from: b */
    private View m22199b(int i) {
        View view = null;
        try {
            C5439f fVar = (C5439f) this.f17432c.mo27379a(i).newInstance();
            fVar.setAdapter(this);
            fVar.setContext(this.f17430a);
            view = fVar.getView(this.f17433d);
            view.setTag(fVar);
            return view;
        } catch (Exception e) {
            C5264a.m21621b("TAdapter", " viewAtPosition is error", e);
            return view;
        }
    }

    /* renamed from: a */
    public final List<T> mo27381a() {
        return this.f17431b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27382a(int i) {
    }

    /* renamed from: a */
    public final void mo27377a(View view) {
        if (view != null) {
            C5439f fVar = (C5439f) view.getTag();
            if (fVar != null) {
                fVar.reclaim();
                this.f17437h.remove(fVar);
            }
        }
    }

    /* renamed from: a */
    public final void mo27383a(Object obj) {
        this.f17435f = obj;
    }

    /* renamed from: b */
    public final boolean mo27384b() {
        return this.f17436g;
    }

    /* renamed from: c */
    public final Object mo27385c() {
        return this.f17435f;
    }

    public int getCount() {
        List<T> list = this.f17431b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T getItem(int i) {
        if (i < getCount()) {
            return this.f17431b.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (getViewTypeCount() == 1) {
            return 0;
        }
        Class a = this.f17432c.mo27379a(i);
        if (this.f17434e.containsKey(a)) {
            return ((Integer) this.f17434e.get(a)).intValue();
        }
        int size = this.f17434e.size();
        if (size >= getViewTypeCount()) {
            return 0;
        }
        this.f17434e.put(a, Integer.valueOf(size));
        return size;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m22198a(i, view);
    }

    public int getViewTypeCount() {
        return this.f17432c.mo27378a();
    }

    public boolean isEnabled(int i) {
        return this.f17432c.mo27380b();
    }
}
