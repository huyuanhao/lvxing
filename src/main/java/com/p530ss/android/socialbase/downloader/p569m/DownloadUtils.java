package com.p530ss.android.socialbase.downloader.p569m;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.impls.DownloadProxy;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus;
import com.p530ss.android.socialbase.downloader.p559d.ITempFileSaveCompleteCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p560e.DownloadHttpException;
import com.p530ss.android.socialbase.downloader.p561f.C6704a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p562g.HttpHeader;
import com.p530ss.android.socialbase.downloader.p562g.RandomAccessOutputStream;
import com.p530ss.android.socialbase.downloader.p564i.IDownloadHeadHttpConnection;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.tencent.android.tpush.common.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.m.f */
public class DownloadUtils {
    /* renamed from: a */
    private static final String f22367a = DownloadUtils.class.getSimpleName();
    /* renamed from: b */
    private static final Pattern f22368b = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    /* renamed from: c */
    private static String f22369c = null;
    /* renamed from: d */
    private static volatile SparseArray<Boolean> f22370d = new SparseArray<>();
    /* renamed from: e */
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> f22371e = new SparseArray<>();
    /* renamed from: f */
    private static final char[] f22372f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: g */
    private static Pattern f22373g = null;
    /* renamed from: h */
    private static Pattern f22374h = null;
    /* renamed from: i */
    private static Boolean f22375i;
    /* renamed from: j */
    private static Boolean f22376j;

    /* renamed from: a */
    public static double m28747a(long j) {
        return ((double) j) / 1048576.0d;
    }

    /* renamed from: a */
    public static boolean m28770a(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    /* renamed from: b */
    public static boolean m28790b(int i) {
        return i == 206 || i == 200;
    }

    /* renamed from: b */
    public static boolean m28791b(long j) {
        return j == -1;
    }

    /* renamed from: a */
    public static String m28755a(byte[] bArr) {
        if (bArr != null) {
            return m28756a(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    /* renamed from: a */
    public static String m28756a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                byte b = bArr[i5 + i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                int i6 = i4 + 1;
                char[] cArr2 = f22372f;
                cArr[i4] = cArr2[b >> 4];
                i4 = i6 + 1;
                cArr[i6] = cArr2[b & 15];
            }
            return new String(cArr, 0, i3);
        }
    }

    /* renamed from: a */
    public static long m28748a(IDownloadHeadHttpConnection cVar) {
        long j = -1;
        if (cVar == null) {
            return -1;
        }
        String a = cVar.mo16500a("Content-Length");
        if (!TextUtils.isEmpty(a) || !DownloadExpSwitchCode.m28744a(1)) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException unused) {
            }
        } else {
            j = m28782b(cVar);
        }
        return j;
    }

