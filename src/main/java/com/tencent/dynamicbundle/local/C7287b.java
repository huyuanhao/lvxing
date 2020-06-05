package com.tencent.dynamicbundle.local;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
/* renamed from: com.tencent.dynamicbundle.local.b */
public class C7287b {
    /* renamed from: a */
    private static C7287b f24686a;

    /* renamed from: a */
    public static synchronized C7287b m31456a() {
        C7287b bVar;
        synchronized (C7287b.class) {
            if (f24686a == null) {
                f24686a = new C7287b();
            }
            bVar = f24686a;
        }
        return bVar;
    }

    /* renamed from: a */
    public String mo34999a(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return mo35000a(instance.digest());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public String mo35000a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
