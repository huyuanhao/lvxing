package com.qiyukf.unicorn.p514h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.LongSparseArray;
import com.p522qq.p523e.comm.constants.ErrorCode.OtherError;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.session.viewholder.C5629c;
import com.qiyukf.nim.uikit.session.viewholder.C5638j;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p469e.C5808b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5914c;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.p485i.C5923g;
import com.qiyukf.nimlib.p485i.C5925h;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6015c;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.analytics.C5973a;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.event.entry.RequestStaffEntry;
import com.qiyukf.unicorn.api.event.entry.TransferCloseResultEntry;
import com.qiyukf.unicorn.api.event.entry.TransferRequestEntry;
import com.qiyukf.unicorn.api.event.eventcallback.TransferCloseResultCallback;
import com.qiyukf.unicorn.api.event.eventcallback.TransferRequestCallback;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.api.pop.POPManager;
import com.qiyukf.unicorn.p493a.p494a.p495a.p496a.p498b.C5971b;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6042a;
import com.qiyukf.unicorn.p502e.C6043b;
import com.qiyukf.unicorn.p502e.C6045d;
import com.qiyukf.unicorn.p502e.C6048f;
import com.qiyukf.unicorn.p502e.C6049g;
import com.qiyukf.unicorn.p502e.C6051i;
import com.qiyukf.unicorn.p502e.C6053k;
import com.qiyukf.unicorn.p502e.C6054l;
import com.qiyukf.unicorn.p502e.C6055m;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.C6164f;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6072a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6074b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6076c;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6080e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6086g;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6090h;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6092i;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6094j;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6095k;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6099l;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6101m;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6103n;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6105a;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6106b;
import com.qiyukf.unicorn.p503f.p504a.p505a.p507b.C6107c;
import com.qiyukf.unicorn.p503f.p504a.p509c.C6114a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6121c;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6122d;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6126g;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6127h;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6128i;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6129j;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6130k;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6131l;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6133n;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6134o;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6135p;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6136q;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6137r;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6138s;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6139t;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6140u;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6142v;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6146b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6148d;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6150f;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6152h;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6155k;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6159o;
import com.qiyukf.unicorn.p515i.C6200b;
import com.qiyukf.unicorn.p516j.C6221h;
import com.qiyukf.unicorn.p517ui.p519b.C6295b;
import com.qiyukf.unicorn.p517ui.p519b.C6298c;
import com.qiyukf.unicorn.p517ui.p519b.C6303d;
import com.qiyukf.unicorn.p517ui.p519b.C6305e;
import com.qiyukf.unicorn.p517ui.p519b.C6312f;
import com.qiyukf.unicorn.p517ui.p519b.C6313g;
import com.qiyukf.unicorn.p517ui.p519b.C6314h;
import com.qiyukf.unicorn.p517ui.p519b.C6316i;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6253c;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6255d;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6258f;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6263g;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6265h;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6271i;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6273j;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6276k;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6278l;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6281m;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6283n;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6285o;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6291p;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6293q;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6294r;
import com.tencent.p605ep.commonbase.network.HttpStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.qiyukf.unicorn.h.d */
public final class C6187d {
    /* renamed from: A */
    private Observer<CustomNotification> f19317A = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (customNotification.getSessionType() == SessionTypeEnum.Ysf) {
                C6144e attachment = customNotification.getAttachment();
                if (attachment != null) {
                    C6187d.m24540a(C6187d.this, customNotification.getTime(), customNotification.getSessionId(), attachment);
                }
            }
        }
    };
    /* renamed from: B */
    private Observer<IMMessage> f19318B = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.getSessionType() == SessionTypeEnum.Ysf) {
                C6178a.m24516a(iMMessage);
            }
        }
    };
    /* renamed from: C */
    private Observer<List<IMMessage>> f19319C = new Observer<List<IMMessage>>() {
        public final /* synthetic */ void onEvent(Object obj) {
            List<IMMessage> list = (List) obj;
            if (((IMMessage) list.get(0)).getSessionType() == SessionTypeEnum.Ysf) {
                for (IMMessage iMMessage : list) {
                    if (iMMessage.getAttachment() instanceof C6119a) {
                        C6119a aVar = (C6119a) iMMessage.getAttachment();
                        C6187d.this.f19324e.mo28910a(aVar.mo29080b(), aVar.mo29083c(), aVar.mo29093j());
                        C6014b.m23975o(aVar.mo29080b());
                        C6187d.this.f19325f.mo28909a(aVar.mo29097n());
                        C6187d.m24541a(C6187d.this, aVar);
                    }
                    C6187d.this.f19327h.mo29273a(iMMessage);
                    int a = C6185c.m24531a(iMMessage);
                    if (iMMessage.getDirect() == MsgDirectionEnum.In && !(iMMessage.getAttachment() instanceof C6137r)) {
                        C6055m mVar = (C6055m) C6187d.this.f19321b.get(iMMessage.getSessionId());
                        if (a != 2) {
                            String o = mVar == null ? C6014b.m23974o() : mVar.f18942d;
                            if (TextUtils.isEmpty(o)) {
                                o = C6054l.m24099a(iMMessage.getSessionId());
                            }
                            iMMessage.setFromAccount(o);
                        }
                        ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(iMMessage, false);
                    }
                    if (iMMessage.getAttachment() instanceof C6131l) {
                        long c = C6187d.this.mo29295c(iMMessage.getSessionId());
                        if (c <= 0) {
                            c = C6187d.this.mo29303g(iMMessage.getSessionId());
                        }
                        if (c > 0) {
                            ((C6131l) iMMessage.getAttachment()).mo29126a(c);
                            ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, false);
                        }
                    }
                }
                C6178a.m24516a((IMMessage) list.get(0));
            }
        }
    };
    /* renamed from: a */
    private C6164f f19320a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Map<String, C6055m> f19321b = new HashMap();
    /* renamed from: c */
    private Map<String, Runnable> f19322c = new HashMap();
    /* renamed from: d */
    private ConsultSource f19323d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public C6054l f19324e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C6053k f19325f;
    /* renamed from: g */
    private C6178a f19326g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C6184b f19327h;
    /* renamed from: i */
    private boolean f19328i = false;
    /* renamed from: j */
    private TransferRequestCallback f19329j = null;
    /* renamed from: k */
    private Map<String, C6048f> f19330k = new HashMap();
    /* access modifiers changed from: private */
    /* renamed from: l */
    public C6195a f19331l;
    /* renamed from: m */
    private Map<String, ProductDetail> f19332m = new HashMap();
    /* renamed from: n */
    private Map<String, List<C6114a>> f19333n = new HashMap();
    /* renamed from: o */
    private Map<Long, List<C6045d>> f19334o = new HashMap();
    /* renamed from: p */
    private Map<String, C6051i> f19335p = new HashMap();
    /* renamed from: q */
    private LongSparseArray<C6051i> f19336q = new LongSparseArray<>();
    /* renamed from: r */
    private Map<String, Long> f19337r = new HashMap();
    /* renamed from: s */
    private Map<String, C6042a> f19338s = new HashMap();
    /* renamed from: t */
    private Map<String, Boolean> f19339t = new HashMap();
    /* renamed from: u */
    private Map<String, Long> f19340u = new HashMap();
    /* renamed from: v */
    private Map<String, Boolean> f19341v = new HashMap();
    /* renamed from: w */
    private Context f19342w;
    /* renamed from: x */
    private Map<String, C6049g> f19343x = new HashMap();
    /* renamed from: y */
    private Handler f19344y;
    /* renamed from: z */
    private boolean f19345z;

    /* renamed from: com.qiyukf.unicorn.h.d$a */
    public interface C6195a {
        /* renamed from: a */
        void mo29319a();

        /* renamed from: a */
        void mo29320a(String str);

        /* renamed from: a */
        void mo29321a(String str, C6043b bVar);

        /* renamed from: b */
        void mo29322b(String str);
    }

    /* renamed from: com.qiyukf.unicorn.h.d$b */
    private static class C6196b implements Runnable {
        /* renamed from: a */
        private String f19365a;

        private C6196b(String str) {
            this.f19365a = str;
        }

        /* synthetic */ C6196b(String str, byte b) {
            this(str);
        }

        public final void run() {
            if (TextUtils.isEmpty(C6014b.m23942c()) || this.f19365a.equals(C6014b.m23942c())) {
                C6119a aVar = new C6119a();
                aVar.mo29077a((int) HttpStatus.SC_REQUEST_TIMEOUT);
                aVar.mo29079a(this.f19365a);
                C5808b.m23319a(MessageBuilder.createCustomNotification(aVar, this.f19365a));
            }
        }
    }

    public C6187d(Context context) {
        this.f19344y = new Handler(context.getMainLooper());
        this.f19320a = C6164f.m24457a();
        this.f19321b = new HashMap();
        this.f19324e = new C6054l();
        this.f19325f = new C6053k();
        this.f19326g = new C6178a();
        this.f19327h = new C6184b(this.f19325f, this.f19324e);
        ((MsgService) NIMClient.getService(MsgService.class)).registerCustomAttachmentParser(MsgTypeEnum.custom, this.f19320a);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f19317A, true);
        if (!(C6029d.m24045e().sdkEvents == null || C6029d.m24045e().sdkEvents.eventProcessFactory == null)) {
            C6029d.m24045e().sdkEvents.eventProcessFactory.eventOf(2);
        }
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.f19318B, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeReceiveMessage(this.f19319C, true);
        C5629c.m22788a(C6119a.class, C5638j.class);
        C5629c.m22788a(C6146b.class, C6313g.class);
        C5629c.m22788a(C6148d.class, C6295b.class);
        C5629c.m22788a(C6131l.class, C6305e.class);
        C5629c.m22788a(C6137r.class, C6314h.class);
        C5629c.m22788a(C6159o.class, C6312f.class);
        C5629c.m22788a(ProductAttachment.class, C6298c.class);
        C5629c.m22788a(C6130k.class, C6303d.class);
        C5629c.m22788a(C6135p.class, C5638j.class);
        C5629c.m22788a(C6133n.class, C5638j.class);
        C5629c.m22788a(C6127h.class, C6316i.class);
        C5629c.m22788a(C6072a.class, C6253c.class);
        C5629c.m22788a(C6074b.class, C6255d.class);
        C5629c.m22788a(C6086g.class, C6276k.class);
        C5629c.m22788a(C6094j.class, C6283n.class);
        C5629c.m22788a(C6095k.class, C6285o.class);
        C5629c.m22788a(C6101m.class, C6293q.class);
        C5629c.m22788a(C6099l.class, C6291p.class);
        C5629c.m22788a(C6103n.class, C6294r.class);
        C5629c.m22788a(C6084f.class, C6265h.class);
        C5629c.m22788a(C6092i.class, C6278l.class);
        C5629c.m22788a(C6080e.class, C6258f.class);
        C5629c.m22788a(C6076c.class, C6263g.class);
        C5629c.m22788a(C6090h.class, C6281m.class);
        C5629c.m22788a(C5971b.class, C6273j.class);
        C5629c.m22788a(C6107c.class, C6294r.class);
        C5629c.m22788a(C6105a.class, C6271i.class);
        C5629c.m22788a(C6106b.class, C6294r.class);
    }

    /* renamed from: a */
    private static IMMessage m24538a(long j, String str) {
        return MessageBuilder.createEmptyMessage(str, SessionTypeEnum.Ysf, j);
    }

    /* renamed from: a */
    static /* synthetic */ void m24540a(C6187d dVar, long j, final String str, C6144e eVar) {
        String content;
        boolean z = false;
        switch (eVar.getCmdId()) {
            case 2:
                final C6119a aVar = (C6119a) eVar;
                if (dVar.f19328i) {
                    TransferRequestEntry transferRequestEntry = new TransferRequestEntry();
                    transferRequestEntry.setCode(aVar.mo29075a());
                    dVar.f19329j.handlerTransferRequestCallback(transferRequestEntry);
                }
                if (aVar.mo29075a() != 200) {
                    dVar.f19344y.postDelayed(new Runnable() {
                        public final void run() {
                            C6187d.this.m24546a(str, aVar);
                        }
                    }, 1000);
                    break;
                } else {
                    dVar.m24546a(str, aVar);
                    return;
                }
            case 6:
                C6133n nVar = (C6133n) eVar;
                dVar.f19321b.remove(str);
                dVar.f19336q.remove(nVar.mo29138a());
                dVar.f19337r.remove(str);
                dVar.f19338s.remove(str);
                dVar.f19333n.remove(str);
                dVar.f19340u.remove(str);
                dVar.f19339t.remove(str);
                dVar.f19334o.remove(str);
                C6014b.m23937b(String.valueOf(nVar.mo29138a()), System.currentTimeMillis());
                dVar.m24553j();
                dVar.f19335p.remove(str);
                if (nVar.mo29142e() == 2) {
                    C5914c.m23708a(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, nVar));
                }
                if (nVar.mo29139b() == 1) {
                    dVar.f19326g.mo29264a(j, str, nVar.mo29138a(), nVar.mo29140c(), 0);
                }
                C6029d.m24048h().mo28853a(str, SessionStatusEnum.NONE);
                return;
            case 9:
                dVar.m24545a(str, j, (C6126g) eVar);
                return;
            case 15:
                C6128i iVar = (C6128i) eVar;
                if (iVar.mo29117b() == 200) {
                    C6048f fVar = (C6048f) dVar.f19330k.get(str);
                    if (fVar != null) {
                        fVar.f18914a = iVar.mo29116a();
                        fVar.f18915b = iVar.mo29118c();
                        fVar.f18916c = iVar.mo29120e();
                        fVar.f18917d = iVar.mo29121f();
                        dVar.m24544a(str, 10000);
                    }
                    return;
                } else if (iVar.mo29117b() == 301 || iVar.mo29117b() != 302) {
                    dVar.mo29312n(str);
                    return;
                } else {
                    dVar.mo29312n(str);
                    C6029d.m24048h().mo28853a(str, SessionStatusEnum.NONE);
                    return;
                }
            case 23:
                C6134o oVar = (C6134o) eVar;
                dVar.f19337r.put(str, Long.valueOf(oVar.mo29143a()));
                if (oVar.mo29144b() == 1) {
                    z = true;
                }
                dVar.f19336q.put(oVar.mo29143a(), new C6051i(z, oVar.mo29145c()));
                return;
            case 28:
                C6127h hVar = (C6127h) eVar;
                if (!(dVar.f19341v.get(str) == null ? Boolean.valueOf(false) : (Boolean) dVar.f19341v.get(str)).booleanValue()) {
                    C5912a a = C5922f.m23740a(hVar.mo29115b());
                    if (a != null) {
                        ((MsgService) NIMClient.getService(MsgService.class)).deleteChattingHistory(a);
                        UserInfo userInfo = C5718b.m23017d().userInfoProvider.getUserInfo(a.getFromAccount());
                        StringBuilder sb = new StringBuilder();
                        sb.append(userInfo.getName());
                        sb.append("撤回了一条消息");
                        hVar.mo29114a(sb.toString());
                        ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomMessage(str, SessionTypeEnum.Ysf, hVar), true);
                    }
                }
                return;
            case 42:
                C6139t tVar = (C6139t) eVar;
                if (tVar != null && tVar.mo29166a()) {
                    C5912a a2 = C5922f.m23740a(tVar.mo29167b());
                    if (a2 != null) {
                        JSONObject extension = a2.getExtension();
                        if (extension == null) {
                            extension = new JSONObject();
                        }
                        C5366b.m22031a(extension, "trashWords", (Object) tVar.mo29168c());
                        C5366b.m22029a(extension, "auditResult", tVar.mo29169d());
                        a2.setExt(extension.toString());
                        ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(a2, true);
                        C5925h a3 = C5922f.m23743a(a2.getSessionId(), a2.getSessionType());
                        if (a3 != null && TextUtils.equals(a3.getRecentMessageId(), a2.getUuid())) {
                            C6138s sVar = new C6138s();
                            if (a2.getMsgType() == MsgTypeEnum.image) {
                                content = "[图片]";
                            } else if (a2.getAttachment() instanceof C6130k) {
                                sVar.mo29164a(((C6130k) a2.getAttachment()).toJson(false));
                                sVar.mo29162a();
                                sVar.mo29165a(tVar.mo29168c());
                                sVar.mo29163a(tVar.mo29169d());
                                a3.mo28344b(MsgTypeEnum.custom.getValue());
                                a3.mo28348e(sVar.toJson(false));
                                a3.setMsgStatus(MsgStatusEnum.fail);
                                C5922f.m23752a(a3);
                                C5808b.m23321a((RecentContact) a3);
                            } else {
                                content = a2.getContent();
                            }
                            sVar.mo29164a(content);
                            sVar.mo29165a(tVar.mo29168c());
                            sVar.mo29163a(tVar.mo29169d());
                            a3.mo28344b(MsgTypeEnum.custom.getValue());
                            a3.mo28348e(sVar.toJson(false));
                            a3.setMsgStatus(MsgStatusEnum.fail);
                            C5922f.m23752a(a3);
                            C5808b.m23321a((RecentContact) a3);
                        }
                    }
                }
                return;
            case 50:
                dVar.f19326g.mo29270a(str, (C6122d) eVar);
                return;
            case 55:
                C6121c cVar = (C6121c) eVar;
                if (dVar.f19326g == null || !(cVar.mo29104a() == 411 || cVar.mo29104a() == 413)) {
                    C6178a aVar2 = dVar.f19326g;
                    if (aVar2 != null) {
                        RequestCallbackWrapper a4 = aVar2.mo29262a(cVar.mo29105b());
                        if (a4 != null) {
                            a4.onFailed(cVar.mo29104a());
                        }
                    }
                    int a5 = cVar.mo29104a();
                    if (a5 != 412) {
                        if (a5 == 414) {
                            C5415g.m22161a(C5961R.string.ysf_evaluation_error);
                        }
                        return;
                    }
                    C5415g.m22161a(C5961R.string.ysf_evaluation_timeout);
                    return;
                }
                RequestCallbackWrapper a6 = dVar.f19326g.mo29262a(cVar.mo29105b());
                if (a6 != null) {
                    a6.onResult(200, null, null);
                }
                return;
            case 57:
                C6140u uVar = (C6140u) eVar;
                dVar.f19335p.put(str, new C6051i(uVar.mo29170a(), uVar.mo29171b()));
                return;
            case 70:
                C6135p pVar = (C6135p) eVar;
                ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, pVar), true);
                C6014b.m23937b(String.valueOf(pVar.mo29147b()), System.currentTimeMillis());
                return;
            case 90:
                C6137r rVar = (C6137r) eVar;
                Runnable runnable = (Runnable) dVar.f19322c.remove(str);
                if (runnable != null) {
                    dVar.f19344y.removeCallbacks(runnable);
                }
                dVar.f19324e.mo28910a(C6054l.m24100b(str), C6029d.m24039c().getString(C5961R.string.ysf_staff_name_group), rVar.mo29155b());
                dVar.f19325f.mo28909a(rVar.mo29159f());
                C5912a createCustomReceivedMessage = MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, rVar);
                createCustomReceivedMessage.setFromAccount(C6054l.m24100b(str));
                ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(createCustomReceivedMessage, true);
                dVar.f19321b.remove(str);
                C6029d.m24048h().mo28853a(str, SessionStatusEnum.NONE);
                return;
            case 108:
                C6195a aVar3 = dVar.f19331l;
                if (aVar3 != null) {
                    aVar3.mo29322b(str);
                }
                dVar.f19339t.put(str, Boolean.valueOf(true));
                break;
            case 163:
                C5973a.m23887b();
                return;
            case 405:
                C6198a.f19367a.mo29324a(j, str, (C6136q) eVar);
                return;
            case 502:
                C6029d.m24048h().mo28852a((C6129j) eVar);
                return;
            case OtherError.VIDEO_PLAY_ERROR /*701*/:
                C6221h.m24657a((C6142v) eVar);
                return;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24541a(C6187d dVar, C6119a aVar) {
        if (aVar.mo29091h() == 0) {
            ConsultSource consultSource = dVar.f19323d;
            if (consultSource != null && !TextUtils.isEmpty(consultSource.vipStaffid) && !TextUtils.isEmpty(dVar.f19323d.VIPStaffAvatarUrl)) {
                C6054l lVar = dVar.f19324e;
                String str = dVar.f19323d.vipStaffid;
                String str2 = TextUtils.isEmpty(dVar.f19323d.vipStaffName) ? aVar.mo29083c() : dVar.f19323d.vipStaffName.length() > 40 ? dVar.f19323d.vipStaffName.substring(0, 40) : dVar.f19323d.vipStaffName;
                lVar.mo28910a(str, str2, dVar.f19323d.VIPStaffAvatarUrl);
            }
        }
    }

    /* renamed from: a */
    private void m24544a(final String str, long j) {
        C6048f fVar = (C6048f) this.f19330k.get(str);
        if (fVar != null) {
            if (fVar.f18918e == null) {
                fVar.f18918e = new Runnable() {
                    public final void run() {
                        C6152h hVar = new C6152h();
                        hVar.mo29201a(C6014b.m23948d());
                        C6185c.m24532a(hVar, str, false);
                    }
                };
            }
            this.f19344y.removeCallbacks(fVar.f18918e);
            this.f19344y.postDelayed(fVar.f18918e, j);
        }
    }

    /* renamed from: a */
    private void m24545a(String str, long j, C6126g gVar) {
        ArrayList a;
        Log.i("attachment:", gVar.mo29112a());
        Long valueOf = Long.valueOf(this.f19340u.get(str) == null ? 0 : ((Long) this.f19340u.get(str)).longValue());
        ArrayList<C5912a> arrayList = new ArrayList<>();
        if (valueOf.longValue() == 0) {
            a = C5922f.m23746a((C5912a) m24538a(j, str), QueryDirectionEnum.QUERY_OLD, 20, true);
        } else if (valueOf.longValue() <= j) {
            a = C5922f.m23745a((C5912a) m24538a(valueOf.longValue(), str), valueOf.longValue(), j);
        } else {
            return;
        }
        arrayList.addAll(a);
        for (C5912a aVar : arrayList) {
            if (aVar.getStatus() == MsgStatusEnum.unread && aVar.getTime() < j) {
                aVar.setStatus(MsgStatusEnum.read);
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(aVar, true);
            }
        }
        this.f19340u.put(str, Long.valueOf(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24546a(String str, C6119a aVar) {
        Boolean bool;
        Map<String, Boolean> map;
        SessionStatusEnum sessionStatusEnum;
        C6015c cVar;
        String str2 = str;
        Runnable runnable = (Runnable) this.f19322c.remove(str2);
        if (runnable != null) {
            this.f19344y.removeCallbacks(runnable);
        }
        int i = 0;
        if (aVar.mo29096m() != null) {
            map = this.f19339t;
            bool = Boolean.valueOf(aVar.mo29096m().mo29067j());
        } else {
            map = this.f19339t;
            bool = Boolean.valueOf(false);
        }
        map.put(str2, bool);
        this.f19321b.remove(str2);
        int a = aVar.mo29075a();
        if (a == 201 || a == 203) {
            this.f19325f.mo28909a(aVar.mo29097n());
        }
        if (a == 200) {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
            C6055m mVar = new C6055m(aVar.mo29087e());
            mVar.f18942d = aVar.mo29080b();
            mVar.f18943e = aVar.mo29083c();
            mVar.f18944f = aVar.mo29085d();
            mVar.f18945g = aVar.mo29091h();
            mVar.f18946h = aVar.mo29092i();
            mVar.f18940b = aVar.mo29094k();
            mVar.f18941c = aVar.mo29095l();
            mVar.f18947i = aVar.mo29093j();
            this.f19321b.put(str2, mVar);
            m24554s(str);
            if (C6029d.m24048h() != null) {
                C6029d.m24048h().mo28853a(str2, SessionStatusEnum.IN_SESSION);
            }
            if (C6014b.m23960h(str) != mVar.f18939a) {
                C6014b.m23928a(str2, mVar.f18939a);
                C6014b.m23927a(str2, 0);
                if (mVar.f18945g != 1) {
                    i = 1;
                }
                C6014b.m23936b(str2, i);
                C6014b.m23945c(str2, (String) null);
                C6014b.m23929a(str2, aVar.mo29096m());
            }
            if (mVar.f18945g != 1 && mVar.f18945g == 0) {
                C6200b.m24602a().mo29397b();
            }
            this.f19338s.put(str2, aVar.mo29098o());
        } else {
            if (a == 203) {
                ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
                C6048f fVar = new C6048f(aVar.mo29087e(), aVar.mo29089f(), aVar.mo29090g(), aVar.mo29099p(), aVar.mo29100q(), aVar.mo29101r());
                this.f19330k.put(str2, fVar);
                m24544a(str2, 10000);
                m24554s(str);
                cVar = C6029d.m24048h();
                sessionStatusEnum = SessionStatusEnum.IN_QUEUE;
            } else {
                cVar = C6029d.m24048h();
                sessionStatusEnum = SessionStatusEnum.NONE;
            }
            cVar.mo28853a(str2, sessionStatusEnum);
        }
        if (a == 200 || a == 201 || a == 205) {
            mo29312n(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24547a(String str, boolean z, C6043b bVar, RequestStaffEntry requestStaffEntry) {
        C6196b bVar2 = new C6196b(str, 0);
        this.f19322c.put(str, bVar2);
        this.f19344y.postDelayed(bVar2, C5411c.m22135b(C6029d.m24039c()) ? 15000 : 3000);
        mo29312n(str);
        C6155k kVar = new C6155k();
        kVar.mo29218g(C6029d.m24039c().getPackageName());
        kVar.mo29204a((int) z);
        ConsultSource consultSource = this.f19323d;
        if (consultSource != null) {
            kVar.mo29206a(consultSource.uri);
            kVar.mo29209b(this.f19323d.title);
            kVar.mo29212c(this.f19323d.custom);
            kVar.mo29208b(this.f19323d.groupId);
            kVar.mo29205a(this.f19323d.staffId);
            kVar.mo29213d(this.f19323d.faqGroupId);
            kVar.mo29207b((int) this.f19323d.robotFirst);
            ConsultSource consultSource2 = this.f19323d;
            consultSource2.robotFirst = true;
            kVar.mo29210c(consultSource2.vipLevel);
            kVar.mo29215e(this.f19323d.robotId);
            if (!(requestStaffEntry == null || requestStaffEntry.getProductDetail() == null)) {
                this.f19323d.productDetail = requestStaffEntry.getProductDetail();
            }
        }
        kVar.mo29214d("Android");
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BRAND);
        sb.append("$$");
        sb.append(VERSION.RELEASE);
        kVar.mo29216e(sb.toString());
        kVar.mo29217f(C5718b.m23021h());
        kVar.mo29203a();
        if (bVar != null) {
            kVar.mo29205a(bVar.mo28885b());
            kVar.mo29208b(bVar.mo28883a());
            kVar.mo29211c(bVar.f18901d);
        }
        if (requestStaffEntry != null) {
            kVar.mo29206a(requestStaffEntry.getUri());
            kVar.mo29209b(requestStaffEntry.getTitle());
            kVar.mo29212c(requestStaffEntry.getCustom());
            kVar.mo29213d(requestStaffEntry.getFaqGroupId());
            kVar.mo29215e(requestStaffEntry.getRobotId());
            kVar.mo29211c(requestStaffEntry.getEntryId());
            kVar.mo29207b((int) requestStaffEntry.isRobotFirst());
            kVar.mo29210c(requestStaffEntry.getVipLevel());
            kVar.mo29215e(requestStaffEntry.getRobotId());
            kVar.mo29208b(requestStaffEntry.getGroupId());
            kVar.mo29205a(requestStaffEntry.getStaffId());
        }
        C6185c.m24532a(kVar, str, false);
        this.f19321b.remove(str);
        C6029d.m24048h().mo28853a(str, SessionStatusEnum.NONE);
        C6195a aVar = this.f19331l;
        if (aVar != null) {
            aVar.mo29321a(str, bVar);
        }
    }

    /* renamed from: j */
    public static IMMessage m24552j(String str) {
        IMMessage t = m24555t(str);
        if (t == null || !((C6137r) t.getAttachment()).mo29157d()) {
            return null;
        }
        return t;
    }

    /* renamed from: j */
    private void m24553j() {
        if (!this.f19345z && this.f19321b.size() == 0 && this.f19330k.size() == 0) {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(0);
        }
    }

    /* renamed from: s */
    private static void m24554s(String str) {
        if (!C6029d.m24048h().mo28856b(str)) {
            C5912a aVar = (C5912a) POPManager.queryLastMessage(str);
            if (aVar == null) {
                aVar = (C5912a) MessageBuilder.createEmptyMessage(str, SessionTypeEnum.Ysf, System.currentTimeMillis());
                aVar.setStatus(MsgStatusEnum.success);
                aVar.mo28292a(MsgTypeEnum.tips.getValue());
                aVar.setContent("");
            }
            C5808b.m23321a((RecentContact) C5923g.m23759a(aVar));
        }
    }

    /* renamed from: t */
    private static IMMessage m24555t(String str) {
        IMMessage iMMessage;
        try {
            iMMessage = C5922f.m23741a(str, SessionTypeEnum.Ysf.getValue());
        } catch (Exception unused) {
            iMMessage = null;
        }
        if (iMMessage == null || !(iMMessage.getAttachment() instanceof C6137r)) {
            return null;
        }
        return iMMessage;
    }

    /* renamed from: a */
    public final int mo29277a(String str) {
        C6048f fVar = (C6048f) this.f19330k.get(str);
        if (fVar == null) {
            return 0;
        }
        return fVar.f18915b;
    }

    /* renamed from: a */
    public final C6054l mo29278a() {
        return this.f19324e;
    }

    /* renamed from: a */
    public final List<C6045d> mo29279a(Long l) {
        return this.f19334o.get(l) == null ? new ArrayList() : (List) this.f19334o.get(l);
    }

    /* renamed from: a */
    public final void mo29280a(Context context) {
        this.f19342w = context;
    }

    /* renamed from: a */
    public final void mo29281a(ConsultSource consultSource) {
        this.f19323d = consultSource;
    }

    /* renamed from: a */
    public final void mo29282a(OnPushMessageListener onPushMessageListener) {
        this.f19327h.mo29274a(onPushMessageListener);
    }

    /* renamed from: a */
    public final void mo29283a(C6195a aVar) {
        this.f19331l = aVar;
    }

    /* renamed from: a */
    public final void mo29284a(Long l, List<C6045d> list) {
        this.f19334o.put(l, list);
    }

    /* renamed from: a */
    public final void mo29285a(String str, long j, long j2, String str2, boolean z, TransferCloseResultCallback transferCloseResultCallback, TransferRequestCallback transferRequestCallback) {
        this.f19329j = transferRequestCallback;
        final C6146b bVar = new C6146b();
        bVar.mo29179a(mo29295c(str));
        bVar.mo29180a(str2);
        final String str3 = str;
        InvocationFuture a = C6185c.m24532a(bVar, str, false);
        final TransferCloseResultCallback transferCloseResultCallback2 = transferCloseResultCallback;
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        C61881 r0 = new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (transferCloseResultCallback2 != null) {
                    TransferCloseResultEntry transferCloseResultEntry = new TransferCloseResultEntry();
                    transferCloseResultEntry.setCode(i);
                    transferCloseResultCallback2.handlerTransferCloseCallback(transferCloseResultEntry);
                }
                if (i == 200) {
                    int i2 = 1;
                    ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(str3, SessionTypeEnum.Ysf, bVar), true);
                    C6043b bVar = null;
                    if (!(j3 == 0 && j4 == 0)) {
                        bVar = new C6043b();
                        if (j3 != 0) {
                            i2 = 2;
                        }
                        bVar.f18898a = i2;
                        long j = j3;
                        if (j == 0) {
                            j = j4;
                        }
                        bVar.f18899b = j;
                        bVar.mo28886b(j3);
                        bVar.mo28884a(j4);
                    }
                    C6043b bVar2 = bVar;
                    C6187d dVar = C6187d.this;
                    String str = str3;
                    boolean z = z2;
                    dVar.mo29290a(str, z, bVar2, z ? 5 : 0, true);
                    return;
                }
                C5415g.m22165b(C5961R.string.ysf_transfer_staff_error);
            }
        };
        a.setCallback(r0);
    }

    /* renamed from: a */
    public final void mo29286a(String str, ProductDetail productDetail) {
        this.f19332m.put(str, productDetail);
    }

    /* renamed from: a */
    public final void mo29287a(String str, List<C6114a> list) {
        this.f19333n.put(str, list);
    }

    /* renamed from: a */
    public final void mo29288a(String str, boolean z) {
        this.f19345z = z;
        m24553j();
        if (this.f19330k.containsKey(str)) {
            if (z) {
                m24544a(str, 0);
                return;
            }
            C6048f fVar = (C6048f) this.f19330k.get(str);
            if (!(fVar == null || fVar.f18918e == null)) {
                this.f19344y.removeCallbacks(fVar.f18918e);
                StringBuilder sb = new StringBuilder("handler testremove");
                sb.append(str);
                C5264a.m21620b("test", sb.toString());
            }
        }
    }

    /* renamed from: a */
    public final boolean mo29289a(String str, boolean z, C6043b bVar, int i) {
        return mo29290a(str, z, bVar, i, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
            if (r12.f18899b > 0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a5, code lost:
            if (mo29277a(r10) == 0) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* renamed from: a */
    public final boolean mo29290a(final java.lang.String r10, final boolean r11, final com.qiyukf.unicorn.p502e.C6043b r12, int r13, boolean r14) {
        /*
        r9 = this;
        java.lang.StringBuilder r0 = new java.lang.StringBuilder
        java.lang.String r1 = "isTransfar:"
        r0.<init>(r1)
        r0.append(r14)
        java.lang.String r1 = "requestStaffScenes:"
        r0.append(r1)
        r0.append(r13)
        java.lang.String r0 = r0.toString()
        java.lang.String r1 = "requestStaff"
        com.qiyukf.basesdk.p393a.C5264a.m21617a(r1, r0)
        r9.f19328i = r14
        r0 = 0
        if (r14 != 0) goto L_0x0022
        r9.f19329j = r0
    L_0x0022:
        boolean r1 = android.text.TextUtils.isEmpty(r10)
        r2 = 0
        r4 = 0
        r5 = 1
        if (r1 != 0) goto L_0x00a8
        com.qiyukf.unicorn.api.ConsultSource r1 = r9.f19323d
        if (r1 != 0) goto L_0x0032
        goto L_0x00a8
    L_0x0032:
        com.qiyukf.unicorn.e.g r1 = new com.qiyukf.unicorn.e.g
        r1.m50341init()
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.staffId
        r1.mo28898a(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.groupId
        r1.mo28900b(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.robotId
        r1.mo28902c(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        boolean r6 = r6.robotFirst
        r1.mo28901b(r6)
        r1.mo28899a(r11)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.faqGroupId
        r1.mo28903d(r6)
        if (r12 == 0) goto L_0x006d
        long r6 = r12.mo28885b()
        r1.mo28898a(r6)
        long r6 = r12.mo28883a()
        r1.mo28900b(r6)
    L_0x006d:
        java.util.Map<java.lang.String, com.qiyukf.unicorn.e.g> r6 = r9.f19343x
        java.lang.Object r6 = r6.get(r10)
        boolean r6 = r1.equals(r6)
        if (r6 != 0) goto L_0x0080
        java.util.Map<java.lang.String, com.qiyukf.unicorn.e.g> r6 = r9.f19343x
        r6.put(r10, r1)
    L_0x007e:
        r1 = 1
        goto L_0x00a9
    L_0x0080:
        java.util.Map<java.lang.String, com.qiyukf.unicorn.e.m> r1 = r9.f19321b
        java.lang.Object r1 = r1.get(r10)
        com.qiyukf.unicorn.e.m r1 = (com.qiyukf.unicorn.p502e.C6055m) r1
        if (r1 == 0) goto L_0x0099
        int r6 = r1.f18945g
        if (r6 != r5) goto L_0x0099
        if (r11 != 0) goto L_0x007e
        if (r12 == 0) goto L_0x0099
        long r6 = r12.f18899b
        int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r8 <= 0) goto L_0x0099
    L_0x0098:
        goto L_0x007e
    L_0x0099:
        if (r1 != 0) goto L_0x00a8
        boolean r1 = r9.mo29306h(r10)
        if (r1 != 0) goto L_0x00a8
        int r1 = r9.mo29277a(r10)
        if (r1 != 0) goto L_0x00a8
        goto L_0x0098
    L_0x00a8:
        r1 = 0
    L_0x00a9:
        if (r1 == 0) goto L_0x0177
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.event.SDKEvents r1 = r1.sdkEvents
        if (r1 == 0) goto L_0x0174
        com.qiyukf.unicorn.api.YSFOptions r1 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.event.SDKEvents r1 = r1.sdkEvents
        com.qiyukf.unicorn.api.event.EventProcessFactory r1 = r1.eventProcessFactory
        if (r1 == 0) goto L_0x0174
        com.qiyukf.unicorn.api.event.entry.RequestStaffEntry r1 = new com.qiyukf.unicorn.api.event.entry.RequestStaffEntry
        r1.m50268init()
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        if (r6 == 0) goto L_0x010a
        java.lang.String r6 = r6.uri
        r1.setUri(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        java.lang.String r6 = r6.title
        r1.setTitle(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        java.lang.String r6 = r6.custom
        r1.setCustom(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.groupId
        r1.setGroupId(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.staffId
        r1.setStaffId(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.faqGroupId
        r1.setFaqGroupId(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        boolean r6 = r6.robotFirst
        r1.setRobotFirst(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        int r6 = r6.vipLevel
        r1.setVipLevel(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        long r6 = r6.robotId
        r1.setRobotId(r6)
        com.qiyukf.unicorn.api.ConsultSource r6 = r9.f19323d
        com.qiyukf.unicorn.api.ProductDetail r6 = r6.productDetail
        r1.setProductDetail(r6)
    L_0x010a:
        if (r12 == 0) goto L_0x0131
        long r6 = r12.mo28883a()
        int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
        if (r8 != 0) goto L_0x0119
        long r2 = r12.mo28887c()
        goto L_0x011d
    L_0x0119:
        long r2 = r12.mo28883a()
    L_0x011d:
        r1.setGroupId(r2)
        long r2 = r12.mo28885b()
        r1.setStaffId(r2)
        java.lang.String r2 = r12.f18900c
        r1.setLabel(r2)
        long r2 = r12.f18901d
        r1.setEntryId(r2)
    L_0x0131:
        if (r10 != 0) goto L_0x0136
        java.lang.String r2 = "-1"
        goto L_0x0137
    L_0x0136:
        r2 = r10
    L_0x0137:
        r1.setShopId(r2)
        r1.setScenes(r13)
        r1.setHumanOnly(r11)
        r1.setTransfar(r14)
        int r13 = r9.mo29301f(r10)
        if (r13 == 0) goto L_0x0154
        int r13 = r9.mo29301f(r10)
        if (r13 == r5) goto L_0x0150
        goto L_0x0154
    L_0x0150:
        r1.setRobot(r5)
        goto L_0x0157
    L_0x0154:
        r1.setRobot(r4)
    L_0x0157:
        com.qiyukf.unicorn.api.YSFOptions r13 = com.qiyukf.unicorn.C6029d.m24045e()
        com.qiyukf.unicorn.api.event.SDKEvents r13 = r13.sdkEvents
        com.qiyukf.unicorn.api.event.EventProcessFactory r13 = r13.eventProcessFactory
        com.qiyukf.unicorn.api.event.UnicornEventBase r13 = r13.eventOf(r4)
        if (r13 == 0) goto L_0x0170
        android.content.Context r14 = r9.f19342w
        com.qiyukf.unicorn.h.d$2 r0 = new com.qiyukf.unicorn.h.d$2
        r0.m50469init(r10, r12, r11)
        r13.onEvent(r1, r14, r0)
        goto L_0x0173
    L_0x0170:
        r9.m24547a(r10, r11, r12, r0)
    L_0x0173:
        return r5
    L_0x0174:
        r9.m24547a(r10, r11, r12, r0)
    L_0x0177:
        boolean r10 = r9.mo29306h(r10)
        return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p514h.C6187d.mo29290a(java.lang.String, boolean, com.qiyukf.unicorn.e.b, int, boolean):boolean");
    }

    /* renamed from: b */
    public final C6048f mo29291b(String str) {
        return (C6048f) this.f19330k.get(str);
    }

    /* renamed from: b */
    public final C6053k mo29292b() {
        return this.f19325f;
    }

    /* renamed from: b */
    public final void mo29293b(OnPushMessageListener onPushMessageListener) {
        this.f19327h.mo29275b(onPushMessageListener);
    }

    /* renamed from: b */
    public final void mo29294b(String str, boolean z) {
        this.f19341v.put(str, Boolean.valueOf(z));
    }

    /* renamed from: c */
    public final long mo29295c(String str) {
        C6055m mVar = (C6055m) this.f19321b.get(str);
        if (mVar == null) {
            return 0;
        }
        return mVar.f18939a;
    }

    /* renamed from: c */
    public final C6178a mo29296c() {
        return this.f19326g;
    }

    /* renamed from: d */
    public final C6055m mo29297d(String str) {
        return (C6055m) this.f19321b.get(str);
    }

    /* renamed from: d */
    public final boolean mo29298d() {
        return !this.f19321b.isEmpty() || !this.f19330k.isEmpty();
    }

    /* renamed from: e */
    public final long mo29299e(String str) {
        try {
            if (this.f19337r.get(str) == null) {
                return -100;
            }
            return ((Long) this.f19337r.get(str)).longValue();
        } catch (NullPointerException e) {
            StringBuilder sb = new StringBuilder("获取 getfaqSessionId 失败");
            sb.append(e.getMessage());
            C5264a.m21617a("getfaqSessionId", sb.toString());
            return 0;
        }
    }

    /* renamed from: e */
    public final Map<String, C6055m> mo29300e() {
        return this.f19321b;
    }

    /* renamed from: f */
    public final int mo29301f(String str) {
        C6055m mVar = (C6055m) this.f19321b.get(str);
        if (mVar == null) {
            return 0;
        }
        return mVar.f18945g;
    }

    /* renamed from: f */
    public final void mo29302f() {
        C6150f fVar = new C6150f();
        fVar.mo29200a(C6014b.m23948d());
        C6185c.m24532a(fVar, C6185c.m24533a(), false);
        mo29304g();
        this.f19335p.clear();
        this.f19336q.clear();
        this.f19337r.clear();
        this.f19338s.clear();
        this.f19340u.clear();
        this.f19333n.clear();
        this.f19332m.clear();
        this.f19344y.removeCallbacks(null);
        this.f19343x.clear();
        this.f19322c.clear();
    }

    /* renamed from: g */
    public final long mo29303g(String str) {
        C6048f fVar = (C6048f) this.f19330k.get(str);
        if (fVar == null) {
            return 0;
        }
        return fVar.f18920g;
    }

    /* renamed from: g */
    public final void mo29304g() {
        this.f19321b.clear();
        Runnable runnable = (Runnable) this.f19322c.get(C6014b.m23942c());
        String str = "test";
        if (runnable != null) {
            this.f19344y.removeCallbacks(runnable);
            StringBuilder sb = new StringBuilder("handler testremove");
            sb.append(C6014b.m23942c());
            C5264a.m21620b(str, sb.toString());
        }
        this.f19344y.removeCallbacks(null);
        C5264a.m21620b(str, "handler testremovenull");
        this.f19330k.clear();
    }

    /* renamed from: h */
    public final C6195a mo29305h() {
        return this.f19331l;
    }

    /* renamed from: h */
    public final boolean mo29306h(String str) {
        return this.f19322c.containsKey(str);
    }

    /* renamed from: i */
    public final SessionStatusEnum mo29307i(String str) {
        return this.f19321b.containsKey(str) ? SessionStatusEnum.IN_SESSION : this.f19330k.containsKey(str) ? SessionStatusEnum.IN_QUEUE : SessionStatusEnum.NONE;
    }

    /* renamed from: i */
    public final boolean mo29308i() {
        ConsultSource consultSource = this.f19323d;
        return consultSource != null && !TextUtils.isEmpty(consultSource.vipStaffid) && !TextUtils.isEmpty(this.f19323d.VIPStaffAvatarUrl);
    }

    /* renamed from: k */
    public final C6051i mo29309k(String str) {
        C6051i iVar = (C6051i) this.f19335p.get(str);
        return iVar == null ? C6051i.f18931a : iVar;
    }

    /* renamed from: l */
    public final C6051i mo29310l(String str) {
        Long l = (Long) this.f19337r.get(str);
        if (l == null) {
            return null;
        }
        return (C6051i) this.f19336q.get(l.longValue());
    }

    /* renamed from: m */
    public final C6042a mo29311m(String str) {
        if (Long.valueOf(mo29295c(str)).longValue() == 0) {
            return null;
        }
        return (C6042a) this.f19338s.get(str);
    }

    /* renamed from: n */
    public final void mo29312n(String str) {
        C6048f fVar = (C6048f) this.f19330k.remove(str);
        if (fVar != null && fVar.f18918e != null) {
            this.f19344y.removeCallbacks(fVar.f18918e);
        }
    }

    /* renamed from: o */
    public final ProductDetail mo29313o(String str) {
        return (ProductDetail) this.f19332m.get(str);
    }

    /* renamed from: p */
    public final List<C6114a> mo29314p(String str) {
        return (List) this.f19333n.get(str);
    }

    /* renamed from: q */
    public final boolean mo29315q(String str) {
        C6055m mVar = (C6055m) this.f19321b.get(str);
        return mVar != null && mVar.f18945g == 1 && mVar.f18946h == 1;
    }

    /* renamed from: r */
    public final Boolean mo29316r(String str) {
        return Boolean.valueOf(this.f19339t.get(str) == null ? false : ((Boolean) this.f19339t.get(str)).booleanValue());
    }
}
