package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.Log;

/* renamed from: shanhuAD.z */
class C8704z implements OnVideoSizeChangedListener {
    final /* synthetic */ C8672G this$0;

    C8704z(C8672G g) {
        this.this$0 = g;
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            this.this$0.f29484Zi = mediaPlayer.getVideoWidth();
            this.this$0.f29485_i = mediaPlayer.getVideoHeight();
            if (this.this$0.f29484Zi != 0 && this.this$0.f29485_i != 0) {
                this.this$0.getHolder().setFixedSize(this.this$0.f29484Zi, this.this$0.f29485_i);
                this.this$0.requestLayout();
            }
        } catch (Throwable th) {
            Log.w(this.this$0.TAG, th);
        }
    }
}
