package com.kwai.filedownloader.download;

import android.text.TextUtils;
import com.kwai.filedownloader.p353a.C4589b;
import com.kwai.filedownloader.p353a.C4593d;
import com.kwai.filedownloader.p356d.C4619b;
import com.kwai.filedownloader.p358f.C4660d;
import com.kwai.filedownloader.p358f.C4664f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConnectTask {
    /* renamed from: a */
    final int f15048a;
    /* renamed from: b */
    final String f15049b;
    /* renamed from: c */
    final C4619b f15050c;
    /* renamed from: d */
    private C4628a f15051d;
    /* renamed from: e */
    private String f15052e;
    /* renamed from: f */
    private Map<String, List<String>> f15053f;
    /* renamed from: g */
    private List<String> f15054g;

    /* renamed from: com.kwai.filedownloader.download.ConnectTask$Reconnect */
    class Reconnect extends Throwable {
        Reconnect() {
        }
    }

    /* renamed from: com.kwai.filedownloader.download.ConnectTask$a */
    static class C4625a {
        /* renamed from: a */
        private Integer f15055a;
        /* renamed from: b */
        private String f15056b;
        /* renamed from: c */
        private String f15057c;
        /* renamed from: d */
        private C4619b f15058d;
        /* renamed from: e */
        private C4628a f15059e;

        C4625a() {
        }

        /* renamed from: a */
        public C4625a mo25111a(int i) {
            this.f15055a = Integer.valueOf(i);
            return this;
        }

        /* renamed from: a */
        public C4625a mo25112a(C4619b bVar) {
            this.f15058d = bVar;
            return this;
        }

        /* renamed from: a */
        public C4625a mo25113a(C4628a aVar) {
            this.f15059e = aVar;
            return this;
        }

        /* renamed from: a */
        public C4625a mo25114a(String str) {
            this.f15056b = str;
            return this;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public ConnectTask mo25115a() {
            Integer num = this.f15055a;
            if (num != null) {
                C4628a aVar = this.f15059e;
                if (!(aVar == null || this.f15056b == null)) {
                    ConnectTask connectTask = new ConnectTask(aVar, num.intValue(), this.f15056b, this.f15057c, this.f15058d);
                    return connectTask;
                }
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: b */
        public C4625a mo25116b(String str) {
            this.f15057c = str;
            return this;
        }
    }

    private ConnectTask(C4628a aVar, int i, String str, String str2, C4619b bVar) {
        this.f15048a = i;
        this.f15049b = str;
        this.f15052e = str2;
        this.f15050c = bVar;
        this.f15051d = aVar;
    }

    /* renamed from: a */
    private void m18951a(C4589b bVar) {
        C4619b bVar2 = this.f15050c;
        if (bVar2 != null) {
            HashMap a = bVar2.mo25061a();
            if (a != null) {
                if (C4660d.f15179a) {
                    C4660d.m19125e(this, "%d add outside header: %s", Integer.valueOf(this.f15048a), a);
                }
                for (Entry entry : a.entrySet()) {
                    String str = (String) entry.getKey();
                    List<String> list = (List) entry.getValue();
                    if (list != null) {
                        for (String a2 : list) {
                            bVar.mo22741a(str, a2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m18952b(C4589b bVar) {
        String str;
        if (!bVar.mo22742a(this.f15052e, this.f15051d.f15095a)) {
            if (!TextUtils.isEmpty(this.f15052e)) {
                bVar.mo22741a("If-Match", this.f15052e);
            }
            if (this.f15051d.f15097c == 0) {
                str = C4664f.m19135a("bytes=%d-", Long.valueOf(this.f15051d.f15096b));
            } else {
                str = C4664f.m19135a("bytes=%d-%d", Long.valueOf(this.f15051d.f15096b), Long.valueOf(this.f15051d.f15097c));
            }
            bVar.mo22741a("Range", str);
        }
    }

    /* renamed from: c */
    private void m18953c(C4589b bVar) {
        C4619b bVar2 = this.f15050c;
        String str = "User-Agent";
        if (bVar2 == null || bVar2.mo25061a().get(str) == null) {
            bVar.mo22741a(str, C4664f.m19155e());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C4589b mo25106a() {
        C4589b a = C4629b.m18995a().mo25140a(this.f15049b);
        m18951a(a);
        m18952b(a);
        m18953c(a);
        this.f15053f = a.mo22743b();
        if (C4660d.f15179a) {
            C4660d.m19123c(this, "%s request header %s", Integer.valueOf(this.f15048a), this.f15053f);
        }
        a.mo22745d();
        this.f15054g = new ArrayList();
        return C4593d.m18655a(this.f15053f, a, this.f15054g);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo25107b() {
        return this.f15051d.f15096b > 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public String mo25108c() {
        List<String> list = this.f15054g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f15054g;
        return (String) list2.get(list2.size() - 1);
    }

    /* renamed from: d */
    public Map<String, List<String>> mo25109d() {
        return this.f15053f;
    }

    /* renamed from: e */
    public C4628a mo25110e() {
        return this.f15051d;
    }
}
