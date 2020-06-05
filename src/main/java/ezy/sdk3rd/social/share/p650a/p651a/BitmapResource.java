package ezy.sdk3rd.social.share.p650a.p651a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import ezy.sdk3rd.social.share.p650a.ImageTool;

/* renamed from: ezy.sdk3rd.social.share.a.a.a */
public class BitmapResource implements ImageResource {
    /* renamed from: a */
    public final Bitmap f27314a;

    /* renamed from: a */
    public String mo38637a() {
        return null;
    }

    public BitmapResource(Bitmap bitmap) {
        this.f27314a = bitmap;
    }

    /* renamed from: b */
    public Bitmap mo38638b() {
        return this.f27314a;
    }

    /* renamed from: c */
    public byte[] mo38639c() {
        return ImageTool.m34849a(this.f27314a, CompressFormat.JPEG);
    }
}
