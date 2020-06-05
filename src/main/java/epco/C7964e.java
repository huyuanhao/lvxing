package epco;

import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import epco.C7944a.C7946b;

/* renamed from: epco.e */
public class C7964e implements C7982l {
    /* renamed from: a */
    private final C7946b f27067a = C7944a.m34364a();

    /* renamed from: a */
    public C7944a mo38311a() {
        return this.f27067a.mo38250a();
    }

    /* renamed from: a */
    public void mo38312a(C7975i0 i0Var) {
    }

    /* renamed from: a */
    public void mo38313a(C7981k0 k0Var) {
    }

    /* renamed from: a */
    public void mo38314a(C7983l0 l0Var) {
    }

    /* renamed from: a */
    public void mo38315a(C7985m0 m0Var) {
    }

    /* renamed from: a */
    public void mo38316a(C7989o0 o0Var) {
        C7973h0 a = o0Var.mo38402a();
        String b = o0Var.mo38405b();
        if (b.equals("application")) {
            this.f27067a.mo38252c(a.mo38352a("label"));
            this.f27067a.mo38251b(a.mo38352a("icon"));
        } else if (b.equals("manifest")) {
            this.f27067a.mo38253d(a.mo38352a("package"));
            this.f27067a.mo38254e(a.mo38352a("versionName"));
            this.f27067a.mo38248a(a.mo38357c(AppEntity.KEY_VERSION_CODE_INT));
        } else if (b.equals("uses-permission")) {
            this.f27067a.mo38249a(a.mo38352a(ArgKey.KEY_NAME));
        }
    }
}
