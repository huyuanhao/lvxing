package com.tencent.p605ep.commonbase.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.ep.commonbase.utils.FileHeaderUtil */
public class FileHeaderUtil {
    public static FileHeader readHeader(InputStream inputStream) {
        FileHeader fileHeader = new FileHeader();
        byte[] bArr = new byte[4];
        try {
            inputStream.read(bArr);
            fileHeader.mVersion = ConvertUtil.bytesToInt(bArr);
            inputStream.read(bArr);
            fileHeader.mCreateTime = ConvertUtil.bytesToInt(bArr);
            byte[] bArr2 = new byte[16];
            inputStream.read(bArr2);
            fileHeader.mDigestMd5Str = bArr2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileHeader;
    }

    public static void writeHeader(FileHeader fileHeader, OutputStream outputStream) {
        try {
            outputStream.write(ConvertUtil.intToBytes(fileHeader.mVersion));
            outputStream.write(ConvertUtil.intToBytes(fileHeader.mCreateTime));
            outputStream.write(fileHeader.mDigestMd5Str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
