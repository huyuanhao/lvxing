package com.pgl.sys.p362a;

import android.content.Context;
import android.util.Base64;
import com.pgl.p359a.p361b.C4786d;
import com.pgl.sys.p362a.p363a.C4790a;
import com.tencent.p605ep.commonbase.software.AppEntity;
import org.json.JSONObject;

/* renamed from: com.pgl.sys.a.a */
public class C4789a {
    /* renamed from: a */
    static int f15436a = 504;
    /* renamed from: b */
    static boolean f15437b = false;
    /* renamed from: c */
    static String f15438c = "";
    /* renamed from: d */
    static String f15439d = "";
    /* renamed from: e */
    private static long f15440e;

    /* renamed from: a */
    public static String m19626a() {
        String str = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "Android");
            jSONObject.put(AppEntity.KEY_VERSION_STR, "1.0.3");
            String str2 = "token_id";
            if (f15437b) {
                jSONObject.put(str2, f15439d);
            } else {
                jSONObject.put(str2, str);
            }
            jSONObject.put("code", f15436a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            C4786d.m19619a("Call onEvent Error");
            return str;
        }
    }

    /* renamed from: a */
    public static void m19627a(Context context, String str, C4790a aVar) {
        int i = f15436a;
        if (i != 102 && i != 202 && i != 200) {
            f15440e = System.currentTimeMillis();
            f15437b = false;
            f15438c = str;
            f15436a = 102;
            Thread thread = new Thread(new C4791b(context, aVar));
            thread.setName("CZL-3");
            thread.start();
        }
    }
}
