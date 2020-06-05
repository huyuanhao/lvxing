package p655io.reactivex.exceptions;

import p655io.reactivex.internal.util.C8162d;

/* renamed from: io.reactivex.exceptions.a */
public final class Exceptions {
    /* renamed from: a */
    public static RuntimeException m34943a(Throwable th) {
        throw C8162d.m35182a(th);
    }

    /* renamed from: b */
    public static void m34944b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
