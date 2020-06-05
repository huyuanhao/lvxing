package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.rpc.b */
public interface C6952b extends IInterface {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.rpc.b$a */
    public static abstract class C6953a extends Binder implements C6952b {

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.android.tpush.rpc.b$a$a */
        private static class C6954a implements C6952b {
            /* renamed from: a */
            private IBinder f23076a;

            C6954a(IBinder iBinder) {
                this.f23076a = iBinder;
            }

            public IBinder asBinder() {
                return this.f23076a;
            }

            /* renamed from: a */
            public void mo33247a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITaskCallback");
                    this.f23076a.transact(1, obtain, obtain2, 0);
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

        public C6953a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITaskCallback");
        }

        /* renamed from: a */
        public static C6952b m29684a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITaskCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C6952b)) {
                return new C6954a(iBinder);
            }
            return (C6952b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = "com.tencent.android.tpush.rpc.ITaskCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo33247a();
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
    void mo33247a();
}
