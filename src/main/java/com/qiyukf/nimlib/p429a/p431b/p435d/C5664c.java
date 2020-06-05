package com.qiyukf.nimlib.p429a.p431b.p435d;

import android.text.TextUtils;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p431b.C5667g;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p442d.p446d.C5701c;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5913b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.p516j.C6220g;
import java.util.Locale;

/* renamed from: com.qiyukf.nimlib.a.b.d.c */
public final class C5664c extends C5667g {
    /* renamed from: a */
    public final void mo27842a(C5686a aVar) {
        long j;
        StringBuilder sb;
        C5892b f = ((C5701c) aVar).mo27909f();
        if (aVar.mo27893b()) {
            j = f.mo28243c(7);
            f.mo28243c(12);
        } else {
            j = 0;
        }
        C5912a aVar2 = null;
        C5669a a = C5668c.m22861a().mo27856a(aVar);
        if (!(a == null || a.mo27875e() == null || !(a.mo27875e() instanceof C5817i))) {
            C5817i iVar = (C5817i) a.mo27875e();
            C5912a aVar3 = (C5912a) iVar.mo28118b()[0];
            iVar.mo28111a((int) aVar.mo27896e());
            C5805a.m23315c(iVar);
            aVar2 = aVar3;
        }
        MsgStatusEnum msgStatusEnum = aVar.mo27893b() ? MsgStatusEnum.success : MsgStatusEnum.fail;
        if (!(aVar2 == null || C6029d.m24047g().mo29311m(aVar2.getSessionId()) == null)) {
            if ("1".equals(C6029d.m24047g().mo29311m(aVar2.getSessionId()).mo28880a()) && aVar2.getSessionId() != null && C6029d.m24047g().mo29301f(aVar2.getSessionId()) == 0 && ((aVar2.getMsgType() == MsgTypeEnum.text || aVar2.getMsgType() == MsgTypeEnum.image || aVar2.getMsgType() == MsgTypeEnum.file || aVar2.getMsgType() == MsgTypeEnum.video || aVar2.getMsgType() == MsgTypeEnum.custom) && TextUtils.isEmpty(C6220g.m24654a(aVar2)))) {
                msgStatusEnum = aVar.mo27893b() ? MsgStatusEnum.unread : MsgStatusEnum.fail;
            }
        }
        int value = msgStatusEnum.getValue();
        if (aVar2 != null) {
            if (msgStatusEnum != MsgStatusEnum.fail) {
                long a2 = aVar2.mo28290a();
                String str = "'";
                String str2 = "' where messageid='";
                String str3 = "UPDATE msghistory set status='";
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i > 0) {
                    sb = new StringBuilder(str3);
                    sb.append(value);
                    String str4 = "', time='";
                    sb.append(str4);
                    sb.append(j);
                    sb.append(str4);
                    sb.append(j);
                } else {
                    sb = new StringBuilder(str3);
                    sb.append(value);
                }
                sb.append(str2);
                sb.append(a2);
                sb.append(str);
                C5742c.m23101a().mo28018d().mo27979a(sb.toString());
                String uuid = aVar2.getUuid();
                C5742c.m23101a().mo28018d().mo27979a(i <= 0 ? String.format(Locale.getDefault(), "UPDATE lstmsg set msgstatus='%d' where messageId='%s'", new Object[]{Integer.valueOf(value), uuid}) : String.format(Locale.getDefault(), "UPDATE lstmsg set msgstatus='%d',time='%d' where messageId='%s'", new Object[]{Integer.valueOf(value), Long.valueOf(j), uuid}));
            }
            aVar2.setStatus(msgStatusEnum);
            C5808b.m23320a((IMMessage) aVar2);
            C5913b.m23694a().mo28327b(aVar2.getUuid());
        }
    }
}
