package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.C8357a;
import okhttp3.C8367ad;
import okhttp3.C8379e;
import okhttp3.C8498p;
import okhttp3.C8506t;
import okhttp3.internal.C8417c;

/* compiled from: RouteSelector */
/* renamed from: okhttp3.internal.connection.e */
public final class C8432e {
    /* renamed from: a */
    private final C8357a f28594a;
    /* renamed from: b */
    private final C8431d f28595b;
    /* renamed from: c */
    private final C8379e f28596c;
    /* renamed from: d */
    private final C8498p f28597d;
    /* renamed from: e */
    private List<Proxy> f28598e = Collections.emptyList();
    /* renamed from: f */
    private int f28599f;
    /* renamed from: g */
    private List<InetSocketAddress> f28600g = Collections.emptyList();
    /* renamed from: h */
    private final List<C8367ad> f28601h = new ArrayList();

    /* compiled from: RouteSelector */
    /* renamed from: okhttp3.internal.connection.e$a */
    public static final class C8433a {
        /* renamed from: a */
        private final List<C8367ad> f28602a;
        /* renamed from: b */
        private int f28603b = 0;

        C8433a(List<C8367ad> list) {
            this.f28602a = list;
        }

        /* renamed from: a */
        public boolean mo40296a() {
            return this.f28603b < this.f28602a.size();
        }

        /* renamed from: b */
        public C8367ad mo40297b() {
            if (mo40296a()) {
                List<C8367ad> list = this.f28602a;
                int i = this.f28603b;
                this.f28603b = i + 1;
                return (C8367ad) list.get(i);
            }
            throw new NoSuchElementException();
        }

        /* renamed from: c */
        public List<C8367ad> mo40298c() {
            return new ArrayList(this.f28602a);
        }
    }

    public C8432e(C8357a aVar, C8431d dVar, C8379e eVar, C8498p pVar) {
        this.f28594a = aVar;
        this.f28595b = dVar;
        this.f28596c = eVar;
        this.f28597d = pVar;
        m36112a(aVar.mo40068a(), aVar.mo40077h());
    }

    /* renamed from: a */
    public boolean mo40294a() {
        return m36113c() || !this.f28601h.isEmpty();
    }

    /* renamed from: b */
    public C8433a mo40295b() throws IOException {
        if (mo40294a()) {
            ArrayList arrayList = new ArrayList();
            while (m36113c()) {
                Proxy d = m36114d();
                int size = this.f28600g.size();
                for (int i = 0; i < size; i++) {
                    C8367ad adVar = new C8367ad(this.f28594a, d, (InetSocketAddress) this.f28600g.get(i));
                    if (this.f28595b.mo40292c(adVar)) {
                        this.f28601h.add(adVar);
                    } else {
                        arrayList.add(adVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f28601h);
                this.f28601h.clear();
            }
            return new C8433a(arrayList);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public void mo40293a(C8367ad adVar, IOException iOException) {
        if (!(adVar.mo40131b().type() == Type.DIRECT || this.f28594a.mo40076g() == null)) {
            this.f28594a.mo40076g().connectFailed(this.f28594a.mo40068a().mo40548a(), adVar.mo40131b().address(), iOException);
        }
        this.f28595b.mo40290a(adVar);
    }

    /* renamed from: a */
    private void m36112a(C8506t tVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f28598e = Collections.singletonList(proxy);
        } else {
            List select = this.f28594a.mo40076g().select(tVar.mo40548a());
            if (select == null || select.isEmpty()) {
                list = C8417c.m36035a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C8417c.m36034a(select);
            }
            this.f28598e = list;
        }
        this.f28599f = 0;
    }

    /* renamed from: c */
    private boolean m36113c() {
        return this.f28599f < this.f28598e.size();
    }

    /* renamed from: d */
    private Proxy m36114d() throws IOException {
        if (m36113c()) {
            List<Proxy> list = this.f28598e;
            int i = this.f28599f;
            this.f28599f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m36111a(proxy);
            return proxy;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.f28594a.mo40068a().mo40556f());
        sb.append("; exhausted proxy configurations: ");
        sb.append(this.f28598e);
        throw new SocketException(sb.toString());
    }

    /* renamed from: a */
    private void m36111a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f28600g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.f28594a.mo40068a().mo40556f();
            i = this.f28594a.mo40068a().mo40557g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m36110a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Proxy.address() is not an InetSocketAddress: ");
                sb.append(address.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i < 1 || i > 65535) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No route to ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i);
            sb2.append("; port is out of range");
            throw new SocketException(sb2.toString());
        } else if (proxy.type() == Type.SOCKS) {
            this.f28600g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f28597d.mo40499a(this.f28596c, str);
            List a = this.f28594a.mo40070b().mo40495a(str);
            if (!a.isEmpty()) {
                this.f28597d.mo40500a(this.f28596c, str, a);
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f28600g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f28594a.mo40070b());
            sb3.append(" returned no addresses for ");
            sb3.append(str);
            throw new UnknownHostException(sb3.toString());
        }
    }

    /* renamed from: a */
    static String m36110a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
