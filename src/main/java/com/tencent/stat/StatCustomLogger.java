package com.tencent.stat;

public interface StatCustomLogger {
    void debug(Object obj);

    void error(Exception exc);

    void error(Object obj);

    void info(Object obj);

    void verbose(Object obj);

    void warn(Object obj);
}
