package com.p570ta.utdid2.device;

import android.content.Context;
import com.p570ta.utdid2.p572b.p573a.C6803g;
import com.p570ta.utdid2.p572b.p573a.C6804i;
import java.util.zip.Adler32;

/* renamed from: com.ta.utdid2.device.b */
public class DeviceInfo {
    /* renamed from: a */
    private static C6809a f22545a = null;
    /* renamed from: e */
    static final Object f22546e = new Object();
    /* renamed from: k */
    static String f22547k = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";

    /* renamed from: a */
    static long m29102a(C6809a aVar) {
        if (aVar != null) {
            String format = String.format("%s%s%s%s%s", new Object[]{aVar.mo32712f(), aVar.getDeviceId(), Long.valueOf(aVar.mo32703a()), aVar.mo32710e(), aVar.mo32708d()});
            if (!C6804i.m29033a(format)) {
                Adler32 adler32 = new Adler32();
                adler32.reset();
                adler32.update(format.getBytes());
                return adler32.getValue();
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static C6809a m29103a(Context context) {
        if (context != null) {
            new C6809a();
            synchronized (f22546e) {
                String value = UTUtdid.m29105a(context).getValue();
                if (!C6804i.m29033a(value)) {
                    if (value.endsWith("\n")) {
                        value = value.substring(0, value.length() - 1);
                    }
                    C6809a aVar = new C6809a();
                    long currentTimeMillis = System.currentTimeMillis();
                    String a = C6803g.m29029a(context);
                    String b = C6803g.m29030b(context);
                    aVar.mo32709d(a);
                    aVar.mo32706b(a);
                    aVar.mo32705b(currentTimeMillis);
                    aVar.mo32707c(b);
                    aVar.mo32711e(value);
                    aVar.mo32704a(m29102a(aVar));
                    return aVar;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static synchronized C6809a m29104b(Context context) {
        synchronized (DeviceInfo.class) {
            if (f22545a != null) {
                C6809a aVar = f22545a;
                return aVar;
            } else if (context == null) {
                return null;
            } else {
                C6809a a = m29103a(context);
                f22545a = a;
                return a;
            }
        }
    }
}
