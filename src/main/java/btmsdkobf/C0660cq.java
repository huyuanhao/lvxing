package btmsdkobf;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

/* renamed from: btmsdkobf.cq */
public class C0660cq {
    /* renamed from: gx */
    private static volatile C0660cq f442gx;
    /* renamed from: gA */
    private C0659cp f443gA;
    /* renamed from: gy */
    private C0658co f444gy;
    /* renamed from: gz */
    private Calendar f445gz = Calendar.getInstance();

    private C0660cq() {
        if (C0652cl.m86E().isCheckLicence()) {
            m123R();
        }
    }

    /* renamed from: Q */
    public static synchronized C0660cq m122Q() {
        C0660cq cqVar;
        synchronized (C0660cq.class) {
            if (f442gx == null) {
                f442gx = new C0660cq();
            }
            cqVar = f442gx;
        }
        return cqVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070 A[LOOP:0: B:1:0x0002->B:29:0x0070, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063 A[SYNTHETIC] */
    /* renamed from: R */
    private void m123R() {
        /*
        r9 = this;
        r0 = 0
        r1 = 0
    L_0x0002:
        byte[] r2 = r9.m127f(r1)     // Catch:{ RuntimeException -> 0x0083 }
        if (r2 == 0) goto L_0x007b
        java.security.interfaces.RSAPublicKey r3 = m125T()
        r4 = 128(0x80, float:1.794E-43)
        byte[] r5 = new byte[r4]
        int r6 = r5.length
        java.lang.System.arraycopy(r2, r0, r5, r0, r6)
        r6 = 0
        if (r3 == 0) goto L_0x0027
        java.lang.String r7 = "RSA/ECB/PKCS1Padding"
        javax.crypto.Cipher r7 = javax.crypto.Cipher.getInstance(r7)     // Catch:{ all -> 0x0026 }
        r8 = 2
        r7.init(r8, r3)     // Catch:{ all -> 0x0026 }
        byte[] r6 = r7.doFinal(r5)     // Catch:{ all -> 0x0026 }
        goto L_0x0027
    L_0x0027:
        if (r6 == 0) goto L_0x0073
        int r3 = r2.length
        int r3 = r3 - r4
        byte[] r3 = new byte[r3]
        int r5 = r3.length
        java.lang.System.arraycopy(r2, r4, r3, r0, r5)
        byte[] r2 = m126a(r3, r6)
        if (r2 != 0) goto L_0x0038
        return
    L_0x0038:
        java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
        r3.<init>(r2)
        java.util.Properties r2 = new java.util.Properties
        r2.<init>()
        r2.load(r3)     // Catch:{ IOException -> 0x0045, all -> 0x004b }
    L_0x0045:
        r3.close()     // Catch:{ IOException -> 0x0049 }
        goto L_0x0050
        goto L_0x0050
    L_0x004b:
        r0 = move-exception
        r3.close()     // Catch:{ IOException -> 0x004f }
    L_0x004f:
        throw r0
    L_0x0050:
        btmsdkobf.cp r3 = new btmsdkobf.cp
        android.content.Context r4 = btmsdkobf.C0652cl.m85D()
        r3.m40604init(r2, r4)
        r9.f443gA = r3
        btmsdkobf.cp r2 = r9.f443gA
        boolean r2 = r2.mo9181O()
        if (r2 == 0) goto L_0x0070
        r9.m124S()
        java.util.Calendar r0 = r9.f445gz
        long r1 = java.lang.System.currentTimeMillis()
        r0.setTimeInMillis(r1)
        return
    L_0x0070:
        int r1 = r1 + 1
        goto L_0x0002
    L_0x0073:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException
        java.lang.String r1 = "RSA decrypt error."
        r0.<init>(r1)
        throw r0
    L_0x007b:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException
        java.lang.String r1 = "Certification file is missing! Please contact TMS(Tencent Mobile Secure) group."
        r0.<init>(r1)
        throw r0
    L_0x0083:
        java.lang.RuntimeException r0 = new java.lang.RuntimeException
        java.lang.String r1 = "loadLicence Invaild signature! Please contact TMS(Tencent Mobile Secure) group."
        r0.<init>(r1)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: btmsdkobf.C0660cq.m123R():void");
    }

    /* renamed from: S */
    private final void m124S() {
        long P = this.f443gA.mo9182P();
        boolean z = System.currentTimeMillis() / 1000 >= P;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000 * P);
        StringBuilder sb = new StringBuilder();
        sb.append("expirySeconds=");
        sb.append(P);
        sb.append("(");
        sb.append(instance.get(1));
        String str = "-";
        sb.append(str);
        sb.append(instance.get(2));
        sb.append(str);
        sb.append(instance.get(5));
        sb.append(") expired=");
        sb.append(z);
        C0848ff.m905d("LicenceManager", sb.toString());
        this.f444gy = new C0658co(z);
    }

    /* renamed from: T */
    private static RSAPublicKey m125T() {
        try {
            return (RSAPublicKey) X509Certificate.getInstance(C0828ev.decode("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5ekNDQWQ4Q0NRRGlsbUFjTWxiczVEQU5C\nZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SkQKVGpFTE1Ba0dBMVVFQ0JNQ1IwUXhD\nekFKQmdOVkJBY1RBa2RhTVJJd0VBWURWUVFLRkFsMFpXTUlibU5sYm5ReApDekFKQmdOVkJBc1RB\nak5ITVE0d0RBWURWUVFERXdWdlltRnRZVEVrTUNJR0NTcUdTSWIzRFFFSkFSWVZiMkpoCmJXRjZa\nVzVuUUhSbGJtTmxiblF1WTI5dE1CNFhEVEV4TVRFeE5qRXhNVGN4TjFvWERURXlNREl5TkRFeE1U\nY3gKTjFvd2dZQXhDekFKQmdOVkJBWVRBa05PTVFzd0NRWURWUVFJRXdKSFJERUxNQWtHQTFVRUJ4\nTUNSMW94RURBTwpCZ05WQkFvVEIzUmxibU5sYm5ReEN6QUpCZ05WQkFzVEFqTkhNUkl3RUFZRFZR\nUURFd2x2WW1GdFlYcGxibWN4CkpEQWlCZ2txaGtpRzl3MEJDUUVXRlc5aVlXMWhlbVZ1WjBCMFpX\nNWpaVzUwTG1OdmJUQ0JuekFOQmdrcWhraUcKOXcwQkFRRUZBQU9CalFBd2dZa0NnWUVBd1kvV3FI\nV2NlRERkSm16anI3TlpSeS9qTllwS1NzVzExZngxaTIrQwpxTUE3NTJXb1d1bDZuSTB1MGZkWitk\nUzVUandRNkU0Qm13dXduVTVnQmJYK1VzQ2VHRHZaQVhQc045UEVWYnZTCkcvR25YclQrcTI2VUpP\nNHcrd3VNdmk5YWxkZHhhbkNKeXJ2ZWQ2NUdvMXhXUEErWGNHaVQxMndubjZtUHhyMnUKcVEwQ0F3\nRUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBblpzV3FpSmV5SC9sT0prSWN6L2ZidDN3MXFL\nRApGTXJ5cFVHVFN6Z3NONWNaMW9yOGlvVG5ENGRLaDdJN2ttbDRpcGNvMDF0enc2MGhLYUtwNG9G\nMnYrMEs2NGZDCnBEMG9EUlkrOGoyK2RsMmNxeHBsT0FYdDc1RWFKNW40MG1DZDdTN0VBS0d2Z2Na\naVhyV0Z1eUtCL2QvNTh3Qm4KOEFGUVJhTnBySXNOSHpxMkMwL0JXR1pTSnJicmhOWExFY0ZtL0Ru\nTG14ZEVNYWxPSXhnSkhGcEFOS2tadXBzdgo0L0lDVFhSL0RJaURjbXJjbDFkNkc2VmgyaUcwaS9v\nRDBHQnBMZlFPcEF0Vmx6Y2lxZnBsTkphcnpRUTZUVXRyCm5GRmVNVDNDc2t5VGJwYnp1R2dDdUxj\nQVR3cnRQd1BOOWZzQXYrSjRJZm0rZUNVVDVnZlorMSsyNHc9PQotLS0tLUVORCBDRVJUSUZJQ0FU\nRS0tLS0tCg==\n".getBytes(), 0)).getPublicKey();
        } catch (CertificateException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m126a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/ECB/NoPadding");
            instance.init(2, generateSecret);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    /* renamed from: f */
    private byte[] m127f(int i) {
        String str;
        InputStream inputStream = null;
        try {
            AssetManager assets = C0652cl.m85D().getAssets();
            if (i == 0) {
                str = "licence.conf";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("licence");
                sb.append(i);
                sb.append(".conf");
                str = sb.toString();
            }
            InputStream open = assets.open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            if (open != null) {
                try {
                    open.close();
                } catch (IOException unused) {
                }
            }
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* renamed from: O */
    public final boolean mo9184O() {
        if (C0652cl.m86E().isCheckLicence()) {
            return this.f443gA.mo9181O();
        }
        return true;
    }

    /* renamed from: c */
    public String mo9185c() {
        return C0652cl.m86E().isCheckLicence() ? this.f443gA.mo9183c() : C0652cl.m86E().mo9079c();
    }
}
