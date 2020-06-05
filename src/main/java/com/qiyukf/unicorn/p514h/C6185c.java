package com.qiyukf.unicorn.p514h;

import android.text.TextUtils;
import com.qiyukf.nim.uikit.session.module.C5591b;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p516j.C6218e;
import com.tencent.mid.core.Constants.ERROR;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.h.c */
public final class C6185c {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static C5591b f19315a;

    /* renamed from: a */
    public static int m24531a(IMMessage iMMessage) {
        JSONObject extension = iMMessage.getExtension();
        if (extension != null) {
            return extension.optInt("type");
        }
        return 0;
    }

    /* renamed from: a */
    public static InvocationFuture<Void> m24532a(C6144e eVar, String str, boolean z) {
        CustomNotification createCustomNotification = MessageBuilder.createCustomNotification(eVar, str);
        MsgService msgService = (MsgService) NIMClient.getService(MsgService.class);
        return z ? msgService.sendImportantNotification(createCustomNotification) : msgService.sendCustomNotification(createCustomNotification);
    }

    /* renamed from: a */
    public static String m24533a() {
        String c = C6014b.m23942c();
        return !TextUtils.isEmpty(c) ? c : ERROR.CMD_FORMAT_ERROR;
    }

    /* renamed from: a */
    public static void m24534a(C5591b bVar) {
        f19315a = bVar;
    }

    /* renamed from: b */
    public static void m24535b(final IMMessage iMMessage) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (C6185c.f19315a != null) {
                    C6185c.f19315a.sendMessage(iMMessage, false);
                }
            }
        });
    }

    /* renamed from: b */
    public static boolean m24536b() {
        C5591b bVar = f19315a;
        return bVar != null && bVar.isAllowSendMessage(false);
    }
}
