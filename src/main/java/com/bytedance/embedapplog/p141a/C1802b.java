package com.bytedance.embedapplog.p141a;

import android.content.Context;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.p142b.C1822i;
import com.bytedance.embedapplog.p143c.C1835a;
import com.bytedance.embedapplog.p143c.C1836b;
import com.bytedance.embedapplog.util.C1856h;
import org.json.JSONObject;

/* renamed from: com.bytedance.embedapplog.a.b */
class C1802b extends C1803c {
    /* renamed from: b */
    private boolean f5039b;
    /* renamed from: c */
    private final C1822i f5040c;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo13345a() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo13349e() {
        return "ac";
    }

    C1802b(Context context, C1822i iVar) {
        super(context);
        this.f5040c = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo13346b() {
        return this.f5039b ? Long.MAX_VALUE : 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long[] mo13347c() {
        return C1809i.f5065b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo13348d() {
        if (this.f5040c.mo13446o() != 0) {
            JSONObject a = this.f5040c.mo13425a();
            if (a != null) {
                this.f5039b = C1835a.m6438b(C1836b.m6441a(this.f5041a, this.f5040c.mo13425a(), C1835a.m6431a().getActiveUri(), true, AppLog.getIAppParam()), a);
            } else {
                C1856h.m6582a(null);
            }
        }
        return this.f5039b;
    }
}
