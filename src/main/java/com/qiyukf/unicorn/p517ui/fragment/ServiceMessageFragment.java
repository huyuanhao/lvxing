package com.qiyukf.unicorn.p517ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5411c;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.session.C5490a;
import com.qiyukf.nim.uikit.session.fragment.MessageFragment;
import com.qiyukf.nim.uikit.session.module.input.C5608e;
import com.qiyukf.nim.uikit.session.module.p427a.C5570b;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5922f;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6010b;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.C6029d.C6036a;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.api.customization.input.InputPanelOptions;
import com.qiyukf.unicorn.api.event.UnicornEventBase;
import com.qiyukf.unicorn.api.event.entry.ConnectionStaffResultEntry;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleListener;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleOptions;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.api.pop.OnShopEventListener;
import com.qiyukf.unicorn.api.pop.SessionListEntrance;
import com.qiyukf.unicorn.api.pop.SessionListEntrance.Position;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6043b;
import com.qiyukf.unicorn.p502e.C6048f;
import com.qiyukf.unicorn.p502e.C6055m;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6124f;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6127h;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6128i;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6132m;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6133n;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6146b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6151g;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p514h.C6187d;
import com.qiyukf.unicorn.p514h.C6187d.C6195a;
import com.qiyukf.unicorn.p517ui.activity.LeaveMessageDetailActivity;
import com.qiyukf.unicorn.p517ui.evaluate.C6327c;
import com.qiyukf.unicorn.p517ui.p518a.C6229a;
import com.qiyukf.unicorn.p517ui.p518a.C6229a.C6233a;
import com.qiyukf.unicorn.p517ui.p518a.C6234b;
import com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a;
import com.qiyukf.unicorn.widget.p521a.C6362f;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment */
public class ServiceMessageFragment extends MessageFragment {
    /* renamed from: j */
    private static long f19741j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public int f19742k = 0;
    /* renamed from: l */
    private C6229a f19743l;
    /* renamed from: m */
    private ViewGroup f19744m;
    /* access modifiers changed from: private */
    /* renamed from: n */
    public SessionLifeCycleListener f19745n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public C6327c f19746o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public ConsultSource f19747p;
    /* renamed from: q */
    private SessionLifeCycleOptions f19748q;
    /* access modifiers changed from: private */
    /* renamed from: r */
    public C6043b f19749r;
    /* renamed from: s */
    private boolean f19750s = false;
    /* access modifiers changed from: private */
    /* renamed from: t */
    public boolean f19751t = false;
    /* access modifiers changed from: private */
    /* renamed from: u */
    public boolean f19752u = false;
    /* access modifiers changed from: private */
    /* renamed from: v */
    public boolean f19753v = false;
    /* renamed from: w */
    private C6036a f19754w = new C6036a() {
        /* renamed from: a */
        public final void mo27687a() {
            C6029d.m24047g().mo29281a(ServiceMessageFragment.this.f19747p);
            ServiceMessageFragment.this.m24922a(true);
            ServiceMessageFragment.m24931c(ServiceMessageFragment.this);
            ServiceMessageFragment.m24933d(ServiceMessageFragment.this);
        }
    };
    /* renamed from: x */
    private Observer<CustomNotification> f19755x = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (TextUtils.equals(ServiceMessageFragment.this.f17886g, customNotification.getSessionId()) && customNotification.getSessionType() == SessionTypeEnum.Ysf) {
                ServiceMessageFragment.this.mo29540a(customNotification);
            }
        }
    };
    /* renamed from: y */
    private Observer<StatusCode> f19756y = new Observer<StatusCode>() {
        public final /* synthetic */ void onEvent(Object obj) {
            StatusCode statusCode = (StatusCode) obj;
            if (ServiceMessageFragment.this.f19742k != 7) {
                if (statusCode == StatusCode.LOGINED) {
                    if (ServiceMessageFragment.this.f19751t) {
                        ServiceMessageFragment.m24945o(ServiceMessageFragment.this);
                    } else if (ServiceMessageFragment.this.isResumed() && ServiceMessageFragment.this.f19742k == -1) {
                        ServiceMessageFragment.this.m24923a(0);
                    } else if (ServiceMessageFragment.this.f19742k == -1) {
                        ServiceMessageFragment.this.f19753v = true;
                    }
                } else if (statusCode.shouldReLogin() || statusCode.wontAutoLogin()) {
                    StringBuilder sb = new StringBuilder("test one");
                    sb.append(statusCode);
                    C5264a.m21620b("test", sb.toString());
                    ServiceMessageFragment.this.f19742k = -1;
                    ServiceMessageFragment.this.m24929b((String) null);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.unicorn.ui.fragment.ServiceMessageFragment$9 */
    static /* synthetic */ class C63469 {
        /* renamed from: a */
        static final /* synthetic */ int[] f19782a = new int[C6236a.m24689a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
            int[] r0 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.m24689a()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f19782a = r0
            r0 = 1
            int[] r1 = f19782a     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19432b     // Catch:{ NoSuchFieldError -> 0x0011 }
            int r2 = r2 - r0
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            int[] r1 = f19782a     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19433c     // Catch:{ NoSuchFieldError -> 0x0019 }
            int r2 = r2 - r0
            r3 = 2
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            int[] r1 = f19782a     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19434d     // Catch:{ NoSuchFieldError -> 0x0021 }
            int r2 = r2 - r0
            r3 = 3
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            int[] r1 = f19782a     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19435e     // Catch:{ NoSuchFieldError -> 0x0029 }
            int r2 = r2 - r0
            r3 = 4
            r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            int[] r1 = f19782a     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r2 = com.qiyukf.unicorn.p517ui.p518a.C6234b.C6236a.f19431a     // Catch:{ NoSuchFieldError -> 0x0031 }
            int r2 = r2 - r0
            r0 = 5
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p517ui.fragment.ServiceMessageFragment.C63469.m50627clinit():void");
        }
    }

    /* renamed from: a */
    private void m24916a(final ProductDetail productDetail) {
        this.f19750s = true;
        C6029d.m24047g().mo29286a(this.f17886g, productDetail.clone());
        mo27424a(new Runnable() {
            public final void run() {
                ServiceMessageFragment.m24919a(ServiceMessageFragment.this, productDetail);
            }
        }, 250);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24917a(C6119a aVar) {
        ProductDetail productDetail;
        int a = aVar.mo29075a();
        if (a == 200) {
            this.f19742k = C6029d.m24047g().mo29301f(this.f17886g) == 1 ? 6 : 1;
            if (aVar.mo29096m() != null) {
                this.f19752u = aVar.mo29096m().mo29067j();
            } else {
                this.f19752u = false;
            }
            if (!(this.f19747p.productDetail == null || !this.f19747p.productDetail.valid() || C6029d.m24047g().mo29295c(this.f17886g) == f19741j)) {
                int i = this.f19742k;
                if (i == 1 || (i == 6 && this.f19747p.isSendProductonRobot)) {
                    if (this.f19742k != 6 || !this.f19747p.productDetail.isSendByUser()) {
                        productDetail = this.f19747p.productDetail;
                    } else {
                        productDetail = this.f19747p.productDetail.clone();
                        if (productDetail != null) {
                            productDetail.setSendByUser(false);
                        }
                        f19741j = C6029d.m24047g().mo29295c(this.f17886g);
                    }
                    m24916a(productDetail);
                    f19741j = C6029d.m24047g().mo29295c(this.f17886g);
                }
            }
            if (!TextUtils.isEmpty(this.f19747p.vipStaffid) && !TextUtils.isEmpty(this.f19747p.vipStaffWelcomeMsg) && this.f19742k == 1) {
                ((MsgService) NIMClient.getService(MsgService.class)).sendMessage(MessageBuilder.createTextMessage(this.f17886g, SessionTypeEnum.Ysf, this.f19747p.vipStaffWelcomeMsg), false, false);
            }
        } else {
            int i2 = a == 201 ? 3 : a == 203 ? aVar.mo29100q() ? 10 : 4 : a == 204 ? 5 : a == 205 ? 9 : -1;
            this.f19742k = i2;
        }
        m24927b(aVar);
        m24929b(aVar.mo29085d());
    }

    /* renamed from: a */
    static /* synthetic */ void m24918a(ServiceMessageFragment serviceMessageFragment, long j) {
        final C6362f fVar = new C6362f(serviceMessageFragment.getContext());
        fVar.show();
        final C6146b bVar = new C6146b();
        bVar.mo29179a(j);
        C6185c.m24532a(bVar, serviceMessageFragment.f17886g, false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (ServiceMessageFragment.this.isAdded()) {
                    fVar.cancel();
                    if (i == 200) {
                        ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(ServiceMessageFragment.this.f17886g, SessionTypeEnum.Ysf, bVar), true);
                        return;
                    }
                    fVar.mo29584a();
                    fVar.mo29585a(C6029d.m24039c().getString(C5961R.string.ysf_msg_quit_session_failed));
                    fVar.mo29586b();
                }
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m24919a(ServiceMessageFragment serviceMessageFragment, ProductDetail productDetail) {
        if (productDetail != null) {
            ProductAttachment productAttachment = new ProductAttachment();
            productAttachment.fromProductDetail(productDetail, true);
            if (productAttachment.getShow() == 1 || productAttachment.getSendByUser() == 1) {
                IMMessage createCustomMessage = MessageBuilder.createCustomMessage(serviceMessageFragment.f17886g, SessionTypeEnum.Ysf, productAttachment);
                createCustomMessage.setStatus(MsgStatusEnum.success);
                if (1 == productAttachment.getSendByUser()) {
                    serviceMessageFragment.f17884e.mo27704a(createCustomMessage);
                    return;
                }
                serviceMessageFragment.sendMessage(createCustomMessage, false);
            } else {
                C6185c.m24532a(productAttachment, serviceMessageFragment.f17886g, false);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24921a(ServiceMessageFragment serviceMessageFragment, final boolean z) {
        C6048f b = C6029d.m24047g().mo29291b(serviceMessageFragment.f17886g);
        if (b != null) {
            long j = b.f18914a;
            final C6146b bVar = new C6146b();
            bVar.mo29179a(j);
            C6185c.m24532a(bVar, serviceMessageFragment.f17886g, false).setCallback(new RequestCallbackWrapper<Void>() {
                public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                    if (i == 200) {
                        C6029d.m24047g().mo29312n(ServiceMessageFragment.this.f17886g);
                        ServiceMessageFragment.this.f19742k = 0;
                        ServiceMessageFragment.this.m24929b((String) null);
                        if (!z) {
                            ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(ServiceMessageFragment.this.f17886g, SessionTypeEnum.Ysf, bVar), true);
                        }
                    } else {
                        C5415g.m22161a(C5961R.string.ysf_msg_quit_queue_failed);
                    }
                }
            });
            if (z) {
                SessionLifeCycleListener sessionLifeCycleListener = serviceMessageFragment.f19745n;
                if (sessionLifeCycleListener != null) {
                    sessionLifeCycleListener.onLeaveSession();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24922a(boolean z) {
        FragmentActivity fragmentActivity;
        C6187d dVar;
        C6187d g = C6029d.m24047g();
        if (z) {
            g.mo29283a((C6195a) new C6195a() {
                /* renamed from: a */
                public final void mo29319a() {
                    ServiceMessageFragment.this.f19742k = -1;
                    ServiceMessageFragment.this.m24929b((String) null);
                }

                /* renamed from: a */
                public final void mo29320a(String str) {
                    if (TextUtils.equals(ServiceMessageFragment.this.f17886g, str)) {
                        ServiceMessageFragment.this.f19746o.mo29538b();
                    }
                }

                /* renamed from: a */
                public final void mo29321a(String str, C6043b bVar) {
                    if (TextUtils.equals(ServiceMessageFragment.this.f17886g, str)) {
                        ServiceMessageFragment.this.f19742k = 2;
                        ServiceMessageFragment.this.f19749r = bVar;
                        ServiceMessageFragment.this.m24929b((String) null);
                    }
                }

                /* renamed from: b */
                public final void mo29322b(String str) {
                    if (TextUtils.equals(ServiceMessageFragment.this.f17886g, str)) {
                        if (ServiceMessageFragment.this.f19742k == 1) {
                            ServiceMessageFragment.this.f19752u = true;
                        }
                        ServiceMessageFragment.this.m24930c();
                        ServiceMessageFragment.this.f19746o.mo29538b();
                    }
                }
            });
            dVar = C6029d.m24047g();
            fragmentActivity = getActivity();
        } else {
            fragmentActivity = null;
            g.mo29283a((C6195a) null);
            dVar = C6029d.m24047g();
        }
        dVar.mo29280a((Context) fragmentActivity);
        C6029d.m24047g().mo29288a(this.f17886g, z);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f19755x, z);
        ((AuthServiceObserver) NIMClient.getService(AuthServiceObserver.class)).observeOnlineStatus(this.f19756y, z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
            if (r12 != 3) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0042, code lost:
            if (com.qiyukf.unicorn.C6029d.m24047g().mo29289a(r11.f17886g, false, (com.qiyukf.unicorn.p502e.C6043b) null, r12) != false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[ADDED_TO_REGION] */
    /* renamed from: a */
    public boolean m24923a(int r12) {
        /*
        r11 = this;
        int r0 = r11.f19742k
        r1 = 0
        r2 = 1
        r3 = 7
        r4 = 0
        r5 = 2
        if (r0 != r3) goto L_0x0045
        com.qiyukf.unicorn.api.ConsultSource r6 = r11.f19747p
        long r6 = r6.staffId
        r8 = 0
        int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r10 > 0) goto L_0x001b
        com.qiyukf.unicorn.api.ConsultSource r6 = r11.f19747p
        long r6 = r6.groupId
        int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
        if (r10 <= 0) goto L_0x0061
    L_0x001b:
        com.qiyukf.unicorn.C6029d.m24047g()
        java.lang.String r6 = r11.f17886g
        com.qiyukf.nimlib.sdk.msg.model.IMMessage r6 = com.qiyukf.unicorn.p514h.C6187d.m24552j(r6)
        com.qiyukf.unicorn.api.msg.attachment.MsgAttachment r7 = r6.getAttachment()
        com.qiyukf.unicorn.f.a.d.r r7 = (com.qiyukf.unicorn.p503f.p504a.p510d.C6137r) r7
        r7.mo29158e()
        java.lang.Class<com.qiyukf.nimlib.sdk.msg.MsgService> r7 = com.qiyukf.nimlib.sdk.msg.MsgService.class
        java.lang.Object r7 = com.qiyukf.nimlib.sdk.NIMClient.getService(r7)
        com.qiyukf.nimlib.sdk.msg.MsgService r7 = (com.qiyukf.nimlib.sdk.msg.MsgService) r7
        r7.updateIMMessageStatus(r6, r2)
        com.qiyukf.unicorn.h.d r6 = com.qiyukf.unicorn.C6029d.m24047g()
        java.lang.String r7 = r11.f17886g
        boolean r12 = r6.mo29289a(r7, r4, r1, r12)
        if (r12 == 0) goto L_0x0061
        goto L_0x005f
    L_0x0045:
        com.qiyukf.unicorn.h.d r6 = com.qiyukf.unicorn.C6029d.m24047g()
        java.lang.String r7 = r11.f17886g
        com.qiyukf.unicorn.e.b r8 = r11.f19749r
        if (r8 != 0) goto L_0x0050
        goto L_0x0052
    L_0x0050:
        int r12 = r8.f18898a
    L_0x0052:
        boolean r12 = r6.mo29289a(r7, r4, r8, r12)
        if (r12 == 0) goto L_0x0061
        int r12 = r11.f19742k
        if (r12 == r5) goto L_0x0061
        r6 = 3
        if (r12 == r6) goto L_0x0061
    L_0x005f:
        r11.f19742k = r5
    L_0x0061:
        int r12 = r11.f19742k
        if (r12 == r0) goto L_0x0068
        r11.m24929b(r1)
    L_0x0068:
        int r12 = r11.f19742k
        if (r12 == r5) goto L_0x0070
        if (r12 != r3) goto L_0x006f
        goto L_0x0070
    L_0x006f:
        return r4
    L_0x0070:
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.p517ui.fragment.ServiceMessageFragment.m24923a(int):boolean");
    }

    /* renamed from: b */
    private void m24926b() {
        SpannableStringBuilder spannableStringBuilder;
        String str;
        if (getActivity() != null) {
            C6048f b = C6029d.m24047g().mo29291b(this.f17886g);
            if (b != null && m24935e()) {
                this.f17881b.setVisibility(0);
                TextView textView = this.f17881b;
                if (b == null) {
                    spannableStringBuilder = null;
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    if (b.f18916c) {
                        str = getString(C5961R.string.ysf_service_in_queue, Integer.valueOf(b.f18915b));
                    } else {
                        str = getString(C5961R.string.ysf_service_in_queue_hide_length);
                    }
                    spannableStringBuilder2.append(str);
                    SpannableString spannableString = new SpannableString(getString(C5961R.string.ysf_service_quit_queue));
                    spannableString.setSpan(new ClickableSpan() {
                        public final void onClick(View view) {
                            ServiceMessageFragment.m24921a(ServiceMessageFragment.this, false);
                        }
                    }, 0, spannableString.length(), 33);
                    spannableStringBuilder2.append(" ").append(spannableString);
                    spannableStringBuilder = spannableStringBuilder2;
                }
                textView.setText(spannableStringBuilder);
            }
        }
    }

    /* renamed from: b */
    private void m24927b(C6119a aVar) {
        if (C6029d.m24045e().sdkEvents != null && C6029d.m24045e().sdkEvents.eventProcessFactory != null) {
            UnicornEventBase eventOf = C6029d.m24045e().sdkEvents.eventProcessFactory.eventOf(1);
            if (eventOf != null) {
                ConnectionStaffResultEntry connectionStaffResultEntry = new ConnectionStaffResultEntry();
                if (aVar.mo29075a() == 200) {
                    connectionStaffResultEntry.setStaffType(aVar.mo29091h() == 1 ? 0 : 1);
                    connectionStaffResultEntry.setConnectResult(0);
                    if (this.f19742k == 1) {
                        if (!TextUtils.isEmpty(this.f19747p.vipStaffid)) {
                            connectionStaffResultEntry.setVipStaffid(this.f19747p.vipStaffid);
                        }
                        if (!TextUtils.isEmpty(this.f19747p.VIPStaffAvatarUrl)) {
                            connectionStaffResultEntry.setVIPStaffAvatarUrl(this.f19747p.VIPStaffAvatarUrl);
                        }
                        if (!TextUtils.isEmpty(this.f19747p.vipStaffName)) {
                            connectionStaffResultEntry.setVipStaffName(this.f19747p.vipStaffName.length() > 40 ? this.f19747p.vipStaffName.substring(0, 40) : this.f19747p.vipStaffName);
                        }
                    }
                    connectionStaffResultEntry.setStaffId(aVar.mo29080b());
                    connectionStaffResultEntry.setStaffIconUrl(aVar.mo29093j());
                    connectionStaffResultEntry.setStaffName(aVar.mo29083c());
                    connectionStaffResultEntry.setGroupId(aVar.mo29095l());
                    connectionStaffResultEntry.setCode(aVar.mo29075a());
                } else {
                    connectionStaffResultEntry.setCode(aVar.mo29075a());
                    connectionStaffResultEntry.setConnectResult(1);
                    if (C5411c.m22135b(getContext())) {
                        connectionStaffResultEntry.setErrorType(1);
                    } else {
                        connectionStaffResultEntry.setErrorType(0);
                    }
                }
                eventOf.onEvent(connectionStaffResultEntry, getContext(), null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m24929b(final String str) {
        C5608e eVar;
        List list;
        TextView textView;
        int i;
        if (getActivity() != null) {
            getActivity().setTitle(getArguments().getString("title"));
            this.f17881b.setMovementMethod(LinkMovementMethod.getInstance());
            this.f17881b.setOnClickListener(null);
            this.f17881b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            int i2 = this.f19742k;
            if (i2 == 2) {
                this.f17881b.setVisibility(8);
                getActivity().setTitle(C5961R.string.ysf_requesting_staff);
            } else if (i2 == 3 || i2 == 9) {
                this.f17881b.setVisibility(0);
                this.f17881b.setMovementMethod(null);
                this.f17881b.setCompoundDrawablesWithIntrinsicBounds(0, 0, C5961R.C5962drawable.ysf_ic_leave_message_arrow, 0);
                this.f17881b.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        C5409b.m22130a((Activity) ServiceMessageFragment.this.getActivity());
                        LeaveMessageDetailActivity.start(ServiceMessageFragment.this.getContext(), str);
                        ServiceMessageFragment.this.getActivity().overridePendingTransition(C5961R.anim.ysf_anim_popup_in, 0);
                    }
                });
                int i3 = this.f19742k == 3 ? C5961R.string.ysf_no_staff : C5961R.string.ysf_no_staff_disabled;
                TextView textView2 = this.f17881b;
                if (TextUtils.isEmpty(str)) {
                    str = getString(i3);
                }
                textView2.setText(str);
            } else {
                if (i2 == -1) {
                    this.f17881b.setVisibility(0);
                    if (C5411c.m22135b(getContext())) {
                        TextView textView3 = this.f17881b;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getString(C5961R.string.ysf_some_error_happened));
                        SpannableString spannableString = new SpannableString(getString(C5961R.string.ysf_retry_connect));
                        spannableString.setSpan(new ClickableSpan() {
                            public final void onClick(View view) {
                                ServiceMessageFragment.this.m24923a(4);
                            }
                        }, 0, spannableString.length(), 33);
                        spannableStringBuilder.append(spannableString);
                        textView3.setText(spannableStringBuilder);
                    } else {
                        textView = this.f17881b;
                        i = C5961R.string.ysf_network_error;
                    }
                } else if (m24935e()) {
                    m24926b();
                } else if (this.f19742k == 5) {
                    this.f17881b.setVisibility(0);
                    textView = this.f17881b;
                    i = C5961R.string.ysf_service_product_invalid;
                } else {
                    this.f17881b.setVisibility(8);
                }
                textView.setText(i);
            }
            m24930c();
            if (this.f19742k != 2) {
                this.f17883d.mo27775b(this.f19742k == 9);
                C5608e eVar2 = this.f17883d;
                int i4 = this.f19742k;
                boolean z = i4 == 6 || i4 == 10;
                eVar2.mo27772a(z);
                C5570b bVar = this.f17884e;
                int i5 = this.f19742k;
                boolean z2 = i5 == 6 || i5 == 10;
                bVar.mo27707a(z2);
            }
            int i6 = this.f19742k;
            if (i6 == 6 || i6 == 10) {
                eVar = this.f17883d;
                list = C6029d.m24047g().mo29314p(this.f17886g);
            } else if (i6 == 1 || i6 == 3) {
                eVar = this.f17883d;
                list = this.f19747p.quickEntryList;
            } else {
                this.f17883d.mo27774b(null);
                C6327c cVar = this.f19746o;
                int i7 = this.f19742k;
                boolean z3 = i7 != 1 || i7 == 0 || i7 == 8;
                cVar.mo29537a(z3);
                if (!this.f19750s && this.f19747p.productDetail != null && this.f19747p.productDetail.valid() && this.f19747p.productDetail.isAlwaysSend() && (!this.f19747p.productDetail.equals(C6029d.m24047g().mo29313o(this.f17886g)) || this.f19747p.productDetail.isSendByUser())) {
                    int i8 = this.f19742k;
                    if (i8 == 1 || (i8 == 6 && this.f19747p.isSendProductonRobot)) {
                        if (this.f19742k == 6 || !this.f19747p.productDetail.isSendByUser()) {
                            m24916a(this.f19747p.productDetail);
                        } else {
                            ProductDetail clone = this.f19747p.productDetail.clone();
                            if (clone != null) {
                                clone.setSendByUser(false);
                                m24916a(clone);
                            }
                            return;
                        }
                    }
                }
            }
            eVar.mo27774b(list);
            C6327c cVar2 = this.f19746o;
            int i72 = this.f19742k;
            if (i72 != 1) {
            }
            cVar2.mo29537a(z3);
            int i82 = this.f19742k;
            if (this.f19742k == 6) {
            }
            m24916a(this.f19747p.productDetail);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24930c() {
        C6234b bVar;
        ArrayList arrayList = new ArrayList();
        if (this.f19747p.shopEntrance != null) {
            arrayList.add(new C6234b(C6236a.f19432b, this.f19747p.shopEntrance.getName(), this.f19747p.shopEntrance.getLogo(), true));
        }
        int i = this.f19742k;
        if ((i == 1 || i == 0 || i == 8) && C6010b.m23913a().mo28845b() == null && this.f19752u) {
            arrayList.add(new C6234b(C6236a.f19434d));
        }
        boolean z = this.f19742k == 6 && C6029d.m24047g().mo29315q(this.f17886g);
        if (z) {
            arrayList.add(new C6234b(C6236a.f19433c));
        }
        if (this.f19742k == 1 && this.f19748q.canCloseSession()) {
            bVar = new C6234b(C6236a.f19435e, true);
        } else if (!m24935e() || !this.f19748q.canQuitQueue()) {
            if (this.f19742k == 8 && this.f19748q.canCloseSession()) {
                bVar = new C6234b(C6236a.f19435e, false);
            }
            this.f19743l.mo29418a((List<C6234b>) arrayList);
        } else {
            bVar = new C6234b(C6236a.f19435e, true);
        }
        arrayList.add(bVar);
        this.f19743l.mo29418a((List<C6234b>) arrayList);
    }

    /* renamed from: c */
    static /* synthetic */ void m24931c(ServiceMessageFragment serviceMessageFragment) {
        int i;
        C6187d g = C6029d.m24047g();
        if (C6187d.m24552j(serviceMessageFragment.f17886g) != null) {
            i = 7;
        } else if (g.mo29277a(serviceMessageFragment.f17886g) > 0) {
            i = g.mo29291b(serviceMessageFragment.f17886g).f18919f ? 10 : 4;
        } else if (g.mo29306h(serviceMessageFragment.f17886g)) {
            i = 2;
        } else if (g.mo29301f(serviceMessageFragment.f17886g) == 1) {
            i = 6;
        } else {
            if (g.mo29295c(serviceMessageFragment.f17886g) > 0) {
                serviceMessageFragment.f19742k = 1;
            }
            serviceMessageFragment.m24929b((String) null);
        }
        serviceMessageFragment.f19742k = i;
        serviceMessageFragment.m24929b((String) null);
    }

    /* renamed from: d */
    private void m24932d() {
        String[] split;
        String p = C6014b.m23976p();
        if (!TextUtils.isEmpty(p)) {
            C6014b.m23977p(null);
            for (final String str : TextUtils.split(p, StorageInterface.KEY_SPLITER)) {
                C6185c.m24532a(new C6151g(str, 2), this.f17886g, false).setCallback(new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i != 200) {
                            C6014b.m23977p(str);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m24933d(ServiceMessageFragment serviceMessageFragment) {
        boolean z = true;
        ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
        if (!C6029d.m24026a().mo28873i()) {
            serviceMessageFragment.f19751t = true;
            serviceMessageFragment.f19742k = 2;
            serviceMessageFragment.m24929b((String) null);
            return;
        }
        serviceMessageFragment.m24932d();
        if (C6029d.m24048h().mo28848a(serviceMessageFragment.f17886g) > 0) {
            z = false;
        }
        C6055m d = C6029d.m24047g().mo29297d(serviceMessageFragment.f17886g);
        if (d != null) {
            C6119a aVar = new C6119a();
            aVar.mo29077a(200);
            aVar.mo29081b(d.f18945g);
            aVar.mo29084c(d.f18942d);
            aVar.mo29088e(d.f18947i);
            aVar.mo29086d(d.f18943e);
            aVar.mo29078a(d.f18941c);
            serviceMessageFragment.m24927b(aVar);
        }
        if (z) {
            serviceMessageFragment.m24923a(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m24935e() {
        int i = this.f19742k;
        return i == 4 || i == 10;
    }

    /* renamed from: o */
    static /* synthetic */ void m24945o(ServiceMessageFragment serviceMessageFragment) {
        serviceMessageFragment.f19751t = false;
        if (TextUtils.isEmpty(serviceMessageFragment.f17886g)) {
            serviceMessageFragment.mo27681a(C6014b.m23942c());
            serviceMessageFragment.f19746o.mo29536a(serviceMessageFragment.f17886g);
            C6029d.m24047g().mo29296c().mo29266a((Fragment) serviceMessageFragment, serviceMessageFragment.f17886g);
            Bundle arguments = serviceMessageFragment.getArguments();
            if (arguments != null) {
                arguments.putString("account", serviceMessageFragment.f17886g);
            }
        }
        serviceMessageFragment.mo27680a();
        C6187d g = C6029d.m24047g();
        String str = serviceMessageFragment.f17886g;
        C6043b bVar = serviceMessageFragment.f19749r;
        g.mo29289a(str, false, bVar, bVar == null ? 0 : bVar.f18898a);
    }

    /* renamed from: s */
    static /* synthetic */ void m24949s(ServiceMessageFragment serviceMessageFragment) {
        if (serviceMessageFragment.f19742k == 1 || serviceMessageFragment.m24935e()) {
            final boolean e = serviceMessageFragment.m24935e();
            C6364g.m25005a(serviceMessageFragment.getContext(), serviceMessageFragment.getString(e ? C5961R.string.ysf_dialog_quit_queue : C5961R.string.ysf_dialog_close_session), true, (C6365a) new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    if (i == 0) {
                        if (!e && ServiceMessageFragment.this.f19742k == 1) {
                            ServiceMessageFragment.m24918a(ServiceMessageFragment.this, C6029d.m24047g().mo29295c(ServiceMessageFragment.this.f17886g));
                        } else if (e && ServiceMessageFragment.this.m24935e()) {
                            ServiceMessageFragment.m24921a(ServiceMessageFragment.this, true);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo29540a(CustomNotification customNotification) {
        C6144e attachment = customNotification.getAttachment();
        if (attachment != null) {
            int cmdId = attachment.getCmdId();
            if (cmdId == 2) {
                final C6119a aVar = (C6119a) attachment;
                if (aVar.mo29075a() == 200) {
                    m24917a(aVar);
                } else {
                    mo27424a(new Runnable() {
                        public final void run() {
                            ServiceMessageFragment.this.m24917a(aVar);
                        }
                    }, 1000);
                }
                this.f19749r = null;
            } else if (cmdId == 6) {
                this.f19742k = 8;
                if (((C6133n) attachment).mo29139b() != 1) {
                    this.f19746o.mo29539c();
                }
                m24929b((String) null);
            } else if (cmdId == 15) {
                C6128i iVar = (C6128i) attachment;
                if (this.f19742k != 1) {
                    int b = iVar.mo29117b();
                    if (b == 200) {
                        m24926b();
                    } else if (b == 301) {
                        this.f19742k = 1;
                        m24929b((String) null);
                    } else if (b == 302) {
                        this.f19742k = 3;
                        m24929b(iVar.mo29119d());
                    } else if (b == 303) {
                        this.f19742k = 9;
                        m24929b(iVar.mo29119d());
                    } else {
                        this.f19742k = -1;
                        m24929b((String) null);
                    }
                }
            } else if (cmdId == 25) {
                this.f17883d.mo27771a((C6124f) attachment);
            } else if (cmdId == 28) {
                C6127h hVar = (C6127h) attachment;
                C5912a a = C5922f.m23740a(hVar.mo29115b());
                if (a != null) {
                    ((MsgService) NIMClient.getService(MsgService.class)).deleteChattingHistory(a);
                    this.f17884e.mo27709b((IMMessage) a);
                    UserInfo userInfo = C5718b.m23017d().userInfoProvider.getUserInfo(a.getFromAccount());
                    hVar.mo29114a(getString(C5961R.string.ysf_staff_withdrawal_str, userInfo.getName()));
                    ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomMessage(this.f17886g, SessionTypeEnum.Ysf, hVar), true);
                }
            } else if (cmdId == 90) {
                this.f19742k = 7;
                m24929b((String) null);
            } else if (cmdId == 211) {
                C6132m mVar = (C6132m) attachment;
                if (!(mVar.mo29137a() == null || mVar.mo29137a().size() == 0)) {
                    C6029d.m24047g().mo29287a(this.f17886g, mVar.mo29137a());
                }
                this.f17883d.mo27774b(mVar.mo29137a());
            }
        }
    }

    public boolean isAllowSendMessage(boolean z) {
        if (C6029d.m24038b()) {
            int i = this.f19742k;
            if (i == 1 || i == 6 || i == 3 || m24935e()) {
                return true;
            }
            if (!z) {
                return false;
            }
            if (!m24923a(0)) {
                return super.isAllowSendMessage(z);
            }
        }
        C5415g.m22161a(C5961R.string.ysf_send_message_disallow_as_requesting);
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f19747p = (ConsultSource) getArguments().getSerializable(ArgKey.KEY_SOURCE);
        if (this.f19747p == null) {
            this.f19747p = new ConsultSource(null, null, null);
        }
        this.f19748q = this.f19747p.sessionLifeCycleOptions == null ? new SessionLifeCycleOptions() : this.f19747p.sessionLifeCycleOptions;
        this.f19743l = new C6229a(this.f19744m);
        this.f19752u = C6029d.m24047g().mo29316r(this.f17886g).booleanValue();
        this.f19746o = new C6327c(this, this.f17886g);
        if (this.f19744m != null) {
            this.f19743l.mo29415a(C6029d.m24045e().uiCustomization);
            this.f19743l.mo29417a(this.f19746o);
            this.f19743l.mo29416a((C6233a) new C6233a() {
                /* renamed from: a */
                public final void mo29422a(C6234b bVar) {
                    int i = C63469.f19782a[bVar.mo29423a() - 1];
                    if (i == 1) {
                        OnShopEventListener onShopEventListener = C6029d.m24045e().onShopEventListener;
                        if (onShopEventListener != null) {
                            onShopEventListener.onShopEntranceClick(ServiceMessageFragment.this.getContext(), ServiceMessageFragment.this.f17886g);
                        }
                    } else if (i == 2) {
                        C6029d.m24047g().mo29289a(ServiceMessageFragment.this.f17886g, true, (C6043b) null, 5);
                    } else if (i == 3) {
                        ServiceMessageFragment.this.f19746o.mo29534a();
                    } else if (i == 4) {
                        ServiceMessageFragment.m24949s(ServiceMessageFragment.this);
                    } else if (i == 5) {
                        C5409b.m22130a((Activity) ServiceMessageFragment.this.getActivity());
                    }
                }
            });
        }
        if (this.f19747p.sessionListEntrance != null) {
            SessionListEntrance sessionListEntrance = this.f19747p.sessionListEntrance;
            ImageView imageView = (ImageView) this.f17880a.findViewById(C5961R.C5963id.ysf_session_list_entrance);
            imageView.setVisibility(0);
            Position position = sessionListEntrance.getPosition();
            int imageResId = sessionListEntrance.getImageResId();
            if (position == null) {
                position = Position.TOP_RIGHT;
            }
            if (imageResId <= 0) {
                imageResId = position == Position.TOP_RIGHT ? C5961R.C5962drawable.ysf_session_list_entrance_right : C5961R.C5962drawable.ysf_session_list_entrance_left;
            }
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.gravity = position == Position.TOP_RIGHT ? GravityCompat.END : GravityCompat.START;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(imageResId);
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    OnShopEventListener onShopEventListener = C6029d.m24045e().onShopEventListener;
                    if (onShopEventListener != null) {
                        onShopEventListener.onSessionListEntranceClick(ServiceMessageFragment.this.getContext());
                    }
                }
            });
        }
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.topTipBarBackgroundColor != 0) {
                this.f17881b.setBackgroundColor(uICustomization.topTipBarBackgroundColor);
            }
            if (uICustomization.topTipBarTextColor != 0) {
                this.f17881b.setTextColor(uICustomization.topTipBarTextColor);
            }
            if (uICustomization.topTipBarTextSize > 0.0f) {
                this.f17881b.setTextSize(uICustomization.topTipBarTextSize);
            }
        }
        YSFOptions e = C6029d.m24045e();
        if (!(e == null || e.imPageViewConfig == null || e.imPageViewConfig.adViewProvider == null)) {
            this.f17882c.removeAllViews();
            this.f17882c.addView(e.imPageViewConfig.adViewProvider.getAdview(getContext()));
        }
        if (C6029d.m24038b()) {
            this.f19754w.mo27687a();
            return;
        }
        this.f19742k = 2;
        getActivity().setTitle(C5961R.string.ysf_requesting_staff);
        C6029d.m24031a(this.f19754w);
    }

    public boolean onBackPressed() {
        if (!m24935e() || !this.f19748q.canQuitQueue()) {
            return false;
        }
        String quitQueuePrompt = this.f19748q.getQuitQueuePrompt();
        if (TextUtils.isEmpty(quitQueuePrompt)) {
            quitQueuePrompt = getString(C5961R.string.ysf_dialog_message_queue);
        }
        C6364g.m25003a(getContext(), (CharSequence) quitQueuePrompt, (CharSequence[]) getResources().getStringArray(C5961R.array.ysf_dialog_items_queue), (C6365a) new C6365a() {
            /* renamed from: a */
            public final void mo27603a(int i) {
                if (i != 0) {
                    if (i == 1 && ServiceMessageFragment.this.m24935e()) {
                        ServiceMessageFragment.m24921a(ServiceMessageFragment.this, true);
                    }
                } else if (ServiceMessageFragment.this.f19745n != null) {
                    ServiceMessageFragment.this.f19745n.onLeaveSession();
                }
            }
        });
        return true;
    }

    public void onDestroy() {
        C5426a.m22175a();
        C6029d.m24047g().mo29296c().mo29271b();
        C6029d.m24047g().mo29294b(this.f17886g, false);
        this.f19747p = null;
        if (C6029d.m24038b()) {
            m24922a(false);
            C6029d.m24047g().mo29281a((ConsultSource) null);
            this.f19747p = null;
        }
        C6029d.m24037b(this.f19754w);
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        try {
            C6029d.m24047g().mo29296c().mo29263a();
            C6029d.m24047g().mo29294b(this.f17886g, false);
        } catch (NullPointerException e) {
            C5264a.m21621b("NullPointerException", "邀请评价发生异常", e);
        }
    }

    public void onReceiveMessage(List<IMMessage> list) {
        IMMessage iMMessage = (IMMessage) list.get(0);
        boolean z = iMMessage.getSessionType() == SessionTypeEnum.Ysf && TextUtils.equals(this.f17886g, iMMessage.getSessionId());
        if (z) {
            ConsultSource consultSource = this.f19747p;
            if (consultSource != null && !TextUtils.isEmpty(consultSource.prompt) && !TextUtils.isEmpty(this.f19747p.vipStaffid) && !TextUtils.isEmpty(this.f19747p.VIPStaffAvatarUrl) && this.f19742k == 1) {
                for (IMMessage iMMessage2 : list) {
                    if (iMMessage2.getAttachment() instanceof C6119a) {
                        C6119a aVar = (C6119a) iMMessage2.getAttachment();
                        aVar.mo29102s();
                        aVar.mo29082b(this.f19747p.prompt.length() > 100 ? this.f19747p.prompt.substring(0, 100) : this.f19747p.prompt);
                    }
                    iMMessage2.setFromAccount(this.f19747p.vipStaffid);
                    ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(iMMessage2, true);
                }
            }
            m24932d();
            if (C6014b.m23962i(this.f17886g) != -1) {
                this.f19746o.mo29538b();
            }
        }
    }

    public void onResume() {
        super.onResume();
        try {
            C6029d.m24047g().mo29296c().mo29266a((Fragment) this, this.f17886g);
            C6029d.m24047g().mo29294b(this.f17886g, true);
        } catch (NullPointerException e) {
            C5264a.m21621b("NullPointerException", "邀请评价发生异常", e);
        }
        if (this.f19753v) {
            this.f19753v = false;
            m24923a(100);
        }
    }

    public void setArguments(String str, ConsultSource consultSource, ViewGroup viewGroup) {
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            setArguments(arguments);
        }
        this.f19744m = viewGroup;
        arguments.putString("title", str);
        if (consultSource != null) {
            arguments.putSerializable(ArgKey.KEY_SOURCE, consultSource);
            if (!TextUtils.isEmpty(consultSource.shopId)) {
                arguments.putString("account", consultSource.shopId.toLowerCase());
            }
            if (consultSource.sessionLifeCycleOptions != null) {
                this.f19745n = consultSource.sessionLifeCycleOptions.getSessionLifeCycleListener();
            }
        }
        arguments.putSerializable("type", SessionTypeEnum.Ysf);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        InputPanelOptions inputPanelOptions = C6029d.m24045e().inputPanelOptions;
        C5490a aVar = new C5490a();
        if (uICustomization != null) {
            aVar.f17680a = uICustomization.msgBackgroundUri;
            aVar.f17681b = uICustomization.msgBackgroundColor;
        }
        if (inputPanelOptions != null) {
            if (inputPanelOptions.emojiIconResId != 0) {
                aVar.f17684e = inputPanelOptions.emojiIconResId;
            }
            if (inputPanelOptions.photoIconResId != 0) {
                aVar.f17685f = inputPanelOptions.photoIconResId;
            }
            if (inputPanelOptions.voiceIconResId != 0) {
                aVar.f17683d = inputPanelOptions.voiceIconResId;
            }
            if (inputPanelOptions.moreIconResId != 0) {
                aVar.f17686g = inputPanelOptions.moreIconResId;
            }
            aVar.f17687h = inputPanelOptions.showActionPanel;
            if (inputPanelOptions.showActionPanel && inputPanelOptions.actionPanelOptions != null) {
                aVar.f17682c = inputPanelOptions.actionPanelOptions.backgroundColor;
            }
        }
        if (uICustomization != null || inputPanelOptions != null) {
            arguments.putSerializable("customization", aVar);
        }
    }
}
