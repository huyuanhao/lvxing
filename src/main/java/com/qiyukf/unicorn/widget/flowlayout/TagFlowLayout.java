package com.qiyukf.unicorn.widget.flowlayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.HashSet;
import java.util.Set;

public class TagFlowLayout extends FlowLayout implements C6370a {
    /* renamed from: d */
    private C6369a f19857d;
    /* renamed from: e */
    private int f19858e;
    /* renamed from: f */
    private Set<Integer> f19859f;
    /* renamed from: g */
    private C6367a f19860g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C6368b f19861h;

    /* renamed from: com.qiyukf.unicorn.widget.flowlayout.TagFlowLayout$a */
    public interface C6367a {
    }

    /* renamed from: com.qiyukf.unicorn.widget.flowlayout.TagFlowLayout$b */
    public interface C6368b {
        /* renamed from: a */
        boolean mo29531a(View view, int i);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19858e = -1;
        this.f19859f = new HashSet();
    }

    /* renamed from: a */
    private static void m25008a(int i, TagView tagView) {
        tagView.setChecked(true);
        tagView.getChildAt(0);
        StringBuilder sb = new StringBuilder("onSelected ");
        sb.append(i);
        Log.d("zhy", sb.toString());
    }

    /* renamed from: a */
    static /* synthetic */ void m25009a(TagFlowLayout tagFlowLayout, TagView tagView, int i) {
        if (!tagView.isChecked()) {
            if (tagFlowLayout.f19858e == 1 && tagFlowLayout.f19859f.size() == 1) {
                Integer num = (Integer) tagFlowLayout.f19859f.iterator().next();
                m25011b(num.intValue(), (TagView) tagFlowLayout.getChildAt(num.intValue()));
                m25008a(i, tagView);
                tagFlowLayout.f19859f.remove(num);
            } else if (tagFlowLayout.f19858e <= 0 || tagFlowLayout.f19859f.size() < tagFlowLayout.f19858e) {
                m25008a(i, tagView);
            } else {
                return;
            }
            tagFlowLayout.f19859f.add(Integer.valueOf(i));
        } else {
            m25011b(i, tagView);
            tagFlowLayout.f19859f.remove(Integer.valueOf(i));
        }
        if (tagFlowLayout.f19860g != null) {
            new HashSet(tagFlowLayout.f19859f);
        }
    }

    /* renamed from: b */
    private void m25010b() {
        removeAllViews();
        C6369a aVar = this.f19857d;
        HashSet a = aVar.mo29604a();
        for (final int i = 0; i < aVar.mo29606b(); i++) {
            View a2 = aVar.mo29530a(this, i, aVar.mo29603a(i));
            final TagView tagView = new TagView(getContext());
            a2.setDuplicateParentStateEnabled(true);
            if (a2.getLayoutParams() != null) {
                tagView.setLayoutParams(a2.getLayoutParams());
            } else {
                int i2 = (int) ((getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                marginLayoutParams.setMargins(i2, i2, i2, i2);
                tagView.setLayoutParams(marginLayoutParams);
            }
            a2.setLayoutParams(new LayoutParams(-1, -1));
            tagView.addView(a2);
            addView(tagView);
            if (a.contains(Integer.valueOf(i))) {
                m25008a(i, tagView);
            }
            aVar.mo29603a(i);
            a2.setClickable(false);
            tagView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TagFlowLayout.m25009a(TagFlowLayout.this, tagView, i);
                    if (TagFlowLayout.this.f19861h != null) {
                        TagFlowLayout.this.f19861h.mo29531a(tagView, i);
                    }
                }
            });
        }
        this.f19859f.addAll(a);
    }

    /* renamed from: b */
    private static void m25011b(int i, TagView tagView) {
        tagView.setChecked(false);
        tagView.getChildAt(0);
        StringBuilder sb = new StringBuilder("unSelected ");
        sb.append(i);
        Log.d("zhy", sb.toString());
    }

    /* renamed from: a */
    public final void mo29593a() {
        this.f19859f.clear();
        m25010b();
    }

    /* renamed from: a */
    public final void mo29594a(C6368b bVar) {
        this.f19861h = bVar;
    }

    /* renamed from: a */
    public final void mo29595a(C6369a aVar) {
        this.f19857d = aVar;
        this.f19857d.mo29605a((C6370a) this);
        this.f19859f.clear();
        m25010b();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getChildAt(0).getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String parseInt : string.split("\\|")) {
                    int parseInt2 = Integer.parseInt(parseInt);
                    this.f19859f.add(Integer.valueOf(parseInt2));
                    TagView tagView = (TagView) getChildAt(parseInt2);
                    if (tagView != null) {
                        m25008a(parseInt2, tagView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.f19859f.size() > 0) {
            for (Integer intValue : this.f19859f) {
                int intValue2 = intValue.intValue();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(intValue2);
                sb.append("|");
                str = sb.toString();
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }
}
