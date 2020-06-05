package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.p131c.BaseRequestOptions;
import com.bumptech.glide.p131c.Request;
import com.bumptech.glide.p131c.RequestCoordinator;
import com.bumptech.glide.p131c.RequestListener;
import com.bumptech.glide.p131c.RequestOptions;
import com.bumptech.glide.p131c.SingleRequest;
import com.bumptech.glide.p131c.ThumbnailRequestCoordinator;
import com.bumptech.glide.p131c.p132a.Target;
import com.bumptech.glide.p131c.p132a.ViewTarget;
import com.bumptech.glide.p134d.ApplicationVersionSignature;
import com.bumptech.glide.util.C1772j;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.bumptech.glide.h */
public class RequestBuilder<TranscodeType> extends BaseRequestOptions<RequestBuilder<TranscodeType>> implements Cloneable {
    /* renamed from: a */
    protected static final RequestOptions f4351a = ((RequestOptions) ((RequestOptions) ((RequestOptions) new RequestOptions().mo12425a(DiskCacheStrategy.f4631c)).mo12422a(Priority.LOW)).mo12437b(true));
    /* renamed from: b */
    private final Context f4352b;
    /* renamed from: c */
    private final RequestManager f4353c;
    /* renamed from: d */
    private final Class<TranscodeType> f4354d;
    /* renamed from: e */
    private final Glide f4355e;
    /* renamed from: f */
    private final GlideContext f4356f;
    /* renamed from: g */
    private TransitionOptions<?, ? super TranscodeType> f4357g;
    /* renamed from: h */
    private Object f4358h;
    /* renamed from: i */
    private List<RequestListener<TranscodeType>> f4359i;
    /* renamed from: j */
    private RequestBuilder<TranscodeType> f4360j;
    /* renamed from: k */
    private RequestBuilder<TranscodeType> f4361k;
    /* renamed from: l */
    private Float f4362l;
    /* renamed from: m */
    private boolean f4363m = true;
    /* renamed from: n */
    private boolean f4364n;
    /* renamed from: o */
    private boolean f4365o;

