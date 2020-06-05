package com.qiyukf.unicorn.p517ui.p519b.p520a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5971b;

/* renamed from: com.qiyukf.unicorn.ui.b.a.j */
public class C6273j extends C6257e {
    /* renamed from: a */
    private C6275a f19558a;
    /* renamed from: b */
    private View f19559b;
    /* renamed from: c */
    private TextView f19560c;

    /* renamed from: com.qiyukf.unicorn.ui.b.a.j$a */
    private static class C6275a {
        /* renamed from: a */
        private ImageView f19563a;
        /* renamed from: b */
        private TextView f19564b;
        /* renamed from: c */
        private TextView f19565c;
        /* renamed from: d */
        private TextView f19566d;
        /* renamed from: e */
        private TextView f19567e;
        /* renamed from: f */
        private TextView f19568f;

        public C6275a(View view) {
            this.f19563a = (ImageView) view.findViewById(C5961R.C5963id.ysf_iv_goods_img);
            this.f19564b = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_name);
            this.f19565c = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_sku);
            this.f19566d = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_price);
            this.f19567e = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_count);
            this.f19568f = (TextView) view.findViewById(C5961R.C5963id.ysf_tv_goods_state);
        }

        /* renamed from: a */
        public final void mo29480a(C5971b bVar) {
            int a = C5412d.m22146a(60.0f);
            C5426a.m22179a(bVar.mo28526e(), this.f19563a, a, a);
            this.f19564b.setText(bVar.mo28527f());
            this.f19565c.setText(bVar.mo28530i());
            this.f19566d.setText(bVar.mo28528g());
            this.f19567e.setText(bVar.mo28529h());
            this.f19568f.setText(bVar.mo28525d());
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29445a() {
        final C5971b bVar = (C5971b) this.message.getAttachment();
        this.f19558a.mo29480a(bVar);
        if (bVar.mo28531j()) {
            this.f19559b.setVisibility(0);
            this.f19560c.setVisibility(0);
            this.f19560c.setText(TextUtils.isEmpty(bVar.mo28533l()) ? "重新选择" : bVar.mo28533l());
            this.f19560c.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    bVar.mo28534m().onClick(C6273j.this.context, bVar.mo28532k());
                }
            });
            return;
        }
        this.f19559b.setVisibility(8);
        this.f19560c.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_goods;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19559b = findViewById(C5961R.C5963id.view_ysf_item_message_goods_line);
        this.f19560c = (TextView) findViewById(C5961R.C5963id.tv_ysf_item_message_goods);
        this.f19558a = new C6275a(findViewById(C5961R.C5963id.ysf_goods_content));
    }
}
