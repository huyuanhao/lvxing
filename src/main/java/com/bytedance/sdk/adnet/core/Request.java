package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.C1982p.C1983a;
import com.bytedance.sdk.adnet.err.AuthFailureError;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.p162e.ICache.C1994a;
import com.bytedance.sdk.adnet.p162e.IRetryPolicy;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Request<T> implements Comparable<Request<T>> {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;
    /* renamed from: a */
    protected C1983a<T> f6183a;
    /* renamed from: b */
    protected Handler f6184b;
    /* access modifiers changed from: private|final */
    /* renamed from: c */
    public final C1984a f6185c;
    /* renamed from: d */
    private final int f6186d;
    /* renamed from: e */
    private String f6187e;
    /* renamed from: f */
    private String f6188f;
    /* renamed from: g */
    private final int f6189g;
    /* renamed from: h */
    private final Object f6190h;
    /* renamed from: i */
    private Integer f6191i;
    /* renamed from: j */
    private RequestQueue f6192j;
    /* renamed from: k */
    private boolean f6193k;
    /* renamed from: l */
    private boolean f6194l;
    /* renamed from: m */
    private boolean f6195m;
    /* renamed from: n */
    private boolean f6196n;
    /* renamed from: o */
    private IRetryPolicy f6197o;
    /* renamed from: p */
    private C1994a f6198p;
    /* renamed from: q */
    private Object f6199q;
    /* renamed from: r */
    private long f6200r;
    /* renamed from: s */
    private long f6201s;
    /* renamed from: t */
    private boolean f6202t;
    /* renamed from: u */
    private String f6203u;
    /* renamed from: v */
    private Map<String, Object> f6204v;
    /* renamed from: w */
    private C1967a f6205w;

    /* renamed from: com.bytedance.sdk.adnet.core.Request$a */
    interface C1967a {
        /* renamed from: a */
        void mo14304a(Request<?> request);

        /* renamed from: a */
        void mo14305a(Request<?> request, C1982p<?> pVar);
    }

    /* renamed from: com.bytedance.sdk.adnet.core.Request$b */
    public enum C1968b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    /* renamed from: a */
    public abstract C1982p<T> mo14188a(NetworkResponse lVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public VAdError mo14251a(VAdError vAdError) {
        return vAdError;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo14189a(long j, long j2) {
    }

    /* renamed from: a */
    public abstract void mo14190a(C1982p<T> pVar);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Map<String, String> mo14261c() throws AuthFailureError {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo14264d() {
        return "UTF-8";
    }

    @Deprecated
    public Request(String str, C1983a aVar) {
        this(-1, str, aVar);
    }

    public Request(int i, String str, C1983a aVar) {
        this.f6185c = C1984a.f6303a ? new C1984a() : null;
        this.f6188f = "VADNetAgent/0";
        this.f6190h = new Object();
        this.f6193k = true;
        this.f6194l = false;
        this.f6195m = false;
        this.f6196n = false;
        this.f6198p = null;
        this.f6200r = 0;
        this.f6201s = 0;
        this.f6202t = true;
        this.f6184b = new Handler(Looper.getMainLooper());
        this.f6186d = i;
        this.f6187e = str;
        this.f6183a = aVar;
        setRetryPolicy(new DefaultRetryPolicy());
        this.f6189g = m7794b(str);
    }

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.f6204v == null) {
                this.f6204v = new HashMap();
            }
            this.f6204v.put(str, obj);
        }
        return this;
    }

    public Map<String, Object> getExtra() {
        return this.f6204v;
    }

    public long getStartTime() {
        return this.f6200r;
    }

    public void setStartTime() {
        this.f6200r = SystemClock.elapsedRealtime();
    }

    public long getNetDuration() {
        return this.f6201s;
    }

    public void setNetDuration(long j) {
        this.f6201s = j;
    }

    public boolean isResponseOnMain() {
        return this.f6202t;
    }

    public Request<?> setResponseOnMain(boolean z) {
        this.f6202t = z;
        return this;
    }

    public int getMethod() {
        return this.f6186d;
    }

    public Request<?> setTag(Object obj) {
        this.f6199q = obj;
        return this;
    }

    public Object getTag() {
        return this.f6199q;
    }

    public C1983a getBaseListener() {
        C1983a<T> aVar;
        synchronized (this.f6190h) {
            aVar = this.f6183a;
        }
        return aVar;
    }

    public int getTrafficStatsTag() {
        return this.f6189g;
    }

    /* renamed from: b */
    private static int m7794b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    String host = parse.getHost();
                    if (host != null) {
                        return host.hashCode();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public Request<?> setRetryPolicy(IRetryPolicy eVar) {
        this.f6197o = eVar;
        return this;
    }

    public void addMarker(String str) {
        if (C1984a.f6303a) {
            this.f6185c.mo14377a(str, Thread.currentThread().getId());
        }
    }

    public String getUserAgent() {
        return this.f6188f;
    }

    public Request<?> setUserAgent(String str) {
        this.f6188f = str;
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14255a(final String str) {
        RequestQueue oVar = this.f6192j;
        if (oVar != null) {
            oVar.mo14367c(this);
        }
        if (C1984a.f6303a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f6184b.post(new Runnable() {
                    public void run() {
                        Request.this.f6185c.mo14377a(str, id);
                        Request.this.f6185c.mo14376a(Request.this.toString());
                    }
                });
            } else {
                this.f6185c.mo14377a(str, id);
                this.f6185c.mo14376a(toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14253a(int i) {
        RequestQueue oVar = this.f6192j;
        if (oVar != null) {
            oVar.mo14363a(this, i);
        }
    }

    public Request<?> setRequestQueue(RequestQueue oVar) {
        this.f6192j = oVar;
        return this;
    }

    public final Request<?> setSequence(int i) {
        this.f6191i = Integer.valueOf(i);
        return this;
    }

    public final RequestQueue getRequestQueue() {
        return this.f6192j;
    }

    public final int getSequence() {
        Integer num = this.f6191i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.f6187e;
    }

    public void setUrl(String str) {
        this.f6187e = str;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(method));
        sb.append('-');
        sb.append(url);
        return sb.toString();
    }

    public Request<?> setCacheEntry(C1994a aVar) {
        this.f6198p = aVar;
        return this;
    }

    public C1994a getCacheEntry() {
        return this.f6198p;
    }

    public void cancel() {
        synchronized (this.f6190h) {
            this.f6194l = true;
            this.f6183a = null;
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f6190h) {
            z = this.f6194l;
        }
        return z;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: a */
    public Map<String, String> mo14252a() throws AuthFailureError {
        return mo14261c();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: b */
    public String mo14258b() {
        return mo14264d();
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map a = mo14252a();
        if (a == null || a.size() <= 0) {
            return null;
        }
        return m7793a(a, mo14258b());
    }

    public String getBodyContentType() {
        StringBuilder sb = new StringBuilder();
        sb.append("application/x-www-form-urlencoded; charset=");
        sb.append(mo14264d());
        return sb.toString();
    }

    public byte[] getBody() throws AuthFailureError {
        Map c = mo14261c();
        if (c == null || c.size() <= 0) {
            return null;
        }
        return m7793a(c, mo14264d());
    }

    /* renamed from: a */
    private byte[] m7793a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[]{entry.getKey(), entry.getValue()}));
                }
                sb.append(URLEncoder.encode((String) entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Encoding not supported: ");
            sb2.append(str);
            throw new RuntimeException(sb2.toString(), e);
        }
    }

    public final Request<?> setShouldCache(boolean z) {
        this.f6193k = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.f6193k;
    }

    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.f6196n = z;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.f6196n;
    }

    public C1968b getPriority() {
        return C1968b.NORMAL;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().mo14329a();
    }

    public IRetryPolicy getRetryPolicy() {
        return this.f6197o;
    }

    public void markDelivered() {
        synchronized (this.f6190h) {
            this.f6195m = true;
        }
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.f6190h) {
            z = this.f6195m;
        }
        return z;
    }

    public void build(RequestQueue oVar) {
        if (oVar != null) {
            oVar.mo14361a(this);
        }
    }

    public void deliverError(C1982p<T> pVar) {
        C1983a<T> aVar;
        synchronized (this.f6190h) {
            aVar = this.f6183a;
        }
        if (aVar != null) {
            aVar.mo14172b(pVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo14254a(C1967a aVar) {
        synchronized (this.f6190h) {
            this.f6205w = aVar;
        }
    }

    public String getIpAddrStr() {
        return this.f6203u;
    }

    public void setIpAddrStr(String str) {
        this.f6203u = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo14259b(C1982p<?> pVar) {
        C1967a aVar;
        synchronized (this.f6190h) {
            aVar = this.f6205w;
        }
        if (aVar != null) {
            aVar.mo14305a(this, pVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo14266e() {
        C1967a aVar;
        synchronized (this.f6190h) {
            aVar = this.f6205w;
        }
        if (aVar != null) {
            aVar.mo14304a(this);
        }
    }

    public int compareTo(Request<T> request) {
        C1968b priority = getPriority();
        C1968b priority2 = request.getPriority();
        return priority == priority2 ? this.f6191i.intValue() - request.f6191i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        sb.append(Integer.toHexString(getTrafficStatsTag()));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(isCanceled() ? "[X] " : "[ ] ");
        sb3.append(getUrl());
        String str = " ";
        sb3.append(str);
        sb3.append(sb2);
        sb3.append(str);
        sb3.append(getPriority());
        sb3.append(str);
        sb3.append(this.f6191i);
        return sb3.toString();
    }
}
