package com.bytedance.sdk.p145a.p147b.p148a.p150b;

import com.bytedance.sdk.p145a.p147b.Address;
import com.bytedance.sdk.p145a.p147b.Call;
import com.bytedance.sdk.p145a.p147b.EventListener;
import com.bytedance.sdk.p145a.p147b.HttpUrl;
import com.bytedance.sdk.p145a.p147b.Route;
import com.bytedance.sdk.p145a.p147b.p148a.C1876c;
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

/* renamed from: com.bytedance.sdk.a.b.a.b.f */
public final class RouteSelector {
    /* renamed from: a */
    private final Address f5372a;
    /* renamed from: b */
    private final RouteDatabase f5373b;
    /* renamed from: c */
    private final Call f5374c;
    /* renamed from: d */
    private final EventListener f5375d;
    /* renamed from: e */
    private List<Proxy> f5376e = Collections.emptyList();
    /* renamed from: f */
    private int f5377f;
    /* renamed from: g */
    private List<InetSocketAddress> f5378g = Collections.emptyList();
    /* renamed from: h */
    private final List<Route> f5379h = new ArrayList();

    /* compiled from: RouteSelector */
    /* renamed from: com.bytedance.sdk.a.b.a.b.f$a */
    public static final class C1874a {
        /* renamed from: a */
        private final List<Route> f5380a;
        /* renamed from: b */
        private int f5381b = 0;

        C1874a(List<Route> list) {
            this.f5380a = list;
        }

        /* renamed from: a */
        public boolean mo13708a() {
            return this.f5381b < this.f5380a.size();
        }

        /* renamed from: b */
        public Route mo13709b() {
            if (mo13708a()) {
                List<Route> list = this.f5380a;
                int i = this.f5381b;
                this.f5381b = i + 1;
                return (Route) list.get(i);
            }
            throw new NoSuchElementException();
        }

        /* renamed from: c */
        public List<Route> mo13710c() {
            return new ArrayList(this.f5380a);
        }
    }

    public RouteSelector(Address aVar, RouteDatabase dVar, Call hVar, EventListener sVar) {
        this.f5372a = aVar;
        this.f5373b = dVar;
        this.f5374c = hVar;
        this.f5375d = sVar;
        m6920a(aVar.mo13639a(), aVar.mo13648h());
    }

    /* renamed from: a */
    public boolean mo13706a() {
        return m6922c() || !this.f5379h.isEmpty();
    }

    /* renamed from: b */
    public C1874a mo13707b() throws IOException {
        if (mo13706a()) {
            ArrayList arrayList = new ArrayList();
            while (m6922c()) {
                Proxy d = m6923d();
                int size = this.f5378g.size();
                for (int i = 0; i < size; i++) {
                    Route dVar = new Route(this.f5372a, d, (InetSocketAddress) this.f5378g.get(i));
                    if (this.f5373b.mo13702c(dVar)) {
                        this.f5379h.add(dVar);
                    } else {
                        arrayList.add(dVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f5379h);
                this.f5379h.clear();
            }
            return new C1874a(arrayList);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public void mo13705a(Route dVar, IOException iOException) {
        if (!(dVar.mo13970b().type() == Type.DIRECT || this.f5372a.mo13647g() == null)) {
            this.f5372a.mo13647g().connectFailed(this.f5372a.mo13639a().mo14084a(), dVar.mo13970b().address(), iOException);
        }
        this.f5373b.mo13700a(dVar);
    }

    /* renamed from: a */
    private void m6920a(HttpUrl vVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f5376e = Collections.singletonList(proxy);
        } else {
            List select = this.f5372a.mo13647g().select(vVar.mo14084a());
            if (select == null || select.isEmpty()) {
                list = C1876c.m6958a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C1876c.m6957a(select);
            }
            this.f5376e = list;
        }
        this.f5377f = 0;
    }

    /* renamed from: c */
    private boolean m6922c() {
        return this.f5377f < this.f5376e.size();
    }

    /* renamed from: d */
    private Proxy m6923d() throws IOException {
        if (m6922c()) {
            List<Proxy> list = this.f5376e;
            int i = this.f5377f;
            this.f5377f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m6921a(proxy);
            return proxy;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.f5372a.mo13639a().mo14092f());
        sb.append("; exhausted proxy configurations: ");
        sb.append(this.f5376e);
        throw new SocketException(sb.toString());
    }

    /* renamed from: a */
    private void m6921a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f5378g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.f5372a.mo13639a().mo14092f();
            i = this.f5372a.mo13639a().mo14093g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m6919a(inetSocketAddress);
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
            this.f5378g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f5375d.mo14051a(this.f5374c, str);
            List a = this.f5372a.mo13641b().mo14043a(str);
            if (!a.isEmpty()) {
                this.f5375d.mo14052a(this.f5374c, str, a);
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f5378g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f5372a.mo13641b());
            sb3.append(" returned no addresses for ");
            sb3.append(str);
            throw new UnknownHostException(sb3.toString());
        }
    }

    /* renamed from: a */
    static String m6919a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
