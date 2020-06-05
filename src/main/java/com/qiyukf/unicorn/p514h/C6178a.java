package com.qiyukf.unicorn.p514h;

import android.content.Context;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6115b;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6122d;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;
import com.qiyukf.unicorn.p514h.C6187d.C6195a;
import com.qiyukf.unicorn.p517ui.evaluate.C6317a;
import com.qiyukf.unicorn.p517ui.evaluate.C6317a.C6325a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.qiyukf.unicorn.h.a */
public final class C6178a {
    /* renamed from: a */
    private Fragment f19291a;
    /* renamed from: b */
    private String f19292b;
    /* renamed from: c */
    private Map<String, IMMessage> f19293c = new HashMap();
    /* renamed from: d */
    private LongSparseArray<RequestCallbackWrapper<Void>> f19294d = new LongSparseArray<>();
    /* renamed from: e */
    private C6317a f19295e;

    /* renamed from: a */
    public static C6115b m24514a(String str) {
        C6115b k = C6014b.m23966k(str);
        return k == null ? C6115b.m24278a() : k;
    }

    /* renamed from: a */
    private void m24515a(long j, RequestCallbackWrapper<Void> requestCallbackWrapper) {
        this.f19294d.put(j, requestCallbackWrapper);
    }

    /* renamed from: a */
    public static void m24516a(IMMessage iMMessage) {
        String sessionId = iMMessage.getSessionId();
        int i = C6014b.m23962i(sessionId);
        if (i != -1 && i != 4) {
            MsgDirectionEnum direct = iMMessage.getDirect();
            if ((direct == MsgDirectionEnum.Out && i % 2 == 0) || (direct == MsgDirectionEnum.In && i % 2 == 1)) {
                C6014b.m23927a(sessionId, i + 1);
            }
        }
    }

    /* renamed from: a */
    public final RequestCallbackWrapper<Void> mo29262a(long j) {
        return (RequestCallbackWrapper) this.f19294d.get(j);
    }

    /* renamed from: a */
    public final void mo29263a() {
        this.f19291a = null;
        this.f19292b = null;
    }

