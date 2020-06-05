package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.common.data.User;
import com.jiayouya.travel.module.p276me.data.VoiceStatus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;
import p641de.hdodenhof.circleimageview.CircleImageView;

public class ActivitySettingBindingImpl extends ActivitySettingBinding {
    /* renamed from: k */
    private static final IncludedLayouts f10207k = null;
    /* renamed from: l */
    private static final SparseIntArray f10208l = new SparseIntArray();
    /* renamed from: m */
    private final LinearLayout f10209m;
    /* renamed from: n */
    private final TextView f10210n;
    /* renamed from: o */
    private final LinearLayout f10211o;
    /* renamed from: p */
    private final CircleImageView f10212p;
    /* renamed from: q */
    private final LinearLayout f10213q;
    /* renamed from: r */
    private final TextView f10214r;
    /* renamed from: s */
    private final TextView f10215s;
    /* renamed from: t */
    private final TextView f10216t;
    /* renamed from: u */
    private final LinearLayout f10217u;
    /* renamed from: v */
    private final LinearLayout f10218v;
    /* renamed from: w */
    private long f10219w;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10208l.put(R.id.toolbar, 13);
        f10208l.put(R.id.refresh, 14);
        f10208l.put(R.id.lyt_ali, 15);
        f10208l.put(R.id.btn_exit, 16);
    }

    public ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, f10207k, f10208l));
    }

    private ActivitySettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[16], (LinearLayout) objArr[15], (LinearLayout) objArr[1], (LinearLayout) objArr[5], (SmartRefreshLayout) objArr[14], (Switch) objArr[12], (CenteredTitleBar) objArr[13]);
        this.f10219w = -1;
        this.f10199c.setTag(null);
        this.f10200d.setTag(null);
        this.f10209m = objArr[0];
        this.f10209m.setTag(null);
        this.f10210n = objArr[10];
        this.f10210n.setTag(null);
        this.f10211o = objArr[11];
        this.f10211o.setTag(null);
        this.f10212p = objArr[2];
        this.f10212p.setTag(null);
        this.f10213q = objArr[3];
        this.f10213q.setTag(null);
        this.f10214r = objArr[4];
        this.f10214r.setTag(null);
        this.f10215s = objArr[6];
        this.f10215s.setTag(null);
        this.f10216t = objArr[7];
        this.f10216t.setTag(null);
        this.f10217u = objArr[8];
        this.f10217u.setTag(null);
        this.f10218v = objArr[9];
        this.f10218v.setTag(null);
        this.f10202f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10219w = 8;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10219w != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (24 == i) {
            mo20103a((String) obj);
            return true;
        } else if (1 == i) {
            mo20102a((VoiceStatus) obj);
            return true;
        } else if (33 != i) {
            return false;
        } else {
            mo20101a((User) obj);
            return true;
        }
    }

    /* renamed from: a */
    public void mo20103a(String str) {
        this.f10206j = str;
        synchronized (this) {
            this.f10219w |= 1;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20102a(VoiceStatus voiceStatus) {
        this.f10205i = voiceStatus;
        synchronized (this) {
            this.f10219w |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20101a(User user) {
        this.f10204h = user;
        synchronized (this) {
            this.f10219w |= 4;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
            if (r6 == 1) goto L_0x0025;
     */
    public void executeBindings() {
        /*
        r22 = this;
        r1 = r22
        monitor-enter(r22)
        long r2 = r1.f10219w     // Catch:{ all -> 0x00de }
        r4 = 0
        r1.f10219w = r4     // Catch:{ all -> 0x00de }
        monitor-exit(r22)     // Catch:{ all -> 0x00de }
        java.lang.String r0 = r1.f10206j
        com.jiayouya.travel.module.me.data.VoiceStatus r6 = r1.f10205i
        com.jiayouya.travel.module.common.data.User r7 = r1.f10204h
        r8 = 10
        long r10 = r2 & r8
        int r13 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
        if (r13 == 0) goto L_0x0024
        if (r6 == 0) goto L_0x001f
        int r6 = r6.getStatus()
        goto L_0x0020
    L_0x001f:
        r6 = 0
    L_0x0020:
        r10 = 1
        if (r6 != r10) goto L_0x0024
        goto L_0x0025
    L_0x0024:
        r10 = 0
    L_0x0025:
        r13 = 12
        long r15 = r2 & r13
        int r11 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
        if (r11 == 0) goto L_0x005f
        if (r7 == 0) goto L_0x0040
        java.lang.String r15 = r7.getAvatar()
        java.lang.String r16 = r7.getNickname()
        boolean r17 = r7.isBindAliPay()
        java.lang.String r7 = r7.getMobile()
        goto L_0x0046
    L_0x0040:
        r7 = 0
        r15 = 0
        r16 = 0
        r17 = 0
    L_0x0046:
        if (r11 == 0) goto L_0x0051
        if (r17 == 0) goto L_0x004d
        r18 = 32
        goto L_0x004f
    L_0x004d:
        r18 = 16
    L_0x004f:
        long r2 = r2 | r18
    L_0x0051:
        if (r17 == 0) goto L_0x0056
        java.lang.String r11 = "已绑定"
        goto L_0x0058
    L_0x0056:
        java.lang.String r11 = "未绑定"
    L_0x0058:
        r8 = r11
        r9 = r17
        r11 = r7
        r7 = r16
        goto L_0x0064
    L_0x005f:
        r7 = 0
        r8 = 0
        r9 = 0
        r11 = 0
        r15 = 0
    L_0x0064:
        r18 = 8
        long r18 = r2 & r18
        int r20 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
        if (r20 == 0) goto L_0x0096
        android.widget.LinearLayout r12 = r1.f10199c
        java.lang.String r6 = "/me/avatar"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r12, r6)
        android.widget.LinearLayout r6 = r1.f10200d
        java.lang.String r12 = "/me/phone"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r6, r12)
        android.widget.LinearLayout r6 = r1.f10211o
        java.lang.String r12 = "/me/private"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r6, r12)
        android.widget.LinearLayout r6 = r1.f10213q
        java.lang.String r12 = "/me/nickname"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r6, r12)
        android.widget.LinearLayout r6 = r1.f10217u
        java.lang.String r12 = "/me/private"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r6, r12)
        android.widget.LinearLayout r6 = r1.f10218v
        java.lang.String r12 = "/me/aboutUs"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r6, r12)
    L_0x0096:
        r20 = 9
        long r20 = r2 & r20
        int r6 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
        if (r6 == 0) goto L_0x00a3
        android.widget.TextView r6 = r1.f10210n
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r0)
    L_0x00a3:
        long r12 = r2 & r13
        int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
        if (r0 == 0) goto L_0x00cd
        de.hdodenhof.circleimageview.CircleImageView r0 = r1.f10212p
        r6 = 0
        r12 = r6
        jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r12 = (p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType) r12
        java.lang.Integer r6 = (java.lang.Integer) r6
        r13 = 0
        com.jiayouya.travel.common.p243a.ImageAdapter.m12783a(r0, r15, r13, r12, r6)
        android.widget.TextView r0 = r1.f10214r
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r7)
        android.widget.TextView r0 = r1.f10215s
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r11)
        android.widget.TextView r0 = r1.f10216t
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r8)
        android.widget.TextView r0 = r1.f10216t
        java.lang.Boolean r6 = java.lang.Boolean.valueOf(r9)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12796b(r0, r6)
    L_0x00cd:
        r6 = 10
        long r2 = r2 & r6
        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r0 == 0) goto L_0x00dd
        android.widget.Switch r0 = r1.f10202f
        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)
        com.jiayouya.travel.common.p243a.CustomAdapter.m12776a(r0, r2)
    L_0x00dd:
        return
    L_0x00de:
        r0 = move-exception
        monitor-exit(r22)     // Catch:{ all -> 0x00de }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.databinding.ActivitySettingBindingImpl.executeBindings():void");
    }
}
