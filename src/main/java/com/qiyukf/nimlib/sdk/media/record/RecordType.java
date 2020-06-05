package com.qiyukf.nimlib.sdk.media.record;

public enum RecordType {
    AMR(3, 1, ".amr"),
    AAC(6, 3, ".aac");
    
    private int audioEncoder;
    private int outputFormat;
    private String suffix;

    private RecordType(int i, int i2, String str) {
        this.outputFormat = i;
        this.audioEncoder = i2;
        this.suffix = str;
    }

    public final int getAudioEncoder() {
        return this.audioEncoder;
    }

    public final String getFileSuffix() {
        return this.suffix;
    }

    public final int getOutputFormat() {
        return this.outputFormat;
    }
}
