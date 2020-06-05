package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.c */
public interface INotificationClickAidlCallback extends IInterface {

    /* compiled from: INotificationClickAidlCallback */
    /* renamed from: com.ss.android.socialbase.downloader.d.c$a */
    public static abstract class C6663a extends Binder implements INotificationClickAidlCallback {

        /* compiled from: INotificationClickAidlCallback */
        /* renamed from: com.ss.android.socialbase.downloader.d.c$a$a */
        private static class C6664a implements INotificationClickAidlCallback {
            /* renamed from: a */
            private IBinder f21791a;

            C6664a(IBinder iBinder) {
                this.f21791a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21791a;
            }

            /* renamed from: a */
            public boolean mo31746a(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z = true;
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21791a.transact(1, obtain, obtain2, 0);
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

            /* renamed from: b */
            public boolean mo31747b(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
                    boolean z = true;
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21791a.transact(2, obtain, obtain2, 0);
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
        }

        public IBinder asBinder() {
            return this;
        }

        public C6663a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
        }

        /* renamed from: a */
        public static INotificationClickAidlCallback m27213a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof INotificationClickAidlCallback)) {
                return new C6664a(iBinder);
            }
            return (INotificationClickAidlCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            DownloadInfo cVar = null;
            String str = "com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                if (parcel.readInt() != 0) {
                    cVar = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(parcel);
                }
                boolean a = mo31746a(cVar);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                if (parcel.readInt() != 0) {
                    cVar = (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(parcel);
                }
                boolean b = mo31747b(cVar);
                parcel2.writeNoException();
                parcel2.writeInt(b);
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
    boolean mo31746a(DownloadInfo cVar) throws RemoteException;

    /* renamed from: b */
    boolean mo31747b(DownloadInfo cVar) throws RemoteException;
}
