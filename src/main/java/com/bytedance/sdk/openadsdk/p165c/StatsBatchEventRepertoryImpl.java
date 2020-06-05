package com.bytedance.sdk.openadsdk.p165c;

import android.content.Context;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.bytedance.sdk.openadsdk.c.l */
public class StatsBatchEventRepertoryImpl extends StatsEventRepertoryImpl {
    /* renamed from: d */
    public String mo15038d() {
        return "logstatsbatch";
    }

    public StatsBatchEventRepertoryImpl(Context context) {
        super(context);
    }

    /* renamed from: c */
    public int mo15011c() {
        return this.f6813a.mo15325b("stats_serverbusy_retrycount", 0);
    }

    /* renamed from: a */
    public void mo15004a(int i) {
        this.f6813a.mo15320a("stats_serverbusy_retrycount", i);
    }

    /* renamed from: e */
    public static String m8505e() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append("logstatsbatch");
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append("id");
        sb.append(" TEXT UNIQUE,");
        sb.append(ArgKey.KEY_VALUE);
        sb.append(" TEXT ,");
        sb.append("gen_time");
        sb.append(" TEXT , ");
        sb.append("retry");
        sb.append(" INTEGER default 0");
        sb.append(")");
        return sb.toString();
    }
}
