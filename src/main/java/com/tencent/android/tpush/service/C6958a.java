package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.C6860a;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.C6901c;
import com.tencent.android.tpush.common.C6914l;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.channel.C7000a;
import com.tencent.android.tpush.service.channel.C7005b;
import com.tencent.android.tpush.service.channel.C7030c.C7031a;
import com.tencent.android.tpush.service.channel.exception.ChannelException;
import com.tencent.android.tpush.service.channel.protocol.TpnsClientReport;
import com.tencent.android.tpush.service.channel.protocol.TpnsClientReportReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsRegisterReq;
import com.tencent.android.tpush.service.channel.protocol.TpnsRegisterRsp;
import com.tencent.android.tpush.service.channel.protocol.TpnsUnregisterReq;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.p590c.C6987a;
import com.tencent.android.tpush.service.p594d.C7046a;
import com.tencent.android.tpush.service.p595e.C7048a;
import com.tencent.android.tpush.service.p595e.C7050c;
import com.tencent.android.tpush.service.p595e.C7053f;
import com.tencent.android.tpush.service.p595e.C7055h;
import com.tencent.android.tpush.service.p595e.C7056i;
import com.tencent.android.tpush.stat.p597b.C7074c;
import com.tencent.mid.sotrage.StorageInterface;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.a */
public class C6958a {
    /* renamed from: a */
    public static final String f23084a = C6958a.class.getSimpleName();
    /* renamed from: b */
    private static C6958a f23085b;
    /* renamed from: c */
    private static volatile C6968a f23086c;
    /* renamed from: d */
    private static volatile C6970c f23087d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean f23088e = false;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public ArrayList<Intent> f23089f = new ArrayList<>();

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.a$a */
    private class C6968a extends BroadcastReceiver {
        private C6968a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                if (C6958a.this.f23088e) {
                    C6901c.m29459a().mo33104a((Runnable) new C6969b(context, intent));
                } else if (C6958a.this.f23089f.size() < 10) {
                    C6958a.this.f23089f.add(intent);
                    String str = C6958a.f23084a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("PackageChangesReceiver add intend to beforeInitedIntents,action:");
                    sb.append(intent.getAction());
                    sb.append(", size:");
                    sb.append(C6958a.this.f23089f.size());
                    C6864a.m29305f(str, sb.toString());
                } else {
                    C6864a.m29309j(C6958a.f23084a, "Too much beforeInitedIntents. discard it");
                }
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.a$b */
    private class C6969b implements Runnable {
        /* renamed from: b */
        private Context f23126b = null;
        /* renamed from: c */
        private Intent f23127c = null;

        public C6969b(Context context, Intent intent) {
            this.f23126b = context;
            this.f23127c = intent;
        }

