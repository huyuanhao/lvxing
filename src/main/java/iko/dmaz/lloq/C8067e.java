package iko.dmaz.lloq;

/* renamed from: iko.dmaz.lloq.e */
public class C8067e implements Comparable<C8067e> {
    /* renamed from: a */
    private String f27355a;
    /* renamed from: b */
    private C8068f f27356b;
    /* renamed from: c */
    private int f27357c = -1;
    /* renamed from: d */
    private boolean f27358d;

    public C8067e(String str, C8068f fVar, boolean z, int i) {
        this.f27355a = str;
        this.f27356b = fVar;
        this.f27358d = z;
        this.f27357c = i;
    }

    /* renamed from: a */
    public int compareTo(C8067e eVar) {
        int i = eVar.f27357c;
        int i2 = this.f27357c;
        if (i > i2) {
            return -1;
        }
        return i < i2 ? 1 : 0;
    }
}
