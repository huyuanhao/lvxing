package com.bytedance.embedapplog.p141a;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p144d.C1839b;
import com.bytedance.embedapplog.util.C1856h;
import com.p522qq.p523e.comm.constants.Constants;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.h */
class C1808h extends C1803c {
    /* renamed from: b */
    private static final long[] f5061b = {60000};
    /* renamed from: c */
    private final C1839b f5062c;
    /* renamed from: d */
    private final C1822i f5063d;
    /* renamed from: e */
    private long f5064e;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return Constants.PORTRAIT;
    }

    C1808h(Context context, C1822i iVar, C1839b bVar) {
        super(context);
        this.f5062c = bVar;
        this.f5063d = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        return this.f5064e + 60000;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        return f5061b;
    }

    /* renamed from: d */
    public boolean mo13348d() {
        long currentTimeMillis = System.currentTimeMillis();
        C1811k d = C1805e.m6278d();
        if (d != null) {
            Bundle a = d.mo13358a(currentTimeMillis, 50000);
            if (a != null) {
                AppLog.onEventV3("play_session", a);
                AppLog.flush();
            }
        }
        if (this.f5063d.mo13446o() == 0) {
            return false;
        }
        JSONObject b = this.f5063d.mo13430b();
        if (b != null) {
            boolean a2 = this.f5062c.mo13477a(b);
            this.f5064e = System.currentTimeMillis();
            return a2;
        }
        C1856h.m6582a(null);
        return false;
    }
}
