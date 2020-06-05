package com.tencent.qqpim.discovery;

import com.tencent.qqpim.discovery.internal.model.ClickDataModel;
import discoveryAD.C7929sa;
import java.util.ArrayList;

public class ADReporter {

    /* renamed from: com.tencent.qqpim.discovery.ADReporter$OuterReportMetaData */
    public static class OuterReportMetaData {
        public ArrayList<String> clicktrackurls;
        public byte[] context = null;
        public ArrayList<String> finishDownLoadtrackurls;
        public ArrayList<String> installtrackurls;
        public int positionId;
        public ArrayList<String> startDownLoadtrackurls;
        public String uniqueKey;
    }

    public static void reportActive(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 8, 0);
    }

    public static void reportAdClick(OuterReportMetaData outerReportMetaData, ClickDataModel clickDataModel) {
        C7929sa.m34337a(outerReportMetaData, 4, clickDataModel);
    }

    public static void reportDownloadFinish(OuterReportMetaData outerReportMetaData) {
        C7929sa.m34336a(outerReportMetaData, 6);
    }

    public static void reportDownloadFinish(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 6, 0);
    }

    public static void reportInstalled(OuterReportMetaData outerReportMetaData) {
        C7929sa.m34336a(outerReportMetaData, 7);
    }

    public static void reportInstalled(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 7, 0);
    }

    public static void reportStartDownload(OuterReportMetaData outerReportMetaData) {
        C7929sa.m34336a(outerReportMetaData, 5);
    }

    public static void reportStartDownload(AdDisplayModel adDisplayModel) {
        new NativeAd(new AdRequestData());
        NativeAd.reportAppPhase(adDisplayModel, 5, 0);
    }
}
