package com.oasisfeng.condom;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application.OnProvideAssistDataListener;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Log;
import com.oasisfeng.condom.util.Lazy;
import java.util.List;

public class CondomContext extends ContextWrapper {
    final String TAG;
    private final Context mApplicationContext;
    private final Lazy<Context> mBaseContext;
    CondomCore mCondom;
    private final Lazy<ContentResolver> mContentResolver;
    private final Lazy<PackageManager> mPackageManager;

    /* renamed from: com.oasisfeng.condom.CondomContext$CondomApplication */
    private static class CondomApplication extends Application {
        /* renamed from: a */
        private final CondomCore f15358a;
        /* renamed from: b */
        private final Application f15359b;
        /* renamed from: c */
        private final String f15360c;

        public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
            if (VERSION.SDK_INT >= 14) {
                this.f15359b.registerComponentCallbacks(componentCallbacks);
            }
        }

        public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
            if (VERSION.SDK_INT >= 14) {
                this.f15359b.unregisterComponentCallbacks(componentCallbacks);
            }
        }

        public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            if (VERSION.SDK_INT >= 14) {
                this.f15359b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            if (VERSION.SDK_INT >= 14) {
                this.f15359b.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        }

        public void registerOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
            if (VERSION.SDK_INT >= 18) {
                this.f15359b.registerOnProvideAssistDataListener(onProvideAssistDataListener);
            }
        }

        public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener onProvideAssistDataListener) {
            if (VERSION.SDK_INT >= 18) {
                this.f15359b.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
            }
        }

        public Context getBaseContext() {
            this.f15358a.logConcern(this.f15360c, "Application.getBaseContext");
            return super.getBaseContext();
        }

        public void attachBaseContext(Context context) {
            super.attachBaseContext(context);
        }

        CondomApplication(CondomCore condomCore, Application application, String str) {
            this.f15358a = condomCore;
            this.f15359b = application;
            this.f15360c = CondomCore.buildLogTag("CondomApp", "CondomApp.", str);
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomContext$CondomContentResolver */
    private class CondomContentResolver extends ContentResolverWrapper {
        public IContentProvider acquireUnstableProvider(Context context, String str) {
            if (!CondomContext.this.mCondom.shouldAllowProvider(context, str, 8192)) {
                return null;
            }
            return super.acquireUnstableProvider(context, str);
        }

        public IContentProvider acquireProvider(Context context, String str) {
            if (!CondomContext.this.mCondom.shouldAllowProvider(context, str, 8192)) {
                return null;
            }
            return super.acquireProvider(context, str);
        }

        CondomContentResolver(Context context, ContentResolver contentResolver) {
            super(context, contentResolver);
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomContext$CondomPackageManager */
    class CondomPackageManager extends PackageManagerWrapper {
        public List<ResolveInfo> queryBroadcastReceivers(final Intent intent, final int i) {
            return CondomContext.this.mCondom.proceedQuery(OutboundType.QUERY_RECEIVERS, intent, new WrappedValueProcedure<List<ResolveInfo>>() {
                /* renamed from: a */
                public List<ResolveInfo> mo25408b() {
                    return CondomPackageManager.super.queryBroadcastReceivers(intent, i);
                }
            });
        }

        public List<ResolveInfo> queryIntentServices(final Intent intent, final int i) {
            final int flags = intent.getFlags();
            return CondomContext.this.mCondom.proceedQuery(OutboundType.QUERY_SERVICES, intent, new WrappedValueProcedure<List<ResolveInfo>>() {
                /* renamed from: a */
                public List<ResolveInfo> mo25408b() {
                    List<ResolveInfo> b = CondomPackageManager.super.queryIntentServices(intent, i);
                    CondomContext.this.mCondom.filterCandidates(OutboundType.QUERY_SERVICES, intent.setFlags(flags), b, CondomContext.this.TAG, true);
                    return b;
                }
            });
        }

        public ResolveInfo resolveService(final Intent intent, final int i) {
            final int flags = intent.getFlags();
            return (ResolveInfo) CondomContext.this.mCondom.proceed(OutboundType.QUERY_SERVICES, intent, null, new WrappedValueProcedure<ResolveInfo>() {
                /* renamed from: a */
                public ResolveInfo mo25408b() {
                    if (!CondomContext.this.mCondom.mExcludeBackgroundServices && CondomContext.this.mCondom.mOutboundJudge == null) {
                        return CondomPackageManager.super.resolveService(intent, i);
                    }
                    List d = CondomPackageManager.super.queryIntentServices(intent, i);
                    return CondomContext.this.mCondom.filterCandidates(OutboundType.QUERY_SERVICES, intent.setFlags(flags), d, CondomContext.this.TAG, false);
                }
            });
        }

        public ProviderInfo resolveContentProvider(String str, int i) {
            ProviderInfo resolveContentProvider = super.resolveContentProvider(str, i);
            if (!CondomContext.this.mCondom.shouldAllowProvider(resolveContentProvider)) {
                return null;
            }
            return resolveContentProvider;
        }

        public List<PackageInfo> getInstalledPackages(int i) {
            CondomContext.this.mCondom.logConcern(CondomContext.this.TAG, "PackageManager.getInstalledPackages");
            return super.getInstalledPackages(i);
        }

        public List<ApplicationInfo> getInstalledApplications(int i) {
            CondomContext.this.mCondom.logConcern(CondomContext.this.TAG, "PackageManager.getInstalledApplications");
            return super.getInstalledApplications(i);
        }

        CondomPackageManager(PackageManager packageManager) {
            super(packageManager);
        }
    }

    /* renamed from: com.oasisfeng.condom.CondomContext$PseudoContextImpl */
    private static class PseudoContextImpl extends PseudoContextWrapper {
        public PseudoContextImpl(CondomContext condomContext) {
            super(condomContext);
        }
    }

    public static CondomContext wrap(Context context, String str) {
        return wrap(context, str, new CondomOptions());
    }

    public static CondomContext wrap(Context context, String str, CondomOptions condomOptions) {
        CondomContext condomContext;
        if (context instanceof CondomContext) {
            return (CondomContext) context;
        }
        Context applicationContext = context.getApplicationContext();
        CondomCore condomCore = new CondomCore(context, condomOptions);
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            CondomApplication condomApplication = new CondomApplication(condomCore, application, str);
            CondomContext condomContext2 = new CondomContext(condomCore, condomApplication, str);
            if (context == applicationContext) {
                condomContext = condomContext2;
            } else {
                condomContext = new CondomContext(condomCore, application, str);
            }
            condomApplication.attachBaseContext(condomContext);
            return condomContext2;
        }
        return new CondomContext(condomCore, context == applicationContext ? null : new CondomContext(condomCore, applicationContext, str), str);
    }

    public CondomContext setDryRun(boolean z) {
        if (z == this.mCondom.mDryRun) {
            return this;
        }
        this.mCondom.mDryRun = z;
        if (z) {
            Log.w(this.TAG, "Start dry-run mode, no outbound requests will be blocked actually, despite later stated in log.");
        } else {
            Log.w(this.TAG, "Stop dry-run mode.");
        }
        return this;
    }

    @Deprecated
    public CondomContext preventWakingUpStoppedPackages(boolean z) {
        this.mCondom.mExcludeStoppedPackages = z;
        return this;
    }

    @Deprecated
    public CondomContext preventBroadcastToBackgroundPackages(boolean z) {
        this.mCondom.mExcludeBackgroundReceivers = z;
        return this;
    }

    @Deprecated
    public CondomContext preventServiceInBackgroundPackages(boolean z) {
        this.mCondom.mExcludeBackgroundServices = z;
        return this;
    }

    public boolean bindService(final Intent intent, final ServiceConnection serviceConnection, final int i) {
        boolean booleanValue = ((Boolean) this.mCondom.proceed(OutboundType.BIND_SERVICE, intent, Boolean.FALSE, new WrappedValueProcedure<Boolean>() {
            /* renamed from: a */
            public Boolean mo25408b() {
                return Boolean.valueOf(CondomContext.super.bindService(intent, serviceConnection, i));
            }
        })).booleanValue();
        if (booleanValue) {
            this.mCondom.logIfOutboundPass(this.TAG, intent, CondomCore.getTargetPackage(intent), CondomEvent.BIND_PASS);
        }
        return booleanValue;
    }

    public ComponentName startService(final Intent intent) {
        ComponentName componentName = (ComponentName) this.mCondom.proceed(OutboundType.START_SERVICE, intent, null, new WrappedValueProcedure<ComponentName>() {
            /* renamed from: a */
            public ComponentName mo25408b() {
                return CondomContext.super.startService(intent);
            }
        });
        if (componentName != null) {
            this.mCondom.logIfOutboundPass(this.TAG, intent, componentName.getPackageName(), CondomEvent.START_PASS);
        }
        return componentName;
    }

    public void sendBroadcast(final Intent intent) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendBroadcast(intent);
            }
        });
    }

    public void sendBroadcast(final Intent intent, final String str) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendBroadcast(intent, str);
            }
        });
    }

    public void sendBroadcastAsUser(final Intent intent, final UserHandle userHandle) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendBroadcastAsUser(intent, userHandle);
            }
        });
    }

    public void sendBroadcastAsUser(final Intent intent, final UserHandle userHandle, final String str) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendBroadcastAsUser(intent, userHandle, str);
            }
        });
    }

    public void sendOrderedBroadcast(final Intent intent, final String str) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendOrderedBroadcast(intent, str);
            }
        });
    }

    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        CondomCore condomCore = this.mCondom;
        final Intent intent2 = intent;
        final String str3 = str;
        final BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        final Handler handler2 = handler;
        final int i2 = i;
        final String str4 = str2;
        final Bundle bundle2 = bundle;
        C47638 r0 = new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendOrderedBroadcast(intent2, str3, broadcastReceiver2, handler2, i2, str4, bundle2);
            }
        };
        Intent intent3 = intent;
        condomCore.proceedBroadcast(intent, r0);
    }

    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
        CondomCore condomCore = this.mCondom;
        final Intent intent2 = intent;
        final UserHandle userHandle2 = userHandle;
        final String str3 = str;
        final BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        final Handler handler2 = handler;
        final int i2 = i;
        final String str4 = str2;
        final Bundle bundle2 = bundle;
        C47649 r0 = new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendOrderedBroadcastAsUser(intent2, userHandle2, str3, broadcastReceiver2, handler2, i2, str4, bundle2);
            }
        };
        Intent intent3 = intent;
        condomCore.proceedBroadcast(intent, r0);
    }

    public void sendStickyBroadcast(final Intent intent) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendStickyBroadcast(intent);
            }
        });
    }

    public void sendStickyBroadcastAsUser(final Intent intent, final UserHandle userHandle) {
        this.mCondom.proceedBroadcast(intent, new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendStickyBroadcastAsUser(intent, userHandle);
            }
        });
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        CondomCore condomCore = this.mCondom;
        final Intent intent2 = intent;
        final BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        final Handler handler2 = handler;
        final int i2 = i;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C475212 r0 = new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendStickyOrderedBroadcast(intent2, broadcastReceiver2, handler2, i2, str2, bundle2);
            }
        };
        Intent intent3 = intent;
        condomCore.proceedBroadcast(intent, r0);
    }

    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
        CondomCore condomCore = this.mCondom;
        final Intent intent2 = intent;
        final UserHandle userHandle2 = userHandle;
        final BroadcastReceiver broadcastReceiver2 = broadcastReceiver;
        final Handler handler2 = handler;
        final int i2 = i;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C475313 r0 = new WrappedProcedure() {
            /* renamed from: a */
            public void mo25409a() {
                CondomContext.super.sendStickyOrderedBroadcastAsUser(intent2, userHandle2, broadcastReceiver2, handler2, i2, str2, bundle2);
            }
        };
        Intent intent3 = intent;
        condomCore.proceedBroadcast(intent, r0);
    }

    public ContentResolver getContentResolver() {
        return (ContentResolver) this.mContentResolver.get();
    }

    public PackageManager getPackageManager() {
        return (PackageManager) this.mPackageManager.get();
    }

    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public Context getBaseContext() {
        this.mCondom.logConcern(this.TAG, "getBaseContext");
        return (Context) this.mBaseContext.get();
    }

    private CondomContext(CondomCore condomCore, Context context, String str) {
        super(condomCore.mBase);
        final Context context2 = condomCore.mBase;
        this.mCondom = condomCore;
        if (context == 0) {
            context = this;
        }
        this.mApplicationContext = context;
        this.mBaseContext = new Lazy<Context>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Context create() {
                return new PseudoContextImpl(CondomContext.this);
            }
        };
        this.mPackageManager = new Lazy<PackageManager>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public PackageManager create() {
                return new CondomPackageManager(context2.getPackageManager());
            }
        };
        this.mContentResolver = new Lazy<ContentResolver>() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public ContentResolver create() {
                CondomContext condomContext = CondomContext.this;
                Context context = context2;
                return new CondomContentResolver(context, context.getContentResolver());
            }
        };
        this.TAG = CondomCore.buildLogTag("Condom", "Condom.", str);
    }
}
