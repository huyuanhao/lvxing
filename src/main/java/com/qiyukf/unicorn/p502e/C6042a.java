package com.qiyukf.unicorn.p502e;

import com.qiyukf.basesdk.p412c.C5366b;
import java.io.Serializable;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.e.a */
public final class C6042a implements Serializable {
    /* renamed from: a */
    private String f18894a;
    /* renamed from: b */
    private String f18895b;
    /* renamed from: c */
    private String f18896c;
    /* renamed from: d */
    private boolean f18897d;

    /* renamed from: a */
    public final String mo28880a() {
        return this.f18895b;
    }

    /* renamed from: a */
    public final void mo28881a(String str) {
        JSONObject a = C5366b.m22027a(str);
        String str2 = "setting";
        if (a.has(str2)) {
            JSONObject f = C5366b.m22040f(a, str2);
            if (f != null) {
                this.f18894a = C5366b.m22039e(f, "inputSwitch");
                this.f18895b = C5366b.m22039e(f, "staffReadSwitch");
                this.f18896c = C5366b.m22039e(f, "sendingRate");
                this.f18897d = C5366b.m22033a(f, "session_transfer_switch");
            }
        }
    }

    /* renamed from: b */
    public final boolean mo28882b() {
        return this.f18897d;
    }
}
