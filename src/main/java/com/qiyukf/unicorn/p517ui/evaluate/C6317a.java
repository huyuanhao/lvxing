package com.qiyukf.unicorn.p517ui.evaluate;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6116c;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;
import com.qiyukf.unicorn.p514h.C6178a;
import com.qiyukf.unicorn.widget.flowlayout.C6369a;
import com.qiyukf.unicorn.widget.flowlayout.FlowLayout;
import com.qiyukf.unicorn.widget.flowlayout.TagFlowLayout;
import com.qiyukf.unicorn.widget.flowlayout.TagFlowLayout.C6368b;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.qiyukf.unicorn.ui.evaluate.a */
public final class C6317a extends Dialog implements OnCancelListener, OnShowListener, OnClickListener {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public View f19699a;
    /* renamed from: b */
    private ImageView f19700b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ScrollView f19701c;
    /* renamed from: d */
    private LinearLayout f19702d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public EditText f19703e;
    /* renamed from: f */
    private Button f19704f;
    /* renamed from: g */
    private C6325a f19705g;
    /* renamed from: h */
    private Context f19706h;
    /* renamed from: i */
    private C6148d f19707i;
    /* renamed from: j */
    private C6115b f19708j;
    /* renamed from: k */
    private String f19709k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public int f19710l = -1;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public Set<Integer>[] f19711m;
    /* renamed from: n */
    private List<String> f19712n = new ArrayList();
    /* renamed from: o */
    private String f19713o;
    /* renamed from: p */
    private int f19714p;
    /* renamed from: q */
    private OnTouchListener f19715q = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            C6317a.this.f19703e.postDelayed(new Runnable() {
                public final void run() {
                    C6317a.this.f19701c.fullScroll(130);
                }
            }, 200);
            return false;
        }
    };
    /* renamed from: r */
    private TextWatcher f19716r = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            if (C6317a.this.f19710l != -1) {
                C6317a.this.mo29518a(true);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    /* renamed from: s */
    private C6369a<String> f19717s = new C6369a<String>(this.f19712n) {
        /* renamed from: a */
        public final /* synthetic */ View mo29530a(FlowLayout flowLayout, int i, Object obj) {
            String str = (String) obj;
            View inflate = LayoutInflater.from(flowLayout.getContext()).inflate(C5961R.C5964layout.ysf_evaluation_tag_item, flowLayout, false);
            TextView textView = (TextView) inflate.findViewById(C5961R.C5963id.ysf_tag_text);
            textView.setText(str);
            textView.setSelected(C6317a.this.f19711m[C6317a.this.f19710l].contains(Integer.valueOf(i)));
            return inflate;
        }
    };
    /* renamed from: t */
    private C6368b f19718t = new C6368b() {
        /* renamed from: a */
        public final boolean mo29531a(View view, int i) {
            TextView textView = (TextView) view.findViewById(C5961R.C5963id.ysf_tag_text);
            if (!textView.isSelected()) {
                textView.setSelected(true);
                C6317a.this.f19711m[C6317a.this.f19710l].add(Integer.valueOf(i));
            } else {
                textView.setSelected(false);
                C6317a.this.f19711m[C6317a.this.f19710l].remove(Integer.valueOf(i));
            }
            return true;
        }
    };

    /* renamed from: com.qiyukf.unicorn.ui.evaluate.a$a */
    public interface C6325a {
        /* renamed from: a */
        void mo29272a(int i, List<String> list, String str);
    }

    public C6317a(Context context, C6148d dVar) {
        super(context, C5961R.style.ysf_popup_dialog_style);
        this.f19706h = context;
        this.f19707i = dVar;
        this.f19713o = dVar.mo29195d();
        this.f19714p = dVar.mo29191b();
        m24886a();
    }

    public C6317a(Context context, String str) {
        super(context, C5961R.style.ysf_popup_dialog_style);
        this.f19706h = context;
        this.f19709k = str;
        m24886a();
    }

    /* renamed from: a */
    private void m24886a() {
        C6148d dVar = this.f19707i;
        if (dVar != null) {
            this.f19708j = dVar.mo29196e();
        }
        C6115b bVar = this.f19708j;
        if (bVar == null || bVar.mo29063f() == null) {
            C6029d.m24047g();
            this.f19708j = C6178a.m24514a(this.f19709k);
        }
        this.f19711m = new Set[this.f19708j.mo29063f().size()];
        int i = 0;
        while (true) {
            Set<Integer>[] setArr = this.f19711m;
            if (i < setArr.length) {
                setArr[i] = new HashSet();
                i++;
            } else {
                this.f19699a = LayoutInflater.from(getContext()).inflate(C5961R.C5964layout.ysf_dialog_evaluation, null);
                setContentView(this.f19699a);
                setCancelable(false);
                setOnShowListener(this);
                setOnCancelListener(this);
                this.f19700b = (ImageView) this.f19699a.findViewById(C5961R.C5963id.ysf_evaluation_dialog_close);
                this.f19701c = (ScrollView) this.f19699a.findViewById(C5961R.C5963id.scroll_view);
                this.f19703e = (EditText) this.f19699a.findViewById(C5961R.C5963id.ysf_evaluation_dialog_et_remark);
                this.f19704f = (Button) this.f19699a.findViewById(C5961R.C5963id.ysf_btn_submit);
                this.f19702d = (LinearLayout) this.f19699a.findViewById(C5961R.C5963id.ysf_evaluation_dialog_radio_group);
                TagFlowLayout tagFlowLayout = (TagFlowLayout) this.f19699a.findViewById(C5961R.C5963id.ysf_evaluation_tag_layout);
                this.f19700b.setOnClickListener(this);
                this.f19703e.setOnTouchListener(this.f19715q);
                this.f19704f.setOnClickListener(this);
                tagFlowLayout.mo29595a((C6369a) this.f19717s);
                tagFlowLayout.mo29594a(this.f19718t);
                this.f19703e.addTextChangedListener(this.f19716r);
                m24890b();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24887a(int i) {
        int i2;
        if (this.f19708j.mo29066i() == 1) {
            int c = this.f19708j.mo29060c();
            if (c == 2) {
                i2 = 1 - i;
            } else if (c != 3) {
                i2 = 4 - i;
            } else {
                this.f19710l = 2 - i;
            }
            this.f19710l = i2;
        } else {
            this.f19710l = i;
        }
        mo29518a(true);
        int i3 = 0;
        while (i3 < this.f19702d.getChildCount()) {
            this.f19702d.getChildAt(i3).setSelected(i3 == i);
            i3++;
        }
        List e = ((C6116c) this.f19708j.mo29063f().get(this.f19710l)).mo29072e();
        this.f19712n.clear();
        this.f19712n.addAll(e);
        this.f19717s.mo29607c();
    }

    /* renamed from: b */
    private void m24890b() {
        C6326b bVar;
        int c = this.f19708j.mo29060c();
        List f = this.f19708j.mo29063f();
        ArrayList<C6326b> arrayList = new ArrayList<>();
        if (c == 2) {
            arrayList.add(new C6326b(((C6116c) f.get(0)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_satisfied));
            bVar = new C6326b(((C6116c) f.get(1)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_dissatisfied);
        } else if (c == 3) {
            arrayList.add(new C6326b(((C6116c) f.get(0)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_satisfied));
            arrayList.add(new C6326b(((C6116c) f.get(1)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_common));
            bVar = new C6326b(((C6116c) f.get(2)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_dissatisfied);
        } else {
            arrayList.add(new C6326b(((C6116c) f.get(0)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_very_satisfied));
            arrayList.add(new C6326b(((C6116c) f.get(1)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_satisfied));
            arrayList.add(new C6326b(((C6116c) f.get(2)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_common));
            arrayList.add(new C6326b(((C6116c) f.get(3)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_dissatisfied));
            bVar = new C6326b(((C6116c) f.get(4)).mo29070c(), C5961R.C5962drawable.ysf_evaluation_very_dissatisfied);
        }
        arrayList.add(bVar);
        if (this.f19708j.mo29066i() == 1) {
            Collections.reverse(arrayList);
        }
        for (C6326b bVar2 : arrayList) {
            final EvaluationEntryView evaluationEntryView = new EvaluationEntryView(this.f19706h);
            evaluationEntryView.mo29516a(bVar2.mo29532a());
            evaluationEntryView.mo29515a(bVar2.mo29533b());
            final int indexOf = arrayList.indexOf(bVar2);
            evaluationEntryView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    evaluationEntryView.mo29514a();
                    C6317a.this.m24887a(indexOf);
                    C6317a.this.mo29518a(true);
                }
            });
            this.f19702d.addView(evaluationEntryView, new LayoutParams(0, -2, 1.0f));
            C6148d dVar = this.f19707i;
            if (!(dVar == null || dVar.mo29191b() == 0 || this.f19707i.mo29191b() != ((C6116c) f.get(indexOf)).mo29071d())) {
                evaluationEntryView.mo29514a();
                m24887a(indexOf);
            }
        }
        C6148d dVar2 = this.f19707i;
        if (dVar2 == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar2.mo29195d()) || this.f19707i.mo29191b() != 0) {
            if (!TextUtils.isEmpty(this.f19707i.mo29195d())) {
                this.f19703e.setText(this.f19707i.mo29195d());
            }
            mo29518a(false);
        }
    }

    /* renamed from: a */
    public final void mo29517a(C6325a aVar) {
        this.f19705g = aVar;
    }

    /* renamed from: a */
    public final void mo29518a(boolean z) {
        Button button = this.f19704f;
        if (button != null) {
            button.setEnabled(z);
        }
    }

    /* renamed from: b */
    public final void mo29519b(boolean z) {
        Button button = this.f19704f;
        if (button != null) {
            button.setText(z ? C5961R.string.ysf_evaluation_btn_submitting : C5961R.string.ysf_evaluation_btn_submit);
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        C6029d.m24047g().mo29296c().mo29268a((C6317a) null);
    }

    public final void onClick(View view) {
        Context context;
        int i;
        C5409b.m22133b(getWindow().getDecorView());
        if (view != this.f19700b) {
            if (!(view != this.f19704f || this.f19705g == null || this.f19710l == -1)) {
                C6116c cVar = (C6116c) this.f19708j.mo29063f().get(this.f19710l);
                int d = cVar.mo29071d();
                Set<Integer> set = this.f19711m[this.f19710l];
                ArrayList arrayList = new ArrayList(set.size());
                for (Integer intValue : set) {
                    arrayList.add(cVar.mo29072e().get(intValue.intValue()));
                }
                String trim = this.f19703e.getText().toString().trim();
                if (cVar.mo29068a() == 1 && arrayList.size() == 0) {
                    C5415g.m22165b(C5961R.string.ysf_evaluation_empty_label);
                } else if (cVar.mo29069b() != 1 || !TextUtils.isEmpty(trim)) {
                    this.f19705g.mo29272a(d, arrayList, trim);
                } else {
                    C5415g.m22165b(C5961R.string.ysf_evaluation_empty_remark);
                }
            }
        } else if (this.f19703e.length() == 0) {
            cancel();
        } else {
            this.f19699a.setVisibility(8);
            if (this.f19708j.mo29065h()) {
                context = this.f19706h;
                i = C5961R.string.ysf_evaluation_dialog_message_multi;
            } else {
                context = this.f19706h;
                i = C5961R.string.ysf_evaluation_dialog_message;
            }
            String string = context.getString(i);
            Context context2 = this.f19706h;
            C6364g.m25004a(context2, null, string, context2.getString(C5961R.string.ysf_yes), this.f19706h.getString(C5961R.string.ysf_no), false, new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    if (i == 0) {
                        C6317a.this.cancel();
                    } else {
                        C6317a.this.f19699a.setVisibility(0);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
    }

    public final void onShow(DialogInterface dialogInterface) {
        C6029d.m24047g().mo29296c().mo29268a(this);
    }
}
