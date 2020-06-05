package com.jiayouya.travel.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jiayouya.travel.R;
import com.jiayouya.travel.common.p243a.CustomAdapter;
import com.jiayouya.travel.common.p243a.ImageAdapter;
import com.jiayouya.travel.common.p243a.RndAdapter;
import com.jiayouya.travel.common.p243a.TextViewAdapter;
import com.jiayouya.travel.common.p243a.ViewAdapter;
import com.jiayouya.travel.module.group.data.Channel;
import com.jiayouya.travel.module.group.data.GroupIndexRsp;
import com.jiayouya.travel.module.group.data.GroupIndexRspKt;
import com.jiayouya.travel.module.group.data.Parent;
import ezy.p653ui.widget.round.RoundText;
import java.util.List;
import p641de.hdodenhof.circleimageview.CircleImageView;
import p672jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public class FragmentTourGroupBindingImpl extends FragmentTourGroupBinding {
    /* renamed from: r */
    private static final IncludedLayouts f10806r = null;
    /* renamed from: s */
    private static final SparseIntArray f10807s = new SparseIntArray();
    /* renamed from: A */
    private final TextView f10808A;
    /* renamed from: B */
    private final TextView f10809B;
    /* renamed from: C */
    private final TextView f10810C;
    /* renamed from: D */
    private final TextView f10811D;
    /* renamed from: E */
    private final TextView f10812E;
    /* renamed from: F */
    private final RoundText f10813F;
    /* renamed from: G */
    private final LinearLayout f10814G;
    /* renamed from: H */
    private final TextView f10815H;
    /* renamed from: I */
    private final LinearLayout f10816I;
    /* renamed from: J */
    private final CircleImageView f10817J;
    /* renamed from: K */
    private final TextView f10818K;
    /* renamed from: L */
    private final TextView f10819L;
    /* renamed from: M */
    private final LinearLayout f10820M;
    /* renamed from: N */
    private final CircleImageView f10821N;
    /* renamed from: O */
    private final CircleImageView f10822O;
    /* renamed from: P */
    private final TextView f10823P;
    /* renamed from: Q */
    private final TextView f10824Q;
    /* renamed from: R */
    private final CircleImageView f10825R;
    /* renamed from: S */
    private final CircleImageView f10826S;
    /* renamed from: T */
    private final LinearLayout f10827T;
    /* renamed from: U */
    private long f10828U;
    /* renamed from: t */
    private final FrameLayout f10829t;
    /* renamed from: u */
    private final LinearLayout f10830u;
    /* renamed from: v */
    private final TextView f10831v;
    /* renamed from: w */
    private final TextView f10832w;
    /* renamed from: x */
    private final TextView f10833x;
    /* renamed from: y */
    private final TextView f10834y;
    /* renamed from: z */
    private final LinearLayout f10835z;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        f10807s.put(R.id.refresh, 33);
        f10807s.put(R.id.status_view, 34);
        f10807s.put(R.id.tv_title1, 35);
        f10807s.put(R.id.tv_title2, 36);
        f10807s.put(R.id.lyt_persons, 37);
        f10807s.put(R.id.space, 38);
        f10807s.put(R.id.tv_total_profit, 39);
        f10807s.put(R.id.tv_channel_explain, 40);
        f10807s.put(R.id.tv_contact_inviter, 41);
        f10807s.put(R.id.tv_contact_star, 42);
    }

    public FragmentTourGroupBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 43, f10806r, f10807s));
    }

    private FragmentTourGroupBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[6], objArr[23], objArr[37], objArr[14], objArr[33], objArr[38], objArr[34], objArr[40], objArr[41], objArr[42], objArr[7], objArr[8], objArr[13], objArr[35], objArr[36], objArr[39]);
        this.f10828U = -1;
        this.f10789a.setTag(null);
        this.f10790b.setTag(null);
        this.f10829t = objArr[0];
        this.f10829t.setTag(null);
        this.f10830u = objArr[1];
        this.f10830u.setTag(null);
        this.f10831v = objArr[10];
        this.f10831v.setTag(null);
        this.f10832w = objArr[11];
        this.f10832w.setTag(null);
        this.f10833x = objArr[12];
        this.f10833x.setTag(null);
        this.f10834y = objArr[15];
        this.f10834y.setTag(null);
        this.f10835z = objArr[16];
        this.f10835z.setTag(null);
        this.f10808A = objArr[17];
        this.f10808A.setTag(null);
        this.f10809B = objArr[18];
        this.f10809B.setTag(null);
        this.f10810C = objArr[19];
        this.f10810C.setTag(null);
        this.f10811D = objArr[2];
        this.f10811D.setTag(null);
        this.f10812E = objArr[20];
        this.f10812E.setTag(null);
        this.f10813F = objArr[21];
        this.f10813F.setTag(null);
        this.f10814G = objArr[22];
        this.f10814G.setTag(null);
        this.f10815H = objArr[24];
        this.f10815H.setTag(null);
        this.f10816I = objArr[25];
        this.f10816I.setTag(null);
        this.f10817J = objArr[26];
        this.f10817J.setTag(null);
        this.f10818K = objArr[27];
        this.f10818K.setTag(null);
        this.f10819L = objArr[28];
        this.f10819L.setTag(null);
        this.f10820M = objArr[29];
        this.f10820M.setTag(null);
        this.f10821N = objArr[3];
        this.f10821N.setTag(null);
        this.f10822O = objArr[30];
        this.f10822O.setTag(null);
        this.f10823P = objArr[31];
        this.f10823P.setTag(null);
        this.f10824Q = objArr[32];
        this.f10824Q.setTag(null);
        this.f10825R = objArr[4];
        this.f10825R.setTag(null);
        this.f10826S = objArr[5];
        this.f10826S.setTag(null);
        this.f10827T = objArr[9];
        this.f10827T.setTag(null);
        this.f10792d.setTag(null);
        this.f10799k.setTag(null);
        this.f10800l.setTag(null);
        this.f10801m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.f10828U = 2;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10828U != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (19 != i) {
            return false;
        }
        mo20154a((GroupIndexRsp) obj);
        return true;
    }

    /* renamed from: a */
    public void mo20154a(GroupIndexRsp groupIndexRsp) {
        this.f10805q = groupIndexRsp;
        synchronized (this) {
            this.f10828U |= 1;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        String str2;
        CharSequence charSequence;
        boolean z;
        boolean z2;
        boolean z3;
        long j2;
        CharSequence charSequence2;
        float f;
        CharSequence charSequence3;
        boolean z4;
        String str3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        String str4;
        CharSequence charSequence6;
        String str5;
        boolean z5;
        String str6;
        CharSequence charSequence7;
        boolean z6;
        String str7;
        CharSequence charSequence8;
        CharSequence charSequence9;
        String str8;
        int i;
        CharSequence charSequence10;
        boolean z7;
        CharSequence charSequence11;
        CharSequence charSequence12;
        CharSequence charSequence13;
        int i2;
        String str9;
        String str10;
        String str11;
        String str12;
        float f2;
        CharSequence charSequence14;
        CharSequence charSequence15;
        CharSequence charSequence16;
        CharSequence charSequence17;
        Parent parent;
        Channel channel;
        String str13;
        String str14;
        String str15;
        Parent parent2;
        List list;
        String str16;
        String str17;
        String str18;
        CharSequence charSequence18;
        String str19;
        String str20;
        int i3;
        CharSequence charSequence19;
        long j3;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        synchronized (this) {
            j = this.f10828U;
            this.f10828U = 0;
        }
        GroupIndexRsp groupIndexRsp = this.f10805q;
        int i4 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (groupIndexRsp != null) {
                float percent = groupIndexRsp.getPercent();
                parent2 = groupIndexRsp.getParent();
                String fansProfit = groupIndexRsp.getFansProfit();
                String targetText = groupIndexRsp.getTargetText();
                String lockProfit = groupIndexRsp.getLockProfit();
                channel = groupIndexRsp.getChannel();
                String profitRate = groupIndexRsp.getProfitRate();
                String members = groupIndexRsp.getMembers();
                parent = groupIndexRsp.getStar();
                String activeNum = groupIndexRsp.getActiveNum();
                String travelProfit = groupIndexRsp.getTravelProfit();
                String nowProfit = groupIndexRsp.getNowProfit();
                String invalidNum = groupIndexRsp.getInvalidNum();
                List avatars = groupIndexRsp.getAvatars();
                str12 = groupIndexRsp.getChildrenProfit();
                str11 = groupIndexRsp.getTargetProfit();
                str10 = groupIndexRsp.getH5Url();
                str13 = profitRate;
                str14 = activeNum;
                str16 = invalidNum;
                list = avatars;
                f2 = percent;
                charSequence17 = fansProfit;
                str17 = targetText;
                str15 = lockProfit;
                charSequence14 = nowProfit;
                charSequence15 = travelProfit;
                charSequence16 = members;
            } else {
                str17 = null;
                str16 = null;
                list = null;
                parent2 = null;
                str15 = null;
                str14 = null;
                str13 = null;
                channel = null;
                parent = null;
                charSequence17 = null;
                charSequence16 = null;
                charSequence15 = null;
                charSequence14 = null;
                f2 = 0.0f;
                str12 = null;
                str11 = null;
                str10 = null;
            }
            boolean z8 = groupIndexRsp != null;
            if (i4 != 0) {
                j = z8 ? j | 32 : j | 16;
            }
            if (parent2 != null) {
                String historyProfit = parent2.getHistoryProfit();
                String avatar = parent2.getAvatar();
                charSequence18 = historyProfit;
                str19 = parent2.getInviteNum();
                str18 = avatar;
            } else {
                str19 = null;
                charSequence18 = null;
                str18 = null;
            }
            boolean z9 = parent2 == null;
            StringBuilder sb = new StringBuilder();
            sb.append(str17);
            sb.append("x");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str15);
            sb3.append("元");
            String sb4 = sb3.toString();
            boolean z10 = channel == null;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str13);
            sb5.append("倍加速");
            CharSequence sb6 = sb5.toString();
            boolean z11 = parent == null;
            StringBuilder sb7 = new StringBuilder();
            z3 = z8;
            sb7.append("(");
            sb7.append(str14);
            String sb8 = sb7.toString();
            boolean isEmpty = TextUtils.isEmpty(str14);
            StringBuilder sb9 = new StringBuilder();
            z2 = z10;
            sb9.append("当前未实名好友");
            sb9.append(str16);
            String sb10 = sb9.toString();
            boolean isEmpty2 = TextUtils.isEmpty(str16);
            if ((j & 3) != 0) {
                j |= z9 ? 8 : 4;
            }
            if ((j & 3) != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            if (channel != null) {
                i3 = channel.getStatus();
                str20 = channel.getProfit();
            } else {
                i3 = 0;
                str20 = null;
            }
            if (parent != null) {
                String historyProfit2 = parent.getHistoryProfit();
                String inviteNum = parent.getInviteNum();
                str21 = parent.getAvatar();
                charSequence19 = historyProfit2;
                long j4 = j;
                str22 = inviteNum;
                j3 = j4;
            } else {
                j3 = j;
                str22 = null;
                str21 = null;
                charSequence19 = null;
            }
            if (list != null) {
                str24 = (String) getFromList(list, 1);
                str23 = (String) getFromList(list, 0);
                str25 = (String) getFromList(list, 2);
            } else {
                str25 = null;
                str24 = null;
                str23 = null;
            }
            StringBuilder sb11 = new StringBuilder();
            String str26 = str25;
            sb11.append("他邀请了");
            sb11.append(str19);
            String sb12 = sb11.toString();
            int i5 = z9 ? 15 : 0;
            StringBuilder sb13 = new StringBuilder();
            sb13.append(sb2);
            sb13.append(str13);
            String sb14 = sb13.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(sb8);
            sb15.append("人活跃)");
            str7 = sb15.toString();
            StringBuilder sb16 = new StringBuilder();
            sb16.append(sb10);
            sb16.append("人, 已替您产生收入");
            String sb17 = sb16.toString();
            int i6 = isEmpty2 ? 17 : 0;
            boolean z12 = i3 == 1;
            StringBuilder sb18 = new StringBuilder();
            z = isEmpty2;
            sb18.append("他邀请了");
            sb18.append(str22);
            String sb19 = sb18.toString();
            StringBuilder sb20 = new StringBuilder();
            sb20.append(sb12);
            sb20.append("人，累计收益");
            String sb21 = sb20.toString();
            StringBuilder sb22 = new StringBuilder();
            sb22.append(sb14);
            sb22.append("倍加速");
            String sb23 = sb22.toString();
            String string = this.f10799k.getResources().getString(R.string.grey99_and_red, new Object[]{sb17, sb4});
            StringBuilder sb24 = new StringBuilder();
            sb24.append(sb19);
            sb24.append("人，累计收益");
            String sb25 = sb24.toString();
            i = i5;
            z6 = isEmpty;
            str = str21;
            charSequence11 = charSequence15;
            charSequence8 = charSequence14;
            charSequence12 = str12;
            charSequence2 = sb6;
            charSequence = charSequence19;
            str4 = str23;
            str2 = str26;
            j2 = 32;
            charSequence6 = sb25;
            charSequence4 = sb21;
            str6 = string;
            charSequence13 = charSequence17;
            j = j3;
            z5 = z11;
            charSequence9 = charSequence16;
            str5 = str24;
            CharSequence charSequence20 = str20;
            charSequence7 = sb23;
            i2 = i6;
            z7 = z12;
            str8 = str10;
            z4 = z9;
            charSequence10 = str11;
            str3 = str18;
            f = f2;
            charSequence5 = charSequence18;
            charSequence3 = charSequence20;
        } else {
            j2 = 32;
            i2 = 0;
            charSequence13 = null;
            charSequence12 = null;
            charSequence11 = null;
            z7 = false;
            charSequence10 = null;
            i = 0;
            str8 = null;
            charSequence9 = null;
            charSequence8 = null;
            str7 = null;
            z6 = false;
            charSequence7 = null;
            str6 = null;
            z5 = false;
            str5 = null;
            charSequence6 = null;
            str4 = null;
            charSequence5 = null;
            charSequence4 = null;
            str3 = null;
            z4 = false;
            charSequence3 = null;
            f = 0.0f;
            charSequence2 = null;
            z3 = false;
            z2 = false;
            z = false;
            charSequence = null;
            str2 = null;
            str = null;
        }
        if ((j & j2) != 0) {
            str9 = GroupIndexRspKt.progressText(groupIndexRsp);
        } else {
            str9 = null;
        }
        int i7 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i7 == 0) {
            str9 = null;
        } else if (!z3) {
            str9 = "";
        }
        long j5 = j;
        if (i7 != 0) {
            ViewAdapter.m12789a((View) this.f10789a, (float) i2);
            String str27 = null;
            RndAdapter.m12785a(this.f10790b, z7, str27, str27);
            ViewAdapter.m12794a((View) this.f10831v, str8);
            TextViewBindingAdapter.setText(this.f10832w, charSequence8);
            TextViewBindingAdapter.setText(this.f10833x, charSequence10);
            TextViewBindingAdapter.setText(this.f10834y, str9);
            ViewAdapter.m12789a((View) this.f10835z, (float) i);
            TextViewBindingAdapter.setText(this.f10808A, str7);
            ViewAdapter.m12798c((View) this.f10808A, Boolean.valueOf(z6));
            TextViewBindingAdapter.setText(this.f10809B, charSequence11);
            TextViewBindingAdapter.setText(this.f10810C, charSequence12);
            TextViewBindingAdapter.setText(this.f10811D, charSequence9);
            TextViewBindingAdapter.setText(this.f10812E, charSequence13);
            TextViewBindingAdapter.setText(this.f10813F, charSequence2);
            ViewAdapter.m12798c((View) this.f10814G, Boolean.valueOf(z2));
            TextViewBindingAdapter.setText(this.f10815H, charSequence3);
            ViewAdapter.m12798c((View) this.f10816I, Boolean.valueOf(z4));
            CornerType cornerType = null;
            Integer num = null;
            ImageAdapter.m12783a((ImageView) this.f10817J, str3, 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f10818K, charSequence4);
            TextViewBindingAdapter.setText(this.f10819L, charSequence5);
            ViewAdapter.m12798c((View) this.f10820M, Boolean.valueOf(z5));
            ImageAdapter.m12783a((ImageView) this.f10821N, str4, 0, cornerType, num);
            ImageAdapter.m12783a((ImageView) this.f10822O, str, 0, cornerType, num);
            TextViewBindingAdapter.setText(this.f10823P, charSequence6);
            TextViewBindingAdapter.setText(this.f10824Q, charSequence);
            ImageAdapter.m12783a((ImageView) this.f10825R, str5, 0, cornerType, num);
            ImageAdapter.m12783a((ImageView) this.f10826S, str2, 0, cornerType, num);
            CustomAdapter.m12777a(this.f10792d, Float.valueOf(f));
            TextViewAdapter.m12787a(this.f10799k, str6);
            ViewAdapter.m12798c((View) this.f10799k, Boolean.valueOf(z));
            ViewAdapter.m12798c((View) this.f10800l, Boolean.valueOf(z));
            TextViewBindingAdapter.setText(this.f10801m, charSequence7);
        }
        if ((j5 & 2) != 0) {
            ViewAdapter.m12794a((View) this.f10830u, "/me/inviteLogs");
            ViewAdapter.m12794a((View) this.f10835z, "/group/travelIncomeLogs");
            ViewAdapter.m12794a((View) this.f10827T, "/group/travelIncomeLogs");
        }
    }
}
