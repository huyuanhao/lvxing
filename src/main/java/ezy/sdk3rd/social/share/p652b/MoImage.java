package ezy.sdk3rd.social.share.p652b;

import android.graphics.Bitmap;
import ezy.sdk3rd.social.share.p650a.p651a.BitmapResource;
import ezy.sdk3rd.social.share.p650a.p651a.ImageResource;

/* renamed from: ezy.sdk3rd.social.share.b.b */
public class MoImage implements IMediaObject {
    /* renamed from: a */
    public ImageResource f27316a;

    /* renamed from: a */
    public int mo38640a() {
        return 2;
    }

    public MoImage(Bitmap bitmap) {
        this.f27316a = new BitmapResource(bitmap);
    }

    /* renamed from: b */
    public String mo38641b() {
        return this.f27316a.mo38637a();
    }

    /* renamed from: c */
    public byte[] mo38642c() {
        return this.f27316a.mo38639c();
    }
}
