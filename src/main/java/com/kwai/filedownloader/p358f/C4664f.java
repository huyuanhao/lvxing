package com.kwai.filedownloader.p358f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.kwai.filedownloader.download.C4629b;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p356d.C4621c;
import com.kwai.filedownloader.p357e.C4641a;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.kwai.filedownloader.f.f */
public class C4664f {
    /* renamed from: a */
    private static int f15188a = 65536;
    /* renamed from: b */
    private static long f15189b = 2000;
    /* renamed from: c */
    private static String f15190c;
    /* renamed from: d */
    private static Boolean f15191d;
    /* renamed from: e */
    private static Boolean f15192e;
    /* renamed from: f */
    private static final Pattern f15193f = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: a */
    public static int m19129a() {
        return f15188a;
    }

    /* renamed from: a */
    public static int m19130a(String str, String str2, boolean z) {
        return C4629b.m18995a().mo25143b().mo25219a(str, str2, z);
    }

    /* renamed from: a */
    public static String m19131a(int i, C4589b bVar) {
        if (bVar != null) {
            String a = bVar.mo22740a("Etag");
            if (C4660d.f15179a) {
                C4660d.m19123c(C4664f.class, "etag find %s for task(%d)", a, Integer.valueOf(i));
            }
            return a;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    /* renamed from: a */
    public static String m19132a(C4589b bVar, String str) {
        String g = m19158g(bVar.mo22740a("Content-Disposition"));
        if (TextUtils.isEmpty(g)) {
            g = m19151c(str);
        }
        return g.replaceAll("\\/", "_");
    }

    /* renamed from: a */
    public static String m19133a(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        } else if (str != null) {
            return m19135a("%s%s%s", str, File.separator, str2);
        } else {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
    }

    /* renamed from: a */
    public static String m19134a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (z) {
            if (str2 == null) {
                return null;
            }
            str = m19133a(str, str2);
        }
        return str;
    }

    /* renamed from: a */
    public static String m19135a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: a */
    public static void m19136a(int i) {
        if (m19142a(C4654c.m19105a())) {
            f15188a = i;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    /* renamed from: a */
    public static void m19137a(long j) {
        if (m19142a(C4654c.m19105a())) {
            f15189b = j;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    /* renamed from: a */
    public static boolean m19138a(int i, C4621c cVar) {
        return m19139a(i, cVar, (Boolean) null);
    }

    /* renamed from: a */
    public static boolean m19139a(int i, C4621c cVar, Boolean bool) {
        Class<C4664f> cls = C4664f.class;
        if (cVar == null) {
            if (C4660d.f15179a) {
                C4660d.m19123c(cls, "can't continue %d model == null", Integer.valueOf(i));
            }
            return false;
        } else if (cVar.mo25087e() != null) {
            return m19140a(i, cVar, cVar.mo25087e(), bool);
        } else {
            if (C4660d.f15179a) {
                C4660d.m19123c(cls, "can't continue %d temp path == null", Integer.valueOf(i));
            }
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m19140a(int i, C4621c cVar, String str, Boolean bool) {
        Class<C4664f> cls = C4664f.class;
        if (str != null) {
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long g = cVar.mo25089g();
                if (cVar.mo25096n() > 1 || g != 0) {
                    long h = cVar.mo25090h();
                    if (length < g || (h != -1 && (length > h || g >= h))) {
                        if (!C4660d.f15179a) {
                            return false;
                        }
                        C4660d.m19123c(cls, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i), Long.valueOf(length), Long.valueOf(g), Long.valueOf(h));
                        return false;
                    } else if (bool == null || bool.booleanValue() || h != length) {
                        return true;
                    } else {
                        if (!C4660d.f15179a) {
                            return false;
                        }
                        C4660d.m19123c(cls, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i));
                        return false;
                    }
                } else if (!C4660d.f15179a) {
                    return false;
                } else {
                    C4660d.m19123c(cls, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i));
                    return false;
                }
            } else if (!C4660d.f15179a) {
                return false;
            } else {
                C4660d.m19123c(cls, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                return false;
            }
        } else if (!C4660d.f15179a) {
            return false;
        } else {
            C4660d.m19123c(cls, "can't continue %d path = null", Integer.valueOf(i));
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m19141a(long j, long j2) {
        return j > ((long) m19129a()) && j2 > m19145b();
    }

    /* renamed from: a */
    public static boolean m19142a(Context context) {
        Class<C4664f> cls = C4664f.class;
        Boolean bool = f15191d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        if (!C4661e.m19127a().f15183d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                List runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    Iterator it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) it.next();
                        if (runningAppProcessInfo.pid == myPid) {
                            z = runningAppProcessInfo.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    C4660d.m19124d(cls, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                    return false;
                }
            } else {
                C4660d.m19124d(cls, "fail to get the activity manager!", new Object[0]);
                return false;
            }
        } else {
            z = true;
        }
        f15191d = Boolean.valueOf(z);
        return f15191d.booleanValue();
    }

    /* renamed from: a */
    public static boolean m19143a(String str) {
        return true;
    }

    /* renamed from: b */
    public static int m19144b(String str, String str2) {
        return C4629b.m18995a().mo25143b().mo25219a(str, str2, false);
    }

    /* renamed from: b */
    public static long m19145b() {
        return f15189b;
    }

    /* renamed from: b */
    public static long m19146b(int i, C4589b bVar) {
        long k = m19162k(bVar.mo22740a("Content-Length"));
        String a = bVar.mo22740a("Transfer-Encoding");
        if (k >= 0) {
            return k;
        }
        boolean z = a != null && a.equals("chunked");
        if (z) {
            return -1;
        }
        if (!C4661e.m19127a().f15182c) {
            throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
        } else if (!C4660d.f15179a) {
            return -1;
        } else {
            C4660d.m19123c(C4664f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i));
            return -1;
        }
    }

    /* renamed from: b */
    public static String m19147b(String str) {
        return m19133a(m19150c(), m19151c(str));
    }

    /* renamed from: b */
    public static void m19148b(Context context) {
        File c = m19149c(context);
        try {
            c.getParentFile().mkdirs();
            c.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static File m19149c(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("filedownloader");
        return new File(sb.toString(), ".old_file_converted");
    }

    /* renamed from: c */
    public static String m19150c() {
        if (!TextUtils.isEmpty(f15190c)) {
            return f15190c;
        }
        return (C4654c.m19105a().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : C4654c.m19105a().getExternalCacheDir()).getAbsolutePath();
    }

    /* renamed from: c */
    public static String m19151c(String str) {
        return m19156e(str);
    }

    /* renamed from: c */
    public static void m19152c(String str, String str2) {
        m19164m(str2);
        m19165n(str);
    }

    /* renamed from: d */
    public static String m19153d(String str) {
        return m19135a("%s.temp", str);
    }

    /* renamed from: d */
    public static boolean m19154d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C4654c.m19105a().getSystemService("connectivity");
        boolean z = false;
        if (connectivityManager == null) {
            C4660d.m19124d(C4664f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public static String m19155e() {
        return m19135a("FileDownloader/%s", "2.6.5.2");
    }

    /* renamed from: e */
    public static String m19156e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                byte b2 = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    /* renamed from: f */
    public static long m19157f(String str) {
        StatFs statFs = new StatFs(str);
        return VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: g */
    public static String m19158g(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = f15193f.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    /* renamed from: h */
    public static String m19159h(String str) {
        int length = str.length();
        int i = 2;
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i2 <= 0) {
            i = lastIndexOf;
        }
        if (i == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        return (str.indexOf(File.separatorChar) == i && str.charAt(i2) == File.separatorChar) ? str.substring(0, i + 1) : str.substring(0, i);
    }

    /* renamed from: i */
    public static String m19160i(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDownloader-");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: j */
    public static boolean m19161j(String str) {
        return C4654c.m19105a().checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: k */
    public static long m19162k(String str) {
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

    /* renamed from: l */
    public static C4641a m19163l(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        } else if (m19143a(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(m19135a("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (file.exists() || file.createNewFile()) {
                return C4629b.m18995a().mo25141a(file);
            }
            throw new IOException(m19135a("create new file error  %s", file.getAbsolutePath()));
        } else {
            throw new RuntimeException(m19135a("found invalid internal destination filename %s", str));
        }
    }

    /* renamed from: m */
    public static void m19164m(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* renamed from: n */
    public static void m19165n(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
