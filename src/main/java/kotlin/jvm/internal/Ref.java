package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {

    /* renamed from: kotlin.jvm.internal.Ref$BooleanRef */
    public static final class BooleanRef implements Serializable {
        public boolean element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$ByteRef */
    public static final class ByteRef implements Serializable {
        public byte element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$CharRef */
    public static final class CharRef implements Serializable {
        public char element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$DoubleRef */
    public static final class DoubleRef implements Serializable {
        public double element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$FloatRef */
    public static final class FloatRef implements Serializable {
        public float element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$IntRef */
    public static final class IntRef implements Serializable {
        public int element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$LongRef */
    public static final class LongRef implements Serializable {
        public long element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$ObjectRef */
    public static final class ObjectRef<T> implements Serializable {
        public T element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* renamed from: kotlin.jvm.internal.Ref$ShortRef */
    public static final class ShortRef implements Serializable {
        public short element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }
}
