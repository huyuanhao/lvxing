package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.t */
public interface IDownloadDiskSpaceAidlCallback extends IInterface {

    /* compiled from: IDownloadDiskSpaceAidlCallback */
    /* renamed from: com.ss.android.socialbase.downloader.d.t$a */
    public static abstract class C6681a extends Binder implements IDownloadDiskSpaceAidlCallback {

        /* compiled from: IDownloadDiskSpaceAidlCallback */
        /* renamed from: com.ss.android.socialbase.downloader.d.t$a$a */
        private static class C6682a implements IDownloadDiskSpaceAidlCallback {
            /* renamed from: a */
            private IBinder f21801a;

            C6682a(IBinder iBinder) {
                this.f21801a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21801a;
            }

            /* renamed from: a */
            public void mo31805a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
                    this.f21801a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6681a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
        }

        /* renamed from: a */
        public static IDownloadDiskSpaceAidlCallback m27298a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadDiskSpaceAidlCallback)) {
                return new C6682a(iBinder);
            }
            return (IDownloadDiskSpaceAidlCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo31805a();
                parcel2.writeNoException();
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
    void mo31805a() throws RemoteException;
}
