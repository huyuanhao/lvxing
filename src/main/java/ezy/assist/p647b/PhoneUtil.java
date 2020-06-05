package ezy.assist.p647b;

import android.content.Context;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import ezy.assist.p648c.C8021c;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/* renamed from: ezy.assist.b.a */
public class PhoneUtil {
    /* renamed from: a */
    public static String f27265a = null;
    /* renamed from: b */
    public static String f27266b = null;
    /* renamed from: c */
    public static String f27267c = null;
    /* renamed from: d */
    public static String f27268d = "tel";
    /* renamed from: e */
    public static String f27269e;
    /* renamed from: f */
    public static String f27270f;

    /* renamed from: a */
    public static void m34785a(Context context) {
        try {
            m34786b(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m34784a();
    }

    /* renamed from: b */
    private static void m34786b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        f27265a = telephonyManager.getDeviceId();
        f27266b = telephonyManager.getSubscriberId();
        f27269e = telephonyManager.getLine1Number();
        if (!TextUtils.isEmpty(f27269e) && f27269e.startsWith("+86")) {
            f27270f = f27269e.substring(3);
        }
        f27268d = m34783a(f27266b);
    }

    /* renamed from: a */
    private static String m34783a(String str) {
        String str2 = "tel";
        if (str == null) {
            return str2;
        }
        if (str.startsWith("46000") || str.startsWith("46002")) {
            return "cmcc";
        }
        if (str.startsWith("46001")) {
            return "cnc";
        }
        if (str.startsWith("46003")) {
        }
        return str2;
    }

    /* renamed from: a */
    private static void m34784a() {
        if (!TextUtils.isEmpty(f27265a)) {
            f27267c = f27265a;
        } else if (!TextUtils.isEmpty(f27266b)) {
            f27267c = f27266b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb.append(File.separator);
        sb.append(".ezy");
        String sb2 = sb.toString();
        C8021c.m34805b(sb2);
        File file = new File(sb2, "DEVICEID");
        if (file.exists()) {
            f27267c = C8021c.m34803a(file.getAbsolutePath());
        }
        if (TextUtils.isEmpty(f27267c)) {
            f27267c = UUID.randomUUID().toString();
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile();
                C8021c.m34804a(file.getAbsolutePath(), f27267c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
