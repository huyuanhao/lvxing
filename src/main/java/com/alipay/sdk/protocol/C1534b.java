package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.alipay.sdk.p126f.C1531b;
import com.alipay.sdk.sys.C1536b;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.protocol.b */
public class C1534b {
    /* renamed from: a */
    private C1533a f3920a;
    /* renamed from: b */
    private String f3921b;
    /* renamed from: c */
    private String[] f3922c;

    public C1534b(String str, C1533a aVar) {
        this.f3921b = str;
        this.f3920a = aVar;
    }

    /* renamed from: a */
    public static void m4595a(C1534b bVar) {
        String[] b = bVar.mo12198b();
        if (b.length == 3) {
            if (TextUtils.equals("tid", b[0])) {
                C1531b a = C1531b.m4573a(C1536b.m4608a().mo12202b());
                if (!TextUtils.isEmpty(b[1]) && !TextUtils.isEmpty(b[2])) {
                    a.mo12194a(b[1], b[2]);
                }
            }
        }
    }

    /* renamed from: a */
    public static List<C1534b> m4594a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] b = m4597b(jSONObject.optString(ArgKey.KEY_NAME, ""));
        for (int i = 0; i < b.length; i++) {
            C1533a a = C1533a.m4593a(b[i]);
            if (a != C1533a.None) {
                C1534b bVar = new C1534b(b[i], a);
                bVar.f3922c = m4596a(b[i]);
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static String[] m4596a(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String trim : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            String str2 = "";
            arrayList.add(trim.trim().replaceAll("'", str2).replaceAll("\"", str2));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* renamed from: b */
    private static String[] m4597b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(";");
        }
        return null;
    }

    /* renamed from: a */
    public C1533a mo12197a() {
        return this.f3920a;
    }

    /* renamed from: b */
    public String[] mo12198b() {
        return this.f3922c;
    }
}
