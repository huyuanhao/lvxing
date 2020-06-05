package com.kwad.sdk.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.p306a.C3809l;
import com.kwad.sdk.p306a.C3817t;

public class DrawDownloadProgressBar extends FrameLayout {
    /* renamed from: a */
    private Context f14351a;
    /* renamed from: b */
    private TextProgressBar f14352b;
    /* renamed from: c */
    private View f14353c;

    public DrawDownloadProgressBar(Context context) {
        super(context);
        m17880a(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17880a(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17880a(context);
    }

    /* renamed from: a */
    private void m17880a(Context context) {
        this.f14351a = context;
        Context context2 = this.f14351a;
        inflate(context2, C3809l.m15792b(context2, "ksad_draw_download_bar"), this);
        this.f14352b = (TextProgressBar) findViewById(C3809l.m15789a(this.f14351a, "ksad_download_progress"));
        this.f14353c = findViewById(C3809l.m15789a(this.f14351a, "ksad_download_progress_cover"));
        this.f14353c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    /* renamed from: a */
    public void mo24567a(String str, int i) {
        int i2;
        View view;
        if (i == 0 || i == getMax()) {
            view = this.f14353c;
            i2 = 0;
        } else {
            view = this.f14353c;
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f14352b.mo24328a(str, i);
    }

    public int getMax() {
        return this.f14352b.getMax();
    }

    public void setTextColor(int i) {
        this.f14352b.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.f14352b.setTextDimen((float) C3817t.m15862a(getContext(), (float) i));
    }
}
