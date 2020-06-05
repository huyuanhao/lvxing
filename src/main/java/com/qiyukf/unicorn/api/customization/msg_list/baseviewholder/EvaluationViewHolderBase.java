package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C6010b;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;

public abstract class EvaluationViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        C6148d dVar = (C6148d) iMMessage.getAttachment();
        bindEvaluationMsgView(context, dVar.mo29190a(), dVar.mo29184a(context));
    }

    public abstract void bindEvaluationMsgView(Context context, boolean z, CharSequence charSequence);

    public final void evaluationBtnClinck() {
        if (C6010b.m23913a().mo28845b() != null) {
            C6010b.m23913a();
        } else {
            C6029d.m24047g().mo29296c().mo29265a(this.context, this.message);
        }
    }
}
