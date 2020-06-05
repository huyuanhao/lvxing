package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.common.p424ui.imageview.CheckedImageButton;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.p502e.C6045d;
import com.qiyukf.unicorn.p503f.C6168c;
import com.qiyukf.unicorn.p516j.C6219f;
import java.util.List;

public class EmoticonPickerView extends LinearLayout implements C5541d {
    /* renamed from: a */
    RequestCallback<List<C6045d>> f17796a = new RequestCallback<List<C6045d>>() {
        public final void onException(Throwable th) {
            EmoticonPickerView.this.f17813r.post(new Runnable() {
                public final void run() {
                    EmoticonPickerView.this.m22495d();
                }
            });
        }

        public final void onFailed(int i) {
            EmoticonPickerView.this.f17813r.post(new Runnable() {
                public final void run() {
                    EmoticonPickerView.this.m22495d();
                }
            });
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            final List list = (List) obj;
            EmoticonPickerView.this.f17813r.post(new Runnable() {
                public final void run() {
                    if (!EmoticonPickerView.m22488a(list)) {
                        EmoticonPickerView.m22486a(EmoticonPickerView.this);
                        EmoticonPickerView.this.f17811p.removeAllViews();
                        EmoticonPickerView.this.f17809n.removeAllViews();
                        return;
                    }
                    EmoticonPickerView.this.m22498e();
                    C5548i.m22560a().mo27672a(list);
                    EmoticonPickerView.this.f17799d.mo27656a(list);
                    EmoticonPickerView.this.m22490b();
                    EmoticonPickerView.this.f17800e = true;
                    EmoticonPickerView.this.m22493c();
                }
            });
        }
    };
    /* renamed from: b */
    OnClickListener f17797b = new OnClickListener() {
        public final void onClick(View view) {
            EmoticonPickerView.this.m22491b(view.getId());
        }
    };
    /* renamed from: c */
    private Context f17798c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5542e f17799d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f17800e = false;
    /* renamed from: f */
    private View f17801f;
    /* renamed from: g */
    private C5535c f17802g;
    /* renamed from: h */
    private ViewPager f17803h;
    /* renamed from: i */
    private LinearLayout f17804i;
    /* renamed from: j */
    private TextView f17805j;
    /* renamed from: k */
    private Button f17806k;
    /* renamed from: l */
    private TextView f17807l;
    /* renamed from: m */
    private LinearLayout f17808m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public LinearLayout f17809n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public HorizontalScrollView f17810o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public LinearLayout f17811p;
    /* renamed from: q */
    private int f17812q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public Handler f17813r;

    public EmoticonPickerView(Context context) {
        super(context);
        m22485a(context);
    }

