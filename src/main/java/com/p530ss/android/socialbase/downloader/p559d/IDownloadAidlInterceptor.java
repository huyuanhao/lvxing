package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.o */
public interface IDownloadAidlInterceptor extends IInterface {

    /* compiled from: IDownloadAidlInterceptor */
    /* renamed from: com.ss.android.socialbase.downloader.d.o$a */
    public static abstract class C6675a extends Binder implements IDownloadAidlInterceptor {

        /* compiled from: IDownloadAidlInterceptor */
        /* renamed from: com.ss.android.socialbase.downloader.d.o$a$a */
        private static class C6676a implements IDownloadAidlInterceptor {
            /* renamed from: a */
            private IBinder f21798a;

            C6676a(IBinder iBinder) {
                this.f21798a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21798a;
            }

            /* renamed from: a */
            public boolean mo31778a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
                    boolean z = false;
                    this.f21798a.transact(1, obtain, obtain2, 0);
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

        public C6675a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
        }

        /* renamed from: a */
        public static IDownloadAidlInterceptor m27260a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlInterceptor)) {
                return new C6676a(iBinder);
            }
            return (IDownloadAidlInterceptor) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor";
            if (i == 1) {
                parcel.enforceInterface(str);
                boolean a = mo31778a();
                parcel2.writeNoException();
                parcel2.writeInt(a);
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
    boolean mo31778a() throws RemoteException;
}
