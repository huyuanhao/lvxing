package com.qiyukf.nimlib.p485i;

import android.text.TextUtils;
import com.qiyukf.basesdk.p412c.C5366b;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomMessageConfig;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

/* renamed from: com.qiyukf.nimlib.i.a */
public final class C5912a implements IMMessage {
    private static final long serialVersionUID = -1949246189525361810L;
    /* renamed from: a */
    private long f18681a = -1;
    /* renamed from: b */
    private String f18682b;
    /* renamed from: c */
    private SessionTypeEnum f18683c;
    /* renamed from: d */
    private int f18684d;
    /* renamed from: e */
    private MsgStatusEnum f18685e;
    /* renamed from: f */
    private MsgDirectionEnum f18686f;
    /* renamed from: g */
    private String f18687g;
    /* renamed from: h */
    private String f18688h;
    /* renamed from: i */
    private long f18689i;
    /* renamed from: j */
    private MsgAttachment f18690j;
    /* renamed from: k */
    private String f18691k;
    /* renamed from: l */
    private transient JSONObject f18692l;
    /* renamed from: m */
    private AttachStatusEnum f18693m;
    /* renamed from: n */
    private String f18694n;
    /* renamed from: o */
    private long f18695o;
    /* renamed from: p */
    private String f18696p;
    /* renamed from: q */
    private CustomMessageConfig f18697q;

    /* renamed from: a */
    public final long mo28290a() {
        return this.f18681a;
    }

    /* renamed from: a */
    public final String mo28291a(boolean z) {
        MsgAttachment msgAttachment = this.f18690j;
        return msgAttachment != null ? msgAttachment.toJson(z) : this.f18696p;
    }

    /* renamed from: a */
    public final void mo28292a(int i) {
        this.f18684d = i;
    }

    /* renamed from: a */
    public final void mo28293a(long j) {
        this.f18681a = j;
    }

    /* renamed from: a */
    public final void mo28294a(SessionTypeEnum sessionTypeEnum) {
        this.f18683c = sessionTypeEnum;
    }

    /* renamed from: a */
    public final void mo28295a(CustomMessageConfig customMessageConfig) {
        this.f18697q = customMessageConfig;
    }

    /* renamed from: a */
    public final void mo28296a(String str) {
        this.f18694n = str;
    }

    /* renamed from: b */
    public final int mo28297b() {
        return this.f18684d;
    }

    /* renamed from: b */
    public final void mo28298b(long j) {
        this.f18695o = j;
    }

    /* renamed from: b */
    public final void mo28299b(String str) {
        this.f18682b = str;
    }

    /* renamed from: c */
    public final long mo28300c() {
        return this.f18695o;
    }

    /* renamed from: c */
    public final void mo28301c(String str) {
        this.f18696p = str;
        if (!TextUtils.isEmpty(str)) {
            this.f18690j = C5913b.m23694a().mo28328c().mo28333a(this.f18684d, str);
        }
    }

    /* renamed from: d */
    public final CustomMessageConfig mo28302d() {
        return this.f18697q;
    }

    public final AttachStatusEnum getAttachStatus() {
        AttachStatusEnum attachStatusEnum = this.f18693m;
        return attachStatusEnum == null ? AttachStatusEnum.def : attachStatusEnum;
    }

    public final MsgAttachment getAttachment() {
        return this.f18690j;
    }

    public final String getContent() {
        return this.f18688h;
    }

    public final MsgDirectionEnum getDirect() {
        return this.f18686f;
    }

    public final String getExt() {
        return this.f18691k;
    }

    public final JSONObject getExtension() {
        if (!TextUtils.isEmpty(this.f18691k) && this.f18692l == null) {
            this.f18692l = C5366b.m22027a(this.f18691k);
        }
        return this.f18692l;
    }

    public final String getFromAccount() {
        return this.f18687g;
    }

    public final MsgTypeEnum getMsgType() {
        return C5923g.m23763a(this.f18684d);
    }

    public final String getSessionId() {
        return this.f18682b;
    }

    public final SessionTypeEnum getSessionType() {
        return this.f18683c;
    }

    public final MsgStatusEnum getStatus() {
        return this.f18685e;
    }

    public final long getTime() {
        return this.f18689i;
    }

    public final String getUuid() {
        return this.f18694n;
    }

    public final boolean isTheSame(IMMessage iMMessage) {
        if (iMMessage == null) {
            return false;
        }
        long j = ((C5912a) iMMessage).f18681a;
        long j2 = this.f18681a;
        return (j2 <= 0 || j <= 0) ? TextUtils.equals(this.f18694n, iMMessage.getUuid()) : j2 == j;
    }

    public final void setAttachStatus(AttachStatusEnum attachStatusEnum) {
        this.f18693m = attachStatusEnum;
    }

    public final void setAttachment(MsgAttachment msgAttachment) {
        this.f18690j = msgAttachment;
    }

    public final void setContent(String str) {
        this.f18688h = str;
    }

    public final void setDirect(MsgDirectionEnum msgDirectionEnum) {
        this.f18686f = msgDirectionEnum;
    }

    public final void setExt(String str) {
        this.f18692l = null;
        this.f18691k = str;
    }

    public final void setFromAccount(String str) {
        this.f18687g = str;
    }

    public final void setStatus(MsgStatusEnum msgStatusEnum) {
        this.f18685e = msgStatusEnum;
    }

    public final void setTime(long j) {
        this.f18689i = j;
    }
}
