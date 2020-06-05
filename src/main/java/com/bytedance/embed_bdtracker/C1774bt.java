package com.bytedance.embed_bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.bytedance.embed_bdtracker.bt */
public interface C1774bt extends IInterface {

    /* renamed from: com.bytedance.embed_bdtracker.bt$a */
    public static abstract class C1775a extends Binder implements C1774bt {

        /* renamed from: com.bytedance.embed_bdtracker.bt$a$a */
        private static class C1776a implements C1774bt {
            /* renamed from: a */
            private IBinder f4925a;

            C1776a(IBinder iBinder) {
                this.f4925a = iBinder;
            }

            public IBinder asBinder() {
                return this.f4925a;
            }

            /* renamed from: a */
            public String mo13242a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f4925a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo13243b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z = false;
                    this.f4925a.transact(2, obtain, obtain2, 0);
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

        /* renamed from: a */
        public static C1774bt m6165a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1774bt)) {
                return new C1776a(iBinder);
            }
            return (C1774bt) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
            if (i == 1) {
                parcel.enforceInterface(str);
                String a = mo13242a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                boolean b = mo13243b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
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
    String mo13242a();

    /* renamed from: b */
    boolean mo13243b();
}
