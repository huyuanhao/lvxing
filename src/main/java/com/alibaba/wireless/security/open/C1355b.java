package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.framework.C1338c;
import com.alibaba.wireless.security.open.p080a.C1354a;
import com.alibaba.wireless.security.open.p081b.C1357a;
import com.alibaba.wireless.security.open.p082c.C1359a;
import com.alibaba.wireless.security.open.p083d.C1360a;
import com.alibaba.wireless.security.open.p084e.C1361a;
import com.alibaba.wireless.security.open.p084e.C1363c;
import com.alibaba.wireless.security.open.p085f.C1366a;
import com.alibaba.wireless.security.open.p086g.C1367a;
import com.alibaba.wireless.security.open.p087h.C1368a;
import com.alibaba.wireless.security.open.p088i.C1369a;
import com.alibaba.wireless.security.open.p089j.C1370a;
import com.alibaba.wireless.security.open.p090k.C1371a;
import com.alibaba.wireless.security.open.p091l.C1372a;
import com.alibaba.wireless.security.open.p092m.C1373a;
import com.alibaba.wireless.security.open.p095n.C1377a;
import com.alibaba.wireless.security.open.p096o.C1378a;
import com.alibaba.wireless.security.open.p097p.C1379a;
import com.alibaba.wireless.security.open.p098q.C1380a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.alibaba.wireless.security.open.b */
public class C1355b {
    /* renamed from: b */
    private static volatile C1355b f3555b;
    /* renamed from: c */
    private static volatile C1361a f3556c;
    /* renamed from: d */
    private static final Object f3557d = new Object();
    /* renamed from: e */
    private static JSONObject f3558e = null;
    /* renamed from: g */
    private static Object f3559g = new Object();
    /* renamed from: a */
    private C1338c f3560a;
    /* renamed from: f */
    private final Map<Integer, Class> f3561f = new HashMap<Integer, Class>() {
        {
            put(Integer.valueOf(1), C1371a.class);
            put(Integer.valueOf(2), C1360a.class);
            put(Integer.valueOf(3), C1378a.class);
            put(Integer.valueOf(5), C1357a.class);
            put(Integer.valueOf(6), C1377a.class);
            put(Integer.valueOf(7), C1359a.class);
            put(Integer.valueOf(8), C1373a.class);
            put(Integer.valueOf(9), C1379a.class);
            put(Integer.valueOf(10), C1368a.class);
            put(Integer.valueOf(11), C1380a.class);
            put(Integer.valueOf(12), C1369a.class);
            put(Integer.valueOf(13), C1354a.class);
            put(Integer.valueOf(14), C1366a.class);
            put(Integer.valueOf(15), C1367a.class);
            put(Integer.valueOf(16), C1370a.class);
            put(Integer.valueOf(17), C1372a.class);
        }
    };

    private C1355b(C1338c cVar) {
        this.f3560a = cVar;
    }

    /* renamed from: a */
    public static C1355b m3996a(Context context) throws SecException {
        return m3997a(context, null);
    }

    /* renamed from: a */
    public static C1355b m3997a(Context context, String str) throws SecException {
        if (f3555b == null) {
            synchronized (C1355b.class) {
                if (context == null) {
                    return null;
                }
                if (f3555b == null && m3998a(str).mo11887a(context) == 0) {
                    f3555b = new C1355b(((C1363c) m3998a(str)).mo11890a());
                }
            }
        }
        return f3555b;
    }

    /* renamed from: a */
    public static C1361a m3998a(String str) {
        if (f3556c == null) {
            synchronized (f3557d) {
                if (f3556c == null) {
                    f3556c = new C1363c(str);
                }
            }
        }
        return f3556c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1353a mo11872a(int i) {
        try {
            return (C1353a) mo11874a((Class) this.f3561f.get(Integer.valueOf(i)));
        } catch (SecException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C1360a mo11873a() {
        return (C1360a) mo11872a(2);
    }

    /* renamed from: a */
    public <T> T mo11874a(Class<T> cls) throws SecException {
        return this.f3560a.mo11846a(cls);
    }

    /* renamed from: b */
    public C1378a mo11875b() {
        return (C1378a) mo11872a(3);
    }

    /* renamed from: c */
    public C1359a mo11876c() {
        return (C1359a) mo11872a(7);
    }

    /* renamed from: d */
    public C1380a mo11877d() {
        return (C1380a) mo11872a(11);
    }

    /* renamed from: e */
    public C1370a mo11878e() {
        C1370a aVar = (C1370a) mo11872a(16);
        if (aVar == null) {
            new SecException(1699).printStackTrace();
        }
        return aVar;
    }
}
