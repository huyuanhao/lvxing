package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadDiskSpaceAidlCallback.C6681a;

/* renamed from: com.ss.android.socialbase.downloader.d.u */
public interface IDownloadDiskSpaceAidlHandler extends IInterface {

    /* compiled from: IDownloadDiskSpaceAidlHandler */
    /* renamed from: com.ss.android.socialbase.downloader.d.u$a */
    public static abstract class C6683a extends Binder implements IDownloadDiskSpaceAidlHandler {

        /* compiled from: IDownloadDiskSpaceAidlHandler */
        /* renamed from: com.ss.android.socialbase.downloader.d.u$a$a */
        private static class C6684a implements IDownloadDiskSpaceAidlHandler {
            /* renamed from: a */
            private IBinder f21802a;

            C6684a(IBinder iBinder) {
                this.f21802a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21802a;
            }

            /* renamed from: a */
            public boolean mo31809a(long j, long j2, IDownloadDiskSpaceAidlCallback tVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    boolean z = false;
                    this.f21802a.transact(1, obtain, obtain2, 0);
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

        public C6683a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
        }

        /* renamed from: a */
        public static IDownloadDiskSpaceAidlHandler m27301a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadDiskSpaceAidlHandler)) {
                return new C6684a(iBinder);
            }
            return (IDownloadDiskSpaceAidlHandler) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler";
            if (i == 1) {
                parcel.enforceInterface(str);
                boolean a = mo31809a(parcel.readLong(), parcel.readLong(), C6681a.m27298a(parcel.readStrongBinder()));
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
    boolean mo31809a(long j, long j2, IDownloadDiskSpaceAidlCallback tVar) throws RemoteException;
}
