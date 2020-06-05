package shanhuAD;

/* renamed from: shanhuAD.w */
class C8701w implements Runnable {
    /* renamed from: _j */
    final /* synthetic */ C8702x f29573_j;

    C8701w(C8702x xVar) {
        this.f29573_j = xVar;
    }

    public void run() {
        C8702x xVar = this.f29573_j;
        C8703y yVar = xVar.this$0;
        yVar.f29553Fj = false;
        yVar.mo41458j(xVar.f29574Qk);
        this.f29573_j.val$listener.onCompletion();
    }
}
