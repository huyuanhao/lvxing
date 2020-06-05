package com.uber.autodispose.android;

import p655io.reactivex.exceptions.Exceptions;
import p655io.reactivex.p664d.BooleanSupplier;

/* renamed from: com.uber.autodispose.android.a */
public final class AutoDisposeAndroidPlugins {
    /* renamed from: a */
    private static volatile BooleanSupplier f25973a;

    /* renamed from: a */
    public static boolean m33057a(BooleanSupplier eVar) {
        if (eVar != null) {
            BooleanSupplier eVar2 = f25973a;
            if (eVar2 != null) {
                return eVar2.getAsBoolean();
            }
            try {
                return eVar.getAsBoolean();
            } catch (Exception e) {
                throw Exceptions.m34943a(e);
            }
        } else {
            throw new NullPointerException("defaultChecker == null");
        }
    }
}
