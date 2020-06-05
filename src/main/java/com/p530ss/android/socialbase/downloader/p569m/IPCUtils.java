package com.p530ss.android.socialbase.downloader.p569m;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.p530ss.android.socialbase.downloader.p557b.ListenerType;
import com.p530ss.android.socialbase.downloader.p559d.AbsDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.IChunkCntAidlCalculator;
import com.p530ss.android.socialbase.downloader.p559d.IChunkCntAidlCalculator.C6669a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlDepend.C6671a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlFileProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlFileProvider.C6673a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlInterceptor;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlInterceptor.C6675a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener.C6677a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlMonitorDepend.C6679a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlCallback.C6681a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlHandler.C6683a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceCallback;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadFileUriProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlCallback.C6685a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlHandler.C6687a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenCallback;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadInterceptor;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadMonitorDepend;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener.C6661a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventListener;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback.C6663a;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickCallback;
import com.p530ss.android.socialbase.downloader.p559d.IRetryDelayTimeAidlCalculator;
import com.p530ss.android.socialbase.downloader.p559d.IRetryDelayTimeAidlCalculator.C6665a;
import com.p530ss.android.socialbase.downloader.p559d.ProcessAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.ProcessAidlCallback.C6667a;
import com.p530ss.android.socialbase.downloader.p559d.ProcessCallback;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.C6712d;
import com.p530ss.android.socialbase.downloader.p562g.DownloadAidlTask;
import com.p530ss.android.socialbase.downloader.p562g.DownloadAidlTask.C6706a;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.m.g */
public class IPCUtils {
    /* access modifiers changed from: private|static */
    /* renamed from: a */
    public static Handler f22377a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static DownloadAidlTask m28850a(final C6712d dVar) {
        if (dVar == null) {
            return null;
        }
        return new C6706a() {
            /* renamed from: a */
            public DownloadInfo mo32094a() throws RemoteException {
                return dVar.mo32357a();
            }

            /* renamed from: b */
            public IChunkCntAidlCalculator mo32095b() throws RemoteException {
                return IPCUtils.m28834a(dVar.mo32404f());
            }

            /* renamed from: b */
            public IDownloadAidlListener mo32096b(int i) throws RemoteException {
                return IPCUtils.m28838a(dVar.mo32392c(DownloadUtils.m28798c(i)), i != ListenerType.SUB.ordinal());
            }

            /* renamed from: a */
            public int mo32092a(int i) throws RemoteException {
                return dVar.mo32380b(DownloadUtils.m28798c(i));
            }

            /* renamed from: a */
            public IDownloadAidlListener mo32093a(int i, int i2) throws RemoteException {
                return IPCUtils.m28838a(dVar.mo32356a(DownloadUtils.m28798c(i), i2), i != ListenerType.SUB.ordinal());
            }

            /* renamed from: c */
            public IDownloadNotificationEventAidlListener mo32097c() throws RemoteException {
                return IPCUtils.m28827a(dVar.mo32416j());
            }

            /* renamed from: d */
            public INotificationClickAidlCallback mo32098d() throws RemoteException {
                return IPCUtils.m28829a(dVar.mo32418k());
            }

            /* renamed from: e */
            public IDownloadAidlInterceptor mo32099e() throws RemoteException {
                return IPCUtils.m28837a(dVar.mo32391c());
            }

            /* renamed from: f */
            public IDownloadAidlDepend mo32100f() throws RemoteException {
                return IPCUtils.m28835a(dVar.mo32397d());
            }

            /* renamed from: j */
            public IDownloadAidlMonitorDepend mo32104j() throws RemoteException {
                return IPCUtils.m28839a(dVar.mo32401e());
            }

            /* renamed from: g */
            public IDownloadForbiddenAidlHandler mo32101g() throws RemoteException {
                return IPCUtils.m28847a(dVar.mo32410h());
            }

            /* renamed from: h */
            public IRetryDelayTimeAidlCalculator mo32102h() throws RemoteException {
                return IPCUtils.m28831a(dVar.mo32407g());
            }

            /* renamed from: i */
            public IDownloadDiskSpaceAidlHandler mo32103i() throws RemoteException {
                return IPCUtils.m28842a(dVar.mo32413i());
            }

            /* renamed from: k */
            public IDownloadAidlFileProvider mo32105k() throws RemoteException {
                return IPCUtils.m28836a(dVar.mo32420l());
            }
        };
    }

