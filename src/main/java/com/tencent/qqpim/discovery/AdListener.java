package com.tencent.qqpim.discovery;

public interface AdListener {

    /* renamed from: com.tencent.qqpim.discovery.AdListener$AdListenerErrorCode */
    public static class AdListenerErrorCode {
        public static final int LIMITEDREQUEST = 3;
        public static final int NETERROR = 1;
        public static final int NOAD = 2;

        public static String getErrorDes(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "UNKNOW" : "LIMITEDREQUEST" : "NOAD" : "NETERROR";
        }
    }

    void onAdClicked(AdDisplayModel adDisplayModel);

    void onAdClose(AdDisplayModel adDisplayModel);

    @Deprecated
    void onAdLoaded(C7479Ad ad);

    void onAdShow(AdDisplayModel adDisplayModel);

    void onError(C7479Ad ad, int i);
}
