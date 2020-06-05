package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.g */
public interface ProcessAidlCallback extends IInterface {

    /* compiled from: ProcessAidlCallback */
    /* renamed from: com.ss.android.socialbase.downloader.d.g$a */
    public static abstract class C6667a extends Binder implements ProcessAidlCallback {

        /* compiled from: ProcessAidlCallback */
        /* renamed from: com.ss.android.socialbase.downloader.d.g$a$a */
        private static class C6668a implements ProcessAidlCallback {
            /* renamed from: a */
            private IBinder f21793a;

            C6668a(IBinder iBinder) {
                this.f21793a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21793a;
            }

            /* renamed from: a */
            public void mo31759a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f21793a.transact(1, obtain, obtain2, 0);
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

        public C6667a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
        }

        /* renamed from: a */
        public static ProcessAidlCallback m27224a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.ProcessAidlCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ProcessAidlCallback)) {
                return new C6668a(iBinder);
            }
            return (ProcessAidlCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.ProcessAidlCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo31759a(parcel.readInt(), parcel.readInt());
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
    void mo31759a(int i, int i2) throws RemoteException;
}
