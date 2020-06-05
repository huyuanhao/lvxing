package com.qiyukf.unicorn.p501d;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.nimlib.C5718b;
import com.tencent.android.tpush.common.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

/* renamed from: com.qiyukf.unicorn.d.b */
public final class C6041b {
    /* renamed from: a */
    public static String m24069a() {
        String str;
        String str2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("   time: ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(" ");
        sb.append(Build.MODEL);
        linkedHashMap.put(" device: ", sb.toString());
        linkedHashMap.put("android: ", VERSION.RELEASE);
        linkedHashMap.put(" system: ", Build.DISPLAY);
        ActivityManager activityManager = (ActivityManager) C5718b.m23009a().getSystemService(Constants.FLAG_ACTIVITY_NAME);
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        linkedHashMap.put("    ram: ", String.valueOf(memoryInfo.availMem));
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (VERSION.SDK_INT >= 18) {
                long blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong();
                long availableBlocksLong = statFs.getAvailableBlocksLong();
                jArr[0] = blockCountLong * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            } else {
                long blockSize = (long) statFs.getBlockSize();
                long availableBlocks = (long) statFs.getAvailableBlocks();
                jArr[0] = ((long) statFs.getBlockCount()) * blockSize;
                jArr[1] = blockSize * availableBlocks;
            }
        }
        long j = jArr[0];
        long j2 = jArr[1];
        if (j <= 0) {
            str = "--";
        } else {
            float f = (float) ((j2 * 100) / j);
            Locale locale = Locale.US;
            Object[] objArr = new Object[2];
            objArr[0] = Float.valueOf(f);
            if (j >= 1073741824) {
                float f2 = (float) (j / 1073741824);
                str2 = String.format(Locale.US, "%.02f GB", new Object[]{Float.valueOf(f2)});
            } else if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                float f3 = (float) (j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                str2 = String.format(Locale.US, "%.02f MB", new Object[]{Float.valueOf(f3)});
            } else {
                float f4 = (float) (j / 1024);
                str2 = String.format(Locale.US, "%.02f KB", new Object[]{Float.valueOf(f4)});
            }
            objArr[1] = str2;
            str = String.format(locale, "%.01f%% [%s]", objArr);
        }
        linkedHashMap.put("   disk: ", str);
        linkedHashMap.put("network: ", C5411c.m22141h(C5718b.m23009a()));
        Iterator it = linkedHashMap.entrySet().iterator();
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String str3 = "line.separator";
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (entry != null) {
                    sb2.append((String) entry.getKey());
                    sb2.append((String) entry.getValue());
                    sb2.append(System.getProperty(str3));
                }
            } else {
                sb2.append(System.getProperty(str3));
                sb2.append("========================");
                sb2.append(System.getProperty(str3));
                sb2.append(System.getProperty(str3));
                return sb2.toString();
            }
        }
    }
}
