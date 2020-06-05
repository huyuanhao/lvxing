package retrofit2;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter.C8624a;

/* compiled from: Platform */
/* renamed from: retrofit2.j */
class C8652j {
    /* renamed from: a */
    private static final C8652j f29391a = m37568c();

    /* compiled from: Platform */
    /* renamed from: retrofit2.j$a */
    static class C8653a extends C8652j {

        /* compiled from: Platform */
        /* renamed from: retrofit2.j$a$a */
        static class C8654a implements Executor {
            /* renamed from: a */
            private final Handler f29392a = new Handler(Looper.getMainLooper());

            C8654a() {
            }

            public void execute(Runnable runnable) {
                this.f29392a.post(runnable);
            }
        }

        C8653a() {
        }

        /* renamed from: b */
        public Executor mo41340b() {
            return new C8654a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C8624a mo41338a(@Nullable Executor executor) {
            if (executor != null) {
                return new ExecutorCallAdapterFactory(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform */
    /* renamed from: retrofit2.j$b */
    static class C8655b extends C8652j {
        C8655b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo41339a(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: varargs */
        /* renamed from: a */
        public Object mo41337a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return ((Lookup) declaredConstructor.newInstance(new Object[]{cls, Integer.valueOf(-1)})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo41339a(Method method) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    /* renamed from: b */
    public Executor mo41340b() {
        return null;
    }

    C8652j() {
    }

    /* renamed from: a */
    static C8652j m37567a() {
        return f29391a;
    }

    /* renamed from: c */
    private static C8652j m37568c() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new C8653a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new C8655b();
        } catch (ClassNotFoundException unused2) {
            return new C8652j();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C8624a mo41338a(@Nullable Executor executor) {
        if (executor != null) {
            return new ExecutorCallAdapterFactory(executor);
        }
        return DefaultCallAdapterFactory.f29338a;
    }

    /* access modifiers changed from: varargs */
    @Nullable
    /* renamed from: a */
    public Object mo41337a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
