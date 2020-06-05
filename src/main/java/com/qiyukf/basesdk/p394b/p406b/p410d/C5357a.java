package com.qiyukf.basesdk.p394b.p406b.p410d;

import android.util.SparseArray;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5321a;
import com.qiyukf.basesdk.p394b.p406b.p407a.C5323c;
import com.qiyukf.basesdk.p394b.p406b.p411e.C5360a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.b.b.d.a */
public final class C5357a {
    /* renamed from: a */
    private C5321a f17292a;
    /* renamed from: b */
    private SocketChannel f17293b;
    /* renamed from: c */
    private SelectionKey f17294c;
    /* renamed from: d */
    private boolean f17295d = false;
    /* renamed from: e */
    private final List<C5359a> f17296e = new LinkedList();

    /* renamed from: com.qiyukf.basesdk.b.b.d.a$a */
    private static class C5359a {
        /* renamed from: a */
        ByteBuffer f17298a;
        /* renamed from: b */
        C5323c f17299b;

        C5359a(ByteBuffer byteBuffer, C5323c cVar) {
            this.f17298a = byteBuffer;
            this.f17299b = cVar;
        }
    }

    public C5357a(C5321a aVar) {
        this.f17292a = aVar;
    }

    /* renamed from: b */
    private boolean m21998b(SocketAddress socketAddress) {
        try {
            boolean connect = this.f17293b.connect(socketAddress);
            if (!connect) {
                this.f17294c.interestOps(8);
            }
            return connect;
        } catch (Throwable th) {
            try {
                this.f17293b.close();
            } catch (IOException unused) {
            }
            throw th;
        }
    }

    /* renamed from: b */
    private boolean m21999b(ByteBuffer byteBuffer, C5323c cVar) {
        boolean z = true;
        if (byteBuffer.remaining() == 0) {
            cVar.mo27237b();
            return true;
        }
        int i = 9;
        while (true) {
            if (i >= 16) {
                z = false;
                break;
            }
            try {
                if (this.f17293b.write(byteBuffer) == 0) {
                    break;
                } else if (byteBuffer.remaining() <= 0) {
                    cVar.mo27237b();
                    return true;
                } else {
                    i++;
                }
            } catch (Throwable th) {
                this.f17292a.mo27226a().mo27258a(th);
            }
        }
        if (z) {
            this.f17294c.interestOps(4);
        } else {
            this.f17292a.mo27229c().execute(new Runnable() {
                public final void run() {
                    C5357a.this.mo27312d();
                }
            });
        }
        return false;
    }

    /* renamed from: a */
    public final int mo27304a(ByteBuffer byteBuffer) {
        return this.f17293b.read(byteBuffer);
    }

    /* renamed from: a */
    public final SelectionKey mo27305a(Selector selector, C5321a aVar) {
        this.f17294c = this.f17293b.register(selector, 0, aVar);
        return this.f17294c;
    }

    /* renamed from: a */
    public final <T> void mo27306a(SparseArray<Object> sparseArray) {
        this.f17293b = SelectorProvider.provider().openSocketChannel();
        this.f17293b.configureBlocking(false);
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            Object valueAt = sparseArray.valueAt(i);
            if (keyAt == 4098) {
                this.f17293b.socket().setReceiveBufferSize(((Integer) valueAt).intValue());
            } else if (keyAt == 4097) {
                this.f17293b.socket().setSendBufferSize(((Integer) valueAt).intValue());
            } else {
                boolean z = true;
                if (keyAt == 1) {
                    this.f17293b.socket().setTcpNoDelay(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 8) {
                    this.f17293b.socket().setKeepAlive(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 4) {
                    this.f17293b.socket().setReuseAddress(((Boolean) valueAt).booleanValue());
                } else if (keyAt == 128) {
                    int intValue = ((Integer) valueAt).intValue();
                    Socket socket = this.f17293b.socket();
                    if (intValue <= 0) {
                        z = false;
                    }
                    socket.setSoLinger(z, intValue);
                } else if (keyAt == 3) {
                    this.f17293b.socket().setTrafficClass(((Integer) valueAt).intValue());
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27307a(ByteBuffer byteBuffer, C5323c cVar) {
        this.f17296e.add(new C5359a(byteBuffer, cVar));
        mo27312d();
    }

    /* renamed from: a */
    public final boolean mo27308a() {
        SocketChannel socketChannel = this.f17293b;
        return socketChannel != null && socketChannel.isOpen();
    }

    /* renamed from: a */
    public final boolean mo27309a(SocketAddress socketAddress) {
        return m21998b(socketAddress);
    }

    /* renamed from: b */
    public final boolean mo27310b() {
        SocketChannel socketChannel = this.f17293b;
        return socketChannel != null && socketChannel.isOpen() && this.f17293b.isConnected();
    }

    /* renamed from: c */
    public final void mo27311c() {
        this.f17293b.close();
        for (C5359a aVar : this.f17296e) {
            aVar.f17299b.mo27236a((Throwable) C5360a.m22011a(this.f17292a));
        }
        this.f17296e.clear();
    }

    /* renamed from: d */
    public final void mo27312d() {
        if (!this.f17295d) {
            this.f17295d = true;
            Iterator it = this.f17296e.iterator();
            while (it.hasNext()) {
                C5359a aVar = (C5359a) it.next();
                if (!m21999b(aVar.f17298a, aVar.f17299b)) {
                    break;
                }
                it.remove();
            }
            this.f17295d = false;
        }
    }

    /* renamed from: e */
    public final boolean mo27313e() {
        return this.f17295d;
    }

    /* renamed from: f */
    public final void mo27314f() {
        if (!this.f17293b.finishConnect()) {
            throw new Error();
        }
    }
}
