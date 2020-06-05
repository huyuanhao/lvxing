package epco;

import java.io.Writer;

/* renamed from: epco.z0 */
abstract class C8013z0 extends C8011y0 {
    C8013z0() {
    }

    /* renamed from: a */
    public final int mo38273a(CharSequence charSequence, int i, Writer writer) {
        return mo38291a(Character.codePointAt(charSequence, i), writer);
    }

    /* renamed from: a */
    public abstract boolean mo38291a(int i, Writer writer);
}