    /* renamed from: a */
    public static IDownloadAidlListener m28838a(final IDownloadListener adVar, final boolean z) {
        if (adVar == null) {
            return null;
        }
        return new C6677a() {
            /* renamed from: a */
            public int mo31782a() throws RemoteException {
                return adVar.hashCode();
            }

            /* renamed from: a */
            public void mo31783a(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31350a(cVar);
                        }
                    });
                } else {
                    adVar.mo31350a(cVar);
                }
            }

            /* renamed from: b */
            public void mo31785b(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31352b(cVar);
                        }
                    });
                } else {
                    adVar.mo31352b(cVar);
                }
            }

            /* renamed from: c */
            public void mo31787c(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31353c(cVar);
                        }
                    });
                } else {
                    adVar.mo31353c(cVar);
                }
            }

            /* renamed from: d */
            public void mo31789d(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31354d(cVar);
                        }
                    });
                } else {
                    adVar.mo31354d(cVar);
                }
            }

            /* renamed from: e */
            public void mo31790e(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31355e(cVar);
                        }
                    });
                } else {
                    adVar.mo31355e(cVar);
                }
            }

            /* renamed from: a */
            public void mo31784a(final DownloadInfo cVar, final BaseException aVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31351a(cVar, aVar);
                        }
                    });
                } else {
                    adVar.mo31351a(cVar, aVar);
                }
            }

            /* renamed from: f */
            public void mo31791f(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31356f(cVar);
                        }
                    });
                } else {
                    adVar.mo31356f(cVar);
                }
            }

            /* renamed from: g */
            public void mo31792g(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31735g(cVar);
                        }
                    });
                } else {
                    adVar.mo31735g(cVar);
                }
            }

            /* renamed from: h */
            public void mo31793h(final DownloadInfo cVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31736h(cVar);
                        }
                    });
                } else {
                    adVar.mo31736h(cVar);
                }
            }

            /* renamed from: b */
            public void mo31786b(final DownloadInfo cVar, final BaseException aVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31733b(cVar, aVar);
                        }
                    });
                } else {
                    adVar.mo31733b(cVar, aVar);
                }
            }

            /* renamed from: c */
            public void mo31788c(final DownloadInfo cVar, final BaseException aVar) throws RemoteException {
                if (z) {
                    IPCUtils.f22377a.post(new Runnable() {
                        public void run() {
                            adVar.mo31734c(cVar, aVar);
                        }
                    });
                } else {
                    adVar.mo31734c(cVar, aVar);
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadNotificationEventAidlListener m28827a(final IDownloadNotificationEventListener agVar) {
        if (agVar == null) {
            return null;
        }
        return new C6661a() {
            /* renamed from: a */
            public void mo31740a(int i, DownloadInfo cVar, String str, String str2) throws RemoteException {
                agVar.mo31500a(i, cVar, str, str2);
            }

            /* renamed from: a */
            public boolean mo31741a(boolean z) throws RemoteException {
                return agVar.mo31501a(z);
            }

            /* renamed from: a */
            public String mo31739a() throws RemoteException {
                return agVar.mo31499a();
            }
        };
    }

    /* renamed from: a */
    public static INotificationClickAidlCallback m28829a(final INotificationClickCallback dVar) {
        if (dVar == null) {
            return null;
        }
        return new C6663a() {
            /* renamed from: a */
            public boolean mo31746a(DownloadInfo cVar) throws RemoteException {
                return dVar.mo31751a(cVar);
            }

            /* renamed from: b */
            public boolean mo31747b(DownloadInfo cVar) throws RemoteException {
                return dVar.mo31752b(cVar);
            }
        };
    }

    /* renamed from: a */
    public static IRetryDelayTimeAidlCalculator m28831a(final IRetryDelayTimeCalculator rVar) {
        if (rVar == null) {
            return null;
        }
        return new C6665a() {
            /* renamed from: a */
            public long mo31753a(int i, int i2) throws RemoteException {
                return rVar.mo32072a(i, i2);
            }
        };
    }

    /* renamed from: a */
    public static IDownloadForbiddenAidlHandler m28847a(final IDownloadForbiddenHandler abVar) {
        if (abVar == null) {
            return null;
        }
        return new C6687a() {
            /* renamed from: a */
            public boolean mo31820a(IDownloadForbiddenAidlCallback yVar) throws RemoteException {
                return abVar.mo31731a(IPCUtils.m28822a(yVar));
            }
        };
    }

    /* renamed from: a */
    public static IDownloadAidlFileProvider m28836a(final IDownloadFileUriProvider xVar) {
        if (xVar == null) {
            return null;
        }
        return new C6673a() {
            /* renamed from: a */
            public Uri mo31774a(String str, String str2) throws RemoteException {
                return xVar.mo31814a(str, str2);
            }
        };
    }

    /* renamed from: a */
    public static IDownloadForbiddenCallback m28822a(final IDownloadForbiddenAidlCallback yVar) {
        if (yVar == null) {
            return null;
        }
        return new IDownloadForbiddenCallback() {
            /* renamed from: a */
            public void mo31729a(List<String> list) {
                try {
                    yVar.mo31815a(list);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: a */
            public boolean mo31730a() {
                try {
                    return yVar.mo31816a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadDiskSpaceAidlHandler m28842a(final IDownloadDiskSpaceHandler wVar) {
        if (wVar == null) {
            return null;
        }
        return new C6683a() {
            /* renamed from: a */
            public boolean mo31809a(long j, long j2, IDownloadDiskSpaceAidlCallback tVar) throws RemoteException {
                return wVar.mo31291a(j, j2, IPCUtils.m28843a(tVar));
            }
        };
    }

    /* renamed from: a */
    public static IDownloadDiskSpaceCallback m28843a(final IDownloadDiskSpaceAidlCallback tVar) {
        if (tVar == null) {
            return null;
        }
        return new IDownloadDiskSpaceCallback() {
            /* renamed from: a */
            public void mo31813a() {
                try {
                    tVar.mo31805a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadAidlDepend m28835a(final IDownloadDepend sVar) {
        if (sVar == null) {
            return null;
        }
        return new C6671a() {
            /* renamed from: a */
            public void mo31770a(DownloadInfo cVar, BaseException aVar, int i) throws RemoteException {
                sVar.mo31498a(cVar, aVar, i);
            }
        };
    }

    /* renamed from: a */
    public static IDownloadAidlMonitorDepend m28839a(final IDownloadMonitorDepend aeVar) {
        if (aeVar == null) {
            return null;
        }
        return new C6679a() {
            /* renamed from: a */
            public void mo31798a(String str) throws RemoteException {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        aeVar.mo31737a(new JSONObject(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: a */
            public String mo31797a() throws RemoteException {
                return aeVar.mo31738b();
            }

            /* renamed from: b */
            public int[] mo31799b() throws RemoteException {
                IDownloadMonitorDepend aeVar = aeVar;
                if (aeVar instanceof AbsDownloadMonitorDepend) {
                    return ((AbsDownloadMonitorDepend) aeVar).mo31765a();
                }
                return null;
            }
        };
    }

    /* renamed from: a */
    public static IChunkCntAidlCalculator m28834a(final IChunkCntCalculator iVar) {
        if (iVar == null) {
            return null;
        }
        return new C6669a() {
            /* renamed from: a */
            public int mo31766a(long j) throws RemoteException {
                return iVar.mo31302a(j);
            }
        };
    }

    /* renamed from: a */
    public static IDownloadAidlInterceptor m28837a(final IDownloadInterceptor acVar) {
        if (acVar == null) {
            return null;
        }
        return new C6675a() {
            /* renamed from: a */
            public boolean mo31778a() throws RemoteException {
                return acVar.mo31732a();
            }
        };
    }

    /* renamed from: a */
    public static C6712d m28851a(DownloadAidlTask aVar) {
        if (aVar == null) {
            return null;
        }
        try {
            C6712d dVar = new C6712d(aVar.mo32094a());
            dVar.mo32371a(m28848a(aVar.mo32095b())).mo32365a(m28828a(aVar.mo32097c())).mo32362a(m28824a(aVar.mo32099e())).mo32367a(m28840a(aVar.mo32100f())).mo32364a(m28826a(aVar.mo32104j())).mo32361a(m28823a(aVar.mo32101g())).mo32368a(m28844a(aVar.mo32103i())).mo32369a(m28845a(aVar.mo32105k())).mo32366a(m28830a(aVar.mo32098d())).mo32372a(m28849a(aVar.mo32102h()));
            IDownloadAidlListener b = aVar.mo32096b(ListenerType.MAIN.ordinal());
            if (b != null) {
                dVar.mo32359a(b.hashCode(), m28825a(b));
            }
            IDownloadAidlListener b2 = aVar.mo32096b(ListenerType.SUB.ordinal());
            if (b2 != null) {
                dVar.mo32382b(b2.hashCode(), m28825a(b2));
            }
            IDownloadAidlListener b3 = aVar.mo32096b(ListenerType.NOTIFICATION.ordinal());
            if (b3 != null) {
                dVar.mo32394c(b3.hashCode(), m28825a(b3));
            }
            m28852a(dVar, aVar, ListenerType.MAIN);
            m28852a(dVar, aVar, ListenerType.SUB);
            m28852a(dVar, aVar, ListenerType.NOTIFICATION);
            return dVar;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static void m28852a(C6712d dVar, DownloadAidlTask aVar, ListenerType hVar) throws RemoteException {
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < aVar.mo32092a(hVar.ordinal()); i++) {
            IDownloadAidlListener a = aVar.mo32093a(hVar.ordinal(), i);
            if (a != null) {
                sparseArray.put(a.mo31782a(), m28825a(a));
            }
        }
        dVar.mo32377a(sparseArray, hVar);
    }

    /* renamed from: a */
    public static IDownloadNotificationEventListener m28828a(final IDownloadNotificationEventAidlListener afVar) {
        if (afVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() {
            /* renamed from: a */
            public void mo31500a(int i, DownloadInfo cVar, String str, String str2) {
                try {
                    afVar.mo31740a(i, cVar, str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: a */
            public boolean mo31501a(boolean z) {
                try {
                    return afVar.mo31741a(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            /* renamed from: a */
            public String mo31499a() {
                try {
                    return afVar.mo31739a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: a */
    public static INotificationClickCallback m28830a(final INotificationClickAidlCallback cVar) {
        if (cVar == null) {
            return null;
        }
        return new INotificationClickCallback() {
            /* renamed from: a */
            public boolean mo31751a(DownloadInfo cVar) {
                try {
                    return cVar.mo31746a(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            /* renamed from: b */
            public boolean mo31752b(DownloadInfo cVar) {
                try {
                    return cVar.mo31747b(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: a */
    public static IChunkCntCalculator m28848a(final IChunkCntAidlCalculator lVar) {
        if (lVar == null) {
            return null;
        }
        return new IChunkCntCalculator() {
            /* renamed from: a */
            public int mo31302a(long j) {
                try {
                    return lVar.mo31766a(j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadDepend m28840a(final IDownloadAidlDepend mVar) {
        if (mVar == null) {
            return null;
        }
        return new IDownloadDepend() {
            /* renamed from: a */
            public void mo31498a(DownloadInfo cVar, BaseException aVar, int i) {
                if (cVar != null) {
                    try {
                        mVar.mo31770a(cVar, aVar, i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadMonitorDepend m28826a(final IDownloadAidlMonitorDepend qVar) {
        if (qVar == null) {
            return null;
        }
        return new AbsDownloadMonitorDepend() {
            /* renamed from: a */
            public void mo31737a(JSONObject jSONObject) {
                if (jSONObject != null) {
                    try {
                        qVar.mo31798a(jSONObject.toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: b */
            public String mo31738b() {
                try {
                    return qVar.mo31797a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            /* renamed from: a */
            public int[] mo31765a() {
                try {
                    return qVar.mo31799b();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadForbiddenHandler m28823a(final IDownloadForbiddenAidlHandler zVar) {
        if (zVar == null) {
            return null;
        }
        return new IDownloadForbiddenHandler() {
            /* renamed from: a */
            public boolean mo31731a(IDownloadForbiddenCallback aaVar) {
                try {
                    return zVar.mo31820a(IPCUtils.m28846a(aaVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadForbiddenAidlCallback m28846a(final IDownloadForbiddenCallback aaVar) {
        if (aaVar == null) {
            return null;
        }
        return new C6685a() {
            /* renamed from: a */
            public void mo31815a(List<String> list) {
                aaVar.mo31729a(list);
            }

            /* renamed from: a */
            public boolean mo31816a() {
                return aaVar.mo31730a();
            }
        };
    }

    /* renamed from: a */
    public static ProcessAidlCallback m28832a(final ProcessCallback hVar) {
        if (hVar == null) {
            return null;
        }
        return new C6667a() {
            /* renamed from: a */
            public void mo31759a(int i, int i2) {
                hVar.mo31763a(i, i2);
            }
        };
    }

    /* renamed from: a */
    public static ProcessCallback m28833a(final ProcessAidlCallback gVar) {
        if (gVar == null) {
            return null;
        }
        return new ProcessCallback() {
            /* renamed from: a */
            public void mo31763a(int i, int i2) {
                try {
                    gVar.mo31759a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadDiskSpaceHandler m28844a(final IDownloadDiskSpaceAidlHandler uVar) {
        if (uVar == null) {
            return null;
        }
        return new IDownloadDiskSpaceHandler() {
            /* renamed from: a */
            public boolean mo31291a(long j, long j2, IDownloadDiskSpaceCallback vVar) {
                try {
                    return uVar.mo31809a(j, j2, IPCUtils.m28841a(vVar));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadDiskSpaceAidlCallback m28841a(final IDownloadDiskSpaceCallback vVar) {
        if (vVar == null) {
            return null;
        }
        return new C6681a() {
            /* renamed from: a */
            public void mo31805a() throws RemoteException {
                vVar.mo31813a();
            }
        };
    }

    /* renamed from: a */
    public static IRetryDelayTimeCalculator m28849a(final IRetryDelayTimeAidlCalculator eVar) {
        if (eVar == null) {
            return null;
        }
        return new IRetryDelayTimeCalculator() {
            /* renamed from: a */
            public long mo32072a(int i, int i2) {
                try {
                    return eVar.mo31753a(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadInterceptor m28824a(final IDownloadAidlInterceptor oVar) {
        if (oVar == null) {
            return null;
        }
        return new IDownloadInterceptor() {
            /* renamed from: a */
            public boolean mo31732a() {
                try {
                    return oVar.mo31778a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadFileUriProvider m28845a(final IDownloadAidlFileProvider nVar) {
        if (nVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() {
            /* renamed from: a */
            public Uri mo31814a(String str, String str2) {
                try {
                    return nVar.mo31774a(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: a */
    public static IDownloadListener m28825a(final IDownloadAidlListener pVar) {
        if (pVar == null) {
            return null;
        }
        return new IDownloadListener() {
            /* renamed from: a */
            public void mo31350a(DownloadInfo cVar) {
                try {
                    pVar.mo31783a(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: b */
            public void mo31352b(DownloadInfo cVar) {
                try {
                    pVar.mo31785b(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: c */
            public void mo31353c(DownloadInfo cVar) {
                try {
                    pVar.mo31787c(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: d */
            public void mo31354d(DownloadInfo cVar) {
                try {
                    pVar.mo31789d(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: e */
            public void mo31355e(DownloadInfo cVar) {
                try {
                    pVar.mo31790e(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: a */
            public void mo31351a(DownloadInfo cVar, BaseException aVar) {
                try {
                    pVar.mo31784a(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: f */
            public void mo31356f(DownloadInfo cVar) {
                try {
                    pVar.mo31791f(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: g */
            public void mo31735g(DownloadInfo cVar) {
                try {
                    pVar.mo31792g(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: h */
            public void mo31736h(DownloadInfo cVar) {
                try {
                    pVar.mo31793h(cVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: b */
            public void mo31733b(DownloadInfo cVar, BaseException aVar) {
                try {
                    pVar.mo31786b(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            /* renamed from: c */
            public void mo31734c(DownloadInfo cVar, BaseException aVar) {
                try {
                    pVar.mo31788c(cVar, aVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
