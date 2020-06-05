package com.qiyukf.unicorn.p517ui.p519b;

import android.widget.TextView;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.p502e.C6043b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6137r;
import com.qiyukf.unicorn.widget.p521a.C6351a;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.h */
public class C6314h extends C6248a<C6043b> {
    /* access modifiers changed from: private|static */
    /* renamed from: b */
    public static void m24874b(IMMessage iMMessage, C6043b bVar) {
        C6137r rVar = (C6137r) iMMessage.getAttachment();
        if (rVar.mo29157d()) {
            rVar.mo29158e();
            ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, true);
            C6029d.m24047g().mo29289a(iMMessage.getSessionId(), true, bVar, bVar == null ? 0 : bVar.f18898a);
        }
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29436a(TextView textView, Object obj) {
        textView.setText(((C6043b) obj).f18900c);
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29437a(Object obj) {
        m24874b(this.message, (C6043b) obj);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final boolean mo29438a() {
        return ((C6137r) this.message.getAttachment()).mo29157d();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final String mo29439b() {
        return ((C6137r) this.message.getAttachment()).mo29154a();
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        super.bindContentView();
        final IMMessage iMMessage = this.message;
        YSFOptions e = C6029d.m24045e();
        if (e.categoryDialogStyle > 0) {
            C6137r rVar = (C6137r) iMMessage.getAttachment();
            if (rVar.mo29157d() && !rVar.mo29160g()) {
                final List c = rVar.mo29156c();
                String[] strArr = new String[c.size()];
                for (int i = 0; i < c.size(); i++) {
                    strArr[i] = ((C6043b) c.get(i)).f18900c;
                }
                C6351a aVar = new C6351a(this.context, e.categoryDialogStyle == 1 ? 17 : 80);
                aVar.setTitle(rVar.mo29154a());
                aVar.mo29563a(strArr);
                aVar.mo29562a((C6365a) new C6365a() {
                    /* renamed from: a */
                    public final void mo27603a(int i) {
                        C6314h.m24874b(iMMessage, (C6043b) c.get(i));
                    }
                });
                aVar.show();
                rVar.mo29161h();
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, true);
            }
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final String mo29440c() {
        return null;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final List<C6043b> mo29441d() {
        return ((C6137r) this.message.getAttachment()).mo29156c();
    }
}
