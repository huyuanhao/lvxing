package com.bytedance.sdk.p145a.p147b;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Headers */
/* renamed from: com.bytedance.sdk.a.b.u */
public final class C1935u {
    /* renamed from: a */
    private final String[] f5959a;

    /* compiled from: Headers */
    /* renamed from: com.bytedance.sdk.a.b.u$a */
    public static final class C1936a {
        /* renamed from: a */
        final List<String> f5960a = new ArrayList(20);

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C1936a mo14078a(String str) {
            String str2 = ":";
            int indexOf = str.indexOf(str2, 1);
            if (indexOf != -1) {
                return mo14082b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            String str3 = "";
            if (str.startsWith(str2)) {
                return mo14082b(str3, str.substring(1));
            }
            return mo14082b(str3, str);
        }

        /* renamed from: a */
        public C1936a mo14079a(String str, String str2) {
            m7529d(str, str2);
            return mo14082b(str, str2);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C1936a mo14082b(String str, String str2) {
            this.f5960a.add(str);
            this.f5960a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public C1936a mo14081b(String str) {
            int i = 0;
            while (i < this.f5960a.size()) {
                if (str.equalsIgnoreCase((String) this.f5960a.get(i))) {
                    this.f5960a.remove(i);
                    this.f5960a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C1936a mo14083c(String str, String str2) {
            m7529d(str, str2);
            mo14081b(str);
            mo14082b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m7529d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(C1876c.m6955a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i2 = 0;
                    while (i2 < length2) {
                        char charAt2 = str2.charAt(i2);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException(C1876c.m6955a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
                        }
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("value for name ");
                sb.append(str);
                sb.append(" == null");
                throw new NullPointerException(sb.toString());
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        /* renamed from: a */
        public C1935u mo14080a() {
            return new C1935u(this);
        }
    }

    C1935u(C1936a aVar) {
        this.f5959a = (String[]) aVar.f5960a.toArray(new String[aVar.f5960a.size()]);
    }

    /* renamed from: a */
    public String mo14071a(String str) {
        return m7522a(this.f5959a, str);
    }

    /* renamed from: a */
    public int mo14069a() {
        return this.f5959a.length / 2;
    }

    /* renamed from: a */
    public String mo14070a(int i) {
        return this.f5959a[i * 2];
    }

    /* renamed from: b */
    public String mo14073b(int i) {
        return this.f5959a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> mo14074b(String str) {
        int a = mo14069a();
        ArrayList arrayList = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(mo14070a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo14073b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public C1936a mo14072b() {
        C1936a aVar = new C1936a();
        Collections.addAll(aVar.f5960a, this.f5959a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C1935u) && Arrays.equals(((C1935u) obj).f5959a, this.f5959a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5959a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a = mo14069a();
        for (int i = 0; i < a; i++) {
            sb.append(mo14070a(i));
            sb.append(": ");
            sb.append(mo14073b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m7522a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
