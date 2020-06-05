package mtopsdk.xstate.p693b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: mtopsdk.xstate.b.a */
public interface IXState extends IInterface {

    /* compiled from: IXState */
    /* renamed from: mtopsdk.xstate.b.a$a */
    public static abstract class C8346a extends Binder implements IXState {
        public IBinder asBinder() {
            return this;
        }

        public C8346a() {
            attachInterface(this, "mtopsdk.xstate.aidl.IXState");
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = "mtopsdk.xstate.aidl.IXState";
            if (i == 1) {
                parcel.enforceInterface(str);
                String b = mo39879b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(str);
                String a = mo39876a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(str);
                mo39878a(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(str);
                mo39877a();
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface(str);
                mo39880b();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(str);
                return true;
            }
        }
    }

    /* renamed from: a */
    String mo39876a(String str) throws RemoteException;

    /* renamed from: a */
    void mo39877a() throws RemoteException;

    /* renamed from: a */
    void mo39878a(String str, String str2) throws RemoteException;

    /* renamed from: b */
    String mo39879b(String str) throws RemoteException;

    /* renamed from: b */
    void mo39880b() throws RemoteException;
}
