package com.qiyukf.nimlib.p488k.p489a;

import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qiyukf.nimlib.k.a.a */
public final class C5934a {
    /* renamed from: a */
    private static C5934a f18748a;
    /* access modifiers changed from: private */
    /* renamed from: b */
    public Map<String, AbortableFuture<Void>> f18749b = new HashMap();
    /* access modifiers changed from: private */
    /* renamed from: c */
    public Map<String, AttachmentProgress> f18750c = new HashMap();
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C5937a f18751d;
    /* renamed from: e */
    private Observer<IMMessage> f18752e = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (C5934a.this.f18749b.containsKey(iMMessage.getUuid()) && C5934a.this.f18751d != null) {
                if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && C5934a.m23797d(iMMessage)) {
                    C5934a.this.f18751d.onSuccess(iMMessage);
                    C5934a.m23794a(C5934a.this, iMMessage);
                } else if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                    C5934a.this.f18751d.onFail(iMMessage);
                    C5934a.m23794a(C5934a.this, iMMessage);
                }
            }
        }
    };
    /* renamed from: f */
    private Observer<AttachmentProgress> f18753f = new Observer<AttachmentProgress>() {
        public final /* synthetic */ void onEvent(Object obj) {
            AttachmentProgress attachmentProgress = (AttachmentProgress) obj;
            if (C5934a.this.f18749b.containsKey(attachmentProgress.getUuid())) {
                C5934a.this.f18750c.put(attachmentProgress.getUuid(), attachmentProgress);
                if (C5934a.this.f18751d != null) {
                    C5934a.this.f18751d.onProgress(attachmentProgress);
                }
            }
        }
    };

    /* renamed from: com.qiyukf.nimlib.k.a.a$a */
    public interface C5937a {
        void onFail(IMMessage iMMessage);

        void onProgress(AttachmentProgress attachmentProgress);

        void onSuccess(IMMessage iMMessage);
    }

    private C5934a() {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.f18752e, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeAttachmentProgress(this.f18753f, true);
    }

    /* renamed from: a */
    public static C5934a m23792a() {
        if (f18748a == null) {
            f18748a = new C5934a();
        }
        return f18748a;
    }

    /* renamed from: a */
    static /* synthetic */ void m23794a(C5934a aVar, IMMessage iMMessage) {
        aVar.f18749b.remove(iMMessage.getUuid());
        aVar.f18750c.remove(iMMessage.getUuid());
    }

    /* renamed from: d */
    public static boolean m23797d(IMMessage iMMessage) {
        String path = ((FileAttachment) iMMessage.getAttachment()).getPath();
        if (!TextUtils.isEmpty(path)) {
            return new File(path).exists();
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m23798e(IMMessage iMMessage) {
        long expire = ((FileAttachment) iMMessage.getAttachment()).getExpire();
        if (expire <= 0) {
            expire = iMMessage.getTime() + 604800000;
        }
        return System.currentTimeMillis() > expire;
    }

    /* renamed from: a */
    public final AttachmentProgress mo28368a(IMMessage iMMessage) {
        return (AttachmentProgress) this.f18750c.get(iMMessage.getUuid());
    }

    /* renamed from: a */
    public final void mo28369a(C5937a aVar) {
        this.f18751d = aVar;
    }

    /* renamed from: b */
    public final void mo28370b(IMMessage iMMessage) {
        this.f18749b.put(iMMessage.getUuid(), ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(iMMessage, false));
    }

    /* renamed from: c */
    public final void mo28371c(IMMessage iMMessage) {
        AbortableFuture abortableFuture = (AbortableFuture) this.f18749b.remove(iMMessage.getUuid());
        this.f18750c.remove(iMMessage.getUuid());
        if (abortableFuture != null) {
            abortableFuture.abort();
        }
    }
}
