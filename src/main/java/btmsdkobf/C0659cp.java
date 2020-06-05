package btmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Properties;

/* renamed from: btmsdkobf.cp */
public class C0659cp {
    /* renamed from: gu */
    private static final long f439gu = (new GregorianCalendar(2040, 0, 1).getTimeInMillis() / 1000);
    /* renamed from: gv */
    private Properties f440gv;
    /* renamed from: gw */
    boolean f441gw = false;
    private Context mContext;

    C0659cp(Properties properties, Context context) {
        this.f440gv = properties;
        this.mContext = context;
    }

    /* renamed from: f */
    private String m118f(String str) {
        PackageInfo packageInfo;
        String str2;
        String str3 = null;
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception e) {
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
        try {
            str3 = C0870g.m966e(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
            byteArrayInputStream.close();
            return str3;
        } catch (CertificateException e2) {
            e2.printStackTrace();
            return str2;
        } catch (IOException e3) {
            e3.printStackTrace();
            return str3;
        }
    }

    /* renamed from: O */
    public boolean mo9181O() {
        if (this.f441gw) {
            return true;
        }
        String f = m118f(this.mContext.getPackageName());
        if (f == null) {
            return true;
        }
        String trim = this.f440gv.getProperty("signature").toUpperCase().trim();
        this.f441gw = f.equals(trim);
        if (!this.f441gw) {
            StringBuilder sb = new StringBuilder();
            sb.append("your    signature is ");
            sb.append(f);
            String str = " len:";
            sb.append(str);
            sb.append(f.length());
            String sb2 = sb.toString();
            String str2 = "DEBUG";
            C0848ff.m907i(str2, sb2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("licence signature is ");
            sb3.append(trim);
            sb3.append(str);
            sb3.append(trim.length());
            C0848ff.m907i(str2, sb3.toString());
        }
        return this.f441gw;
    }

    /* renamed from: P */
    public long mo9182P() {
        return Long.parseLong(this.f440gv.getProperty("expiry.seconds", Long.toString(f439gu)));
    }

    /* renamed from: c */
    public String mo9183c() {
        return this.f440gv.getProperty("lc_sdk_channel");
    }
}
