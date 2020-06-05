package shanhuAD;

import android.util.SparseArray;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.p605ep.shanhuad.adpublic.models.AdID;
import com.tencent.qqpim.discovery.AdRequestData;
import epco.C7990p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: shanhuAD.f */
public class C8680f {
    /* renamed from: Ek */
    public static final int f29536Ek = 1;
    /* renamed from: Fk */
    public static final int f29537Fk = 2;
    /* renamed from: Gk */
    public static final int f29538Gk = 3;
    /* renamed from: Hk */
    public static final int f29539Hk = 4;
    /* renamed from: Ik */
    public static final int f29540Ik = 5;
    /* renamed from: Jk */
    public static final int f29541Jk = 6;
    /* renamed from: Kk */
    public static final int f29542Kk = 7;
    /* renamed from: Lk */
    public static final int f29543Lk = 8;
    /* renamed from: Mk */
    public static final int f29544Mk = 9;
    /* renamed from: Nk */
    private static SparseArray<ArrayList<Integer>> f29545Nk = new SparseArray<>();

    static {
        f29545Nk.append(1, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(294), Integer.valueOf(TinkerReport.KEY_LOADED_MISSING_RES)})));
        f29545Nk.append(2, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(TinkerReport.KEY_LOADED_INFO_CORRUPTED)})));
        f29545Nk.append(3, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(295), Integer.valueOf(300), Integer.valueOf(301), Integer.valueOf(302), Integer.valueOf(303), Integer.valueOf(305)})));
        f29545Nk.append(4, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(296)})));
        f29545Nk.append(5, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(297), Integer.valueOf(298), Integer.valueOf(299), Integer.valueOf(312)})));
        f29545Nk.append(6, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(TinkerReport.KEY_LOADED_MISSING_PATCH_INFO), Integer.valueOf(307)})));
        f29545Nk.append(7, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(310), Integer.valueOf(311)})));
        f29545Nk.append(8, new ArrayList());
        f29545Nk.append(9, new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(C7990p.f27143h)})));
    }

    /* renamed from: a */
    public static ArrayList<AdRequestData> m37692a(AdID adID, int i, int i2) {
        ArrayList arrayList = (ArrayList) f29545Nk.get(i);
        Integer[] numArr = adID.styleArray;
        if (numArr != null) {
            arrayList = new ArrayList(Arrays.asList(numArr));
        }
        ArrayList<AdRequestData> arrayList2 = new ArrayList<>();
        arrayList2.add(m37691a(adID.posID, i2, arrayList, adID.width, adID.height));
        return arrayList2;
    }

    /* renamed from: b */
    public static ArrayList<AdRequestData> m37693b(List<AdID> list, int i, int i2) {
        ArrayList<AdRequestData> arrayList = new ArrayList<>();
        for (AdID a : list) {
            arrayList.addAll(m37692a(a, i, i2));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static AdRequestData m37691a(int i, int i2, ArrayList<Integer> arrayList, int i3, int i4) {
        AdRequestData adRequestData = new AdRequestData();
        adRequestData.positionId = i;
        adRequestData.advNum = i2;
        adRequestData.positionFormatTypes = arrayList;
        adRequestData.pos_width = i3;
        adRequestData.pos_height = i4;
        return adRequestData;
    }
}
