package mtopsdk.mtop.util;

import java.io.Serializable;

public class Result<T> implements Serializable {
    /* renamed from: a */
    private boolean f28017a;
    /* renamed from: b */
    private T f28018b;
    /* renamed from: c */
    private String f28019c;
    /* renamed from: d */
    private String f28020d;
    /* renamed from: e */
    private String f28021e;
    /* renamed from: f */
    private int f28022f;

    public Result(T t) {
        this.f28017a = true;
        this.f28018b = t;
    }

    public Result() {
        this.f28017a = true;
    }

    public Result(boolean z, String str, String str2) {
        this(z, null, str, str2);
    }

    public Result(boolean z, String str, String str2, String str3) {
        this.f28017a = true;
        this.f28017a = z;
        this.f28019c = str;
        this.f28020d = str2;
        this.f28021e = str3;
    }

    public T getModel() {
        return this.f28018b;
    }

    public void setModel(T t) {
        this.f28018b = t;
    }

    public String getErrCode() {
        return this.f28020d;
    }

    public void setErrCode(String str) {
        this.f28020d = str;
    }

    public String getErrInfo() {
        return this.f28021e;
    }

    public void setErrInfo(String str) {
        this.f28021e = str;
    }

    public String getErrType() {
        return this.f28019c;
    }

    public void setErrType(String str) {
        this.f28019c = str;
    }

    public boolean isSuccess() {
        return this.f28017a;
    }

    public void setSuccess(boolean z) {
        this.f28017a = z;
    }

    public int getStatusCode() {
        return this.f28022f;
    }

    public void setStatusCode(int i) {
        this.f28022f = i;
    }
}
