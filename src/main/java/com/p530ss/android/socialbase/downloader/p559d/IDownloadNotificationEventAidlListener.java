package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.af */
public interface IDownloadNotificationEventAidlListener extends IInterface {

    /* compiled from: IDownloadNotificationEventAidlListener */
    /* renamed from: com.ss.android.socialbase.downloader.d.af$a */
    public static abstract class C6661a extends Binder implements IDownloadNotificationEventAidlListener {

        /* compiled from: IDownloadNotificationEventAidlListener */
        /* renamed from: com.ss.android.socialbase.downloader.d.af$a$a */
        private static class C6662a implements IDownloadNotificationEventAidlListener {
            /* renamed from: a */
            private IBinder f21790a;

            C6662a(IBinder iBinder) {
                this.f21790a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21790a;
            }

            /* renamed from: a */
            public void mo31740a(int i, DownloadInfo cVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    obtain.writeInt(i);
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21790a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo31741a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    this.f21790a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public String mo31739a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
                    this.f21790a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public C6661a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
        }

        /* renamed from: a */
        public static IDownloadNotificationEventAidlListener m27203a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadNotificationEventAidlListener)) {
                return new C6662a(iBinder);
            }
            return (IDownloadNotificationEventAidlListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener";
            if (i == 1) {
                parcel.enforceInterface(str);
                mo31740a(parcel.readInt(), parcel.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                boolean a = mo31741a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(a);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                String a2 = mo31739a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
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
    String mo31739a() throws RemoteException;

    /* renamed from: a */
    void mo31740a(int i, DownloadInfo cVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    boolean mo31741a(boolean z) throws RemoteException;
}
