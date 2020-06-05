package com.ali.auth.third.core.util;

import android.app.Application;
import com.ali.auth.third.core.model.C1023d;
import com.ali.auth.third.core.model.C1031l;
import com.ali.auth.third.core.p024c.C0989a;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.core.util.g */
public class C1042g {
    /* renamed from: a */
    public static String m2007a() {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(C0989a.m1887c().getPackageManager().getPackageInfo(C0989a.m1887c().getPackageName(), 64).signatures[0].toByteArray()))).getSerialNumber().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m2008a(C1023d dVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loginTime", dVar.f1997c);
            jSONObject.put("expireIn", dVar.f1996b);
            jSONObject.put("sid", dVar.f1995a);
            jSONObject.put(ArgKey.KEY_MOBILE, dVar.f1998d);
            jSONObject.put("loginId", dVar.f1999e);
            jSONObject.put("autoLoginToken", dVar.f2000f);
            jSONObject.put("topAccessToken", dVar.f2002h);
            jSONObject.put("topAuthCode", dVar.f2003i);
            jSONObject.put("topExpireTime", dVar.f2004j);
            jSONObject.put("ssoToken", dVar.f2005k);
            C1031l lVar = dVar.f2001g;
            if (lVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("avatarUrl", lVar.f2072f);
                jSONObject2.put("userId", lVar.f2067a);
                jSONObject2.put("openId", lVar.f2075i);
                jSONObject2.put("openSid", lVar.f2076j);
                jSONObject2.put("nick", lVar.f2068b);
                jSONObject2.put("deviceTokenKey", lVar.f2073g);
                jSONObject2.put("deviceTokenSalt", lVar.f2074h);
                jSONObject.put("user", jSONObject2);
            }
            if (dVar.f2007m != null) {
                jSONObject.put("otherInfo", C1039d.m1996a(dVar.f2007m));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public static String m2009b() {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(C0989a.m1887c().getPackageManager().getPackageInfo(C0989a.m1887c().getPackageName(), 64).signatures[0].toByteArray()));
            MessageDigest instance = MessageDigest.getInstance("SHA1");
            instance.update(x509Certificate.getPublicKey().toString().getBytes());
            return C1034a.m1976a(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public static Application m2010c() {
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
