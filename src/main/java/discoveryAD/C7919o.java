package discoveryAD;

import java.util.List;

/* renamed from: discoveryAD.o */
class C7919o implements Runnable {
    /* renamed from: Jc */
    final /* synthetic */ List f26923Jc;
    /* renamed from: Kc */
    final /* synthetic */ List f26924Kc;
    /* renamed from: Lc */
    final /* synthetic */ C7921p f26925Lc;

    C7919o(C7921p pVar, List list, List list2) {
        this.f26925Lc = pVar;
        this.f26923Jc = list;
        this.f26924Kc = list2;
    }

    public void run() {
        if (!C7931ta.m34347g(this.f26923Jc)) {
            C7852Aa.m34156i("删除本地数据库相关数据  begin");
            C7862G.getInstance().mo38132eb().mo38176e(this.f26923Jc);
        }
        if (!C7931ta.m34347g(this.f26924Kc)) {
            C7852Aa.m34156i("保存数据到相关数据库");
            C7862G.getInstance().mo38132eb().mo38177f(this.f26924Kc);
            C7852Aa.m34156i("新数据上报");
            this.f26925Lc.this$0.f26733hd.mo38156b(this.f26924Kc);
        }
    }
}
