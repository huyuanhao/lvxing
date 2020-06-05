package com.ksad.lottie.network;

import com.ksad.lottie.C3665c;

public enum FileExtension {
    Json(".json"),
    Zip(".zip");
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        FileExtension[] values;
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find correct extension for ");
        sb.append(str);
        C3665c.m15251b(sb.toString());
        return Json;
    }

    public String tempExtension() {
        StringBuilder sb = new StringBuilder();
        sb.append(".temp");
        sb.append(this.extension);
        return sb.toString();
    }

    public String toString() {
        return this.extension;
    }
}
