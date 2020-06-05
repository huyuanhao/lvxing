package com.tmsdk.module.coin;

import android.content.Context;
import btmsdkobf.C0563aa;
import btmsdkobf.C0565ac;
import btmsdkobf.C0566ad;
import btmsdkobf.C0567ae;
import btmsdkobf.C0570ah;
import btmsdkobf.C0571ai;
import btmsdkobf.C0576an;
import btmsdkobf.C0890y;
import java.util.ArrayList;

public class CoinManager extends BaseManager {
    public static final String TAG = "CoinManager";
    /* renamed from: H */
    private C0576an f25877H;

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public int mo37251A() {
        return super.mo37251A();
    }

    public int CheckBatchTask(CoinRequestInfo coinRequestInfo, ArrayList<CoinTask> arrayList, ArrayList<CheckTaskResultItem> arrayList2) {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckBatchTask, checkTasks:[");
        sb.append(arrayList);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.CheckBatchTask(coinRequestInfo, arrayList, arrayList2);
    }

    public int GetCoinProductId() {
        return this.f25877H.GetCoinProductId();
    }

    public int GetCoinVersion() {
        return this.f25877H.GetCoinVersion();
    }

    public int GetMallData(CoinRequestInfo coinRequestInfo, long j, MallData mallData) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallData, GetMallData:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.GetMallData(coinRequestInfo, j, mallData);
    }

    public int GetMallItemList(CoinRequestInfo coinRequestInfo, long j, C0571ai aiVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.GetMallItemList(coinRequestInfo, j, aiVar);
    }

    public int GetTasks(CoinRequestInfo coinRequestInfo, ArrayList<Integer> arrayList, Coin coin, ArrayList<CoinTaskType> arrayList2) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetTasks, coinRequestInfo:[");
        sb.append(coinRequestInfo);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.GetTasks(coinRequestInfo, arrayList, coin, arrayList2);
    }

    public int GetTasks(CoinRequestInfo coinRequestInfo, ArrayList<Integer> arrayList, ArrayList<CoinTaskType> arrayList2) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetTasks, coinRequestInfo:[");
        sb.append(coinRequestInfo);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.GetTasks(coinRequestInfo, arrayList, null, arrayList2);
    }

    public int SubmitBatchTask(CoinRequestInfo coinRequestInfo, ArrayList<CoinTask> arrayList, Coin coin, ArrayList<SubmitResultItem> arrayList2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SubmitBatchTask, submitTasks:[");
        sb.append(arrayList);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.SubmitBatchTask(coinRequestInfo, arrayList, coin, arrayList2);
    }

    public int SubmitBatchTask(CoinRequestInfo coinRequestInfo, ArrayList<CoinTask> arrayList, ArrayList<SubmitResultItem> arrayList2) {
        StringBuilder sb = new StringBuilder();
        sb.append("SubmitBatchTask, submitTasks:[");
        sb.append(arrayList);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.SubmitBatchTask(coinRequestInfo, arrayList, null, arrayList2);
    }

    public int getActAreaList(CoinRequestInfo coinRequestInfo, long j, C0890y yVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.getActAreaList(coinRequestInfo, j, yVar);
    }

    public int getBannerList(CoinRequestInfo coinRequestInfo, long j, C0563aa aaVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.getBannerList(coinRequestInfo, j, aaVar);
    }

    public int getMallExcRecord(CoinRequestInfo coinRequestInfo, long j, C0565ac acVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.getMallExcRecord(coinRequestInfo, j, acVar);
    }

    public int getMallItemDetail(CoinRequestInfo coinRequestInfo, long j, C0570ah ahVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.getMallItemDetail(coinRequestInfo, j, ahVar);
    }

    public int getMallItemExcRule(CoinRequestInfo coinRequestInfo, long j, C0567ae aeVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.getMallItemExcRule(coinRequestInfo, j, aeVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void mo37252h(Context context) {
        this.f25877H = new C0576an();
    }

    public int mallExchange(CoinRequestInfo coinRequestInfo, long j, C0566ad adVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMallItemList, GetMallItemList:[");
        sb.append(j);
        sb.append("]");
        TmsLog.m32939d(TAG, sb.toString());
        return this.f25877H.mallExchange(coinRequestInfo, j, adVar);
    }
}
