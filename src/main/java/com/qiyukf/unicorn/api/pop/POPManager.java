package com.qiyukf.unicorn.api.pop;

import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C6015c;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.UnicornMessage;
import com.qiyukf.unicorn.p516j.C6218e;
import java.util.ArrayList;
import java.util.List;

public class POPManager {
    public static void addOnSessionListChangedListener(final OnSessionListChangedListener onSessionListChangedListener, final boolean z) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                C6015c h = C6029d.m24048h();
                if (h != null) {
                    h.mo28851a(onSessionListChangedListener, z);
                }
            }
        });
    }

    public static void clearUnreadCount(final String str) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (C6029d.m24048h() != null) {
                    ((MsgService) NIMClient.getService(MsgService.class)).clearUnreadCount(str, SessionTypeEnum.Ysf);
                }
            }
        });
    }

    public static void deleteSession(final String str, final boolean z) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                C6015c h = C6029d.m24048h();
                if (h != null) {
                    h.mo28854a(str, z);
                }
            }
        });
    }

    public static List<Session> getSessionList() {
        C6015c h = C6029d.m24048h();
        return h == null ? new ArrayList() : h.mo28859e();
    }

    public static ShopInfo getShopInfo(String str) {
        if (C6029d.m24048h() == null) {
            return null;
        }
        return C6029d.m24047g().mo29292b().getUserInfo(str);
    }

    public static UnicornMessage queryLastMessage(String str) {
        if (C6029d.m24048h() != null) {
            return ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(str, SessionTypeEnum.Ysf);
        }
        return null;
    }
}
