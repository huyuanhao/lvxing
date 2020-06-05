package p655io.reactivex.internal.p670b;

/* renamed from: io.reactivex.internal.b.f */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(T t);

    T poll() throws Exception;
}
