package com.tencent.p605ep.commonbase.utils;

/* renamed from: com.tencent.ep.commonbase.utils.FileHeader */
public class FileHeader {
    public int mCreateTime;
    public byte[] mDigestMd5Str;
    public int mVersion;

    public FileHeader() {
    }

    public FileHeader(int i, int i2, byte[] bArr) {
        this.mVersion = i;
        this.mCreateTime = i2;
        this.mDigestMd5Str = bArr;
    }
}
