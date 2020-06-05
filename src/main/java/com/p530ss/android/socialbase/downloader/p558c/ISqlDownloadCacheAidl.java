package com.p530ss.android.socialbase.downloader.p558c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadChunk;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.c.c */
public interface ISqlDownloadCacheAidl extends IInterface {

    /* compiled from: ISqlDownloadCacheAidl */
    /* renamed from: com.ss.android.socialbase.downloader.c.c$a */
    public static abstract class C6642a extends Binder implements ISqlDownloadCacheAidl {

        /* compiled from: ISqlDownloadCacheAidl */
        /* renamed from: com.ss.android.socialbase.downloader.c.c$a$a */
        private static class C6643a implements ISqlDownloadCacheAidl {
            /* renamed from: a */
            private IBinder f21727a;

            C6643a(IBinder iBinder) {
                this.f21727a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21727a;
            }

            /* renamed from: a */
            public void mo31668a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    this.f21727a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo31675a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21727a.transact(2, obtain, obtain2, 0);
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
            public DownloadInfo mo31677b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public List<DownloadInfo> mo31667a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    this.f21727a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public List<DownloadInfo> mo31679b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    this.f21727a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public List<DownloadInfo> mo31686c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    this.f21727a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public List<DownloadInfo> mo31689d(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeString(str);
                    this.f21727a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public List<DownloadChunk> mo31685c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(DownloadChunk.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo31690d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31674a(DownloadChunk bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21727a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31682b(DownloadChunk bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21727a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31671a(int i, int i2, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f21727a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31670a(int i, int i2, int i3, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    this.f21727a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31669a(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.f21727a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public DownloadInfo mo31664a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f21727a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo31676a(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean z = true;
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21727a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public boolean mo31693e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21727a.transact(17, obtain, obtain2, 0);
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

            /* renamed from: f */
            public boolean mo31694f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    boolean z = false;
                    this.f21727a.transact(18, obtain, obtain2, 0);
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
            public void mo31680b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    this.f21727a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public DownloadInfo mo31695g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public DownloadInfo mo31666a(int i, long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f21727a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public DownloadInfo mo31665a(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f21727a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public DownloadInfo mo31678b(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f21727a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public DownloadInfo mo31696h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public DownloadInfo mo31684c(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f21727a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public DownloadInfo mo31688d(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f21727a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public DownloadInfo mo31692e(int i, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f21727a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public DownloadInfo mo31697i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public DownloadInfo mo31698j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    this.f21727a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (DownloadInfo) DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public boolean mo31687c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean z = false;
                    this.f21727a.transact(30, obtain, obtain2, 0);
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

            /* renamed from: d */
            public boolean mo31691d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    boolean z = false;
                    this.f21727a.transact(31, obtain, obtain2, 0);
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
            public void mo31683b(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21727a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31672a(int i, List<DownloadChunk> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f21727a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31681b(int i, List<DownloadChunk> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeInt(i);
                    obtain.writeTypedList(list);
                    this.f21727a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31673a(ISqlCacheLoadCompleteCallbackAidl bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f21727a.transact(35, obtain, obtain2, 0);
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

        public C6642a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
        }

        /* renamed from: a */
        public static ISqlDownloadCacheAidl m27027a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ISqlDownloadCacheAidl)) {
                return new C6643a(iBinder);
            }
            return (ISqlDownloadCacheAidl) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r0v7, types: [com.ss.android.socialbase.downloader.g.b] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v12, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v18, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: type inference failed for: r0v22 */
        /* JADX WARNING: type inference failed for: r0v23 */
        /* JADX WARNING: type inference failed for: r0v24 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v21
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.ss.android.socialbase.downloader.g.c]
  uses: [com.ss.android.socialbase.downloader.g.b, com.ss.android.socialbase.downloader.g.c]
	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:231)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:95)
	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:88)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
	at jadx.core.ProcessClass.process(ProcessClass.java:30)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
        /* JADX WARNING: Unknown variable types count: 7 */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
            r10 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            java.lang.String r1 = "com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl"
            r2 = 1
            if (r11 == r0) goto L_0x0336
            r0 = 0
            r3 = 0
            switch(r11) {
                case 1: goto L_0x032c;
                case 2: goto L_0x031a;
                case 3: goto L_0x02ff;
                case 4: goto L_0x02ed;
                case 5: goto L_0x02db;
                case 6: goto L_0x02c9;
                case 7: goto L_0x02b7;
                case 8: goto L_0x02a5;
                case 9: goto L_0x0297;
                case 10: goto L_0x027e;
                case 11: goto L_0x0265;
                case 12: goto L_0x024f;
                case 13: goto L_0x0234;
                case 14: goto L_0x021a;
                case 15: goto L_0x01fb;
                case 16: goto L_0x01de;
                case 17: goto L_0x01cc;
                case 18: goto L_0x01ba;
                case 19: goto L_0x01b0;
                case 20: goto L_0x0195;
                case 21: goto L_0x016d;
                case 22: goto L_0x014e;
                case 23: goto L_0x012f;
                case 24: goto L_0x0114;
                case 25: goto L_0x00f5;
                case 26: goto L_0x00d6;
                case 27: goto L_0x00b7;
                case 28: goto L_0x009c;
                case 29: goto L_0x0081;
                case 30: goto L_0x0073;
                case 31: goto L_0x0065;
                case 32: goto L_0x004c;
                case 33: goto L_0x0038;
                case 34: goto L_0x0024;
                case 35: goto L_0x0012;
                default: goto L_0x000d;
            }
        L_0x000d:
            boolean r11 = super.onTransact(r11, r12, r13, r14)
            return r11
        L_0x0012:
            r12.enforceInterface(r1)
            android.os.IBinder r11 = r12.readStrongBinder()
            com.ss.android.socialbase.downloader.c.b r11 = com.p530ss.android.socialbase.downloader.p558c.ISqlCacheLoadCompleteCallbackAidl.C6640a.m26990a(r11)
            r10.mo31673a(r11)
            r13.writeNoException()
            return r2
        L_0x0024:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r14 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.util.ArrayList r12 = r12.createTypedArrayList(r14)
            r10.mo31681b(r11, r12)
            r13.writeNoException()
            return r2
        L_0x0038:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r14 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.util.ArrayList r12 = r12.createTypedArrayList(r14)
            r10.mo31672a(r11, r12)
            r13.writeNoException()
            return r2
        L_0x004c:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x005e
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r11 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r0 = r11
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x005e:
            r10.mo31683b(r0)
            r13.writeNoException()
            return r2
        L_0x0065:
            r12.enforceInterface(r1)
            boolean r11 = r10.mo31691d()
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x0073:
            r12.enforceInterface(r1)
            boolean r11 = r10.mo31687c()
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x0081:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31698j(r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0098
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x009b
        L_0x0098:
            r13.writeInt(r3)
        L_0x009b:
            return r2
        L_0x009c:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31697i(r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x00b3
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x00b6
        L_0x00b3:
            r13.writeInt(r3)
        L_0x00b6:
            return r2
        L_0x00b7:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            long r0 = r12.readLong()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31692e(r11, r0)
            r13.writeNoException()
            if (r11 == 0) goto L_0x00d2
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x00d5
        L_0x00d2:
            r13.writeInt(r3)
        L_0x00d5:
            return r2
        L_0x00d6:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            long r0 = r12.readLong()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31688d(r11, r0)
            r13.writeNoException()
            if (r11 == 0) goto L_0x00f1
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x00f4
        L_0x00f1:
            r13.writeInt(r3)
        L_0x00f4:
            return r2
        L_0x00f5:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            long r0 = r12.readLong()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31684c(r11, r0)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0110
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x0113
        L_0x0110:
            r13.writeInt(r3)
        L_0x0113:
            return r2
        L_0x0114:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31696h(r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x012b
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x012e
        L_0x012b:
            r13.writeInt(r3)
        L_0x012e:
            return r2
        L_0x012f:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            long r0 = r12.readLong()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31678b(r11, r0)
            r13.writeNoException()
            if (r11 == 0) goto L_0x014a
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x014d
        L_0x014a:
            r13.writeInt(r3)
        L_0x014d:
            return r2
        L_0x014e:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            long r0 = r12.readLong()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31665a(r11, r0)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0169
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x016c
        L_0x0169:
            r13.writeInt(r3)
        L_0x016c:
            return r2
        L_0x016d:
            r12.enforceInterface(r1)
            int r5 = r12.readInt()
            long r6 = r12.readLong()
            java.lang.String r8 = r12.readString()
            java.lang.String r9 = r12.readString()
            r4 = r10
            com.ss.android.socialbase.downloader.g.c r11 = r4.mo31666a(r5, r6, r8, r9)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0191
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x0194
        L_0x0191:
            r13.writeInt(r3)
        L_0x0194:
            return r2
        L_0x0195:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31695g(r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x01ac
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x01af
        L_0x01ac:
            r13.writeInt(r3)
        L_0x01af:
            return r2
        L_0x01b0:
            r12.enforceInterface(r1)
            r10.mo31680b()
            r13.writeNoException()
            return r2
        L_0x01ba:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            boolean r11 = r10.mo31694f(r11)
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x01cc:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            boolean r11 = r10.mo31693e(r11)
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x01de:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x01f0
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r11 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r0 = r11
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x01f0:
            boolean r11 = r10.mo31676a(r0)
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x01fb:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            int r12 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31664a(r11, r12)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0216
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x0219
        L_0x0216:
            r13.writeInt(r3)
        L_0x0219:
            return r2
        L_0x021a:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            int r14 = r12.readInt()
            int r0 = r12.readInt()
            int r12 = r12.readInt()
            r10.mo31669a(r11, r14, r0, r12)
            r13.writeNoException()
            return r2
        L_0x0234:
            r12.enforceInterface(r1)
            int r4 = r12.readInt()
            int r5 = r12.readInt()
            int r6 = r12.readInt()
            long r7 = r12.readLong()
            r3 = r10
            r3.mo31670a(r4, r5, r6, r7)
            r13.writeNoException()
            return r2
        L_0x024f:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            int r14 = r12.readInt()
            long r0 = r12.readLong()
            r10.mo31671a(r11, r14, r0)
            r13.writeNoException()
            return r2
        L_0x0265:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0277
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r11 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r0 = r11
            com.ss.android.socialbase.downloader.g.b r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r0
        L_0x0277:
            r10.mo31682b(r0)
            r13.writeNoException()
            return r2
        L_0x027e:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            if (r11 == 0) goto L_0x0290
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.b> r11 = com.p530ss.android.socialbase.downloader.p562g.DownloadChunk.CREATOR
            java.lang.Object r11 = r11.createFromParcel(r12)
            r0 = r11
            com.ss.android.socialbase.downloader.g.b r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadChunk) r0
        L_0x0290:
            r10.mo31674a(r0)
            r13.writeNoException()
            return r2
        L_0x0297:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            r10.mo31690d(r11)
            r13.writeNoException()
            return r2
        L_0x02a5:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            java.util.List r11 = r10.mo31685c(r11)
            r13.writeNoException()
            r13.writeTypedList(r11)
            return r2
        L_0x02b7:
            r12.enforceInterface(r1)
            java.lang.String r11 = r12.readString()
            java.util.List r11 = r10.mo31689d(r11)
            r13.writeNoException()
            r13.writeTypedList(r11)
            return r2
        L_0x02c9:
            r12.enforceInterface(r1)
            java.lang.String r11 = r12.readString()
            java.util.List r11 = r10.mo31686c(r11)
            r13.writeNoException()
            r13.writeTypedList(r11)
            return r2
        L_0x02db:
            r12.enforceInterface(r1)
            java.lang.String r11 = r12.readString()
            java.util.List r11 = r10.mo31679b(r11)
            r13.writeNoException()
            r13.writeTypedList(r11)
            return r2
        L_0x02ed:
            r12.enforceInterface(r1)
            java.lang.String r11 = r12.readString()
            java.util.List r11 = r10.mo31667a(r11)
            r13.writeNoException()
            r13.writeTypedList(r11)
            return r2
        L_0x02ff:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            com.ss.android.socialbase.downloader.g.c r11 = r10.mo31677b(r11)
            r13.writeNoException()
            if (r11 == 0) goto L_0x0316
            r13.writeInt(r2)
            r11.writeToParcel(r13, r2)
            goto L_0x0319
        L_0x0316:
            r13.writeInt(r3)
        L_0x0319:
            return r2
        L_0x031a:
            r12.enforceInterface(r1)
            int r11 = r12.readInt()
            boolean r11 = r10.mo31675a(r11)
            r13.writeNoException()
            r13.writeInt(r11)
            return r2
        L_0x032c:
            r12.enforceInterface(r1)
            r10.mo31668a()
            r13.writeNoException()
            return r2
        L_0x0336:
            r13.writeString(r1)
            return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p558c.ISqlDownloadCacheAidl.C6642a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    DownloadInfo mo31664a(int i, int i2) throws RemoteException;

    /* renamed from: a */
    DownloadInfo mo31665a(int i, long j) throws RemoteException;

    /* renamed from: a */
    DownloadInfo mo31666a(int i, long j, String str, String str2) throws RemoteException;

    /* renamed from: a */
    List<DownloadInfo> mo31667a(String str) throws RemoteException;

    /* renamed from: a */
    void mo31668a() throws RemoteException;

    /* renamed from: a */
    void mo31669a(int i, int i2, int i3, int i4) throws RemoteException;

    /* renamed from: a */
    void mo31670a(int i, int i2, int i3, long j) throws RemoteException;

    /* renamed from: a */
    void mo31671a(int i, int i2, long j) throws RemoteException;

    /* renamed from: a */
    void mo31672a(int i, List<DownloadChunk> list) throws RemoteException;

    /* renamed from: a */
    void mo31673a(ISqlCacheLoadCompleteCallbackAidl bVar) throws RemoteException;

    /* renamed from: a */
    void mo31674a(DownloadChunk bVar) throws RemoteException;

    /* renamed from: a */
    boolean mo31675a(int i) throws RemoteException;

    /* renamed from: a */
    boolean mo31676a(DownloadInfo cVar) throws RemoteException;

    /* renamed from: b */
    DownloadInfo mo31677b(int i) throws RemoteException;

    /* renamed from: b */
    DownloadInfo mo31678b(int i, long j) throws RemoteException;

    /* renamed from: b */
    List<DownloadInfo> mo31679b(String str) throws RemoteException;

    /* renamed from: b */
    void mo31680b() throws RemoteException;

    /* renamed from: b */
    void mo31681b(int i, List<DownloadChunk> list) throws RemoteException;

    /* renamed from: b */
    void mo31682b(DownloadChunk bVar) throws RemoteException;

    /* renamed from: b */
    void mo31683b(DownloadInfo cVar) throws RemoteException;

    /* renamed from: c */
    DownloadInfo mo31684c(int i, long j) throws RemoteException;

    /* renamed from: c */
    List<DownloadChunk> mo31685c(int i) throws RemoteException;

    /* renamed from: c */
    List<DownloadInfo> mo31686c(String str) throws RemoteException;

    /* renamed from: c */
    boolean mo31687c() throws RemoteException;

    /* renamed from: d */
    DownloadInfo mo31688d(int i, long j) throws RemoteException;

    /* renamed from: d */
    List<DownloadInfo> mo31689d(String str) throws RemoteException;

    /* renamed from: d */
    void mo31690d(int i) throws RemoteException;

    /* renamed from: d */
    boolean mo31691d() throws RemoteException;

    /* renamed from: e */
    DownloadInfo mo31692e(int i, long j) throws RemoteException;

    /* renamed from: e */
    boolean mo31693e(int i) throws RemoteException;

    /* renamed from: f */
    boolean mo31694f(int i) throws RemoteException;

    /* renamed from: g */
    DownloadInfo mo31695g(int i) throws RemoteException;

    /* renamed from: h */
    DownloadInfo mo31696h(int i) throws RemoteException;

    /* renamed from: i */
    DownloadInfo mo31697i(int i) throws RemoteException;

    /* renamed from: j */
    DownloadInfo mo31698j(int i) throws RemoteException;
}
