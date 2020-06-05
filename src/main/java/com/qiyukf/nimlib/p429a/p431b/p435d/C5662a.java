package com.qiyukf.nimlib.p429a.p431b.p435d;

import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.C5685d;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p438b.C5675a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p444b.C5693a;
import com.qiyukf.nimlib.p429a.p442d.p446d.C5699a;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.b.d.a */
public final class C5662a extends C5667g {
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0121, code lost:
            if (r15 == false) goto L_0x01b2;
     */
    /* renamed from: a */
    private static int m22851a(com.qiyukf.nimlib.p473h.p481c.p483b.C5892b r14, boolean r15) {
        /*
        r0 = 1
        int r1 = r14.mo28242b(r0)
        r2 = 2
        r3 = 8
        r4 = 102(0x66, float:1.43E-43)
        r5 = 101(0x65, float:1.42E-43)
        r6 = 5
        r7 = 100
        r8 = 3
        r9 = 0
        if (r1 == r7) goto L_0x00df
        if (r1 == r5) goto L_0x00df
        if (r1 != r4) goto L_0x0019
        goto L_0x00df
    L_0x0019:
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType r15 = com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType.typeOfValue(r1)
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType r1 = com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType.undefined
        if (r15 == r1) goto L_0x01b2
        com.qiyukf.nimlib.sdk.msg.model.SystemMessage r1 = new com.qiyukf.nimlib.sdk.msg.model.SystemMessage
        r1.m50168init()
        java.lang.String r4 = r14.mo28239a(r8)
        r1.setFromAccount(r4)
        java.lang.String r2 = r14.mo28239a(r2)
        r1.setTargetId(r2)
        int r2 = r14.mo28242b(r0)
        r1.setType(r2)
        long r4 = r14.mo28243c(r9)
        r1.setTime(r4)
        r2 = 4
        java.lang.String r2 = r14.mo28239a(r2)
        r1.setContent(r2)
        java.lang.String r14 = r14.mo28239a(r6)
        r1.setAttach(r14)
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus r14 = com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus.init
        r1.setStatus(r14)
        android.content.ContentValues r14 = new android.content.ContentValues
        r14.<init>(r3)
        java.lang.String r2 = r1.getTargetId()
        java.lang.String r3 = "id"
        r14.put(r3, r2)
        java.lang.String r2 = r1.getFromAccount()
        java.lang.String r3 = "fromid"
        r14.put(r3, r2)
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType r2 = r1.getType()
        int r2 = r2.getValue()
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r3 = "type"
        r14.put(r3, r2)
        long r2 = r1.getTime()
        java.lang.Long r2 = java.lang.Long.valueOf(r2)
        java.lang.String r3 = "time"
        r14.put(r3, r2)
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus r2 = r1.getStatus()
        int r2 = r2.getValue()
        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        java.lang.String r3 = "status"
        r14.put(r3, r2)
        java.lang.String r2 = r1.getContent()
        java.lang.String r3 = "content"
        r14.put(r3, r2)
        java.lang.String r2 = r1.getAttach()
        java.lang.String r3 = "attach"
        r14.put(r3, r2)
        com.qiyukf.nimlib.c.c r2 = com.qiyukf.nimlib.p451c.C5742c.m23101a()
        com.qiyukf.nimlib.c.a r2 = r2.mo28018d()
        java.lang.String r3 = "system_msg"
        long r2 = r2.mo27978a(r3, r14)
        r1.setMessageId(r2)
        java.lang.StringBuilder r14 = new java.lang.StringBuilder
        r14.<init>()
        java.lang.Class<com.qiyukf.nimlib.sdk.msg.SystemMessageObserver> r2 = com.qiyukf.nimlib.sdk.msg.SystemMessageObserver.class
        java.lang.String r2 = r2.getSimpleName()
        r14.append(r2)
        java.lang.String r2 = "/observeReceiveSystemMsg"
        r14.append(r2)
        java.lang.String r14 = r14.toString()
        com.qiyukf.nimlib.p469e.C5805a.m23312a(r14, r1)
        com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType r14 = com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType.DeleteFriend
        if (r15 != r14) goto L_0x00de
        return r9
    L_0x00de:
        return r0
    L_0x00df:
        com.qiyukf.nimlib.sdk.msg.model.CustomNotification r1 = new com.qiyukf.nimlib.sdk.msg.model.CustomNotification
        r1.m50165init()
        java.lang.String r10 = r14.mo28239a(r8)
        java.lang.String r6 = r14.mo28239a(r6)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        java.lang.String r12 = "receive custom notification: sessionId: "
        r11.<init>(r12)
        r11.append(r10)
        java.lang.String r10 = ", content: "
        r11.append(r10)
        r11.append(r6)
        java.lang.String r10 = r11.toString()
        java.lang.String r11 = "test"
        com.qiyukf.basesdk.p393a.C5264a.m21620b(r11, r10)
        r1.setAttachStr(r6)
        com.qiyukf.unicorn.f.a.e r6 = r1.getAttachment()
        if (r6 == 0) goto L_0x01b2
        if (r15 == 0) goto L_0x0125
        com.qiyukf.unicorn.f.a.e r15 = r1.getAttachment()
        if (r15 == 0) goto L_0x0120
        boolean r15 = r15.supportOffline()
        if (r15 == 0) goto L_0x0120
        r15 = 1
        goto L_0x0121
    L_0x0120:
        r15 = 0
    L_0x0121:
        if (r15 != 0) goto L_0x0125
        goto L_0x01b2
    L_0x0125:
        long r10 = r14.mo28243c(r9)
        r1.setTime(r10)
        java.lang.String r15 = r14.mo28239a(r8)
        r1.setFromAccount(r15)
        java.lang.String r15 = r14.mo28239a(r3)
        r1.setApnsText(r15)
        r15 = 6
        long r10 = r14.mo28243c(r15)
        r12 = 0
        int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
        if (r15 <= 0) goto L_0x0148
        r1.setSendToOnlineUserOnly(r9)
    L_0x0148:
        int r15 = r14.mo28242b(r0)
        if (r15 != r7) goto L_0x015b
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r15 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.P2P
    L_0x0150:
        r1.setSessionType(r15)
        java.lang.String r14 = r14.mo28239a(r8)
    L_0x0157:
        r1.setSessionId(r14)
        goto L_0x016c
    L_0x015b:
        if (r15 != r5) goto L_0x0167
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r15 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Team
        r1.setSessionType(r15)
        java.lang.String r14 = r14.mo28239a(r2)
        goto L_0x0157
    L_0x0167:
        if (r15 != r4) goto L_0x016c
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r15 = com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum.Ysf
        goto L_0x0150
    L_0x016c:
        android.content.Intent r14 = new android.content.Intent
        java.lang.StringBuilder r15 = new java.lang.StringBuilder
        r15.<init>()
        android.content.Context r0 = com.qiyukf.nimlib.C5718b.m23009a()
        java.lang.String r0 = r0.getPackageName()
        r15.append(r0)
        java.lang.String r0 = ".ACTION.RECEIVE_CUSTOM_NOTIFICATION.UNICORN"
        r15.append(r0)
        java.lang.String r15 = r15.toString()
        r14.<init>(r15)
        java.lang.String r15 = "com.netease.nim.EXTRA.BROADCAST_MSG.UNICORN"
        r14.putExtra(r15, r1)
        android.content.Context r15 = com.qiyukf.nimlib.C5718b.m23009a()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        android.content.Context r2 = com.qiyukf.nimlib.C5718b.m23009a()
        java.lang.String r2 = r2.getPackageName()
        r0.append(r2)
        java.lang.String r2 = ".permission.RECEIVE_MSG.UNICORN"
        r0.append(r2)
        java.lang.String r0 = r0.toString()
        r15.sendBroadcast(r14, r0)
        com.qiyukf.nimlib.p469e.C5808b.m23319a(r1)
    L_0x01b2:
        return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p429a.p431b.p435d.C5662a.m22851a(com.qiyukf.nimlib.h.c.b.b, boolean):int");
    }

    /* renamed from: a */
    private static void m22852a(byte b, List<Long> list) {
        C5675a aVar = new C5675a();
        aVar.mo27880a(b);
        aVar.mo27882b(3);
        aVar.mo27881a(list);
        C5668c.m22861a().mo27865a((C5669a) aVar, C5713a.f18257d);
    }

    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        if (aVar.mo27893b()) {
            int i = 0;
            if (aVar instanceof C5699a) {
                i = 0 + m22851a(((C5699a) aVar).mo27908f(), false);
            } else if (aVar instanceof C5693a) {
                List<C5892b> f = ((C5693a) aVar).mo27901f();
                ArrayList arrayList = new ArrayList();
                for (C5892b bVar : f) {
                    i += m22851a(bVar, true);
                    long c = bVar.mo28243c(6);
                    if (c > 0) {
                        arrayList.add(Long.valueOf(c));
                    }
                }
                m22852a(aVar.mo27891a().mo28233h() == 6 ? (byte) 7 : 101, (List<Long>) arrayList);
            }
            if (i > 0) {
                int a = i + C5685d.m22935a();
                C5685d.m22936a(a);
                C5808b.m23318a(a);
            }
        }
    }
}
