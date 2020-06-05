package org.apache.thrift.async;

import java.util.concurrent.atomic.AtomicLong;

public abstract class TAsyncMethodCall<T> {
    /* renamed from: a */
    private static AtomicLong f29063a = new AtomicLong(0);

    /* renamed from: org.apache.thrift.async.TAsyncMethodCall$State */
    public enum State {
        CONNECTING,
        WRITING_REQUEST_SIZE,
        WRITING_REQUEST_BODY,
        READING_RESPONSE_SIZE,
        READING_RESPONSE_BODY,
        RESPONSE_READ,
        ERROR
    }
}
