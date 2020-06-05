package com.alibaba.mtl.appmonitor;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* renamed from: com.alibaba.mtl.appmonitor.c */
public interface IMonitor extends IInterface {

    /* compiled from: IMonitor */
    /* renamed from: com.alibaba.mtl.appmonitor.c$a */
    public static abstract class C1297a extends Binder implements IMonitor {

        /* compiled from: IMonitor */
        /* renamed from: com.alibaba.mtl.appmonitor.c$a$a */
        private static class C1298a implements IMonitor {
            /* renamed from: a */
            private IBinder f3190a;

            C1298a(IBinder iBinder) {
                this.f3190a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3190a;
            }

            /* renamed from: a */
            public void mo11583a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f3190a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11603a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z ? 1 : 0);
                    this.f3190a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11604a(boolean z, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3190a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11587a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    this.f3190a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo11606b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f3190a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11584a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo11607b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11585a(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f3190a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11592a(String str, String str2, MeasureSet measureSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3190a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11595a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f3190a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11593a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3190a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11594a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i = 1;
                    if (measureSet != null) {
                        obtain.writeInt(1);
                        measureSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dimensionSet != null) {
                        obtain.writeInt(1);
                        dimensionSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f3190a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11602a(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeMap(map);
                    this.f3190a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo11612c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f3190a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo11615d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    this.f3190a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo11613c(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo11616d(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public boolean mo11605a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.f3190a.transact(18, obtain, obtain2, 0);
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
            public void mo11589a(String str, String str2, double d, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    obtain.writeMap(map);
                    this.f3190a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11597a(String str, String str2, String str3, double d, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeDouble(d);
                    obtain.writeMap(map);
                    this.f3190a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo11618e(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo11619f(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public boolean mo11611b(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.f3190a.transact(23, obtain, obtain2, 0);
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
            public void mo11588a(String str, String str2, double d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    this.f3190a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo11620g(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo11621h(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public boolean mo11614c(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.f3190a.transact(27, obtain, obtain2, 0);
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
            public void mo11601a(String str, String str2, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeMap(map);
                    this.f3190a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11600a(String str, String str2, String str3, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeMap(map);
                    this.f3190a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11599a(String str, String str2, String str3, String str4, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeMap(map);
                    this.f3190a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11598a(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeMap(map);
                    this.f3190a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11596a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3190a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo11610b(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3190a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo11622i(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo11623j(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeInt(i);
                    this.f3190a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public boolean mo11617d(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z = false;
                    this.f3190a.transact(36, obtain, obtain2, 0);
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
            public void mo11609b(String str, String str2, double d, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeDouble(d);
                    obtain.writeMap(map);
                    this.f3190a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11590a(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeDouble(d);
                    obtain.writeMap(map);
                    this.f3190a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11591a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dimensionValueSet != null) {
                        obtain.writeInt(1);
                        dimensionValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (measureValueSet != null) {
                        obtain.writeInt(1);
                        measureValueSet.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeMap(map);
                    this.f3190a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo11586a(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f3190a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo11608b(Transaction transaction, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.alibaba.mtl.appmonitor.IMonitor");
                    if (transaction != null) {
                        obtain.writeInt(1);
                        transaction.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f3190a.transact(41, obtain, obtain2, 0);
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

        public C1297a() {
            attachInterface(this, "com.alibaba.mtl.appmonitor.IMonitor");
        }

        /* renamed from: a */
        public static IMonitor m3449a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.alibaba.mtl.appmonitor.IMonitor");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMonitor)) {
                return new C1298a(iBinder);
            }
            return (IMonitor) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r4v1, types: [com.alibaba.mtl.appmonitor.model.MeasureSet] */
        /* JADX WARNING: type inference failed for: r4v3, types: [com.alibaba.mtl.appmonitor.model.MeasureSet] */
        /* JADX WARNING: type inference failed for: r4v4, types: [com.alibaba.mtl.appmonitor.model.MeasureSet] */
        /* JADX WARNING: type inference failed for: r4v7, types: [com.alibaba.mtl.appmonitor.model.MeasureSet] */
        /* JADX WARNING: type inference failed for: r4v8, types: [com.alibaba.mtl.appmonitor.model.DimensionSet] */
        /* JADX WARNING: type inference failed for: r4v11, types: [com.alibaba.mtl.appmonitor.model.DimensionSet] */
        /* JADX WARNING: type inference failed for: r4v12, types: [com.alibaba.mtl.appmonitor.model.DimensionSet] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.alibaba.mtl.appmonitor.model.DimensionSet] */
        /* JADX WARNING: type inference failed for: r4v13 */
        /* JADX WARNING: type inference failed for: r4v24 */
        /* JADX WARNING: type inference failed for: r3v28, types: [com.alibaba.mtl.appmonitor.model.DimensionValueSet] */
        /* JADX WARNING: type inference failed for: r0v65, types: [com.alibaba.mtl.appmonitor.model.DimensionValueSet] */
        /* JADX WARNING: type inference failed for: r4v26 */
        /* JADX WARNING: type inference failed for: r4v27, types: [com.alibaba.mtl.appmonitor.model.MeasureValueSet] */
        /* JADX WARNING: type inference failed for: r0v73, types: [com.alibaba.mtl.appmonitor.model.MeasureValueSet] */
        /* JADX WARNING: type inference failed for: r4v28 */
        /* JADX WARNING: type inference failed for: r4v29, types: [com.alibaba.mtl.appmonitor.Transaction] */
        /* JADX WARNING: type inference failed for: r4v31, types: [com.alibaba.mtl.appmonitor.Transaction] */
        /* JADX WARNING: type inference failed for: r4v32, types: [com.alibaba.mtl.appmonitor.Transaction] */
        /* JADX WARNING: type inference failed for: r4v34, types: [com.alibaba.mtl.appmonitor.Transaction] */
        /* JADX WARNING: type inference failed for: r4v35 */
        /* JADX WARNING: type inference failed for: r4v36 */
        /* JADX WARNING: type inference failed for: r4v37 */
        /* JADX WARNING: type inference failed for: r4v38 */
        /* JADX WARNING: type inference failed for: r4v39 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v13
  assigns: [?[OBJECT, ARRAY], ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.alibaba.mtl.appmonitor.Transaction]
  uses: [com.alibaba.mtl.appmonitor.model.DimensionSet, com.alibaba.mtl.appmonitor.Transaction]
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
	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
	at java.util.ArrayList.forEach(ArrayList.java:1249)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
	at jadx.core.ProcessClass.process(ProcessClass.java:35)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
 */
        /* JADX WARNING: Unknown variable types count: 16 */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
            r9 = this;
            r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
            java.lang.String r3 = "com.alibaba.mtl.appmonitor.IMonitor"
            r7 = 1
            if (r10 == r2) goto L_0x0448
            r2 = 0
            r4 = 0
            switch(r10) {
                case 1: goto L_0x043e;
                case 2: goto L_0x042d;
                case 3: goto L_0x0410;
                case 4: goto L_0x0402;
                case 5: goto L_0x03f8;
                case 6: goto L_0x03ea;
                case 7: goto L_0x03dc;
                case 8: goto L_0x03ca;
                case 9: goto L_0x03a9;
                case 10: goto L_0x0382;
                case 11: goto L_0x0351;
                case 12: goto L_0x0311;
                case 13: goto L_0x02fb;
                case 14: goto L_0x02f1;
                case 15: goto L_0x02e7;
                case 16: goto L_0x02d9;
                case 17: goto L_0x02cb;
                case 18: goto L_0x02b5;
                case 19: goto L_0x028e;
                case 20: goto L_0x0262;
                case 21: goto L_0x0254;
                case 22: goto L_0x0246;
                case 23: goto L_0x0230;
                case 24: goto L_0x021a;
                case 25: goto L_0x020c;
                case 26: goto L_0x01fe;
                case 27: goto L_0x01e8;
                case 28: goto L_0x01ca;
                case 29: goto L_0x01a8;
                case 30: goto L_0x017c;
                case 31: goto L_0x014b;
                case 32: goto L_0x0135;
                case 33: goto L_0x011f;
                case 34: goto L_0x0111;
                case 35: goto L_0x0103;
                case 36: goto L_0x00ed;
                case 37: goto L_0x00c6;
                case 38: goto L_0x008f;
                case 39: goto L_0x004c;
                case 40: goto L_0x002f;
                case 41: goto L_0x0012;
                default: goto L_0x000d;
            }
        L_0x000d:
            boolean r0 = super.onTransact(r10, r11, r12, r13)
            return r0
        L_0x0012:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0024
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.Transaction> r0 = com.alibaba.mtl.appmonitor.Transaction.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            r4 = r0
            com.alibaba.mtl.appmonitor.Transaction r4 = (com.alibaba.mtl.appmonitor.Transaction) r4
        L_0x0024:
            java.lang.String r0 = r11.readString()
            r9.mo11608b(r4, r0)
            r12.writeNoException()
            return r7
        L_0x002f:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0041
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.Transaction> r0 = com.alibaba.mtl.appmonitor.Transaction.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            r4 = r0
            com.alibaba.mtl.appmonitor.Transaction r4 = (com.alibaba.mtl.appmonitor.Transaction) r4
        L_0x0041:
            java.lang.String r0 = r11.readString()
            r9.mo11586a(r4, r0)
            r12.writeNoException()
            return r7
        L_0x004c:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0067
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.DimensionValueSet> r0 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.DimensionValueSet r0 = (com.alibaba.mtl.appmonitor.model.DimensionValueSet) r0
            r5 = r0
            goto L_0x0068
        L_0x0067:
            r5 = r4
        L_0x0068:
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0077
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.MeasureValueSet> r0 = com.alibaba.mtl.appmonitor.model.MeasureValueSet.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.MeasureValueSet r0 = (com.alibaba.mtl.appmonitor.model.MeasureValueSet) r0
            r4 = r0
        L_0x0077:
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r6 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r5
            r5 = r6
            r0.mo11591a(r1, r2, r3, r4, r5)
            r12.writeNoException()
            return r7
        L_0x008f:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x00a9
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.DimensionValueSet> r0 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.DimensionValueSet r0 = (com.alibaba.mtl.appmonitor.model.DimensionValueSet) r0
            r4 = r0
        L_0x00a9:
            double r5 = r11.readDouble()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r8 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r6 = r8
            r0.mo11590a(r1, r2, r3, r4, r6)
            r12.writeNoException()
            return r7
        L_0x00c6:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            double r4 = r11.readDouble()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r6 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r5 = r6
            r0.mo11609b(r1, r2, r3, r5)
            r12.writeNoException()
            return r7
        L_0x00ed:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            boolean r0 = r9.mo11617d(r0, r1)
            r12.writeNoException()
            r12.writeInt(r0)
            return r7
        L_0x0103:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11623j(r0)
            r12.writeNoException()
            return r7
        L_0x0111:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11622i(r0)
            r12.writeNoException()
            return r7
        L_0x011f:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            java.lang.String r1 = r11.readString()
            r9.mo11610b(r0, r2, r1)
            r12.writeNoException()
            return r7
        L_0x0135:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            java.lang.String r1 = r11.readString()
            r9.mo11596a(r0, r2, r1)
            r12.writeNoException()
            return r7
        L_0x014b:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            java.lang.String r4 = r11.readString()
            java.lang.String r5 = r11.readString()
            java.lang.String r6 = r11.readString()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r8 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            r0.mo11598a(r1, r2, r3, r4, r5, r6)
            r12.writeNoException()
            return r7
        L_0x017c:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            java.lang.String r4 = r11.readString()
            java.lang.String r5 = r11.readString()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r6 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r0.mo11599a(r1, r2, r3, r4, r5)
            r12.writeNoException()
            return r7
        L_0x01a8:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            java.lang.Class r4 = r9.getClass()
            java.lang.ClassLoader r4 = r4.getClassLoader()
            java.util.HashMap r1 = r11.readHashMap(r4)
            r9.mo11600a(r0, r2, r3, r1)
            r12.writeNoException()
            return r7
        L_0x01ca:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            java.lang.Class r3 = r9.getClass()
            java.lang.ClassLoader r3 = r3.getClassLoader()
            java.util.HashMap r1 = r11.readHashMap(r3)
            r9.mo11601a(r0, r2, r1)
            r12.writeNoException()
            return r7
        L_0x01e8:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            boolean r0 = r9.mo11614c(r0, r1)
            r12.writeNoException()
            r12.writeInt(r0)
            return r7
        L_0x01fe:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11621h(r0)
            r12.writeNoException()
            return r7
        L_0x020c:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11620g(r0)
            r12.writeNoException()
            return r7
        L_0x021a:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            double r3 = r11.readDouble()
            r9.mo11588a(r0, r2, r3)
            r12.writeNoException()
            return r7
        L_0x0230:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            boolean r0 = r9.mo11611b(r0, r1)
            r12.writeNoException()
            r12.writeInt(r0)
            return r7
        L_0x0246:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11619f(r0)
            r12.writeNoException()
            return r7
        L_0x0254:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11618e(r0)
            r12.writeNoException()
            return r7
        L_0x0262:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            java.lang.String r4 = r11.readString()
            double r5 = r11.readDouble()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r8 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r6 = r8
            r0.mo11597a(r1, r2, r3, r4, r6)
            r12.writeNoException()
            return r7
        L_0x028e:
            r11.enforceInterface(r3)
            java.lang.String r2 = r11.readString()
            java.lang.String r3 = r11.readString()
            double r4 = r11.readDouble()
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r6 = r11.readHashMap(r0)
            r0 = r9
            r1 = r2
            r2 = r3
            r3 = r4
            r5 = r6
            r0.mo11589a(r1, r2, r3, r5)
            r12.writeNoException()
            return r7
        L_0x02b5:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r1 = r11.readString()
            boolean r0 = r9.mo11605a(r0, r1)
            r12.writeNoException()
            r12.writeInt(r0)
            return r7
        L_0x02cb:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11616d(r0)
            r12.writeNoException()
            return r7
        L_0x02d9:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11613c(r0)
            r12.writeNoException()
            return r7
        L_0x02e7:
            r11.enforceInterface(r3)
            r9.mo11615d()
            r12.writeNoException()
            return r7
        L_0x02f1:
            r11.enforceInterface(r3)
            r9.mo11612c()
            r12.writeNoException()
            return r7
        L_0x02fb:
            r11.enforceInterface(r3)
            java.lang.Class r0 = r9.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.util.HashMap r0 = r11.readHashMap(r0)
            r9.mo11602a(r0)
            r12.writeNoException()
            return r7
        L_0x0311:
            r11.enforceInterface(r3)
            java.lang.String r3 = r11.readString()
            java.lang.String r5 = r11.readString()
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x032c
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.MeasureSet> r0 = com.alibaba.mtl.appmonitor.model.MeasureSet.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.MeasureSet r0 = (com.alibaba.mtl.appmonitor.model.MeasureSet) r0
            r6 = r0
            goto L_0x032d
        L_0x032c:
            r6 = r4
        L_0x032d:
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x033c
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.DimensionSet> r0 = com.alibaba.mtl.appmonitor.model.DimensionSet.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.DimensionSet r0 = (com.alibaba.mtl.appmonitor.model.DimensionSet) r0
            r4 = r0
        L_0x033c:
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0344
            r8 = 1
            goto L_0x0345
        L_0x0344:
            r8 = 0
        L_0x0345:
            r0 = r9
            r1 = r3
            r2 = r5
            r3 = r6
            r5 = r8
            r0.mo11594a(r1, r2, r3, r4, r5)
            r12.writeNoException()
            return r7
        L_0x0351:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            int r3 = r11.readInt()
            if (r3 == 0) goto L_0x036b
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.MeasureSet> r3 = com.alibaba.mtl.appmonitor.model.MeasureSet.CREATOR
            java.lang.Object r3 = r3.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.MeasureSet r3 = (com.alibaba.mtl.appmonitor.model.MeasureSet) r3
            goto L_0x036c
        L_0x036b:
            r3 = r4
        L_0x036c:
            int r5 = r11.readInt()
            if (r5 == 0) goto L_0x037b
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.DimensionSet> r4 = com.alibaba.mtl.appmonitor.model.DimensionSet.CREATOR
            java.lang.Object r1 = r4.createFromParcel(r11)
            r4 = r1
            com.alibaba.mtl.appmonitor.model.DimensionSet r4 = (com.alibaba.mtl.appmonitor.model.DimensionSet) r4
        L_0x037b:
            r9.mo11593a(r0, r2, r3, r4)
            r12.writeNoException()
            return r7
        L_0x0382:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r3 = r11.readString()
            int r5 = r11.readInt()
            if (r5 == 0) goto L_0x039b
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.MeasureSet> r4 = com.alibaba.mtl.appmonitor.model.MeasureSet.CREATOR
            java.lang.Object r4 = r4.createFromParcel(r11)
            com.alibaba.mtl.appmonitor.model.MeasureSet r4 = (com.alibaba.mtl.appmonitor.model.MeasureSet) r4
        L_0x039b:
            int r1 = r11.readInt()
            if (r1 == 0) goto L_0x03a2
            r2 = 1
        L_0x03a2:
            r9.mo11595a(r0, r3, r4, r2)
            r12.writeNoException()
            return r7
        L_0x03a9:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            java.lang.String r2 = r11.readString()
            int r3 = r11.readInt()
            if (r3 == 0) goto L_0x03c3
            android.os.Parcelable$Creator<com.alibaba.mtl.appmonitor.model.MeasureSet> r3 = com.alibaba.mtl.appmonitor.model.MeasureSet.CREATOR
            java.lang.Object r1 = r3.createFromParcel(r11)
            r4 = r1
            com.alibaba.mtl.appmonitor.model.MeasureSet r4 = (com.alibaba.mtl.appmonitor.model.MeasureSet) r4
        L_0x03c3:
            r9.mo11592a(r0, r2, r4)
            r12.writeNoException()
            return r7
        L_0x03ca:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            int r1 = r11.readInt()
            r9.mo11585a(r0, r1)
            r12.writeNoException()
            return r7
        L_0x03dc:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11607b(r0)
            r12.writeNoException()
            return r7
        L_0x03ea:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            r9.mo11584a(r0)
            r12.writeNoException()
            return r7
        L_0x03f8:
            r11.enforceInterface(r3)
            r9.mo11606b()
            r12.writeNoException()
            return r7
        L_0x0402:
            r11.enforceInterface(r3)
            java.lang.String r0 = r11.readString()
            r9.mo11587a(r0)
            r12.writeNoException()
            return r7
        L_0x0410:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x041a
            r2 = 1
        L_0x041a:
            java.lang.String r0 = r11.readString()
            java.lang.String r3 = r11.readString()
            java.lang.String r1 = r11.readString()
            r9.mo11604a(r2, r0, r3, r1)
            r12.writeNoException()
            return r7
        L_0x042d:
            r11.enforceInterface(r3)
            int r0 = r11.readInt()
            if (r0 == 0) goto L_0x0437
            r2 = 1
        L_0x0437:
            r9.mo11603a(r2)
            r12.writeNoException()
            return r7
        L_0x043e:
            r11.enforceInterface(r3)
            r9.mo11583a()
            r12.writeNoException()
            return r7
        L_0x0448:
            r12.writeString(r3)
            return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.IMonitor.C1297a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo11583a() throws RemoteException;

    /* renamed from: a */
    void mo11584a(int i) throws RemoteException;

    /* renamed from: a */
    void mo11585a(int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo11586a(Transaction transaction, String str) throws RemoteException;

    /* renamed from: a */
    void mo11587a(String str) throws RemoteException;

    /* renamed from: a */
    void mo11588a(String str, String str2, double d) throws RemoteException;

    /* renamed from: a */
    void mo11589a(String str, String str2, double d, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11590a(String str, String str2, DimensionValueSet dimensionValueSet, double d, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11591a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11592a(String str, String str2, MeasureSet measureSet) throws RemoteException;

    /* renamed from: a */
    void mo11593a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    /* renamed from: a */
    void mo11594a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo11595a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo11596a(String str, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo11597a(String str, String str2, String str3, double d, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11598a(String str, String str2, String str3, String str4, String str5, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11599a(String str, String str2, String str3, String str4, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11600a(String str, String str2, String str3, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11601a(String str, String str2, Map map) throws RemoteException;

    /* renamed from: a */
    void mo11602a(Map map) throws RemoteException;

    /* renamed from: a */
    void mo11603a(boolean z) throws RemoteException;

    /* renamed from: a */
    void mo11604a(boolean z, String str, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    boolean mo11605a(String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo11606b() throws RemoteException;

    /* renamed from: b */
    void mo11607b(int i) throws RemoteException;

    /* renamed from: b */
    void mo11608b(Transaction transaction, String str) throws RemoteException;

    /* renamed from: b */
    void mo11609b(String str, String str2, double d, Map map) throws RemoteException;

    /* renamed from: b */
    void mo11610b(String str, String str2, String str3) throws RemoteException;

    /* renamed from: b */
    boolean mo11611b(String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo11612c() throws RemoteException;

    /* renamed from: c */
    void mo11613c(int i) throws RemoteException;

    /* renamed from: c */
    boolean mo11614c(String str, String str2) throws RemoteException;

    /* renamed from: d */
    void mo11615d() throws RemoteException;

    /* renamed from: d */
    void mo11616d(int i) throws RemoteException;

    /* renamed from: d */
    boolean mo11617d(String str, String str2) throws RemoteException;

    /* renamed from: e */
    void mo11618e(int i) throws RemoteException;

    /* renamed from: f */
    void mo11619f(int i) throws RemoteException;

    /* renamed from: g */
    void mo11620g(int i) throws RemoteException;

    /* renamed from: h */
    void mo11621h(int i) throws RemoteException;

    /* renamed from: i */
    void mo11622i(int i) throws RemoteException;

    /* renamed from: j */
    void mo11623j(int i) throws RemoteException;
}
