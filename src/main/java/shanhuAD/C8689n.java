package shanhuAD;

/* renamed from: shanhuAD.n */
class C8689n implements Runnable {
    /* renamed from: Qk */
    final /* synthetic */ boolean f29548Qk;
    final /* synthetic */ C8690o this$0;

    C8689n(C8690o oVar, boolean z) {
        this.this$0 = oVar;
        this.f29548Qk = z;
    }

    public void run() {
        if (this.this$0.f29549Bj.getVisibility() != 0) {
            this.this$0.f29549Bj.setVisibility(0);
        }
        if (this.f29548Qk && this.this$0.f29550Cj.getVisibility() != 0) {
            this.this$0.f29550Cj.setVisibility(0);
        }
        C8694p pVar = this.this$0.f29551Dj;
        if (pVar != null && pVar.getVisibility() != 8) {
            this.this$0.f29551Dj.setVisibility(8);
            this.this$0.f29551Dj.mo41485wb();
        }
    }
}
