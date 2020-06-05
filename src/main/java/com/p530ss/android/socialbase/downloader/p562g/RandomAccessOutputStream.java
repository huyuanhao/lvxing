package com.p530ss.android.socialbase.downloader.p562g;

import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.ss.android.socialbase.downloader.g.f */
public class RandomAccessOutputStream {
    /* renamed from: a */
    private BufferedOutputStream f22113a;
    /* renamed from: b */
    private FileDescriptor f22114b;
    /* renamed from: c */
    private RandomAccessFile f22115c;

    public RandomAccessOutputStream(File file, int i) throws BaseException {
        try {
            this.f22115c = new RandomAccessFile(file, "rw");
            this.f22114b = this.f22115c.getFD();
            if (i > 0) {
                int i2 = 131072;
                if (i < 8192) {
                    i2 = 8192;
                } else if (i <= 131072) {
                    i2 = i;
                }
                this.f22113a = new BufferedOutputStream(new FileOutputStream(this.f22115c.getFD()), i2);
                return;
            }
            this.f22113a = new BufferedOutputStream(new FileOutputStream(this.f22115c.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, (Throwable) e);
        }
    }

    /* renamed from: a */
    public void mo32442a(byte[] bArr, int i, int i2) throws IOException {
        this.f22113a.write(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo32440a() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.f22113a;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.f22114b;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    /* renamed from: b */
    public void mo32443b() throws IOException {
        RandomAccessFile randomAccessFile = this.f22115c;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
        this.f22113a.close();
    }

    /* renamed from: a */
    public void mo32441a(long j) throws IOException {
        this.f22115c.seek(j);
    }

    /* renamed from: b */
    public void mo32444b(long j) throws IOException {
        this.f22115c.setLength(j);
    }
}
