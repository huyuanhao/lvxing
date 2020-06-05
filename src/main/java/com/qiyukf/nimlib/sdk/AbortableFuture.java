package com.qiyukf.nimlib.sdk;

public interface AbortableFuture<T> extends InvocationFuture {
    boolean abort();
}
