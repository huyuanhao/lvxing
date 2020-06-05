package shanhuAD;

import shanhuAD.C8682h.C8683a;

/* renamed from: shanhuAD.g */
class C8681g extends Thread {
    final /* synthetic */ C8683a val$listener;
    final /* synthetic */ String val$url;

    C8681g(String str, C8683a aVar) {
        this.val$url = str;
        this.val$listener = aVar;
    }

    public void run() {
        C8682h.m37696c(this.val$url, this.val$listener);
    }
}
