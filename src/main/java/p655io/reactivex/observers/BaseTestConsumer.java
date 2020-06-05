package p655io.reactivex.observers;

import p655io.reactivex.observers.BaseTestConsumer;
import p655io.reactivex.p662b.Disposable;

/* renamed from: io.reactivex.observers.BaseTestConsumer */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {

    /* renamed from: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy */
    public enum TestWaitStrategy implements Runnable {
        SPIN {
            public void run() {
            }
        },
        YIELD {
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS {
            public void run() {
                sleep(1);
            }
        },
        SLEEP_10MS {
            public void run() {
                sleep(10);
            }
        },
        SLEEP_100MS {
            public void run() {
                sleep(100);
            }
        },
        SLEEP_1000MS {
            public void run() {
                sleep(1000);
            }
        };

        public abstract void run();

        static void sleep(int i) {
            try {
                Thread.sleep((long) i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
