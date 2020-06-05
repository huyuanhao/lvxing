package com.jiayouya.travel.module.p281tb.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jiayouya.travel.R;
import java.util.List;

/* renamed from: com.jiayouya.travel.module.tb.widget.TagGroup */
public class TagGroup extends ViewGroup {
    /* renamed from: a */
    private Context f11889a;
    /* renamed from: b */
    private float f11890b;
    /* renamed from: c */
    private float f11891c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C3319a f11892d;
    /* renamed from: e */
    private C3320b f11893e;

    /* renamed from: com.jiayouya.travel.module.tb.widget.TagGroup$a */
    public interface C3319a {
        /* renamed from: a */
        void mo21578a(String str);
    }

    /* renamed from: com.jiayouya.travel.module.tb.widget.TagGroup$b */
    class C3320b implements OnClickListener {
        C3320b() {
        }

        public void onClick(View view) {
            String charSequence = ((TextView) view).getText().toString();
            if (TagGroup.this.f11892d != null) {
                TagGroup.this.f11892d.mo21578a(charSequence);
            }
        }
    }

    public TagGroup(Context context) {
        this(context, null, 0);
    }

    public TagGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11893e = new C3320b();
        this.f11889a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagGroup);
        this.f11890b = obtainStyledAttributes.getDimension(1, 5.0f);
        this.f11891c = obtainStyledAttributes.getDimension(0, 5.0f);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount && i3 < 4; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                i5 = (int) (((float) i5) + ((float) measuredWidth) + this.f11891c);
                if (i5 > size) {
                    i4 = (int) (((float) i4) + ((float) i6) + this.f11890b);
                    i3++;
                    i5 = measuredWidth;
                    i6 = measuredHeight;
                } else {
                    i6 = Math.max(i6, measuredHeight);
                }
            }
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + i4 + i6;
        int paddingLeft = i3 == 0 ? getPaddingLeft() + getPaddingRight() + i5 : size;
        if (mode == 1073741824) {
            paddingLeft = size;
        }
        if (mode2 == 1073741824) {
            paddingTop = size2;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = getChildCount();
        int i5 = paddingLeft;
        int i6 = paddingTop;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount && i7 < 4; i9++) {
            View childAt = getChildAt(i9);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                if (i5 + measuredWidth > paddingRight) {
                    i7++;
                    i6 = (int) (((float) i6) + ((float) i8) + this.f11890b);
                    i5 = paddingLeft;
                    i8 = measuredHeight;
                } else {
                    i8 = Math.max(i8, measuredHeight);
                }
                childAt.layout(i5, i6, i5 + measuredWidth, measuredHeight + i6);
                i5 = (int) (((float) i5) + ((float) measuredWidth) + this.f11891c);
            }
        }
    }

    public void setTag(List<String> list) {
        removeAllViews();
        for (String text : list) {
            TextView textView = (TextView) LayoutInflater.from(this.f11889a).inflate(R.layout.item_tag, null, false);
            textView.setText(text);
            textView.setOnClickListener(this.f11893e);
            addView(textView);
        }
    }

    public void setOnTagItemClickListener(C3319a aVar) {
        this.f11892d = aVar;
    }
}
