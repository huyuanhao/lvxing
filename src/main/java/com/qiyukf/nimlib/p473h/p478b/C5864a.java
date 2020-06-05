package com.qiyukf.nimlib.p473h.p478b;

import android.content.Context;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.nimlib.C5644a;
import com.qiyukf.nimlib.p450b.C5725d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;

/* renamed from: com.qiyukf.nimlib.h.b.a */
public final class C5864a {
    /* renamed from: a */
    int f18575a;
    /* renamed from: b */
    PublicKey f18576b;

    /* renamed from: a */
    public static C5864a m23485a(Context context) {
        C5864a aVar = new C5864a();
        File file = new File(m23491b());
        try {
            FileInputStream fileInputStream = file.exists() ? new FileInputStream(file) : null;
            if (fileInputStream == null || !aVar.m23489a((InputStream) fileInputStream, true)) {
                aVar.m23489a(context.getAssets().open(m23486a(true)), false);
            }
        } catch (Exception unused) {
        }
        return aVar;
    }

    /* renamed from: a */
    private static String m23486a(boolean z) {
        if (!C5725d.m23056e()) {
            return C5725d.m23053b() ? z ? "keystore_unicorn2" : "bbgsvirgin2" : z ? "keystore_unicorn" : "bbgsvirgin";
        }
        boolean z2 = C5725d.m23056e() && C5263a.m21611d().test;
        return z2 ? "bbgsvirgin3" : "bbgsvirgin4";
    }

    /* renamed from: a */
    public static void m23487a() {
        m23492c();
    }

    /* renamed from: a */
    public static void m23488a(int i, byte[] bArr, long j) {
        if (bArr != null && m23490a(bArr, j)) {
            try {
                byte[] encoded = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(bArr), new BigInteger("10001", 16))).getEncoded();
                ByteBuffer allocate = ByteBuffer.allocate(encoded.length + 12);
                allocate.putLong(j);
                allocate.putInt(i);
                allocate.put(encoded);
                File file = new File(m23491b());
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(m23491b()));
                fileOutputStream.write(allocate.array(), 0, allocate.capacity());
                fileOutputStream.close();
            } catch (Exception e) {
                m23492c();
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m23489a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[256];
        try {
            int read = inputStream.read(bArr);
            long j = 0;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (z) {
                j = wrap.getLong();
                read -= 8;
            }
            this.f18575a = wrap.getInt();
            if (this.f18575a < 0) {
                return false;
            }
            byte[] bArr2 = new byte[(read - 4)];
            wrap.get(bArr2);
            this.f18576b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            if (!z || m23490a(((RSAPublicKey) this.f18576b).getModulus().toByteArray(), j)) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return true;
            }
            m23492c();
            this.f18576b = null;
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
        }
    }

    /* renamed from: a */
    private static boolean m23490a(byte[] bArr, long j) {
        if (bArr == null) {
            return false;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, bArr.length);
        return j == crc32.getValue();
    }

    /* renamed from: b */
    private static String m23491b() {
        StringBuilder sb = new StringBuilder();
        sb.append(C5644a.f18160b);
        sb.append("/");
        sb.append(m23486a(false));
        return sb.toString();
    }

    /* renamed from: c */
    private static void m23492c() {
        new File(m23491b()).delete();
    }
}
