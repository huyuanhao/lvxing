package com.tencent.stat;

public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    /* renamed from: a */
    private String f25312a = null;
    /* renamed from: b */
    private long f25313b = 0;
    /* renamed from: c */
    private long f25314c = 0;
    /* renamed from: d */
    private int f25315d = 0;
    /* renamed from: e */
    private long f25316e = 0;
    /* renamed from: f */
    private int f25317f = 0;
    /* renamed from: g */
    private int f25318g = 1;

    public StatAppMonitor(String str) {
        this.f25312a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f25312a = str;
        this.f25313b = j;
        this.f25314c = j2;
        this.f25315d = i;
        this.f25316e = j3;
        this.f25317f = i2;
        this.f25318g = i3;
    }

    public String getInterfaceName() {
        return this.f25312a;
    }

    public void setInterfaceName(String str) {
        this.f25312a = str;
    }

    public long getReqSize() {
        return this.f25313b;
    }

    public void setReqSize(long j) {
        this.f25313b = j;
    }

    public long getRespSize() {
        return this.f25314c;
    }

    public void setRespSize(long j) {
        this.f25314c = j;
    }

    public int getResultType() {
        return this.f25315d;
    }

    public void setResultType(int i) {
        this.f25315d = i;
    }

    public long getMillisecondsConsume() {
        return this.f25316e;
    }

    public void setMillisecondsConsume(long j) {
        this.f25316e = j;
    }

    public int getReturnCode() {
        return this.f25317f;
    }

    public void setReturnCode(int i) {
        this.f25317f = i;
    }

    public int getSampling() {
        return this.f25318g;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f25318g = i;
    }

    public StatAppMonitor clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
