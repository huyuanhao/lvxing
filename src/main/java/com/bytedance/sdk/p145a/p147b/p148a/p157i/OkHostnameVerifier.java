package com.bytedance.sdk.p145a.p147b.p148a.p157i;

import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import org.slf4j.Marker;

/* renamed from: com.bytedance.sdk.a.b.a.i.e */
public final class OkHostnameVerifier implements HostnameVerifier {
    /* renamed from: a */
    public static final OkHostnameVerifier f5699a = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return mo13900a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo13900a(String str, X509Certificate x509Certificate) {
        if (C1876c.m6974c(str)) {
            return m7328b(str, x509Certificate);
        }
        return m7329c(str, x509Certificate);
    }

    /* renamed from: b */
    private boolean m7328b(String str, X509Certificate x509Certificate) {
        List a = m7327a(x509Certificate, 7);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase((String) a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m7329c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        List a = m7327a(x509Certificate, 2);
        int size = a.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (mo13899a(lowerCase, (String) a.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (!z) {
            String a2 = new DistinguishedNameParser(x509Certificate.getSubjectX500Principal()).mo13898a("cn");
            if (a2 != null) {
                return mo13899a(lowerCase, a2);
            }
        }
        return false;
    }

    /* renamed from: a */
    public static List<String> m7326a(X509Certificate x509Certificate) {
        List a = m7327a(x509Certificate, 7);
        List a2 = m7327a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m7327a(X509Certificate x509Certificate, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null) {
                    if (list.size() >= 2) {
                        Integer num = (Integer) list.get(0);
                        if (num != null) {
                            if (num.intValue() == i) {
                                String str = (String) list.get(1);
                                if (str != null) {
                                    arrayList.add(str);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    public boolean mo13899a(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            String str3 = ".";
            if (!str.startsWith(str3)) {
                String str4 = "..";
                if (!str.endsWith(str4) && str2 != null && str2.length() != 0 && !str2.startsWith(str3) && !str2.endsWith(str4)) {
                    if (!str.endsWith(str3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append('.');
                        str = sb.toString();
                    }
                    if (!str2.endsWith(str3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append('.');
                        str2 = sb2.toString();
                    }
                    String lowerCase = str2.toLowerCase(Locale.US);
                    if (!lowerCase.contains(Marker.ANY_MARKER)) {
                        return str.equals(lowerCase);
                    }
                    String str5 = "*.";
                    if (!lowerCase.startsWith(str5) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || str5.equals(lowerCase)) {
                        return false;
                    }
                    String substring = lowerCase.substring(1);
                    if (!str.endsWith(substring)) {
                        return false;
                    }
                    int length = str.length() - substring.length();
                    if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
