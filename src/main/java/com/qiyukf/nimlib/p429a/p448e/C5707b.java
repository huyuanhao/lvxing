package com.qiyukf.nimlib.p429a.p448e;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5285d;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5287f;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5290a.C5293c;
import com.qiyukf.basesdk.p394b.p395a.p397b.C5298c;
import com.qiyukf.basesdk.p412c.p416c.C5405c;
import com.qiyukf.nimlib.C5644a;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p437a.C5673c;
import com.qiyukf.nimlib.p429a.p436c.p440d.C5678a;
import com.qiyukf.nimlib.p429a.p436c.p440d.C5679b;
import com.qiyukf.nimlib.p429a.p436c.p440d.C5680c;
import com.qiyukf.nimlib.p429a.p436c.p441e.C5683a;
import com.qiyukf.nimlib.p429a.p442d.C5686a;
import com.qiyukf.nimlib.p429a.p449f.C5713a;
import com.qiyukf.nimlib.p429a.p449f.C5714b;
import com.qiyukf.nimlib.p429a.p449f.C5715c;
import com.qiyukf.nimlib.p451c.C5730a;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p451c.p452a.C5732b;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p469e.C5814f;
import com.qiyukf.nimlib.p469e.C5816h;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.p472g.C5842a;
import com.qiyukf.nimlib.p472g.C5845c;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5892b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5913b;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.p485i.C5916d;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.p485i.C5923g;
import com.qiyukf.nimlib.p485i.C5925h;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.tencent.android.tpush.common.MessageKey;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.e.b */
public class C5707b extends C5816h implements MsgService {
    /* renamed from: a */
    private static InvocationFuture<List<IMMessage>> m22969a(List<C5912a> list) {
        C5817i b = m23333b();
        for (C5912a aVar : list) {
            if (aVar.getStatus() == MsgStatusEnum.fail) {
                if (C5913b.m23694a().mo28329c(aVar.getUuid())) {
                    aVar.setStatus(MsgStatusEnum.sending);
                }
            } else if (C5913b.m23694a().mo28332f(aVar.getUuid())) {
                aVar.setAttachStatus(AttachStatusEnum.transferring);
            }
        }
        b.mo28116b((Object) list);
        C5805a.m23315c(b);
        return null;
    }

    /* renamed from: a */
    private static void m22970a(C5925h hVar) {
        if (hVar.getMsgStatus() == MsgStatusEnum.fail && C5913b.m23694a().mo28329c(hVar.getRecentMessageId())) {
            hVar.setMsgStatus(MsgStatusEnum.sending);
        }
    }

    /* renamed from: a */
    private void m22971a(CustomNotification customNotification, final C5817i iVar, C5713a aVar) {
        if (TextUtils.isEmpty(customNotification.getSessionId()) || customNotification.getSessionType() == null) {
            throw new IllegalArgumentException("illegal receiver");
        }
        String json = customNotification.getAttachment().toJson(true);
        StringBuilder sb = new StringBuilder("send custom notification: sessionId: ");
        sb.append(customNotification.getSessionId());
        sb.append(", content: ");
        sb.append(json);
        C5264a.m21620b("test", sb.toString());
        C5892b bVar = new C5892b();
        bVar.mo28241a(2, customNotification.getSessionId());
        bVar.mo28240a(1, C5923g.m23758a(customNotification.getSessionType()));
        bVar.mo28241a(5, json);
        if (!customNotification.isSendToOnlineUserOnly()) {
            bVar.mo28240a(7, 1);
        }
        if (!TextUtils.isEmpty(customNotification.getApnsText())) {
            bVar.mo28241a(8, customNotification.getApnsText());
        }
        C5678a aVar2 = customNotification.getSessionType() == SessionTypeEnum.Ysf ? new C5683a() : new C5678a();
        aVar2.mo27885a(bVar);
        C5668c.m22861a().mo27866a((C5715c) new C5714b(aVar2, aVar) {
            /* renamed from: a */
            public final void mo27887a(C5686a aVar) {
                iVar.mo28111a((int) aVar.mo27896e());
                C5805a.m23315c(iVar);
            }
        });
    }

