package com.bytedance.sdk.openadsdk.p190h;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import com.tencent.mid.sotrage.StorageInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Request */
/* renamed from: com.bytedance.sdk.openadsdk.h.i */
public class C2482i {
    /* renamed from: a */
    public final C2485c f8921a;
    /* renamed from: b */
    public final List<C2484b> f8922b;
    /* renamed from: c */
    public final C2483a f8923c;

    /* compiled from: Request */
    /* renamed from: com.bytedance.sdk.openadsdk.h.i$a */
    static final class C2483a {
        /* renamed from: a */
        final int f8924a;
        /* renamed from: b */
        final String f8925b;
        /* renamed from: c */
        final String f8926c;
        /* renamed from: d */
        final int f8927d;
        /* renamed from: e */
        final int f8928e;
        /* renamed from: f */
        final String f8929f;
        /* renamed from: g */
        final List<String> f8930g;

        private C2483a(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.f8924a = i;
            this.f8925b = str;
            this.f8926c = str2;
            this.f8927d = i2;
            this.f8928e = i3;
            this.f8929f = str3;
            this.f8930g = list;
        }

        /* renamed from: a */
        static C2483a m11682a(C2485c cVar, List<C2484b> list) throws C2486d {
            String str;
            int i;
            int i2;
            String str2;
            int indexOf = cVar.f8934b.indexOf("?");
            if (indexOf != -1) {
                ArrayList arrayList = new ArrayList();
                String[] split = cVar.f8934b.substring(indexOf + 1).split("&");
                int length = split.length;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    str = "=";
                    if (i3 >= length) {
                        break;
                    }
                    String[] split2 = split[i3].split(str);
                    if (split2.length == 2) {
                        if ("rk".equals(split2[0])) {
                            str4 = Uri.decode(split2[1]);
                        } else {
                            if ("k".equals(split2[0])) {
                                str5 = Uri.decode(split2[1]);
                            } else if (split2[0].startsWith("u")) {
                                arrayList.add(Uri.decode(split2[1]));
                            } else {
                                if ("f".equals(split2[0]) && C2479d.m11668b(split2[1]) == 1) {
                                    i4 = 1;
                                }
                            }
                        }
                    }
                    i3++;
                }
                if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("rawKey or key is empty, path: ");
                    sb.append(cVar.f8934b);
                    throw new C2486d(sb.toString());
                }
                if (list != null) {
                    int i5 = 0;
                    int i6 = 0;
                    for (C2484b bVar : list) {
                        if (bVar != null) {
                            if ("Range".equalsIgnoreCase(bVar.f8931a)) {
                                int indexOf2 = bVar.f8932b.indexOf(str);
                                String str6 = "Range format error, Range: ";
                                if (indexOf2 != -1) {
                                    if ("bytes".equalsIgnoreCase(bVar.f8932b.substring(0, indexOf2).trim())) {
                                        String substring = bVar.f8932b.substring(indexOf2 + 1);
                                        if (!substring.contains(StorageInterface.KEY_SPLITER)) {
                                            int indexOf3 = substring.indexOf("-");
                                            if (indexOf3 != -1) {
                                                String trim = substring.substring(0, indexOf3).trim();
                                                String trim2 = substring.substring(indexOf3 + 1).trim();
                                                try {
                                                    if (trim.length() > 0) {
                                                        i5 = Integer.parseInt(trim);
                                                    }
                                                    if (trim2.length() > 0) {
                                                        i6 = Integer.parseInt(trim2);
                                                        if (i5 > i6) {
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append(str6);
                                                            sb2.append(bVar.f8932b);
                                                            throw new C2486d(sb2.toString());
                                                        }
                                                    }
                                                    str3 = bVar.f8932b;
                                                } catch (NumberFormatException unused) {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(str6);
                                                    sb3.append(bVar.f8932b);
                                                    throw new C2486d(sb3.toString());
                                                }
                                            } else {
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(str6);
                                                sb4.append(bVar.f8932b);
                                                throw new C2486d(sb4.toString());
                                            }
                                        } else {
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(str6);
                                            sb5.append(bVar.f8932b);
                                            throw new C2486d(sb5.toString());
                                        }
                                    } else {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append(str6);
                                        sb6.append(bVar.f8932b);
                                        throw new C2486d(sb6.toString());
                                    }
                                } else {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(str6);
                                    sb7.append(bVar.f8932b);
                                    throw new C2486d(sb7.toString());
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    i2 = i5;
                    i = i6;
                    str2 = str3;
                } else {
                    str2 = null;
                    i = 0;
                    i2 = 0;
                }
                if (!arrayList.isEmpty()) {
                    C2483a aVar = new C2483a(i4, str4, str5, i2, i, str2, arrayList);
                    return aVar;
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("no url found: path: ");
                sb8.append(cVar.f8934b);
                throw new C2486d(sb8.toString());
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append("path format error, path: ");
            sb9.append(cVar.f8934b);
            throw new C2486d(sb9.toString());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Extra{flag=");
            sb.append(this.f8924a);
            sb.append(", rawKey='");
            sb.append(this.f8925b);
            sb.append('\'');
            sb.append(", key='");
            sb.append(this.f8926c);
            sb.append('\'');
            sb.append(", from=");
            sb.append(this.f8927d);
            sb.append(", to=");
            sb.append(this.f8928e);
            sb.append(", urls=");
            sb.append(this.f8930g);
            sb.append('}');
            return sb.toString();
        }
    }

    /* compiled from: Request */
    /* renamed from: com.bytedance.sdk.openadsdk.h.i$b */
    public static final class C2484b {
        /* renamed from: a */
        public final String f8931a;
        /* renamed from: b */
        public final String f8932b;

        public C2484b(String str, String str2) {
            this.f8931a = str;
            this.f8932b = str2;
        }

        /* renamed from: a */
        static C2484b m11683a(String str) throws C2486d {
            int indexOf = str.indexOf(":");
            String str2 = "request header format error, header: ";
            if (indexOf != -1) {
                String trim = str.substring(0, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim.length() != 0 && trim2.length() != 0) {
                    return new C2484b(trim, trim2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                throw new C2486d(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str);
            throw new C2486d(sb2.toString());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Header{name='");
            sb.append(this.f8931a);
            sb.append('\'');
            sb.append(", value='");
            sb.append(this.f8932b);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* compiled from: Request */
    /* renamed from: com.bytedance.sdk.openadsdk.h.i$c */
    static final class C2485c {
        /* renamed from: a */
        final String f8933a;
        /* renamed from: b */
        final String f8934b;
        /* renamed from: c */
        final String f8935c;

        private C2485c(String str, String str2, String str3) {
            this.f8933a = str;
            this.f8934b = str2;
            this.f8935c = str3;
        }

        /* renamed from: a */
        static C2485c m11684a(String str) throws C2486d {
            int indexOf = str.indexOf(32);
            String str2 = "request line format error, line: ";
            if (indexOf != -1) {
                int lastIndexOf = str.lastIndexOf(32);
                if (lastIndexOf > indexOf) {
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
                    String trim3 = str.substring(lastIndexOf + 1).trim();
                    if (trim.length() != 0 && trim2.length() != 0 && trim3.length() != 0) {
                        return new C2485c(trim, trim2, trim3);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    throw new C2486d(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str);
                throw new C2486d(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(str);
            throw new C2486d(sb3.toString());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RequestLine{method='");
            sb.append(this.f8933a);
            sb.append('\'');
            sb.append(", path='");
            sb.append(this.f8934b);
            sb.append('\'');
            sb.append(", version='");
            sb.append(this.f8935c);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    /* compiled from: Request */
    /* renamed from: com.bytedance.sdk.openadsdk.h.i$d */
    static final class C2486d extends Exception {
        C2486d(String str) {
            super(str);
        }
    }

    public C2482i(C2485c cVar, List<C2484b> list, C2483a aVar) {
        this.f8921a = cVar;
        this.f8922b = list;
        this.f8923c = aVar;
    }

    /* renamed from: a */
    public static C2482i m11679a(InputStream inputStream) throws IOException, C2486d {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C2479d.f8916a));
        ArrayList arrayList = new ArrayList();
        C2485c cVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (cVar == null) {
                cVar = C2485c.m11684a(trim);
            } else {
                arrayList.add(C2484b.m11683a(trim));
            }
        }
        if (cVar != null) {
            return new C2482i(cVar, arrayList, C2483a.m11682a(cVar, arrayList));
        }
        throw new C2486d("request line is null");
    }

    /* renamed from: a */
    static String m11680a(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = m11681a(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    /* renamed from: a */
    private static String m11681a(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        String str3 = "=";
        sb.append(str3);
        sb.append(Uri.encode(str));
        String str4 = "&";
        sb.append(str4);
        sb.append("k");
        sb.append(str3);
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(str4);
            sb.append("u");
            sb.append(i);
            sb.append(str3);
            sb.append(Uri.encode((String) list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{requestLine=");
        sb.append(this.f8921a);
        sb.append(", headers=");
        sb.append(this.f8922b);
        sb.append(", extra=");
        sb.append(this.f8923c);
        sb.append('}');
        return sb.toString();
    }
}
