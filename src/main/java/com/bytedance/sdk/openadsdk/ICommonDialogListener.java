package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICommonDialogListener extends IInterface {

    /* renamed from: com.bytedance.sdk.openadsdk.ICommonDialogListener$Stub */
    public static abstract class Stub extends Binder implements ICommonDialogListener {

        /* renamed from: com.bytedance.sdk.openadsdk.ICommonDialogListener$Stub$a */
        private static class C1997a implements ICommonDialogListener {
            /* renamed from: a */
            private IBinder f6368a;

            C1997a(IBinder iBinder) {
                this.f6368a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6368a;
            }

            public void onDialogBtnYes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f6368a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDialogBtnNo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f6368a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDialogCancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonDialogListener");
                    this.f6368a.transact(3, obtain, obtain2, 0);
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.ICommonDialogListener");
        }

        public static ICommonDialogListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ICommonDialogListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICommonDialogListener)) {
                return new C1997a(iBinder);
            }
            return (ICommonDialogListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.bytedance.sdk.openadsdk.ICommonDialogListener";
            if (i == 1) {
                parcel.enforceInterface(str);
                onDialogBtnYes();
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                onDialogBtnNo();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                onDialogCancel();
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

    void onDialogBtnNo() throws RemoteException;

    void onDialogBtnYes() throws RemoteException;

    void onDialogCancel() throws RemoteException;
}
