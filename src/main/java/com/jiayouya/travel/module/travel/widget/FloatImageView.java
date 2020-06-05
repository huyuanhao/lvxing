package com.jiayouya.travel.module.travel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import com.jiayouya.travel.common.p244b.GloblaEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo39189d2 = {"Lcom/jiayouya/travel/module/travel/widget/FloatImageView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "firstY", "", "lastY", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: FloatImageView.kt */
public final class FloatImageView extends ImageView {
    /* renamed from: a */
    private float f12223a;
    /* renamed from: b */
    private float f12224b;

    public FloatImageView(Context context, AttributeSet attributeSet) {
        C8271i.m35386b(context, "context");
        C8271i.m35386b(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C8271i.m35386b(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f12223a = motionEvent.getRawY();
            this.f12224b = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                setY(Math.max(0.0f, Math.min(getY() + (((float) ((int) motionEvent.getRawY())) - this.f12223a), ((float) GloblaEx.m12813a(false, 1, (Object) null)) - ((float) GloblaEx.m12810a(100.0f)))));
                this.f12223a = motionEvent.getRawY();
            }
        } else if (Math.abs(motionEvent.getRawY() - this.f12224b) <= ((float) GloblaEx.m12810a(3.0f))) {
            performClick();
        }
        return true;
    }
}
