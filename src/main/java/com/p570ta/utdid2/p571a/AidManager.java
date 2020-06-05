package com.p570ta.utdid2.p571a;

import android.content.Context;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.p570ta.utdid2.p572b.p573a.C6802f;
import com.p570ta.utdid2.p572b.p573a.C6804i;
import com.p570ta.utdid2.p572b.p573a.TimeUtils;
import com.p620ut.device.AidCallback;

/* renamed from: com.ta.utdid2.a.a */
public class AidManager {
    private static final String TAG = AidManager.class.getName();
    /* renamed from: a */
    private static AidManager f22473a;
    private Context mContext;

    /* renamed from: a */
    public static synchronized AidManager m28997a(Context context) {
        AidManager aVar;
        synchronized (AidManager.class) {
            if (f22473a == null) {
                f22473a = new AidManager(context);
            }
            aVar = f22473a;
        }
        return aVar;
    }

    private AidManager(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public void mo32650a(String str, String str2, String str3, AidCallback aVar) {
        if (aVar == null) {
            Log.e(TAG, "callback is null!");
        } else if (this.mContext == null || C6804i.m29033a(str) || C6804i.m29033a(str2)) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("mContext:");
            sb.append(this.mContext);
            sb.append("; callback:");
            sb.append(aVar);
            sb.append("; has appName:");
            sb.append(!C6804i.m29033a(str));
            sb.append("; has token:");
            sb.append(!C6804i.m29033a(str2));
            Log.e(str4, sb.toString());
            aVar.mo37387a(PointerIconCompat.TYPE_HAND, "");
        } else {
            String a = AidStorageController.m29011a(this.mContext, str, str2);
            if (!C6804i.m29033a(a) && TimeUtils.m29035a(AidStorageController.m29011a(this.mContext, str, str2), 1)) {
                aVar.mo37387a(1001, a);
            } else if (C6802f.m29026a(this.mContext)) {
                AidRequester.m29002a(this.mContext).mo32652a(str, str2, str3, a, aVar);
            } else {
                aVar.mo37387a(PointerIconCompat.TYPE_HELP, a);
            }
        }
    }

    /* renamed from: a */
    public String mo32649a(String str, String str2, String str3) {
        if (this.mContext == null || C6804i.m29033a(str) || C6804i.m29033a(str2)) {
            String str4 = TAG;
            StringBuilder sb = new StringBuilder("mContext:");
            sb.append(this.mContext);
            sb.append("; has appName:");
            sb.append(!C6804i.m29033a(str));
            sb.append("; has token:");
            sb.append(!C6804i.m29033a(str2));
            Log.e(str4, sb.toString());
            return "";
        }
        String a = AidStorageController.m29011a(this.mContext, str, str2);
        if ((C6804i.m29033a(a) || !TimeUtils.m29035a(AidStorageController.m29011a(this.mContext, str, str2), 1)) && C6802f.m29026a(this.mContext)) {
            return m28998b(str, str2, str3);
        }
        return a;
    }

    /* renamed from: b */
    private synchronized String m28998b(String str, String str2, String str3) {
        if (this.mContext == null) {
            Log.e(TAG, "no context!");
            return "";
        }
        String str4 = "";
        if (C6802f.m29026a(this.mContext)) {
            str4 = AidRequester.m29002a(this.mContext).mo32651a(str, str2, str3, AidStorageController.m29011a(this.mContext, str, str2));
        }
        AidStorageController.m29013a(this.mContext, str, str4, str2);
        return str4;
    }
}
