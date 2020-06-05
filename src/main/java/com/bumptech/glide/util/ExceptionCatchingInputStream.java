package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.bumptech.glide.util.c */
public class ExceptionCatchingInputStream extends InputStream {
    /* renamed from: a */
    private static final Queue<ExceptionCatchingInputStream> f4907a = C1772j.m6153a(0);
    /* renamed from: b */
    private InputStream f4908b;
    /* renamed from: c */
    private IOException f4909c;

    /* renamed from: a */
    public static ExceptionCatchingInputStream m6118a(InputStream inputStream) {
        ExceptionCatchingInputStream cVar;
        synchronized (f4907a) {
            cVar = (ExceptionCatchingInputStream) f4907a.poll();
        }
        if (cVar == null) {
            cVar = new ExceptionCatchingInputStream();
        }
        cVar.mo13215b(inputStream);
        return cVar;
    }

    ExceptionCatchingInputStream() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo13215b(InputStream inputStream) {
        this.f4908b = inputStream;
    }

    public int available() throws IOException {
        return this.f4908b.available();
    }

    public void close() throws IOException {
        this.f4908b.close();
    }

    public void mark(int i) {
        this.f4908b.mark(i);
    }

    public boolean markSupported() {
        return this.f4908b.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f4908b.read(bArr);
        } catch (IOException e) {
            this.f4909c = e;
            return -1;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f4908b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f4909c = e;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f4908b.reset();
    }

    public long skip(long j) {
        try {
            return this.f4908b.skip(j);
        } catch (IOException e) {
            this.f4909c = e;
            return 0;
        }
    }

    public int read() {
        try {
            return this.f4908b.read();
        } catch (IOException e) {
            this.f4909c = e;
            return -1;
        }
    }

    /* renamed from: a */
    public IOException mo13212a() {
        return this.f4909c;
    }

    /* renamed from: b */
    public void mo13214b() {
        this.f4909c = null;
        this.f4908b = null;
        synchronized (f4907a) {
            f4907a.offer(this);
        }
    }
}
