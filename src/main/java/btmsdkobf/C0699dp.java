package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.dp */
public class C0699dp {
    /* renamed from: a */
    public static <T extends JceStruct> T m380a(byte[] bArr, T t, boolean z) {
        if (!(bArr == null || t == null)) {
            if (z) {
                try {
                    t = t.newInit();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getJceStruct exception: ");
                    sb.append(e);
                    C0848ff.m906e("JceStructUtil", sb.toString());
                }
            }
            t.recyle();
            t.readFrom(m384k(bArr));
            return t;
        }
        return null;
    }

    /* renamed from: b */
    public static byte[] m381b(JceStruct jceStruct) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("UTF-8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    /* renamed from: bi */
    public static C0637bz m382bi() {
        return new C0637bz();
    }

    /* renamed from: j */
    public static C0648ch m383j(byte[] bArr) {
        JceStruct a = m380a(bArr, new C0648ch(), false);
        if (a == null) {
            return null;
        }
        return (C0648ch) a;
    }

    /* renamed from: k */
    private static JceInputStream m384k(byte[] bArr) {
        JceInputStream jceInputStream = new JceInputStream(bArr);
        jceInputStream.setServerEncoding("UTF-8");
        return jceInputStream;
    }
}
