package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.answer.data.Questions;
import ezy.p653ui.widget.round.RoundText;

public class ActivityAnswerBindingImpl extends ActivityAnswerBinding {
    /* renamed from: h */
    private static final IncludedLayouts f9827h = null;
    /* renamed from: i */
    private static final SparseIntArray f9828i = new SparseIntArray();
    /* renamed from: j */
    private final LinearLayout f9829j;
    /* renamed from: k */
    private final RoundText f9830k;
    /* renamed from: l */
    private final TextView f9831l;
    /* renamed from: m */
    private long f9832m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9828i.put(R.id.lyt_container, 5);
        f9828i.put(R.id.list, 6);
    }

    public ActivityAnswerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, f9827h, f9828i));
    }

    private ActivityAnswerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[4], (TextView) objArr[3], (RecyclerView) objArr[6], (LinearLayout) objArr[5]);
        this.f9832m = -1;
        this.f9820a.setTag(null);
        this.f9821b.setTag(null);
        this.f9829j = objArr[0];
        this.f9829j.setTag(null);
        this.f9830k = objArr[1];
        this.f9830k.setTag(null);
        this.f9831l = objArr[2];
        this.f9831l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9832m = 8;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9832m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20071a((Questions) obj);
        } else if (3 == i) {
            mo20072a(((Boolean) obj).booleanValue());
        } else if (14 != i) {
            return false;
        } else {
            mo20073b(((Boolean) obj).booleanValue());
        }
        return true;
    }

    /* renamed from: a */
    public void mo20071a(Questions questions) {
        this.f9824e = questions;
        synchronized (this) {
            this.f9832m |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20072a(boolean z) {
        this.f9825f = z;
        synchronized (this) {
            this.f9832m |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    /* renamed from: b */
    public void mo20073b(boolean z) {
        this.f9826g = z;
        synchronized (this) {
            this.f9832m |= 4;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        synchronized (this) {
            j = this.f9832m;
            this.f9832m = 0;
        }
        Questions questions = this.f9824e;
        boolean z2 = this.f9825f;
        boolean z3 = this.f9826g;
        boolean z4 = false;
        CharSequence charSequence3 = null;
        int i = ((j & 9) > 0 ? 1 : ((j & 9) == 0 ? 0 : -1));
        if (i != 0) {
            if (questions != null) {
                charSequence = questions.getQuestion();
                z = questions.isSingle();
            } else {
                charSequence = null;
                z = false;
            }
            if (i != 0) {
                j |= z ? 32 : 16;
            }
            charSequence2 = z ? "单选" : "多选";
        } else {
            charSequence2 = null;
            charSequence = null;
        }
        if ((j & 10) != 0) {
            z4 = !z2;
        }
        int i2 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (i2 != 0) {
                j |= z3 ? 128 : 64;
            }
            charSequence3 = z3 ? "下一题" : "提交";
        }
        if ((j & 12) != 0) {
            TextViewBindingAdapter.setText(this.f9820a, charSequence3);
        }
        if ((j & 10) != 0) {
            ViewAdapter.m12798c((View) this.f9821b, Boolean.valueOf(z4));
        }
        if ((j & 9) != 0) {
            TextViewBindingAdapter.setText(this.f9830k, charSequence2);
            TextViewBindingAdapter.setText(this.f9831l, charSequence);
        }
    }
}
