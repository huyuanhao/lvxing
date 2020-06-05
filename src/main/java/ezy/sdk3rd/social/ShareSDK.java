package ezy.sdk3rd.social;

import android.app.Activity;
import ezy.sdk3rd.social.sdk.C8036h;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.share.IShareable;
import ezy.sdk3rd.social.share.ShareData;
import ezy.sdk3rd.social.share.p652b.IMediaObject;

/* renamed from: ezy.sdk3rd.social.d */
public class ShareSDK {
    /* renamed from: a */
    static C8036h<IShareable> f27277a = new C8036h<>();
    /* renamed from: b */
    private ShareData f27278b = new ShareData();
    /* renamed from: c */
    private Activity f27279c;

    /* renamed from: a */
    public static <T extends IShareable> void m34818a(String str, String str2, Class<T> cls) {
        f27277a.mo38621a(str, str2, cls);
    }

    private ShareSDK(Activity activity, String str, IMediaObject aVar) {
        this.f27279c = activity;
        ShareData aVar2 = this.f27278b;
        aVar2.f27307b = str;
        aVar2.f27311f = aVar;
    }

    /* renamed from: a */
    public static ShareSDK m34817a(Activity activity, IMediaObject aVar) {
        return new ShareSDK(activity, null, aVar);
    }

    /* renamed from: a */
    public void mo38575a(String str, OnCallback<String> fVar) {
        if (!f27277a.mo38622a(str)) {
            Activity activity = this.f27279c;
            StringBuilder sb = new StringBuilder();
            sb.append("不支持的平台[");
            sb.append(str);
            sb.append("]");
            fVar.mo20728a(activity, 3, sb.toString());
            return;
        }
        IShareable iShareable = (IShareable) f27277a.mo38619a(this.f27279c, str);
        if (iShareable != null) {
            iShareable.share(this.f27278b, fVar);
        }
    }
}
