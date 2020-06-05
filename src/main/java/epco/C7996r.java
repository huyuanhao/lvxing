package epco;

import java.util.Locale;

/* renamed from: epco.r */
public class C7996r {
    /* renamed from: a */
    private long f27191a;
    /* renamed from: b */
    private String f27192b;

    public C7996r(int i) {
        this.f27192b = String.valueOf(i);
    }

    public C7996r(long j) {
        this.f27191a = j;
    }

    public C7996r(String str) {
        this.f27192b = str;
    }

    public C7996r(boolean z) {
        this.f27192b = String.valueOf(z);
    }

    /* renamed from: a */
    public long mo38418a() {
        return this.f27191a;
    }

    /* renamed from: a */
    public String mo38419a(C8012z zVar, Locale locale) {
        if (this.f27192b == null) {
            this.f27192b = C8003u0.m34636a(this.f27191a, zVar, locale);
        }
        return this.f27192b;
    }

    /* renamed from: a */
    public void mo38420a(long j) {
        this.f27191a = j;
    }

    /* renamed from: a */
    public void mo38421a(String str) {
        this.f27192b = str;
    }

    /* renamed from: b */
    public String mo38422b() {
        return this.f27192b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceEntity{resourceId=");
        sb.append(this.f27191a);
        sb.append(", value='");
        sb.append(this.f27192b);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
