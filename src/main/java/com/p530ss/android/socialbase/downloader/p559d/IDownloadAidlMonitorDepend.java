package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.q */
public interface IDownloadAidlMonitorDepend extends IInterface {

    /* compiled from: IDownloadAidlMonitorDepend */
    /* renamed from: com.ss.android.socialbase.downloader.d.q$a */
    public static abstract class C6679a extends Binder implements IDownloadAidlMonitorDepend {

        /* compiled from: IDownloadAidlMonitorDepend */
        /* renamed from: com.ss.android.socialbase.downloader.d.q$a$a */
        private static class C6680a implements IDownloadAidlMonitorDepend {
            /* renamed from: a */
            private IBinder f21800a;

            C6680a(IBinder iBinder) {
                this.f21800a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21800a;
            }

            /* renamed from: a */
            public void mo31798a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    obtain.writeString(str);
                    this.f21800a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public String mo31797a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    this.f21800a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public int[] mo31799b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
                    this.f21800a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6679a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
        }

        /* renamed from: a */
        public static IDownloadAidlMonitorDepend m27290a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlMonitorDepend)) {
                return new C6680a(iBinder);
            }
            return (IDownloadAidlMonitorDepend) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo31798a(parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                String a = mo31797a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                int[] b = mo31799b();
                parcel2.writeNoException();
                parcel2.writeIntArray(b);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: a */
    String mo31797a() throws RemoteException;

    /* renamed from: a */
    void mo31798a(String str) throws RemoteException;

    /* renamed from: b */
    int[] mo31799b() throws RemoteException;
}
