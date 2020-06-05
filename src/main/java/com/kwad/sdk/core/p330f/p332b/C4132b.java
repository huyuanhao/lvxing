package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.b */
public interface C4132b extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.b$a */
    public static final class C4133a implements C4132b {
        /* renamed from: a */
        private IBinder f13803a;

        public C4133a(IBinder iBinder) {
            this.f13803a = iBinder;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23832a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f13803a.transact(1, obtain, obtain2, 0);
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
            return this.f13803a;
        }

        /* renamed from: b */
        public boolean mo23834b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z = false;
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                this.f13803a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = true;
                }
            } catch (Exception e) {
                C4065b.m16865a(e);
            } catch (Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
            return z;
        }
    }
}
