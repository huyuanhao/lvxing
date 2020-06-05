package com.bytedance.sdk.openadsdk.core.p170d;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.p167a.InteractionListener.C2204a;
import com.tencent.android.tpush.common.Constants;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import discoveryAD.C7880W.C7881a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.core.d.e */
public class ClickEventModel {
    /* renamed from: a */
    private final int[] f7337a;
    /* renamed from: b */
    private final int[] f7338b;
    /* renamed from: c */
    private final int[] f7339c;
    /* renamed from: d */
    private final int[] f7340d;
    /* renamed from: e */
    private final int f7341e;
    /* renamed from: f */
    private final int f7342f;
    /* renamed from: g */
    private final int f7343g;
    /* renamed from: h */
    private final int f7344h;
    /* renamed from: i */
    private final long f7345i;
    /* renamed from: j */
    private final long f7346j;
    /* renamed from: k */
    private final int f7347k;
    /* renamed from: l */
    private final int f7348l;
    /* renamed from: m */
    private final int f7349m;
    /* renamed from: n */
    private final int f7350n;
    /* renamed from: o */
    private SparseArray<C2204a> f7351o;

    /* compiled from: ClickEventModel */
    /* renamed from: com.bytedance.sdk.openadsdk.core.d.e$a */
    public static class C2224a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public long f7352a;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public long f7353b;
        /* access modifiers changed from: private */
        /* renamed from: c */
        public int f7354c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public int f7355d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public int f7356e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public int f7357f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public int[] f7358g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public int[] f7359h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public int[] f7360i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public int[] f7361j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public int f7362k;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public int f7363l;
        /* access modifiers changed from: private */
        /* renamed from: m */
        public int f7364m;
        /* access modifiers changed from: private */
        /* renamed from: n */
        public SparseArray<C2204a> f7365n;
        /* access modifiers changed from: private */
        /* renamed from: o */
        public int f7366o;

        /* renamed from: a */
        public C2224a mo15360a(int i) {
            this.f7366o = i;
            return this;
        }

        /* renamed from: a */
        public C2224a mo15362a(SparseArray<C2204a> sparseArray) {
            this.f7365n = sparseArray;
            return this;
        }

        /* renamed from: a */
        public C2224a mo15361a(long j) {
            this.f7352a = j;
            return this;
        }

        /* renamed from: b */
        public C2224a mo15366b(long j) {
            this.f7353b = j;
            return this;
        }

        /* renamed from: b */
        public C2224a mo15365b(int i) {
            this.f7354c = i;
            return this;
        }

        /* renamed from: c */
        public C2224a mo15368c(int i) {
            this.f7355d = i;
            return this;
        }

        /* renamed from: d */
        public C2224a mo15370d(int i) {
            this.f7356e = i;
            return this;
        }

        /* renamed from: e */
        public C2224a mo15372e(int i) {
            this.f7357f = i;
            return this;
        }

        /* renamed from: a */
        public C2224a mo15363a(int[] iArr) {
            this.f7358g = iArr;
            return this;
        }

        /* renamed from: b */
        public C2224a mo15367b(int[] iArr) {
            this.f7359h = iArr;
            return this;
        }

        /* renamed from: c */
        public C2224a mo15369c(int[] iArr) {
            this.f7360i = iArr;
            return this;
        }

        /* renamed from: d */
        public C2224a mo15371d(int[] iArr) {
            this.f7361j = iArr;
            return this;
        }

        /* renamed from: f */
        public C2224a mo15373f(int i) {
            this.f7362k = i;
            return this;
        }

        /* renamed from: g */
        public C2224a mo15374g(int i) {
            this.f7363l = i;
            return this;
        }

        /* renamed from: h */
        public C2224a mo15375h(int i) {
            this.f7364m = i;
            return this;
        }

        /* renamed from: a */
        public ClickEventModel mo15364a() {
            return new ClickEventModel(this);
        }
    }

    private ClickEventModel(C2224a aVar) {
        this.f7337a = aVar.f7359h;
        this.f7338b = aVar.f7360i;
        this.f7340d = aVar.f7361j;
        this.f7339c = aVar.f7358g;
        this.f7341e = aVar.f7357f;
        this.f7342f = aVar.f7356e;
        this.f7343g = aVar.f7355d;
        this.f7344h = aVar.f7354c;
        this.f7345i = aVar.f7353b;
        this.f7346j = aVar.f7352a;
        this.f7347k = aVar.f7362k;
        this.f7348l = aVar.f7363l;
        this.f7349m = aVar.f7364m;
        this.f7350n = aVar.f7366o;
        this.f7351o = aVar.f7365n;
    }

    /* renamed from: a */
    public JSONObject mo15359a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f7337a != null && this.f7337a.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(this.f7337a[0])).putOpt("ad_y", Integer.valueOf(this.f7337a[1]));
            }
            if (this.f7338b != null && this.f7338b.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(this.f7338b[0])).putOpt("height", Integer.valueOf(this.f7338b[1]));
            }
            if (this.f7339c != null && this.f7339c.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(this.f7339c[0])).putOpt("button_y", Integer.valueOf(this.f7339c[1]));
            }
            if (this.f7340d != null && this.f7340d.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(this.f7340d[0])).putOpt("button_height", Integer.valueOf(this.f7340d[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.f7351o != null) {
                for (int i = 0; i < this.f7351o.size(); i++) {
                    C2204a aVar = (C2204a) this.f7351o.valueAt(i);
                    if (aVar != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt(ArgKey.KEY_FORCE, Double.valueOf(aVar.f7230c)).putOpt("mr", Double.valueOf(aVar.f7229b)).putOpt(C7881a.f26804fh, Integer.valueOf(aVar.f7228a)).putOpt("ts", Long.valueOf(aVar.f7231d));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.f7350n)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Integer.valueOf(this.f7341e)).putOpt("down_y", Integer.valueOf(this.f7342f)).putOpt("up_x", Integer.valueOf(this.f7343g)).putOpt("up_y", Integer.valueOf(this.f7344h)).putOpt("down_time", Long.valueOf(this.f7345i)).putOpt("up_time", Long.valueOf(this.f7346j)).putOpt("toolType", Integer.valueOf(this.f7347k)).putOpt(Constants.FLAG_DEVICE_ID, Integer.valueOf(this.f7348l)).putOpt(ArgKey.KEY_SOURCE, Integer.valueOf(this.f7349m)).putOpt("ft", jSONObject2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
