package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

/* renamed from: shanhuAD.E */
class C8670E implements OnBufferingUpdateListener {
    final /* synthetic */ C8672G this$0;

    C8670E(C8672G g) {
        this.this$0 = g;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.this$0.f29492gj = i;
    }
}
