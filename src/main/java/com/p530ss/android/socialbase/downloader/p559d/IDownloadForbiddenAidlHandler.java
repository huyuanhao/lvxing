package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p559d.IDownloadForbiddenAidlCallback.C6685a;

/* renamed from: com.ss.android.socialbase.downloader.d.z */
public interface IDownloadForbiddenAidlHandler extends IInterface {

    /* compiled from: IDownloadForbiddenAidlHandler */
    /* renamed from: com.ss.android.socialbase.downloader.d.z$a */
    public static abstract class C6687a extends Binder implements IDownloadForbiddenAidlHandler {

        /* compiled from: IDownloadForbiddenAidlHandler */
        /* renamed from: com.ss.android.socialbase.downloader.d.z$a$a */
        private static class C6688a implements IDownloadForbiddenAidlHandler {
            /* renamed from: a */
            private IBinder f21804a;

            C6688a(IBinder iBinder) {
                this.f21804a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21804a;
            }

            /* renamed from: a */
            public boolean mo31820a(IDownloadForbiddenAidlCallback yVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
                    obtain.writeStrongBinder(yVar != null ? yVar.asBinder() : null);
                    boolean z = false;
                    this.f21804a.transact(1, obtain, obtain2, 0);
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

        public C6687a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
        }

        /* renamed from: a */
        public static IDownloadForbiddenAidlHandler m27312a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadForbiddenAidlHandler)) {
                return new C6688a(iBinder);
            }
            return (IDownloadForbiddenAidlHandler) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler";
            if (i == 1) {
                parcel.enforceInterface(str);
                boolean a = mo31820a(C6685a.m27308a(parcel.readStrongBinder()));
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
    boolean mo31820a(IDownloadForbiddenAidlCallback yVar) throws RemoteException;
}
