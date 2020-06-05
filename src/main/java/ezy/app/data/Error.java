package ezy.app.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u0013"}, mo39189d2 = {"Lezy/app/data/Error;", "", "message", "", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "setMessage", "component1", "copy", "equals", "", "other", "hashCode", "toString", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Error.kt */
public final class Error {
    @SerializedName(alternate = {"errorCode"}, value = "code")
    private final int code;
    private String message;

    public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = error.message;
        }
        return error.copy(str);
    }

    public final String component1() {
        return this.message;
    }

    public final Error copy(String str) {
        C8271i.m35386b(str, "message");
        return new Error(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.C8271i.m35384a((java.lang.Object) r1.message, (java.lang.Object) ((ezy.app.data.Error) r2).message) != false) goto L_0x0015;
     */
    public boolean equals(java.lang.Object r2) {
        /*
        r1 = this;
        if (r1 == r2) goto L_0x0015
        boolean r0 = r2 instanceof ezy.app.data.Error
        if (r0 == 0) goto L_0x0013
        ezy.app.data.Error r2 = (ezy.app.data.Error) r2
        java.lang.String r0 = r1.message
        java.lang.String r2 = r2.message
        boolean r2 = kotlin.jvm.internal.C8271i.m35384a(r0, r2)
        if (r2 == 0) goto L_0x0013
        goto L_0x0015
    L_0x0013:
        r2 = 0
        return r2
    L_0x0015:
        r2 = 1
        return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ezy.app.data.Error.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.message;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error(message=");
        sb.append(this.message);
        sb.append(")");
        return sb.toString();
    }

    public Error(String str) {
        C8271i.m35386b(str, "message");
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        C8271i.m35386b(str, "<set-?>");
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }
}
