package com.p522qq.p523e.comm.p525pi;

/* renamed from: com.qq.e.comm.pi.AdData */
public interface AdData {

    /* renamed from: com.qq.e.comm.pi.AdData$VideoPlayer */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();
}
