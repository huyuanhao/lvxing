package com.p530ss.android.socialbase.appdownloader.p550a;

import android.content.Context;
import android.text.TextUtils;
import com.p530ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.a.d */
public class DevicePlans {
    /* renamed from: a */
    public static AbsDevicePlan m26597a(Context context, String str, JSONObject jSONObject, DownloadInfo cVar) {
        AbsDevicePlan aVar = null;
        if (!(cVar == null || context == null || jSONObject == null)) {
            String k = cVar.mo32297k();
            if (TextUtils.isEmpty(k)) {
                return null;
            }
            File file = new File(k);
            char c = 65535;
            switch (str.hashCode()) {
                case -1349088399:
                    if (str.equals("custom")) {
                        c = 4;
                        break;
                    }
                    break;
                case 105958545:
                    if (str.equals("oppo1")) {
                        c = 2;
                        break;
                    }
                    break;
                case 105958546:
                    if (str.equals("oppo2")) {
                        c = 3;
                        break;
                    }
                    break;
                case 112220421:
                    if (str.equals("vivo1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 112220422:
                    if (str.equals("vivo2")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                aVar = new Vivo1DevicePlan(context, cVar.mo32305n());
            } else if (c == 1) {
                aVar = new Vivo2DevicePlan(context, file.getAbsolutePath());
            } else if (c == 2) {
                aVar = new Oppo1DevicePlan(context, file.getAbsolutePath());
            } else if (c == 3) {
                aVar = new Oppo2DevicePlan(context, file.getAbsolutePath());
            } else if (c == 4) {
                aVar = new CustomJumpDevicePlan(context, file.getAbsolutePath(), jSONObject);
            }
        }
        return aVar;
    }

    /* renamed from: a */
    public static boolean m26598a(Context context, String str, JSONObject jSONObject) {
        boolean z = false;
        if (!(context == null || str == null)) {
            AbsDevicePlan aVar = null;
            String a = AppDownloadUtils.m26650a(context);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1349088399:
                    if (str.equals("custom")) {
                        c = 4;
                        break;
                    }
                    break;
                case 105958545:
                    if (str.equals("oppo1")) {
                        c = 2;
                        break;
                    }
                    break;
                case 105958546:
                    if (str.equals("oppo2")) {
                        c = 3;
                        break;
                    }
                    break;
                case 112220421:
                    if (str.equals("vivo1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 112220422:
                    if (str.equals("vivo2")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                aVar = new Vivo1DevicePlan(context, a);
            } else if (c == 1) {
                aVar = new Vivo2DevicePlan(context, a);
            } else if (c == 2) {
                aVar = new Oppo1DevicePlan(context, a);
            } else if (c == 3) {
                aVar = new Oppo2DevicePlan(context, a);
            } else if (c == 4) {
                aVar = new CustomJumpDevicePlan(context, a, jSONObject);
            }
            if (aVar != null && aVar.mo31455a()) {
                z = true;
            }
        }
        return z;
    }
}
