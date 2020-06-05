package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.module.travel.data.BagItem;
import ezy.p653ui.widget.round.RoundText;

public class ItemWarehouseBindingImpl extends ItemWarehouseBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11193c = null;
    /* renamed from: d */
    private static final SparseIntArray f11194d = null;
    /* renamed from: e */
    private final FrameLayout f11195e;
    /* renamed from: f */
    private final FrameLayout f11196f;
    /* renamed from: g */
    private final ImageView f11197g;
    /* renamed from: h */
    private final RoundText f11198h;
    /* renamed from: i */
    private final TextView f11199i;
    /* renamed from: j */
    private final TextView f11200j;
    /* renamed from: k */
    private long f11201k;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemWarehouseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, f11193c, f11194d));
    }

    private ItemWarehouseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11201k = -1;
        this.f11195e = objArr[0];
        this.f11195e.setTag(null);
        this.f11196f = objArr[1];
        this.f11196f.setTag(null);
        this.f11197g = objArr[2];
        this.f11197g.setTag(null);
        this.f11198h = objArr[3];
        this.f11198h.setTag(null);
        this.f11199i = objArr[4];
        this.f11199i.setTag(null);
        this.f11200j = objArr[5];
        this.f11200j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11201k = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11201k != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20206a((BagItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20205a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20206a(BagItem bagItem) {
        this.f11192b = bagItem;
        synchronized (this) {
            this.f11201k |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20205a(OnClickListener onClickListener) {
        this.f11191a = onClickListener;
        synchronized (this) {
            this.f11201k |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r9v2, types: [int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r9v5, types: [int] */
    /* JADX WARNING: type inference failed for: r11v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v4
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int]
  uses: [boolean, int]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
    /* JADX WARNING: Unknown variable types count: 6 */
    public void executeBindings() {
        /*
        r15 = this;
        monitor-enter(r15)
        long r0 = r15.f11201k     // Catch:{ all -> 0x009b }
        r2 = 0
        r15.f11201k = r2     // Catch:{ all -> 0x009b }
        monitor-exit(r15)     // Catch:{ all -> 0x009b }
        com.jiayouya.travel.module.travel.data.BagItem r4 = r15.f11192b
        android.view.View$OnClickListener r5 = r15.f11191a
        r6 = 5
        long r6 = r6 & r0
        r8 = 0
        r9 = 0
        int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r10 == 0) goto L_0x005c
        if (r4 == 0) goto L_0x002c
        int r9 = r4.getDogId()
        int r6 = r4.getLevel()
        int r7 = r4.getNum()
        boolean r11 = r4.isSelected()
        java.lang.String r4 = r4.getName()
        goto L_0x0030
    L_0x002c:
        r4 = r8
        r6 = 0
        r7 = 0
        r11 = 0
    L_0x0030:
        int r9 = com.jiayouya.travel.module.travel.p287c.MergeUtil.m14455b(r9)
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r6)
        java.lang.String r6 = ""
        r12.append(r6)
        java.lang.String r6 = r12.toString()
        java.lang.StringBuilder r12 = new java.lang.StringBuilder
        r12.<init>()
        r12.append(r7)
        java.lang.String r7 = ""
        r12.append(r7)
        java.lang.String r7 = r12.toString()
        r14 = r7
        r7 = r4
        r4 = r9
        r9 = r11
        r11 = r14
        goto L_0x0060
    L_0x005c:
        r6 = r8
        r7 = r6
        r11 = r7
        r4 = 0
    L_0x0060:
        r12 = 6
        long r0 = r0 & r12
        int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
        if (r10 == 0) goto L_0x0091
        android.widget.FrameLayout r0 = r15.f11195e
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12796b(r0, r1)
        android.widget.FrameLayout r0 = r15.f11196f
        java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12796b(r0, r1)
        android.widget.ImageView r0 = r15.f11197g
        java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
        com.jiayouya.travel.common.p243a.ImageAdapter.m12780a(r0, r1)
        ezy.ui.widget.round.RoundText r0 = r15.f11198h
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
        android.widget.TextView r0 = r15.f11199i
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        android.widget.TextView r0 = r15.f11200j
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
    L_0x0091:
        if (r12 == 0) goto L_0x009a
        android.widget.FrameLayout r0 = r15.f11195e
        java.lang.Integer r8 = (java.lang.Integer) r8
        com.jiayouya.travel.common.p243a.ViewAdapter.m12792a(r0, r5, r8)
    L_0x009a:
        return
    L_0x009b:
        r0 = move-exception
        monitor-exit(r15)     // Catch:{ all -> 0x009b }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.databinding.ItemWarehouseBindingImpl.executeBindings():void");
    }
}
