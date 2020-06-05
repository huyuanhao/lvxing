package com.pgl.sys.ces.p367c;

import android.content.Context;
import com.pgl.p359a.p360a.C4777a;
import com.pgl.p359a.p360a.C4778b;
import com.pgl.sys.ces.C4804b;
import com.pgl.sys.ces.p365a.C4799c;

/* renamed from: com.pgl.sys.ces.c.a */
public class C4810a extends C4778b {
    /* renamed from: b */
    private Context f15475b = null;

    public C4810a(Context context, String str) {
        super(context, str);
        this.f15475b = context;
        StringBuilder sb = new StringBuilder();
        sb.append(C4777a.m19588a());
        sb.append("/v2/r");
        sb.append(mo25756a());
        this.f15414a = sb.toString();
    }

    /* renamed from: a */
    public String mo25756a() {
        String str;
        try {
            str = this.f15475b.getPackageManager().getPackageInfo(this.f15475b.getPackageName(), 0).versionName;
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
        sb3.append(C4799c.m19646c(this.f15475b));
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
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && bArr != null && bArr.length > 0) {
                    if (bArr.length == 37) {
                        C4804b.f15452g = true;
                    } else {
                        C4804b.f15452g = false;
                    }
                }
            } catch (Throwable unused) {
                C4804b.f15452g = false;
            }
        }
        return true;
    }
}
