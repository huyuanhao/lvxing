package com.kwai.filedownloader.p357e;

import com.kwai.filedownloader.p358f.C4654c.C4659e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* renamed from: com.kwai.filedownloader.e.b */
public class C4642b implements C4641a {
    /* renamed from: a */
    private final BufferedOutputStream f15162a = new BufferedOutputStream(new FileOutputStream(this.f15164c.getFD()));
    /* renamed from: b */
    private final FileDescriptor f15163b = this.f15164c.getFD();
    /* renamed from: c */
    private final RandomAccessFile f15164c;

    /* renamed from: com.kwai.filedownloader.e.b$a */
    public static class C4643a implements C4659e {
        /* renamed from: a */
        public C4641a mo25199a(File file) {
            return new C4642b(file);
        }

        /* renamed from: a */
        public boolean mo25200a() {
            return true;
        }
    }

    C4642b(File file) {
        this.f15164c = new RandomAccessFile(file, "rw");
    }

    /* renamed from: a */
    public void mo25194a() {
        this.f15162a.flush();
        this.f15163b.sync();
    }

    /* renamed from: a */
    public void mo25195a(long j) {
        this.f15164c.seek(j);
    }

    /* renamed from: a */
    public void mo25196a(byte[] bArr, int i, int i2) {
        this.f15162a.write(bArr, i, i2);
    }

    /* renamed from: b */
    public void mo25197b() {
        this.f15162a.close();
        this.f15164c.close();
    }

    /* renamed from: b */
    public void mo25198b(long j) {
        this.f15164c.setLength(j);
    }
}
