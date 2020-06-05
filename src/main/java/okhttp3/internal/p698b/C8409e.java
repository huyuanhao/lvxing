package okhttp3.internal.p698b;

import com.tencent.mid.sotrage.StorageInterface;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import okhttp3.C8362ab;
import okhttp3.C8492l;
import okhttp3.C8493m;
import okhttp3.C8504s;
import okhttp3.C8504s.C8505a;
import okhttp3.C8506t;
import okhttp3.C8518z;
import okhttp3.internal.C8417c;
import org.slf4j.Marker;

/* compiled from: HttpHeaders */
/* renamed from: okhttp3.internal.b.e */
public final class C8409e {
    /* renamed from: a */
    private static final Pattern f28504a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* renamed from: a */
    public static long m35978a(C8362ab abVar) {
        return m35979a(abVar.mo40096g());
    }

    /* renamed from: a */
    public static long m35979a(C8504s sVar) {
        return m35977a(sVar.mo40533a("Content-Length"));
    }

    /* renamed from: a */
    private static long m35977a(String str) {
        long j = -1;
        if (str == null) {
            return -1;
        }
        try {
            j = Long.parseLong(str);
        } catch (NumberFormatException unused) {
        }
        return j;
    }

    /* renamed from: a */
    public static boolean m35982a(C8362ab abVar, C8504s sVar, C8518z zVar) {
        for (String str : m35989e(abVar)) {
            if (!C8417c.m36044a((Object) sVar.mo40535b(str), (Object) zVar.mo40647b(str))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m35984b(C8362ab abVar) {
        return m35985b(abVar.mo40096g());
    }

    /* renamed from: b */
    public static boolean m35985b(C8504s sVar) {
        return m35986c(sVar).contains(Marker.ANY_MARKER);
    }

    /* renamed from: e */
    private static Set<String> m35989e(C8362ab abVar) {
        return m35986c(abVar.mo40096g());
    }

    /* renamed from: c */
    public static Set<String> m35986c(C8504s sVar) {
        Set emptySet = Collections.emptySet();
        int a = sVar.mo40531a();
        Set set = emptySet;
        for (int i = 0; i < a; i++) {
            if ("Vary".equalsIgnoreCase(sVar.mo40532a(i))) {
                String b = sVar.mo40534b(i);
                if (set.isEmpty()) {
                    set = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(StorageInterface.KEY_SPLITER)) {
                    set.add(trim.trim());
                }
            }
        }
        return set;
    }

    /* renamed from: c */
    public static C8504s m35987c(C8362ab abVar) {
        return m35980a(abVar.mo40099j().mo40088a().mo40648c(), abVar.mo40096g());
    }

    /* renamed from: a */
    public static C8504s m35980a(C8504s sVar, C8504s sVar2) {
        Set c = m35986c(sVar2);
        if (c.isEmpty()) {
            return new C8505a().mo40543a();
        }
        C8505a aVar = new C8505a();
        int a = sVar.mo40531a();
        for (int i = 0; i < a; i++) {
            String a2 = sVar.mo40532a(i);
            if (c.contains(a2)) {
                aVar.mo40542a(a2, sVar.mo40534b(i));
            }
        }
        return aVar.mo40543a();
    }

    /* renamed from: a */
    public static void m35981a(C8493m mVar, C8506t tVar, C8504s sVar) {
        if (mVar != C8493m.f28864a) {
            List a = C8492l.m36451a(tVar, sVar);
            if (!a.isEmpty()) {
                mVar.mo40488a(tVar, a);
            }
        }
    }

    /* renamed from: d */
    public static boolean m35988d(C8362ab abVar) {
        if (abVar.mo40088a().mo40646b().equals("HEAD")) {
            return false;
        }
        int c = abVar.mo40091c();
        if (((c >= 100 && c < 200) || c == 204 || c == 304) && m35978a(abVar) == -1) {
            if ("chunked".equalsIgnoreCase(abVar.mo40089b("Transfer-Encoding"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static int m35976a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: a */
    public static int m35975a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: b */
    public static int m35983b(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            i = (int) parseLong;
            return i;
        } catch (NumberFormatException unused) {
        }
    }
}