    /* renamed from: b */
    public static long m28782b(IDownloadHeadHttpConnection cVar) {
        if (cVar == null) {
            return -1;
        }
        String a = cVar.mo16500a("Content-Range");
        if (TextUtils.isEmpty(a)) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(a);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e) {
            String str = f22367a;
            StringBuilder sb = new StringBuilder();
            sb.append("parse content-length from content-range failed ");
            sb.append(e);
            C6704a.m27761d(str, sb.toString());
        }
        return -1;
    }

    /* renamed from: a */
    public static long m28749a(String str) {
        long j = -1;
        if (str == null) {
            return -1;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                j = Long.parseLong(split[1]);
                return j;
            } catch (NumberFormatException unused) {
                String str2 = f22367a;
                StringBuilder sb = new StringBuilder();
                sb.append("parse instance length failed with ");
                sb.append(str);
                C6704a.m27761d(str2, sb.toString());
            }
        }
        return j;
    }

    /* renamed from: g */
    private static String m28816g(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (f22373g == null) {
                f22373g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            Matcher matcher = f22373g.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            if (f22374h == null) {
                f22374h = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
            }
            Matcher matcher2 = f22374h.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static String m28753a(IDownloadHeadHttpConnection cVar, String str) {
        String g = m28816g(cVar.mo16500a("Content-Disposition"));
        return TextUtils.isEmpty(g) ? m28806d(str) : g;
    }

    /* renamed from: a */
    public static RandomAccessOutputStream m28752a(String str, String str2, int i) throws BaseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new BaseException((int) PointerIconCompat.TYPE_GRABBING, (Throwable) new IOException("path must be not empty"));
        }
        File file = new File(str, str2);
        if (!file.exists() || !file.isDirectory()) {
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (file2.exists()) {
                            file2.delete();
                            throw new BaseException(1031, "download savePath is not directory");
                        } else if (!file2.mkdirs()) {
                            throw new BaseException(1030, "download savePath directory can not created");
                        }
                    }
                    file.createNewFile();
                } catch (IOException e) {
                    throw new BaseException(1036, (Throwable) e);
                }
            }
            return new RandomAccessOutputStream(file, i);
        }
        throw new BaseException(1035, (Throwable) new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{str, Boolean.valueOf(file.isDirectory())})));
    }

    /* renamed from: a */
    public static List<DownloadChunk> m28758a(List<DownloadChunk> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (DownloadChunk bVar : list) {
            if (bVar != null) {
                if (bVar.mo32125d()) {
                    sparseArray.put(bVar.mo32141s(), bVar);
                    List<DownloadChunk> list2 = (List) sparseArray2.get(bVar.mo32141s());
                    if (list2 != null) {
                        for (DownloadChunk a : list2) {
                            a.mo32114a(bVar);
                        }
                        bVar.mo32116a(list2);
                    }
                } else {
                    DownloadChunk bVar2 = (DownloadChunk) sparseArray.get(bVar.mo32118b());
                    if (bVar2 != null) {
                        List g = bVar2.mo32129g();
                        if (g == null) {
                            g = new ArrayList();
                            bVar2.mo32116a(g);
                        }
                        bVar.mo32114a(bVar2);
                        g.add(bVar);
                    } else {
                        List list3 = (List) sparseArray2.get(bVar.mo32118b());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(bVar.mo32118b(), list3);
                        }
                        list3.add(bVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    /* renamed from: a */
    public static String m28754a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", new Object[]{str, File.separator, str2});
    }

    /* renamed from: b */
    public static String m28785b(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        return str;
    }

    /* renamed from: b */
    public static String m28784b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.temp", new Object[]{str});
    }

    /* renamed from: b */
    public static long m28783b(List<DownloadChunk> list) {
        long j = 0;
        for (DownloadChunk o : list) {
            j += o.mo32137o();
        }
        return j;
    }

    /* renamed from: a */
    public static void m28763a(DownloadInfo cVar) {
        if (cVar != null) {
            m28800c(cVar.mo32297k(), cVar.mo32287h());
            m28800c(cVar.mo32300l(), cVar.mo32303m());
            if (cVar.mo32259be()) {
                m28787b(cVar);
            }
        }
    }

    /* renamed from: b */
    public static void m28787b(DownloadInfo cVar) {
        if (cVar != null) {
            JSONObject d = DownloadSetting.m28612a(cVar).mo32555d("anti_hijack_dir");
            if (d != null) {
                String optString = d.optString("install_desc");
                if (!TextUtils.isEmpty(optString)) {
                    m28800c(cVar.mo32297k(), optString);
                }
                m28818h(cVar.mo32297k());
            }
        }
    }

    /* renamed from: h */
    private static void m28818h(String str) {
        String str2 = f22367a;
        StringBuilder sb = new StringBuilder();
        sb.append("deleteDirIfEmpty on thread: ");
        sb.append(Thread.currentThread());
        Log.w(str2, sb.toString());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory() && !file.delete()) {
                Log.w(f22367a, "deleteDirIfEmpty return false");
            }
        }
    }

    /* renamed from: c */
    public static void m28800c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            if (file.exists()) {
                String str3 = f22367a;
                StringBuilder sb = new StringBuilder();
                sb.append("deleteFile: ");
                sb.append(str);
                sb.append("/");
                sb.append(str2);
                Log.e(str3, sb.toString());
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public static boolean m28774a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m28802c(DownloadInfo cVar) {
        return m28777a(cVar, cVar.mo32179Y(), cVar.mo32155A());
    }

    /* renamed from: a */
    public static boolean m28777a(DownloadInfo cVar, boolean z, String str) {
        if (!z && !TextUtils.isEmpty(cVar.mo32297k()) && !TextUtils.isEmpty(cVar.mo32287h())) {
            try {
                if (new File(cVar.mo32297k(), cVar.mo32287h()).exists() && m28751a(cVar.mo32297k(), cVar.mo32287h(), str) == Md5CheckStatus.VALID) {
                    return true;
                }
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public static Md5CheckStatus m28751a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return Md5CheckStatus.VALID;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return Md5CheckStatus.INVALID_FILE_NO_EXIST;
        }
        String a = DownloadDigestUtils.m28741a(file);
        if (TextUtils.isEmpty(a)) {
            return Md5CheckStatus.INVALID_FILE_MD5_EMPTY;
        }
        if (!a.equals(str3)) {
            return Md5CheckStatus.INVALID_MD5_NOT_EQUALS;
        }
        return Md5CheckStatus.VALID;
    }

    /* renamed from: a */
    private static Md5CheckStatus m28750a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return Md5CheckStatus.VALID;
        }
        String a = DownloadDigestUtils.m28741a(file);
        if (TextUtils.isEmpty(a)) {
            return Md5CheckStatus.INVALID_FILE_MD5_EMPTY;
        }
        if (!a.equals(str)) {
            return Md5CheckStatus.INVALID_MD5_NOT_EQUALS;
        }
        return Md5CheckStatus.VALID;
    }

    /* renamed from: c */
    public static long m28796c(String str) throws BaseException {
        try {
            StatFs statFs = new StatFs(str);
            if (VERSION.SDK_INT >= 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (IllegalArgumentException e) {
            throw new BaseException(1050, (Throwable) e);
        } catch (Throwable th) {
            throw new BaseException(1052, th);
        }
    }

    /* renamed from: a */
    public static void m28765a(DownloadInfo cVar, ITempFileSaveCompleteCallback fVar) {
        BaseException aVar;
        boolean z;
        String str = f22367a;
        StringBuilder sb = new StringBuilder();
        sb.append("saveFileAsTargetName targetName is ");
        sb.append(cVar.mo32305n());
        C6704a.m27758b(str, sb.toString());
        try {
            File file = new File(cVar.mo32300l(), cVar.mo32303m());
            File file2 = new File(cVar.mo32297k(), cVar.mo32287h());
            DownloadInfo h = Downloader.m27478a(C6694b.m27342B()).mo31928h(cVar.mo32283g());
            String str2 = "targetFile exist";
            if (!file.exists()) {
                C6704a.m27758b(f22367a, "tempFile not exist");
                if (file2.exists()) {
                    C6704a.m27758b(f22367a, str2);
                    if (cVar.mo32216aS() == Md5CheckStatus.VALID) {
                        C6704a.m27758b(f22367a, "tempFile not exist , targetFile exists and md5 check valid");
                        if (fVar != null) {
                            fVar.mo31757a();
                        }
                        return;
                    } else if (h != null && h.mo32213aP()) {
                        h.mo32189a(fVar);
                        return;
                    }
                } else {
                    C6704a.m27758b(f22367a, "targetFile not exist");
                    if (h != null && h.mo32213aP()) {
                        h.mo32189a(fVar);
                        return;
                    }
                }
            } else if (file2.exists()) {
                C6704a.m27758b(f22367a, str2);
                Md5CheckStatus aS = cVar.mo32216aS();
                if (aS == Md5CheckStatus.VALID) {
                    C6704a.m27758b(f22367a, "tempFile exist , targetFile exists and md5 check valid");
                    if (fVar != null) {
                        fVar.mo31757a();
                    }
                    return;
                } else if (h == null || !h.mo32213aP()) {
                    if (h != null) {
                        h.mo32299k(true);
                    }
                    String str3 = f22367a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("saveFileAsTargetName: ");
                    sb2.append(file2.getPath());
                    Log.e(str3, sb2.toString());
                    if (!file2.delete()) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("delete targetPath file existed with md5 check invalid status:");
                        sb3.append(aS.name());
                        sb3.append(" failed!");
                        BaseException aVar2 = new BaseException(1037, sb3.toString());
                        if (fVar != null) {
                            fVar.mo31758a(aVar2);
                        }
                        if (h != null) {
                            h.mo32195a(false, aVar2);
                        }
                        return;
                    }
                } else {
                    h.mo32189a(fVar);
                    return;
                }
            }
            if (h != null) {
                h.mo32299k(true);
            }
            try {
                z = !m28794b(file, file2);
                aVar = null;
            } catch (BaseException e) {
                aVar = e;
                z = false;
            }
            if (z) {
                if (aVar == null) {
                    aVar = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s), temp file is exist: %d", new Object[]{cVar.mo32300l(), cVar.mo32303m(), cVar.mo32297k(), cVar.mo32287h(), Boolean.valueOf(file.exists())}));
                }
                if (fVar != null) {
                    fVar.mo31758a(aVar);
                }
                if (h != null) {
                    h.mo32195a(false, aVar);
                }
            } else {
                if (fVar != null) {
                    fVar.mo31757a();
                }
                if (h != null) {
                    h.mo32195a(true, (BaseException) null);
                }
            }
        } catch (Throwable th) {
            String str4 = f22367a;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("saveFileAsTargetName throwable ");
            sb4.append(th.getMessage());
            C6704a.m27758b(str4, sb4.toString());
            if (fVar != null) {
                fVar.mo31758a(new BaseException(1038, m28786b(th, "saveFileAsTargetName")));
            }
        }
    }

    /* JADX INFO: used method not loaded: com.ss.android.socialbase.downloader.h.a.a(com.ss.android.socialbase.downloader.d.ae, com.ss.android.socialbase.downloader.g.c, com.ss.android.socialbase.downloader.e.a, int):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
            return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4 = new java.io.File(r17.mo32300l(), r17.mo32303m());
            r5 = new java.io.File(r17.mo32297k(), r17.mo32287h());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
            if (r5.exists() == false) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
            com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(f22367a, "targetFile exist");
            r6 = r17.mo32216aS();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bc, code lost:
            if (r6 != com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus.f21704a) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00be, code lost:
            com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(f22367a, "tempFile not exist , targetFile exists and md5 check valid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c5, code lost:
            if (r2 == null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c7, code lost:
            r19.mo31757a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ca, code lost:
            m28761a(r17.mo32283g(), true, (com.p530ss.android.socialbase.downloader.p560e.BaseException) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d7, code lost:
            if (r4.exists() != false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d9, code lost:
            r15 = new com.p530ss.android.socialbase.downloader.p560e.BaseException(1005, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new java.lang.Object[]{r17.mo32300l(), r17.mo32303m(), r17.mo32297k(), r17.mo32287h(), r6.name()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0104, code lost:
            if (r2 == null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0106, code lost:
            r2.mo31758a(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
            m28761a(r17.mo32283g(), false, r15);
            r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0112, code lost:
            r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0117, code lost:
            if (r5.delete() != false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0119, code lost:
            if (r3 != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011b, code lost:
            if (r0 == null) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011d, code lost:
            com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r0, r1, new com.p530ss.android.socialbase.downloader.p560e.BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r17.mo32308q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x012e, code lost:
            r11 = new java.lang.StringBuilder();
            r11.append("delete targetPath file existed with md5 check invalid status:");
            r11.append(r6.name());
            r11.append(" failed!");
            r3 = new com.p530ss.android.socialbase.downloader.p560e.BaseException(1037, r11.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014f, code lost:
            if (r2 == null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0151, code lost:
            r2.mo31758a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0154, code lost:
            m28761a(r17.mo32283g(), false, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0160, code lost:
            if (r4.exists() != false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0162, code lost:
            r3 = new com.p530ss.android.socialbase.downloader.p560e.BaseException(1005, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new java.lang.Object[]{r17.mo32300l(), r17.mo32303m(), r17.mo32297k(), r17.mo32287h()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0187, code lost:
            if (r2 == null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0189, code lost:
            r2.mo31758a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x018c, code lost:
            m28761a(r17.mo32283g(), false, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0193, code lost:
            r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0195, code lost:
            r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0196, code lost:
            if (r3 == false) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0198, code lost:
            r3 = m28750a(r4, r17.mo32155A());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a2, code lost:
            if (r3 == com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus.f21704a) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a4, code lost:
            r5 = new com.p530ss.android.socialbase.downloader.p560e.BaseException(1038, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile md5 is invalid : %s", new java.lang.Object[]{r17.mo32300l(), r17.mo32303m(), r17.mo32297k(), r17.mo32287h(), r3.name()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01d1, code lost:
            if (r2 == null) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01d3, code lost:
            r2.mo31758a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01d6, code lost:
            m28761a(r17.mo32283g(), false, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e1, code lost:
            if (r4.delete() != false) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e3, code lost:
            if (r0 == null) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e5, code lost:
            com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r0, r1, new com.p530ss.android.socialbase.downloader.p560e.BaseException(1038, "tempFile md5 is invalid ,but delete failed"), r17.mo32308q());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01fb, code lost:
            r0 = !m28794b(r4, r5);
            r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01fe, code lost:
            r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ff, code lost:
            r3 = r0;
            r0 = false;
     */
    /* renamed from: a */
    public static void m28764a(com.p530ss.android.socialbase.downloader.p562g.DownloadInfo r17, com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend r18, com.p530ss.android.socialbase.downloader.p559d.ITempFileSaveCompleteCallback r19) {
        /*
        r1 = r17
        r0 = r18
        r2 = r19
        java.lang.String r3 = f22367a
        java.lang.StringBuilder r4 = new java.lang.StringBuilder
        r4.<init>()
        java.lang.String r5 = "saveFileAsTargetName targetName is "
        r4.append(r5)
        java.lang.String r5 = r17.mo32305n()
        r4.append(r5)
        java.lang.String r4 = r4.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r3, r4)
        android.util.SparseArray<java.lang.Boolean> r4 = f22370d     // Catch:{ all -> 0x024a }
        monitor-enter(r4)     // Catch:{ all -> 0x024a }
        android.util.SparseArray<java.lang.Boolean> r5 = f22370d     // Catch:{ all -> 0x0247 }
        int r6 = r17.mo32283g()     // Catch:{ all -> 0x0247 }
        java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x0247 }
        java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0247 }
        r7 = 1
        r8 = 0
        if (r5 != r6) goto L_0x0035
        r5 = 1
        goto L_0x0036
    L_0x0035:
        r5 = 0
    L_0x0036:
        if (r5 == 0) goto L_0x0062
        java.lang.String r0 = f22367a     // Catch:{ all -> 0x0247 }
        java.lang.String r5 = "has another same task is saving temp file"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r0, r5)     // Catch:{ all -> 0x0247 }
        if (r2 == 0) goto L_0x0060
        android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.d.f>> r0 = f22371e     // Catch:{ all -> 0x0247 }
        int r5 = r17.mo32283g()     // Catch:{ all -> 0x0247 }
        java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0247 }
        java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0247 }
        if (r0 != 0) goto L_0x005d
        java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0247 }
        r0.<init>()     // Catch:{ all -> 0x0247 }
        android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.d.f>> r5 = f22371e     // Catch:{ all -> 0x0247 }
        int r1 = r17.mo32283g()     // Catch:{ all -> 0x0247 }
        r5.put(r1, r0)     // Catch:{ all -> 0x0247 }
    L_0x005d:
        r0.add(r2)     // Catch:{ all -> 0x0247 }
    L_0x0060:
        monitor-exit(r4)     // Catch:{ all -> 0x0247 }
        return
    L_0x0062:
        java.lang.String r5 = f22367a     // Catch:{ all -> 0x0247 }
        java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
        r6.<init>()     // Catch:{ all -> 0x0247 }
        java.lang.String r9 = "saveTempFileStatusMap put id:"
        r6.append(r9)     // Catch:{ all -> 0x0247 }
        int r9 = r17.mo32283g()     // Catch:{ all -> 0x0247 }
        r6.append(r9)     // Catch:{ all -> 0x0247 }
        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0247 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r5, r6)     // Catch:{ all -> 0x0247 }
        android.util.SparseArray<java.lang.Boolean> r5 = f22370d     // Catch:{ all -> 0x0247 }
        int r6 = r17.mo32283g()     // Catch:{ all -> 0x0247 }
        java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0247 }
        r5.put(r6, r9)     // Catch:{ all -> 0x0247 }
        monitor-exit(r4)     // Catch:{ all -> 0x0247 }
        java.io.File r4 = new java.io.File     // Catch:{ all -> 0x024a }
        java.lang.String r5 = r17.mo32300l()     // Catch:{ all -> 0x024a }
        java.lang.String r6 = r17.mo32303m()     // Catch:{ all -> 0x024a }
        r4.<init>(r5, r6)     // Catch:{ all -> 0x024a }
        java.io.File r5 = new java.io.File     // Catch:{ all -> 0x024a }
        java.lang.String r6 = r17.mo32297k()     // Catch:{ all -> 0x024a }
        java.lang.String r9 = r17.mo32287h()     // Catch:{ all -> 0x024a }
        r5.<init>(r6, r9)     // Catch:{ all -> 0x024a }
        boolean r6 = r5.exists()     // Catch:{ all -> 0x024a }
        r9 = 5
        r10 = 1005(0x3ed, float:1.408E-42)
        r11 = 0
        r12 = 3
        r13 = 2
        r14 = 4
        if (r6 == 0) goto L_0x015c
        java.lang.String r6 = f22367a     // Catch:{ all -> 0x024a }
        java.lang.String r15 = "targetFile exist"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r6, r15)     // Catch:{ all -> 0x024a }
        com.ss.android.socialbase.downloader.b.i r6 = r17.mo32216aS()     // Catch:{ all -> 0x024a }
        com.ss.android.socialbase.downloader.b.i r15 = com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus.VALID     // Catch:{ all -> 0x024a }
        if (r6 != r15) goto L_0x00d3
        java.lang.String r6 = f22367a     // Catch:{ all -> 0x024a }
        java.lang.String r10 = "tempFile not exist , targetFile exists and md5 check valid"
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r6, r10)     // Catch:{ all -> 0x024a }
        if (r2 == 0) goto L_0x00ca
        r19.mo31757a()     // Catch:{ all -> 0x024a }
    L_0x00ca:
        int r6 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r6, r7, r11)     // Catch:{ all -> 0x024a }
        goto L_0x0193
    L_0x00d3:
        boolean r15 = r4.exists()     // Catch:{ all -> 0x024a }
        if (r15 != 0) goto L_0x0112
        com.ss.android.socialbase.downloader.e.a r15 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r11 = "Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s"
        java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ all -> 0x024a }
        java.lang.String r16 = r17.mo32300l()     // Catch:{ all -> 0x024a }
        r3[r8] = r16     // Catch:{ all -> 0x024a }
        java.lang.String r16 = r17.mo32303m()     // Catch:{ all -> 0x024a }
        r3[r7] = r16     // Catch:{ all -> 0x024a }
        java.lang.String r16 = r17.mo32297k()     // Catch:{ all -> 0x024a }
        r3[r13] = r16     // Catch:{ all -> 0x024a }
        java.lang.String r16 = r17.mo32287h()     // Catch:{ all -> 0x024a }
        r3[r12] = r16     // Catch:{ all -> 0x024a }
        java.lang.String r16 = r6.name()     // Catch:{ all -> 0x024a }
        r3[r14] = r16     // Catch:{ all -> 0x024a }
        java.lang.String r3 = java.lang.String.format(r11, r3)     // Catch:{ all -> 0x024a }
        r15.m51543init(r10, r3)     // Catch:{ all -> 0x024a }
        if (r2 == 0) goto L_0x0109
        r2.mo31758a(r15)     // Catch:{ all -> 0x024a }
    L_0x0109:
        int r3 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r3, r8, r15)     // Catch:{ all -> 0x024a }
        r3 = 0
        goto L_0x0113
    L_0x0112:
        r3 = 1
    L_0x0113:
        boolean r10 = r5.delete()     // Catch:{ all -> 0x024a }
        if (r10 != 0) goto L_0x0196
        if (r3 != 0) goto L_0x012e
        if (r0 == 0) goto L_0x0196
        com.ss.android.socialbase.downloader.e.a r6 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r10 = "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"
        r11 = 1038(0x40e, float:1.455E-42)
        r6.m51543init(r11, r10)     // Catch:{ all -> 0x024a }
        int r10 = r17.mo32308q()     // Catch:{ all -> 0x024a }
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r0, r1, r6, r10)     // Catch:{ all -> 0x024a }
        goto L_0x0196
    L_0x012e:
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        r10 = 1037(0x40d, float:1.453E-42)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x024a }
        r11.<init>()     // Catch:{ all -> 0x024a }
        java.lang.String r15 = "delete targetPath file existed with md5 check invalid status:"
        r11.append(r15)     // Catch:{ all -> 0x024a }
        java.lang.String r6 = r6.name()     // Catch:{ all -> 0x024a }
        r11.append(r6)     // Catch:{ all -> 0x024a }
        java.lang.String r6 = " failed!"
        r11.append(r6)     // Catch:{ all -> 0x024a }
        java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x024a }
        r3.m51543init(r10, r6)     // Catch:{ all -> 0x024a }
        if (r2 == 0) goto L_0x0154
        r2.mo31758a(r3)     // Catch:{ all -> 0x024a }
    L_0x0154:
        int r6 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r6, r8, r3)     // Catch:{ all -> 0x024a }
        goto L_0x0193
    L_0x015c:
        boolean r3 = r4.exists()     // Catch:{ all -> 0x024a }
        if (r3 != 0) goto L_0x0195
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r6 = "Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist"
        java.lang.Object[] r11 = new java.lang.Object[r14]     // Catch:{ all -> 0x024a }
        java.lang.String r15 = r17.mo32300l()     // Catch:{ all -> 0x024a }
        r11[r8] = r15     // Catch:{ all -> 0x024a }
        java.lang.String r15 = r17.mo32303m()     // Catch:{ all -> 0x024a }
        r11[r7] = r15     // Catch:{ all -> 0x024a }
        java.lang.String r15 = r17.mo32297k()     // Catch:{ all -> 0x024a }
        r11[r13] = r15     // Catch:{ all -> 0x024a }
        java.lang.String r15 = r17.mo32287h()     // Catch:{ all -> 0x024a }
        r11[r12] = r15     // Catch:{ all -> 0x024a }
        java.lang.String r6 = java.lang.String.format(r6, r11)     // Catch:{ all -> 0x024a }
        r3.m51543init(r10, r6)     // Catch:{ all -> 0x024a }
        if (r2 == 0) goto L_0x018c
        r2.mo31758a(r3)     // Catch:{ all -> 0x024a }
    L_0x018c:
        int r6 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r6, r8, r3)     // Catch:{ all -> 0x024a }
    L_0x0193:
        r3 = 0
        goto L_0x0196
    L_0x0195:
        r3 = 1
    L_0x0196:
        if (r3 == 0) goto L_0x0277
        java.lang.String r3 = r17.mo32155A()     // Catch:{ all -> 0x024a }
        com.ss.android.socialbase.downloader.b.i r3 = m28750a(r4, r3)     // Catch:{ all -> 0x024a }
        com.ss.android.socialbase.downloader.b.i r6 = com.p530ss.android.socialbase.downloader.p557b.Md5CheckStatus.VALID     // Catch:{ all -> 0x024a }
        if (r3 == r6) goto L_0x01f7
        com.ss.android.socialbase.downloader.e.a r5 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r6 = "Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile md5 is invalid : %s"
        java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x024a }
        java.lang.String r10 = r17.mo32300l()     // Catch:{ all -> 0x024a }
        r9[r8] = r10     // Catch:{ all -> 0x024a }
        java.lang.String r10 = r17.mo32303m()     // Catch:{ all -> 0x024a }
        r9[r7] = r10     // Catch:{ all -> 0x024a }
        java.lang.String r7 = r17.mo32297k()     // Catch:{ all -> 0x024a }
        r9[r13] = r7     // Catch:{ all -> 0x024a }
        java.lang.String r7 = r17.mo32287h()     // Catch:{ all -> 0x024a }
        r9[r12] = r7     // Catch:{ all -> 0x024a }
        java.lang.String r3 = r3.name()     // Catch:{ all -> 0x024a }
        r9[r14] = r3     // Catch:{ all -> 0x024a }
        java.lang.String r3 = java.lang.String.format(r6, r9)     // Catch:{ all -> 0x024a }
        r6 = 1038(0x40e, float:1.455E-42)
        r5.m51543init(r6, r3)     // Catch:{ all -> 0x024a }
        if (r2 == 0) goto L_0x01d6
        r2.mo31758a(r5)     // Catch:{ all -> 0x024a }
    L_0x01d6:
        int r3 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r3, r8, r5)     // Catch:{ all -> 0x024a }
        boolean r3 = r4.delete()     // Catch:{ all -> 0x024a }
        if (r3 != 0) goto L_0x0277
        if (r0 == 0) goto L_0x0277
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r4 = "tempFile md5 is invalid ,but delete failed"
        r5 = 1038(0x40e, float:1.455E-42)
        r3.m51543init(r5, r4)     // Catch:{ all -> 0x024a }
        int r4 = r17.mo32308q()     // Catch:{ all -> 0x024a }
        com.p530ss.android.socialbase.downloader.p563h.DownloadMonitorHelper.m28177a(r0, r1, r3, r4)     // Catch:{ all -> 0x024a }
        goto L_0x0277
    L_0x01f7:
        boolean r0 = m28794b(r4, r5)     // Catch:{ a -> 0x01fe }
        r0 = r0 ^ r7
        r3 = 0
        goto L_0x0201
    L_0x01fe:
        r0 = move-exception
        r3 = r0
        r0 = 0
    L_0x0201:
        if (r0 == 0) goto L_0x0239
        if (r3 != 0) goto L_0x022c
        com.ss.android.socialbase.downloader.e.a r3 = new com.ss.android.socialbase.downloader.e.a     // Catch:{ all -> 0x024a }
        java.lang.String r0 = "Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)"
        java.lang.Object[] r4 = new java.lang.Object[r14]     // Catch:{ all -> 0x024a }
        java.lang.String r5 = r17.mo32300l()     // Catch:{ all -> 0x024a }
        r4[r8] = r5     // Catch:{ all -> 0x024a }
        java.lang.String r5 = r17.mo32303m()     // Catch:{ all -> 0x024a }
        r4[r7] = r5     // Catch:{ all -> 0x024a }
        java.lang.String r5 = r17.mo32297k()     // Catch:{ all -> 0x024a }
        r4[r13] = r5     // Catch:{ all -> 0x024a }
        java.lang.String r5 = r17.mo32287h()     // Catch:{ all -> 0x024a }
        r4[r12] = r5     // Catch:{ all -> 0x024a }
        java.lang.String r0 = java.lang.String.format(r0, r4)     // Catch:{ all -> 0x024a }
        r4 = 1038(0x40e, float:1.455E-42)
        r3.m51543init(r4, r0)     // Catch:{ all -> 0x024a }
    L_0x022c:
        if (r2 == 0) goto L_0x0231
        r2.mo31758a(r3)     // Catch:{ all -> 0x024a }
    L_0x0231:
        int r0 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        m28761a(r0, r8, r3)     // Catch:{ all -> 0x024a }
        goto L_0x0277
    L_0x0239:
        if (r2 == 0) goto L_0x023e
        r19.mo31757a()     // Catch:{ all -> 0x024a }
    L_0x023e:
        int r0 = r17.mo32283g()     // Catch:{ all -> 0x024a }
        r1 = 0
        m28761a(r0, r7, r1)     // Catch:{ all -> 0x024a }
        goto L_0x0277
    L_0x0247:
        r0 = move-exception
        monitor-exit(r4)     // Catch:{ all -> 0x0247 }
        throw r0     // Catch:{ all -> 0x024a }
    L_0x024a:
        r0 = move-exception
        java.lang.String r1 = f22367a
        java.lang.StringBuilder r3 = new java.lang.StringBuilder
        r3.<init>()
        java.lang.String r4 = "saveFileAsTargetName throwable "
        r3.append(r4)
        java.lang.String r4 = r0.getMessage()
        r3.append(r4)
        java.lang.String r3 = r3.toString()
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r1, r3)
        if (r2 == 0) goto L_0x0277
        com.ss.android.socialbase.downloader.e.a r1 = new com.ss.android.socialbase.downloader.e.a
        java.lang.String r3 = "saveFileAsTargetName"
        java.lang.String r0 = m28786b(r0, r3)
        r3 = 1038(0x40e, float:1.455E-42)
        r1.m51543init(r3, r0)
        r2.mo31758a(r1)
    L_0x0277:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28764a(com.ss.android.socialbase.downloader.g.c, com.ss.android.socialbase.downloader.d.ae, com.ss.android.socialbase.downloader.d.f):void");
    }

    /* renamed from: a */
    private static void m28761a(int i, boolean z, BaseException aVar) {
        synchronized (f22370d) {
            List<ITempFileSaveCompleteCallback> list = (List) f22371e.get(i);
            if (list != null) {
                for (ITempFileSaveCompleteCallback fVar : list) {
                    if (fVar != null) {
                        if (z) {
                            fVar.mo31757a();
                        } else {
                            fVar.mo31758a(aVar);
                        }
                    }
                }
            }
            String str = f22367a;
            StringBuilder sb = new StringBuilder();
            sb.append("handleTempSaveCallback id:");
            sb.append(i);
            C6704a.m27758b(str, sb.toString());
            f22370d.remove(i);
        }
    }

    /* renamed from: a */
    public static void m28766a(DownloadInfo cVar, String str) throws BaseException {
        if (cVar != null && !TextUtils.isEmpty(str) && !str.equals(cVar.mo32287h())) {
            File file = new File(cVar.mo32297k(), str);
            File file2 = new File(cVar.mo32297k(), cVar.mo32287h());
            String str2 = f22367a;
            StringBuilder sb = new StringBuilder();
            sb.append("copyFileFromExistFileWithSameName: existFile:");
            sb.append(file.getPath());
            sb.append(" targetFile:");
            sb.append(file2.getPath());
            Log.e(str2, sb.toString());
            if (file2.exists() && !file2.delete()) {
                throw new BaseException(1037, "targetPath file exists but can't delete");
            } else if (!m28778a(file, file2)) {
                throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{cVar.mo32297k(), str, cVar.mo32297k(), cVar.mo32287h()}));
            }
        }
    }

    /* renamed from: a */
    public static boolean m28778a(File file, File file2) throws BaseException {
        return m28779a(file, file2, true);
    }

    /* renamed from: a */
    public static boolean m28779a(File file, File file2, boolean z) throws BaseException {
        if (!(file == null || file2 == null)) {
            try {
                if (file.exists() && !file.isDirectory()) {
                    if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        File parentFile = file2.getParentFile();
                        String str = "Destination '";
                        if (parentFile != null) {
                            if (!parentFile.mkdirs()) {
                                if (!parentFile.isDirectory()) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append(parentFile);
                                    sb.append("' directory cannot be created");
                                    throw new BaseException(1053, sb.toString());
                                }
                            }
                        }
                        String str2 = f22367a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("copyFile: srcFile:");
                        sb2.append(file.getPath());
                        sb2.append(" destFile:");
                        sb2.append(file2.getPath());
                        Log.e(str2, sb2.toString());
                        if (file2.exists() && !file2.canWrite()) {
                            if (!file2.delete()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(str);
                                sb3.append(file2);
                                sb3.append("' exists but is read-only and delete failed");
                                throw new IOException(sb3.toString());
                            }
                        }
                        m28788b(file, file2, z);
                        return true;
                    }
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                m28768a(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static void m28788b(File file, File file2, boolean z) throws IOException {
        Throwable th;
        long j;
        long j2;
        long j3;
        long j4;
        File file3 = file;
        File file4 = file2;
        if (!file2.exists() || !file2.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file3);
            try {
                FileChannel channel = fileInputStream.getChannel();
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file4);
                    try {
                        FileChannel channel2 = fileOutputStream.getChannel();
                        try {
                            long size = channel.size();
                            th = 0;
                            while (j3 < size) {
                                th = size - j3;
                                if (th > 31457280) {
                                    j4 = 31457280;
                                }
                                long transferFrom = channel2.transferFrom(channel, j3, j4);
                                if (transferFrom == th) {
                                    break;
                                }
                                j3 += transferFrom;
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            fileOutputStream.close();
                            if (channel != null) {
                                channel.close();
                            }
                            fileInputStream.close();
                            long length = file.length();
                            long length2 = file2.length();
                            if (length != length2) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to copy full contents from '");
                                sb.append(file3);
                                sb.append("' to '");
                                sb.append(file4);
                                sb.append("' Expected length: ");
                                sb.append(length);
                                sb.append(" Actual: ");
                                sb.append(length2);
                                throw new IOException(sb.toString());
                            } else if (z) {
                                file4.setLastModified(file.lastModified());
                            }
                        } catch (Throwable th2) {
                            if (channel2 != null) {
                                channel2.close();
                            }
                            throw j2;
                        } finally {
                            j2 = th2;
                        }
                    } catch (Throwable th3) {
                        j2.addSuppressed(th3);
                    } finally {
                        j = th3;
                        try {
                        } catch (Throwable th4) {
                            Throwable th5 = th4;
                            fileOutputStream.close();
                            throw th5;
                        }
                    }
                } catch (Throwable th6) {
                    j.addSuppressed(th6);
                } finally {
                    th = th6;
                    try {
                    } catch (Throwable th7) {
                        Throwable th8 = th7;
                        if (channel != null) {
                            channel.close();
                        }
                        throw th8;
                    }
                }
            } catch (Throwable th9) {
                th.addSuppressed(th9);
            } finally {
                Throwable th10 = th9;
                try {
                } catch (Throwable th11) {
                    Throwable th12 = th11;
                    try {
                        fileInputStream.close();
                    } catch (Throwable th13) {
                        th10.addSuppressed(th13);
                    }
                    throw th12;
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Destination '");
            sb2.append(file4);
            sb2.append("' exists but is a directory");
            throw new IOException(sb2.toString());
        }
    }

    /* renamed from: b */
    public static boolean m28794b(File file, File file2) throws BaseException {
        String str = f22367a;
        StringBuilder sb = new StringBuilder();
        sb.append("moveFile1: src:");
        sb.append(file.getPath());
        String str2 = " dest:";
        sb.append(str2);
        sb.append(file2.getPath());
        Log.e(str, sb.toString());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = m28778a(file, file2);
            try {
                String str3 = f22367a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("moveFile2: src:");
                sb2.append(file.getPath());
                sb2.append(str2);
                sb2.append(file2.getPath());
                Log.e(str3, sb2.toString());
                file.delete();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    /* renamed from: d */
    public static boolean m28808d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    /* renamed from: a */
    public static boolean m28771a(int i, String str) {
        boolean z = false;
        if (DownloadExpSwitchCode.m28744a(16777216)) {
            if (i == 206 || i == 1) {
                z = true;
            }
            return z;
        } else if (i >= 400) {
            return false;
        } else {
            if (i == 206 || i == 1 || "bytes".equals(str)) {
                z = true;
            }
            return z;
        }
    }

    /* renamed from: c */
    public static boolean m28803c(IDownloadHeadHttpConnection cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        if (DownloadExpSwitchCode.m28744a(8)) {
            if ("chunked".equals(cVar.mo16500a("Transfer-Encoding")) || m28748a(cVar) == -1) {
                z = true;
            }
            return z;
        }
        if (m28748a(cVar) == -1) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static List<HttpHeader> m28760a(List<HttpHeader> list, String str, DownloadChunk bVar) {
        return m28759a(list, str, bVar.mo32135m(), bVar.mo32138p());
    }

    /* renamed from: a */
    public static List<HttpHeader> m28759a(List<HttpHeader> list, String str, long j, long j2) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (HttpHeader eVar : list) {
                if (eVar != null) {
                    arrayList.add(eVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new HttpHeader("If-Match", str));
        }
        arrayList.add(new HttpHeader("Accept-Encoding", "identity"));
        String str3 = f22367a;
        StringBuilder sb = new StringBuilder();
        sb.append("range CurrentOffset:");
        sb.append(j);
        sb.append(" EndOffset:");
        sb.append(j2);
        C6704a.m27758b(str3, sb.toString());
        if (j2 == 0) {
            str2 = String.format("bytes=%s-", new Object[]{String.valueOf(j)});
        } else {
            str2 = String.format("bytes=%s-%s", new Object[]{String.valueOf(j), String.valueOf(j2)});
        }
        arrayList.add(new HttpHeader("Range", str2));
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m28772a(int i, String str, String str2) {
        return i == -3 && !m28808d(str, str2);
    }

    /* renamed from: a */
    public static boolean m28773a(Context context) {
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    if (1 == activeNetworkInfo.getType()) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static boolean m28792b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static String m28806d(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(str.getBytes("UTF-8"));
                    return m28755a(instance.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m28799c(Context context) {
        String str = f22369c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Constants.FLAG_ACTIVITY_NAME);
            if (activityManager != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (C6704a.m27756a()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("processName = ");
                            sb.append(runningAppProcessInfo.processName);
                            C6704a.m27758b("Process", sb.toString());
                        }
                        f22369c = runningAppProcessInfo.processName;
                        return f22369c;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f22369c = m28811e();
        return f22369c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[SYNTHETIC, Splitter:B:20:0x0069] */
    /* renamed from: e */
    private static java.lang.String m28811e() {
        /*
        r0 = 0
        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0066 }
        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0066 }
        java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0066 }
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
        r4.<init>()     // Catch:{ all -> 0x0066 }
        java.lang.String r5 = "/proc/"
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x0066 }
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        java.lang.String r5 = "/cmdline"
        r4.append(r5)     // Catch:{ all -> 0x0066 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0066 }
        r3.<init>(r4)     // Catch:{ all -> 0x0066 }
        java.lang.String r4 = "iso-8859-1"
        r2.<init>(r3, r4)     // Catch:{ all -> 0x0066 }
        r1.<init>(r2)     // Catch:{ all -> 0x0066 }
        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
        r2.<init>()     // Catch:{ all -> 0x0064 }
    L_0x0031:
        int r3 = r1.read()     // Catch:{ all -> 0x0064 }
        if (r3 <= 0) goto L_0x003c
        char r3 = (char) r3     // Catch:{ all -> 0x0064 }
        r2.append(r3)     // Catch:{ all -> 0x0064 }
        goto L_0x0031
    L_0x003c:
        boolean r3 = com.p530ss.android.socialbase.downloader.p561f.C6704a.m27756a()     // Catch:{ all -> 0x0064 }
        if (r3 == 0) goto L_0x005c
        java.lang.String r3 = "Process"
        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
        r4.<init>()     // Catch:{ all -> 0x0064 }
        java.lang.String r5 = "get processName = "
        r4.append(r5)     // Catch:{ all -> 0x0064 }
        java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0064 }
        r4.append(r5)     // Catch:{ all -> 0x0064 }
        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0064 }
        com.p530ss.android.socialbase.downloader.p561f.C6704a.m27758b(r3, r4)     // Catch:{ all -> 0x0064 }
    L_0x005c:
        java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0064 }
        r1.close()     // Catch:{ Exception -> 0x0063 }
    L_0x0063:
        return r0
        goto L_0x0067
    L_0x0066:
        r1 = r0
    L_0x0067:
        if (r1 == 0) goto L_0x006c
        r1.close()     // Catch:{ Exception -> 0x006c }
    L_0x006c:
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p569m.DownloadUtils.m28811e():java.lang.String");
    }

    /* renamed from: a */
    public static boolean m28769a() {
        Boolean bool = f22375i;
        if (bool != null) {
            return bool.booleanValue();
        }
        String c = m28799c(C6694b.m27342B());
        boolean z = false;
        if (c == null || !c.contains(":")) {
            if (c != null && c.equals(C6694b.m27342B().getPackageName())) {
                z = true;
            }
            f22375i = Boolean.valueOf(z);
        } else {
            f22375i = Boolean.valueOf(false);
        }
        return f22375i.booleanValue();
    }

    /* renamed from: b */
    public static boolean m28789b() {
        return !m28801c() && C6694b.m27368b() && DownloadProxy.m28368a(true).mo32053g();
    }

    /* renamed from: c */
    public static boolean m28801c() {
        Boolean bool = f22376j;
        if (bool != null) {
            return bool.booleanValue();
        }
        String c = m28799c(C6694b.m27342B());
        if (c != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(C6694b.m27342B().getPackageName());
            sb.append(":downloader");
            if (c.equals(sb.toString())) {
                f22376j = Boolean.valueOf(true);
                return f22376j.booleanValue();
            }
        }
        f22376j = Boolean.valueOf(false);
        return f22376j.booleanValue();
    }

    /* renamed from: e */
    public static boolean m28812e(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String c = m28799c(C6694b.m27342B());
        if (c == null || !c.equals(str)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m28807d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* renamed from: f */
    public static String m28814f(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m28780a(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if ((th instanceof SocketTimeoutException) || (!TextUtils.isEmpty(i) && (i.contains("time out") || i.contains("Time-out")))) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m28795b(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if (th instanceof DownloadHttpException) {
            DownloadHttpException cVar = (DownloadHttpException) th;
            if ((cVar != null && cVar.mo32085c() == 403) || (!TextUtils.isEmpty(i) && i.contains("403"))) {
                return true;
            }
        }
        if (!TextUtils.isEmpty(i) && i.contains("Forbidden")) {
            z = true;
        }
        return z;
    }

    /* renamed from: c */
    public static boolean m28804c(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if (!TextUtils.isEmpty(i) && i.contains("network not available")) {
            z = true;
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m28809d(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if (!TextUtils.isEmpty(i) && i.contains("Exception in connect")) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public static boolean m28813e(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if (!TextUtils.isEmpty(i) && i.contains("Precondition Failed")) {
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public static boolean m28815f(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String i = m28820i(th);
        if (!TextUtils.isEmpty(i) && i.contains("Requested Range Not Satisfiable")) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m28775a(BaseException aVar) {
        return aVar != null && aVar.mo32073a() == 1051;
    }

    /* renamed from: b */
    public static boolean m28793b(BaseException aVar) {
        if (aVar instanceof DownloadHttpException) {
            DownloadHttpException cVar = (DownloadHttpException) aVar;
            if (cVar.mo32085c() == 412 || cVar.mo32085c() == 416) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static void m28768a(Throwable th, String str) throws BaseException {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (th instanceof BaseException) {
            BaseException aVar = (BaseException) th;
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("-");
            sb.append(aVar.mo32076b());
            aVar.mo32075a(sb.toString());
            throw aVar;
        } else if (th instanceof SSLHandshakeException) {
            throw new BaseException((int) PointerIconCompat.TYPE_COPY, m28786b(th, str2));
        } else if (m28780a(th)) {
            throw new BaseException(1048, m28786b(th, str2));
        } else if (m28813e(th)) {
            throw new DownloadHttpException(1004, HttpStatus.SC_PRECONDITION_FAILED, m28786b(th, str2));
        } else if (m28815f(th)) {
            throw new DownloadHttpException(1004, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, m28786b(th, str2));
        } else if (m28795b(th)) {
            throw new BaseException(1047, m28786b(th, str2));
        } else if (m28804c(th)) {
            throw new BaseException(1049, m28786b(th, str2));
        } else if (m28809d(th)) {
            throw new BaseException(1041, m28786b(th, str2));
        } else if (th instanceof IOException) {
            m28767a((IOException) th, str);
        } else {
            throw new BaseException(1000, m28786b(th, str2));
        }
    }

    /* renamed from: a */
    public static void m28767a(IOException iOException, String str) throws BaseException {
        if (str == null) {
            str = "";
        }
        String b = m28786b((Throwable) iOException, str);
        if (iOException instanceof ConnectException) {
            throw new BaseException(1041, b);
        } else if (iOException instanceof UnknownHostException) {
            throw new BaseException(1055, b);
        } else if (iOException instanceof NoRouteToHostException) {
            throw new BaseException(1056, b);
        } else if (iOException instanceof UnknownServiceException) {
            throw new BaseException(1057, b);
        } else if (iOException instanceof PortUnreachableException) {
            throw new BaseException(1058, b);
        } else if (iOException instanceof SocketTimeoutException) {
            throw new BaseException(1048, b);
        } else if (iOException instanceof SocketException) {
            throw new BaseException(1059, b);
        } else if (iOException instanceof HttpRetryException) {
            throw new BaseException(1060, b);
        } else if (iOException instanceof ProtocolException) {
            throw new BaseException(1061, b);
        } else if (iOException instanceof MalformedURLException) {
            throw new BaseException(1062, b);
        } else if (iOException instanceof FileNotFoundException) {
            throw new BaseException(1063, b);
        } else if (iOException instanceof InterruptedIOException) {
            throw new BaseException(1064, b);
        } else if (iOException instanceof UnsupportedEncodingException) {
            throw new BaseException(1065, b);
        } else if (iOException instanceof EOFException) {
            throw new BaseException(1066, b);
        } else if (iOException instanceof StreamResetException) {
            throw new BaseException(1067, b);
        } else if (iOException instanceof SSLException) {
            throw new BaseException((int) PointerIconCompat.TYPE_COPY, b);
        } else if (m28817g((Throwable) iOException)) {
            throw new BaseException((int) PointerIconCompat.TYPE_CELL, b);
        } else {
            throw new BaseException(1023, b);
        }
    }

    /* renamed from: g */
    public static boolean m28817g(Throwable th) {
        boolean z = false;
        if (th == null) {
            return false;
        }
        String str = "ENOSPC";
        if (th instanceof BaseException) {
            BaseException aVar = (BaseException) th;
            int a = aVar.mo32073a();
            if (a == 1006) {
                return true;
            }
            boolean z2 = a == 1023 || a == 1039 || a == 1040 || a == 1054 || a == 1064;
            if (z2) {
                String message = aVar.getMessage();
                if (!TextUtils.isEmpty(message) && message.contains(str)) {
                    z = true;
                }
                return z;
            }
        } else if (th instanceof IOException) {
            String i = m28820i(th);
            if (!TextUtils.isEmpty(i) && i.contains(str)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: h */
    public static boolean m28819h(Throwable th) {
        if (!(th instanceof BaseException)) {
            return false;
        }
        int a = ((BaseException) th).mo32073a();
        if (a == 1055 || a == 1023 || a == 1041 || a == 1022 || a == 1048 || a == 1056 || a == 1057 || a == 1058 || a == 1059 || a == 1060 || a == 1061 || a == 1067 || a == 1049 || a == 1047 || a == 1051 || a == 1004 || a == 1011 || a == 1002 || a == 1013) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m28776a(BaseException aVar, DownloadInfo cVar) {
        if (aVar == null) {
            return false;
        }
        int a = aVar.mo32073a();
        if (a == 1000 || a == 1032 || a == 1033 || a == 1034 || a == 1008 || a == 1026 || a == 1027 || a == 1044 || a == 1020) {
            return true;
        }
        if (a == 1049 || a == 1055 || a == 1006 || cVar == null || cVar.mo32180Z() >= 8388608) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static String m28786b(Throwable th, String str) {
        if (str == null) {
            return m28820i(th);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-");
        sb.append(m28820i(th));
        return sb.toString();
    }

    /* renamed from: i */
    public static String m28820i(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    /* renamed from: c */
    public static ListenerType m28798c(int i) {
        ListenerType hVar = ListenerType.MAIN;
        if (i == ListenerType.SUB.ordinal()) {
            return ListenerType.SUB;
        }
        return i == ListenerType.NOTIFICATION.ordinal() ? ListenerType.NOTIFICATION : hVar;
    }

    /* renamed from: a */
    public static <K> HashMap<Integer, K> m28757a(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    /* renamed from: a */
    public static <K> void m28762a(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map != null && sparseArray != null) {
            for (Integer num : map.keySet()) {
                if (num != null) {
                    sparseArray.put(num.intValue(), map.get(num));
                }
            }
        }
    }

    /* renamed from: d */
    public static long m28805d(DownloadInfo cVar) {
        if (cVar == null) {
            return -1;
        }
        List c = C6694b.m27384p().mo31685c(cVar.mo32283g());
        long j = 0;
        if (cVar.mo32219aV() == 1) {
            j = cVar.mo32180Z();
        } else if (c != null && c.size() > 1) {
            long c2 = m28797c(c);
            if (c2 >= 0) {
                j = c2;
            }
        }
        return j;
    }

    /* renamed from: c */
    private static long m28797c(List<DownloadChunk> list) {
        if (list == null || list.isEmpty()) {
            return -1;
        }
        long j = -1;
        for (DownloadChunk bVar : list) {
            if (bVar != null && ((bVar.mo32136n() <= bVar.mo32138p() || bVar.mo32138p() == 0) && (j == -1 || j > bVar.mo32136n()))) {
                j = bVar.mo32136n();
            }
        }
        return j;
    }

    /* renamed from: e */
    public static long m28810e(DownloadInfo cVar) {
        long j = 0;
        if (cVar == null) {
            return 0;
        }
        List c = C6694b.m27384p().mo31685c(cVar.mo32283g());
        int aV = cVar.mo32219aV();
        boolean z = true;
        if (aV <= 1) {
            z = false;
        }
        if (cVar.mo32214aQ()) {
            if (!z) {
                j = cVar.mo32180Z();
            } else if (c != null && aV == c.size()) {
                j = m28783b(c);
            }
        }
        return j;
    }

    /* renamed from: a */
    public static boolean m28781a(List<HttpHeader> list, List<HttpHeader> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }
}
