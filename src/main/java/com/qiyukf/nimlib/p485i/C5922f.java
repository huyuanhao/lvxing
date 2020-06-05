package com.qiyukf.nimlib.p485i;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.qiyukf.nimlib.p451c.C5730a;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p451c.p452a.C5732b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.tencent.android.tpush.common.MessageKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.i.f */
public final class C5922f {
    /* renamed from: a */
    public static C5912a m23740a(String str) {
        StringBuilder sb = new StringBuilder("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where uuid='");
        sb.append(str);
        sb.append("'");
        ArrayList a = m23744a(C5742c.m23101a().mo28018d(), sb.toString());
        if (a.size() == 1) {
            return (C5912a) a.get(0);
        }
        return null;
    }

    /* renamed from: a */
    public static C5912a m23741a(String str, int i) {
        ArrayList a = m23747a(str, i, 0, 1);
        if (!a.isEmpty()) {
            return (C5912a) a.get(0);
        }
        return null;
    }

    /* renamed from: a */
    private static C5925h m23742a(Cursor cursor) {
        C5925h hVar = new C5925h();
        try {
            hVar.mo28342a(cursor.getString(0));
            hVar.mo28345b(cursor.getString(1));
            hVar.mo28346c(cursor.getString(2));
            hVar.setMsgStatus(MsgStatusEnum.statusOfValue(cursor.getInt(3)));
            hVar.mo28337a(cursor.getInt(4));
            hVar.mo28347d(cursor.getString(5));
            hVar.mo28338a(cursor.getLong(6));
            hVar.mo28339a(SessionTypeEnum.typeOfValue(cursor.getInt(7)));
            hVar.setTag(cursor.getLong(8));
            hVar.mo28344b(cursor.getInt(9));
            hVar.mo28348e(cursor.getString(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hVar;
    }

    /* renamed from: a */
    public static C5925h m23743a(String str, SessionTypeEnum sessionTypeEnum) {
        Cursor b = C5742c.m23101a().mo28018d().mo27981b(String.format("select uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach from lstmsg where uid='%s' and sessiontype='%d'", new Object[]{C5732b.m23077a(str), Integer.valueOf(sessionTypeEnum.getValue())}));
        C5925h a = (b == null || !b.moveToNext()) ? null : m23742a(b);
        if (b != null && !b.isClosed()) {
            b.close();
        }
        return a;
    }

    /* renamed from: a */
    private static ArrayList<C5912a> m23744a(C5730a aVar, String str) {
        Cursor b = aVar.mo27981b(str);
        if (b == null) {
            return new ArrayList<>();
        }
        ArrayList<C5912a> arrayList = new ArrayList<>(b.getCount());
        while (b.moveToNext()) {
            C5912a aVar2 = new C5912a();
            aVar2.mo28293a(b.getLong(0));
            aVar2.mo28296a(b.getString(1));
            aVar2.mo28298b(b.getLong(2));
            aVar2.setTime(b.getLong(3));
            aVar2.setContent(b.getString(4));
            aVar2.mo28292a(b.getInt(5));
            aVar2.mo28294a(SessionTypeEnum.typeOfValue(b.getInt(6)));
            aVar2.setFromAccount(b.getString(7));
            aVar2.mo28299b(b.getString(8));
            aVar2.setDirect(MsgDirectionEnum.directionOfValue(b.getInt(9)));
            aVar2.setStatus(MsgStatusEnum.statusOfValue(b.getInt(10)));
            aVar2.setAttachStatus(AttachStatusEnum.statusOfValue(b.getInt(11)));
            aVar2.mo28301c(b.getString(12));
            aVar2.setExt(b.getString(13));
            arrayList.add(aVar2);
        }
        if (!b.isClosed()) {
            b.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<C5912a> m23745a(C5912a aVar, long j, long j2) {
        String sessionId = aVar.getSessionId();
        int value = aVar.getSessionType().getValue();
        boolean z = aVar.mo28290a() > 0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        sb.append(C5732b.m23077a(sessionId));
        sb.append("' and sessiontype='");
        sb.append(value);
        sb.append("'");
        sb.append(" and time>=");
        sb.append(j);
        sb.append(" and time<=");
        sb.append(j2);
        sb.append(" ORDER BY time ASC");
        ArrayList<C5912a> a = m23744a(C5742c.m23101a().mo28018d(), sb.toString());
        if (!z) {
            return a;
        }
        Iterator it = a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (((C5912a) it.next()).mo28290a() == aVar.mo28290a()) {
                break;
            }
        }
        for (int i2 = 0; i2 <= i - 1; i2++) {
            a.remove(i2);
        }
        if (i <= 1) {
            return a;
        }
        sb.delete(sb.lastIndexOf(" "), sb.length());
        sb.append(" offset ");
        sb.append(i);
        return m23744a(C5742c.m23101a().mo28018d(), sb.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00de  */
    /* renamed from: a */
    public static java.util.ArrayList<com.qiyukf.nimlib.p485i.C5912a> m23746a(com.qiyukf.nimlib.p485i.C5912a r11, com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum r12, int r13, boolean r14) {
        /*
        java.lang.String r0 = r11.getSessionId()
        com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum r1 = r11.getSessionType()
        int r1 = r1.getValue()
        long r2 = r11.mo28290a()
        r4 = 0
        r6 = 0
        r7 = 1
        int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r8 <= 0) goto L_0x001a
        r2 = 1
        goto L_0x001b
    L_0x001a:
        r2 = 0
    L_0x001b:
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r8 = "SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='"
        r3.append(r8)
        java.lang.String r0 = com.qiyukf.nimlib.p451c.p452a.C5732b.m23077a(r0)
        r3.append(r0)
        java.lang.String r0 = "' and sessiontype='"
        r3.append(r0)
        r3.append(r1)
        java.lang.String r0 = "'"
        r3.append(r0)
        com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum r0 = com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum.QUERY_NEW
        if (r12 != r0) goto L_0x003f
        r12 = 1
        goto L_0x0040
    L_0x003f:
        r12 = 0
    L_0x0040:
        if (r12 == 0) goto L_0x004f
        java.lang.String r0 = " and time>="
    L_0x0044:
        r3.append(r0)
        long r0 = r11.getTime()
        r3.append(r0)
        goto L_0x005a
    L_0x004f:
        long r0 = r11.getTime()
        int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
        if (r8 <= 0) goto L_0x005a
        java.lang.String r0 = " and time<="
        goto L_0x0044
    L_0x005a:
        java.lang.String r0 = " ORDER BY time "
        r3.append(r0)
        if (r12 == 0) goto L_0x0064
        java.lang.String r0 = "ASC"
        goto L_0x0066
    L_0x0064:
        java.lang.String r0 = "DESC"
    L_0x0066:
        r3.append(r0)
        java.lang.String r0 = " limit "
        r3.append(r0)
        if (r2 == 0) goto L_0x0073
        int r0 = r13 + 1
        goto L_0x0074
    L_0x0073:
        r0 = r13
    L_0x0074:
        r3.append(r0)
        com.qiyukf.nimlib.c.c r0 = com.qiyukf.nimlib.p451c.C5742c.m23101a()
        com.qiyukf.nimlib.c.a r0 = r0.mo28018d()
        java.lang.String r1 = r3.toString()
        java.util.ArrayList r0 = m23744a(r0, r1)
        if (r2 == 0) goto L_0x00dc
        java.util.Iterator r1 = r0.iterator()
        r2 = 0
    L_0x008e:
        boolean r4 = r1.hasNext()
        if (r4 == 0) goto L_0x00a8
        java.lang.Object r4 = r1.next()
        com.qiyukf.nimlib.i.a r4 = (com.qiyukf.nimlib.p485i.C5912a) r4
        int r2 = r2 + 1
        long r4 = r4.mo28290a()
        long r8 = r11.mo28290a()
        int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
        if (r10 != 0) goto L_0x008e
    L_0x00a8:
        int r11 = r2 + -1
        if (r6 > r11) goto L_0x00b2
        r0.remove(r6)
        int r6 = r6 + 1
        goto L_0x00a8
    L_0x00b2:
        if (r2 <= r7) goto L_0x00dc
        java.lang.String r11 = " "
        int r11 = r3.lastIndexOf(r11)
        int r0 = r3.length()
        r3.delete(r11, r0)
        r3.append(r13)
        java.lang.String r11 = " offset "
        r3.append(r11)
        r3.append(r2)
        com.qiyukf.nimlib.c.c r11 = com.qiyukf.nimlib.p451c.C5742c.m23101a()
        com.qiyukf.nimlib.c.a r11 = r11.mo28018d()
        java.lang.String r13 = r3.toString()
        java.util.ArrayList r0 = m23744a(r11, r13)
    L_0x00dc:
        if (r12 == r14) goto L_0x00e1
        java.util.Collections.reverse(r0)
    L_0x00e1:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.p485i.C5922f.m23746a(com.qiyukf.nimlib.i.a, com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum, int, boolean):java.util.ArrayList");
    }

    /* renamed from: a */
    public static ArrayList<C5912a> m23747a(String str, int i, long j, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        sb.append(C5732b.m23077a(str));
        sb.append("' and sessiontype='");
        sb.append(i);
        sb.append("'");
        sb.append(" ORDER BY time desc limit ");
        sb.append(i2);
        sb.append(" offset ");
        sb.append(j);
        return m23744a(C5742c.m23101a().mo28018d(), sb.toString());
    }

    /* renamed from: a */
    public static List<RecentContact> m23748a() {
        Cursor b = C5742c.m23101a().mo28018d().mo27981b("select uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach from lstmsg order by time desc limit 100");
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            while (b.moveToNext()) {
                arrayList.add(m23742a(b));
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static List<C5912a> m23749a(String str, List<String> list, IMMessage iMMessage, int i) {
        String str2;
        String sessionId = iMMessage.getSessionId();
        int value = iMMessage.getSessionType().getValue();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT messageid,uuid,serverid,time,content,msgtype,sessiontype,fromid,id,direct,status,status2,attach,ext FROM msghistory where id='");
        sb.append(C5732b.m23077a(sessionId));
        sb.append("' and sessiontype='");
        sb.append(value);
        String str3 = "'";
        sb.append(str3);
        if (iMMessage.getTime() > 0) {
            sb.append(" and time<'");
            sb.append(iMMessage.getTime());
            sb.append(str3);
        }
        sb.append(" and msgtype='");
        sb.append(MsgTypeEnum.text.getValue());
        sb.append("' and (");
        if (list != null && list.size() > 0) {
            sb.append("fromid in (");
            for (String str4 : list) {
                sb.append(str3);
                sb.append(C5732b.m23077a(str4));
                sb.append("',");
            }
            sb.replace(sb.length() - 1, sb.length(), ") or");
        }
        sb.append(" content like ");
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            String replace = str.replace(str3, "''").replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
            StringBuilder sb2 = new StringBuilder("'%");
            sb2.append(replace);
            sb2.append("%' ESCAPE '\\'");
            str2 = sb2.toString();
        }
        sb.append(str2);
        sb.append(") ORDER BY time desc limit ");
        sb.append(i);
        return m23744a(C5742c.m23101a().mo28018d(), sb.toString());
    }

    /* renamed from: a */
    public static void m23750a(C5912a aVar) {
        m23751a(aVar, (MsgStatusEnum) null);
    }

    /* renamed from: a */
    public static void m23751a(C5912a aVar, MsgStatusEnum msgStatusEnum) {
        ContentValues c = m23757c(aVar);
        if (msgStatusEnum != null) {
            c.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(msgStatusEnum.getValue()));
        }
        aVar.mo28293a(C5742c.m23101a().mo28018d().mo27978a("msghistory", c));
    }

    /* renamed from: a */
    public static void m23752a(C5925h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert or replace into lstmsg(uid,fromuid,messageId,msgstatus,unreadnum,content,time,sessiontype,tag,msgtype,attach) values ('");
        sb.append(C5732b.m23077a(hVar.getContactId()));
        String str = "','";
        sb.append(str);
        sb.append(C5732b.m23077a(hVar.getFromAccount()));
        sb.append(str);
        sb.append(hVar.getRecentMessageId());
        sb.append(str);
        sb.append(hVar.getMsgStatus().getValue());
        sb.append(str);
        sb.append(hVar.getUnreadCount());
        sb.append(str);
        sb.append(C5732b.m23077a(hVar.getContent()));
        sb.append(str);
        sb.append(hVar.getTime());
        sb.append(str);
        sb.append(hVar.getSessionType().getValue());
        sb.append(str);
        sb.append(hVar.getTag());
        sb.append(str);
        sb.append(hVar.mo28343b());
        sb.append(str);
        sb.append(C5732b.m23077a(hVar.mo28336a()));
        sb.append("')");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
    }

    /* renamed from: a */
    public static void m23753a(List<C5912a> list) {
        C5742c.m23101a().mo28018d().mo27984d().beginTransaction();
        try {
            for (C5912a a : list) {
                m23751a(a, (MsgStatusEnum) null);
            }
            C5742c.m23101a().mo28018d().mo27984d().setTransactionSuccessful();
        } finally {
            C5742c.m23101a().mo28018d().mo27984d().endTransaction();
        }
    }

    /* renamed from: b */
    public static long m23754b(String str) {
        StringBuilder sb = new StringBuilder("SELECT messageid FROM msghistory where uuid='");
        sb.append(str);
        sb.append("'");
        Cursor b = C5742c.m23101a().mo28018d().mo27981b(sb.toString());
        long j = 0;
        if (b != null) {
            if (b.moveToNext()) {
                j = b.getLong(0);
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        return j;
    }

    /* renamed from: b */
    public static void m23755b(C5912a aVar) {
        m23756b(aVar, null);
    }

    /* renamed from: b */
    public static void m23756b(C5912a aVar, MsgStatusEnum msgStatusEnum) {
        ContentValues c = m23757c(aVar);
        c.put("messageid", Long.valueOf(aVar.mo28290a()));
        if (msgStatusEnum != null) {
            c.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(msgStatusEnum.getValue()));
        }
        C5742c.m23101a().mo28018d().mo27980b("msghistory", c);
    }

    /* renamed from: c */
    private static ContentValues m23757c(C5912a aVar) {
        ContentValues contentValues = new ContentValues(16);
        contentValues.put("uuid", aVar.getUuid());
        contentValues.put("serverid", Long.valueOf(aVar.mo28300c()));
        contentValues.put("time", Long.valueOf(aVar.getTime()));
        contentValues.put(MessageKey.MSG_CONTENT, aVar.getContent());
        contentValues.put("msgtype", Integer.valueOf(aVar.mo28297b()));
        contentValues.put("sessiontype", Integer.valueOf(aVar.getSessionType().getValue()));
        contentValues.put("fromid", aVar.getFromAccount());
        contentValues.put("id", aVar.getSessionId());
        contentValues.put("direct", Integer.valueOf(aVar.getDirect().getValue()));
        contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(aVar.getStatus().getValue()));
        contentValues.put("status2", Integer.valueOf(aVar.getAttachStatus().getValue()));
        contentValues.put("attach", aVar.mo28291a(false));
        contentValues.put("ext", aVar.getExt());
        return contentValues;
    }
}
