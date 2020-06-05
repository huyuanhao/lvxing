package com.qiyukf.unicorn.p517ui.p519b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.p502e.C6050h;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6131l;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6157m;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6158n;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6159o;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.widget.p521a.C6356d;
import com.qiyukf.unicorn.widget.p521a.C6356d.C6359a;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.b.e */
public class C6305e extends C6248a<C6050h> {
    /* renamed from: b */
    private View f19674b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public View f19675c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public View f19676d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public TextView f19677e;

    /* renamed from: a */
    private void m24847a(int i) {
        final C6131l lVar = (C6131l) this.message.getAttachment();
        if (i != 3 || !lVar.mo29135h()) {
            this.f19677e.setVisibility(8);
            return;
        }
        this.f19677e.setVisibility(0);
        this.f19677e.setText(lVar.mo29133f());
        TextView textView = this.f19677e;
        textView.setHint(textView.length() == 0 ? lVar.mo29128b(this.context) : null);
        this.f19677e.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (C6305e.this.m24849a(lVar)) {
                    C6305e.m24853d(C6305e.this);
                } else {
                    C5415g.m22161a(C5961R.string.ysf_robot_evaluate_disable);
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m24848a(C6305e eVar, final int i) {
        boolean z = true;
        eVar.f19675c.setSelected(i == 2);
        View view = eVar.f19676d;
        if (i != 3) {
            z = false;
        }
        view.setSelected(z);
        final C6131l lVar = (C6131l) eVar.message.getAttachment();
        C6157m mVar = new C6157m();
        mVar.mo29220a(eVar.message.getUuid());
        mVar.mo29219a(i);
        C6185c.m24532a(mVar, eVar.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200) {
                    lVar.mo29125a(i);
                    if (i == 2) {
                        lVar.mo29127a((String) null);
                    }
                    ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(C6305e.this.message, false);
                    if (i != 2 && C6305e.this.m24849a(lVar)) {
                        if (lVar.mo29135h()) {
                            C6305e.m24853d(C6305e.this);
                            return;
                        }
                        C6158n nVar = new C6158n();
                        nVar.mo29221a(C6305e.this.message.getUuid());
                        nVar.mo29222b("");
                        C6185c.m24532a(nVar, C6305e.this.message.getSessionId(), false);
                    }
                } else {
                    C5415g.m22161a(C5961R.string.ysf_network_error);
                }
            }
        });
        eVar.m24847a(i);
        if (i == 3) {
            eVar.getAdapter().mo27734d().mo27726c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24849a(C6131l lVar) {
        if (lVar.mo29134g() == 0) {
            return false;
        }
        String sessionId = this.message.getSessionId();
        return lVar.mo29134g() == C6029d.m24047g().mo29295c(sessionId) || lVar.mo29134g() == C6029d.m24047g().mo29303g(sessionId);
    }

    /* renamed from: d */
    static /* synthetic */ void m24853d(C6305e eVar) {
        final C6131l lVar = (C6131l) eVar.message.getAttachment();
        new C6356d(eVar.context).mo29576a(lVar.mo29133f(), lVar.mo29128b(eVar.context)).mo29575a((C6359a) new C6359a() {
            /* renamed from: a */
            public final void mo29512a() {
                if (C6305e.this.m24849a(lVar)) {
                    C6158n nVar = new C6158n();
                    nVar.mo29221a(C6305e.this.message.getUuid());
                    nVar.mo29222b("");
                    C6185c.m24532a(nVar, C6305e.this.message.getSessionId(), false);
                    return;
                }
                C5415g.m22161a(C5961R.string.ysf_robot_evaluate_disable);
            }

            /* renamed from: a */
            public final void mo29513a(final String str) {
                if (C6305e.this.m24849a(lVar)) {
                    C6305e.this.f19677e.setText(str);
                    C6305e.this.f19677e.setHint(C6305e.this.f19677e.length() == 0 ? lVar.mo29128b(C6305e.this.context) : null);
                    C6158n nVar = new C6158n();
                    nVar.mo29221a(C6305e.this.message.getUuid());
                    nVar.mo29222b(str);
                    C6185c.m24532a(nVar, C6305e.this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
                        public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                            if (i == 200) {
                                C5415g.m22163a("感谢您的反馈");
                                lVar.mo29127a(str);
                                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(C6305e.this.message, true);
                                return;
                            }
                            C5415g.m22161a(C5961R.string.ysf_network_error);
                        }
                    });
                    return;
                }
                C5415g.m22161a(C5961R.string.ysf_robot_evaluate_disable);
            }
        }).show();
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29436a(TextView textView, Object obj) {
        textView.setText(((C6050h) obj).f18928b);
    }

