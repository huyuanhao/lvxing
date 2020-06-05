package ezy.app.p643a;

import ezy.app.data.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo39189d2 = {"Lezy/app/net/Session;", "", "()V", "callback", "Lezy/app/net/Session$Callback;", "expiration", "", "token", "Lezy/app/data/Token;", "getToken", "()Lezy/app/data/Token;", "setToken", "(Lezy/app/data/Token;)V", "tokenStore", "Lezy/app/net/Session$TokenStore;", "init", "", "store", "isExpired", "", "isLoggedIn", "login", "tk", "logout", "refresh", "resume", "set", "Callback", "TokenStore", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.a.b */
public final class Session {
    /* renamed from: a */
    public static final Session f27256a = new Session();
    /* renamed from: b */
    private static C8018b f27257b;
    /* renamed from: c */
    private static C8017a f27258c;
    /* renamed from: d */
    private static Token f27259d;
    /* renamed from: e */
    private static long f27260e;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, mo39189d2 = {"Lezy/app/net/Session$Callback;", "", "onAuthorised", "", "type", "", "onExpired", "onUnauthorised", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Session.kt */
    /* renamed from: ezy.app.a.b$a */
    public interface C8017a {
        /* renamed from: a */
        void mo19827a();

        /* renamed from: a */
        void mo19828a(int i);

        /* renamed from: b */
        void mo19829b();
    }

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo39189d2 = {"Lezy/app/net/Session$TokenStore;", "", "read", "Lezy/app/data/Token;", "save", "", "token", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Session.kt */
    /* renamed from: ezy.app.a.b$b */
    public interface C8018b {
        /* renamed from: a */
        Token mo19825a();

        /* renamed from: a */
        void mo19826a(Token token);
    }

    private Session() {
    }

    /* renamed from: a */
    public final Token mo38534a() {
        return f27259d;
    }

    /* renamed from: a */
    public final void mo38535a(C8018b bVar, C8017a aVar) {
        C8271i.m35386b(bVar, "store");
        C8271i.m35386b(aVar, "callback");
        f27257b = bVar;
        f27258c = aVar;
    }

    /* renamed from: b */
    public final boolean mo38538b() {
        Token token = f27259d;
        return (token != null ? token.getAccessToken() : null) != null;
    }

    /* renamed from: c */
    public final boolean mo38540c() {
        if (System.currentTimeMillis() <= f27260e) {
            Token token = f27259d;
            if ((token != null ? token.getAccessToken() : null) != null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public final void mo38541d() {
        C8018b bVar = f27257b;
        mo38536a(bVar != null ? bVar.mo19825a() : null);
    }

    /* renamed from: a */
    public final void mo38536a(Token token) {
        m34761d(token);
        if (!mo38538b()) {
            return;
        }
        if (mo38540c()) {
            C8017a aVar = f27258c;
            if (aVar != null) {
                aVar.mo19827a();
                return;
            }
            return;
        }
        C8017a aVar2 = f27258c;
        if (aVar2 != null) {
            aVar2.mo19828a(1);
        }
    }

    /* renamed from: b */
    public final void mo38537b(Token token) {
        C8271i.m35386b(token, "tk");
        m34761d(token);
        C8017a aVar = f27258c;
        if (aVar != null) {
            aVar.mo19828a(2);
        }
    }

    /* renamed from: c */
    public final void mo38539c(Token token) {
        C8271i.m35386b(token, "tk");
        m34761d(token);
        C8017a aVar = f27258c;
        if (aVar != null) {
            aVar.mo19828a(0);
        }
    }

    /* renamed from: e */
    public final void mo38542e() {
        C8017a aVar = f27258c;
        if (aVar != null) {
            aVar.mo19829b();
        }
        Token token = new Token(null, null, 0, 7, null);
        m34761d(token);
    }

    /* renamed from: d */
    private final void m34761d(Token token) {
        if (token != null) {
            f27260e = System.currentTimeMillis() + ((long) (token.getExpiresIn() * 1000));
            C8018b bVar = f27257b;
            if (bVar != null) {
                bVar.mo19826a(token);
            }
        } else {
            token = null;
        }
        f27259d = token;
    }
}
