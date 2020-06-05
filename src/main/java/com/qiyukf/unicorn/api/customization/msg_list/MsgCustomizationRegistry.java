package com.qiyukf.unicorn.api.customization.msg_list;

import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.nim.uikit.session.viewholder.C5629c;
import com.qiyukf.nim.uikit.session.viewholder.C5631e;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.EvaluationViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.ProductViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.TextViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.TipsViewHolderBase;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;

public class MsgCustomizationRegistry {
    @SafeVarargs
    public static void hideViewForMsgType(Class<? extends MsgAttachment>... clsArr) {
        for (Class<? extends MsgAttachment> a : clsArr) {
            C5629c.m22789a(a, C5631e.class, false);
        }
    }

    public static void registerMessageHandlerFactory(MessageHandlerFactory messageHandlerFactory) {
        C5629c.m22786a(messageHandlerFactory);
    }

    public static void registerMessageViewHolder(Class<? extends C5622b> cls) {
        if (TextViewHolderBase.class.isAssignableFrom(cls)) {
            C5629c.m22787a(MsgTypeEnum.text, cls);
        } else if (TipsViewHolderBase.class.isAssignableFrom(cls)) {
            C5629c.m22787a(MsgTypeEnum.tips, cls);
        } else if (EvaluationViewHolderBase.class.isAssignableFrom(cls)) {
            C5629c.m22789a(C6148d.class, cls, true);
        } else {
            if (ProductViewHolderBase.class.isAssignableFrom(cls)) {
                C5629c.m22789a(ProductAttachment.class, cls, true);
            }
        }
    }

    public static void registerMessageViewHolder(Class<? extends MsgAttachment> cls, Class<? extends C5622b> cls2) {
        C5629c.m22789a(cls, cls2, true);
    }
}
