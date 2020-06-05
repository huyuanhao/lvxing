package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.p126f.C1531b;
import com.alipay.sdk.sys.C1536b;
import com.alipay.sdk.util.C1539b;
import com.tencent.mid.sotrage.StorageInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.alipay.sdk.app.statistic.c */
public class C1507c {
    /* renamed from: a */
    private String f3855a;
    /* renamed from: b */
    private String f3856b;
    /* renamed from: c */
    private String f3857c;
    /* renamed from: d */
    private String f3858d;
    /* renamed from: e */
    private String f3859e;
    /* renamed from: f */
    private String f3860f;
    /* renamed from: g */
    private String f3861g;
    /* renamed from: h */
    private String f3862h;
    /* renamed from: i */
    private String f3863i = "";
    /* renamed from: j */
    private String f3864j;

    public C1507c(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.f3855a = m4459b();
        this.f3857c = m4457a(context);
        this.f3858d = m4462c();
        this.f3859e = m4464d();
        this.f3860f = m4460b(context);
        String str = "-";
        this.f3861g = str;
        this.f3862h = str;
        this.f3864j = str;
    }

    /* renamed from: a */
    public boolean mo12152a() {
        return TextUtils.isEmpty(this.f3863i);
    }

    /* renamed from: a */
    public void mo12150a(String str, String str2, Throwable th) {
        mo12148a(str, str2, m4458a(th));
    }

    /* renamed from: a */
    public void mo12151a(String str, String str2, Throwable th, String str3) {
        mo12149a(str, str2, m4458a(th), str3);
    }

    /* renamed from: a */
    public void mo12149a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!TextUtils.isEmpty(this.f3863i)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str5);
            sb.append("^");
            str5 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str5);
        sb2.append(String.format("%s,%s,%s,%s", new Object[]{str, str2, m4461b(str3), str4}));
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f3863i);
        sb4.append(sb3);
        this.f3863i = sb4.toString();
    }

    /* renamed from: a */
    public void mo12148a(String str, String str2, String str3) {
        mo12149a(str, str2, str3, "-");
    }

    /* renamed from: b */
    private String m4461b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(StorageInterface.KEY_SPLITER, "，").replace("-", "=").replace("^", "~");
    }

    /* renamed from: a */
    private String m4458a(Throwable th) {
        String str = " 》 ";
        if (th == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th.getMessage());
            stringBuffer.append(str);
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(stackTraceElement.toString());
                    sb.append(str);
                    stringBuffer.append(sb.toString());
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String mo12147a(String str) {
        if (mo12152a()) {
            return "";
        }
        this.f3856b = m4463c(str);
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[]{this.f3855a, this.f3856b, this.f3857c, this.f3858d, this.f3859e, this.f3860f, this.f3861g, this.f3862h, this.f3863i, this.f3864j});
    }

    /* renamed from: b */
    private String m4459b() {
        return String.format("123456789,%s", new Object[]{new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date())});
    }

    /* renamed from: c */
    private String m4463c(String str) {
        String str2;
        String[] split = str.split("&");
        String str3 = null;
        if (split != null) {
            str2 = null;
            String str4 = null;
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    String str5 = "";
                    String str6 = "\"";
                    if (split3[0].equalsIgnoreCase("partner")) {
                        split3[1].replace(str6, str5);
                    } else if (split3[0].equalsIgnoreCase("out_trade_no")) {
                        str2 = split3[1].replace(str6, str5);
                    } else if (split3[0].equalsIgnoreCase("trade_no")) {
                        str4 = split3[1].replace(str6, str5);
                    }
                }
            }
            str3 = str4;
        } else {
            str2 = null;
        }
        String b = m4461b(str3);
        String b2 = m4461b(str2);
        return String.format("%s,%s,-,%s,-,-,-", new Object[]{b, b2, m4461b(b2)});
    }

    /* renamed from: a */
    private String m4457a(Context context) {
        String str;
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    str2 = applicationContext.getPackageManager().getPackageInfo(str, 0).versionName;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", new Object[]{str, str2});
        }
        str = str2;
        return String.format("%s,%s,-,-,-", new Object[]{str, str2});
    }

    /* renamed from: c */
    private String m4462c() {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[]{m4461b("15.6.5"), m4461b("h.a.3.6.5")});
    }

    /* renamed from: d */
    private String m4464d() {
        return String.format("%s,%s,-,-,-", new Object[]{m4461b(C1531b.m4573a(C1536b.m4608a().mo12202b()).mo12193a()), m4461b(C1536b.m4608a().mo12204e())});
    }

    /* renamed from: b */
    private String m4460b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{m4461b(C1539b.m4620d(context)), "android", m4461b(VERSION.RELEASE), m4461b(Build.MODEL), "-", m4461b(C1539b.m4617a(context).mo12208a()), m4461b(C1539b.m4618b(context).mo12215b()), "gw", m4461b(C1539b.m4617a(context).mo12210b())});
    }
}
