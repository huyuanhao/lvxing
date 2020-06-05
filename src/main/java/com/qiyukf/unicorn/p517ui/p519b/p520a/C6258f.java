package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6104b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6108c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6081a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6082b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e.C6083c;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p516j.C6228j;
import com.qiyukf.unicorn.p517ui.activity.CardPopupActivity;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.C6374a;
import com.qiyukf.unicorn.widget.pulltorefresh.PullableListView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.a.f */
public class C6258f extends C6257e implements OnClickListener, OnItemClickListener, OnDismissListener, C6374a {
    /* renamed from: a */
    private TextView f19495a;
    /* renamed from: b */
    private ListView f19496b;
    /* renamed from: c */
    private View f19497c;
    /* renamed from: d */
    private TextView f19498d;
    /* renamed from: e */
    private C6080e f19499e;
    /* renamed from: f */
    private C6261a f19500f;
    /* renamed from: g */
    private PopupWindow f19501g;
    /* renamed from: h */
    private View f19502h;
    /* renamed from: i */
    private View f19503i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public PullToRefreshLayout f19504j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public PullableListView f19505k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C6261a f19506l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public String f19507m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public String f19508n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public boolean f19509o;
    /* renamed from: p */
    private Observer<CustomNotification> f19510p = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (C6258f.this.f19509o && customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof C6104b)) {
                C6104b bVar = (C6104b) customNotification.getAttachment();
                if (bVar.mo29038a() instanceof C6080e) {
                    C6258f.this.f19509o = false;
                    C6080e eVar = (C6080e) bVar.mo29038a();
                    if (eVar.mo28943e() == null || eVar.mo28942d().isEmpty()) {
                        C6258f.this.f19505k.mo29622a(false);
                        C6258f.this.f19504j.mo29608a(2);
                        return;
                    }
                    C6258f.this.f19507m = eVar.mo28943e().mo28944a();
                    C6258f.this.f19508n = eVar.mo28943e().mo28945b();
                    C6258f.this.f19506l.mo29459b(eVar.mo28942d());
                    C6258f.this.f19506l.notifyDataSetChanged();
                    C6258f.this.f19504j.mo29608a(0);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.unicorn.ui.b.a.f$a */
    private static class C6261a extends BaseAdapter {
        /* renamed from: a */
        private List<C6083c> f19513a = new ArrayList();
        /* renamed from: b */
        private boolean f19514b;

        public C6261a(boolean z) {
            this.f19514b = z;
        }

        /* renamed from: a */
        public final C6083c getItem(int i) {
            return (C6083c) this.f19513a.get(i);
        }

        /* renamed from: a */
        public final void mo29458a(List<C6083c> list) {
            this.f19513a.clear();
            mo29459b(list);
        }

        /* renamed from: b */
        public final void mo29459b(List<C6083c> list) {
            this.f19513a.addAll(list);
        }

        public final int getCount() {
            return this.f19513a.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C6262b bVar;
            boolean z = false;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_view_holder_card, viewGroup, false);
                bVar = new C6262b(view, this.f19514b);
                view.setTag(bVar);
            } else {
                bVar = (C6262b) view.getTag();
            }
            bVar.mo29464a((C6083c) this.f19513a.get(i));
            if (i < this.f19513a.size() - 1) {
                z = true;
            }
            bVar.mo29465a(z);
            return view;
        }
    }

    /* renamed from: com.qiyukf.unicorn.ui.b.a.f$b */
    static class C6262b {
        /* renamed from: a */
        private LinearLayout f19515a;
        /* renamed from: b */
        private View f19516b;
        /* renamed from: c */
        private boolean f19517c;

        C6262b(View view, boolean z) {
            this.f19517c = z;
            this.f19515a = (LinearLayout) view.findViewById(C5961R.C5963id.ysf_holder_card_container);
            this.f19516b = view.findViewById(C5961R.C5963id.ysf_holder_card_divider);
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final void mo29464a(C6083c cVar) {
            this.f19515a.removeAllViews();
            for (List<C6082b> list : cVar.mo28955b()) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f19515a.getContext()).inflate(C5961R.C5964layout.ysf_message_item_card_layout, this.f19515a, false);
                for (C6082b a : list) {
                    C6251b.m24732a(a, linearLayout, list.size(), this.f19517c);
                }
                this.f19515a.addView(linearLayout);
            }
        }

        /* access modifiers changed from: final */
        /* renamed from: a */
        public final void mo29465a(boolean z) {
            this.f19516b.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: a */
    private void m24745a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f19510p, z);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        this.f19499e = (C6080e) this.message.getAttachment();
        this.f19495a.setText(this.f19499e.mo28941c());
        this.f19500f.mo29458a(this.f19499e.mo28942d());
        this.f19496b.setAdapter(this.f19500f);
        this.f19496b.setOnItemClickListener(this);
        if (this.f19499e.mo28943e() != null) {
            this.f19497c.setVisibility(0);
            this.f19498d.setText(this.f19499e.mo28943e().mo28947d());
            this.f19498d.setOnClickListener(this);
            return;
        }
        this.f19497c.setVisibility(8);
    }

    /* renamed from: a */
    public final void mo29449a(String str, String str2) {
        if (getAdapter().mo27734d().mo27723a()) {
            CardPopupActivity.start(this.context, this.message.getSessionId(), str, str2);
        }
    }

    /* renamed from: c */
    public final void mo29452c() {
        if (getAdapter().mo27734d().mo27723a()) {
            this.f19501g = new PopupWindow(this.context);
            this.f19501g.setWidth(-1);
            this.f19501g.setHeight((int) (((double) C5412d.m22148b()) * 0.8d));
            this.f19501g.setContentView(LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_popup_window_bot_list, null));
            this.f19501g.setBackgroundDrawable(new ColorDrawable(0));
            this.f19501g.setOutsideTouchable(false);
            this.f19501g.setFocusable(true);
            this.f19501g.setOnDismissListener(this);
            this.f19501g.setAnimationStyle(C5961R.style.ysf_dialog_window_animation_style);
            this.f19501g.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
            C6228j.m24667a(((Activity) this.context).getWindow(), 0.3f);
            this.f19502h = this.f19501g.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_placeholder);
            TextView textView = (TextView) this.f19501g.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_title);
            this.f19503i = this.f19501g.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_close);
            this.f19504j = (PullToRefreshLayout) this.f19501g.getContentView().findViewById(C5961R.C5963id.ysf_ptr_layout_bot_list);
            this.f19505k = (PullableListView) this.f19501g.getContentView().findViewById(C5961R.C5963id.ysf_lv_bot_list);
            textView.setText(this.f19499e.mo28943e().mo28948e());
            this.f19502h.setOnClickListener(this);
            this.f19503i.setOnClickListener(this);
            this.f19505k.setOnItemClickListener(this);
            this.f19507m = this.f19499e.mo28943e().mo28944a();
            this.f19508n = this.f19499e.mo28943e().mo28945b();
            if (this.f19506l == null) {
                this.f19506l = new C6261a(false);
            }
            this.f19506l = this.f19506l;
            this.f19506l.mo29458a(this.f19499e.mo28942d());
            this.f19505k.setAdapter(this.f19506l);
            this.f19505k.mo29622a(true);
            this.f19504j.mo29609a((C6374a) this);
            m24745a(true);
            getAdapter().mo27734d().mo27724b();
        }
    }

    /* renamed from: d */
    public final void mo29453d() {
        if (C6029d.m24047g().mo29295c(this.message.getSessionId()) == 0) {
            this.f19504j.mo29608a(1);
            C5415g.m22161a(C5961R.string.ysf_bot_load_more_disabled);
            return;
        }
        C6108c cVar = new C6108c();
        cVar.mo29049a(this.f19507m);
        cVar.mo29050b(this.f19508n);
        C6185c.m24532a(cVar, this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200) {
                    C6258f.this.f19509o = true;
                    return;
                }
                C6258f.this.f19509o = false;
                C6258f.this.f19504j.mo29608a(1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_bot_list;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19495a = (TextView) findViewById(C5961R.C5963id.ysf_tv_bot_list_title);
        this.f19496b = (ListView) findViewById(C5961R.C5963id.ysf_lv_bot_list);
        this.f19497c = findViewById(C5961R.C5963id.ysf_bot_footer_layout);
        this.f19498d = (TextView) findViewById(C5961R.C5963id.ysf_bot_footer_text);
        this.f19500f = new C6261a(true);
    }

    public void onClick(View view) {
        if (view == this.f19498d) {
            C6250a.m24730a(this.f19499e.mo28943e(), this);
            return;
        }
        if (view == this.f19503i || view == this.f19502h) {
            this.f19501g.dismiss();
        }
    }

    public void onDismiss() {
        C6228j.m24667a(((Activity) this.context).getWindow(), 1.0f);
        m24745a(false);
        this.f19509o = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C6081a a = ((C6261a) adapterView.getAdapter()).getItem(i).mo28954a();
        C6250a.m24730a(a, this);
        if (adapterView == this.f19505k && !TextUtils.equals(a.mo28946c(), "popup")) {
            this.f19501g.dismiss();
        }
    }
}
