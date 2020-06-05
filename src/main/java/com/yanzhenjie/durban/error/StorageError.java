package com.yanzhenjie.durban.error;

public class StorageError extends Exception {
    public StorageError(String str) {
        super(str);
    }

    public StorageError(Throwable th) {
        super(th);
    }
}
