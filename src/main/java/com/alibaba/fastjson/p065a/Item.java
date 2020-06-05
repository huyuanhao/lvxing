package com.alibaba.fastjson.p065a;

/* renamed from: com.alibaba.fastjson.a.e */
final class Item {
    /* renamed from: a */
    int f2553a;
    /* renamed from: b */
    int f2554b;
    /* renamed from: c */
    int f2555c;
    /* renamed from: d */
    long f2556d;
    /* renamed from: e */
    String f2557e;
    /* renamed from: f */
    String f2558f;
    /* renamed from: g */
    String f2559g;
    /* renamed from: h */
    int f2560h;
    /* renamed from: i */
    Item f2561i;

    Item() {
    }

    Item(int i, Item eVar) {
        this.f2553a = i;
        this.f2554b = eVar.f2554b;
        this.f2555c = eVar.f2555c;
        this.f2556d = eVar.f2556d;
        this.f2557e = eVar.f2557e;
        this.f2558f = eVar.f2558f;
        this.f2559g = eVar.f2559g;
        this.f2560h = eVar.f2560h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11024a(int i, String str, String str2, String str3) {
        this.f2554b = i;
        this.f2557e = str;
        this.f2558f = str2;
        this.f2559g = str3;
        if (!(i == 1 || i == 7 || i == 8)) {
            if (i == 12) {
                this.f2560h = (i + (str.hashCode() * str2.hashCode())) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                return;
            } else if (i != 13) {
                this.f2560h = (i + (str.hashCode() * str2.hashCode() * str3.hashCode())) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                return;
            }
        }
        this.f2560h = (i + str.hashCode()) & ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11023a(int i) {
        this.f2554b = 3;
        this.f2555c = i;
        this.f2560h = Integer.MAX_VALUE & (this.f2554b + i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo11025a(Item eVar) {
        boolean z;
        boolean z2;
        int i = this.f2554b;
        boolean z3 = true;
        if (i != 1) {
            if (i != 15) {
                if (i == 12) {
                    if (!eVar.f2557e.equals(this.f2557e) || !eVar.f2558f.equals(this.f2558f)) {
                        z2 = false;
                    }
                    return z2;
                } else if (i != 13) {
                    switch (i) {
                        case 3:
                        case 4:
                            if (eVar.f2555c != this.f2555c) {
                                z3 = false;
                            }
                            return z3;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            if (!eVar.f2557e.equals(this.f2557e) || !eVar.f2558f.equals(this.f2558f) || !eVar.f2559g.equals(this.f2559g)) {
                                z3 = false;
                            }
                            return z3;
                    }
                }
            }
            if (eVar.f2556d != this.f2556d) {
                z = false;
            }
            return z;
        }
        return eVar.f2557e.equals(this.f2557e);
    }
}
