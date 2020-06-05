package com.qiyukf.nimlib.p451c;

import com.qiyukf.nimlib.p451c.p452a.C5733c;
import com.qiyukf.nimlib.p451c.p452a.C5733c.C5734a;
import com.qiyukf.nimlib.p451c.p452a.C5733c.C5735b;

/* renamed from: com.qiyukf.nimlib.c.b */
public final class C5737b extends C5733c {
    /* renamed from: a */
    public static final C5737b f18305a = new C5737b();

    public C5737b() {
        super(new C5734a[]{new C5734a("msghistory").mo27987a((C5735b) new C5735b() {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final String[] mo27991a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS msghistory(messageid Integer PRIMARY KEY AUTOINCREMENT, uuid Varchar(32) NOT NULL, serverid Long, id Varchar(32) NOT NULL, fromid Varchar(32) NOT NULL, sessiontype Integer, time Long, status Integer, direct Integer, msgtype Integer, content Varchar(512), status2 Integer, attach TEXT)", "CREATE INDEX IF NOT EXISTS msghistory_uuid_index on msghistory(uuid)", "CREATE INDEX IF NOT EXISTS msghistory_id_sessiontype_time on msghistory(id, sessiontype, time)"};
            }

            /* access modifiers changed from: protected|final */
            /* renamed from: b */
            public final String[] mo27992b() {
                return null;
            }
        }).mo27987a((C5735b) new C5735b() {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final String[] mo27991a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS msghistory(messageid Integer PRIMARY KEY AUTOINCREMENT, uuid Varchar(32) NOT NULL, serverid Long, sessionid, Long, id Varchar(32) NOT NULL, fromid Varchar(32) NOT NULL, sessiontype Integer, sessiontime Long, visitorid Long, foreignid Varchar(128), time Long, sort Long, status Integer, direct Integer, msgtype Integer, content Varchar(512), status2 Integer, attach TEXT,ext TEXT )", "CREATE INDEX IF NOT EXISTS msghistory_uuid_index on msghistory(uuid)", "CREATE INDEX IF NOT EXISTS msghistory_visitor_time on msghistory(foreignid, visitorid, sort)"};
            }

            /* access modifiers changed from: protected|final */
            /* renamed from: b */
            public final String[] mo27992b() {
                return new String[]{"ALTER TABLE msghistory ADD ext TEXT"};
            }
        }), new C5734a("lastMsg").mo27987a((C5735b) new C5735b() {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final String[] mo27991a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS lstmsg(uid Varchar(16) NOT NULL, messageId long, msgstatus INTEGER, sessiontype INTEGER, unreadnum integer, content Varchar(512), time long, tag INTEGER default 0, tag_time long default 0, fromuid Varchar(16))", "CREATE UNIQUE INDEX IF NOT EXISTS lstmsg_uid_sessiontype on lstmsg(uid, sessiontype)"};
            }

            /* access modifiers changed from: protected|final */
            /* renamed from: b */
            public final String[] mo27992b() {
                return null;
            }
        }).mo27987a((C5735b) new C5735b() {
            /* access modifiers changed from: protected|final */
            /* renamed from: a */
            public final String[] mo27991a() {
                return new String[]{"CREATE TABLE IF NOT EXISTS lstmsg(uid Varchar(16) NOT NULL, messageId long, msgstatus INTEGER, sessiontype INTEGER, unreadnum INTEGER, content Varchar(512), time long, tag INTEGER default 0, tag_time long default 0, fromuid Varchar(16), msgtype INTEGER, attach TEXT)", "CREATE UNIQUE INDEX IF NOT EXISTS lstmsg_uid_sessiontype on lstmsg(uid, sessiontype)"};
            }

            /* access modifiers changed from: protected|final */
            /* renamed from: b */
            public final String[] mo27992b() {
                return new String[]{"ALTER TABLE lstmsg ADD msgtype INTEGER", "ALTER TABLE lstmsg ADD attach TEXT"};
            }
        })});
    }
}
