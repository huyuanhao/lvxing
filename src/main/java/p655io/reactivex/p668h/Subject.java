package p655io.reactivex.p668h;

import p655io.reactivex.Observable;
import p655io.reactivex.Observer;

/* renamed from: io.reactivex.h.d */
public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    /* renamed from: j */
    public final Subject<T> mo38878j() {
        if (this instanceof SerializedSubject) {
            return this;
        }
        return new SerializedSubject(this);
    }
}
