package p681me.jessyan.retrofiturlmanager;

import okhttp3.C8506t;

/* renamed from: me.jessyan.retrofiturlmanager.Utils */
class Utils {
    private Utils() {
        throw new IllegalStateException("do not instantiation me");
    }

    static C8506t checkUrl(String str) {
        C8506t e = C8506t.m36545e(str);
        if (e != null) {
            return e;
        }
        throw new InvalidUrlException(str);
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
