package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.common.data.AdRsp;
import ezy.p653ui.widget.round.RoundLayout;

public class DialogCoinBoxBindingImpl extends DialogCoinBoxBinding {
    /* renamed from: e */
    private static final IncludedLayouts f10312e = null;
    /* renamed from: f */
    private static final SparseIntArray f10313f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f10314g;
    /* renamed from: h */
    private final ImageView f10315h;
    /* renamed from: i */
    private final TextView f10316i;
    /* renamed from: j */
    private final TextView f10317j;
    /* renamed from: k */
    private final TextView f10318k;
    /* renamed from: l */
    private long f10319l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10313f.put(R.id.iv_close, 5);
        f10313f.put(R.id.btn, 6);
    }

    public DialogCoinBoxBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10312e, f10313f));
    }

    private DialogCoinBoxBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundLayout) objArr[6], (ImageView) objArr[5]);
        this.f10319l = -1;
        this.f10314g = objArr[0];
        this.f10314g.setTag(null);
        this.f10315h = objArr[1];
        this.f10315h.setTag(null);
        this.f10316i = objArr[2];
        this.f10316i.setTag(null);
        this.f10317j = objArr[3];
        this.f10317j.setTag(null);
        this.f10318k = objArr[4];
        this.f10318k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10319l = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10319l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20108a((AdRsp) obj);
        } else if (8 != i) {
            return false;
        } else {
            mo20109a(((Boolean) obj).booleanValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20108a(AdRsp adRsp) {
        this.f10310c = adRsp;
        synchronized (this) {
            this.f10319l |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20109a(boolean z) {
        this.f10311d = z;
        synchronized (this) {
            this.f10319l |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        long j2;
        long j3;
        int i;
        String str;
        synchronized (this) {
            j = this.f10319l;
            this.f10319l = 0;
        }
        AdRsp adRsp = this.f10310c;
        boolean z = this.f10311d;
        int i2 = 0;
        if ((j & 5) != 0) {
            if (adRsp != null) {
                i = adRsp.getAdNumVideo();
                str = adRsp.getAdDesc();
            } else {
                str = null;
                i = 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("(剩余");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(i);
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append("次)");
            charSequence = sb5.toString();
        } else {
            charSequence = null;
        }
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (i3 != 0) {
                if (z) {
                    j3 = j | 16 | 64 | 256;
                    j2 = 1024;
                } else {
                    j3 = j | 8 | 32 | 128;
                    j2 = 512;
                }
                j = j3 | j2;
            }
            String str2 = z ? "10" : "5";
            int i4 = z ? 4 : 22;
            String str3 = z ? "金" : "银";
            String str4 = z ? "x10" : "x5";
            StringBuilder sb6 = new StringBuilder();
            sb6.append("发财啦，下次奖励翻");
            sb6.append(str2);
            String sb7 = sb6.toString();
            StringBuilder sb8 = new StringBuilder();
            sb8.append("恭喜获得");
            sb8.append(str3);
            String sb9 = sb8.toString();
            StringBuilder sb10 = new StringBuilder();
            sb10.append(sb7);
            sb10.append("倍！");
            charSequence3 = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(sb9);
            sb11.append("宝箱");
            String sb12 = sb11.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb12);
            sb13.append(str4);
            charSequence2 = sb13.toString();
            i2 = i4;
        } else {
            charSequence3 = null;
            charSequence2 = null;
        }
        if ((6 & j) != 0) {
            ViewAdapter.m12796b((View) this.f10315h, Boolean.valueOf(z));
            ViewAdapter.m12790a((View) this.f10316i, i2);
            TextViewBindingAdapter.setText(this.f10316i, charSequence2);
            TextViewBindingAdapter.setText(this.f10317j, charSequence3);
        }
        if ((j & 5) != 0) {
            TextViewBindingAdapter.setText(this.f10318k, charSequence);
        }
    }
}
