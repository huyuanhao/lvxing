package com.qiyukf.nim.uikit.session.module.input;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.nim.uikit.session.module.C5567a;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.OnBotEventListener;
import com.qiyukf.unicorn.api.QuickEntry;
import com.qiyukf.unicorn.api.QuickEntryListener;
import com.qiyukf.unicorn.p502e.C6047e;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6114a;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6145a;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.widget.BotActionItemView;
import com.tencent.android.tpush.common.MessageKey;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nim.uikit.session.module.input.f */
public final class C5617f {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public C5567a f18103a;
    /* renamed from: b */
    private LinearLayout f18104b;
    /* renamed from: c */
    private LinearLayout f18105c;

    public C5617f(C5567a aVar, LinearLayout linearLayout) {
        this.f18103a = aVar;
        this.f18104b = linearLayout;
    }

    /* renamed from: a */
    public final void mo27796a(List<? extends C6047e> list) {
        if (list == null || list.isEmpty()) {
            LinearLayout linearLayout = this.f18105c;
            if (linearLayout != null && linearLayout.getVisibility() != 8) {
                this.f18105c.setVisibility(8);
                return;
            }
            return;
        }
        int i = 0;
        if (this.f18105c == null) {
            this.f18105c = (LinearLayout) LayoutInflater.from(this.f18103a.f17920a).inflate(C5961R.C5964layout.ysf_message_quick_entry_layout, this.f18104b, false);
            this.f18104b.addView(this.f18105c, 0);
        }
        this.f18105c.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) this.f18105c.findViewById(C5961R.C5963id.ysf_message_quick_entry_container);
        linearLayout2.removeAllViews();
        while (i < list.size()) {
            final C6047e eVar = (C6047e) list.get(i);
            BotActionItemView botActionItemView = new BotActionItemView(this.f18103a.f17920a);
            botActionItemView.mo29551a(eVar);
            int i2 = i + 1;
            botActionItemView.mo29553a(Long.valueOf((long) ((i2 * 100) << 1)));
            botActionItemView.mo29552a(Boolean.valueOf(true));
            botActionItemView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    C6047e eVar = eVar;
                    if (eVar instanceof C6114a) {
                        C6114a aVar = (C6114a) eVar;
                        if (aVar.mo29055a() == 1) {
                            if (C5617f.this.f18103a.f17924e.isAllowSendMessage(true)) {
                                C5617f.this.f18103a.f17924e.sendMessage(MessageBuilder.createTextMessage(C5617f.this.f18103a.f17922c, C5617f.this.f18103a.f17923d, aVar.mo29056b()), false);
                            }
                            JSONObject jSONObject = new JSONObject();
                            C5366b.m22032a(jSONObject, MessageKey.MSG_CONTENT, aVar.getName());
                            String str = C5617f.this.f18103a.f17922c;
                            String str2 = "ai_bot_direct_button_click";
                            try {
                                C6145a aVar2 = new C6145a();
                                aVar2.mo29177a(str2);
                                aVar2.mo29178a(jSONObject);
                                aVar2.mo29176a(Long.valueOf(C6029d.m24047g().mo29295c(str)));
                                C6185c.m24532a(aVar2, str, false);
                            } catch (Exception e) {
                                C5264a.m21617a("埋点失败，失败原因", e.toString());
                            }
                        } else {
                            if (aVar.mo29055a() == 2) {
                                OnBotEventListener onBotEventListener = C6029d.m24045e().onBotEventListener;
                                if (onBotEventListener != null) {
                                    onBotEventListener.onUrlClick(C5617f.this.f18103a.f17920a, aVar.mo29057c());
                                }
                            }
                        }
                    } else {
                        if (eVar instanceof QuickEntry) {
                            QuickEntry quickEntry = (QuickEntry) eVar;
                            QuickEntryListener quickEntryListener = C6029d.m24045e().quickEntryListener;
                            if (quickEntryListener != null) {
                                quickEntryListener.onClick(C5617f.this.f18103a.f17920a, C5617f.this.f18103a.f17922c, quickEntry);
                            }
                        }
                    }
                }
            });
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            float f = 10.0f;
            layoutParams.leftMargin = C5412d.m22146a(i == 0 ? 10.0f : 5.0f);
            if (i != list.size() - 1) {
                f = 0.0f;
            }
            layoutParams.rightMargin = C5412d.m22146a(f);
            botActionItemView.setLayoutParams(layoutParams);
            linearLayout2.addView(botActionItemView);
            i = i2;
        }
    }
}
