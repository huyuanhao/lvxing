package com.qiyukf.nim.uikit.session.viewholder;

import com.qiyukf.nimlib.sdk.msg.attachment.NotificationAttachment;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.customization.msg_list.MessageHandlerFactory;
import com.qiyukf.unicorn.api.customization.msg_list.UnicornMessageHandler;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import java.util.HashMap;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.c */
public final class C5629c {
    /* renamed from: a */
    private static HashMap<Class<? extends MsgAttachment>, Class<? extends C5622b>> f18125a = new HashMap<>();
    /* renamed from: b */
    private static HashMap<Class<? extends MsgAttachment>, Class<? extends C5622b>> f18126b = new HashMap<>();
    /* renamed from: c */
    private static HashMap<MsgTypeEnum, Class<? extends C5622b>> f18127c = new HashMap<>();
    /* renamed from: d */
    private static MessageHandlerFactory f18128d;

    static {
        m22789a(ImageAttachment.class, C5633g.class, false);
        m22789a(AudioAttachment.class, C5619a.class, false);
        m22789a(NotificationAttachment.class, C5632f.class, false);
        m22789a(FileAttachment.class, C5630d.class, false);
        m22789a(VideoAttachment.class, C5640l.class, false);
    }

    /* renamed from: a */
    public static int m22784a() {
        return f18125a.size() + 3;
    }

    /* renamed from: a */
    public static Class<? extends C5622b> m22785a(IMMessage iMMessage) {
        Class<C5639k> cls;
        HashMap<MsgTypeEnum, Class<? extends C5622b>> hashMap;
        MsgTypeEnum msgTypeEnum;
        if (iMMessage.getMsgType() == MsgTypeEnum.text) {
            if (f18127c.get(MsgTypeEnum.text) == null) {
                return C5635h.class;
            }
            hashMap = f18127c;
            msgTypeEnum = MsgTypeEnum.text;
        } else if (iMMessage.getMsgType() != MsgTypeEnum.tips) {
            if (iMMessage.getAttachment() != null) {
                Class cls2 = iMMessage.getAttachment().getClass();
                cls = null;
                while (cls == null && cls2 != null) {
                    cls = (Class) f18126b.get(cls2);
                    if (cls == null) {
                        cls = (Class) f18125a.get(cls2);
                    }
                    if (cls == null) {
                        Class superclass = cls2.getSuperclass();
                        if (superclass == null || !MsgAttachment.class.isAssignableFrom(superclass)) {
                            Class[] interfaces = cls2.getInterfaces();
                            int length = interfaces.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    cls2 = null;
                                    break;
                                }
                                Class cls3 = interfaces[i];
                                if (MsgAttachment.class.isAssignableFrom(cls3)) {
                                    cls2 = cls3;
                                    break;
                                }
                                i++;
                            }
                        } else {
                            cls2 = superclass;
                        }
                    }
                }
            } else {
                cls = null;
            }
            if (cls == null) {
                cls = C5639k.class;
            }
            return cls;
        } else if (f18127c.get(MsgTypeEnum.tips) == null) {
            return C5638j.class;
        } else {
            hashMap = f18127c;
            msgTypeEnum = MsgTypeEnum.tips;
        }
        return (Class) hashMap.get(msgTypeEnum);
    }

    /* renamed from: a */
    public static void m22786a(MessageHandlerFactory messageHandlerFactory) {
        f18128d = messageHandlerFactory;
    }

    /* renamed from: a */
    public static void m22787a(MsgTypeEnum msgTypeEnum, Class<? extends C5622b> cls) {
        f18127c.put(msgTypeEnum, cls);
    }

    @Deprecated
    /* renamed from: a */
    public static void m22788a(Class<? extends MsgAttachment> cls, Class<? extends C5622b> cls2) {
        m22789a(cls, cls2, false);
    }

    /* renamed from: a */
    public static void m22789a(Class<? extends MsgAttachment> cls, Class<? extends C5622b> cls2, boolean z) {
        (z ? f18126b : f18125a).put(cls, cls2);
    }

    /* renamed from: b */
    public static UnicornMessageHandler m22790b(IMMessage iMMessage) {
        if (iMMessage.getAttachment() != null) {
            MessageHandlerFactory messageHandlerFactory = f18128d;
            if (messageHandlerFactory != null) {
                return messageHandlerFactory.handlerOf(iMMessage);
            }
        }
        return null;
    }
}
