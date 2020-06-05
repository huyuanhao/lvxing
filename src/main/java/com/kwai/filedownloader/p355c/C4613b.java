package com.kwai.filedownloader.p355c;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwai.filedownloader.p355c.C4610a.C4611a;
import com.kwai.filedownloader.p356d.C4619b;

/* renamed from: com.kwai.filedownloader.c.b */
public interface C4613b extends IInterface {

    /* renamed from: com.kwai.filedownloader.c.b$a */
    public static abstract class C4614a extends Binder implements C4613b {

        /* renamed from: com.kwai.filedownloader.c.b$a$a */
        private static class C4615a implements C4613b {
            /* renamed from: a */
            private IBinder f15014a;

            C4615a(IBinder iBinder) {
                this.f15014a = iBinder;
            }

            /* renamed from: a */
            public void mo25012a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    this.f15014a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo25013a(int i, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15014a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo25014a(C4610a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f15014a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo25015a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i4 = 1;
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(z2 ? 1 : 0);
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z3) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    this.f15014a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo25016a(boolean z) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z ? 1 : 0);
                    this.f15014a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo25017a(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f15014a.transact(5, obtain, obtain2, 0);
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

            /* renamed from: a */
            public boolean mo25018a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.f15014a.transact(3, obtain, obtain2, 0);
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

            public IBinder asBinder() {
                return this.f15014a;
            }

            /* renamed from: b */
            public void mo25019b(C4610a aVar) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f15014a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo25020b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    boolean z = false;
                    this.f15014a.transact(11, obtain, obtain2, 0);
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

            /* renamed from: b */
            public boolean mo25021b(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f15014a.transact(7, obtain, obtain2, 0);
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

            /* renamed from: c */
            public long mo25022c(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f15014a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo25023c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    this.f15014a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public long mo25024d(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f15014a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public byte mo25025e(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    this.f15014a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public boolean mo25026f(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f15014a.transact(14, obtain, obtain2, 0);
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

        public C4614a() {
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCService");
        }

        /* renamed from: a */
        public static C4613b m18853a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C4613b)) ? new C4615a(iBinder) : (C4613b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            String str = "com.kwai.filedownloader.i.IFileDownloadIPCService";
            if (i3 != 1598968902) {
                Notification notification = null;
                boolean z = false;
                switch (i3) {
                    case 1:
                        parcel3.enforceInterface(str);
                        mo25014a(C4611a.m18836a(parcel.readStrongBinder()));
                        return true;
                    case 2:
                        parcel3.enforceInterface(str);
                        mo25019b(C4611a.m18836a(parcel.readStrongBinder()));
                        return true;
                    case 3:
                        parcel3.enforceInterface(str);
                        boolean a = mo25018a(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel4.writeInt(a);
                        return true;
                    case 4:
                        parcel3.enforceInterface(str);
                        mo25015a(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0 ? (C4619b) C4619b.CREATOR.createFromParcel(parcel3) : null, parcel.readInt() != 0);
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel3.enforceInterface(str);
                        boolean a2 = mo25017a(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(a2);
                        return true;
                    case 6:
                        parcel3.enforceInterface(str);
                        mo25012a();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel3.enforceInterface(str);
                        boolean b = mo25021b(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(b);
                        return true;
                    case 8:
                        parcel3.enforceInterface(str);
                        long c = mo25022c(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeLong(c);
                        return true;
                    case 9:
                        parcel3.enforceInterface(str);
                        long d = mo25024d(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeLong(d);
                        return true;
                    case 10:
                        parcel3.enforceInterface(str);
                        byte e = mo25025e(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeByte(e);
                        return true;
                    case 11:
                        parcel3.enforceInterface(str);
                        boolean b2 = mo25020b();
                        parcel2.writeNoException();
                        parcel4.writeInt(b2);
                        return true;
                    case 12:
                        parcel3.enforceInterface(str);
                        int readInt = parcel.readInt();
                        if (parcel.readInt() != 0) {
                            notification = (Notification) Notification.CREATOR.createFromParcel(parcel3);
                        }
                        mo25013a(readInt, notification);
                        return true;
                    case 13:
                        parcel3.enforceInterface(str);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        mo25016a(z);
                        return true;
                    case 14:
                        parcel3.enforceInterface(str);
                        boolean f = mo25026f(parcel.readInt());
                        parcel2.writeNoException();
                        parcel4.writeInt(f);
                        return true;
                    case 15:
                        parcel3.enforceInterface(str);
                        mo25023c();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel4.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: a */
    void mo25012a();

    /* renamed from: a */
    void mo25013a(int i, Notification notification);

    /* renamed from: a */
    void mo25014a(C4610a aVar);

    /* renamed from: a */
    void mo25015a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, C4619b bVar, boolean z3);

    /* renamed from: a */
    void mo25016a(boolean z);

    /* renamed from: a */
    boolean mo25017a(int i);

    /* renamed from: a */
    boolean mo25018a(String str, String str2);

    /* renamed from: b */
    void mo25019b(C4610a aVar);

    /* renamed from: b */
    boolean mo25020b();

    /* renamed from: b */
    boolean mo25021b(int i);

    /* renamed from: c */
    long mo25022c(int i);

    /* renamed from: c */
    void mo25023c();

    /* renamed from: d */
    long mo25024d(int i);

    /* renamed from: e */
    byte mo25025e(int i);

    /* renamed from: f */
    boolean mo25026f(int i);
}
