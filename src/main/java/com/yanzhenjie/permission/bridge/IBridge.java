package com.yanzhenjie.permission.bridge;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.yanzhenjie.permission.bridge.b */
public interface IBridge extends IInterface {

    /* compiled from: IBridge */
    /* renamed from: com.yanzhenjie.permission.bridge.b$a */
    public static abstract class C7829a extends Binder implements IBridge {

        /* compiled from: IBridge */
        /* renamed from: com.yanzhenjie.permission.bridge.b$a$a */
        private static class C7830a implements IBridge {
            /* renamed from: a */
            public static IBridge f26646a;
            /* renamed from: b */
            private IBinder f26647b;

            C7830a(IBinder iBinder) {
                this.f26647b = iBinder;
            }

            public IBinder asBinder() {
                return this.f26647b;
            }

            /* renamed from: a */
            public void mo38021a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(1, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38021a(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo38022a(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    if (this.f26647b.transact(2, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38022a(str, strArr);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo38023b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(3, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38023b(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo38024c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(4, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38024c(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo38025d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(5, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38025d(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo38026e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(6, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38026e(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo38027f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(7, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38027f(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo38028g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.yanzhenjie.permission.bridge.IBridge");
                    obtain.writeString(str);
                    if (this.f26647b.transact(8, obtain, obtain2, 0) || C7829a.m34031a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C7829a.m34031a().mo38028g(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C7829a() {
            attachInterface(this, "com.yanzhenjie.permission.bridge.IBridge");
        }

        /* renamed from: a */
        public static IBridge m34032a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.yanzhenjie.permission.bridge.IBridge");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IBridge)) {
                return new C7830a(iBinder);
            }
            return (IBridge) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.yanzhenjie.permission.bridge.IBridge";
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(str);
                        mo38021a(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(str);
                        mo38022a(parcel.readString(), parcel.createStringArray());
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(str);
                        mo38023b(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(str);
                        mo38024c(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(str);
                        mo38025d(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(str);
                        mo38026e(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(str);
                        mo38027f(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(str);
                        mo38028g(parcel.readString());
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

        /* renamed from: a */
        public static IBridge m34031a() {
            return C7830a.f26646a;
        }
    }

    /* renamed from: a */
    void mo38021a(String str) throws RemoteException;

    /* renamed from: a */
    void mo38022a(String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo38023b(String str) throws RemoteException;

    /* renamed from: c */
    void mo38024c(String str) throws RemoteException;

    /* renamed from: d */
    void mo38025d(String str) throws RemoteException;

    /* renamed from: e */
    void mo38026e(String str) throws RemoteException;

    /* renamed from: f */
    void mo38027f(String str) throws RemoteException;

    /* renamed from: g */
    void mo38028g(String str) throws RemoteException;
}
