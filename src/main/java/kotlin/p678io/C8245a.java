package kotlin.p678io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0006"}, mo39189d2 = {"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Exceptions.kt */
/* renamed from: kotlin.io.a */
public final class C8245a {
    /* access modifiers changed from: private|static|final */
    /* renamed from: b */
    public static final String m35367b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" -> ");
            sb2.append(file2);
            sb.append(sb2.toString());
        }
        if (str != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(": ");
            sb3.append(str);
            sb.append(sb3.toString());
        }
        String sb4 = sb.toString();
        C8271i.m35382a((Object) sb4, "sb.toString()");
        return sb4;
    }
}
