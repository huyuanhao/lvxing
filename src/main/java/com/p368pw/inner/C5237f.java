package com.p368pw.inner;

import android.content.Context;
import android.text.TextUtils;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5206p;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.p369a.C4875b;
import com.p368pw.inner.p369a.C4966f;
import com.p368pw.inner.p369a.p379e.C4932d;
import com.tencent.mid.sotrage.StorageInterface;
import com.tmsdk.module.coin.CoinTask;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: com.pw.inner.f */
public class C5237f {
    /* renamed from: a */
    public static String m21568a(Context context) {
        return C5206p.m21472b(context, "wg_cg");
    }

    /* renamed from: a */
    public static String m21569a(Context context, int i) {
        return C5206p.m21472b(context, String.format("%s_%s", new Object[]{"wg_r_s_a_t", String.valueOf(i)}));
    }

    /* renamed from: a */
    public static String m21570a(Context context, C4932d dVar) {
        return C5206p.m21472b(context, dVar.mo26136d());
    }

    /* renamed from: a */
    public static void m21571a(Context context, int i, String str) {
        C5206p.m21471a(context, String.format("%s_%s", new Object[]{"wg_r_s_a_t", String.valueOf(i)}), str);
    }

    /* renamed from: a */
    public static void m21572a(Context context, long j) {
        C5206p.m21470a(context, "wg_cd", j);
    }

    /* renamed from: a */
    public static void m21573a(Context context, long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("wg_rb_");
        sb.append(str);
        C5206p.m21470a(context, sb.toString(), j);
    }

    /* renamed from: a */
    public static void m21574a(Context context, C4875b bVar) {
        if (bVar != null && bVar.mo25894a() != null && bVar.mo25894a().size() != 0) {
            StringBuilder sb = new StringBuilder();
            Iterator it = bVar.mo25894a().iterator();
            while (it.hasNext()) {
                sb.append(((C4966f) it.next()).mo26292a());
                sb.append(StorageInterface.KEY_SPLITER);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            m21599i(context, sb.toString());
        }
    }

    /* renamed from: a */
    public static void m21575a(Context context, C4932d dVar, CoinTask coinTask) {
        C5206p.m21471a(context, dVar.mo26136d(), C5204n.m21460a(coinTask));
    }

    /* renamed from: a */
    public static void m21576a(Context context, String str) {
        if (!m21568a(context).equals(str)) {
            C5206p.m21471a(context, "wg_cg", str);
        }
    }

    /* renamed from: a */
    public static void m21577a(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("wg_rs_");
        sb.append(str2);
        C5206p.m21471a(context, sb.toString(), str);
    }

    /* renamed from: b */
    public static String m21578b(Context context) {
        return C5206p.m21472b(context, "wg_cf");
    }

    /* renamed from: b */
    public static void m21579b(Context context, long j) {
        C5206p.m21470a(context, "wg_ca", j);
    }

    /* renamed from: b */
    public static void m21580b(Context context, C4932d dVar) {
        C5206p.m21473c(context, dVar.mo26136d());
    }

    /* renamed from: b */
    public static void m21581b(Context context, String str) {
        if (!m21578b(context).equals(str)) {
            C5206p.m21471a(context, "wg_cf", str);
        }
    }

    /* renamed from: b */
    public static void m21582b(Context context, String str, String str2) {
        C5206p.m21471a(context, String.format("%s_%s", new Object[]{"wg_r_s_pl", str}), str2);
    }

    /* renamed from: c */
    public static String m21583c(Context context) {
        return C5206p.m21472b(context, "wg_ct");
    }

    /* renamed from: c */
    public static void m21584c(Context context, long j) {
        C5206p.m21470a(context, "wg_up_sh", j);
    }

    /* renamed from: c */
    public static void m21585c(Context context, String str) {
        C5206p.m21471a(context, "wg_ct", str);
    }

    /* renamed from: c */
    public static void m21586c(Context context, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("wg_tx_v_d_c");
        C5206p.m21471a(context, sb.toString(), str2);
    }

    /* renamed from: d */
    public static long m21587d(Context context) {
        return C5206p.m21468a(context, "wg_cd");
    }

    /* renamed from: d */
    public static void m21588d(Context context, long j) {
        C5206p.m21470a(context, "tx_file_rep_date", j);
    }

    /* renamed from: d */
    public static void m21589d(Context context, String str) {
        C5206p.m21471a(context, "wg_ot", str);
    }

    /* renamed from: e */
    public static long m21590e(Context context) {
        return C5206p.m21468a(context, "wg_ca");
    }

    /* renamed from: e */
    public static String m21591e(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("wg_rs_");
        sb.append(str);
        return C5206p.m21472b(context, sb.toString());
    }

    /* renamed from: f */
    public static long m21592f(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("wg_rb_");
        sb.append(str);
        return C5206p.m21468a(context, sb.toString());
    }

    /* renamed from: f */
    public static String m21593f(Context context) {
        String str = "wg_cs";
        String b = C5206p.m21472b(context, str);
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String uuid = UUID.randomUUID().toString();
        C5206p.m21471a(context, str, uuid);
        return uuid;
    }

    /* renamed from: g */
    public static String m21594g(Context context) {
        return C5206p.m21472b(context, "wg_r_s_p");
    }

    /* renamed from: g */
    public static void m21595g(Context context, String str) {
        C5206p.m21471a(context, "wg_r_s_p", str);
    }

    /* renamed from: h */
    public static String m21596h(Context context) {
        return C5206p.m21472b(context, "wg_r_v_p");
    }

    /* renamed from: h */
    public static String m21597h(Context context, String str) {
        return C5206p.m21472b(context, String.format("%s_%s", new Object[]{"wg_r_s_pl", str}));
    }

    /* renamed from: i */
    public static long m21598i(Context context) {
        return C5206p.m21468a(context, "wg_up_sh");
    }

    /* renamed from: i */
    public static void m21599i(Context context, String str) {
        C5206p.m21471a(context, "wg_r_v_p", str);
    }

    /* renamed from: j */
    public static long m21600j(Context context) {
        return C5206p.m21468a(context, "tx_file_rep_date");
    }

    /* renamed from: j */
    public static String m21601j(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("wg_tx_v_d_c");
        return C5206p.m21472b(context, sb.toString());
    }

    /* renamed from: k */
    public static void m21602k(Context context, String str) {
        if (!C5207q.m21476a((CharSequence) str)) {
            C5206p.m21471a(context, "tx_pl_aw", str);
        }
    }
}
