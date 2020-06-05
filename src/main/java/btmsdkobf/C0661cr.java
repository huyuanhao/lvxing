package btmsdkobf;

import android.os.Bundle;

/* renamed from: btmsdkobf.cr */
public class C0661cr {
    /* renamed from: gB */
    protected C0662a f446gB = null;

    /* renamed from: btmsdkobf.cr$a */
    public interface C0662a {
        /* renamed from: a */
        void mo9187a(Bundle bundle);

        /* renamed from: b */
        void mo9188b(Bundle bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9186a(int i, Bundle bundle) {
        C0662a aVar = this.f446gB;
        if (aVar == null) {
            return;
        }
        if (i == 1) {
            aVar.mo9187a(bundle);
        } else if (i == 2) {
            aVar.mo9188b(bundle);
        }
    }
}
