package com.qiyukf.nimlib.p473h.p478b;

import android.content.Context;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.nimlib.p429a.p436c.C5669a.C5670a;
import com.qiyukf.nimlib.p429a.p442d.C5686a.C5687a;
import com.qiyukf.nimlib.p473h.p474a.p476b.C5852a;
import com.qiyukf.nimlib.p473h.p474a.p477c.C5857a;
import com.qiyukf.nimlib.p473h.p481c.C5888a;
import com.qiyukf.nimlib.p473h.p481c.p482a.C5889a;
import com.qiyukf.nimlib.p473h.p481c.p482a.C5890b;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5896d;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5897e;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5898f;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5899g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.zip.Deflater;

/* renamed from: com.qiyukf.nimlib.h.b.d */
public final class C5880d {
    /* renamed from: a */
    private Context f18617a;
    /* renamed from: b */
    private C5882b f18618b;
    /* renamed from: c */
    private boolean f18619c;
    /* renamed from: d */
    private C5670a f18620d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5864a f18621e;
    /* renamed from: f */
    private C5883c f18622f;
    /* renamed from: g */
    private C5884d f18623g;

    /* renamed from: com.qiyukf.nimlib.h.b.d$a */
    private class C5881a {
        /* access modifiers changed from: private|final */
        /* renamed from: b */
        public final byte[] f18625b;
        /* renamed from: c */
        private final C5889a f18626c = new C5889a(this.f18625b);
        /* renamed from: d */
        private final C5889a f18627d = new C5889a(this.f18625b);

        C5881a() {
            byte[] bArr = new byte[16];
            new SecureRandom(SecureRandom.getSeed(32)).nextBytes(bArr);
            this.f18625b = bArr;
        }

        /* renamed from: a */
        public final void mo28211a(byte[] bArr, int i, int i2) {
            this.f18627d.mo28238a(bArr, i, i2);
        }
    }

    /* renamed from: com.qiyukf.nimlib.h.b.d$b */
    public interface C5882b {
        /* renamed from: a */
        void mo28194a();

        /* renamed from: a */
        void mo28195a(C5670a aVar, boolean z);
    }

    /* renamed from: com.qiyukf.nimlib.h.b.d$c */
    private class C5883c {
        /* renamed from: b */
        private final C5881a f18629b;
        /* renamed from: c */
        private final PublicKey f18630c;

        public C5883c(C5881a aVar, PublicKey publicKey) {
            this.f18629b = aVar;
            this.f18630c = publicKey;
        }

        /* renamed from: a */
        public final C5670a mo28212a(C5670a aVar) {
            byte[] bArr;
            if (aVar == null) {
                bArr = null;
            } else {
                C5894b bVar = new C5894b();
                bVar.mo28257b(this.f18629b.f18625b);
                bVar.mo28251a(C5880d.m23546a(aVar, false).mo28258b());
                bArr = C5890b.m23589a(this.f18630c, bVar.mo28258b().array(), 0, bVar.mo28245a());
            }
            C5852a aVar2 = new C5852a(C5880d.this.f18621e.f18575a, bArr);
            return new C5670a(aVar2.mo27870a(), aVar2.mo27872b().mo28258b());
        }

        /* renamed from: a */
        public final C5894b mo28213a(C5670a aVar, boolean z) {
            C5894b a = C5880d.m23546a(aVar, true);
            StringBuilder sb = new StringBuilder("send ");
            sb.append(aVar.f18204a);
            C5264a.m21617a("core", sb.toString());
            if (!z) {
                this.f18629b.f18626c.mo28238a(a.mo28258b().array(), 0, a.mo28245a());
            }
            return a;
        }
    }

    /* renamed from: com.qiyukf.nimlib.h.b.d$d */
    private class C5884d {
        /* renamed from: b */
        private final C5881a f18632b;
        /* renamed from: c */
        private final byte[] f18633c = new byte[4];
        /* renamed from: d */
        private int f18634d;

