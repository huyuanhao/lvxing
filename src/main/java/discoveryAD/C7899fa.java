package discoveryAD;

import discoveryAD.C7903ha.C7904a;

/* renamed from: discoveryAD.fa */
class C7899fa implements Runnable {
    /* renamed from: fe */
    final /* synthetic */ String f26891fe;
    /* renamed from: ge */
    final /* synthetic */ String f26892ge;
    /* renamed from: he */
    final /* synthetic */ String f26893he;
    /* renamed from: ie */
    final /* synthetic */ boolean f26894ie;
    final /* synthetic */ C7903ha this$0;
    final /* synthetic */ C7904a val$callback;
    final /* synthetic */ String val$url;

    C7899fa(C7903ha haVar, String str, String str2, String str3, String str4, boolean z, C7904a aVar) {
        this.this$0 = haVar;
        this.f26891fe = str;
        this.f26892ge = str2;
        this.val$url = str3;
        this.f26893he = str4;
        this.f26894ie = z;
        this.val$callback = aVar;
    }

    public void run() {
        this.this$0.mo38213a(this.f26891fe, this.f26892ge, this.val$url, this.f26893he, this.f26894ie, this.val$callback);
    }
}
