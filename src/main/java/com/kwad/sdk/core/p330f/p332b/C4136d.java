package com.kwad.sdk.core.p330f.p332b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.core.p319c.C4065b;

/* renamed from: com.kwad.sdk.core.f.b.d */
public interface C4136d extends IInterface {

    /* renamed from: com.kwad.sdk.core.f.b.d$a */
    public static final class C4137a implements C4136d {
        /* renamed from: a */
        private IBinder f13805a;

        public C4137a(IBinder iBinder) {
            this.f13805a = iBinder;
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public String mo23837a(String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                this.f13805a.transact(1, obtain, obtain2, 0);
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
            return this.f13805a;
        }
    }

    /* renamed from: a */
    String mo23837a(String str, String str2, String str3);
}
