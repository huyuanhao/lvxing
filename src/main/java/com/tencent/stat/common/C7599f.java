package com.tencent.stat.common;

import android.content.Context;
import android.os.Environment;
import com.tencent.mid.core.Constants;
import java.io.File;

/* renamed from: com.tencent.stat.common.f */
public class C7599f {
    /* renamed from: a */
    public static boolean m32764a(Context context) {
        if (Util.checkPermission(context, Constants.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m32767b(Context context) {
        if (Util.checkPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m32765a(Context context, File file) {
        try {
            if (m32764a(context)) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                    return file.createNewFile();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* renamed from: b */
    public static long m32766b(Context context, File file) {
        try {
            if (m32767b(context) && file.exists()) {
                return file.lastModified();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }
}
