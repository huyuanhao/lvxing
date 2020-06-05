package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;

/* renamed from: shanhuAD.t */
class C8698t implements OnInfoListener {
    final /* synthetic */ C8703y this$0;

    C8698t(C8703y yVar) {
        this.this$0 = yVar;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        C8703y yVar = this.this$0;
        if (yVar.f29553Fj || i != 3) {
            this.this$0.postDelayed(new C8697s(this), 60);
        } else {
            yVar.f29553Fj = true;
            yVar.postDelayed(new C8696r(this), 60);
        }
        return true;
    }
}
