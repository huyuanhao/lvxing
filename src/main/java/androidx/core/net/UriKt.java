package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\b¨\u0006\u0005"}, mo39189d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Uri.kt */
public final class UriKt {
    public static final Uri toUri(String str) {
        C8271i.m35386b(str, "$this$toUri");
        Uri parse = Uri.parse(str);
        C8271i.m35382a((Object) parse, "Uri.parse(this)");
        return parse;
    }

    public static final Uri toUri(File file) {
        C8271i.m35386b(file, "$this$toUri");
        Uri fromFile = Uri.fromFile(file);
        C8271i.m35382a((Object) fromFile, "Uri.fromFile(this)");
        return fromFile;
    }

    public static final File toFile(Uri uri) {
        C8271i.m35386b(uri, "$this$toFile");
        if (C8271i.m35384a((Object) uri.getScheme(), (Object) "file")) {
            return new File(uri.getPath());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Uri lacks 'file' scheme: ");
        sb.append(uri);
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
