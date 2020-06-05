package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.d */
public class VideoOnTouchLayout {
    /* access modifiers changed from: private|final */
    /* renamed from: a */
    public final C2363a f8336a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f8337b = false;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean f8338c = false;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public float f8339d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public float f8340e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public int f8341f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public int f8342g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public boolean f8343h = true;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public boolean f8344i = false;
    /* renamed from: j */
    private final OnTouchListener f8345j = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = false;
            if (VideoOnTouchLayout.this.f8336a.mo16167m()) {
                if (VideoOnTouchLayout.this.f8337b || !VideoOnTouchLayout.this.f8338c) {
                    z = true;
                }
                return z;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                VideoOnTouchLayout dVar = VideoOnTouchLayout.this;
                dVar.f8346k = dVar.m10804a(motionEvent);
                VideoOnTouchLayout.this.f8339d = x;
                VideoOnTouchLayout.this.f8340e = y;
                VideoOnTouchLayout.this.f8341f = (int) x;
                VideoOnTouchLayout.this.f8342g = (int) y;
                VideoOnTouchLayout.this.f8343h = true;
                if (VideoOnTouchLayout.this.f8336a != null && VideoOnTouchLayout.this.f8338c && !VideoOnTouchLayout.this.f8337b) {
                    VideoOnTouchLayout.this.f8336a.mo16145a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - ((float) VideoOnTouchLayout.this.f8341f)) > 20.0f || Math.abs(y - ((float) VideoOnTouchLayout.this.f8342g)) > 20.0f) {
                    VideoOnTouchLayout.this.f8343h = false;
                }
                if (!VideoOnTouchLayout.this.f8337b) {
                    VideoOnTouchLayout.this.f8343h = true;
                }
                VideoOnTouchLayout.this.f8344i = false;
                VideoOnTouchLayout.this.f8339d = 0.0f;
                VideoOnTouchLayout.this.f8340e = 0.0f;
                VideoOnTouchLayout.this.f8341f = 0;
                if (VideoOnTouchLayout.this.f8336a != null) {
                    VideoOnTouchLayout.this.f8336a.mo16145a(view, VideoOnTouchLayout.this.f8343h);
                }
                VideoOnTouchLayout.this.f8346k = false;
            } else if (action != 2) {
                if (action == 3) {
                    VideoOnTouchLayout.this.f8346k = false;
                }
            } else if (VideoOnTouchLayout.this.f8337b && !VideoOnTouchLayout.this.f8346k) {
                float f = y - VideoOnTouchLayout.this.f8340e;
                float abs = Math.abs(x - VideoOnTouchLayout.this.f8339d);
                float abs2 = Math.abs(f);
                if (!VideoOnTouchLayout.this.f8344i) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    VideoOnTouchLayout.this.f8344i = true;
                }
                if (VideoOnTouchLayout.this.f8336a != null) {
                    VideoOnTouchLayout.this.f8336a.mo16166l();
                }
                VideoOnTouchLayout.this.f8339d = x;
                VideoOnTouchLayout.this.f8340e = y;
            }
            if (VideoOnTouchLayout.this.f8337b || !VideoOnTouchLayout.this.f8338c) {
                z = true;
            }
            return z;
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean f8346k;

    /* compiled from: VideoOnTouchLayout */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.d$a */
    public interface C2363a {
        /* renamed from: a */
        void mo16145a(View view, boolean z);

        /* renamed from: l */
        void mo16166l();

        /* renamed from: m */
        boolean mo16167m();
    }

    public VideoOnTouchLayout(C2363a aVar) {
        this.f8336a = aVar;
    }

    /* renamed from: a */
    public void mo16316a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.f8345j);
        }
    }

    /* renamed from: a */
    public void mo16317a(boolean z) {
        this.f8338c = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m10804a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int c = UIUtils.m12078c(InternalContainer.m10059a().getApplicationContext());
        int d = UIUtils.m12084d(InternalContainer.m10059a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = (float) c;
        if (rawX > f * 0.01f && rawX < f * 0.99f) {
            float f2 = (float) d;
            if (rawY > 0.01f * f2 && rawY < f2 * 0.99f) {
                return false;
            }
        }
        return true;
    }
}
