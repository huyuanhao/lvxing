package com.qiyukf.nimlib.p485i;

import android.text.TextUtils;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5285d;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5286e;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5287f;
import com.qiyukf.basesdk.p394b.p395a.p404c.C5317c;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.p472g.C5843b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.i.c */
public final class C5914c {
    /* renamed from: a */
    public static C5285d m23703a(final C5912a aVar, boolean z, final C5817i iVar) {
        final FileAttachment fileAttachment = (FileAttachment) aVar.getAttachment();
        if (TextUtils.isEmpty(fileAttachment.getUrl())) {
            m23711b(iVar, (int) HttpStatus.SC_REQUEST_URI_TOO_LONG);
            return null;
        }
        String pathForSave = fileAttachment.getPathForSave();
        String a = C5317c.m21855a(fileAttachment.getUrl());
        if (z) {
            if (aVar.getMsgType() == MsgTypeEnum.image) {
                pathForSave = fileAttachment.getThumbPathForSave();
                ImageAttachment imageAttachment = (ImageAttachment) fileAttachment;
                a = C5317c.m21856a(a, imageAttachment.getWidth(), imageAttachment.getHeight());
            } else if (aVar.getMsgType() == MsgTypeEnum.video) {
                pathForSave = fileAttachment.getThumbPathForSave();
                a = C5317c.m21857b(a);
            }
        }
        if (new File(pathForSave).exists()) {
            if (aVar.getAttachStatus() == AttachStatusEnum.transferred) {
                m23711b(iVar, (int) HttpStatus.SC_REQUEST_URI_TOO_LONG);
            } else {
                m23712b(aVar, AttachStatusEnum.transferred);
                m23711b(iVar, 200);
            }
            return null;
        }
        m23712b(aVar, AttachStatusEnum.transferring);
        C5285d dVar = new C5285d(a, pathForSave, new C5286e() {
            /* renamed from: d */
            private long f18705d = fileAttachment.getSize();

            /* renamed from: a */
            public final void mo27143a() {
                C5914c.m23712b(aVar, AttachStatusEnum.transferred);
                C5914c.m23711b(iVar, 200);
            }

            /* renamed from: a */
            public final void mo27144a(long j) {
                C5808b.m23322a(aVar.getUuid(), j, this.f18705d);
            }

            /* renamed from: b */
            public final void mo27145b() {
                C5914c.m23712b(aVar, AttachStatusEnum.fail);
                C5914c.m23711b(iVar, 500);
            }

            /* renamed from: b */
            public final void mo27146b(long j) {
                this.f18705d = j;
            }

            /* renamed from: c */
            public final void mo27147c() {
                C5914c.m23712b(aVar, AttachStatusEnum.fail);
            }
        });
        C5287f.m21710a().mo27149a(dVar);
        return dVar;
    }

    /* renamed from: a */
    public static C5912a m23704a(C5892b bVar, boolean z) {
        String a = bVar.mo28239a(11);
        if (bVar.mo28242b(13) == 1 && !TextUtils.isEmpty(a) && C5922f.m23754b(a) != 0) {
            a = null;
        } else if (TextUtils.isEmpty(a)) {
            a = C5406d.m22120b();
        }
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String a2 = bVar.mo28239a(2);
        int b = bVar.mo28242b(0);
        String a3 = m23706a(bVar);
        int b2 = bVar.mo28242b(8);
        C5912a aVar = new C5912a();
        aVar.mo28296a(bVar.mo28239a(11));
        aVar.mo28298b(bVar.mo28243c(12));
        aVar.setFromAccount(a2);
        aVar.mo28299b(a3);
        aVar.setTime(bVar.mo28243c(7));
        aVar.mo28294a(SessionTypeEnum.typeOfValue(b));
        aVar.mo28292a(b2);
        aVar.setContent(bVar.mo28239a(9));
        aVar.mo28301c(bVar.mo28239a(10));
        aVar.setExt(bVar.mo28239a(15));
        aVar.setStatus(MsgStatusEnum.success);
        aVar.setAttachStatus(AttachStatusEnum.def);
        int b3 = bVar.mo28242b(4);
        boolean equals = C5718b.m23015b().equals(aVar.getFromAccount());
        if (C5718b.m23015b().equals(aVar.getFromAccount()) && C5718b.m23015b().equals(aVar.getSessionId())) {
            equals = b3 == 1 || b3 == 2 || b3 == 8;
        }
        aVar.setDirect(equals ? MsgDirectionEnum.Out : MsgDirectionEnum.In);
        if (z) {
            C5922f.m23750a(aVar);
        }
        return aVar;
    }

