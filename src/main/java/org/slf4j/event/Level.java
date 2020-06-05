package org.slf4j.event;

public enum Level {
    ERROR(40, r1),
    WARN(30, r3),
    INFO(20, r4),
    DEBUG(10, r5),
    TRACE(0, r6);
    
    private int levelInt;
    private String levelStr;

    private Level(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    public int toInt() {
        return this.levelInt;
    }

    public String toString() {
        return this.levelStr;
    }
}
