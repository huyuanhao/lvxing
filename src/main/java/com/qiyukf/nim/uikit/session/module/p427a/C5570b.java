package com.qiyukf.nim.uikit.session.module.p427a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p412c.p416c.C5406d;
import com.qiyukf.basesdk.p412c.p417d.C5408a;
import com.qiyukf.basesdk.p412c.p417d.C5409b;
import com.qiyukf.basesdk.p412c.p417d.C5412d;
import com.qiyukf.basesdk.p412c.p417d.C5415g;
import com.qiyukf.nim.uikit.C5426a;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.p419a.C5438e;
import com.qiyukf.nim.uikit.common.p419a.C5439f;
import com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5481a;
import com.qiyukf.nim.uikit.common.p424ui.listview.AutoRefreshListView.C5482b;
import com.qiyukf.nim.uikit.common.p424ui.listview.C5487a;
import com.qiyukf.nim.uikit.common.p424ui.listview.MessageListView;
import com.qiyukf.nim.uikit.common.p424ui.listview.MessageListView.C5486b;
import com.qiyukf.nim.uikit.p418a.C5430a;
import com.qiyukf.nim.uikit.p418a.C5431b.C5432a;
import com.qiyukf.nim.uikit.session.helper.C5557c;
import com.qiyukf.nim.uikit.session.helper.C5557c.C5562a;
import com.qiyukf.nim.uikit.session.helper.C5563d;
import com.qiyukf.nim.uikit.session.helper.C5563d.C5564a;
import com.qiyukf.nim.uikit.session.module.C5567a;
import com.qiyukf.nim.uikit.session.module.p427a.C5588c.C5590a;
import com.qiyukf.nim.uikit.session.viewholder.C5622b;
import com.qiyukf.nim.uikit.session.viewholder.C5629c;
import com.qiyukf.nimlib.C5718b;
import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.C6015c;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p502e.C6048f;
import com.qiyukf.unicorn.p503f.p504a.C6113c;
import com.qiyukf.unicorn.p503f.p504a.C6144e;
import com.qiyukf.unicorn.p503f.p504a.p505a.p506a.C6084f;
import com.qiyukf.unicorn.p503f.p504a.p510d.C6119a;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6146b;
import com.qiyukf.unicorn.p503f.p504a.p511e.C6160p;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p514h.C6187d;
import com.qiyukf.unicorn.p517ui.fragment.TranslateFragment;
import com.qiyukf.unicorn.p517ui.p519b.p520a.C6265h;
import com.qiyukf.unicorn.widget.p521a.C6364g;
import com.qiyukf.unicorn.widget.p521a.C6364g.C6365a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.module.a.b */
public final class C5570b implements C5438e {
    /* renamed from: a */
    public volatile boolean f17933a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean f17934b;
    /* access modifiers changed from: private */
    /* renamed from: c */
    public C5567a f17935c;
    /* renamed from: d */
    private View f17936d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public MessageListView f17937e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public List<IMMessage> f17938f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C5588c f17939g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public ImageView f17940h;
    /* renamed from: i */
    private C5568a f17941i;
    /* renamed from: j */
    private Handler f17942j;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public View f17943k;
    /* renamed from: l */
    private TextView f17944l;
    /* renamed from: m */
    private ImageView f17945m;
    /* renamed from: n */
    private boolean f17946n;
    /* renamed from: o */
    private boolean f17947o;
    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean f17948p;
    /* renamed from: q */
    private boolean f17949q;
    /* renamed from: r */
    private int f17950r;
    /* access modifiers changed from: private */
    /* renamed from: s */
    public C5564a f17951s;
    /* renamed from: t */
    private Observer<CustomNotification> f17952t;
    /* renamed from: u */
    private C5562a f17953u;
    /* renamed from: v */
    private Observer<IMMessage> f17954v;
    /* renamed from: w */
    private Observer<AttachmentProgress> f17955w;
    /* renamed from: x */
    private C5432a f17956x;
    /* renamed from: y */
    private Runnable f17957y;