    /* renamed from: a */
    private static void m22973a(String str, SessionTypeEnum sessionTypeEnum) {
        StringBuilder sb = new StringBuilder("DELETE FROM lstmsg where uid = '");
        sb.append(C5732b.m23077a(str));
        sb.append("' and sessiontype='");
        sb.append(sessionTypeEnum.getValue());
        sb.append("'");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
        C5679b bVar = new C5679b();
        bVar.mo27886a(str, sessionTypeEnum);
        C5668c.m22861a().mo27865a((C5669a) bVar, C5713a.f18255b);
    }

    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m22974b(String str, long j, int i, C5817i iVar) {
        C5673c cVar = new C5673c();
        C5892b bVar = new C5892b();
        bVar.mo28241a(0, "AAC");
        bVar.mo28241a(1, String.valueOf(i));
        bVar.mo28241a(2, str);
        bVar.f18650a.put(3, String.valueOf(j));
        cVar.mo27879a(bVar);
        cVar.mo27871a(iVar);
        C5668c.m22861a().mo27864a((C5669a) cVar);
    }

    /* renamed from: b */
    private static void m22975b(List<RecentContact> list) {
        for (RecentContact recentContact : list) {
            m22970a((C5925h) recentContact);
        }
    }

    public void clearChattingHistory(String str, SessionTypeEnum sessionTypeEnum) {
        int value = sessionTypeEnum.getValue();
        StringBuilder sb = new StringBuilder("DELETE FROM msghistory where (id='");
        sb.append(C5732b.m23077a(str));
        sb.append("' and sessiontype='");
        sb.append(value);
        sb.append("')");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
        if (C5922f.m23743a(str, sessionTypeEnum) != null) {
            C5808b.m23321a((RecentContact) C5923g.m23762a(str, sessionTypeEnum));
        }
    }

    public void clearMsgDatabase(boolean z) {
        if (z) {
            List<RecentContact> a = C5922f.m23748a();
            if (a.size() != 0) {
                C5679b bVar = new C5679b();
                for (RecentContact recentContact : a) {
                    bVar.mo27886a(recentContact.getContactId(), recentContact.getSessionType());
                }
                C5668c.m22861a().mo27865a((C5669a) bVar, C5713a.f18255b);
            }
        }
        C5742c.m23101a().mo28018d().mo27979a("DELETE FROM msghistory");
        if (z) {
            C5742c.m23101a().mo28018d().mo27979a("DELETE FROM lstmsg");
        }
        if (z) {
            C5808b.m23324b((RecentContact) null);
        }
    }

    public void clearUnreadCount(String str, SessionTypeEnum sessionTypeEnum) {
        if (!TextUtils.isEmpty(str)) {
            C5925h a = C5922f.m23743a(str, sessionTypeEnum);
            if (a != null && a.getUnreadCount() > 0) {
                int value = sessionTypeEnum.getValue();
                StringBuilder sb = new StringBuilder("update lstmsg set unreadnum = 0 where uid='");
                sb.append(C5732b.m23077a(str));
                sb.append("' and sessiontype='");
                sb.append(value);
                sb.append("'");
                C5742c.m23101a().mo28018d().mo27979a(sb.toString());
                a.mo28337a(0);
                m22970a(a);
                C5808b.m23321a((RecentContact) a);
            }
            C5842a.m23411a(C5845c.MESSAGE);
        }
    }

