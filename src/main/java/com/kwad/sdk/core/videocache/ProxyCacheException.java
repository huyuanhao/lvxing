package com.kwad.sdk.core.videocache;

public class ProxyCacheException extends Exception {
    private static final String LIBRARY_VERSION = ". Version: 2.6.5.2";

    public ProxyCacheException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(LIBRARY_VERSION);
        super(sb.toString());
    }

    public ProxyCacheException(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(LIBRARY_VERSION);
        super(sb.toString(), th);
    }

    public ProxyCacheException(Throwable th) {
        super("No explanation error. Version: 2.6.5.2", th);
    }
}
