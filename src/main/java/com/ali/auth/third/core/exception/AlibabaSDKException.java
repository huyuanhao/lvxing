package com.ali.auth.third.core.exception;

import com.ali.auth.third.core.p027f.C0999a;

public class AlibabaSDKException extends RuntimeException {
    private static final long serialVersionUID = 1357689949294215654L;
    private C0999a message;

    public AlibabaSDKException(C0999a aVar) {
        super(aVar == null ? "" : aVar.f1944c);
        this.message = aVar;
    }

    public AlibabaSDKException(C0999a aVar, Throwable th) {
        super(aVar == null ? "" : aVar.f1944c, th);
        this.message = aVar;
    }

    public C0999a getSDKMessage() {
        return this.message;
    }
}