    /* renamed from: a */
    public final void mo29264a(long j, String str, long j2, boolean z, int i) {
        C6148d dVar = new C6148d();
        dVar.mo29185a(-1);
        dVar.mo29187a(m24514a(str));
        dVar.mo29188a("android");
        dVar.mo29186a(j2);
        dVar.mo29192b(i);
        C5912a createCustomReceivedMessage = MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, null, dVar, j);
        C5914c.m23708a(createCustomReceivedMessage);
        C6014b.m23945c(str, createCustomReceivedMessage.getUuid());
        if (z) {
            if (createCustomReceivedMessage.getSessionId().equals(this.f19292b)) {
                if (this.f19295e == null) {
                    mo29265a(this.f19291a.getContext(), (IMMessage) createCustomReceivedMessage);
                }
            } else if (!this.f19293c.containsKey(createCustomReceivedMessage.getSessionId())) {
                this.f19293c.put(createCustomReceivedMessage.getSessionId(), createCustomReceivedMessage);
            }
        }
    }

    /* renamed from: a */
    public final void mo29265a(final Context context, final IMMessage iMMessage) {
        final C6317a aVar = new C6317a(context, (C6148d) iMMessage.getAttachment());
        aVar.setCanceledOnTouchOutside(false);
        aVar.mo29517a((C6325a) new C6325a() {
            /* renamed from: a */
            public final void mo29272a(int i, List<String> list, String str) {
                aVar.mo29518a(false);
                aVar.mo29519b(true);
                C6178a.this.mo29267a(iMMessage, i, str, list, (RequestCallbackWrapper<Void>) new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i == 200) {
                            aVar.cancel();
                            return;
                        }
                        if (aVar.isShowing()) {
                            aVar.mo29518a(true);
                            aVar.mo29519b(false);
                            C5415g.m22163a(context.getString(C5961R.string.ysf_network_error));
                        }
                    }
                });
            }
        });
        aVar.show();
    }

    /* renamed from: a */
    public final void mo29266a(Fragment fragment, String str) {
        this.f19291a = fragment;
        this.f19292b = str;
        if (this.f19293c.containsKey(str)) {
            IMMessage iMMessage = (IMMessage) this.f19293c.remove(str);
            if (this.f19295e == null && iMMessage != null && (iMMessage.getAttachment() instanceof C6148d)) {
                mo29265a(fragment.getContext(), iMMessage);
            }
        }
    }

    /* renamed from: a */
    public final void mo29267a(IMMessage iMMessage, int i, String str, List<String> list, RequestCallbackWrapper<Void> requestCallbackWrapper) {
        final C6148d dVar = (C6148d) iMMessage.getAttachment();
        dVar.mo29185a(i);
        dVar.mo29193b(str);
        dVar.mo29189a(list);
        final String sessionId = iMMessage.getSessionId();
        final IMMessage queryLastMessage = ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(sessionId, SessionTypeEnum.Ysf);
        C6185c.m24532a(dVar, sessionId, true);
        long c = dVar.mo29194c();
        final IMMessage iMMessage2 = iMMessage;
        final RequestCallbackWrapper<Void> requestCallbackWrapper2 = requestCallbackWrapper;
        C61833 r1 = new RequestCallbackWrapper<Void>() {
            public final void onFailed(int i) {
                super.onFailed(i);
            }

            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                Void voidR = (Void) obj;
                if (i == 200) {
                    ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage2, true);
                    if (dVar.mo29194c() == C6014b.m23960h(sessionId)) {
                        C6014b.m23936b(sessionId, 2);
                        C6014b.m23927a(sessionId, -1);
                        C6014b.m23945c(sessionId, (String) null);
                    }
                }
                if (C6014b.m23960h(sessionId) == ((C6148d) iMMessage2.getAttachment()).mo29194c() || iMMessage2.isTheSame(queryLastMessage)) {
                    C6195a h = C6029d.m24047g().mo29305h();
                    if (h != null) {
                        h.mo29320a(sessionId);
                    }
                }
                RequestCallbackWrapper requestCallbackWrapper = requestCallbackWrapper2;
                if (requestCallbackWrapper != null) {
                    requestCallbackWrapper.onResult(i, voidR, th);
                }
            }
        };
        m24515a(c, (RequestCallbackWrapper<Void>) r1);
    }

    /* renamed from: a */
    public final void mo29268a(C6317a aVar) {
        this.f19295e = aVar;
    }

    /* renamed from: a */
    public final void mo29269a(final String str, int i, String str2, List<String> list, final RequestCallbackWrapper<Void> requestCallbackWrapper) {
        C5912a a = C5922f.m23740a(C6014b.m23971m(str));
        if (a != null) {
            mo29267a((IMMessage) a, i, str2, list, requestCallbackWrapper);
            return;
        }
        final C6148d dVar = new C6148d();
        dVar.mo29185a(i);
        dVar.mo29187a(m24514a(str));
        dVar.mo29193b(str2);
        dVar.mo29188a("android");
        dVar.mo29186a(C6014b.m23960h(str));
        dVar.mo29189a(list);
        C6185c.m24532a(dVar, str, false);
        m24515a(dVar.mo29194c(), (RequestCallbackWrapper<Void>) new RequestCallbackWrapper<Void>() {
            public final void onFailed(int i) {
                super.onFailed(i);
            }

            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                Void voidR = (Void) obj;
                if (i == 200) {
                    ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, dVar), true).setCallback(new RequestCallbackWrapper<Void>() {
                        public final /* bridge */ /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        }
                    });
                    if (dVar.mo29194c() == C6014b.m23960h(str)) {
                        C6014b.m23936b(str, 2);
                        C6014b.m23927a(str, -1);
                    }
                }
                C6195a h = C6029d.m24047g().mo29305h();
                if (h != null) {
                    h.mo29320a(str);
                }
                RequestCallbackWrapper requestCallbackWrapper = requestCallbackWrapper;
                if (requestCallbackWrapper != null) {
                    requestCallbackWrapper.onResult(i, voidR, th);
                }
            }
        });
    }

    /* renamed from: a */
    public final void mo29270a(String str, C6122d dVar) {
        if (C6014b.m23964j(str) == 1 || m24514a(str).mo29065h()) {
            mo29264a(System.currentTimeMillis(), str, dVar.mo29107b(), dVar.mo29108c(), dVar.mo29106a());
        }
    }

    /* renamed from: b */
    public final void mo29271b() {
        C6317a aVar = this.f19295e;
        if (aVar != null && aVar.isShowing()) {
            this.f19295e.cancel();
        }
    }
}
