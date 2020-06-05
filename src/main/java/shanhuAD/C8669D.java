package shanhuAD;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;
import com.tencent.mid.sotrage.StorageInterface;

/* renamed from: shanhuAD.D */
class C8669D implements OnErrorListener {
    final /* synthetic */ C8672G this$0;

    C8669D(C8672G g) {
        this.this$0 = g;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String i3 = this.this$0.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Error: ");
        sb.append(i);
        sb.append(StorageInterface.KEY_SPLITER);
        sb.append(i2);
        Log.d(i3, sb.toString());
        C8672G g = this.this$0;
        g.f29478Ti = -1;
        g.f29479Ui = -1;
        if (g.f29488cj != null) {
            this.this$0.f29488cj.hide();
        }
        if (this.this$0.f29493hj == null || this.this$0.f29493hj.onError(this.this$0.f29481Wi, i, i2)) {
        }
        return true;
    }
}
