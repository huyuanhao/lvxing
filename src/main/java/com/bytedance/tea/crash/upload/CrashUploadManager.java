package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.NpthBus;
import com.bytedance.tea.crash.p221g.C2593d;
import com.bytedance.tea.crash.p221g.LogPath;
import org.json.JSONObject;

/* renamed from: com.bytedance.tea.crash.upload.a */
public class CrashUploadManager {
    /* renamed from: a */
    private static volatile CrashUploadManager f9391a;
    /* renamed from: b */
    private volatile Context f9392b;

    /* renamed from: a */
    public static CrashUploadManager m12604a() {
        if (f9391a == null) {
            f9391a = new CrashUploadManager(NpthBus.m12595d());
        }
        return f9391a;
    }

    private CrashUploadManager(Context context) {
        this.f9392b = context;
    }

    /* renamed from: a */
    public String mo17076a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                return C2593d.m12524a(LogPath.m12539a(this.f9392b), LogPath.m12540a(), CrashUploader.m12612a(NpthBus.m12591a().mo17019a()), jSONObject, CrashUploader.m12613a());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public void mo17077b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String a = CrashUploader.m12612a(NpthBus.m12591a().mo17019a());
                String a2 = C2593d.m12524a(LogPath.m12539a(this.f9392b), LogPath.m12542b(), a, jSONObject, CrashUploader.m12617b());
                jSONObject.put("upload_scene", "direct");
                if (CrashUploader.m12616b(a, jSONObject.toString()).mo17083a()) {
                    C2593d.m12530a(a2);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
