package com.kwai.filedownloader.exception;

import com.kwai.filedownloader.p358f.C4664f;
import java.io.IOException;

public class FileDownloadOutOfSpaceException extends IOException {
    private long breakpointBytes;
    private long freeSpaceBytes;
    private long requiredSpaceBytes;

    public FileDownloadOutOfSpaceException(long j, long j2, long j3) {
        super(C4664f.m19135a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)));
        init(j, j2, j3);
    }

    public FileDownloadOutOfSpaceException(long j, long j2, long j3, Throwable th) {
        super(C4664f.m19135a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(j)), th);
        init(j, j2, j3);
    }

    private void init(long j, long j2, long j3) {
        this.freeSpaceBytes = j;
        this.requiredSpaceBytes = j2;
        this.breakpointBytes = j3;
    }

    public long getBreakpointBytes() {
        return this.breakpointBytes;
    }

    public long getFreeSpaceBytes() {
        return this.freeSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