    public void deleteChattingHistory(IMMessage iMMessage) {
        C5925h hVar;
        C5912a aVar = (C5912a) iMMessage;
        StringBuilder sb = new StringBuilder("DELETE FROM msghistory where uuid = '");
        sb.append(aVar.getUuid());
        sb.append("'");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
        String sessionId = iMMessage.getSessionId();
        SessionTypeEnum sessionType = iMMessage.getSessionType();
        C5925h a = C5922f.m23743a(sessionId, sessionType);
        if (a != null && TextUtils.equals(a.getRecentMessageId(), iMMessage.getUuid())) {
            C5912a a2 = C5922f.m23741a(sessionId, sessionType.getValue());
            if (a2 == null) {
                hVar = C5923g.m23762a(sessionId, sessionType);
            } else {
                hVar = C5923g.m23759a(a2);
                m22970a(hVar);
            }
            C5808b.m23321a((RecentContact) hVar);
        }
    }

    public void deleteRecentContact(RecentContact recentContact) {
        m22973a(recentContact.getContactId(), recentContact.getSessionType());
    }

    public void deleteRecentContact2(String str, SessionTypeEnum sessionTypeEnum) {
        m22973a(str, sessionTypeEnum);
        C5925h hVar = new C5925h();
        hVar.mo28342a(str);
        hVar.mo28339a(sessionTypeEnum);
        C5808b.m23324b((RecentContact) hVar);
    }

    public AbortableFuture downloadAttachment(IMMessage iMMessage, boolean z) {
        C5285d a = C5914c.m23703a((C5912a) iMMessage, z, m23333b());
        if (a == null) {
            return null;
        }
        return new C5814f<C5285d>(a) {
            public final boolean abort() {
                C5287f.m21710a().mo27152b((C5285d) this.f18477c);
                return false;
            }
        };
    }

    public void migrateMessages(String str, String str2, boolean z) {
        if (!TextUtils.equals(str, str2)) {
            Context a = C5718b.m23009a();
            StringBuilder sb = new StringBuilder();
            sb.append(C5718b.m23020g());
            String str3 = "/";
            sb.append(str3);
            sb.append(str2);
            C5730a aVar = new C5730a(a, sb.toString());
            StringBuilder sb2 = new StringBuilder("ATTACH DATABASE '");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(C5644a.f18159a);
            sb3.append(str3);
            sb3.append(str);
            sb3.append("/msg.db");
            sb2.append(sb3.toString());
            sb2.append("' AS src");
            aVar.mo27979a(sb2.toString());
            aVar.mo27979a("INSERT INTO msghistory(uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach) SELECT uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach FROM src.msghistory");
            aVar.mo27979a("INSERT OR IGNORE INTO lstmsg(uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach) SELECT uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach FROM src.lstmsg");
            aVar.mo27979a("DETACH DATABASE src");
            if (z) {
                StringBuilder sb4 = new StringBuilder("UPDATE msghistory SET fromid='");
                sb4.append(C5732b.m23077a(str2));
                sb4.append("' WHERE fromid='");
                sb4.append(C5732b.m23077a(str));
                String str4 = "'";
                sb4.append(str4);
                aVar.mo27979a(sb4.toString());
                StringBuilder sb5 = new StringBuilder("UPDATE lstmsg SET fromuid='");
                sb5.append(C5732b.m23077a(str2));
                sb5.append("' WHERE fromuid='");
                sb5.append(C5732b.m23077a(str));
                sb5.append(str4);
                aVar.mo27979a(sb5.toString());
            }
            aVar.mo27983c();
            C5808b.m23325b(((MsgService) NIMClient.getService(MsgService.class)).queryRecentContactsBlock());
        }
    }

    public InvocationFuture<List<IMMessage>> pullMessageHistory(IMMessage iMMessage, int i, boolean z) {
        return pullMessageHistoryEx(iMMessage, 0, i, QueryDirectionEnum.QUERY_OLD, z);
    }

