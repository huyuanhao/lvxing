package iko.dmaz.lloq;

import iko.dmaz.lloq.p654a.C8061c;
import java.util.HashMap;
import java.util.List;

/* renamed from: iko.dmaz.lloq.a */
public class C8058a extends C8062b {
    /* renamed from: f */
    private String f27326f;
    /* renamed from: g */
    private String f27327g;
    /* renamed from: h */
    private String f27328h;
    /* renamed from: i */
    private String f27329i;
    /* renamed from: j */
    private String f27330j;
    /* renamed from: k */
    private int f27331k;
    /* renamed from: l */
    private boolean f27332l = true;
    /* renamed from: m */
    private C8063c f27333m;

    public C8058a(String str, String str2, String str3, C8063c cVar, boolean z) {
        super(str, str2, str3);
        this.f27333m = cVar;
        this.f27332l = z;
    }

    /* renamed from: a */
    public void mo38802a(String str) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("dbName", this.f27329i);
        hashMap.put("tblName", this.f27330j);
        hashMap.put("tblVersion", Integer.toString(this.f27331k));
        hashMap.put("logData", str);
        if (this.f27332l) {
            C8061c.m34882a(this.f27328h, mo38805b(this.f27333m.mo26893a(hashMap)), true);
            return;
        }
        C8061c.m34882a(this.f27328h, this.f27333m.mo26893a(hashMap), true);
    }

    /* renamed from: a */
    public void mo38803a(String str, String str2, int i, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f27338c);
        String str4 = "?";
        stringBuffer.append(str4);
        String str5 = "appKey=";
        stringBuffer.append(str5);
        stringBuffer.append(str3);
        String str6 = "&";
        stringBuffer.append(str6);
        String str7 = "dbName=";
        stringBuffer.append(str7);
        stringBuffer.append(str);
        stringBuffer.append(str6);
        String str8 = "tblName=";
        stringBuffer.append(str8);
        stringBuffer.append(str2);
        stringBuffer.append(str6);
        String str9 = "tblVersion=";
        stringBuffer.append(str9);
        stringBuffer.append(i);
        this.f27326f = stringBuffer.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(this.f27339d);
        stringBuffer2.append(str4);
        stringBuffer2.append(str5);
        stringBuffer2.append(str3);
        stringBuffer2.append(str6);
        stringBuffer2.append(str7);
        stringBuffer2.append(str);
        stringBuffer2.append(str6);
        stringBuffer2.append(str8);
        stringBuffer2.append(str2);
        stringBuffer2.append(str6);
        stringBuffer2.append(str9);
        stringBuffer2.append(i);
        this.f27327g = stringBuffer2.toString();
        this.f27329i = str;
        this.f27330j = str2;
        this.f27331k = i;
        this.f27328h = this.f27340e;
    }

    /* renamed from: a */
    public void mo38804a(List<C8067e> list) {
        C8061c.m34882a(this.f27326f, this.f27333m.mo26893a(list), false);
        C8061c.m34881a(this.f27327g);
    }
}
