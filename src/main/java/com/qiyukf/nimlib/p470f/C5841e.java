package com.qiyukf.nimlib.p470f;

import android.os.Build.VERSION;
import android.os.TransactionTooLargeException;

/* renamed from: com.qiyukf.nimlib.f.e */
public final class C5841e {
    /* renamed from: a */
    public static boolean m23410a(Exception exc) {
        if (!(VERSION.SDK_INT >= 15 ? exc instanceof TransactionTooLargeException : false)) {
            return false;
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
