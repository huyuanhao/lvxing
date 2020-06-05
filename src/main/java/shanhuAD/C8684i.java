package shanhuAD;

import com.tencent.p605ep.shanhuad.adpublic.adbuilder.RewardVideo.RVListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: shanhuAD.i */
public class C8684i {
    /* renamed from: Ok */
    private static C8684i f29546Ok;
    /* renamed from: Pk */
    private Map<String, RVListener> f29547Pk = new HashMap();

    private C8684i() {
    }

    public static synchronized C8684i getInstance() {
        C8684i iVar;
        synchronized (C8684i.class) {
            if (f29546Ok == null) {
                f29546Ok = new C8684i();
            }
            iVar = f29546Ok;
        }
        return iVar;
    }

    /* renamed from: R */
    public RVListener mo41446R(String str) {
        synchronized (this.f29547Pk) {
            if (str == null) {
                return null;
            }
            RVListener rVListener = (RVListener) this.f29547Pk.get(str);
            return rVListener;
        }
    }

    /* renamed from: S */
    public void mo41447S(String str) {
        synchronized (this.f29547Pk) {
            if (str != null) {
                this.f29547Pk.remove(str);
            }
        }
    }

    /* renamed from: a */
    public void mo41448a(String str, RVListener rVListener) {
        synchronized (this.f29547Pk) {
            if (rVListener != null) {
                this.f29547Pk.put(str, rVListener);
            }
        }
    }
}
