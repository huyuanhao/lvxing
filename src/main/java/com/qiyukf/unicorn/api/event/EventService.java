package com.qiyukf.unicorn.api.event;

import android.text.TextUtils;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.event.eventcallback.TransferCloseResultCallback;
import com.qiyukf.unicorn.api.event.eventcallback.TransferRequestCallback;
import com.qiyukf.unicorn.p502e.C6043b;
import com.qiyukf.unicorn.p514h.C6185c;

public class EventService {
    public static void requestStaff(boolean z) {
        requestStaff(C6185c.m24533a(), z, 0, 0, z ? 5 : 0);
    }

    public static boolean requestStaff(String str, boolean z, long j, long j2, int i) {
        C6043b bVar;
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0 && j2 == 0) {
            bVar = null;
        } else {
            C6043b bVar2 = new C6043b();
            bVar2.f18898a = i2 == 0 ? 1 : 2;
            bVar2.f18899b = i2 != 0 ? j : j2;
            bVar2.mo28884a(j2);
            bVar2.mo28886b(j);
            bVar = bVar2;
        }
        return C6029d.m24047g().mo29289a(str, z, bVar, i);
    }

    public static void transferStaff(String str, long j, long j2, String str2, boolean z, TransferCloseResultCallback transferCloseResultCallback, TransferRequestCallback transferRequestCallback) {
        C6029d.m24047g().mo29285a(TextUtils.isEmpty(str) ? C6185c.m24533a() : str, j, j2, str2, z, transferCloseResultCallback, transferRequestCallback);
    }
}
