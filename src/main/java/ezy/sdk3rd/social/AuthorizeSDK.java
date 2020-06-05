package ezy.sdk3rd.social;

import android.app.Activity;
import ezy.sdk3rd.social.authorize.IAuthorize;
import ezy.sdk3rd.social.sdk.C8036h;
import ezy.sdk3rd.social.sdk.DefaultCallback;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.OnSucceed;

/* renamed from: ezy.sdk3rd.social.a */
public class AuthorizeSDK {
    /* renamed from: a */
    static C8036h<IAuthorize> f27275a = new C8036h<>();

    /* renamed from: a */
    public static <T extends IAuthorize> void m34813a(String str, String str2, Class<T> cls) {
        f27275a.mo38621a(str, str2, cls);
    }

    /* renamed from: a */
    public static void m34812a(Activity activity, String str, OnSucceed<String> gVar) {
        m34811a(activity, str, (OnCallback<String>) new DefaultCallback<String>(f27275a.mo38620a(), gVar));
    }

    /* renamed from: a */
    public static void m34811a(Activity activity, String str, OnCallback<String> fVar) {
        if (!f27275a.mo38622a(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("不支持的平台[");
            sb.append(str);
            sb.append("]");
            fVar.mo20728a(activity, 3, sb.toString());
            return;
        }
        IAuthorize iAuthorize = (IAuthorize) f27275a.mo38619a(activity, str);
        if (iAuthorize != null) {
            iAuthorize.authorize(fVar);
        }
    }
}
