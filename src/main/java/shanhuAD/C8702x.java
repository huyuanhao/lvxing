package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import shanhuAD.C8690o.C8691a;

/* renamed from: shanhuAD.x */
class C8702x implements OnCompletionListener {
    /* renamed from: Qk */
    final /* synthetic */ boolean f29574Qk;
    final /* synthetic */ C8703y this$0;
    final /* synthetic */ C8691a val$listener;

    C8702x(C8703y yVar, boolean z, C8691a aVar) {
        this.this$0 = yVar;
        this.f29574Qk = z;
        this.val$listener = aVar;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.this$0.post(new C8701w(this));
    }
}
