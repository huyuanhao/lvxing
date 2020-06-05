package com.p530ss.android.socialbase.downloader.p562g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
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
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlHandler.C6683a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlHandler;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlHandler.C6687a;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadNotificationEventAidlListener.C6661a;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback;
import com.p530ss.android.socialbase.downloader.p559d.INotificationClickAidlCallback.C6663a;
import com.p530ss.android.socialbase.downloader.p559d.IRetryDelayTimeAidlCalculator;
import com.p530ss.android.socialbase.downloader.p559d.IRetryDelayTimeAidlCalculator.C6665a;

/* renamed from: com.ss.android.socialbase.downloader.g.a */
public interface DownloadAidlTask extends IInterface {

    /* compiled from: DownloadAidlTask */
    /* renamed from: com.ss.android.socialbase.downloader.g.a$a */
    public static abstract class C6706a extends Binder implements DownloadAidlTask {

        /* compiled from: DownloadAidlTask */
        /* renamed from: com.ss.android.socialbase.downloader.g.a$a$a */
        private static class C6707a implements DownloadAidlTask {
            /* renamed from: a */
            private IBinder f21951a;

            C6707a(IBinder iBinder) {
                this.f21951a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21951a;
            }

            /* renamed from: a */
            public DownloadInfo mo32094a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public IChunkCntAidlCalculator mo32095b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6669a.m27251a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo32092a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    this.f21951a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IDownloadAidlListener mo32093a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f21951a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6677a.m27274a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public IDownloadAidlListener mo32096b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    obtain.writeInt(i);
                    this.f21951a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6677a.m27274a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public IDownloadNotificationEventAidlListener mo32097c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6661a.m27203a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public INotificationClickAidlCallback mo32098d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6663a.m27213a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public IDownloadAidlInterceptor mo32099e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6675a.m27260a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public IDownloadAidlDepend mo32100f() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6671a.m27254a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public IDownloadForbiddenAidlHandler mo32101g() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6687a.m27312a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public IRetryDelayTimeAidlCalculator mo32102h() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6665a.m27219a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public IDownloadDiskSpaceAidlHandler mo32103i() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6683a.m27301a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public IDownloadAidlMonitorDepend mo32104j() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6679a.m27290a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public IDownloadAidlFileProvider mo32105k() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
                    this.f21951a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return C6673a.m27257a(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6706a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.model.DownloadAidlTask");
        }

        /* renamed from: a */
        public static DownloadAidlTask m27781a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.model.DownloadAidlTask");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof DownloadAidlTask)) {
                return new C6707a(iBinder);
            }
            return (DownloadAidlTask) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder;
            IBinder iBinder2;
            IBinder iBinder3;
            IBinder iBinder4;
            IBinder iBinder5;
            IBinder iBinder6;
            IBinder iBinder7;
            IBinder iBinder8;
            IBinder iBinder9;
            IBinder iBinder10;
            String str = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
            if (i != 1598968902) {
                IBinder iBinder11 = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(str);
                        DownloadInfo a = mo32094a();
                        parcel2.writeNoException();
                        if (a != null) {
                            parcel2.writeInt(1);
                            a.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface(str);
                        IChunkCntAidlCalculator b = mo32095b();
                        parcel2.writeNoException();
                        if (b != null) {
                            iBinder = b.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder);
                        return true;
                    case 3:
                        parcel.enforceInterface(str);
                        int a2 = mo32092a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(a2);
                        return true;
                    case 4:
                        parcel.enforceInterface(str);
                        IDownloadAidlListener a3 = mo32093a(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        if (a3 != null) {
                            iBinder2 = a3.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder2);
                        return true;
                    case 5:
                        parcel.enforceInterface(str);
                        IDownloadAidlListener b2 = mo32096b(parcel.readInt());
                        parcel2.writeNoException();
                        if (b2 != null) {
                            iBinder3 = b2.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder3);
                        return true;
                    case 6:
                        parcel.enforceInterface(str);
                        IDownloadNotificationEventAidlListener c = mo32097c();
                        parcel2.writeNoException();
                        if (c != null) {
                            iBinder4 = c.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder4);
                        return true;
                    case 7:
                        parcel.enforceInterface(str);
                        INotificationClickAidlCallback d = mo32098d();
                        parcel2.writeNoException();
                        if (d != null) {
                            iBinder5 = d.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder5);
                        return true;
                    case 8:
                        parcel.enforceInterface(str);
                        IDownloadAidlInterceptor e = mo32099e();
                        parcel2.writeNoException();
                        if (e != null) {
                            iBinder6 = e.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder6);
                        return true;
                    case 9:
                        parcel.enforceInterface(str);
                        IDownloadAidlDepend f = mo32100f();
                        parcel2.writeNoException();
                        if (f != null) {
                            iBinder7 = f.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder7);
                        return true;
                    case 10:
                        parcel.enforceInterface(str);
                        IDownloadForbiddenAidlHandler g = mo32101g();
                        parcel2.writeNoException();
                        if (g != null) {
                            iBinder8 = g.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder8);
                        return true;
                    case 11:
                        parcel.enforceInterface(str);
                        IRetryDelayTimeAidlCalculator h = mo32102h();
                        parcel2.writeNoException();
                        if (h != null) {
                            iBinder9 = h.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder9);
                        return true;
                    case 12:
                        parcel.enforceInterface(str);
                        IDownloadDiskSpaceAidlHandler i3 = mo32103i();
                        parcel2.writeNoException();
                        if (i3 != null) {
                            iBinder10 = i3.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder10);
                        return true;
                    case 13:
                        parcel.enforceInterface(str);
                        IDownloadAidlMonitorDepend j = mo32104j();
                        parcel2.writeNoException();
                        if (j != null) {
                            iBinder11 = j.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder11);
                        return true;
                    case 14:
                        parcel.enforceInterface(str);
                        IDownloadAidlFileProvider k = mo32105k();
                        parcel2.writeNoException();
                        if (k != null) {
                            iBinder11 = k.asBinder();
                        }
                        parcel2.writeStrongBinder(iBinder11);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: a */
    int mo32092a(int i) throws RemoteException;

    /* renamed from: a */
    IDownloadAidlListener mo32093a(int i, int i2) throws RemoteException;

    /* renamed from: a */
    DownloadInfo mo32094a() throws RemoteException;

    /* renamed from: b */
    IChunkCntAidlCalculator mo32095b() throws RemoteException;

    /* renamed from: b */
    IDownloadAidlListener mo32096b(int i) throws RemoteException;

    /* renamed from: c */
    IDownloadNotificationEventAidlListener mo32097c() throws RemoteException;

    /* renamed from: d */
    INotificationClickAidlCallback mo32098d() throws RemoteException;

    /* renamed from: e */
    IDownloadAidlInterceptor mo32099e() throws RemoteException;

    /* renamed from: f */
    IDownloadAidlDepend mo32100f() throws RemoteException;

    /* renamed from: g */
    IDownloadForbiddenAidlHandler mo32101g() throws RemoteException;

    /* renamed from: h */
    IRetryDelayTimeAidlCalculator mo32102h() throws RemoteException;

    /* renamed from: i */
    IDownloadDiskSpaceAidlHandler mo32103i() throws RemoteException;

    /* renamed from: j */
    IDownloadAidlMonitorDepend mo32104j() throws RemoteException;

    /* renamed from: k */
    IDownloadAidlFileProvider mo32105k() throws RemoteException;
}
