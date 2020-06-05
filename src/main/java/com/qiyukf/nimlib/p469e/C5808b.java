package com.qiyukf.nimlib.p469e;

import com.qiyukf.nimlib.p485i.C5912a;
import com.qiyukf.nimlib.p485i.C5925h;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.SystemMessageObserver;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nimlib.e.b */
public final class C5808b {
    /* renamed from: a */
    public static void m23318a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(SystemMessageObserver.class.getSimpleName());
        sb.append("/observeUnreadCountChange");
        C5805a.m23312a(sb.toString(), Integer.valueOf(i));
    }

    /* renamed from: a */
    public static void m23319a(CustomNotification customNotification) {
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeCustomNotification");
        C5805a.m23312a(sb.toString(), customNotification);
    }

    /* renamed from: a */
    public static void m23320a(IMMessage iMMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeMsgStatus");
        C5805a.m23312a(sb.toString(), iMMessage);
    }

    /* renamed from: a */
    public static void m23321a(RecentContact recentContact) {
        if (recentContact != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(recentContact);
            StringBuilder sb = new StringBuilder();
            sb.append(MsgServiceObserve.class.getSimpleName());
            sb.append("/observeRecentContact");
            C5805a.m23312a(sb.toString(), arrayList);
        }
    }

    /* renamed from: a */
    public static void m23322a(String str, long j, long j2) {
        AttachmentProgress attachmentProgress = new AttachmentProgress(str, j, j2);
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeAttachmentProgress");
        C5805a.m23312a(sb.toString(), attachmentProgress);
    }

    /* renamed from: a */
    public static void m23323a(List<C5912a> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeReceiveMessage");
        C5805a.m23312a(sb.toString(), list);
    }

    /* renamed from: b */
    public static void m23324b(RecentContact recentContact) {
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeRecentContactDeleted");
        C5805a.m23312a(sb.toString(), recentContact);
    }

    /* renamed from: b */
    public static void m23325b(List<C5925h> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(MsgServiceObserve.class.getSimpleName());
        sb.append("/observeRecentContact");
        C5805a.m23312a(sb.toString(), list);
    }
}
