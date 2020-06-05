package com.pgl.sys.ces.p367c;

import android.content.Context;
import com.pgl.p359a.p360a.C4777a;
import com.pgl.p359a.p360a.C4778b;
import com.pgl.sys.ces.C4795a;
import com.pgl.sys.ces.C4804b;
import com.pgl.sys.ces.p365a.C4799c;

/* renamed from: com.pgl.sys.ces.c.b */
public class C4811b extends C4778b {
    /* renamed from: b */
    private Context f15476b = null;

    public C4811b(Context context, String str) {
        super(context, str);
        this.f15476b = context;
        StringBuilder sb = new StringBuilder();
        sb.append(C4777a.m19588a());
        sb.append("/v2/s");
        sb.append(mo25756a());
        this.f15414a = sb.toString();
    }

    /* renamed from: a */
    public String mo25756a() {
        String str;
        try {
            str = this.f15476b.getPackageManager().getPackageInfo(this.f15476b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?os=0&ver=0.6.08.27.03-PGL-DO&m=2");
        sb.append("&app_ver=");
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append("&region=");
        sb3.append(C4799c.m19646c(this.f15476b));
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        sb5.append("&appkey=");
        sb5.append(C4804b.m19664b());
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        sb7.append("&did=");
        sb7.append(C4804b.m19665c());
        return sb7.toString();
    }

    /* renamed from: a */
    public boolean mo25726a(int i, byte[] bArr) {
        if (i != 200 || bArr == null) {
            return false;
        }
        try {
            if (bArr.length <= 0) {
                return false;
            }
            String str = (String) C4795a.meta(200, this.f15476b, bArr);
            if (str == null || str.length() <= 0) {
                return false;
            }
            if (str.equalsIgnoreCase("AYE")) {
                C4804b.f15453h = true;
                return true;
            }
            C4804b.f15453h = false;
            return false;
        } catch (Throwable unused) {
            C4804b.f15453h = false;
            return false;
        }
    }
}
