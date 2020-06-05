package ezy.sdk3rd.social.share;

import android.text.TextUtils;
import ezy.sdk3rd.social.share.p650a.p651a.ImageResource;
import ezy.sdk3rd.social.share.p652b.IMediaObject;

/* renamed from: ezy.sdk3rd.social.share.a */
public class ShareData {
    /* renamed from: a */
    public String f27306a;
    /* renamed from: b */
    public String f27307b;
    /* renamed from: c */
    public String f27308c;
    /* renamed from: d */
    public String f27309d;
    /* renamed from: e */
    public ImageResource f27310e;
    /* renamed from: f */
    public IMediaObject f27311f;

    public ShareData() {
        String str = "";
        this.f27306a = str;
        this.f27307b = str;
        this.f27308c = str;
        this.f27309d = str;
    }

    /* renamed from: a */
    public boolean mo38630a() {
        return !TextUtils.isEmpty(this.f27306a);
    }

    /* renamed from: b */
    public boolean mo38631b() {
        return !TextUtils.isEmpty(this.f27307b);
    }

    /* renamed from: c */
    public boolean mo38632c() {
        return !TextUtils.isEmpty(this.f27308c);
    }

    /* renamed from: d */
    public boolean mo38633d() {
        return !TextUtils.isEmpty(this.f27309d);
    }

    /* renamed from: e */
    public boolean mo38634e() {
        return this.f27310e != null;
    }

    /* renamed from: f */
    public int mo38635f() {
        IMediaObject aVar = this.f27311f;
        if (aVar != null) {
            return aVar.mo38640a();
        }
        return mo38631b() ? 1 : 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShareData [type=");
        sb.append(mo38635f());
        sb.append(", title=");
        sb.append(this.f27308c);
        sb.append(", desc=");
        sb.append(this.f27309d);
        sb.append(", thumb=");
        sb.append(this.f27310e);
        sb.append("]");
        return sb.toString();
    }
}