    /* renamed from: com.qiyukf.nim.uikit.session.module.a.b$a */
    private class C5582a implements C5482b {
        /* renamed from: b */
        private QueryDirectionEnum f17972b = null;
        /* renamed from: c */
        private IMMessage f17973c = null;
        /* renamed from: d */
        private boolean f17974d;
        /* renamed from: e */
        private boolean f17975e = true;
        /* renamed from: f */
        private RequestCallback<List<IMMessage>> f17976f = new RequestCallbackWrapper<List<IMMessage>>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                List list = (List) obj;
                if (list != null) {
                    C5582a aVar = C5582a.this;
                    C6015c h = C6029d.m24048h();
                    boolean z = false;
                    int a = h == null ? 0 : h.mo28848a(C5570b.this.f17935c.f17922c);
                    C6048f b = C6029d.m24047g().mo29291b(C5570b.this.f17935c.f17922c);
                    C6029d.m24047g();
                    if (C6187d.m24552j(C5570b.this.f17935c.f17922c) != null || C6029d.m24045e().isDefaultLoadMsg || a > 0 || C5570b.this.f17933a || ((b != null && b.f18916c) || ((C6029d.m24047g().mo29295c(C5570b.this.f17935c.f17922c) != 0 && C6014b.m23981r(C5570b.this.f17935c.f17922c) == C6029d.m24047g().mo29295c(C5570b.this.f17935c.f17922c)) || !C5570b.this.f17934b))) {
                        if (a > 0) {
                            C6014b.m23944c(C5570b.this.f17935c.f17922c, C6029d.m24047g().mo29295c(C5570b.this.f17935c.f17922c));
                        }
                        z = true;
                    }
                    C5582a aVar2 = C5582a.this;
                    if (z) {
                        if (!C5570b.this.f17933a && !C5570b.this.f17934b && !C6029d.m24045e().isDefaultLoadMsg && list.size() != 0) {
                            C6146b bVar = new C6146b();
                            bVar.mo29180a("以上为历史消息");
                            IMMessage createCustomMessage = MessageBuilder.createCustomMessage(C5718b.m23015b(), SessionTypeEnum.Ysf, bVar);
                            createCustomMessage.setStatus(MsgStatusEnum.success);
                            list.add(createCustomMessage);
                        }
                        C5570b.this.f17933a = true;
                        C5582a.m22639a(C5582a.this, list);
                        return;
                    }
                    C5582a.m22639a(aVar2, (List) new ArrayList());
                }
            }
        };

        public C5582a(boolean z) {
            this.f17974d = z;
            if (z) {
                m22641b();
            } else {
                m22640a(QueryDirectionEnum.QUERY_OLD, 0);
            }
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.qiyukf.nimlib.sdk.msg.model.IMMessage>, for r7v0, types: [java.util.List, java.util.Collection, java.util.List<com.qiyukf.nimlib.sdk.msg.model.IMMessage>] */
        /* renamed from: a */
        static /* synthetic */ void m22639a(com.qiyukf.nim.uikit.session.module.p427a.C5570b.C5582a r6, java.util.List<com.qiyukf.nimlib.sdk.msg.model.IMMessage> r7) {
            /*
            int r0 = r7.size()
            boolean r1 = r6.f17974d
            if (r1 == 0) goto L_0x000b
            java.util.Collections.reverse(r7)
        L_0x000b:
            boolean r1 = r6.f17975e
            if (r1 == 0) goto L_0x0051
            com.qiyukf.nim.uikit.session.module.a.b r1 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r1 = r1.f17938f
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0051
            java.util.Iterator r1 = r7.iterator()
        L_0x001f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0051
            java.lang.Object r2 = r1.next()
            com.qiyukf.nimlib.sdk.msg.model.IMMessage r2 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r2
            com.qiyukf.nim.uikit.session.module.a.b r3 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r3 = r3.f17938f
            java.util.Iterator r3 = r3.iterator()
        L_0x0035:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x001f
            java.lang.Object r4 = r3.next()
            com.qiyukf.nimlib.sdk.msg.model.IMMessage r4 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r4
            boolean r5 = r4.isTheSame(r2)
            if (r5 == 0) goto L_0x0035
            com.qiyukf.nim.uikit.session.module.a.b r2 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r2 = r2.f17938f
            r2.remove(r4)
            goto L_0x001f
        L_0x0051:
            boolean r1 = r6.f17975e
            if (r1 == 0) goto L_0x0064
            com.qiyukf.nimlib.sdk.msg.model.IMMessage r1 = r6.f17973c
            if (r1 == 0) goto L_0x0064
            com.qiyukf.nim.uikit.session.module.a.b r1 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r1 = r1.f17938f
            com.qiyukf.nimlib.sdk.msg.model.IMMessage r2 = r6.f17973c
            r1.add(r2)
        L_0x0064:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.addAll(r7)
            com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum r7 = r6.f17972b
            com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum r2 = com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum.QUERY_NEW
            r3 = 0
            if (r7 != r2) goto L_0x007d
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r7 = r7.f17938f
            r7.addAll(r1)
            goto L_0x0086
        L_0x007d:
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r7 = r7.f17938f
            r7.addAll(r3, r1)
        L_0x0086:
            boolean r7 = r6.f17975e
            if (r7 == 0) goto L_0x0093
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            com.qiyukf.nim.uikit.common.ui.listview.MessageListView r7 = r7.f17937e
            com.qiyukf.nim.uikit.common.p424ui.listview.C5487a.m22377a(r7)
        L_0x0093:
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            com.qiyukf.nim.uikit.session.module.a.c r7 = r7.f17939g
            com.qiyukf.nim.uikit.session.module.a.b r1 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            java.util.List r1 = r1.f17938f
            r2 = 1
            boolean r4 = r6.f17975e
            r7.mo27731a(r1, r2, r4)
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            r7.mo27711d()
            com.qiyukf.nim.uikit.session.module.a.b r7 = com.qiyukf.nim.uikit.session.module.p427a.C5570b.this
            com.qiyukf.nim.uikit.common.ui.listview.MessageListView r7 = r7.f17937e
            r7.mo27568c(r0)
            r6.f17975e = r3
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.p427a.C5570b.C5582a.m22639a(com.qiyukf.nim.uikit.session.module.a.b$a, java.util.List):void");
        }

        /* renamed from: a */
        private void m22640a(QueryDirectionEnum queryDirectionEnum, int i) {
            C5570b.this.f17934b = i == 0;
            this.f17972b = queryDirectionEnum;
            C5570b.this.f17937e.mo27567b(queryDirectionEnum == QueryDirectionEnum.QUERY_NEW ? C5481a.f17663b : C5481a.f17662a);
            ((MsgService) NIMClient.getService(MsgService.class)).queryMessageListEx(m22642c(), queryDirectionEnum, 20, true).setCallback(this.f17976f);
        }

        /* renamed from: b */
        private void m22641b() {
            this.f17972b = QueryDirectionEnum.QUERY_OLD;
            ((MsgService) NIMClient.getService(MsgService.class)).pullMessageHistory(m22642c(), 20, true).setCallback(this.f17976f);
        }

        /* renamed from: c */
        private IMMessage m22642c() {
            if (C5570b.this.f17938f.size() == 0) {
                IMMessage iMMessage = this.f17973c;
                if (iMMessage == null) {
                    iMMessage = MessageBuilder.createEmptyMessage(C5570b.this.f17935c.f17922c, C5570b.this.f17935c.f17923d, 0);
                }
                return iMMessage;
            }
            return (IMMessage) C5570b.this.f17938f.get(this.f17972b == QueryDirectionEnum.QUERY_NEW ? C5570b.this.f17938f.size() - 1 : 0);
        }

        /* renamed from: a */
        public final void mo27575a() {
            if (!this.f17974d) {
                m22640a(QueryDirectionEnum.QUERY_NEW, 0);
            }
        }

        /* renamed from: a */
        public final void mo27576a(int i) {
            if (this.f17974d) {
                m22641b();
            } else {
                m22640a(QueryDirectionEnum.QUERY_OLD, i);
            }
        }
    }

    /* renamed from: com.qiyukf.nim.uikit.session.module.a.b$b */
    private class C5584b implements C5590a {
        private C5584b() {
        }

        /* synthetic */ C5584b(C5570b bVar, byte b) {
            this();
        }

        /* renamed from: d */
        private void m22646d(final IMMessage iMMessage) {
            C6364g.m25005a((Context) C5570b.this.f17935c.f17920a, C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_re_download_message), true, (C6365a) new C6365a() {
                /* renamed from: a */
                public final void mo27603a(int i) {
                    if (i == 0 && iMMessage.getAttachment() != null && (iMMessage.getAttachment() instanceof FileAttachment)) {
                        ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(iMMessage, true);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public void m22647e(IMMessage iMMessage) {
            C5912a aVar = (C5912a) iMMessage;
            aVar.setTime(System.currentTimeMillis());
            aVar.mo28299b(C5570b.this.f17935c.f17922c);
            aVar.setStatus(MsgStatusEnum.sending);
            aVar.mo28294a(C5570b.this.f17935c.f17923d);
            if (aVar.getMsgType() == MsgTypeEnum.audio) {
                AudioAttachment audioAttachment = (AudioAttachment) aVar.getAttachment();
                audioAttachment.setAutoTransform(C5570b.this.f17948p);
                aVar.setAttachment(audioAttachment);
            }
            C5570b.this.f17939g.mo27729a(iMMessage);
            C5570b.this.f17935c.f17924e.sendMessage(aVar, true);
            C5570b.this.mo27704a(iMMessage);
        }

        /* renamed from: a */
        public final void mo27721a(C5564a aVar) {
            C5570b.this.f17951s = aVar;
            TFragment tFragment = (TFragment) C5570b.this.f17935c.f17921b;
            StringBuilder sb = new StringBuilder();
            sb.append(C5406d.m22120b());
            sb.append(".jpg");
            C5557c.m22588a(tFragment, 8, false, C5946c.m23834a(sb.toString(), C5944b.TYPE_TEMP), false);
        }

        /* renamed from: a */
        public final void mo27722a(IMMessage iMMessage) {
            if (iMMessage.getDirect() != MsgDirectionEnum.Out) {
                m22646d(iMMessage);
            } else if (iMMessage.getStatus() == MsgStatusEnum.fail) {
                m22647e(iMMessage);
            } else if (iMMessage.getAttachment() instanceof FileAttachment) {
                FileAttachment fileAttachment = (FileAttachment) iMMessage.getAttachment();
                if (TextUtils.isEmpty(fileAttachment.getPath()) && TextUtils.isEmpty(fileAttachment.getThumbPath())) {
                    m22646d(iMMessage);
                }
            } else {
                m22647e(iMMessage);
            }
        }

        /* renamed from: a */
        public final boolean mo27723a() {
            return C5570b.this.f17935c.f17924e.isAllowSendMessage(true);
        }

        /* renamed from: b */
        public final void mo27724b() {
            C5570b.this.f17935c.f17924e.shouldCollapseInputPanel();
        }

        /* renamed from: b */
        public final boolean mo27725b(IMMessage iMMessage) {
            if (C5570b.this.f17935c.f17924e.isLongClickEnabled()) {
                ArrayList arrayList = new ArrayList();
                final String string = C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_re_send_has_blank);
                if (iMMessage.getStatus() == MsgStatusEnum.fail) {
                    arrayList.add(string);
                }
                final String string2 = C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_copy_has_blank);
                if (iMMessage.getMsgType() == MsgTypeEnum.text || (iMMessage.getAttachment() instanceof C6113c)) {
                    arrayList.add(string2);
                }
                final String string3 = C5570b.this.f17935c.f17920a.getString(C6014b.m23965j() ? C5961R.string.ysf_audio_play_by_speaker : C5961R.string.ysf_audio_play_by_earphone);
                final String string4 = C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_audio_translate);
                if (iMMessage.getMsgType() == MsgTypeEnum.audio) {
                    arrayList.add(string3);
                    arrayList.add(string4);
                }
                final String string5 = C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_delete_has_blank);
                CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                Activity activity = C5570b.this.f17935c.f17920a;
                final CharSequence[] charSequenceArr2 = charSequenceArr;
                final IMMessage iMMessage2 = iMMessage;
                C55862 r3 = new C6365a() {
                    /* renamed from: a */
                    public final void mo27603a(int i) {
                        if (TextUtils.equals(charSequenceArr2[i], string)) {
                            C5584b bVar = C5584b.this;
                            IMMessage iMMessage = iMMessage2;
                            if (C5570b.this.m22597a(iMMessage.getUuid()) >= 0) {
                                C6364g.m25005a((Context) C5570b.this.f17935c.f17920a, C5570b.this.f17935c.f17920a.getString(C5961R.string.ysf_re_send_message), true, (C6365a) new C6365a(iMMessage) {
                                    /* renamed from: a */
                                    final /* synthetic */ IMMessage f17989a;

                                    {
                                        this.f17989a = r2;
                                    }

                                    /* renamed from: a */
                                    public final void mo27603a(int i) {
                                        if (i == 0) {
                                            C5584b.this.m22647e(this.f17989a);
                                        }
                                    }
                                });
                            }
                        } else if (TextUtils.equals(charSequenceArr2[i], string2)) {
                            C5584b bVar2 = C5584b.this;
                            IMMessage iMMessage2 = iMMessage2;
                            if (iMMessage2.getMsgType() == MsgTypeEnum.text) {
                                C5408a.m22129a(C5570b.this.f17935c.f17920a, iMMessage2.getContent());
                                return;
                            }
                            if (iMMessage2.getAttachment() instanceof C6113c) {
                                C5408a.m22129a(C5570b.this.f17935c.f17920a, ((C6113c) iMMessage2.getAttachment()).mo29035a(C5570b.this.f17935c.f17920a));
                            }
                        } else if (TextUtils.equals(charSequenceArr2[i], string3)) {
                            C6014b.m23931a(!C6014b.m23965j());
                            C5570b.this.mo27708b(C6014b.m23965j() ? C5961R.string.ysf_audio_current_mode_is_earphone : C5961R.string.ysf_audio_current_mode_is_speaker);
                        } else if (TextUtils.equals(charSequenceArr2[i], string4)) {
                            C5584b bVar3 = C5584b.this;
                            IMMessage iMMessage3 = iMMessage2;
                            if (iMMessage3.getDirect() != MsgDirectionEnum.In || iMMessage3.getAttachStatus() == AttachStatusEnum.transferred) {
                                if (iMMessage3.getStatus() != MsgStatusEnum.read && iMMessage3.getDirect() == MsgDirectionEnum.In) {
                                    iMMessage3.setStatus(MsgStatusEnum.read);
                                    ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage3, true);
                                }
                                C5409b.m22130a(C5570b.this.f17935c.f17920a);
                                C5570b.this.f17935c.f17921b.getActivity().getSupportFragmentManager().beginTransaction().replace(16908290, TranslateFragment.newInstance(iMMessage3)).addToBackStack(null).commitAllowingStateLoss();
                                return;
                            }
                            C5415g.m22161a(C5961R.string.ysf_no_permission_audio_error);
                        } else {
                            if (TextUtils.equals(charSequenceArr2[i], string5)) {
                                C5584b bVar4 = C5584b.this;
                                IMMessage iMMessage4 = iMMessage2;
                                ((MsgService) NIMClient.getService(MsgService.class)).deleteChattingHistory(iMMessage4);
                                C5570b.this.f17939g.mo27729a(iMMessage4);
                            }
                        }
                    }
                };
                C6364g.m25003a((Context) activity, (CharSequence) null, charSequenceArr, (C6365a) r3);
            }
            return true;
        }

        /* renamed from: c */
        public final void mo27726c() {
            if (C5570b.this.mo27714g()) {
                C5570b.this.mo27715h();
            }
        }

        /* renamed from: c */
        public final void mo27727c(IMMessage iMMessage) {
            C5570b.this.f17935c.f17924e.sendMessage(iMMessage, false);
        }
    }

    public C5570b(C5567a aVar, View view) {
        this(aVar, view, 0);
    }

    private C5570b(C5567a aVar, View view, byte b) {
        int i;
        MessageListView messageListView;
        this.f17934b = true;
        this.f17933a = false;
        this.f17948p = false;
        this.f17949q = false;
        this.f17950r = 0;
        this.f17952t = new Observer<CustomNotification>() {
            public final /* synthetic */ void onEvent(Object obj) {
                CustomNotification customNotification = (CustomNotification) obj;
                if (TextUtils.equals(C5570b.this.f17935c.f17922c, customNotification.getSessionId()) && customNotification.getSessionType() == SessionTypeEnum.Ysf) {
                    C5570b.this.mo27703a(customNotification);
                }
            }
        };
        this.f17953u = new C5562a() {
            /* renamed from: a */
            public final void mo27696a(File file) {
                MediaPlayer a = C5570b.this.m22599a(file);
                C5570b.this.f17935c.f17924e.sendMessage(MessageBuilder.createVideoMessage(C5570b.this.f17935c.f17922c, SessionTypeEnum.Ysf, file, a == null ? 0 : (long) a.getDuration(), a == null ? 0 : a.getVideoWidth(), a == null ? 0 : a.getVideoHeight(), file.getName()), false);
            }
        };
        this.f17954v = new Observer<IMMessage>() {
            public final /* synthetic */ void onEvent(Object obj) {
                IMMessage iMMessage = (IMMessage) obj;
                if (C5570b.this.m22611c(iMMessage)) {
                    C5570b.m22606b(C5570b.this, iMMessage);
                }
            }
        };
        this.f17955w = new Observer<AttachmentProgress>() {
            public final /* synthetic */ void onEvent(Object obj) {
                C5570b.m22602a(C5570b.this, (AttachmentProgress) obj);
            }
        };
        this.f17957y = new Runnable() {
            public final void run() {
                C5570b.this.f17943k.setVisibility(8);
            }
        };
        this.f17935c = aVar;
        this.f17936d = view;
        this.f17946n = false;
        this.f17947o = false;
        this.f17938f = new ArrayList();
        this.f17939g = new C5588c(this.f17935c.f17920a, this.f17938f, this);
        this.f17939g.mo27728a((C5590a) new C5584b(this, 0));
        this.f17940h = (ImageView) this.f17936d.findViewById(C5961R.C5963id.message_activity_background);
        this.f17937e = (MessageListView) this.f17936d.findViewById(C5961R.C5963id.messageListView);
        this.f17937e.requestDisallowInterceptTouchEvent(true);
        if (!this.f17946n || this.f17947o) {
            messageListView = this.f17937e;
            i = C5481a.f17662a;
        } else {
            messageListView = this.f17937e;
            i = C5481a.f17664c;
        }
        messageListView.mo27565a(i);
        if (VERSION.SDK_INT >= 9) {
            this.f17937e.setOverScrollMode(2);
        }
        this.f17937e.mo27577a((BaseAdapter) this.f17939g);
        this.f17937e.mo27578a((C5486b) new C5486b() {
            /* renamed from: a */
            public final void mo27583a() {
                C5570b.this.f17935c.f17924e.shouldCollapseInputPanel();
            }

            /* renamed from: a */
            public final void mo27584a(int i, int i2) {
                if (i2 - i > C5412d.m22150d() + C5412d.m22151e() || C5570b.this.mo27714g()) {
                    C5487a.m22377a(C5570b.this.f17937e);
                }
            }

            /* renamed from: b */
            public final void mo27585b() {
                C5409b.m22132a(C5570b.this.f17935c.f17921b);
            }
        });
        this.f17937e.mo27566a((C5482b) new C5582a(this.f17947o));
        this.f17942j = new Handler();
        if (!this.f17946n) {
            this.f17941i = new C5568a(this.f17935c.f17920a, this.f17936d, this.f17937e);
        }
        m22610c(true);
        this.f17943k = this.f17936d.findViewById(C5961R.C5963id.play_audio_mode_tips_bar);
        this.f17944l = (TextView) this.f17936d.findViewById(C5961R.C5963id.play_audio_mode_tips_label);
        this.f17945m = (ImageView) this.f17936d.findViewById(C5961R.C5963id.play_audio_mode_tips_indicator);
        UICustomization uICustomization = C6029d.m24045e().uiCustomization;
        if (uICustomization != null && uICustomization.msgListViewDividerHeight > 0) {
            this.f17937e.setDividerHeight(uICustomization.msgListViewDividerHeight);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m22597a(String str) {
        for (int i = 0; i < this.f17938f.size(); i++) {
            if (TextUtils.equals(((IMMessage) this.f17938f.get(i)).getUuid(), str)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MediaPlayer m22599a(File file) {
        try {
            r4 = file;
            r4 = MediaPlayer.create(this.f17935c.f17920a, Uri.fromFile(file));
            r4 = r4;
            return r4;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("file:");
            sb.append(r4);
            C5264a.m21621b("getVideoMediaPlayer is error", sb.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22602a(C5570b bVar, AttachmentProgress attachmentProgress) {
        int a = bVar.m22597a(attachmentProgress.getUuid());
        if (a >= 0 && a < bVar.f17938f.size()) {
            bVar.f17939g.mo27730a((IMMessage) bVar.f17938f.get(a), ((float) attachmentProgress.getTransferred()) / ((float) attachmentProgress.getTotal()));
            bVar.m22609c(a);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m22606b(C5570b bVar, IMMessage iMMessage) {
        int a = bVar.m22597a(iMMessage.getUuid());
        if (a >= 0 && a < bVar.f17938f.size()) {
            IMMessage iMMessage2 = (IMMessage) bVar.f17938f.get(a);
            iMMessage2.setStatus(iMMessage.getStatus());
            iMMessage2.setAttachStatus(iMMessage.getAttachStatus());
            iMMessage2.setAttachment(iMMessage.getAttachment());
            iMMessage2.setExt(iMMessage.getExt());
            bVar.m22609c(a);
            bVar.f17939g.notifyDataSetChanged();
            if (bVar.mo27714g() || bVar.f17950r != 0) {
                bVar.f17950r = 0;
                bVar.m22607b(false);
            }
        }
    }

    /* renamed from: b */
    private void m22607b(final boolean z) {
        this.f17942j.postDelayed(new Runnable() {
            public final void run() {
                if (z) {
                    MessageListView b = C5570b.this.f17937e;
                    int count = C5570b.this.f17939g.getCount();
                    if (VERSION.SDK_INT >= 11) {
                        b.smoothScrollToPositionFromTop(count, 0, 100);
                    } else {
                        b.setSelection(count);
                    }
                } else {
                    C5487a.m22377a(C5570b.this.f17937e);
                }
            }
        }, 10);
    }

    /* renamed from: c */
    private void m22609c(final int i) {
        this.f17935c.f17920a.runOnUiThread(new Runnable() {
            public final void run() {
                if (i >= 0) {
                    MessageListView b = C5570b.this.f17937e;
                    int i = i;
                    int firstVisiblePosition = b.getFirstVisiblePosition() - b.getHeaderViewsCount();
                    Object tag = (i < firstVisiblePosition || i > b.getLastVisiblePosition() - b.getHeaderViewsCount()) ? null : b.getChildAt(i - firstVisiblePosition).getTag();
                    if (tag instanceof C5622b) {
                        ((C5622b) tag).refreshCurrentItem();
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private void m22610c(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.f17952t, z);
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class);
        msgServiceObserve.observeMsgStatus(this.f17954v, z);
        msgServiceObserve.observeAttachmentProgress(this.f17955w, z);
        if (z) {
            if (this.f17956x == null) {
                this.f17956x = new C5432a() {
                };
            }
            C5430a.m22185a(this.f17956x);
            return;
        }
        C5432a aVar = this.f17956x;
        if (aVar != null) {
            C5430a.m22186b(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m22611c(IMMessage iMMessage) {
        return iMMessage.getSessionType() == this.f17935c.f17923d && iMMessage.getSessionId() != null && iMMessage.getSessionId().equals(this.f17935c.f17922c);
    }

    /* renamed from: a */
    public final int mo27378a() {
        return C5629c.m22784a();
    }

    /* renamed from: a */
    public final Class<? extends C5439f> mo27379a(int i) {
        return C5629c.m22785a((IMMessage) this.f17938f.get(i));
    }

    /* renamed from: a */
    public final void mo27701a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                C5557c.m22586a(intent, this.f17953u);
            } else if (i == 8) {
                C5563d.m22592a(this.f17935c.f17921b, intent, 9, this.f17951s);
            } else if (i == 9) {
                C5563d.m22591a(this.f17935c.f17921b, intent, i, 8, this.f17951s);
            }
        }
    }

    /* renamed from: a */
    public final void mo27702a(C5567a aVar) {
        this.f17935c = aVar;
        this.f17938f.clear();
        this.f17937e.mo27566a((C5482b) new C5582a(this.f17947o));
    }

    /* access modifiers changed from: protected|final */
    /* renamed from: a */
    public final void mo27703a(CustomNotification customNotification) {
        C6144e attachment = customNotification.getAttachment();
        if (attachment != null && attachment.getCmdId() == 2) {
            C6119a aVar = (C6119a) attachment;
            if (aVar.mo29075a() == 200 && (this.f17933a || C6014b.m23981r(this.f17935c.f17922c) != aVar.mo29087e())) {
                C6014b.m23944c(this.f17935c.f17922c, aVar.mo29087e());
            } else if (!this.f17933a) {
                List<IMMessage> list = this.f17938f;
                if (list != null && list.size() == 0) {
                    C5482b a = this.f17937e.mo27564a();
                    this.f17933a = true;
                    a.mo27576a(0);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo27704a(IMMessage iMMessage) {
        this.f17938f.add(iMMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(iMMessage);
        this.f17939g.mo27731a(arrayList, false, true);
        this.f17939g.notifyDataSetChanged();
        if (this.f17949q) {
            this.f17950r++;
        }
        C5487a.m22377a(this.f17937e);
    }

    /* renamed from: a */
    public final void mo27705a(String str, int i) {
        if (C5426a.m22183b(str)) {
            C5426a.m22177a(str, C5412d.m22145a(), C5412d.m22148b(), (ImageLoaderListener) new ImageLoaderListener() {
                public final void onLoadComplete(Bitmap bitmap) {
                    C5570b.this.f17940h.setImageBitmap(bitmap);
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
            return;
        }
        if (i != 0) {
            this.f17940h.setBackgroundColor(i);
        }
    }

    /* renamed from: a */
    public final void mo27706a(List<IMMessage> list) {
        mo27714g();
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        int i = 0;
        for (IMMessage iMMessage : list) {
            if (m22611c(iMMessage)) {
                this.f17938f.add(iMMessage);
                arrayList.add(iMMessage);
                i++;
                z = true;
            }
            if (iMMessage.getAttachment() instanceof C6084f) {
                C6265h.m24766b(iMMessage.getUuid());
            }
        }
        if (z) {
            this.f17939g.notifyDataSetChanged();
        }
        this.f17939g.mo27731a(arrayList, false, true);
        if (i > 0) {
            m22607b(true);
        }
        if (C6029d.m24047g().mo29311m(this.f17935c.f17922c) != null && C6029d.m24047g().mo29301f(this.f17935c.f17922c) == 0 && !this.f17949q) {
            C6160p pVar = new C6160p();
            pVar.mo29227a(String.valueOf(C6029d.m24047g().mo29295c(this.f17935c.f17922c)));
            C6185c.m24532a(pVar, list.get(0) != null ? ((IMMessage) list.get(0)).getSessionId() : this.f17935c.f17922c, true);
        }
    }

    /* renamed from: a */
    public final void mo27707a(boolean z) {
        this.f17948p = z;
    }

    /* renamed from: b */
    public final void mo27708b(int i) {
        int i2 = C6014b.m23965j() ? C5961R.C5962drawable.ysf_play_audio_mode_earphone : C5961R.C5962drawable.ysf_play_audio_mode_speaker;
        this.f17944l.setText(i);
        this.f17945m.setBackgroundResource(i2);
        this.f17943k.setVisibility(0);
        this.f17942j.removeCallbacks(this.f17957y);
        this.f17942j.postDelayed(this.f17957y, 3000);
    }

    /* renamed from: b */
    public final void mo27709b(IMMessage iMMessage) {
        this.f17939g.mo27729a(iMMessage);
    }

    /* renamed from: b */
    public final boolean mo27380b() {
        return false;
    }

    /* renamed from: c */
    public final void mo27710c() {
        this.f17942j.removeCallbacks(null);
        m22610c(false);
    }

    /* renamed from: d */
    public final void mo27711d() {
        this.f17935c.f17920a.runOnUiThread(new Runnable() {
            public final void run() {
                C5570b.this.f17939g.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: e */
    public final void mo27712e() {
        this.f17949q = true;
    }

    /* renamed from: f */
    public final void mo27713f() {
        this.f17949q = false;
    }

    /* renamed from: g */
    public final boolean mo27714g() {
        MessageListView messageListView = this.f17937e;
        if (!(messageListView == null || messageListView.getAdapter() == null || messageListView.getLastVisiblePosition() < (messageListView.getAdapter().getCount() - 1) - messageListView.getFooterViewsCount())) {
            View childAt = messageListView.getChildAt(messageListView.getChildCount() - 1);
            return childAt != null && childAt.getBottom() - messageListView.getBottom() < C5412d.m22146a(30.0f);
        }
    }

    /* renamed from: h */
    public final void mo27715h() {
        m22607b(false);
    }
}
