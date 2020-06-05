package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.f */
public interface C4140f extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.f$a */
    public static final class C4141a implements C4140f {
        /* renamed from: a */
        private IBinder f13807a;

        public C4141a(IBinder iBinder) {
            this.f13807a = iBinder;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23841a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                this.f13807a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain.recycle();
                obtain2.recycle();
                return readString;
            } catch (Exception e) {
                C4065b.m16865a(e);
                obtain.recycle();
                obtain2.recycle();
                return null;
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
        }

        public IBinder asBinder() {
            return this.f13807a;
        }
    }

    /* renamed from: a */
    String mo23841a();
}
