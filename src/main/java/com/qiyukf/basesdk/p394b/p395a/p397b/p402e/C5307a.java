package com.qiyukf.basesdk.p394b.p395a.p397b.p402e;

import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.qiyukf.basesdk.b.a.b.e.a */
public class C5307a {
    /* renamed from: a */
    private static final String f17206a = C5309c.m21831a(C5307a.class);
    /* renamed from: b */
    private final RandomAccessFile f17207b;
    /* renamed from: c */
    private final File f17208c;
    /* renamed from: d */
    private final String f17209d;

    public C5307a(File file, String str) {
        this.f17208c = file;
        this.f17207b = new RandomAccessFile(file, "r");
        if (str == null || str.trim().length() <= 0) {
            str = file.getName();
        }
        this.f17209d = str;
    }

    /* renamed from: a */
    public final byte[] mo27212a(long j, int i) {
        if (j == 0 && i == 0 && this.f17208c.length() == 0) {
            return new byte[0];
        }
        if (j >= this.f17208c.length()) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f17207b.seek(j);
        this.f17207b.read(bArr);
        return bArr;
    }
}
