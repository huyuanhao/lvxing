package p655io.reactivex.internal.util;

import org.p705b.Subscription;
import p655io.reactivex.internal.p670b.SimpleQueue;
import p655io.reactivex.internal.queue.SpscArrayQueue;
import p655io.reactivex.internal.queue.SpscLinkedArrayQueue;

/* renamed from: io.reactivex.internal.util.h */
public final class QueueDrainHelper {
    /* renamed from: a */
    public static <T> SimpleQueue<T> m35195a(int i) {
        if (i < 0) {
            return new SpscLinkedArrayQueue(-i);
        }
        return new SpscArrayQueue(i);
    }

    /* renamed from: a */
    public static void m35196a(Subscription cVar, int i) {
        cVar.request(i < 0 ? Long.MAX_VALUE : (long) i);
    }
}