        public void run() {
            try {
                String action = this.f23127c.getAction();
                if (action != null) {
                    if (!"android.intent.action.PACKAGE_ADDED".equals(action)) {
                        if (!"android.intent.action.PACKAGE_REPLACED".equals(action)) {
                            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                                C6958a.this.m29713b(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.REGISTER.V4".equals(action)) {
                                C6958a.this.m29715c(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.UNREGISTER.V4".equals(action)) {
                                C6958a.this.m29720e(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.ENABLE_DEBUG.V4".equals(action)) {
                                C6958a.this.m29726h(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.MSG_ACK.V4".equals(action)) {
                                C6987a.m29846a().mo33327a(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.TAG.V4".equals(action)) {
                                C6958a.this.m29718d(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.PUSH_CLICK.RESULT.V4".equals(action)) {
                                C6987a.m29846a().mo33346c(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.PUSH_CANCELLED.RESULT.V4".equals(action)) {
                                C6987a.m29846a().mo33346c(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.ack.sdk2srv.V4".equals(action)) {
                                C7046a.m30126a(this.f23127c);
                            } else if ("com.tencent.android.tpush.action.UPDATE_OTHER_PUSH_TOKEN.V4".equals(action)) {
                                C6958a.this.m29722f(this.f23126b, this.f23127c);
                            } else if ("com.tencent.android.tpush.action.COMM_REPORT.V4".equals(action)) {
                                C6958a.this.m29724g(this.f23126b, this.f23127c);
                            }
                        }
                    }
                    C6958a.this.m29702a(this.f23126b, this.f23127c);
                }
            } catch (Throwable th) {
                String str = C6958a.f23084a;
                StringBuilder sb = new StringBuilder();
                sb.append(C6958a.f23084a);
                sb.append(" run error.");
                C6864a.m29302d(str, sb.toString(), th);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.service.a$c */
    private class C6970c extends BroadcastReceiver {
        private C6970c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                if (C6958a.this.f23088e) {
                    C6901c.m29459a().mo33104a((Runnable) new C6969b(context, intent));
                } else if (C6958a.this.f23089f.size() < 10) {
                    C6958a.this.f23089f.add(intent);
                    String str = C6958a.f23084a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("TPushAppReceiver add intend to beforeInitedIntents,action:");
                    sb.append(intent.getAction());
                    sb.append(", size:");
                    sb.append(C6958a.this.f23089f.size());
                    C6864a.m29305f(str, sb.toString());
                } else {
                    C6864a.m29309j(C6958a.f23084a, "Too much beforeInitedIntents. discard it");
                }
            }
        }
    }

    /* renamed from: a */
    public void mo33263a(Context context) {
        String str = f23084a;
        StringBuilder sb = new StringBuilder();
        sb.append("handleServiceInited, beforeInitedIntents size:");
        sb.append(this.f23089f.size());
        C6864a.m29305f(str, sb.toString());
        this.f23088e = true;
        try {
            Intent intent = new Intent("com.tencent.android.tpush.action.SERVICE_START.V4");
            intent.putExtra("pkg", C6973b.m29776f().getPackageName());
            intent.putExtra("ver", 4.03f);
            C6973b.m29776f().sendBroadcast(intent);
        } catch (Throwable th) {
            C6864a.m29302d(f23084a, "sendBroadcast", th);
        }
        Iterator it = this.f23089f.iterator();
        while (it.hasNext()) {
            C6901c.m29459a().mo33104a((Runnable) new C6969b(context, (Intent) it.next()));
        }
        this.f23089f.clear();
    }

    private C6958a() {
    }

    /* renamed from: a */
    public static synchronized C6958a m29694a() {
        C6958a aVar;
        synchronized (C6958a.class) {
            if (f23085b == null) {
                f23085b = new C6958a();
            }
            aVar = f23085b;
        }
        return aVar;
    }

    /* renamed from: b */
    public synchronized void mo33264b(Context context) {
        if (context != null) {
            try {
                if (f23086c == null) {
                    f23086c = new C6968a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addDataScheme("package");
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    context.registerReceiver(f23086c, intentFilter);
                }
            } catch (Exception e) {
                C6864a.m29302d(f23084a, "registerReceiver", e);
            }
            try {
                if (f23087d == null) {
                    f23087d = new C6970c();
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("com.tencent.android.tpush.action.REGISTER.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.UNREGISTER.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.ENABLE_DEBUG.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.MSG_ACK.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.TAG.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.PUSH_CLICK.RESULT.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.PUSH_CANCELLED.RESULT.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.ack.sdk2srv.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.reserved.act.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.UPDATE_OTHER_PUSH_TOKEN.V4");
                    intentFilter2.addAction("com.tencent.android.tpush.action.COMM_REPORT.V4");
                    context.registerReceiver(f23087d, intentFilter2);
                }
            } catch (Exception e2) {
                C6864a.m29302d(f23084a, "registerReceiver", e2);
            }
        }
        return;
    }

    /* renamed from: c */
    public synchronized void mo33265c(Context context) {
        this.f23089f.clear();
        if (context != null) {
            if (f23086c != null) {
                C6914l.m29513a(context, (BroadcastReceiver) f23086c);
                f23086c = null;
            }
            if (f23087d != null) {
                C6914l.m29513a(context, (BroadcastReceiver) f23087d);
                f23087d = null;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29702a(final Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && context != null && C7056i.m30213h(context, dataString.substring(8))) {
            C6973b.m29763a().mo33289d();
            C6901c.m29459a().mo33106a(new Runnable() {
                public void run() {
                    C6914l.m29524e(context);
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m29713b(final Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString != null && context != null) {
            final String substring = dataString.substring(8);
            C6901c.m29459a().mo33106a(new Runnable() {
                public void run() {
                    try {
                        context.getPackageManager().getApplicationInfo(substring, 8192);
                    } catch (NameNotFoundException unused) {
                        String str = C6958a.f23084a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("appRemoveHandler check app:");
                        sb.append(substring);
                        sb.append(" has been removed.");
                        C6864a.m29298c(str, sb.toString());
                        CacheManager.removeRegisterInfos(substring);
                        C6982c.m29815a().mo33317a(substring);
                    } catch (Throwable unused2) {
                    }
                }
            }, 30000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29717d(final Context context) {
        if (C7048a.m30138a(context) == 3) {
            final long currentTimeMillis = System.currentTimeMillis();
            long b = C7053f.m30157b(context, "com.tencent.android.tpush.action.next.applist.ts.V4", 0);
            boolean z = true;
            if (b != 0 && currentTimeMillis <= b && Math.abs(b - currentTimeMillis) <= 172800000) {
                z = false;
            }
            if (z) {
                C6901c.m29459a().mo33106a(new Runnable() {
                    public void run() {
                        TpnsClientReport tpnsClientReport = new TpnsClientReport();
                        tpnsClientReport.commandId = 0;
                        tpnsClientReport.signal = C7056i.m30222p(context).toString();
                        TpnsClientReportReq tpnsClientReportReq = new TpnsClientReportReq();
                        tpnsClientReportReq.reportMsgs = new ArrayList<>();
                        tpnsClientReportReq.reportMsgs.add(tpnsClientReport);
                        C7005b.m29964a().mo33389a((JceStruct) tpnsClientReportReq, (C7031a) new C7031a() {
                            /* renamed from: a */
                            public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                                if (i == 0) {
                                    try {
                                        C7053f.m30154a(context, "com.tencent.android.tpush.action.next.applist.ts.V4", currentTimeMillis + 86400000);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }

                            /* renamed from: a */
                            public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                                String str = C6958a.f23084a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(">>> reportReq onMessageSendFailed(");
                                sb.append(jceStruct);
                                String str2 = ", ";
                                sb.append(str2);
                                sb.append(channelException);
                                sb.append(str2);
                                sb.append(aVar);
                                sb.append(")");
                                C6864a.m29308i(str, sb.toString());
                            }

                            /* renamed from: a */
                            public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                                String str = C6958a.f23084a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(">>> reportReq onMessageDiscarded(");
                                sb.append(jceStruct);
                                sb.append(", ");
                                sb.append(aVar);
                                sb.append(")");
                                C6864a.m29308i(str, sb.toString());
                            }
                        });
                    }
                }, 5000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m29715c(Context context, Intent intent) {
        boolean z;
        String str;
        Context context2 = context;
        Intent intent2 = intent;
        if (context2 != null && intent2 != null) {
            final String decrypt = Rijndael.decrypt(intent2.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent2.getStringExtra("accKey"));
            final String decrypt3 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_PACK_NAME));
            String decrypt4 = Rijndael.decrypt(intent2.getStringExtra("account"));
            int intExtra = intent2.getIntExtra("accountType", -1);
            String decrypt5 = Rijndael.decrypt(intent2.getStringExtra(Constants.FLAG_TICKET));
            int intExtra2 = intent2.getIntExtra(Constants.FLAG_TICKET_TYPE, -1);
            String decrypt6 = Rijndael.decrypt(intent2.getStringExtra("qua"));
            String stringExtra = intent2.getStringExtra("appVer");
            String decrypt7 = Rijndael.decrypt(intent2.getStringExtra("reserved"));
            String str2 = f23084a;
            StringBuilder sb = new StringBuilder();
            sb.append("receive intent, reserved: ");
            sb.append(decrypt7);
            Log.d(str2, sb.toString());
            long longExtra = intent2.getLongExtra("accChannel", -1);
            String stringExtra2 = intent2.getStringExtra("url");
            String stringExtra3 = intent2.getStringExtra("otherToken");
            String stringExtra4 = intent2.getStringExtra("payload");
            long longExtra2 = intent2.getLongExtra("otherPushType", -1);
            long longExtra3 = intent2.getLongExtra("otherPushTokenOpType", -1);
            boolean booleanExtra = intent2.getBooleanExtra("aidl", false);
            try {
                if (!C7056i.m30194b(decrypt6)) {
                    z = booleanExtra;
                    CacheManager.setQua(context2, Long.parseLong(decrypt), decrypt6);
                } else {
                    z = booleanExtra;
                }
                try {
                    str = TpnsSecurity.getEncryptAPKSignature(context2.createPackageContext(decrypt3, 0));
                } catch (Throwable unused) {
                    str = "";
                }
                C6982c a = C6982c.m29815a();
                long parseLong = Long.parseLong(decrypt);
                String a2 = C7050c.m30146a();
                final boolean z2 = z;
                final Context context3 = context;
                C69634 r1 = new C7031a() {
                    /* renamed from: a */
                    public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                    }

                    /* renamed from: a */
                    public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                        C7005b.m29964a().mo33388a(true, decrypt3);
                        if (i == 0) {
                            if (XGPushConfig.enableDebug) {
                                String str = C6958a.f23084a;
                                StringBuilder sb = new StringBuilder();
                                sb.append(">> Register [accId = ");
                                sb.append(decrypt);
                                sb.append(" , packName = ");
                                sb.append(decrypt3);
                                sb.append(" , rsp = ");
                                sb.append(aVar.mo33364c());
                                sb.append("]");
                                C6864a.m29298c(str, sb.toString());
                            }
                            C6958a.this.m29696a(i, (TpnsRegisterRsp) jceStruct2, (TpnsRegisterReq) jceStruct, aVar, decrypt3, z2);
                            try {
                                C6958a.this.m29717d(context3);
                            } catch (Throwable th) {
                                C6864a.m29302d(C6958a.f23084a, "handler app info failed", th);
                            }
                        } else {
                            String str2 = C6958a.f23084a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(">> Register ack fail responseCode = ");
                            sb2.append(i);
                            C6864a.m29308i(str2, sb2.toString());
                            int i2 = i;
                            C6958a.this.m29700a(i2, "服务器处理失败，返回错误", (TpnsRegisterReq) jceStruct, aVar, decrypt3);
                        }
                    }

                    /* renamed from: a */
                    public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                        String str = C6958a.f23084a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("@@ TpnsMessage.IEventListener.onMessageSendFailed ");
                        sb.append(channelException.errorCode);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(channelException.getMessage());
                        C6864a.m29309j(str, sb.toString());
                        C6958a.this.m29700a(channelException.errorCode, channelException.getMessage(), (TpnsRegisterReq) jceStruct, aVar, decrypt3);
                    }
                };
                a.mo33314a(parseLong, decrypt2, a2, decrypt4, decrypt5, intExtra2, str, stringExtra, decrypt7, longExtra2, stringExtra2, stringExtra4, stringExtra3, longExtra3, longExtra, intExtra, r1);
            } catch (Exception e) {
                String str3 = f23084a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(">> register error ");
                sb2.append(e);
                C6864a.m29308i(str3, sb2.toString());
                String str4 = f23084a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(">> register error-> ");
                sb3.append(Log.getStackTraceString(e));
                C6864a.m29308i(str4, sb3.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m29718d(Context context, Intent intent) {
        if (context != null && intent != null) {
            long longExtra = intent.getLongExtra("accId", -1);
            String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
            int intExtra = intent.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TAG_NAME));
            final String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
            C6982c a = C6982c.m29815a();
            final long j = longExtra;
            final int i = intExtra;
            final String str = decrypt2;
            final String str2 = decrypt;
            C69645 r2 = new C7031a() {
                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    String str = " , tagName = ";
                    if (i == 0) {
                        String str2 = C6958a.f23084a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Set tag ack success  [accId = ");
                        sb.append(j);
                        sb.append(" , tagtype = ");
                        sb.append(i);
                        sb.append(str);
                        sb.append(str);
                        sb.append(", packName = ");
                        sb.append(str2);
                        sb.append(" , rsp = ");
                        sb.append(aVar.mo33364c());
                        sb.append("]");
                        C6864a.m29305f(str2, sb.toString());
                    } else {
                        String str3 = C6958a.f23084a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Set tag ack failed with responseCode = ");
                        sb2.append(i);
                        sb2.append(str);
                        sb2.append(str);
                        C6864a.m29309j(str3, sb2.toString());
                    }
                    C6958a.this.m29699a(i, str, i, str2, stringExtra);
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    if (channelException != null) {
                        C6958a.this.m29699a(channelException.errorCode, str, i, str2, stringExtra);
                    }
                }

                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                    String str = C6958a.f23084a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Set tag onMessageDiscarded  , tagName = ");
                    sb.append(str);
                    C6864a.m29307h(str, sb.toString());
                }
            };
            a.mo33312a(longExtra, decrypt, i, str, (C7031a) r2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m29720e(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra("accKey"));
            final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra("token"));
            CacheManager.UnregisterInfoByPkgName(decrypt3);
            try {
                C6982c.m29815a().mo33318a(decrypt4, C7050c.m30146a(), Long.parseLong(decrypt), decrypt2, decrypt3, (C7031a) new C7031a() {
                    /* renamed from: a */
                    public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                    }

                    /* renamed from: a */
                    public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                        if (i == 0) {
                            String str = C6958a.f23084a;
                            StringBuilder sb = new StringBuilder();
                            sb.append(">> UnRegister ack with [accId = ");
                            sb.append(decrypt);
                            sb.append(" , packName = ");
                            sb.append(decrypt3);
                            sb.append(" , rsp = ");
                            sb.append(aVar.mo33364c());
                            sb.append("]");
                            C6864a.m29305f(str, sb.toString());
                            C6958a.this.m29697a(i, (TpnsUnregisterReq) jceStruct, aVar, decrypt3);
                            return;
                        }
                        String str2 = C6958a.f23084a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(">> unregeister ack failed responseCode=");
                        sb2.append(i);
                        C6864a.m29308i(str2, sb2.toString());
                        int i2 = i;
                        C6958a.this.m29701a(i2, "服务器处理失败，返回错误", (TpnsUnregisterReq) jceStruct, aVar, decrypt3);
                    }

                    /* renamed from: a */
                    public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                        String str = C6958a.f23084a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("@@ unregister onMessageSendFailed ");
                        sb.append(channelException.errorCode);
                        sb.append(StorageInterface.KEY_SPLITER);
                        sb.append(channelException.getMessage());
                        C6864a.m29308i(str, sb.toString());
                        C6958a.this.m29701a(channelException.errorCode, channelException.getMessage(), (TpnsUnregisterReq) jceStruct, aVar, decrypt3);
                    }
                });
            } catch (Exception e) {
                String str = f23084a;
                StringBuilder sb = new StringBuilder();
                sb.append(">>> unregister error ");
                sb.append(e);
                C6864a.m29308i(str, sb.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m29722f(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
            String decrypt2 = Rijndael.decrypt(intent.getStringExtra("token"));
            String decrypt3 = Rijndael.decrypt(intent.getStringExtra("other_push_type"));
            String decrypt4 = Rijndael.decrypt(intent.getStringExtra(Constants.OTHER_PUSH_TOKEN));
            String str = f23084a;
            StringBuilder sb = new StringBuilder();
            String str2 = "binder other push token with accid = ";
            sb.append(str2);
            sb.append(decrypt);
            String str3 = "  token = ";
            sb.append(str3);
            sb.append(decrypt2);
            String str4 = " otherPushType = ";
            sb.append(str4);
            sb.append(decrypt3);
            String str5 = " otherPushToken = ";
            sb.append(str5);
            sb.append(decrypt4);
            C6864a.m29303e(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(decrypt);
            sb2.append(str3);
            sb2.append(decrypt2);
            sb2.append(str4);
            sb2.append(decrypt3);
            sb2.append(str5);
            sb2.append(decrypt4);
            C6914l.m29510a(sb2.toString(), context);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(decrypt);
            sb3.append("otherpush");
            String a = C7055h.m30169a(context, sb3.toString(), "");
            if (!C7056i.m30194b(a)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(decrypt);
                sb4.append("otherpushts");
                long a2 = C7055h.m30167a(context, sb4.toString(), -1);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(decrypt2);
                sb5.append(":");
                sb5.append(decrypt4);
                if (!a.equals(sb5.toString()) || Math.abs(System.currentTimeMillis() - a2) <= 86400000) {
                    C6864a.m29305f(f23084a, "OtherToken or Mid changed , go on binder");
                } else {
                    String str6 = f23084a;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Already binder other push succeed token with accid = ");
                    sb6.append(decrypt);
                    sb6.append(str3);
                    sb6.append(decrypt2);
                    sb6.append(str4);
                    sb6.append(decrypt3);
                    sb6.append(str5);
                    sb6.append(decrypt4);
                    C6864a.m29305f(str6, sb6.toString());
                    return;
                }
            }
            C6982c a3 = C6982c.m29815a();
            long parseLong = Long.parseLong(decrypt);
            final String str7 = decrypt2;
            final String str8 = decrypt3;
            final String str9 = decrypt4;
            final Context context2 = context;
            C69667 r1 = new C7031a() {
                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                }

                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    if (i == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bind OtherPushToken success ack with= ");
                        sb.append(decrypt);
                        sb.append("  token = ");
                        sb.append(str7);
                        String str = " otherPushType = ";
                        sb.append(str);
                        sb.append(str8);
                        String str2 = " otherPushToken = ";
                        sb.append(str2);
                        sb.append(str9);
                        C6914l.m29510a(sb.toString(), context2);
                        String str3 = C6958a.f23084a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(">> bind OtherPushToken success ack with [accId = ");
                        sb2.append(decrypt);
                        sb2.append("  , rsp = ");
                        sb2.append(i);
                        sb2.append("]  token = ");
                        sb2.append(str7);
                        sb2.append(str);
                        sb2.append(str8);
                        sb2.append(str2);
                        sb2.append(str9);
                        C6864a.m29305f(str3, sb2.toString());
                        Context context = context2;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(decrypt);
                        sb3.append("otherpush");
                        String sb4 = sb3.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str7);
                        sb5.append(":");
                        sb5.append(str9);
                        C7055h.m30172b(context, sb4, sb5.toString());
                        Context context2 = context2;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(decrypt);
                        sb6.append("ts");
                        C7055h.m30171b(context2, sb6.toString(), System.currentTimeMillis());
                        return;
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("updateOtherPushToken ack failed responseCode=");
                    sb7.append(i);
                    C6914l.m29510a(sb7.toString(), context2);
                    String str4 = C6958a.f23084a;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(">> updateOtherPushToken ack failed responseCode=");
                    sb8.append(i);
                    C6864a.m29309j(str4, sb8.toString());
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    String str = C6958a.f23084a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("@@ updateOtherPushToken onMessageSendFailed ");
                    sb.append(channelException.errorCode);
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(channelException.getMessage());
                    C6864a.m29309j(str, sb.toString());
                }
            };
            a3.mo33313a(parseLong, decrypt2, decrypt3, decrypt4, (C7031a) r1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m29724g(Context context, Intent intent) {
        if (context != null && intent != null) {
            final String decrypt = Rijndael.decrypt(intent.getStringExtra("accessId"));
            final String stringExtra = intent.getStringExtra(AppEntity.KEY_PKG_NAME_STR);
            C6982c a = C6982c.m29815a();
            final Context context2 = context;
            final Intent intent2 = intent;
            C69678 r1 = new C7031a() {
                /* renamed from: a */
                public void mo33270a(JceStruct jceStruct, C7000a aVar) {
                }

                /* renamed from: a */
                public void mo33269a(JceStruct jceStruct, int i, JceStruct jceStruct2, C7000a aVar) {
                    if (i == 0) {
                        String str = C6958a.f23084a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(">> sendCommReportMessage ack with [accId = ");
                        sb.append(decrypt);
                        sb.append("  , rsp = ");
                        sb.append(i);
                        sb.append("]");
                        C6864a.m29305f(str, sb.toString());
                        C6860a.m29262d(context2, stringExtra, intent2.toURI());
                        return;
                    }
                    String str2 = C6958a.f23084a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(">> sendCommReportMessage ack failed responseCode=");
                    sb2.append(i);
                    C6864a.m29309j(str2, sb2.toString());
                }

                /* renamed from: a */
                public void mo33271a(JceStruct jceStruct, ChannelException channelException, C7000a aVar) {
                    String str = C6958a.f23084a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("@@ sendCommReportMessage onMessageSendFailed ");
                    sb.append(channelException.errorCode);
                    sb.append(StorageInterface.KEY_SPLITER);
                    sb.append(channelException.getMessage());
                    C6864a.m29309j(str, sb.toString());
                }
            };
            a.mo33315a(intent, (C7031a) r1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m29726h(Context context, Intent intent) {
        if (intent != null && context != null) {
            boolean booleanExtra = intent.getBooleanExtra("debugMode", false);
            XGPushConfig.enableDebug = booleanExtra;
            if (booleanExtra) {
                C6864a.m29282a(2);
            } else {
                C6864a.m29282a(3);
            }
        }
    }

    /* renamed from: a */
    private static boolean m29711a(TpnsRegisterReq tpnsRegisterReq) {
        if (tpnsRegisterReq == null) {
            return false;
        }
        String str = tpnsRegisterReq.reserved;
        if (str == null) {
            return false;
        }
        return str.contains("ccver");
    }

    /* renamed from: a */
    private void m29695a(int i, TpnsRegisterReq tpnsRegisterReq, String str, String str2, long j, String str3) {
        Intent a = C7056i.m30173a(i, str2, 1);
        a.putExtra("accId", tpnsRegisterReq.accessId);
        if (!(tpnsRegisterReq.account == null || tpnsRegisterReq.account.length() == 0)) {
            a.putExtra("account", tpnsRegisterReq.account);
        }
        if (!(str == null || str.length() == 0)) {
            a.putExtra("token", str);
        }
        if (!(tpnsRegisterReq.ticket == null || tpnsRegisterReq.ticket.length() == 0)) {
            a.putExtra(Constants.FLAG_TICKET, tpnsRegisterReq.ticket);
            a.putExtra(Constants.FLAG_TICKET_TYPE, tpnsRegisterReq.ticketType);
        }
        if (!(tpnsRegisterReq.deviceId == null || tpnsRegisterReq.deviceId.length() == 0)) {
            a.putExtra(Constants.FLAG_DEVICE_ID, tpnsRegisterReq.deviceId);
        }
        if (j >= 0) {
            a.putExtra("otherPushType", j);
            if (!C6914l.m29521c(str3)) {
                a.putExtra("otherPushToken", str3);
            }
        }
        if (m29711a(tpnsRegisterReq)) {
            a.putExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, true);
        }
        C6973b.m29776f().sendBroadcast(a);
    }

    /* renamed from: a */
    private void m29698a(int i, String str) {
        C6973b.m29776f().sendBroadcast(C7056i.m30173a(i, str, 2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29699a(int i, String str, int i2, String str2, String str3) {
        Intent a = C7056i.m30173a(i, str2, 3);
        a.putExtra(Constants.FLAG_TAG_NAME, Rijndael.encrypt(str));
        a.putExtra(Constants.FLAG_TAG_TYPE, i2);
        a.putExtra(Constants.FLAG_TAG_OPER_NAME, str3);
        C6973b.m29776f().sendBroadcast(a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29696a(int i, TpnsRegisterRsp tpnsRegisterRsp, TpnsRegisterReq tpnsRegisterReq, C7000a aVar, String str, boolean z) {
        TpnsRegisterRsp tpnsRegisterRsp2 = tpnsRegisterRsp;
        TpnsRegisterReq tpnsRegisterReq2 = tpnsRegisterReq;
        String str2 = str;
        C7074c.m30321b();
        Intent intent = new Intent("com.tencent.android.tpush.action.REGISTER.RESULT.V4");
        intent.putExtra("accId", tpnsRegisterReq2.accessId);
        intent.putExtra("data", tpnsRegisterRsp2.token);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        int i2 = i;
        intent.putExtra("code", i);
        intent.putExtra("operation", 0);
        intent.putExtra("otherPushType", tpnsRegisterRsp2.otherPushTokenType);
        intent.putExtra("otherPushToken", tpnsRegisterRsp2.otherPushToken);
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.accessId = tpnsRegisterReq2.accessId;
        registerEntity.accessKey = tpnsRegisterReq2.accessKey;
        registerEntity.token = tpnsRegisterRsp2.token;
        registerEntity.channelId = tpnsRegisterReq2.channelId;
        registerEntity.packageName = str2;
        registerEntity.timestamp = System.currentTimeMillis() / 1000;
        CacheManager.addRegisterInfo(registerEntity);
        registerEntity.guid = tpnsRegisterRsp2.guid;
        CacheManager.setTokenAndGuid(C6973b.m29776f(), tpnsRegisterRsp2.token, tpnsRegisterRsp2.guid);
        if (!C7056i.m30194b(str)) {
            intent.setPackage(str2);
        }
        C6973b.m29776f().sendBroadcast(intent);
        m29695a(i, tpnsRegisterReq, tpnsRegisterRsp2.token, str, tpnsRegisterRsp2.otherPushTokenType, tpnsRegisterRsp2.otherPushToken);
        C7005b.m29964a().mo33390a(false);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("aidl", z);
            jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29700a(int i, String str, TpnsRegisterReq tpnsRegisterReq, C7000a aVar, String str2) {
        C7074c.m30321b();
        Intent intent = new Intent("com.tencent.android.tpush.action.REGISTER.RESULT.V4");
        intent.putExtra("data", "");
        intent.putExtra("code", i);
        intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, str);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 1);
        if (!C7056i.m30194b(str2)) {
            intent.setPackage(str2);
        }
        C6973b.m29776f().sendBroadcast(intent);
        m29695a(i, tpnsRegisterReq, tpnsRegisterReq.token, str2, -1, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29697a(int i, TpnsUnregisterReq tpnsUnregisterReq, C7000a aVar, String str) {
        Intent intent = new Intent("com.tencent.android.tpush.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 0);
        CacheManager.UnregisterInfoSuccessByPkgName(str);
        CacheManager.removeRegisterInfos(str);
        if (!C6914l.m29521c(str)) {
            intent.setPackage(str);
        }
        C6973b.m29776f().sendBroadcast(intent);
        m29698a(i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29701a(int i, String str, TpnsUnregisterReq tpnsUnregisterReq, C7000a aVar, String str2) {
        String str3 = f23084a;
        StringBuilder sb = new StringBuilder();
        sb.append("unregisterFailHandler failed with (");
        sb.append(i);
        String str4 = StorageInterface.KEY_SPLITER;
        sb.append(str4);
        sb.append(str);
        sb.append(str4);
        sb.append(tpnsUnregisterReq);
        sb.append(str4);
        sb.append(aVar);
        sb.append(str4);
        sb.append(str2);
        sb.append(")");
        C6864a.m29308i(str3, sb.toString());
        Intent intent = new Intent("com.tencent.android.tpush.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i);
        intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, str);
        intent.putExtra("operation", 1);
        if (!C6914l.m29521c(str2)) {
            intent.setPackage(str2);
        }
        C6973b.m29776f().sendBroadcast(intent);
        m29698a(i, str2);
    }
}
