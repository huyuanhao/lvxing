package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.p514h.C6185c;

public abstract class ProductViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        ProductAttachment productAttachment = (ProductAttachment) iMMessage.getAttachment();
        boolean z = true;
        if (!(productAttachment.getSendByUser() == 1 && iMMessage.getDirect() == MsgDirectionEnum.Out && C6029d.m24047g().mo29301f(iMMessage.getSessionId()) != 1)) {
            z = false;
        }
        bindTextMsgView(context, productAttachment, Boolean.valueOf(z));
    }

    public abstract void bindTextMsgView(Context context, ProductAttachment productAttachment, Boolean bool);

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    public final void onClickToSendByUser(ProductAttachment productAttachment) {
        int i;
        if (C6029d.m24047g().mo29301f(this.message.getSessionId()) == 1) {
            i = C5961R.string.ysf_send_card_robot;
        } else if (!C6185c.m24536b()) {
            i = C5961R.string.ysf_send_card_error;
        } else {
            ProductAttachment clone = productAttachment.clone();
            if (clone != null) {
                clone.setSendByUser(0);
                clone.setActionText("");
                C6185c.m24535b(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, clone));
            }
            return;
        }
        C5415g.m22165b(i);
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
