package com.readystatesoftware.chuck;

import android.content.Context;
import java.io.IOException;
import okhttp3.C8362ab;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;

public final class ChuckInterceptor implements C8508u {

    /* renamed from: com.readystatesoftware.chuck.ChuckInterceptor$Period */
    public enum Period {
        ONE_HOUR,
        ONE_DAY,
        ONE_WEEK,
        FOREVER
    }

    public ChuckInterceptor(Context context) {
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        return aVar.mo40244a(aVar.mo40246a());
    }
}
