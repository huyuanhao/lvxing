package com.qiyukf.nimlib.p453d.p462c;

import android.content.Context;
import android.os.Build;
import com.qiyukf.nimlib.p453d.C5744a;
import com.qiyukf.nimlib.p453d.p454a.p455a.C5749b;
import com.qiyukf.nimlib.p453d.p454a.p455a.C5749b.C5750a;
import com.qiyukf.nimlib.p453d.p454a.p456b.C5753a;
import com.qiyukf.nimlib.p453d.p454a.p458d.C5759a;
import com.qiyukf.nimlib.p453d.p459b.p460a.C5764b;
import com.qiyukf.nimlib.p453d.p463d.p464a.C5779b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.d.c.a */
public final class C5773a {
    /* renamed from: a */
    private static C5773a f18383a;

    /* renamed from: com.qiyukf.nimlib.d.c.a$a */
    public interface C5776a<T> {
        /* renamed from: a */
        void mo28043a(int i, String str);

        /* renamed from: a */
        void mo28044a(T t);
    }

    /* renamed from: a */
    public static synchronized C5773a m23195a() {
        C5773a aVar;
        synchronized (C5773a.class) {
            if (f18383a == null) {
                f18383a = new C5773a();
            }
            aVar = f18383a;
        }
        return aVar;
    }

    /* renamed from: b */
    private static Map<String, String> m23196b() {
        HashMap hashMap = new HashMap(6);
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        C5779b b = C5744a.m23125d().mo28021b();
        if (b != null) {
            hashMap.put("nt-source", b.mo28056a());
            Context a = C5744a.m23125d().mo28019a();
            hashMap.put("nt-appid", a == null ? null : a.getPackageName());
            hashMap.put("nt-appkey", b.mo28057b());
            hashMap.put("nt-system", "2");
            hashMap.put("nt-deviceid", C5764b.m23170c(C5744a.m23125d().mo28019a()));
            hashMap.put("nt-deviceid2", C5764b.m23175h(C5744a.m23125d().mo28019a()));
            hashMap.put("nt-deviceid3", Build.SERIAL);
            hashMap.put("nt-version", b.mo28058c());
            hashMap.put("nt-time", String.valueOf(System.currentTimeMillis()));
            hashMap.put("Content-Encoding", "gzip");
        }
        return hashMap;
    }

    /* renamed from: a */
    public final void mo28041a(final C5776a<C5777b> aVar) {
        try {
            C5749b.m23138a().mo28026a("https://dt.netease.im/api/getConfig", m23196b(), null, false, new C5750a() {
                /* renamed from: a */
                public final void mo28027a(String str, int i, Throwable th) {
                    C5776a aVar;
                    int i2;
                    String message;
                    if (i == 200 && th == null) {
                        try {
                            aVar.mo28044a((C5777b) C5759a.m23155a(new JSONObject(str), C5777b.class));
                        } catch (JSONException e) {
                            aVar = aVar;
                            i2 = -1;
                            message = e.getMessage();
                            aVar.mo28043a(i2, message);
                        } catch (Throwable th2) {
                            aVar = aVar;
                            i2 = -2;
                            message = th2.getMessage();
                            aVar.mo28043a(i2, message);
                        }
                    } else {
                        StringBuilder sb = new StringBuilder("http fetch strategy failed, code=");
                        sb.append(i);
                        sb.append(", error=");
                        sb.append(th != null ? th.getMessage() : "null");
                        C5753a.m23148e(sb.toString());
                        C5776a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.mo28043a(i, th != null ? th.getMessage() : null);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb = new StringBuilder("fetch strategy error, e=");
            sb.append(th.getMessage());
            C5753a.m23148e(sb.toString());
        }
    }

    /* renamed from: a */
    public final void mo28042a(String str, final C5776a<Void> aVar) {
        try {
            C5749b.m23138a().mo28025a("https://dt.netease.im/api/updateInfo", m23196b(), str, new C5750a() {
                /* renamed from: a */
                public final void mo28027a(String str, int i, Throwable th) {
                    String str2 = null;
                    if (i == 200 && th == null) {
                        aVar.mo28044a(null);
                        return;
                    }
                    StringBuilder sb = new StringBuilder("http post data failed, code=");
                    sb.append(i);
                    sb.append(", error=");
                    sb.append(th != null ? th.getMessage() : "null");
                    C5753a.m23148e(sb.toString());
                    C5776a aVar = aVar;
                    if (aVar != null) {
                        if (th != null) {
                            str2 = th.getMessage();
                        }
                        aVar.mo28043a(i, str2);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            StringBuilder sb = new StringBuilder("post data error, e=");
            sb.append(th.getMessage());
            C5753a.m23148e(sb.toString());
        }
    }
}
