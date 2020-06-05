package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.d.y */
public interface IDownloadForbiddenAidlCallback extends IInterface {

    /* compiled from: IDownloadForbiddenAidlCallback */
    /* renamed from: com.ss.android.socialbase.downloader.d.y$a */
    public static abstract class C6685a extends Binder implements IDownloadForbiddenAidlCallback {

        /* compiled from: IDownloadForbiddenAidlCallback */
        /* renamed from: com.ss.android.socialbase.downloader.d.y$a$a */
        private static class C6686a implements IDownloadForbiddenAidlCallback {
            /* renamed from: a */
            private IBinder f21803a;

            C6686a(IBinder iBinder) {
                this.f21803a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21803a;
            }

            /* renamed from: a */
            public void mo31815a(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    obtain.writeStringList(list);
                    this.f21803a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo31816a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
                    boolean z = false;
                    this.f21803a.transact(2, obtain, obtain2, 0);
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

        public C6685a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
        }

        /* renamed from: a */
        public static IDownloadForbiddenAidlCallback m27308a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadForbiddenAidlCallback)) {
                return new C6686a(iBinder);
            }
            return (IDownloadForbiddenAidlCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo31815a(parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                boolean a = mo31816a();
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
    void mo31815a(List<String> list) throws RemoteException;

    /* renamed from: a */
    boolean mo31816a() throws RemoteException;
}