    /* renamed from: a */
    public static C5925h m23705a(ArrayList<C5912a> arrayList, String str) {
        C5912a aVar = (C5912a) arrayList.get(arrayList.size() - 1);
        boolean equals = C5923g.m23765a(aVar.getSessionId(), aVar.getSessionType().getValue()).equals(C5743d.m23119d());
        m23710a(arrayList);
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C5912a aVar2 = (C5912a) it.next();
            if (!equals && m23713b(aVar2)) {
                i++;
            }
        }
        C5808b.m23323a((List<C5912a>) arrayList);
        if (i > 0) {
            C5912a aVar3 = null;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (m23713b((C5912a) arrayList.get(size))) {
                    aVar3 = (C5912a) arrayList.get(size);
                    break;
                } else {
                    size--;
                }
            }
            if (aVar3 != null) {
                C5843b.m23416a(aVar3, str, i);
            }
        }
        return C5923g.m23760a(aVar, i);
    }

    /* renamed from: a */
    public static String m23706a(C5892b bVar) {
        int b = bVar.mo28242b(0);
        String a = bVar.mo28239a(2);
        String a2 = bVar.mo28239a(1);
        return ((b == 0 || b == 2) && !a.equals(C5718b.m23015b())) ? a : a2;
    }

    /* renamed from: a */
    public static void m23708a(C5912a aVar) {
        C5922f.m23750a(aVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        C5808b.m23321a((RecentContact) m23705a(arrayList, ""));
    }

    /* renamed from: a */
    public static void m23710a(ArrayList<C5912a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C5912a aVar = (C5912a) it.next();
            if (C5718b.m23017d().preloadAttach && aVar.getMsgType() != MsgTypeEnum.custom && aVar.getAttachment() != null && aVar.getAttachment().getClass().getSuperclass().equals(FileAttachment.class)) {
                m23703a(aVar, true, null);
            }
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m23711b(C5817i iVar, int i) {
        if (iVar != null) {
            iVar.mo28111a(i);
            C5805a.m23315c(iVar);
        }
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m23712b(C5912a aVar, AttachStatusEnum attachStatusEnum) {
        aVar.setAttachStatus(attachStatusEnum);
        if (attachStatusEnum == AttachStatusEnum.transferring) {
            C5913b.m23694a().mo28330d(aVar.getUuid());
        } else {
            C5913b.m23694a().mo28331e(aVar.getUuid());
            long a = aVar.mo28290a();
            int value = attachStatusEnum.getValue();
            StringBuilder sb = new StringBuilder("UPDATE msghistory set status2='");
            sb.append(value);
            sb.append("' where messageid='");
            sb.append(a);
            sb.append("'");
            C5742c.m23101a().mo28018d().mo27979a(sb.toString());
        }
        C5808b.m23320a((IMMessage) aVar);
    }

    /* renamed from: b */
    private static boolean m23713b(C5912a aVar) {
        if (aVar.getDirect() == MsgDirectionEnum.Out) {
            return false;
        }
        return aVar.getAttachment() != null ? aVar.getAttachment().countToUnread() : aVar.getMsgType() != MsgTypeEnum.notification;
    }
}
