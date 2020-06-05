package com.tencent.stat.common;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* renamed from: com.tencent.stat.common.i */
public class C7605i {
    /* renamed from: a */
    private static long f25698a = -1;

    /* renamed from: a */
    public static long m32780a(Context context) {
        return m32781a(context, context.getPackageName());
    }

    /* renamed from: a */
    public static long m32781a(Context context, String str) {
        if (f25698a == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            sb.append(str);
            sb.append(".mta_");
            File file = new File(Environment.getExternalStorageDirectory(), sb.toString());
            if (!file.exists()) {
                C7599f.m32765a(context, file);
                file.setReadOnly();
            }
            f25698a = C7599f.m32766b(context, file);
        }
        if (f25698a == -1) {
            f25698a = 0;
        }
        return f25698a;
    }
}
