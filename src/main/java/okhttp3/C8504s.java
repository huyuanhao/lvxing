package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;
import okhttp3.internal.C8417c;

/* compiled from: Headers */
/* renamed from: okhttp3.s */
public final class C8504s {
    /* renamed from: a */
    private final String[] f28885a;

    /* compiled from: Headers */
    /* renamed from: okhttp3.s$a */
    public static final class C8505a {
        /* renamed from: a */
        final List<String> f28886a = new ArrayList(20);

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C8505a mo40541a(String str) {
            String str2 = ":";
            int indexOf = str.indexOf(str2, 1);
            if (indexOf != -1) {
                return mo40545b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            String str3 = "";
            if (str.startsWith(str2)) {
                return mo40545b(str3, str.substring(1));
            }
            return mo40545b(str3, str);
        }

        /* renamed from: a */
        public C8505a mo40542a(String str, String str2) {
            m36524d(str, str2);
            return mo40545b(str, str2);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C8505a mo40545b(String str, String str2) {
            this.f28886a.add(str);
            this.f28886a.add(str2.trim());
            return this;
        }

        /* renamed from: b */
        public C8505a mo40544b(String str) {
            int i = 0;
            while (i < this.f28886a.size()) {
                if (str.equalsIgnoreCase((String) this.f28886a.get(i))) {
                    this.f28886a.remove(i);
                    this.f28886a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: c */
        public C8505a mo40547c(String str, String str2) {
            m36524d(str, str2);
            mo40544b(str);
            mo40545b(str, str2);
            return this;
        }

        /* renamed from: d */
        private void m36524d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(C8417c.m36030a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
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
                            throw new IllegalArgumentException(C8417c.m36030a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2));
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

        /* renamed from: c */
        public String mo40546c(String str) {
            for (int size = this.f28886a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f28886a.get(size))) {
                    return (String) this.f28886a.get(size + 1);
                }
            }
            return null;
        }

        /* renamed from: a */
        public C8504s mo40543a() {
            return new C8504s(this);
        }
    }

    C8504s(C8505a aVar) {
        this.f28885a = (String[]) aVar.f28886a.toArray(new String[aVar.f28886a.size()]);
    }

    private C8504s(String[] strArr) {
        this.f28885a = strArr;
    }

    @Nullable
    /* renamed from: a */
    public String mo40533a(String str) {
        return m36515a(this.f28885a, str);
    }

    /* renamed from: a */
    public int mo40531a() {
        return this.f28885a.length / 2;
    }

    /* renamed from: a */
    public String mo40532a(int i) {
        return this.f28885a[i * 2];
    }

    /* renamed from: b */
    public String mo40534b(int i) {
        return this.f28885a[(i * 2) + 1];
    }

    /* renamed from: b */
    public List<String> mo40535b(String str) {
        int a = mo40531a();
        ArrayList arrayList = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(mo40532a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(mo40534b(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    public C8505a mo40536b() {
        C8505a aVar = new C8505a();
        Collections.addAll(aVar.f28886a, this.f28885a);
        return aVar;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C8504s) && Arrays.equals(((C8504s) obj).f28885a, this.f28885a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f28885a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a = mo40531a();
        for (int i = 0; i < a; i++) {
            sb.append(mo40532a(i));
            sb.append(": ");
            sb.append(mo40534b(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* renamed from: c */
    public Map<String, List<String>> mo40537c() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int a = mo40531a();
        for (int i = 0; i < a; i++) {
            String lowerCase = mo40532a(i).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(mo40534b(i));
        }
        return treeMap;
    }

    /* renamed from: a */
    private static String m36515a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C8504s m36516a(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        } else if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i = 0;
            while (i < strArr2.length) {
                if (strArr2[i] != null) {
                    strArr2[i] = strArr2[i].trim();
                    i++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            int i2 = 0;
            while (i2 < strArr2.length) {
                String str = strArr2[i2];
                String str2 = strArr2[i2 + 1];
                if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                    i2 += 2;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected header: ");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            return new C8504s(strArr2);
        } else {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
    }
}
