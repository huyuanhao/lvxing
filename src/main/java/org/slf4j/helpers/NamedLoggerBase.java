package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.C8580b;
import org.slf4j.LoggerFactory;

/* renamed from: org.slf4j.helpers.b */
abstract class NamedLoggerBase implements Serializable, C8580b {
    private static final long serialVersionUID = 7535258609338176893L;
    protected String name;

    NamedLoggerBase() {
    }

    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return LoggerFactory.m37316a(getName());
    }
}
