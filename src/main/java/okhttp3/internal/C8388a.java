package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.C8357a;
import okhttp3.C8362ab.C8363a;
import okhttp3.C8367ad;
import okhttp3.C8488j;
import okhttp3.C8490k;
import okhttp3.C8504s.C8505a;
import okhttp3.internal.connection.C8430c;
import okhttp3.internal.connection.C8431d;
import okhttp3.internal.connection.C8434f;

/* compiled from: Internal */
/* renamed from: okhttp3.internal.a */
public abstract class C8388a {
    /* renamed from: a */
    public static C8388a f28432a;

    /* renamed from: a */
    public abstract int mo40192a(C8363a aVar);

    /* renamed from: a */
    public abstract Socket mo40193a(C8488j jVar, C8357a aVar, C8434f fVar);

    /* renamed from: a */
    public abstract C8430c mo40194a(C8488j jVar, C8357a aVar, C8434f fVar, C8367ad adVar);

    /* renamed from: a */
    public abstract C8431d mo40195a(C8488j jVar);

    /* renamed from: a */
    public abstract void mo40196a(C8490k kVar, SSLSocket sSLSocket, boolean z);

    /* renamed from: a */
    public abstract void mo40197a(C8505a aVar, String str);

    /* renamed from: a */
    public abstract void mo40198a(C8505a aVar, String str, String str2);

    /* renamed from: a */
    public abstract boolean mo40199a(C8357a aVar, C8357a aVar2);

    /* renamed from: a */
    public abstract boolean mo40200a(C8488j jVar, C8430c cVar);

    /* renamed from: b */
    public abstract void mo40201b(C8488j jVar, C8430c cVar);
}
