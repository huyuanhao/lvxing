package com.qiyukf.nim.uikit.session.helper;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.qiyukf.basesdk.p393a.C5264a;

/* renamed from: com.qiyukf.nim.uikit.session.helper.a */
public final class C5554a implements OnTouchListener {
    /* renamed from: a */
    private C5555a f17900a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f17901b;

    /* renamed from: com.qiyukf.nim.uikit.session.helper.a$a */
    private class C5555a implements Runnable {
        /* renamed from: b */
        private View f17903b;

        C5555a(View view) {
            this.f17903b = view;
        }

        public final void run() {
            View view = this.f17903b;
            while (!view.performLongClick() && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            C5554a.this.f17901b = false;
        }
    }

    /* renamed from: a */
    public static C5554a m22582a() {
        return new C5554a();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f17900a == null) {
            this.f17900a = new C5555a(view);
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(null);
        Spannable newSpannable = Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 3) {
            int x = (int) motionEvent.getX();
            int totalPaddingLeft = (x - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) totalPaddingLeft);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 0) {
                    this.f17901b = true;
                    view.postDelayed(this.f17900a, (long) ViewConfiguration.getLongPressTimeout());
                } else if (this.f17901b) {
                    view.removeCallbacks(this.f17900a);
                    if (action == 1) {
                        try {
                            clickableSpanArr[0].onClick(textView);
                        } catch (Throwable th) {
                            C5264a.m21621b("onSpanClick is error", "", th);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
