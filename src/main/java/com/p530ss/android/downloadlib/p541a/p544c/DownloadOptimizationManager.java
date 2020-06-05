package com.p530ss.android.downloadlib.p541a.p544c;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.p530ss.android.downloadad.p538a.p540b.NativeDownloadModel;
import com.p530ss.android.downloadlib.p541a.C6565j;
import com.p530ss.android.socialbase.downloader.downloader.Downloader;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import java.io.File;
import java.util.HashMap;

/* renamed from: com.ss.android.downloadlib.a.c.d */
public class DownloadOptimizationManager {
    /* renamed from: a */
    private static volatile DownloadOptimizationManager f21337a;
    /* renamed from: b */
    private long f21338b = 0;
    /* renamed from: c */
    private LongSparseArray<String> f21339c = new LongSparseArray<>();
    /* renamed from: d */
    private HashMap<String, Integer> f21340d = new HashMap<>();

    /* renamed from: a */
    public static DownloadOptimizationManager m26212a() {
        if (f21337a == null) {
            synchronized (DownloadOptimizationManager.class) {
                if (f21337a == null) {
                    f21337a = new DownloadOptimizationManager();
                }
            }
        }
        return f21337a;
    }

    /* renamed from: b */
    public LongSparseArray<String> mo31295b() {
        return this.f21339c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public long mo31296c() {
        return this.f21338b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo31298d() {
        this.f21338b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void mo31293a(String str) {
        this.f21340d.put(str, Integer.valueOf(mo31294b(str) + 1));
    }

    /* renamed from: b */
    public int mo31294b(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f21340d == null) {
            this.f21340d = new HashMap<>();
        }
        if (this.f21340d.containsKey(str)) {
            i = ((Integer) this.f21340d.get(str)).intValue();
        }
        return i;
    }

    /* renamed from: c */
    public boolean mo31297c(String str) {
        if (this.f21340d == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ((this.f21340d.containsKey(str) ? ((Integer) this.f21340d.get(str)).intValue() : 0) > 2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static void m26213a(NativeDownloadModel aVar) {
        if (aVar != null && aVar.mo31194a() > 0) {
            DownloadInfo h = Downloader.m27478a(C6565j.m26357a()).mo31928h(aVar.mo31221k());
            if (h != null) {
                m26214a(h);
            }
        }
    }

    /* renamed from: a */
    public static void m26214a(DownloadInfo cVar) {
        if (cVar != null && DownloadSetting.m28610a(cVar.mo32283g()).mo32547a("delete_file_after_install", 0) != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(cVar.mo32297k());
                sb.append(File.separator);
                sb.append(cVar.mo32287h());
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    File file = new File(sb2);
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