    /* compiled from: RequestBuilder */
    /* renamed from: com.bumptech.glide.h$1 */
    static /* synthetic */ class C16181 {
        /* renamed from: a */
        static final /* synthetic */ int[] f4366a = new int[ScaleType.values().length];
        /* renamed from: b */
        static final /* synthetic */ int[] f4367b = new int[Priority.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        static {
            /*
            com.bumptech.glide.Priority[] r0 = com.bumptech.glide.Priority.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f4367b = r0
            r0 = 1
            int[] r1 = f4367b     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.bumptech.glide.Priority r2 = com.bumptech.glide.Priority.LOW     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2
            int[] r2 = f4367b     // Catch:{ NoSuchFieldError -> 0x001f }
            com.bumptech.glide.Priority r3 = com.bumptech.glide.Priority.NORMAL     // Catch:{ NoSuchFieldError -> 0x001f }
            int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3
            int[] r3 = f4367b     // Catch:{ NoSuchFieldError -> 0x002a }
            com.bumptech.glide.Priority r4 = com.bumptech.glide.Priority.HIGH     // Catch:{ NoSuchFieldError -> 0x002a }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4
            int[] r4 = f4367b     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.bumptech.glide.Priority r5 = com.bumptech.glide.Priority.IMMEDIATE     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            android.widget.ImageView$ScaleType[] r4 = android.widget.ImageView.ScaleType.values()
            int r4 = r4.length
            int[] r4 = new int[r4]
            f4366a = r4
            int[] r4 = f4366a     // Catch:{ NoSuchFieldError -> 0x0048 }
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x0048 }
            int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
            r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
        L_0x0048:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0052 }
            android.widget.ImageView$ScaleType r4 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0052 }
            int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
            r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
        L_0x0052:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x005c }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x005c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0066 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0066 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
            r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
        L_0x0066:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0071 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0071 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0071 }
        L_0x0071:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x007c }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x007c }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007c }
            r2 = 6
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007c }
        L_0x007c:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0087 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0087 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
            r2 = 7
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0087 }
        L_0x0087:
            int[] r0 = f4366a     // Catch:{ NoSuchFieldError -> 0x0093 }
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX     // Catch:{ NoSuchFieldError -> 0x0093 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
            r2 = 8
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
        L_0x0093:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.C16181.m42340clinit():void");
        }
    }

    protected RequestBuilder(Glide eVar, RequestManager iVar, Class<TranscodeType> cls, Context context) {
        this.f4355e = eVar;
        this.f4353c = iVar;
        this.f4354d = cls;
        this.f4352b = context;
        this.f4357g = iVar.mo12596b(cls);
        this.f4356f = eVar.mo12536e();
        m5259a(iVar.mo12601e());
        mo12435b((BaseRequestOptions<?>) iVar.mo12602f());
    }

    /* renamed from: a */
    private void m5259a(List<RequestListener<Object>> list) {
        for (RequestListener a : list) {
            mo12585a(a);
        }
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo12435b(BaseRequestOptions<?> aVar) {
        Preconditions.m6138a(aVar);
        return (RequestBuilder) super.mo12435b(aVar);
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo12585a(RequestListener<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.f4359i == null) {
                this.f4359i = new ArrayList();
            }
            this.f4359i.add(eVar);
        }
        return this;
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo12587a(Object obj) {
        return mo19993b(obj);
    }

    /* renamed from: b */
    private RequestBuilder<TranscodeType> mo19993b(Object obj) {
        this.f4358h = obj;
        this.f4364n = true;
        return this;
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo12588a(String str) {
        return mo19993b((Object) str);
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> mo12586a(Integer num) {
        return mo19993b((Object) num).mo12435b((BaseRequestOptions<?>) RequestOptions.m5103b(ApplicationVersionSignature.m5164a(this.f4352b)));
    }

    /* renamed from: a */
    public RequestBuilder<TranscodeType> clone() {
        RequestBuilder<TranscodeType> hVar = (RequestBuilder) super.clone();
        hVar.f4357g = hVar.f4357g.clone();
        return hVar;
    }

    /* renamed from: a */
    public <Y extends Target<TranscodeType>> Y mo12580a(Y y) {
        return mo12581a(y, null, Executors.m6122a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <Y extends Target<TranscodeType>> Y mo12581a(Y y, RequestListener<TranscodeType> eVar, Executor executor) {
        return m5256a(y, eVar, this, executor);
    }

    /* renamed from: a */
    private <Y extends Target<TranscodeType>> Y m5256a(Y y, RequestListener<TranscodeType> eVar, BaseRequestOptions<?> aVar, Executor executor) {
        Preconditions.m6138a(y);
        if (this.f4364n) {
            Request b = m5262b(y, eVar, aVar, executor);
            Request request = y.getRequest();
            if (!b.mo12492a(request) || m5260a(aVar, request)) {
                this.f4353c.mo12593a((Target<?>) y);
                y.setRequest(b);
                this.f4353c.mo12594a(y, b);
                return y;
            }
            b.mo12503h();
            if (!((Request) Preconditions.m6138a(request)).mo12495c()) {
                request.mo12490a();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* renamed from: a */
    private boolean m5260a(BaseRequestOptions<?> aVar, Request cVar) {
        return !aVar.mo12461w() && cVar.mo12504h_();
    }

    /* renamed from: a */
    public ViewTarget<ImageView, TranscodeType> mo12582a(ImageView imageView) {
        BaseRequestOptions aVar;
        C1772j.m6154a();
        Preconditions.m6138a(imageView);
        if (!mo12440d() && mo12438c() && imageView.getScaleType() != null) {
            switch (C16181.f4366a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().mo12441e();
                    break;
                case 2:
                    aVar = clone().mo12444g();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().mo12443f();
                    break;
                case 6:
                    aVar = clone().mo12444g();
                    break;
            }
        }
        aVar = this;
        return (ViewTarget) m5256a(this.f4356f.mo12545a(imageView, this.f4354d), null, aVar, Executors.m6122a());
    }

    /* renamed from: b */
    private Priority mo19984b(Priority priority) {
        int i = C16181.f4367b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown priority: ");
        sb.append(mo12464z());
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    private Request m5262b(Target<TranscodeType> hVar, RequestListener<TranscodeType> eVar, BaseRequestOptions<?> aVar, Executor executor) {
        return m5258a(hVar, eVar, (RequestCoordinator) null, this.f4357g, aVar.mo12464z(), aVar.mo12412A(), aVar.mo12414C(), aVar, executor);
    }

    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.c.d] */
    /* JADX WARNING: type inference failed for: r14v0, types: [com.bumptech.glide.c.d] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.bumptech.glide.c.b] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* renamed from: a */
    private com.bumptech.glide.p131c.Request m5258a(com.bumptech.glide.p131c.p132a.Target<TranscodeType> r22, com.bumptech.glide.p131c.RequestListener<TranscodeType> r23, com.bumptech.glide.p131c.RequestCoordinator r24, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> r25, com.bumptech.glide.Priority r26, int r27, int r28, com.bumptech.glide.p131c.BaseRequestOptions<?> r29, java.util.concurrent.Executor r30) {
        /*
        r21 = this;
        r10 = r21
        com.bumptech.glide.h<TranscodeType> r0 = r10.f4361k
        if (r0 == 0) goto L_0x0010
        com.bumptech.glide.c.b r0 = new com.bumptech.glide.c.b
        r1 = r24
        r0.m42298init(r1)
        r3 = r0
        r15 = r3
        goto L_0x0015
    L_0x0010:
        r1 = r24
        r0 = 0
        r15 = r0
        r3 = r1
    L_0x0015:
        r0 = r21
        r1 = r22
        r2 = r23
        r4 = r25
        r5 = r26
        r6 = r27
        r7 = r28
        r8 = r29
        r9 = r30
        com.bumptech.glide.c.c r0 = r0.m5263b(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        if (r15 != 0) goto L_0x002e
        return r0
    L_0x002e:
        com.bumptech.glide.h<TranscodeType> r1 = r10.f4361k
        int r1 = r1.mo12412A()
        com.bumptech.glide.h<TranscodeType> r2 = r10.f4361k
        int r2 = r2.mo12414C()
        boolean r3 = com.bumptech.glide.util.C1772j.m6155a(r27, r28)
        if (r3 == 0) goto L_0x0050
        com.bumptech.glide.h<TranscodeType> r3 = r10.f4361k
        boolean r3 = r3.mo12413B()
        if (r3 != 0) goto L_0x0050
        int r1 = r29.mo12412A()
        int r2 = r29.mo12414C()
    L_0x0050:
        r17 = r1
        r18 = r2
        com.bumptech.glide.h<TranscodeType> r11 = r10.f4361k
        com.bumptech.glide.j<?, ? super TranscodeType> r1 = r11.f4357g
        com.bumptech.glide.Priority r16 = r11.mo12464z()
        com.bumptech.glide.h<TranscodeType> r2 = r10.f4361k
        r12 = r22
        r13 = r23
        r14 = r15
        r3 = r15
        r15 = r1
        r19 = r2
        r20 = r30
        com.bumptech.glide.c.c r1 = r11.m5258a(r12, r13, r14, r15, r16, r17, r18, r19, r20)
        r3.mo12491a(r0, r1)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.RequestBuilder.m5258a(com.bumptech.glide.c.a.h, com.bumptech.glide.c.e, com.bumptech.glide.c.d, com.bumptech.glide.j, com.bumptech.glide.Priority, int, int, com.bumptech.glide.c.a, java.util.concurrent.Executor):com.bumptech.glide.c.c");
    }

    /* renamed from: b */
    private Request m5263b(Target<TranscodeType> hVar, RequestListener<TranscodeType> eVar, RequestCoordinator dVar, TransitionOptions<?, ? super TranscodeType> jVar, Priority priority, int i, int i2, BaseRequestOptions<?> aVar, Executor executor) {
        RequestCoordinator dVar2 = dVar;
        Priority priority2 = priority;
        RequestBuilder<TranscodeType> hVar2 = this.f4360j;
        if (hVar2 != null) {
            if (!this.f4365o) {
                TransitionOptions<?, ? super TranscodeType> jVar2 = hVar2.f4363m ? jVar : hVar2.f4357g;
                Priority z = this.f4360j.mo12463y() ? this.f4360j.mo12464z() : mo19984b(priority2);
                int A = this.f4360j.mo12412A();
                int C = this.f4360j.mo12414C();
                if (C1772j.m6155a(i, i2) && !this.f4360j.mo12413B()) {
                    A = aVar.mo12412A();
                    C = aVar.mo12414C();
                }
                int i3 = A;
                int i4 = C;
                ThumbnailRequestCoordinator iVar = new ThumbnailRequestCoordinator(dVar2);
                Request a = m5257a(hVar, eVar, aVar, (RequestCoordinator) iVar, jVar, priority, i, i2, executor);
                this.f4365o = true;
                RequestBuilder<TranscodeType> hVar3 = this.f4360j;
                ThumbnailRequestCoordinator iVar2 = iVar;
                Request a2 = hVar3.m5258a(hVar, eVar, (RequestCoordinator) iVar, jVar2, z, i3, i4, (BaseRequestOptions<?>) hVar3, executor);
                this.f4365o = false;
                iVar2.mo12522a(a, a2);
                return iVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.f4362l == null) {
            return m5257a(hVar, eVar, aVar, dVar, jVar, priority, i, i2, executor);
        } else {
            ThumbnailRequestCoordinator iVar3 = new ThumbnailRequestCoordinator(dVar2);
            RequestListener<TranscodeType> eVar2 = eVar;
            ThumbnailRequestCoordinator iVar4 = iVar3;
            TransitionOptions<?, ? super TranscodeType> jVar3 = jVar;
            int i5 = i;
            int i6 = i2;
            Executor executor2 = executor;
            iVar3.mo12522a(m5257a(hVar, eVar2, aVar, (RequestCoordinator) iVar4, jVar3, priority, i5, i6, executor2), m5257a(hVar, eVar2, aVar.clone().mo12420a(this.f4362l.floatValue()), (RequestCoordinator) iVar4, jVar3, mo19984b(priority2), i5, i6, executor2));
            return iVar3;
        }
    }

    /* renamed from: a */
    private Request m5257a(Target<TranscodeType> hVar, RequestListener<TranscodeType> eVar, BaseRequestOptions<?> aVar, RequestCoordinator dVar, TransitionOptions<?, ? super TranscodeType> jVar, Priority priority, int i, int i2, Executor executor) {
        Context context = this.f4352b;
        GlideContext gVar = this.f4356f;
        return SingleRequest.m5110a(context, gVar, this.f4358h, this.f4354d, aVar, i, i2, priority, hVar, eVar, this.f4359i, dVar, gVar.mo12549c(), jVar.getTransitionFactory(), executor);
    }
}
