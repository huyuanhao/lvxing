package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICommonPermissionListener extends IInterface {

    /* renamed from: com.bytedance.sdk.openadsdk.ICommonPermissionListener$Stub */
    public static abstract class Stub extends Binder implements ICommonPermissionListener {

        /* renamed from: com.bytedance.sdk.openadsdk.ICommonPermissionListener$Stub$a */
        private static class C1998a implements ICommonPermissionListener {
            /* renamed from: a */
            private IBinder f6369a;

            C1998a(IBinder iBinder) {
                this.f6369a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6369a;
            }

            public void onGranted() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    this.f6369a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDenied(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    obtain.writeString(str);
                    this.f6369a.transact(2, obtain, obtain2, 0);
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

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.ICommonPermissionListener");
        }

        public static ICommonPermissionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICommonPermissionListener)) {
                return new C1998a(iBinder);
            }
            return (ICommonPermissionListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.bytedance.sdk.openadsdk.ICommonPermissionListener";
            if (i == 1) {
                parcel.enforceInterface(str);
                onGranted();
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                onDenied(parcel.readString());
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

    void onDenied(String str) throws RemoteException;

    void onGranted() throws RemoteException;
}
