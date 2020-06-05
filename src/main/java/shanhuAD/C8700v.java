package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import shanhuAD.C8690o.C8691a;

/* renamed from: shanhuAD.v */
class C8700v implements OnCompletionListener {
    /* renamed from: Rk */
    final /* synthetic */ boolean f29572Rk;
    final /* synthetic */ C8703y this$0;
    final /* synthetic */ C8691a val$listener;

    C8700v(C8703y yVar, C8691a aVar, boolean z) {
        this.this$0 = yVar;
        this.val$listener = aVar;
        this.f29572Rk = z;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C8691a aVar = this.val$listener;
        if (aVar != null) {
            aVar.onCompletion();
        }
        if (this.f29572Rk) {
            this.this$0.f29575Ij.start();
        }
    }
}
