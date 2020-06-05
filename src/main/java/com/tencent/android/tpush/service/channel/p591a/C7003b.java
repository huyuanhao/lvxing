package com.tencent.android.tpush.service.channel.p591a;

import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.InnerException;
import com.tencent.android.tpush.service.channel.p591a.C7001a.C7002a;
import com.tencent.android.tpush.service.channel.p592b.C7021a;
import com.tencent.android.tpush.service.channel.p592b.C7022b;
import com.tencent.android.tpush.service.channel.p592b.C7024d;
import com.tencent.android.tpush.service.channel.p592b.C7025e;
import com.tencent.android.tpush.service.channel.p592b.C7028h;
import com.tencent.android.tpush.service.channel.p592b.C7029i;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.a.b */
public class C7003b extends C7001a {
    /* renamed from: l */
    protected String f23259l = null;
    /* renamed from: m */
    protected String f23260m = null;
    /* renamed from: n */
    private boolean f23261n = false;

    public C7003b(SocketChannel socketChannel, C7002a aVar) {
        String str;
        super(socketChannel, aVar);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23253g);
        if (this.f23254h == 80) {
            str = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(":");
            sb2.append(this.f23254h);
            str = sb2.toString();
        }
        sb.append(str);
        this.f23260m = sb.toString();
        this.f23259l = "/";
        this.f23255i = 1;
    }

    protected C7003b(SocketChannel socketChannel, C7002a aVar, String str, int i, String str2) {
        String str3;
        super(socketChannel, aVar);
        this.f23253g = str;
        this.f23254h = i;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (i == 80) {
            str3 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(":");
            sb2.append(i);
            str3 = sb2.toString();
        }
        sb.append(str3);
        this.f23260m = sb.toString();
        this.f23259l = str2;
    }

    /* renamed from: a */
    public void mo33369a(C7001a aVar, C7024d dVar) {
        if (dVar instanceof C7021a) {
            Iterator it = ((C7021a) dVar).f23336i.iterator();
            while (it.hasNext()) {
                C7029i iVar = (C7029i) it.next();
                StringBuilder sb = new StringBuilder();
                sb.append("clientDidReceivePacket  httppacket ");
                sb.append(iVar);
                C6864a.m29298c("TpnsHttpClient-Type", sb.toString());
                this.f23247a.mo33387b(aVar, iVar);
            }
            mo33373c();
            return;
        }
        throw new InnerException("packet is not instance of Http****Packet!");
    }

    /* renamed from: a */
    public void mo33370a(C7001a aVar, C7025e eVar) {
        this.f23261n = true;
        if (eVar instanceof C7022b) {
            C7022b bVar = (C7022b) eVar;
            StringBuilder sb = new StringBuilder();
            sb.append("clientDidSendPacket send httppacket ");
            sb.append(bVar);
            C6864a.m29298c("TpnsHttpClient-Type", sb.toString());
            Iterator it = bVar.f23342d.iterator();
            while (it.hasNext()) {
                C7025e eVar2 = (C7025e) it.next();
                if ((((C7028h) eVar2).mo33447h() & 127) != 7) {
                    this.f23247a.mo33384a(aVar, (C7029i) eVar2);
                }
            }
            return;
        }
        throw new InnerException("packet is not instance of Http****Packet!");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33372b() {
        if (this.f23252f == null && !this.f23261n) {
            ArrayList a = this.f23247a.mo33382a((C7001a) this, 16);
            if (a.size() > 0) {
                C7022b bVar = new C7022b(this.f23260m, this.f23259l);
                bVar.mo33423a(this.f23250d);
                bVar.mo33419a("Host", this.f23260m);
                bVar.mo33419a("User-Agent", "TPNS_CLIENT/0.1");
                bVar.mo33419a("Content-Type", "application/binary");
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    bVar.mo33418a((C7025e) (C7028h) it.next());
                }
                this.f23252f = bVar;
            }
        }
        return this.f23252f != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33371a() {
        boolean z = false;
        if (!this.f23261n) {
            return false;
        }
        if (this.f23251e == null) {
            this.f23251e = new C7021a();
            this.f23251e.mo33423a(this.f23250d);
        }
        if (this.f23251e != null) {
            z = true;
        }
        return z;
    }
}
