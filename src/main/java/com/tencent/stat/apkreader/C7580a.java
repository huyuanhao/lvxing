package com.tencent.stat.apkreader;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.tencent.stat.apkreader.a */
final class C7580a {
    /* renamed from: a */
    public static long m32691a(FileChannel fileChannel) throws IOException {
        long size = fileChannel.size();
        if (size >= 22) {
            long j = size - 22;
            long min = Math.min(j, 65535);
            int i = 0;
            while (true) {
                long j2 = (long) i;
                if (j2 <= min) {
                    long j3 = j - j2;
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    fileChannel.position(j3);
                    fileChannel.read(allocate);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    if (allocate.getInt(0) == 101010256) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(2);
                        fileChannel.position(j3 + 20);
                        fileChannel.read(allocate2);
                        allocate2.order(ByteOrder.LITTLE_ENDIAN);
                        short s = allocate2.getShort(0);
                        if (s == i) {
                            return (long) s;
                        }
                    }
                    i++;
                } else {
                    throw new IOException("ZIP End of Central Directory (EOCD) record not found");
                }
            }
        } else {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
    }

    /* renamed from: b */
    public static long m32696b(FileChannel fileChannel) throws IOException {
        return m32692a(fileChannel, m32691a(fileChannel));
    }

    /* renamed from: a */
    public static long m32692a(FileChannel fileChannel, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j) - 6);
        fileChannel.read(allocate);
        return (long) allocate.getInt(0);
    }

    /* renamed from: c */
    public static C7581b<ByteBuffer, Long> m32699c(FileChannel fileChannel) throws IOException, C7583d {
        return m32697b(fileChannel, m32696b(fileChannel));
    }

    /* renamed from: b */
    public static C7581b<ByteBuffer, Long> m32697b(FileChannel fileChannel, long j) throws IOException, C7583d {
        if (j >= 32) {
            fileChannel.position(j - 24);
            ByteBuffer allocate = ByteBuffer.allocate(24);
            fileChannel.read(allocate);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j2 = allocate.getLong(0);
                if (j2 < ((long) allocate.capacity()) || j2 > 2147483639) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("APK Signing Block size out of range: ");
                    sb.append(j2);
                    throw new C7583d(sb.toString());
                }
                int i = (int) (8 + j2);
                long j3 = j - ((long) i);
                if (j3 >= 0) {
                    fileChannel.position(j3);
                    ByteBuffer allocate2 = ByteBuffer.allocate(i);
                    fileChannel.read(allocate2);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    long j4 = allocate2.getLong(0);
                    if (j4 == j2) {
                        return C7581b.m32700a(allocate2, Long.valueOf(j3));
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("APK Signing Block sizes in header and footer do not match: ");
                    sb2.append(j4);
                    sb2.append(" vs ");
                    sb2.append(j2);
                    throw new C7583d(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("APK Signing Block offset out of range: ");
                sb3.append(j3);
                throw new C7583d(sb3.toString());
            }
            throw new C7583d("No APK Signing Block before ZIP Central Directory");
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
        sb4.append(j);
        throw new C7583d(sb4.toString());
    }

    /* renamed from: a */
    public static Map<Integer, ByteBuffer> m32695a(ByteBuffer byteBuffer) throws C7583d {
        m32698b(byteBuffer);
        ByteBuffer a = m32694a(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (a.hasRemaining()) {
            i++;
            if (a.remaining() >= 8) {
                long j = a.getLong();
                String str = " size out of range: ";
                String str2 = "APK Signing Block entry #";
                if (j < 4 || j > 2147483647L) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(i);
                    sb.append(str);
                    sb.append(j);
                    throw new C7583d(sb.toString());
                }
                int i2 = (int) j;
                int position = a.position() + i2;
                if (i2 <= a.remaining()) {
                    linkedHashMap.put(Integer.valueOf(a.getInt()), m32693a(a, i2 - 4));
                    a.position(position);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(i);
                    sb2.append(str);
                    sb2.append(i2);
                    sb2.append(", available: ");
                    sb2.append(a.remaining());
                    throw new C7583d(sb2.toString());
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Insufficient data to read size of APK Signing Block entry #");
                sb3.append(i);
                throw new C7583d(sb3.toString());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private static ByteBuffer m32694a(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("start: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= i) {
            int capacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int limit = byteBuffer.limit();
                int position = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    return slice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(limit);
                    byteBuffer.position(position);
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("end > capacity: ");
                sb2.append(i2);
                sb2.append(" > ");
                sb2.append(capacity);
                throw new IllegalArgumentException(sb2.toString());
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("end < start: ");
            sb3.append(i2);
            sb3.append(" < ");
            sb3.append(i);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    /* renamed from: a */
    private static ByteBuffer m32693a(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 < position || i2 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i2);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i2);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: b */
    private static void m32698b(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
