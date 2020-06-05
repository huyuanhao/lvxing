package com.p530ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import androidx.core.app.NotificationManagerCompat;
import com.p530ss.android.socialbase.appdownloader.p552c.INotificationPermissionRequestCallback;
import com.p530ss.android.socialbase.appdownloader.view.NotificationPermissionRequestFragment;
import com.p530ss.android.socialbase.downloader.downloader.C6694b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.appdownloader.j */
public class NotificationPermissionHelper {
    /* renamed from: a */
    private static final String f21647a = NotificationPermissionHelper.class.getSimpleName();
    /* renamed from: b */
    private static List<INotificationPermissionRequestCallback> f21648b = new ArrayList();
    /* renamed from: c */
    private static NotificationPermissionRequestFragment f21649c;
    /* access modifiers changed from: private|static */
    /* renamed from: d */
    public static AlertDialog f21650d;

    /* renamed from: a */
    public static boolean m26942a() {
        try {
            return NotificationManagerCompat.from(C6694b.m27342B()).areNotificationsEnabled();
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: a */
    public static synchronized void m26941a(boolean z) {
        synchronized (NotificationPermissionHelper.class) {
            try {
                if (f21650d != null) {
                    f21650d.cancel();
                    f21650d = null;
                }
                for (INotificationPermissionRequestCallback mVar : f21648b) {
                    if (mVar != null) {
                        if (z) {
                            mVar.mo31471a();
                        } else {
                            mVar.mo31472b();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized void m26940a(final Activity activity, final INotificationPermissionRequestCallback mVar) {
        synchronized (NotificationPermissionHelper.class) {
            if (mVar != null) {
                if (activity != null) {
                    try {
                        if (!activity.isFinishing()) {
                            int a = ResourceUtils.m26944a(C6694b.m27342B(), "appdownloader_notification_request_title");
                            int a2 = ResourceUtils.m26944a(C6694b.m27342B(), "appdownloader_notification_request_message");
                            int a3 = ResourceUtils.m26944a(C6694b.m27342B(), "appdownloader_notification_request_btn_yes");
                            int a4 = ResourceUtils.m26944a(C6694b.m27342B(), "appdownloader_notification_request_btn_no");
                            f21648b.add(mVar);
                            if (f21650d == null || !f21650d.isShowing()) {
                                f21650d = new Builder(activity).setTitle(a).setMessage(a2).setPositiveButton(a3, new OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        NotificationPermissionHelper.m26943b(activity, mVar);
                                        dialogInterface.cancel();
                                        NotificationPermissionHelper.f21650d = null;
                                    }
                                }).setNegativeButton(a4, new OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        NotificationPermissionHelper.m26941a(false);
                                    }
                                }).setOnKeyListener(new OnKeyListener() {
                                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                        if (i != 4) {
                                            return false;
                                        }
                                        if (keyEvent.getAction() == 1) {
                                            NotificationPermissionHelper.m26941a(false);
                                        }
                                        return true;
                                    }
                                }).setCancelable(false).show();
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        m26941a(false);
                    }
                }
                mVar.mo31472b();
                return;
            }
            return;
        }
        return;
    }

    /* renamed from: b */
    public static void m26943b(Activity activity, INotificationPermissionRequestCallback mVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    f21649c = (NotificationPermissionRequestFragment) fragmentManager.findFragmentByTag(f21647a);
                    if (f21649c == null) {
                        f21649c = new NotificationPermissionRequestFragment();
                        fragmentManager.beginTransaction().add(f21649c, f21647a).commitAllowingStateLoss();
                        fragmentManager.executePendingTransactions();
                    }
                    f21649c.mo31641a();
                    return;
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    mVar.mo31471a();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        mVar.mo31471a();
    }
}
