package discoveryAD;

import com.tencent.p605ep.commonbase.api.Log;
import com.tencent.qqpim.discovery.internal.model.C7489d;
import com.tencent.qqpim.discovery.internal.protocol.C7522v;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: discoveryAD.wa */
class C7937wa extends Thread {
    /* renamed from: Jg */
    final /* synthetic */ ArrayList f26970Jg;

    C7937wa(ArrayList arrayList) {
        this.f26970Jg = arrayList;
    }

    public void run() {
        Iterator it = this.f26970Jg.iterator();
        while (it.hasNext()) {
            C7489d dVar = (C7489d) it.next();
            C7522v vVar = dVar.f25069xe.f25136ca;
            if (!(vVar == null || vVar.f25283Db == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("phase : ");
                sb.append(dVar.f25069xe.f25133W);
                Log.m31477d("ExtraReport", sb.toString());
                Iterator it2 = dVar.f25069xe.f25136ca.f25283Db.iterator();
                while (it2.hasNext()) {
                    C7941ya.m34359Q((String) it2.next());
                }
            }
        }
    }
}
