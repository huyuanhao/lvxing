package com.jiayouya.travel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.group.data.InviteLogsItem;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class ItemInviteLogsBindingImpl extends ItemInviteLogsBinding {
    /* renamed from: c */
    private static final IncludedLayouts f11029c = null;
    /* renamed from: d */
    private static final SparseIntArray f11030d = null;
    /* renamed from: e */
    private final LinearLayout f11031e;
    /* renamed from: f */
    private final CircleImageView f11032f;
    /* renamed from: g */
    private final TextView f11033g;
    /* renamed from: h */
    private final TextView f11034h;
    /* renamed from: i */
    private final ImageView f11035i;
    /* renamed from: j */
    private final ImageView f11036j;
    /* renamed from: k */
    private final TextView f11037k;
    /* renamed from: l */
    private final TextView f11038l;
    /* renamed from: m */
    private final TextView f11039m;
    /* renamed from: n */
    private long f11040n;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemInviteLogsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, f11029c, f11030d));
    }

    private ItemInviteLogsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f11040n = -1;
        this.f11031e = objArr[0];
        this.f11031e.setTag(null);
        this.f11032f = objArr[1];
        this.f11032f.setTag(null);
        this.f11033g = objArr[2];
        this.f11033g.setTag(null);
        this.f11034h = objArr[3];
        this.f11034h.setTag(null);
        this.f11035i = objArr[4];
        this.f11035i.setTag(null);
        this.f11036j = objArr[5];
        this.f11036j.setTag(null);
        this.f11037k = objArr[6];
        this.f11037k.setTag(null);
        this.f11038l = objArr[7];
        this.f11038l.setTag(null);
        this.f11039m = objArr[8];
        this.f11039m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f11040n = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11040n != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20186a((InviteLogsItem) obj);
        } else if (2 != i) {
            return false;
        } else {
            mo20185a((OnClickListener) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20186a(InviteLogsItem inviteLogsItem) {
        this.f11027a = inviteLogsItem;
        synchronized (this) {
            this.f11040n |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20185a(OnClickListener onClickListener) {
        this.f11028b = onClickListener;
        synchronized (this) {
            this.f11040n |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        CharSequence charSequence;
        String str;
        String str2;
        String str3;
        boolean z3;
        boolean z4;
        CharSequence charSequence2;
        CornerType cornerType;
        CharSequence charSequence3;
        String str4;
        String str5;
        String str6;
        String str7;
        synchronized (this) {
            j = this.f11040n;
            this.f11040n = 0;
        }
        InviteLogsItem inviteLogsItem = this.f11027a;
        OnClickListener onClickListener = this.f11028b;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (i != 0) {
            if (inviteLogsItem != null) {
                str3 = inviteLogsItem.getAvatar();
                str6 = inviteLogsItem.getMaxLevel();
                String inviteTime = inviteLogsItem.getInviteTime();
                z2 = inviteLogsItem.isCertified();
                str5 = inviteLogsItem.getQq();
                str4 = inviteLogsItem.getWx();
                String contribution = inviteLogsItem.getContribution();
                CharSequence charSequence4 = inviteTime;
                charSequence = inviteLogsItem.getNickname();
                str7 = contribution;
                charSequence3 = charSequence4;
            } else {
                str7 = null;
                str3 = null;
                str6 = null;
                charSequence = null;
                z2 = false;
                str5 = null;
                str4 = null;
                charSequence3 = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Lv.");
            sb.append(str6);
            str = sb.toString();
            z4 = TextUtils.isEmpty(str5);
            z3 = TextUtils.isEmpty(str4);
            boolean isEmpty = TextUtils.isEmpty(str7);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str7);
            sb2.append("元");
            String sb3 = sb2.toString();
            String string = this.f11039m.getResources().getString(R.string.c66_and_red, new Object[]{"今日贡献", sb3});
            z = isEmpty;
            str2 = string;
            charSequence2 = charSequence3;
        } else {
            charSequence2 = null;
            z4 = false;
            z3 = false;
            str3 = null;
            str2 = null;
            str = null;
            charSequence = null;
            z2 = false;
            z = false;
        }
        if ((j & 6) != 0) {
            cornerType = null;
            ViewAdapter.m12792a(this.f11031e, onClickListener, null);
        } else {
            cornerType = null;
        }
        if (i != 0) {
            ImageAdapter.m12783a((ImageView) this.f11032f, str3, 0, cornerType, (Integer) cornerType);
            TextViewBindingAdapter.setText(this.f11033g, charSequence);
            ViewAdapter.m12798c((View) this.f11034h, Boolean.valueOf(z2));
            ViewAdapter.m12798c((View) this.f11035i, Boolean.valueOf(z3));
            ViewAdapter.m12798c((View) this.f11036j, Boolean.valueOf(z4));
            TextViewBindingAdapter.setText(this.f11037k, str);
            TextViewBindingAdapter.setText(this.f11038l, charSequence2);
            TextViewAdapter.m12787a(this.f11039m, str2);
            ViewAdapter.m12798c((View) this.f11039m, Boolean.valueOf(z));
        }
    }
}
