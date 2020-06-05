package com.qiyukf.nim.uikit.session.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.p502e.C6043b;

/* renamed from: com.qiyukf.nim.uikit.session.helper.b */
public class C5556b extends ClickableSpan {
    /* renamed from: a */
    private Context f17904a;
    /* renamed from: b */
    private String f17905b;
    /* renamed from: c */
    private int f17906c = 0;
    /* renamed from: d */
    private String f17907d;

    public C5556b(Context context, String str) {
        this.f17904a = context;
        this.f17905b = str;
    }

    /* renamed from: a */
    public static void m22584a(Context context, String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getScheme())) {
                StringBuilder sb = new StringBuilder("http://");
                sb.append(str);
                parse = Uri.parse(sb.toString());
            }
            if (parse.getScheme().toLowerCase().equals("qiyu")) {
                if ("action.qiyukf.com".equals(parse.getHost().toLowerCase())) {
                    String queryParameter = parse.getQueryParameter("command");
                    if (!TextUtils.isEmpty(queryParameter) && queryParameter.equalsIgnoreCase("applyHumanStaff")) {
                        C6029d.m24047g().mo29289a(str2, true, (C6043b) null, 2);
                    }
                }
                return;
            }
            OnMessageItemClickListener onMessageItemClickListener = C6029d.m24045e().onMessageItemClickListener;
            if (onMessageItemClickListener != null) {
                onMessageItemClickListener.onURLClicked(context, parse.toString());
            } else {
                context.startActivity(new Intent("android.intent.action.VIEW", parse));
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("url:");
            sb2.append(str);
            C5264a.m21621b("onURLClick is error", sb2.toString(), e);
        }
    }

    /* renamed from: a */
    public final void mo27694a(String str) {
        this.f17907d = str;
    }

    public void onClick(View view) {
        m22584a(this.f17904a, this.f17905b, this.f17907d);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(true);
        int i = this.f17906c;
        if (i != 0) {
            textPaint.setColor(i);
        }
    }
}