        C5884d(C5881a aVar) {
            this.f18632b = aVar;
            this.f18634d = -1;
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final void mo28214a() {
            this.f18634d = -1;
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final byte[] mo28215a(ByteBuffer byteBuffer) {
            byte b;
            if (this.f18634d <= 5) {
                if (byteBuffer.remaining() < 4) {
                    return null;
                }
                byteBuffer.get(this.f18633c);
                this.f18632b.mo28211a(this.f18633c, 0, 4);
                byte[] bArr = this.f18633c;
                int i = 0;
                int i2 = 0;
                int i3 = 1;
                do {
                    b = bArr[i];
                    i2 += (b & Byte.MAX_VALUE) * i3;
                    i3 <<= 7;
                    i++;
                } while ((b & Byte.MIN_VALUE) != 0);
                this.f18634d = i2;
                int i4 = this.f18634d;
                if (i4 > 5) {
                    this.f18634d = i4 + C5896d.m23618b(i4);
                } else {
                    this.f18634d = -1;
                    throw new C5899g();
                }
            }
            C5264a.m21620b("core", String.format("received packetSize: %d, readableBytes: %d", new Object[]{Integer.valueOf(this.f18634d), Integer.valueOf(byteBuffer.remaining())}));
            int i5 = this.f18634d - 4;
            if (byteBuffer.remaining() < i5) {
                return null;
            }
            byte[] bArr2 = new byte[this.f18634d];
            System.arraycopy(this.f18633c, 0, bArr2, 0, 4);
            byteBuffer.get(bArr2, 4, i5);
            this.f18632b.mo28211a(bArr2, 4, i5);
            this.f18634d = -1;
            return bArr2;
        }
    }

    public C5880d(Context context, C5882b bVar) {
        this.f18617a = context.getApplicationContext();
        this.f18618b = bVar;
        m23547c();
    }

    /* renamed from: a */
    static /* synthetic */ C5894b m23546a(C5670a aVar, boolean z) {
        C5894b bVar = new C5894b();
        int limit = aVar.f18205b.limit();
        ByteBuffer byteBuffer = aVar.f18205b;
        if (z && limit >= 1024 && !aVar.f18204a.mo28228c()) {
            ByteBuffer byteBuffer2 = aVar.f18205b;
            byte[] array = byteBuffer2.array();
            int position = byteBuffer2.position();
            int limit2 = byteBuffer2.limit() - byteBuffer2.position();
            byte[] bArr = new byte[(limit2 + 4 + (limit2 / 1000) + 12)];
            Deflater deflater = new Deflater();
            deflater.setInput(array, position, limit2);
            deflater.finish();
            int deflate = deflater.deflate(bArr);
            deflater.end();
            byteBuffer = ByteBuffer.allocate(deflate + 4);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putInt(limit2);
            byteBuffer.put(bArr, 0, deflate);
            byteBuffer.flip();
            limit = byteBuffer.limit();
            aVar.f18204a.mo28230e();
        }
        C5888a aVar2 = aVar.f18204a;
        int i = 5;
        if (aVar.f18204a.mo28229d()) {
            i = 7;
        }
        aVar2.mo28222a(i + limit);
        bVar.mo28249a((C5891a) aVar.f18204a);
        bVar.mo28251a(byteBuffer);
        return bVar;
    }

    /* renamed from: c */
    private void m23547c() {
        this.f18621e = C5864a.m23485a(this.f18617a);
        this.f18622f = null;
        this.f18623g = null;
        this.f18619c = false;
    }

    /* renamed from: a */
    public final C5687a mo28207a(ByteBuffer byteBuffer) {
        C5884d dVar = this.f18623g;
        if (dVar == null) {
            return null;
        }
        byte[] a = dVar.mo28215a(byteBuffer);
        if (a == null) {
            return null;
        }
        C5898f fVar = new C5898f(a);
        C5888a aVar = new C5888a();
        fVar.mo28261a((C5891a) aVar);
        StringBuilder sb = new StringBuilder("received ");
        sb.append(aVar);
        String str = "core";
        C5264a.m21617a(str, sb.toString());
        if (aVar.mo28228c()) {
            C5898f fVar2 = new C5898f(C5897e.m23619a(fVar));
            aVar.mo28231f();
            fVar = fVar2;
        }
        C5687a aVar2 = new C5687a();
        aVar2.f18231a = aVar;
        aVar2.f18232b = fVar;
        if (aVar2.f18231a.mo28232g() == 1 && aVar2.f18231a.mo28233h() == 1) {
            C5857a aVar3 = new C5857a();
            aVar3.mo27892a(aVar2.f18231a);
            short e = aVar3.mo27896e();
            if (e == 201) {
                try {
                    aVar3.mo27845a(aVar2.f18232b);
                    C5864a.m23488a(aVar3.mo28168f(), aVar3.mo28169g(), aVar3.mo28170h());
                    m23547c();
                    StringBuilder sb2 = new StringBuilder("public key updated to: ");
                    sb2.append(aVar3.mo28168f());
                    C5264a.m21617a(str, sb2.toString());
                    if (this.f18618b != null) {
                        this.f18618b.mo28195a(this.f18620d, true);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (e != 200) {
                StringBuilder sb3 = new StringBuilder("Handshake fail[code=");
                sb3.append(aVar3.mo27891a().mo28235j());
                sb3.append("]");
                C5264a.m21617a(str, sb3.toString());
                C5864a.m23487a();
                if (this.f18618b != null) {
                    this.f18618b.mo28194a();
                }
            } else if (this.f18618b != null) {
                this.f18618b.mo28195a(this.f18620d, false);
            }
            this.f18620d = null;
            return null;
        } else if (aVar2.f18231a.mo28234i() >= 0 && aVar2.f18231a.mo28236k() >= 0) {
            return aVar2;
        } else {
            throw new C5899g("invalid headers, connection may be corrupted");
        }
    }

    /* renamed from: a */
    public final C5894b mo28208a(C5670a aVar) {
        if (this.f18619c) {
            return this.f18622f.mo28213a(aVar, false);
        }
        this.f18619c = true;
        this.f18620d = aVar;
        return this.f18622f.mo28213a(this.f18622f.mo28212a(aVar), true);
    }

    /* renamed from: a */
    public final void mo28209a() {
        C5881a aVar = new C5881a();
        this.f18622f = new C5883c(aVar, this.f18621e.f18576b);
        this.f18623g = new C5884d(aVar);
        this.f18619c = false;
    }

    /* renamed from: b */
    public final void mo28210b() {
        C5884d dVar = this.f18623g;
        if (dVar != null) {
            dVar.mo28214a();
        }
    }
}
