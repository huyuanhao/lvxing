package org.apache.thrift.transport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import org.slf4j.C8580b;
import org.slf4j.LoggerFactory;

/* renamed from: org.apache.thrift.transport.e */
public class TSocket extends TIOStreamTransport {
    /* renamed from: c */
    private static final C8580b f29196c = LoggerFactory.m37316a(TSocket.class.getName());
    /* renamed from: d */
    private Socket f29197d;
    /* renamed from: e */
    private String f29198e;
    /* renamed from: f */
    private int f29199f;
    /* renamed from: g */
    private int f29200g;
    /* renamed from: h */
    private int f29201h;

    public TSocket(String str, int i, int i2) {
        this(str, i, i2, i2);
    }

    public TSocket(String str, int i, int i2, int i3) {
        this.f29198e = str;
        this.f29199f = i;
        this.f29200g = i2;
        this.f29201h = i3;
        m37285g();
    }

    /* renamed from: g */
    private void m37285g() {
        this.f29197d = new Socket();
        try {
            this.f29197d.setSoLinger(false, 0);
            this.f29197d.setTcpNoDelay(true);
            this.f29197d.setKeepAlive(true);
            this.f29197d.setSoTimeout(this.f29200g);
        } catch (SocketException e) {
            f29196c.error("Could not configure socket.", (Throwable) e);
        }
    }

    /* renamed from: a */
    public boolean mo40953a() {
        Socket socket = this.f29197d;
        if (socket == null) {
            return false;
        }
        return socket.isConnected();
    }

    /* renamed from: f */
    public void mo40978f() throws TTransportException {
        if (!mo40953a()) {
            String str = this.f29198e;
            if (str == null || str.length() == 0) {
                throw new TTransportException(1, "Cannot open null host.");
            }
            int i = this.f29199f;
            if (i <= 0 || i > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid port ");
                sb.append(this.f29199f);
                throw new TTransportException(1, sb.toString());
            }
            if (this.f29197d == null) {
                m37285g();
            }
            try {
                this.f29197d.connect(new InetSocketAddress(this.f29198e, this.f29199f), this.f29201h);
                this.f29191a = new BufferedInputStream(this.f29197d.getInputStream(), 1024);
                this.f29192b = new BufferedOutputStream(this.f29197d.getOutputStream(), 1024);
            } catch (IOException e) {
                close();
                throw new TTransportException(1, (Throwable) e);
            }
        } else {
            throw new TTransportException(2, "Socket already connected.");
        }
    }

    public void close() {
        super.close();
        Socket socket = this.f29197d;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                f29196c.warn("Could not close socket.", (Throwable) e);
            }
            this.f29197d = null;
        }
    }
}
