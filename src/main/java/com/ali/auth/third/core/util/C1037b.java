package com.ali.auth.third.core.util;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* renamed from: com.ali.auth.third.core.util.b */
public class C1037b {
    /* renamed from: a */
    public static String m1986a(Context context, String str) {
        String str2 = "";
        try {
            FileInputStream openFileInput = context.openFileInput(str);
            int available = openFileInput.available();
            if (available <= 0) {
                return str2;
            }
            byte[] bArr = new byte[available];
            openFileInput.read(bArr);
            String str3 = new String(bArr, "UTF-8");
            try {
                openFileInput.close();
            } catch (Exception unused) {
            }
            return str3;
        } catch (Exception unused2) {
            return str2;
        }
    }

    /* renamed from: a */
    public static void m1987a(Context context, String str, String str2) {
        try {
            FileOutputStream openFileOutput = context.openFileOutput(str, 0);
            openFileOutput.write(str2.getBytes());
            openFileOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
