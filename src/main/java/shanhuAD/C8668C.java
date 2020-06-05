package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;

/* renamed from: shanhuAD.C */
class C8668C implements OnInfoListener {
    final /* synthetic */ C8672G this$0;

    C8668C(C8672G g) {
        this.this$0 = g;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.this$0.f29494ij != null) {
            this.this$0.f29494ij.onInfo(mediaPlayer, i, i2);
        }
        return true;
    }
}
