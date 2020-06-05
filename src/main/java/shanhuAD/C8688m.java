package shanhuAD;

/* renamed from: shanhuAD.m */
class C8688m implements Runnable {
    final /* synthetic */ C8690o this$0;

    C8688m(C8690o oVar) {
        this.this$0 = oVar;
    }

    public void run() {
        if (this.this$0.f29550Cj.getVisibility() != 0) {
            this.this$0.f29550Cj.setVisibility(0);
        }
        C8694p pVar = this.this$0.f29551Dj;
        if (pVar != null && pVar.getVisibility() != 8) {
            this.this$0.f29551Dj.setVisibility(8);
            this.this$0.f29551Dj.mo41485wb();
        }
    }
}
