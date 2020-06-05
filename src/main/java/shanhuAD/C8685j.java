package shanhuAD;

/* renamed from: shanhuAD.j */
class C8685j implements Runnable {
    final /* synthetic */ C8690o this$0;

    C8685j(C8690o oVar) {
        this.this$0 = oVar;
    }

    public void run() {
        if (this.this$0.f29550Cj.getVisibility() != 8) {
            this.this$0.f29550Cj.setVisibility(8);
        }
        C8694p pVar = this.this$0.f29551Dj;
        if (pVar != null && pVar.getVisibility() != 0) {
            this.this$0.f29551Dj.setVisibility(0);
            this.this$0.f29551Dj.mo41484vb();
        }
    }
}
