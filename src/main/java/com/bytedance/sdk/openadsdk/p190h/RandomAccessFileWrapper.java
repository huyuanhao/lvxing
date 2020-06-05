package com.bytedance.sdk.openadsdk.p190h;

import com.bytedance.sdk.openadsdk.p190h.p197g.C2479d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.bytedance.sdk.openadsdk.h.h */
class RandomAccessFileWrapper {
    /* renamed from: a */
    private final RandomAccessFile f8920a;

    /* compiled from: RandomAccessFileWrapper */
    /* renamed from: com.bytedance.sdk.openadsdk.h.h$a */
    static class C2481a extends Exception {
        C2481a(Throwable th) {
            super(th);
        }
    }

    RandomAccessFileWrapper(File file, String str) throws C2481a {
        try {
            this.f8920a = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new C2481a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16789a(long j) throws C2481a {
        try {
            this.f8920a.seek(j);
        } catch (IOException e) {
            throw new C2481a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16790a(byte[] bArr, int i, int i2) throws C2481a {
        try {
            this.f8920a.write(bArr, i, i2);
        } catch (IOException e) {
            throw new C2481a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo16787a(byte[] bArr) throws C2481a {
        try {
            return this.f8920a.read(bArr);
        } catch (IOException e) {
            throw new C2481a(e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo16788a() {
        C2479d.m11663a(this.f8920a);
    }
}
