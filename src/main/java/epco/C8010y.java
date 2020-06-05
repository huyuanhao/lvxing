package epco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: epco.y */
public class C8010y {
    /* renamed from: a */
    private String f27240a;
    /* renamed from: b */
    private short f27241b;
    /* renamed from: c */
    private C7998s f27242c;
    /* renamed from: d */
    private C7998s f27243d;
    /* renamed from: e */
    private Map<Short, C7965e0> f27244e = new HashMap();
    /* renamed from: f */
    private Map<Short, List<C7957c0>> f27245f = new HashMap();

    public C8010y(C8002u uVar) {
        this.f27240a = uVar.mo38450i();
        this.f27241b = (short) ((int) uVar.mo38444e());
    }

    /* renamed from: a */
    public C7965e0 mo38508a(Short sh) {
        return (C7965e0) this.f27244e.get(sh);
    }

    /* renamed from: a */
    public short mo38509a() {
        return this.f27241b;
    }

    /* renamed from: a */
    public void mo38510a(C7957c0 c0Var) {
        List list = (List) this.f27245f.get(Short.valueOf(c0Var.mo38283b()));
        if (list == null) {
            list = new ArrayList();
            this.f27245f.put(Short.valueOf(c0Var.mo38283b()), list);
        }
        list.add(c0Var);
    }

    /* renamed from: a */
    public void mo38511a(C7965e0 e0Var) {
        this.f27244e.put(Short.valueOf(e0Var.mo38322b()), e0Var);
    }

    /* renamed from: a */
    public void mo38512a(C7998s sVar) {
        this.f27243d = sVar;
    }

    /* renamed from: a */
    public void mo38513a(String str) {
        this.f27240a = str;
    }

    /* renamed from: a */
    public void mo38514a(Map<Short, C7965e0> map) {
        this.f27244e = map;
    }

    /* renamed from: a */
    public void mo38515a(short s) {
        this.f27241b = s;
    }

    /* renamed from: b */
    public C7998s mo38516b() {
        return this.f27243d;
    }

    /* renamed from: b */
    public List<C7957c0> mo38517b(Short sh) {
        return (List) this.f27245f.get(sh);
    }

    /* renamed from: b */
    public void mo38518b(C7998s sVar) {
        this.f27242c = sVar;
    }

    /* renamed from: b */
    public void mo38519b(Map<Short, List<C7957c0>> map) {
        this.f27245f = map;
    }

    /* renamed from: c */
    public String mo38520c() {
        return this.f27240a;
    }

    /* renamed from: d */
    public Map<Short, C7965e0> mo38521d() {
        return this.f27244e;
    }

    /* renamed from: e */
    public C7998s mo38522e() {
        return this.f27242c;
    }

    /* renamed from: f */
    public Map<Short, List<C7957c0>> mo38523f() {
        return this.f27245f;
    }
}
