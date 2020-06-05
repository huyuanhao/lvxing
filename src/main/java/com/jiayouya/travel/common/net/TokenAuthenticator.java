package com.jiayouya.travel.common.net;

import android.content.Context;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import okhttp3.C8368b;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo39189d2 = {"Lcom/jiayouya/travel/common/net/TokenAuthenticator;", "Lokhttp3/Authenticator;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: TokenAuthenticator.kt */
public final class TokenAuthenticator implements C8368b {
    /* renamed from: b */
    private final Gson f9657b = new Gson();
    /* renamed from: c */
    private final Context f9658c;

    public TokenAuthenticator(Context context) {
        C8271i.m35386b(context, "context");
        this.f9658c = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* renamed from: a */
    public okhttp3.C8518z mo20012a(okhttp3.C8367ad r8, okhttp3.C8362ab r9) {
        /*
        r7 = this;
        ezy.app.a.b r8 = ezy.app.p643a.Session.f27256a
        boolean r8 = r8.mo38538b()
        r0 = 0
        if (r8 == 0) goto L_0x00a2
        if (r9 == 0) goto L_0x00a2
        okhttp3.ac r8 = r9.mo40097h()
        if (r8 == 0) goto L_0x00a2
        com.google.gson.Gson r1 = r7.f9657b     // Catch:{ JsonSyntaxException -> 0x0020 }
        java.lang.String r8 = r8.mo40127g()     // Catch:{ JsonSyntaxException -> 0x0020 }
        java.lang.Class<ezy.app.data.Error> r2 = ezy.app.data.Error.class
        java.lang.Object r8 = r1.fromJson(r8, r2)     // Catch:{ JsonSyntaxException -> 0x0020 }
        ezy.app.data.Error r8 = (ezy.app.data.Error) r8     // Catch:{ JsonSyntaxException -> 0x0020 }
        goto L_0x0021
    L_0x0020:
        r8 = r0
    L_0x0021:
        if (r8 == 0) goto L_0x002c
        int r8 = r8.getCode()
        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
        goto L_0x002d
    L_0x002c:
        r8 = r0
    L_0x002d:
        if (r8 != 0) goto L_0x0031
        goto L_0x00a2
    L_0x0031:
        int r8 = r8.intValue()
        r1 = 40101(0x9ca5, float:5.6193E-41)
        if (r8 != r1) goto L_0x00a2
        ezy.app.a.a r8 = ezy.app.p643a.API.f27251a     // Catch:{ Exception -> 0x005a }
        com.jiayouya.travel.module.common.a.e r8 = com.jiayouya.travel.module.common.p257a.C2959f.m13538a(r8)     // Catch:{ Exception -> 0x005a }
        ezy.app.a.b r1 = ezy.app.p643a.Session.f27256a     // Catch:{ Exception -> 0x005a }
        ezy.app.data.Token r1 = r1.mo38534a()     // Catch:{ Exception -> 0x005a }
        if (r1 == 0) goto L_0x004f
        java.lang.String r1 = r1.getRefreshToken()     // Catch:{ Exception -> 0x005a }
        if (r1 == 0) goto L_0x004f
        goto L_0x0051
    L_0x004f:
        java.lang.String r1 = ""
    L_0x0051:
        retrofit2.b r8 = r8.mo20410a(r1)     // Catch:{ Exception -> 0x005a }
        retrofit2.l r8 = r8.mo41289a()     // Catch:{ Exception -> 0x005a }
        goto L_0x005f
    L_0x005a:
        r8 = move-exception
        r8.printStackTrace()
        r8 = r0
    L_0x005f:
        if (r8 == 0) goto L_0x00a2
        boolean r1 = r8.mo41353c()
        r2 = 1
        if (r1 != r2) goto L_0x00a2
        java.lang.Object r8 = r8.mo41354d()
        ezy.app.data.Token r8 = (ezy.app.data.Token) r8
        if (r8 == 0) goto L_0x00a2
        ezy.app.a.b r0 = ezy.app.p643a.Session.f27256a
        java.lang.String r1 = "it"
        kotlin.jvm.internal.C8271i.m35382a(r8, r1)
        r0.mo38539c(r8)
        okhttp3.z r9 = r9.mo40088a()
        okhttp3.z$a r9 = r9.mo40650e()
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "Bearer "
        r0.append(r1)
        java.lang.String r8 = r8.getAccessToken()
        r0.append(r8)
        java.lang.String r8 = r0.toString()
        java.lang.String r0 = "Authorization"
        okhttp3.z$a r8 = r9.mo40662b(r0, r8)
        okhttp3.z r8 = r8.mo40663b()
        return r8
    L_0x00a2:
        ezy.app.a.b r8 = ezy.app.p643a.Session.f27256a
        r8.mo38542e()
        com.jiayouya.travel.common.d.m r1 = com.jiayouya.travel.common.p246d.Router.f9644a
        r3 = 0
        r8 = 335544320(0x14000000, float:6.4623485E-27)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
        r5 = 2
        r6 = 0
        java.lang.String r2 = "/login/wx"
        com.jiayouya.travel.common.p246d.Router.m12969a(r1, r2, r3, r4, r5, r6)
        return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.common.net.TokenAuthenticator.mo20012a(okhttp3.ad, okhttp3.ab):okhttp3.z");
    }
}
