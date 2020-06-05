package com.yanzhenjie.permission.p633a;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.a.t */
class StorageReadTest implements PermissionTest {
    StorageReadTest() {
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
        boolean z = true;
        if (VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
            return true;
        }
        if (!TextUtils.equals("mounted", Environment.getExternalStorageState())) {
            return true;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!externalStorageDirectory.exists()) {
            return true;
        }
        long lastModified = externalStorageDirectory.lastModified();
        String[] list = externalStorageDirectory.list();
        if (lastModified <= 0 || list == null) {
            z = false;
        }
        return z;
    }
}
