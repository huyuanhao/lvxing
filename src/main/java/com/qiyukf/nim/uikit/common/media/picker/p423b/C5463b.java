package com.qiyukf.nim.uikit.common.media.picker.p423b;

import android.content.Context;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/* renamed from: com.qiyukf.nim.uikit.common.media.picker.b.b */
public final class C5463b {
    /* renamed from: a */
    public static ArrayList<PhotoInfo> m22274a(Context context) {
        ArrayList<PhotoInfo> arrayList = null;
        try {
            File file = new File(context.getFilesDir().getPath().concat("/qiyu/picker_photos"));
            if (file.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                ArrayList<PhotoInfo> arrayList2 = (ArrayList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    file.delete();
                } catch (Exception unused) {
                }
                arrayList = arrayList2;
            }
        } catch (Exception unused2) {
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    /* renamed from: a */
    public static void m22275a(Context context, ArrayList<PhotoInfo> arrayList) {
        try {
            String concat = context.getFilesDir().getPath().concat("/qiyu/picker_photos");
            new File(concat).getParentFile().mkdirs();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(concat));
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
