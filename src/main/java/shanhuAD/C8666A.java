package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

/* renamed from: shanhuAD.A */
class C8666A implements OnPreparedListener {
    final /* synthetic */ C8672G this$0;

    C8666A(C8672G g) {
        this.this$0 = g;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C8672G g = this.this$0;
        g.f29478Ti = 2;
        g.f29496kj = g.f29497lj = g.f29498mj = true;
        if (this.this$0.f29490ej != null) {
            this.this$0.f29490ej.onPrepared(this.this$0.f29481Wi);
        }
        if (this.this$0.f29488cj != null) {
            this.this$0.f29488cj.setEnabled(true);
        }
        this.this$0.f29484Zi = mediaPlayer.getVideoWidth();
        this.this$0.f29485_i = mediaPlayer.getVideoHeight();
        int m = this.this$0.f29495jj;
        if (m != 0) {
            this.this$0.seekTo(m);
        }
        if (this.this$0.f29484Zi == 0 || this.this$0.f29485_i == 0) {
            C8672G g2 = this.this$0;
            if (g2.f29479Ui == 3) {
                g2.start();
                return;
            }
            return;
        }
        this.this$0.getHolder().setFixedSize(this.this$0.f29484Zi, this.this$0.f29485_i);
        if (this.this$0.f29486aj == this.this$0.f29484Zi && this.this$0.f29487bj == this.this$0.f29485_i) {
            C8672G g3 = this.this$0;
            if (g3.f29479Ui == 3) {
                g3.start();
                if (this.this$0.f29488cj != null) {
                    this.this$0.f29488cj.show();
                }
            } else if (g3.isPlaying()) {
            } else {
                if ((m != 0 || this.this$0.getCurrentPosition() > 0) && this.this$0.f29488cj != null) {
                    this.this$0.f29488cj.show(0);
                }
            }
        }
    }
}
