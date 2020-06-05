package epco;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* renamed from: epco.y0 */
abstract class C8011y0 {
    C8011y0() {
    }

    /* renamed from: a */
    public static String m34727a(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    public abstract int mo38273a(CharSequence charSequence, int i, Writer writer);

    /* renamed from: a */
    public final C8011y0 mo38524a(C8011y0... y0VarArr) {
        C8011y0[] y0VarArr2 = new C8011y0[(y0VarArr.length + 1)];
        y0VarArr2[0] = this;
        System.arraycopy(y0VarArr, 0, y0VarArr2, 1, y0VarArr.length);
        return new C8009x0(y0VarArr2);
    }

    /* renamed from: a */
    public final String mo38525a(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            mo38526a(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void mo38526a(CharSequence charSequence, Writer writer) {
        if (writer == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (charSequence != null) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int a = mo38273a(charSequence, i, writer);
                if (a == 0) {
                    char[] chars = Character.toChars(Character.codePointAt(charSequence, i));
                    writer.write(chars);
                    i += chars.length;
                } else {
                    int i2 = i;
                    for (int i3 = 0; i3 < a; i3++) {
                        i2 += Character.charCount(Character.codePointAt(charSequence, i2));
                    }
                    i = i2;
                }
            }
        }
    }
}
