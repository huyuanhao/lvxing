package btmsdkobf;

import java.io.Serializable;
import java.util.List;

/* renamed from: btmsdkobf.el */
public class C0806el implements Serializable {
    /* renamed from: mU */
    private List<Long> f902mU;

    /* renamed from: b */
    public boolean mo9488b(int i, long j) {
        boolean z = true;
        if (!C0716dx.m444u(i) && !C0716dx.m446v(i)) {
            List<Long> list = this.f902mU;
            if (list != null) {
                z = list.contains(Long.valueOf(j));
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[shark_vip] request not allow currently, cmd: ");
                    sb.append(i);
                    sb.append(" ident: ");
                    sb.append(j);
                    sb.append(" mVipIdents: ");
                    sb.append(this.f902mU);
                    C0849fg.m914i("VipRule", sb.toString());
                }
            }
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mVipIdents|");
        sb.append(this.f902mU);
        return sb.toString();
    }
}
