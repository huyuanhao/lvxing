package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.ss.android.socialbase.downloader.d.l */
public interface IChunkCntAidlCalculator extends IInterface {

    /* compiled from: IChunkCntAidlCalculator */
    /* renamed from: com.ss.android.socialbase.downloader.d.l$a */
    public static abstract class C6669a extends Binder implements IChunkCntAidlCalculator {

        /* compiled from: IChunkCntAidlCalculator */
        /* renamed from: com.ss.android.socialbase.downloader.d.l$a$a */
        private static class C6670a implements IChunkCntAidlCalculator {
            /* renamed from: a */
            private IBinder f21795a;

            C6670a(IBinder iBinder) {
                this.f21795a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21795a;
            }

            /* renamed from: a */
            public int mo31766a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
                    obtain.writeLong(j);
                    this.f21795a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6669a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
        }

        /* renamed from: a */
        public static IChunkCntAidlCalculator m27251a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IChunkCntAidlCalculator)) {
                return new C6670a(iBinder);
            }
            return (IChunkCntAidlCalculator) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator";
            if (i == 1) {
                parcel.enforceInterface(str);
                int a = mo31766a(parcel.readLong());
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
    int mo31766a(long j) throws RemoteException;
}
