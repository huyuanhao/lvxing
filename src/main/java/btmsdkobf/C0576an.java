package btmsdkobf;

import android.text.TextUtils;
import com.tmsdk.module.coin.CheckTaskResultItem;
import com.tmsdk.module.coin.Coin;
import com.tmsdk.module.coin.CoinRequestInfo;
import com.tmsdk.module.coin.CoinTask;
import com.tmsdk.module.coin.CoinTaskType;
import com.tmsdk.module.coin.ErrorCode;
import com.tmsdk.module.coin.MallData;
import com.tmsdk.module.coin.SubmitResultItem;
import com.tmsdk.module.coin.TMSDKContext;
import com.tmsdk.module.coin.TmsLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: btmsdkobf.an */
public class C0576an {
    /* renamed from: bB */
    private int f117bB = 0;
    /* renamed from: bC */
    private int f118bC = 0;

    public C0576an() {
        String str = "CoinManager_Impl";
        JSONObject jSONObject = TMSDKContext.getsExtraJO();
        try {
            this.f117bB = jSONObject.getInt("coin_productId");
            this.f118bC = jSONObject.getInt("coin_version");
            StringBuilder sb = new StringBuilder();
            sb.append("mCoinProductId:");
            sb.append(this.f117bB);
            TmsLog.m32939d(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mCoinVersion:");
            sb2.append(this.f118bC);
            TmsLog.m32939d(str, sb2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private C0887v m28a(CoinRequestInfo coinRequestInfo) {
        C0887v vVar = new C0887v();
        vVar.f1076aq = coinRequestInfo.accountId;
        vVar.f1078as = C0638c.getGuid();
        vVar.f1079at = "";
        vVar.f1077ar = coinRequestInfo.loginKey;
        C0881p pVar = new C0881p();
        pVar.f1055ae = this.f117bB;
        pVar.f1056af = this.f118bC;
        vVar.f1075ap = pVar;
        TmsLog.m32939d("CoinManager_Impl", coinRequestInfo.toString());
        return vVar;
    }

    public int CheckBatchTask(CoinRequestInfo coinRequestInfo, ArrayList<CoinTask> arrayList, ArrayList<CheckTaskResultItem> arrayList2) {
        if (arrayList == null || coinRequestInfo == null || arrayList2 == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        if (TextUtils.isEmpty(a.f1076aq) && TextUtils.isEmpty(a.f1078as)) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m48a(a, arrayList, (C0600ap) new C0600ap() {
            /* renamed from: a */
            public void mo9152a(int i, ArrayList<C0878m> arrayList) {
                atomicInteger.set(i);
                atomicReference.set(arrayList);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (atomicInteger.get() == 0) {
            ArrayList arrayList3 = (ArrayList) atomicReference.get();
            if (arrayList3 != null && arrayList3.size() > 0) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    C0878m mVar = (C0878m) it.next();
                    CheckTaskResultItem checkTaskResultItem = new CheckTaskResultItem();
                    checkTaskResultItem.coinNum = mVar.coin_num;
                    checkTaskResultItem.errorCode = mVar.f1046W;
                    checkTaskResultItem.orderId = mVar.order_id;
                    arrayList2.add(checkTaskResultItem);
                }
            }
        }
        return atomicInteger.get();
    }

    public int GetCoinProductId() {
        return this.f117bB;
    }

    public int GetCoinVersion() {
        return this.f118bC;
    }

    public int GetMallData(CoinRequestInfo coinRequestInfo, long j, MallData mallData) {
        MallData mallData2 = mallData;
        int i = ErrorCode.EC_PARAM_INVALID;
        if (!(coinRequestInfo == null || mallData2 == null)) {
            C0887v a = m28a(coinRequestInfo);
            if (a == null) {
                return ErrorCode.EC_PARAM_INVALID;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
            AtomicLong atomicLong = new AtomicLong(0);
            AtomicReference atomicReference = new AtomicReference();
            AtomicReference atomicReference2 = new AtomicReference();
            new AtomicReference(null);
            final AtomicInteger atomicInteger2 = atomicInteger;
            final AtomicLong atomicLong2 = atomicLong;
            final AtomicReference atomicReference3 = atomicReference;
            final AtomicReference atomicReference4 = atomicReference2;
            final CountDownLatch countDownLatch2 = countDownLatch;
            C05846 r3 = new C0603as() {
                /* renamed from: a */
                public void mo9154a(int i, long j, String str, String str2) {
                    atomicInteger2.set(i);
                    atomicLong2.set(j);
                    atomicReference3.set(str);
                    atomicReference4.set(str2);
                    countDownLatch2.countDown();
                }
            };
            C0588ao.m42a(a, j, (C0603as) r3);
            try {
                countDownLatch.await(8, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mallData2 != null) {
                mallData2.version = atomicLong.get();
                mallData2.resource = (String) atomicReference.get();
                mallData2.stock = (String) atomicReference2.get();
            }
            i = atomicInteger.get();
        }
        return i;
    }

    public int GetMallItemList(CoinRequestInfo coinRequestInfo, long j, C0571ai aiVar) {
        if (coinRequestInfo == null || aiVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m46a(a, j, (C0607aw) new C0607aw() {
            /* renamed from: a */
            public void mo9155a(int i, ArrayList<C0573ak> arrayList) {
                atomicInteger.set(i);
                atomicReference.set(arrayList);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (aiVar != null) {
            aiVar.f94W = atomicInteger.get();
            aiVar.f95bm = (ArrayList) atomicReference.get();
        }
        return atomicInteger.get();
    }

    public int GetTasks(CoinRequestInfo coinRequestInfo, ArrayList<Integer> arrayList, Coin coin, ArrayList<CoinTaskType> arrayList2) {
        if (arrayList2 == null || coinRequestInfo == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        if (TextUtils.isEmpty(a.f1076aq) && TextUtils.isEmpty(a.f1078as)) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        AtomicInteger atomicInteger2 = new AtomicInteger(-1);
        AtomicReference atomicReference = new AtomicReference(null);
        final AtomicInteger atomicInteger3 = atomicInteger;
        final AtomicReference atomicReference2 = atomicReference;
        final AtomicInteger atomicInteger4 = atomicInteger2;
        final CountDownLatch countDownLatch2 = countDownLatch;
        C05771 r2 = new C0608ax() {
            /* renamed from: a */
            public void mo9147a(int i, int i2, ArrayList<C0884s> arrayList) {
                atomicInteger3.set(i);
                atomicReference2.set(arrayList);
                atomicInteger4.set(i2);
                countDownLatch2.countDown();
            }
        };
        C0588ao.m49a(a, arrayList, (C0608ax) r2);
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (atomicInteger.get() == 0) {
            ArrayList arrayList3 = (ArrayList) atomicReference.get();
            if (arrayList3 != null && arrayList3.size() > 0) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    C0884s sVar = (C0884s) it.next();
                    CoinTaskType coinTaskType = new CoinTaskType();
                    coinTaskType.task_type = sVar.task_type;
                    coinTaskType.coinTasks = new ArrayList<>();
                    if (sVar.f1066ag != null && sVar.f1066ag.size() > 0) {
                        Iterator it2 = sVar.f1066ag.iterator();
                        while (it2.hasNext()) {
                            C0885t tVar = (C0885t) it2.next();
                            CoinTask coinTask = new CoinTask();
                            coinTask.coin_num = tVar.coin_num;
                            coinTask.task_type = tVar.task_type;
                            coinTask.task_status = tVar.f1069ai;
                            coinTask.order_id = tVar.order_id;
                            coinTask.order_data = tVar.order_data;
                            coinTask.coin_num_login = tVar.coin_num;
                            coinTask.order_assign_timestamp = tVar.f1071ak;
                            coinTask.order_expire_timestamp = tVar.f1073am;
                            coinTask.order_submit_timestamp = tVar.f1072al;
                            if (tVar.f1070aj != null) {
                                C0886u uVar = tVar.f1070aj;
                                coinTask.type_id = uVar.type_id;
                                coinTask.text_1 = uVar.text_1;
                                coinTask.text_2 = uVar.text_2;
                                coinTask.text_3 = uVar.text_3;
                                coinTask.icon_1 = uVar.icon_1;
                                coinTask.icon_2 = uVar.icon_2;
                                coinTask.icon_3 = uVar.icon_3;
                                coinTask.url = uVar.url;
                                coinTask.app = uVar.app;
                                coinTask.extra = uVar.extra;
                            }
                            coinTaskType.coinTasks.add(coinTask);
                        }
                    }
                    arrayList2.add(coinTaskType);
                }
            }
        }
        if (coin != null) {
            coin.totalCoin = atomicInteger2.get();
        }
        return atomicInteger.get();
    }

    public int SubmitBatchTask(CoinRequestInfo coinRequestInfo, ArrayList<CoinTask> arrayList, Coin coin, ArrayList<SubmitResultItem> arrayList2) {
        if (arrayList == null || coinRequestInfo == null || arrayList2 == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        if (TextUtils.isEmpty(a.f1076aq) && TextUtils.isEmpty(a.f1077ar)) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        AtomicInteger atomicInteger2 = new AtomicInteger(-1);
        AtomicReference atomicReference = new AtomicReference(null);
        final AtomicInteger atomicInteger3 = atomicInteger;
        final AtomicReference atomicReference2 = atomicReference;
        final AtomicInteger atomicInteger4 = atomicInteger2;
        final CountDownLatch countDownLatch2 = countDownLatch;
        C05835 r2 = new C0610az() {
            /* renamed from: a */
            public void mo9153a(int i, int i2, ArrayList<C0878m> arrayList) {
                atomicInteger3.set(i);
                atomicReference2.set(arrayList);
                atomicInteger4.set(i2);
                countDownLatch2.countDown();
            }
        };
        C0588ao.m50a(a, arrayList, (C0610az) r2);
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (atomicInteger.get() == 0) {
            ArrayList arrayList3 = (ArrayList) atomicReference.get();
            if (arrayList3 != null && arrayList3.size() > 0) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    C0878m mVar = (C0878m) it.next();
                    SubmitResultItem submitResultItem = new SubmitResultItem();
                    submitResultItem.coinNum = mVar.coin_num;
                    submitResultItem.errorCode = mVar.f1046W;
                    submitResultItem.orderId = mVar.order_id;
                    arrayList2.add(submitResultItem);
                }
            }
        }
        if (coin != null) {
            coin.totalCoin = atomicInteger2.get();
        }
        return atomicInteger.get();
    }

    public int getActAreaList(CoinRequestInfo coinRequestInfo, long j, C0890y yVar) {
        if (coinRequestInfo == null || yVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m40a(a, j, (C0601aq) new C0601aq() {
            /* renamed from: a */
            public void mo9148a(int i, ArrayList<C0889x> arrayList) {
                atomicInteger.set(i);
                atomicReference.set(arrayList);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (yVar != null) {
            yVar.f1098W = atomicInteger.get();
            yVar.f1099aH = (ArrayList) atomicReference.get();
        }
        return atomicInteger.get();
    }

    public int getBannerList(CoinRequestInfo coinRequestInfo, long j, C0563aa aaVar) {
        if (coinRequestInfo == null || aaVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m41a(a, j, (C0602ar) new C0602ar() {
            /* renamed from: a */
            public void mo9157a(int i, ArrayList<C0891z> arrayList) {
                atomicInteger.set(i);
                atomicReference.set(arrayList);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (aaVar != null) {
            aaVar.f46W = atomicInteger.get();
            aaVar.f47aN = (ArrayList) atomicReference.get();
        }
        return atomicInteger.get();
    }

    public int getMallExcRecord(CoinRequestInfo coinRequestInfo, long j, C0565ac acVar) {
        if (coinRequestInfo == null || acVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m43a(a, j, (C0604at) new C0604at() {
            /* renamed from: a */
            public void mo9150a(int i, ArrayList<C0572aj> arrayList) {
                atomicInteger.set(i);
                atomicReference.set(arrayList);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (acVar != null) {
            acVar.f53W = atomicInteger.get();
            acVar.f54aP = (ArrayList) atomicReference.get();
        }
        return atomicInteger.get();
    }

    public int getMallItemDetail(CoinRequestInfo coinRequestInfo, long j, C0570ah ahVar) {
        if (coinRequestInfo == null || ahVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicReference atomicReference = new AtomicReference(null);
        C0588ao.m44a(a, j, (C0605au) new C0605au() {
            /* renamed from: a */
            public void mo9156a(int i, C0568af afVar) {
                atomicInteger.set(i);
                atomicReference.set(afVar);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ahVar != null) {
            ahVar.f90W = atomicInteger.get();
            ahVar.f91bk = (C0568af) atomicReference.get();
        }
        return atomicInteger.get();
    }

    public int getMallItemExcRule(CoinRequestInfo coinRequestInfo, long j, C0567ae aeVar) {
        if (coinRequestInfo == null || aeVar == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        C0887v a = m28a(coinRequestInfo);
        if (a == null) {
            return ErrorCode.EC_PARAM_INVALID;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        final AtomicInteger atomicInteger3 = new AtomicInteger(0);
        C0588ao.m45a(a, j, (C0606av) new C0606av() {
            /* renamed from: a */
            public void mo9149a(int i, int i2, int i3) {
                atomicInteger.set(i);
                atomicInteger2.set(i2);
                atomicInteger3.set(i3);
            }
        });
        try {
            countDownLatch.await(8, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (aeVar != null) {
            aeVar.f62W = atomicInteger.get();
            aeVar.f63aV = atomicInteger2.get();
            aeVar.f64aW = atomicInteger3.get();
        }
        return atomicInteger.get();
    }

    public int mallExchange(CoinRequestInfo coinRequestInfo, long j, C0566ad adVar) {
        C0566ad adVar2 = adVar;
        int i = ErrorCode.EC_PARAM_INVALID;
        if (!(coinRequestInfo == null || adVar2 == null)) {
            C0887v a = m28a(coinRequestInfo);
            if (a == null) {
                return ErrorCode.EC_PARAM_INVALID;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicInteger atomicInteger = new AtomicInteger(ErrorCode.EC_FAIL);
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            AtomicInteger atomicInteger3 = new AtomicInteger(0);
            AtomicInteger atomicInteger4 = new AtomicInteger(0);
            AtomicReference atomicReference = new AtomicReference(null);
            final AtomicInteger atomicInteger5 = atomicInteger;
            final AtomicInteger atomicInteger6 = atomicInteger2;
            final AtomicInteger atomicInteger7 = atomicInteger3;
            final AtomicInteger atomicInteger8 = atomicInteger4;
            final AtomicReference atomicReference2 = atomicReference;
            C05813 r4 = new C0609ay() {
                /* renamed from: a */
                public void mo9151a(int i, int i2, int i3, int i4, String str) {
                    atomicInteger5.set(i);
                    atomicInteger6.set(i2);
                    atomicInteger7.set(i3);
                    atomicInteger8.set(i4);
                    atomicReference2.set(str);
                }
            };
            C0588ao.m47a(a, j, (C0609ay) r4);
            try {
                countDownLatch.await(8, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (adVar2 != null) {
                adVar2.f56W = atomicInteger.get();
                adVar2.f57aR = atomicInteger2.get();
                adVar2.f58aS = atomicInteger3.get();
                adVar2.f59aT = atomicInteger4.get();
                adVar2.f60aU = (String) atomicReference.get();
            }
            i = atomicInteger.get();
        }
        return i;
    }
}