    public InvocationFuture<List<IMMessage>> pullMessageHistoryEx(IMMessage iMMessage, long j, int i, QueryDirectionEnum queryDirectionEnum, boolean z) {
        IMMessage iMMessage2 = iMMessage;
        if (iMMessage2 != null && (iMMessage2 instanceof C5912a)) {
            C5912a aVar = (C5912a) iMMessage2;
            boolean z2 = queryDirectionEnum != QueryDirectionEnum.QUERY_OLD;
            C5680c cVar = new C5680c(aVar.getSessionId(), aVar.getSessionType(), z2 ? iMMessage.getTime() : j, z2 ? j : iMMessage.getTime(), aVar.mo28300c(), i, z2, z);
            cVar.mo27871a(m23333b());
            C5668c.m22861a().mo27864a((C5669a) cVar);
        }
        return null;
    }

    public IMMessage queryLastMessage(String str, SessionTypeEnum sessionTypeEnum) {
        return C5922f.m23741a(str, sessionTypeEnum.getValue());
    }

    public InvocationFuture queryMessageList(String str, SessionTypeEnum sessionTypeEnum, long j, int i) {
        return m22969a((List<C5912a>) C5922f.m23747a(str, sessionTypeEnum.getValue(), j, i));
    }

    public InvocationFuture<List<IMMessage>> queryMessageListEx(IMMessage iMMessage, QueryDirectionEnum queryDirectionEnum, int i, boolean z) {
        return m22969a((List<C5912a>) C5922f.m23746a((C5912a) iMMessage, queryDirectionEnum, i, z));
    }

    public InvocationFuture queryRecentContacts() {
        C5817i b = m23333b();
        List a = C5922f.m23748a();
        m22975b(a);
        b.mo28116b((Object) a);
        C5805a.m23315c(b);
        return null;
    }

    public List<RecentContact> queryRecentContactsBlock() {
        List<RecentContact> a = C5922f.m23748a();
        m22975b(a);
        return a;
    }

    public void registerCustomAttachmentParser(MsgTypeEnum msgTypeEnum, MsgAttachmentParser msgAttachmentParser) {
        C5913b.m23694a().mo28328c().mo28334a(msgTypeEnum.getValue(), msgAttachmentParser);
    }

