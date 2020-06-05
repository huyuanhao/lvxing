package com.jiayouya.travel.databinding;

import android.view.View;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jiayouya.travel.module.answer.data.AnswerResult;
import ezy.p653ui.widget.round.RoundText;

public abstract class ActivityAnswerResultBinding extends ViewDataBinding {
    /* renamed from: a */
    public final RoundText f9833a;
    /* renamed from: b */
    public final RoundText f9834b;
    /* renamed from: c */
    public final RecyclerView f9835c;
    @Bindable
    /* renamed from: d */
    protected AnswerResult f9836d;

    /* renamed from: a */
    public abstract void mo20075a(AnswerResult answerResult);

    protected ActivityAnswerResultBinding(Object obj, View view, int i, RoundText roundText, RoundText roundText2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f9833a = roundText;
        this.f9834b = roundText2;
        this.f9835c = recyclerView;
    }
}
