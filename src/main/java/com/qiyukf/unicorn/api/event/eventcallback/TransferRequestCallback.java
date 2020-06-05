package com.qiyukf.unicorn.api.event.eventcallback;

import com.qiyukf.unicorn.api.event.entry.TransferRequestEntry;

public interface TransferRequestCallback {
    void handlerTransferRequestCallback(TransferRequestEntry transferRequestEntry);
}
