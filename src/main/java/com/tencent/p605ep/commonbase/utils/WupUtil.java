package com.tencent.p605ep.commonbase.utils;

import android.content.Context;
import com.p522qq.jce.wup.UniAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.ep.commonbase.utils.WupUtil */
public class WupUtil {
    private static UniAttribute loadAttributeFromFileWithHeader(Context context, String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        UniAttribute uniAttribute = new UniAttribute();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        sb.append(File.separator);
        sb.append(str);
        String sb2 = sb.toString();
        if (sb2 == null || sb2.length() == 0) {
            return uniAttribute;
        }
        File file = new File(sb2);
        if (!file.exists()) {
            return uniAttribute;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileHeader readHeader = FileHeaderUtil.readHeader(fileInputStream);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                if (!ConvertUtil.bytesToHexString(MD5Util.encrypt(bArr)).equals(ConvertUtil.bytesToHexString(readHeader.mDigestMd5Str))) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return uniAttribute;
                }
                byte[] decryptV2 = XxteaCryptor.decryptV2(bArr, null);
                if (str2 != null && str2.length() > 0) {
                    uniAttribute.setEncodeName(str2);
                }
                uniAttribute.decode(decryptV2);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return uniAttribute;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            th.printStackTrace();
        }
    }

    public static <T> T loadWupObjectFromFileWithHeader(Context context, String str, String str2, T t) {
        return loadWupObjectFromFileWithHeader(context, str, str2, t, null);
    }

    public static <T> T loadWupObjectFromFileWithHeader(Context context, String str, String str2, T t, String str3) {
        T t2;
        if (str == null || str2 == null) {
            return t;
        }
        try {
            t2 = loadAttributeFromFileWithHeader(context, str, str3).getByClass(str2, t);
        } catch (Throwable th) {
            th.printStackTrace();
            t2 = t;
        }
        if (t2 == null) {
            t2 = t;
        }
        return t2;
    }

    public static <T> List<T> loadWupObjectListFromFileWithHeader(Context context, String str, String str2, T t) {
        return loadWupObjectListFromFileWithHeader(context, str, str2, t, null);
    }

    public static <T> List<T> loadWupObjectListFromFileWithHeader(Context context, String str, String str2, T t, String str3) {
        List<T> list;
        List<T> arrayList = new ArrayList<>();
        if (str == null || str2 == null) {
            return arrayList;
        }
        UniAttribute loadAttributeFromFileWithHeader = loadAttributeFromFileWithHeader(context, str, str3);
        try {
            arrayList.add(t);
            list = (List) loadAttributeFromFileWithHeader.getByClass(str2, arrayList);
        } catch (Throwable unused) {
            list = arrayList;
        }
        if (list == null) {
            list = new ArrayList<>(0);
        }
        return list;
    }
}
