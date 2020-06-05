package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.e */
public interface IRetryDelayTimeAidlCalculator extends IInterface {

    /* compiled from: IRetryDelayTimeAidlCalculator */
    /* renamed from: com.ss.android.socialbase.downloader.d.e$a */
    public static abstract class C6665a extends Binder implements IRetryDelayTimeAidlCalculator {

        /* compiled from: IRetryDelayTimeAidlCalculator */
        /* renamed from: com.ss.android.socialbase.downloader.d.e$a$a */
        private static class C6666a implements IRetryDelayTimeAidlCalculator {
            /* renamed from: a */
            private IBinder f21792a;

            C6666a(IBinder iBinder) {
                this.f21792a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21792a;
            }

            /* renamed from: a */
            public long mo31753a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f21792a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6665a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
        }

        /* renamed from: a */
        public static IRetryDelayTimeAidlCalculator m27219a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IRetryDelayTimeAidlCalculator)) {
                return new C6666a(iBinder);
            }
            return (IRetryDelayTimeAidlCalculator) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator";
            if (i == 1) {
                parcel.enforceInterface(str);
                long a = mo31753a(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeLong(a);
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
    long mo31753a(int i, int i2) throws RemoteException;
}
