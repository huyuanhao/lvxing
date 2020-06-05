package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* renamed from: shanhuAD.B */
class C8667B implements OnCompletionListener {
    final /* synthetic */ C8672G this$0;

    C8667B(C8672G g) {
        this.this$0 = g;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C8672G g = this.this$0;
        g.f29478Ti = 5;
        g.f29479Ui = 5;
        g.f29500oj = 0;
        if (this.this$0.f29488cj != null) {
            this.this$0.f29488cj.hide();
        }
        if (this.this$0.f29489dj != null) {
            this.this$0.f29489dj.onCompletion(this.this$0.f29481Wi);
        }
    }
}
