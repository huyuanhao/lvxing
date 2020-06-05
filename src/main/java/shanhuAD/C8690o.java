package shanhuAD;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.p605ep.common.adapt.ServiceCenter;
import com.tencent.p605ep.common.adapt.iservice.picasso.IPicasso;

/* renamed from: shanhuAD.o */
public abstract class C8690o extends RelativeLayout {
    /* renamed from: Bj */
    protected ImageView f29549Bj;
    /* renamed from: Cj */
    protected ImageView f29550Cj;
    /* renamed from: Dj */
    protected C8694p f29551Dj;
    /* renamed from: Ej */
    protected View f29552Ej;
    /* renamed from: Fj */
    protected boolean f29553Fj = false;
    /* renamed from: Gj */
    protected C8693c f29554Gj;
    /* renamed from: Hj */
    protected C8692b f29555Hj;

    /* renamed from: shanhuAD.o$a */
    public interface C8691a {
        void onCompletion();
    }

    /* renamed from: shanhuAD.o$b */
    public interface C8692b {
        /* renamed from: a */
        void mo41481a(View view, long j);
    }

    /* renamed from: shanhuAD.o$c */
    public interface C8693c {
        void onStart();
    }

    public C8690o(Context context) {
        super(context);
        this.f29552Ej = new View(context);
        addView(this.f29552Ej, new LayoutParams(-1, -1));
        this.f29549Bj = new ImageView(context);
        addView(this.f29549Bj, new LayoutParams(-1, -1));
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f29550Cj = new ImageView(context);
        addView(this.f29550Cj, layoutParams);
    }

    /* renamed from: a */
    public abstract void mo41454a(C8691a aVar, boolean z);

    /* renamed from: a */
    public abstract void mo41455a(boolean z, C8691a aVar);

    /* renamed from: c */
    public void mo41456c(String str, int i, int i2) {
        this.f29549Bj.setImageDrawable(null);
        if (this.f29550Cj.getVisibility() != 0) {
            this.f29550Cj.setVisibility(0);
        }
        ((IPicasso) ServiceCenter.get(IPicasso.class)).load(Uri.parse(str)).resize(i, i2).centerCrop().fast().round(10).into(this.f29549Bj);
    }

    public abstract boolean isPlaying();

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo41458j(boolean z) {
        post(new C8689n(this, z));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        post(new C8688m(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        post(new C8687l(this));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        post(new C8686k(this));
    }

    public abstract void pause();

    /* renamed from: rb */
    public abstract void mo41463rb();

    public abstract void release();

    public abstract void resume();

    /* renamed from: sb */
    public abstract void mo41466sb();

    public abstract void seekTo(int i);

    public void setOnPlayListener(OnClickListener onClickListener) {
        this.f29550Cj.setOnClickListener(onClickListener);
    }

    public void setOnProgressListener(C8692b bVar) {
        this.f29555Hj = bVar;
    }

    public void setOnStartListener(C8693c cVar) {
        this.f29554Gj = cVar;
    }

    public void setPreview(Bitmap bitmap) {
        this.f29549Bj.setImageBitmap(bitmap);
        if (this.f29550Cj.getVisibility() != 0) {
            this.f29550Cj.setVisibility(0);
        }
    }

    public abstract void setScale(float f);

    public abstract void setSourceFile(String str);

    public abstract void setSourceUrl(String str);

    public abstract void setSourceVid(String str);

    public abstract void setVolume(float f, float f2);

    public abstract void start();

    public abstract void stop();

    /* access modifiers changed from: protected */
    /* renamed from: tb */
    public void mo41479tb() {
        if (this.f29549Bj.getVisibility() != 8) {
            this.f29549Bj.setVisibility(8);
        }
        if (this.f29550Cj.getVisibility() != 8) {
            this.f29550Cj.setVisibility(8);
        }
        C8694p pVar = this.f29551Dj;
        if (!(pVar == null || pVar.getVisibility() == 8)) {
            this.f29551Dj.setVisibility(8);
            this.f29551Dj.mo41485wb();
        }
        if (this.f29552Ej.getVisibility() != 8) {
            this.f29552Ej.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ub */
    public void mo41480ub() {
        post(new C8685j(this));
    }
}
