package btmsdkobf;

import java.util.Map;

/* renamed from: btmsdkobf.fb */
public class C0843fb {
    /* renamed from: nX */
    private C0851fi f977nX;

    public C0843fb(String str) {
        if (C0652cl.m86E().getProductId() != 13) {
            StringBuilder sb = new StringBuilder();
            sb.append(C0652cl.m86E().getProductId());
            sb.append(str);
            str = sb.toString();
        }
        this.f977nX = new C0851fi(C0652cl.m85D(), str);
    }

    /* renamed from: cM */
    public static C0843fb m895cM() {
        return new C0843fb("tms_base");
    }

    public void clear() {
        this.f977nX.clear();
    }

    public Map<String, ?> getAll() {
        return this.f977nX.getAll();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.f977nX.getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return this.f977nX.getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.f977nX.getLong(str, j);
    }

    public String getString(String str, String str2) {
        return this.f977nX.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        this.f977nX.putBoolean(str, z);
    }

    public void putInt(String str, int i) {
        this.f977nX.putInt(str, i);
    }

    public void putLong(String str, long j) {
        this.f977nX.putLong(str, j);
    }

    public void putString(String str, String str2) {
        this.f977nX.putString(str, str2);
    }

    public void remove(String str) {
        this.f977nX.remove(str);
    }
}
