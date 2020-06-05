package com.yanzhenjie.durban.p632c;

import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* renamed from: com.yanzhenjie.durban.c.g */
public class ImageHeaderParser {
    /* renamed from: a */
    private static final byte[] f26481a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    /* renamed from: b */
    private static final int[] f26482b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    /* renamed from: c */
    private final C7794b f26483c;

    /* compiled from: ImageHeaderParser */
    /* renamed from: com.yanzhenjie.durban.c.g$a */
    private static class C7793a {
        /* renamed from: a */
        private final ByteBuffer f26484a;

        public C7793a(byte[] bArr, int i) {
            this.f26484a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: a */
        public void mo37839a(ByteOrder byteOrder) {
            this.f26484a.order(byteOrder);
        }

        /* renamed from: a */
        public int mo37837a() {
            return this.f26484a.remaining();
        }

        /* renamed from: a */
        public int mo37838a(int i) {
            return this.f26484a.getInt(i);
        }

        /* renamed from: b */
        public short mo37840b(int i) {
            return this.f26484a.getShort(i);
        }
    }

    /* compiled from: ImageHeaderParser */
    /* renamed from: com.yanzhenjie.durban.c.g$b */
    private interface C7794b {
        /* renamed from: a */
        int mo37841a() throws IOException;

        /* renamed from: a */
        int mo37842a(byte[] bArr, int i) throws IOException;

        /* renamed from: a */
        long mo37843a(long j) throws IOException;

        /* renamed from: b */
        short mo37844b() throws IOException;
    }

    /* compiled from: ImageHeaderParser */
    /* renamed from: com.yanzhenjie.durban.c.g$c */
    private static class C7795c implements C7794b {
        /* renamed from: a */
        private final InputStream f26485a;

        public C7795c(InputStream inputStream) {
            this.f26485a = inputStream;
        }

        /* renamed from: a */
        public int mo37841a() throws IOException {
            return ((this.f26485a.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.f26485a.read() & 255);
        }

        /* renamed from: b */
        public short mo37844b() throws IOException {
            return (short) (this.f26485a.read() & 255);
        }

        /* renamed from: a */
        public long mo37843a(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f26485a.skip(j2);
                if (skip <= 0) {
                    if (this.f26485a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        /* renamed from: a */
        public int mo37842a(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f26485a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }
    }

    /* renamed from: a */
    private static int m33831a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: a */
    private static boolean m33835a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f26483c = new C7795c(inputStream);
    }

    /* renamed from: a */
    public int mo37836a() throws IOException {
        int a = this.f26483c.mo37841a();
        String str = "ImageHeaderParser";
        if (!m33835a(a)) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Parser doesn't handle magic number: ");
                sb.append(a);
                Log.d(str, sb.toString());
            }
            return -1;
        }
        int b = m33836b();
        if (b != -1) {
            return m33833a(new byte[b], b);
        }
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "Failed to parse exif segment length, or exif segment not found");
        }
        return -1;
    }

    /* renamed from: a */
    private int m33833a(byte[] bArr, int i) throws IOException {
        int a = this.f26483c.mo37842a(bArr, i);
        String str = "ImageHeaderParser";
        if (a != i) {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to read exif segment data, length: ");
                sb.append(i);
                sb.append(", actually read: ");
                sb.append(a);
                Log.d(str, sb.toString());
            }
            return -1;
        } else if (m33837b(bArr, i)) {
            return m33832a(new C7793a(bArr, i));
        } else {
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    /* renamed from: b */
    private boolean m33837b(byte[] bArr, int i) {
        boolean z = bArr != null && i > f26481a.length;
        if (!z) {
            return z;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f26481a;
            if (i2 >= bArr2.length) {
                return z;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* renamed from: b */
    private int m33836b() throws IOException {
        String str;
        short b;
        int a;
        long j;
        long a2;
        do {
            short b2 = this.f26483c.mo37844b();
            str = "ImageHeaderParser";
            if (b2 != 255) {
                if (Log.isLoggable(str, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append(b2);
                    Log.d(str, sb.toString());
                }
                return -1;
            }
            b = this.f26483c.mo37844b();
            if (b == 218) {
                return -1;
            }
            if (b == 217) {
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a = this.f26483c.mo37841a() - 2;
            if (b == 225) {
                return a;
            }
            j = (long) a;
            a2 = this.f26483c.mo37843a(j);
        } while (a2 == j);
        if (Log.isLoggable(str, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append(b);
            sb2.append(", wanted to skip: ");
            sb2.append(a);
            sb2.append(", but actually skipped: ");
            sb2.append(a2);
            Log.d(str, sb2.toString());
        }
        return -1;
    }

    /* renamed from: a */
    private static int m33832a(C7793a aVar) {
        ByteOrder byteOrder;
        short b = aVar.mo37840b(6);
        String str = "ImageHeaderParser";
        if (b == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (b == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append(b);
                Log.d(str, sb.toString());
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.mo37839a(byteOrder);
        int a = aVar.mo37838a(10) + 6;
        short b2 = aVar.mo37840b(a);
        for (int i = 0; i < b2; i++) {
            int a2 = m33831a(a, i);
            short b3 = aVar.mo37840b(a2);
            if (b3 == 274) {
                short b4 = aVar.mo37840b(a2 + 2);
                if (b4 >= 1 && b4 <= 12) {
                    int a3 = aVar.mo37838a(a2 + 4);
                    if (a3 >= 0) {
                        String str2 = " tagType=";
                        if (Log.isLoggable(str, 3)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(i);
                            sb2.append(str2);
                            sb2.append(b3);
                            sb2.append(" formatCode=");
                            sb2.append(b4);
                            sb2.append(" componentCount=");
                            sb2.append(a3);
                            Log.d(str, sb2.toString());
                        }
                        int i2 = a3 + f26482b[b4];
                        if (i2 <= 4) {
                            int i3 = a2 + 8;
                            if (i3 < 0 || i3 > aVar.mo37837a()) {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Illegal tagValueOffset=");
                                    sb3.append(i3);
                                    sb3.append(str2);
                                    sb3.append(b3);
                                    Log.d(str, sb3.toString());
                                }
                            } else if (i2 >= 0 && i2 + i3 <= aVar.mo37837a()) {
                                return aVar.mo37840b(i3);
                            } else {
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append(b3);
                                    Log.d(str, sb4.toString());
                                }
                            }
                        } else if (Log.isLoggable(str, 3)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb5.append(b4);
                            Log.d(str, sb5.toString());
                        }
                    } else if (Log.isLoggable(str, 3)) {
                        Log.d(str, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(str, 3)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Got invalid format code = ");
                    sb6.append(b4);
                    Log.d(str, sb6.toString());
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m33834a(ExifInterface exifInterface, int i, int i2, String str) {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            ExifInterface exifInterface2 = new ExifInterface(str);
            for (String str2 : strArr) {
                String attribute = exifInterface.getAttribute(str2);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface2.setAttribute(str2, attribute);
                }
            }
            exifInterface2.setAttribute("ImageWidth", String.valueOf(i));
            exifInterface2.setAttribute("ImageLength", String.valueOf(i2));
            exifInterface2.setAttribute("Orientation", "0");
            exifInterface2.saveAttributes();
        } catch (IOException e) {
            Log.d("ImageHeaderParser", e.getMessage());
        }
    }
}
