package com.qiyukf.unicorn.p517ui.p519b;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.p514h.C6185c;

/* renamed from: com.qiyukf.unicorn.ui.b.c */
public class C6298c extends C5622b {
    /* renamed from: a */
    private View f19644a;
    /* renamed from: b */
    private TextView f19645b;
    /* renamed from: c */
    private ImageView f19646c;
    /* renamed from: d */
    private TextView f19647d;
    /* renamed from: e */
    private TextView f19648e;
    /* renamed from: f */
    private TextView f19649f;
    /* renamed from: g */
    private TextView f19650g;
    /* renamed from: h */
    private LinearLayout f19651h;
    /* renamed from: i */
    private TextView f19652i;
    /* renamed from: j */
    private TextView f19653j;
    /* renamed from: k */
    private TextView f19654k;
    /* renamed from: l */
    private TextView f19655l;
    /* renamed from: m */
    private TextView f19656m;
    /* renamed from: n */
    private TextView f19657n;
    /* renamed from: o */
    private LinearLayout f19658o;
    /* renamed from: p */
    private View f19659p;
    /* renamed from: q */
    private View f19660q;
    /* renamed from: r */
    private ImageView f19661r;
    /* renamed from: s */
    private View f19662s;
    /* renamed from: t */
    private TextView f19663t;
    /* renamed from: u */
    private LinearLayout f19664u;
    /* renamed from: v */
    private View f19665v;
    /* renamed from: w */
    private TextView f19666w;
    /* access modifiers changed from: private */
    /* renamed from: x */
    public ProductAttachment f19667x;

