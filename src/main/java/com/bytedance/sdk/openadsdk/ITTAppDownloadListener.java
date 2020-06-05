package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITTAppDownloadListener extends IInterface {

    /* renamed from: com.bytedance.sdk.openadsdk.ITTAppDownloadListener$Stub */
    public static abstract class Stub extends Binder implements ITTAppDownloadListener {

        /* renamed from: com.bytedance.sdk.openadsdk.ITTAppDownloadListener$Stub$a */
        private static class C2002a implements ITTAppDownloadListener {
            /* renamed from: a */
            private IBinder f6373a;

            C2002a(IBinder iBinder) {
                this.f6373a = iBinder;
            }

            public IBinder asBinder() {
                return this.f6373a;
            }

            public void onIdle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    this.f6373a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6373a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6373a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6373a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6373a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInstalled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6373a.transact(6, obtain, obtain2, 0);
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        }

        public static ITTAppDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITTAppDownloadListener)) {
                return new C2002a(iBinder);
            }
            return (ITTAppDownloadListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.bytedance.sdk.openadsdk.ITTAppDownloadListener";
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(str);
                        onIdle();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(str);
                        onDownloadActive(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(str);
                        onDownloadPaused(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(str);
                        onDownloadFailed(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(str);
                        onDownloadFinished(parcel.readLong(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(str);
                        onInstalled(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFinished(long j, String str, String str2) throws RemoteException;

    void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException;

    void onIdle() throws RemoteException;

    void onInstalled(String str, String str2) throws RemoteException;
}
