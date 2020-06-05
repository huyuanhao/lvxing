package discoveryAD;

import com.tencent.qqpim.discovery.DiscoverySdk;

/* renamed from: discoveryAD.G */
public class C7862G {
    /* renamed from: rd */
    private static C7862G f26750rd;
    /* renamed from: sd */
    private C7884Z f26751sd;
    /* renamed from: td */
    private C7882X f26752td;
    /* renamed from: ud */
    private C7894da f26753ud = new C7894da();

    private C7862G() {
        C7852Aa.m34156i("DbMgr()");
        C7889ba baVar = new C7889ba(DiscoverySdk.getInstance().getApplicationContext());
        this.f26751sd = new C7884Z(baVar);
        this.f26752td = new C7882X(baVar);
    }

    public static C7862G getInstance() {
        if (f26750rd == null) {
            synchronized (C7862G.class) {
                if (f26750rd == null) {
                    f26750rd = new C7862G();
                }
            }
        }
        return f26750rd;
    }

    /* renamed from: db */
    public C7882X mo38131db() {
        return this.f26752td;
    }

    /* renamed from: eb */
    public C7884Z mo38132eb() {
        return this.f26751sd;
    }

    /* renamed from: fb */
    public C7894da mo38133fb() {
        return this.f26753ud;
    }
}
