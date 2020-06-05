package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C8367ad;

/* compiled from: RouteDatabase */
/* renamed from: okhttp3.internal.connection.d */
public final class C8431d {
    /* renamed from: a */
    private final Set<C8367ad> f28593a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo40290a(C8367ad adVar) {
        this.f28593a.add(adVar);
    }

    /* renamed from: b */
    public synchronized void mo40291b(C8367ad adVar) {
        this.f28593a.remove(adVar);
    }

    /* renamed from: c */
    public synchronized boolean mo40292c(C8367ad adVar) {
        return this.f28593a.contains(adVar);
    }
}
