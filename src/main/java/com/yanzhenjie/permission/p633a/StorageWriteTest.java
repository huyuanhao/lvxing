package com.yanzhenjie.permission.p633a;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.a.u */
class StorageWriteTest implements PermissionTest {
    StorageWriteTest() {
    }

    /* renamed from: a */
    public boolean mo38007a() throws Throwable {
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
        File file = new File(externalStorageDirectory, "Android");
        if (file.exists() && file.isFile() && !file.delete()) {
            return false;
        }
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file, "ANDROID.PERMISSION.TEST");
        if (file2.exists()) {
            return file2.delete();
        }
        return file2.createNewFile();
    }
}
