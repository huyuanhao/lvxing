package com.tencent.android.tpush.p581c;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.cloudctr.CloudControlManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.c.g */
public class C6881g {
    /* renamed from: a */
    private long f22916a = -1;
    /* renamed from: b */
    private long f22917b = -1;
    /* renamed from: c */
    private long f22918c = -1;
    /* renamed from: d */
    private long f22919d = -1;
    /* renamed from: e */
    private String f22920e = "";
    /* renamed from: f */
    private long f22921f = -1;
    /* renamed from: g */
    private long f22922g = -1;
    /* renamed from: h */
    private Context f22923h = null;
    /* renamed from: i */
    private Intent f22924i = null;
    /* renamed from: j */
    private C6867a f22925j = null;

    private C6881g(Context context, Intent intent) {
        this.f22923h = context;
        this.f22924i = intent;
    }

    /* renamed from: a */
    public static C6881g m29385a(Context context, Intent intent) {
        C6867a aVar;
        C6881g gVar = new C6881g(context, intent);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_CONTENT));
        gVar.f22920e = decrypt;
        gVar.f22917b = intent.getLongExtra(MessageKey.MSG_ID, -1);
        gVar.f22918c = intent.getLongExtra("accId", -1);
        gVar.f22919d = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, -1);
        gVar.f22916a = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1);
        gVar.f22921f = intent.getLongExtra(MessageKey.MSG_CREATE_TIMESTAMPS, -1);
        gVar.f22922g = intent.getLongExtra("type", -1);
        int i = (int) gVar.f22922g;
        if (i == 1) {
            aVar = new C6873e(decrypt);
        } else if (i != 2) {
            if (i == 3) {
                C6871c.m29327a().mo33016b(context, decrypt);
                XGPushManager.msgAck(context, gVar);
            } else if (i != 1000) {
                StringBuilder sb = new StringBuilder();
                sb.append("error type for message, drop it, type:");
                sb.append(gVar.f22922g);
                sb.append(",intent:");
                sb.append(intent);
                C6864a.m29308i(Constants.LogTag, sb.toString());
                XGPushManager.msgAck(context, gVar);
            } else {
                CloudControlManager.m29396a().mo33061a(context, decrypt);
            }
            aVar = null;
        } else {
            aVar = new C6882h(decrypt);
        }
        if (aVar != null) {
            gVar.f22925j = aVar;
            gVar.f22925j.mo32997b();
        }
        return gVar;
    }

    /* renamed from: a */
    public void mo33051a() {
        if (this.f22925j.mo32998c() == 1) {
            C6868b.m29326b(this.f22923h, this);
        }
    }

    /* renamed from: b */
    public long mo33052b() {
        return this.f22917b;
    }

    /* renamed from: c */
    public long mo33053c() {
        return this.f22918c;
    }

    /* renamed from: d */
    public long mo33054d() {
        return this.f22919d;
    }

    /* renamed from: e */
    public long mo33055e() {
        return this.f22921f;
    }

    /* renamed from: f */
    public String mo33056f() {
        return this.f22920e;
    }

    /* renamed from: g */
    public C6867a mo33057g() {
        return this.f22925j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushMessageManager [msgId=");
        sb.append(this.f22917b);
        sb.append(", accessId=");
        sb.append(this.f22918c);
        sb.append(", busiMsgId=");
        sb.append(this.f22919d);
        sb.append(", content=");
        sb.append(this.f22920e);
        sb.append(", timestamps=");
        sb.append(this.f22921f);
        sb.append(", type=");
        sb.append(this.f22922g);
        sb.append(", intent=");
        sb.append(this.f22924i);
        sb.append(", messageHolder=");
        sb.append(this.f22925j);
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: h */
    public long mo33058h() {
        return this.f22916a;
    }
}
