package com.qiyukf.basesdk.p394b.p406b.p408b;

import com.qiyukf.basesdk.p394b.p406b.p409c.C5347a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.basesdk.b.b.b.a */
public abstract class C5343a extends C5347a {
    /* renamed from: b */
    private ByteBuffer f17274b;

    protected C5343a() {
    }

    /* renamed from: b */
    private void m21941b(ByteBuffer byteBuffer, List<Object> list) {
        while (byteBuffer.remaining() > 0) {
            try {
                int size = list.size();
                int remaining = byteBuffer.remaining();
                mo27286a(byteBuffer, list);
                if (size == list.size()) {
                    if (remaining == byteBuffer.remaining()) {
                        return;
                    }
                } else if (remaining == byteBuffer.remaining()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getSimpleName());
                    sb.append(".decode() did not read anything but decoded a message.");
                    throw new C5344b(sb.toString());
                }
            } catch (C5344b e) {
                throw e;
            } catch (Throwable th) {
                throw new C5344b(th);
            }
        }
    }

    /* renamed from: a */
    public final void mo27283a(Object obj) {
        if (obj instanceof ByteBuffer) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            try {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                byteBuffer.flip();
                if (this.f17274b == null) {
                    this.f17274b = byteBuffer;
                } else {
                    if (this.f17274b.capacity() - this.f17274b.limit() < byteBuffer.remaining()) {
                        int remaining = byteBuffer.remaining();
                        ByteBuffer byteBuffer2 = this.f17274b;
                        this.f17274b = ByteBuffer.allocate(byteBuffer2.remaining() + remaining);
                        this.f17274b.put(byteBuffer2);
                        this.f17274b.flip();
                    }
                    this.f17274b.position(this.f17274b.limit()).limit(this.f17274b.capacity());
                    this.f17274b.put(byteBuffer);
                    this.f17274b.flip();
                }
                m21941b(this.f17274b, arrayList);
                ByteBuffer byteBuffer3 = this.f17274b;
                if (byteBuffer3 != null && byteBuffer3.remaining() <= 0) {
                    this.f17274b = null;
                }
                int size = arrayList.size();
                while (i < size) {
                    super.mo27283a(arrayList.get(i));
                    i++;
                }
            } catch (C5344b e) {
                throw e;
            } catch (Throwable th) {
                ByteBuffer byteBuffer4 = this.f17274b;
                if (byteBuffer4 != null && byteBuffer4.remaining() <= 0) {
                    this.f17274b = null;
                }
                int size2 = arrayList.size();
                while (i < size2) {
                    super.mo27283a(arrayList.get(i));
                    i++;
                }
                throw th;
            }
        } else {
            super.mo27283a(obj);
        }
    }

    /* renamed from: a */
    public abstract void mo27286a(ByteBuffer byteBuffer, List<Object> list);

    /* renamed from: h */
    public void mo27284h() {
        ByteBuffer allocate;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        try {
            if (this.f17274b != null) {
                m21941b(this.f17274b, arrayList);
                allocate = this.f17274b;
            } else {
                allocate = ByteBuffer.allocate(0);
            }
            mo27286a(allocate, arrayList);
            if (this.f17274b != null) {
                this.f17274b = null;
            }
            int size = arrayList.size();
            while (i < size) {
                super.mo27283a(arrayList.get(i));
                i++;
            }
            super.mo27284h();
        } catch (C5344b e) {
            throw e;
        } catch (Exception e2) {
            throw new C5344b((Throwable) e2);
        } catch (Throwable th) {
            if (this.f17274b != null) {
                this.f17274b = null;
            }
            int size2 = arrayList.size();
            while (i < size2) {
                super.mo27283a(arrayList.get(i));
                i++;
            }
            super.mo27284h();
            throw th;
        }
    }

    /* renamed from: i */
    public final void mo27285i() {
        super.mo27285i();
    }
}
