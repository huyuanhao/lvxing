package com.alipay.android.phone.mrpc.core.p102a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.p099a.p100a.C1386e;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* renamed from: com.alipay.android.phone.mrpc.core.a.d */
public final class C1401d extends C1398a {
    public C1401d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    /* renamed from: a */
    public final Object mo11934a() {
        try {
            String str = new String(this.f3605b);
            StringBuilder sb = new StringBuilder("threadid = ");
            sb.append(Thread.currentThread().getId());
            sb.append("; rpc response:  ");
            sb.append(str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                Type type = this.f3604a;
                Class<String> cls = String.class;
                String str2 = ArgKey.KEY_RESULT;
                return type == cls ? jSONObject.optString(str2) : C1386e.m4045a(jSONObject.optString(str2), this.f3604a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            Integer valueOf = Integer.valueOf(10);
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.f3605b));
            sb2.append(":");
            sb2.append(e);
            throw new RpcException(valueOf, sb2.toString() == null ? "" : e.getMessage());
        }
    }
}
