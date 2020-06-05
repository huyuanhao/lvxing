package com.kwad.sdk.core.imageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String INDIVIDUAL_DIR_NAME = "ksad-images";

    private StorageUtils() {
    }

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = "mounted";
        File externalCacheDir = (!z || !str2.equals(str) || !hasExternalStoragePermission(context)) ? null : getExternalCacheDir(context);
        if (z) {
            try {
                if (str2.equals(str) || !Environment.isExternalStorageRemovable()) {
                    externalCacheDir = context.getExternalCacheDir();
                }
            } catch (Exception unused2) {
            }
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/data/data/");
        sb.append(context.getPackageName());
        sb.append("/cache/");
        String sb2 = sb.toString();
        C4246L.m17484w("Can't define system cache directory! '%s' will be used.", sb2);
        return new File(sb2);
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                C4246L.m17484w("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                C4246L.m17483i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context) {
        return getIndividualCacheDirectory(context, INDIVIDUAL_DIR_NAME);
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        File cacheDirectory = getCacheDirectory(context);
        File file = new File(cacheDirectory, str);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static File getOwnCacheDirectory(Context context, String str) {
        File file = (!"mounted".equals(Environment.getExternalStorageState()) || !hasExternalStoragePermission(context)) ? null : new File(Environment.getExternalStorageDirectory(), str);
        return (file == null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
    }

    public static File getOwnCacheDirectory(Context context, String str, boolean z) {
        File file;
        if (z) {
            if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
                file = new File(Environment.getExternalStorageDirectory(), str);
                return (file != null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
            }
        }
        file = null;
        if (file != null) {
        }
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
