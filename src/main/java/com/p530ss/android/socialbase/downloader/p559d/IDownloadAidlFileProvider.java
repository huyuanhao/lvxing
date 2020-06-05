package com.p530ss.android.socialbase.downloader.p559d;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.n */
public interface IDownloadAidlFileProvider extends IInterface {

    /* compiled from: IDownloadAidlFileProvider */
    /* renamed from: com.ss.android.socialbase.downloader.d.n$a */
    public static abstract class C6673a extends Binder implements IDownloadAidlFileProvider {

        /* compiled from: IDownloadAidlFileProvider */
        /* renamed from: com.ss.android.socialbase.downloader.d.n$a$a */
        private static class C6674a implements IDownloadAidlFileProvider {
            /* renamed from: a */
            private IBinder f21797a;

            C6674a(IBinder iBinder) {
                this.f21797a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21797a;
            }

            /* renamed from: a */
            public Uri mo31774a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21797a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6673a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
        }

        /* renamed from: a */
        public static IDownloadAidlFileProvider m27257a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlFileProvider)) {
                return new C6674a(iBinder);
            }
            return (IDownloadAidlFileProvider) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider";
            if (i == 1) {
                parcel.enforceInterface(str);
                Uri a = mo31774a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (a != null) {
                    parcel2.writeInt(1);
                    a.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
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
    Uri mo31774a(String str, String str2) throws RemoteException;
}
