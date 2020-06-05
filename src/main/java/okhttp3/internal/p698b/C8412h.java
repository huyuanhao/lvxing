package okhttp3.internal.p698b;

import javax.annotation.Nullable;
import okhttp3.C8364ac;
import okhttp3.C8510v;
import okio.C8529e;

/* compiled from: RealResponseBody */
/* renamed from: okhttp3.internal.b.h */
public final class C8412h extends C8364ac {
    @Nullable
    /* renamed from: a */
    private final String f28517a;
    /* renamed from: b */
    private final long f28518b;
    /* renamed from: c */
    private final C8529e f28519c;

    public C8412h(@Nullable String str, long j, C8529e eVar) {
        this.f28517a = str;
        this.f28518b = j;
        this.f28519c = eVar;
    }

    /* renamed from: a */
    public C8510v mo40120a() {
        String str = this.f28517a;
        if (str != null) {
            return C8510v.m36598b(str);
        }
        return null;
    }

    /* renamed from: b */
    public long mo40121b() {
        return this.f28518b;
    }

    /* renamed from: c */
    public C8529e mo40122c() {
        return this.f28519c;
    }
}