    /* access modifiers changed from: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ void mo29437a(Object obj) {
        IMMessage createTextMessage;
        C6050h hVar = (C6050h) obj;
        if (C6029d.m24047g().mo29301f(this.message.getSessionId()) == 1) {
            C6159o oVar = new C6159o();
            oVar.mo29224a(hVar.f18927a);
            oVar.mo29226b(hVar.f18928b);
            oVar.mo29225a(this.message.getUuid());
            createTextMessage = MessageBuilder.createCustomMessage(this.message.getSessionId(), this.message.getSessionType(), oVar);
        } else {
            createTextMessage = MessageBuilder.createTextMessage(this.message.getSessionId(), this.message.getSessionType(), hVar.f18928b);
            createTextMessage.setStatus(MsgStatusEnum.success);
        }
        getAdapter().mo27734d().mo27727c(createTextMessage);
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: b */
    public final String mo29439b() {
        C6131l lVar = (C6131l) this.message.getAttachment();
        List d = lVar.mo29131d();
        if (TextUtils.isEmpty(lVar.mo29124a()) && d != null && d.size() == 1 && !TextUtils.isEmpty(((C6050h) d.get(0)).f18929c)) {
            return ((C6050h) d.get(0)).f18929c;
        }
        if (!TextUtils.isEmpty(lVar.mo29124a())) {
            return lVar.mo29124a();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void bindContentView() {
        super.bindContentView();
        final C6131l lVar = (C6131l) this.message.getAttachment();
        if (lVar.mo29132e() <= 0 || !m24849a(lVar)) {
            this.f19674b.setVisibility(8);
            return;
        }
        boolean z = false;
        this.f19674b.setVisibility(0);
        this.f19675c.setSelected(lVar.mo29132e() == 2);
        View view = this.f19676d;
        if (lVar.mo29132e() == 3) {
            z = true;
        }
        view.setSelected(z);
        m24847a(lVar.mo29132e());
        this.f19675c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!C6305e.this.f19675c.isSelected()) {
                    if (C6305e.this.m24849a(lVar)) {
                        C6305e.m24848a(C6305e.this, 2);
                        return;
                    }
                    C5415g.m22161a(C5961R.string.ysf_robot_evaluate_disable);
                }
            }
        });
        this.f19676d.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!C6305e.this.f19676d.isSelected()) {
                    if (C6305e.this.m24849a(lVar)) {
                        C6305e.m24848a(C6305e.this, 3);
                        return;
                    }
                    C5415g.m22161a(C5961R.string.ysf_robot_evaluate_disable);
                }
            }
        });
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: c */
    public final String mo29440c() {
        return ((C6131l) this.message.getAttachment()).mo29130c();
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: d */
    public final List<C6050h> mo29441d() {
        C6131l lVar = (C6131l) this.message.getAttachment();
        List<C6050h> d = lVar.mo29131d();
        if (!TextUtils.isEmpty(lVar.mo29124a()) || d == null || d.size() != 1 || TextUtils.isEmpty(((C6050h) d.get(0)).f18929c)) {
            return d;
        }
        return null;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: e */
    public final boolean mo29442e() {
        this.message.getAttachment();
        return true;
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: f */
    public final boolean mo29443f() {
        return ((C6131l) this.message.getAttachment()).mo29129b();
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.f19674b = LayoutInflater.from(this.context).inflate(C5961R.C5964layout.ysf_message_item_robot_evaluation, this.f19473a, false);
        this.f19675c = this.f19674b.findViewById(C5961R.C5963id.ysf_robot_evaluate_useful);
        this.f19676d = this.f19674b.findViewById(C5961R.C5963id.ysf_robot_evaluate_useless);
        this.f19677e = (TextView) this.f19674b.findViewById(C5961R.C5963id.ysf_robot_evaluation_content);
        this.f19473a.addView(this.f19674b);
    }
}
