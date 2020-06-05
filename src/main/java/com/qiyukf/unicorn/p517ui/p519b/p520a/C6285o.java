package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.C5969b;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5971b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6104b;
import com.qiyukf.unicorn.p503f.p504a.p505a.C6108c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k.C6097b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k.C6097b.C6098a;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p516j.C6228j;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.C6374a;
import com.qiyukf.unicorn.widget.pulltorefresh.PullableListView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.a.o */
public class C6285o extends C6257e implements OnClickListener, OnItemClickListener, OnDismissListener, C6374a {
    /* renamed from: a */
    private TextView f19596a;
    /* renamed from: b */
    private ListView f19597b;
    /* renamed from: c */
    private View f19598c;
    /* renamed from: d */
    private TextView f19599d;
    /* renamed from: e */
    private C6288a f19600e;
    /* renamed from: f */
    private PopupWindow f19601f;
    /* renamed from: g */
    private View f19602g;
    /* renamed from: h */
    private View f19603h;
    /* access modifiers changed from: private */
    /* renamed from: i */
    public PullToRefreshLayout f19604i;
    /* access modifiers changed from: private */
    /* renamed from: j */
    public PullableListView f19605j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public C6288a f19606k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public String f19607l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public String f19608m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public boolean f19609n;
    /* renamed from: o */
    private Observer<CustomNotification> f19610o = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (C6285o.this.f19609n && customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof C6104b)) {
                C6104b bVar = (C6104b) customNotification.getAttachment();
                if (bVar.mo29038a() instanceof C6095k) {
                    C6285o.this.f19609n = false;
                    C6095k kVar = (C6095k) bVar.mo29038a();
                    if (kVar.mo29006e() == null || kVar.mo29005d().isEmpty()) {
                        C6285o.this.f19605j.mo29622a(false);
                        C6285o.this.f19604i.mo29608a(2);
                        return;
                    }
                    C6285o.this.f19607l = kVar.mo29006e().mo29008b();
                    C6285o.this.f19608m = kVar.mo29006e().mo29009c();
                    C6285o.this.f19606k.mo29491b(kVar.mo29005d());
                    C6285o.this.f19606k.notifyDataSetChanged();
                    C6285o.this.f19604i.mo29608a(0);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.unicorn.ui.b.a.o$a */
    private static class C6288a extends BaseAdapter {
        /* renamed from: a */
        private List<Object> f19613a;

        /* renamed from: com.qiyukf.unicorn.ui.b.a.o$a$a */
        private static class C6289a {
            /* renamed from: a */
            private ImageView f19614a;
            /* renamed from: b */
            private TextView f19615b;
            /* renamed from: c */
            private TextView f19616c;
            /* renamed from: d */
            private TextView f19617d;
            /* renamed from: e */
            private TextView f19618e;
            /* renamed from: f */
            private TextView f19619f;
            /* renamed from: g */
            private View f19620g;

            public C6289a(View view) {
                this.f19614a = (ImageView) view.findViewById(C5961R.C5963id.ysf_iv_goods_img);
                this.f19615b = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_name);
                this.f19616c = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_sku);
                this.f19617d = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_price);
                this.f19618e = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_count);
                this.f19619f = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_state);
                this.f19620g = view.findViewById(C5961R.C5963id.ysf_v_order_list_goods_divider);
            }

            /* renamed from: a */
            public final void mo29499a(C6098a aVar, boolean z, boolean z2) {
                int a = C5412d.m22146a(60.0f);
                C5426a.m22179a(aVar.mo29017e(), this.f19614a, a, a);
                this.f19615b.setText(aVar.mo29018f());
                this.f19616c.setText(aVar.mo29021i());
                this.f19617d.setText(aVar.mo29019g());
                this.f19618e.setText(aVar.mo29020h());
                this.f19619f.setText(aVar.mo29016d());
                this.f19620g.setVisibility(z ? 8 : 0);
                int a2 = z2 ? 0 : C5412d.m22146a(10.0f);
                this.f19620g.setPadding(a2, 0, a2, 0);
            }
        }

        /* renamed from: com.qiyukf.unicorn.ui.b.a.o$a$b */
        private static class C6290b {
            /* renamed from: a */
            private View f19621a;
            /* renamed from: b */
            private View f19622b;
            /* renamed from: c */
            private TextView f19623c;
            /* renamed from: d */
            private TextView f19624d;

            public C6290b(View view) {
                this.f19621a = view.findViewById(C5961R.C5963id.ysf_order_list_order_header_content);
                this.f19622b = view.findViewById(C5961R.C5963id.ysf_order_list_header_divider);
                this.f19623c = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_order_shop_name);
                this.f19624d = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_order_state);
            }

            /* renamed from: a */
            public final void mo29500a(C6097b bVar, boolean z) {
                this.f19623c.setText(bVar.mo29010a());
                this.f19624d.setText(bVar.mo29011b());
                int i = 0;
                this.f19621a.setPadding(0, z ? 0 : C5412d.m22146a(10.0f), 0, 0);
                View view = this.f19622b;
                if (z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }

        private C6288a() {
            this.f19613a = new ArrayList();
        }

        /* synthetic */ C6288a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo29490a(List<C6097b> list) {
            this.f19613a.clear();
            mo29491b(list);
        }

        /* renamed from: b */
        public final void mo29491b(List<C6097b> list) {
            for (int i = 0; i < list.size(); i++) {
                C6097b bVar = (C6097b) list.get(i);
                this.f19613a.add(bVar);
                this.f19613a.addAll(bVar.mo29012c());
            }
        }

        public final int getCount() {
            return this.f19613a.size();
        }

        public final Object getItem(int i) {
            return this.f19613a.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return this.f19613a.get(i) instanceof C6097b ? 0 : 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C6290b bVar;
            C6289a aVar;
            int itemViewType = getItemViewType(i);
            boolean z = false;
            if (itemViewType == 0) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_view_holder_order_list_order_header, null);
                    bVar = new C6290b(view);
                    view.setTag(bVar);
                } else {
                    bVar = (C6290b) view.getTag();
                }
                C6097b bVar2 = (C6097b) this.f19613a.get(i);
                if (i == 0) {
                    z = true;
                }
                bVar.mo29500a(bVar2, z);
            } else if (itemViewType == 1) {
                if (view == null) {
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(C5961R.C5964layout.ysf_view_holder_order_list_goods, null);
                    aVar = new C6289a(view);
                    view.setTag(aVar);
                } else {
                    aVar = (C6289a) view.getTag();
                }
                boolean z2 = i < this.f19613a.size() - 1 && (this.f19613a.get(i + 1) instanceof C6097b);
                C6098a aVar2 = (C6098a) this.f19613a.get(i);
                if (i == this.f19613a.size() - 1) {
                    z = true;
                }
                aVar.mo29499a(aVar2, z, z2);
            }
            return view;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final boolean isEnabled(int i) {
            return this.f19613a.get(i) instanceof C6098a;
        }
    }

    /* renamed from: a */
    private void m24802a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f19610o, z);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        C6095k kVar = (C6095k) this.message.getAttachment();
        this.f19596a.setText(kVar.mo29004c());
        this.f19600e.mo29490a(kVar.mo29005d());
        this.f19597b.setAdapter(this.f19600e);
        this.f19597b.setOnItemClickListener(this);
        if (kVar.mo29006e() == null || kVar.mo29005d().size() < 3) {
            this.f19598c.setVisibility(8);
            return;
        }
        this.f19598c.setVisibility(0);
        this.f19599d.setText(kVar.mo29006e().mo29007a());
        this.f19599d.setOnClickListener(this);
    }

    /* renamed from: d */
    public final void mo29453d() {
        if (C6029d.m24047g().mo29295c(this.message.getSessionId()) == 0) {
            this.f19604i.mo29608a(1);
            C5415g.m22161a(C5961R.string.ysf_bot_load_more_disabled);
            return;
        }
        C6108c cVar = new C6108c();
        cVar.mo29049a(this.f19607l);
        cVar.mo29050b(this.f19608m);
        C6185c.m24532a(cVar, this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200) {
                    C6285o.this.f19609n = true;
                    return;
                }
                C6285o.this.f19609n = false;
                C6285o.this.f19604i.mo29608a(1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_bot_list;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19596a = (TextView) findViewById(C5961R.C5963id.ysf_tv_bot_list_title);
        this.f19597b = (ListView) findViewById(C5961R.C5963id.ysf_lv_bot_list);
        this.f19598c = findViewById(C5961R.C5963id.ysf_bot_footer_layout);
        this.f19599d = (TextView) findViewById(C5961R.C5963id.ysf_bot_footer_text);
        this.f19600e = new C6288a(0);
    }

    public void onClick(View view) {
        if (view == this.f19599d) {
            if (getAdapter().mo27734d().mo27723a()) {
                this.f19601f = new PopupWindow(this.context);
                this.f19601f.setWidth(-1);
                this.f19601f.setHeight((int) (((double) C5412d.m22148b()) * 0.8d));
                this.f19601f.setContentView(LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_popup_window_bot_list, null));
                this.f19601f.setBackgroundDrawable(new ColorDrawable(0));
                this.f19601f.setOutsideTouchable(false);
                this.f19601f.setFocusable(true);
                this.f19601f.setOnDismissListener(this);
                this.f19601f.setAnimationStyle(C5961R.style.ysf_dialog_window_animation_style);
                this.f19601f.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
                C6228j.m24667a(((Activity) this.context).getWindow(), 0.3f);
                this.f19602g = this.f19601f.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_placeholder);
                TextView textView = (TextView) this.f19601f.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_title);
                this.f19603h = this.f19601f.getContentView().findViewById(C5961R.C5963id.ysf_bot_list_close);
                this.f19604i = (PullToRefreshLayout) this.f19601f.getContentView().findViewById(C5961R.C5963id.ysf_ptr_layout_bot_list);
                this.f19605j = (PullableListView) this.f19601f.getContentView().findViewById(C5961R.C5963id.ysf_lv_bot_list);
                textView.setText(C5961R.string.ysf_bot_order_list_title);
                this.f19602g.setOnClickListener(this);
                this.f19603h.setOnClickListener(this);
                this.f19605j.setOnItemClickListener(this);
                C6095k kVar = (C6095k) this.message.getAttachment();
                this.f19607l = kVar.mo29006e().mo29008b();
                this.f19608m = kVar.mo29006e().mo29009c();
                if (this.f19606k == null) {
                    this.f19606k = new C6288a(0);
                }
                this.f19606k = this.f19606k;
                this.f19606k.mo29490a(kVar.mo29005d());
                this.f19605j.setAdapter(this.f19606k);
                this.f19605j.mo29622a(true);
                this.f19604i.mo29609a((C6374a) this);
                m24802a(true);
                getAdapter().mo27734d().mo27724b();
            }
        } else if (view == this.f19603h || view == this.f19602g) {
            this.f19601f.dismiss();
        }
    }

    public void onDismiss() {
        C6228j.m24667a(((Activity) this.context).getWindow(), 1.0f);
        m24802a(false);
        this.f19609n = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C6098a aVar = (C6098a) adapterView.getAdapter().getItem(i);
        if (aVar.mo29022j() != null) {
            OnMessageItemClickListener onMessageItemClickListener = C6029d.m24045e().onMessageItemClickListener;
            if (onMessageItemClickListener != null) {
                onMessageItemClickListener.onURLClicked(this.context, aVar.mo29022j());
            }
        } else {
            C5971b bVar = new C5971b();
            bVar.fromJson(aVar.mo29013a());
            C5969b bVar2 = new C5969b();
            bVar2.mo28519a(aVar.mo29014b());
            bVar2.mo28521b(aVar.mo29015c());
            bVar2.mo28520a(bVar.mo28524c());
            bVar.mo28536a(bVar2);
            getAdapter().mo27734d().mo27727c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, bVar));
        }
        if (adapterView == this.f19605j) {
            this.f19601f.dismiss();
        }
    }
}
