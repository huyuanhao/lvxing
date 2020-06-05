package com.qiyukf.unicorn.api.event;

import android.util.SparseArray;
import java.io.Serializable;

public class SDKEvents implements Serializable {
    public transient SparseArray<UnicornEventBase> eventMap = new SparseArray<>();
    public transient EventProcessFactory eventProcessFactory;
}
