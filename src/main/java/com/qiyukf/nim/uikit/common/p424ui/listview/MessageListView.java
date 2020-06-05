package com.qiyukf.nim.uikit.common.p424ui.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import com.qiyukf.nim.uikit.common.p419a.C5435b;

/* renamed from: com.qiyukf.nim.uikit.common.ui.listview.MessageListView */
public class MessageListView extends AutoRefreshListView {
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5435b f17669c;
    /* renamed from: d */
    private GestureDetector f17670d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C5486b f17671e;
    /* renamed from: f */
    private RecyclerListener f17672f = new RecyclerListener() {
        public final void onMovedToScrapHeap(View view) {
            if (MessageListView.this.f17669c != null) {
                MessageListView.this.f17669c.mo27377a(view);
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: g */
    public boolean f17673g = false;

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.MessageListView$a */
    private class C5485a extends SimpleOnGestureListener {
        private C5485a() {
        }

        /* synthetic */ C5485a(MessageListView messageListView, byte b) {
            this();
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!MessageListView.this.f17673g && MessageListView.this.f17671e != null) {
                MessageListView.this.f17671e.mo27583a();
                MessageListView.this.f17673g = true;
            }
            return true;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!MessageListView.this.f17673g && MessageListView.this.f17671e != null) {
                MessageListView.this.f17671e.mo27583a();
                MessageListView.this.f17673g = true;
            }
            return true;
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.common.ui.listview.MessageListView$b */
    public interface C5486b {
        /* renamed from: a */
        void mo27583a();

        /* renamed from: a */
        void mo27584a(int i, int i2);

        /* renamed from: b */
        void mo27585b();
    }

    public MessageListView(Context context) {
        super(context);
        m22368a(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22368a(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22368a(context);
    }

    public MessageListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m22368a(context);
    }

    /* renamed from: a */
    private void m22368a(Context context) {
        setRecyclerListener(this.f17672f);
        this.f17670d = new GestureDetector(context, new C5485a(this, 0));
    }

    /* renamed from: a */
    public final void mo27577a(BaseAdapter baseAdapter) {
        C5435b bVar = (baseAdapter == null || !(baseAdapter instanceof C5435b)) ? null : (C5435b) baseAdapter;
        this.f17669c = bVar;
        super.setAdapter(baseAdapter);
    }

    /* renamed from: a */
    public final void mo27578a(C5486b bVar) {
        this.f17671e = bVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        C5486b bVar = this.f17671e;
        if (bVar != null) {
            bVar.mo27584a(i2, i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f17670d.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.f17673g = false;
        }
        C5486b bVar = this.f17671e;
        if (bVar != null) {
            bVar.mo27585b();
        }
        return super.onTouchEvent(motionEvent);
    }
}
