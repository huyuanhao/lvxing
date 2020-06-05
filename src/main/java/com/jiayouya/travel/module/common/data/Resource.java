package com.jiayouya.travel.module.common.data;

import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001 B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JL\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/Resource;", "T", "", "status", "", "data", "message", "", "extra", "isRefresh", "", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Z)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getExtra", "()Z", "getMessage", "()Ljava/lang/String;", "getStatus", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Z)Lcom/jiayouya/travel/module/common/data/Resource;", "equals", "other", "hashCode", "toString", "Companion", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Resource.kt */
public final class Resource<T> {
    public static final Companion Companion = new Companion(null);
    public static final int ERROR = 1;
    public static final int LOADING = 2;
    public static final int SUCCESS = 0;
    private final T data;
    private final Object extra;
    private final boolean isRefresh;
    private final String message;
    private final int status;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u0001H\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u0001H\t¢\u0006\u0002\u0010\u0010J9\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0001\u0010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u0001H\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo39189d2 = {"Lcom/jiayouya/travel/module/common/data/Resource$Companion;", "", "()V", "ERROR", "", "LOADING", "SUCCESS", "error", "Lcom/jiayouya/travel/module/common/data/Resource;", "T", "msg", "", "data", "extra", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/jiayouya/travel/module/common/data/Resource;", "loading", "(Ljava/lang/Object;)Lcom/jiayouya/travel/module/common/data/Resource;", "success", "isRefresh", "", "(Ljava/lang/Object;ZLjava/lang/Object;)Lcom/jiayouya/travel/module/common/data/Resource;", "app_grRelease"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Resource.kt */
    /* renamed from: com.jiayouya.travel.module.common.data.Resource$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }

        public static /* synthetic */ Resource success$default(Companion companion, Object obj, boolean z, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                obj2 = null;
            }
            return companion.success(obj, z, obj2);
        }

        public final <T> Resource<T> success(T t, boolean z, Object obj) {
            Resource resource = new Resource(0, t, null, obj, z, 4, null);
            return resource;
        }

        public static /* synthetic */ Resource error$default(Companion companion, String str, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                obj = null;
            }
            if ((i & 4) != 0) {
                obj2 = null;
            }
            return companion.error(str, obj, obj2);
        }

        public final <T> Resource<T> error(String str, T t, Object obj) {
            Resource resource = new Resource(1, t, str, obj, false, 16, null);
            return resource;
        }

        public static /* synthetic */ Resource loading$default(Companion companion, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.loading(obj);
        }

        public final <T> Resource<T> loading(T t) {
            Resource resource = new Resource(2, t, null, null, false, 28, null);
            return resource;
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=T, for r5v0, types: [java.lang.Object] */
    public static /* synthetic */ com.jiayouya.travel.module.common.data.Resource copy$default(com.jiayouya.travel.module.common.data.Resource r3, int r4, T r5, java.lang.String r6, java.lang.Object r7, boolean r8, int r9, java.lang.Object r10) {
        /*
        r10 = r9 & 1
        if (r10 == 0) goto L_0x0006
        int r4 = r3.status
    L_0x0006:
        r10 = r9 & 2
        if (r10 == 0) goto L_0x000c
        T r5 = r3.data
    L_0x000c:
        r10 = r5
        r5 = r9 & 4
        if (r5 == 0) goto L_0x0013
        java.lang.String r6 = r3.message
    L_0x0013:
        r0 = r6
        r5 = r9 & 8
        if (r5 == 0) goto L_0x001a
        java.lang.Object r7 = r3.extra
    L_0x001a:
        r1 = r7
        r5 = r9 & 16
        if (r5 == 0) goto L_0x0021
        boolean r8 = r3.isRefresh
    L_0x0021:
        r2 = r8
        r5 = r3
        r6 = r4
        r7 = r10
        r8 = r0
        r9 = r1
        r10 = r2
        com.jiayouya.travel.module.common.data.Resource r3 = r5.copy(r6, r7, r8, r9, r10)
        return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.module.common.data.Resource.copy$default(com.jiayouya.travel.module.common.data.Resource, int, java.lang.Object, java.lang.String, java.lang.Object, boolean, int, java.lang.Object):com.jiayouya.travel.module.common.data.Resource");
    }

    public final int component1() {
        return this.status;
    }

    public final T component2() {
        return this.data;
    }

    public final String component3() {
        return this.message;
    }

    public final Object component4() {
        return this.extra;
    }

    public final boolean component5() {
        return this.isRefresh;
    }

    public final Resource<T> copy(int i, T t, String str, Object obj, boolean z) {
        Resource resource = new Resource(i, t, str, obj, z);
        return resource;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Resource) {
                Resource resource = (Resource) obj;
                if ((this.status == resource.status) && C8271i.m35384a((Object) this.data, (Object) resource.data) && C8271i.m35384a((Object) this.message, (Object) resource.message) && C8271i.m35384a(this.extra, resource.extra)) {
                    if (this.isRefresh == resource.isRefresh) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.status * 31;
        T t = this.data;
        int i2 = 0;
        int hashCode = (i + (t != null ? t.hashCode() : 0)) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.extra;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z = this.isRefresh;
        if (z) {
            z = true;
        }
        return i3 + z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resource(status=");
        sb.append(this.status);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append(", isRefresh=");
        sb.append(this.isRefresh);
        sb.append(")");
        return sb.toString();
    }

    public Resource(int i, T t, String str, Object obj, boolean z) {
        this.status = i;
        this.data = t;
        this.message = str;
        this.extra = obj;
        this.isRefresh = z;
    }

    public final int getStatus() {
        return this.status;
    }

    public final T getData() {
        return this.data;
    }

    public /* synthetic */ Resource(int i, Object obj, String str, Object obj2, boolean z, int i2, DefaultConstructorMarker fVar) {
        Object obj3 = (i2 & 2) != 0 ? null : obj;
        if ((i2 & 4) != 0) {
            str = null;
        }
        this(i, obj3, str, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? true : z);
    }

    public final String getMessage() {
        return this.message;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }
}
