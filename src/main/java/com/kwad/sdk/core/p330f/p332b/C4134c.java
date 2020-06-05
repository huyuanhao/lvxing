package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.c */
public interface C4134c extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.c$a */
    public static final class C4135a implements C4134c {
        /* renamed from: a */
        private IBinder f13804a;

        public C4135a(IBinder iBinder) {
            this.f13804a = iBinder;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23835a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.f13804a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception e) {
                C4065b.m16865a(e);
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this.f13804a;
        }
    }

    /* renamed from: a */
    String mo23835a();
}
