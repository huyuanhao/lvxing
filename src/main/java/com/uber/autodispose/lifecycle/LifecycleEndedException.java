package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

public class LifecycleEndedException extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String str) {
        super(str);
    }
}
