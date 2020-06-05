package com.p530ss.android.socialbase.appdownloader.p554e.p555a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.ss.android.socialbase.appdownloader.e.a.d */
public class IntReader {
    /* renamed from: a */
    private InputStream f21565a;
    /* renamed from: b */
    private boolean f21566b;
    /* renamed from: c */
    private int f21567c;

    public IntReader() {
    }

    public IntReader(InputStream inputStream, boolean z) {
        mo31529a(inputStream, z);
    }

    /* renamed from: a */
    public final void mo31529a(InputStream inputStream, boolean z) {
        this.f21565a = inputStream;
        this.f21566b = z;
        this.f21567c = 0;
    }

    /* renamed from: a */
    public final void mo31528a() {
        InputStream inputStream = this.f21565a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            mo31529a(null, false);
        }
    }

    /* renamed from: b */
    public final int mo31531b() throws IOException {
        return mo31527a(4);
    }

    /* renamed from: a */
    public final int mo31527a(int i) throws IOException {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        if (this.f21566b) {
            int i3 = (i - 1) * 8;
            while (i3 >= 0) {
                int read = this.f21565a.read();
                if (read != -1) {
                    this.f21567c++;
                    i2 |= read << i3;
                    i3 -= 8;
                } else {
                    throw new EOFException();
                }
            }
            return i2;
        }
        int i4 = i * 8;
        int i5 = 0;
        while (i2 != i4) {
            int read2 = this.f21565a.read();
            if (read2 != -1) {
                this.f21567c++;
                i5 |= read2 << i2;
                i2 += 8;
            } else {
                throw new EOFException();
            }
        }
        return i5;
    }

    /* renamed from: b */
    public final int[] mo31532b(int i) throws IOException {
        int[] iArr = new int[i];
        mo31530a(iArr, 0, i);
        return iArr;
    }

    /* renamed from: a */
    public final void mo31530a(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = i + 1;
            iArr[i] = mo31531b();
            i2--;
            i = i3;
        }
    }

    /* renamed from: c */
    public final void mo31534c(int i) throws IOException {
        if (i > 0) {
            long j = (long) i;
            long skip = this.f21565a.skip(j);
            this.f21567c = (int) (((long) this.f21567c) + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    /* renamed from: c */
    public final void mo31533c() throws IOException {
        mo31534c(4);
    }
}
