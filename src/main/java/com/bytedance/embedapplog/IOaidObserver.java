package com.bytedance.embedapplog;

public interface IOaidObserver {

    /* renamed from: com.bytedance.embedapplog.IOaidObserver$Oaid */
    public static final class Oaid {
        /* renamed from: id */
        public final String f5008id;

        public Oaid(String str) {
            this.f5008id = str;
        }
    }

    void onOaidLoaded(Oaid oaid);
}
