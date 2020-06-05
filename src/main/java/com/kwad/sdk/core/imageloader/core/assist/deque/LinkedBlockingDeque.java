package com.kwad.sdk.core.imageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient Node<E> first;
    transient Node<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* renamed from: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$AbstractItr */
    private abstract class AbstractItr implements Iterator<E> {
        private Node<E> lastRet;
        Node<E> next;
        E nextItem;

        AbstractItr() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = firstNode();
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private Node<E> succ(Node<E> node) {
            while (true) {
                Node<E> nextNode = nextNode(node);
                if (nextNode == null) {
                    return null;
                }
                if (nextNode.item != null) {
                    return nextNode;
                }
                if (nextNode == node) {
                    return firstNode();
                }
                node = nextNode;
            }
        }

        /* access modifiers changed from: 0000 */
        public void advance() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.next = succ(this.next);
                this.nextItem = this.next == null ? null : this.next.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract Node<E> firstNode();

        public boolean hasNext() {
            return this.next != null;
        }

        public E next() {
            Node<E> node = this.next;
            if (node != null) {
                this.lastRet = node;
                E e = this.nextItem;
                advance();
                return e;
            }
            throw new NoSuchElementException();
        }

        public abstract Node<E> nextNode(Node<E> node);

        public void remove() {
            Node<E> node = this.lastRet;
            if (node != null) {
                this.lastRet = null;
                ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (node.item != null) {
                        LinkedBlockingDeque.this.unlink(node);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$DescendingItr */
    private class DescendingItr extends AbstractItr {
        private DescendingItr() {
            super();
        }

        /* access modifiers changed from: 0000 */
        public Node<E> firstNode() {
            return LinkedBlockingDeque.this.last;
        }

        /* access modifiers changed from: 0000 */
        public Node<E> nextNode(Node<E> node) {
            return node.prev;
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$Itr */
    private class Itr extends AbstractItr {
        private Itr() {
            super();
        }

        /* access modifiers changed from: 0000 */
        public Node<E> firstNode() {
            return LinkedBlockingDeque.this.first;
        }

        /* access modifiers changed from: 0000 */
        public Node<E> nextNode(Node<E> node) {
            return node.next;
        }
    }

    /* renamed from: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$Node */
    static final class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E e) {
            this.item = e;
        }
    }

    public LinkedBlockingDeque() {
        this((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i > 0) {
            this.capacity = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this((int) ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!linkLast(new Node(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.first;
        node.next = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        Node<E> node2 = this.last;
        node.prev = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private E unlinkFirst() {
        Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.next;
        E e = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        Node<E> node2 = node.prev;
        E e = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new DescendingItr();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection != this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.first.item);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new Itr();
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) {
        return offerLast(e, j, timeUnit);
    }

    public boolean offerFirst(E e) {
        if (e != null) {
            Node node = new Node(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkFirst(node);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean offerFirst(E e, long j, TimeUnit timeUnit) {
        boolean z;
        if (e != null) {
            Node node = new Node(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkFirst(node)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public boolean offerLast(E e) {
        if (e != null) {
            Node node = new Node(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkLast(node);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean offerLast(E e, long j, TimeUnit timeUnit) {
        boolean z;
        if (e != null) {
            Node node = new Node(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (true) {
                try {
                    if (linkLast(node)) {
                        z = true;
                        break;
                    } else if (nanos <= 0) {
                        z = false;
                        break;
                    } else {
                        nanos = this.notFull.awaitNanos(nanos);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            return z;
        }
        throw new NullPointerException();
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll() {
        return pollFirst();
    }

    public E poll(long j, TimeUnit timeUnit) {
        return pollFirst(j, timeUnit);
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollFirst(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    reentrantLock.unlock();
                    return unlinkFirst;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    reentrantLock.unlock();
                    return unlinkLast;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e) {
        addFirst(e);
    }

    public void put(E e) {
        putLast(e);
    }

    public void putFirst(E e) {
        if (e != null) {
            Node node = new Node(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkFirst(node)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public void putLast(E e) {
        if (e != null) {
            Node node = new Node(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkLast(node)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return removeFirst();
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() {
        return takeFirst();
    }

    public E takeFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            Node<E> node = this.first;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T[], code=java.lang.Object[], for r6v0, types: [T[], java.lang.Object[], java.lang.Object] */
    public <T> T[] toArray(java.lang.Object[] r6) {
        /*
        r5 = this;
        java.util.concurrent.locks.ReentrantLock r0 = r5.lock
        r0.lock()
        int r1 = r6.length     // Catch:{ all -> 0x0035 }
        int r2 = r5.count     // Catch:{ all -> 0x0035 }
        if (r1 >= r2) goto L_0x001c
        java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x0035 }
        java.lang.Class r6 = r6.getComponentType()     // Catch:{ all -> 0x0035 }
        int r1 = r5.count     // Catch:{ all -> 0x0035 }
        java.lang.Object r6 = java.lang.reflect.Array.newInstance(r6, r1)     // Catch:{ all -> 0x0035 }
        java.lang.Object[] r6 = (java.lang.Object[]) r6     // Catch:{ all -> 0x0035 }
        java.lang.Object[] r6 = (java.lang.Object[]) r6     // Catch:{ all -> 0x0035 }
    L_0x001c:
        r1 = 0
        com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$Node<E> r2 = r5.first     // Catch:{ all -> 0x0035 }
    L_0x001f:
        if (r2 == 0) goto L_0x002b
        int r3 = r1 + 1
        E r4 = r2.item     // Catch:{ all -> 0x0035 }
        r6[r1] = r4     // Catch:{ all -> 0x0035 }
        com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque$Node<E> r2 = r2.next     // Catch:{ all -> 0x0035 }
        r1 = r3
        goto L_0x001f
    L_0x002b:
        int r2 = r6.length     // Catch:{ all -> 0x0035 }
        if (r2 <= r1) goto L_0x0031
        r2 = 0
        r6[r1] = r2     // Catch:{ all -> 0x0035 }
    L_0x0031:
        r0.unlock()
        return r6
    L_0x0035:
        r6 = move-exception
        r0.unlock()
        throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque.toArray(java.lang.Object[]):java.lang.Object[]");
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Node<E> node = this.first;
            if (node == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e = node.item;
                if (e == this) {
                    e = "(this Collection)";
                }
                sb.append(e);
                node = node.next;
                if (node == null) {
                    sb.append(']');
                    String sb2 = sb.toString();
                    reentrantLock.unlock();
                    return sb2;
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void unlink(Node<E> node) {
        Node<E> node2 = node.prev;
        Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
        } else if (node3 == null) {
            unlinkLast();
        } else {
            node2.next = node3;
            node3.prev = node2;
            node.item = null;
            this.count--;
            this.notFull.signal();
        }
    }
}