    public EmoticonPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22485a(context);
    }

    public EmoticonPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22485a(context);
    }

    /* renamed from: a */
    private CheckedImageButton m22484a(int i, OnClickListener onClickListener) {
        CheckedImageButton checkedImageButton = new CheckedImageButton(this.f17798c);
        checkedImageButton.mo27532b(C5961R.C5962drawable.ysf_sticker_button_background_normal_layer_list);
        checkedImageButton.mo27534c(C5961R.C5962drawable.ysf_sticker_button_background_pressed_layer_list);
        checkedImageButton.setId(i);
        checkedImageButton.setOnClickListener(onClickListener);
        checkedImageButton.setScaleType(ScaleType.FIT_CENTER);
        checkedImageButton.mo27528a(C5412d.m22146a(7.0f));
        int a = C5412d.m22146a(50.0f);
        int a2 = C5412d.m22146a(44.0f);
        this.f17811p.addView(checkedImageButton);
        LayoutParams layoutParams = checkedImageButton.getLayoutParams();
        layoutParams.width = a;
        layoutParams.height = a2;
        checkedImageButton.setLayoutParams(layoutParams);
        return checkedImageButton;
    }

    /* renamed from: a */
    private void m22485a(Context context) {
        this.f17798c = context;
        this.f17813r = new Handler(context.getMainLooper());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C5961R.C5964layout.ysf_emoji_layout, this);
    }

    /* renamed from: a */
    static /* synthetic */ void m22486a(EmoticonPickerView emoticonPickerView) {
        ViewPager viewPager = emoticonPickerView.f17803h;
        if (viewPager != null && emoticonPickerView.f17807l != null && emoticonPickerView.f17804i != null && emoticonPickerView.f17808m != null) {
            viewPager.setVisibility(8);
            emoticonPickerView.f17807l.setVisibility(8);
            emoticonPickerView.f17804i.setVisibility(8);
            emoticonPickerView.f17801f.setVisibility(8);
            emoticonPickerView.f17808m.setVisibility(0);
        }
    }

    /* renamed from: a */
    public static boolean m22488a(List<C6045d> list) {
        if (list.size() == 0) {
            return false;
        }
        return (list.size() == 1 && ((C6045d) list.get(0)).mo28890a() == -1 && ((C6045d) list.get(0)).mo28894e() == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22490b() {
        C5548i a = C5548i.m22560a();
        this.f17811p.removeAllViews();
        int i = 0;
        if (a.mo27675d()) {
            CheckedImageButton a2 = m22484a(0, this.f17797b);
            a2.mo27535d(C5961R.C5962drawable.ysf_emoji_icon_inactive);
            a2.mo27536e(C5961R.C5962drawable.ysf_emoji_icon);
            i = 1;
        }
        for (C5547h hVar : a.mo27674c()) {
            int i2 = i + 1;
            final CheckedImageButton a3 = m22484a(i, this.f17797b);
            C5426a.m22177a(hVar.mo27667c(), 100, 100, (ImageLoaderListener) new ImageLoaderListener() {
                public final void onLoadComplete(Bitmap bitmap) {
                    a3.mo27529a(bitmap);
                    a3.mo27533b(bitmap);
                }

                public final void onLoadFailed(Throwable th) {
                    a3.mo27535d(C5961R.C5962drawable.ysf_emoji_icon_inactive);
                    a3.mo27536e(C5961R.C5962drawable.ysf_emoji_icon);
                }
            });
            i = i2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22491b(int i) {
        C5535c cVar;
        m22494c(i);
        if (this.f17802g == null) {
            cVar = new C5535c(this.f17798c, this.f17799d, this.f17803h, this.f17809n);
        } else {
            if (i == 0) {
                cVar = new C5535c(this.f17798c, this.f17799d, this.f17803h, this.f17809n);
            }
            this.f17802g.mo27649a(i);
        }
        this.f17802g = cVar;
        this.f17802g.mo27650a((C5541d) this);
        this.f17802g.mo27649a(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22493c() {
        if (this.f17799d == null) {
            C5264a.m21617a("sticker", "show picker view when listener is null");
        }
        m22491b(0);
        this.f17813r.postDelayed(new Runnable() {
            /* renamed from: a */
            final /* synthetic */ int f17823a = 0;

            public final void run() {
                if (EmoticonPickerView.this.f17810o.getChildAt(0).getWidth() == 0) {
                    EmoticonPickerView.this.f17813r.postDelayed(this, 100);
                }
                View childAt = EmoticonPickerView.this.f17811p.getChildAt(this.f17823a);
                int right = (childAt == null || childAt.getRight() <= EmoticonPickerView.this.f17810o.getWidth()) ? -1 : childAt.getRight() - EmoticonPickerView.this.f17810o.getWidth();
                if (right != -1) {
                    EmoticonPickerView.this.f17810o.smoothScrollTo(right, 0);
                }
            }
        }, 100);
    }

    /* renamed from: c */
    private void m22494c(int i) {
        int i2 = 0;
        while (i2 < this.f17811p.getChildCount()) {
            View childAt = this.f17811p.getChildAt(i2);
            if (childAt instanceof FrameLayout) {
                childAt = ((FrameLayout) childAt).getChildAt(0);
            }
            if (childAt != null && (childAt instanceof CheckedImageButton)) {
                CheckedImageButton checkedImageButton = (CheckedImageButton) childAt;
                if (checkedImageButton.mo27531a() && i2 != i) {
                    checkedImageButton.mo27530a(false);
                } else if (!checkedImageButton.mo27531a() && i2 == i) {
                    checkedImageButton.mo27530a(true);
                }
            }
            i2++;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22495d() {
        String str;
        TextView textView;
        ViewPager viewPager = this.f17803h;
        if (viewPager != null && this.f17807l != null && this.f17804i != null && this.f17808m != null) {
            viewPager.setVisibility(8);
            this.f17807l.setVisibility(8);
            this.f17804i.setVisibility(0);
            this.f17808m.setVisibility(8);
            this.f17801f.setVisibility(0);
            C5548i a = C5548i.m22560a();
            if (C6219f.m24653a(this.f17798c) || a.mo27675d() || a.mo27674c().size() != 0) {
                textView = this.f17805j;
                str = "加载失败，请重新加载";
            } else {
                textView = this.f17805j;
                str = "当前网络不可用";
            }
            textView.setText(str);
            this.f17806k.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    new Thread(new Runnable() {
                        public final void run() {
                            C6168c.m24478a(EmoticonPickerView.this.f17796a);
                        }
                    }).start();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22498e() {
        ViewPager viewPager = this.f17803h;
        if (viewPager != null && this.f17807l != null && this.f17804i != null && this.f17808m != null) {
            viewPager.setVisibility(0);
            this.f17807l.setVisibility(8);
            this.f17801f.setVisibility(0);
            this.f17808m.setVisibility(8);
            this.f17804i.setVisibility(8);
        }
    }

    /* renamed from: a */
    public final void mo27627a() {
        C5535c cVar = this.f17802g;
        if (cVar != null) {
            cVar.mo27648a();
        }
    }

    /* renamed from: a */
    public final void mo27628a(int i) {
        if (this.f17812q != i) {
            this.f17812q = i;
            m22494c(i);
        }
    }

    /* renamed from: a */
    public final void mo27629a(C5542e eVar) {
        if (eVar != null) {
            this.f17799d = eVar;
        } else {
            C5264a.m21617a("sticker", "listener is null");
        }
        if (!eVar.mo27657a()) {
            if (!C6219f.m24653a(this.f17798c)) {
                m22495d();
                return;
            }
            ViewPager viewPager = this.f17803h;
            if (!(viewPager == null || this.f17807l == null || this.f17804i == null || this.f17808m == null)) {
                viewPager.setVisibility(8);
                this.f17807l.setVisibility(0);
                this.f17804i.setVisibility(8);
                this.f17808m.setVisibility(8);
                this.f17801f.setVisibility(0);
                this.f17807l.setText("正在加载表情请稍后...");
            }
            new Thread(new Runnable() {
                public final void run() {
                    C6168c.m24478a(EmoticonPickerView.this.f17796a);
                }
            }).start();
        } else if (!this.f17800e) {
            m22490b();
            this.f17800e = true;
            m22498e();
            m22493c();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f17803h = (ViewPager) findViewById(C5961R.C5963id.emotion_icon_pager);
        this.f17801f = findViewById(C5961R.C5963id.bottom_divider_line);
        this.f17809n = (LinearLayout) findViewById(C5961R.C5963id.layout_scr_bottom);
        this.f17811p = (LinearLayout) findViewById(C5961R.C5963id.emoj_tab_view);
        this.f17810o = (HorizontalScrollView) findViewById(C5961R.C5963id.emoj_tab_view_container);
        this.f17807l = (TextView) findViewById(C5961R.C5963id.tv_load_and_fail_message);
        this.f17808m = (LinearLayout) findViewById(C5961R.C5963id.ll_load_empty_parent);
        this.f17804i = (LinearLayout) findViewById(C5961R.C5963id.ll_load_fail_parent);
        this.f17806k = (Button) findViewById(C5961R.C5963id.btn_load_fail_reload);
        this.f17805j = (TextView) findViewById(C5961R.C5963id.ysf_tv_network_error_pic);
        findViewById(C5961R.C5963id.top_divider_line).setVisibility(0);
    }
}
