package com.bytedance.sdk.openadsdk.p190h.p197g;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.p190h.C2482i.C2484b;
import com.bytedance.sdk.openadsdk.p190h.Proxy;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoHttpHeaderInfo;
import com.bytedance.sdk.openadsdk.p190h.p192b.VideoProxyDB;
import com.bytedance.sdk.openadsdk.p190h.p195e.AbsResponseWrapper;
import com.bytedance.sdk.openadsdk.p190h.p195e.VideoRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: Util */
/* renamed from: com.bytedance.sdk.openadsdk.h.g.d */
public final class C2479d {
    /* renamed from: a */
    public static final Charset f8916a = Charset.forName("UTF-8");
    /* renamed from: b */
    private static final Handler f8917b = new Handler(Looper.getMainLooper());
    /* renamed from: c */
    private static final ExecutorService f8918c;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f8918c = threadPoolExecutor;
    }

    /* renamed from: a */
    public static void m11662a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11665a(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11666a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11663a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m11667a(String str) {
        return str != null && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* renamed from: b */
    public static int m11668b(String str) {
        return m11653a(str, 0);
    }

    /* renamed from: a */
    public static int m11653a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* renamed from: a */
    public static String m11657a(AbsResponseWrapper aVar, int i) {
        if (aVar == null || !aVar.mo16745b()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.mo16748e().toUpperCase());
        sb.append(' ');
        sb.append(aVar.mo16741a());
        sb.append(' ');
        sb.append(aVar.mo16749f());
        String str = "\r\n";
        sb.append(str);
        if (Proxy.f8836c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(aVar.mo16748e().toUpperCase());
            String str2 = " ";
            sb2.append(str2);
            sb2.append(aVar.mo16741a());
            sb2.append(str2);
            sb2.append(aVar.mo16749f());
            Log.i("TAG_PROXY_headers", sb2.toString());
        }
        List a = m11659a(aVar.mo16746c());
        boolean z = true;
        if (a != null) {
            int size = a.size();
            boolean z2 = true;
            for (int i2 = 0; i2 < size; i2++) {
                C2484b bVar = (C2484b) a.get(i2);
                if (bVar != null) {
                    String str3 = bVar.f8931a;
                    String str4 = bVar.f8932b;
                    sb.append(str3);
                    sb.append(": ");
                    sb.append(str4);
                    sb.append(str);
                    if ("Content-Range".equalsIgnoreCase(str3) || ("Accept-Ranges".equalsIgnoreCase(str3) && "bytes".equalsIgnoreCase(str4))) {
                        z2 = false;
                    }
                }
            }
            z = z2;
        }
        if (z) {
            int a2 = m11652a(aVar);
            if (a2 > 0) {
                sb.append("Content-Range: bytes ");
                sb.append(Math.max(i, 0));
                sb.append("-");
                sb.append(a2 - 1);
                sb.append("/");
                sb.append(a2);
                sb.append(str);
            }
        }
        sb.append("Connection: close");
        sb.append(str);
        sb.append(str);
        String sb3 = sb.toString();
        if (Proxy.f8836c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb3);
        }
        return sb3;
    }

    /* renamed from: a */
    public static String m11655a(int i, int i2) {
        String b = m11669b(i, i2);
        if (b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(b);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m11669b(int i, int i2) {
        String str = "-";
        if (i >= 0 && i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(str);
            sb.append(i2);
            return sb.toString();
        } else if (i > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(str);
            return sb2.toString();
        } else if (i >= 0 || i2 <= 0) {
            return null;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(i2);
            return sb3.toString();
        }
    }

    /* renamed from: a */
    public static List<String> m11661a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (m11667a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: a */
    public static String m11656a(VideoHttpHeaderInfo aVar, int i) {
        StringBuilder sb = new StringBuilder();
        String str = "\r\n";
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK");
            sb.append(str);
        } else {
            sb.append("HTTP/1.1 206 Partial Content");
            sb.append(str);
        }
        sb.append("Accept-Ranges: bytes");
        sb.append(str);
        sb.append("Content-Type: ");
        sb.append(aVar.f8789b);
        sb.append(str);
        String str2 = "Content-Length: ";
        if (i <= 0) {
            sb.append(str2);
            sb.append(aVar.f8790c);
            sb.append(str);
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i);
            sb.append("-");
            sb.append(aVar.f8790c - 1);
            sb.append("/");
            sb.append(aVar.f8790c);
            sb.append(str);
            sb.append(str2);
            sb.append(aVar.f8790c - i);
            sb.append(str);
        }
        sb.append("Connection: close");
        sb.append(str);
        sb.append(str);
        String sb2 = sb.toString();
        if (Proxy.f8836c) {
            Log.i("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    /* renamed from: a */
    public static int m11651a() {
        int i = 1;
        if (VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (file.exists()) {
                File[] listFiles = file.listFiles(new FilenameFilter() {
                    /* renamed from: a */
                    private Pattern f8919a = Pattern.compile("^cpu[0-9]+$");

                    public boolean accept(File file, String str) {
                        return this.f8919a.matcher(str).matches();
                    }
                });
                if (listFiles != null) {
                    i = Math.max(listFiles.length, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    /* renamed from: a */
    public static int m11652a(AbsResponseWrapper aVar) {
        if (aVar == null) {
            return -1;
        }
        if (aVar.mo16741a() == 200) {
            return m11653a(aVar.mo16744a("Content-Length", null), -1);
        }
        if (aVar.mo16741a() == 206) {
            String a = aVar.mo16744a("Content-Range", null);
            if (!TextUtils.isEmpty(a)) {
                int lastIndexOf = a.lastIndexOf("/");
                if (lastIndexOf >= 0 && lastIndexOf < a.length() - 1) {
                    return m11653a(a.substring(lastIndexOf + 1), -1);
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String m11658a(AbsResponseWrapper aVar, boolean z, boolean z2) {
        String str = "TAG_PROXY_Response";
        if (aVar == null) {
            String str2 = "response null";
            if (Proxy.f8836c) {
                Log.e(str, str2);
            }
            return str2;
        } else if (!aVar.mo16745b()) {
            String str3 = "response code: ";
            if (Proxy.f8836c) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(aVar.mo16741a());
                Log.e(str, sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(aVar.mo16741a());
            return sb2.toString();
        } else {
            String a = aVar.mo16744a("Content-Type", null);
            if (!m11674c(a)) {
                String str4 = "Content-Type: ";
                if (Proxy.f8836c) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str4);
                    sb3.append(a);
                    Log.e(str, sb3.toString());
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str4);
                sb4.append(a);
                return sb4.toString();
            }
            int a2 = m11652a(aVar);
            if (a2 <= 0) {
                String str5 = "Content-Length: ";
                if (Proxy.f8836c) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str5);
                    sb5.append(a2);
                    Log.e(str, sb5.toString());
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str5);
                sb6.append(a2);
                return sb6.toString();
            }
            if (z) {
                String a3 = aVar.mo16744a("Accept-Ranges", null);
                if (a3 == null || !a3.contains("bytes")) {
                    String str6 = "Accept-Ranges: ";
                    if (Proxy.f8836c) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(str6);
                        sb7.append(a3);
                        Log.e(str, sb7.toString());
                    }
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str6);
                    sb8.append(a3);
                    return sb8.toString();
                }
            }
            if (!z2 || aVar.mo16747d() != null) {
                return null;
            }
            String str7 = "response body null";
            if (Proxy.f8836c) {
                Log.e(str, str7);
            }
            return str7;
        }
    }

    /* renamed from: c */
    public static boolean m11674c(String str) {
        return str != null && (str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str));
    }

    /* renamed from: b */
    public static boolean m11673b() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* renamed from: a */
    public static void m11664a(Runnable runnable) {
        if (runnable != null) {
            String str = "TAG_PROXY_UTIL";
            if (m11673b()) {
                f8918c.execute(runnable);
                if (Proxy.f8836c) {
                    Log.e(str, "invoke in pool thread");
                    return;
                }
                return;
            }
            runnable.run();
            if (Proxy.f8836c) {
                Log.e(str, "invoke calling thread");
            }
        }
    }

    /* renamed from: b */
    public static void m11672b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (m11673b()) {
            runnable.run();
        } else {
            f8917b.post(runnable);
        }
    }

    /* renamed from: a */
    public static List<C2484b> m11659a(List<C2484b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String str = ": ";
        if (Proxy.f8836c) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C2484b bVar = (C2484b) list.get(i);
                if (bVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(bVar.f8931a);
                    sb.append(str);
                    sb.append(bVar.f8931a);
                    Log.i("TAG_PROXY_PRE_FILTER", sb.toString());
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (C2484b bVar2 : list) {
            if (!"Host".equals(bVar2.f8931a)) {
                if (!"Keep-Alive".equals(bVar2.f8931a)) {
                    if (!"Connection".equals(bVar2.f8931a)) {
                        if (!"Proxy-Connection".equals(bVar2.f8931a)) {
                        }
                    }
                }
            }
            arrayList.add(bVar2);
        }
        list.removeAll(arrayList);
        if (Proxy.f8836c) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                C2484b bVar3 = (C2484b) list.get(i2);
                if (bVar3 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(bVar3.f8931a);
                    sb2.append(str);
                    sb2.append(bVar3.f8932b);
                    Log.i("TAG_PROXY_POST_FILTER", sb2.toString());
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    public static List<C2484b> m11660a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Entry> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Entry entry : entrySet) {
                    arrayList.add(new C2484b((String) entry.getKey(), (String) entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static VideoHttpHeaderInfo m11654a(AbsResponseWrapper aVar, VideoProxyDB cVar, String str, int i) {
        String str2;
        String str3;
        String str4;
        VideoHttpHeaderInfo a = cVar.mo16710a(str, i);
        if (a == null) {
            int a2 = m11652a(aVar);
            String a3 = aVar.mo16744a("Content-Type", null);
            if (a2 > 0 && !TextUtils.isEmpty(a3)) {
                VideoRequest g = aVar.mo16750g();
                String str5 = "";
                if (g != null) {
                    str2 = g.f8850b;
                    str3 = m11671b(g.f8853e);
                } else {
                    str3 = str5;
                    str2 = str3;
                }
                String b = m11670b(aVar.mo16746c());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str2);
                    jSONObject.put("requestHeaders", str3);
                    jSONObject.put("responseHeaders", b);
                    str4 = jSONObject.toString();
                } catch (Throwable unused) {
                    str4 = str5;
                }
                VideoHttpHeaderInfo aVar2 = new VideoHttpHeaderInfo(str, a3, a2, i, str4);
                cVar.mo16712a(aVar2);
                return aVar2;
            }
        }
        return a;
    }

    /* renamed from: b */
    public static String m11670b(List<C2484b> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2484b bVar = (C2484b) list.get(0);
            if (bVar != null) {
                sb.append(bVar.f8931a);
                sb.append(": ");
                sb.append(bVar.f8932b);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m11671b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
