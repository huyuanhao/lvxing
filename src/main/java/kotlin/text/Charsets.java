package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo39189d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.text.d */
public final class Charsets {
    /* renamed from: a */
    public static final Charset f27799a;
    /* renamed from: b */
    public static final Charset f27800b;
    /* renamed from: c */
    public static final Charset f27801c;
    /* renamed from: d */
    public static final Charset f27802d;
    /* renamed from: e */
    public static final Charset f27803e;
    /* renamed from: f */
    public static final Charset f27804f;
    /* renamed from: g */
    public static final Charsets f27805g = new Charsets();

    static {
        Charset forName = Charset.forName("UTF-8");
        C8271i.m35382a((Object) forName, "Charset.forName(\"UTF-8\")");
        f27799a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        C8271i.m35382a((Object) forName2, "Charset.forName(\"UTF-16\")");
        f27800b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        C8271i.m35382a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        f27801c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        C8271i.m35382a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        f27802d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        C8271i.m35382a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        f27803e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        C8271i.m35382a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f27804f = forName6;
    }

    private Charsets() {
    }
}
