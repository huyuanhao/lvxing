package com.p530ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlFileProvider;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlFileProvider.C6673a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener.C6661a;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback.C6663a;
import com.p530ss.android.socialbase.downloader.p559d.ProcessAidlCallback;
import com.p530ss.android.socialbase.downloader.p562g.DownloadAidlTask;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.j */
public interface IDownloadAidlService extends IInterface {

    /* compiled from: IDownloadAidlService */
    /* renamed from: com.ss.android.socialbase.downloader.downloader.j$a */
    public static abstract class C6701a extends Binder implements IDownloadAidlService {

        /* compiled from: IDownloadAidlService */
        /* renamed from: com.ss.android.socialbase.downloader.downloader.j$a$a */
        private static class C6702a implements IDownloadAidlService {
            /* renamed from: a */
            private IBinder f21939a;

            C6702a(IBinder iBinder) {
                this.f21939a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21939a;
            }

            /* renamed from: a */
            public void mo31971a(DownloadAidlTask aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f21939a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31960a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31969a(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo31982b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21939a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo31985c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo31990d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31959a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f21939a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public long mo31991e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public int mo31994f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public boolean mo31995g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21939a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public DownloadInfo mo31996h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public List<DownloadInfo> mo31958a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f21939a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public List<DownloadChunk> mo31997i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadChunk.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo31957a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21939a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public DownloadInfo mo31976b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21939a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public List<DownloadInfo> mo31977b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f21939a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public List<DownloadInfo> mo31984c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f21939a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public List<DownloadInfo> mo31988d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f21939a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31973a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStringList(list);
                    this.f21939a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31980b(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo31998j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31965a(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31978b(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo31975a(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = true;
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21939a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31966a(int i, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21939a.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31974a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(26, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo31981b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = false;
                    this.f21939a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public List<DownloadInfo> mo31992e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeString(str);
                    this.f21939a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public boolean mo31999k(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21939a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo32000l(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public boolean mo31987c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = false;
                    this.f21939a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo31986c(int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.f21939a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public int mo32001m(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31972a(DownloadChunk bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21939a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo31983b(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = true;
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21939a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public boolean mo32002n(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21939a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo32003o(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31964a(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f21939a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31963a(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.f21939a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31962a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.f21939a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public boolean mo32004p(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21939a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo31989d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    this.f21939a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31968a(int i, List<DownloadChunk> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f21939a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31979b(int i, List<DownloadChunk> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f21939a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31970a(ProcessAidlCallback gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f21939a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31961a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f21939a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public IDownloadNotificationEventAidlListener mo32005q(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6661a.m27203a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public INotificationClickAidlCallback mo32006r(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6663a.m27213a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31967a(int i, IDownloadNotificationEventAidlListener afVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(afVar != null ? afVar.asBinder() : null);
                    this.f21939a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public IDownloadAidlFileProvider mo32007s(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    obtain.writeInt(i);
                    this.f21939a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6673a.m27257a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public boolean mo31993e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
                    boolean z = false;
                    this.f21939a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6701a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        /* renamed from: a */
        public static IDownloadAidlService m27580a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlService)) {
                return new C6702a(iBinder);
            }
            return (IDownloadAidlService) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r2v1 */
        /* JADX WARNING: type inference failed for: r2v6, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r2v8, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r2v9, types: [android.app.Notification] */
        /* JADX WARNING: type inference failed for: r2v12, types: [android.app.Notification] */
        /* JADX WARNING: type inference failed for: r2v13, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r2v15, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r2v16, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r2v18, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r2v25, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v26, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v27, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v28, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v29, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v30, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v31 */
        /* JADX WARNING: type inference failed for: r2v32 */
        /* JADX WARNING: type inference failed for: r2v33 */
        /* JADX WARNING: type inference failed for: r2v34 */
        /* JADX WARNING: type inference failed for: r2v35 */
        /* JADX WARNING: type inference failed for: r2v36 */
        /* JADX WARNING: type inference failed for: r2v37 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v31
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.IBinder]
  uses: [com.ss.android.socialbase.downloader.g.c, android.os.IBinder]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
        /* JADX WARNING: Unknown variable types count: 13 */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
            r9 = this;
            r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
            java.lang.String r3 = "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService"
            r6 = 1
            if (r10 == r2) goto L_0x041d
            r2 = 0
            r4 = 0
            switch(r10) {
                case 1: goto L_0x040b;
                case 2: goto L_0x03fd;
                case 3: goto L_0x03e8;
                case 4: goto L_0x03d6;
                case 5: goto L_0x03c8;
                case 6: goto L_0x03ba;
                case 7: goto L_0x03b0;
                case 8: goto L_0x039e;
                case 9: goto L_0x038c;
                case 10: goto L_0x037a;
                case 11: goto L_0x035f;
                case 12: goto L_0x034d;
                case 13: goto L_0x033b;
                case 14: goto L_0x0325;
                case 15: goto L_0x0306;
                case 16: goto L_0x02f4;
                case 17: goto L_0x02e2;
                case 18: goto L_0x02d0;
                case 19: goto L_0x02c2;
                case 20: goto L_0x02ad;
                case 21: goto L_0x029f;
                case 22: goto L_0x0272;
                case 23: goto L_0x0245;
                case 24: goto L_0x0228;
                case 25: goto L_0x020e;
                case 26: goto L_0x0200;
                case 27: goto L_0x01f2;
                case 28: goto L_0x01e0;
                case 29: goto L_0x01ce;
                case 30: goto L_0x01c0;
                case 31: goto L_0x01b2;
                case 32: goto L_0x019d;
                case 33: goto L_0x018b;
                case 34: goto L_0x0172;
                case 35: goto L_0x0155;
                case 36: goto L_0x0143;
                case 37: goto L_0x0135;
                case 38: goto L_0x011f;
                case 39: goto L_0x0100;
                case 40: goto L_0x00e6;
                case 41: goto L_0x00d4;
                case 42: goto L_0x00ca;
                case 43: goto L_0x00b6;
                case 44: goto L_0x00a2;
                case 45: goto L_0x0090;
                case 46: goto L_0x007e;
                case 47: goto L_0x0066;
                case 48: goto L_0x004e;
                case 49: goto L_0x0038;
                case 50: goto L_0x0020;
                case 51: goto L_0x0012;
                default: goto L_0x000d;
            }
        L_0x000d:
            boolean r0 = super.onTransact(r10, r11, r12, r13)
            return r0
        L_0x0012:
            r11.enforceInterface(r3)
            boolean r0 = r9.mo31993e()
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x0020:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            com.ss.android.socialbase.downloader.d.n r0 = r9.mo32007s(r0)
            r12.writeNoException()
            if (r0 == 0) goto L_0x0034
            android.os.IBinder r2 = r0.asBinder()
        L_0x0034:
            r12.writeStrongBinder(r2)
            return r6
        L_0x0038:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            android.os.IBinder r1 = r11.readStrongBinder()
            com.ss.android.socialbase.downloader.d.af r1 = com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener.C6661a.m27203a(r1)
            r9.mo31967a(r0, r1)
            r12.writeNoException()
            return r6
        L_0x004e:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            com.ss.android.socialbase.downloader.d.c r0 = r9.mo32006r(r0)
            r12.writeNoException()
            if (r0 == 0) goto L_0x0062
            android.os.IBinder r2 = r0.asBinder()
        L_0x0062:
            r12.writeStrongBinder(r2)
            return r6
        L_0x0066:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            com.ss.android.socialbase.downloader.d.af r0 = r9.mo32005q(r0)
            r12.writeNoException()
            if (r0 == 0) goto L_0x007a
            android.os.IBinder r2 = r0.asBinder()
        L_0x007a:
            r12.writeStrongBinder(r2)
            return r6
        L_0x007e:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r1 = r11.readInt()
            r9.mo31961a(r0, r1)
            r12.writeNoException()
            return r6
        L_0x0090:
            r11.enforceInterface(r3)
            android.os.IBinder r0 = r11.readStrongBinder()
            com.ss.android.socialbase.downloader.d.g r0 = com.p530ss.android.socialbase.downloader.p559d.ProcessAidlCallback.C6667a.m27224a(r0)
            r9.mo31970a(r0)
            r12.writeNoException()
            return r6
        L_0x00a2:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r2 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.util.ArrayList r1 = r11.createTypedArrayList(r2)
            r9.mo31979b(r0, r1)
            r12.writeNoException()
            return r6
        L_0x00b6:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r2 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.util.ArrayList r1 = r11.createTypedArrayList(r2)
            r9.mo31968a(r0, r1)
            r12.writeNoException()
            return r6
        L_0x00ca:
            r11.enforceInterface(r3)
            r9.mo31989d()
            r12.writeNoException()
            return r6
        L_0x00d4:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            boolean r0 = r9.mo32004p(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x00e6:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r2 = r11.readInt()
            int r3 = r11.readInt()
            int r1 = r11.readInt()
            r9.mo31962a(r0, r2, r3, r1)
            r12.writeNoException()
            return r6
        L_0x0100:
            r11.enforceInterface(r3)
            int r2 = r11.readInt()
            int r3 = r11.readInt()
            int r4 = r11.readInt()
            long r7 = r11.readLong()
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r7
            r0.mo31963a(r1, r2, r3, r4)
            r12.writeNoException()
            return r6
        L_0x011f:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r2 = r11.readInt()
            long r3 = r11.readLong()
            r9.mo31964a(r0, r2, r3)
            r12.writeNoException()
            return r6
        L_0x0135:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo32003o(r0)
            r12.writeNoException()
            return r6
        L_0x0143:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            boolean r0 = r9.mo32002n(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x0155:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0167
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r0 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            r2 = r0
            com.ss.android.socialbase.downloader.g.c r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r2
        L_0x0167:
            boolean r0 = r9.mo31983b(r2)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x0172:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0184
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r0 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            r2 = r0
            com.ss.android.socialbase.downloader.g.b r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r2
        L_0x0184:
            r9.mo31972a(r2)
            r12.writeNoException()
            return r6
        L_0x018b:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r0 = r9.mo32001m(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x019d:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r1 = r11.readInt()
            if (r1 == 0) goto L_0x01ab
            r4 = 1
        L_0x01ab:
            r9.mo31986c(r0, r4)
            r12.writeNoException()
            return r6
        L_0x01b2:
            r11.enforceInterface(r3)
            boolean r0 = r9.mo31987c()
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x01c0:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo32000l(r0)
            r12.writeNoException()
            return r6
        L_0x01ce:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            boolean r0 = r9.mo31999k(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x01e0:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.util.List r0 = r9.mo31992e(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x01f2:
            r11.enforceInterface(r3)
            boolean r0 = r9.mo31981b()
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x0200:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x020a
            r4 = 1
        L_0x020a:
            r9.mo31974a(r4)
            return r6
        L_0x020e:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r3 = r11.readInt()
            if (r3 == 0) goto L_0x0224
            android.os.Parcelable$Creator r2 = android.app.Notification.CREATOR
            java.lang.Object r1 = r2.createFromParcel(r11)
            r2 = r1
            android.app.Notification r2 = (android.app.Notification) r2
        L_0x0224:
            r9.mo31966a(r0, r2)
            return r6
        L_0x0228:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x023a
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r0 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            r2 = r0
            com.ss.android.socialbase.downloader.g.c r2 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r2
        L_0x023a:
            boolean r0 = r9.mo31975a(r2)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x0245:
            r11.enforceInterface(r3)
            int r2 = r11.readInt()
            int r3 = r11.readInt()
            android.os.IBinder r0 = r11.readStrongBinder()
            com.ss.android.socialbase.downloader.d.p r5 = com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener.C6677a.m27274a(r0)
            int r7 = r11.readInt()
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0264
            r8 = 1
            goto L_0x0265
        L_0x0264:
            r8 = 0
        L_0x0265:
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r8
            r0.mo31978b(r1, r2, r3, r4, r5)
            r12.writeNoException()
            return r6
        L_0x0272:
            r11.enforceInterface(r3)
            int r2 = r11.readInt()
            int r3 = r11.readInt()
            android.os.IBinder r0 = r11.readStrongBinder()
            com.ss.android.socialbase.downloader.d.p r5 = com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener.C6677a.m27274a(r0)
            int r7 = r11.readInt()
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0291
            r8 = 1
            goto L_0x0292
        L_0x0291:
            r8 = 0
        L_0x0292:
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r8
            r0.mo31965a(r1, r2, r3, r4, r5)
            r12.writeNoException()
            return r6
        L_0x029f:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo31998j(r0)
            r12.writeNoException()
            return r6
        L_0x02ad:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r1 = r11.readInt()
            if (r1 == 0) goto L_0x02bb
            r4 = 1
        L_0x02bb:
            r9.mo31980b(r0, r4)
            r12.writeNoException()
            return r6
        L_0x02c2:
            r11.enforceInterface(r3)
            java.util.ArrayList r0 = r11.createStringArrayList()
            r9.mo31973a(r0)
            r12.writeNoException()
            return r6
        L_0x02d0:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.util.List r0 = r9.mo31988d(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x02e2:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.util.List r0 = r9.mo31984c(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x02f4:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.util.List r0 = r9.mo31977b(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x0306:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            com.ss.android.socialbase.downloader.g.c r0 = r9.mo31976b(r0, r1)
            r12.writeNoException()
            if (r0 == 0) goto L_0x0321
            r12.writeInt(r6)
            r0.writeToParcel(r12, r6)
            goto L_0x0324
        L_0x0321:
            r12.writeInt(r4)
        L_0x0324:
            return r6
        L_0x0325:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            int r0 = r9.mo31957a(r0, r1)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x033b:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            java.util.List r0 = r9.mo31997i(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x034d:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.util.List r0 = r9.mo31958a(r0)
            r12.writeNoException()
            r12.writeTypedList(r0)
            return r6
        L_0x035f:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            com.ss.android.socialbase.downloader.g.c r0 = r9.mo31996h(r0)
            r12.writeNoException()
            if (r0 == 0) goto L_0x0376
            r12.writeInt(r6)
            r0.writeToParcel(r12, r6)
            goto L_0x0379
        L_0x0376:
            r12.writeInt(r4)
        L_0x0379:
            return r6
        L_0x037a:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            boolean r0 = r9.mo31995g(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x038c:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r0 = r9.mo31994f(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x039e:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            long r0 = r9.mo31991e(r0)
            r12.writeNoException()
            r12.writeLong(r0)
            return r6
        L_0x03b0:
            r11.enforceInterface(r3)
            r9.mo31959a()
            r12.writeNoException()
            return r6
        L_0x03ba:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo31990d(r0)
            r12.writeNoException()
            return r6
        L_0x03c8:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo31985c(r0)
            r12.writeNoException()
            return r6
        L_0x03d6:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            boolean r0 = r9.mo31982b(r0)
            r12.writeNoException()
            r12.writeInt(r0)
            return r6
        L_0x03e8:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r1 = r11.readInt()
            if (r1 == 0) goto L_0x03f6
            r4 = 1
        L_0x03f6:
            r9.mo31969a(r0, r4)
            r12.writeNoException()
            return r6
        L_0x03fd:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo31960a(r0)
            r12.writeNoException()
            return r6
        L_0x040b:
            r11.enforceInterface(r3)
            android.os.IBinder r0 = r11.readStrongBinder()
            com.ss.android.socialbase.downloader.g.a r0 = com.p530ss.android.socialbase.downloader.p562g.DownloadAidlTask.C6706a.m27781a(r0)
            r9.mo31971a(r0)
            r12.writeNoException()
            return r6
        L_0x041d:
            r12.writeString(r3)
            return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.downloader.IDownloadAidlService.C6701a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    int mo31957a(String str, String str2) throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo31958a(String str) throws RemoteException;

    /* renamed from: a */
    void mo31959a() throws RemoteException;

    /* renamed from: a */
    void mo31960a(int i) throws RemoteException;

    /* renamed from: a */
    void mo31961a(int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo31962a(int i, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: a */
    void mo31963a(int i, int i2, int i3, long j) throws RemoteException;

    /* renamed from: a */
    void mo31964a(int i, int i2, long j) throws RemoteException;

    /* renamed from: a */
    void mo31965a(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo31966a(int i, Notification notification) throws RemoteException;

    /* renamed from: a */
    void mo31967a(int i, IDownloadNotificationEventAidlListener afVar) throws RemoteException;

    /* renamed from: a */
    void mo31968a(int i, List<DownloadChunk> list) throws RemoteException;

    /* renamed from: a */
    void mo31969a(int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo31970a(ProcessAidlCallback gVar) throws RemoteException;

    /* renamed from: a */
    void mo31971a(DownloadAidlTask aVar) throws RemoteException;

    /* renamed from: a */
    void mo31972a(DownloadChunk bVar) throws RemoteException;

    /* renamed from: a */
    void mo31973a(List<String> list) throws RemoteException;

    /* renamed from: a */
    void mo31974a(boolean z) throws RemoteException;

    /* renamed from: a */
    boolean mo31975a(DownloadInfo cVar) throws RemoteException;

    /* renamed from: b */
    DownloadInfo mo31976b(String str, String str2) throws RemoteException;

    /* renamed from: b */
    List<DownloadInfo> mo31977b(String str) throws RemoteException;

    /* renamed from: b */
    void mo31978b(int i, int i2, IDownloadAidlListener pVar, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo31979b(int i, List<DownloadChunk> list) throws RemoteException;

    /* renamed from: b */
    void mo31980b(int i, boolean z) throws RemoteException;

    /* renamed from: b */
    boolean mo31981b() throws RemoteException;

    /* renamed from: b */
    boolean mo31982b(int i) throws RemoteException;

    /* renamed from: b */
    boolean mo31983b(DownloadInfo cVar) throws RemoteException;

    /* renamed from: c */
    List<DownloadInfo> mo31984c(String str) throws RemoteException;

    /* renamed from: c */
    void mo31985c(int i) throws RemoteException;

    /* renamed from: c */
    void mo31986c(int i, boolean z) throws RemoteException;

    /* renamed from: c */
    boolean mo31987c() throws RemoteException;

    /* renamed from: d */
    List<DownloadInfo> mo31988d(String str) throws RemoteException;

    /* renamed from: d */
    void mo31989d() throws RemoteException;

    /* renamed from: d */
    void mo31990d(int i) throws RemoteException;

    /* renamed from: e */
    long mo31991e(int i) throws RemoteException;

    /* renamed from: e */
    List<DownloadInfo> mo31992e(String str) throws RemoteException;

    /* renamed from: e */
    boolean mo31993e() throws RemoteException;

    /* renamed from: f */
    int mo31994f(int i) throws RemoteException;

    /* renamed from: g */
    boolean mo31995g(int i) throws RemoteException;

    /* renamed from: h */
    DownloadInfo mo31996h(int i) throws RemoteException;

    /* renamed from: i */
    List<DownloadChunk> mo31997i(int i) throws RemoteException;

    /* renamed from: j */
    void mo31998j(int i) throws RemoteException;

    /* renamed from: k */
    boolean mo31999k(int i) throws RemoteException;

    /* renamed from: l */
    void mo32000l(int i) throws RemoteException;

    /* renamed from: m */
    int mo32001m(int i) throws RemoteException;

    /* renamed from: n */
    boolean mo32002n(int i) throws RemoteException;

    /* renamed from: o */
    void mo32003o(int i) throws RemoteException;

    /* renamed from: p */
    boolean mo32004p(int i) throws RemoteException;

    /* renamed from: q */
    IDownloadNotificationEventAidlListener mo32005q(int i) throws RemoteException;

    /* renamed from: r */
    INotificationClickAidlCallback mo32006r(int i) throws RemoteException;

    /* renamed from: s */
    IDownloadAidlFileProvider mo32007s(int i) throws RemoteException;
}
