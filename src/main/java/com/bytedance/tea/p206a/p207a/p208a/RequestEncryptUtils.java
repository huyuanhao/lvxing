package com.bytedance.tea.p206a.p207a.p208a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bytedance.tea.a.a.a.a */
public class RequestEncryptUtils {
    /* renamed from: a */
    private static C2570a f9198a = null;
    /* renamed from: b */
    private static boolean f9199b = false;

    /* compiled from: RequestEncryptUtils */
    /* renamed from: com.bytedance.tea.a.a.a.a$a */
    public interface C2570a {
        /* renamed from: a */
        boolean mo16954a();

        /* renamed from: b */
        boolean mo16955b();

        /* renamed from: c */
        boolean mo16956c();
    }

    /* renamed from: a */
    public static String m12264a(String str, List<Pair<String, String>> list) {
        String str2 = "UTF-8";
        if (TextUtils.isEmpty(str) || f9198a == null || f9199b) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri parse = Uri.parse(str);
            m12266a(parse, (Map<String, List<String>>) linkedHashMap);
            LinkedList linkedList = new LinkedList();
            m12267a((Map<String, List<String>>) linkedHashMap, (List<Pair<String, List<String>>>) linkedList, "device_id");
            m12267a((Map<String, List<String>>) linkedHashMap, (List<Pair<String, List<String>>>) linkedList, "device_type");
            m12267a((Map<String, List<String>>) linkedHashMap, (List<Pair<String, List<String>>>) linkedList, "device_brand");
            m12267a((Map<String, List<String>>) linkedHashMap, (List<Pair<String, List<String>>>) linkedList, "uuid");
            m12267a((Map<String, List<String>>) linkedHashMap, (List<Pair<String, List<String>>>) linkedList, "openudid");
            String a = m12265a((List<Pair<String, List<String>>>) linkedList, false, str2);
            if (TextUtils.isEmpty(a)) {
                return str;
            }
            byte[] bytes = a.getBytes();
            byte[] a2 = TTEncryptUtils.m6552a(bytes, bytes.length);
            if (a2 == null) {
                return str;
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            LinkedList linkedList2 = new LinkedList();
            if (f9198a.mo16954a()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(encodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (f9198a.mo16955b() && list != null) {
                list.add(new Pair("X-SS-QUERIES", m12263a(encodeToString, str2)));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return m12262a(parse.getScheme(), parse.getHost(), parse.getPort(), parse.getPath(), m12265a((List<Pair<String, List<String>>>) linkedList2, true, str2), parse.getFragment()).toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    /* renamed from: a */
    private static boolean m12267a(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair(str, map.get(str)));
        if (!f9198a.mo16956c()) {
            map.remove(str);
        }
        return true;
    }

    /* renamed from: a */
    public static void m12266a(Uri uri, Map<String, List<String>> map) throws IOException {
        String[] split;
        String str = "parseUrl url is null !!!";
        if (uri == null) {
            throw new IOException(str);
        } else if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str2 : query.split("&")) {
                        int indexOf = str2.indexOf("=");
                        String str3 = "UTF-8";
                        if (indexOf >= 0) {
                            String decode = URLDecoder.decode(str2.substring(0, indexOf), str3);
                            List list = (List) map.get(decode);
                            if (list == null) {
                                list = new LinkedList();
                            }
                            list.add(URLDecoder.decode(str2.substring(indexOf + 1), str3));
                            map.put(decode, list);
                        } else {
                            String decode2 = URLDecoder.decode(str2, str3);
                            List list2 = (List) map.get(decode2);
                            if (list2 == null) {
                                list2 = new LinkedList();
                            }
                            list2.add("");
                            map.put(decode2, list2);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                throw new IOException(str);
            }
        }
    }

    /* renamed from: a */
    private static Uri m12262a(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    /* renamed from: a */
    private static String m12265a(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            String str2 = (String) pair.first;
            if (z) {
                str2 = m12263a((String) pair.first, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String str3 : list2) {
                    if (z) {
                        str3 = str3 != null ? m12263a(str3, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m12263a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
