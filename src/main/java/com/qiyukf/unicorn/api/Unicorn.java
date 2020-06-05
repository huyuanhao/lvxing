package com.qiyukf.unicorn.api;

import android.content.Context;
import android.view.ViewGroup;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.basesdk.p394b.p395a.p396a.C5287f;
import com.qiyukf.nimlib.C5743d;
import com.qiyukf.nimlib.p488k.p491c.C5944b;
import com.qiyukf.nimlib.p488k.p491c.C5946c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.C6015c;
import com.qiyukf.unicorn.C6029d;
import com.qiyukf.unicorn.api.msg.MessageService;
import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.api.msg.UnicornMessage;
import com.qiyukf.unicorn.p499b.C6014b;
import com.qiyukf.unicorn.p514h.C6185c;
import com.qiyukf.unicorn.p516j.C6218e;
import com.qiyukf.unicorn.p517ui.activity.ServiceMessageActivity;
import com.qiyukf.unicorn.p517ui.fragment.ServiceMessageFragment;

public class Unicorn {
    private static final String TAG = "QIYU";
    /* access modifiers changed from: private|static */
    public static C6029d delegate;

    public static void addPushMessageListener(OnPushMessageListener onPushMessageListener) {
        if (isInit()) {
            C6029d.m24047g().mo29282a(onPushMessageListener);
        }
    }

    public static void addUnreadCountChangeListener(final UnreadCountChangeListener unreadCountChangeListener, final boolean z) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                C6015c h = C6029d.m24048h();
                if (h != null) {
                    h.mo28850a(unreadCountChangeListener, z);
                }
            }
        });
    }

    public static void clearCache() {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    try {
                        C5287f.m21710a().mo27151b();
                        C5946c.m23843c(C5944b.TYPE_FILE);
                    } catch (Throwable th) {
                        C5264a.m21625d(Unicorn.TAG, "clear cache error", th);
                    }
                }
            }
        });
    }

    public static int getUnreadCount() {
        C6015c h = C6029d.m24048h();
        if (h != null) {
            return h.mo28858d();
        }
        return 0;
    }

    public static boolean init(Context context, String str, YSFOptions ySFOptions, UnicornImageLoader unicornImageLoader) {
        delegate = C6029d.m24027a(context, str, ySFOptions, unicornImageLoader);
        return !C5743d.m23121f() || delegate != null;
    }

    static boolean isInit() {
        return delegate != null && C6029d.m24038b();
    }

    @Deprecated
    public static boolean isServiceAvailable() {
        return true;
    }

    public static void logout() {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                Unicorn.setUserInfo(null);
            }
        });
    }

    @Deprecated
    public static ServiceMessageFragment newServiceFragment(String str, ConsultSource consultSource) {
        return newServiceFragment(str, consultSource, null);
    }

    public static ServiceMessageFragment newServiceFragment(String str, ConsultSource consultSource, ViewGroup viewGroup) {
        if (delegate != null) {
            ServiceMessageFragment serviceMessageFragment = new ServiceMessageFragment();
            serviceMessageFragment.setArguments(str, consultSource, viewGroup);
            return serviceMessageFragment;
        }
        C5264a.m21622c(TAG, "QIYU is not init, please init first.");
        return null;
    }

    public static void openServiceActivity(final Context context, final String str, final ConsultSource consultSource) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.delegate != null) {
                    ServiceMessageActivity.start(context, str, consultSource);
                } else {
                    C5264a.m21622c(Unicorn.TAG, "QIYU is not init, please init first.");
                }
            }
        });
    }

    public static UnicornMessage queryLastMessage() {
        if (isInit()) {
            return ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(C6185c.m24533a(), SessionTypeEnum.Ysf);
        }
        return null;
    }

    public static void removePushMessageListener(OnPushMessageListener onPushMessageListener) {
        if (isInit()) {
            C6029d.m24047g().mo29293b(onPushMessageListener);
        }
    }

    @Deprecated
    public static void sendProductMessage(ProductDetail productDetail) {
        MessageService.sendProductMessage(productDetail);
    }

    public static boolean setUserInfo(YSFUserInfo ySFUserInfo) {
        return setUserInfo(ySFUserInfo, null);
    }

    public static boolean setUserInfo(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        return isInit() && delegate.mo28872a(ySFUserInfo, requestCallback);
    }

    public static void toggleNotification(final boolean z) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6014b.m23940b(z);
                }
            }
        });
    }

    public static void trackUserAccess(final String str, final String str2) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    Unicorn.delegate.mo28871a(str, str2);
                }
            }
        });
    }

    public static void updateOptions(final YSFOptions ySFOptions) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    Unicorn.delegate.mo28870a(ySFOptions);
                }
            }
        });
    }
}
