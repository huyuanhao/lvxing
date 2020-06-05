package shanhuAD;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.p605ep.commonbase.api.Log;
import shanhuAD.C8672G.C8674b;
import shanhuAD.C8690o.C8691a;
import shanhuAD.C8690o.C8692b;

/* renamed from: shanhuAD.y */
public class C8703y extends C8690o {
    private static final String TAG = "QVideoView";
    /* renamed from: Ij */
    public C8672G f29575Ij;

    public C8703y(Context context) {
        super(context);
        m37714j(context);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f29575Ij = new C8672G(context);
        this.f29575Ij.setOnInfoListener(new C8698t(this));
        this.f29575Ij.setOnStopListener(new C8699u(this));
        addView(this.f29575Ij, 0, layoutParams);
        this.f29575Ij.setVisibility(8);
    }

    /* renamed from: j */
    private void m37714j(Context context) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f29551Dj = new C8695q(context, 5);
        this.f29551Dj.setVisibility(8);
        addView(this.f29551Dj, layoutParams);
    }

    /* renamed from: a */
    public void mo41455a(boolean z, C8691a aVar) {
        this.f29575Ij.setOnCompletionListener(new C8700v(this, aVar, z));
    }

    public int getCurrentPosition() {
        return this.f29575Ij.getCurrentPosition();
    }

    public boolean isPlaying() {
        return this.f29575Ij.isPlaying();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f29575Ij.isPlaying()) {
            C8692b bVar = this.f29555Hj;
            if (bVar != null) {
                bVar.mo41481a(this, (long) this.f29575Ij.getCurrentPosition());
                invalidate();
            }
        }
    }

    public void pause() {
        this.f29575Ij.pause();
        onPause();
    }

    /* renamed from: rb */
    public void mo41463rb() {
        this.f29575Ij.mo41420rb();
    }

    public void release() {
        this.f29575Ij.stopPlayback();
    }

    public void resume() {
        this.f29575Ij.start();
        onResume();
    }

    /* renamed from: sb */
    public void mo41466sb() {
        this.f29575Ij.mo41423sb();
    }

    public void seekTo(int i) {
        this.f29575Ij.seekTo(i);
    }

    public void setScale(float f) {
        this.f29575Ij.setScale(f);
    }

    public void setSourceFile(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f29575Ij.hashCode());
        sb.append(" setSourceFile setVideoURI");
        Log.m31483i(TAG, sb.toString());
        this.f29575Ij.setVideoURI(Uri.parse(str));
    }

    public void setSourceUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f29575Ij.hashCode());
        sb.append(" setSourceUrl ");
        sb.append(str);
        Log.m31483i(TAG, sb.toString());
        this.f29575Ij.setVideoURI(Uri.parse(str));
    }

    public void setSourceVid(String str) {
    }

    public void setVideoStartListener(C8674b bVar) {
        C8672G g = this.f29575Ij;
        if (g != null) {
            g.setVideoStartListener(bVar);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f29575Ij.setVisibility(i);
    }

    public void setVolume(float f, float f2) {
        this.f29575Ij.setVolume(f, f2);
    }

    public void start() {
        this.f29575Ij.start();
        mo41480ub();
    }

    public void stop() {
        this.f29553Fj = false;
        this.f29575Ij.stop();
    }

    /* renamed from: a */
    public void mo41454a(C8691a aVar, boolean z) {
        if (aVar != null) {
            this.f29575Ij.setOnCompletionListener(new C8702x(this, z, aVar));
        }
    }
}
