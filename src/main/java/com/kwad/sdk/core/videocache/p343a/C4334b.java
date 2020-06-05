package com.kwad.sdk.core.videocache.p343a;

import com.kwad.sdk.core.videocache.C4332a;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.kwad.sdk.core.videocache.a.b */
public class C4334b implements C4332a {
    /* renamed from: a */
    public File f14244a;
    /* renamed from: b */
    private final C4333a f14245b;
    /* renamed from: c */
    private RandomAccessFile f14246c;

    public C4334b(File file, C4333a aVar) {
        File file2;
        if (aVar != null) {
            try {
                this.f14245b = aVar;
                C4336d.m17727a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.getName());
                    sb.append(".download");
                    file2 = new File(parentFile, sb.toString());
                }
                this.f14244a = file2;
                this.f14246c = new RandomAccessFile(this.f14244a, exists ? "r" : "rw");
            } catch (IOException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error using file ");
                sb2.append(file);
                sb2.append(" as disc cache");
                throw new ProxyCacheException(sb2.toString(), e);
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* renamed from: a */
    private boolean m17719a(File file) {
        return file.getName().endsWith(".download");
    }

    /* renamed from: a */
    public synchronized int mo24482a(byte[] bArr, long j, int i) {
        try {
            r6 = bArr;
            this.f14246c.seek(j);
            r6 = this.f14246c.read(bArr, 0, i);
            r6 = r6;
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(mo24483a()), Integer.valueOf(r6.length)}), e);
        }
        return r6;
    }

    /* renamed from: a */
    public synchronized long mo24483a() {
        try {
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error reading length of file ");
            sb.append(this.f14244a);
            throw new ProxyCacheException(sb.toString(), e);
        }
        return (long) ((int) this.f14246c.length());
    }

    /* renamed from: a */
    public synchronized void mo24484a(byte[] bArr, int i) {
        try {
            if (!mo24487d()) {
                this.f14246c.seek(mo24483a());
                this.f14246c.write(bArr, 0, i);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Error append cache: cache file ");
                sb.append(this.f14244a);
                sb.append(" is completed!");
                throw new ProxyCacheException(sb.toString());
            }
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i), this.f14246c, Integer.valueOf(bArr.length)}), e);
        }
    }

    /* renamed from: b */
    public synchronized void mo24485b() {
        try {
            this.f14246c.close();
            this.f14245b.mo24488a(this.f14244a);
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error closing file ");
            sb.append(this.f14244a);
            throw new ProxyCacheException(sb.toString(), e);
        }
    }

    /* renamed from: c */
    public synchronized void mo24486c() {
        if (!mo24487d()) {
            mo24485b();
            File file = new File(this.f14244a.getParentFile(), this.f14244a.getName().substring(0, this.f14244a.getName().length() - 9));
            if (this.f14244a.renameTo(file)) {
                this.f14244a = file;
                try {
                    this.f14246c = new RandomAccessFile(this.f14244a, "r");
                    this.f14245b.mo24488a(this.f14244a);
                } catch (IOException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error opening ");
                    sb.append(this.f14244a);
                    sb.append(" as disc cache");
                    throw new ProxyCacheException(sb.toString(), e);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error renaming file ");
                sb2.append(this.f14244a);
                sb2.append(" to ");
                sb2.append(file);
                sb2.append(" for completion!");
                throw new ProxyCacheException(sb2.toString());
            }
        }
    }

    /* renamed from: d */
    public synchronized boolean mo24487d() {
        return !m17719a(this.f14244a);
    }
}
