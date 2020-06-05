package com.tencent.qqpim.discovery.internal.protocol;

import java.io.Serializable;

public final class EAdPhase implements Serializable {
    public static final int _EADPHASE_ACTIVE = 8;
    public static final int _EADPHASE_CLICK = 4;
    public static final int _EADPHASE_CLOSE = 9;
    public static final int _EADPHASE_DEEPLINK = 10;
    public static final int _EADPHASE_DISPLAY = 3;
    public static final int _EADPHASE_DOWNLOAD = 6;
    public static final int _EADPHASE_INSTALL = 7;
    public static final int _EADPHASE_NONE = 0;
    public static final int _EADPHASE_RECV = 2;
    public static final int _EADPHASE_SEND = 1;
    public static final int _EADPHASE_SHOULD_DISPLAY = 101;
    public static final int _EADPHASE_TRANS = 5;
    public static final int _EADPHASE_VIDEO_PLAY = 11;
}
