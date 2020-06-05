package com.p368pw.inner.base.p387d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.pw.inner.base.d.a */
public class C5144a {

    /* renamed from: com.pw.inner.base.d.a$a */
    public static final class C5146a {
        /* renamed from: a */
        private final String f16805a;
        /* renamed from: b */
        private final boolean f16806b;

        C5146a(String str, boolean z) {
            this.f16805a = str;
            this.f16806b = z;
        }

        /* renamed from: a */
        public String mo26750a() {
            return this.f16805a;
        }
    }

    /* renamed from: com.pw.inner.base.d.a$b */
    private static final class C5147b implements ServiceConnection {
        /* renamed from: a */
        boolean f16807a;
        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f16808b;

        private C5147b() {
            this.f16807a = false;
            this.f16808b = new LinkedBlockingQueue<>(1);
        }

        /* renamed from: a */
        public IBinder mo26751a() {
            if (!this.f16807a) {
                this.f16807a = true;
                return (IBinder) this.f16808b.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f16808b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: com.pw.inner.base.d.a$c */
    private static final class C5148c implements IInterface {
        /* renamed from: a */
        private IBinder f16809a;

        public C5148c(IBinder iBinder) {
            this.f16809a = iBinder;
        }

        /* renamed from: a */
        public String mo26754a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f16809a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* renamed from: a */
        public boolean mo26755a(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(z ? 1 : 0);
                this.f16809a.transact(2, obtain, obtain2, 0);
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

        public IBinder asBinder() {
            return this.f16809a;
        }
    }

    /* renamed from: a */
    public static C5146a m21266a(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                C5147b bVar = new C5147b();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        C5148c cVar = new C5148c(bVar.mo26751a());
                        C5146a aVar = new C5146a(cVar.mo26754a(), cVar.mo26755a(true));
                        context.unbindService(bVar);
                        return aVar;
                    } catch (Exception e) {
                        throw e;
                    } catch (Throwable th) {
                        context.unbindService(bVar);
                        throw th;
                    }
                } else {
                    throw new IOException("Google Play connection failed");
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
