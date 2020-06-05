package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* renamed from: com.alipay.android.phone.mrpc.core.j */
public final class C1418j extends C1397a {
    /* renamed from: g */
    private C1415g f3630g;

    public C1418j(C1415g gVar, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.f3630g = gVar;
    }

    /* renamed from: a */
    public final Object mo11967a() {
        String str = "";
        C1424o oVar = new C1424o(this.f3630g.mo11962a());
        oVar.mo11979a(this.f3599b);
        oVar.mo11975a(this.f3602e);
        oVar.mo11978a(this.f3603f);
        oVar.mo11976a("id", String.valueOf(this.f3601d));
        oVar.mo11976a("operationType", this.f3600c);
        oVar.mo11976a("gzip", String.valueOf(this.f3630g.mo11965d()));
        oVar.mo11977a((Header) new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.f3630g.mo11964c().mo11939b();
        if (b != null && !b.isEmpty()) {
            for (Header a : b) {
                oVar.mo11977a(a);
            }
        }
        StringBuilder sb = new StringBuilder("threadid = ");
        sb.append(Thread.currentThread().getId());
        sb.append("; ");
        sb.append(oVar.toString());
        try {
            C1430u uVar = (C1430u) this.f3630g.mo11963b().mo11941a(oVar).get();
            if (uVar != null) {
                return uVar.mo11998b();
            }
            throw new RpcException(Integer.valueOf(9), "response is null");
        } catch (InterruptedException e) {
            throw new RpcException(Integer.valueOf(13), str, e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(Integer.valueOf(9), str, e2);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        } catch (CancellationException e3) {
            throw new RpcException(Integer.valueOf(13), str, e3);
        }
    }
}
