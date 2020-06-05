package com.bytedance.sdk.openadsdk.core.p174h;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.bytedance.sdk.openadsdk.core.h.a */
public class AdSlotSetter {
    /* renamed from: a */
    public String f7585a;
    /* renamed from: b */
    public int f7586b = 1;
    /* renamed from: c */
    public int f7587c = 1;
    /* renamed from: d */
    public int f7588d = 2;
    /* renamed from: e */
    public int f7589e = 1;
    /* renamed from: f */
    public int f7590f = 1;
    /* renamed from: g */
    public int f7591g = 100;
    /* renamed from: h */
    public int f7592h = 0;
    /* renamed from: i */
    public int f7593i = 2;
    /* renamed from: j */
    public int f7594j = 1;
    /* renamed from: k */
    public int f7595k = 3;
    /* renamed from: l */
    public int f7596l = -1;
    /* renamed from: m */
    public int f7597m = -1;
    /* renamed from: n */
    public int f7598n = -1;
    /* renamed from: o */
    public int f7599o = 2;
    /* renamed from: p */
    public int f7600p = 1;
    /* renamed from: q */
    public int f7601q = 0;
    /* renamed from: r */
    public int f7602r = 1500;
    /* renamed from: s */
    public int f7603s = 2;
    /* renamed from: t */
    public int f7604t = -1;
    /* renamed from: u */
    public int f7605u = 20;
    /* renamed from: v */
    public int f7606v = -1;
    /* renamed from: w */
    public int f7607w = 0;
    /* renamed from: x */
    public int f7608x = 0;
    /* renamed from: y */
    public List<String> f7609y;

    /* renamed from: a */
    public static AdSlotSetter m9658a() {
        return new AdSlotSetter();
    }

    private AdSlotSetter() {
    }

    /* renamed from: a */
    public AdSlotSetter mo15690a(int i) {
        this.f7606v = i;
        return this;
    }

    /* renamed from: b */
    public AdSlotSetter mo15693b(int i) {
        this.f7607w = i;
        return this;
    }

    /* renamed from: c */
    public AdSlotSetter mo15694c(int i) {
        this.f7608x = i;
        return this;
    }

    /* renamed from: d */
    public AdSlotSetter mo15695d(int i) {
        this.f7605u = i;
        return this;
    }

    /* renamed from: e */
    public AdSlotSetter mo15696e(int i) {
        this.f7604t = i;
        return this;
    }

    /* renamed from: f */
    public AdSlotSetter mo15697f(int i) {
        this.f7601q = i;
        return this;
    }

    /* renamed from: g */
    public AdSlotSetter mo15698g(int i) {
        this.f7602r = i;
        return this;
    }

    /* renamed from: h */
    public AdSlotSetter mo15699h(int i) {
        this.f7603s = i;
        return this;
    }

    /* renamed from: i */
    public AdSlotSetter mo15700i(int i) {
        this.f7599o = i;
        return this;
    }

    /* renamed from: j */
    public AdSlotSetter mo15701j(int i) {
        this.f7597m = i;
        return this;
    }

    /* renamed from: k */
    public AdSlotSetter mo15702k(int i) {
        this.f7598n = i;
        return this;
    }

    /* renamed from: l */
    public AdSlotSetter mo15703l(int i) {
        this.f7596l = i;
        return this;
    }

    /* renamed from: m */
    public AdSlotSetter mo15704m(int i) {
        this.f7595k = i;
        return this;
    }

    /* renamed from: a */
    public AdSlotSetter mo15691a(String str) {
        this.f7585a = str;
        return this;
    }

    /* renamed from: n */
    public AdSlotSetter mo15705n(int i) {
        this.f7586b = i;
        return this;
    }

    /* renamed from: o */
    public AdSlotSetter mo15706o(int i) {
        this.f7587c = i;
        return this;
    }

    /* renamed from: p */
    public AdSlotSetter mo15707p(int i) {
        this.f7588d = i;
        return this;
    }

    /* renamed from: q */
    public AdSlotSetter mo15708q(int i) {
        this.f7589e = i;
        return this;
    }

    /* renamed from: r */
    public AdSlotSetter mo15709r(int i) {
        this.f7590f = i;
        return this;
    }

    /* renamed from: s */
    public AdSlotSetter mo15710s(int i) {
        this.f7591g = i;
        return this;
    }

    /* renamed from: t */
    public AdSlotSetter mo15711t(int i) {
        this.f7592h = i;
        return this;
    }

    /* renamed from: u */
    public AdSlotSetter mo15712u(int i) {
        this.f7593i = i;
        return this;
    }

    /* renamed from: v */
    public AdSlotSetter mo15713v(int i) {
        this.f7594j = i;
        return this;
    }

    /* renamed from: w */
    public AdSlotSetter mo15714w(int i) {
        this.f7600p = i;
        return this;
    }

    /* renamed from: a */
    public AdSlotSetter mo15692a(JSONArray jSONArray) {
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            this.f7609y = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    this.f7609y.add(jSONArray.get(i).toString());
                    i++;
                } catch (Exception unused) {
                }
            }
        }
        return this;
    }
}
