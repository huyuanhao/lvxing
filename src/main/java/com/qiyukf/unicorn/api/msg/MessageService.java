package com.qiyukf.unicorn.api.msg;

import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.p514h.C6185c;

public class MessageService {
    public static void sendMessage(IMMessage iMMessage) {
        C6185c.m24535b(iMMessage);
    }

    public static void sendProductMessage(ProductDetail productDetail) {
        sendProductMessage(C6185c.m24533a(), productDetail);
    }

    public static void sendProductMessage(String str, ProductDetail productDetail) {
        ProductAttachment productAttachment = new ProductAttachment();
        productAttachment.fromProductDetail(productDetail, false);
        if (productAttachment.getSendByUser() == 1) {
            productAttachment.setSendByUser(0);
        }
        if (productAttachment.getShow() == 1) {
            IMMessage buildCustomMessage = UnicornMessageBuilder.buildCustomMessage(str, productAttachment);
            buildCustomMessage.setStatus(MsgStatusEnum.success);
            C6185c.m24535b(buildCustomMessage);
            return;
        }
        C6185c.m24532a(productAttachment, str, false);
    }
}
