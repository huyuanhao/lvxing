package kotlin.p674b;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C8271i;
import kotlin.jvm.p679a.C8246a;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a0\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, mo39189d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, mo39190k = 2, mo39191mv = {1, 1, 15})
/* renamed from: kotlin.b.a */
public final class Thread {

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo39189d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Thread.kt */
    /* renamed from: kotlin.b.a$a */
    public static final class C8181a extends Thread {
        /* renamed from: a */
        final /* synthetic */ C8246a f27727a;

        C8181a(C8246a aVar) {
            this.f27727a = aVar;
        }

        public void run() {
            this.f27727a.invoke();
        }
    }

    /* renamed from: a */
    public static /* synthetic */ Thread m35249a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, C8246a aVar, int i2, Object obj) {
        boolean z3 = (i2 & 1) != 0 ? true : z;
        boolean z4 = (i2 & 2) != 0 ? false : z2;
        if ((i2 & 4) != 0) {
            classLoader = null;
        }
        ClassLoader classLoader2 = classLoader;
        if ((i2 & 8) != 0) {
            str = null;
        }
        return m35248a(z3, z4, classLoader2, str, (i2 & 16) != 0 ? -1 : i, aVar);
    }

    /* renamed from: a */
    public static final Thread m35248a(boolean z, boolean z2, ClassLoader classLoader, String str, int i, C8246a<Unit> aVar) {
        C8271i.m35386b(aVar, "block");
        C8181a aVar2 = new C8181a(aVar);
        if (z2) {
            aVar2.setDaemon(true);
        }
        if (i > 0) {
            aVar2.setPriority(i);
        }
        if (str != null) {
            aVar2.setName(str);
        }
        if (classLoader != null) {
            aVar2.setContextClassLoader(classLoader);
        }
        if (z) {
            aVar2.start();
        }
        return aVar2;
    }
}
