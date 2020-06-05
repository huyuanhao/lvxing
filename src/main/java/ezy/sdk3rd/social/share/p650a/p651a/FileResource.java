package ezy.sdk3rd.social.share.p650a.p651a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import ezy.sdk3rd.social.share.p650a.ImageTool;
import java.io.File;

/* renamed from: ezy.sdk3rd.social.share.a.a.b */
public class FileResource implements ImageResource {
    /* renamed from: a */
    public final File f27315a;

    /* renamed from: a */
    public String mo38637a() {
        return this.f27315a.toString();
    }

    /* renamed from: b */
    public Bitmap mo38638b() {
        return ImageTool.m34848a(this.f27315a);
    }

    /* renamed from: c */
    public byte[] mo38639c() {
        return ImageTool.m34849a(ImageTool.m34848a(this.f27315a), CompressFormat.JPEG);
    }
}
