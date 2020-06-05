package com.qiyukf.unicorn.api.event.eventcallback;

import com.qiyukf.unicorn.api.event.entry.TransferCloseResultEntry;

public interface TransferCloseResultCallback {
    void handlerTransferCloseCallback(TransferCloseResultEntry transferCloseResultEntry);
}
