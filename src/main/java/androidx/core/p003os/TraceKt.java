package androidx.core.p003os;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo39189d2 = {"trace", "T", "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* compiled from: Trace.kt */
/* renamed from: androidx.core.os.TraceKt */
public final class TraceKt {
    public static final <T> T trace(String str, C8246a<? extends T> aVar) {
        C8271i.m35386b(str, "sectionName");
        C8271i.m35386b(aVar, "block");
        TraceCompat.beginSection(str);
        try {
            return aVar.invoke();
        } finally {
            InlineMarker.m35375a(1);
            TraceCompat.endSection();
            InlineMarker.m35376b(1);
        }
    }
}
