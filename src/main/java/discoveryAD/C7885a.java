package discoveryAD;

/* renamed from: discoveryAD.a */
public abstract class C7885a implements Comparable<C7885a> {
    /* renamed from: oc */
    public static final int f26812oc = 1;
    /* renamed from: pc */
    public static final int f26813pc = 2;
    /* renamed from: qc */
    private final int f26814qc = -1;
    /* renamed from: rc */
    public int f26815rc;
    /* renamed from: sc */
    String f26816sc;
    /* renamed from: tc */
    public int f26817tc = -1;
    /* renamed from: uc */
    public int f26818uc = -1;
    /* renamed from: vc */
    protected int f26819vc = 2;
    /* renamed from: wc */
    public int f26820wc = 0;
    /* renamed from: xc */
    public long f26821xc = 0;
    /* renamed from: yc */
    public boolean f26822yc = true;

    private boolean isExpired() {
        return this.f26815rc < ((int) (System.currentTimeMillis() / 1000));
    }

    /* renamed from: G */
    public abstract void mo38123G(int i);

    /* renamed from: Wa */
    public boolean mo38179Wa() {
        return (this.f26818uc == 0 || this.f26817tc == 0 || isExpired()) ? false : true;
    }

    /* renamed from: Xa */
    public abstract void mo38124Xa();

    /* renamed from: Ya */
    public abstract void mo38125Ya();

    /* renamed from: Za */
    public abstract void mo38126Za();

    /* renamed from: _a */
    public abstract void mo38127_a();

    /* renamed from: a */
    public int compareTo(C7885a aVar) {
        int i = this.f26820wc;
        int i2 = aVar.f26820wc;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: ab */
    public abstract void mo38128ab();

    /* renamed from: bb */
    public void mo38181bb() {
        this.f26815rc = ((int) (System.currentTimeMillis() / 1000)) - 5;
    }

    public int getState() {
        return this.f26819vc;
    }

    public abstract void onClick();
}
