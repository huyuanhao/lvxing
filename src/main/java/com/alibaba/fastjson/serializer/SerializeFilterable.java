package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.alibaba.fastjson.serializer.az */
public abstract class SerializeFilterable {
    /* renamed from: g */
    protected List<BeforeFilter> f2895g = null;
    /* renamed from: h */
    protected List<AfterFilter> f2896h = null;
    /* renamed from: i */
    protected List<PropertyFilter> f2897i = null;
    /* renamed from: j */
    protected List<ValueFilter> f2898j = null;
    /* renamed from: k */
    protected List<NameFilter> f2899k = null;
    /* renamed from: l */
    protected List<PropertyPreFilter> f2900l = null;
    /* renamed from: m */
    protected List<LabelFilter> f2901m = null;
    /* renamed from: n */
    protected List<ContextValueFilter> f2902n = null;
    /* renamed from: o */
    protected boolean f2903o = true;

    /* renamed from: h */
    public List<BeforeFilter> mo11361h() {
        if (this.f2895g == null) {
            this.f2895g = new ArrayList();
            this.f2903o = false;
        }
        return this.f2895g;
    }

    /* renamed from: i */
    public List<AfterFilter> mo11362i() {
        if (this.f2896h == null) {
            this.f2896h = new ArrayList();
            this.f2903o = false;
        }
        return this.f2896h;
    }

    /* renamed from: j */
    public List<NameFilter> mo11363j() {
        if (this.f2899k == null) {
            this.f2899k = new ArrayList();
            this.f2903o = false;
        }
        return this.f2899k;
    }

    /* renamed from: k */
    public List<PropertyPreFilter> mo11364k() {
        if (this.f2900l == null) {
            this.f2900l = new ArrayList();
            this.f2903o = false;
        }
        return this.f2900l;
    }

    /* renamed from: l */
    public List<LabelFilter> mo11365l() {
        if (this.f2901m == null) {
            this.f2901m = new ArrayList();
            this.f2903o = false;
        }
        return this.f2901m;
    }

    /* renamed from: m */
    public List<PropertyFilter> mo11366m() {
        if (this.f2897i == null) {
            this.f2897i = new ArrayList();
            this.f2903o = false;
        }
        return this.f2897i;
    }

    /* renamed from: n */
    public List<ContextValueFilter> mo11367n() {
        if (this.f2902n == null) {
            this.f2902n = new ArrayList();
            this.f2903o = false;
        }
        return this.f2902n;
    }

    /* renamed from: o */
    public List<ValueFilter> mo11368o() {
        if (this.f2898j == null) {
            this.f2898j = new ArrayList();
            this.f2903o = false;
        }
        return this.f2898j;
    }

    /* renamed from: a */
    public void mo11357a(SerializeFilter ayVar) {
        if (ayVar != null) {
            if (ayVar instanceof PropertyPreFilter) {
                mo11364k().add((PropertyPreFilter) ayVar);
            }
            if (ayVar instanceof NameFilter) {
                mo11363j().add((NameFilter) ayVar);
            }
            if (ayVar instanceof ValueFilter) {
                mo11368o().add((ValueFilter) ayVar);
            }
            if (ayVar instanceof ContextValueFilter) {
                mo11367n().add((ContextValueFilter) ayVar);
            }
            if (ayVar instanceof PropertyFilter) {
                mo11366m().add((PropertyFilter) ayVar);
            }
            if (ayVar instanceof BeforeFilter) {
                mo11361h().add((BeforeFilter) ayVar);
            }
            if (ayVar instanceof AfterFilter) {
                mo11362i().add((AfterFilter) ayVar);
            }
            if (ayVar instanceof LabelFilter) {
                mo11365l().add((LabelFilter) ayVar);
            }
        }
    }

    /* renamed from: a */
    public boolean mo11358a(JSONSerializer agVar, Object obj, String str) {
        if (agVar.f2900l != null) {
            for (PropertyPreFilter a : agVar.f2900l) {
                if (!a.mo11350a(agVar, obj, str)) {
                    return false;
                }
            }
        }
        List<PropertyPreFilter> list = this.f2900l;
        if (list != null) {
            for (PropertyPreFilter a2 : list) {
                if (!a2.mo11350a(agVar, obj, str)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo11359a(JSONSerializer agVar, Object obj, String str, Object obj2) {
        if (agVar.f2897i != null) {
            for (PropertyFilter a : agVar.f2897i) {
                if (!a.mo11349a(obj, str, obj2)) {
                    return false;
                }
            }
        }
        List<PropertyFilter> list = this.f2897i;
        if (list != null) {
            for (PropertyFilter a2 : list) {
                if (!a2.mo11349a(obj, str, obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo11360b(JSONSerializer agVar, Object obj, String str, Object obj2) {
        if (agVar.f2899k != null) {
            for (NameFilter a : agVar.f2899k) {
                str = a.mo11348a(obj, str, obj2);
            }
        }
        List<NameFilter> list = this.f2899k;
        if (list != null) {
            for (NameFilter a2 : list) {
                str = a2.mo11348a(obj, str, obj2);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo11356a(JSONSerializer agVar, BeanContext jVar, Object obj, String str, Object obj2) {
        if (obj2 != null) {
            if (agVar.f2846b.f2916i || !(jVar == null || (jVar.mo11422a() & SerializerFeature.WriteNonStringValueAsString.mask) == 0)) {
                boolean z = obj2 instanceof Number;
                if (z || (obj2 instanceof Boolean)) {
                    String str2 = null;
                    if (z && jVar != null) {
                        str2 = jVar.mo11424c();
                    }
                    if (str2 != null) {
                        obj2 = new DecimalFormat(str2).format(obj2);
                    } else {
                        obj2 = obj2.toString();
                    }
                }
            }
            if (jVar != null && jVar.mo11423b()) {
                obj2 = JSON.parse((String) obj2);
            }
        }
        if (agVar.f2898j != null) {
            for (ValueFilter a : agVar.f2898j) {
                obj2 = a.mo11413a(obj, str, obj2);
            }
        }
        List<ValueFilter> list = this.f2898j;
        if (list != null) {
            for (ValueFilter a2 : list) {
                obj2 = a2.mo11413a(obj, str, obj2);
            }
        }
        if (agVar.f2902n != null) {
            for (ContextValueFilter a3 : agVar.f2902n) {
                obj2 = a3.mo11428a(jVar, obj, str, obj2);
            }
        }
        List<ContextValueFilter> list2 = this.f2902n;
        if (list2 != null) {
            for (ContextValueFilter a4 : list2) {
                obj2 = a4.mo11428a(jVar, obj, str, obj2);
            }
        }
        return obj2;
    }
}
