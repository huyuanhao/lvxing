package com.qiyukf.unicorn.p517ui.p518a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.p516j.C6228j;
import com.qiyukf.unicorn.p517ui.evaluate.C6327c;
import com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.a.a */
public final class C6229a {
    /* renamed from: a */
    private Context f19412a;
    /* renamed from: b */
    private UICustomization f19413b;
    /* renamed from: c */
    private C6327c f19414c;
    /* renamed from: d */
    private ViewGroup f19415d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public LinearLayout f19416e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public PopupWindow f19417f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C6233a f19418g;
    /* renamed from: h */
    private List<C6234b> f19419h;

    /* renamed from: com.qiyukf.unicorn.ui.a.a$a */
    public interface C6233a {
        /* renamed from: a */
        void mo29422a(C6234b bVar);
    }

    public C6229a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.f19415d = viewGroup;
            this.f19412a = viewGroup.getContext();
            this.f19416e = new LinearLayout(this.f19412a);
            this.f19416e.setOrientation(0);
            this.f19416e.setGravity(16);
            this.f19416e.setPadding(C5412d.m22146a(10.0f), 0, C5412d.m22146a(10.0f), 0);
            this.f19415d.removeAllViews();
            this.f19415d.addView(this.f19416e);
        }
    }

    /* renamed from: a */
    private View m24668a(final C6234b bVar, boolean z) {
        Resources resources;
        int i;
        View inflate = LayoutInflater.from(this.f19412a).inflate(z ? C5961R.C5964layout.ysf_service_action_menu_item_folded : C5961R.C5964layout.ysf_service_action_menu_item, null);
        ImageView imageView = (ImageView) inflate.findViewById(C5961R.C5963id.ysf_action_menu_icon);
        TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_action_menu_title);
        textView.setText(bVar.mo29425b());
        if (z || !m24674b()) {
            imageView.setImageResource(bVar.mo29427d());
            resources = this.f19412a.getResources();
            i = C5961R.color.ysf_title_bar_text_color_dark_selector;
        } else {
            imageView.setImageResource(bVar.mo29428e());
            resources = this.f19412a.getResources();
            i = C5961R.color.ysf_title_bar_text_color_light_selector;
        }
        textView.setTextColor(resources.getColorStateList(i));
        if (!TextUtils.isEmpty(bVar.mo29426c())) {
            int dimension = (int) this.f19412a.getResources().getDimension(C5961R.dimen.ysf_title_bar_icon_size);
            C5426a.m22179a(bVar.mo29426c(), imageView, dimension, dimension);
        }
        if (bVar.mo29423a() == C6236a.f19432b) {
            textView.setMaxEms(3);
            textView.setEllipsize(TruncateAt.END);
        }
        C6228j.m24666a(inflate, bVar.mo29430f());
        if (bVar.mo29423a() == C6236a.f19434d) {
            C6228j.m24666a(inflate, false);
            C6327c cVar = this.f19414c;
            if (cVar != null) {
                cVar.mo29535a(inflate);
            }
        }
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                C6229a.this.m24670a();
                if (C6229a.this.f19418g != null) {
                    C6229a.this.f19418g.mo29422a(bVar);
                }
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24670a() {
        PopupWindow popupWindow = this.f19417f;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f19417f.dismiss();
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24671a(C6229a aVar, float f) {
        Context context = aVar.f19412a;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            LayoutParams attributes = window.getAttributes();
            attributes.alpha = f;
            window.setAttributes(attributes);
        }
    }

    /* renamed from: b */
    private void m24673b(List<C6234b> list) {
        LinearLayout linearLayout = new LinearLayout(this.f19412a);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(C5961R.C5962drawable.ysf_menu_panel_background);
        for (int i = 1; i < list.size(); i++) {
            C6234b bVar = (C6234b) list.get(i);
            if (i > 1) {
                linearLayout.addView(LayoutInflater.from(this.f19412a).inflate(C5961R.C5964layout.ysf_include_divider, linearLayout, false), -1, C5412d.m22146a(0.5f));
            }
            linearLayout.addView(m24668a(bVar, true), -1, -2);
        }
        this.f19417f = new PopupWindow(this.f19412a);
        this.f19417f.setWidth(C5412d.m22146a(100.0f));
        this.f19417f.setHeight(-2);
        this.f19417f.setContentView(linearLayout);
        this.f19417f.setBackgroundDrawable(new ColorDrawable(0));
        this.f19417f.setOutsideTouchable(false);
        this.f19417f.setFocusable(true);
        this.f19417f.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss() {
                C6229a.m24671a(C6229a.this, 1.0f);
            }
        });
    }

    /* renamed from: b */
    private boolean m24674b() {
        UICustomization uICustomization = this.f19413b;
        return uICustomization != null && uICustomization.titleBarStyle == 1;
    }

    /* renamed from: a */
    public final void mo29415a(UICustomization uICustomization) {
        this.f19413b = uICustomization;
    }

    /* renamed from: a */
    public final void mo29416a(C6233a aVar) {
        this.f19418g = aVar;
    }

    /* renamed from: a */
    public final void mo29417a(C6327c cVar) {
        this.f19414c = cVar;
    }

    /* renamed from: a */
    public final void mo29418a(List<C6234b> list) {
        if (this.f19415d != null) {
            if (list.isEmpty()) {
                this.f19415d.setVisibility(8);
                return;
            }
            this.f19415d.setVisibility(0);
            List<C6234b> list2 = this.f19419h;
            boolean z = true;
            if (list2 != null && list2.size() == list.size()) {
                int i = 0;
                while (true) {
                    if (i >= this.f19419h.size()) {
                        z = false;
                        break;
                    } else if (!((C6234b) this.f19419h.get(i)).equals(list.get(i))) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (z) {
                this.f19419h = list;
                m24670a();
                for (C6234b a : this.f19419h) {
                    a.mo29424a(this.f19412a);
                }
                this.f19416e.removeAllViews();
                if (this.f19419h.size() < 3) {
                    for (int i2 = 0; i2 < this.f19419h.size(); i2++) {
                        View a2 = m24668a((C6234b) this.f19419h.get(i2), false);
                        if (i2 > 0) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.leftMargin = C5412d.m22146a(10.0f);
                            a2.setLayoutParams(layoutParams);
                        }
                        this.f19416e.addView(a2);
                    }
                    return;
                }
                this.f19416e.addView(m24668a((C6234b) this.f19419h.get(0), false));
                ImageView imageView = new ImageView(this.f19412a);
                imageView.setScaleType(ScaleType.CENTER_INSIDE);
                imageView.setImageResource(m24674b() ? C5961R.C5962drawable.ysf_ic_menu_more_light : C5961R.C5962drawable.ysf_ic_menu_more_dark);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (C6229a.this.f19417f != null) {
                            C6229a.this.f19417f.showAsDropDown(C6229a.this.f19416e, -C5412d.m22146a(30.0f), C5412d.m22146a(10.0f));
                            C6229a.m24671a(C6229a.this, 0.5f);
                        }
                        if (C6229a.this.f19418g != null) {
                            C6229a.this.f19418g.mo29422a(new C6234b(C6236a.f19431a));
                        }
                    }
                });
                int dimension = (int) this.f19412a.getResources().getDimension(C5961R.dimen.ysf_title_bar_icon_size);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimension, dimension);
                layoutParams2.leftMargin = C5412d.m22146a(10.0f);
                this.f19416e.addView(imageView, layoutParams2);
                m24673b(this.f19419h);
            }
        }
    }
}
