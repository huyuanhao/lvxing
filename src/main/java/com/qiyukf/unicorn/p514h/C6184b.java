package com.qiyukf.unicorn.p514h;

import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.p502e.C6053k;
import com.qiyukf.unicorn.p502e.C6054l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.h.b */
public final class C6184b {
    /* renamed from: a */
    private C6053k f19312a;
    /* renamed from: b */
    private List<OnPushMessageListener> f19313b = new ArrayList();
    /* renamed from: c */
    private C6054l f19314c;

    public C6184b(C6053k kVar, C6054l lVar) {
        this.f19312a = kVar;
        this.f19314c = lVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010a A[LOOP:0: B:25:0x0104->B:27:0x010a, LOOP_END] */
    /* renamed from: a */
    public final void mo29273a(com.qiyukf.nimlib.sdk.msg.model.IMMessage r7) {
        /*
        r6 = this;
        int r0 = com.qiyukf.unicorn.p514h.C6185c.m24531a(r7)
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r1 = r7.getDirect()
        com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum r2 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In
        if (r1 != r2) goto L_0x0114
        r1 = 2
        if (r0 != r1) goto L_0x0114
        org.json.JSONObject r0 = r7.getExtension()
        java.lang.String r1 = "msgSessionId"
        java.lang.String r0 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r0, r1)
        com.qiyukf.unicorn.f.a.e.g r1 = new com.qiyukf.unicorn.f.a.e.g
        r2 = 1
        r1.m50433init(r0, r2)
        java.lang.String r3 = r7.getSessionId()
        com.qiyukf.unicorn.p514h.C6185c.m24532a(r1, r3, r2)
        com.qiyukf.unicorn.p499b.C6014b.m23977p(r0)
        org.json.JSONObject r0 = r7.getExtension()
        if (r0 == 0) goto L_0x0044
        java.lang.String r1 = "shop"
        org.json.JSONObject r0 = com.qiyukf.basesdk.p412c.C5366b.m22040f(r0, r1)
        if (r0 == 0) goto L_0x0044
        com.qiyukf.unicorn.e.j r1 = new com.qiyukf.unicorn.e.j
        r1.m50345init()
        java.lang.String r0 = r0.toString()
        r1.mo28907a(r0)
        goto L_0x0045
    L_0x0044:
        r1 = 0
    L_0x0045:
        if (r1 == 0) goto L_0x004c
        com.qiyukf.unicorn.e.k r0 = r6.f19312a
        r0.mo28909a(r1)
    L_0x004c:
        com.qiyukf.unicorn.api.msg.PushMessageExtension r0 = new com.qiyukf.unicorn.api.msg.PushMessageExtension
        r0.m50277init()
        org.json.JSONObject r1 = r7.getExtension()
        java.lang.String r2 = "senderInfo"
        org.json.JSONObject r2 = com.qiyukf.basesdk.p412c.C5366b.m22040f(r1, r2)
        if (r2 == 0) goto L_0x0080
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r3 = new com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender
        r3.m50279init()
        java.lang.String r4 = "staffId"
        java.lang.String r4 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r2, r4)
        r3.setId(r4)
        java.lang.String r4 = "staffIcon"
        java.lang.String r4 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r2, r4)
        r3.setAvatar(r4)
        java.lang.String r4 = "staffName"
        java.lang.String r2 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r2, r4)
        r3.setName(r2)
        r0.setSender(r3)
    L_0x0080:
        java.lang.String r2 = "action"
        org.json.JSONObject r1 = com.qiyukf.basesdk.p412c.C5366b.m22040f(r1, r2)
        if (r1 == 0) goto L_0x00a2
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Action r2 = new com.qiyukf.unicorn.api.msg.PushMessageExtension$Action
        r2.m50278init()
        java.lang.String r3 = "label"
        java.lang.String r3 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r1, r3)
        r2.setLabel(r3)
        java.lang.String r3 = "url"
        java.lang.String r1 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r1, r3)
        r2.setUrl(r1)
        r0.setAction(r2)
    L_0x00a2:
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r1 = r0.getSender()
        if (r1 == 0) goto L_0x00f3
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r1 = r0.getSender()
        java.lang.String r1 = r1.getId()
        boolean r1 = android.text.TextUtils.isEmpty(r1)
        if (r1 != 0) goto L_0x00f3
        com.qiyukf.unicorn.e.l r1 = r6.f19314c
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r2 = r0.getSender()
        java.lang.String r2 = r2.getId()
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r3 = r0.getSender()
        java.lang.String r3 = r3.getName()
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r4 = r0.getSender()
        java.lang.String r4 = r4.getAvatar()
        java.lang.String r5 = r7.getUuid()
        r1.mo28911a(r2, r3, r4, r5)
        java.lang.StringBuilder r1 = new java.lang.StringBuilder
        r1.<init>()
        com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender r2 = r0.getSender()
        java.lang.String r2 = r2.getId()
        r1.append(r2)
        java.lang.String r2 = r7.getUuid()
        r1.append(r2)
        java.lang.String r1 = r1.toString()
        goto L_0x00fb
    L_0x00f3:
        java.lang.String r1 = r7.getSessionId()
        java.lang.String r1 = com.qiyukf.unicorn.p502e.C6054l.m24099a(r1)
    L_0x00fb:
        r7.setFromAccount(r1)
        java.util.List<com.qiyukf.unicorn.api.msg.OnPushMessageListener> r1 = r6.f19313b
        java.util.Iterator r1 = r1.iterator()
    L_0x0104:
        boolean r2 = r1.hasNext()
        if (r2 == 0) goto L_0x0114
        java.lang.Object r2 = r1.next()
        com.qiyukf.unicorn.api.msg.OnPushMessageListener r2 = (com.qiyukf.unicorn.api.msg.OnPushMessageListener) r2
        r2.onReceive(r7, r0)
        goto L_0x0104
    L_0x0114:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p514h.C6184b.mo29273a(com.qiyukf.nimlib.sdk.msg.model.IMMessage):void");
    }

    /* renamed from: a */
    public final void mo29274a(OnPushMessageListener onPushMessageListener) {
        if (onPushMessageListener != null && !this.f19313b.contains(onPushMessageListener)) {
            this.f19313b.add(onPushMessageListener);
        }
    }

    /* renamed from: b */
    public final void mo29275b(OnPushMessageListener onPushMessageListener) {
        this.f19313b.remove(onPushMessageListener);
    }
}
