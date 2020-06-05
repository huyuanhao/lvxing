package com.alibaba.wireless.security.open.middletier.p093fc;

/* renamed from: com.alibaba.wireless.security.open.middletier.fc.FCAction */
public class FCAction {

    /* renamed from: com.alibaba.wireless.security.open.middletier.fc.FCAction$FCMainAction */
    public enum FCMainAction {
        SUCCESS,
        FAIL,
        CANCEL,
        RETRY,
        TIMEOUT
    }

    /* renamed from: com.alibaba.wireless.security.open.middletier.fc.FCAction$FCSubAction */
    public enum FCSubAction {
        WUA(1),
        NC(2),
        FL(4),
        LOGIN(8),
        DENY(16);
        
        /* renamed from: a */
        private long f3578a;

        private FCSubAction(long j) {
            this.f3578a = 0;
            this.f3578a = j;
        }

        public long getValue() {
            return this.f3578a;
        }
    }
}
