package com.qiyukf.basesdk.p394b.p395a.p397b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qiyukf.basesdk.C5263a;
import com.qiyukf.basesdk.p394b.p395a.p397b.p400c.C5302d;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;

/* renamed from: com.qiyukf.basesdk.b.a.b.b */
public final class C5295b {
    /* renamed from: a */
    public static String m21751a() {
        return m21755b().getString(ArgKey.KEY_TOKENS, null);
    }

    /* renamed from: a */
    public static void m21752a(String str) {
        Editor edit = m21755b().edit();
        edit.putString(ArgKey.KEY_TOKENS, str);
        edit.commit();
    }

    /* renamed from: a */
    public static void m21753a(String str, C5302d dVar) {
        Editor edit = m21755b().edit();
        StringBuilder sb = new StringBuilder("bo/");
        sb.append(str);
        edit.putString(sb.toString(), C5302d.m21774a(dVar));
        edit.commit();
    }

    /* renamed from: a */
    public static void m21754a(String str, String str2) {
        Editor edit = m21755b().edit();
        StringBuilder sb = new StringBuilder("fc/");
        sb.append(str);
        edit.putString(sb.toString(), str2);
        edit.commit();
    }

    /* renamed from: b */
    private static SharedPreferences m21755b() {
        Context a = C5263a.m21607a();
        StringBuilder sb = new StringBuilder("NimSDK_NOS_");
        sb.append(C5263a.m21609b());
        return a.getSharedPreferences(sb.toString(), 0);
    }

    /* renamed from: b */
    public static String m21756b(String str) {
        SharedPreferences b = m21755b();
        StringBuilder sb = new StringBuilder("fc/");
        sb.append(str);
        return b.getString(sb.toString(), null);
    }

    /* renamed from: c */
    public static void m21757c(String str) {
        Editor edit = m21755b().edit();
        StringBuilder sb = new StringBuilder("fc/");
        sb.append(str);
        edit.remove(sb.toString());
        edit.commit();
    }

    /* renamed from: d */
    public static C5302d m21758d(String str) {
        SharedPreferences b = m21755b();
        StringBuilder sb = new StringBuilder("bo/");
        sb.append(str);
        String string = b.getString(sb.toString(), null);
        if (string == null) {
            return null;
        }
        return C5302d.m21778e(string);
    }

    /* renamed from: e */
    public static void m21759e(String str) {
        Editor edit = m21755b().edit();
        StringBuilder sb = new StringBuilder("bo/");
        sb.append(str);
        edit.remove(sb.toString());
        edit.commit();
    }
}
