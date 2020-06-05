package btmsdkobf;

import android.content.Context;
import btmsdkobf.C0718dy.C0738f;
import btmsdkobf.C0819es.C0823a;

/* renamed from: btmsdkobf.et */
public class C0824et {
    /* renamed from: gV */
    private final int f933gV = 3;
    /* renamed from: nu */
    private Context f934nu = null;
    /* renamed from: nv */
    private C0819es f935nv = null;

    public C0824et(Context context, C0823a aVar, C0814ep epVar) {
        this.f934nu = context;
        this.f935nv = new C0819es(context, aVar, epVar);
    }

    /* renamed from: a */
    public int mo9520a(C0738f fVar, byte[] bArr) {
        if (fVar == null || bArr == null) {
            return -10;
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= 3) {
                break;
            }
            String str = "TmsTcpNetwork";
            if (fVar.mo9364bJ()) {
                C0849fg.m912e(str, "[tcp_control][time_out]sendDataAsync(), send time out");
                i = -17;
                break;
            }
            i = this.f935nv.mo9509a(fVar, bArr);
            StringBuilder sb = new StringBuilder();
            sb.append("[tcp_control]sendDataAsync(), ret: ");
            sb.append(i);
            sb.append(" times: ");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" data.length: ");
            sb.append(bArr.length);
            C0849fg.m911d(str, sb.toString());
            if (i == 0) {
                break;
            }
            if (2 != i2) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[tcp_control]sendDataAsync() InterruptedException e: ");
                    sb2.append(e.toString());
                    C0849fg.m912e(str, sb2.toString());
                }
            }
            i2 = i3;
        }
        return i;
    }

    /* renamed from: cC */
    public boolean mo9521cC() {
        return this.f935nv.mo9510cC();
    }

    /* renamed from: cG */
    public int mo9522cG() {
        C0849fg.m914i("TmsTcpNetwork", "[tcp_control]close()");
        return this.f935nv.stop();
    }

    /* renamed from: cH */
    public int mo9523cH() {
        String str = "TmsTcpNetwork";
        C0849fg.m914i(str, "[tcp_control]connect()");
        int q = this.f935nv.mo9515q(this.f934nu);
        StringBuilder sb = new StringBuilder();
        sb.append("[ocean] connect |ret|");
        sb.append(q);
        C0849fg.m911d(str, sb.toString());
        return q;
    }

    /* renamed from: cI */
    public int mo9524cI() {
        int cx = this.f935nv.mo9513cx();
        StringBuilder sb = new StringBuilder();
        sb.append("[ocean] reconnect |ret|");
        sb.append(cx);
        C0849fg.m911d("TmsTcpNetwork", sb.toString());
        return cx;
    }

    /* renamed from: ck */
    public C0814ep mo9525ck() {
        return this.f935nv.mo9511ck();
    }

    /* renamed from: cw */
    public String mo9526cw() {
        return this.f935nv.mo9512cw();
    }

    /* renamed from: m */
    public boolean mo9527m() {
        return this.f935nv.mo9514m();
    }
}
