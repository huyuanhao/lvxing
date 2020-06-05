package com.bytedance.tea.crash.p218e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.p213b.NpthDataManager;
import com.bytedance.tea.crash.p213b.p214a.DuplicateLog;
import com.bytedance.tea.crash.p216c.UploadRequest;
import com.bytedance.tea.crash.p221g.C2593d;
import com.bytedance.tea.crash.p221g.LogPath;
import com.bytedance.tea.crash.p221g.NpthLog;
import com.bytedance.tea.crash.upload.CrashUploader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.e.d */
public final class CrashFileCollector {
    /* renamed from: a */
    private Context f9330a;

    public CrashFileCollector(Context context) {
        this.f9330a = context;
    }

    /* renamed from: a */
    public void mo17046a(boolean z) {
        m12453a();
        if (z) {
            m12455b();
        }
    }

    /* renamed from: a */
    private void m12453a() {
        String str = "history_time";
        try {
            SharedPreferences sharedPreferences = this.f9330a.getSharedPreferences("npth", 0);
            long j = sharedPreferences.getLong(str, -1);
            if (j < 0) {
                sharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                C2593d.m12528a(LogPath.m12541b(this.f9330a));
                sharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m12455b() {
        File[] a = m12454a(LogPath.m12539a(this.f9330a), ".npth");
        if (a != null) {
            Arrays.sort(a, Collections.reverseOrder());
            int i = 0;
            while (i < a.length && i < 50) {
                File file = a[i];
                try {
                    if (NpthDataManager.m12329a().mo16978a(file.getAbsolutePath())) {
                        C2593d.m12528a(file);
                    } else {
                        UploadRequest c = C2593d.m12532c(file.getAbsolutePath());
                        if (!(c == null || c.mo17010b() == null)) {
                            JSONObject b = c.mo17010b();
                            m12452a(file.getName(), b);
                            c.mo17010b().put("upload_scene", "launch_scan");
                            if (CrashUploader.m12610a(c.mo17006a(), b.toString(), c.mo17012c()).mo17083a() && !C2593d.m12528a(file)) {
                                NpthDataManager.m12329a().mo16977a(DuplicateLog.m12333a(file.getAbsolutePath()));
                            }
                        }
                    }
                } catch (Exception e) {
                    NpthLog.m12550b(e);
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    private CrashType m12452a(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return CrashType.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return CrashType.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return CrashType.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return CrashType.JAVA;
            }
        }
        return null;
    }

    /* renamed from: a */
    private File[] m12454a(File file, String str) {
        File[] fileArr;
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            fileArr = file.listFiles();
        } else {
            fileArr = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str != null && str.endsWith(".npth");
                }
            });
        }
        return fileArr;
    }
}
