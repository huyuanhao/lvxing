package com.qiyukf.nim.uikit.common.p424ui.imageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import com.qiyukf.basesdk.p393a.C5264a;

/* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView */
public class MultiTouchZoomableImageView extends BaseZoomableImageView {
    /* renamed from: d */
    protected boolean f17616d = false;
    /* renamed from: e */
    private GestureDetector f17617e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ScaleGestureDetector f17618f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f17619g = false;

    /* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView$a */
    private class C5475a extends SimpleOnGestureListener {
        private C5475a() {
        }

        /* synthetic */ C5475a(MultiTouchZoomableImageView multiTouchZoomableImageView, byte b) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.mo27518d() != MultiTouchZoomableImageView.this.mo27520f()) {
                MultiTouchZoomableImageView multiTouchZoomableImageView = MultiTouchZoomableImageView.this;
                multiTouchZoomableImageView.mo27506a(multiTouchZoomableImageView.mo27520f());
            } else {
                MultiTouchZoomableImageView multiTouchZoomableImageView2 = MultiTouchZoomableImageView.this;
                multiTouchZoomableImageView2.mo27515b(multiTouchZoomableImageView2.mo27520f() * 3.0f, motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            StringBuilder sb;
            String str = "diffX:";
            String str2 = "MultiTouchZoomableImageView onFing error";
            if ((motionEvent != null && motionEvent.getPointerCount() > 1) || ((motionEvent2 != null && motionEvent2.getPointerCount() > 1) || MultiTouchZoomableImageView.this.f17618f.isInProgress())) {
                return false;
            }
            if ((motionEvent.getX() - motionEvent2.getX() <= 100.0f || Math.abs(f) <= 200.0f) && ((motionEvent2.getX() - motionEvent.getX() <= 100.0f || Math.abs(f) <= 200.0f) && ((motionEvent.getY() - motionEvent2.getY() <= 100.0f || Math.abs(f2) <= 200.0f) && motionEvent2.getY() - motionEvent.getY() > 100.0f && Math.abs(f2) > 200.0f && !MultiTouchZoomableImageView.this.f17616d && MultiTouchZoomableImageView.this.mo27518d() <= MultiTouchZoomableImageView.this.mo27520f()))) {
                MultiTouchZoomableImageView.this.f17566b.mo27563c();
                return true;
            }
            try {
                float x = motionEvent2.getX() - motionEvent.getX();
                float y = motionEvent2.getY() - motionEvent.getY();
                if (Math.abs(f) > 800.0f || Math.abs(f2) > 800.0f) {
                    MultiTouchZoomableImageView.this.mo27514b(x / 2.0f, y / 2.0f);
                    MultiTouchZoomableImageView.this.invalidate();
                }
            } catch (NullPointerException e) {
                e = e;
                sb = new StringBuilder(str);
                sb.append(e);
                C5264a.m21621b(str2, sb.toString(), e);
                return super.onFling(motionEvent, motionEvent2, f, f2);
            } catch (IllegalArgumentException e2) {
                e = e2;
                sb = new StringBuilder(str);
                sb.append(e);
                C5264a.m21621b(str2, sb.toString(), e);
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.f17566b != null && !MultiTouchZoomableImageView.this.f17619g) {
                MultiTouchZoomableImageView.this.f17566b.mo27562b();
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent != null) {
                try {
                    if (motionEvent.getPointerCount() <= 1) {
                    }
                    return false;
                } catch (IllegalArgumentException e) {
                    C5264a.m21621b("MultiTouchZoomableImageView onScroll error", "", e);
                }
            }
            if ((motionEvent2 == null || motionEvent2.getPointerCount() <= 1) && (MultiTouchZoomableImageView.this.f17618f == null || !MultiTouchZoomableImageView.this.f17618f.isInProgress())) {
                if (!MultiTouchZoomableImageView.this.f17616d) {
                    if (MultiTouchZoomableImageView.this.mo27518d() <= MultiTouchZoomableImageView.this.mo27520f()) {
                        if (MultiTouchZoomableImageView.this.f17567c != null) {
                            MultiTouchZoomableImageView.this.f17567c.requestDisallowInterceptTouchEvent(false);
                        }
                        return true;
                    }
                }
                MultiTouchZoomableImageView.this.mo27521g();
                MultiTouchZoomableImageView.this.mo27512a(-f, -f2);
                if (MultiTouchZoomableImageView.this.mo27516b(f)) {
                    if (MultiTouchZoomableImageView.this.f17567c != null) {
                        MultiTouchZoomableImageView.this.f17567c.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (MultiTouchZoomableImageView.this.f17567c != null) {
                    MultiTouchZoomableImageView.this.f17567c.requestDisallowInterceptTouchEvent(true);
                }
                MultiTouchZoomableImageView.this.mo27517c();
                return true;
            }
            return false;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.f17566b == null) {
                return super.onSingleTapConfirmed(motionEvent);
            }
            MultiTouchZoomableImageView.this.f17566b.mo27561a();
            return false;
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView$b */
    class C5476b extends SimpleOnScaleGestureListener {
        C5476b() {
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
                try {
                    MultiTouchZoomableImageView.this.mo27507a(Math.min(MultiTouchZoomableImageView.this.mo27519e(), Math.max(MultiTouchZoomableImageView.this.mo27518d() * scaleGestureDetector.getScaleFactor(), 1.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    MultiTouchZoomableImageView.this.invalidate();
                    MultiTouchZoomableImageView.this.f17619g = true;
                    return true;
                } catch (IllegalArgumentException e) {
                    C5264a.m21621b("BaseZoomableImageView is onScale is error", "", e);
                }
            }
            return false;
        }
    }

    public MultiTouchZoomableImageView(Context context) {
        super(context);
        m22340a(context);
    }

    public MultiTouchZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22340a(context);
    }

    public MultiTouchZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22340a(context);
    }

    /* renamed from: a */
    private void m22340a(Context context) {
        this.f17618f = new ScaleGestureDetector(context, new C5476b());
        this.f17617e = new GestureDetector(context, new C5475a(this, 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.f17567c != null) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        this.f17567c.requestDisallowInterceptTouchEvent(true);
                    } else if (action != 3) {
                    }
                }
                this.f17567c.requestDisallowInterceptTouchEvent(false);
                this.f17619g = false;
            }
            if (this.f17565a != null) {
                this.f17618f.onTouchEvent(motionEvent);
                if (!this.f17618f.isInProgress()) {
                    this.f17617e.onTouchEvent(motionEvent);
                }
                return true;
            }
            this.f17566b.mo27561a();
            return false;
        } catch (Exception e) {
            C5264a.m21621b("MultiTouchZoomableImageView onTouchEvent error", "", e);
        }
    }
}
