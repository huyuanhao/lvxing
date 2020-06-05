package com.qiyukf.nimlib.p429a.p448e;

import android.database.Cursor;
import com.qiyukf.nimlib.p429a.C5685d;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p469e.C5816h;
import com.qiyukf.nimlib.p469e.C5817i;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.msg.SystemMessageService;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus;
import com.qiyukf.nimlib.sdk.msg.model.SystemMessage;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.e.c */
public class C5712c extends C5816h implements SystemMessageService {
    public void clearSystemMessages() {
        C5742c.m23101a().mo28018d().mo27979a("DELETE FROM system_msg");
    }

    public void deleteSystemMessage(long j) {
        StringBuilder sb = new StringBuilder("DELETE FROM system_msg WHERE messageid='");
        sb.append(j);
        sb.append("'");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
    }

    public InvocationFuture<Integer> querySystemMessageUnreadCount() {
        int a = C5685d.m22935a();
        C5817i b = m23333b();
        b.mo28116b((Object) Integer.valueOf(a));
        C5805a.m23315c(b);
        return null;
    }

    public int querySystemMessageUnreadCountBlock() {
        return C5685d.m22935a();
    }

    public InvocationFuture<List<SystemMessage>> querySystemMessages(int i, int i2) {
        StringBuilder sb = new StringBuilder("SELECT messageid, id, fromid, type, time, status, content, attach FROM system_msg ORDER BY time desc LIMIT ");
        sb.append(i2);
        sb.append(" OFFSET ");
        sb.append(i);
        Cursor b = C5742c.m23101a().mo28018d().mo27981b(sb.toString());
        ArrayList arrayList = new ArrayList();
        if (b != null) {
            while (b.moveToNext()) {
                SystemMessage systemMessage = new SystemMessage();
                systemMessage.setMessageId(b.getLong(0));
                systemMessage.setTargetId(b.getString(1));
                systemMessage.setFromAccount(b.getString(2));
                systemMessage.setType(b.getInt(3));
                systemMessage.setTime(b.getLong(4));
                systemMessage.setStatus(SystemMessageStatus.statusOfValue(b.getInt(5)));
                systemMessage.setContent(b.getString(6));
                systemMessage.setAttach(b.getString(7));
                arrayList.add(systemMessage);
            }
            if (!b.isClosed()) {
                b.close();
            }
        }
        C5817i b2 = m23333b();
        b2.mo28116b((Object) arrayList);
        C5805a.m23315c(b2);
        return null;
    }

    public void resetSystemMessageUnreadCount() {
        C5685d.m22936a(0);
        C5808b.m23318a(0);
    }

    public void setSystemMessageStatus(long j, SystemMessageStatus systemMessageStatus) {
        StringBuilder sb = new StringBuilder("UPDATE system_msg SET status='");
        sb.append(systemMessageStatus.getValue());
        sb.append("' WHERE messageid='");
        sb.append(j);
        sb.append("'");
        C5742c.m23101a().mo28018d().mo27979a(sb.toString());
    }
}
