package com.p530ss.android.socialbase.downloader.p569m;

import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.m.k */
public class SystemUtils {
    /* renamed from: a */
    private static Boolean f22438a;

    /* renamed from: a */
    public static synchronized boolean m28952a() {
        synchronized (SystemUtils.class) {
            if (f22438a != null) {
                boolean booleanValue = f22438a.booleanValue();
                return booleanValue;
            }
            try {
                String path = Environment.getExternalStorageDirectory().getPath();
                Process exec = Runtime.getRuntime().exec("mount");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                exec.waitFor();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split.length != 0) {
                            List<String> asList = Arrays.asList(split);
                            if (asList.contains("fuse")) {
                                for (String startsWith : asList) {
                                    if (path.startsWith(startsWith)) {
                                        f22438a = Boolean.TRUE;
                                        boolean booleanValue2 = f22438a.booleanValue();
                                        return booleanValue2;
                                    }
                                }
                                continue;
                            }
                        }
                    } else {
                        bufferedReader.close();
                        exec.destroy();
                        f22438a = Boolean.FALSE;
                        boolean booleanValue3 = f22438a.booleanValue();
                        return booleanValue3;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: a */
    public static boolean m28953a(Context context, String str, String str2) {
        try {
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
            int length = serviceInfoArr.length;
            for (int i = 0; i < length; i++) {
                ServiceInfo serviceInfo = serviceInfoArr[i];
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
