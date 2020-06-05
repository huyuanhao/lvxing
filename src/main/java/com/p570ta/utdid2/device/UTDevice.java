package com.p570ta.utdid2.device;

import android.content.Context;
import com.p570ta.utdid2.p572b.p573a.C6804i;

/* renamed from: com.ta.utdid2.device.UTDevice */
public class UTDevice {
    public static String getUtdid(Context context) {
        C6809a b = DeviceInfo.m29104b(context);
        return (b == null || C6804i.m29033a(b.mo32712f())) ? "ffffffffffffffffffffffff" : b.mo32712f();
    }

    public static String getUtdidForUpdate(Context context) {
        String h = UTUtdid.m29105a(context).mo32715h();
        return (h == null || C6804i.m29033a(h)) ? "ffffffffffffffffffffffff" : h;
    }
}
