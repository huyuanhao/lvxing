package btmsdkobf;

/* renamed from: btmsdkobf.de */
public class C0684de {
    /* renamed from: hu */
    private C0843fb f498hu;
    /* renamed from: hv */
    private int f499hv = 0;
    /* renamed from: hw */
    private long f500hw = 0;
    /* renamed from: hx */
    private int f501hx = 0;
    /* renamed from: hy */
    private long f502hy = 0;
    /* renamed from: hz */
    private long f503hz = 0;

    public C0684de(String str, long j, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("freq_ctrl_");
        sb.append(str);
        this.f498hu = new C0843fb(sb.toString());
        this.f499hv = i;
        this.f500hw = j;
        this.f501hx = this.f498hu.getInt("times_now", this.f501hx);
        this.f502hy = this.f498hu.getLong("time_span_start", this.f502hy);
        this.f503hz = this.f498hu.getLong("time_span_end", this.f503hz);
        this.f498hu.putInt("times", i);
        this.f498hu.putLong("time_span", j);
    }

    /* renamed from: c */
    private void m266c(long j) {
        this.f502hy = j;
        this.f503hz = j + this.f500hw;
        this.f498hu.putLong("time_span_start", this.f502hy);
        this.f498hu.putLong("time_span_end", this.f503hz);
    }

    /* renamed from: o */
    private void m267o(int i) {
        this.f501hx = i;
        this.f498hu.putInt("times_now", this.f501hx);
    }

    /* renamed from: aP */
    public boolean mo9270aP() {
        if (this.f502hy == 0) {
            return true;
        }
        return this.f501hx < this.f499hv || System.currentTimeMillis() >= this.f503hz;
    }

    /* renamed from: aQ */
    public void mo9271aQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f502hy == 0 || currentTimeMillis >= this.f503hz) {
            m266c(currentTimeMillis);
            m267o(0);
        }
        m267o(this.f501hx + 1);
    }
}
