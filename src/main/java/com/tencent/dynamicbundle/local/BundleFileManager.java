package com.tencent.dynamicbundle.local;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Vector;

/* compiled from: ProGuard */
public class BundleFileManager {
    /* renamed from: a */
    private static BundleFileManager f24683a;

    public static synchronized BundleFileManager getInstance() {
        BundleFileManager bundleFileManager;
        synchronized (BundleFileManager.class) {
            if (f24683a == null) {
                f24683a = new BundleFileManager();
            }
            bundleFileManager = f24683a;
        }
        return bundleFileManager;
    }

    public Vector<String> getPathFiles(String str, String str2) {
        Vector<String> vector = new Vector<>();
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (!listFiles[i].isDirectory()) {
                    String name = listFiles[i].getName();
                    if (name.trim().toLowerCase().endsWith(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append("/");
                        sb.append(name);
                        vector.add(sb.toString());
                    }
                }
            }
        }
        return vector;
    }

    public String getFilePath(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        sb.append(File.separator);
        sb.append(str);
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb2;
    }

    public int copySdcardFile(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public ClassLoader loadDexByPath(Context context, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(".dex");
        return new DexClassLoader(file.getAbsolutePath(), context.getDir(sb.toString(), 0).getAbsolutePath(), null, context.getClassLoader());
    }
}
