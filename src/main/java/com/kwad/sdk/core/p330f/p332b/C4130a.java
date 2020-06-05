package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.a */
public interface C4130a extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.a$a */
    public static final class C4131a implements C4130a {
        /* renamed from: a */
        private IBinder f13802a;

        public C4131a(IBinder iBinder) {
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23830a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f13802a.transact(3, obtain, obtain2, 0);
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
            return this.f13802a;
        }
    }
}
