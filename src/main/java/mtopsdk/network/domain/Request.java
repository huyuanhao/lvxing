package mtopsdk.network.domain;

import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public final class Request {
    /* renamed from: a */
    public final String f28036a;
    /* renamed from: b */
    public final String f28037b;
    /* renamed from: c */
    public final Map<String, String> f28038c;
    /* renamed from: d */
    public final C8343b f28039d;
    /* renamed from: e */
    public final String f28040e;
    /* renamed from: f */
    public final int f28041f;
    /* renamed from: g */
    public final int f28042g;
    /* renamed from: h */
    public final int f28043h;
    @Deprecated
    /* renamed from: i */
    public final int f28044i;
    /* renamed from: j */
    public final String f28045j;
    /* renamed from: k */
    public final String f28046k;
    /* renamed from: l */
    public final String f28047l;
    /* renamed from: m */
    public final int f28048m;
    /* renamed from: n */
    public final Object f28049n;
    /* renamed from: o */
    public final String f28050o;

    /* renamed from: mtopsdk.network.domain.Request$Environment */
    public interface Environment {

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: mtopsdk.network.domain.Request$Environment$Definition */
        public @interface Definition {
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Request{ url=");
        sb.append(this.f28036a);
        sb.append(", method=");
        sb.append(this.f28037b);
        sb.append(", appKey=");
        sb.append(this.f28046k);
        sb.append(", authCode=");
        sb.append(this.f28047l);
        sb.append(", headers=");
        sb.append(this.f28038c);
        sb.append(", body=");
        sb.append(this.f28039d);
        sb.append(", seqNo=");
        sb.append(this.f28040e);
        sb.append(", connectTimeoutMills=");
        sb.append(this.f28041f);
        sb.append(", readTimeoutMills=");
        sb.append(this.f28042g);
        sb.append(", retryTimes=");
        sb.append(this.f28043h);
        sb.append(", bizId=");
        sb.append(!TextUtils.isEmpty(this.f28045j) ? this.f28045j : String.valueOf(this.f28044i));
        sb.append(", env=");
        sb.append(this.f28048m);
        sb.append(", reqContext=");
        sb.append(this.f28049n);
        sb.append(", api=");
        sb.append(this.f28050o);
        sb.append("}");
        return sb.toString();
    }
}
