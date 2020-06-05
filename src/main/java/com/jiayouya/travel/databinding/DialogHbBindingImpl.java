package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.data.C3325HB;
import ezy.p653ui.widget.round.RoundText;

public class DialogHbBindingImpl extends DialogHbBinding {
    /* renamed from: h */
    private static final IncludedLayouts f10452h = null;
    /* renamed from: i */
    private static final SparseIntArray f10453i = new SparseIntArray();
    /* renamed from: j */
    private final FrameLayout f10454j;
    /* renamed from: k */
    private final FrameLayout f10455k;
    /* renamed from: l */
    private final ImageView f10456l;
    /* renamed from: m */
    private final TextView f10457m;
    /* renamed from: n */
    private final RoundText f10458n;
    /* renamed from: o */
    private final LinearLayout f10459o;
    /* renamed from: p */
    private final TextView f10460p;
    /* renamed from: q */
    private long f10461q;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10453i.put(R.id.iv_close, 10);
    }

    public DialogHbBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, f10452h, f10453i));
    }

    private DialogHbBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[8], (ImageView) objArr[10], (ImageView) objArr[9], (TextView) objArr[7]);
        this.f10461q = -1;
        this.f10445a.setTag(null);
        this.f10447c.setTag(null);
        this.f10454j = objArr[0];
        this.f10454j.setTag(null);
        this.f10455k = objArr[1];
        this.f10455k.setTag(null);
        this.f10456l = objArr[2];
        this.f10456l.setTag(null);
        this.f10457m = objArr[3];
        this.f10457m.setTag(null);
        this.f10458n = objArr[4];
        this.f10458n.setTag(null);
        this.f10459o = objArr[5];
        this.f10459o.setTag(null);
        this.f10460p = objArr[6];
        this.f10460p.setTag(null);
        this.f10448d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10461q = 8;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10461q != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20123a((C3325HB) obj);
        } else if (20 == i) {
            mo20124a((String) obj);
        } else if (25 != i) {
            return false;
        } else {
            mo20122a(((Integer) obj).intValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20123a(C3325HB hb) {
        this.f10451g = hb;
        synchronized (this) {
            this.f10461q |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20124a(String str) {
        this.f10449e = str;
        synchronized (this) {
            this.f10461q |= 2;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20122a(int i) {
        this.f10450f = i;
        synchronized (this) {
            this.f10461q |= 4;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0297  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    public void executeBindings() {
        /*
        r233 = this;
        r1 = r233
        monitor-enter(r233)
        long r2 = r1.f10461q     // Catch:{ all -> 0x02b2 }
        r4 = 0
        r1.f10461q = r4     // Catch:{ all -> 0x02b2 }
        monitor-exit(r233)     // Catch:{ all -> 0x02b2 }
        com.jiayouya.travel.module.travel.data.HB r0 = r1.f10451g
        java.lang.String r6 = r1.f10449e
        int r7 = r1.f10450f
        r8 = 11
        long r10 = r2 & r8
        r12 = 128(0x80, double:6.32E-322)
        r14 = 10
        r16 = 64
        r18 = 0
        int r19 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
        if (r19 == 0) goto L_0x0035
        boolean r10 = android.text.TextUtils.isEmpty(r6)
        if (r19 == 0) goto L_0x002c
        if (r10 == 0) goto L_0x002a
        long r2 = r2 | r12
        goto L_0x002c
    L_0x002a:
        long r2 = r2 | r16
    L_0x002c:
        long r19 = r2 & r14
        int r11 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
        if (r11 == 0) goto L_0x0036
        r11 = r10 ^ 1
        goto L_0x0037
    L_0x0035:
        r10 = 0
    L_0x0036:
        r11 = 0
    L_0x0037:
        r19 = 192(0xc0, double:9.5E-322)
        long r19 = r2 & r19
        r21 = 0
        int r22 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
        if (r22 == 0) goto L_0x0071
        long r19 = r2 & r16
        int r22 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
        if (r22 == 0) goto L_0x0060
        if (r0 == 0) goto L_0x004e
        java.lang.String r19 = r0.getDesc2()
        goto L_0x0050
    L_0x004e:
        r19 = r21
    L_0x0050:
        if (r19 != 0) goto L_0x0054
        r18 = 1
    L_0x0054:
        if (r22 == 0) goto L_0x0062
        if (r18 == 0) goto L_0x005b
        r22 = 32
        goto L_0x005d
    L_0x005b:
        r22 = 16
    L_0x005d:
        long r2 = r2 | r22
        goto L_0x0062
    L_0x0060:
        r19 = r21
    L_0x0062:
        long r12 = r12 & r2
        int r20 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
        if (r20 == 0) goto L_0x006e
        if (r0 == 0) goto L_0x006e
        java.lang.String r0 = r0.getDesc()
        goto L_0x0075
    L_0x006e:
        r0 = r21
        goto L_0x0075
    L_0x0071:
        r0 = r21
        r19 = r0
    L_0x0075:
        long r12 = r2 & r16
        int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
        if (r16 == 0) goto L_0x0082
        if (r18 == 0) goto L_0x0084
        java.lang.String r12 = "恭喜您开红包获得"
        r19 = r12
        goto L_0x0084
    L_0x0082:
        r19 = r21
    L_0x0084:
        long r8 = r8 & r2
        int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
        if (r12 == 0) goto L_0x008f
        if (r10 == 0) goto L_0x008c
        goto L_0x0091
    L_0x008c:
        r0 = r19
        goto L_0x0091
    L_0x008f:
        r0 = r21
    L_0x0091:
        long r8 = r2 & r14
        int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
        if (r13 == 0) goto L_0x00c9
        android.widget.FrameLayout r8 = r1.f10445a
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r10)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r8, r9)
        android.widget.ImageView r8 = r1.f10447c
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r11)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r8, r9)
        ezy.ui.widget.round.RoundText r8 = r1.f10458n
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r11)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r8, r9)
        android.widget.LinearLayout r8 = r1.f10459o
        java.lang.Boolean r9 = java.lang.Boolean.valueOf(r10)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r8, r9)
        android.widget.TextView r8 = r1.f10460p
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r8, r6)
        android.widget.TextView r6 = r1.f10448d
        java.lang.Boolean r8 = java.lang.Boolean.valueOf(r10)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r6, r8)
    L_0x00c9:
        r8 = 8
        long r8 = r8 & r2
        int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
        if (r6 == 0) goto L_0x0290
        android.widget.FrameLayout r6 = r1.f10455k
        r22 = r6
        r23 = 0
        r8 = 2131099927(0x7f060117, float:1.7812221E38)
        int r6 = getColorFromResource(r6, r8)
        java.lang.Integer r24 = java.lang.Integer.valueOf(r6)
        r25 = 0
        r6 = r21
        java.lang.Integer r6 = (java.lang.Integer) r6
        r53 = r6
        r150 = r6
        r151 = r6
        r152 = r6
        r55 = r6
        r224 = r6
        r158 = r6
        r222 = r6
        r221 = r6
        r220 = r6
        r159 = r6
        r160 = r6
        r92 = r6
        r161 = r6
        r162 = r6
        r163 = r6
        r164 = r6
        r93 = r6
        r94 = r6
        r166 = r6
        r169 = r6
        r171 = r6
        r100 = r6
        r179 = r6
        r180 = r6
        r26 = r6
        r42 = r6
        r101 = r6
        r102 = r6
        r181 = r6
        r103 = r6
        r104 = r6
        r187 = r6
        r188 = r6
        r195 = r6
        r63 = r6
        r105 = r6
        r189 = r6
        r190 = r6
        r106 = r6
        r191 = r6
        r192 = r6
        r64 = r6
        r193 = r6
        r108 = r6
        r43 = r6
        r65 = r6
        r198 = r6
        r200 = r6
        r111 = r6
        r44 = r6
        r113 = r6
        r208 = r6
        r209 = r6
        r210 = r6
        r34 = r6
        r45 = r6
        r216 = r6
        r217 = r6
        r218 = r6
        r219 = r6
        r46 = r6
        r71 = r6
        r121 = r6
        r122 = r6
        r72 = r6
        r123 = r6
        r47 = r6
        r73 = r6
        r74 = r6
        r48 = r6
        r75 = r6
        r129 = r6
        r130 = r6
        r76 = r6
        r131 = r6
        r132 = r6
        r35 = r6
        r50 = r6
        r77 = r6
        r133 = r6
        r134 = r6
        r135 = r6
        r79 = r6
        r137 = r6
        r140 = r6
        r36 = r6
        r82 = r6
        r142 = r6
        r84 = r6
        r27 = 0
        r28 = 0
        r29 = 1092616192(0x41200000, float:10.0)
        r30 = 0
        r31 = 0
        r32 = 0
        r33 = 0
        r37 = 0
        r38 = 0
        r6 = r21
        java.lang.Float r6 = (java.lang.Float) r6
        r155 = r6
        r156 = r6
        r223 = r6
        r225 = r6
        r214 = r6
        r165 = r6
        r39 = r6
        r167 = r6
        r97 = r6
        r98 = r6
        r68 = r6
        r40 = r6
        r184 = r6
        r185 = r6
        r194 = r6
        r107 = r6
        r196 = r6
        r109 = r6
        r213 = r6
        r69 = r6
        r126 = r6
        r127 = r6
        r49 = r6
        r78 = r6
        r136 = r6
        r138 = r6
        r80 = r6
        r51 = r6
        r41 = 0
        r52 = 0
        r54 = 0
        r56 = 0
        r57 = 0
        r58 = 0
        r59 = 0
        r60 = 0
        r61 = 0
        r62 = 0
        r66 = 0
        r67 = 0
        r70 = 0
        r81 = 0
        r83 = 0
        r85 = 0
        r86 = 0
        r87 = 0
        r88 = 0
        r89 = 0
        r90 = 0
        r91 = 0
        r95 = 0
        r96 = 0
        r99 = 0
        r110 = 0
        r112 = 0
        r114 = 0
        r115 = 0
        r116 = 0
        r117 = 0
        r118 = 0
        r119 = 0
        r120 = 0
        r124 = 0
        r125 = 0
        r128 = 0
        r139 = 0
        r141 = 0
        r143 = 0
        r144 = 0
        r145 = 0
        r146 = 0
        r147 = 0
        r148 = 0
        r149 = 0
        r153 = 0
        r154 = 0
        r157 = 0
        r168 = 0
        r170 = 0
        r172 = 0
        r173 = 0
        r174 = 0
        r175 = 0
        r176 = 0
        r177 = 0
        r178 = 0
        r182 = 0
        r183 = 0
        r186 = 0
        r197 = 0
        r199 = 0
        r201 = 0
        r202 = 0
        r203 = 0
        r204 = 0
        r205 = 0
        r206 = 0
        r207 = 0
        r211 = 0
        r212 = 0
        r215 = 0
        r6 = r21
        android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6
        r226 = r6
        r232 = r6
        r227 = r6
        r231 = r6
        r228 = r6
        r229 = r6
        r230 = r6
        tech.linjiang.android.drawable.Drawables.m37723a(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232)
    L_0x0290:
        r8 = 12
        long r2 = r2 & r8
        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r6 == 0) goto L_0x02aa
        android.widget.ImageView r2 = r1.f10456l
        java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
        r4 = 10
        r5 = r21
        jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r5 = (p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType) r5
        r6 = r21
        java.lang.Integer r6 = (java.lang.Integer) r6
        com.jiayouya.travel.common.p243a.ImageAdapter.m12781a(r2, r3, r4, r5, r6)
    L_0x02aa:
        if (r12 == 0) goto L_0x02b1
        android.widget.TextView r2 = r1.f10457m
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r0)
    L_0x02b1:
        return
    L_0x02b2:
        r0 = move-exception
        monitor-exit(r233)     // Catch:{ all -> 0x02b2 }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.databinding.DialogHbBindingImpl.executeBindings():void");
    }
}
