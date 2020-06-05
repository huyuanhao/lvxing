package com.tencent.bugly.beta.utils;

import android.util.Log;
import epco.C7962d0;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.utils.a */
public class C7153a {
    /* renamed from: a */
    public static long f23847a = -1;
    /* renamed from: b */
    public static long f23848b = 0;
    /* renamed from: c */
    public static long f23849c = 1;
    /* renamed from: d */
    private byte[] f23850d;
    /* renamed from: e */
    private byte[] f23851e;
    /* renamed from: f */
    private byte[] f23852f;
    /* renamed from: g */
    private long f23853g;
    /* renamed from: h */
    private String f23854h;
    /* renamed from: i */
    private BufferedInputStream f23855i;
    /* renamed from: j */
    private long f23856j;
    /* renamed from: k */
    private long f23857k;

    /* renamed from: a */
    public synchronized void mo34476a(long j) {
        this.f23853g = j;
    }

    public C7153a(String str) throws Exception {
        this.f23850d = new byte[2];
        this.f23851e = new byte[4];
        this.f23852f = new byte[8];
        this.f23853g = f23849c;
        this.f23854h = null;
        this.f23855i = null;
        this.f23856j = 0;
        this.f23857k = 0;
        this.f23854h = str;
        this.f23855i = new BufferedInputStream(new FileInputStream(this.f23854h));
        this.f23856j = 0;
        this.f23857k = 0;
    }

    public C7153a(String str, long j) throws Exception {
        this.f23850d = new byte[2];
        this.f23851e = new byte[4];
        this.f23852f = new byte[8];
        this.f23853g = f23849c;
        this.f23854h = null;
        this.f23855i = null;
        this.f23856j = 0;
        this.f23857k = 0;
        this.f23854h = str;
        this.f23853g = j;
        this.f23855i = new BufferedInputStream(new FileInputStream(this.f23854h));
        this.f23856j = 0;
        this.f23857k = 0;
    }

    /* renamed from: a */
    public synchronized boolean mo34477a() {
        try {
            if (this.f23855i != null) {
                this.f23855i.close();
            }
            this.f23855i = null;
            this.f23854h = null;
            this.f23856j = 0;
            this.f23857k = 0;
        } catch (IOException e) {
            Log.e("BinaryFileReader", e.getMessage());
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public synchronized boolean mo34480b(long j) {
        if (this.f23855i == null) {
            Log.e("BinaryFileReader", "Please open file first！");
            return false;
        } else if (j == 0) {
            return true;
        } else {
            long j2 = j;
            while (j2 > 0) {
                try {
                    j2 -= this.f23855i.skip(j2);
                } catch (IOException unused) {
                    Log.e("BinaryFileReader", "Failed to skip file pointer！");
                    return false;
                }
            }
            this.f23856j += j;
            return true;
        }
    }

    /* renamed from: a */
    public synchronized boolean mo34478a(byte[] bArr) {
        try {
            this.f23855i.read(bArr);
            this.f23856j += (long) bArr.length;
            this.f23857k += (long) bArr.length;
        } catch (IOException e) {
            Log.e("BinaryFileReader", e.getMessage());
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public synchronized byte mo34479b() throws IOException {
        if (this.f23855i == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        byte read = (byte) this.f23855i.read();
        this.f23856j++;
        this.f23857k++;
        return read;
    }

    /* renamed from: c */
    public synchronized short mo34481c() throws IOException {
        if (this.f23855i == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        this.f23855i.read(this.f23850d);
        short a = m30604a(this.f23850d, this.f23853g);
        this.f23856j += 2;
        this.f23857k += 2;
        return a;
    }

    /* renamed from: d */
    public synchronized int mo34482d() throws IOException {
        if (this.f23855i == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        this.f23855i.read(this.f23851e);
        int b = m30605b(this.f23851e, this.f23853g);
        this.f23856j += 4;
        this.f23857k += 4;
        return b;
    }

    /* renamed from: e */
    public synchronized long mo34483e() throws IOException {
        if (this.f23855i == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        this.f23855i.read(this.f23852f);
        long c = m30608c(this.f23852f, this.f23853g);
        this.f23856j += 8;
        this.f23857k += 8;
        return c;
    }

    /* renamed from: f */
    public synchronized long mo34484f() throws IOException {
        return ((long) mo34479b()) & 255;
    }

    /* renamed from: g */
    public synchronized long mo34485g() throws IOException {
        return ((long) mo34481c()) & 65535;
    }

    /* renamed from: h */
    public synchronized long mo34486h() throws IOException {
        return ((long) mo34482d()) & C7962d0.f27060j;
    }

    /* renamed from: i */
    public synchronized long mo34487i() throws IOException {
        return mo34483e();
    }

    /* renamed from: b */
    private static short m30606b(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return -1;
        }
        return (short) m30607c(bArr);
    }

    /* renamed from: c */
    private static int m30607c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m30609d(bArr);
    }

    /* renamed from: d */
    private static long m30609d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1;
        }
        long j = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j = (j << 8) | (((long) bArr[length]) & 255);
        }
        return j;
    }

    /* renamed from: e */
    private static short m30610e(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return -1;
        }
        return (short) m30611f(bArr);
    }

    /* renamed from: f */
    private static int m30611f(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) m30612g(bArr);
    }

    /* renamed from: g */
    private static long m30612g(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1;
        }
        long j = 0;
        for (byte b : bArr) {
            j = (j << 8) | (((long) b) & 255);
        }
        return j;
    }

    /* renamed from: a */
    public static short m30604a(byte[] bArr, long j) {
        if (j == f23849c) {
            return m30606b(bArr);
        }
        return m30610e(bArr);
    }

    /* renamed from: b */
    public static int m30605b(byte[] bArr, long j) {
        if (j == f23849c) {
            return m30607c(bArr);
        }
        return m30611f(bArr);
    }

    /* renamed from: c */
    public static long m30608c(byte[] bArr, long j) {
        if (j == f23849c) {
            return m30609d(bArr);
        }
        return m30612g(bArr);
    }
}
