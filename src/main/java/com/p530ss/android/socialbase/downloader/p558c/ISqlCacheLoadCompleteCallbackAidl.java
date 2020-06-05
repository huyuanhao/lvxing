package com.p530ss.android.socialbase.downloader.p558c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.c.b */
public interface ISqlCacheLoadCompleteCallbackAidl extends IInterface {

    /* compiled from: ISqlCacheLoadCompleteCallbackAidl */
    /* renamed from: com.ss.android.socialbase.downloader.c.b$a */
    public static abstract class C6640a extends Binder implements ISqlCacheLoadCompleteCallbackAidl {

        /* compiled from: ISqlCacheLoadCompleteCallbackAidl */
        /* renamed from: com.ss.android.socialbase.downloader.c.b$a$a */
        private static class C6641a implements ISqlCacheLoadCompleteCallbackAidl {
            /* renamed from: a */
            private IBinder f21726a;

            C6641a(IBinder iBinder) {
                this.f21726a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21726a;
            }

            /* renamed from: a */
            public void mo31660a(Map map, Map map2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    this.f21726a.transact(1, obtain, obtain2, 0);
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

        public C6640a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
        }

        /* renamed from: a */
        public static ISqlCacheLoadCompleteCallbackAidl m26990a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISqlCacheLoadCompleteCallbackAidl)) {
                return new C6641a(iBinder);
            }
            return (ISqlCacheLoadCompleteCallbackAidl) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.db.ISqlCacheLoadCompleteCallbackAidl";
            if (i == 1) {
                parcel.enforceInterface(str);
                ClassLoader classLoader = getClass().getClassLoader();
                mo31660a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
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
    void mo31660a(Map map, Map map2) throws RemoteException;
}
