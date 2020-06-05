package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.uber.autodispose.a */
final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    AtomicThrowable() {
    }

    public boolean addThrowable(Throwable th) {
        return ExceptionHelper.m33089a(this, th);
    }

    public Throwable terminate() {
        return ExceptionHelper.m33088a(this);
    }
}