    /* access modifiers changed from: protected */
    public void bindContentView() {
        this.f19667x = (ProductAttachment) this.message.getAttachment();
        this.f19644a.setBackgroundResource(isReceivedMessage() ? C5961R.C5962drawable.ysf_message_left_bg_product_selector : C5961R.C5962drawable.ysf_message_right_bg_product_selector);
        String str = "";
        if (this.f19667x.getTemplate() != null) {
            if ("pictureLink".equals(this.f19667x.getTemplate())) {
                LayoutParams layoutParams = (LayoutParams) this.f19644a.getLayoutParams();
                layoutParams.width = -2;
                this.f19644a.setLayoutParams(layoutParams);
                this.f19661r.setVisibility(0);
                this.f19664u.setVisibility(8);
                this.f19654k.setVisibility(8);
                this.f19659p.setVisibility(8);
                this.f19655l.setVisibility(8);
                this.f19660q.setVisibility(8);
                this.f19656m.setVisibility(8);
                this.f19661r.setImageResource(C5961R.C5962drawable.ysf_image_placeholder_loading);
                String picture = this.f19667x.getPicture();
                if (!TextUtils.isEmpty(picture)) {
                    str = picture.trim();
                }
                ImageView imageView = this.f19661r;
                C5426a.m22179a(str, imageView, imageView.getWidth(), this.f19661r.getHeight());
                if (!TextUtils.isEmpty(this.f19667x.getUrl())) {
                    this.f19661r.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            C6029d.m24045e().onMessageItemClickListener.onURLClicked(C6298c.this.context, C6298c.this.f19667x.getUrl());
                        }
                    });
                }
                if (this.f19667x.getSendByUser() == 1 || this.message.getDirect() != MsgDirectionEnum.Out || C6029d.m24047g().mo29301f(this.message.getSessionId()) == 1) {
                    this.f19663t.setVisibility(8);
                    this.f19662s.setVisibility(8);
                } else {
                    this.f19663t.setText(TextUtils.isEmpty(this.f19667x.getActionText()) ? "发送链接" : this.f19667x.getActionText());
                    this.f19663t.setTextColor(this.f19667x.getActionTextColor() == 0 ? -10578718 : this.f19667x.getActionTextColor());
                    this.f19662s.setVisibility(0);
                    this.f19663t.setVisibility(0);
                    this.f19663t.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            int i;
                            if (C6029d.m24047g().mo29301f(C6298c.this.message.getSessionId()) == 1) {
                                i = C5961R.string.ysf_send_card_robot;
                            } else if (!C6185c.m24536b()) {
                                i = C5961R.string.ysf_send_card_error;
                            } else {
                                ProductAttachment clone = C6298c.this.f19667x.clone();
                                if (clone != null) {
                                    clone.setSendByUser(0);
                                    clone.setActionText("");
                                    C6185c.m24535b(MessageBuilder.createCustomMessage(C6298c.this.message.getSessionId(), SessionTypeEnum.Ysf, clone));
                                }
                                return;
                            }
                            C5415g.m22165b(i);
                        }
                    });
                }
                if (this.message.getDirect() == MsgDirectionEnum.Out || !this.f19667x.isOpenReselect()) {
                    this.f19666w.setVisibility(8);
                    this.f19665v.setVisibility(8);
                }
                this.f19666w.setVisibility(0);
                this.f19665v.setVisibility(0);
                this.f19666w.setText(TextUtils.isEmpty(this.f19667x.getReselectText()) ? "重新选择" : this.f19667x.getReselectText());
                this.f19666w.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        C6298c.this.f19667x.getProductReslectOnclickListener().onClick(C6298c.this.context, C6298c.this.f19667x.getHandlerTag());
                    }
                });
                return;
            }
        }
        LayoutParams layoutParams2 = (LayoutParams) this.f19644a.getLayoutParams();
        layoutParams2.width = (int) ((this.context.getResources().getDisplayMetrics().density * 255.0f) + 0.5f);
        this.f19644a.setLayoutParams(layoutParams2);
        this.f19661r.setVisibility(8);
        this.f19664u.setVisibility(0);
        this.f19645b.setText(this.f19667x.getTitle());
        this.f19647d.setText(this.f19667x.getDesc());
        this.f19646c.setImageResource(C5961R.C5962drawable.ysf_image_placeholder_loading);
        String picture2 = this.f19667x.getPicture();
        if (!TextUtils.isEmpty(picture2)) {
            str = picture2.trim();
        }
        ImageView imageView2 = this.f19646c;
        C5426a.m22179a(str, imageView2, imageView2.getWidth(), this.f19646c.getHeight());
        if (!TextUtils.isEmpty(this.f19667x.getOrderSku())) {
            this.f19657n.setVisibility(0);
            this.f19657n.setText(this.f19667x.getOrderSku());
        } else {
            this.f19657n.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getNote())) {
            this.f19648e.setText(this.f19667x.getNote());
            this.f19648e.setVisibility(0);
        } else {
            this.f19648e.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getOrderTime())) {
            this.f19655l.setVisibility(0);
            TextView textView = this.f19655l;
            StringBuilder sb = new StringBuilder("下单时间：");
            sb.append(this.f19667x.getOrderTime());
            textView.setText(sb.toString());
        } else {
            this.f19655l.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getOrderID())) {
            this.f19659p.setVisibility(0);
            this.f19654k.setVisibility(0);
            TextView textView2 = this.f19654k;
            StringBuilder sb2 = new StringBuilder("订单编号：");
            sb2.append(this.f19667x.getOrderID());
            textView2.setText(sb2.toString());
        } else {
            this.f19654k.setVisibility(8);
            this.f19659p.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getActivity())) {
            this.f19656m.setVisibility(0);
            this.f19660q.setVisibility(0);
            this.f19656m.setText(this.f19667x.getActivity());
            if (!TextUtils.isEmpty(this.f19667x.getActivityHref())) {
                this.f19656m.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        C6029d.m24045e().onMessageItemClickListener.onURLClicked(C6298c.this.context, C6298c.this.f19667x.getActivityHref());
                    }
                });
            }
        } else {
            this.f19656m.setVisibility(8);
            this.f19660q.setVisibility(8);
        }
        this.f19651h.setVisibility(0);
        if (!TextUtils.isEmpty(this.f19667x.getPrice())) {
            this.f19649f.setVisibility(0);
            this.f19649f.setText(this.f19667x.getPrice());
        } else {
            this.f19649f.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getOrderStatus())) {
            this.f19650g.setVisibility(0);
            this.f19650g.setText(this.f19667x.getOrderStatus());
        } else {
            this.f19650g.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getPayMoney())) {
            this.f19652i.setVisibility(0);
            this.f19652i.setText(this.f19667x.getPayMoney());
        } else {
            this.f19652i.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f19667x.getOrderCount())) {
            this.f19653j.setVisibility(0);
            this.f19653j.setText(this.f19667x.getOrderCount());
        } else {
            this.f19653j.setVisibility(8);
        }
        if (this.f19667x.getSendByUser() == 1) {
        }
        this.f19663t.setVisibility(8);
        this.f19662s.setVisibility(8);
        if (this.message.getDirect() == MsgDirectionEnum.Out) {
        }
        this.f19666w.setVisibility(8);
        this.f19665v.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_product;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f19644a = findViewById(C5961R.C5963id.ysf_product_content);
        this.f19645b = (TextView) findViewById(C5961R.C5963id.ysf_product_title);
        this.f19646c = (ImageView) findViewById(C5961R.C5963id.ysf_product_image);
        this.f19647d = (TextView) findViewById(C5961R.C5963id.ysf_product_description);
        this.f19648e = (TextView) findViewById(C5961R.C5963id.ysf_product_note);
        this.f19657n = (TextView) findViewById(C5961R.C5963id.ysf_product_sku);
        this.f19649f = (TextView) findViewById(C5961R.C5963id.ysf_product_price);
        this.f19650g = (TextView) findViewById(C5961R.C5963id.ysf_product_order_status);
        this.f19651h = (LinearLayout) findViewById(C5961R.C5963id.ysf_ll_product_price_and_count_parent);
        this.f19652i = (TextView) findViewById(C5961R.C5963id.ysf_tv_product_pay_money);
        this.f19653j = (TextView) findViewById(C5961R.C5963id.ysf_tv_product_count);
        this.f19654k = (TextView) findViewById(C5961R.C5963id.ysf_tv_product_number);
        this.f19655l = (TextView) findViewById(C5961R.C5963id.ysf_tv_product_time);
        this.f19656m = (TextView) findViewById(C5961R.C5963id.ysf_tv_product_activity);
        this.f19658o = (LinearLayout) findViewById(C5961R.C5963id.ysf_product_tags);
        this.f19659p = findViewById(C5961R.C5963id.ysf_view_product_order_line);
        this.f19660q = findViewById(C5961R.C5963id.view_ysf_message_item_activity_line);
        this.f19661r = (ImageView) findViewById(C5961R.C5963id.iv_ysf_message_product_template);
        this.f19662s = findViewById(C5961R.C5963id.view_ysf_message_item_send_line);
        this.f19663t = (TextView) findViewById(C5961R.C5963id.tv_ysf_message_product_send);
        this.f19664u = (LinearLayout) findViewById(C5961R.C5963id.ll_ysf_message_product_top_parent);
        this.f19665v = findViewById(C5961R.C5963id.view_ysf_message_item_reselect_line);
        this.f19666w = (TextView) findViewById(C5961R.C5963id.tv_ysf_message_product_reselect);
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onItemClick() {
        if (this.f19667x.getUrl() != null) {
            String trim = this.f19667x.getUrl().trim();
            Uri parse = Uri.parse(trim);
            if (TextUtils.isEmpty(parse.getScheme())) {
                StringBuilder sb = new StringBuilder("http://");
                sb.append(trim);
                trim = sb.toString();
                parse = Uri.parse(trim);
            }
            try {
                OnMessageItemClickListener onMessageItemClickListener = C6029d.m24045e().onMessageItemClickListener;
                if (onMessageItemClickListener != null) {
                    onMessageItemClickListener.onURLClicked(this.context, trim);
                    return;
                }
                this.context.startActivity(new Intent("android.intent.action.VIEW", parse));
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
