package com.kwai.filedownloader.p355c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* renamed from: com.kwai.filedownloader.c.a */
public interface C4610a extends IInterface {

    /* renamed from: com.kwai.filedownloader.c.a$a */
    public static abstract class C4611a extends Binder implements C4610a {

        /* renamed from: com.kwai.filedownloader.c.a$a$a */
        private static class C4612a implements C4610a {
            /* renamed from: a */
            private IBinder f15013a;

            C4612a(IBinder iBinder) {
                this.f15013a = iBinder;
            }

            /* renamed from: a */
            public void mo25008a(MessageSnapshot messageSnapshot) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                    if (messageSnapshot != null) {
                        obtain.writeInt(1);
                        messageSnapshot.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15013a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f15013a;
            }
        }

        public C4611a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCCallback");
        }

        /* renamed from: a */
        public static C4610a m18836a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C4610a)) ? new C4612a(iBinder) : (C4610a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = "com.kwai.filedownloader.i.IFileDownloadIPCCallback";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo25008a(parcel.readInt() != 0 ? (MessageSnapshot) MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
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
    void mo25008a(MessageSnapshot messageSnapshot);
}
