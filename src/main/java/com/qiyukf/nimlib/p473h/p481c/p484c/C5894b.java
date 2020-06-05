package com.qiyukf.nimlib.p473h.p481c.p484c;

import android.text.TextUtils;
import com.qiyukf.nimlib.p473h.p481c.p483b.C5891a;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.qiyukf.nimlib.h.c.c.b */
public final class C5894b {
    /* renamed from: a */
    private ByteBuffer f18652a = C5893a.m23599a();
    /* renamed from: b */
    private int f18653b = 1048576;

    public C5894b() {
        this.f18652a.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: c */
    private void m23600c(int i) {
        if (this.f18652a.remaining() < i) {
            int capacity = (this.f18652a.capacity() + i) - this.f18652a.remaining();
            if (capacity <= this.f18653b) {
                ByteBuffer allocate = ByteBuffer.allocate(Math.min(Math.max(capacity, this.f18652a.capacity() << 1), this.f18653b));
                allocate.order(this.f18652a.order());
                this.f18652a.flip();
                allocate.put(this.f18652a);
                this.f18652a = allocate;
                return;
            }
            throw new BufferOverflowException();
        }
    }

    /* renamed from: a */
    public final int mo28245a() {
        return this.f18652a.position();
    }

    /* renamed from: a */
    public final C5894b mo28246a(byte b) {
        try {
            m23600c(1);
            this.f18652a.put(b);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28247a(int i) {
        try {
            m23600c(4);
            this.f18652a.putInt(i);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28248a(long j) {
        try {
            m23600c(8);
            this.f18652a.putLong(j);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28249a(C5891a aVar) {
        aVar.mo28223a(this);
        return this;
    }

    /* renamed from: a */
    public final C5894b mo28250a(String str) {
        try {
            return mo28257b(TextUtils.isEmpty(str) ? null : str.getBytes("utf-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28251a(ByteBuffer byteBuffer) {
        try {
            m23600c(byteBuffer.remaining());
            this.f18652a.put(byteBuffer);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28252a(short s) {
        try {
            m23600c(2);
            this.f18652a.putShort(s);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28253a(boolean z) {
        int i = 1;
        try {
            m23600c(1);
            ByteBuffer byteBuffer = this.f18652a;
            if (!z) {
                i = 0;
            }
            byteBuffer.put((byte) i);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: a */
    public final C5894b mo28254a(byte[] bArr) {
        try {
            m23600c(bArr.length);
            this.f18652a.put(bArr);
            return this;
        } catch (BufferOverflowException unused) {
            throw new C5895c();
        }
    }

    /* renamed from: b */
    public final C5894b mo28255b(int i) {
        return mo28254a(C5896d.m23617a(i));
    }

    /* renamed from: b */
    public final C5894b mo28256b(String str) {
        try {
            mo28248a(Long.valueOf(str).longValue());
            return this;
        } catch (Exception unused) {
            throw new C5895c();
        }
    }

    /* renamed from: b */
    public final C5894b mo28257b(byte[] bArr) {
        if (bArr == null) {
            try {
                return mo28255b(0);
            } catch (BufferOverflowException unused) {
                throw new C5895c();
            }
        } else if (bArr.length <= 2147483645) {
            m23600c(C5896d.m23618b(bArr.length) + bArr.length);
            this.f18652a.put(C5896d.m23617a(bArr.length));
            this.f18652a.put(bArr);
            return this;
        } else {
            throw new C5895c();
        }
    }

    /* renamed from: b */
    public final ByteBuffer mo28258b() {
        ByteBuffer duplicate = this.f18652a.duplicate();
        duplicate.flip();
        return duplicate;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18652a.toString());
        sb.append(" Size ");
        sb.append(this.f18652a.position());
        return sb.toString();
    }
}
