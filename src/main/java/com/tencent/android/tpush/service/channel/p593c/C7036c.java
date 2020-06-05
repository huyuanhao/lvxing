package com.tencent.android.tpush.service.channel.p593c;

import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import epco.C7962d0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.c.c */
public class C7036c {
    /* renamed from: a */
    static final /* synthetic */ boolean f23391a = (!C7036c.class.desiredAssertionStatus());

    /* renamed from: a */
    public static boolean m30091a(InputStream inputStream, int i) {
        return inputStream.available() >= i;
    }

    /* renamed from: a */
    public static short m30090a(InputStream inputStream) {
        if (m30091a(inputStream, 1)) {
            byte[] bArr = new byte[1];
            if (inputStream.read(bArr) != -1) {
                return (short) (bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            }
            throw new IOException("the end of stream has been reached!");
        }
        throw new IORefusedException("inputstream cannot read 1 byte");
    }

    /* renamed from: b */
    public static long m30093b(InputStream inputStream) {
        if (m30091a(inputStream, 4)) {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr) != -1) {
                return (long) ((bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24));
            }
            throw new IOException("the end of stream has been reached!");
        }
        throw new IORefusedException("inputstream cannot read 4 byte");
    }

    /* renamed from: c */
    public static int m30094c(InputStream inputStream) {
        if (m30091a(inputStream, 4)) {
            byte[] bArr = new byte[4];
            if (inputStream.read(bArr) != -1) {
                return (bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((bArr[2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8) | ((bArr[1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((bArr[0] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 24);
            }
            throw new IOException("the end of stream has been reached!");
        }
        throw new IORefusedException("inputstream cannot read 4 byte");
    }

    /* renamed from: a */
    public static int m30086a(InputStream inputStream, byte[] bArr, int i) {
        if (inputStream.available() == 0 && bArr.length - i > 0) {
            return 0;
        }
        int length = bArr.length - i < inputStream.available() ? bArr.length - i : inputStream.available();
        if (length > 0) {
            length = inputStream.read(bArr, i, length);
            if (length == -1) {
                throw new IOException("the end of stream has been reached!");
            }
        }
        return length;
    }

    /* renamed from: a */
    public static int m30087a(OutputStream outputStream, int i) {
        if (f23391a || (i >= 0 && ((long) i) <= 255)) {
            outputStream.write((byte) (i & 255));
            return 1;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static int m30088a(OutputStream outputStream, long j) {
        if (f23391a || (j >= 0 && j <= C7962d0.f27060j)) {
            outputStream.write(new byte[]{(byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))});
            return 4;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public static int m30092b(OutputStream outputStream, int i) {
        outputStream.write(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
        return 4;
    }

    /* renamed from: a */
    public static int m30089a(OutputStream outputStream, byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            outputStream.write(bArr, i2, 1);
            i++;
        }
        return i;
    }
}
