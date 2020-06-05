package epco;

import android.util.SparseArray;

/* renamed from: epco.z */
public class C8012z {
    /* renamed from: a */
    private SparseArray<C8010y> f27246a = new SparseArray<>();
    /* renamed from: b */
    private C7998s f27247b;

    /* renamed from: a */
    public C7998s mo38527a() {
        return this.f27247b;
    }

    /* renamed from: a */
    public C8010y mo38528a(short s) {
        return (C8010y) this.f27246a.get(s);
    }

    /* renamed from: a */
    public void mo38529a(C7998s sVar) {
        this.f27247b = sVar;
    }

    /* renamed from: a */
    public void mo38530a(C8010y yVar) {
        this.f27246a.put(yVar.mo38509a(), yVar);
    }
}
