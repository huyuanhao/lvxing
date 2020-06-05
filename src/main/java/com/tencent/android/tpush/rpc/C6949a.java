package com.tencent.android.tpush.rpc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.android.tpush.rpc.C6952b.C6953a;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.rpc.a */
public interface C6949a extends IInterface {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.android.tpush.rpc.a$a */
    public static abstract class C6950a extends Binder implements C6949a {

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.android.tpush.rpc.a$a$a */
        private static class C6951a implements C6949a {
            /* renamed from: a */
            private IBinder f23075a;

            C6951a(IBinder iBinder) {
                this.f23075a = iBinder;
            }

            public IBinder asBinder() {
                return this.f23075a;
            }

            /* renamed from: a */
            public void mo33241a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    this.f23075a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo33243b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    this.f23075a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo33242a(String str, C6952b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.android.tpush.rpc.ITask");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f23075a.transact(3, obtain, obtain2, 0);
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

        public C6950a() {
            attachInterface(this, "com.tencent.android.tpush.rpc.ITask");
        }

        /* renamed from: a */
        public static C6949a m29679a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.android.tpush.rpc.ITask");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C6949a)) {
                return new C6951a(iBinder);
            }
            return (C6949a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = "com.tencent.android.tpush.rpc.ITask";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo33241a();
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                mo33243b();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                mo33242a(parcel.readString(), C6953a.m29684a(parcel.readStrongBinder()));
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
    void mo33241a();

    /* renamed from: a */
    void mo33242a(String str, C6952b bVar);

    /* renamed from: b */
    void mo33243b();
}
