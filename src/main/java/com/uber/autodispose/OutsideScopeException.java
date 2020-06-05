package com.uber.autodispose;

public class OutsideScopeException extends RuntimeException {
    public OutsideScopeException(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        if (!AutoDisposePlugins.m33085a()) {
            return this;
        }
        return super.fillInStackTrace();
    }
}
