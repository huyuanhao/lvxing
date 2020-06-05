package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.m */
public interface IDownloadAidlDepend extends IInterface {

    /* compiled from: IDownloadAidlDepend */
    /* renamed from: com.ss.android.socialbase.downloader.d.m$a */
    public static abstract class C6671a extends Binder implements IDownloadAidlDepend {

        /* compiled from: IDownloadAidlDepend */
        /* renamed from: com.ss.android.socialbase.downloader.d.m$a$a */
        private static class C6672a implements IDownloadAidlDepend {
            /* renamed from: a */
            private IBinder f21796a;

            C6672a(IBinder iBinder) {
                this.f21796a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21796a;
            }

            /* renamed from: a */
            public void mo31770a(DownloadInfo cVar, BaseException aVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f21796a.transact(1, obtain, obtain2, 0);
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

        public C6671a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        /* renamed from: a */
        public static IDownloadAidlDepend m27254a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlDepend)) {
                return new C6672a(iBinder);
            }
            return (IDownloadAidlDepend) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend";
            if (i == 1) {
                parcel.enforceInterface(str);
                BaseException aVar = null;
                DownloadInfo cVar = parcel.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    aVar = (BaseException) BaseException.CREATOR.createFromParcel(parcel);
                }
                mo31770a(cVar, aVar, parcel.readInt());
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
    void mo31770a(DownloadInfo cVar, BaseException aVar, int i) throws RemoteException;
}
