package p655io.reactivex.internal.util;

import java.io.Serializable;
import org.p705b.Subscriber;
import org.p705b.Subscription;
import p655io.reactivex.Observer;
import p655io.reactivex.internal.p669a.ObjectHelper;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.internal.util.NotificationLite */
public enum NotificationLite {
    COMPLETE;

    /* renamed from: io.reactivex.internal.util.NotificationLite$a */
    static final class C8158a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        C8158a(Disposable bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Disposable[");
            sb.append(this.upstream);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: io.reactivex.internal.util.NotificationLite$b */
    static final class C8159b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        /* renamed from: e */
        final Throwable f27686e;

        C8159b(Throwable th) {
            this.f27686e = th;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Error[");
            sb.append(this.f27686e);
            sb.append("]");
            return sb.toString();
        }

        public int hashCode() {
            return this.f27686e.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C8159b)) {
                return false;
            }
            return ObjectHelper.m35049a((Object) this.f27686e, (Object) ((C8159b) obj).f27686e);
        }
    }

    /* renamed from: io.reactivex.internal.util.NotificationLite$c */
    static final class C8160c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription upstream;

        C8160c(Subscription cVar) {
            this.upstream = cVar;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Subscription[");
            sb.append(this.upstream);
            sb.append("]");
            return sb.toString();
        }
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable th) {
        return new C8159b(th);
    }

    public static Object subscription(Subscription cVar) {
        return new C8160c(cVar);
    }

    public static Object disposable(Disposable bVar) {
        return new C8158a(bVar);
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isError(Object obj) {
        return obj instanceof C8159b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof C8160c;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof C8158a;
    }

    public static Throwable getError(Object obj) {
        return ((C8159b) obj).f27686e;
    }

    public static Subscription getSubscription(Object obj) {
        return ((C8160c) obj).upstream;
    }

    public static Disposable getDisposable(Object obj) {
        return ((C8158a) obj).upstream;
    }

    public static <T> boolean accept(Object obj, Subscriber<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof C8159b) {
            bVar.onError(((C8159b) obj).f27686e);
            return true;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean accept(Object obj, Observer<? super T> lVar) {
        if (obj == COMPLETE) {
            lVar.onComplete();
            return true;
        } else if (obj instanceof C8159b) {
            lVar.onError(((C8159b) obj).f27686e);
            return true;
        } else {
            lVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Subscriber<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof C8159b) {
            bVar.onError(((C8159b) obj).f27686e);
            return true;
        } else if (obj instanceof C8160c) {
            bVar.onSubscribe(((C8160c) obj).upstream);
            return false;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, Observer<? super T> lVar) {
        if (obj == COMPLETE) {
            lVar.onComplete();
            return true;
        } else if (obj instanceof C8159b) {
            lVar.onError(((C8159b) obj).f27686e);
            return true;
        } else if (obj instanceof C8158a) {
            lVar.onSubscribe(((C8158a) obj).upstream);
            return false;
        } else {
            lVar.onNext(obj);
            return false;
        }
    }
}
