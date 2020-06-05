package com.qiyukf.nimlib.p470f;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import java.io.Serializable;

/* renamed from: com.qiyukf.nimlib.f.a */
public class C5825a {
    /* renamed from: a */
    public static Message m23354a(int i, Object obj) {
        Message obtain = Message.obtain(null, i);
        if (obj != null) {
            Bundle bundle = new Bundle();
            String str = "IPC";
            if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
            obtain.setData(bundle);
        }
        return obtain;
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m23355a(Message message) {
        message.getData().setClassLoader(C5825a.class.getClassLoader());
        return message.getData().getParcelable("IPC");
    }

    /* renamed from: b */
    public static Serializable m23356b(Message message) {
        message.getData().setClassLoader(C5825a.class.getClassLoader());
        return message.getData().getSerializable("IPC");
    }
}
