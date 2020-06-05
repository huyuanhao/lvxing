package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.alibaba.wireless.security.framework.utils.d */
public class C1350d {
    /* renamed from: a */
    private FileChannel f3535a = null;
    /* renamed from: b */
    private FileLock f3536b = null;
    /* renamed from: c */
    private RandomAccessFile f3537c = null;
    /* renamed from: d */
    private File f3538d = null;
    /* renamed from: e */
    private boolean f3539e = true;
    /* renamed from: f */
    private String f3540f = null;

    public C1350d(Context context, String str) {
        this.f3540f = str;
        this.f3539e = m3984c();
    }

    /* renamed from: c */
    private boolean m3984c() {
        try {
            this.f3538d = new File(this.f3540f);
            if (!this.f3538d.exists()) {
                this.f3538d.createNewFile();
            }
        } catch (Exception unused) {
            if (!this.f3538d.exists()) {
                try {
                    this.f3538d.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file = this.f3538d;
        return file != null && file.exists();
    }

    /* renamed from: a */
    public boolean mo11862a() {
        if (!this.f3539e) {
            this.f3539e = m3984c();
            if (!this.f3539e) {
                return true;
            }
        }
        boolean z = false;
        try {
            if (this.f3538d != null) {
                this.f3537c = new RandomAccessFile(this.f3538d, "rw");
                this.f3535a = this.f3537c.getChannel();
                this.f3536b = this.f3535a.lock();
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return z;
    }

    /* renamed from: b */
    public boolean mo11863b() {
        boolean z = true;
        if (!this.f3539e) {
            return true;
        }
        try {
            if (this.f3536b != null) {
                this.f3536b.release();
                this.f3536b = null;
            }
        } catch (IOException unused) {
            z = false;
        }
        try {
            if (this.f3535a != null) {
                this.f3535a.close();
                this.f3535a = null;
            }
        } catch (IOException unused2) {
            z = false;
        }
        try {
            if (this.f3537c != null) {
                this.f3537c.close();
                this.f3537c = null;
            }
        } catch (IOException unused3) {
            z = false;
        }
        return z;
    }
}
