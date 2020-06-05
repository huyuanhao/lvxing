package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleNotStartedException extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String str) {
        super(str);
    }
}
