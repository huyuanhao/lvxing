package shanhuAD;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

/* renamed from: shanhuAD.F */
class C8671F implements Callback {
    final /* synthetic */ C8672G this$0;

    C8671F(C8672G g) {
        this.this$0 = g;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.this$0.f29486aj = i2;
        this.this$0.f29487bj = i3;
        boolean z = true;
        boolean z2 = this.this$0.f29479Ui == 3;
        if (!(this.this$0.f29484Zi == i2 && this.this$0.f29485_i == i3)) {
            z = false;
        }
        if (this.this$0.f29481Wi != null && z2 && z) {
            if (this.this$0.f29495jj != 0) {
                C8672G g = this.this$0;
                g.seekTo(g.f29495jj);
            }
            this.this$0.start();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.this$0.f29480Vi = surfaceHolder;
        this.this$0.m37655Gb();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.this$0.f29480Vi = null;
        if (this.this$0.f29488cj != null) {
            this.this$0.f29488cj.hide();
        }
        this.this$0.m37679k(true);
    }
}
