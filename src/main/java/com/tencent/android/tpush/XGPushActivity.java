package com.tencent.android.tpush;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.stat.C7084e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public class XGPushActivity extends Activity {
    /* renamed from: a */
    static ActivityLifecycleCallbacks f22684a = null;
    /* renamed from: b */
    static List<String> f22685b = null;
    /* renamed from: c */
    static String f22686c = "";
    /* renamed from: d */
    static long f22687d;
    /* renamed from: e */
    static long f22688e;

    /* renamed from: a */
    private boolean m29210a(Intent intent) {
        if (intent == null) {
            return false;
        }
        String str = MessageKey.MSG_PORTECT_TAG;
        if (!intent.hasExtra(str)) {
            return false;
        }
        String stringExtra = intent.getStringExtra(str);
        if (C6914l.m29521c(stringExtra)) {
            return false;
        }
        try {
            Long valueOf = Long.valueOf(Rijndael.decrypt(stringExtra));
            if (valueOf.longValue() <= 0 || System.currentTimeMillis() < valueOf.longValue()) {
                return false;
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str = Constants.LogTag;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (XGPushConfig.enableDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("XGPushActivity receiver intent:");
                sb.append(intent);
                C6864a.m29303e(str, sb.toString());
            }
            if (m29210a(intent)) {
                int intExtra = intent.getIntExtra(Constants.FLAG_ACTION_TYPE, NotificationAction.activity.getType());
                if (intExtra == NotificationAction.activity.getType()) {
                    m29212b(intent);
                } else if (intExtra == NotificationAction.action_package.getType()) {
                    m29214c(intent);
                } else if (intExtra == NotificationAction.url.getType()) {
                    m29211b(0, intent);
                } else {
                    if (intExtra != NotificationAction.intent.getType()) {
                        if (intExtra != NotificationAction.intent_with_action.getType()) {
                            finish();
                            return;
                        }
                    }
                    m29211b(1, intent);
                }
            } else {
                finish();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static void m29206a(Application application) {
        if (f22684a == null) {
            f22684a = new ActivityLifecycleCallbacks() {
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                public void onActivityDestroyed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                    if (activity != null && activity.getComponentName().getClassName() != null && activity.getApplicationContext() != null) {
                        C7084e.m30403b(activity.getApplicationContext(), activity.getComponentName().getClassName(), XGPushConfig.getAccessId(activity.getApplicationContext()));
                    }
                }

                public void onActivityPaused(Activity activity) {
                    if (activity != null && activity.getComponentName().getClassName() != null && activity.getApplicationContext() != null) {
                        if (activity.getComponentName().getClassName().equals(XGPushActivity.f22686c)) {
                            C7084e.m30409c(activity.getApplicationContext(), activity.getComponentName().getClassName(), XGPushConfig.getAccessId(activity.getApplicationContext()));
                        } else {
                            C7084e.m30392a(activity.getApplicationContext(), activity.getComponentName().getClassName(), XGPushConfig.getAccessId(activity.getApplicationContext()), XGPushActivity.f22687d, XGPushActivity.f22688e);
                        }
                    }
                }
            };
            if (application != null) {
                try {
                    ((Application) application.getApplicationContext()).registerActivityLifecycleCallbacks(f22684a);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void addActivityNames(String str) {
        if (!C6914l.m29521c(str)) {
            if (f22685b == null) {
                f22685b = new ArrayList();
            }
            if (!f22685b.contains(str)) {
                f22685b.add(str);
            }
        }
    }

    public static boolean isMonitorActivityNames(String str) {
        if (f22685b != null && !C6914l.m29521c(str) && f22685b.contains(str)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m29212b(Intent intent) {
        String str = Constants.FLAG_ACTIVITY_NAME;
        String stringExtra = intent.getStringExtra(str) != null ? intent.getStringExtra(str) : "";
        if (XGPushConfig.enableDebug) {
            StringBuilder sb = new StringBuilder();
            sb.append("activity intent =");
            sb.append(intent);
            sb.append("activity = ");
            sb.append(stringExtra);
            sb.append("intent.getFlags()");
            sb.append(intent.getFlags());
            C6864a.m29303e(Constants.PushMessageLogTag, sb.toString());
        }
        if (intent != null) {
            f22687d = intent.getLongExtra(MessageKey.MSG_ID, 0);
            f22688e = intent.getLongExtra(MessageKey.MSG_BUSI_MSG_ID, 0);
            f22686c = stringExtra;
        }
        Intent intent2 = new Intent();
        intent2.addFlags(intent.getFlags());
        intent2.addFlags(536870912);
        intent2.setClassName(getApplicationContext(), stringExtra);
        intent.putExtra(Constants.TAG_TPUSH_MESSAGE, "true");
        intent2.putExtras(intent);
        intent2.putExtra(Constants.TAG_TPUSH_NOTIFICATION, XGPushManager.m29223a((Activity) this));
        try {
            m29206a(getApplication());
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
        }
        finish();
    }

    /* renamed from: c */
    private void m29214c(Intent intent) {
        m29216e(intent);
        ResolveInfo a = m29204a(intent.getStringExtra(Constants.FLAG_PACKAGE_NAME));
        if (a != null) {
            String str = a.activityInfo.name;
            String str2 = a.activityInfo.packageName;
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent2.setComponent(new ComponentName(str2, str));
            m29205a(0, intent2);
            return;
        }
        m29205a(1, intent);
    }

    /* renamed from: a */
    private ResolveInfo m29204a(String str) {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str2 = resolveInfo.activityInfo.name;
                if (resolveInfo.activityInfo.packageName.equals(str)) {
                    return resolveInfo;
                }
            }
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "查找主Activity出错", th);
        }
        return null;
    }

    /* renamed from: a */
    private void m29205a(int i, final Intent intent) {
        String str = "取消";
        String str2 = "提示";
        if (i == 0) {
            Builder builder = new Builder(this);
            builder.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    XGPushActivity.this.m29216e(intent);
                    XGPushActivity.this.finish();
                }
            }).setTitle(str2).setMessage("是否确定打开此应用？").setPositiveButton("打开", new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.open.getType());
                    XGPushActivity.this.m29216e(intent);
                    try {
                        XGPushActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                    }
                    XGPushActivity.this.finish();
                }
            }).setNegativeButton(str, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.open_cancel.getType());
                    XGPushActivity.this.m29216e(intent);
                    dialogInterface.dismiss();
                    XGPushActivity.this.finish();
                }
            });
            builder.create().show();
        } else if (i == 1) {
            Builder builder2 = new Builder(this);
            builder2.setOnCancelListener(new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    intent.putExtra("action", NotificationAction.download_cancel.getType());
                    XGPushActivity.this.m29216e(intent);
                    XGPushActivity.this.finish();
                }
            }).setTitle(str2).setMessage("本地未发现此应用，建议去下载！").setPositiveButton("下载", new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.download.getType());
                    XGPushActivity.this.m29216e(intent);
                    Intent intent = new Intent(XGPushActivity.this, XGDownloadService.class);
                    intent.putExtras(intent);
                    Intent intent2 = intent;
                    String str = Constants.FLAG_PACKAGE_DOWNLOAD_URL;
                    intent.putExtra(str, intent2.getStringExtra(str));
                    XGPushActivity.this.startService(intent);
                    XGPushActivity.this.finish();
                }
            }).setNegativeButton(str, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    intent.putExtra("action", NotificationAction.download_cancel.getType());
                    XGPushActivity.this.m29216e(intent);
                    dialogInterface.dismiss();
                    XGPushActivity.this.finish();
                }
            });
            builder2.create().show();
        }
    }

    /* renamed from: b */
    private void m29211b(int i, final Intent intent) {
        String str = "取消";
        String str2 = "确认";
        String str3 = "提示";
        String str4 = Constants.FLAG_ACTION_CONFIRM;
        if (i == 0) {
            final String stringExtra = intent.getStringExtra(Constants.FLAG_ACTIVITY_NAME);
            if (intent.getIntExtra(str4, 0) == 1) {
                Builder cancelable = new Builder(this).setTitle(str3).setCancelable(false);
                StringBuilder sb = new StringBuilder();
                sb.append("是否打开网站:");
                sb.append(stringExtra);
                sb.append("?");
                cancelable.setMessage(sb.toString()).setPositiveButton(str2, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        XGPushActivity.this.m29209a(stringExtra, intent);
                        XGPushActivity.this.finish();
                    }
                }).setNegativeButton(str, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        XGPushActivity.this.m29216e(intent);
                        dialogInterface.cancel();
                        XGPushActivity.this.finish();
                    }
                }).show();
                return;
            }
            m29209a(stringExtra, intent);
        } else if (i != 1) {
        } else {
            if (intent.getIntExtra(str4, 0) == 1) {
                new Builder(this).setTitle(str3).setCancelable(false).setMessage("继续打开Intent?").setPositiveButton(str2, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        XGPushActivity.this.m29215d(intent);
                        XGPushActivity.this.finish();
                    }
                }).setNegativeButton(str, new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        XGPushActivity.this.m29216e(intent);
                        dialogInterface.cancel();
                        XGPushActivity.this.finish();
                    }
                }).show();
            } else {
                m29215d(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29215d(Intent intent) {
        try {
            Intent intent2 = new Intent();
            int intExtra = intent.getIntExtra(Constants.FLAG_ACTION_TYPE, NotificationAction.intent.getType());
            int type = NotificationAction.intent.getType();
            String str = Constants.FLAG_ACTIVITY_NAME;
            if (intExtra == type) {
                Uri parse = Uri.parse(intent.getStringExtra(str));
                intent2.setAction("android.intent.action.VIEW");
                intent2.setData(parse);
            } else if (intExtra == NotificationAction.intent_with_action.getType()) {
                intent2.setAction(intent.getStringExtra(str));
                intent2.setPackage(getPackageName());
                intent2.setFlags(268435456);
            }
            if (intent2.resolveActivity(getPackageManager()) != null) {
                m29216e(intent);
                startActivity(intent2);
            }
            finish();
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "openIntent error.", th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29209a(String str, Intent intent) {
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent2.setFlags(268435456);
            m29216e(intent);
            startActivity(intent2);
        } catch (Throwable th) {
            C6864a.m29302d(Constants.LogTag, "openUrl error.", th);
        }
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29216e(Intent intent) {
        XGPushManager.m29228a(getApplicationContext(), intent);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }
}
