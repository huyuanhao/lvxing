package com.p530ss.android.socialbase.downloader.p559d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.p530ss.android.socialbase.downloader.p560e.BaseException;
import com.p530ss.android.socialbase.downloader.p562g.DownloadInfo;

/* renamed from: com.ss.android.socialbase.downloader.d.p */
public interface IDownloadAidlListener extends IInterface {

    /* compiled from: IDownloadAidlListener */
    /* renamed from: com.ss.android.socialbase.downloader.d.p$a */
    public static abstract class C6677a extends Binder implements IDownloadAidlListener {

        /* compiled from: IDownloadAidlListener */
        /* renamed from: com.ss.android.socialbase.downloader.d.p$a$a */
        private static class C6678a implements IDownloadAidlListener {
            /* renamed from: a */
            private IBinder f21799a;

            C6678a(IBinder iBinder) {
                this.f21799a = iBinder;
            }

            public IBinder asBinder() {
                return this.f21799a;
            }

            /* renamed from: a */
            public int mo31782a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    this.f21799a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31783a(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31785b(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo31787c(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo31789d(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo31790e(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo31784a(DownloadInfo cVar, BaseException aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo31791f(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo31792g(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo31793h(DownloadInfo cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo31786b(DownloadInfo cVar, BaseException aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo31788c(DownloadInfo cVar, BaseException aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
                    if (cVar != null) {
                        obtain.writeInt(1);
                        cVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (aVar != null) {
                        obtain.writeInt(1);
                        aVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f21799a.transact(12, obtain, obtain2, 0);
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

        public C6677a() {
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
        }

        /* renamed from: a */
        public static IDownloadAidlListener m27274a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDownloadAidlListener)) {
                return new C6678a(iBinder);
            }
            return (IDownloadAidlListener) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v7, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v17, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v22, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v23, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v28, types: [com.ss.android.socialbase.downloader.g.c] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v32, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.ss.android.socialbase.downloader.e.a] */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: type inference failed for: r0v37 */
        /* JADX WARNING: type inference failed for: r0v38 */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: type inference failed for: r0v40 */
        /* JADX WARNING: type inference failed for: r0v41 */
        /* JADX WARNING: type inference failed for: r0v42 */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v35
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.ss.android.socialbase.downloader.e.a]
  uses: [com.ss.android.socialbase.downloader.g.c, com.ss.android.socialbase.downloader.e.a]
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
        /* JADX WARNING: Unknown variable types count: 21 */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
            r3 = this;
            r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
            r1 = 1
            java.lang.String r2 = "com.ss.android.socialbase.downloader.depend.IDownloadAidlListener"
            if (r4 == r0) goto L_0x0162
            r0 = 0
            switch(r4) {
                case 1: goto L_0x0154;
                case 2: goto L_0x013b;
                case 3: goto L_0x0122;
                case 4: goto L_0x0109;
                case 5: goto L_0x00f0;
                case 6: goto L_0x00d7;
                case 7: goto L_0x00ae;
                case 8: goto L_0x0095;
                case 9: goto L_0x007c;
                case 10: goto L_0x0063;
                case 11: goto L_0x003a;
                case 12: goto L_0x0011;
                default: goto L_0x000c;
            }
        L_0x000c:
            boolean r4 = super.onTransact(r4, r5, r6, r7)
            return r4
        L_0x0011:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0023
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            com.ss.android.socialbase.downloader.g.c r4 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r4
            goto L_0x0024
        L_0x0023:
            r4 = r0
        L_0x0024:
            int r7 = r5.readInt()
            if (r7 == 0) goto L_0x0033
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.e.a> r7 = com.p530ss.android.socialbase.downloader.p560e.BaseException.CREATOR
            java.lang.Object r5 = r7.createFromParcel(r5)
            r0 = r5
            com.ss.android.socialbase.downloader.e.a r0 = (com.p530ss.android.socialbase.downloader.p560e.BaseException) r0
        L_0x0033:
            r3.mo31788c(r4, r0)
            r6.writeNoException()
            return r1
        L_0x003a:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x004c
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            com.ss.android.socialbase.downloader.g.c r4 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r4
            goto L_0x004d
        L_0x004c:
            r4 = r0
        L_0x004d:
            int r7 = r5.readInt()
            if (r7 == 0) goto L_0x005c
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.e.a> r7 = com.p530ss.android.socialbase.downloader.p560e.BaseException.CREATOR
            java.lang.Object r5 = r7.createFromParcel(r5)
            r0 = r5
            com.ss.android.socialbase.downloader.e.a r0 = (com.p530ss.android.socialbase.downloader.p560e.BaseException) r0
        L_0x005c:
            r3.mo31786b(r4, r0)
            r6.writeNoException()
            return r1
        L_0x0063:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0075
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x0075:
            r3.mo31793h(r0)
            r6.writeNoException()
            return r1
        L_0x007c:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x008e
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x008e:
            r3.mo31792g(r0)
            r6.writeNoException()
            return r1
        L_0x0095:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00a7
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x00a7:
            r3.mo31791f(r0)
            r6.writeNoException()
            return r1
        L_0x00ae:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00c0
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            com.ss.android.socialbase.downloader.g.c r4 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r4
            goto L_0x00c1
        L_0x00c0:
            r4 = r0
        L_0x00c1:
            int r7 = r5.readInt()
            if (r7 == 0) goto L_0x00d0
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.e.a> r7 = com.p530ss.android.socialbase.downloader.p560e.BaseException.CREATOR
            java.lang.Object r5 = r7.createFromParcel(r5)
            r0 = r5
            com.ss.android.socialbase.downloader.e.a r0 = (com.p530ss.android.socialbase.downloader.p560e.BaseException) r0
        L_0x00d0:
            r3.mo31784a(r4, r0)
            r6.writeNoException()
            return r1
        L_0x00d7:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x00e9
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x00e9:
            r3.mo31790e(r0)
            r6.writeNoException()
            return r1
        L_0x00f0:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0102
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x0102:
            r3.mo31789d(r0)
            r6.writeNoException()
            return r1
        L_0x0109:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x011b
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x011b:
            r3.mo31787c(r0)
            r6.writeNoException()
            return r1
        L_0x0122:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x0134
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x0134:
            r3.mo31785b(r0)
            r6.writeNoException()
            return r1
        L_0x013b:
            r5.enforceInterface(r2)
            int r4 = r5.readInt()
            if (r4 == 0) goto L_0x014d
            android.os.Parcelable$Creator<com.ss.android.socialbase.downloader.g.c> r4 = com.p530ss.android.socialbase.downloader.p562g.DownloadInfo.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r5)
            r0 = r4
            com.ss.android.socialbase.downloader.g.c r0 = (com.p530ss.android.socialbase.downloader.p562g.DownloadInfo) r0
        L_0x014d:
            r3.mo31783a(r0)
            r6.writeNoException()
            return r1
        L_0x0154:
            r5.enforceInterface(r2)
            int r4 = r3.mo31782a()
            r6.writeNoException()
            r6.writeInt(r4)
            return r1
        L_0x0162:
            r6.writeString(r2)
            return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.socialbase.downloader.p559d.IDownloadAidlListener.C6677a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    int mo31782a() throws RemoteException;

    /* renamed from: a */
    void mo31783a(DownloadInfo cVar) throws RemoteException;

    /* renamed from: a */
    void mo31784a(DownloadInfo cVar, BaseException aVar) throws RemoteException;

    /* renamed from: b */
    void mo31785b(DownloadInfo cVar) throws RemoteException;

    /* renamed from: b */
    void mo31786b(DownloadInfo cVar, BaseException aVar) throws RemoteException;

    /* renamed from: c */
    void mo31787c(DownloadInfo cVar) throws RemoteException;

    /* renamed from: c */
    void mo31788c(DownloadInfo cVar, BaseException aVar) throws RemoteException;

    /* renamed from: d */
    void mo31789d(DownloadInfo cVar) throws RemoteException;

    /* renamed from: e */
    void mo31790e(DownloadInfo cVar) throws RemoteException;

    /* renamed from: f */
    void mo31791f(DownloadInfo cVar) throws RemoteException;

    /* renamed from: g */
    void mo31792g(DownloadInfo cVar) throws RemoteException;

    /* renamed from: h */
    void mo31793h(DownloadInfo cVar) throws RemoteException;
}
