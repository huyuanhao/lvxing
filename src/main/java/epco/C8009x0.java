package epco;

import java.io.Writer;

/* renamed from: epco.x0 */
class C8009x0 extends C8011y0 {
    /* renamed from: a */
    private final C8011y0[] f27239a;

    public C8009x0(C8011y0... y0VarArr) {
        this.f27239a = y0VarArr;
    }

    /* renamed from: a */
    public int mo38273a(CharSequence charSequence, int i, Writer writer) {
        for (C8011y0 a : this.f27239a) {
            int a2 = a.mo38273a(charSequence, i, writer);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }
}
