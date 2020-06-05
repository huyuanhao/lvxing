package com.jiayouya.travel.databinding;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.common.data.User;
import ezy.p653ui.widget.CenteredTitleBar;
import ezy.p653ui.widget.round.RoundText;
import tech.linjiang.android.drawable.Drawables;

public class ActivityPhoneBindingImpl extends ActivityPhoneBinding {
    /* renamed from: h */
    private static final IncludedLayouts f10125h = null;
    /* renamed from: i */
    private static final SparseIntArray f10126i = new SparseIntArray();
    /* renamed from: j */
    private final LinearLayout f10127j;
    /* renamed from: k */
    private final CenteredTitleBar f10128k;
    /* renamed from: l */
    private long f10129l;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10126i.put(R.id.edit_phone, 4);
        f10126i.put(R.id.tv_get_code, 5);
        f10126i.put(R.id.edit_code, 6);
    }

    public ActivityPhoneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f10125h, f10126i));
    }

    private ActivityPhoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[3], (EditText) objArr[6], (EditText) objArr[4], (TextView) objArr[2], (TextView) objArr[5]);
        this.f10129l = -1;
        this.f10118a.setTag(null);
        this.f10127j = objArr[0];
        this.f10127j.setTag(null);
        this.f10128k = objArr[1];
        this.f10128k.setTag(null);
        this.f10121d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10129l = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10129l != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (33 == i) {
            mo20095a((User) obj);
        } else if (32 != i) {
            return false;
        } else {
            mo20094a(((Integer) obj).intValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20095a(User user) {
        this.f10123f = user;
        synchronized (this) {
            this.f10129l |= 1;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20094a(int i) {
        this.f10124g = i;
        synchronized (this) {
            this.f10129l |= 2;
        }
        notifyPropertyChanged(32);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        boolean z;
        CharSequence charSequence2;
        synchronized (this) {
            j = this.f10129l;
            this.f10129l = 0;
        }
        User user = this.f10123f;
        int i = this.f10124g;
        if ((j & 7) != 0) {
            z = TextUtils.isEmpty(user != null ? user.getMobile() : null);
            if ((j & 5) != 0) {
                j |= z ? 16 : 8;
            }
            if ((j & 7) != 0) {
                j = z ? j | 256 : j | 128;
            }
            charSequence = (j & 5) != 0 ? z ? "绑定手机号" : "更换手机号" : null;
        } else {
            charSequence = null;
            z = false;
        }
        int i2 = ((j & 128) > 0 ? 1 : ((j & 128) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean z2 = true;
            if (i != 1) {
                z2 = false;
            }
            if (i2 != 0) {
                j |= z2 ? 64 : 32;
            }
            charSequence2 = z2 ? "更换" : "下一步";
        } else {
            charSequence2 = null;
        }
        int i3 = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        CharSequence charSequence3 = i3 != 0 ? z ? "提交" : charSequence2 : null;
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.f10118a, charSequence3);
        }
        if ((j & 5) != 0) {
            this.f10128k.setTitle(charSequence);
        }
        if ((j & 4) != 0) {
            Integer num = null;
            Integer num2 = num;
            Integer num3 = num;
            Integer num4 = num;
            Integer num5 = num;
            Integer num6 = num;
            Integer num7 = num;
            Integer num8 = num;
            Integer num9 = num;
            Integer num10 = num;
            Integer num11 = num;
            Integer num12 = num;
            Integer num13 = num;
            Integer num14 = num;
            Integer num15 = num;
            Integer num16 = num;
            Integer num17 = num;
            Integer num18 = num;
            Integer num19 = num;
            Integer num20 = num;
            Integer num21 = num;
            Integer num22 = num;
            Integer num23 = num;
            Integer num24 = num;
            Integer num25 = num;
            Integer num26 = num;
            Integer num27 = num;
            Integer num28 = num;
            Integer num29 = num;
            Integer num30 = num;
            Integer num31 = num;
            Integer num32 = num;
            Integer num33 = num;
            Integer num34 = num;
            Integer num35 = num;
            Integer num36 = num;
            Integer num37 = num;
            Integer num38 = num;
            Integer num39 = num;
            Integer num40 = num;
            Integer num41 = num;
            Integer num42 = num;
            Integer num43 = num;
            Integer num44 = num;
            Integer num45 = num;
            Integer num46 = num;
            Integer num47 = num;
            Integer num48 = num;
            Integer num49 = num;
            Integer num50 = num;
            Integer num51 = num;
            Integer num52 = num;
            Integer num53 = num;
            Integer num54 = num;
            Integer num55 = num;
            Integer num56 = num;
            Integer num57 = num;
            Integer num58 = num;
            Integer num59 = num;
            Integer num60 = num;
            Integer num61 = num;
            Integer num62 = num;
            Integer num63 = num;
            Integer num64 = num;
            Integer num65 = num;
            Integer num66 = num;
            Integer num67 = num;
            Integer num68 = num;
            Integer num69 = num;
            Integer num70 = num;
            Integer num71 = num;
            Integer num72 = num;
            Integer num73 = num;
            Integer num74 = num;
            Integer num75 = num;
            Integer num76 = num;
            Integer num77 = num;
            Integer num78 = num;
            Integer num79 = num;
            Integer num80 = num;
            Integer num81 = num;
            Integer num82 = num;
            Integer num83 = num;
            Integer num84 = num;
            Integer num85 = num;
            Integer num86 = num;
            Integer num87 = num;
            Integer num88 = num;
            Integer num89 = num;
            Integer num90 = num;
            Integer num91 = num;
            Float f = null;
            Float f2 = f;
            Float f3 = f;
            Float f4 = f;
            Float f5 = f;
            Float f6 = f;
            Float f7 = f;
            Float f8 = f;
            Float f9 = f;
            Float f10 = f;
            Float f11 = f;
            Float f12 = f;
            Float f13 = f;
            Float f14 = f;
            Float f15 = f;
            Float f16 = f;
            Float f17 = f;
            Float f18 = f;
            Float f19 = f;
            Float f20 = f;
            Float f21 = f;
            Float f22 = f;
            Float f23 = f;
            Float f24 = f;
            Float f25 = f;
            Float f26 = f;
            Float f27 = f;
            Float f28 = f;
            Float f29 = f;
            Drawable drawable = null;
            Drawables.m37723a(this.f10121d, 0, Integer.valueOf(getColorFromResource(this.f10121d, R.color.grey_f4)), 0, num27, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, num57, num79, num88, 0, 0, f8, f13, 0.0f, num28, num47, num52, num58, num63, num69, num72, f24, num80, f29, 0, num2, 0, num6, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num37, num44, num48, 0, 0, f12, f21, 0.0f, num64, num67, num70, num71, num73, num76, num81, f25, num85, f28, 0, num89, 0, num91, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num14, num19, num20, 0, 0, f10, f11, 0.0f, num24, num29, num30, num32, num33, num38, num41, f17, num46, f19, 0, num51, 0, num53, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num65, num66, num68, 0, 0, f22, f23, 0.0f, num74, num75, num77, num78, num82, num83, num84, f26, num86, f27, 0, num87, 0, num90, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num3, num4, num5, 0, 0, f2, f3, 0.0f, num8, num12, num13, num15, num16, num17, num18, f7, num21, f9, 0, num22, 0, num23, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num25, num26, num31, 0, 0, f14, f15, 0.0f, num34, num35, num39, num40, num42, num43, num45, f16, num36, f18, 0, num49, 0, num50, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, num54, num55, num56, 0, 0, f20, f6, 0.0f, num59, num60, num61, num62, num11, num10, num9, f4, num7, f5, drawable, drawable, drawable, drawable, drawable, drawable, drawable);
        }
    }
}
