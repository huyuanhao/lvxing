package com.tencent.android.tpush.service.channel.p591a;

import com.tencent.android.tpush.service.channel.p591a.C7001a.C7002a;
import com.tencent.android.tpush.service.channel.p592b.C7022b;
import java.nio.channels.SocketChannel;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.a.c */
public class C7004c extends C7003b {
    public C7004c(SocketChannel socketChannel, C7002a aVar, String str, int i) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(str);
        if (i == 80) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(":");
            sb2.append(i);
            str2 = sb2.toString();
        }
        sb.append(str2);
        sb.append("/");
        super(socketChannel, aVar, str, i, sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo33371a() {
        return super.mo33371a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo33372b() {
        if (this.f23252f == null && super.mo33372b()) {
            ((C7022b) this.f23252f).mo33419a("X-Online-Host", this.f23260m);
        }
        return this.f23252f != null;
    }
}
