package com.ali.auth.third.p016a.p019c;

import com.ali.auth.third.core.model.C1025f;
import com.ali.auth.third.core.model.C1026g;
import com.ali.auth.third.core.model.C1029j;
import com.ali.auth.third.core.p027f.C0999a;
import com.ali.auth.third.core.p027f.C1000b;
import com.ali.auth.third.core.p032i.C1016a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.p016a.C0955a;
import com.ali.auth.third.p016a.p017a.C0957a;
import com.ali.auth.third.p034ui.QRView;
import com.ali.auth.third.p034ui.p035a.C1068b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ali.auth.third.a.c.d */
public class C0971d extends C1016a<String, Void, Void> {
    /* renamed from: a */
    private C1068b f1858a;
    /* renamed from: b */
    private boolean f1859b;

    public C0971d(C1068b bVar, boolean z) {
        this.f1858a = bVar;
        this.f1859b = z;
    }

    /* access modifiers changed from: protected|varargs */
    /* renamed from: a */
    public Void mo10274a(String... strArr) {
        JSONObject jSONObject;
        C1068b bVar;
        String str = "nativeIv";
        try {
            JSONObject optJSONObject = new JSONObject(strArr[0]).optJSONObject("params");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("qrCodeInfo");
                if (optJSONObject2 != null) {
                    C1029j a = C0955a.f1830a.mo10259a(optJSONObject2.optString("at"), optJSONObject2.optLong("t"), this.f1859b);
                    String str2 = "message";
                    String str3 = "code";
                    if (a == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(str3, 10010);
                        jSONObject2.put(str2, "");
                        this.f1858a.mo10408a(jSONObject2.toString());
                        return null;
                    }
                    try {
                        int i = a.f2054a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("get qrcode of ");
                        sb.append(optJSONObject2);
                        sb.append(" status ");
                        sb.append(i);
                        C1018a.m1964b("login", sb.toString());
                        if (i == 3000) {
                            C0957a.f1835b.mo10330a((C1025f) a.f2056c);
                            if (this.f1858a.mo10406a() != null) {
                                this.f1858a.mo10406a().setResult(C1026g.f2037a.f2046j);
                                this.f1858a.mo10406a().finish();
                            } else if (QRView.f2130a != null) {
                                QRView.f2130a.mo10306a(C0957a.f1835b.mo10329a());
                                QRView.f2130a = null;
                            }
                        } else {
                            if (i == 14030) {
                                jSONObject = new JSONObject();
                                jSONObject.put(str3, 4);
                                jSONObject.put(str2, a.f2055b);
                                bVar = this.f1858a;
                            } else if (i == 14031) {
                                jSONObject = new JSONObject();
                                jSONObject.put(str3, 5);
                                jSONObject.put(str2, a.f2055b);
                                bVar = this.f1858a;
                            } else if (i == 14042) {
                                jSONObject = new JSONObject();
                                jSONObject.put(str3, 6);
                                jSONObject.put(str2, a.f2055b);
                                bVar = this.f1858a;
                            } else if (i == 13060) {
                                JSONObject jSONObject3 = new JSONObject();
                                if (((C1025f) a.f2056c).f2033e != null) {
                                    jSONObject3.put(str, ((C1025f) a.f2056c).f2033e.get(str));
                                    jSONObject3.put("iv_token", ((C1025f) a.f2056c).f2033e.get("nativeIvToken"));
                                    jSONObject3.put("scene", ((C1025f) a.f2056c).f2030b);
                                    jSONObject3.put("login_token", ((C1025f) a.f2056c).f2029a);
                                }
                                this.f1858a.mo10407a(13060, jSONObject3.toString());
                            } else if (i == 1) {
                                jSONObject = new JSONObject();
                                jSONObject.put(str3, 10010);
                                jSONObject.put(str2, a.f2055b);
                                bVar = this.f1858a;
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put(str3, i);
                                jSONObject.put(str2, a.f2055b);
                                bVar = this.f1858a;
                            }
                            bVar.mo10408a(jSONObject.toString());
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10281a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo10282a(Throwable th) {
        C0999a a = C1000b.m1914a(10010, th.getMessage());
        C1018a.m1958a("login", a, th);
        this.f1858a.mo10407a(a.f1942a, a.f1944c);
    }
}
