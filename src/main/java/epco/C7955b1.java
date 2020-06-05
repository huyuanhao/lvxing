package epco;

import java.io.Writer;
import java.util.HashMap;

/* renamed from: epco.b1 */
class C7955b1 extends C8011y0 {
    /* renamed from: a */
    private final HashMap<String, CharSequence> f27033a = new HashMap<>();
    /* renamed from: b */
    private final int f27034b;
    /* renamed from: c */
    private final int f27035c;

    public C7955b1(CharSequence[]... charSequenceArr) {
        int i = 0;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (charSequenceArr != null) {
            int i3 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.f27033a.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                if (length < i3) {
                    i3 = length;
                }
                if (length > i4) {
                    i4 = length;
                }
            }
            i2 = i3;
            i = i4;
        }
        this.f27034b = i2;
        this.f27035c = i;
    }

    /* renamed from: a */
    public int mo38273a(CharSequence charSequence, int i, Writer writer) {
        int i2 = this.f27035c;
        if (i + i2 > charSequence.length()) {
            i2 = charSequence.length() - i;
        }
        for (i2 = 
/*
Method generation error in method: epco.b1.a(java.lang.CharSequence, int, java.io.Writer):int, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0v1 'i2' int) = (r0v0 'i2' int), (r0v5 'i2' int) binds: {(r0v0 'i2' int)=B:1:0x0008, (r0v5 'i2' int)=B:2:0x000a} in method: epco.b1.a(java.lang.CharSequence, int, java.io.Writer):int, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:238)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:192)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:193)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:324)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.generate(CodeGen.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:36)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:290)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:536)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:508)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:232)
	... 14 more

*/
}
