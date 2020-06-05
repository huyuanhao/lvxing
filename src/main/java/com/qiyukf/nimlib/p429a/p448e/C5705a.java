package com.qiyukf.nimlib.p429a.p448e;

import android.text.TextUtils;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p429a.C5645a;
import com.qiyukf.nimlib.p429a.C5668c;
import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p429a.p436c.p439c.C5677a;
import com.qiyukf.nimlib.p451c.C5742c;
import com.qiyukf.nimlib.p469e.C5805a;
import com.qiyukf.nimlib.p469e.C5814f;
import com.qiyukf.nimlib.p469e.C5816h;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.sdk.auth.OnlineClient;
import com.qiyukf.unicorn.api.SavePowerConfig;

/* renamed from: com.qiyukf.nimlib.a.e.a */
public class C5705a extends C5816h implements AuthService {
    public void changeSaverMode(int i) {
        C5668c.m22861a().mo27857a(i);
    }

    public int getKickedClientType() {
        return C5743d.m23123h();
    }

    public InvocationFuture<Void> kickOtherClient(OnlineClient onlineClient) {
        if (onlineClient instanceof C5645a) {
            C5677a aVar = new C5677a(((C5645a) onlineClient).mo27834a());
            aVar.mo27871a(m23333b());
            C5668c.m22861a().mo27864a((C5669a) aVar);
        }
        return null;
    }

    public AbortableFuture<LoginInfo> login(LoginInfo loginInfo) {
        C5668c.m22861a().mo27859a(m23333b(), loginInfo);
        return new C5814f<LoginInfo>(loginInfo) {
            public final boolean abort() {
                C5705a.this.logout();
                return false;
            }
        };
    }

    public InvocationFuture<Void> logout() {
        C5668c.m22861a().mo27868c();
        C5805a.m23315c(m23333b().mo28116b((Object) null));
        return null;
    }

    public boolean openLocalCache(String str) {
        if (C5742c.m23101a().mo28016b()) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return C5742c.m23101a().mo28015a(C5718b.m23009a(), str);
    }

    public void updateSavePowerConfig(SavePowerConfig savePowerConfig) {
        C5668c.m22861a().mo27862a(savePowerConfig);
    }
}
