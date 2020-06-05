package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.answer.data.AnswerError;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import com.jiayouya.travel.module.travel.p287c.GoldUtil;
import ezy.p653ui.widget.round.RoundText;

public class ActivityAnswerResultBindingImpl extends ActivityAnswerResultBinding {
    /* renamed from: e */
    private static final IncludedLayouts f9837e = null;
    /* renamed from: f */
    private static final SparseIntArray f9838f = new SparseIntArray();
    /* renamed from: g */
    private final LinearLayout f9839g;
    /* renamed from: h */
    private final NestedScrollView f9840h;
    /* renamed from: i */
    private final TextView f9841i;
    /* renamed from: j */
    private final LinearLayout f9842j;
    /* renamed from: k */
    private final TextView f9843k;
    /* renamed from: l */
    private final TextView f9844l;
    /* renamed from: m */
    private long f9845m;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f9838f.put(R.id.btn_answer_again, 6);
        f9838f.put(R.id.list, 7);
        f9838f.put(R.id.btn_receive, 8);
    }

    public ActivityAnswerResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, f9837e, f9838f));
    }

    private ActivityAnswerResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundText) objArr[6], (RoundText) objArr[8], (RecyclerView) objArr[7]);
        this.f9845m = -1;
        this.f9839g = objArr[0];
        this.f9839g.setTag(null);
        this.f9840h = objArr[1];
        this.f9840h.setTag(null);
        this.f9841i = objArr[2];
        this.f9841i.setTag(null);
        this.f9842j = objArr[3];
        this.f9842j.setTag(null);
        this.f9843k = objArr[4];
        this.f9843k.setTag(null);
        this.f9844l = objArr[5];
        this.f9844l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f9845m = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9845m != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20075a((AnswerResult) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20075a(AnswerResult answerResult) {
        this.f9836d = answerResult;
        synchronized (this) {
            this.f9845m |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        CharSequence charSequence;
        String str;
        AnswerError answerError;
        Object obj;
        synchronized (this) {
            j = this.f9845m;
            this.f9845m = 0;
        }
        AnswerResult answerResult = this.f9836d;
        double d = 0.0d;
        boolean z2 = false;
        String str2 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (answerResult != null) {
                d = answerResult.getCoin();
                obj = answerResult.getTimeText();
                answerError = answerResult.getError();
            } else {
                obj = null;
                answerError = null;
            }
            charSequence = GoldUtil.f11900a.mo21651a(d);
            str = this.f9843k.getResources().getString(R.string.c66_and_orange, new Object[]{"恭喜获得", obj});
            z = answerError != null;
            if (answerError == null) {
                z2 = true;
            }
            if (answerError != null) {
                str2 = answerError.getNum();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("共");
            sb.append(str2);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("个错题");
            str2 = sb3.toString();
        } else {
            str = null;
            charSequence = null;
            z = false;
        }
        if (i != 0) {
            ViewAdapter.m12798c((View) this.f9840h, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f9841i, str2);
            ViewAdapter.m12798c((View) this.f9842j, Boolean.valueOf(z));
            TextViewAdapter.m12787a(this.f9843k, str);
            TextViewBindingAdapter.setText(this.f9844l, charSequence);
        }
    }
}
