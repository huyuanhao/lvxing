package com.qiyukf.nimlib.p485i;

import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

/* renamed from: com.qiyukf.nimlib.i.h */
public final class C5925h implements RecentContact {
    /* renamed from: a */
    private String f18718a;
    /* renamed from: b */
    private String f18719b;
    /* renamed from: c */
    private String f18720c;
    /* renamed from: d */
    private int f18721d;
    /* renamed from: e */
    private MsgStatusEnum f18722e;
    /* renamed from: f */
    private SessionTypeEnum f18723f;
    /* renamed from: g */
    private String f18724g;
    /* renamed from: h */
    private long f18725h;
    /* renamed from: i */
    private long f18726i;
    /* renamed from: j */
    private String f18727j;
    /* renamed from: k */
    private int f18728k;
    /* renamed from: l */
    private MsgAttachment f18729l;
    /* renamed from: m */
    private SessionStatusEnum f18730m;

    /* renamed from: a */
    public final String mo28336a() {
        return this.f18727j;
    }

    /* renamed from: a */
    public final void mo28337a(int i) {
        this.f18721d = i;
    }

    /* renamed from: a */
    public final void mo28338a(long j) {
        this.f18725h = j;
    }

    /* renamed from: a */
    public final void mo28339a(SessionTypeEnum sessionTypeEnum) {
        this.f18723f = sessionTypeEnum;
    }

    /* renamed from: a */
    public final void mo28340a(SessionStatusEnum sessionStatusEnum) {
        this.f18730m = sessionStatusEnum;
    }

    /* renamed from: a */
    public final void mo28341a(MsgAttachment msgAttachment) {
        this.f18729l = msgAttachment;
        if (msgAttachment != null) {
            this.f18727j = msgAttachment.toJson(false);
        }
    }

    /* renamed from: a */
    public final void mo28342a(String str) {
        this.f18718a = str;
    }

    /* renamed from: b */
    public final int mo28343b() {
        return this.f18728k;
    }

    /* renamed from: b */
    public final void mo28344b(int i) {
        this.f18728k = i;
    }

    /* renamed from: b */
    public final void mo28345b(String str) {
        this.f18719b = str;
    }

    /* renamed from: c */
    public final void mo28346c(String str) {
        this.f18720c = str;
    }

    /* renamed from: d */
    public final void mo28347d(String str) {
        this.f18724g = str;
    }

    /* renamed from: e */
    public final void mo28348e(String str) {
        this.f18727j = str;
        if (!TextUtils.isEmpty(str)) {
            this.f18729l = C5913b.m23694a().mo28328c().mo28333a(this.f18728k, str);
        }
    }

    public final MsgAttachment getAttachment() {
        return this.f18729l;
    }

    public final String getContactId() {
        return this.f18718a;
    }

    public final String getContent() {
        return this.f18724g;
    }

    public final String getFromAccount() {
        return this.f18719b;
    }

    public final MsgStatusEnum getMsgStatus() {
        return this.f18722e;
    }

    public final MsgTypeEnum getMsgType() {
        return C5923g.m23763a(this.f18728k);
    }

    public final String getRecentMessageId() {
        return this.f18720c;
    }

    public final SessionStatusEnum getSessionStatus() {
        return this.f18730m;
    }

    public final SessionTypeEnum getSessionType() {
        return this.f18723f;
    }

    public final long getTag() {
        return this.f18726i;
    }

    public final long getTime() {
        return this.f18725h;
    }

    public final int getUnreadCount() {
        return this.f18721d;
    }

    public final void setMsgStatus(MsgStatusEnum msgStatusEnum) {
        this.f18722e = msgStatusEnum;
    }

    public final void setTag(long j) {
        this.f18726i = j;
    }
}
