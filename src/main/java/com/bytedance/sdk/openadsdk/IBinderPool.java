package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IBinderPool extends IInterface {

    /* renamed from: com.bytedance.sdk.openadsdk.IBinderPool$Stub */
    public static abstract class Stub extends Binder implements IBinderPool {

        /* renamed from: com.bytedance.sdk.openadsdk.IBinderPool$Stub$a */
        private static class C1996a implements IBinderPool {
            /* renamed from: a */
            private IBinder f6367a;

            C1996a(IBinder iBinder) {
                this.f6367a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6367a;
            }

            public IBinder queryBinder(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IBinderPool");
                    obtain.writeInt(i);
                    this.f6367a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IBinderPool");
        }

        public static IBinderPool asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IBinderPool");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBinderPool)) {
                return new C1996a(iBinder);
            }
            return (IBinderPool) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.bytedance.sdk.openadsdk.IBinderPool";
            if (i == 1) {
                parcel.enforceInterface(str);
                IBinder queryBinder = queryBinder(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(queryBinder);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    IBinder queryBinder(int i) throws RemoteException;
}
