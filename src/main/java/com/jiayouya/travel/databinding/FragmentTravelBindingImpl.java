package com.jiayouya.travel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.jiayouya.travel.R;
import com.jiayouya.travel.module.travel.data.DogHomeRsp;
import com.jiayouya.travel.module.travel.data.GameIndex;
import com.jiayouya.travel.module.travel.data.SuggestBuyItem;

public class FragmentTravelBindingImpl extends FragmentTravelBinding {
    /* renamed from: R */
    private static final IncludedLayouts f10879R = null;
    /* renamed from: S */
    private static final SparseIntArray f10880S = new SparseIntArray();
    /* renamed from: T */
    private final ImageView f10881T;
    /* renamed from: U */
    private final ImageView f10882U;
    /* renamed from: V */
    private final TextView f10883V;
    /* renamed from: W */
    private final FrameLayout f10884W;
    /* renamed from: X */
    private final ImageView f10885X;
    /* renamed from: Y */
    private final TextView f10886Y;
    /* renamed from: Z */
    private final LinearLayout f10887Z;
    /* renamed from: aa */
    private final TextView f10888aa;
    /* renamed from: ab */
    private long f10889ab;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10880S.put(R.id.far_scroll_view, 19);
        f10880S.put(R.id.bg_far, 20);
        f10880S.put(R.id.bg_far_2, 21);
        f10880S.put(R.id.lyt_top, 22);
        f10880S.put(R.id.middle_scroll_view, 23);
        f10880S.put(R.id.lyt_mid_bg, 24);
        f10880S.put(R.id.bg_middle, 25);
        f10880S.put(R.id.bg_middle_2, 26);
        f10880S.put(R.id.near_scroll_view, 27);
        f10880S.put(R.id.bg_near, 28);
        f10880S.put(R.id.bg_near_2, 29);
        f10880S.put(R.id.lyt_middle, 30);
        f10880S.put(R.id.walk_lottie_view, 31);
        f10880S.put(R.id.tv_rise, 32);
        f10880S.put(R.id.tv_gold_icon, 33);
        f10880S.put(R.id.iv_shop, 34);
        f10880S.put(R.id.status_view, 35);
        f10880S.put(R.id.lyt_free_coin, 36);
        f10880S.put(R.id.iv_claim, 37);
        f10880S.put(R.id.iv_luck_draw, 38);
        f10880S.put(R.id.lyt_bottom, 39);
        f10880S.put(R.id.tv_handbook, 40);
        f10880S.put(R.id.tv_warehouse, 41);
        f10880S.put(R.id.lyt_add, 42);
        f10880S.put(R.id.tv_price, 43);
        f10880S.put(R.id.lyt_merge, 44);
        f10880S.put(R.id.lottie_view, 45);
    }

    public FragmentTravelBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 46, f10879R, f10880S));
    }

    private FragmentTravelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[15], objArr[20], objArr[21], objArr[25], objArr[26], objArr[28], objArr[29], objArr[3], objArr[8], objArr[19], objArr[37], objArr[18], objArr[38], objArr[34], objArr[45], objArr[42], objArr[1], objArr[12], objArr[39], objArr[4], objArr[0], objArr[36], objArr[44], objArr[24], objArr[30], objArr[22], objArr[23], objArr[27], objArr[7], objArr[9], objArr[35], objArr[33], objArr[40], objArr[43], objArr[32], objArr[5], objArr[41], objArr[31]);
        this.f10889ab = -1;
        this.f10853a.setTag(null);
        this.f10860h.setTag(null);
        this.f10861i.setTag(null);
        this.f10864l.setTag(null);
        this.f10869q.setTag(null);
        this.f10870r.setTag(null);
        this.f10872t.setTag(null);
        this.f10873u.setTag(null);
        this.f10881T = objArr[10];
        this.f10881T.setTag(null);
        this.f10882U = objArr[11];
        this.f10882U.setTag(null);
        this.f10883V = objArr[13];
        this.f10883V.setTag(null);
        this.f10884W = objArr[14];
        this.f10884W.setTag(null);
        this.f10885X = objArr[16];
        this.f10885X.setTag(null);
        this.f10886Y = objArr[17];
        this.f10886Y.setTag(null);
        this.f10887Z = objArr[2];
        this.f10887Z.setTag(null);
        this.f10888aa = objArr[6];
        this.f10888aa.setTag(null);
        this.f10838C.setTag(null);
        this.f10839D.setTag(null);
        this.f10845J.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10889ab = 32;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10889ab != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 == i) {
            mo20157a((DogHomeRsp) obj);
        } else if (13 == i) {
            mo20159a((SuggestBuyItem) obj);
        } else if (23 == i) {
            mo20156a(((Long) obj).longValue());
        } else if (29 == i) {
            mo20158a((GameIndex) obj);
        } else if (11 != i) {
            return false;
        } else {
            mo20160a((String) obj);
        }
        return true;
    }

    /* renamed from: a */
    public void mo20157a(DogHomeRsp dogHomeRsp) {
        this.f10851P = dogHomeRsp;
        synchronized (this) {
            this.f10889ab |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20159a(SuggestBuyItem suggestBuyItem) {
        this.f10848M = suggestBuyItem;
        synchronized (this) {
            this.f10889ab |= 2;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20156a(long j) {
        this.f10850O = j;
        synchronized (this) {
            this.f10889ab |= 4;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20158a(GameIndex gameIndex) {
        this.f10852Q = gameIndex;
        synchronized (this) {
            this.f10889ab |= 8;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    /* renamed from: a */
    public void mo20160a(String str) {
        this.f10849N = str;
        synchronized (this) {
            this.f10889ab |= 16;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x12b0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x12ba  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x12e2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x12fd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x131c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x1323  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    public void executeBindings() {
        /*
        r1506 = this;
        r1 = r1506
        monitor-enter(r1)
        long r2 = r1.f10889ab     // Catch:{ all -> 0x132b }
        r4 = 0
        r1.f10889ab = r4     // Catch:{ all -> 0x132b }
        monitor-exit(r1)     // Catch:{ all -> 0x132b }
        com.jiayouya.travel.module.travel.data.DogHomeRsp r0 = r1.f10851P
        com.jiayouya.travel.module.travel.data.SuggestBuyItem r6 = r1.f10848M
        long r7 = r1.f10850O
        com.jiayouya.travel.module.travel.data.GameIndex r9 = r1.f10852Q
        java.lang.String r10 = r1.f10849N
        r11 = 33
        long r13 = r2 & r11
        r15 = 1
        r16 = 0
        int r12 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
        if (r12 == 0) goto L_0x0039
        if (r0 == 0) goto L_0x002e
        java.lang.String r12 = r0.getHowToPlay()
        int r13 = r0.getTickets()
        java.lang.String r0 = r0.getAdProfit()
        goto L_0x0032
    L_0x002e:
        r0 = r16
        r12 = r0
        r13 = 0
    L_0x0032:
        if (r13 <= 0) goto L_0x0036
        r13 = 1
        goto L_0x0037
    L_0x0036:
        r13 = 0
    L_0x0037:
        r13 = r13 ^ r15
        goto L_0x003d
    L_0x0039:
        r0 = r16
        r12 = r0
        r13 = 0
    L_0x003d:
        r17 = 34
        long r19 = r2 & r17
        int r14 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
        if (r14 == 0) goto L_0x0068
        if (r6 == 0) goto L_0x0050
        int r14 = r6.getDogId()
        int r6 = r6.getLevel()
        goto L_0x0052
    L_0x0050:
        r6 = 0
        r14 = 0
    L_0x0052:
        int r14 = com.jiayouya.travel.module.travel.p287c.MergeUtil.m14455b(r14)
        java.lang.StringBuilder r11 = new java.lang.StringBuilder
        r11.<init>()
        r11.append(r6)
        java.lang.String r6 = ""
        r11.append(r6)
        java.lang.String r6 = r11.toString()
        goto L_0x006b
    L_0x0068:
        r6 = r16
        r14 = 0
    L_0x006b:
        r20 = 36
        long r22 = r2 & r20
        int r11 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
        if (r11 == 0) goto L_0x007d
        int r11 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
        if (r11 <= 0) goto L_0x0079
        r11 = 1
        goto L_0x007a
    L_0x0079:
        r11 = 0
    L_0x007a:
        r22 = r11 ^ 1
        goto L_0x0080
    L_0x007d:
        r11 = 0
        r22 = 0
    L_0x0080:
        r23 = 40
        long r25 = r2 & r23
        int r27 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
        if (r27 == 0) goto L_0x0098
        if (r9 == 0) goto L_0x008f
        com.jiayouya.travel.module.travel.data.CityInfo r9 = r9.getCity()
        goto L_0x0091
    L_0x008f:
        r9 = r16
    L_0x0091:
        if (r9 == 0) goto L_0x0098
        java.lang.String r9 = r9.getName()
        goto L_0x009a
    L_0x0098:
        r9 = r16
    L_0x009a:
        r25 = 48
        long r27 = r2 & r25
        int r29 = (r27 > r4 ? 1 : (r27 == r4 ? 0 : -1))
        if (r29 == 0) goto L_0x00b5
        if (r10 != 0) goto L_0x00a7
        r27 = 1
        goto L_0x00a9
    L_0x00a7:
        r27 = 0
    L_0x00a9:
        if (r29 == 0) goto L_0x00b7
        if (r27 == 0) goto L_0x00b0
        r28 = 128(0x80, double:6.32E-322)
        goto L_0x00b2
    L_0x00b0:
        r28 = 64
    L_0x00b2:
        long r2 = r2 | r28
        goto L_0x00b7
    L_0x00b5:
        r27 = 0
    L_0x00b7:
        long r25 = r2 & r25
        int r28 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
        if (r28 == 0) goto L_0x00c2
        if (r27 == 0) goto L_0x00c4
        java.lang.String r10 = "--"
        goto L_0x00c4
    L_0x00c2:
        r10 = r16
    L_0x00c4:
        r25 = 32
        long r25 = r2 & r25
        int r27 = (r25 > r4 ? 1 : (r25 == r4 ? 0 : -1))
        if (r27 == 0) goto L_0x12b0
        android.view.View r4 = r1.f10853a
        r29 = r4
        r30 = 0
        r4 = r16
        java.lang.Integer r4 = (java.lang.Integer) r4
        r1299 = r4
        r1315 = r4
        r1326 = r4
        r1328 = r4
        r1423 = r4
        r1424 = r4
        r1425 = r4
        r1365 = r4
        r1431 = r4
        r1497 = r4
        r1432 = r4
        r1495 = r4
        r1433 = r4
        r1493 = r4
        r1434 = r4
        r1435 = r4
        r1436 = r4
        r1437 = r4
        r1366 = r4
        r1367 = r4
        r1439 = r4
        r1442 = r4
        r1444 = r4
        r1373 = r4
        r1452 = r4
        r1453 = r4
        r1316 = r4
        r1336 = r4
        r1374 = r4
        r1375 = r4
        r1454 = r4
        r1376 = r4
        r1377 = r4
        r1460 = r4
        r1461 = r4
        r1337 = r4
        r1378 = r4
        r1462 = r4
        r1463 = r4
        r1379 = r4
        r1464 = r4
        r1465 = r4
        r1381 = r4
        r1466 = r4
        r1468 = r4
        r1317 = r4
        r1338 = r4
        r1471 = r4
        r1473 = r4
        r1384 = r4
        r1386 = r4
        r1481 = r4
        r1482 = r4
        r1483 = r4
        r1307 = r4
        r1318 = r4
        r1319 = r4
        r1489 = r4
        r1490 = r4
        r1491 = r4
        r1492 = r4
        r1344 = r4
        r1394 = r4
        r1494 = r4
        r1395 = r4
        r1345 = r4
        r1396 = r4
        r1320 = r4
        r1346 = r4
        r1347 = r4
        r1321 = r4
        r1348 = r4
        r1402 = r4
        r1403 = r4
        r1349 = r4
        r1404 = r4
        r1405 = r4
        r1308 = r4
        r1323 = r4
        r1350 = r4
        r1406 = r4
        r1407 = r4
        r1408 = r4
        r1352 = r4
        r1410 = r4
        r1413 = r4
        r1309 = r4
        r1355 = r4
        r1415 = r4
        r1357 = r4
        r1088 = r4
        r1104 = r4
        r1115 = r4
        r1117 = r4
        r1212 = r4
        r1213 = r4
        r1214 = r4
        r1154 = r4
        r1220 = r4
        r1286 = r4
        r1221 = r4
        r1284 = r4
        r1222 = r4
        r1282 = r4
        r1223 = r4
        r1224 = r4
        r1225 = r4
        r1226 = r4
        r1155 = r4
        r1156 = r4
        r1228 = r4
        r1231 = r4
        r1233 = r4
        r1162 = r4
        r1241 = r4
        r1242 = r4
        r1105 = r4
        r1125 = r4
        r1163 = r4
        r1164 = r4
        r1243 = r4
        r1165 = r4
        r1166 = r4
        r1249 = r4
        r1250 = r4
        r1126 = r4
        r1167 = r4
        r1251 = r4
        r1252 = r4
        r1168 = r4
        r1253 = r4
        r1254 = r4
        r1170 = r4
        r1255 = r4
        r1257 = r4
        r1106 = r4
        r1127 = r4
        r1260 = r4
        r1262 = r4
        r1173 = r4
        r1175 = r4
        r1270 = r4
        r1271 = r4
        r1272 = r4
        r1096 = r4
        r1107 = r4
        r1108 = r4
        r1278 = r4
        r1279 = r4
        r1280 = r4
        r1281 = r4
        r1133 = r4
        r1183 = r4
        r1283 = r4
        r1184 = r4
        r1134 = r4
        r1185 = r4
        r1109 = r4
        r1135 = r4
        r1136 = r4
        r1110 = r4
        r1137 = r4
        r1191 = r4
        r1192 = r4
        r1138 = r4
        r1193 = r4
        r1194 = r4
        r1097 = r4
        r1112 = r4
        r1139 = r4
        r1195 = r4
        r1196 = r4
        r1197 = r4
        r1141 = r4
        r1199 = r4
        r1202 = r4
        r1098 = r4
        r1144 = r4
        r1204 = r4
        r1146 = r4
        r877 = r4
        r893 = r4
        r904 = r4
        r906 = r4
        r1001 = r4
        r1002 = r4
        r1003 = r4
        r943 = r4
        r1009 = r4
        r1075 = r4
        r1010 = r4
        r1073 = r4
        r1011 = r4
        r1071 = r4
        r1012 = r4
        r1013 = r4
        r1014 = r4
        r1015 = r4
        r944 = r4
        r945 = r4
        r1017 = r4
        r1020 = r4
        r1022 = r4
        r951 = r4
        r1030 = r4
        r1031 = r4
        r894 = r4
        r914 = r4
        r952 = r4
        r953 = r4
        r1032 = r4
        r954 = r4
        r955 = r4
        r1038 = r4
        r1039 = r4
        r915 = r4
        r956 = r4
        r1040 = r4
        r1041 = r4
        r957 = r4
        r1042 = r4
        r1043 = r4
        r959 = r4
        r1044 = r4
        r1046 = r4
        r895 = r4
        r916 = r4
        r1049 = r4
        r1051 = r4
        r962 = r4
        r964 = r4
        r1059 = r4
        r1060 = r4
        r1061 = r4
        r885 = r4
        r896 = r4
        r897 = r4
        r1067 = r4
        r1068 = r4
        r1069 = r4
        r1070 = r4
        r922 = r4
        r972 = r4
        r1072 = r4
        r973 = r4
        r923 = r4
        r974 = r4
        r898 = r4
        r924 = r4
        r925 = r4
        r899 = r4
        r926 = r4
        r980 = r4
        r981 = r4
        r927 = r4
        r982 = r4
        r983 = r4
        r886 = r4
        r901 = r4
        r928 = r4
        r984 = r4
        r985 = r4
        r986 = r4
        r930 = r4
        r988 = r4
        r991 = r4
        r887 = r4
        r933 = r4
        r993 = r4
        r935 = r4
        r666 = r4
        r682 = r4
        r693 = r4
        r695 = r4
        r790 = r4
        r791 = r4
        r792 = r4
        r732 = r4
        r798 = r4
        r864 = r4
        r799 = r4
        r862 = r4
        r800 = r4
        r860 = r4
        r801 = r4
        r802 = r4
        r803 = r4
        r804 = r4
        r733 = r4
        r734 = r4
        r806 = r4
        r809 = r4
        r811 = r4
        r740 = r4
        r819 = r4
        r820 = r4
        r683 = r4
        r703 = r4
        r741 = r4
        r742 = r4
        r821 = r4
        r743 = r4
        r744 = r4
        r827 = r4
        r828 = r4
        r704 = r4
        r745 = r4
        r829 = r4
        r830 = r4
        r746 = r4
        r831 = r4
        r832 = r4
        r748 = r4
        r833 = r4
        r835 = r4
        r684 = r4
        r705 = r4
        r838 = r4
        r840 = r4
        r751 = r4
        r753 = r4
        r848 = r4
        r849 = r4
        r850 = r4
        r674 = r4
        r685 = r4
        r686 = r4
        r856 = r4
        r857 = r4
        r858 = r4
        r859 = r4
        r711 = r4
        r761 = r4
        r861 = r4
        r762 = r4
        r712 = r4
        r763 = r4
        r687 = r4
        r713 = r4
        r714 = r4
        r688 = r4
        r715 = r4
        r769 = r4
        r770 = r4
        r716 = r4
        r771 = r4
        r772 = r4
        r675 = r4
        r690 = r4
        r717 = r4
        r773 = r4
        r774 = r4
        r775 = r4
        r719 = r4
        r777 = r4
        r780 = r4
        r676 = r4
        r722 = r4
        r782 = r4
        r724 = r4
        r455 = r4
        r471 = r4
        r482 = r4
        r484 = r4
        r579 = r4
        r580 = r4
        r581 = r4
        r521 = r4
        r587 = r4
        r653 = r4
        r588 = r4
        r651 = r4
        r589 = r4
        r649 = r4
        r590 = r4
        r591 = r4
        r592 = r4
        r593 = r4
        r522 = r4
        r523 = r4
        r595 = r4
        r598 = r4
        r600 = r4
        r529 = r4
        r608 = r4
        r609 = r4
        r472 = r4
        r492 = r4
        r530 = r4
        r531 = r4
        r610 = r4
        r532 = r4
        r533 = r4
        r616 = r4
        r617 = r4
        r493 = r4
        r534 = r4
        r618 = r4
        r619 = r4
        r535 = r4
        r620 = r4
        r621 = r4
        r537 = r4
        r622 = r4
        r624 = r4
        r473 = r4
        r494 = r4
        r627 = r4
        r629 = r4
        r540 = r4
        r542 = r4
        r637 = r4
        r638 = r4
        r639 = r4
        r463 = r4
        r474 = r4
        r475 = r4
        r645 = r4
        r646 = r4
        r647 = r4
        r648 = r4
        r500 = r4
        r550 = r4
        r650 = r4
        r551 = r4
        r501 = r4
        r552 = r4
        r476 = r4
        r502 = r4
        r503 = r4
        r477 = r4
        r504 = r4
        r558 = r4
        r559 = r4
        r505 = r4
        r560 = r4
        r561 = r4
        r464 = r4
        r479 = r4
        r506 = r4
        r562 = r4
        r563 = r4
        r564 = r4
        r508 = r4
        r566 = r4
        r569 = r4
        r465 = r4
        r511 = r4
        r571 = r4
        r513 = r4
        r244 = r4
        r260 = r4
        r271 = r4
        r273 = r4
        r368 = r4
        r369 = r4
        r370 = r4
        r310 = r4
        r376 = r4
        r442 = r4
        r377 = r4
        r440 = r4
        r378 = r4
        r438 = r4
        r379 = r4
        r380 = r4
        r381 = r4
        r382 = r4
        r311 = r4
        r312 = r4
        r384 = r4
        r387 = r4
        r389 = r4
        r318 = r4
        r397 = r4
        r398 = r4
        r261 = r4
        r281 = r4
        r319 = r4
        r320 = r4
        r399 = r4
        r321 = r4
        r322 = r4
        r405 = r4
        r406 = r4
        r282 = r4
        r323 = r4
        r407 = r4
        r408 = r4
        r324 = r4
        r409 = r4
        r410 = r4
        r326 = r4
        r411 = r4
        r413 = r4
        r262 = r4
        r283 = r4
        r416 = r4
        r418 = r4
        r329 = r4
        r331 = r4
        r426 = r4
        r427 = r4
        r428 = r4
        r252 = r4
        r263 = r4
        r264 = r4
        r434 = r4
        r435 = r4
        r436 = r4
        r437 = r4
        r289 = r4
        r339 = r4
        r439 = r4
        r340 = r4
        r290 = r4
        r341 = r4
        r265 = r4
        r291 = r4
        r292 = r4
        r266 = r4
        r293 = r4
        r347 = r4
        r348 = r4
        r294 = r4
        r349 = r4
        r350 = r4
        r253 = r4
        r268 = r4
        r295 = r4
        r351 = r4
        r352 = r4
        r353 = r4
        r297 = r4
        r355 = r4
        r358 = r4
        r254 = r4
        r300 = r4
        r360 = r4
        r302 = r4
        r60 = r4
        r62 = r4
        r157 = r4
        r158 = r4
        r159 = r4
        r99 = r4
        r165 = r4
        r231 = r4
        r166 = r4
        r229 = r4
        r167 = r4
        r227 = r4
        r168 = r4
        r169 = r4
        r170 = r4
        r171 = r4
        r100 = r4
        r101 = r4
        r173 = r4
        r176 = r4
        r178 = r4
        r107 = r4
        r186 = r4
        r187 = r4
        r33 = r4
        r49 = r4
        r108 = r4
        r109 = r4
        r188 = r4
        r110 = r4
        r111 = r4
        r194 = r4
        r195 = r4
        r70 = r4
        r112 = r4
        r196 = r4
        r202 = r4
        r197 = r4
        r113 = r4
        r198 = r4
        r199 = r4
        r71 = r4
        r200 = r4
        r115 = r4
        r50 = r4
        r72 = r4
        r205 = r4
        r207 = r4
        r118 = r4
        r51 = r4
        r120 = r4
        r215 = r4
        r216 = r4
        r217 = r4
        r31 = r4
        r52 = r4
        r53 = r4
        r223 = r4
        r224 = r4
        r225 = r4
        r226 = r4
        r78 = r4
        r128 = r4
        r228 = r4
        r129 = r4
        r79 = r4
        r130 = r4
        r54 = r4
        r80 = r4
        r81 = r4
        r55 = r4
        r82 = r4
        r136 = r4
        r137 = r4
        r83 = r4
        r138 = r4
        r139 = r4
        r42 = r4
        r57 = r4
        r84 = r4
        r140 = r4
        r141 = r4
        r142 = r4
        r86 = r4
        r144 = r4
        r147 = r4
        r89 = r4
        r149 = r4
        r91 = r4
        r32 = 0
        r34 = 0
        r35 = 0
        r36 = 1106247680(0x41f00000, float:30.0)
        r37 = 0
        r38 = 0
        r39 = 0
        r40 = 0
        android.view.View r4 = r1.f10853a
        r5 = 2131099778(0x7f060082, float:1.7811919E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r41 = java.lang.Integer.valueOf(r4)
        android.view.View r4 = r1.f10853a
        r5 = 2131099777(0x7f060081, float:1.7811917E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r43 = java.lang.Integer.valueOf(r4)
        r44 = 0
        r45 = 0
        r4 = r16
        java.lang.Float r4 = (java.lang.Float) r4
        r1428 = r4
        r1429 = r4
        r1313 = r4
        r1496 = r4
        r1498 = r4
        r1341 = r4
        r1438 = r4
        r1440 = r4
        r1371 = r4
        r1370 = r4
        r1457 = r4
        r1458 = r4
        r1469 = r4
        r1380 = r4
        r1467 = r4
        r1382 = r4
        r1312 = r4
        r1342 = r4
        r1487 = r4
        r1486 = r4
        r1399 = r4
        r1400 = r4
        r1351 = r4
        r1409 = r4
        r1322 = r4
        r1411 = r4
        r1353 = r4
        r1324 = r4
        r1217 = r4
        r1218 = r4
        r1102 = r4
        r1285 = r4
        r1287 = r4
        r1130 = r4
        r1227 = r4
        r1229 = r4
        r1160 = r4
        r1159 = r4
        r1246 = r4
        r1247 = r4
        r1258 = r4
        r1169 = r4
        r1256 = r4
        r1171 = r4
        r1101 = r4
        r1131 = r4
        r1276 = r4
        r1275 = r4
        r1188 = r4
        r1189 = r4
        r1140 = r4
        r1198 = r4
        r1111 = r4
        r1200 = r4
        r1142 = r4
        r1113 = r4
        r1006 = r4
        r1007 = r4
        r891 = r4
        r1074 = r4
        r1076 = r4
        r919 = r4
        r1016 = r4
        r1018 = r4
        r949 = r4
        r948 = r4
        r1035 = r4
        r1036 = r4
        r1047 = r4
        r958 = r4
        r1045 = r4
        r960 = r4
        r890 = r4
        r920 = r4
        r1065 = r4
        r1064 = r4
        r977 = r4
        r978 = r4
        r929 = r4
        r987 = r4
        r900 = r4
        r989 = r4
        r931 = r4
        r902 = r4
        r795 = r4
        r796 = r4
        r680 = r4
        r863 = r4
        r865 = r4
        r708 = r4
        r805 = r4
        r807 = r4
        r738 = r4
        r737 = r4
        r824 = r4
        r825 = r4
        r836 = r4
        r747 = r4
        r834 = r4
        r749 = r4
        r679 = r4
        r709 = r4
        r854 = r4
        r853 = r4
        r766 = r4
        r767 = r4
        r718 = r4
        r776 = r4
        r689 = r4
        r778 = r4
        r720 = r4
        r691 = r4
        r584 = r4
        r585 = r4
        r469 = r4
        r652 = r4
        r654 = r4
        r497 = r4
        r594 = r4
        r596 = r4
        r527 = r4
        r526 = r4
        r613 = r4
        r614 = r4
        r625 = r4
        r536 = r4
        r623 = r4
        r538 = r4
        r468 = r4
        r498 = r4
        r643 = r4
        r642 = r4
        r555 = r4
        r556 = r4
        r507 = r4
        r565 = r4
        r478 = r4
        r567 = r4
        r509 = r4
        r480 = r4
        r373 = r4
        r374 = r4
        r258 = r4
        r441 = r4
        r443 = r4
        r286 = r4
        r383 = r4
        r385 = r4
        r316 = r4
        r315 = r4
        r402 = r4
        r403 = r4
        r414 = r4
        r325 = r4
        r412 = r4
        r327 = r4
        r257 = r4
        r287 = r4
        r432 = r4
        r431 = r4
        r344 = r4
        r345 = r4
        r296 = r4
        r354 = r4
        r267 = r4
        r356 = r4
        r298 = r4
        r269 = r4
        r162 = r4
        r163 = r4
        r230 = r4
        r232 = r4
        r75 = r4
        r221 = r4
        r172 = r4
        r46 = r4
        r104 = r4
        r105 = r4
        r47 = r4
        r191 = r4
        r192 = r4
        r203 = r4
        r116 = r4
        r201 = r4
        r114 = r4
        r174 = r4
        r220 = r4
        r76 = r4
        r133 = r4
        r134 = r4
        r56 = r4
        r85 = r4
        r143 = r4
        r145 = r4
        r87 = r4
        r58 = r4
        r48 = 0
        r59 = 0
        r61 = 0
        r63 = 0
        r64 = 0
        r65 = 0
        r66 = 0
        r67 = 0
        r68 = 0
        r69 = 0
        r73 = 0
        r74 = 0
        r77 = 0
        r88 = 0
        r90 = 0
        r92 = 0
        r93 = 0
        r94 = 0
        r95 = 0
        r96 = 0
        r97 = 0
        r98 = 0
        r102 = 0
        r103 = 0
        r106 = 0
        r117 = 0
        r119 = 0
        r121 = 0
        r122 = 0
        r123 = 0
        r124 = 0
        r125 = 0
        r126 = 0
        r127 = 0
        r131 = 0
        r132 = 0
        r135 = 0
        r146 = 0
        r148 = 0
        r150 = 0
        r151 = 0
        r152 = 0
        r153 = 0
        r154 = 0
        r155 = 0
        r156 = 0
        r160 = 0
        r161 = 0
        r164 = 0
        r175 = 0
        r177 = 0
        r179 = 0
        r180 = 0
        r181 = 0
        r182 = 0
        r183 = 0
        r184 = 0
        r185 = 0
        r189 = 0
        r190 = 0
        r193 = 0
        r204 = 0
        r206 = 0
        r208 = 0
        r209 = 0
        r210 = 0
        r211 = 0
        r212 = 0
        r213 = 0
        r214 = 0
        r218 = 0
        r219 = 0
        r222 = 0
        r4 = r16
        android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
        r1505 = r4
        r1503 = r4
        r1501 = r4
        r1499 = r4
        r1504 = r4
        r1500 = r4
        r1502 = r4
        r1294 = r4
        r1292 = r4
        r1290 = r4
        r1288 = r4
        r1293 = r4
        r1289 = r4
        r1291 = r4
        r1083 = r4
        r1081 = r4
        r1079 = r4
        r1077 = r4
        r1082 = r4
        r1078 = r4
        r1080 = r4
        r872 = r4
        r870 = r4
        r868 = r4
        r866 = r4
        r871 = r4
        r867 = r4
        r869 = r4
        r661 = r4
        r659 = r4
        r657 = r4
        r655 = r4
        r660 = r4
        r656 = r4
        r658 = r4
        r450 = r4
        r448 = r4
        r446 = r4
        r444 = r4
        r449 = r4
        r445 = r4
        r447 = r4
        r233 = r4
        r239 = r4
        r234 = r4
        r236 = r4
        r235 = r4
        r237 = r4
        r238 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r184, r185, r186, r187, r188, r189, r190, r191, r192, r193, r194, r195, r196, r197, r198, r199, r200, r201, r202, r203, r204, r205, r206, r207, r208, r209, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r230, r231, r232, r233, r234, r235, r236, r237, r238, r239)
        com.jiayouya.travel.common.widget.countdownview.CountdownView r4 = r1.f10861i
        r240 = r4
        r241 = 0
        com.jiayouya.travel.common.widget.countdownview.CountdownView r4 = r1.f10861i
        r5 = 2131099927(0x7f060117, float:1.7812221E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r242 = java.lang.Integer.valueOf(r4)
        r243 = 0
        r245 = 0
        r246 = 0
        r247 = 1077936128(0x40400000, float:3.0)
        r248 = 0
        r249 = 0
        r250 = 0
        r251 = 0
        r4 = 0
        r255 = r4
        r256 = r4
        r4 = 0
        r259 = r4
        r4 = 0
        r270 = r4
        r272 = r4
        r4 = 0
        r274 = r4
        r275 = r4
        r276 = r4
        r277 = r4
        r278 = r4
        r279 = r4
        r280 = r4
        r4 = 0
        r284 = r4
        r285 = r4
        r4 = 0
        r288 = r4
        r4 = 0
        r299 = r4
        r301 = r4
        r4 = 0
        r303 = r4
        r304 = r4
        r305 = r4
        r306 = r4
        r307 = r4
        r308 = r4
        r309 = r4
        r4 = 0
        r313 = r4
        r314 = r4
        r4 = 0
        r317 = r4
        r4 = 0
        r328 = r4
        r330 = r4
        r4 = 0
        r332 = r4
        r333 = r4
        r334 = r4
        r335 = r4
        r336 = r4
        r337 = r4
        r338 = r4
        r4 = 0
        r342 = r4
        r343 = r4
        r4 = 0
        r346 = r4
        r4 = 0
        r357 = r4
        r359 = r4
        r4 = 0
        r361 = r4
        r362 = r4
        r363 = r4
        r364 = r4
        r365 = r4
        r366 = r4
        r367 = r4
        r4 = 0
        r371 = r4
        r372 = r4
        r4 = 0
        r375 = r4
        r4 = 0
        r386 = r4
        r388 = r4
        r4 = 0
        r390 = r4
        r391 = r4
        r392 = r4
        r393 = r4
        r394 = r4
        r395 = r4
        r396 = r4
        r4 = 0
        r400 = r4
        r401 = r4
        r4 = 0
        r404 = r4
        r4 = 0
        r415 = r4
        r417 = r4
        r4 = 0
        r419 = r4
        r420 = r4
        r421 = r4
        r422 = r4
        r423 = r4
        r424 = r4
        r425 = r4
        r4 = 0
        r429 = r4
        r430 = r4
        r4 = 0
        r433 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r240, r241, r242, r243, r244, r245, r246, r247, r248, r249, r250, r251, r252, r253, r254, r255, r256, r257, r258, r259, r260, r261, r262, r263, r264, r265, r266, r267, r268, r269, r270, r271, r272, r273, r274, r275, r276, r277, r278, r279, r280, r281, r282, r283, r284, r285, r286, r287, r288, r289, r290, r291, r292, r293, r294, r295, r296, r297, r298, r299, r300, r301, r302, r303, r304, r305, r306, r307, r308, r309, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r330, r331, r332, r333, r334, r335, r336, r337, r338, r339, r340, r341, r342, r343, r344, r345, r346, r347, r348, r349, r350, r351, r352, r353, r354, r355, r356, r357, r358, r359, r360, r361, r362, r363, r364, r365, r366, r367, r368, r369, r370, r371, r372, r373, r374, r375, r376, r377, r378, r379, r380, r381, r382, r383, r384, r385, r386, r387, r388, r389, r390, r391, r392, r393, r394, r395, r396, r397, r398, r399, r400, r401, r402, r403, r404, r405, r406, r407, r408, r409, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r430, r431, r432, r433, r434, r435, r436, r437, r438, r439, r440, r441, r442, r443, r444, r445, r446, r447, r448, r449, r450)
        com.jiayouya.travel.common.widget.countdownview.CountdownView r4 = r1.f10861i
        r5 = r16
        java.lang.Long r5 = (java.lang.Long) r5
        r29 = r10
        r10 = r16
        java.lang.Boolean r10 = (java.lang.Boolean) r10
        com.jiayouya.travel.common.p243a.CustomAdapter.m12778a(r4, r5, r10, r15)
        com.jiayouya.travel.module.travel.widget.FloatImageView r4 = r1.f10864l
        java.lang.String r5 = "/explore/index"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r5)
        android.widget.FrameLayout r4 = r1.f10870r
        java.lang.String r5 = "/me/bonusDetail"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r5)
        android.widget.FrameLayout r4 = r1.f10870r
        r451 = r4
        r4 = 0
        r452 = r4
        r4 = -827826(0xfffffffffff35e4e, float:NaN)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        r453 = r4
        r4 = 0
        r454 = r4
        r4 = 0
        r456 = r4
        r457 = r4
        r4 = 1110704128(0x42340000, float:45.0)
        r458 = r4
        r4 = 0
        r459 = r4
        r460 = r4
        r461 = r4
        r462 = r4
        r4 = 0
        r466 = r4
        r467 = r4
        r4 = 0
        r470 = r4
        r4 = 0
        r481 = r4
        r483 = r4
        r4 = 0
        r485 = r4
        r486 = r4
        r487 = r4
        r488 = r4
        r489 = r4
        r490 = r4
        r491 = r4
        r4 = 0
        r495 = r4
        r496 = r4
        r4 = 0
        r499 = r4
        r4 = 0
        r510 = r4
        r512 = r4
        r4 = 0
        r514 = r4
        r515 = r4
        r516 = r4
        r517 = r4
        r518 = r4
        r519 = r4
        r520 = r4
        r4 = 0
        r524 = r4
        r525 = r4
        r4 = 0
        r528 = r4
        r4 = 0
        r539 = r4
        r541 = r4
        r4 = 0
        r543 = r4
        r544 = r4
        r545 = r4
        r546 = r4
        r547 = r4
        r548 = r4
        r549 = r4
        r4 = 0
        r553 = r4
        r554 = r4
        r4 = 0
        r557 = r4
        r4 = 0
        r568 = r4
        r570 = r4
        r4 = 0
        r572 = r4
        r573 = r4
        r574 = r4
        r575 = r4
        r576 = r4
        r577 = r4
        r578 = r4
        r4 = 0
        r582 = r4
        r583 = r4
        r4 = 0
        r586 = r4
        r4 = 0
        r597 = r4
        r599 = r4
        r4 = 0
        r601 = r4
        r602 = r4
        r603 = r4
        r604 = r4
        r605 = r4
        r606 = r4
        r607 = r4
        r4 = 0
        r611 = r4
        r612 = r4
        r4 = 0
        r615 = r4
        r4 = 0
        r626 = r4
        r628 = r4
        r4 = 0
        r630 = r4
        r631 = r4
        r632 = r4
        r633 = r4
        r634 = r4
        r635 = r4
        r636 = r4
        r4 = 0
        r640 = r4
        r641 = r4
        r4 = 0
        r644 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r451, r452, r453, r454, r455, r456, r457, r458, r459, r460, r461, r462, r463, r464, r465, r466, r467, r468, r469, r470, r471, r472, r473, r474, r475, r476, r477, r478, r479, r480, r481, r482, r483, r484, r485, r486, r487, r488, r489, r490, r491, r492, r493, r494, r495, r496, r497, r498, r499, r500, r501, r502, r503, r504, r505, r506, r507, r508, r509, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r530, r531, r532, r533, r534, r535, r536, r537, r538, r539, r540, r541, r542, r543, r544, r545, r546, r547, r548, r549, r550, r551, r552, r553, r554, r555, r556, r557, r558, r559, r560, r561, r562, r563, r564, r565, r566, r567, r568, r569, r570, r571, r572, r573, r574, r575, r576, r577, r578, r579, r580, r581, r582, r583, r584, r585, r586, r587, r588, r589, r590, r591, r592, r593, r594, r595, r596, r597, r598, r599, r600, r601, r602, r603, r604, r605, r606, r607, r608, r609, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r630, r631, r632, r633, r634, r635, r636, r637, r638, r639, r640, r641, r642, r643, r644, r645, r646, r647, r648, r649, r650, r651, r652, r653, r654, r655, r656, r657, r658, r659, r660, r661)
        android.widget.LinearLayout r4 = r1.f10872t
        r5 = 0
        java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12793a(r4, r10)
        android.widget.ImageView r4 = r1.f10881T
        java.lang.String r5 = "/travel/rankingList"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r5)
        android.widget.FrameLayout r4 = r1.f10884W
        r662 = r4
        r5 = 0
        r663 = r5
        r5 = 2131099786(0x7f06008a, float:1.7811935E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        r664 = r4
        r4 = 0
        r665 = r4
        r4 = 0
        r667 = r4
        r668 = r4
        r4 = 1101529088(0x41a80000, float:21.0)
        r669 = r4
        r4 = 0
        r670 = r4
        r671 = r4
        r672 = r4
        r673 = r4
        r4 = 0
        r677 = r4
        r678 = r4
        r4 = 0
        r681 = r4
        r4 = 0
        r692 = r4
        r694 = r4
        r4 = 0
        r696 = r4
        r697 = r4
        r698 = r4
        r699 = r4
        r700 = r4
        r701 = r4
        r702 = r4
        r4 = 0
        r706 = r4
        r707 = r4
        r4 = 0
        r710 = r4
        r4 = 0
        r721 = r4
        r723 = r4
        r4 = 0
        r725 = r4
        r726 = r4
        r727 = r4
        r728 = r4
        r729 = r4
        r730 = r4
        r731 = r4
        r4 = 0
        r735 = r4
        r736 = r4
        r4 = 0
        r739 = r4
        r4 = 0
        r750 = r4
        r752 = r4
        r4 = 0
        r754 = r4
        r755 = r4
        r756 = r4
        r757 = r4
        r758 = r4
        r759 = r4
        r760 = r4
        r4 = 0
        r764 = r4
        r765 = r4
        r4 = 0
        r768 = r4
        r4 = 0
        r779 = r4
        r781 = r4
        r4 = 0
        r783 = r4
        r784 = r4
        r785 = r4
        r786 = r4
        r787 = r4
        r788 = r4
        r789 = r4
        r4 = 0
        r793 = r4
        r794 = r4
        r4 = 0
        r797 = r4
        r4 = 0
        r808 = r4
        r810 = r4
        r4 = 0
        r812 = r4
        r813 = r4
        r814 = r4
        r815 = r4
        r816 = r4
        r817 = r4
        r818 = r4
        r4 = 0
        r822 = r4
        r823 = r4
        r4 = 0
        r826 = r4
        r4 = 0
        r837 = r4
        r839 = r4
        r4 = 0
        r841 = r4
        r842 = r4
        r843 = r4
        r844 = r4
        r845 = r4
        r846 = r4
        r847 = r4
        r4 = 0
        r851 = r4
        r852 = r4
        r4 = 0
        r855 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r662, r663, r664, r665, r666, r667, r668, r669, r670, r671, r672, r673, r674, r675, r676, r677, r678, r679, r680, r681, r682, r683, r684, r685, r686, r687, r688, r689, r690, r691, r692, r693, r694, r695, r696, r697, r698, r699, r700, r701, r702, r703, r704, r705, r706, r707, r708, r709, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r730, r731, r732, r733, r734, r735, r736, r737, r738, r739, r740, r741, r742, r743, r744, r745, r746, r747, r748, r749, r750, r751, r752, r753, r754, r755, r756, r757, r758, r759, r760, r761, r762, r763, r764, r765, r766, r767, r768, r769, r770, r771, r772, r773, r774, r775, r776, r777, r778, r779, r780, r781, r782, r783, r784, r785, r786, r787, r788, r789, r790, r791, r792, r793, r794, r795, r796, r797, r798, r799, r800, r801, r802, r803, r804, r805, r806, r807, r808, r809, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r820, r821, r822, r823, r824, r825, r826, r827, r828, r829, r830, r831, r832, r833, r834, r835, r836, r837, r838, r839, r840, r841, r842, r843, r844, r845, r846, r847, r848, r849, r850, r851, r852, r853, r854, r855, r856, r857, r858, r859, r860, r861, r862, r863, r864, r865, r866, r867, r868, r869, r870, r871, r872)
        android.widget.TextView r4 = r1.f10886Y
        r873 = r4
        r5 = 0
        r874 = r5
        r5 = 2131099927(0x7f060117, float:1.7812221E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        r875 = r4
        r4 = 0
        r876 = r4
        r4 = 0
        r878 = r4
        r879 = r4
        r4 = 1086324736(0x40c00000, float:6.0)
        r880 = r4
        r4 = 0
        r881 = r4
        r882 = r4
        r883 = r4
        r884 = r4
        r4 = 0
        r888 = r4
        r889 = r4
        r4 = 0
        r892 = r4
        r4 = 0
        r903 = r4
        r905 = r4
        r4 = 0
        r907 = r4
        r908 = r4
        r909 = r4
        r910 = r4
        r911 = r4
        r912 = r4
        r913 = r4
        r4 = 0
        r917 = r4
        r918 = r4
        r4 = 0
        r921 = r4
        r4 = 0
        r932 = r4
        r934 = r4
        r4 = 0
        r936 = r4
        r937 = r4
        r938 = r4
        r939 = r4
        r940 = r4
        r941 = r4
        r942 = r4
        r4 = 0
        r946 = r4
        r947 = r4
        r4 = 0
        r950 = r4
        r4 = 0
        r961 = r4
        r963 = r4
        r4 = 0
        r965 = r4
        r966 = r4
        r967 = r4
        r968 = r4
        r969 = r4
        r970 = r4
        r971 = r4
        r4 = 0
        r975 = r4
        r976 = r4
        r4 = 0
        r979 = r4
        r4 = 0
        r990 = r4
        r992 = r4
        r4 = 0
        r994 = r4
        r995 = r4
        r996 = r4
        r997 = r4
        r998 = r4
        r999 = r4
        r1000 = r4
        r4 = 0
        r1004 = r4
        r1005 = r4
        r4 = 0
        r1008 = r4
        r4 = 0
        r1019 = r4
        r1021 = r4
        r4 = 0
        r1023 = r4
        r1024 = r4
        r1025 = r4
        r1026 = r4
        r1027 = r4
        r1028 = r4
        r1029 = r4
        r4 = 0
        r1033 = r4
        r1034 = r4
        r4 = 0
        r1037 = r4
        r4 = 0
        r1048 = r4
        r1050 = r4
        r4 = 0
        r1052 = r4
        r1053 = r4
        r1054 = r4
        r1055 = r4
        r1056 = r4
        r1057 = r4
        r1058 = r4
        r4 = 0
        r1062 = r4
        r1063 = r4
        r4 = 0
        r1066 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r873, r874, r875, r876, r877, r878, r879, r880, r881, r882, r883, r884, r885, r886, r887, r888, r889, r890, r891, r892, r893, r894, r895, r896, r897, r898, r899, r900, r901, r902, r903, r904, r905, r906, r907, r908, r909, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r920, r921, r922, r923, r924, r925, r926, r927, r928, r929, r930, r931, r932, r933, r934, r935, r936, r937, r938, r939, r940, r941, r942, r943, r944, r945, r946, r947, r948, r949, r950, r951, r952, r953, r954, r955, r956, r957, r958, r959, r960, r961, r962, r963, r964, r965, r966, r967, r968, r969, r970, r971, r972, r973, r974, r975, r976, r977, r978, r979, r980, r981, r982, r983, r984, r985, r986, r987, r988, r989, r990, r991, r992, r993, r994, r995, r996, r997, r998, r999, r1000, r1001, r1002, r1003, r1004, r1005, r1006, r1007, r1008, r1009, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r1019, r1020, r1021, r1022, r1023, r1024, r1025, r1026, r1027, r1028, r1029, r1030, r1031, r1032, r1033, r1034, r1035, r1036, r1037, r1038, r1039, r1040, r1041, r1042, r1043, r1044, r1045, r1046, r1047, r1048, r1049, r1050, r1051, r1052, r1053, r1054, r1055, r1056, r1057, r1058, r1059, r1060, r1061, r1062, r1063, r1064, r1065, r1066, r1067, r1068, r1069, r1070, r1071, r1072, r1073, r1074, r1075, r1076, r1077, r1078, r1079, r1080, r1081, r1082, r1083)
        android.widget.LinearLayout r4 = r1.f10887Z
        r1084 = r4
        r4 = 0
        r1085 = r4
        r4 = 2014581779(0x78141413, float:1.2013548E34)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        r1086 = r4
        r4 = 0
        r1087 = r4
        r4 = 0
        r1089 = r4
        r1090 = r4
        r4 = 1077936128(0x40400000, float:3.0)
        r1091 = r4
        r4 = 0
        r1092 = r4
        r1093 = r4
        r1094 = r4
        r1095 = r4
        r4 = 0
        r1099 = r4
        r1100 = r4
        r4 = 0
        r1103 = r4
        r4 = 0
        r1114 = r4
        r1116 = r4
        r4 = 0
        r1118 = r4
        r1119 = r4
        r1120 = r4
        r1121 = r4
        r1122 = r4
        r1123 = r4
        r1124 = r4
        r4 = 0
        r1128 = r4
        r1129 = r4
        r4 = 0
        r1132 = r4
        r4 = 0
        r1143 = r4
        r1145 = r4
        r4 = 0
        r1147 = r4
        r1148 = r4
        r1149 = r4
        r1150 = r4
        r1151 = r4
        r1152 = r4
        r1153 = r4
        r4 = 0
        r1157 = r4
        r1158 = r4
        r4 = 0
        r1161 = r4
        r4 = 0
        r1172 = r4
        r1174 = r4
        r4 = 0
        r1176 = r4
        r1177 = r4
        r1178 = r4
        r1179 = r4
        r1180 = r4
        r1181 = r4
        r1182 = r4
        r4 = 0
        r1186 = r4
        r1187 = r4
        r4 = 0
        r1190 = r4
        r4 = 0
        r1201 = r4
        r1203 = r4
        r4 = 0
        r1205 = r4
        r1206 = r4
        r1207 = r4
        r1208 = r4
        r1209 = r4
        r1210 = r4
        r1211 = r4
        r4 = 0
        r1215 = r4
        r1216 = r4
        r4 = 0
        r1219 = r4
        r4 = 0
        r1230 = r4
        r1232 = r4
        r4 = 0
        r1234 = r4
        r1235 = r4
        r1236 = r4
        r1237 = r4
        r1238 = r4
        r1239 = r4
        r1240 = r4
        r4 = 0
        r1244 = r4
        r1245 = r4
        r4 = 0
        r1248 = r4
        r4 = 0
        r1259 = r4
        r1261 = r4
        r4 = 0
        r1263 = r4
        r1264 = r4
        r1265 = r4
        r1266 = r4
        r1267 = r4
        r1268 = r4
        r1269 = r4
        r4 = 0
        r1273 = r4
        r1274 = r4
        r4 = 0
        r1277 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r1084, r1085, r1086, r1087, r1088, r1089, r1090, r1091, r1092, r1093, r1094, r1095, r1096, r1097, r1098, r1099, r1100, r1101, r1102, r1103, r1104, r1105, r1106, r1107, r1108, r1109, r1110, r1111, r1112, r1113, r1114, r1115, r1116, r1117, r1118, r1119, r1120, r1121, r1122, r1123, r1124, r1125, r1126, r1127, r1128, r1129, r1130, r1131, r1132, r1133, r1134, r1135, r1136, r1137, r1138, r1139, r1140, r1141, r1142, r1143, r1144, r1145, r1146, r1147, r1148, r1149, r1150, r1151, r1152, r1153, r1154, r1155, r1156, r1157, r1158, r1159, r1160, r1161, r1162, r1163, r1164, r1165, r1166, r1167, r1168, r1169, r1170, r1171, r1172, r1173, r1174, r1175, r1176, r1177, r1178, r1179, r1180, r1181, r1182, r1183, r1184, r1185, r1186, r1187, r1188, r1189, r1190, r1191, r1192, r1193, r1194, r1195, r1196, r1197, r1198, r1199, r1200, r1201, r1202, r1203, r1204, r1205, r1206, r1207, r1208, r1209, r1210, r1211, r1212, r1213, r1214, r1215, r1216, r1217, r1218, r1219, r1220, r1221, r1222, r1223, r1224, r1225, r1226, r1227, r1228, r1229, r1230, r1231, r1232, r1233, r1234, r1235, r1236, r1237, r1238, r1239, r1240, r1241, r1242, r1243, r1244, r1245, r1246, r1247, r1248, r1249, r1250, r1251, r1252, r1253, r1254, r1255, r1256, r1257, r1258, r1259, r1260, r1261, r1262, r1263, r1264, r1265, r1266, r1267, r1268, r1269, r1270, r1271, r1272, r1273, r1274, r1275, r1276, r1277, r1278, r1279, r1280, r1281, r1282, r1283, r1284, r1285, r1286, r1287, r1288, r1289, r1290, r1291, r1292, r1293, r1294)
        android.widget.TextView r4 = r1.f10888aa
        java.lang.String r5 = "/me/map"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r5)
        com.jiayouya.travel.common.widget.RndCornerProgressBar r4 = r1.f10838C
        java.lang.String r5 = "/me/map"
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r5)
        com.jiayouya.travel.common.widget.RndCornerProgressBar r4 = r1.f10838C
        r1295 = r4
        r4 = 0
        r1296 = r4
        com.jiayouya.travel.common.widget.RndCornerProgressBar r4 = r1.f10838C
        r5 = 2131099927(0x7f060117, float:1.7812221E38)
        int r4 = getColorFromResource(r4, r5)
        java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        r1297 = r4
        r4 = 0
        r1298 = r4
        r4 = 0
        r1300 = r4
        r1301 = r4
        r4 = 1077936128(0x40400000, float:3.0)
        r1302 = r4
        r4 = 0
        r1303 = r4
        r1304 = r4
        r1305 = r4
        r1306 = r4
        r4 = 0
        r1310 = r4
        r1311 = r4
        r4 = 0
        r1314 = r4
        r4 = 0
        r1325 = r4
        r1327 = r4
        r4 = 0
        r1329 = r4
        r1330 = r4
        r1331 = r4
        r1332 = r4
        r1333 = r4
        r1334 = r4
        r1335 = r4
        r4 = 0
        r1339 = r4
        r1340 = r4
        r4 = 0
        r1343 = r4
        r4 = 0
        r1354 = r4
        r1356 = r4
        r4 = 0
        r1358 = r4
        r1359 = r4
        r1360 = r4
        r1361 = r4
        r1362 = r4
        r1363 = r4
        r1364 = r4
        r4 = 0
        r1368 = r4
        r1369 = r4
        r4 = 0
        r1372 = r4
        r4 = 0
        r1383 = r4
        r1385 = r4
        r4 = 0
        r1387 = r4
        r1388 = r4
        r1389 = r4
        r1390 = r4
        r1391 = r4
        r1392 = r4
        r1393 = r4
        r4 = 0
        r1397 = r4
        r1398 = r4
        r4 = 0
        r1401 = r4
        r4 = 0
        r1412 = r4
        r1414 = r4
        r4 = 0
        r1416 = r4
        r1417 = r4
        r1418 = r4
        r1419 = r4
        r1420 = r4
        r1421 = r4
        r1422 = r4
        r4 = 0
        r1426 = r4
        r1427 = r4
        r4 = 0
        r1430 = r4
        r4 = 0
        r1441 = r4
        r1443 = r4
        r4 = 0
        r1445 = r4
        r1446 = r4
        r1447 = r4
        r1448 = r4
        r1449 = r4
        r1450 = r4
        r1451 = r4
        r4 = 0
        r1455 = r4
        r1456 = r4
        r4 = 0
        r1459 = r4
        r4 = 0
        r1470 = r4
        r1472 = r4
        r4 = 0
        r1474 = r4
        r1475 = r4
        r1476 = r4
        r1477 = r4
        r1478 = r4
        r1479 = r4
        r1480 = r4
        r4 = 0
        r1484 = r4
        r1485 = r4
        r4 = 0
        r1488 = r4
        tech.linjiang.android.drawable.Drawables.m37723a(r1295, r1296, r1297, r1298, r1299, r1300, r1301, r1302, r1303, r1304, r1305, r1306, r1307, r1308, r1309, r1310, r1311, r1312, r1313, r1314, r1315, r1316, r1317, r1318, r1319, r1320, r1321, r1322, r1323, r1324, r1325, r1326, r1327, r1328, r1329, r1330, r1331, r1332, r1333, r1334, r1335, r1336, r1337, r1338, r1339, r1340, r1341, r1342, r1343, r1344, r1345, r1346, r1347, r1348, r1349, r1350, r1351, r1352, r1353, r1354, r1355, r1356, r1357, r1358, r1359, r1360, r1361, r1362, r1363, r1364, r1365, r1366, r1367, r1368, r1369, r1370, r1371, r1372, r1373, r1374, r1375, r1376, r1377, r1378, r1379, r1380, r1381, r1382, r1383, r1384, r1385, r1386, r1387, r1388, r1389, r1390, r1391, r1392, r1393, r1394, r1395, r1396, r1397, r1398, r1399, r1400, r1401, r1402, r1403, r1404, r1405, r1406, r1407, r1408, r1409, r1410, r1411, r1412, r1413, r1414, r1415, r1416, r1417, r1418, r1419, r1420, r1421, r1422, r1423, r1424, r1425, r1426, r1427, r1428, r1429, r1430, r1431, r1432, r1433, r1434, r1435, r1436, r1437, r1438, r1439, r1440, r1441, r1442, r1443, r1444, r1445, r1446, r1447, r1448, r1449, r1450, r1451, r1452, r1453, r1454, r1455, r1456, r1457, r1458, r1459, r1460, r1461, r1462, r1463, r1464, r1465, r1466, r1467, r1468, r1469, r1470, r1471, r1472, r1473, r1474, r1475, r1476, r1477, r1478, r1479, r1480, r1481, r1482, r1483, r1484, r1485, r1486, r1487, r1488, r1489, r1490, r1491, r1492, r1493, r1494, r1495, r1496, r1497, r1498, r1499, r1500, r1501, r1502, r1503, r1504, r1505)
        goto L_0x12b2
    L_0x12b0:
        r29 = r10
    L_0x12b2:
        long r4 = r2 & r20
        r20 = 0
        int r10 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
        if (r10 == 0) goto L_0x12d9
        com.jiayouya.travel.common.widget.countdownview.CountdownView r4 = r1.f10860h
        java.lang.Long r5 = java.lang.Long.valueOf(r7)
        java.lang.Boolean r7 = java.lang.Boolean.valueOf(r11)
        com.jiayouya.travel.common.p243a.CustomAdapter.m12778a(r4, r5, r7, r15)
        android.widget.LinearLayout r4 = r1.f10869q
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r22)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r4, r5)
        android.widget.LinearLayout r4 = r1.f10887Z
        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r22)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r4, r5)
    L_0x12d9:
        r4 = 33
        long r4 = r4 & r2
        r7 = 0
        int r10 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
        if (r10 == 0) goto L_0x12f5
        android.widget.ImageView r4 = r1.f10882U
        com.jiayouya.travel.common.p243a.ViewAdapter.m12794a(r4, r12)
        android.widget.TextView r4 = r1.f10883V
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r4, r0)
        android.view.View r0 = r1.f10839D
        java.lang.Boolean r4 = java.lang.Boolean.valueOf(r13)
        com.jiayouya.travel.common.p243a.ViewAdapter.m12798c(r0, r4)
    L_0x12f5:
        long r4 = r2 & r17
        r7 = 0
        int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
        if (r0 == 0) goto L_0x1314
        android.widget.ImageView r0 = r1.f10885X
        java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
        r5 = r16
        jp.wasabeef.glide.transformations.RoundedCornersTransformation$CornerType r5 = (p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType) r5
        r7 = r16
        java.lang.Integer r7 = (java.lang.Integer) r7
        r8 = 0
        com.jiayouya.travel.common.p243a.ImageAdapter.m12781a(r0, r4, r8, r5, r7)
        android.widget.TextView r0 = r1.f10886Y
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r6)
    L_0x1314:
        long r2 = r2 & r23
        r4 = 0
        int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
        if (r0 == 0) goto L_0x1321
        android.widget.TextView r0 = r1.f10888aa
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r9)
    L_0x1321:
        if (r28 == 0) goto L_0x132a
        android.widget.TextView r0 = r1.f10845J
        r10 = r29
        androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r10)
    L_0x132a:
        return
    L_0x132b:
        r0 = move-exception
        monitor-exit(r1)     // Catch:{ all -> 0x132b }
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jiayouya.travel.databinding.FragmentTravelBindingImpl.executeBindings():void");
    }
}
