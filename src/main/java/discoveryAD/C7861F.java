package discoveryAD;

import com.tencent.qqpim.discovery.IConch;
import java.util.ArrayList;
import java.util.List;

/* renamed from: discoveryAD.F */
public class C7861F {
    /* renamed from: nd */
    private final int f26746nd = -1;
    /* renamed from: od */
    private final int f26747od = 1;
    /* renamed from: pd */
    private final int f26748pd = 2;
    /* renamed from: qd */
    private IConch f26749qd;

    /* renamed from: nb */
    private List<Integer> m34207nb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(1));
        arrayList.add(Integer.valueOf(2));
        return arrayList;
    }

    /* renamed from: ob */
    private void m34208ob() {
        this.f26749qd.registerConchPush(m34207nb(), new C7860E(this));
    }

    /* renamed from: a */
    public void mo38130a(IConch iConch) {
        if (this.f26749qd == null) {
            this.f26749qd = iConch;
            m34208ob();
        }
    }
}
