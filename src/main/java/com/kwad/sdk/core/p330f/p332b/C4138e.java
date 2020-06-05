package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.e */
public interface C4138e extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.e$a */
    public static class C4139a implements C4138e {
        /* renamed from: a */
        private IBinder f13806a;

        public C4139a(IBinder iBinder) {
            this.f13806a = iBinder;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23839a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.f13806a.transact(1, obtain, obtain2, 0);
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
            return this.f13806a;
        }
    }
}
