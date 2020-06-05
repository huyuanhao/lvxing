package com.p530ss.android.downloadlib.p541a;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.p530ss.android.downloadlib.p549e.C6587g;
import com.p530ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.p530ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.p530ss.android.socialbase.downloader.p564i.NetworkQuality;
import com.p530ss.android.socialbase.downloader.p567k.DownloadSetting;
import com.tencent.mid.sotrage.StorageInterface;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.a.e */
public class ChunkCalculatorFactory {
    /* renamed from: a */
    private static C6555b f21346a;

    /* compiled from: ChunkCalculatorFactory */
    /* renamed from: com.ss.android.downloadlib.a.e$1 */
    static /* synthetic */ class C65531 {
        /* renamed from: a */
        static final /* synthetic */ int[] f21347a = new int[NetworkQuality.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
     */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
            com.ss.android.socialbase.downloader.i.h[] r0 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.values()
            int r0 = r0.length
            int[] r0 = new int[r0]
            f21347a = r0
            int[] r0 = f21347a     // Catch:{ NoSuchFieldError -> 0x0014 }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.POOR     // Catch:{ NoSuchFieldError -> 0x0014 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            int[] r0 = f21347a     // Catch:{ NoSuchFieldError -> 0x001f }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.MODERATE     // Catch:{ NoSuchFieldError -> 0x001f }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            int[] r0 = f21347a     // Catch:{ NoSuchFieldError -> 0x002a }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.GOOD     // Catch:{ NoSuchFieldError -> 0x002a }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            int[] r0 = f21347a     // Catch:{ NoSuchFieldError -> 0x0035 }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.EXCELLENT     // Catch:{ NoSuchFieldError -> 0x0035 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            int[] r0 = f21347a     // Catch:{ NoSuchFieldError -> 0x0040 }
            com.ss.android.socialbase.downloader.i.h r1 = com.p530ss.android.socialbase.downloader.p564i.NetworkQuality.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0040 }
            int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5
            r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p530ss.android.downloadlib.p541a.ChunkCalculatorFactory.C65531.m51274clinit():void");
        }
    }

    /* compiled from: ChunkCalculatorFactory */
    /* renamed from: com.ss.android.downloadlib.a.e$a */
    static class C6554a implements IChunkCntCalculator {
        /* renamed from: a */
        private final String f21348a;
        /* renamed from: b */
        private C6555b f21349b;

        public C6554a(C6555b bVar, String str) {
            this.f21349b = bVar;
            this.f21348a = str;
        }

        /* renamed from: a */
        public int mo31302a(long j) {
            if (C6587g.m26536c(this.f21348a)) {
                C6555b bVar = this.f21349b;
                if (bVar != null) {
                    return bVar.mo31302a(j);
                }
            }
            return 1;
        }
    }

    /* compiled from: ChunkCalculatorFactory */
    /* renamed from: com.ss.android.downloadlib.a.e$b */
    static class C6555b implements IChunkCntCalculator {
        /* renamed from: a */
        private int f21350a;
        /* renamed from: b */
        private ArrayList<int[]> f21351b = new ArrayList<>();

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public boolean mo31304b(long j) {
            return true;
        }

        public C6555b(JSONObject jSONObject) {
            m26236a(jSONObject);
        }

        /* renamed from: a */
        private void m26236a(JSONObject jSONObject) {
            this.f21350a = jSONObject.optInt("is_open_exp", 0);
            m26237b(jSONObject);
        }

        /* renamed from: a */
        public int mo31302a(long j) {
            if (!mo31303a() || !mo31304b(j)) {
                return 1;
            }
            return m26235a((int) (j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
        }

        /* renamed from: a */
        public boolean mo31303a() {
            int i = this.f21350a;
            return i == 1 || i == 3;
        }

        /* renamed from: b */
        private void m26237b(JSONObject jSONObject) {
            if (jSONObject != null) {
                String str = "download_chunk_config";
                if (jSONObject.has(str)) {
                    String obj = jSONObject.opt(str).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        JSONObject jSONObject2 = null;
                        try {
                            jSONObject2 = new JSONObject(obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (jSONObject2 != null) {
                            String[] strArr = new String[5];
                            String[][] strArr2 = new String[5][];
                            strArr[1] = jSONObject2.optString("download_chunk_1");
                            strArr[2] = jSONObject2.optString("download_chunk_2");
                            strArr[3] = jSONObject2.optString("download_chunk_3");
                            strArr[4] = jSONObject2.optString("download_chunk_4");
                            for (int i = 1; i < 5; i++) {
                                if (!TextUtils.isEmpty(strArr[i])) {
                                    strArr2[i] = strArr[i].split(StorageInterface.KEY_SPLITER);
                                    for (int i2 = 0; i2 < strArr2[i].length - 1; i2 += 2) {
                                        this.f21351b.add(new int[]{i, Integer.parseInt(strArr2[i][i2]), Integer.parseInt(strArr2[i][i2 + 1])});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        private int m26235a(int i) {
            for (int i2 = 0; i2 < this.f21351b.size(); i2++) {
                int[] iArr = (int[]) this.f21351b.get(i2);
                if (i >= iArr[1] && i < iArr[2]) {
                    return iArr[0];
                }
            }
            return 1;
        }
    }

    /* compiled from: ChunkCalculatorFactory */
    /* renamed from: com.ss.android.downloadlib.a.e$c */
    static class C6556c implements IChunkAdjustCalculator {
        /* renamed from: a */
        private int f21352a;
        /* renamed from: b */
        private ArrayList<int[]> f21353b = new ArrayList<>();

        public C6556c(JSONObject jSONObject) {
            m26241a(jSONObject);
        }

        /* renamed from: a */
        private void m26241a(JSONObject jSONObject) {
            this.f21352a = jSONObject.optInt("is_open_exp", 0);
            m26243b(jSONObject);
        }

        /* renamed from: b */
        private void m26243b(JSONObject jSONObject) {
            if (jSONObject != null) {
                String str = "download_chunk_config";
                if (jSONObject.has(str)) {
                    String obj = jSONObject.opt(str).toString();
                    if (!TextUtils.isEmpty(obj)) {
                        JSONObject jSONObject2 = null;
                        try {
                            jSONObject2 = new JSONObject(obj);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (jSONObject2 != null) {
                            String optString = jSONObject2.optString("network_quality_operation");
                            String optString2 = jSONObject2.optString("network_quality_operand");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                String str2 = StorageInterface.KEY_SPLITER;
                                String[] split = optString.split(str2);
                                String[] split2 = optString2.split(str2);
                                if (split.length >= 5 && split2.length >= 5) {
                                    for (int i = 0; i < 5; i++) {
                                        this.f21353b.add(new int[]{Integer.parseInt(split[i]), Integer.parseInt(split2[i])});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public int mo31305a(int i, NetworkQuality hVar) {
            return mo31306a() ? m26242b(i, hVar) : i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo31306a() {
            int i = this.f21352a;
            return i == 2 || i == 3;
        }

        /* renamed from: b */
        private int m26242b(int i, NetworkQuality hVar) {
            if (this.f21353b.size() < 5) {
                return i;
            }
            int[] iArr = null;
            int i2 = C65531.f21347a[hVar.ordinal()];
            if (i2 == 1) {
                iArr = (int[]) this.f21353b.get(0);
            } else if (i2 == 2) {
                iArr = (int[]) this.f21353b.get(1);
            } else if (i2 == 3) {
                iArr = (int[]) this.f21353b.get(2);
            } else if (i2 == 4) {
                iArr = (int[]) this.f21353b.get(3);
            } else if (i2 == 5) {
                iArr = (int[]) this.f21353b.get(4);
            }
            if (iArr != null && iArr.length >= 2) {
                int i3 = iArr[0];
                if (i3 == 1) {
                    i += iArr[1];
                } else if (i3 == 2) {
                    i -= iArr[1];
                } else if (i3 == 3) {
                    i = iArr[1];
                }
                if (i <= 1) {
                    i = 1;
                }
            }
            return i;
        }
    }

    /* renamed from: a */
    public static IChunkCntCalculator m26230a(String str) {
        if (f21346a == null) {
            f21346a = new C6555b(C6565j.m26375i());
        }
        return new C6554a(f21346a, str);
    }

    /* renamed from: a */
    public static IChunkCntCalculator m26231a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String str2 = "download_chunk_config";
            if (jSONObject.has(str2) && !DownloadSetting.m28621f(str2)) {
                return m26232b(jSONObject);
            }
        }
        return m26230a(str);
    }

    /* renamed from: a */
    public static IChunkAdjustCalculator m26229a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String str = "download_chunk_config";
            if (jSONObject.has(str) && !DownloadSetting.m28621f(str)) {
                return m26233c(jSONObject);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static IChunkCntCalculator m26232b(JSONObject jSONObject) {
        return new C6555b(jSONObject);
    }

    /* renamed from: c */
    public static IChunkAdjustCalculator m26233c(JSONObject jSONObject) {
        return new C6556c(jSONObject);
    }
}
