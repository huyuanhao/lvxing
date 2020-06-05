package discoveryAD;

/* renamed from: discoveryAD.D */
public class C7859D extends C7885a {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            if (r0 == 0) goto L_0x0017;
     */
    /* renamed from: G */
    public void mo38123G(int r3) {
        /*
        r2 = this;
        int r0 = r2.f26819vc
        r1 = 3
        int r0 = java.lang.Math.max(r0, r1)
        r2.f26819vc = r0
        boolean r0 = r2.f26822yc
        if (r0 == 0) goto L_0x001b
        int r0 = r2.f26820wc
        if (r0 != 0) goto L_0x0017
        r2.f26820wc = r3
        int r0 = r2.f26820wc
        if (r0 != 0) goto L_0x001b
    L_0x0017:
        int r0 = r0 + 1
        r2.f26820wc = r0
    L_0x001b:
        int r0 = r2.f26817tc
        if (r0 <= 0) goto L_0x0023
        int r0 = r0 + -1
        r2.f26817tc = r0
    L_0x0023:
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        r0.<init>()
        java.lang.String r1 = "AdLifeCycle onDisplay:mWeight="
        r0.append(r1)
        int r1 = r2.f26820wc
        r0.append(r1)
        java.lang.String r1 = "|maxweight="
        r0.append(r1)
        r0.append(r3)
        java.lang.String r3 = "|mRemainDisplayCount="
        r0.append(r3)
        int r3 = r2.f26817tc
        r0.append(r3)
        java.lang.String r3 = r0.toString()
        discoveryAD.C7852Aa.m34156i(r3)
        long r0 = java.lang.System.currentTimeMillis()
        r2.f26821xc = r0
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: discoveryAD.C7859D.mo38123G(int):void");
    }

    /* renamed from: Xa */
    public void mo38124Xa() {
        this.f26819vc = Math.max(this.f26819vc, 10);
    }

    /* renamed from: Ya */
    public void mo38125Ya() {
        this.f26819vc = Math.max(this.f26819vc, 6);
    }

    /* renamed from: Za */
    public void mo38126Za() {
        this.f26819vc = Math.max(this.f26819vc, 9);
        mo38181bb();
    }

    /* renamed from: _a */
    public void mo38127_a() {
        this.f26819vc = Math.max(this.f26819vc, 2);
    }

    /* renamed from: ab */
    public void mo38128ab() {
        this.f26819vc = Math.max(this.f26819vc, 5);
    }

    public void onClick() {
        this.f26819vc = Math.max(this.f26819vc, 4);
        if (this.f26822yc) {
            this.f26820wc += 2;
        }
        int i = this.f26818uc;
        if (i > 0) {
            this.f26818uc = i - 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("AdLifeCycle onClick:mWeight=");
        sb.append(this.f26820wc);
        sb.append("|mRemainClickCount=");
        sb.append(this.f26818uc);
        C7852Aa.m34156i(sb.toString());
    }
}
