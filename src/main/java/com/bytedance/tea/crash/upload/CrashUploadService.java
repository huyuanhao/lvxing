package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.tea.crash.CrashType;
import com.bytedance.tea.crash.p213b.NpthDataManager;
import com.bytedance.tea.crash.p213b.p214a.DuplicateLog;
import com.bytedance.tea.crash.p221g.C2593d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class CrashUploadService extends IntentService {
    public CrashUploadService() {
        super("CrashUploadService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            CrashType cVar = null;
            String str = "crash_type";
            if (intent.hasExtra(str)) {
                cVar = (CrashType) intent.getSerializableExtra(str);
            }
            String stringExtra = intent.getStringExtra("upload_url");
            String stringExtra2 = intent.getStringExtra("crash_json_value");
            String stringExtra3 = intent.getStringExtra("crash_info_file_path");
            String stringExtra4 = intent.getStringExtra("crash_dump_file_path");
            NpthDataManager.m12329a().mo16976a((Context) getApplication());
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra) && !NpthDataManager.m12329a().mo16978a(stringExtra3) && m12603a(stringExtra, stringExtra2, stringExtra4, cVar).mo17083a()) {
                if (cVar == CrashType.NATIVE) {
                    if (!C2593d.m12529a(new File(stringExtra3).getParentFile(), true)) {
                        NpthDataManager.m12329a().mo16977a(DuplicateLog.m12333a(stringExtra3));
                    }
                } else if (!TextUtils.isEmpty(stringExtra3) && !C2593d.m12530a(stringExtra3)) {
                    NpthDataManager.m12329a().mo16977a(DuplicateLog.m12333a(stringExtra3));
                }
            }
        }
    }

    /* renamed from: a */
    private C2602f m12603a(String str, String str2, String str3, CrashType cVar) {
        if (cVar == null) {
            return new C2602f(201);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            jSONObject.put("upload_scene", "new_process");
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (cVar == CrashType.NATIVE) {
            return CrashUploader.m12609a(str, str2, str3);
        }
        if (cVar == CrashType.LAUNCH) {
            return CrashUploader.m12608a(str, str2);
        }
        return CrashUploader.m12610a(str, str2, CrashUploader.m12613a());
    }

    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
