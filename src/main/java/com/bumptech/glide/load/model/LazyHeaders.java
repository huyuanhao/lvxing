package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.model.j */
public final class LazyHeaders implements Headers {
    /* renamed from: c */
    private final Map<String, List<LazyHeaderFactory>> f4782c;
    /* renamed from: d */
    private volatile Map<String, String> f4783d;

    /* compiled from: LazyHeaders */
    /* renamed from: com.bumptech.glide.load.model.j$a */
    public static final class C1721a {
        /* renamed from: a */
        private static final String f4784a = m5873b();
        /* renamed from: b */
        private static final Map<String, List<LazyHeaderFactory>> f4785b;
        /* renamed from: c */
        private boolean f4786c = true;
        /* renamed from: d */
        private Map<String, List<LazyHeaderFactory>> f4787d = f4785b;
        /* renamed from: e */
        private boolean f4788e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f4784a)) {
                hashMap.put("User-Agent", Collections.singletonList(new C1722b(f4784a)));
            }
            f4785b = Collections.unmodifiableMap(hashMap);
        }

        /* renamed from: a */
        public LazyHeaders mo12967a() {
            this.f4786c = true;
            return new LazyHeaders(this.f4787d);
        }

        /* renamed from: b */
        static String m5873b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: LazyHeaders */
    /* renamed from: com.bumptech.glide.load.model.j$b */
    static final class C1722b implements LazyHeaderFactory {
        /* renamed from: a */
        private final String f4789a;

        C1722b(String str) {
            this.f4789a = str;
        }

        /* renamed from: a */
        public String mo12963a() {
            return this.f4789a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.f4789a);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1722b)) {
                return false;
            }
            return this.f4789a.equals(((C1722b) obj).f4789a);
        }

        public int hashCode() {
            return this.f4789a.hashCode();
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f4782c = Collections.unmodifiableMap(map);
    }

    /* renamed from: a */
    public Map<String, String> mo12962a() {
        if (this.f4783d == null) {
            synchronized (this) {
                if (this.f4783d == null) {
                    this.f4783d = Collections.unmodifiableMap(m5871b());
                }
            }
        }
        return this.f4783d;
    }

    /* renamed from: b */
    private Map<String, String> m5871b() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f4782c.entrySet()) {
            String a = m5870a((List) entry.getValue());
            if (!TextUtils.isEmpty(a)) {
                hashMap.put(entry.getKey(), a);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private String m5870a(List<LazyHeaderFactory> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a = ((LazyHeaderFactory) list.get(i)).mo12963a();
            if (!TextUtils.isEmpty(a)) {
                sb.append(a);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.f4782c);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LazyHeaders)) {
            return false;
        }
        return this.f4782c.equals(((LazyHeaders) obj).f4782c);
    }

    public int hashCode() {
        return this.f4782c.hashCode();
    }
}
