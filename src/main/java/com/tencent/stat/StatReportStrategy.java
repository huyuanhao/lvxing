package com.tencent.stat;

public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    /* renamed from: a */
    int f25424a;

    private StatReportStrategy(int i) {
        this.f25424a = i;
    }

    public int getIntValue() {
        return this.f25424a;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        StatReportStrategy[] values;
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.getIntValue()) {
                return statReportStrategy;
            }
        }
        return null;
    }
}
