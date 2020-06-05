package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5191i;
import java.util.List;

/* renamed from: com.pw.inner.appwall.y */
public class C5060y extends FrameLayout {
    /* renamed from: a */
    int f16547a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public int f16548b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public int f16549c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public RecyclerView f16550d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public SmoothLinearLayoutManager f16551e;
    /* renamed from: f */
    private C5063a f16552f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C5067c f16553g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public List<C5138c> f16554h;
    /* renamed from: i */
    private RectF f16555i;
    /* renamed from: j */
    private Path f16556j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public Handler f16557k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C5066b f16558l;

    /* renamed from: com.pw.inner.appwall.y$a */
    private class C5063a extends Adapter<C5065a> {
        /* renamed from: b */
        private Context f16562b;

        /* renamed from: com.pw.inner.appwall.y$a$a */
        class C5065a extends ViewHolder {
            /* access modifiers changed from: private */
            /* renamed from: b */
            public C4980ab f16566b;

            C5065a(View view) {
                super(view);
                this.f16566b = (C4980ab) view;
            }
        }

        C5063a(Context context) {
            this.f16562b = context;
        }

        /* renamed from: a */
        public C5065a onCreateViewHolder(ViewGroup viewGroup, int i) {
            C4980ab abVar = new C4980ab(this.f16562b);
            abVar.mo26352a(C5060y.this.f16548b, C5060y.this.f16549c);
            abVar.setLayoutParams(new LayoutParams(-1, -1));
            return new C5065a(abVar);
        }

        /* renamed from: a */
        public void onBindViewHolder(C5065a aVar, int i) {
            final C5138c cVar = (C5138c) C5060y.this.f16554h.get(i % C5060y.this.f16554h.size());
            aVar.f16566b.mo26353a(cVar.f16778g, C4970aa.m20787a(C4970aa.m20784a().mo26333e(), cVar.f16775d));
            aVar.f16566b.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5060y.this.f16558l != null) {
                        C5060y.this.f16558l.mo26422a(cVar);
                    }
                }
            });
        }

        public int getItemCount() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    /* renamed from: com.pw.inner.appwall.y$b */
    public interface C5066b {
        /* renamed from: a */
        void mo26422a(C5138c cVar);
    }

    /* renamed from: com.pw.inner.appwall.y$c */
    private static class C5067c extends View {
        /* renamed from: a */
        private int f16567a;
        /* renamed from: b */
        private int f16568b;
        /* renamed from: c */
        private Paint f16569c;
        /* renamed from: d */
        private int f16570d;
        /* renamed from: e */
        private int f16571e;
        /* renamed from: f */
        private float f16572f;
        /* renamed from: g */
        private float f16573g;

        public C5067c(Context context) {
            this(context, null);
        }

        public C5067c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f16568b = 0;
            this.f16569c = new Paint();
            this.f16570d = Color.parseColor("#F24B54");
            this.f16571e = -1;
            this.f16572f = 10.0f;
            this.f16573g = 20.0f;
            this.f16569c.setStyle(Style.FILL);
            this.f16569c.setAntiAlias(true);
        }

        /* renamed from: a */
        public void mo26577a(int i) {
            this.f16567a = i;
        }

        /* renamed from: b */
        public void mo26578b(int i) {
            this.f16568b = i;
            invalidate();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            int i;
            Paint paint;
            super.onDraw(canvas);
            float width = ((float) getWidth()) / 2.0f;
            float f = this.f16572f * 2.0f;
            int i2 = this.f16567a;
            float f2 = width - (((f * ((float) i2)) + (this.f16573g * ((float) (i2 - 1)))) / 2.0f);
            canvas.save();
            for (int i3 = 0; i3 < this.f16567a; i3++) {
                if (i3 == this.f16568b) {
                    paint = this.f16569c;
                    i = this.f16570d;
                } else {
                    paint = this.f16569c;
                    i = this.f16571e;
                }
                paint.setColor(i);
                canvas.drawCircle((this.f16572f * ((float) ((i3 * 2) + 1))) + f2 + (((float) i3) * this.f16573g), ((float) getHeight()) / 2.0f, this.f16572f, this.f16569c);
            }
            canvas.restore();
        }
    }

    public C5060y(Context context) {
        this(context, null);
    }

    public C5060y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C5060y(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16547a = C5191i.m21391b(getContext(), 10);
        this.f16557k = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 22783) {
                    C5060y.this.f16550d.smoothScrollToPosition(C5060y.this.f16551e.findFirstVisibleItemPosition() + 1);
                    C5060y.this.m21096c();
                }
            }
        };
        setWillNotDraw(false);
        this.f16556j = new Path();
        this.f16555i = new RectF();
        this.f16553g = new C5067c(context);
        this.f16550d = new RecyclerView(context);
        this.f16552f = new C5063a(context);
        this.f16550d.setAdapter(this.f16552f);
        this.f16551e = new SmoothLinearLayoutManager(context, 0, false);
        this.f16550d.setLayoutManager(this.f16551e);
        this.f16550d.setHasFixedSize(true);
        new PagerSnapHelper().attachToRecyclerView(this.f16550d);
        addView(this.f16550d, new FrameLayout.LayoutParams(-1, -1));
        setLayoutParams(new LayoutParams(-1, C5191i.m21391b(context, 120)));
    }

    /* renamed from: a */
    private void m21094a(Context context) {
        this.f16553g.mo26577a(this.f16554h.size());
        this.f16550d.addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                C5060y.this.f16553g.mo26578b(C5060y.this.f16551e.findFirstVisibleItemPosition() % C5060y.this.f16554h.size());
                if (i == 1 || i == 2) {
                    C5060y.this.f16557k.removeMessages(22783);
                } else if (i == 0 && !C5060y.this.f16557k.hasMessages(22783)) {
                    C5060y.this.m21096c();
                }
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, C5191i.m21391b(context, 32));
        layoutParams.gravity = 81;
        removeView(this.f16553g);
        addView(this.f16553g, layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21096c() {
        this.f16557k.removeCallbacksAndMessages(null);
        List<C5138c> list = this.f16554h;
        if (list != null && list.size() > 1) {
            this.f16557k.sendEmptyMessageDelayed(22783, 3500);
        }
    }

    /* renamed from: a */
    public C5060y mo26565a(C5066b bVar) {
        this.f16558l = bVar;
        return this;
    }

    /* renamed from: a */
    public void mo26566a() {
        this.f16557k.removeCallbacksAndMessages(null);
    }

    /* renamed from: a */
    public void mo26567a(int i, int i2) {
        this.f16548b = i;
        this.f16549c = i2;
    }

    /* renamed from: b */
    public void mo26568b() {
        m21096c();
    }

    public void draw(Canvas canvas) {
        this.f16556j.reset();
        Path path = this.f16556j;
        RectF rectF = this.f16555i;
        int i = this.f16547a;
        path.addRoundRect(rectF, (float) i, (float) i, Direction.CW);
        canvas.save();
        canvas.clipPath(this.f16556j);
        super.draw(canvas);
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16550d.scrollToPosition(this.f16551e.findFirstVisibleItemPosition() + 1);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f16555i.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    public void setData(List<C5138c> list) {
        this.f16554h = list;
        this.f16552f.notifyDataSetChanged();
        this.f16550d.scrollToPosition(list != null ? list.size() * 10 : 0);
        m21094a(getContext());
        m21096c();
    }
}
