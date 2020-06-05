package com.tencent.stat;

public interface StatCrashCallback {
    void onJavaCrash(Thread thread, Throwable th);

    void onJniNativeCrash(String str);
}