    public InvocationFuture<Void> saveMessageToLocal(IMMessage iMMessage, boolean z) {
        C5912a aVar = (C5912a) iMMessage;
        C5922f.m23750a(aVar);
        C5808b.m23321a((RecentContact) C5923g.m23759a(aVar));
        m23333b().mo28111a(200);
        C5805a.m23315c(m23333b());
        if (z) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(aVar);
            C5808b.m23323a((List<C5912a>) arrayList);
        }
        return null;
    }

    public InvocationFuture<List<IMMessage>> searchMessageHistory(String str, List<String> list, IMMessage iMMessage, int i) {
        return m22969a(C5922f.m23749a(str, list, iMMessage, i));
    }

    public InvocationFuture<Void> sendCustomNotification(CustomNotification customNotification) {
        m22971a(customNotification, m23333b(), C5713a.f18254a);
        return null;
    }

    public AbortableFuture<FileAttachment> sendFile(FileAttachment fileAttachment) {
        final C5293c a = C5916d.m23719a(fileAttachment, m23333b());
        return new C5814f<FileAttachment>() {
            public final boolean abort() {
                C5290a.m21719a().mo27155a((Runnable) a);
                return false;
            }
        };
    }

    public InvocationFuture<Void> sendImportantNotification(CustomNotification customNotification) {
        m22971a(customNotification, m23333b(), new C5713a(5, 30));
        return null;
    }

    public InvocationFuture<Void> sendMessage(IMMessage iMMessage, boolean z, boolean z2) {
        C5916d.m23721a((C5912a) iMMessage, z, m23333b(), z2);
        return null;
    }

    public void setChattingAccount(String str, SessionTypeEnum sessionTypeEnum) {
        if (MsgService.MSG_CHATTING_ACCOUNT_ALL.equals(str)) {
            C5743d.m23109a(str);
            C5845c[] cVarArr = C5845c.f18542c;
            if (cVarArr != null) {
                for (C5845c a : cVarArr) {
                    C5842a.m23411a(a);
                }
            }
            return;
        }
        if (str == null) {
            str = "";
        }
        C5743d.m23109a(C5923g.m23765a(str, sessionTypeEnum.getValue()));
        clearUnreadCount(str, sessionTypeEnum);
    }

    public AbortableFuture<String> transVoiceToText(String str, String str2, final long j) {
        if (str2 == null || !new File(str2).exists()) {
            throw new IllegalArgumentException("Invalid audio path.");
        }
        final C5817i b = m23333b();
        if (TextUtils.isEmpty(str)) {
            C5290a.m21719a().mo27154a(str2, C5405c.m22115b(str2), b, new C5298c() {
                /* renamed from: b */
                final /* synthetic */ int f18249b = 16000;

                /* renamed from: a */
                public final void mo27169a() {
                    mo27170a(400);
                }

                /* renamed from: a */
                public final void mo27170a(int i) {
                    b.mo28111a(i);
                    b.mo28112a((Object) null);
                    C5805a.m23315c(b);
                }

                /* renamed from: a */
                public final void mo27171a(long j, long j2) {
                }

                /* renamed from: a */
                public final void mo27172a(String str) {
                    C5707b.m22974b(str, j, this.f18249b, b);
                }
            });
        } else {
            m22974b(str, j, 16000, b);
        }
        return null;
    }

    public void updateIMMessageStatus(IMMessage iMMessage, boolean z) {
        C5912a aVar = (C5912a) iMMessage;
        ContentValues contentValues = new ContentValues(3);
        if (aVar.getStatus() != null) {
            contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(aVar.getStatus().getValue()));
        }
        if (aVar.getAttachStatus() != null) {
            contentValues.put("status2", Integer.valueOf(aVar.getAttachStatus().getValue()));
        }
        String str = "attach";
        if (aVar.getAttachment() != null) {
            contentValues.put(str, aVar.getAttachment().toJson(false));
        }
        if (contentValues.size() > 0) {
            C5742c.m23101a().mo28018d().mo27977a("msghistory", contentValues, "uuid=?", new String[]{aVar.getUuid()});
        }
        if (z) {
            C5808b.m23320a(iMMessage);
        }
        if (iMMessage.getAttachment() != null) {
            C5925h a = C5922f.m23743a(iMMessage.getSessionId(), iMMessage.getSessionType());
            if (a != null && a.getRecentMessageId().equals(iMMessage.getUuid())) {
                a.mo28341a(iMMessage.getAttachment());
                if (a.getMsgType() == MsgTypeEnum.custom || a.getMsgType() == MsgTypeEnum.appCustom) {
                    a.mo28347d(a.getAttachment().getContent(C5718b.m23009a()));
                }
                ContentValues contentValues2 = new ContentValues(2);
                contentValues2.put(MessageKey.MSG_CONTENT, a.getContent());
                contentValues2.put(str, a.getAttachment().toJson(false));
                C5742c.m23101a().mo28018d().mo27977a("lstmsg", contentValues2, "messageId=?", new String[]{a.getRecentMessageId()});
                C5808b.m23321a((RecentContact) a);
            }
        }
    }

    public void updateMessage(IMMessage iMMessage, boolean z) {
        C5922f.m23755b((C5912a) iMMessage);
        if (z) {
            C5808b.m23320a(iMMessage);
        }
    }

    public InvocationFuture<Void> updateRecent(RecentContact recentContact) {
        StringBuilder sb = new StringBuilder("UPDATE lstmsg set tag='");
        sb.append(recentContact.getTag());
        sb.append("' where messageId='");
        sb.append(recentContact.getRecentMessageId());
        sb.append("'");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
        return null;
    }
}
