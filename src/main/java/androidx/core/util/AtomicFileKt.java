package androidx.core.util;

import android.util.AtomicFile;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.p679a.C8247b;
import kotlin.text.Charsets;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a0\u0010\u0007\u001a\u00020\b*\u00020\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nH\b\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0013"}, mo39189d2 = {"readBytes", "", "Landroid/util/AtomicFile;", "readText", "", "charset", "Ljava/nio/charset/Charset;", "tryWrite", "", "block", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "writeBytes", "array", "writeText", "text", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: AtomicFile.kt */
public final class AtomicFileKt {
    public static final void tryWrite(AtomicFile atomicFile, C8247b<? super FileOutputStream, Unit> bVar) {
        C8271i.m35386b(atomicFile, "$this$tryWrite");
        C8271i.m35386b(bVar, "block");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            C8271i.m35382a((Object) startWrite, "stream");
            bVar.invoke(startWrite);
            InlineMarker.m35375a(1);
            atomicFile.finishWrite(startWrite);
            InlineMarker.m35376b(1);
        } catch (Throwable th) {
            InlineMarker.m35375a(1);
            atomicFile.failWrite(startWrite);
            InlineMarker.m35376b(1);
            throw th;
        }
    }

    public static /* synthetic */ void writeText$default(AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.f27799a;
        }
        writeText(atomicFile, str, charset);
    }

    public static final void writeText(AtomicFile atomicFile, String str, Charset charset) {
        C8271i.m35386b(atomicFile, "$this$writeText");
        C8271i.m35386b(str, "text");
        C8271i.m35386b(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        C8271i.m35382a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static final byte[] readBytes(AtomicFile atomicFile) {
        C8271i.m35386b(atomicFile, "$this$readBytes");
        byte[] readFully = atomicFile.readFully();
        C8271i.m35382a((Object) readFully, "readFully()");
        return readFully;
    }

    public static /* synthetic */ String readText$default(AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.f27799a;
        }
        return readText(atomicFile, charset);
    }

    public static final String readText(AtomicFile atomicFile, Charset charset) {
        C8271i.m35386b(atomicFile, "$this$readText");
        C8271i.m35386b(charset, "charset");
        byte[] readFully = atomicFile.readFully();
        C8271i.m35382a((Object) readFully, "readFully()");
        return new String(readFully, charset);
    }

    public static final void writeBytes(AtomicFile atomicFile, byte[] bArr) {
        C8271i.m35386b(atomicFile, "$this$writeBytes");
        C8271i.m35386b(bArr, "array");
        FileOutputStream startWrite = atomicFile.startWrite();
        try {
            C8271i.m35382a((Object) startWrite, "stream");
            startWrite.write(bArr);
            atomicFile.finishWrite(startWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(startWrite);
            throw th;
        }
    }
}
