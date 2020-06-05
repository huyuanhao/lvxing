package com.qiyukf.nim.uikit.session.viewholder;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.C5543f;
import com.qiyukf.nim.uikit.session.helper.C5554a;
import com.qiyukf.nim.uikit.session.helper.C5556b;
import com.qiyukf.nim.uikit.session.helper.C5566e;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.p514h.C6185c;

/* renamed from: com.qiyukf.nim.uikit.session.viewholder.h */
public class C5635h extends C5622b {
    /* renamed from: a */
    protected TextView f18138a;
    /* renamed from: b */
    protected ImageView f18139b;
    /* renamed from: c */
    protected ImageView f18140c;
    /* renamed from: d */
    protected OnClickListener f18141d = new OnClickListener() {
        public final void onClick(View view) {
            C5556b.m22584a(C5635h.this.context, C5635h.this.f18145h, "");
        }
    };
    /* renamed from: e */
    private TextView f18142e;
    /* renamed from: f */
    private LinearLayout f18143f;
    /* renamed from: g */
    private TextView f18144g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public String f18145h;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo27827a() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundLeft <= 0) ? C5961R.C5962drawable.ysf_message_left_bg_selector : uICustomization.msgItemBackgroundLeft;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27828a(TextView textView) {
        SpannableString spannableString = C6185c.m24531a(this.message) == 2 ? C5543f.m22544a(this.context, this.message.getContent(), this.message.getSessionId()) : C5543f.m22547a(this.message.getContent()) ? C5543f.m22543a(this.context, (CharSequence) this.message.getContent(), this.f18138a) : C5543f.m22542a(this.context, this.message.getContent());
        textView.setText(C5566e.m22593a(this.context, (CharSequence) spannableString));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo27829b() {
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundRight <= 0) ? C5961R.C5962drawable.ysf_message_right_bg_selector : uICustomization.msgItemBackgroundRight;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f2  */
    public void bindContentView() {
        /*
        r3 = this;
        boolean r0 = r3.isReceivedMessage()
        if (r0 == 0) goto L_0x0023
        android.widget.LinearLayout r0 = r3.f18143f
        int r1 = r3.mo27827a()
        r0.setBackgroundResource(r1)
        android.widget.TextView r0 = r3.f18138a
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.UICustomization r1 = r1.uiCustomization
        if (r1 == 0) goto L_0x0020
        int r2 = r1.textMsgColorLeft
        if (r2 == 0) goto L_0x0020
        int r1 = r1.textMsgColorLeft
        goto L_0x003e
    L_0x0020:
        r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        goto L_0x003e
    L_0x0023:
        android.widget.LinearLayout r0 = r3.f18143f
        int r1 = r3.mo27829b()
        r0.setBackgroundResource(r1)
        android.widget.TextView r0 = r3.f18138a
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.UICustomization r1 = r1.uiCustomization
        if (r1 == 0) goto L_0x003d
        int r2 = r1.textMsgColorRight
        if (r2 == 0) goto L_0x003d
        int r1 = r1.textMsgColorRight
        goto L_0x003e
    L_0x003d:
        r1 = -1
    L_0x003e:
        r0.setTextColor(r1)
        android.widget.TextView r0 = r3.f18138a
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.UICustomization r1 = r1.uiCustomization
        if (r1 == 0) goto L_0x0065
        boolean r2 = r3.isReceivedMessage()
        if (r2 == 0) goto L_0x0058
        int r2 = r1.hyperLinkColorLeft
        if (r2 == 0) goto L_0x0058
        int r1 = r1.hyperLinkColorLeft
        goto L_0x007a
    L_0x0058:
        boolean r2 = r3.isReceivedMessage()
        if (r2 != 0) goto L_0x0065
        int r2 = r1.hyperLinkColorRight
        if (r2 == 0) goto L_0x0065
        int r1 = r1.hyperLinkColorRight
        goto L_0x007a
    L_0x0065:
        int r1 = r0.getCurrentTextColor()
        r2 = 16777215(0xffffff, float:2.3509886E-38)
        r2 = r2 & r1
        if (r2 == 0) goto L_0x0070
        goto L_0x007a
    L_0x0070:
        android.content.res.Resources r1 = r0.getResources()
        int r2 = com.qiyukf.unicorn.C5961R.color.ysf_text_link_color_blue
        int r1 = r1.getColor(r2)
    L_0x007a:
        r0.setLinkTextColor(r1)
        android.widget.TextView r0 = r3.f18138a
        r3.mo27828a(r0)
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r0 = r3.message
        org.json.JSONObject r0 = r0.getExtension()
        java.lang.String r1 = "action"
        org.json.JSONObject r0 = com.qiyukf.basesdk.p412c.C5366b.m22040f(r0, r1)
        if (r0 == 0) goto L_0x00f2
        android.widget.TextView r1 = r3.f18142e
        r2 = 0
        r1.setVisibility(r2)
        android.widget.TextView r1 = r3.f18144g
        r1.setVisibility(r2)
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.UICustomization r1 = r1.uiCustomization
        if (r1 == 0) goto L_0x00af
        int r2 = r1.msgItemBackgroundLeft
        if (r2 <= 0) goto L_0x00af
        android.widget.LinearLayout r2 = r3.f18143f
        int r1 = r1.msgItemBackgroundLeft
        r2.setBackgroundResource(r1)
        goto L_0x00bd
    L_0x00af:
        android.widget.TextView r1 = r3.f18138a
        r2 = 35
        r1.setPadding(r2, r2, r2, r2)
        android.widget.LinearLayout r1 = r3.f18143f
        int r2 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_message_left_bg_selector
        r1.setBackgroundResource(r2)
    L_0x00bd:
        java.lang.String r1 = "label"
        java.lang.String r2 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r0, r1)
        boolean r2 = android.text.TextUtils.isEmpty(r2)
        if (r2 != 0) goto L_0x00d3
        android.widget.TextView r2 = r3.f18142e
        java.lang.String r1 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r0, r1)
        r2.setText(r1)
        goto L_0x00da
    L_0x00d3:
        android.widget.TextView r1 = r3.f18142e
        java.lang.String r2 = "知道了"
        r1.setText(r2)
    L_0x00da:
        java.lang.String r1 = "url"
        java.lang.String r0 = com.qiyukf.basesdk.p412c.C5366b.m22039e(r0, r1)
        r3.f18145h = r0
        java.lang.String r0 = r3.f18145h
        boolean r0 = android.text.TextUtils.isEmpty(r0)
        if (r0 != 0) goto L_0x00f1
        android.widget.TextView r0 = r3.f18142e
        android.view.View$OnClickListener r1 = r3.f18141d
        r0.setOnClickListener(r1)
    L_0x00f1:
        return
    L_0x00f2:
        android.widget.TextView r0 = r3.f18142e
        r1 = 8
        r0.setVisibility(r1)
        android.widget.TextView r0 = r3.f18144g
        r0.setVisibility(r1)
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.viewholder.C5635h.bindContentView():void");
    }

    /* access modifiers changed from: protected */
    public int getContentResId() {
        return C5961R.C5964layout.ysf_message_item_text;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        this.f18138a = (TextView) findViewById(C5961R.C5963id.nim_message_item_text_body);
        this.f18142e = (TextView) findViewById(C5961R.C5963id.tv_nim_message_item_url_button);
        this.f18143f = (LinearLayout) findViewById(C5961R.C5963id.ll_nim_message_item_text_parent);
        this.f18144g = (TextView) findViewById(C5961R.C5963id.tv_nim_message_item_url_line);
        this.f18139b = (ImageView) findViewById(C5961R.C5963id.message_item_rich_gif);
        this.f18138a.setOnTouchListener(C5554a.m22582a());
        this.f18140c = (ImageView) findViewById(C5961R.C5963id.iv_message_item_rich_pic);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null && uICustomization.textMsgSize > 0.0f) {
            ((TextView) findViewById(C5961R.C5963id.nim_message_item_text_body)).setTextSize(uICustomization.textMsgSize);
        }
    }

    /* access modifiers changed from: protected */
    public int leftBackground() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int rightBackground() {
        return 0;
    }
}
