package com.qiyukf.nimlib.p429a.p436c.p440d;

import com.qiyukf.nimlib.p429a.p436c.C5669a;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5894b;
import com.qiyukf.nimlib.p473h.p481c.p484c.C5896d;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.a.c.d.b */
public final class C5679b extends C5669a {
    /* renamed from: a */
    private List<String> f18219a = new ArrayList(1);

    /* renamed from: a */
    public final void mo27886a(String str, SessionTypeEnum sessionTypeEnum) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (sessionTypeEnum == SessionTypeEnum.P2P) {
            str2 = "p2p|";
        } else if (sessionTypeEnum == SessionTypeEnum.Team) {
            str2 = "team|";
        } else {
            throw new IllegalArgumentException("only support p2p and team.");
        }
        sb.append(str2);
        sb.append(str);
        this.f18219a.add(sb.toString());
    }

    /* renamed from: b */
    public final C5894b mo27872b() {
        C5894b bVar = new C5894b();
        C5896d.m23616a(bVar, this.f18219a);
        return bVar;
    }

    /* renamed from: c */
    public final byte mo27873c() {
        return 7;
    }

    /* renamed from: d */
    public final byte mo27874d() {
        return 9;
    }
}
