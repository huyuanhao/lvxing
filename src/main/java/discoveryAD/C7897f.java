package discoveryAD;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.IProRequestCallback;
import java.util.List;

/* renamed from: discoveryAD.f */
public class C7897f implements IProRequestCallback {
    /* renamed from: Dc */
    List<C7883Y> f26889Dc;
    /* renamed from: Ec */
    C7898a f26890Ec;
    final String TAG = "AdSharkCallBack";

    /* renamed from: discoveryAD.f$a */
    public interface C7898a {
        /* renamed from: a */
        void mo38154a(List<C7883Y> list, boolean z);
    }

    public C7897f(List<C7883Y> list, C7898a aVar) {
        this.f26889Dc = list;
        this.f26890Ec = aVar;
    }

    public void onCallback(int i, JceStruct jceStruct) {
        C7898a aVar;
        List<C7883Y> list;
        boolean z = false;
        String str = "resp==null";
        String str2 = "AdSharkCallBack";
        if (i == 0 && jceStruct != null) {
            aVar = this.f26890Ec;
            list = this.f26889Dc;
            z = true;
        } else {
            Log.m31487w(str2, str);
            aVar = this.f26890Ec;
            list = this.f26889Dc;
        }
        aVar.mo38154a(list, z);
    }
}
